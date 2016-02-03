package com.tapstream.sdk;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import java.lang.reflect.Method;

public class AdvertisingIdFetcher
        implements Runnable {
    private static final String UUID_KEY = "TapstreamSDKUUID";
    private Application app;

    public AdvertisingIdFetcher(Application paramApplication) {
        this.app = paramApplication;
    }

    public void run() {
        try {
            Object localObject2 = Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient");
            Object localObject1 = Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient$Info");
            Object localObject3 = ((Class) localObject2).getMethod("getAdvertisingIdInfo", new Class[]{Context.class}).invoke(localObject2, new Object[]{this.app});
            localObject2 = (String) ((Class) localObject1).getMethod("getId", new Class[0]).invoke(localObject3, new Object[0]);
            boolean bool = ((Boolean) ((Class) localObject1).getMethod("isLimitAdTrackingEnabled", new Class[0]).invoke(localObject3, new Object[0])).booleanValue();
            localObject1 = this.app.getSharedPreferences("TapstreamSDKUUID", 0).edit();
            ((SharedPreferences.Editor) localObject1).putString("advertisingId", (String) localObject2);
            ((SharedPreferences.Editor) localObject1).putBoolean("limitAdTracking", bool);
            ((SharedPreferences.Editor) localObject1).commit();
            return;
        } catch (Exception localException) {
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/tapstream/sdk/AdvertisingIdFetcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */