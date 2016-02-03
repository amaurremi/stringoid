package com.everimaging.fotorsdk.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.FloatMath;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.everimaging.fotorsdk.R.dimen;
import com.everimaging.fotorsdk.log.FotorLoggerFactory;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.LoggerType;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.c;

public class FotorImageView
        extends ImageView {
    private static final String v = FotorImageView.class.getSimpleName();
    private static final FotorLoggerFactory.c w = FotorLoggerFactory.a(v, FotorLoggerFactory.LoggerType.CONSOLE);
    private final float[] A = new float[9];
    private boolean B = true;
    private Matrix C;
    private boolean D;
    private boolean E;
    private RectF F = new RectF();
    private RectF G = new RectF();
    private boolean H = false;
    private boolean I;
    private boolean J;
    private float K;
    private float L;
    private float M;
    private float N;
    private boolean O;
    private float P;
    private float Q;
    private long R;
    private long S;
    private boolean T = true;
    protected Matrix a = new Matrix();
    protected Matrix b = new Matrix();
    protected float c = 2.0F;
    protected float d = 0.5F;
    protected float e;
    protected c f;
    protected b g;
    protected float h;
    protected float i;
    protected a j;
    protected boolean k;
    protected float l;
    protected Handler m = new Handler();
    protected int n;
    protected int o;
    protected PointF p = new PointF();
    protected Handler q = new Handler() {
        public void handleMessage(Message paramAnonymousMessage) {
            switch (paramAnonymousMessage.what) {
            }
            do {
                do {
                    do {
                        do {
                            return;
                            FotorImageView.j().c(new Object[]{"single click"});
                        } while (FotorImageView.this.f == null);
                        FotorImageView.this.f.a(FotorImageView.this);
                        return;
                        FotorImageView.j().c(new Object[]{"long press down"});
                    } while (FotorImageView.this.f == null);
                    FotorImageView.this.f.c(FotorImageView.this);
                    return;
                    FotorImageView.j().c(new Object[]{"long press up"});
                } while (FotorImageView.this.f == null);
                FotorImageView.this.f.d(FotorImageView.this);
                return;
                FotorImageView.j().c(new Object[]{"double click"});
            } while (FotorImageView.this.f == null);
            FotorImageView.this.f.b(FotorImageView.this);
        }
    };
    float r = 0.0F;
    float s = 0.0F;
    float t = 0.0F;
    float u = 0.0F;
    private Paint x;
    private PaintFlagsDrawFilter y;
    private final Matrix z = new Matrix();

    public FotorImageView(Context paramContext) {
        super(paramContext);
        a(paramContext);
    }

    public FotorImageView(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
        a(paramContext);
    }

    public FotorImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
        a(paramContext);
    }

    private float a(MotionEvent paramMotionEvent) {
        try {
            float f1 = paramMotionEvent.getX(0) - paramMotionEvent.getX(1);
            float f2 = paramMotionEvent.getY(0) - paramMotionEvent.getY(1);
            f1 = FloatMath.sqrt(f1 * f1 + f2 * f2);
            return f1;
        } catch (Exception paramMotionEvent) {
            paramMotionEvent.printStackTrace();
        }
        return 0.0F;
    }

    private void a(final float paramFloat) {
        final Drawable localDrawable = getDrawable();
        if (localDrawable == null) {
            return;
        }
        this.t = 0.0F;
        this.u = 0.0F;
        float f1 = getScale();
        final float f2 = (this.e - f1) / paramFloat;
        final float f8 = this.h;
        float f9 = a(this.b, 2);
        final float f3 = this.i;
        float f4 = a(this.b, 5);
        float f10 = localDrawable.getIntrinsicWidth();
        float f11 = this.e;
        float f12 = localDrawable.getIntrinsicWidth();
        float f5 = localDrawable.getIntrinsicHeight();
        float f6 = this.e;
        float f7 = localDrawable.getIntrinsicHeight();
        f8 = (f8 - f9 - (f10 * f1 - f11 * f12) / 2.0F) / paramFloat;
        f3 = (f3 - f4 - (f5 * f1 - f6 * f7) / 2.0F) / paramFloat;
        final long l1 = System.currentTimeMillis();
        this.m.post(new Runnable() {
            public void run() {
                long l = System.currentTimeMillis();
                float f1 = Math.min(paramFloat, (float) (l - l1));
                float f2 = f2;
                float f3 = localDrawable;
                float f4 = f8.getIntrinsicWidth() * FotorImageView.this.getScale() / 2.0F;
                float f5 = FotorImageView.this.a(FotorImageView.this.b, 2);
                float f6 = f8.getIntrinsicHeight() * FotorImageView.this.getScale() / 2.0F;
                float f7 = FotorImageView.this.a(FotorImageView.this.b, 5);
                FotorImageView.this.b(f2 + f3 * f1, f4 + f5, f6 + f7);
                FotorImageView.this.b(f3 * f1 - FotorImageView.this.t, this.g * f1 - FotorImageView.this.u);
                FotorImageView.this.t = (f3 * f1);
                FotorImageView.this.u = (this.g * f1);
                if (f1 < paramFloat) {
                    FotorImageView.this.m.post(this);
                }
            }
        });
    }

    private void a(Context paramContext) {
        setLongPressEnable(true);
        setDoubleClickEnable(true);
        this.x = new Paint();
        this.x.setAntiAlias(true);
        this.x.setFilterBitmap(true);
        setScaleType(ImageView.ScaleType.MATRIX);
        setWillNotDraw(false);
        this.y = new PaintFlagsDrawFilter(0, 3);
        this.l = paramContext.getResources().getDimension(R.dimen.fotor_main_imageview_margin);
        setFocusable(true);
        setFocusableInTouchMode(true);
    }

    private void b() {
        if (this.j != null) {
            this.m.removeCallbacks(this.j);
        }
        if (this.k) {
            this.q.sendEmptyMessage(3);
        }
        this.k = false;
    }

    private void b(Bitmap paramBitmap, boolean paramBoolean) {
        if ((paramBitmap != null) && (paramBoolean)) {
            a(getDrawable());
            setImageMatrix(getImageViewMatrix());
        }
    }

    protected float a(Matrix paramMatrix) {
        return a(paramMatrix, 0);
    }

    protected float a(Matrix paramMatrix, int paramInt) {
        paramMatrix.getValues(this.A);
        return this.A[paramInt];
    }

    protected RectF a(Matrix paramMatrix, boolean paramBoolean1, boolean paramBoolean2) {
        if (getDrawable() == null) {
            return new RectF(0.0F, 0.0F, 0.0F, 0.0F);
        }
        this.F.set(0.0F, 0.0F, 0.0F, 0.0F);
        paramMatrix = b(paramMatrix);
        float f1 = paramMatrix.height();
        float f2 = paramMatrix.width();
        int i1;
        if (paramBoolean2) {
            i1 = this.n;
            if (f1 < i1) {
                f1 = (i1 - f1) / 2.0F - paramMatrix.top;
            }
        }
        for (; ; ) {
            if (paramBoolean1) {
                i1 = this.o;
                if (f2 < i1) {
                    f2 = (i1 - f2) / 2.0F - paramMatrix.left;
                }
            }
            for (; ; ) {
                this.F.set(f2, f1, 0.0F, 0.0F);
                return this.F;
                if (paramMatrix.top > 0.0F) {
                    f1 = -paramMatrix.top;
                    break;
                }
                if (paramMatrix.bottom >= i1) {
                    break label228;
                }
                f1 = this.n - paramMatrix.bottom;
                break;
                if (paramMatrix.left > 0.0F) {
                    f2 = -paramMatrix.left;
                } else if (paramMatrix.right < i1) {
                    f2 = i1 - paramMatrix.right;
                } else {
                    f2 = 0.0F;
                }
            }
            label228:
            f1 = 0.0F;
        }
    }

    public void a() {
        Drawable localDrawable = getDrawable();
        if (localDrawable == null) {
            return;
        }
        this.e = Math.min((this.o - this.l) / localDrawable.getIntrinsicWidth(), (this.n - this.l) / localDrawable.getIntrinsicHeight());
        if (this.e > 1.0F) {
            this.e = 1.0F;
        }
        this.d = (this.e / 2.0F);
        w.c(new Object[]{"arithScaleRate scaleRate:" + this.e});
    }

    public void a(float paramFloat1, float paramFloat2, float paramFloat3) {
        float f1;
        if (paramFloat1 > this.c) {
            f1 = this.c;
        }
        for (; ; ) {
            paramFloat1 = f1 / getScale();
            this.b.postScale(paramFloat1, paramFloat1, paramFloat2, paramFloat3);
            setImageMatrix(getImageViewMatrix());
            a(true, true);
            return;
            f1 = paramFloat1;
            if (paramFloat1 < this.d) {
                f1 = this.d;
            }
        }
    }

    protected void a(final float paramFloat1, final float paramFloat2, final float paramFloat3, final float paramFloat4) {
        paramFloat1 = (paramFloat1 - getScale()) / paramFloat4;
        float f1 = getScale();
        final long l1 = System.currentTimeMillis();
        this.m.post(new Runnable() {
            public void run() {
                long l = System.currentTimeMillis();
                float f1 = Math.min(paramFloat4, (float) (l - l1));
                float f2 = paramFloat1;
                float f3 = paramFloat2;
                FotorImageView.this.a(f2 + f3 * f1, paramFloat3, this.f);
                if (f1 < paramFloat4) {
                    FotorImageView.this.m.post(this);
                }
            }
        });
    }

    protected void a(long paramLong) {
        if ((h()) && (getScale() <= this.e)) {
            this.k = false;
            if (this.j == null) {
                this.j = new a();
            }
            this.m.postDelayed(this.j, 600L - paramLong);
        }
    }

    public void a(Bitmap paramBitmap, boolean paramBoolean) {
        if (paramBitmap == null) {
            super.setImageDrawable(null);
        }
        for (; ; ) {
            if (getWidth() > 0) {
                b(paramBitmap, paramBoolean);
            }
            return;
            super.setImageBitmap(paramBitmap);
        }
    }

    protected void a(Drawable paramDrawable) {
        a();
        a(this.e, 0.0F, 0.0F);
        float[] arrayOfFloat = new float[9];
        getImageViewMatrix().getValues(arrayOfFloat);
        float f1 = (this.o - paramDrawable.getIntrinsicWidth() * this.e) / 2.0F;
        arrayOfFloat[2] = f1;
        this.h = f1;
        f1 = (this.n - paramDrawable.getIntrinsicHeight() * this.e) / 2.0F;
        arrayOfFloat[5] = f1;
        this.i = f1;
        this.b.setValues(arrayOfFloat);
        this.C = new Matrix(this.b);
    }

    protected void a(boolean paramBoolean1, boolean paramBoolean2) {
        if (getDrawable() == null) {
        }
        RectF localRectF;
        do {
            return;
            localRectF = a(this.b, paramBoolean1, paramBoolean2);
        } while ((localRectF.left == 0.0F) && (localRectF.top == 0.0F));
        b(localRectF.left, localRectF.top);
    }

    protected RectF b(Matrix paramMatrix) {
        Drawable localDrawable = getDrawable();
        if (localDrawable == null) {
            return null;
        }
        paramMatrix = c(paramMatrix);
        this.G.set(0.0F, 0.0F, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
        paramMatrix.mapRect(this.G);
        return this.G;
    }

    public void b(float paramFloat1, float paramFloat2) {
        this.b.postTranslate(paramFloat1, paramFloat2);
        setImageMatrix(getImageViewMatrix());
    }

    public void b(float paramFloat1, float paramFloat2, float paramFloat3) {
        float f1;
        if (paramFloat1 > this.c) {
            f1 = this.c;
        }
        for (; ; ) {
            paramFloat1 = f1 / getScale();
            this.b.postScale(paramFloat1, paramFloat1, paramFloat2, paramFloat3);
            setImageMatrix(getImageViewMatrix());
            return;
            f1 = paramFloat1;
            if (paramFloat1 < this.d) {
                f1 = this.d;
            }
        }
    }

    public Matrix c(Matrix paramMatrix) {
        this.z.set(this.a);
        this.z.postConcat(paramMatrix);
        return this.z;
    }

    public void c() {
        Drawable localDrawable = getDrawable();
        if (localDrawable == null) {
            return;
        }
        float f3 = a(this.b, 2);
        float f4 = a(this.b, 5);
        if ((getScale() <= this.e) || (localDrawable.getIntrinsicWidth() * getScale() < this.o)) {
        }
        for (float f1 = (this.o - getScale() * localDrawable.getIntrinsicWidth()) / 2.0F; ; f1 = 0.0F) {
            if ((getScale() <= this.e) || (localDrawable.getIntrinsicHeight() * getScale() < this.n)) {
            }
            for (float f2 = (this.n - getScale() * localDrawable.getIntrinsicHeight()) / 2.0F; ; f2 = 0.0F) {
                float f5 = this.o - (localDrawable.getIntrinsicWidth() * getScale() + f3);
                float f6 = this.n - (localDrawable.getIntrinsicHeight() * getScale() + f4);
                if (f3 > 0.0F) {
                    d(f1 - f3, 200.0F);
                }
                if (f4 > 0.0F) {
                    c(f2 - f4, 200.0F);
                }
                if (f5 > 0.0F) {
                    d(f5 - f1, 200.0F);
                }
                if (f6 <= 0.0F) {
                    break;
                }
                c(f6 - f2, 200.0F);
                return;
            }
        }
    }

    protected void c(float paramFloat1, final float paramFloat2) {
        this.r = 0.0F;
        paramFloat1 /= paramFloat2;
        final long l1 = System.currentTimeMillis();
        this.m.post(new Runnable() {
            public void run() {
                long l = System.currentTimeMillis();
                float f = Math.min(paramFloat2, (float) (l - l1));
                FotorImageView.this.b(0.0F, this.c * f - FotorImageView.this.r);
                FotorImageView.this.r = (this.c * f);
                if (f < paramFloat2) {
                    FotorImageView.this.m.post(this);
                }
            }
        });
    }

    public void c(float paramFloat1, float paramFloat2, float paramFloat3) {
        float f2 = getScale();
        float f1;
        if (f2 * paramFloat1 > this.c) {
            f1 = this.c / f2;
        }
        for (; ; ) {
            this.b.postScale(f1, f1, paramFloat2, paramFloat3);
            setImageMatrix(getImageViewMatrix());
            return;
            f1 = paramFloat1;
            if (f2 * paramFloat1 < this.d) {
                f1 = this.d / f2;
            }
        }
    }

    protected void d() {
        w.c(new Object[]{"doubleClick：getScale:" + getScale()});
        if (getScale() > this.e) {
            a(250.0F);
        }
        for (; ; ) {
            this.q.obtainMessage(4).sendToTarget();
            return;
            a(this.c, getWidth() / 2.0F, getHeight() / 2.0F, 200.0F);
        }
    }

    protected void d(float paramFloat1, final float paramFloat2) {
        this.s = 0.0F;
        paramFloat1 /= paramFloat2;
        final long l1 = System.currentTimeMillis();
        this.m.post(new Runnable() {
            public void run() {
                long l = System.currentTimeMillis();
                float f = Math.min(paramFloat2, (float) (l - l1));
                FotorImageView.this.b(this.c * f - FotorImageView.this.s, 0.0F);
                FotorImageView.this.s = (this.c * f);
                if (f < paramFloat2) {
                    FotorImageView.this.m.post(this);
                }
            }
        });
    }

    public void f() {
        if (this.C != null) {
            this.b = new Matrix(this.C);
            setImageMatrix(getImageViewMatrix());
            return;
        }
        this.b.reset();
        setImageMatrix(getImageViewMatrix());
    }

    protected void g() {
        w.c(new Object[]{"singleClick"});
        this.q.obtainMessage(1).sendToTarget();
    }

    public int getContentHeight() {
        return getHeight() - getPaddingTop() - getPaddingBottom();
    }

    public int getContentWidth() {
        return getWidth() - getPaddingLeft() - getPaddingRight();
    }

    public Matrix getImageViewMatrix() {
        return c(this.b);
    }

    public RectF getPictureRectF() {
        RectF localRectF = new RectF();
        getImageMatrix().mapRect(localRectF);
        localRectF.right = (getWidth() - localRectF.left - getPaddingLeft() - getPaddingRight());
        localRectF.bottom = (getHeight() - localRectF.top - getPaddingTop() - getPaddingBottom());
        return localRectF;
    }

    public float getScale() {
        return a(this.b);
    }

    public boolean h() {
        return this.D;
    }

    public boolean i() {
        return this.E;
    }

    protected void onDraw(Canvas paramCanvas) {
        paramCanvas.setDrawFilter(this.y);
        super.onDraw(paramCanvas);
    }

    protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        w.c(new Object[]{"onLayout ->changed:" + paramBoolean + ",left:" + paramInt1 + ",top:" + paramInt2 + ",right:" + paramInt3 + ",bottom:" + paramInt4});
        super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
        if (paramBoolean) {
            this.o = (paramInt3 - paramInt1);
            this.n = (paramInt4 - paramInt2);
            this.p.x = (this.o / 2.0F);
            this.p.y = (this.n / 2.0F);
        }
        Drawable localDrawable = getDrawable();
        if ((localDrawable != null) && (paramBoolean)) {
            a(localDrawable);
            setImageMatrix(getImageViewMatrix());
        }
        if ((paramBoolean) && (this.g != null)) {
            this.g.a();
        }
    }

    protected void onRestoreInstanceState(Parcelable paramParcelable) {
        w.c(new Object[]{"onRestoreInstanceState"});
        super.onRestoreInstanceState(paramParcelable);
    }

    protected Parcelable onSaveInstanceState() {
        w.c(new Object[]{"onSaveInstanceState"});
        return super.onSaveInstanceState();
    }

    public boolean onTouchEvent(MotionEvent paramMotionEvent) {
        boolean bool2 = true;
        boolean bool1;
        if (!this.B) {
            bool1 = super.onTouchEvent(paramMotionEvent);
        }
        label540:
        do {
            do {
                do {
                    do {
                        do {
                            do {
                                do {
                                    return bool1;
                                    switch (paramMotionEvent.getAction() & 0xFF) {
                                        case 4:
                                        default:
                                            return true;
                                        case 0:
                                            this.M = paramMotionEvent.getX();
                                            this.N = paramMotionEvent.getY();
                                            this.R = System.currentTimeMillis();
                                            a(0L);
                                            return true;
                                        case 2:
                                            bool1 = bool2;
                                    }
                                } while (this.k);
                                f1 = paramMotionEvent.getX();
                                f2 = paramMotionEvent.getY();
                                if ((!this.I) && (FloatMath.sqrt((f1 - this.M) * (f1 - this.M) + (f2 - this.N) * (f2 - this.N)) >= 10.0F) && ((getScale() > this.e) || (this.H))) {
                                    this.I = true;
                                    b();
                                }
                                if (!this.J) {
                                    break;
                                }
                                this.L = a(paramMotionEvent);
                                bool1 = bool2;
                            } while (this.L < 5.0F);
                            f1 = this.L - this.K;
                            bool1 = bool2;
                        } while (f1 == 0.0F);
                        bool1 = bool2;
                    } while (Math.abs(f1) <= 5.0F);
                    f1 = this.L / this.K;
                    this.P = (paramMotionEvent.getX(0) + (paramMotionEvent.getX(1) - paramMotionEvent.getX(0)) / 2.0F);
                    this.Q = (paramMotionEvent.getY(0) + (paramMotionEvent.getY(1) - paramMotionEvent.getY(0)) / 2.0F);
                    c(f1, this.P, this.Q);
                    this.K = this.L;
                    return true;
                    bool1 = bool2;
                } while (!this.I);
                bool1 = bool2;
            } while (this.O);
            float f3 = this.M;
            float f4 = this.N;
            this.M = f1;
            this.N = f2;
            b(f1 - f3, f2 - f4);
            return true;
            if ((!this.O) && (!this.I)) {
                this.S = System.currentTimeMillis();
                f1 = this.M - paramMotionEvent.getX();
                f2 = this.N - paramMotionEvent.getY();
                f1 = FloatMath.sqrt(f1 * f1 + f2 * f2);
                if ((this.S - this.R < 500L) && (f1 < 5.0F) && (!this.k)) {
                    if (i()) {
                        break label540;
                    }
                    g();
                }
            }
            for (; ; ) {
                if ((!this.O) || ((this.O) && (getScale() >= this.e))) {
                    c();
                }
                this.I = false;
                this.O = false;
                b();
                return true;
                if (this.T == true) {
                    this.T = false;
                    new Thread() {
                        public void run() {
                            try {
                                sleep(350L);
                                if (!FotorImageView.e(FotorImageView.this)) {
                                    FotorImageView.a(FotorImageView.this, true);
                                    FotorImageView.this.g();
                                }
                                return;
                            } catch (InterruptedException localInterruptedException) {
                                localInterruptedException.printStackTrace();
                            }
                        }
                    }.start();
                } else {
                    this.T = true;
                    d();
                }
            }
            bool1 = bool2;
        } while (this.k);
        this.O = true;
        float f1 = Math.min(paramMotionEvent.getX(0), paramMotionEvent.getX(1));
        float f2 = Math.min(paramMotionEvent.getY(0), paramMotionEvent.getY(1));
        this.P = (f1 - a(this.b, 2) + Math.abs((paramMotionEvent.getX(0) - paramMotionEvent.getX(1)) / 2.0F));
        this.Q = (f2 - a(this.b, 5) + Math.abs((paramMotionEvent.getY(0) - paramMotionEvent.getY(1)) / 2.0F));
        this.I = false;
        this.K = a(paramMotionEvent);
        if (this.K > 5.0F) {
            this.J = true;
        }
        b();
        return true;
        this.J = false;
        this.I = false;
        if (getScale() < this.e) {
            f1 = getWidth() / 2.0F;
            f2 = getHeight() / 2.0F;
            a(this.e, f1, f2, (float) 250L);
        }
        b();
        return true;
    }

    public void setDoubleClickEnable(boolean paramBoolean) {
        this.E = paramBoolean;
    }

    public void setFotorImageViewLayoutListener(b paramb) {
        this.g = paramb;
    }

    public void setFotorImageViewListener(c paramc) {
        this.f = paramc;
    }

    public void setImageBitmap(Bitmap paramBitmap) {
        a(paramBitmap, true);
    }

    public void setIsCanFitMove(boolean paramBoolean) {
        this.H = paramBoolean;
    }

    public void setLongPressEnable(boolean paramBoolean) {
        this.D = paramBoolean;
    }

    public void setTouchable(boolean paramBoolean) {
        this.B = paramBoolean;
    }

    public class a
            implements Runnable {
        public a() {
        }

        public void run() {
            FotorImageView.this.q.sendEmptyMessage(2);
            FotorImageView.this.k = true;
        }
    }

    public static abstract interface b {
        public abstract void a();
    }

    public static abstract interface c {
        public abstract void a(FotorImageView paramFotorImageView);

        public abstract void b(FotorImageView paramFotorImageView);

        public abstract void c(FotorImageView paramFotorImageView);

        public abstract void d(FotorImageView paramFotorImageView);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/widget/FotorImageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */