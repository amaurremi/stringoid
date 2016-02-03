package com.google.android.gms.internal;

import android.os.RemoteException;

class em
        implements Runnable {
    em(eh parameh) {
    }

    public void run() {
        try {
            eh.a(this.a).e();
            return;
        } catch (RemoteException localRemoteException) {
            mx.d("Could not call onAdLoaded.", localRemoteException);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/em.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */