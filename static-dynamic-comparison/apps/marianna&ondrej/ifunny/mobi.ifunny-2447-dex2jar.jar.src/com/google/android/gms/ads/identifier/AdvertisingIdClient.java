package com.google.android.gms.ads.identifier;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.f;
import com.google.android.gms.common.internal.ag;
import com.google.android.gms.common.j;
import com.google.android.gms.internal.ta;
import com.google.android.gms.internal.tb;

import java.io.IOException;

public final class AdvertisingIdClient {
    j lk;
    ta ll;
    boolean lm;
    final Context mContext;

    public AdvertisingIdClient(Context paramContext) {
        ag.a(paramContext);
        this.mContext = paramContext;
        this.lm = false;
    }

    static ta a(Context paramContext, j paramj) {
        try {
            paramContext = tb.a(paramj.a());
            return paramContext;
        } catch (InterruptedException paramContext) {
            throw new IOException("Interrupted exception");
        }
    }

    public static a getAdvertisingIdInfo(Context paramContext) {
        paramContext = new AdvertisingIdClient(paramContext);
        try {
            paramContext.start();
            a locala = paramContext.W();
            return locala;
        } finally {
            paramContext.finish();
        }
    }

    static j i(Context paramContext) {
        try {
            paramContext.getPackageManager().getPackageInfo("com.android.vending", 0);
            j localj;
            Intent localIntent;
            throw new IOException("Connection failure");
        } catch (PackageManager.NameNotFoundException paramContext) {
            try {
                GooglePlayServicesUtil.D(paramContext);
                localj = new j();
                localIntent = new Intent("com.google.android.gms.ads.identifier.service.START");
                localIntent.setPackage("com.google.android.gms");
                if (!paramContext.bindService(localIntent, localj, 1)) {
                    break label73;
                }
                return localj;
            } catch (f paramContext) {
                throw new IOException(paramContext);
            }
            paramContext = paramContext;
            throw new f(9);
        }
    }

    public a W() {
        ag.c("Calling this from your main thread can lead to deadlock");
        ag.a(this.lk);
        ag.a(this.ll);
        if (!this.lm) {
            throw new IOException("AdvertisingIdService is not connected.");
        }
        try {
            a locala = new a(this.ll.a(), this.ll.a(true));
            return locala;
        } catch (RemoteException localRemoteException) {
            Log.i("AdvertisingIdClient", "GMS remote exception ", localRemoteException);
            throw new IOException("Remote exception");
        }
    }

    public void finish() {
        ag.c("Calling this from your main thread can lead to deadlock");
        if ((this.mContext == null) || (this.lk == null)) {
            return;
        }
        try {
            if (this.lm) {
                this.mContext.unbindService(this.lk);
            }
            this.lm = false;
            this.ll = null;
            this.lk = null;
            return;
        } catch (IllegalArgumentException localIllegalArgumentException) {
            for (; ; ) {
                Log.i("AdvertisingIdClient", "AdvertisingIdClient unbindService failed.", localIllegalArgumentException);
            }
        }
    }

    public void start() {
        ag.c("Calling this from your main thread can lead to deadlock");
        if (this.lm) {
            finish();
        }
        this.lk = i(this.mContext);
        this.ll = a(this.mContext, this.lk);
        this.lm = true;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/ads/identifier/AdvertisingIdClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */