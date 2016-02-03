package com.google.android.youtube.player.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.content.res.Resources;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Build.VERSION;

public final class z {
    private static final Uri a = Uri.parse("http://play.google.com/store/apps/details");

    public static int a(Context paramContext1, Context paramContext2) {
        int i = 0;
        if (paramContext2 != null) {
            i = paramContext2.getResources().getIdentifier("clientTheme", "style", a(paramContext1));
        }
        int j = i;
        if (i == 0) {
            if (Build.VERSION.SDK_INT >= 14) {
                j = 16974120;
            }
        } else {
            return j;
        }
        if (Build.VERSION.SDK_INT >= 11) {
            return 16973931;
        }
        return 16973829;
    }

    public static Intent a(String paramString) {
        paramString = Uri.fromParts("package", paramString, null);
        Intent localIntent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        localIntent.setData(paramString);
        return localIntent;
    }

    public static String a(Context paramContext) {
        Object localObject = new Intent("com.google.android.youtube.api.service.START");
        paramContext = paramContext.getPackageManager();
        localObject = paramContext.resolveService((Intent) localObject, 0);
        if ((localObject != null) && (((ResolveInfo) localObject).serviceInfo != null) && (((ResolveInfo) localObject).serviceInfo.packageName != null)) {
            return ((ResolveInfo) localObject).serviceInfo.packageName;
        }
        if (paramContext.hasSystemFeature("com.google.android.tv")) {
            return "com.google.android.youtube.googletv";
        }
        return "com.google.android.youtube";
    }

    public static boolean a(Context paramContext, String paramString) {
        try {
            Resources localResources = paramContext.getPackageManager().getResourcesForApplication(paramString);
            paramContext = paramString;
            if (paramString.equals("com.google.android.youtube.googletvdev")) {
                paramContext = "com.google.android.youtube.googletv";
            }
            int i = localResources.getIdentifier("youtube_api_version_code", "integer", paramContext);
            if (i == 0) {
            }
            while (1000 > localResources.getInteger(i)) {
                return true;
            }
            return false;
        } catch (PackageManager.NameNotFoundException paramContext) {
        }
        return true;
    }

    public static boolean a(PackageManager paramPackageManager) {
        return paramPackageManager.hasSystemFeature("com.google.android.tv");
    }

    public static Context b(Context paramContext) {
        try {
            paramContext = paramContext.createPackageContext(a(paramContext), 3);
            return paramContext;
        } catch (PackageManager.NameNotFoundException paramContext) {
        }
        return null;
    }

    public static Intent b(String paramString) {
        Intent localIntent = new Intent("android.intent.action.VIEW");
        localIntent.setData(a.buildUpon().appendQueryParameter("id", paramString).build());
        localIntent.setPackage("com.android.vending");
        localIntent.addFlags(524288);
        return localIntent;
    }

    public static int c(Context paramContext) {
        return a(paramContext, b(paramContext));
    }

    public static String d(Context paramContext) {
        try {
            paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionName;
            return paramContext;
        } catch (PackageManager.NameNotFoundException paramContext) {
            throw new IllegalStateException("Cannot retrieve calling Context's PackageInfo", paramContext);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/youtube/player/internal/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */