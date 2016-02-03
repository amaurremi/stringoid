package com.google.android.gms.common.internal;

import android.util.Log;

public final class t {
    private final String a;

    public t(String paramString) {
        this.a = ((String) ag.a(paramString));
    }

    public void a(String paramString1, String paramString2) {
        if (a(5)) {
            Log.w(paramString1, paramString2);
        }
    }

    public boolean a(int paramInt) {
        return Log.isLoggable(this.a, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/common/internal/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */