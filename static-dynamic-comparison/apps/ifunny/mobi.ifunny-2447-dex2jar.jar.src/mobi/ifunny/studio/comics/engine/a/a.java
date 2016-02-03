package mobi.ifunny.studio.comics.engine.a;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.view.KeyEvent;
import android.view.MotionEvent;

import java.util.ArrayList;
import java.util.EnumSet;

import mobi.ifunny.studio.comics.engine.c.h;

public final class a
        extends d {
    private EnumSet<b> a = EnumSet.noneOf(b.class);
    private final mobi.ifunny.studio.comics.engine.c.c b;
    private final boolean c;
    private mobi.ifunny.studio.comics.engine.c.e d;
    private Matrix e;
    private float[] f;
    private final int g;
    private int h;
    private boolean i;
    private int j;

    public a(g paramg, mobi.ifunny.studio.comics.engine.c.c paramc, boolean paramBoolean, int paramInt1, int paramInt2) {
        super(paramg, null);
        this.b = paramc;
        if (!paramBoolean) {
            this.c = false;
            this.d = null;
            a(-16777216);
            b(this.h);
            a(false);
            this.h = paramInt2;
            this.e = new Matrix();
            this.f = new float[2];
            this.g = paramInt1;
            return;
        }
        for (; ; ) {
            try {
                this.d = new mobi.ifunny.studio.comics.engine.c.e();
                if (paramc.g() == null) {
                    continue;
                }
                paramg = (mobi.ifunny.studio.comics.engine.c.f) paramc.g().clone();
                mobi.ifunny.studio.comics.engine.d locald = paramg.b();
                a(locald.c());
                b(locald.d());
                a(locald.b());
                this.d.a(paramg);
                if (paramc.h() != null) {
                    this.d.a((mobi.ifunny.studio.comics.engine.c.d) paramc.h().clone());
                }
                this.d.a(new RectF(paramc.w()));
                this.d.a(paramc.B());
                this.d.b(paramc.A());
                this.d.a(paramc.m());
            } catch (CloneNotSupportedException paramg) {
                this.d = null;
                continue;
            }
            this.c = true;
            break;
            a(-16777216);
            b(this.h);
            a(false);
        }
    }

    public a(mobi.ifunny.studio.comics.engine.c.c paramc, boolean paramBoolean, int paramInt1, int paramInt2) {
        this(null, paramc, paramBoolean, paramInt1, paramInt2);
    }

    private void a(PointF paramPointF) {
        this.b.a(paramPointF);
    }

    private void a(mobi.ifunny.studio.comics.engine.d paramd) {
        paramd = new mobi.ifunny.studio.comics.engine.b.e(this.b, paramd);
        if (h() != null) {
            h().a().a(paramd, mobi.ifunny.studio.comics.engine.c.b);
        }
    }

    private void k() {
        if (h() == null) {
            return;
        }
        mobi.ifunny.studio.comics.engine.f localf = h().a();
        this.b.f(false);
        this.b.j();
        localf.a(null);
    }

    private void l() {
        mobi.ifunny.studio.comics.engine.f localf = h().a();
        if (this.c) {
            this.b.a(this.d);
            if (this.d.a() != null) {
                this.b.a(this.d.a());
            }
            while (this.d.b() != null) {
                this.b.a(this.d.b());
                return;
                this.b.a(null);
            }
            this.b.a(null);
            return;
        }
        localf.b(this.b, this.g, mobi.ifunny.studio.comics.engine.c.c);
    }

    public mobi.ifunny.studio.comics.engine.c.c a() {
        return this.b;
    }

    public void a(int paramInt) {
        this.b.e(paramInt);
        this.j = paramInt;
    }

    public void a(boolean paramBoolean) {
        this.b.a(paramBoolean);
        this.i = paramBoolean;
    }

    public boolean a(int paramInt, KeyEvent paramKeyEvent) {
        return false;
    }

    public boolean a(MotionEvent paramMotionEvent) {
        super.a(paramMotionEvent);
        if (!this.a.contains(b.a)) {
            return false;
        }
        int k = paramMotionEvent.getAction();
        paramMotionEvent = new PointF(paramMotionEvent.getX(), paramMotionEvent.getY());
        paramMotionEvent = h().a().a(paramMotionEvent);
        this.f[0] = paramMotionEvent.x;
        this.f[1] = paramMotionEvent.y;
        this.e.mapPoints(this.f);
        paramMotionEvent.x = this.f[0];
        paramMotionEvent.y = this.f[1];
        switch (k) {
            default:
                return false;
            case 0:
                if (this.a.contains(b.b)) {
                    a(this.b.e());
                    this.b.d();
                }
                this.a.remove(b.b);
                if (this.b.b(this.h)) {
                    this.a.add(b.b);
                    a(new PointF(paramMotionEvent.x, paramMotionEvent.y));
                }
                return true;
            case 2:
                if (this.a.contains(b.b)) {
                    a(new PointF(paramMotionEvent.x, paramMotionEvent.y));
                }
                return true;
        }
        if (this.a.contains(b.b)) {
            a(this.b.e());
            this.b.d();
            this.a.remove(b.b);
        }
        return true;
    }

    public int b() {
        return this.j;
    }

    public void b(int paramInt) {
        this.h = paramInt;
    }

    public boolean b(int paramInt, KeyEvent paramKeyEvent) {
        return false;
    }

    public boolean c() {
        return this.i;
    }

    public int d() {
        return this.h;
    }

    public void e() {
        if ((h() == null) || (!this.a.isEmpty())) {
            return;
        }
        this.a.add(b.a);
        mobi.ifunny.studio.comics.engine.f localf = h().a();
        this.b.f(true);
        localf.a(null);
        if (!this.c) {
            localf.a(this.b, this.g, mobi.ifunny.studio.comics.engine.c.c);
        }
        for (; ; ) {
            this.e.setTranslate(-this.b.q().x, -this.b.q().y);
            localf.a(new c(localf, this.b));
            return;
            Object localObject = localf.g();
            Matrix localMatrix = new Matrix();
            localMatrix.setTranslate(this.b.s(), this.b.t());
            localMatrix.preTranslate(-((RectF) localObject).left, -((RectF) localObject).top);
            if (this.b.m()) {
                localMatrix.preScale(-1.0F, 1.0F);
            }
            localMatrix.preScale(this.b.A(), this.b.A());
            localMatrix.preRotate(this.b.B());
            localMatrix.preTranslate(-this.b.u() / 2.0F, -this.b.v() / 2.0F);
            if (this.d.a() != null) {
                localObject = this.d.a();
                this.f[0] = ((mobi.ifunny.studio.comics.engine.c.d) localObject).a().x;
                this.f[1] = ((mobi.ifunny.studio.comics.engine.c.d) localObject).a().y;
                localMatrix.mapPoints(this.f);
                PointF localPointF = new PointF(this.f[0], this.f[1]);
                mobi.ifunny.studio.comics.engine.c.c localc = this.b;
                float f1 = this.b.B();
                float f2 = ((mobi.ifunny.studio.comics.engine.c.d) localObject).b();
                float f3 = this.b.A();
                localc.a(localPointF, f1 + f2, ((mobi.ifunny.studio.comics.engine.c.d) localObject).c() * f3);
            }
            localf.j();
            if (this.d.b() != null) {
                this.b.a(localMatrix);
            }
        }
    }

    public void f() {
        if ((h() == null) || (!this.a.contains(b.a))) {
            return;
        }
        if (this.a.contains(b.b)) {
            a(this.b.e());
            this.b.d();
        }
        this.a.clear();
        mobi.ifunny.studio.comics.engine.f localf = h().a();
        ArrayList localArrayList = ((c) localf.v()).h();
        boolean bool = this.b.c();
        k();
        if (bool) {
            localObject2 = this.b;
            int k = this.g;
            if (this.c) {
            }
            for (localObject1 = mobi.ifunny.studio.comics.engine.c.a; ; localObject1 = mobi.ifunny.studio.comics.engine.c.c) {
                localf.b((h) localObject2, k, (mobi.ifunny.studio.comics.engine.c) localObject1);
                return;
            }
        }
        Object localObject3 = null;
        mobi.ifunny.studio.comics.engine.c localc = mobi.ifunny.studio.comics.engine.c.a;
        Object localObject1 = localc;
        Object localObject2 = localObject3;
        if (localArrayList != null) {
            localObject1 = localc;
            localObject2 = localObject3;
            if (localArrayList.size() > 0) {
                if (!this.c) {
                    break label238;
                }
            }
        }
        for (localObject1 = mobi.ifunny.studio.comics.engine.c.a; ; localObject1 = mobi.ifunny.studio.comics.engine.c.c) {
            localObject2 = this.b.a(this.b.q(), new ArrayList(localArrayList));
            if (localObject2 == null) {
                break;
            }
            localf.a(new mobi.ifunny.studio.comics.engine.b.f(this.b, (mobi.ifunny.studio.comics.engine.c.e) localObject2, this.d), (mobi.ifunny.studio.comics.engine.c) localObject1);
            return;
            label238:
            localf.a(this.b, this.g, mobi.ifunny.studio.comics.engine.c.b);
        }
        l();
    }

    public void g() {
        if (!this.a.contains(b.a)) {
            return;
        }
        if (this.a.contains(b.b)) {
            a(this.b.e());
            this.b.d();
        }
        this.a.clear();
        k();
        l();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/comics/engine/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */