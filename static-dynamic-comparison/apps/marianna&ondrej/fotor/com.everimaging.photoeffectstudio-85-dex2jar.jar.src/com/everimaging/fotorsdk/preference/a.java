package com.everimaging.fotorsdk.preference;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class a {
    public static String a(Context paramContext) {
        return paramContext.getSharedPreferences("FotorSDK_Pref", 0).getString("FotorSDK_Version", "");
    }

    public static void a(Context paramContext, String paramString) {
        paramContext = paramContext.getSharedPreferences("FotorSDK_Pref", 0).edit();
        paramContext.putString("FotorSDK_Version", paramString);
        paramContext.commit();
    }

    public static void a(Context paramContext, String paramString, boolean paramBoolean) {
        paramContext = paramContext.getSharedPreferences("FotorSDK_Pref", 0).edit();
        paramContext.putBoolean(paramString, paramBoolean);
        paramContext.commit();
    }

    public static void a(Context paramContext, boolean paramBoolean) {
        paramContext = paramContext.getSharedPreferences("FotorSDK_Pref", 0).edit();
        paramContext.putBoolean("FotorSDK_First_Launch_Home", paramBoolean);
        paramContext.commit();
    }

    public static void b(Context paramContext, boolean paramBoolean) {
        paramContext = paramContext.getSharedPreferences("FotorSDK_Pref", 0).edit();
        paramContext.putBoolean("FotorSDK_First_Launch_Crop", paramBoolean);
        paramContext.commit();
    }

    public static boolean b(Context paramContext) {
        return paramContext.getSharedPreferences("FotorSDK_Pref", 0).getBoolean("FotorSDK_First_Launch_Home", true);
    }

    public static boolean b(Context paramContext, String paramString) {
        return paramContext.getSharedPreferences("FotorSDK_Pref", 0).getBoolean(paramString, true);
    }

    public static void c(Context paramContext, boolean paramBoolean) {
        paramContext = paramContext.getSharedPreferences("FotorSDK_Pref", 0).edit();
        paramContext.putBoolean("FotorSDK_First_Launch_Tilt_Shift", paramBoolean);
        paramContext.commit();
    }

    public static boolean c(Context paramContext) {
        return paramContext.getSharedPreferences("FotorSDK_Pref", 0).getBoolean("FotorSDK_First_Launch_Crop", true);
    }

    public static void d(Context paramContext, boolean paramBoolean) {
        paramContext = paramContext.getSharedPreferences("FotorSDK_Pref", 0).edit();
        paramContext.putBoolean("FotorSDK_First_Launch_Pixelate", paramBoolean);
        paramContext.commit();
    }

    public static boolean d(Context paramContext) {
        return paramContext.getSharedPreferences("FotorSDK_Pref", 0).getBoolean("FotorSDK_First_Launch_Tilt_Shift", true);
    }

    public static void e(Context paramContext, boolean paramBoolean) {
        paramContext = paramContext.getSharedPreferences("FotorSDK_Pref", 0).edit();
        paramContext.putBoolean("FotorSDK_First_Tap_Effect", paramBoolean);
        paramContext.commit();
    }

    public static boolean e(Context paramContext) {
        return paramContext.getSharedPreferences("FotorSDK_Pref", 0).getBoolean("FotorSDK_First_Launch_Pixelate", true);
    }

    public static void f(Context paramContext, boolean paramBoolean) {
        paramContext = paramContext.getSharedPreferences("FotorSDK_Pref", 0).edit();
        paramContext.putBoolean("FotorSDK_First_Launch_Effect", paramBoolean);
        paramContext.commit();
    }

    public static boolean f(Context paramContext) {
        return paramContext.getSharedPreferences("FotorSDK_Pref", 0).getBoolean("FotorSDK_First_Tap_Effect", true);
    }

    public static void g(Context paramContext, boolean paramBoolean) {
        paramContext = paramContext.getSharedPreferences("FotorSDK_Pref", 0).edit();
        paramContext.putBoolean("FotorSDK_First_Launch_Frame", paramBoolean);
        paramContext.commit();
    }

    public static boolean g(Context paramContext) {
        return paramContext.getSharedPreferences("FotorSDK_Pref", 0).getBoolean("FotorSDK_First_Launch_Effect", true);
    }

    public static void h(Context paramContext, boolean paramBoolean) {
        paramContext = paramContext.getSharedPreferences("FotorSDK_Pref", 0).edit();
        paramContext.putBoolean("FotorSDK_First_Launch_Sticker", paramBoolean);
        paramContext.commit();
    }

    public static boolean h(Context paramContext) {
        return paramContext.getSharedPreferences("FotorSDK_Pref", 0).getBoolean("FotorSDK_First_Launch_Frame", true);
    }

    public static boolean i(Context paramContext) {
        return paramContext.getSharedPreferences("FotorSDK_Pref", 0).getBoolean("FotorSDK_First_Launch_Sticker", true);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/preference/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */