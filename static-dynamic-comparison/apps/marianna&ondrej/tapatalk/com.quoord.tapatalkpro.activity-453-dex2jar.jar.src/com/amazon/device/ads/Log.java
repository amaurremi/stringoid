package com.amazon.device.ads;

import java.util.ArrayList;
import java.util.Iterator;

class Log {
    protected static final String LOGTAG = "AmazonMobileAds ";
    private static ILog logger = new LogcatLogger(null);
    private static boolean loggingEnabled_ = false;

    public static boolean canLog() {
        if (logger == null) {
            return false;
        }
        return DebugProperties.getDebugPropertyAsBoolean("debug.logging", loggingEnabled_);
    }

    public static void d(String paramString1, String paramString2) {
        d(false, paramString1, paramString2);
    }

    public static void d(String paramString1, String paramString2, Object... paramVarArgs) {
        d(false, paramString1, paramString2, paramVarArgs);
    }

    public static void d(boolean paramBoolean, String paramString1, String paramString2) {
        if ((canLog()) || (paramBoolean)) {
            logger.d("AmazonMobileAds " + paramString1, paramString2);
        }
    }

    public static void d(boolean paramBoolean, String paramString1, String paramString2, Object... paramVarArgs) {
        if ((canLog()) || (paramBoolean)) {
            logger.d("AmazonMobileAds " + paramString1, paramString2, paramVarArgs);
        }
    }

    public static void e(String paramString1, String paramString2) {
        e(false, paramString1, paramString2);
    }

    public static void e(String paramString1, String paramString2, Object... paramVarArgs) {
        e(false, paramString1, paramString2, paramVarArgs);
    }

    public static void e(boolean paramBoolean, String paramString1, String paramString2) {
        if ((canLog()) || (paramBoolean)) {
            logger.e("AmazonMobileAds " + paramString1, paramString2);
        }
    }

    public static void e(boolean paramBoolean, String paramString1, String paramString2, Object... paramVarArgs) {
        if ((canLog()) || (paramBoolean)) {
            logger.e("AmazonMobileAds " + paramString1, paramString2, paramVarArgs);
        }
    }

    public static void enableLogging(boolean paramBoolean) {
        loggingEnabled_ = paramBoolean;
    }

    public static final void enableLoggingWithSetterNotification(String paramString, boolean paramBoolean) {
        if (!paramBoolean) {
            logSetterNotification(paramString, "Debug logging", Boolean.valueOf(paramBoolean));
        }
        enableLogging(paramBoolean);
        if (paramBoolean) {
            logSetterNotification(paramString, "Debug logging", Boolean.valueOf(paramBoolean));
            d(paramString, "Amazon Mobile Ads API Version: %s", new Object[]{Version.getRawSDKVersion()});
        }
    }

    public static ILog getLogger() {
        return logger;
    }

    public static void i(String paramString1, String paramString2) {
        i(false, paramString1, paramString2);
    }

    public static void i(String paramString1, String paramString2, Object... paramVarArgs) {
        i(false, paramString1, paramString2, paramVarArgs);
    }

    public static void i(boolean paramBoolean, String paramString1, String paramString2) {
        if ((canLog()) || (paramBoolean)) {
            logger.i("AmazonMobileAds " + paramString1, paramString2);
        }
    }

    public static void i(boolean paramBoolean, String paramString1, String paramString2, Object... paramVarArgs) {
        if ((canLog()) || (paramBoolean)) {
            logger.i("AmazonMobileAds " + paramString1, paramString2, paramVarArgs);
        }
    }

    public static final void logSetterNotification(String paramString1, String paramString2, Object paramObject) {
        if (!canLog()) {
            return;
        }
        if ((paramObject instanceof Boolean)) {
            if (((Boolean) paramObject).booleanValue()) {
            }
            for (paramObject = "enabled"; ; paramObject = "disabled") {
                d(paramString1, "%s has been %s.", new Object[]{paramString2, paramObject});
                return;
            }
        }
        d(paramString1, "%s has been set: %s", new Object[]{paramString2, String.valueOf(paramObject)});
    }

    public static void setLogger(ILog paramILog) {
        logger = paramILog;
    }

    static Iterable<String> split(String paramString, int paramInt) {
        ArrayList localArrayList = new ArrayList();
        if ((paramString == null) || (paramString.length() == 0)) {
        }
        for (; ; ) {
            return localArrayList;
            int i = 0;
            while (i < paramString.length()) {
                localArrayList.add(paramString.substring(i, Math.min(paramString.length(), i + paramInt)));
                i += paramInt;
            }
        }
    }

    public static void v(String paramString1, String paramString2) {
        v(false, paramString1, paramString2);
    }

    public static void v(String paramString1, String paramString2, Object... paramVarArgs) {
        v(false, paramString1, paramString2, paramVarArgs);
    }

    public static void v(boolean paramBoolean, String paramString1, String paramString2) {
        if ((canLog()) || (paramBoolean)) {
            logger.v("AmazonMobileAds " + paramString1, paramString2);
        }
    }

    public static void v(boolean paramBoolean, String paramString1, String paramString2, Object... paramVarArgs) {
        if ((canLog()) || (paramBoolean)) {
            logger.v("AmazonMobileAds " + paramString1, paramString2, paramVarArgs);
        }
    }

    public static void w(String paramString1, String paramString2) {
        w(false, paramString1, paramString2);
    }

    public static void w(String paramString1, String paramString2, Object... paramVarArgs) {
        w(false, paramString1, paramString2, paramVarArgs);
    }

    public static void w(boolean paramBoolean, String paramString1, String paramString2) {
        if ((canLog()) || (paramBoolean)) {
            logger.w("AmazonMobileAds " + paramString1, paramString2);
        }
    }

    public static void w(boolean paramBoolean, String paramString1, String paramString2, Object... paramVarArgs) {
        if ((canLog()) || (paramBoolean)) {
            logger.w("AmazonMobileAds " + paramString1, paramString2, paramVarArgs);
        }
    }

    private static class LogcatLogger
            implements ILog {
        private static final int MAX_LENGTH = 1000;

        public void d(String paramString1, String paramString2) {
            paramString2 = Log.split(paramString2, 1000).iterator();
            while (paramString2.hasNext()) {
                android.util.Log.d(paramString1, (String) paramString2.next());
            }
        }

        public void d(String paramString1, String paramString2, Object... paramVarArgs) {
            d(paramString1, String.format(paramString2, paramVarArgs));
        }

        public void e(String paramString1, String paramString2) {
            paramString2 = Log.split(paramString2, 1000).iterator();
            while (paramString2.hasNext()) {
                android.util.Log.e(paramString1, (String) paramString2.next());
            }
        }

        public void e(String paramString1, String paramString2, Object... paramVarArgs) {
            e(paramString1, String.format(paramString2, paramVarArgs));
        }

        public void i(String paramString1, String paramString2) {
            paramString2 = Log.split(paramString2, 1000).iterator();
            while (paramString2.hasNext()) {
                android.util.Log.i(paramString1, (String) paramString2.next());
            }
        }

        public void i(String paramString1, String paramString2, Object... paramVarArgs) {
            i(paramString1, String.format(paramString2, paramVarArgs));
        }

        public void v(String paramString1, String paramString2) {
            paramString2 = Log.split(paramString2, 1000).iterator();
            while (paramString2.hasNext()) {
                android.util.Log.v(paramString1, (String) paramString2.next());
            }
        }

        public void v(String paramString1, String paramString2, Object... paramVarArgs) {
            v(paramString1, String.format(paramString2, paramVarArgs));
        }

        public void w(String paramString1, String paramString2) {
            paramString2 = Log.split(paramString2, 1000).iterator();
            while (paramString2.hasNext()) {
                android.util.Log.w(paramString1, (String) paramString2.next());
            }
        }

        public void w(String paramString1, String paramString2, Object... paramVarArgs) {
            w(paramString1, String.format(paramString2, paramVarArgs));
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/amazon/device/ads/Log.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */