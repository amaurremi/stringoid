package com.inmobi.commons.thirdparty;

import com.inmobi.commons.internal.Log;

public class Base62 {
    public static final String ALPHABET = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final int BASE = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".length();

    private static int a(int paramInt1, int paramInt2) {
        return (int) Math.pow(BASE, paramInt2) * paramInt1;
    }

    private static int a(char[] paramArrayOfChar) {
        int j = 0;
        int i = paramArrayOfChar.length - 1;
        while (i >= 0) {
            j += a("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".indexOf(paramArrayOfChar[i]), i);
            i -= 1;
        }
        return j;
    }

    private static long a(long paramLong, StringBuilder paramStringBuilder) {
        paramStringBuilder.append("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".charAt((int) (paramLong % BASE)));
        return paramLong / BASE;
    }

    public static String fromBase10(long paramLong) {
        try {
            Object localObject = new StringBuilder("");
            while (paramLong > 0L) {
                paramLong = a(paramLong, (StringBuilder) localObject);
            }
            localObject = ((StringBuilder) localObject).reverse().toString();
            return (String) localObject;
        } catch (Exception localException) {
            Log.internal("[InMobi]-4.5.1", "Failed to convert to base 62", localException);
        }
        return null;
    }

    public static int toBase10(String paramString) {
        return a(new StringBuilder(paramString).reverse().toString().toCharArray());
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/commons/thirdparty/Base62.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */