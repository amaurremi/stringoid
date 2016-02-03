package com.google.android.gms.common.api;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

import java.util.concurrent.locks.Lock;

class ab
        extends Handler {
    ab(v paramv, Looper paramLooper) {
        super(paramLooper);
    }

    public void handleMessage(Message paramMessage) {
        if (paramMessage.what == 1) {
            v.a(this.a).lock();
            try {
                if ((!this.a.c()) && (!this.a.d())) {
                    boolean bool = v.e(this.a);
                    if (bool) {
                    }
                } else {
                    return;
                }
                v.h(this.a);
                this.a.a();
                return;
            } finally {
                v.a(this.a).unlock();
            }
        }
        Log.wtf("GoogleApiClientImpl", "Don't know how to handle this message.");
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/common/api/ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */