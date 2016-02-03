package com.google.android.gms.internal;

import android.content.Context;
import android.view.MotionEvent;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

@ii
class tn
        implements le, Runnable {
    CountDownLatch a = new CountDownLatch(1);
    private final List<Object[]> b = new Vector();
    private final AtomicReference<le> c = new AtomicReference();
    private tj d;

    public tn(tj paramtj) {
        this.d = paramtj;
        if (mv.b()) {
            ls.a(this);
            return;
        }
        run();
    }

    private void b() {
        if (this.b.isEmpty()) {
        }
        for (; ; ) {
            return;
            Iterator localIterator = this.b.iterator();
            while (localIterator.hasNext()) {
                Object[] arrayOfObject = (Object[]) localIterator.next();
                if (arrayOfObject.length == 1) {
                    ((le) this.c.get()).a((MotionEvent) arrayOfObject[0]);
                } else if (arrayOfObject.length == 3) {
                    ((le) this.c.get()).a(((Integer) arrayOfObject[0]).intValue(), ((Integer) arrayOfObject[1]).intValue(), ((Integer) arrayOfObject[2]).intValue());
                }
            }
        }
    }

    public String a(Context paramContext) {
        a();
        le localle = (le) this.c.get();
        if (localle != null) {
            b();
            return localle.a(paramContext);
        }
        return "";
    }

    public String a(Context paramContext, String paramString) {
        a();
        le localle = (le) this.c.get();
        if (localle != null) {
            b();
            return localle.a(paramContext, paramString);
        }
        return "";
    }

    protected void a() {
        try {
            this.a.await();
            return;
        } catch (InterruptedException localInterruptedException) {
            mx.d("Interrupted during GADSignals creation.", localInterruptedException);
        }
    }

    public void a(int paramInt1, int paramInt2, int paramInt3) {
        le localle = (le) this.c.get();
        if (localle != null) {
            b();
            localle.a(paramInt1, paramInt2, paramInt3);
            return;
        }
        this.b.add(new Object[]{Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3)});
    }

    public void a(MotionEvent paramMotionEvent) {
        le localle = (le) this.c.get();
        if (localle != null) {
            b();
            localle.a(paramMotionEvent);
            return;
        }
        this.b.add(new Object[]{paramMotionEvent});
    }

    protected void a(le paramle) {
        this.c.set(paramle);
    }

    public void run() {
        try {
            a(pa.a(this.d.e.b, this.d.c));
            return;
        } finally {
            this.a.countDown();
            this.d = null;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/tn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */