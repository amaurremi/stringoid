package com.google.android.gms.common.api;

import android.os.RemoteException;
import com.google.android.gms.common.internal.ag;
import com.google.android.gms.common.internal.u;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;

public abstract class f<R extends r>
        implements i<R>, o<R> {
    protected g<R> a;
    private final Object b = new Object();
    private final CountDownLatch c = new CountDownLatch(1);
    private final ArrayList<p> d = new ArrayList();
    private s<R> e;
    private volatile R f;
    private volatile boolean g;
    private boolean h;
    private boolean i;
    private u j;

    private void b(R paramR) {
        this.f = paramR;
        this.j = null;
        this.c.countDown();
        paramR = this.f.a();
        if (this.e != null) {
            this.a.a();
            if (!this.h) {
                this.a.a(this.e, f());
            }
        }
        Iterator localIterator = this.d.iterator();
        while (localIterator.hasNext()) {
            ((p) localIterator.next()).a(paramR);
        }
        this.d.clear();
    }

    private R f() {
        for (; ; ) {
            synchronized (this.b) {
                if (!this.g) {
                    bool = true;
                    ag.a(bool, "Result has already been consumed.");
                    ag.a(a(), "Result is not ready.");
                    r localr = this.f;
                    c();
                    return localr;
                }
            }
            boolean bool = false;
        }
    }

    private void g() {
        synchronized (this.b) {
            if (!a()) {
                a(a(Status.d));
                this.i = true;
            }
            return;
        }
    }

    protected abstract R a(Status paramStatus);

    protected void a(g<R> paramg) {
        this.a = paramg;
    }

    public final void a(R paramR) {
        boolean bool2 = true;
        for (; ; ) {
            synchronized (this.b) {
                if ((this.i) || (this.h)) {
                    e.a(paramR);
                    return;
                }
                if (!a()) {
                    bool1 = true;
                    ag.a(bool1, "Results have already been set");
                    if (this.g) {
                        break label83;
                    }
                    bool1 = bool2;
                    ag.a(bool1, "Result has already been consumed");
                    b(paramR);
                    return;
                }
            }
            boolean bool1 = false;
            continue;
            label83:
            bool1 = false;
        }
    }

    public final boolean a() {
        return this.c.getCount() == 0L;
    }

    public void b() {
        synchronized (this.b) {
            if ((this.h) || (this.g)) {
                return;
            }
            u localu = this.j;
            if (localu == null) {
            }
        }
        try {
            this.j.a();
            e.a(this.f);
            this.e = null;
            this.h = true;
            b(a(Status.e));
            return;
            localObject2 =finally;
            throw ((Throwable) localObject2);
        } catch (RemoteException localRemoteException) {
            for (; ; ) {
            }
        }
    }

    protected void c() {
        this.g = true;
        this.f = null;
        this.e = null;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/common/api/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */