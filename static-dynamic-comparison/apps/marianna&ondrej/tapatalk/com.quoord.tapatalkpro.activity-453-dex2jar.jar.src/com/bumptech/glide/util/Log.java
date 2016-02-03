package com.bumptech.glide.util;

import android.annotation.SuppressLint;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Log {
    public static boolean DEBUG = false;
    private static final String TAG = "GLIDE";
    @SuppressLint({"SimpleDateFormat"})
    private static final DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    public static void d(String paramString, Object... paramVarArgs) {
        if (!DEBUG) {
            return;
        }
        if (paramVarArgs.length > 0) {
            paramString = String.format(paramString, paramVarArgs);
        }
        for (; ; ) {
            android.util.Log.d("GLIDE", "[" + dateFormat.format(new Date()) + "] " + paramString);
            return;
        }
    }

    public static void e(String paramString, Throwable paramThrowable, Object... paramVarArgs) {
        if (paramVarArgs.length > 0) {
            paramString = String.format(paramString, paramVarArgs);
        }
        for (; ; ) {
            android.util.Log.e("GLIDE", paramString, paramThrowable);
            return;
        }
    }

    public static void e(String paramString, Object... paramVarArgs) {
        if (paramVarArgs.length > 0) {
            paramString = String.format(paramString, paramVarArgs);
        }
        for (; ; ) {
            android.util.Log.e("GLIDE", paramString);
            return;
        }
    }

    public static void i(String paramString, Object... paramVarArgs) {
        if (!DEBUG) {
            return;
        }
        if (paramVarArgs.length > 0) {
            paramString = String.format(paramString, paramVarArgs);
        }
        for (; ; ) {
            android.util.Log.i("GLIDE", paramString);
            return;
        }
    }

    public static void v(String paramString, Object... paramVarArgs) {
        if (!DEBUG) {
            return;
        }
        if (paramVarArgs.length > 0) {
            paramString = String.format(paramString, paramVarArgs);
        }
        for (; ; ) {
            android.util.Log.v("GLIDE", paramString);
            return;
        }
    }

    public static void w(String paramString, Object... paramVarArgs) {
        if (paramVarArgs.length > 0) {
            paramString = String.format(paramString, paramVarArgs);
        }
        for (; ; ) {
            android.util.Log.w("GLIDE", paramString);
            return;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/bumptech/glide/util/Log.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */