package com.google.android.gms.common.api;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.internal.ag;

public abstract class h<R extends r, A extends b>
        extends f<R>
        implements ac<A> {
    private final d<A> b;
    private aa c;

    protected h(d<A> paramd) {
        this.b = ((d) ag.a(paramd));
    }

    private void a(RemoteException paramRemoteException) {
        b(new Status(8, paramRemoteException.getLocalizedMessage(), null));
    }

    public void a(aa paramaa) {
        this.c = paramaa;
    }

    public final void a(A paramA) {
        if (this.a == null) {
            a(new g(paramA.d()));
        }
        try {
            b(paramA);
            return;
        } catch (DeadObjectException paramA) {
            a(paramA);
            throw paramA;
        } catch (RemoteException paramA) {
            a(paramA);
        }
    }

    public final void b(Status paramStatus) {
        if (!paramStatus.e()) {
        }
        for (boolean bool = true; ; bool = false) {
            ag.b(bool, "Failed result must not be success");
            a(a(paramStatus));
            return;
        }
    }

    protected abstract void b(A paramA);

    protected void c() {
        super.c();
        if (this.c != null) {
            this.c.a(this);
            this.c = null;
        }
    }

    public final d<A> d() {
        return this.b;
    }

    public int e() {
        return 0;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/common/api/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */