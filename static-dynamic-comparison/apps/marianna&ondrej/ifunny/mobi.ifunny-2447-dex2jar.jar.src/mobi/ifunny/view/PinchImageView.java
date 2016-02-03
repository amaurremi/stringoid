package mobi.ifunny.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.view.as;
import android.support.v4.view.bd;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.FloatMath;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.Scroller;

import java.lang.reflect.Field;

import mobi.ifunny.gallery.view.f;
import mobi.ifunny.gallery.view.g;

public class PinchImageView
        extends ImageView
        implements mobi.ifunny.gallery.view.d {
    private static final String a = PinchImageView.class.getSimpleName();
    private float A;
    private Matrix B = new Matrix();
    private PointF C = new PointF();
    private boolean D;
    private boolean E;
    private boolean F;
    private f G;
    private final PointF H = new PointF();
    private final Rect I = new Rect();
    private boolean J;
    private Runnable K = new o(this);
    private int b;
    protected int c;
    protected int d;
    protected int e;
    protected int f;
    protected final Rect g = new Rect();
    protected final Rect h = new Rect();
    protected final Rect i = new Rect();
    private q j;
    private boolean k;
    private int l;
    private boolean m;
    private int n;
    private int o;
    private boolean p;
    private float q;
    private float r;
    private float s;
    private float t;
    private Matrix u;
    private Matrix v;
    private float[] w = new float[9];
    private g x;
    private Scroller y;
    private boolean z;

    public PinchImageView(Context paramContext) {
        this(paramContext, null);
    }

    public PinchImageView(Context paramContext, AttributeSet paramAttributeSet) {
        this(paramContext, paramAttributeSet, 0);
    }

    public PinchImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
        paramAttributeSet = paramContext.getResources();
        setScaleType(ImageView.ScaleType.MATRIX);
        this.v = new Matrix();
        this.j = q.a;
        this.k = false;
        this.m = false;
        TypedArray localTypedArray = paramContext.getTheme().obtainStyledAttributes(new int[]{2130771970});
        this.l = localTypedArray.getDimensionPixelSize(0, 0);
        localTypedArray.recycle();
        this.n = paramAttributeSet.getDimensionPixelSize(2131427423);
        this.o = paramAttributeSet.getDimensionPixelSize(2131427393);
        this.p = paramAttributeSet.getBoolean(2131296262);
        this.q = (paramAttributeSet.getDisplayMetrics().density * 1.5F);
        this.r = 1.0F;
        this.x = new g(paramContext, new r(this, null));
        this.x.a(true);
        try {
            paramAttributeSet = GestureDetector.class.getDeclaredField("mTouchSlopSquare");
            paramAttributeSet.setAccessible(true);
            paramInt = paramAttributeSet.getInt(this.x);
            paramAttributeSet.set(this.x, Integer.valueOf(paramInt * 2));
            this.y = new Scroller(paramContext);
            setVerticalScrollBarEnabled(true);
            setHorizontalScrollBarEnabled(true);
            this.z = false;
            this.D = true;
            this.E = false;
            this.F = false;
            this.J = true;
            return;
        } catch (NoSuchFieldException paramAttributeSet) {
            for (; ; ) {
            }
        } catch (IllegalArgumentException paramAttributeSet) {
            for (; ; ) {
            }
        } catch (IllegalAccessException paramAttributeSet) {
            for (; ; ) {
            }
        }
    }

    private float a(MotionEvent paramMotionEvent) {
        if (paramMotionEvent.getPointerCount() > 1) {
            float f1 = paramMotionEvent.getX(0) - paramMotionEvent.getX(1);
            float f2 = paramMotionEvent.getY(0) - paramMotionEvent.getY(1);
            return FloatMath.sqrt(f1 * f1 + f2 * f2);
        }
        return 0.0F;
    }

    private void a(float paramFloat1, float paramFloat2) {
        int i2 = 1;
        int i1;
        if ((this.H.x >= this.I.left) && (this.H.x <= this.I.right)) {
            i1 = 1;
            if ((this.H.y < this.I.top) || (this.H.y > this.I.bottom)) {
                break label328;
            }
        }
        for (; ; ) {
            if ((i1 == 0) || (i2 == 0)) {
                break label334;
            }
            if ((paramFloat1 != 0.0F) || (paramFloat2 != 0.0F)) {
                mobi.ifunny.d.b(a, "Fling from " + this.H.x + ";" + this.H.y + " with velocity " + paramFloat1 + ";" + paramFloat2);
                this.y.fling((int) this.H.x, (int) this.H.y, (int) paramFloat1, (int) paramFloat2, this.I.left, this.I.right, this.I.top, this.I.bottom);
                i1 = Math.max(Math.abs((int) paramFloat1), Math.abs((int) paramFloat2));
                if (i1 > 4000) {
                    paramFloat1 = i1 / 16000.0F;
                    i1 = 1000 - (int) (500.0F * paramFloat1);
                    mobi.ifunny.d.b(a, "(maxV > 4000)  k=" + paramFloat1 + "; duration= " + i1 + ";");
                    this.y.extendDuration(i1);
                }
                bd.a(this, this.K);
            }
            return;
            i1 = 0;
            break;
            label328:
            i2 = 0;
        }
        label334:
        i();
    }

    private void a(Matrix paramMatrix) {
        paramMatrix.getValues(this.w);
        float f1 = this.w[2];
        float f2 = this.w[0];
        float f3 = this.e * f2;
        float f4 = f1 + f3;
        if (f3 < this.g.width()) {
            f1 = 0.5F * (this.g.width() - f3) - f1;
        }
        label266:
        for (; ; ) {
            paramMatrix.postTranslate(f1, 0.0F);
            paramMatrix.getValues(this.w);
            int i1 = Math.round(this.w[2]);
            int i2 = Math.round(this.w[5]);
            this.w[2] = i1;
            this.w[5] = i2;
            paramMatrix.setValues(this.w);
            this.i.left = i1;
            this.i.top = i2;
            this.i.right = ((int) (this.i.left + f3));
            this.i.bottom = ((int) (this.i.top + f2 * this.f));
            this.h.setIntersect(this.i, this.g);
            return;
            if (f1 > this.g.left) {
            }
            for (f1 = this.g.left - f1; ; f1 = 0.0F) {
                if (f4 >= this.g.right) {
                    break label266;
                }
                f1 = this.g.right - f4;
                break;
            }
        }
    }

    private void c() {
        d();
        e();
        g();
    }

    private void d() {
        int i1;
        int i3;
        switch (p.a[this.j.ordinal()]) {
            default:
                if (this.k) {
                    i1 = this.l + this.o;
                    i3 = this.d;
                    if (!this.m) {
                        break label177;
                    }
                }
                break;
        }
        label177:
        for (int i2 = this.n; ; i2 = this.o) {
            this.g.set(0, i1, this.c, i3 - i2);
            return;
            i1 = Math.min(this.c, this.d);
            i2 = (this.c - i1) / 2;
            i3 = (this.d - i1) / 2;
            this.g.set(i2, i3, i2 + i1, i1 + i3);
            return;
            i1 = (int) (this.c / this.r);
            i2 = this.c;
            i3 = (this.d - i1) / 2;
            this.g.set(0, i3, i2, i1 + i3);
            return;
            i1 = this.o;
            break;
        }
    }

    private void e() {
        float f3 = f();
        this.s = f3;
        this.t = (4.0F * f3);
        float f4 = this.e;
        float f1 = this.f;
        float f5 = this.g.left;
        float f6 = this.g.width();
        float f2 = this.g.top + (this.g.height() - f1 * f3) * 0.5F;
        f1 = f2;
        switch (p.a[this.j.ordinal()]) {
            default:
                f1 = f2;
                if (f2 < this.g.top) {
                    f1 = this.g.top;
                }
                break;
        }
        this.u = new Matrix();
        this.u.setScale(f3, f3);
        this.u.postTranslate(f5 + (f6 - f4 * f3) * 0.5F, f1);
        mobi.ifunny.d.b(a, "calculated fit matrix " + this.u.toShortString());
    }

    private float f() {
        if ((this.e > 0) && (this.f > 0)) {
            float f2 = this.g.width() - this.b * 2;
            float f1 = this.g.height() - this.b * 2;
            float f3 = f2 * 0.99F / this.e;
            float f4 = 0.99F * f1 / this.f;
            float f5 = Math.min(f3, f4);
            float f6 = 0.6F * this.g.width() / this.e;
            f2 = Math.min(f5, this.q);
            f1 = f2;
            if (this.f / this.e > 1.5F) {
                f1 = Math.max(f2, f6);
            }
            switch (p.a[this.j.ordinal()]) {
                default:
                    f1 = 1.0F;
                case 3:
                    do {
                        return f1;
                        f2 = f3 - f4;
                        if ((f2 > 0.0F) && (f2 < 0.2F * f3)) {
                            return f4;
                        }
                    } while (!this.p);
                    return f3;
                case 4:
                    if (this.p) {
                        return f5;
                    }
                    return Math.min(f5, this.q);
                case 5:
                    return Math.min(f3, f4);
            }
            return Math.max(this.g.width() / this.e, this.g.height() / this.f);
        }
        return 1.0F;
    }

    private void g() {
        mobi.ifunny.d.b(a, "setFitImageMatrix");
        this.v.set(this.u);
        setImageMatrix(this.v);
    }

    private PointF getRelativeTargetToSpringback() {
        PointF localPointF = new PointF();
        float f1;
        if (this.H.x < this.I.left) {
            f1 = this.I.left;
            localPointF.x = f1;
            if (this.H.y >= this.I.top) {
                break label118;
            }
            f1 = this.I.top;
        }
        for (; ; ) {
            localPointF.y = f1;
            return localPointF;
            if (this.H.x > this.I.right) {
                f1 = this.I.right;
                break;
            }
            f1 = this.H.x;
            break;
            label118:
            if (this.H.y > this.I.bottom) {
                f1 = this.I.bottom;
            } else {
                f1 = this.H.y;
            }
        }
    }

    private void h() {
        this.v.getValues(this.w);
        this.H.y = this.w[5];
        this.H.x = this.w[2];
        float f2 = this.w[0];
        float f1 = this.e * f2;
        f2 = this.f * f2;
        int i1 = this.g.width();
        int i2;
        int i3;
        int i4;
        if (f1 < i1) {
            i2 = this.g.left;
            i1 = Math.round((i1 - f1) * 0.5F) + i2;
            i2 = i1;
            i3 = this.g.height();
            if (f2 >= i3) {
                break label192;
            }
            i4 = this.g.top;
            i3 = Math.round((i3 - f2) * 0.5F) + i4;
            i4 = i3;
        }
        for (; ; ) {
            this.I.set(i2, i4, i1, i3);
            return;
            i2 = this.g.left + Math.round(i1 - f1);
            i1 = this.g.left;
            break;
            label192:
            i4 = this.g.top + Math.round(i3 - f2);
            i3 = this.g.top;
        }
    }

    private void i() {
        PointF localPointF = getRelativeTargetToSpringback();
        float f1 = localPointF.x;
        float f2 = this.H.x;
        float f3 = localPointF.y;
        float f4 = this.H.y;
        this.y.startScroll((int) this.H.x, (int) this.H.y, (int) (f1 - f2), (int) (f3 - f4));
        bd.a(this, this.K);
    }

    private void j() {
        PointF localPointF = getRelativeTargetToSpringback();
        this.v.getValues(this.w);
        float f1 = this.w[2];
        float f2 = this.w[5];
        this.v.postTranslate(localPointF.x - f1, localPointF.y - f2);
        setImageMatrix(this.v);
    }

    public void a() {
        h();
        j();
    }

    public void a(boolean paramBoolean1, boolean paramBoolean2) {
        if ((this.k != paramBoolean1) || (this.m != paramBoolean2)) {
            this.k = paramBoolean1;
            this.m = paramBoolean2;
            c();
        }
    }

    public boolean a(float paramFloat) {
        h();
        if (paramFloat > 0.0F) {
            if (this.H.y >= this.I.bottom - 20) {
            }
        }
        do {
            return true;
            return false;
            if (paramFloat >= 0.0F) {
                break;
            }
        } while (this.H.y > this.I.top + 20);
        return false;
        return false;
    }

    public boolean a(int paramInt1, int paramInt2, int paramInt3) {
        boolean bool = false;
        if (this.E) {
            return true;
        }
        this.v.getValues(this.w);
        float f1 = this.w[2];
        float f2 = this.w[0];
        float f3 = this.e;
        if ((paramInt1 < 0) && (f2 * f3 + f1 - 1.0F > this.c)) {
            paramInt2 = 1;
            if ((paramInt1 <= 0) || (f1 >= 0.0F)) {
                break label103;
            }
        }
        label103:
        for (paramInt1 = 1; ; paramInt1 = 0) {
            if ((paramInt2 != 0) || (paramInt1 != 0)) {
                bool = true;
            }
            return bool;
            paramInt2 = 0;
            break;
        }
    }

    protected int computeHorizontalScrollExtent() {
        return getWidth();
    }

    protected int computeHorizontalScrollOffset() {
        this.v.getValues(this.w);
        return (int) -(this.w[2] + 0.5F);
    }

    protected int computeHorizontalScrollRange() {
        this.v.getValues(this.w);
        return (int) (this.w[0] * this.e);
    }

    protected int computeVerticalScrollExtent() {
        return getHeight();
    }

    protected int computeVerticalScrollOffset() {
        this.v.getValues(this.w);
        return (int) -(this.w[5] + 0.5F);
    }

    protected int computeVerticalScrollRange() {
        this.v.getValues(this.w);
        return (int) (this.w[0] * this.f);
    }

    public final int getDrawablePadding() {
        return this.b;
    }

    public Bitmap getFitBitmap() {
        Drawable localDrawable = getDrawable();
        if (localDrawable == null) {
            return null;
        }
        Bitmap localBitmap = Bitmap.createBitmap(this.g.width(), this.g.height(), Bitmap.Config.ARGB_8888);
        Canvas localCanvas = new Canvas(localBitmap);
        localCanvas.translate(-this.g.left, -this.g.top);
        localCanvas.concat(getImageMatrix());
        localDrawable.draw(localCanvas);
        return localBitmap;
    }

    public void invalidateDrawable(Drawable paramDrawable) {
        if ((getDrawable() != null) && (getDrawable().equals(paramDrawable))) {
            invalidate(this.h);
            return;
        }
        super.invalidateDrawable(paramDrawable);
    }

    protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
        mobi.ifunny.d.b(a, "onSizeChanged w " + paramInt1 + " h " + paramInt2 + " oldw " + paramInt3 + " oldh " + paramInt4);
        if ((paramInt1 != paramInt3) || (paramInt2 != paramInt4)) {
            this.c = paramInt1;
            this.d = paramInt2;
            c();
        }
    }

    public boolean onTouchEvent(MotionEvent paramMotionEvent) {
        if (this.x.a(paramMotionEvent)) {
            return true;
        }
        switch (as.a(paramMotionEvent)) {
        }
        do {
            float f1;
            do {
                do {
                    do {
                        do {
                            return super.onTouchEvent(paramMotionEvent);
                        } while ((!this.D) || (this.E) || (this.F));
                        this.A = a(paramMotionEvent);
                    } while (this.A <= 12.0F);
                    this.B.set(this.v);
                    this.C.set((paramMotionEvent.getX(0) + paramMotionEvent.getX(1)) * 0.5F, (paramMotionEvent.getY(0) + paramMotionEvent.getY(1)) * 0.5F);
                    this.E = true;
                    return true;
                } while (!this.E);
                f1 = a(paramMotionEvent);
            } while (f1 <= 12.0F);
            this.B.getValues(this.w);
            float f3 = this.w[0];
            float f2 = f1 / this.A * f3;
            if (f2 < this.s) {
                f1 = this.s;
            }
            for (; ; ) {
                f1 /= f3;
                this.v.set(this.B);
                this.v.postScale(f1, f1, this.C.x, this.C.y);
                setImageMatrix(this.v);
                return true;
                f1 = f2;
                if (f2 > this.t) {
                    f1 = this.t;
                }
            }
            this.E = false;
            return true;
        } while ((!this.y.isFinished()) || (this.F));
        h();
        a(0.0F, 0.0F);
        return true;
    }

    public void requestLayout() {
        if (this.J) {
            return;
        }
        super.requestLayout();
    }

    public void setDoNotRequestLayout(boolean paramBoolean) {
        this.J = paramBoolean;
    }

    public final void setDrawablePadding(int paramInt) {
        if (this.b != paramInt) {
            this.b = paramInt;
            d();
            e();
        }
    }

    public final void setFitPolicy(q paramq) {
        if (this.j != paramq) {
            this.j = paramq;
            d();
            e();
        }
    }

    public final void setFitWidthToHeightRatio(float paramFloat) {
        if (this.r != paramFloat) {
            this.r = paramFloat;
            c();
        }
    }

    public void setImageDrawable(Drawable paramDrawable) {
        super.setImageDrawable(paramDrawable);
        if (paramDrawable == null) {
            this.e = 0;
            this.f = 0;
            return;
        }
        int i1 = paramDrawable.getIntrinsicWidth();
        int i2 = paramDrawable.getIntrinsicHeight();
        if ((this.e != i1) || (this.f != i2)) {
            this.e = i1;
            this.f = i2;
            e();
        }
        g();
    }

    public void setImageMatrix(Matrix paramMatrix) {
        a(paramMatrix);
        super.setImageMatrix(paramMatrix);
        awakenScrollBars();
    }

    public void setOverscroll(boolean paramBoolean) {
        this.z = paramBoolean;
    }

    public void setTapListener(f paramf) {
        this.G = paramf;
    }

    public void setZoomable(boolean paramBoolean) {
        this.D = paramBoolean;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/view/PinchImageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */