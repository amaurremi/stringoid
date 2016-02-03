package com.google.analytics.tracking.android;

import android.util.Log;

class i
        implements Logger {
    private Logger.LogLevel a = Logger.LogLevel.INFO;

    private String e(String paramString) {
        return Thread.currentThread().toString() + ": " + paramString;
    }

    public Logger.LogLevel a() {
        return this.a;
    }

    public void a(Logger.LogLevel paramLogLevel) {
        this.a = paramLogLevel;
    }

    public void a(String paramString) {
        if (this.a.ordinal() <= Logger.LogLevel.VERBOSE.ordinal()) {
            Log.v("GAV3", e(paramString));
        }
    }

    public void b(String paramString) {
        if (this.a.ordinal() <= Logger.LogLevel.INFO.ordinal()) {
            Log.i("GAV3", e(paramString));
        }
    }

    public void c(String paramString) {
        if (this.a.ordinal() <= Logger.LogLevel.WARNING.ordinal()) {
            Log.w("GAV3", e(paramString));
        }
    }

    public void d(String paramString) {
        if (this.a.ordinal() <= Logger.LogLevel.ERROR.ordinal()) {
            Log.e("GAV3", e(paramString));
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/google/analytics/tracking/android/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */