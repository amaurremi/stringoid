package com.mopub.common.logging;

import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class MoPubLog {
    private static final Logger a = Logger.getLogger("com.mopub");
    private static final b b = new b(null);

    static {
        LogManager.getLogManager().addLogger(a);
        a.addHandler(b);
        a.setLevel(Level.FINE);
    }

    public static void c(String paramString) {
        c(paramString, null);
    }

    public static void c(String paramString, Throwable paramThrowable) {
        a.log(Level.FINEST, paramString, paramThrowable);
    }

    public static void d(String paramString) {
        d(paramString, null);
    }

    public static void d(String paramString, Throwable paramThrowable) {
        a.log(Level.CONFIG, paramString, paramThrowable);
    }

    public static void e(String paramString) {
        e(paramString, null);
    }

    public static void e(String paramString, Throwable paramThrowable) {
        a.log(Level.SEVERE, paramString, paramThrowable);
    }

    public static void i(String paramString) {
        i(paramString, null);
    }

    public static void i(String paramString, Throwable paramThrowable) {
        a.log(Level.INFO, paramString, paramThrowable);
    }

    public static void v(String paramString) {
        v(paramString, null);
    }

    public static void v(String paramString, Throwable paramThrowable) {
        a.log(Level.FINE, paramString, paramThrowable);
    }

    public static void w(String paramString) {
        w(paramString, null);
    }

    public static void w(String paramString, Throwable paramThrowable) {
        a.log(Level.WARNING, paramString, paramThrowable);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/common/logging/MoPubLog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */