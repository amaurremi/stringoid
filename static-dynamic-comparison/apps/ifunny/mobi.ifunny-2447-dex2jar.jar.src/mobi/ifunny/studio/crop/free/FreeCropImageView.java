package mobi.ifunny.studio.crop.free;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.support.v4.view.bd;
import android.util.AttributeSet;
import android.view.MotionEvent;
import mobi.ifunny.j;
import mobi.ifunny.view.PinchImageView;
import mobi.ifunny.view.q;

public final class FreeCropImageView
        extends PinchImageView {
    float[] a = new float[2];
    float[] b = new float[9];
    private Drawable j;
    private Rect[] k = new Rect[4];
    private Paint l;
    private int m = -1;
    private final Rect n = new Rect();
    private final Rect o = new Rect();
    private int p;
    private int q;
    private Point r = new Point();

    public FreeCropImageView(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
        setFitPolicy(q.c);
        paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, j.mobi_ifunny_studio_crop_free_FreeCropImageView);
        this.p = paramContext.getDimensionPixelSize(0, 100);
        this.q = paramContext.getDimensionPixelSize(1, 100);
        paramContext.recycle();
        this.l = new Paint();
        this.l.setColor(-1605349296);
    }

    private void a(int paramInt) {
        a(paramInt, this.r);
        Rect localRect2 = this.k[paramInt];
        Rect localRect1 = localRect2;
        if (localRect2 == null) {
            localRect1 = new Rect();
            this.k[paramInt] = localRect1;
        }
        a(this.j, this.r, localRect1);
    }

    private void a(int paramInt, Point paramPoint) {
        switch (paramInt) {
            default:
                throw new IllegalArgumentException(paramInt + " is not correct corner ID");
            case 0:
                paramPoint.x = this.o.left;
                paramPoint.y = this.o.top;
                return;
            case 1:
                paramPoint.x = this.o.right;
                paramPoint.y = this.o.top;
                return;
            case 2:
                paramPoint.x = this.o.right;
                paramPoint.y = this.o.bottom;
                return;
        }
        paramPoint.x = this.o.left;
        paramPoint.y = this.o.bottom;
    }

    private void a(Point paramPoint) {
        Matrix localMatrix = getImageMatrix();
        this.a[0] = paramPoint.x;
        this.a[1] = paramPoint.y;
        localMatrix.mapPoints(this.a);
        paramPoint.x = ((int) this.a[0]);
        paramPoint.y = ((int) this.a[1]);
    }

    private void a(Drawable paramDrawable, Point paramPoint, Rect paramRect) {
        int i1 = paramDrawable.getIntrinsicWidth();
        int i = paramDrawable.getIntrinsicHeight();
        i1 /= 2;
        i /= 2;
        paramRect.set(paramPoint.x - i1, paramPoint.y - i, i1 + paramPoint.x, i + paramPoint.y);
        paramDrawable.setBounds(paramRect);
    }

    private void b(int paramInt) {
        this.n.left = paramInt;
        if (this.n.left < 0) {
            this.n.left = 0;
        }
        if (this.n.width() < this.p) {
            this.n.left = (this.n.right - this.p);
        }
    }

    private void b(int paramInt, Point paramPoint) {
        switch (paramInt) {
            default:
                throw new IllegalArgumentException(paramInt + " is not correct corner ID");
            case 0:
                b(paramPoint.x);
                d(paramPoint.y);
        }
        for (; ; ) {
            d();
            e();
            bd.c(this);
            return;
            c(paramPoint.x);
            d(paramPoint.y);
            continue;
            c(paramPoint.x);
            e(paramPoint.y);
            continue;
            b(paramPoint.x);
            e(paramPoint.y);
        }
    }

    private void b(Point paramPoint) {
        getImageMatrix().getValues(this.b);
        float f = this.b[0];
        paramPoint.x = ((int) ((paramPoint.x - this.b[2]) / f));
        paramPoint.y = ((int) ((paramPoint.y - this.b[5]) / f));
    }

    private void c() {
        Drawable localDrawable = getDrawable();
        if ((this.j == null) || (localDrawable == null)) {
            return;
        }
        this.n.left = ((int) (this.e * 0.0F + 0.5F));
        this.n.top = ((int) (this.f * 0.0F + 0.5F));
        this.n.right = (this.e - this.n.left);
        this.n.bottom = (this.f - this.n.top);
        d();
        e();
    }

    private void c(int paramInt) {
        this.n.right = paramInt;
        if (this.n.right > this.e) {
            this.n.right = this.e;
        }
        if (this.n.width() < this.p) {
            this.n.right = (this.n.left + this.p);
        }
    }

    private void d() {
        Drawable localDrawable = getDrawable();
        if ((this.j == null) || (localDrawable == null)) {
            return;
        }
        this.r.x = this.n.left;
        this.r.y = this.n.top;
        a(this.r);
        this.o.left = this.r.x;
        this.o.top = this.r.y;
        this.r.x = this.n.right;
        this.r.y = this.n.bottom;
        a(this.r);
        this.o.right = this.r.x;
        this.o.bottom = this.r.y;
    }

    private void d(int paramInt) {
        this.n.top = paramInt;
        if (this.n.top < 0) {
            this.n.top = 0;
        }
        if (this.n.height() < this.q) {
            this.n.top = (this.n.bottom - this.q);
        }
    }

    private void e() {
        if (this.j == null) {
        }
        for (; ; ) {
            return;
            int i = 0;
            while (i < 4) {
                a(i);
                i += 1;
            }
        }
    }

    private void e(int paramInt) {
        this.n.bottom = paramInt;
        if (this.n.bottom > this.f) {
            this.n.bottom = this.f;
        }
        if (this.n.height() < this.q) {
            this.n.bottom = (this.n.top + this.q);
        }
    }

    public Rect getCropRect() {
        return this.n;
    }

    public Rect getCropViewRect() {
        return this.o;
    }

    public Rect getReverseCrop() {
        Rect localRect = new Rect();
        localRect.left = this.n.left;
        localRect.top = this.n.top;
        localRect.bottom = (this.f - this.n.bottom);
        localRect.right = (this.e - this.n.right);
        return localRect;
    }

    protected void onDraw(Canvas paramCanvas) {
        super.onDraw(paramCanvas);
        if ((this.j == null) || (getDrawable() == null)) {
        }
        for (; ; ) {
            return;
            paramCanvas.drawRect(this.h.left, this.h.top, this.h.right, this.o.top, this.l);
            paramCanvas.drawRect(this.h.left, this.o.top, this.o.left, this.o.bottom, this.l);
            paramCanvas.drawRect(this.o.right, this.o.top, this.h.right, this.o.bottom, this.l);
            paramCanvas.drawRect(this.h.left, this.o.bottom, this.h.right, this.h.bottom, this.l);
            int i = 0;
            while (i < 4) {
                this.j.setBounds(this.k[i]);
                this.j.draw(paramCanvas);
                i += 1;
            }
        }
    }

    protected void onRestoreInstanceState(Parcelable paramParcelable) {
        paramParcelable = (FreeCropImageView.CropImageViewState) paramParcelable;
        super.onRestoreInstanceState(FreeCropImageView.CropImageViewState.a(paramParcelable));
        this.n.set(FreeCropImageView.CropImageViewState.b(paramParcelable));
    }

    protected Parcelable onSaveInstanceState() {
        return new FreeCropImageView.CropImageViewState(super.onSaveInstanceState(), this.n);
    }

    public boolean onTouchEvent(MotionEvent paramMotionEvent) {
        int i1 = (int) paramMotionEvent.getX();
        int i2 = (int) paramMotionEvent.getY();
        switch (paramMotionEvent.getAction() & 0xFF) {
        }
        do {
            do {
                int i;
                do {
                    return super.onTouchEvent(paramMotionEvent);
                    this.m = -1;
                    i = 0;
                } while (i >= 4);
                Rect localRect = this.k[i];
                if (localRect == null) {
                }
                while (!localRect.contains(i1, i2)) {
                    i += 1;
                    break;
                }
                this.m = i;
                return true;
            } while (this.m == -1);
            paramMotionEvent = new Point(i1, i2);
            b(paramMotionEvent);
            b(this.m, paramMotionEvent);
            return true;
        } while (this.m == -1);
        this.m = -1;
        return true;
    }

    public void setCornerDrawable(Drawable paramDrawable) {
        this.j = paramDrawable;
        setDrawablePadding(paramDrawable.getIntrinsicWidth());
    }

    public void setImageBitmap(Bitmap paramBitmap) {
    }

    public void setImageDrawable(Drawable paramDrawable) {
        super.setImageDrawable(paramDrawable);
        if (paramDrawable == null) {
            this.n.setEmpty();
            this.o.setEmpty();
            return;
        }
        if (this.n.isEmpty()) {
            c();
            return;
        }
        d();
        e();
    }

    public void setImageMatrix(Matrix paramMatrix) {
        super.setImageMatrix(paramMatrix);
        d();
        e();
    }

    public void setMinCropHeight(int paramInt) {
        this.q = paramInt;
        c();
        bd.c(this);
    }

    public void setMinCropWidth(int paramInt) {
        this.p = paramInt;
        c();
        bd.c(this);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/crop/free/FreeCropImageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */