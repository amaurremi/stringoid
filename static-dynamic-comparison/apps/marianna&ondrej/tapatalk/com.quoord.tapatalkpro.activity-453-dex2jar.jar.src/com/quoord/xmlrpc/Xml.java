package com.quoord.xmlrpc;

public class Xml {
    public static final int COMMENT = 1;
    public static final int DOCTYPE = 2;
    public static final int ELEMENT = 4;
    public static int ENCODE_128 = 2;
    public static final int ENCODE_MIN = 0;
    public static final int ENCODE_QUOT = 1;
    public static final int END_DOCUMENT = 8;
    public static final int END_TAG = 16;
    public static final String NO_NAMESPACE = "";
    public static final int PROCESSING_INSTRUCTION = 32;
    public static final int START_DOCUMENT = 0;
    public static final int START_TAG = 64;
    public static final int TEXT = 128;
    public static final int WAP_EXTENSION = 1024;
    public static final int WHITESPACE = 256;

    public static String encode(String paramString) {
        return encode(paramString, 0);
    }

    public static String encode(String paramString, int paramInt) {
        int j = paramString.length();
        StringBuffer localStringBuffer = new StringBuffer(paramString.length());
        int i = 0;
        if (i >= j) {
            return localStringBuffer.toString();
        }
        char c = paramString.charAt(i);
        switch (c) {
            default:
                if ((c >= '') && ((ENCODE_128 & paramInt) != 0)) {
                    localStringBuffer.append("&#" + c + ";");
                }
                break;
        }
        for (; ; ) {
            i += 1;
            break;
            localStringBuffer.append("&lt;");
            continue;
            localStringBuffer.append("&gt;");
            continue;
            localStringBuffer.append("&amp;");
            continue;
            if ((paramInt & 0x1) != 0) {
                localStringBuffer.append("&quot;");
            } else {
                localStringBuffer.append('"');
                continue;
                localStringBuffer.append(c);
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/xmlrpc/Xml.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */