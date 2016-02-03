package com.google.android.gms.internal;

import android.content.Context;
import android.view.View;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;

@ii
public final class g
        implements p {
    private final Object a = new Object();
    private final WeakHashMap<lc, h> b = new WeakHashMap();
    private final ArrayList<h> c = new ArrayList();

    public h a(Context paramContext, ay paramay, lc paramlc, View paramView, gt paramgt) {
        synchronized (this.a) {
            if (a(paramlc)) {
                paramContext = (h) this.b.get(paramlc);
                return paramContext;
            }
            paramContext = new h(paramContext, paramay, paramlc, paramView, paramgt);
            paramContext.a(this);
            this.b.put(paramlc, paramContext);
            this.c.add(paramContext);
            return paramContext;
        }
    }

    public h a(ay paramay, lc paramlc) {
        return a(paramlc.b.getContext(), paramay, paramlc, paramlc.b, paramlc.b.i());
    }

    public void a() {
        synchronized (this.a) {
            Iterator localIterator = this.c.iterator();
            if (localIterator.hasNext()) {
                ((h) localIterator.next()).k();
            }
        }
    }

    public void a(h paramh) {
        synchronized (this.a) {
            if (!paramh.f()) {
                this.c.remove(paramh);
            }
            return;
        }
    }

    public boolean a(lc paramlc) {
        for (; ; ) {
            synchronized (this.a) {
                paramlc = (h) this.b.get(paramlc);
                if ((paramlc != null) && (paramlc.f())) {
                    bool = true;
                    return bool;
                }
            }
            boolean bool = false;
        }
    }

    public void b() {
        synchronized (this.a) {
            Iterator localIterator = this.c.iterator();
            if (localIterator.hasNext()) {
                ((h) localIterator.next()).l();
            }
        }
    }

    public void b(lc paramlc) {
        synchronized (this.a) {
            paramlc = (h) this.b.get(paramlc);
            if (paramlc != null) {
                paramlc.d();
            }
            return;
        }
    }

    public void c() {
        synchronized (this.a) {
            Iterator localIterator = this.c.iterator();
            if (localIterator.hasNext()) {
                ((h) localIterator.next()).m();
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */