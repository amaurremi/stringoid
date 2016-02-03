package com.google.android.gms.internal;

import android.os.RemoteException;

class ei
        implements Runnable {
    ei(eh parameh) {
    }

    public void run() {
        try {
            eh.a(this.a).a();
            return;
        } catch (RemoteException localRemoteException) {
            mx.d("Could not call onAdClicked.", localRemoteException);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/ei.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */