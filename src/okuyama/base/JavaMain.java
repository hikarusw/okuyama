package okuyama.base;

import okuyama.base.lang.BatchDefine;
import okuyama.base.lang.BatchException;
import okuyama.base.util.ILogger;
import okuyama.base.util.LoggerFactory;
import okuyama.base.util.ClassUtility;
import okuyama.base.util.DefaultLogger;
import okuyama.base.parameter.config.BatchConfig;
import okuyama.base.parameter.config.ConfigFolder;
import okuyama.base.parameter.config.JobConfig;

import org.apache.commons.daemon.*;

/**
 * メインクラス.<br>
 *
 * @author T.Okuyama
 * @license GPL(Lv3)
 */
public class JavaMain implements Daemon {

    // Logger
    private static ILogger logger = null;


    DaemonContext dc = null;


    /**
     * 起動メソッド
     * @param args [0]=バッチ用設定ファイル名, [1]=Job用設定ファイル名
     */
    public static void main(String[] args) {
        //logger.info("JavaMain - start");
        try {

            // 引数個数チェック(最低2つ必要)
            validateArgs(args);

            JavaMain me = new JavaMain();

            // 起動オプションを取り込み
            importArgs(args);

            // 本体処理実行
            me.exec(args[0],args[1]);

        } catch (BatchException be) {
            //logger.error("JavaMain - error", be);
            System.err.println("JavaMain -error");
            System.exit(1);
        }

        //logger.info("JavaMain - end");
    }

    /**
     * メイン処理.<br>
     *
     * @param batchConfPath バッチ設定ファイルパス
     * @param jobConfPath Job設定ファイルパス
     * @throws BatchException
     */
    public void exec(String batchConfPath, String jobConfPath) throws BatchException {
        //logger.debug("JavaMain - exec - start");
        String controllerClassName = null;


        try {
            BatchConfig batchConfig = new BatchConfig(batchConfPath);
            JobConfig jobConfig = new JobConfig(jobConfPath);

            // Log4jの設定ファイルが指定されている場合は初期化
            String logPropertiesPath = batchConfig.getBatchParam("loggerproperties");
            if (logPropertiesPath != null && !logPropertiesPath.trim().equals("")) {
                DefaultLogger.propertiesFileName = logPropertiesPath;
            }

            // Logger作成
            logger = LoggerFactory.createLogger(JavaMain.class);

            // Folderに設定情報を格納
            ConfigFolder.setConfig(batchConfig, jobConfig);

            // Controller作成
            IJobController jobController = (IJobController)ClassUtility.createInstance(batchConfig.getBatchParam("controller"));
            // 実行
            jobController.execute();
        } catch (BatchException be) {
            logger.info("JavaMain - exec - error1");
            throw be;
        } catch (Exception e) {
            logger.info("JavaMain - exec - error2");
            throw new BatchException(e);
        }
        logger.debug("JavaMain - exec - end");
    }

    public static void shutdownMainProcess() {
        System.exit(0);
    }


    /**
     * 引数の個数確認。最低数(2)無いと終了する
     * @param args 起動引数
     */
    public static void validateArgs(String[] args) {

        if (args == null || args.length < 2) {
            if (args == null) {
                System.err.println("Error : JavaMain The argument is illega [Main.properties, Node.properties]");
                System.err.println("JavaMain Configure File Not Found");
                System.exit(1);
            } else {
                System.err.println("Error : JavaMain The argument is illega [Node.properties]");
                System.err.println("JavaMain Configure File Not Found");
                System.exit(1);
            }
        }
    }

    /**
     * 引数から起動オプションを受け取る
     * @param args 起動引数
     */
    public static void importArgs(String[] args) {

        if (args.length > 2) {
            for (int i = 2; i < args.length; i++) {
                BatchDefine.USER_OPTION_STR = BatchDefine.USER_OPTION_STR + " " + args[i];
            }
            BatchDefine.USER_OPTION_STR = BatchDefine.USER_OPTION_STR.trim();
        } else {
            BatchDefine.USER_OPTION_STR = null;
        }
    }


    /**
     * Deamon 用
     */
    @Override
    public void init(DaemonContext arg) throws Exception {
        System.out.println("okuyama Daemon init...");
        dc = arg;
    }

    /**
     * Deamon 用
     */
    @Override
    public void start() {

        System.out.println("okuyama Daemon start");
        String[] args = dc.getArguments();

        validateArgs(args);
        importArgs(args);

        try {
            exec(args[0], args[1]);
        } catch (BatchException be) {
            System.err.println("When okuyama starting, JavaMain error...");
            System.exit(1);
        }

    }

    /**
     * Deamon 用
     */
    @Override
    public void stop() {
        System.out.println("okuyama Daemon stop");
        shutdownMainProcess();
    }

    /**
     * Deamon 用
     */
    @Override
    public void destroy() {
        System.out.println("okuyama Daemon destroy");
    }

}
