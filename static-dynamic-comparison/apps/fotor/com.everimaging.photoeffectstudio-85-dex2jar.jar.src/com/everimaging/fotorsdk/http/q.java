package com.everimaging.fotorsdk.http;

import android.util.Log;

import java.io.UnsupportedEncodingException;

import org.apache.http.Header;

public abstract class q
        extends c {
    public q() {
        this("UTF-8");
    }

    public q(String paramString) {
        a(paramString);
    }

    public static String a(byte[] paramArrayOfByte, String paramString) {
        if (paramArrayOfByte == null) {
            return null;
        }
        try {
            paramArrayOfByte = new String(paramArrayOfByte, paramString);
            return paramArrayOfByte;
        } catch (UnsupportedEncodingException paramArrayOfByte) {
            Log.e("TextHttpResponseHandler", "Encoding response into string failed", paramArrayOfByte);
        }
        return null;
    }

    public abstract void a(int paramInt, Header[] paramArrayOfHeader, String paramString);

    public abstract void a(int paramInt, Header[] paramArrayOfHeader, String paramString, Throwable paramThrowable);

    public void a(int paramInt, Header[] paramArrayOfHeader, byte[] paramArrayOfByte) {
        a(paramInt, paramArrayOfHeader, a(paramArrayOfByte, b()));
    }

    public void a(int paramInt, Header[] paramArrayOfHeader, byte[] paramArrayOfByte, Throwable paramThrowable) {
        a(paramInt, paramArrayOfHeader, a(paramArrayOfByte, b()), paramThrowable);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/http/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */