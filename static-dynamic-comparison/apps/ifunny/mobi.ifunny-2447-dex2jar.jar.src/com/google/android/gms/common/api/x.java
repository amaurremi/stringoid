package com.google.android.gms.common.api;

import android.os.Bundle;
import android.os.Handler;

import java.util.concurrent.locks.Lock;

class x
        implements m {
    x(v paramv) {
    }

    public void a(int paramInt) {
        v.a(this.a).lock();
        for (; ; ) {
            try {
                v.a(this.a, paramInt);
                switch (paramInt) {
                    default:
                        return;
                }
            } finally {
                v.a(this.a).unlock();
            }
            this.a.a();
            continue;
            boolean bool = v.e(this.a);
            if (bool) {
                v.a(this.a).unlock();
                return;
            }
            v.b(this.a, 2);
            this.a.b.sendMessageDelayed(this.a.b.obtainMessage(1), v.f(this.a));
        }
    }

    public void a(Bundle paramBundle) {
        v.a(this.a).lock();
        try {
            if (v.b(this.a) == 1) {
                if (paramBundle != null) {
                    v.c(this.a).putAll(paramBundle);
                }
                v.d(this.a);
            }
            return;
        } finally {
            v.a(this.a).unlock();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/common/api/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */