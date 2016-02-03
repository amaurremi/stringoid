package com.google.android.gms.internal;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class pt {
    public static long a(InputStream paramInputStream, OutputStream paramOutputStream, boolean paramBoolean) {
        return a(paramInputStream, paramOutputStream, paramBoolean, 1024);
    }

    public static long a(InputStream paramInputStream, OutputStream paramOutputStream, boolean paramBoolean, int paramInt) {
        byte[] arrayOfByte = new byte[paramInt];
        long l = 0L;
        try {
            for (; ; ) {
                paramInt = paramInputStream.read(arrayOfByte, 0, arrayOfByte.length);
                if (paramInt == -1) {
                    break;
                }
                l += paramInt;
                paramOutputStream.write(arrayOfByte, 0, paramInt);
            }
            if (!paramBoolean) {
                break label71;
            }
        } finally {
            if (paramBoolean) {
                a(paramInputStream);
                a(paramOutputStream);
            }
        }
        a(paramInputStream);
        a(paramOutputStream);
        label71:
        return l;
    }

    public static void a(Closeable paramCloseable) {
        if (paramCloseable != null) {
        }
        try {
            paramCloseable.close();
            return;
        } catch (IOException paramCloseable) {
        }
    }

    public static byte[] a(InputStream paramInputStream) {
        return a(paramInputStream, true);
    }

    public static byte[] a(InputStream paramInputStream, boolean paramBoolean) {
        ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
        a(paramInputStream, localByteArrayOutputStream, paramBoolean);
        return localByteArrayOutputStream.toByteArray();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/pt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */