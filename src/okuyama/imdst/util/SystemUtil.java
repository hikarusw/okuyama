package okuyama.imdst.util;

import java.net.*;
import java.io.*;
import java.util.*;
import java.util.Date;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.zip.*;

import okuyama.imdst.util.io.*;
import okuyama.base.util.ILogger;
import okuyama.base.util.LoggerFactory;


//import net.arnx.jsonic.JSON;



/**
 * okuyamaが使用する共通的なApiに対してアクセスする.<br>
 *
 * @author T.Okuyama
 * @license GPL(Lv3)
 */
public class SystemUtil {

    private static Object compressSync = new Object();
    private static ConcurrentLinkedQueue valueCompresserPool = null;
    private static ConcurrentLinkedQueue valueDecompresserPool = null;

    private static Object[] diskAccessSync = null;
    private static int[] diskAccessSyncCount = null;

    public static PrintWriter netDebugPrinter = null;

    private static Map checkCharacterMap = new HashMap(64);

    public static int bindMasterNodeServerPortNo = 8888;


    static {
        diskAccessSync = new Object[ImdstDefine.parallelDiskAccess];
        diskAccessSyncCount = new int[ImdstDefine.parallelDiskAccess];

        for (int i = 0; i < ImdstDefine.parallelDiskAccess; i++) {
            diskAccessSync[i] = new Object();
            diskAccessSyncCount[i] = 0;
        }

        checkCharacterMap.put("a", null);
        checkCharacterMap.put("b", null);
        checkCharacterMap.put("c", null);
        checkCharacterMap.put("d", null);
        checkCharacterMap.put("e", null);
        checkCharacterMap.put("f", null);
        checkCharacterMap.put("g", null);
        checkCharacterMap.put("h", null);
        checkCharacterMap.put("i", null);
        checkCharacterMap.put("j", null);
        checkCharacterMap.put("k", null);
        checkCharacterMap.put("l", null);
        checkCharacterMap.put("m", null);
        checkCharacterMap.put("n", null);
        checkCharacterMap.put("o", null);
        checkCharacterMap.put("p", null);
        checkCharacterMap.put("q", null);
        checkCharacterMap.put("r", null);
        checkCharacterMap.put("s", null);
        checkCharacterMap.put("t", null);
        checkCharacterMap.put("u", null);
        checkCharacterMap.put("v", null);
        checkCharacterMap.put("w", null);
        checkCharacterMap.put("x", null);
        checkCharacterMap.put("y", null);
        checkCharacterMap.put("z", null);
        checkCharacterMap.put("A", null);
        checkCharacterMap.put("B", null);
        checkCharacterMap.put("C", null);
        checkCharacterMap.put("D", null);
        checkCharacterMap.put("E", null);
        checkCharacterMap.put("F", null);
        checkCharacterMap.put("G", null);
        checkCharacterMap.put("H", null);
        checkCharacterMap.put("I", null);
        checkCharacterMap.put("J", null);
        checkCharacterMap.put("K", null);
        checkCharacterMap.put("L", null);
        checkCharacterMap.put("M", null);
        checkCharacterMap.put("N", null);
        checkCharacterMap.put("O", null);
        checkCharacterMap.put("P", null);
        checkCharacterMap.put("Q", null);
        checkCharacterMap.put("R", null);
        checkCharacterMap.put("S", null);
        checkCharacterMap.put("T", null);
        checkCharacterMap.put("U", null);
        checkCharacterMap.put("V", null);
        checkCharacterMap.put("W", null);
        checkCharacterMap.put("X", null);
        checkCharacterMap.put("Y", null);
        checkCharacterMap.put("Z", null);
        checkCharacterMap.put("1", null);
        checkCharacterMap.put("2", null);
        checkCharacterMap.put("3", null);
        checkCharacterMap.put("4", null);
        checkCharacterMap.put("5", null);
        checkCharacterMap.put("6", null);
        checkCharacterMap.put("7", null);
        checkCharacterMap.put("8", null);
        checkCharacterMap.put("9", null);
        checkCharacterMap.put("0", null);
        checkCharacterMap.put("!", null);
        checkCharacterMap.put("#", null);
        checkCharacterMap.put("$", null);
        checkCharacterMap.put("%", null);
        checkCharacterMap.put("&", null);
        checkCharacterMap.put("'", null);
        checkCharacterMap.put("(", null);
        checkCharacterMap.put(")", null);
        checkCharacterMap.put("-", null);
        checkCharacterMap.put("=", null);
        checkCharacterMap.put("^", null);
        checkCharacterMap.put("~", null);
        checkCharacterMap.put("\\", null);
        checkCharacterMap.put("|", null);
        checkCharacterMap.put("@", null);
        checkCharacterMap.put("`", null);
        checkCharacterMap.put("[", null);
        checkCharacterMap.put("{", null);
        checkCharacterMap.put(";", null);
        checkCharacterMap.put("+", null);
        checkCharacterMap.put(":", null);
        checkCharacterMap.put("*", null);
        checkCharacterMap.put("]", null);
        checkCharacterMap.put("}", null);
        checkCharacterMap.put("/", null);
        checkCharacterMap.put("?", null);
        checkCharacterMap.put("_", null);
        checkCharacterMap.put(",", null);
        checkCharacterMap.put("<", null);
        checkCharacterMap.put(".", null);
        checkCharacterMap.put(">", null);
        checkCharacterMap.put(" ", null);
        checkCharacterMap.put("　", null);
        checkCharacterMap.put("あ", null);
        checkCharacterMap.put("い", null);
        checkCharacterMap.put("う", null);
        checkCharacterMap.put("え", null);
        checkCharacterMap.put("お", null);
        checkCharacterMap.put("か", null);
        checkCharacterMap.put("き", null);
        checkCharacterMap.put("く", null);
        checkCharacterMap.put("け", null);
        checkCharacterMap.put("こ", null);
        checkCharacterMap.put("さ", null);
        checkCharacterMap.put("し", null);
        checkCharacterMap.put("す", null);
        checkCharacterMap.put("せ", null);
        checkCharacterMap.put("そ", null);
        checkCharacterMap.put("た", null);
        checkCharacterMap.put("ち", null);
        checkCharacterMap.put("つ", null);
        checkCharacterMap.put("て", null);
        checkCharacterMap.put("と", null);
        checkCharacterMap.put("な", null);
        checkCharacterMap.put("に", null);
        checkCharacterMap.put("ぬ", null);
        checkCharacterMap.put("ね", null);
        checkCharacterMap.put("の", null);
        checkCharacterMap.put("は", null);
        checkCharacterMap.put("ひ", null);
        checkCharacterMap.put("ふ", null);
        checkCharacterMap.put("へ", null);
        checkCharacterMap.put("ほ", null);
        checkCharacterMap.put("ま", null);
        checkCharacterMap.put("み", null);
        checkCharacterMap.put("む", null);
        checkCharacterMap.put("め", null);
        checkCharacterMap.put("も", null);
        checkCharacterMap.put("や", null);
        checkCharacterMap.put("ゆ", null);
        checkCharacterMap.put("よ", null);
        checkCharacterMap.put("わ", null);
        checkCharacterMap.put("を", null);
        checkCharacterMap.put("ん", null);
        checkCharacterMap.put("！", null);
        checkCharacterMap.put("”", null);
        checkCharacterMap.put("＃", null);
        checkCharacterMap.put("＄", null);
        checkCharacterMap.put("％", null);
        checkCharacterMap.put("＆", null);
        checkCharacterMap.put("’", null);
        checkCharacterMap.put("（", null);
        checkCharacterMap.put("）", null);
        checkCharacterMap.put("＝", null);
        checkCharacterMap.put("～", null);
        checkCharacterMap.put("｜", null);
        checkCharacterMap.put("１", null);
        checkCharacterMap.put("２", null);
        checkCharacterMap.put("３", null);
        checkCharacterMap.put("４", null);
        checkCharacterMap.put("５", null);
        checkCharacterMap.put("６", null);
        checkCharacterMap.put("７", null);
        checkCharacterMap.put("８", null);
        checkCharacterMap.put("９", null);
        checkCharacterMap.put("０", null);
        checkCharacterMap.put("－", null);
        checkCharacterMap.put("＾", null);
        checkCharacterMap.put("￥", null);
        checkCharacterMap.put("ｑ", null);
        checkCharacterMap.put("ｗ", null);
        checkCharacterMap.put("ｅ", null);
        checkCharacterMap.put("ｒ", null);
        checkCharacterMap.put("ｔ", null);
        checkCharacterMap.put("ｙ", null);
        checkCharacterMap.put("ｕ", null);
        checkCharacterMap.put("ｉ", null);
        checkCharacterMap.put("ｏ", null);
        checkCharacterMap.put("ｐ", null);
        checkCharacterMap.put("＠", null);
        checkCharacterMap.put("［", null);
        checkCharacterMap.put("］", null);
        checkCharacterMap.put("：", null);
        checkCharacterMap.put("；", null);
        checkCharacterMap.put("ｌ", null);
        checkCharacterMap.put("ｋ", null);
        checkCharacterMap.put("ｊ", null);
        checkCharacterMap.put("ｈ", null);
        checkCharacterMap.put("ｇ", null);
        checkCharacterMap.put("ｆ", null);
        checkCharacterMap.put("ｄ", null);
        checkCharacterMap.put("ｓ", null);
        checkCharacterMap.put("ａ", null);
        checkCharacterMap.put("ｚ", null);
        checkCharacterMap.put("ｘ", null);
        checkCharacterMap.put("ｃ", null);
        checkCharacterMap.put("ｖ", null);
        checkCharacterMap.put("ｂ", null);
        checkCharacterMap.put("ｎ", null);
        checkCharacterMap.put("ｍ", null);
        checkCharacterMap.put("，", null);
        checkCharacterMap.put("．", null);
        checkCharacterMap.put("／", null);
        checkCharacterMap.put("￥", null);
        checkCharacterMap.put("Ｑ", null);
        checkCharacterMap.put("Ｗ", null);
        checkCharacterMap.put("Ｅ", null);
        checkCharacterMap.put("Ｒ", null);
        checkCharacterMap.put("Ｔ", null);
        checkCharacterMap.put("Ｙ", null);
        checkCharacterMap.put("Ｕ", null);
        checkCharacterMap.put("Ｉ", null);
        checkCharacterMap.put("Ｏ", null);
        checkCharacterMap.put("Ｐ", null);
        checkCharacterMap.put("‘", null);
        checkCharacterMap.put("｛", null);
        checkCharacterMap.put("｝", null);
        checkCharacterMap.put("＊", null);
        checkCharacterMap.put("＋", null);
        checkCharacterMap.put("Ｌ", null);
        checkCharacterMap.put("Ｋ", null);
        checkCharacterMap.put("Ｊ", null);
        checkCharacterMap.put("Ｈ", null);
        checkCharacterMap.put("Ｇ", null);
        checkCharacterMap.put("Ｆ", null);
        checkCharacterMap.put("Ｄ", null);
        checkCharacterMap.put("Ｓ", null);
        checkCharacterMap.put("Ａ", null);
        checkCharacterMap.put("Ｚ", null);
        checkCharacterMap.put("Ｘ", null);
        checkCharacterMap.put("Ｃ", null);
        checkCharacterMap.put("Ｖ", null);
        checkCharacterMap.put("Ｂ", null);
        checkCharacterMap.put("Ｎ", null);
        checkCharacterMap.put("Ｍ", null);
        checkCharacterMap.put("＜", null);
        checkCharacterMap.put("＞", null);
        checkCharacterMap.put("？", null);
        checkCharacterMap.put("＿", null);
        checkCharacterMap.put("\r", null);
        checkCharacterMap.put("\n", null);
    }




    /**
     * 指定の文字を指定の桁数で特定文字列で埋める.<br>
     *
     * @param data
     * @param fixSize
     */
    public static String fillCharacter(String data, int fixSize) {
        return fillCharacter(data, fixSize, 38);
    }


    /**
     * 指定の文字を指定の桁数で特定文字列で埋める.<br>
     *
     * @param data
     * @param fixSize
     * @param fixByte
     */
    public static String fillCharacter(String data, int fixSize, int fillByte) {
        StringBuilder writeBuf = new StringBuilder(data);

        int valueSize = data.length();

        // 渡されたデータが固定の長さ分ない場合は足りない部分を補う
        byte[] appendDatas = new byte[fixSize - valueSize];

        for (int i = 0; i < appendDatas.length; i++) {
            appendDatas[i] = new Integer(fillByte).byteValue();
        }

        writeBuf.append(new String(appendDatas));
        return writeBuf.toString();
    }

    /**
     * RandomAccessFileの利用をSyncする.<br>
     *
     */
    public static int diskAccessSync(RandomAccessFile fileAccessor, byte[] buf) throws Exception {
        int ret = 0;
        try {
            int syncIdx = 0;
            if (ImdstDefine.parallelDiskAccess != 1) {
                syncIdx = ((fileAccessor.hashCode() << 1) >>> 1) % ImdstDefine.parallelDiskAccess;
            }
            synchronized (diskAccessSync[syncIdx]) {
                ret = fileAccessor.read(buf);
            }
        } catch (Exception e) {
            throw e;
        }
        return ret;
    }

    /**
     * RandomAccessFileの利用をSyncする.<br>
     *
     */
    public static int diskAccessSync(RandomAccessFile fileAccessor, byte[] buf, int start, int len) throws Exception {
        int ret = 0;
        try {
            int syncIdx = 0;
            if (ImdstDefine.parallelDiskAccess != 1) {
                syncIdx = ((fileAccessor.hashCode() << 1) >>> 1) % ImdstDefine.parallelDiskAccess;
            }

            synchronized (diskAccessSync[syncIdx]) {
                ret = fileAccessor.read(buf, start, len);
            }
        } catch (Exception e) {
            throw e;
        }
        return ret;
    }


    /**
     * Diskへの書き込みをSyncする.<br>
     * 
     * @param fileAccessor FileアクセスStream
     * @param type Streamの種類 1=BufferedWriter 2=CustomBufferedWriter
     * @throw Exception
     */
    public static int diskAccessSync(Object fileAccessor) throws Exception {
        return diskAccessSync(fileAccessor, true);
    }

    /**
     * Diskへの書き込みをSyncする.<br>
     * 
     * @param fileAccessor FileアクセスStream
     * @param type Streamの種類 1=BufferedWriter 2=CustomBufferedWriter
     * @throw Exception
     */
    public static int diskAccessSync(Object fileAccessor, boolean auto) throws Exception {
        try {
            int type = 0;
            int syncIdx = 0;
            if (ImdstDefine.parallelDiskAccess != 1) {
                syncIdx = ((fileAccessor.hashCode() << 1) >>> 1) % ImdstDefine.parallelDiskAccess;
            }

            boolean checkEnd = false;

            if (fileAccessor instanceof CustomBufferedWriter) {
                type = 2;
                checkEnd = true;
            }

            if (checkEnd == false && fileAccessor instanceof BufferedWriter) {
                type = 1;
                checkEnd = true;
            }


            if (type == 1) {
                if (auto == false) {
                    ((BufferedWriter)fileAccessor).flush();
                    return 0;
                }
                synchronized (diskAccessSync[syncIdx]) {
                    ((BufferedWriter)fileAccessor).flush();
                }
            }

            if (type == 2) {
                synchronized (diskAccessSync[syncIdx]) {
                    CustomBufferedWriter customBufferedWriter = (CustomBufferedWriter)fileAccessor;
                    customBufferedWriter.flush();
                    if (ImdstDefine.transactionLogFsyncType > 0) {
                        diskAccessSyncCount[syncIdx]++;
                        FileDescriptor fd = null;

                        switch (ImdstDefine.transactionLogFsyncType) {
                            case 4 :

                                fd = ((CustomBufferedWriter)fileAccessor).getFD();
                                fd.sync();
                                break;

                            case 3 :
                                if (diskAccessSyncCount[syncIdx] > 5) {
                                    fd = ((CustomBufferedWriter)fileAccessor).getFD();
                                    fd.sync();
                                    diskAccessSyncCount[syncIdx] = 0;
                                }
                                break;

                            case 2 :
                                if (diskAccessSyncCount[syncIdx] > 25) {

                                    fd = ((CustomBufferedWriter)fileAccessor).getFD();
                                    fd.sync();
                                    diskAccessSyncCount[syncIdx] = 0;
                                }
                                break;

                            case 1 :
                                if (diskAccessSyncCount[syncIdx] > 50) {

                                    fd = ((CustomBufferedWriter)fileAccessor).getFD();
                                    fd.sync();
                                    diskAccessSyncCount[syncIdx] = 0;
                                }
                                break;
                        }
                    }
                }
            }

        } catch (Exception e) {
            throw e;
        }
        return 0;
    }

    /**
     * 指定された値を時間に置き換えた場合に現在時間を過ぎているかをチェックする.<br>
     *
     * @param expirTimeStr
     * @return boolean true:有効 false:有効期限切れ
     */
    public static boolean expireCheck(String expirTimeStr) {
        boolean ret = true;

        try {
            // 数値変換出来ない場合はエラー
            if (!expirTimeStr.trim().equals("0")) {

                long expireTime = Long.parseLong(expirTimeStr);

                if (expireTime <= JavaSystemApi.currentTimeMillis) ret = false;
            }
        } catch (NumberFormatException e) {
            ret = false;
        }

        return ret;
    }


    /**
     * 指定された値を時間に置き換えた場合に現在時間を過ぎているかをチェックする.<br>
     * 引数のoverTimeで指定したミリ秒を過ぎている場合のみfalseを返す.<br>
     *
     * @param expirTimeStr
     * @param overTime
     * @return boolean
     */
    public static boolean expireCheck(String expirTimeStr, long overTime) {
        boolean ret = true;

        try {
            // 数値変換出来ない場合はエラー
            if (!expirTimeStr.trim().equals("0")) {

                long expireTime = Long.parseLong(expirTimeStr);

                if ((expireTime + overTime) <= JavaSystemApi.currentTimeMillis) ret = false;
            }
        } catch (NumberFormatException e) {
            ret = false;
        }

        return ret;
    }


    /**
     * Value圧縮関係を初期化
     *
     */
    public static void initValueCompress() {
        if (valueCompresserPool != null) return;

        synchronized (compressSync) {
            if (valueCompresserPool == null) {

                
                valueCompresserPool = new ConcurrentLinkedQueue();
                valueDecompresserPool = new ConcurrentLinkedQueue();
                
                for (int i = 0; i < ImdstDefine.valueCompresserPoolSize; i++) {
                    Deflater compresser = new Deflater();
                    compresser.setLevel(ImdstDefine.valueCompresserLevel);
                    valueCompresserPool.add(compresser);
                    
                    Inflater decompresser = new Inflater();
                    valueDecompresserPool.add(decompresser);
                }
            }
        }
    }


    /**
     * Value用圧縮処理.<br>
     *
     * @param src
     * @return byte[]
     */
    public static byte[] valueCompress(byte[] src) {
        if (!ImdstDefine.saveValueCompress) return src;
        return dataCompress(src);
    }


    /**
     * 圧縮処理.<br>
     *
     * @param src
     * @return byte[]
     */
    public static byte[] dataCompress(byte[] src) {

        if (valueCompresserPool == null) initValueCompress();

        byte[] ret = null;

        Deflater compresser = (Deflater)valueCompresserPool.poll();
        if (compresser == null) {
            compresser = new Deflater();
            compresser.setLevel(ImdstDefine.valueCompresserLevel);
        }

        try {
            // 圧縮
            ret = compress(src, compresser, ImdstDefine.valueCompresserCompressSize);
        } catch (Exception e) {

            e.printStackTrace();
            compresser = null;
        } finally {

            if (compresser != null) { 
                compresser.reset();
                valueCompresserPool.add(compresser);
            }
        }
        return ret;
    }


    /**
     * Value圧縮解除処理.<br>
     *
     * @param src
     * @return byte[]
     */
    public static byte[] valueDecompress(byte[] src) {
        if (!ImdstDefine.saveValueCompress) return src;
        return dataDecompress(src);
    }


    /**
     * 圧縮解除処理.<br>
     *
     * @param src
     * @return byte[]
     */
    public static byte[] dataDecompress(byte[] src) {

        if (valueCompresserPool == null) initValueCompress();

        Inflater decompresser = (Inflater)valueDecompresserPool.poll();
        if (decompresser == null) {
            decompresser = new Inflater();
        }

        byte[] ret = null;
        try {
            // 圧縮解除
            ret = decompress(src, decompresser, ImdstDefine.valueCompresserCompressSize);
        } catch (Exception e) {
            e.printStackTrace();
            decompresser = null;
        } finally {
            if (decompresser != null) {
                decompresser.reset();
                valueDecompresserPool.add(decompresser);
            }
        }
        return ret;
    }


    // 圧縮処理だけ共通化
    private static byte[] compress(byte[] src, Deflater compresser, int compressCycleSize) throws Exception {

        ByteArrayOutputStream compos = new ByteArrayOutputStream();

        try {
            compresser.setInput(src);
            compresser.finish();

            byte[] buf = new byte[compressCycleSize];
            int count = 0;
            while (!compresser.finished()) {
                count = compresser.deflate(buf);
                compos.write(buf, 0, count);
            }
            return compos.toByteArray();
        } catch (Exception e) {
            throw e;
        }
    }

    // 圧縮解除処理だけ共通化
    private static byte[] decompress(byte[] src, Inflater decompresser, int compressCycleSize) throws Exception {

        ByteArrayOutputStream decompos = new ByteArrayOutputStream();

        try {

            decompresser.setInput(src);

            byte[] buf = new byte[compressCycleSize];
            int count = 0;
            while (!decompresser.finished()) {
                count = decompresser.inflate(buf);
                decompos.write(buf, 0, count);
            }
            return decompos.toByteArray();
        } catch (Exception e) {
            throw e;
        }
    }


    // Index作成対象外の場合はtrue
    public static boolean checkNoIndexCharacter(String checkStr) {
        if (checkStr.length() > 1) {
            int checkCount = 0;
            int matchCount = 0;

            for (int i = 0; i < checkStr.length(); i++) {

                String str = checkStr.substring(i, i+1);

                checkCount++;

                if(str.indexOf(" ") > -1 || 
                    str.indexOf("。") > -1 || 
                        str.indexOf("、") > -1 || 
                            str.indexOf("　") > -1 || 
                                str.indexOf("「") > -1 || 
                                    str.indexOf("」") > -1 || 
                                        str.indexOf(",") > -1 || 
                                            str.indexOf(".") > -1 || 
                                                str.indexOf("(") > -1 || 
                                                    str.indexOf(")") > -1 || 
                                                        str.indexOf("[") > -1 || 
                                                            str.indexOf("]") > -1 || 
                                                                str.indexOf("（") > -1 || 
                                                                    str.indexOf("）") > -1 || 
                                                                        str.indexOf("{") > -1 || 
                                                                            str.indexOf("}") > -1 || 
                                                                                str.indexOf("｛") > -1 || 
                                                                                    str.indexOf("｝") > -1 || 
                                                                        str.indexOf("/") > -1) matchCount++;
            }

            if (checkCount == matchCount) return true;
        } else {
            if(checkCharacterMap.containsKey(checkStr)) return true;
        }
        return false;
    }

    

    /**
     * -debugオプションを利用した際に、標準出力への出力を行う.<br>
     *
     * @param String outputStr
     */
    public static void debugLine(String outputStr) {
        if (StatusUtil.getDebugOption()) {
            StringBuilder strBuf = new StringBuilder(100);
            strBuf.append(new Date().toString());
            strBuf.append(" DebugLine \"");
            strBuf.append(outputStr);
            strBuf.append("\"");
            if (SystemUtil.netDebugPrinter == null) { 
                System.out.println(strBuf.toString());
            } else {
                try {
                    SystemUtil.netDebugPrinter.println(strBuf.toString());
                    SystemUtil.netDebugPrinter.flush();
                } catch (Exception e) {
                    
                    StatusUtil.setDebugOption(false);
                    SystemUtil.netDebugPrinter = null;
                }
            }
            
            strBuf = null;
        }
    }


    public static byte[] defaultSerializeMap(Map data) {
        return normalObjectSerialize(data);
    }


    private static byte[] jsonSerializeMap(Map data) {
/*        byte[] ret = null;
        try {

            ret = ((String)JSON.encode(data)).getBytes();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ret;
*/
        return null;
    }


    public static byte[] normalObjectSerialize(Object data) {
        ByteArrayOutputStream bao = null;
        ObjectOutput oo = null;
        try {
            bao = new ByteArrayOutputStream(1000);
            oo = new ObjectOutputStream(bao);

            oo.writeObject(data);
            oo.flush();

            oo.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bao.toByteArray();
    }

    public static Map defaultDeserializeMap(byte[] data) {
        return (Map)normalObjectDeserialize(data);
    }

    private static Map jsonDeserializeMap(byte[] data) {
/*        Map ret = null;
        try {
            
            Map tmpMap = (Map)JSON.decode(new String(data));

            ret = new HashMap();
            for (Iterator ite = tmpMap.entrySet().iterator(); ite.hasNext();) {
                Map.Entry entry = (Map.Entry) ite.next();
                String key = (String) entry.getKey();
                Object value = (Object) entry.getValue();
                ret.put(new CoreMapKey(key), value);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ret;
*/
        return null;
    }

    public static Object normalObjectDeserialize(byte[] data) {
        Object retData = null;
        ByteArrayInputStream bio = null;
        ObjectInputStream ois = null;
        try {
            bio = new ByteArrayInputStream(data);
            ois = new ObjectInputStream(bio);

            retData = ois.readObject();
            ois.close();
            bio.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retData;
    }


    public static String getHostName() {
        try {
            InetAddress inet = InetAddress.getLocalHost();
            return inet.getHostName();
        } catch (Exception e) {
            return null;
        }
    }


    public static int getBindMasterNodePortNo() {
        return bindMasterNodeServerPortNo;
    }

}

