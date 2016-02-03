package com.mopub.common;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.io.StringWriter;
import java.nio.charset.Charset;

public final class DiskLruCacheUtil {
    static final Charset a = Charset.forName("US-ASCII");
    static final Charset b = Charset.forName("UTF-8");

    static String a(Reader paramReader) {
        try {
            StringWriter localStringWriter = new StringWriter();
            char[] arrayOfChar = new char['Ѐ'];
            for (; ; ) {
                int i = paramReader.read(arrayOfChar);
                if (i == -1) {
                    break;
                }
                localStringWriter.write(arrayOfChar, 0, i);
            }
            str = ((StringWriter) localObject).toString();
        } finally {
            paramReader.close();
        }
        String str;
        paramReader.close();
        return str;
    }

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

    static void a(File paramFile) {
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


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/common/DiskLruCacheUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */