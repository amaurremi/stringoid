package com.google.android.gms.common.api;

import android.util.Log;

public class e {
    static void a(r paramr) {
        if ((paramr instanceof q)) {
        }
        try {
            ((q) paramr).a();
            return;
        } catch (RuntimeException localRuntimeException) {
            Log.w("GoogleApi", "Unable to release " + paramr, localRuntimeException);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/common/api/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */