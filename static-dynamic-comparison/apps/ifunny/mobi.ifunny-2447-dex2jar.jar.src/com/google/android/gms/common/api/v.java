package com.google.android.gms.common.api;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.ag;
import com.google.android.gms.common.internal.o;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

final class v
        implements k {
    final Queue<ac<?>> a = new LinkedList();
    final Handler b;
    final Set<ac<?>> c = Collections.newSetFromMap(new ConcurrentHashMap());
    private final Lock d = new ReentrantLock();
    private final Condition e = this.d.newCondition();
    private final com.google.android.gms.common.internal.m f = new com.google.android.gms.common.internal.m(paramContext, paramLooper, this.w);
    private final int g;
    private final Looper h;
    private com.google.android.gms.common.a i;
    private int j;
    private volatile int k = 4;
    private volatile int l;
    private boolean m = false;
    private int n;
    private long o = 5000L;
    private final Bundle p = new Bundle();
    private final Map<d<?>, b> q = new HashMap();
    private final List<String> r;
    private boolean s;
    private final Set<ad<?>> t = Collections.newSetFromMap(new WeakHashMap());
    private final aa u = new w(this);
    private final m v = new x(this);
    private final o w = new y(this);

    public v(Context paramContext, Looper paramLooper, ClientSettings paramClientSettings, Map paramMap, Set paramSet1, Set paramSet2, int paramInt) {
        this.h = paramLooper;
        this.b = new ab(this, paramLooper);
        this.g = paramInt;
        paramSet1 = paramSet1.iterator();
        Object localObject1;
        while (paramSet1.hasNext()) {
            localObject1 = (m) paramSet1.next();
            this.f.a((m) localObject1);
        }
        paramSet1 = paramSet2.iterator();
        while (paramSet1.hasNext()) {
            paramSet2 = (n) paramSet1.next();
            this.f.a(paramSet2);
        }
        paramSet1 = paramMap.keySet().iterator();
        while (paramSet1.hasNext()) {
            paramSet2 = (a) paramSet1.next();
            localObject1 = paramSet2.a();
            Object localObject2 = paramMap.get(paramSet2);
            this.q.put(paramSet2.c(), a((c) localObject1, localObject2, paramContext, paramLooper, paramClientSettings, this.v, new z(this, (c) localObject1)));
        }
        this.r = Collections.unmodifiableList(paramClientSettings.b());
    }

    private static <C extends b, O> C a(c<C, O> paramc, Object paramObject, Context paramContext, Looper paramLooper, ClientSettings paramClientSettings, m paramm, n paramn) {
        return paramc.a(paramContext, paramLooper, paramClientSettings, paramObject, paramm, paramn);
    }

    private void a(int paramInt) {
        this.d.lock();
        Object localObject2;
        try {
            if (this.k == 3) {
                break label374;
            }
            if (paramInt != -1) {
                break label241;
            }
            if (d()) {
                Iterator localIterator1 = this.a.iterator();
                while (localIterator1.hasNext()) {
                    localObject2 = (ac) localIterator1.next();
                    if (((ac) localObject2).e() != 1) {
                        ((ac) localObject2).b();
                        localIterator1.remove();
                    }
                }
            }
            this.a.clear();
        } finally {
            this.d.unlock();
        }
        Iterator localIterator2 = this.c.iterator();
        while (localIterator2.hasNext()) {
            ((ac) localIterator2.next()).b();
        }
        this.c.clear();
        localIterator2 = this.t.iterator();
        while (localIterator2.hasNext()) {
            ((ad) localIterator2.next()).a();
        }
        this.t.clear();
        if ((this.i == null) && (!this.a.isEmpty())) {
            this.m = true;
            this.d.unlock();
            return;
        }
        label241:
        boolean bool1 = d();
        boolean bool2 = c();
        this.k = 3;
        if (bool1) {
            if (paramInt == -1) {
                this.i = null;
            }
            this.e.signalAll();
        }
        this.s = false;
        localIterator2 = this.q.values().iterator();
        while (localIterator2.hasNext()) {
            localObject2 = (b) localIterator2.next();
            if (((b) localObject2).c()) {
                ((b) localObject2).b();
            }
        }
        this.s = true;
        this.k = 4;
        if (bool2) {
            if (paramInt != -1) {
                this.f.a(paramInt);
            }
            this.s = false;
        }
        label374:
        this.d.unlock();
    }

    private <A extends b> void a(ac<A> paramac) {
        this.d.lock();
        try {
            if (paramac.d() != null) {
            }
            for (boolean bool = true; ; bool = false) {
                ag.b(bool, "This task can not be executed or enqueued (it's probably a Batch or malformed)");
                this.c.add(paramac);
                paramac.a(this.u);
                if (!g()) {
                    break;
                }
                paramac.b(new Status(8));
                return;
            }
            paramac.a(a(paramac.d()));
            return;
        } finally {
            this.d.unlock();
        }
    }

    private void e() {
        this.n -= 1;
        if (this.n == 0) {
            if (this.i == null) {
                break label81;
            }
            this.m = false;
            a(3);
            if (!g()) {
                break label67;
            }
            this.b.sendMessageDelayed(this.b.obtainMessage(1), this.o);
        }
        for (; ; ) {
            this.s = false;
            return;
            label67:
            this.f.a(this.i);
        }
        label81:
        this.k = 2;
        h();
        this.e.signalAll();
        f();
        if (this.m) {
            this.m = false;
            a(-1);
            return;
        }
        if (this.p.isEmpty()) {
        }
        for (Bundle localBundle = null; ; localBundle = this.p) {
            this.f.a(localBundle);
            return;
        }
    }

    private void f() {
        this.d.lock();
        for (; ; ) {
            try {
                if (c()) {
                    break label108;
                }
                if (!g()) {
                    break label93;
                }
            } finally {
                this.d.unlock();
            }
            ag.a(bool, "GoogleApiClient is not connected yet.");
            boolean bool = this.a.isEmpty();
            if (!bool) {
                try {
                    a((ac) this.a.remove());
                } catch (DeadObjectException localDeadObjectException) {
                    Log.w("GoogleApiClientImpl", "Service died while flushing queue", localDeadObjectException);
                }
                continue;
                label93:
                bool = false;
            } else {
                this.d.unlock();
                return;
                label108:
                bool = true;
            }
        }
    }

    private boolean g() {
        return this.l != 0;
    }

    private void h() {
        this.d.lock();
        try {
            this.l = 0;
            this.b.removeMessages(1);
            return;
        } finally {
            this.d.unlock();
        }
    }

    public <C extends b> C a(d<C> paramd) {
        paramd = (b) this.q.get(paramd);
        ag.a(paramd, "Appropriate Api was not requested.");
        return paramd;
    }

    public <A extends b, T extends h<? extends r, A>> T a(T paramT) {
        if ((c()) || (g())) {
        }
        for (boolean bool = true; ; bool = false) {
            ag.a(bool, "GoogleApiClient is not connected yet.");
            f();
            try {
                a(paramT);
                return paramT;
            } catch (DeadObjectException localDeadObjectException) {
                a(1);
            }
        }
        return paramT;
    }

    public void a() {
        this.d.lock();
        try {
            this.m = false;
            if (!c()) {
                boolean bool = d();
                if (!bool) {
                }
            } else {
                return;
            }
            this.s = true;
            this.i = null;
            this.k = 1;
            this.p.clear();
            this.n = this.q.size();
            Iterator localIterator = this.q.values().iterator();
            while (localIterator.hasNext()) {
                ((b) localIterator.next()).a();
            }
        } finally {
            this.d.unlock();
        }
    }

    public void a(m paramm) {
        this.f.a(paramm);
    }

    public void a(n paramn) {
        this.f.a(paramn);
    }

    public void b() {
        h();
        a(-1);
    }

    public void b(m paramm) {
        this.f.b(paramm);
    }

    public void b(n paramn) {
        this.f.b(paramn);
    }

    public boolean c() {
        return this.k == 2;
    }

    public boolean d() {
        return this.k == 1;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/common/api/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */