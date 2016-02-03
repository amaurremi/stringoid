package com.inmobi.monetization.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build.VERSION;
import android.util.Log;
import com.inmobi.androidsdk.IMBrowserActivity;

import java.util.Iterator;
import java.util.List;

class h {
    private static boolean a = false;

    public static Activity a(Activity paramActivity) {
        while (paramActivity.getParent() != null) {
            paramActivity = paramActivity.getParent();
        }
        return paramActivity;
    }

    public static void a(Context paramContext) {
        if (paramContext.checkCallingOrSelfPermission("android.permission.INTERNET") != 0) {
            Log.e("[InMobi]-[Monetization]", "App does not have INTERNET permissions. Please provide INTERNET permissions");
            throw new InvalidManifestConfigException(-1);
        }
        if (paramContext.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") != 0) {
            Log.e("[InMobi]-[Monetization]", "App does not have ACCESS_NETWORK_STATE permissions. Please provide ACCESS_NETWORK_STATE permissions");
            throw new InvalidManifestConfigException(-9);
        }
        Iterator localIterator = paramContext.getPackageManager().queryIntentActivities(new Intent(paramContext, IMBrowserActivity.class), 65536).iterator();
        do {
            if (!localIterator.hasNext()) {
                break;
            }
            paramContext = (ResolveInfo) localIterator.next();
        } while (!paramContext.activityInfo.name.contentEquals("com.inmobi.androidsdk.IMBrowserActivity"));
        for (; ; ) {
            if (paramContext == null) {
                Log.e("[InMobi]-[Monetization]", "IMBrowserActivity not declared in the manifest. Please declare it in the app manifest");
                throw new InvalidManifestConfigException(-2);
            }
            int i = paramContext.activityInfo.configChanges;
            if (i == 0) {
                Log.e("[InMobi]-[Monetization]", "IMBrowserActivity in the manifest does not have android:configChanges attributes.Please add android:configChanges=keyboardHidden|orientation|keyboard|screenSize|smallestScreenSize to IMBrowserActivity in the app manifest");
                throw new InvalidManifestConfigException(-3);
            }
            if ((i & 0x10) == 0) {
                Log.e("[InMobi]-[Monetization]", "Missing Config keyboard from android:configChangesof IMBRowserActivity");
                throw new InvalidManifestConfigException(-4);
            }
            if ((i & 0x20) == 0) {
                Log.e("[InMobi]-[Monetization]", "Missing Config keyboardHidden from android:configChangesof IMBRowserActivity");
                throw new InvalidManifestConfigException(-5);
            }
            if ((i & 0x80) == 0) {
                Log.e("[InMobi]-[Monetization]", "Missing Config orientation from android:configChangesof IMBRowserActivity");
                throw new InvalidManifestConfigException(-6);
            }
            if (Build.VERSION.SDK_INT >= 13) {
                if ((i & 0x400) == 0) {
                    Log.e("[InMobi]-[Monetization]", "Missing Config screenSize from android:configChangesof IMBRowserActivity");
                    throw new InvalidManifestConfigException(-7);
                }
                if ((i & 0x800) == 0) {
                    Log.e("[InMobi]-[Monetization]", "Missing Config smallestScreenSize from android:configChanges of IMBRowserActivity");
                    throw new InvalidManifestConfigException(-8);
                }
            }
            return;
            paramContext = null;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/monetization/internal/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */