package org.apache.commons.lang;

import java.io.UnsupportedEncodingException;

public class CharEncoding {
    public static final String ISO_8859_1 = "ISO-8859-1";
    public static final String US_ASCII = "US-ASCII";
    public static final String UTF_16 = "UTF-16";
    public static final String UTF_16BE = "UTF-16BE";
    public static final String UTF_16LE = "UTF-16LE";
    public static final String UTF_8 = "UTF-8";

    public static boolean isSupported(String paramString) {
        if (paramString == null) {
            return false;
        }
        try {
            new String(ArrayUtils.EMPTY_BYTE_ARRAY, paramString);
            return true;
        } catch (UnsupportedEncodingException paramString) {
        }
        return false;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/org/apache/commons/lang/CharEncoding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */