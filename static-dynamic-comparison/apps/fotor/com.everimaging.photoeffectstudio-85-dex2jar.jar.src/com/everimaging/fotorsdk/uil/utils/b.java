package com.everimaging.fotorsdk.uil.utils;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class b {
    public static void a(Closeable paramCloseable) {
        try {
            paramCloseable.close();
            return;
        } catch (Exception paramCloseable) {
        }
    }

    private static boolean a(a parama, int paramInt1, int paramInt2) {
        return (parama != null) && (!parama.a(paramInt1, paramInt2)) && (paramInt1 * 100 / paramInt2 < 75);
    }

    public static boolean a(InputStream paramInputStream, OutputStream paramOutputStream, a parama)
            throws IOException {
        return a(paramInputStream, paramOutputStream, parama, 32768);
    }

    public static boolean a(InputStream paramInputStream, OutputStream paramOutputStream, a parama, int paramInt)
            throws IOException {
        int k = paramInputStream.available();
        byte[] arrayOfByte = new byte[paramInt];
        if (a(parama, 0, k)) {
            return false;
        }
        int i = 0;
        int j;
        do {
            j = paramInputStream.read(arrayOfByte, 0, paramInt);
            if (j == -1) {
                break;
            }
            paramOutputStream.write(arrayOfByte, 0, j);
            j = i + j;
            i = j;
        } while (!a(parama, j, k));
        return false;
        return true;
    }

    public static abstract interface a {
        public abstract boolean a(int paramInt1, int paramInt2);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/uil/utils/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */