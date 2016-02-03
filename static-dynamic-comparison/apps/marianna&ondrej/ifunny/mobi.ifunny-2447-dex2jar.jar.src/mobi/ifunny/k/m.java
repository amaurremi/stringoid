package mobi.ifunny.k;

import android.os.Handler;

import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

import mobi.ifunny.d;

public final class m<K, D> {
    private static final String a = m.class.getSimpleName();
    private final Map<K, q<K, D>> b;
    private final Map<q<K, D>, WeakReference<K>> c;
    private final LinkedList<q<K, D>> d;
    private final ConcurrentLinkedQueue<q<K, D>> e;
    private final Map<String, Set<K>> f;
    private int g;
    private s<K, D> h;
    private final long i;
    private final boolean j;
    private final Handler k = new Handler();
    private Runnable l;
    private boolean m;
    private final Runnable n = new n(this);

    public m(int paramInt1, int paramInt2) {
        this.i = paramInt2;
        if (paramInt2 > 0) {
        }
        for (boolean bool = true; ; bool = false) {
            this.j = bool;
            this.f = new HashMap();
            this.c = new HashMap();
            this.b = new WeakHashMap();
            this.d = new LinkedList();
            this.e = new ConcurrentLinkedQueue();
            this.g = paramInt1;
            this.l = new o(this);
            return;
        }
    }

    private void a(K paramK, q<K, D> paramq) {
        if (q.b(paramq)) {
            a(paramq, false);
        }
        do {
            return;
            this.d.remove(paramq);
            this.c.remove(paramq);
        } while (paramK == null);
        this.b.remove(paramK);
        ((Set) this.f.get(paramq.b())).remove(paramK);
    }

    private void a(K paramK, q<K, D> paramq, D paramD) {
        if (this.h != null) {
            this.h.a(paramK, paramD);
        }
    }

    private void a(q<K, D> paramq) {
    }

    private void a(q<K, D> paramq, boolean paramBoolean) {
        if (paramq.e()) {
        }
        Object localObject;
        do {
            do {
                return;
                q.a(paramq, paramBoolean);
                localObject = (WeakReference) this.c.get(paramq);
            } while (localObject == null);
            localObject = ((WeakReference) localObject).get();
        } while (localObject == null);
        this.b.remove(localObject);
        ((Set) this.f.get(paramq.b())).remove(localObject);
    }

    private void b(K paramK, q<K, D> paramq) {
        if (paramK != null) {
            ((Set) this.f.get(paramq.b())).remove(paramK);
            this.b.remove(paramK);
        }
        this.c.remove(paramq);
        this.e.remove(paramq);
        this.k.postDelayed(this.l, 50L);
    }

    private void b(K paramK, q<K, D> paramq, D paramD) {
        if (this.h != null) {
            this.h.a(paramK, paramD, paramq.f());
        }
    }

    private void b(q<K, D> paramq) {
        this.c.remove(paramq);
        this.e.remove(paramq);
        this.k.postDelayed(this.l, 50L);
    }

    private void c(K paramK, q<K, D> paramq) {
        if ((this.h != null) && (paramK != null)) {
            this.h.a(paramK, q.c(paramq));
        }
        if (paramK == null) {
            d.d(a, "load failed because key is null");
        }
    }

    private void d() {
        this.m = true;
        this.k.postDelayed(this.n, 200L);
    }

    private void e() {
        for (; ; ) {
            q localq;
            if ((this.e.size() < this.g) && (this.d.size() > 0)) {
                localq = (q) this.d.peek();
                Object localObject = (WeakReference) this.c.get(localq);
                if (localObject == null) {
                    a(null, localq);
                    continue;
                }
                localObject = ((WeakReference) localObject).get();
                if (localObject == null) {
                    a(localObject, localq);
                    continue;
                }
                if (!localq.a(this)) {
                    this.k.postDelayed(this.l, 200L);
                }
            } else {
                return;
            }
            this.d.poll();
            this.e.offer(localq);
            a(localq);
        }
    }

    public void a() {
        Object localObject2 = new HashSet(this.b.size());
        Object localObject1 = new HashSet(this.e.size());
        Object localObject3 = this.b.entrySet().iterator();
        while (((Iterator) localObject3).hasNext()) {
            Object localObject4 = (Map.Entry) ((Iterator) localObject3).next();
            q localq = (q) ((Map.Entry) localObject4).getValue();
            localObject4 = ((Map.Entry) localObject4).getKey();
            if (q.b(localq)) {
                ((Set) localObject1).add(localq);
            } else {
                ((Set) localObject2).add(localObject4);
                ((Set) this.f.get(localq.b())).remove(localObject4);
                this.d.remove(localq);
                this.c.remove(localq);
            }
        }
        localObject2 = ((Set) localObject2).iterator();
        while (((Iterator) localObject2).hasNext()) {
            localObject3 = ((Iterator) localObject2).next();
            this.b.remove(localObject3);
        }
        localObject1 = ((Set) localObject1).iterator();
        while (((Iterator) localObject1).hasNext()) {
            a((q) ((Iterator) localObject1).next(), false);
        }
    }

    public void a(K paramK) {
        q localq = (q) this.b.get(paramK);
        if (localq != null) {
            a(paramK, localq);
        }
    }

    public void a(K paramK, r<D> paramr) {
        Object localObject = (q) this.b.get(paramK);
        if ((localObject != null) && (q.c((q) localObject).equals(paramr))) {
            return;
        }
        a(paramK);
        q localq = new q(paramr);
        this.b.put(paramK, localq);
        this.c.put(localq, new WeakReference(paramK));
        String str = paramr.c;
        localObject = (Set) this.f.get(str);
        paramr = (r<D>) localObject;
        if (localObject == null) {
            paramr = Collections.newSetFromMap(new WeakHashMap());
            this.f.put(str, paramr);
        }
        paramr.add(paramK);
        this.d.offer(localq);
        this.k.postDelayed(this.l, 50L);
    }

    public void a(String paramString) {
        paramString = (Set) this.f.get(paramString);
        if (paramString != null) {
            Iterator localIterator = new HashSet(paramString).iterator();
            while (localIterator.hasNext()) {
                Object localObject = localIterator.next();
                q localq = (q) this.b.get(localObject);
                if (localq != null) {
                    a(localObject, localq);
                }
            }
            paramString.clear();
        }
    }

    public void a(s<K, D> params) {
        this.h = params;
    }

    public r<D> b(K paramK) {
        paramK = (q) this.b.get(paramK);
        if (paramK == null) {
            return null;
        }
        return q.c(paramK);
    }

    public void b() {
        a();
        this.h = null;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/k/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */