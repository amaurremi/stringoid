package com.mopub.common.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import com.mopub.common.logging.MoPubLog;

import java.util.List;

public class IntentUtils {
    private static boolean a(String paramString) {
        if (paramString == null) {
        }
        do {
            return false;
            Object localObject = Uri.parse(paramString);
            paramString = ((Uri) localObject).getScheme();
            localObject = ((Uri) localObject).getHost();
            if (("play.google.com".equals(localObject)) || ("market.android.com".equals(localObject))) {
                return true;
            }
        } while (!"market".equals(paramString));
        return true;
    }

    public static boolean canHandleApplicationUrl(Context paramContext, String paramString) {
        return canHandleApplicationUrl(paramContext, paramString, true);
    }

    public static boolean canHandleApplicationUrl(Context paramContext, String paramString, boolean paramBoolean) {
        if (!deviceCanHandleIntent(paramContext, new Intent("android.intent.action.VIEW", Uri.parse(paramString)))) {
            if (paramBoolean) {
                MoPubLog.w("Could not handle application specific action: " + paramString + ". " + "You may be running in the emulator or another device which does not " + "have the required application.");
            }
            return false;
        }
        return true;
    }

    public static boolean canHandleTwitterUrl(Context paramContext) {
        return canHandleApplicationUrl(paramContext, "twitter://timeline", false);
    }

    public static boolean deviceCanHandleIntent(Context paramContext, Intent paramIntent) {
        boolean bool1 = false;
        try {
            boolean bool2 = paramContext.getPackageManager().queryIntentActivities(paramIntent, 0).isEmpty();
            if (!bool2) {
                bool1 = true;
            }
            return bool1;
        } catch (NullPointerException paramContext) {
        }
        return false;
    }

    public static Intent getStartActivityIntent(Context paramContext, Class paramClass, Bundle paramBundle) {
        paramClass = new Intent(paramContext, paramClass);
        if (!(paramContext instanceof Activity)) {
            paramClass.addFlags(268435456);
        }
        if (paramBundle != null) {
            paramClass.putExtras(paramBundle);
        }
        return paramClass;
    }

    public static boolean isDeepLink(String paramString) {
        return (a(paramString)) || (!isHttpUrl(paramString));
    }

    public static boolean isHttpUrl(String paramString) {
        if (paramString == null) {
        }
        do {
            return false;
            paramString = Uri.parse(paramString).getScheme();
        } while ((!"http".equals(paramString)) && (!"https".equals(paramString)));
        return true;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/common/util/IntentUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */