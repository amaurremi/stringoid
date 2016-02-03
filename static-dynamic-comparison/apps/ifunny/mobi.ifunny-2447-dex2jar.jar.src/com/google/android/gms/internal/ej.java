package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.ads.AdRequest.ErrorCode;

class ej
        implements Runnable {
    ej(eh parameh, AdRequest.ErrorCode paramErrorCode) {
    }

    public void run() {
        try {
            eh.a(this.b).a(et.a(this.a));
            return;
        } catch (RemoteException localRemoteException) {
            mx.d("Could not call onAdFailedToLoad.", localRemoteException);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/ej.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */