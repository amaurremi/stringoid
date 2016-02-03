package com.google.android.gms.internal;

import android.util.Base64;

public final class po {
    public static String a(byte[] paramArrayOfByte) {
        if (paramArrayOfByte == null) {
            return null;
        }
        return Base64.encodeToString(paramArrayOfByte, 0);
    }

    public static String b(byte[] paramArrayOfByte) {
        if (paramArrayOfByte == null) {
            return null;
        }
        return Base64.encodeToString(paramArrayOfByte, 10);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/po.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */