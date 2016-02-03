package com.mopub.common.util;

import java.io.InputStream;

public class Strings {
    public static String fromStream(InputStream paramInputStream) {
        StringBuffer localStringBuffer = new StringBuffer();
        byte[] arrayOfByte = new byte['က'];
        for (int i = 0; i != -1; i = paramInputStream.read(arrayOfByte)) {
            localStringBuffer.append(new String(arrayOfByte, 0, i));
        }
        paramInputStream.close();
        return localStringBuffer.toString();
    }

    public static boolean isEmpty(String paramString) {
        if (paramString == null) {
        }
        while (paramString.length() != 0) {
            return false;
        }
        return true;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/common/util/Strings.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */