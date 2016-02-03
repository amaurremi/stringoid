package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.a;
import com.google.android.gms.common.d;
import com.google.android.gms.common.e;

@ii
public final class ka
        extends jy
        implements d, e {
    private final jx a;
    private final kb b;
    private final Object c = new Object();

    public ka(Context paramContext, fi paramfi, jx paramjx) {
        super(paramfi, paramjx);
        this.a = paramjx;
        this.b = new kb(paramContext, this, this, paramfi.k.d);
        this.b.a();
    }

    public void D_() {
        mx.a("Disconnected from remote ad request service.");
    }

    public void a(Bundle paramBundle) {
        e();
    }

    public void a(a parama) {
        this.a.a(new fk(0));
    }

    public void c() {
        synchronized (this.c) {
            if ((this.b.c()) || (this.b.i())) {
                this.b.b();
            }
            return;
        }
    }

    public kf d() {
        synchronized (this.c) {
            try {
                kf localkf = this.b.n();
                return localkf;
            } catch (IllegalStateException localIllegalStateException) {
                return null;
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/ka.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */