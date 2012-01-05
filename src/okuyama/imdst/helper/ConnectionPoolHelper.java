package okuyama.imdst.helper;

import java.io.*;
import java.util.*;
import java.net.*;

import okuyama.base.lang.BatchException;
import okuyama.base.job.AbstractHelper;
import okuyama.base.job.IJob;
import okuyama.base.util.ILogger;
import okuyama.base.util.LoggerFactory;
import okuyama.imdst.util.KeyMapManager;
import okuyama.imdst.util.ImdstDefine;
import okuyama.imdst.util.DataDispatcher;
import okuyama.imdst.util.StatusUtil;
import okuyama.imdst.util.io.KeyNodeConnector;


/**
 * Node間の接続プールを管理するクラス<br>
 *
 * @author T.Okuyama
 * @license GPL(Lv3)
 */
public class ConnectionPoolHelper extends AbstractMasterManagerHelper {

    // ノードの監視サイクル時間(ミリ秒)
    private int connectCycle = 1000;

    private ArrayList nodeList = null;

    /**
     * Logger.<br>
     */
    private static ILogger logger = LoggerFactory.createLogger(ConnectionPoolHelper.class);

    // 初期化メソッド定義
    public void initHelper(String initValue) {
    }

    // Jobメイン処理定義
    public String executeHelper(String optionParam) throws BatchException {
        logger.debug("ConnectionPoolHelper - executeHelper - start");
        String ret = SUCCESS;
        String serverStopMarkerFileName = null;
        File serverStopMarkerFile = null;

        boolean serverRunning = true;

        int counter = 0;
        int maxConnCnt = new Integer(super.getPropertiesValue("KeyNodeConnectionPoolMax")).intValue();
        int maxNodeConnCnt = new Integer(super.getPropertiesValue("OneKeyNodeConnectionPoolMax")).intValue();

        try{
            while (serverRunning) {

                this.nodeList = new ArrayList();

                HashMap allNodeInfo = DataDispatcher.getAllDataNodeInfo();
                ArrayList mainNodeList = (ArrayList)allNodeInfo.get("main");
                ArrayList subNodeList = (ArrayList)allNodeInfo.get("sub");
                ArrayList transactionManagerList = DataDispatcher.getTransactionManagerInfo();

                if (mainNodeList != null) {
                    for (int i = 0; i < mainNodeList.size(); i++) {
                        this.nodeList.add(mainNodeList.get(i));
                    }
                }

                if (subNodeList != null) {
                    for (int i = 0; i < subNodeList.size(); i++) {
                        this.nodeList.add(subNodeList.get(i));
                    }
                }

                if (transactionManagerList != null) {
                    for (int i = 0; i < transactionManagerList.size(); i++) {
                        this.nodeList.add(transactionManagerList.get(i));
                    }
                }

                // 停止ファイル関係チェック
                if (StatusUtil.getStatus() == 1) {
                    serverRunning = false;
                    logger.info("ConnectionPoolHelper - Status Error");
                }

                if (StatusUtil.getStatus() == 2) {
                    serverRunning = false;
                    logger.info("ConnectionPoolHelper - End Status");
                }

                serverStopMarkerFileName = super.getPropertiesValue("ServerStopFile");

                serverStopMarkerFile = new File(new File(serverStopMarkerFileName).getAbsolutePath());
                if (serverStopMarkerFile.exists()) {
                    serverRunning = false;
                    logger.info("ConnectionPoolHelper - Server End File Exists");
                    StatusUtil.setStatus(2);
                }

                // ノード数分処理実行
                counter = super.getNowConnectionPoolCount();

                for (int i = 0; i < maxNodeConnCnt; i++) {
                    if (counter >= maxConnCnt) break;

                    for (int j = 0; j < this.nodeList.size(); j++) {

                        String nodeInfo = (String)nodeList.get(j);
                        KeyNodeConnector keyNodeConnector = this.createNodeConnection(nodeInfo);
                        if (keyNodeConnector != null) {
                            super.setActiveConnection(nodeInfo, keyNodeConnector);
                        }
                        counter++;
                        if (counter >= maxConnCnt) break;
                    }
                    if (counter >= maxConnCnt) break;
                }

                Thread.sleep(connectCycle);
            }
        } catch(Exception e) {
            logger.error("ConnectionPoolHelper - executeHelper - Error", e);
            throw new BatchException(e);
        }

        logger.debug("ConnectionPoolHelper - executeHelper - end");
        return ret;
    }


    /**
     * Helper後処理.<br>
     *
     */
    public void endHelper() {
    }


    /**
     * ノードに対しての接続を作成する
     *
     */
    private KeyNodeConnector createNodeConnection(String nodeInfo) {
        KeyNodeConnector keyNodeConnector = null;
        String[] nodeInfos = nodeInfo.split(":");

        try {
            keyNodeConnector = new KeyNodeConnector(nodeInfos[0], Integer.parseInt(nodeInfos[1]), nodeInfo);
            keyNodeConnector.connect();
        } catch(Exception e) {
            logger.info("Connection Pool Error = [" + nodeInfo + "]");
            keyNodeConnector = null;
        }
        return keyNodeConnector;
    }


}