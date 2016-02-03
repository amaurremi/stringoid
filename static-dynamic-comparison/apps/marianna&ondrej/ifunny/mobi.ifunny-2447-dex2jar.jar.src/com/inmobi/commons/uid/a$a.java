package com.inmobi.commons.uid;

import android.content.Context;
import com.inmobi.commons.internal.FileOperations;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;

import java.lang.reflect.Method;

final class a$a
        implements Runnable {
    public void run() {
        try {
            Object localObject2 = Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient");
            Object localObject1 = Class.forName("com.google.android.gms.ads.identifier.a");
            localObject2 = ((Class) localObject2).getDeclaredMethod("getAdvertisingIdInfo", new Class[]{Context.class}).invoke(null, new Object[]{InternalSDKUtil.getContext()});
            String str = (String) ((Class) localObject1).getDeclaredMethod("getId", (Class[]) null).invoke(localObject2, (Object[]) null);
            a.j().a(str);
            FileOperations.setPreferences(InternalSDKUtil.getContext(), "impref", "gpid", str);
            localObject1 = (Boolean) ((Class) localObject1).getDeclaredMethod("isLimitAdTrackingEnabled", (Class[]) null).invoke(localObject2, (Object[]) null);
            a.j().a(((Boolean) localObject1).booleanValue());
            FileOperations.setPreferences(InternalSDKUtil.getContext(), "impref", "limitadtrck", ((Boolean) localObject1).booleanValue());
            return;
        } catch (Exception localException) {
            Log.internal("[InMobi]-4.5.1", "Exception getting advertiser id", localException);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/commons/uid/a$a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */