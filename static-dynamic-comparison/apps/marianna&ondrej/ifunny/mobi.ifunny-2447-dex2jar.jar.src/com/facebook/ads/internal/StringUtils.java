package com.facebook.ads.internal;

import java.security.MessageDigest;

public class StringUtils {
    public static boolean isNullOrEmpty(String paramString) {
        return (paramString == null) || (paramString.length() <= 0);
    }

    public static String md5(String paramString) {
        try {
            paramString = MessageDigest.getInstance("MD5").digest(paramString.getBytes("utf-8"));
            StringBuilder localStringBuilder = new StringBuilder();
            int i = 0;
            while (i < paramString.length) {
                localStringBuilder.append(Integer.toString((paramString[i] & 0xFF) + 256, 16).substring(1));
                i += 1;
            }
            paramString = localStringBuilder.toString();
            return paramString;
        } catch (Exception paramString) {
        }
        return null;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/ads/internal/StringUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */