package com.mopub.common.util;

import java.io.File;

public class Files {
    public static File createDirectory(String paramString) {
        if (paramString == null) {
        }
        do {
            return null;
            paramString = new File(paramString);
        }
        while (((!paramString.exists()) || (!paramString.isDirectory())) && ((!paramString.mkdirs()) || (!paramString.isDirectory())));
        return paramString;
    }

    public static int intLength(File paramFile) {
        if (paramFile == null) {
            return 0;
        }
        long l = paramFile.length();
        if (l < 2147483647L) {
            return (int) l;
        }
        return Integer.MAX_VALUE;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/common/util/Files.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */