package okuyama.base.parameter.config;

import java.io.File;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import okuyama.base.lang.BatchDefine;
import okuyama.base.lang.BatchException;
import okuyama.base.util.ILogger;
import okuyama.base.util.LoggerFactory;
import okuyama.base.util.ClassUtility;

/** 
 * ルールの設定を読み込み保持する.<br>
 *
 * @author T.Okuyama
 * @license GPL(Lv3)
 */
public class JobConfig {

    // Logger
    private ILogger logger = LoggerFactory.createLogger(JobConfig.class);

    // joblistをキーにして、そのルールをさらにLinkedHashMapとして格納している
    // 格納済みのLinkedHashMapのキーはルールクラス名で、パラメータは初期値
    private LinkedHashMap configMap = null;

    private LinkedHashMap helperMap = null;

    // ユーザがJob設定ファイルに自由に設定した情報を格納
    private Hashtable userPrivateValuesMap = null;

    private String configFileName = null;

    private File configFile = null;

    private long fileModifiedTime = 0L;


    /**
     * 設定ファイル名を渡すことにより、生成.<br>
     * コンストラクタ<br>
     * 
     * @param fileName 設定ファイル名
     * @throws BatchException
     */
    public JobConfig(String fileName) throws BatchException {
        this.configMap = new LinkedHashMap();
        this.helperMap = new LinkedHashMap();
        this.userPrivateValuesMap = new Hashtable();
        this.configFileName = fileName;

        this.configFile = new File(fileName);
        try {
            if (this.configFile.exists()) {

                this.initConfig(new FileInputStream(this.configFile));
            } else {

                this.configFile = new File(JobConfig.class.getResource(this.configFileName).toURI());
                this.initConfig(new FileInputStream(this.configFile));
            }
        } catch (Exception e) {
            throw new BatchException(e);
        }
    }


    /**
     * 設定ファイルを解析し、自身に蓄える.<br>
     *
     * @param is 設定ファイルストリーム
     * @throws BatchException
     */
    private void initConfig(InputStream is) throws BatchException {
        Properties prop = null;

        String jobs = null;
        String[] jobList = null;

        String helpers = null;
        String[] helperList = null;

        String jobClass = null;
        String optionValue = null;
        String initValue = null;
        String dependValue = null;
        String helperLimitSizeStr = null;
        int helperLimitSize = 0;
        String helperMaxUseStr = null;
        int helperMaxUse = 0;

        String[] dependList = null;
        String dbgroupValue = null;
        String[] dbgroupList = null;
        String commitValue = null;

        String helperDbgroupValue = null;
        String[] helperDbgroupList = null;
        String helperCommitValue = null;

        String helperClass = null;

        Set keys = null;
        String key = null;

        JobConfigMap jobConfigMap = null;
        HelperConfigMap helperConfigMap = null;

        try {
            logger.debug("initConfig - Start");
            prop = new Properties();
            prop.load(is);

            // 対象job一覧取得
            jobs = prop.getProperty(BatchDefine.JOB_CONFIG_JOBLIST_KEY);

            logger.debug("JOBLIST:[" + jobs + "]");

            // 対象JobListを分解
            jobList = jobs.split(BatchDefine.JOB_CONFIG_JOBLIST_SEP);

            // 実行Jobの情報を分析
            for (int index = 0; index < jobList.length; index++) {
                jobClass = null;
                initValue = null;
                optionValue = null;
                dependValue = null;
                dependList = null;
                dbgroupValue = null;
                dbgroupList = null;
                commitValue = null;

                logger.debug("Job Parse Job:[" + jobList[index] + "]");
                // 対象Job名を使用して、情報を取り出す
                jobClass = (String)prop.remove(jobList[index] + BatchDefine.JOB_CONFIG_JOIN_SEP + BatchDefine.JOB_CONFIG_CLASS_KEY);

                // ルールの有無を調べる
                if (jobClass == null) {

                    logger.error("Job Class Configure Not Found");
                    logger.error("Error Job Name:[" + jobList[index] + "]");
                    throw new BatchException("Job Class Configure Error");
                } else {

                    logger.debug("Job Class Configure Exists");
                    logger.debug("Job Class Name:[" + jobClass + "]");

                    // Option値取得(NULLの可能性もある)
                    optionValue = (String)prop.remove(jobList[index] + BatchDefine.JOB_CONFIG_JOIN_SEP + BatchDefine.JOB_CONFIG_OPTION_KEY);

                    // Option値取得(NULLの可能性もある)
                    initValue = (String)prop.remove(jobList[index] + BatchDefine.JOB_CONFIG_JOIN_SEP + BatchDefine.JOB_CONFIG_INIT_KEY);

                    // Depend値取得(NULLの可能性もある)
                    dependValue = (String)prop.remove(jobList[index] + BatchDefine.JOB_CONFIG_JOIN_SEP + BatchDefine.JOB_CONFIG_DEPEND_KEY);
                    if (dependValue != null && !dependValue.equals("")) {
                        if(dependValue.indexOf(BatchDefine.JOB_CONFIG_DEPEND_SEP) == -1) {
                            dependList = new String[1];
                            dependList[0] = dependValue;
                        } else {
                            dependList = dependValue.split(BatchDefine.JOB_CONFIG_DEPEND_SEP);
                        }
                    }

                    // Dbgroup値取得(NULLの可能性もある)
                    dbgroupValue = (String)prop.remove(jobList[index] + BatchDefine.JOB_CONFIG_JOIN_SEP + BatchDefine.JOB_CONFIG_DBGROUP_KEY);
                    if (dbgroupValue != null && !dbgroupValue.equals("")) {
                        if(dbgroupValue.indexOf(BatchDefine.JOB_CONFIG_DBGROUP_SEP) == -1) {
                            dbgroupList = new String[1];
                            dbgroupList[0] = dbgroupValue;
                        } else {
                            dbgroupList = dbgroupValue.split(BatchDefine.JOB_CONFIG_DBGROUP_SEP);
                        }
                    }

                    // Commit値取得(NULLの可能性もある)
                    commitValue = (String)prop.remove(jobList[index] + BatchDefine.JOB_CONFIG_JOIN_SEP + BatchDefine.JOB_CONFIG_COMMIT_KEY);

                    // 値を保存
                    jobConfigMap = new JobConfigMap(jobList[index], jobClass, initValue, optionValue, dependList, dbgroupList, commitValue);

                    logger.info("Job Name" + jobList[index] + 
                                ", Class Name[" + jobClass  + "]" + 
                                ", Init  Name[" +  initValue + "]" + 
                                ", Option  Name[" +  optionValue + "]" + 
                                ", Depend  Name[" +  dependValue + "]" +
                                ", Dbgroup  Name[" +  dbgroupValue + "]" + 
                                ", Commit  Name[" +  commitValue + "]");
                    

                    // キー(Job名)値と、詳細情報
                    this.configMap.put(jobList[index], jobConfigMap);
                }
            }



            // 対象Helper一覧取得
            helpers = prop.getProperty(BatchDefine.JOB_CONFIG_HELPERLIST_KEY);

            logger.debug("HelperList:[" + helpers + "]");

            if (helpers != null && !helpers.equals("")) {
                // 対象JobListを分解
                helperList = helpers.split(BatchDefine.JOB_CONFIG_JOBLIST_SEP);

                // 実行Jobの情報を分析
                for (int index = 0; index < helperList.length; index++) {
                    helperClass = null;
                    initValue = null;
                    optionValue = null;
                    helperDbgroupValue = null;
                    helperDbgroupList = null;
                    helperCommitValue = null;


                    logger.debug("Helper Parse List:[" + helperList[index] + "]");
                    // 対象Job名を使用して、情報を取り出す
                    helperClass = (String)prop.remove(helperList[index] + BatchDefine.JOB_CONFIG_JOIN_SEP + BatchDefine.JOB_CONFIG_HELPER_CLASS_KEY);

                    // ルールの有無を調べる
                    if (helperClass == null) {

                        logger.error("Helper Class Not Found");
                        logger.error("Target Helper :[" + helperList[index] + "]");
                        throw new BatchException("ConfigureError");
                    } else {

                        // Option値取得(NULLの可能性もある)
                        optionValue = (String)prop.remove(helperList[index] + BatchDefine.JOB_CONFIG_JOIN_SEP + BatchDefine.JOB_CONFIG_OPTION_KEY);

                        // Init値取得(NULLの可能性もある)
                        initValue = (String)prop.remove(helperList[index] + BatchDefine.JOB_CONFIG_JOIN_SEP + BatchDefine.JOB_CONFIG_INIT_KEY);

                        // Limit値取得(同時インスタンス化数)(NULLの可能性もある)
                        helperLimitSize = 0;
                        helperLimitSizeStr = (String)prop.remove(helperList[index] + BatchDefine.JOB_CONFIG_JOIN_SEP + BatchDefine.JOB_CONFIG_HELPER_LIMIT_KEY);

                        if (helperLimitSizeStr != null) {
                            try {
                                // 数値変換
                                helperLimitSize = Integer.parseInt(helperLimitSizeStr);
                            } catch (NumberFormatException nfe) {
                                logger.error("[" + helperList[index] + "]");
                                throw new BatchException("Cofigure File[ Helper Limit ] Error[" + helperLimitSizeStr + "]");
                            }
                        }

                        // MaxUse値取得(1インスタンスの使用回数)(NULLの可能性もある)
                        helperMaxUse = 0;
                        helperMaxUseStr = (String)prop.remove(helperList[index] + BatchDefine.JOB_CONFIG_JOIN_SEP + BatchDefine.JOB_CONFIG_HELPER_MAX_USE_KEY);

                        if (helperMaxUseStr != null) {
                            try {
                                // 数値変換
                                helperMaxUse = Integer.parseInt(helperMaxUseStr);
                            } catch (NumberFormatException nfe) {
                                logger.error("Helper Name:[" + helperList[index] + "]");
                                throw new BatchException("Helper[ Helper Max Use ]Configure Error[" + helperMaxUseStr + "]");
                            }
                        }

                    }


                    // HelperDbgroupValue値取得(NULLの可能性もある)
                    helperDbgroupValue = (String)prop.remove(helperList[index] + BatchDefine.JOB_CONFIG_JOIN_SEP + BatchDefine.JOB_CONFIG_HELPER_DBGROUP_KEY);
                    if (helperDbgroupValue != null && !helperDbgroupValue.equals("")) {
                        if(helperDbgroupValue.indexOf(BatchDefine.JOB_CONFIG_HELPER_DBGROUP_SEP) == -1) {
                            helperDbgroupList = new String[1];
                            helperDbgroupList[0] = helperDbgroupValue;
                        } else {
                            helperDbgroupList = helperDbgroupValue.split(BatchDefine.JOB_CONFIG_HELPER_DBGROUP_SEP);
                        }
                    }

                    // Commit値取得(NULLの可能性もある)
                    helperCommitValue = (String)prop.remove(helperList[index] + BatchDefine.JOB_CONFIG_JOIN_SEP + BatchDefine.JOB_CONFIG_HELPER_COMMIT_KEY);

                    // 値を保存
                    helperConfigMap = new HelperConfigMap(helperList[index], helperClass, initValue, optionValue, helperLimitSize, helperMaxUse, helperDbgroupList, helperCommitValue);

                    logger.info("Helper Name" + helperList[index] + 
                                ", Class Name[" + helperClass  + "]" + 
                                ", Init Parameter[" +  initValue + "]" + 
                                ", Option Parameter[" +  optionValue + "]" +
                                ", Limit Parameter[" +  helperLimitSizeStr + "]" +
                                ", MaxUse Parameter[" +  helperMaxUseStr + "]" + 
                                ", Dbgroup Parameter[" +  helperDbgroupValue + "]" + 
                                ", Commit Parameter[" +  helperCommitValue + "]");

                    // キー(Job名)値と、詳細情報
                    this.helperMap.put(helperList[index], helperConfigMap);

                }
            }

            // システム設定以外の情報（自由な値）を自身に設定
            keys = prop.keySet();
            key = null;
            if (keys != null) {
                for (Iterator iterator = keys.iterator(); iterator.hasNext();) {
                    key = (String)iterator.next();
                    this.userPrivateValuesMap.put(key, prop.get(key));
                }
            }
            this.fileModifiedTime = this.configFile.lastModified();
        } catch (Exception e) {
            logger.error("initConfig - Error");
            throw new BatchException(e);
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException ie) {
                // 無視
                logger.error("initConfig - File Stream Close Error");
            }
        }
        logger.debug("initConfig - End");
    }

    /**
     * 設定されているconfigMapの情報を基に、Job名リストを取り出す.<br>
     *
     * @return String[] Job名リスト
     */
    public String[] getJobNameList() {
        String[] returnKyes;
        int index = 0;
        String key;

        Set keys = this.configMap.keySet();   
        returnKyes = new String[keys.size()];

        for (Iterator iterator = keys.iterator(); iterator.hasNext();) {

            key = (String)iterator.next();
            returnKyes[index] = key;

            index++;
        }
        return returnKyes;
    }

    /**
     * 設定されているconfigMapの情報を基に、Helper名リストを取り出す.<br>
     * 
     * @return String[] Helper名リスト
     */
    public String[] getHelperNameList() {
        String[] returnKyes;
        int index = 0;
        String key;

        Set keys = this.helperMap.keySet();   
        returnKyes = new String[keys.size()];

        for (Iterator iterator = keys.iterator(); iterator.hasNext();) {

            key = (String)iterator.next();
            returnKyes[index] = key;

            index++;
        }
        return returnKyes;
    }

    /**
     * 設定されているconfigMapの情報を基に、Job名をキーにそのJobに紐付く詳細を取り出す.<br>
     * 詳細情報が存在しないExceptionとする<br>
     *
     * @param jobName Job名
     * @return JobConfigMap Job設定情報
     */
    public JobConfigMap getJobConfig(String jobName) {
        JobConfigMap jobConfigMap = (JobConfigMap)this.configMap.get(jobName);

        return jobConfigMap;
    }

    /**
     * 設定されているconfigMapの情報を基に、Helper名をキーにそのHelperに紐付く詳細を取り出す.<br>
     * 詳細情報が存在しないExceptionとする<br>
     *
     * @param helperName Helper名
     * @return HelperConfigMap Helper設定情報
     */
    public HelperConfigMap getHelperConfig(String helperName) throws BatchException {
        HelperConfigMap helperConfigMap = null;
        if (this.helperMap.containsKey(helperName)) {

            helperConfigMap = (HelperConfigMap)this.helperMap.get(helperName);
        } else {
            throw new BatchException(helperName + ":Helper Not Found");
        }
        return helperConfigMap;
    }
    
    /**
     * ユーザが自由に設定した設定情報を取り出す.<br>
     * 存在しない場合はnullを返す.<br>
     * 
     * @param key 設定ファイルに設定されているユーザパラメータのキー値
     * @return String ユーザパラメータ
     */
    public String getUserParam(String key) {
        String ret = null;

        if (this.userPrivateValuesMap.containsKey(key)) {

            ret = (String)this.userPrivateValuesMap.get(key);
        }
        return ret;
    }

    /**
     * 設定ファイルに変更があったかをチェックする.<br>
     * 
     * @return boolean 
     */
    public boolean isChangePropertiesFile() throws BatchException {
        boolean ret = false;
        try {

            if(this.fileModifiedTime != this.configFile.lastModified()) ret = true;
        } catch(Exception e) {
            // エラー
            logger.error("isChangePropertiesFile - Error" + e);
        }
        return ret;

    }

    /**
     * ユーザが自由に設定した設定情報を再読み込みする.<br>
     * 
     * @param key 設定ファイルに設定されているユーザパラメータのキー値
     */
    public void reloadUserParam(String[] keys) throws BatchException {
        InputStream is = null;

        try {
            this.fileModifiedTime = this.configFile.lastModified();
            is = new FileInputStream(this.configFile);

            Properties prop = new Properties();
            prop.load(is);

            for (int i = 0; i < keys.length; i++) {
                String value = (String)prop.get(keys[i]);
                if (value != null) {
                    this.userPrivateValuesMap.put(keys[i], value);
                }
            }
        } catch (Exception e) {
            logger.error("reloadUserParam - Error");
            throw new BatchException(e);
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException ie) {
                // 無視
                logger.error("reloadUserParam - File Stream Close Error");
            }
        }
    }

}