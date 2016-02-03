package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.d;
import com.google.android.gms.dynamic.e;
import com.google.android.gms.dynamic.g;
import com.google.android.gms.dynamic.g.a;

public final class ag
        extends g<aq> {
    private static final ag lG = new ag();

    private ag() {
        super("com.google.android.gms.ads.AdManagerCreatorImpl");
    }

    public static ap a(Context paramContext, ak paramak, String paramString, bp parambp) {
        Object localObject;
        if (GooglePlayServicesUtil.isGooglePlayServicesAvailable(paramContext) == 0) {
            ap localap = lG.b(paramContext, paramak, paramString, parambp);
            localObject = localap;
            if (localap != null) {
            }
        } else {
            dw.v("Using AdManager from the client jar.");
            localObject = new v(paramContext, paramak, paramString, parambp, new dx(4452000, 4452000, true));
        }
        return (ap) localObject;
    }

    private ap b(Context paramContext, ak paramak, String paramString, bp parambp) {
        try {
            d locald = e.h(paramContext);
            paramContext = ap.a.f(((aq) z(paramContext)).a(locald, paramak, paramString, parambp, 4452000));
            return paramContext;
        } catch (RemoteException paramContext) {
            dw.c("Could not create remote AdManager.", paramContext);
            return null;
        } catch (g.a paramContext) {
            dw.c("Could not create remote AdManager.", paramContext);
        }
        return null;
    }

    protected aq c(IBinder paramIBinder) {
        return aq.a.g(paramIBinder);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/internal/ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */