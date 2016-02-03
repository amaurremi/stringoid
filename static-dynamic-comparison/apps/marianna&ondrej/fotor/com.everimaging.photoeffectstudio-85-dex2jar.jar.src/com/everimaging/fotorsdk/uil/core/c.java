package com.everimaging.fotorsdk.uil.core;

import android.content.res.Resources;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import com.everimaging.fotorsdk.uil.core.assist.ImageScaleType;

public final class c {
    private final int a;
    private final int b;
    private final int c;
    private final Drawable d;
    private final Drawable e;
    private final Drawable f;
    private final boolean g;
    private final boolean h;
    private final boolean i;
    private final ImageScaleType j;
    private final BitmapFactory.Options k;
    private final int l;
    private final boolean m;
    private final Object n;
    private final com.everimaging.fotorsdk.uil.core.process.a o;
    private final com.everimaging.fotorsdk.uil.core.process.a p;
    private final com.everimaging.fotorsdk.uil.core.display.a q;
    private final Handler r;
    private final boolean s;

    private c(a parama) {
        this.a = a.a(parama);
        this.b = a.b(parama);
        this.c = a.c(parama);
        this.d = a.d(parama);
        this.e = a.e(parama);
        this.f = a.f(parama);
        this.g = a.g(parama);
        this.h = a.h(parama);
        this.i = a.i(parama);
        this.j = a.j(parama);
        this.k = a.k(parama);
        this.l = a.l(parama);
        this.m = a.m(parama);
        this.n = a.n(parama);
        this.o = a.o(parama);
        this.p = a.p(parama);
        this.q = a.q(parama);
        this.r = a.r(parama);
        this.s = a.s(parama);
    }

    public static c t() {
        return new a().a();
    }

    public Drawable a(Resources paramResources) {
        if (this.a != 0) {
            return paramResources.getDrawable(this.a);
        }
        return this.d;
    }

    public boolean a() {
        return (this.d != null) || (this.a != 0);
    }

    public Drawable b(Resources paramResources) {
        if (this.b != 0) {
            return paramResources.getDrawable(this.b);
        }
        return this.e;
    }

    public boolean b() {
        return (this.e != null) || (this.b != 0);
    }

    public Drawable c(Resources paramResources) {
        if (this.c != 0) {
            return paramResources.getDrawable(this.c);
        }
        return this.f;
    }

    public boolean c() {
        return (this.f != null) || (this.c != 0);
    }

    public boolean d() {
        return this.o != null;
    }

    public boolean e() {
        return this.p != null;
    }

    public boolean f() {
        return this.l > 0;
    }

    public boolean g() {
        return this.g;
    }

    public boolean h() {
        return this.h;
    }

    public boolean i() {
        return this.i;
    }

    public ImageScaleType j() {
        return this.j;
    }

    public BitmapFactory.Options k() {
        return this.k;
    }

    public int l() {
        return this.l;
    }

    public boolean m() {
        return this.m;
    }

    public Object n() {
        return this.n;
    }

    public com.everimaging.fotorsdk.uil.core.process.a o() {
        return this.o;
    }

    public com.everimaging.fotorsdk.uil.core.process.a p() {
        return this.p;
    }

    public com.everimaging.fotorsdk.uil.core.display.a q() {
        return this.q;
    }

    public Handler r() {
        if (this.s) {
            return null;
        }
        if (this.r == null) {
            if (Looper.myLooper() != Looper.getMainLooper()) {
                throw new IllegalStateException("ImageLoader.displayImage(...) must be invoked from the main thread or from Looper thread");
            }
            return new Handler();
        }
        return this.r;
    }

    boolean s() {
        return this.s;
    }

    public static class a {
        private int a = 0;
        private int b = 0;
        private int c = 0;
        private Drawable d = null;
        private Drawable e = null;
        private Drawable f = null;
        private boolean g = false;
        private boolean h = false;
        private boolean i = false;
        private ImageScaleType j = ImageScaleType.IN_SAMPLE_POWER_OF_2;
        private BitmapFactory.Options k = new BitmapFactory.Options();
        private int l = 0;
        private boolean m = false;
        private Object n = null;
        private com.everimaging.fotorsdk.uil.core.process.a o = null;
        private com.everimaging.fotorsdk.uil.core.process.a p = null;
        private com.everimaging.fotorsdk.uil.core.display.a q = a.b();
        private Handler r = null;
        private boolean s = false;

        public a() {
            this.k.inPurgeable = true;
            this.k.inInputShareable = true;
        }

        public a a(int paramInt) {
            this.a = paramInt;
            return this;
        }

        public a a(Bitmap.Config paramConfig) {
            if (paramConfig == null) {
                throw new IllegalArgumentException("bitmapConfig can't be null");
            }
            this.k.inPreferredConfig = paramConfig;
            return this;
        }

        public a a(BitmapFactory.Options paramOptions) {
            if (paramOptions == null) {
                throw new IllegalArgumentException("decodingOptions can't be null");
            }
            this.k = paramOptions;
            return this;
        }

        public a a(ImageScaleType paramImageScaleType) {
            this.j = paramImageScaleType;
            return this;
        }

        public a a(c paramc) {
            this.a = c.a(paramc);
            this.b = c.b(paramc);
            this.c = c.c(paramc);
            this.d = c.d(paramc);
            this.e = c.e(paramc);
            this.f = c.f(paramc);
            this.g = c.g(paramc);
            this.h = c.h(paramc);
            this.i = c.i(paramc);
            this.j = c.j(paramc);
            this.k = c.k(paramc);
            this.l = c.l(paramc);
            this.m = c.m(paramc);
            this.n = c.n(paramc);
            this.o = c.o(paramc);
            this.p = c.p(paramc);
            this.q = c.q(paramc);
            this.r = c.r(paramc);
            this.s = c.s(paramc);
            return this;
        }

        public a a(com.everimaging.fotorsdk.uil.core.display.a parama) {
            if (parama == null) {
                throw new IllegalArgumentException("displayer can't be null");
            }
            this.q = parama;
            return this;
        }

        public a a(boolean paramBoolean) {
            this.h = paramBoolean;
            return this;
        }

        public c a() {
            return new c(this, null);
        }

        public a b(int paramInt) {
            this.b = paramInt;
            return this;
        }

        public a b(boolean paramBoolean) {
            this.i = paramBoolean;
            return this;
        }

        public a c(int paramInt) {
            this.c = paramInt;
            return this;
        }

        public a c(boolean paramBoolean) {
            this.m = paramBoolean;
            return this;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/uil/core/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */