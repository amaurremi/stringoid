package net.hockeyapp.android;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.Log;

import java.io.File;

public class a {
    public static String a = null;
    public static String b = null;
    public static String c = null;
    public static String d = null;
    public static String e = null;
    public static String f = null;
    public static String g = null;

    private static int a(Context paramContext, PackageManager paramPackageManager) {
        int i = 0;
        try {
            paramContext = paramPackageManager.getApplicationInfo(paramContext.getPackageName(), 128).metaData;
            if (paramContext != null) {
                i = paramContext.getInt("buildNumber", 0);
            }
            return i;
        } catch (Exception paramContext) {
            Log.e("HockeyApp", "Exception thrown when accessing the application info:");
            paramContext.printStackTrace();
        }
        return 0;
    }

    public static void a(Context paramContext) {
        e = Build.VERSION.RELEASE;
        f = Build.MODEL;
        g = Build.MANUFACTURER;
        b(paramContext);
        c(paramContext);
    }

    private static void b(Context paramContext) {
        if (paramContext != null) {
        }
        try {
            paramContext = paramContext.getFilesDir();
            if (paramContext != null) {
                a = paramContext.getAbsolutePath();
            }
            return;
        } catch (Exception paramContext) {
            Log.e("HockeyApp", "Exception thrown when accessing the files dir:");
            paramContext.printStackTrace();
        }
    }

    private static void c(Context paramContext) {
        if (paramContext != null) {
        }
        try {
            PackageManager localPackageManager = paramContext.getPackageManager();
            PackageInfo localPackageInfo = localPackageManager.getPackageInfo(paramContext.getPackageName(), 0);
            d = localPackageInfo.packageName;
            b = "" + localPackageInfo.versionCode;
            c = localPackageInfo.versionName;
            int i = a(paramContext, localPackageManager);
            if ((i != 0) && (i > localPackageInfo.versionCode)) {
                b = "" + i;
            }
            return;
        } catch (Exception paramContext) {
            Log.e("HockeyApp", "Exception thrown when accessing the package info:");
            paramContext.printStackTrace();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/net/hockeyapp/android/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */