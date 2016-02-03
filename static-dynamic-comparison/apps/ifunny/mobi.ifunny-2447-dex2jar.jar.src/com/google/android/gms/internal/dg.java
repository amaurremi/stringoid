package com.google.android.gms.internal;

import android.os.RemoteException;

class dg
        implements Runnable {
    dg(df paramdf, dp paramdp) {
    }

    public void run() {
        try {
            this.a.c.c();
            return;
        } catch (RemoteException localRemoteException) {
            mx.d("Could not destroy mediation adapter.", localRemoteException);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/dg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */