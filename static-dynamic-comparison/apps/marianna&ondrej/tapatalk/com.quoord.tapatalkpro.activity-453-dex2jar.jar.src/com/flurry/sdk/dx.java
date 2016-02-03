package com.flurry.sdk;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;

public final class dx {
    private static final String a = dx.class.getSimpleName();

    public static PackageInfo a(Context paramContext) {
        PackageInfo localPackageInfo = null;
        if (paramContext != null) {
        }
        try {
            localPackageInfo = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 20815);
            return localPackageInfo;
        } catch (PackageManager.NameNotFoundException localNameNotFoundException) {
            eo.a(a, "Cannot find package info for package: " + paramContext.getPackageName());
        }
        return null;
    }

    public static ApplicationInfo b(Context paramContext) {
        ApplicationInfo localApplicationInfo = null;
        if (paramContext != null) {
        }
        try {
            localApplicationInfo = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128);
            return localApplicationInfo;
        } catch (PackageManager.NameNotFoundException localNameNotFoundException) {
            eo.a(a, "Cannot find application info for package: " + paramContext.getPackageName());
        }
        return null;
    }

    public static String c(Context paramContext) {
        paramContext = a(paramContext);
        if ((paramContext != null) && (paramContext.packageName != null)) {
            return paramContext.packageName;
        }
        return "";
    }

    public static Bundle d(Context paramContext) {
        paramContext = b(paramContext);
        if ((paramContext != null) && (paramContext.metaData != null)) {
            return paramContext.metaData;
        }
        return Bundle.EMPTY;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/dx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */