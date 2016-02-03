package com.mopub.mobileads.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.mopub.common.logging.MoPubLog;

public class Utils {
    public static boolean executeIntent(Context paramContext, Intent paramIntent, String paramString) {
        try {
            if (!(paramContext instanceof Activity)) {
                paramIntent.addFlags(268435456);
            }
            paramContext.startActivity(paramIntent);
            return true;
        } catch (Exception paramContext) {
            if (paramString == null) {
            }
        }
        for (; ; ) {
            MoPubLog.d(paramString);
            return false;
            paramString = "Unable to start intent.";
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/mobileads/util/Utils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */