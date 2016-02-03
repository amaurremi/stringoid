package com.inmobi.commons.uid;

import android.content.Context;
import android.provider.Settings.Secure;
import android.provider.Settings.System;
import com.inmobi.commons.internal.Log;

public class PlatformId {
    public static String getAndroidId(Context paramContext) {
        Object localObject1 = null;
        try {
            localObject2 = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
            localObject1 = localObject2;
        } catch (Exception localException) {
            for (; ; ) {
                try {
                    Object localObject2 = Settings.System.getString(paramContext.getContentResolver(), "android_id");
                    return (String) localObject2;
                } catch (Exception paramContext) {
                    Log.internal("commons", "Unable to retrieve android id.");
                }
                localException = localException;
                Log.internal("commons", "Unable to retrieve android id.");
            }
        }
        localObject2 = localObject1;
        if (localObject1 == null) {
        }
        return (String) localObject1;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/commons/uid/PlatformId.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */