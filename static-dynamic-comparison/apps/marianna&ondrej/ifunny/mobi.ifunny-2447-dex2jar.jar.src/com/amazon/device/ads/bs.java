package com.amazon.device.ads;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;

import java.util.HashSet;

class bs {
    public static final String a = bs.class.getSimpleName();
    private static final HashSet<String> b = new HashSet();

    static {
        b.add("com.amazon.device.ads.AdActivity");
    }

    public static double a(double paramDouble) {
        if (hu.a(19)) {
            paramDouble = 1.0D;
        }
        return paramDouble;
    }

    public static void a(ah paramah) {
        Object localObject = paramah.k();
        if ("Wifi".equals(localObject)) {
            paramah.n().a(eb.U);
        }
        for (; ; ) {
            localObject = dn.i().b();
            if (((cz) localObject).o() != null) {
                paramah.n().a(eb.V, ((cz) localObject).o());
            }
            return;
            paramah.n().a(eb.W, (String) localObject);
        }
    }

    public static boolean a(Context paramContext) {
        boolean bool = true;
        HashSet localHashSet = new HashSet();
        try {
            if (hu.a(8)) {
                String str = cf.a(paramContext);
                paramContext = paramContext.getPackageManager().getPackageArchiveInfo(str, 1).activities;
                int j = paramContext.length;
                int i = 0;
                while (i < j) {
                    localHashSet.add(paramContext[i].name);
                    i += 1;
                }
                bool = localHashSet.containsAll(b);
            }
            return bool;
        } catch (Exception paramContext) {
        }
        return true;
    }

    public static boolean a(String paramString, Context paramContext) {
        String str;
        if (paramString != null) {
            str = paramString;
            if (!paramString.equals("")) {
            }
        } else {
            str = "about:blank";
        }
        dv.a(a, "Launch Intent: %s", new Object[]{str});
        paramString = new Intent("android.intent.action.VIEW", Uri.parse(str));
        paramString.setFlags(268435456);
        try {
            paramContext.startActivity(paramString);
            return true;
        } catch (ActivityNotFoundException paramContext) {
            paramContext = paramString.getAction();
            str = a;
            if (!paramContext.startsWith("market://")) {
            }
        }
        for (paramString = "market"; ; paramString = "intent") {
            dv.d(str, "Could not handle %s action: %s", new Object[]{paramString, paramContext});
            return false;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/amazon/device/ads/bs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */