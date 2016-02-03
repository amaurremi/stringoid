package com.mopub.common.util;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Streams {
    public static void closeStream(Closeable paramCloseable) {
        if (paramCloseable == null) {
            return;
        }
        try {
            paramCloseable.close();
            return;
        } catch (IOException paramCloseable) {
        }
    }

    public static void copyContent(InputStream paramInputStream, OutputStream paramOutputStream) {
        if ((paramInputStream == null) || (paramOutputStream == null)) {
            throw new IOException("Unable to copy from or to a null stream.");
        }
        byte[] arrayOfByte = new byte['䀀'];
        for (; ; ) {
            int i = paramInputStream.read(arrayOfByte);
            if (i == -1) {
                break;
            }
            paramOutputStream.write(arrayOfByte, 0, i);
        }
    }

    public static void copyContent(InputStream paramInputStream, OutputStream paramOutputStream, long paramLong) {
        if ((paramInputStream == null) || (paramOutputStream == null)) {
            throw new IOException("Unable to copy from or to a null stream.");
        }
        byte[] arrayOfByte = new byte['䀀'];
        long l = 0L;
        for (; ; ) {
            int i = paramInputStream.read(arrayOfByte);
            if (i == -1) {
                break;
            }
            l += i;
            if (l >= paramLong) {
                throw new IOException("Error copying content: attempted to copy " + l + " bytes, with " + paramLong + " maximum.");
            }
            paramOutputStream.write(arrayOfByte, 0, i);
        }
    }

    public static void readStream(InputStream paramInputStream, byte[] paramArrayOfByte) {
        int j = 0;
        int i = paramArrayOfByte.length;
        int k;
        do {
            k = paramInputStream.read(paramArrayOfByte, j, i);
            if (k == -1) {
                break;
            }
            j += k;
            k = i - k;
            i = k;
        } while (k > 0);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/common/util/Streams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */