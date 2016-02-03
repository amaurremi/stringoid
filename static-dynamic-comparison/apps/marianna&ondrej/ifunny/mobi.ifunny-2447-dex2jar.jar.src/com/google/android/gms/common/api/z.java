package com.google.android.gms.common.api;

import com.google.android.gms.common.a;

import java.util.concurrent.locks.Lock;

class z
        implements n {
    z(v paramv, c paramc) {
    }

    public void a(a parama) {
        v.a(this.b).lock();
        try {
            if ((v.i(this.b) == null) || (this.a.a() < v.j(this.b))) {
                v.a(this.b, parama);
                v.c(this.b, this.a.a());
            }
            v.d(this.b);
            return;
        } finally {
            v.a(this.b).unlock();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/common/api/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */