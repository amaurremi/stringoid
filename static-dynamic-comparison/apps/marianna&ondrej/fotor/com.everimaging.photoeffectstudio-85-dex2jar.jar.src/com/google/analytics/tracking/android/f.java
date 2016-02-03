package com.google.analytics.tracking.android;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;

class f
        implements j {
    private static f e;
    private static Object f = new Object();
    protected String a;
    protected String b;
    protected String c;
    protected String d;

    protected f() {
    }

    private f(Context paramContext) {
        PackageManager localPackageManager = paramContext.getPackageManager();
        this.c = paramContext.getPackageName();
        this.d = localPackageManager.getInstallerPackageName(this.c);
        String str = this.c;
        localObject2 = null;
        localObject1 = str;
        try {
            PackageInfo localPackageInfo = localPackageManager.getPackageInfo(paramContext.getPackageName(), 0);
            paramContext = (Context) localObject2;
            localObject1 = str;
            if (localPackageInfo != null) {
                localObject1 = str;
                paramContext = localPackageManager.getApplicationLabel(localPackageInfo.applicationInfo).toString();
                localObject1 = paramContext;
                str = localPackageInfo.versionName;
                localObject1 = paramContext;
                paramContext = str;
            }
        } catch (PackageManager.NameNotFoundException paramContext) {
            for (; ; ) {
                v.a("Error retrieving package info: appName set to " + (String) localObject1);
                paramContext = (Context) localObject2;
            }
        }
        this.a = ((String) localObject1);
        this.b = paramContext;
    }

    public static f a() {
        return e;
    }

    public static void a(Context paramContext) {
        synchronized (f) {
            if (e == null) {
                e = new f(paramContext);
            }
            return;
        }
    }

    public String a(String paramString) {
        if (paramString == null) {
        }
        do {
            return null;
            if (paramString.equals("&an")) {
                return this.a;
            }
            if (paramString.equals("&av")) {
                return this.b;
            }
            if (paramString.equals("&aid")) {
                return this.c;
            }
        } while (!paramString.equals("&aiid"));
        return this.d;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/google/analytics/tracking/android/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */