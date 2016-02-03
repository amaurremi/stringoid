package mobi.ifunny.studio.comics.engine;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.Region.Op;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.SurfaceHolder;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import mobi.ifunny.studio.a.b.d;
import mobi.ifunny.studio.comics.engine.b.j;

public final class f {
    private int A = 0;
    private Runnable B = new g(this);
    private final Object a = new Object();
    private h b = h.a;
    private boolean c;
    private SurfaceHolder d;
    private e e = new e();
    private RectF f;
    private float g = 1.0F;
    private float h;
    private float i;
    private float j = 0.0F;
    private float k = 0.0F;
    private float l;
    private float m;
    private float n;
    private float o;
    private HandlerThread p;
    private Handler q;
    private AtomicBoolean r = new AtomicBoolean(false);
    private final a s = new a(this, 10);
    private final mobi.ifunny.studio.comics.engine.a.h t = new mobi.ifunny.studio.comics.engine.a.h(this);
    private mobi.ifunny.studio.comics.engine.c.h u;
    private final ArrayList<mobi.ifunny.studio.comics.engine.c.g> v = new ArrayList();
    private mobi.ifunny.studio.comics.engine.c.h w;
    private boolean x;
    private boolean y;
    private i z;

    private void C() {
        if (this.u != null) {
            this.u.c(this.f);
        }
        j();
    }

    private boolean D() {
        boolean bool = true;
        if (d()) {
            bool = false;
        }
        do {
            return bool;
            if (this.p == null) {
                this.p = new HandlerThread(f.class.getSimpleName(), 5);
            }
            this.r.set(true);
            this.p.start();
        } while (this.q != null);
        this.q = new Handler(this.p.getLooper());
        return true;
    }

    private void E() {
        if (!d()) {
            return;
        }
        this.r.set(false);
        this.p.quit();
        this.q = null;
        this.p = null;
    }

    private boolean F() {
        localObject3 = this.a;
        Canvas localCanvas2 = null;
        localCanvas1 = localCanvas2;
        try {
            h localh1 = this.b;
            localCanvas1 = localCanvas2;
            h localh2 = h.b;
            if (localh1 != localh2) {
                if (0 == 0) {
                }
            }
        } finally {
            if (localCanvas1 != null) {
                this.d.unlockCanvasAndPost(localCanvas1);
            }
        }
        try {
            this.d.unlockCanvasAndPost(null);
            return false;
        } finally {
        }
        localCanvas1 = localCanvas2;
        localCanvas2 = this.d.lockCanvas();
        if (localCanvas2 != null) {
            localCanvas1 = localCanvas2;
            a(localCanvas2);
        }
        if (localCanvas2 != null) {
            this.d.unlockCanvasAndPost(localCanvas2);
        }
        return true;
    }

    public static mobi.ifunny.studio.comics.engine.c.h a() {
        return new mobi.ifunny.studio.comics.engine.c.b(-1);
    }

    private void a(Canvas paramCanvas) {
        if (this.e.d() == null) {
            return;
        }
        int i1 = paramCanvas.save();
        paramCanvas.clipRect(this.e.b(), Region.Op.REPLACE);
        paramCanvas.translate(this.n + this.h, this.o + this.i);
        paramCanvas.scale(this.g, this.g);
        if (this.u != null) {
            this.u.b(paramCanvas);
        }
        Iterator localIterator = this.v.iterator();
        while (localIterator.hasNext()) {
            mobi.ifunny.studio.comics.engine.c.g localg = (mobi.ifunny.studio.comics.engine.c.g) localIterator.next();
            localg.d(this.A);
            localg.b(paramCanvas);
            localg.y();
        }
        paramCanvas.restoreToCount(i1);
    }

    private void b(PointF paramPointF) {
        boolean bool2 = true;
        if ((paramPointF == null) || (paramPointF.x <= 0.0F) || (paramPointF.y <= 0.0F)) {
            return;
        }
        RectF localRectF = this.e.d();
        PointF localPointF2 = new PointF(this.f.centerX(), this.f.centerY());
        PointF localPointF1 = localPointF2;
        if (localRectF != null) {
            localPointF1 = localPointF2;
            if (!localRectF.isEmpty()) {
                localPointF1 = new PointF(localRectF.centerX(), localRectF.centerY());
            }
        }
        this.e.a(paramPointF);
        this.e.b(0.0F);
        this.e.c(0.0F);
        paramPointF = this.e.d();
        localPointF1 = new PointF(localPointF1.x - paramPointF.width() / 2.0F, localPointF1.y - paramPointF.height() / 2.0F);
        boolean bool1;
        if (paramPointF.width() < this.f.width()) {
            bool1 = true;
            this.x = bool1;
            if (paramPointF.height() >= this.f.height()) {
                break label344;
            }
            bool1 = bool2;
            label201:
            this.y = bool1;
            if (!this.x) {
                break label349;
            }
            f((this.f.left - paramPointF.left) * this.g);
            a((localPointF1.x - this.f.left) * this.g);
            h(0.0F);
            label261:
            i((paramPointF.height() - this.f.height()) / 2.0F * this.g);
            if (!this.y) {
                break label385;
            }
            g((this.f.top - paramPointF.top) * this.g);
            b((this.f.top - localPointF1.y) * this.g);
        }
        for (; ; ) {
            j();
            return;
            bool1 = false;
            break;
            label344:
            bool1 = false;
            break label201;
            label349:
            f(0.0F);
            a(0.0F);
            h((paramPointF.width() - this.f.width()) / 2.0F * this.g);
            break label261;
            label385:
            g(0.0F);
            b(0.0F);
        }
    }

    private void d(float paramFloat) {
        this.n = paramFloat;
        this.e.b(paramFloat);
    }

    private void e(float paramFloat) {
        this.o = paramFloat;
        this.e.c(paramFloat);
    }

    private void f(float paramFloat) {
        this.l = paramFloat;
        d(this.j + paramFloat);
    }

    private void g(float paramFloat) {
        this.m = paramFloat;
        e(this.k + paramFloat);
    }

    private void h(float paramFloat) {
        this.h = paramFloat;
        d(this.l + this.j);
    }

    private void i(float paramFloat) {
        this.i = paramFloat;
        e(this.m + this.k);
    }

    public List<mobi.ifunny.studio.comics.engine.c.g> A() {
        return new ArrayList(this.v);
    }

    public void B() {
        this.v.clear();
    }

    public PointF a(PointF paramPointF) {
        RectF localRectF = this.e.d();
        return new PointF((paramPointF.x - this.h) / this.g - localRectF.left, (paramPointF.y - this.i) / this.g - localRectF.top);
    }

    public mobi.ifunny.studio.comics.engine.c.g a(int paramInt) {
        return (mobi.ifunny.studio.comics.engine.c.g) this.v.get(paramInt);
    }

    public void a(float paramFloat) {
        if (paramFloat == this.j) {
        }
        while (!this.x) {
            return;
        }
        RectF localRectF = e.a(this.e.b(), paramFloat, this.k, this.g);
        if (paramFloat > 0.0F) {
            paramFloat = 0.0F;
        }
        for (; ; ) {
            this.j = paramFloat;
            d(this.l + this.j);
            return;
            if (localRectF.right < this.f.left) {
                paramFloat = (this.f.left - localRectF.width()) * this.g;
            }
        }
    }

    public void a(float paramFloat1, float paramFloat2) {
        Object localObject = this.e.c();
        if ((paramFloat1 == ((PointF) localObject).x) && (paramFloat2 == ((PointF) localObject).y)) {
            return;
        }
        localObject = this.e.d();
        if ((paramFloat1 > 0.0F) && (paramFloat2 > 0.0F) && ((localObject == null) || (((RectF) localObject).width() <= 0.0F) || (((RectF) localObject).height() <= 0.0F))) {
        }
        for (int i1 = 1; ; i1 = 0) {
            this.c = true;
            b(new PointF(paramFloat1, paramFloat2));
            if ((i1 == 0) || (this.z == null)) {
                break;
            }
            this.z.a(this);
            return;
        }
    }

    public void a(Context paramContext, mobi.ifunny.studio.a.b.b paramb) {
        a(new RectF(0.0F, 0.0F, 640.0F, 480.0F));
        b(new mobi.ifunny.studio.comics.engine.c.b(paramb.a));
        mobi.ifunny.studio.comics.engine.c.g localg = new mobi.ifunny.studio.comics.engine.c.g();
        paramb = paramb.b.iterator();
        while (paramb.hasNext()) {
            mobi.ifunny.studio.comics.engine.c.h localh = mobi.ifunny.studio.comics.a.e.a(paramContext, (d) paramb.next());
            if (localh != null) {
                localg.a(localh, g());
            }
        }
        a(localg);
    }

    public void a(RectF paramRectF) {
        l();
        synchronized (this.a) {
            this.f = paramRectF;
            b(this.e.c());
            C();
            m();
            return;
        }
    }

    public void a(a parama) {
        this.s.a(parama);
    }

    public void a(mobi.ifunny.studio.comics.engine.b.i parami, c paramc) {
        synchronized (this.a) {
            this.s.a(parami, paramc);
            return;
        }
    }

    public void a(b paramb) {
        this.s.a(paramb);
    }

    public void a(mobi.ifunny.studio.comics.engine.c.g paramg) {
        this.v.add(paramg);
        paramg.b(new PointF(0.0F, 0.0F));
        paramg.a(this.f.width(), this.f.height());
    }

    public void a(mobi.ifunny.studio.comics.engine.c.h paramh) {
        if (this.w != null) {
            this.w.e(false);
        }
        this.w = paramh;
        if (this.w != null) {
            this.w.e(true);
        }
    }

    public void a(mobi.ifunny.studio.comics.engine.c.h paramh, int paramInt) {
        a(paramh, paramInt, c.a);
    }

    public void a(mobi.ifunny.studio.comics.engine.c.h paramh, int paramInt, c paramc) {
        a(new mobi.ifunny.studio.comics.engine.b.a(paramh, paramInt), paramc);
    }

    public void a(boolean paramBoolean) {
        if (this.w != null) {
            this.w.c(paramBoolean);
        }
    }

    public boolean a(SurfaceHolder paramSurfaceHolder) {
        if (this.b != h.a) {
            return false;
        }
        synchronized (this.a) {
            this.d = paramSurfaceHolder;
            return true;
        }
    }

    public void b(float paramFloat) {
        if (paramFloat == this.k) {
        }
        while (!this.y) {
            return;
        }
        RectF localRectF = e.a(this.e.b(), this.j, paramFloat, this.g);
        if (paramFloat > 0.0F) {
            paramFloat = 0.0F;
        }
        for (; ; ) {
            this.k = paramFloat;
            e(this.m + this.k);
            return;
            if (localRectF.bottom > this.f.bottom) {
                paramFloat = (this.f.bottom - localRectF.height()) * this.g;
            }
        }
    }

    public void b(int paramInt) {
        this.A = paramInt;
    }

    public void b(mobi.ifunny.studio.comics.engine.c.h paramh) {
        synchronized (this.a) {
            this.u = paramh;
            paramh.c(this.f);
            return;
        }
    }

    public void b(mobi.ifunny.studio.comics.engine.c.h paramh, int paramInt) {
        b(paramh, paramInt, c.a);
    }

    public void b(mobi.ifunny.studio.comics.engine.c.h paramh, int paramInt, c paramc) {
        a(new j(paramh, paramInt), paramc);
    }

    public final boolean b() {
        return (this.u != null) && (this.u.equals(a())) && (this.v.size() == 1) && (((mobi.ifunny.studio.comics.engine.c.g) this.v.get(0)).a());
    }

    public void c(float paramFloat) {
        synchronized (this.a) {
            this.g = paramFloat;
            this.e.a(paramFloat);
            b(this.e.c());
            return;
        }
    }

    public void c(mobi.ifunny.studio.comics.engine.c.h paramh, int paramInt) {
        synchronized (this.a) {
            ((mobi.ifunny.studio.comics.engine.c.g) this.v.get(paramInt)).b(paramh);
            return;
        }
    }

    public boolean c() {
        return this.c;
    }

    public void d(mobi.ifunny.studio.comics.engine.c.h paramh, int paramInt) {
        synchronized (this.a) {
            ((mobi.ifunny.studio.comics.engine.c.g) this.v.get(paramInt)).d(paramh);
            return;
        }
    }

    public boolean d() {
        return this.r.get();
    }

    public mobi.ifunny.studio.a.b.b e() {
        mobi.ifunny.studio.a.b.b localb = new mobi.ifunny.studio.a.b.b();
        localb.a = this.u.z();
        Iterator localIterator = ((mobi.ifunny.studio.comics.engine.c.g) this.v.get(0)).c().iterator();
        while (localIterator.hasNext()) {
            d locald = mobi.ifunny.studio.comics.a.e.a((mobi.ifunny.studio.comics.engine.c.h) localIterator.next());
            localb.b.add(locald);
        }
        return localb;
    }

    public void e(mobi.ifunny.studio.comics.engine.c.h paramh, int paramInt) {
        synchronized (this.a) {
            ((mobi.ifunny.studio.comics.engine.c.g) this.v.get(paramInt)).e(paramh);
            return;
        }
    }

    public RectF f() {
        return this.f;
    }

    public void f(mobi.ifunny.studio.comics.engine.c.h paramh, int paramInt) {
        synchronized (this.a) {
            ((mobi.ifunny.studio.comics.engine.c.g) this.v.get(paramInt)).c(paramh);
            return;
        }
    }

    public RectF g() {
        return this.e.e();
    }

    public void h() {
        if (!d()) {
        }
        synchronized (this.a) {
            k();
            m();
            return;
        }
    }

    public void i() {
        l();
        synchronized (this.a) {
            n();
            if (this.z != null) {
                this.z.b(this);
            }
            return;
        }
    }

    public void j() {
        float f1 = this.f.width();
        float f2 = this.f.height();
        RectF localRectF = g();
        PointF localPointF = new PointF(0.0F, 0.0F);
        Iterator localIterator = this.v.iterator();
        while (localIterator.hasNext()) {
            mobi.ifunny.studio.comics.engine.c.g localg = (mobi.ifunny.studio.comics.engine.c.g) localIterator.next();
            localg.b(localPointF);
            localg.a(f1, f2);
            localg.a(localRectF);
        }
    }

    void k() {
        if (this.b != h.a) {
            return;
        }
        this.b = h.b;
        D();
    }

    public void l() {
        if (this.b != h.b) {
            return;
        }
        synchronized (this.a) {
            this.b = h.c;
            this.q.removeCallbacks(this.B);
            return;
        }
    }

    public void m() {
        if ((this.b != h.c) && (this.b != h.b)) {
            return;
        }
        synchronized (this.a) {
            this.b = h.b;
            this.q.post(this.B);
            return;
        }
    }

    void n() {
        E();
        this.b = h.a;
    }

    public void o() {
        B();
        b(a());
        a(new mobi.ifunny.studio.comics.engine.c.g());
    }

    public void p() {
        this.c = false;
        this.e.a();
        this.l = 0.0F;
        this.m = 0.0F;
        this.j = 0.0F;
        this.k = 0.0F;
        this.g = 0.0F;
    }

    public void q() {
        l();
        synchronized (this.a) {
            n();
            p();
            this.d = null;
            this.z = null;
            this.s.a(null);
            a(null);
            this.t.a(null);
            return;
        }
    }

    public mobi.ifunny.studio.comics.engine.a.h r() {
        return this.t;
    }

    public mobi.ifunny.studio.comics.engine.c.h s() {
        return this.w;
    }

    public float t() {
        return this.g;
    }

    public mobi.ifunny.studio.comics.engine.c.h u() {
        return this.u;
    }

    public a v() {
        return this.s.a();
    }

    public void w() {
        synchronized (this.a) {
            if (y()) {
                this.s.b();
            }
            return;
        }
    }

    public void x() {
        synchronized (this.a) {
            if (z()) {
                this.s.e();
            }
            return;
        }
    }

    public boolean y() {
        return this.s.f();
    }

    public boolean z() {
        return this.s.g();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/comics/engine/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */