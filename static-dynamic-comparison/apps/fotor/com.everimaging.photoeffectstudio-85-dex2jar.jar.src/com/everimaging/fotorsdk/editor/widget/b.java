package com.everimaging.fotorsdk.editor.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v8.renderscript.RenderScript;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.everimaging.fotorsdk.algorithms.filter.d;
import com.everimaging.fotorsdk.editor.R.color;
import com.everimaging.fotorsdk.editor.R.drawable;
import com.everimaging.fotorsdk.editor.filter.a.a;
import com.everimaging.fotorsdk.editor.filter.c;

import java.util.ArrayList;
import java.util.List;

public class b
        extends FrameLayout {
    private RenderScript a;
    private d b;
    private Context c;
    private int d;
    private RectF e;
    private Paint f;
    private ArrayList<a> g;
    private Path h;
    private boolean i;
    private float j;
    private int k = R.drawable.fotor_curve_point_button;
    private float[] l;
    private b m;
    private c n;
    private Path o;
    private boolean p;
    private boolean q = false;

    public b(Context paramContext, RenderScript paramRenderScript, d paramd) {
        super(paramContext);
        this.a = paramRenderScript;
        this.b = paramd;
        a(paramContext);
    }

    @SuppressLint({"NewApi"})
    private void a(Context paramContext) {
        if (Build.VERSION.SDK_INT >= 11) {
            setLayerType(1, null);
        }
        setWillNotDraw(false);
        this.c = paramContext;
        this.i = true;
        this.e = new RectF();
        this.f = new Paint();
        this.f.setStyle(Paint.Style.STROKE);
        this.f.setAntiAlias(true);
        this.f.setColor(-1);
        this.f.setAlpha(204);
        this.f.setStrokeWidth(2.0F);
        this.h = new Path();
        this.n = new c(new a.a() {
            public Context getContext() {
                return b.c(b.this);
            }

            public RenderScript getRenderScript() {
                return b.b(b.this);
            }

            public d getScript_BaseFilter() {
                return b.d(b.this);
            }
        });
        setPointNum(5);
        setBackgroundColor(paramContext.getResources().getColor(R.color.fotor_feature_adjust_curve_background));
    }

    private void a(Canvas paramCanvas) {
        this.h.reset();
        int i1 = 0;
        while (i1 < this.d) {
            ((a) this.g.get(i1)).a(paramCanvas);
            i1 += 1;
        }
        float f1 = this.e.width();
        float f2 = this.e.height();
        float f3 = this.e.top;
        float f4 = this.e.left;
        int i2 = this.l.length;
        a locala;
        if (this.g.size() > 0) {
            locala = (a) this.g.get(0);
            this.h.moveTo(locala.a(), locala.b());
        }
        float f5 = 1.0F / (i2 - 1);
        i1 = 2;
        float f6;
        float f7;
        while (i1 < i2 - 2) {
            f6 = i1;
            f7 = this.l[i1];
            float f8 = i1 + 2;
            float f9 = this.l[(i1 + 2)];
            this.h.quadTo(f6 * f5 * f1 + f4, (1.0F - f7) * f2 + f3, f8 * f5 * f1 + f4, (1.0F - f9) * f2 + f3);
            i1 += 2;
        }
        if (this.g.size() > 0) {
            locala = (a) this.g.get(this.d - 1);
            i1 = i2 - 2;
            f6 = i1;
            f7 = this.l[i1];
            this.h.quadTo(f1 * (f5 * f6) + f4, (1.0F - f7) * f2 + f3, locala.a(), locala.b());
        }
        paramCanvas.drawPath(this.h, this.f);
    }

    private void c() {
        this.l = this.n.a(new float[]{0.0F, 0.0F, 1.0F, 1.0F});
        if (this.l != null) {
        }
        for (int i2 = this.l.length; ; i2 = 0) {
            float f1 = this.e.width();
            float f2 = this.e.height();
            float f3 = this.e.top;
            float f4 = this.e.left;
            int i4 = i2 / (this.d - 1);
            this.o = new Path();
            int i3 = 0;
            int i1 = 0;
            if (i3 < this.d) {
                if (i3 != this.d - 1) {
                    break label312;
                }
                i1 = i2 - 1;
            }
            label312:
            for (; ; ) {
                float f6 = 1.0F / (i2 - 1);
                float f7 = i1;
                float f5 = this.l[i1];
                f6 = f4 + f6 * f7 * f1;
                f5 = f3 + (1.0F - f5) * f2;
                a locala = (a) this.g.get(i3);
                locala.a(this.e);
                locala.a(f6, f5);
                if (i3 == 0) {
                    this.o.moveTo(f6, f5);
                    locala.e();
                }
                for (; ; ) {
                    i3 += 1;
                    i1 += i4;
                    break;
                    if (i3 == this.d - 1) {
                        this.o.lineTo(f6, f5);
                        locala.e();
                    } else {
                        this.o.lineTo(f6, f5);
                        locala.f();
                    }
                }
                this.o.close();
                this.i = false;
                this.p = false;
                return;
            }
        }
    }

    private void d() {
        float f1 = this.e.width();
        float f2 = this.e.height();
        float f3 = this.e.top;
        float f4 = this.e.left;
        Object localObject1 = new ArrayList();
        int i1 = 0;
        float f6;
        while (i1 < this.d) {
            localObject2 = (a) this.g.get(i1);
            f6 = ((a) localObject2).a();
            f5 = ((a) localObject2).b();
            f6 = (f6 - f4) / f1;
            f5 = (f5 - f3) / f2;
            if (((a) localObject2).d()) {
                ((List) localObject1).add(Float.valueOf(f6));
                ((List) localObject1).add(Float.valueOf(1.0F - f5));
            }
            i1 += 1;
        }
        Object localObject2 = new float[((List) localObject1).size()];
        i1 = 0;
        while (i1 < ((List) localObject1).size()) {
            localObject2[i1] = ((Float) ((List) localObject1).get(i1)).floatValue();
            i1 += 1;
        }
        this.l = this.n.a((float[]) localObject2);
        int i3 = this.l.length;
        float f5 = 1.0F / (i3 - 1);
        i1 = 1;
        if (i1 < i3 - 1) {
            f6 = i1;
            float f7 = this.l[i1];
            float f8 = i1 + 1;
            int i2 = 1;
            for (; ; ) {
                if (i2 < this.d - 1) {
                    localObject1 = (a) this.g.get(i2);
                    if (!((a) localObject1).d()) {
                        float f9 = ((a) localObject1).a();
                        if ((f9 >= f4 + f6 * f5 * f1) && (f9 < f4 + f8 * f5 * f1)) {
                            ((a) localObject1).a(f3 + (1.0F - f7) * f2);
                        }
                    }
                } else {
                    i1 += 1;
                    break;
                }
                i2 += 1;
            }
        }
        if (this.m != null) {
            this.m.a(this.l);
        }
    }

    public boolean a() {
        return this.p;
    }

    public void b() {
        c();
        invalidate();
        if (this.m != null) {
            this.m.a(this.l);
        }
    }

    protected void onDraw(Canvas paramCanvas) {
        super.onDraw(paramCanvas);
        paramCanvas.drawRect(this.e, this.f);
        float f1 = this.e.width();
        float f2 = this.e.height();
        float f3 = this.e.left;
        float f4 = this.e.top;
        float f5 = this.e.right;
        float f6 = this.e.bottom;
        paramCanvas.drawLine(f3, f4 + f2 / 3.0F, f5, f4 + f2 / 3.0F, this.f);
        paramCanvas.drawLine(f3, f4 + f2 / 3.0F * 2.0F, f5, f4 + f2 / 3.0F * 2.0F, this.f);
        paramCanvas.drawLine(f3 + f1 / 3.0F, f4, f3 + f1 / 3.0F, f6, this.f);
        paramCanvas.drawLine(f3 + f1 / 3.0F * 2.0F, f4, f3 + f1 / 3.0F * 2.0F, f6, this.f);
        if (this.o != null) {
            paramCanvas.drawPath(this.o, this.f);
        }
        a(paramCanvas);
    }

    protected void onMeasure(int paramInt1, int paramInt2) {
        super.onMeasure(paramInt1, paramInt1);
    }

    protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
        this.e.left = 0.0F;
        this.e.top = 0.0F;
        this.e.right = paramInt1;
        this.e.bottom = paramInt2;
        this.e.inset(this.j, this.j);
        if (this.i) {
            c();
        }
    }

    public boolean onTouchEvent(MotionEvent paramMotionEvent) {
        int i1 = 0;
        a locala;
        float f1;
        float f2;
        if (i1 < this.d) {
            locala = (a) this.g.get(i1);
            f1 = locala.a();
            f2 = locala.b();
            if (i1 == 0) {
                break label217;
            }
            localObject1 = (a) this.g.get(i1 - 1);
        }
        label217:
        for (Object localObject1 = new PointF(((a) localObject1).a(), ((a) localObject1).b()); ; localObject1 = null) {
            if (i1 != this.d - 1) {
                localObject2 = (a) this.g.get(i1 + 1);
            }
            for (Object localObject2 = new PointF(((a) localObject2).a(), ((a) localObject2).b()); ; localObject2 = null) {
                if ((i1 == 0) || (i1 == this.d - 1)) {
                    localObject2 = null;
                    localObject1 = null;
                }
                if (locala.a(paramMotionEvent, (PointF) localObject1, (PointF) localObject2) == true) {
                    if ((f1 != locala.a()) || (f2 != locala.b())) {
                        this.p = true;
                    }
                    if (this.q) {
                        d();
                        invalidate();
                    }
                    return true;
                }
                i1 += 1;
                break;
            }
        }
    }

    public void setOnCurveChangedListener(b paramb) {
        this.m = paramb;
    }

    public void setPointNum(int paramInt) {
        this.d = paramInt;
        this.g = new ArrayList();
        int i1 = 0;
        while (i1 < paramInt) {
            a locala = new a(this.c, this.k, this.e);
            this.g.add(locala);
            this.j = (locala.c().getIntrinsicWidth() / 2.0F);
            if ((i1 == 0) || (i1 == paramInt - 1)) {
                locala.e();
            }
            i1 += 1;
        }
    }

    private class a {
        private PointF b = new PointF();
        private Drawable c;
        private Context d;
        private boolean e;
        private PointF f;
        private RectF g;
        private boolean h;

        public a(Context paramContext, int paramInt, RectF paramRectF) {
            this.d = paramContext;
            this.e = false;
            this.f = new PointF();
            this.g = paramRectF;
            a(paramInt);
        }

        public float a() {
            return this.b.x;
        }

        public void a(float paramFloat) {
            this.b.y = paramFloat;
        }

        public void a(float paramFloat1, float paramFloat2) {
            this.b.set(paramFloat1, paramFloat2);
        }

        public void a(int paramInt) {
            this.c = this.d.getResources().getDrawable(paramInt);
        }

        public void a(Canvas paramCanvas) {
            int i = this.c.getIntrinsicWidth();
            int j = this.c.getIntrinsicHeight();
            Rect localRect = new Rect();
            localRect.left = ((int) (this.b.x - i / 2.0F + 0.5D));
            localRect.top = ((int) (this.b.y - j / 2.0F + 0.5D));
            localRect.right = (i + localRect.left);
            localRect.bottom = (localRect.top + j);
            this.c.setBounds(localRect);
            this.c.draw(paramCanvas);
        }

        public void a(RectF paramRectF) {
            this.g = paramRectF;
        }

        public boolean a(MotionEvent paramMotionEvent, PointF paramPointF1, PointF paramPointF2) {
            float f5 = paramMotionEvent.getX();
            float f6 = paramMotionEvent.getY();
            switch (paramMotionEvent.getAction()) {
            }
            do {
                do {
                    do {
                        return false;
                    }
                    while ((f5 < this.b.x - b.a(b.this)) || (f5 > this.b.x + b.a(b.this)) || (f6 < this.b.y - b.a(b.this)) || (f6 > this.b.y + b.a(b.this)));
                    this.f.set(f5, f6);
                    this.e = true;
                    this.c.setState(new int[]{16842919});
                    return true;
                } while (!this.e);
                b.a(b.this, true);
                float f2 = f5 - this.f.x;
                float f4 = f6 - this.f.y;
                float f7 = this.c.getIntrinsicWidth() / 2.0F;
                float f1 = f2;
                if (paramPointF1 != null) {
                    f1 = f2;
                    if (this.b.x + f2 < paramPointF1.x + f7) {
                        f1 = paramPointF1.x + f7 - this.b.x;
                    }
                }
                f2 = f1;
                if (paramPointF2 != null) {
                    f2 = f1;
                    if (this.b.x + f1 > paramPointF2.x - f7) {
                        f2 = paramPointF2.x - f7 - this.b.x;
                    }
                }
                float f3 = f2;
                if (this.b.x + f2 < this.g.left + f7) {
                    f3 = this.g.left + f7 - this.b.x;
                }
                f1 = f3;
                if (this.b.x + f3 > this.g.right - f7) {
                    f1 = this.g.right - f7 - this.b.x;
                }
                f2 = f4;
                if (this.b.y + f4 < this.g.top) {
                    f2 = this.g.top - this.b.y;
                }
                f3 = f2;
                if (this.b.y + f2 > this.g.bottom) {
                    f3 = this.g.bottom - this.b.y;
                }
                f2 = f1;
                if (paramPointF1 == null) {
                    f2 = f1;
                    if (paramPointF2 == null) {
                        f2 = 0.0F;
                    }
                }
                paramMotionEvent = this.b;
                paramMotionEvent.x = (f2 + paramMotionEvent.x);
                paramMotionEvent = this.b;
                paramMotionEvent.y = (f3 + paramMotionEvent.y);
                this.f.set(f5, f6);
                this.h = true;
                return true;
            } while (!this.e);
            this.e = false;
            this.c.setState(new int[0]);
            b.a(b.this, false);
            return true;
        }

        public float b() {
            return this.b.y;
        }

        public Drawable c() {
            return this.c;
        }

        public boolean d() {
            return this.h;
        }

        public void e() {
            this.h = true;
        }

        public void f() {
            this.h = false;
        }
    }

    public static abstract interface b {
        public abstract void a(float[] paramArrayOfFloat);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/editor/widget/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */