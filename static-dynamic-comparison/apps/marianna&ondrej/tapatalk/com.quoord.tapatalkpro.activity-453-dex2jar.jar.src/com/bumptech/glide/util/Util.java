package com.bumptech.glide.util;

public class Util {
    private static final char[] hexArray = "0123456789abcdef".toCharArray();
    private static final char[] sha256Chars = new char[64];

    private static String bytesToHex(byte[] paramArrayOfByte, char[] paramArrayOfChar) {
        int i = 0;
        for (; ; ) {
            if (i >= paramArrayOfByte.length) {
                return new String(paramArrayOfChar);
            }
            int j = paramArrayOfByte[i] & 0xFF;
            paramArrayOfChar[(i * 2)] = hexArray[(j >>> 4)];
            paramArrayOfChar[(i * 2 + 1)] = hexArray[(j & 0xF)];
            i += 1;
        }
    }

    public static String sha256BytesToHex(byte[] paramArrayOfByte) {
        return bytesToHex(paramArrayOfByte, sha256Chars);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/bumptech/glide/util/Util.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */