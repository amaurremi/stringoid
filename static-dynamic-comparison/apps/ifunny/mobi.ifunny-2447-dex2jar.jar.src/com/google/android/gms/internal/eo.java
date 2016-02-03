package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.ads.AdRequest.ErrorCode;

class eo
        implements Runnable {
    eo(eh parameh, AdRequest.ErrorCode paramErrorCode) {
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


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/eo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */