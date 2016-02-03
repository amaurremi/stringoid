package com.google.android.gms.analytics;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;

class g
        implements m {
    private static Object sf = new Object();
    private static g ss;
    protected String so;
    protected String sp;
    protected String sq;
    protected String sr;

    protected g() {
    }

    private g(Context paramContext) {
        PackageManager localPackageManager = paramContext.getPackageManager();
        this.sq = paramContext.getPackageName();
        this.sr = localPackageManager.getInstallerPackageName(this.sq);
        String str = this.sq;
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
                aa.w("Error retrieving package info: appName set to " + (String) localObject1);
                paramContext = (Context) localObject2;
            }
        }
        this.so = ((String) localObject1);
        this.sp = paramContext;
    }

    public static g ca() {
        return ss;
    }

    public static void n(Context paramContext) {
        synchronized (sf) {
            if (ss == null) {
                ss = new g(paramContext);
            }
            return;
        }
    }

    public boolean C(String paramString) {
        return ("&an".equals(paramString)) || ("&av".equals(paramString)) || ("&aid".equals(paramString)) || ("&aiid".equals(paramString));
    }

    public String getValue(String paramString) {
        if (paramString == null) {
        }
        do {
            return null;
            if (paramString.equals("&an")) {
                return this.so;
            }
            if (paramString.equals("&av")) {
                return this.sp;
            }
            if (paramString.equals("&aid")) {
                return this.sq;
            }
        } while (!paramString.equals("&aiid"));
        return this.sr;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/analytics/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */