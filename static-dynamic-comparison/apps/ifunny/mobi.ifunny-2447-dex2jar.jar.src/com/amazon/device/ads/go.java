package com.amazon.device.ads;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;

class go {
    private static final String a = go.class.getSimpleName();
    private static go b = new go();
    private boolean c = false;

    static go a() {
        return b;
    }

    private static final boolean b() {
        dv.b(a, "App permissions were not read.");
        return true;
    }

    public final boolean a(Context paramContext) {
        return a(paramContext, null);
    }

    public final boolean a(Context paramContext, String paramString) {
        if (this.c) {
            return true;
        }
        if (Build.VERSION.SDK_INT < 8) {
            return b();
        }
        String str = cf.a(paramContext);
        if (str == null) {
            return b();
        }
        paramContext = paramContext.getPackageManager();
        if (paramContext == null) {
            return b();
        }
        paramContext = paramContext.getPackageArchiveInfo(str, 4096);
        if (paramContext == null) {
            return b();
        }
        paramContext = paramContext.requestedPermissions;
        if (paramContext == null) {
            return b();
        }
        int j = paramContext.length;
        int i = 0;
        while (i < j) {
            if (paramContext[i].equals("android.permission.INTERNET")) {
                this.c = true;
                return true;
            }
            i += 1;
        }
        if (paramString != null) {
            dv.c(paramString, "Network task cannot commence because the INTERNET permission is missing from the app's manifest.");
        }
        return false;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/amazon/device/ads/go.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */