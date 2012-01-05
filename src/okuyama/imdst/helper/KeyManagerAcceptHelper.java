package okuyama.imdst.helper;

import java.io.*;
import java.util.*;
import java.net.*;
import java.util.concurrent.ArrayBlockingQueue;

import okuyama.base.lang.BatchException;
import okuyama.base.job.AbstractHelper;
import okuyama.base.job.IJob;
import okuyama.base.util.ILogger;
import okuyama.base.util.LoggerFactory;
import okuyama.imdst.util.KeyMapManager;
import okuyama.imdst.util.ImdstDefine;
import okuyama.imdst.util.DataDispatcher;
import okuyama.imdst.util.StatusUtil;
import okuyama.imdst.util.JavaSystemApi;

/**
 * KeyManagerの使用する接続ソケットを監視し、読み込み待ちのソケットを見つけ出し、<br>
 * 処理対象のキューに登録する.<br>
 *
 * @author T.Okuyama
 * @license GPL(Lv3)
 */
public class KeyManagerAcceptHelper extends AbstractHelper {

    // 無操作上限時間 -1は切断なし
    private long connetionTimeout = 60000 * 30;

    private String queuePrefix = null;

    private ArrayBlockingQueue connectCheckQueue = new ArrayBlockingQueue(5000);

    private CheckConnection[] checkConnections = null;

    /**
     * Logger.<br>
     */
    private static ILogger logger = LoggerFactory.createLogger(KeyManagerAcceptHelper.class);

    // 初期化メソッド定義
    public void initHelper(String initValue) {
        if (initValue != null && !initValue.trim().equals("")) {

            int workCloseTimeInt = Integer.parseInt(initValue);
            long workCloseTimeLong = workCloseTimeInt * 1000;
            this.connetionTimeout = workCloseTimeLong;
        }
        this.checkConnections = new CheckConnection[1];
        this.checkConnections[0] = new CheckConnection();
    }

    // Jobメイン処理定義
    public String executeHelper(String optionParam) throws BatchException {
        logger.debug("KeyManagerAcceptHelper - executeHelper - start");

        String ret = SUCCESS;
        String serverStopMarkerFileName = null;
        File serverStopMarkerFile = null;
        String pollQueueName = null;
        String[] addExecQueueNames = null;
        String addCheckQueueName = null;

        boolean serverRunning = true;

        try{
            Object[] parameters = super.getParameters();
            pollQueueName = (String)parameters[0];
            addExecQueueNames = (String[])parameters[1];
            addCheckQueueName = (String)parameters[0];

            this.checkConnections[0].setAddQueueName(addCheckQueueName);
            this.checkConnections[0].start();

            while (serverRunning) {

                Object[] param = super.pollSpecificationParameterQueue(pollQueueName);
                if (param == null || param.length < 1) continue;

                Object[] clientMap = (Object[])param[0];
                BufferedReader br = (BufferedReader)clientMap[ImdstDefine.paramBr];
                Socket socket = (Socket)clientMap[ImdstDefine.paramSocket];

                // 読み込みのデータがバッファに存在するかをチェック
                if(br.ready()) {

                    // 読み込みのデータがバッファに存在する
                    clientMap[ImdstDefine.paramLast] = new Long(JavaSystemApi.currentTimeMillis);
                    Object[] queueParam = new Object[1];
                    queueParam[0] = clientMap;

                    super.addSmallSizeParameterQueue(addExecQueueNames, queueParam);
                } else {

                    // 接続確認用のQueueに格納
                    connectCheckQueue.add(param);
                    if(!this.checkConnections[0].isAlive()) {
                        this.checkConnections[0] = new CheckConnection();
                        this.checkConnections[0].setAddQueueName(addCheckQueueName);
                        this.checkConnections[0].start();
                    }
                }
            }
        } catch(Exception e) {
            logger.error("KeyManagerAcceptHelper - executeHelper - Error", e);
            throw new BatchException(e);
        }

        logger.debug("KeyManagerAcceptHelper - executeHelper - end");
        return ret;
    }


    /**
     * Helper後処理.<br>
     *
     */
    public void endHelper() {
    }


    /**
     * インナークラス呼び出し用.<br>
     *
     */
    public boolean addCheckEndParamQueue(String addQueueName, Object[] clientMap) {
        Object[] queueParam = new Object[1];
        boolean ret = false;
        queueParam[0] = clientMap;

        try {

            super.addSpecificationParameterQueue(addQueueName, queueParam);
            ret = true;
        } catch (Throwable te) {
            te.printStackTrace();
            ret = false;
        }
        return ret;
    }


    /**
     * 接続確認を行うインナークラス.<br>
     *
     */
    private class CheckConnection extends Thread {

        private String addQueueName = null;

        public void setAddQueueName(String addQueueName) {
            this.addQueueName = addQueueName;
        }


        public void run() {
            while (true) {
                Object[] param = null;
                Object[] clientMap = null;
                Socket socket = null;
                BufferedReader br = null;

                // 読み込みのデータがバッファに存在しない
                try {
                    param = (Object[])connectCheckQueue.take();
                    clientMap = (Object[])param[0];
                    socket = (Socket)clientMap[ImdstDefine.paramSocket];

                    if (((Integer)clientMap[ImdstDefine.paramCheckCount]).intValue() > 10) {

                        clientMap[ImdstDefine.paramCheckCount] = new Integer(0);

                        br = (BufferedReader)clientMap[ImdstDefine.paramBr];
                        int test = 0;
                        br.mark(1);

                        // 無操作時間が上限に達していないかを確認
                        long last = ((Long)clientMap[ImdstDefine.paramLast]).longValue();

                        if (connetionTimeout == -1 || (JavaSystemApi.currentTimeMillis - last) < connetionTimeout) {

                            // 上限に達していない
                            // 既にコネクションが切断されていないかを確認
                            socket.setSoTimeout(1);
                            test = br.read();

                            br.reset(); 
                        } else {

                            // 上限に達している
                            test = -1;
                        }

                        // 無操作時間の上限もしくは、コネクション切断済み
                        if (test == -1) {

                            // クローズ
                            br.close();
                            socket.close();
                            br = null;
                            socket = null;
                        }
                    } else {

                        int checkCount = ((Integer)clientMap[ImdstDefine.paramCheckCount]).intValue();
                        checkCount++;
                        clientMap[ImdstDefine.paramCheckCount] = new Integer(checkCount);
                    }
                } catch (SocketTimeoutException se) {
                } catch (Throwable te) {
                    try {

                        // エラーの場合はクローズ
                        br.close();
                        socket.close();
                        br = null;
                        socket = null;
                    } catch (Throwable tee) {
                        br = null;
                        socket = null;
                    }
                } 

                // 無操作時間が上限に達せず切断もされていない場合は再度確認キューに登録
                if (socket != null) addCheckEndParamQueue(this.addQueueName, clientMap);
            }
        }
    }

}