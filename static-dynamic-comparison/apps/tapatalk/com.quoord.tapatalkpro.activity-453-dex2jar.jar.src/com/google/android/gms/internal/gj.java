package com.google.android.gms.internal;

import android.util.Base64;

public final class gj {
    public static String d(byte[] paramArrayOfByte) {
        if (paramArrayOfByte == null) {
            return null;
        }
        return Base64.encodeToString(paramArrayOfByte, 0);
    }

    public static String e(byte[] paramArrayOfByte) {
        if (paramArrayOfByte == null) {
            return null;
        }
        return Base64.encodeToString(paramArrayOfByte, 10);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/internal/gj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */