package com.flurry.sdk;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

public final class fj {
    static final Charset a = Charset.forName("US-ASCII");
    static final Charset b = Charset.forName("UTF-8");

    static void a(Closeable paramCloseable) {
        if (paramCloseable != null) {
        }
        try {
            paramCloseable.close();
            return;
        } catch (RuntimeException paramCloseable) {
            throw paramCloseable;
        } catch (Exception paramCloseable) {
        }
    }

    static void a(File paramFile)
            throws IOException {
        File[] arrayOfFile = paramFile.listFiles();
        if (arrayOfFile == null) {
            throw new IOException("not a readable directory: " + paramFile);
        }
        int j = arrayOfFile.length;
        int i = 0;
        while (i < j) {
            paramFile = arrayOfFile[i];
            if (paramFile.isDirectory()) {
                a(paramFile);
            }
            if (!paramFile.delete()) {
                throw new IOException("failed to delete file: " + paramFile);
            }
            i += 1;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/fj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */