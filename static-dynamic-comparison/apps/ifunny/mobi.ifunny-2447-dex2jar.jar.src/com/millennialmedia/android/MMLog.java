package com.millennialmedia.android;

public class MMLog {
    static {
        ComponentRegistry.a(new MMLog.LoggingComponent());
    }

    static void a(String paramString1, String paramString2) {
        ComponentRegistry.j().a(paramString1, paramString2);
    }

    static void a(String paramString1, String paramString2, Throwable paramThrowable) {
        ComponentRegistry.j().a(paramString1, paramString2, paramThrowable);
    }

    static void b(String paramString1, String paramString2) {
        ComponentRegistry.j().b(paramString1, paramString2);
    }

    static void c(String paramString1, String paramString2) {
        ComponentRegistry.j().c(paramString1, paramString2);
    }

    static void d(String paramString1, String paramString2) {
        ComponentRegistry.j().d(paramString1, paramString2);
    }

    static void e(String paramString1, String paramString2) {
        ComponentRegistry.j().e(paramString1, paramString2);
    }

    public static int getLogLevel() {
        return ComponentRegistry.j().getLogLevel();
    }

    public static void setLogLevel(int paramInt) {
        ComponentRegistry.j().setLogLevel(paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/MMLog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */