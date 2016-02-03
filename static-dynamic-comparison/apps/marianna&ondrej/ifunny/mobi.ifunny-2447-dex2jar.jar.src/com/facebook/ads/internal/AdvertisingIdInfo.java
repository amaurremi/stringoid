package com.facebook.ads.internal;

import android.content.Context;
import android.os.Looper;

import java.lang.reflect.Method;

public class AdvertisingIdInfo {
    private static final int CONNECTION_RESULT_SUCCESS = 0;
    private final String id;
    private final boolean limitAdTrackingEnabled;

    private AdvertisingIdInfo(String paramString, boolean paramBoolean) {
        this.id = paramString;
        this.limitAdTrackingEnabled = paramBoolean;
    }

    public static AdvertisingIdInfo getAdvertisingIdInfo(Context paramContext) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException("Cannot get advertising info on main thread.");
        }
        Object localObject = AdUtilities.getMethod("com.google.android.gms.common.GooglePlayServicesUtil", "isGooglePlayServicesAvailable", new Class[]{Context.class});
        if (localObject == null) {
            return null;
        }
        localObject = AdUtilities.invokeMethod(null, (Method) localObject, new Object[]{paramContext});
        if ((localObject == null) || (((Integer) localObject).intValue() != 0)) {
            return null;
        }
        localObject = AdUtilities.getMethod("com.google.android.gms.ads.identifier.AdvertisingIdClient", "getAdvertisingIdInfo", new Class[]{Context.class});
        if (localObject == null) {
            return null;
        }
        paramContext = AdUtilities.invokeMethod(null, (Method) localObject, new Object[]{paramContext});
        if (paramContext == null) {
            return null;
        }
        localObject = AdUtilities.getMethod(paramContext.getClass(), "getId", new Class[0]);
        Method localMethod = AdUtilities.getMethod(paramContext.getClass(), "isLimitAdTrackingEnabled", new Class[0]);
        if ((localObject == null) || (localMethod == null)) {
            return null;
        }
        return new AdvertisingIdInfo((String) AdUtilities.invokeMethod(paramContext, (Method) localObject, new Object[0]), ((Boolean) AdUtilities.invokeMethod(paramContext, localMethod, new Object[0])).booleanValue());
    }

    public String getId() {
        return this.id;
    }

    public boolean isLimitAdTrackingEnabled() {
        return this.limitAdTrackingEnabled;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/ads/internal/AdvertisingIdInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */