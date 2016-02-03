package com.flurry.sdk;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ey
        implements ex<String> {
    public void a(OutputStream paramOutputStream, String paramString)
            throws IOException {
        if ((paramOutputStream == null) || (paramString == null)) {
            return;
        }
        paramString = paramString.getBytes("utf-8");
        paramOutputStream.write(paramString, 0, paramString.length);
    }

    public String b(InputStream paramInputStream)
            throws IOException {
        if (paramInputStream == null) {
            return null;
        }
        ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
        fe.a(paramInputStream, localByteArrayOutputStream);
        return localByteArrayOutputStream.toString();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/flurry/sdk/ey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */