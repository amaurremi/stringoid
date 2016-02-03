package com.everimaging.fotorsdk.utils;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class FotorIOUtils {
    public static void closeSilently(Closeable paramCloseable) {
        try {
            paramCloseable.close();
            return;
        } catch (Exception paramCloseable) {
        }
    }

    public static final String readFully(InputStream paramInputStream)
            throws IOException {
        StringBuilder localStringBuilder = new StringBuilder();
        paramInputStream = new Scanner(paramInputStream);
        while (paramInputStream.hasNextLine()) {
            localStringBuilder.append(paramInputStream.nextLine());
        }
        return localStringBuilder.toString();
    }

    public static int readSystemFileAsInt(String paramString)
            throws Exception {
        try {
            int i = Integer.parseInt(readFully(new ProcessBuilder(new String[]{"/system/bin/cat", paramString}).start().getInputStream()));
            return i;
        } catch (Exception paramString) {
            throw new Exception(paramString);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/utils/FotorIOUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */