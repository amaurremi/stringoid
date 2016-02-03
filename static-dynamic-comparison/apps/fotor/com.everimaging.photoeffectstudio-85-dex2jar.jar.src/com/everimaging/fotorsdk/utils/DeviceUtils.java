package com.everimaging.fotorsdk.utils;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.util.Log;
import com.everimaging.fotorsdk.log.FotorLoggerFactory;

public class DeviceUtils {
    public static final double INCHES_TABLET = 6.5D;
    private static final String TAG = DeviceUtils.class.getSimpleName();
    private static int density;
    private static int screenHeight;
    private static int screenWidth;

    public static int getDensity() {
        return density;
    }

    public static String getDevice() {
        return Build.MODEL;
    }

    public static String getOS() {
        return "Android";
    }

    public static String getOSVersion() {
        return Build.VERSION.RELEASE;
    }

    public static String getResolution() {
        return screenWidth + "x" + screenHeight;
    }

    public static int getScreenHeight() {
        return screenHeight;
    }

    public static double getScreenInches(Context paramContext) {
        paramContext = paramContext.getResources().getDisplayMetrics();
        double d1 = paramContext.widthPixels / paramContext.densityDpi;
        double d2 = paramContext.heightPixels / paramContext.densityDpi;
        return Math.sqrt(Math.pow(d1, 2.0D) + Math.pow(d2, 2.0D));
    }

    public static int getScreenWidth() {
        return screenWidth;
    }

    public static void init(Context paramContext) {
        paramContext = paramContext.getResources().getDisplayMetrics();
        screenWidth = paramContext.widthPixels;
        screenHeight = paramContext.heightPixels;
        density = paramContext.densityDpi;
    }

    public static boolean isTablet(Context paramContext) {
        double d = getScreenInches(paramContext);
        if (FotorLoggerFactory.a) {
            Log.d(TAG, "screen size: " + d);
        }
        return d >= 6.5D;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/utils/DeviceUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */