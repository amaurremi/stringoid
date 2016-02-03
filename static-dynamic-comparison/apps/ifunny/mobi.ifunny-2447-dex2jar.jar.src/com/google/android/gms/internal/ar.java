package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.b.a;
import com.google.android.gms.b.d;
import com.google.android.gms.b.e;
import com.google.android.gms.b.f;
import com.google.android.gms.common.GooglePlayServicesUtil;

@ii
public final class ar
        extends e<bf> {
    private static final ar a = new ar();

    private ar() {
        super("com.google.android.gms.ads.AdManagerCreatorImpl");
    }

    public static bc a(Context paramContext, ay paramay, String paramString, ds paramds) {
        Object localObject;
        if (GooglePlayServicesUtil.isGooglePlayServicesAvailable(paramContext) == 0) {
            bc localbc = a.b(paramContext, paramay, paramString, paramds);
            localObject = localbc;
            if (localbc != null) {
            }
        } else {
            mx.a("Using AdManager from the client jar.");
            localObject = new te(paramContext, paramay, paramString, paramds, new gt(6111000, 6111000, true));
        }
        return (bc) localObject;
    }

    private bc b(Context paramContext, ay paramay, String paramString, ds paramds) {
        try {
            a locala = d.a(paramContext);
            paramContext = bd.a(((bf) a(paramContext)).a(locala, paramay, paramString, paramds, 6111000));
            return paramContext;
        } catch (RemoteException paramContext) {
            mx.d("Could not create remote AdManager.", paramContext);
            return null;
        } catch (f paramContext) {
            mx.d("Could not create remote AdManager.", paramContext);
        }
        return null;
    }

    protected bf b(IBinder paramIBinder) {
        return bg.a(paramIBinder);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/ar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */