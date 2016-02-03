package com.umeng.analytics;

import android.content.Context;
import com.umeng.common.b;

public class AnalyticsConfig {
    public static boolean ACTIVITY_DURATION_OPEN;
    public static boolean CATCH_EXCEPTION = true;
    public static boolean COMPRESS_DATA;
    public static boolean ENABLE_MEMORY_BUFFER;
    public static String GPU_RENDERER;
    public static String GPU_VENDER;
    private static String a = null;
    private static String b = null;
    private static double[] c;
    public static long kContinueSessionMillis = 30000L;
    public static int mVerticalType;
    public static String mWrapperType = null;
    public static String mWrapperVersion = null;
    public static int sAge;
    public static Gender sGender;
    public static String sId;
    public static String sSource;

    static {
        GPU_VENDER = "";
        GPU_RENDERER = "";
        c = null;
        ACTIVITY_DURATION_OPEN = true;
        COMPRESS_DATA = true;
        ENABLE_MEMORY_BUFFER = true;
    }

    public static String getAppkey(Context paramContext) {
        if (a == null) {
            a = b.o(paramContext);
        }
        return a;
    }

    public static String getChannel(Context paramContext) {
        if (b == null) {
            b = b.t(paramContext);
        }
        return b;
    }

    public static double[] getLocation() {
        return c;
    }

    public static void setAppkey(String paramString) {
        a = paramString;
    }

    public static void setChannel(String paramString) {
        b = paramString;
    }

    public static void setLocation(double paramDouble1, double paramDouble2) {
        if (c == null) {
            c = new double[2];
        }
        c[0] = paramDouble1;
        c[1] = paramDouble2;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/umeng/analytics/AnalyticsConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */