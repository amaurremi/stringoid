package com.quoord.tapatalkpro.util;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.common.GooglePlayServicesRepairableException;

public class GoogleAdsTool {
    public static String getIdThread(Context paramContext) {
        Object localObject = null;
        try {
            paramContext = AdvertisingIdClient.getAdvertisingIdInfo(paramContext);
            if (paramContext != null) {
                return paramContext.getId();
            }
        } catch (IllegalStateException paramContext) {
            for (; ; ) {
                paramContext.printStackTrace();
                paramContext = (Context) localObject;
            }
        } catch (GooglePlayServicesRepairableException paramContext) {
            for (; ; ) {
                paramContext.printStackTrace();
                paramContext = (Context) localObject;
            }
            return null;
        } catch (Exception paramContext) {
            for (; ; ) {
                paramContext = (Context) localObject;
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/util/GoogleAdsTool.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */