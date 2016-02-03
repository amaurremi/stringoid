package com.google.analytics.tracking.android;

public class v {
    private static s a;

    public static void a(String paramString) {
        Logger localLogger = b();
        if (localLogger != null) {
            localLogger.d(paramString);
        }
    }

    public static boolean a() {
        if (b() != null) {
            return Logger.LogLevel.VERBOSE.equals(b().a());
        }
        return false;
    }

    private static Logger b() {
        if (a == null) {
            a = s.a();
        }
        if (a != null) {
            return a.d();
        }
        return null;
    }

    public static void b(String paramString) {
        Logger localLogger = b();
        if (localLogger != null) {
            localLogger.b(paramString);
        }
    }

    public static void c(String paramString) {
        Logger localLogger = b();
        if (localLogger != null) {
            localLogger.a(paramString);
        }
    }

    public static void d(String paramString) {
        Logger localLogger = b();
        if (localLogger != null) {
            localLogger.c(paramString);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/google/analytics/tracking/android/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */