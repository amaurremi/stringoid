package com.flurry.sdk;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.flurry.android.FlurryAdSize;
import com.flurry.android.impl.ads.FlurryAdModule;

public final class l
        extends RelativeLayout {
    private static final String a = l.class.getSimpleName();
    private final FlurryAdModule b;
    private final String c;
    private final ViewGroup d;
    private long e;
    private final Runnable f = new a(null);

    public l(FlurryAdModule paramFlurryAdModule, Context paramContext, String paramString, ViewGroup paramViewGroup) {
        super(paramContext);
        this.b = paramFlurryAdModule;
        this.c = paramString;
        this.d = paramViewGroup;
    }

    private boolean e() {
        if (FlurryAdModule.i()) {
            eo.a(3, a, "Device is locked: banner will NOT rotate for adSpace: " + getAdSpace());
        }
        i locali;
        do {
            return false;
            if (this.b.g()) {
                eo.a(3, a, "Ad fullscreen panel is opened: banner will NOT rotate for adSpace: " + getAdSpace());
                return false;
            }
            locali = getCurrentBannerView();
        } while ((locali == null) || (!locali.g()));
        return true;
    }

    private void f() {
        eo.a(3, a, "Rotating banner for adSpace: " + getAdSpace());
        this.b.d().a(getContext(), this.c, this.d, FlurryAdSize.BANNER_BOTTOM, true);
    }

    private void g() {
        try {
            if (e()) {
                f();
            }
            do.a().b(this.f, getRotationRateInMilliseconds());
            return;
        } finally {
        }
    }

    private i getCurrentBannerView() {
        if (getChildCount() < 1) {
            return null;
        }
        Object localObject = getChildAt(0);
        try {
            localObject = (i) localObject;
            return (i) localObject;
        } catch (ClassCastException localClassCastException) {
        }
        return null;
    }

    public void a() {
        try {
            c();
            this.e = 0L;
            return;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    public void a(long paramLong) {
        try {
            if (this.e != paramLong) {
                c();
                this.e = paramLong;
                b();
            }
            return;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    public void b() {
        try {
            if (getRotationRateInMilliseconds() != 0L) {
                c();
                eo.a(3, a, "schedule banner rotation for adSpace = " + getAdSpace() + " with fixed rate in milliseconds = " + getRotationRateInMilliseconds());
                do.a().b(this.f, getRotationRateInMilliseconds());
            }
            return;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    public void c() {
        try {
            do.a().d(this.f);
            return;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    public void d() {
        a();
        i locali = getCurrentBannerView();
        if (locali != null) {
            locali.onDestroy();
        }
    }

    public String getAdSpace() {
        return this.c;
    }

    public long getRotationRateInMilliseconds() {
        return this.e;
    }

    public ViewGroup getViewGroup() {
        return this.d;
    }

    final class a
            extends ff {
        private a() {
        }

        public void a() {
            l.a(l.this);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */