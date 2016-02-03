package com.umeng.common.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

public class f {
    public static int a;

    public static String a(byte[] paramArrayOfByte, String paramString)
            throws UnsupportedEncodingException, DataFormatException {
        paramArrayOfByte = b(paramArrayOfByte);
        if (paramArrayOfByte != null) {
            return new String(paramArrayOfByte, paramString);
        }
        return null;
    }

    public static byte[] a(String paramString1, String paramString2)
            throws IOException {
        if (h.d(paramString1)) {
            return null;
        }
        return a(paramString1.getBytes(paramString2));
    }

    public static byte[] a(byte[] paramArrayOfByte)
            throws IOException {
        if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0)) {
            return null;
        }
        Deflater localDeflater = new Deflater();
        localDeflater.setInput(paramArrayOfByte);
        localDeflater.finish();
        paramArrayOfByte = new byte[' '];
        a = 0;
        try {
            localByteArrayOutputStream = new ByteArrayOutputStream();
            try {
                while (!localDeflater.finished()) {
                    int i = localDeflater.deflate(paramArrayOfByte);
                    a += i;
                    localByteArrayOutputStream.write(paramArrayOfByte, 0, i);
                }
                if (localByteArrayOutputStream == null) {
                    break label86;
                }
            } finally {
            }
        } finally {
            for (; ; ) {
                ByteArrayOutputStream localByteArrayOutputStream = null;
            }
        }
        localByteArrayOutputStream.close();
        label86:
        throw paramArrayOfByte;
        localDeflater.end();
        if (localByteArrayOutputStream != null) {
            localByteArrayOutputStream.close();
        }
        return localByteArrayOutputStream.toByteArray();
    }

    public static byte[] b(byte[] paramArrayOfByte)
            throws UnsupportedEncodingException, DataFormatException {
        int i = 0;
        if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
            return null;
        }
        Inflater localInflater = new Inflater();
        localInflater.setInput(paramArrayOfByte, 0, paramArrayOfByte.length);
        paramArrayOfByte = new ByteArrayOutputStream();
        byte[] arrayOfByte = new byte['Ѐ'];
        while (!localInflater.needsInput()) {
            int j = localInflater.inflate(arrayOfByte);
            paramArrayOfByte.write(arrayOfByte, i, j);
            i += j;
        }
        localInflater.end();
        return paramArrayOfByte.toByteArray();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/umeng/common/util/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */