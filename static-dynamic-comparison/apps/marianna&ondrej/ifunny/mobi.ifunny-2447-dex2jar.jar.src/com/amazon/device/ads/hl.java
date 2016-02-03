package com.amazon.device.ads;

import android.util.SparseArray;

abstract class hl
        implements ct, hh {
    private static final SparseArray<hr> a = new SparseArray();
    private int b = 1;

    static {
        a(0, new hq());
        a(1, new hs());
    }

    private static hr a(int paramInt) {
        return (hr) a.get(paramInt, a.get(1));
    }

    static void a(int paramInt, hr paramhr) {
        if (paramhr == null) {
            a.remove(paramInt);
            return;
        }
        a.put(paramInt, paramhr);
    }

    private void a(Runnable paramRunnable) {
        a(this.b).a(paramRunnable);
    }

    protected abstract void a();

    protected abstract void b();

    public void c() {
        a(new hm(this));
    }

    public void d() {
        a(new hn(this));
    }

    public void e() {
        cq.a().a(this);
    }

    public void f() {
        he.a().a(this);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/amazon/device/ads/hl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */