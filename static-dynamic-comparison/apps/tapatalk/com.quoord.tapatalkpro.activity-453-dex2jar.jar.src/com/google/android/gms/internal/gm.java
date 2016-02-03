package com.google.android.gms.internal;

import android.database.CharArrayBuffer;

public final class gm {
    public static void b(String paramString, CharArrayBuffer paramCharArrayBuffer) {
        if ((paramCharArrayBuffer.data == null) || (paramCharArrayBuffer.data.length < paramString.length())) {
            paramCharArrayBuffer.data = paramString.toCharArray();
        }
        for (; ; ) {
            paramCharArrayBuffer.sizeCopied = paramString.length();
            return;
            paramString.getChars(0, paramString.length(), paramCharArrayBuffer.data, 0);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/internal/gm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */