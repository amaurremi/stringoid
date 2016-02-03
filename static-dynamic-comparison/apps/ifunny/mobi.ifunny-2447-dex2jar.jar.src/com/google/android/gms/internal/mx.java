package com.google.android.gms.internal;

import android.util.Log;

@ii
public final class mx {
    public static void a(String paramString) {
        if (a(3)) {
            Log.d("Ads", paramString);
        }
    }

    public static void a(String paramString, Throwable paramThrowable) {
        if (a(3)) {
            Log.d("Ads", paramString, paramThrowable);
        }
    }

    public static boolean a(int paramInt) {
        return ((paramInt >= 5) || (Log.isLoggable("Ads", paramInt))) && (paramInt != 2);
    }

    public static void b(String paramString) {
        if (a(6)) {
            Log.e("Ads", paramString);
        }
    }

    public static void b(String paramString, Throwable paramThrowable) {
        if (a(6)) {
            Log.e("Ads", paramString, paramThrowable);
        }
    }

    public static void c(String paramString) {
        if (a(4)) {
            Log.i("Ads", paramString);
        }
    }

    public static void c(String paramString, Throwable paramThrowable) {
        if (a(4)) {
            Log.i("Ads", paramString, paramThrowable);
        }
    }

    public static void d(String paramString) {
        if (a(2)) {
            Log.v("Ads", paramString);
        }
    }

    public static void d(String paramString, Throwable paramThrowable) {
        if (a(5)) {
            Log.w("Ads", paramString, paramThrowable);
        }
    }

    public static void e(String paramString) {
        if (a(5)) {
            Log.w("Ads", paramString);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/mx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */