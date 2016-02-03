package com.amazon.device.ads;

public class Base64 {
    private static final String ENCODE_CHARSET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";

    public static byte[] decode(String paramString) {
        if (Utils.isNullOrWhiteSpace(paramString)) {
            throw new IllegalArgumentException("Encoded String must not be null or white space");
        }
        int m = getDecodedLength(paramString);
        if (m <= 0) {
            throw new IllegalArgumentException("Encoded String decodes to zero bytes");
        }
        byte[] arrayOfByte = new byte[m];
        int i = 0;
        int j = 0;
        if ((j >= paramString.length()) || (i >= m)) {
        }
        int n;
        do {
            do {
                return arrayOfByte;
            } while ((j % 4 == 0) && (paramString.length() < j + 4));
            n = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".indexOf(paramString.charAt(j));
        } while (n == -1);
        switch (j % 4) {
        }
        for (; ; ) {
            j += 1;
            break;
            arrayOfByte[i] = ((byte) (n << 2));
            continue;
            int k = i + 1;
            arrayOfByte[i] = ((byte) (arrayOfByte[i] | (byte) (n >> 4 & 0x3)));
            i = k;
            if (k < m) {
                arrayOfByte[k] = ((byte) (n << 4));
                i = k;
                continue;
                k = i + 1;
                arrayOfByte[i] = ((byte) (arrayOfByte[i] | (byte) (n >> 2 & 0xF)));
                i = k;
                if (k < m) {
                    arrayOfByte[k] = ((byte) (n << 6));
                    i = k;
                    continue;
                    k = i + 1;
                    arrayOfByte[i] = ((byte) (arrayOfByte[i] | (byte) (n & 0x3F)));
                    i = k;
                }
            }
        }
    }

    private static int getDecodedLength(String paramString) {
        int j = paramString.indexOf("=");
        int i = 0;
        if (j > -1) {
            i = paramString.length() - j;
        }
        return (paramString.length() + 3) / 4 * 3 - i;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/amazon/device/ads/Base64.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */