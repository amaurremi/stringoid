package mobi.ifunny.view;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

public class FitImageView
        extends ImageView {
    protected int a;
    protected int b;
    protected int c;
    protected int d;
    private Matrix e = null;
    private float[] f = new float[9];
    private float g;
    private Matrix h = null;

    public FitImageView(Context paramContext) {
        this(paramContext, null);
    }

    public FitImageView(Context paramContext, AttributeSet paramAttributeSet) {
        this(paramContext, paramAttributeSet, 0);
    }

    public FitImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
        a();
    }

    private void a() {
        setScaleType(ImageView.ScaleType.MATRIX);
        this.e = new Matrix();
    }

    private void a(Matrix paramMatrix) {
        paramMatrix.getValues(this.f);
        float f2 = this.f[2];
        float f1 = this.f[0];
        float f3 = this.c * f1;
        if (f3 < this.a) {
            f1 = 0.5F * (this.a - f3) - f2;
        }
        label151:
        for (; ; ) {
            paramMatrix.postTranslate(f1, 0.0F);
            paramMatrix.getValues(this.f);
            this.f[2] = Math.round(this.f[2]);
            this.f[5] = Math.round(this.f[5]);
            paramMatrix.setValues(this.f);
            return;
            if (f2 > 0.0F) {
            }
            for (f1 = -f2; ; f1 = 0.0F) {
                if (f2 + f3 >= this.a) {
                    break label151;
                }
                f1 = this.a - f3 - f2;
                break;
            }
        }
    }

    private void b() {
        float f1 = 0.0F;
        this.g = c();
        float f3 = this.g;
        float f4 = this.c;
        float f2 = this.g;
        float f6 = this.d;
        float f5 = this.a;
        f2 = (this.b - f2 * f6) * 0.5F;
        if (f2 < 0.0F) {
        }
        for (; ; ) {
            this.h = new Matrix();
            this.h.setScale(this.g, this.g);
            this.h.postTranslate(0.5F * (f5 - f3 * f4), f1);
            return;
            f1 = f2;
        }
    }

    private float c() {
        if ((this.c > 0) && (this.d > 0)) {
            return 0.9999F * this.a / this.c;
        }
        return 1.0F;
    }

    private void d() {
        this.e.set(this.h);
        setImageMatrix(this.e);
    }

    public float getScaleFit() {
        return this.g;
    }

    public int getScaledHeight() {
        return getSuggestedMinimumHeight();
    }

    protected int getSuggestedMinimumHeight() {
        return (int) (this.g * this.d);
    }

    protected int getSuggestedMinimumWidth() {
        return (int) (this.g * this.c);
    }

    protected void onMeasure(int paramInt1, int paramInt2) {
        setMeasuredDimension(resolveSize(getSuggestedMinimumWidth(), paramInt1), resolveSize(getSuggestedMinimumHeight(), paramInt2));
    }

    protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
        if ((paramInt1 != paramInt3) || (paramInt2 != paramInt4)) {
            this.a = paramInt1;
            this.b = paramInt2;
            b();
            d();
        }
    }

    public void setImageDrawable(Drawable paramDrawable) {
        super.setImageDrawable(paramDrawable);
        if (paramDrawable == null) {
            this.c = 0;
            this.d = 0;
            return;
        }
        int i = paramDrawable.getIntrinsicWidth();
        int j = paramDrawable.getIntrinsicHeight();
        if ((this.c != i) || (this.d != j)) {
            this.c = i;
            this.d = j;
            b();
        }
        d();
        requestLayout();
    }

    public void setImageMatrix(Matrix paramMatrix) {
        a(paramMatrix);
        super.setImageMatrix(paramMatrix);
        awakenScrollBars();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/view/FitImageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */