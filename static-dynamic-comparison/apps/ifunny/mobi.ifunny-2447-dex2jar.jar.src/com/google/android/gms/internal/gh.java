package com.google.android.gms.internal;

import android.content.Intent;
import android.os.RemoteException;

class gh
        implements Runnable {
    gh(gg paramgg, gl paramgl, Intent paramIntent) {
    }

    public void run() {
        try {
            if (gg.a(this.c).a(this.a.b, -1, this.b)) {
                gg.c(this.c).a(new gm(gg.b(this.c), this.a.c, true, -1, this.b, this.a));
                return;
            }
            gg.c(this.c).a(new gm(gg.b(this.c), this.a.c, false, -1, this.b, this.a));
            return;
        } catch (RemoteException localRemoteException) {
            mx.e("Fail to verify and dispatch pending transaction");
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/gh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */