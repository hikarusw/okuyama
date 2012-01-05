package okuyama.imdst.util;

import java.io.ByteArrayOutputStream;

import com.sun.mail.util.BASE64DecoderStream;
import com.sun.mail.util.BASE64EncoderStream;

/**
 * 最終保存媒体がMemory時のConverter.<br>
 * Encode仕様:Key=BASE64でデコード後、バイト配列で返す
 *            Value=バイト配列で返す
 *
 * Decode仕様:Key=BASE64でエンコード後、Stringで返す
 *            Value=Stringで返す
 *
 *
 * @author T.Okuyama
 * @license GPL(Lv3)
 */
public class MemoryModeCoreValueCnv implements ICoreValueConverter {

    public volatile static int compressUnderLimitSize = 128;

    /**
     * 引数のObjectはBase64でエンコード後のString
     * 返却値はCoreMapKey
     *
     */
    public Object convertEncodeKey(Object key) {
        if (key == null) return null;
        //System.out.println("Encode Key[" + key + "]");
        return new CoreMapKey(((String)key).getBytes());
    }


    /**
     * 引数のObjectはBase64でエンコードされた文字とメタ情報の連結文字列
     * Base64エンコード済み以外のValueは不正な動作とんある可能性がある
     * 返却値はbyte配列
     *
     */
    public Object convertEncodeValue(Object value) {
        if (value == null) return null;

        byte[] valueBytes = ((String)value).getBytes();

        // 圧縮対象以下の場合は非圧縮
        if (valueBytes.length < MemoryModeCoreValueCnv.compressUnderLimitSize) {
            int size = valueBytes.length+1;
            byte[] returnBytes = new byte[size];

            // 非圧縮判断用に先頭に!を入れる
            returnBytes[0] = 33;
            for (int i = 1; i < size; i++) {
                returnBytes[i] = valueBytes[i-1];
            }
            return returnBytes;
        }

        return SystemUtil.valueCompress(valueBytes);

        //System.out.println("-------------------");
        //System.out.println(((byte[])",".getBytes())[0]); 44 
        //System.out.println(((byte[])"!".getBytes())[0]); 33
        //System.out.println(registerData.length + " => " + SystemUtil.valueCompress(registerData).length);
    }
    

    /**
     * 引数のObjectはCoreMapKey
     * 返却値は文字列
     */
    public Object convertDecodeKey(Object key) {
        if (key == null) return null;
        if (key instanceof CoreMapKey) {
            return new String(((CoreMapKey)key).getDatas());
        } else {
            return key;
        }

    }



    /**
     * 引数のObjectはBase64でエンコードされた文字とメタ情報の連結文字列のbyte配列
     * 返却値はbyte配列を文字列に変更したString
     *
     */
    public Object convertDecodeValue(Object value) {
        if (value == null) return null;

        byte[] valueBytes = (byte[])value;
        String returnStr = null;

        // 先頭が33"!"であるか確認
        if (valueBytes[0] == 33) {

            // 非圧縮
            returnStr = new String(valueBytes, 1, (valueBytes.length - 1));
        } else {

            // 圧縮
            returnStr = new String(SystemUtil.valueDecompress(valueBytes));
        }

        return returnStr;
    }
}
