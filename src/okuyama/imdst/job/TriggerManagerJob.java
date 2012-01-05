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
 * Trigger関係を管理するJob<br>
 * 主に設定ファイルに設定されているQueueへ接続を行い、そこから更新データを取得して<br>
 * Triggerを実行する.<br>
 * TriggerはOkuyamaClientから設定可能となっている.<br>
 * あらかじめTriggerの領域には名前を決めることでその名前領域に対してTriggerを設定するような挙動になる.<br>
 *
 * @author T.Okuyama
 * @license GPL(Lv3)
 */
public class TriggerManagerJob extends AbstractJob implements IJob {

    private String keyMapNodesStr = null;
    private String subKeyMapNodesStr = null;
    private String ruleStrProp = null;

    private String loadBalanceStr = null;

    // トランザクションノードの設定
    private String transactionModeStr = null;
    private String transactionManagerStr = null;

    // マスターノードの設定
    // 自身がMasterNodeかの判定情報(旧設定)
    private String mainMasterNodeModeStr = null;
    // Slaveマスターノードの接続情報(旧設定)
    private String slaveMasterNodeInfoStr = null;

    // 自身の情報
    private String myNodeInfoStr = null;
    // メインマスターノード接続情報
    private String mainMasterNodeInfoStr = null;
    // 全てのマスターノードの接続情報
    private String allMasterNodeInfoStr = null;

    // 分散方式 デフォルトはmode
    // 他にはconsistenthash
    private String dispatchMode = "mod";


    /**
     * Logger.<br>
     */
    private static ILogger logger = LoggerFactory.createLogger(TriggerManagerJob.class);

    // 初期化メソッド定義
    public void initJob(String initValue) {
        logger.debug("TriggerManagerJob - initJob - start");
        logger.debug("TriggerManagerJob - initJob - end");
    }

    // Jobメイン処理定義
    public String executeJob(String optionParam) throws BatchException {
        logger.debug("TriggerManagerJob - executeJob - start");
        String ret = SUCCESS;
        
        try{
            int counter = 0;
            int maxCount = 100;

            while (true) {
                int helperCode = super.executeHelper("MasterConfigurationManagerHelper", null);

                Object[] helperRet = null;
                while(helperRet == null) {
                     helperRet = super.waitGetHelperReturnParam(helperCode, 10);
                }
                logger.error("MasterConfigurationManager End");
                if (maxCount == counter) break;
                counter++;
                Thread.sleep(5000);
            }

        } catch(Exception e) {
            logger.error("TriggerManagerJob - executeJob - Error", e);
            throw new BatchException(e);
        }

        logger.debug("TriggerManagerJob - executeJob - end");
        return ret;
    }
}