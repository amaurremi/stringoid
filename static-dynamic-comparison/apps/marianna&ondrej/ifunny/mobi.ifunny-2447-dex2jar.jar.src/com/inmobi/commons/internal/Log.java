package com.inmobi.commons.internal;

public class Log {
    private static Log.INTERNAL_LOG_LEVEL a = Log.INTERNAL_LOG_LEVEL.NOT_SET;

    public static void debug(String paramString1, String paramString2) {
        if ((a.getValue() >= Log.INTERNAL_LOG_LEVEL.DEBUG.getValue()) || ((a == Log.INTERNAL_LOG_LEVEL.NOT_SET) && (CommonsConfig.getLogLevelConfig() >= Log.INTERNAL_LOG_LEVEL.DEBUG.getValue()))) {
            android.util.Log.d(paramString1, paramString2);
        }
    }

    public static void debug(String paramString1, String paramString2, Throwable paramThrowable) {
        switch (Log.a.a[a.ordinal()]) {
            default:
                return;
            case 1:
                debug(paramString1, paramString2);
                return;
        }
        internal(paramString1, paramString2, paramThrowable);
    }

    public static Log.INTERNAL_LOG_LEVEL getLogLevel() {
        return a;
    }

    public static Log.INTERNAL_LOG_LEVEL getLogLevelValue(long paramLong) {
        if (paramLong == 2L) {
            return Log.INTERNAL_LOG_LEVEL.INTERNAL;
        }
        if (paramLong == 1L) {
            return Log.INTERNAL_LOG_LEVEL.DEBUG;
        }
        return Log.INTERNAL_LOG_LEVEL.NONE;
    }

    public static void internal(String paramString1, String paramString2) {
        if ((a.getValue() >= Log.INTERNAL_LOG_LEVEL.INTERNAL.getValue()) || ((a == Log.INTERNAL_LOG_LEVEL.NOT_SET) && (CommonsConfig.getLogLevelConfig() >= Log.INTERNAL_LOG_LEVEL.INTERNAL.getValue()))) {
            StackTraceElement localStackTraceElement = new Throwable().getStackTrace()[1];
            android.util.Log.v(paramString1, localStackTraceElement.getFileName() + ": " + localStackTraceElement.getMethodName() + " " + paramString2);
        }
    }

    public static void internal(String paramString1, String paramString2, Throwable paramThrowable) {
        if ((a.getValue() >= Log.INTERNAL_LOG_LEVEL.INTERNAL.getValue()) || ((a == Log.INTERNAL_LOG_LEVEL.NOT_SET) && (CommonsConfig.getLogLevelConfig() >= Log.INTERNAL_LOG_LEVEL.INTERNAL.getValue()))) {
            StackTraceElement localStackTraceElement = new Throwable().getStackTrace()[1];
            android.util.Log.e(paramString1, localStackTraceElement.getFileName() + ": " + localStackTraceElement.getMethodName() + " " + paramString2, paramThrowable);
        }
    }

    public static void setInternalLogLevel(Log.INTERNAL_LOG_LEVEL paramINTERNAL_LOG_LEVEL) {
        a = paramINTERNAL_LOG_LEVEL;
        if (a == Log.INTERNAL_LOG_LEVEL.INTERNAL) {
            com.inmobi.commons.thinICE.icedatacollector.BuildSettings.DEBUG = true;
        }
    }

    public static void verbose(String paramString1, String paramString2) {
        if ((a.getValue() >= Log.INTERNAL_LOG_LEVEL.VERBOSE.getValue()) || ((a == Log.INTERNAL_LOG_LEVEL.NOT_SET) && (CommonsConfig.getLogLevelConfig() >= Log.INTERNAL_LOG_LEVEL.VERBOSE.getValue()))) {
            android.util.Log.i(paramString1, paramString2);
        }
    }

    public static void verbose(String paramString1, String paramString2, Throwable paramThrowable) {
        switch (Log.a.a[a.ordinal()]) {
            default:
                return;
            case 1:
            case 3:
                verbose(paramString1, paramString2);
                return;
        }
        internal(paramString1, paramString2, paramThrowable);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/commons/internal/Log.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */