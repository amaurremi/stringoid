package mobi.ifunny.studio.comics.engine.c;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.CornerPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class c
        extends h {
    private static final PorterDuffXfermode n = new PorterDuffXfermode(PorterDuff.Mode.SRC);
    private static final PorterDuffXfermode o = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
    private Bitmap c;
    private Canvas d;
    private Paint e;
    private d f;
    private Queue<mobi.ifunny.studio.comics.engine.d> g;
    private Queue<mobi.ifunny.studio.comics.engine.d> h;
    private f i;
    private mobi.ifunny.studio.comics.engine.d j;
    private boolean k;
    private boolean l = true;
    private boolean m;
    private boolean p;
    private int q;

    public c(Bitmap paramBitmap) {
        super(j.d);
        C().setPathEffect(new CornerPathEffect(2.0F));
        C().setDither(false);
        C().setFilterBitmap(true);
        C().setAntiAlias(true);
        C().setStyle(Paint.Style.STROKE);
        C().setStrokeJoin(Paint.Join.ROUND);
        C().setStrokeCap(Paint.Cap.ROUND);
        this.e = new Paint();
        this.e.setAntiAlias(true);
        this.e.setDither(true);
        this.g = new ConcurrentLinkedQueue();
        this.h = new ConcurrentLinkedQueue();
        this.k = true;
        a(paramBitmap);
    }

    private RectF a(List<mobi.ifunny.studio.comics.engine.d> paramList, RectF paramRectF) {
        int i1;
        label26:
        int i2;
        label29:
        mobi.ifunny.studio.comics.engine.d locald;
        if (paramRectF == null) {
            paramRectF = new RectF(100000.0F, 100000.0F, -100000.0F, -100000.0F);
            if (paramList != null) {
                break label85;
            }
            i1 = 0;
            i2 = 0;
            if (i2 >= i1) {
                return paramRectF;
            }
            locald = (mobi.ifunny.studio.comics.engine.d) paramList.get(i2);
            if ((locald.c() != 0) && (!locald.b())) {
                break label95;
            }
        }
        for (; ; ) {
            i2 += 1;
            break label29;
            paramRectF = new RectF(paramRectF);
            break;
            label85:
            i1 = paramList.size();
            break label26;
            label95:
            RectF localRectF = new RectF();
            locald.a(localRectF);
            if (localRectF.left < paramRectF.left) {
                paramRectF.left = localRectF.left;
            }
            if (localRectF.top < paramRectF.top) {
                paramRectF.top = localRectF.top;
            }
            if (localRectF.right > paramRectF.right) {
                paramRectF.right = localRectF.right;
            }
            if (localRectF.bottom > paramRectF.bottom) {
                paramRectF.bottom = localRectF.bottom;
            }
        }
        return paramRectF;
    }

    private void a(Canvas paramCanvas, Path paramPath, int paramInt1, int paramInt2, boolean paramBoolean, PointF paramPointF) {
        int i1 = z();
        e(paramInt2);
        paramInt2 = (int) C().getStrokeWidth();
        Paint localPaint = C();
        if (paramBoolean) {
        }
        for (PorterDuffXfermode localPorterDuffXfermode = o; ; localPorterDuffXfermode = n) {
            localPaint.setXfermode(localPorterDuffXfermode);
            C().setStrokeWidth(paramInt1);
            if (paramPointF != null) {
                float f1 = paramInt1 / 4;
                C().setStyle(Paint.Style.FILL);
                paramCanvas.drawCircle(paramPointF.x, paramPointF.y, f1, C());
                C().setStyle(Paint.Style.STROKE);
            }
            paramCanvas.drawPath(paramPath, C());
            C().setStrokeWidth(paramInt2);
            e(i1);
            return;
        }
    }

    private void a(Canvas paramCanvas, mobi.ifunny.studio.comics.engine.d paramd) {
        a(paramCanvas, paramd.e(), paramd.d(), paramd.c(), paramd.b(), paramd.a());
    }

    private void c(Canvas paramCanvas) {
        paramCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
        this.g.clear();
        if (this.f != null) {
            paramCanvas.save();
            int i1 = this.f.d().getWidth() / 2;
            int i2 = this.f.d().getHeight() / 2;
            paramCanvas.translate(this.f.a().x, this.f.a().y);
            paramCanvas.scale(this.f.c(), this.f.c());
            paramCanvas.rotate(this.f.b());
            paramCanvas.translate(-i1, -i2);
            paramCanvas.drawBitmap(this.f.d(), 0.0F, 0.0F, this.e);
            paramCanvas.restore();
        }
        for (this.l = false; this.i != null; this.l = true) {
            Iterator localIterator = this.i.a().iterator();
            while (localIterator.hasNext()) {
                mobi.ifunny.studio.comics.engine.d locald = (mobi.ifunny.studio.comics.engine.d) localIterator.next();
                if (!locald.b()) {
                    this.l = false;
                }
                a(paramCanvas, locald);
            }
        }
        if (!this.h.isEmpty()) {
            this.g.addAll(this.h);
            this.l = false;
        }
    }

    public e a(PointF paramPointF, List<mobi.ifunny.studio.comics.engine.d> paramList) {
        Object localObject3 = null;
        Matrix localMatrix = new Matrix();
        int i1;
        int i2;
        Object localObject1;
        if (this.f != null) {
            i1 = this.f.d().getWidth() / 2;
            i2 = this.f.d().getHeight() / 2;
            float f1 = this.f.a().x;
            float f2 = i1;
            float f3 = this.f.a().y;
            float f4 = i2;
            float f5 = this.f.a().x;
            float f6 = i1;
            float f7 = this.f.a().y;
            localObject1 = new RectF(f1 - f2, f3 - f4, f6 + f5, i2 + f7);
            localMatrix.setTranslate(this.f.a().x, this.f.a().y);
            localMatrix.preScale(this.f.c(), this.f.c());
            localMatrix.preRotate(this.f.b());
            localMatrix.preTranslate(-this.f.a().x, -this.f.a().y);
            mobi.ifunny.studio.comics.a.e.a((RectF) localObject1, (RectF) localObject1, localMatrix);
        }
        for (; ; ) {
            if (this.i == null) {
            }
            RectF localRectF;
            PointF localPointF2;
            PointF localPointF1;
            ArrayList localArrayList;
            for (; ; ) {
                localRectF = a(paramList, (RectF) localObject1);
                localPointF2 = new PointF(localRectF.left, localRectF.top);
                localPointF1 = new PointF(localPointF2.x + paramPointF.x, localPointF2.y + paramPointF.y);
                localArrayList = new ArrayList();
                localMatrix.setTranslate(-localPointF2.x, -localPointF2.y);
                if (this.i != null) {
                    List localList = this.i.a();
                    if (localList == null) {
                        i1 = 0;
                        i2 = 0;
                        label350:
                        if (i2 >= i1) {
                        }
                    } else {
                        try {
                            localObject1 = (mobi.ifunny.studio.comics.engine.d) ((mobi.ifunny.studio.comics.engine.d) localList.get(i2)).clone();
                            ((mobi.ifunny.studio.comics.engine.d) localObject1).a(localMatrix);
                            localArrayList.add(localObject1);
                            i2 += 1;
                            break label350;
                            localObject1 = a(this.i.a(), (RectF) localObject1);
                            continue;
                            i1 = localList.size();
                        } catch (CloneNotSupportedException localCloneNotSupportedException) {
                            for (; ; ) {
                                localObject2 = null;
                            }
                        }
                    }
                }
            }
            boolean bool1 = a();
            Object localObject2 = paramList.iterator();
            if (((Iterator) localObject2).hasNext()) {
                for (paramList = (mobi.ifunny.studio.comics.engine.d) ((Iterator) localObject2).next(); ; paramList = null) {
                    try {
                        boolean bool2 = paramList.b();
                        if (bool2) {
                            if (bool1) {
                                break;
                            }
                        }
                    } catch (CloneNotSupportedException paramList) {
                        try {
                            paramList = (mobi.ifunny.studio.comics.engine.d) paramList.clone();
                            bool1 = false;
                            paramList.a(localMatrix);
                            localArrayList.add(paramList);
                        } catch (CloneNotSupportedException paramList) {
                            for (; ; ) {
                                bool1 = false;
                                continue;
                                paramPointF = null;
                                continue;
                                paramList = null;
                            }
                        }
                        paramList = paramList;
                    }
                }
            }
            if (this.f != null) {
                paramList = new d(this.f.d());
                paramList.a(this.f.b());
                paramList.b(this.f.c());
                localObject2 = new float[4];
                localObject2[0] = this.f.a().x;
                localObject2[1] = this.f.a().y;
                localMatrix.mapPoints((float[]) localObject2);
                paramList.a(new PointF(localObject2[0], localObject2[1]));
                if (localArrayList.size() > 0) {
                    paramPointF = new f(localArrayList, new RectF(localPointF2.x, localPointF2.y, localPointF2.x + localRectF.width(), localPointF2.y + localRectF.height()), paramPointF, new RectF(localPointF1.x, localPointF1.y, localPointF1.x + localRectF.width(), localPointF1.y + localRectF.height()), B(), A(), m());
                    if (paramList == null) {
                        localObject2 = localObject3;
                        if (paramPointF == null) {
                        }
                    } else {
                        localObject2 = new e(paramList, paramPointF, new RectF(localPointF1.x, localPointF1.y, localPointF1.x + localRectF.width(), localPointF1.y + localRectF.height()), B(), A(), m());
                    }
                    return (e) localObject2;
                }
            }
            localObject2 = null;
        }
    }

    protected void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
        super.a(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
        if ((w() == null) || ((paramFloat1 == paramFloat3) && (paramFloat2 == paramFloat4))) {
            return;
        }
        if (this.c != null) {
            this.c.recycle();
            this.c = null;
        }
        Bitmap localBitmap = Bitmap.createBitmap((int) paramFloat3, (int) paramFloat4, Bitmap.Config.ARGB_8888);
        Canvas localCanvas = new Canvas();
        localCanvas.setBitmap(localBitmap);
        this.c = localBitmap;
        this.d = localCanvas;
        c(localCanvas);
    }

    public final void a(int paramInt) {
        this.q = paramInt;
    }

    public void a(Bitmap paramBitmap) {
        if (paramBitmap != null) {
            paramBitmap = new d(paramBitmap);
            this.f = paramBitmap;
            a(Math.max(u(), paramBitmap.d().getWidth()), Math.max(v(), paramBitmap.d().getHeight()));
        }
    }

    protected void a(Canvas paramCanvas) {
        if (this.c != null) {
            int i2 = this.g.size();
            int i1 = 0;
            while (i1 < i2) {
                mobi.ifunny.studio.comics.engine.d locald = (mobi.ifunny.studio.comics.engine.d) this.g.poll();
                a(this.d, locald);
                i1 += 1;
            }
            if (!this.k) {
                a(this.d, this.j);
                this.k = true;
            }
            paramCanvas.drawBitmap(this.c, 0.0F, 0.0F, this.e);
        }
    }

    public void a(Matrix paramMatrix) {
        this.i.a(paramMatrix);
        this.i.a(new RectF(0.0F, 0.0F, u(), v()));
        d(false);
        b(1.0F);
        c(0.0F);
        j();
    }

    public void a(PointF paramPointF) {
        this.j.a(paramPointF);
        this.k = false;
        this.l = false;
    }

    public void a(PointF paramPointF, float paramFloat1, float paramFloat2) {
        this.f.a(paramPointF);
        this.f.a(paramFloat1);
        this.f.b(paramFloat2);
        d(false);
        b(1.0F);
        c(0.0F);
        j();
    }

    public void a(d paramd) {
        this.f = paramd;
        j();
    }

    public void a(e parame) {
        c(parame.d());
        c(parame.e());
        b(parame.f());
        d(parame.c());
    }

    public void a(f paramf) {
        this.i = paramf;
        j();
    }

    public void a(mobi.ifunny.studio.comics.engine.d paramd) {
        this.g.add(paramd);
        this.h.add(paramd);
        this.l = false;
    }

    public void a(boolean paramBoolean) {
        this.p = paramBoolean;
    }

    public boolean a() {
        return this.l;
    }

    public void b() {
        super.b();
        if (this.c != null) {
            this.c.recycle();
        }
        this.d = null;
        this.e = null;
        this.g = null;
        this.h = null;
        this.j = null;
        this.f = null;
        this.i = null;
    }

    public boolean b(int paramInt) {
        if ((this.l) && (this.p)) {
            return false;
        }
        this.j = new mobi.ifunny.studio.comics.engine.d();
        a(paramInt);
        this.j.b(paramInt);
        this.j.a(z());
        this.j.a(this.p);
        this.k = true;
        this.m = true;
        return true;
    }

    public void c(int paramInt) {
        if (this.e != null) {
            this.e.setAlpha(paramInt);
        }
    }

    public boolean c() {
        Bitmap localBitmap = f();
        int i5 = localBitmap.getWidth();
        int i6 = localBitmap.getHeight();
        int i1 = 0;
        int i2 = 0;
        while (i1 < i6) {
            int i3 = 0;
            if (i3 < i5) {
                int i7 = localBitmap.getPixel(i3, i1);
                int i4 = i2;
                if (i7 != 0) {
                    if ((i7 & 0xFF000000) >= 536870912) {
                        break label80;
                    }
                    i4 = i2;
                }
                label80:
                do {
                    i3 += 1;
                    i2 = i4;
                    break;
                    i2 += 1;
                    i4 = i2;
                } while (i2 <= 1);
                return false;
            }
            i1 += 1;
        }
        return true;
    }

    public Object clone() {
        c localc = (c) super.clone();
        localc.e = new Paint(this.e);
        localc.g = new ConcurrentLinkedQueue(this.g);
        localc.h = new ConcurrentLinkedQueue(this.h);
        if (this.j != null) {
            localc.j = ((mobi.ifunny.studio.comics.engine.d) this.j.clone());
        }
        localc.p = this.p;
        localc.e(z());
        localc.q = this.q;
        if (this.f != null) {
            d locald = (d) localc.h().clone();
            locald.a(Bitmap.createBitmap(locald.d()));
            localc.a(locald);
        }
        if (this.i != null) {
            localc.a((f) this.i.clone());
        }
        return localc;
    }

    public void d() {
        this.k = true;
        this.j = null;
        this.m = false;
    }

    public mobi.ifunny.studio.comics.engine.d e() {
        return this.j;
    }

    public Bitmap f() {
        return this.c;
    }

    public f g() {
        return this.i;
    }

    public d h() {
        return this.f;
    }

    public int i() {
        if (this.e != null) {
            return this.e.getAlpha();
        }
        return 0;
    }

    public void j() {
        this.h.clear();
        d();
        this.l = true;
        c(this.d);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/comics/engine/c/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */