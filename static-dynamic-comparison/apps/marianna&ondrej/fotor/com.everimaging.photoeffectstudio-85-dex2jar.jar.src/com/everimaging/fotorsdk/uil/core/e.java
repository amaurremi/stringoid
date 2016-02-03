package com.everimaging.fotorsdk.uil.core;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.util.DisplayMetrics;
import com.everimaging.fotorsdk.uil.core.assist.QueueProcessingType;
import com.everimaging.fotorsdk.uil.core.assist.f;
import com.everimaging.fotorsdk.uil.core.download.ImageDownloader;
import com.everimaging.fotorsdk.uil.utils.d;

import java.util.concurrent.Executor;

public final class e {
    final Resources a;
    final int b;
    final int c;
    final int d;
    final int e;
    final Bitmap.CompressFormat f;
    final int g;
    final com.everimaging.fotorsdk.uil.core.process.a h;
    final Executor i;
    final Executor j;
    final boolean k;
    final boolean l;
    final int m;
    final int n;
    final QueueProcessingType o;
    final com.everimaging.fotorsdk.uil.cache.memory.a<String, Bitmap> p;
    final com.everimaging.fotorsdk.uil.cache.disc.b q;
    final ImageDownloader r;
    final com.everimaging.fotorsdk.uil.core.decode.b s;
    final c t;
    final boolean u;
    final com.everimaging.fotorsdk.uil.cache.disc.b v;
    final ImageDownloader w;
    final ImageDownloader x;

    private e(a parama) {
        this.a = a.a(parama).getResources();
        this.b = a.b(parama);
        this.c = a.c(parama);
        this.d = a.d(parama);
        this.e = a.e(parama);
        this.f = a.f(parama);
        this.g = a.g(parama);
        this.h = a.h(parama);
        this.i = a.i(parama);
        this.j = a.j(parama);
        this.m = a.k(parama);
        this.n = a.l(parama);
        this.o = a.m(parama);
        this.q = a.n(parama);
        this.p = a.o(parama);
        this.t = a.p(parama);
        this.u = a.q(parama);
        this.r = a.r(parama);
        this.s = a.s(parama);
        this.k = a.t(parama);
        this.l = a.u(parama);
        this.w = new com.everimaging.fotorsdk.uil.core.download.b(this.r);
        this.x = new com.everimaging.fotorsdk.uil.core.download.c(this.r);
        this.v = a.a(d.a(a.a(parama), false));
    }

    com.everimaging.fotorsdk.uil.core.assist.e a() {
        DisplayMetrics localDisplayMetrics = this.a.getDisplayMetrics();
        int i2 = this.b;
        int i1 = i2;
        if (i2 <= 0) {
            i1 = localDisplayMetrics.widthPixels;
        }
        int i3 = this.c;
        i2 = i3;
        if (i3 <= 0) {
            i2 = localDisplayMetrics.heightPixels;
        }
        return new com.everimaging.fotorsdk.uil.core.assist.e(i1, i2);
    }

    public static class a {
        public static final QueueProcessingType a = QueueProcessingType.FIFO;
        private boolean A = false;
        private Context b;
        private int c = 0;
        private int d = 0;
        private int e = 0;
        private int f = 0;
        private Bitmap.CompressFormat g = null;
        private int h = 0;
        private com.everimaging.fotorsdk.uil.core.process.a i = null;
        private Executor j = null;
        private Executor k = null;
        private boolean l = false;
        private boolean m = false;
        private int n = 3;
        private int o = 4;
        private boolean p = false;
        private QueueProcessingType q = a;
        private int r = 0;
        private int s = 0;
        private int t = 0;
        private com.everimaging.fotorsdk.uil.cache.memory.a<String, Bitmap> u = null;
        private com.everimaging.fotorsdk.uil.cache.disc.b v = null;
        private com.everimaging.fotorsdk.uil.cache.disc.naming.a w = null;
        private ImageDownloader x = null;
        private com.everimaging.fotorsdk.uil.core.decode.b y;
        private c z = null;

        public a(Context paramContext) {
            this.b = paramContext.getApplicationContext();
        }

        private void c() {
            if (this.j == null) {
                this.j = a.a(this.n, this.o, this.q);
                if (this.k != null) {
                    break label198;
                }
                this.k = a.a(this.n, this.o, this.q);
            }
            for (; ; ) {
                if (this.v == null) {
                    if (this.w == null) {
                        this.w = a.a();
                    }
                    this.v = a.a(this.b, this.w, this.s, this.t);
                }
                if (this.u == null) {
                    this.u = a.a(this.r);
                }
                if (this.p) {
                    this.u = new com.everimaging.fotorsdk.uil.cache.memory.impl.a(this.u, f.a());
                }
                if (this.x == null) {
                    this.x = a.a(this.b);
                }
                if (this.y == null) {
                    this.y = a.a(this.A);
                }
                if (this.z == null) {
                    this.z = c.t();
                }
                return;
                this.l = true;
                break;
                label198:
                this.m = true;
            }
        }

        public a a() {
            this.p = true;
            return this;
        }

        public a a(int paramInt) {
            if ((this.j != null) || (this.k != null)) {
                com.everimaging.fotorsdk.uil.utils.c.c("threadPoolSize(), threadPriority() and tasksProcessingOrder() calls can overlap taskExecutor() and taskExecutorForCachedImages() calls.", new Object[0]);
            }
            if (paramInt < 1) {
                this.o = 1;
                return this;
            }
            if (paramInt > 10) {
                this.o = 10;
                return this;
            }
            this.o = paramInt;
            return this;
        }

        public a a(com.everimaging.fotorsdk.uil.cache.disc.naming.a parama) {
            if (this.v != null) {
                com.everimaging.fotorsdk.uil.utils.c.c("discCache() and discCacheFileNameGenerator() calls overlap each other", new Object[0]);
            }
            this.w = parama;
            return this;
        }

        public a b(int paramInt) {
            if ((paramInt <= 0) || (paramInt >= 100)) {
                throw new IllegalArgumentException("availableMemoryPercent must be in range (0 < % < 100)");
            }
            if (this.u != null) {
                com.everimaging.fotorsdk.uil.utils.c.c("memoryCache() and memoryCacheSize() calls overlap each other", new Object[0]);
            }
            this.r = ((int) ((float) Runtime.getRuntime().maxMemory() * (paramInt / 100.0F)));
            return this;
        }

        public e b() {
            c();
            return new e(this, null);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/uil/core/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */