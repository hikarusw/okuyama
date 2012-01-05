package okuyama.imdst.job;

import java.io.*;
import java.net.*;

import okuyama.base.lang.BatchException;
import okuyama.base.job.AbstractJob;
import okuyama.base.job.AbstractHelper;
import okuyama.base.job.IJob;
import okuyama.base.util.ILogger;
import okuyama.base.util.LoggerFactory;
import okuyama.imdst.util.KeyMapManager;
import okuyama.imdst.util.StatusUtil;
import okuyama.imdst.util.ImdstDefine;
import okuyama.imdst.util.DataDispatcher;
import okuyama.imdst.util.StatusUtil;

/**
 * okuyamaのMasterNodeにに対して、Http通信を変換し橋渡しを行う.<br>
 * 基本的にHelperを都度生成しクライアントと通信させるのみ<br>
 *
 * @author T.Okuyama
 * @license GPL(Lv3)
 */
public class HttpGatewayServerJob extends AbstractJob implements IJob {

    private int portNo = 80;

    // サーバーソケット
    ServerSocket serverSocket = null;

    /**
     * Logger.<br>
     */
    private static ILogger logger = LoggerFactory.createLogger(HttpGatewayServerJob.class);

    // 初期化メソッド定義
    public void initJob(String initValue) {
        logger.debug("HttpGatewayServerJob - initJob - start");

        this.portNo = Integer.parseInt(initValue);

        logger.debug("HttpGatewayServerJob - initJob - end");
    }

    // Jobメイン処理定義
    public String executeJob(String optionParam) throws BatchException {
        logger.debug("HttpGatewayServerJob - executeJob - start");
        String ret = SUCCESS;
        Object[] helperParams = null;
        String[] okuyamaMasterInfos = null;

        try{
            okuyamaMasterInfos = optionParam.split(",");


            // サーバソケットの生成
            this.serverSocket = new ServerSocket(this.portNo);
            // 共有領域にServerソケットのポインタを格納
            super.setJobShareParam(super.getJobName() + "_ServeSocket", this.serverSocket);

            Socket socket = null;
            int paramSize = 6;

            // KeyMapNode情報を初期化完了を確認
            if(DataDispatcher.isStandby()) {

                while (true) {
                    if (StatusUtil.getStatus() == 1 || StatusUtil.getStatus() == 2) break;
                    try {

                        helperParams = new Object[paramSize];

                        // クライアントからの接続待ち
                        socket = serverSocket.accept();

                        helperParams[0] = socket;
                        helperParams[1] = okuyamaMasterInfos;

                        super.executeHelper("HttpGatewayServerHelper", helperParams);

                    } catch (Exception e) {
                        if (StatusUtil.getStatus() == 2) {
                            logger.info("HttpGatewayServerJob - executeJob - ServerEnd");
                            break;
                        }
                        logger.error(e);
                    }
                }
            }
        } catch(Exception e) {
            logger.error("HttpGatewayServerJob - executeJob - Error", e);
            throw new BatchException(e);
        }

        //logger.debug("HttpGatewayServerJob - executeJob - end");
        return ret;
    }
}