package com.amazon.device.ads;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

import org.json.JSONArray;

class gw {
    private static final String a = gw.class.getSimpleName();
    private static final ExecutorService b = Executors.newSingleThreadExecutor();

    private void c(long paramLong) {
        he.a().b("amzn-ad-sis-last-checkin", paramLong);
    }

    protected cd a() {
        return new cc().b();
    }

    protected void a(cd paramcd) {
        paramcd = new gu().a(paramcd);
        new hb(new gz(this), new ha[]{paramcd}).a();
    }

    protected boolean a(long paramLong) {
        boolean bool = false;
        gs localgs = dn.i().c();
        if ((b(paramLong)) || (localgs.g()) || (localgs.i()) || (cx.a("debug.shouldRegisterSIS", false))) {
            bool = true;
        }
        return bool;
    }

    protected void b(cd paramcd) {
        paramcd = new hd().a(paramcd);
        new hb(new gz(this), new ha[]{paramcd}).a();
    }

    protected boolean b() {
        return dn.i().c().h();
    }

    protected boolean b(long paramLong) {
        return paramLong - f() > 86400000L;
    }

    public void c() {
        gx localgx = new gx(this);
        b.submit(localgx);
    }

    void d() {
        CountDownLatch localCountDownLatch = new CountDownLatch(1);
        AtomicBoolean localAtomicBoolean = new AtomicBoolean(false);
        cq.a().a(new gy(this, localAtomicBoolean, localCountDownLatch));
        try {
            localCountDownLatch.await();
            if (localAtomicBoolean.get()) {
                e();
            }
            return;
        } catch (InterruptedException localInterruptedException) {
            for (; ; ) {
            }
        }
    }

    void e() {
        long l = System.currentTimeMillis();
        cd localcd = a();
        if ((localcd.a()) && (a(l))) {
            c(l);
            if (b()) {
                b(localcd);
            }
        } else {
            return;
        }
        a(localcd);
    }

    protected long f() {
        return he.a().a("amzn-ad-sis-last-checkin", 0L);
    }

    protected void g() {
        if (ho.a()) {
            dv.c(a, "Registering events must be done on a background thread.");
        }
        cd localcd;
        JSONArray localJSONArray;
        do {
            do {
                return;
                localcd = new cc().b();
            } while (!localcd.f());
            localJSONArray = cl.a().b();
        } while (localJSONArray == null);
        new hb(new ha[]{new gv(localcd, localJSONArray)}).a();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/amazon/device/ads/gw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */