package mobi.ifunny.studio.comics.view;

import android.content.Context;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.ImageView;

public class ConstantRatioImageView
        extends ImageView {
    private Point a;

    public ConstantRatioImageView(Context paramContext) {
        super(paramContext);
        a();
    }

    public ConstantRatioImageView(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
        a();
    }

    public ConstantRatioImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
        a();
    }

    private void a() {
        this.a = new Point();
    }

    private int b(int paramInt1, int paramInt2) {
        int i = View.MeasureSpec.getMode(paramInt2);
        paramInt2 = View.MeasureSpec.getSize(paramInt2);
        switch (i) {
            case 0:
            default:
                return paramInt1;
            case -2147483648:
                return Math.min(paramInt1, paramInt2);
        }
        return paramInt2;
    }

    public void a(int paramInt1, int paramInt2) {
        this.a.set(paramInt1, paramInt2);
        forceLayout();
    }

    public Point getPreferedSize() {
        return this.a;
    }

    protected void onMeasure(int paramInt1, int paramInt2) {
        float f = 0.0F;
        int k = 0;
        int m = 0;
        int i1 = View.MeasureSpec.getMode(paramInt1);
        int n = View.MeasureSpec.getMode(paramInt2);
        int j;
        int i;
        int i2;
        int i3;
        if ((getDrawable() == null) && (this.a == null)) {
            j = 0;
            i = 0;
            i2 = getPaddingLeft();
            i3 = getPaddingRight();
            n = getPaddingTop();
            i1 = getPaddingBottom();
            if ((k == 0) && (m == 0)) {
                break label302;
            }
            i = b(i + i2 + i3, paramInt1);
            paramInt1 = b(j + n + i1, paramInt2);
            if ((f == 0.0F) || (Math.abs((i - i2 - i3) / (paramInt1 - n - i1) - f) <= 1.0E-7D)) {
                break label371;
            }
            if (k == 0) {
                break label362;
            }
            paramInt2 = (int) ((paramInt1 - n - i1) * f) + i2 + i3;
            if (paramInt2 > i) {
                break label362;
            }
            i = 1;
            label172:
            if ((i != 0) || (m == 0)) {
                break label359;
            }
            i = (int) ((paramInt2 - i2 - i3) / f) + n + i1;
            if (i > paramInt1) {
                break label359;
            }
            paramInt1 = i;
        }
        for (; ; ) {
            setMeasuredDimension(paramInt2, paramInt1);
            return;
            j = this.a.x;
            k = this.a.y;
            i = j;
            if (j <= 0) {
                i = 1;
            }
            j = k;
            if (k <= 0) {
                j = 1;
            }
            if (i1 != 1073741824) {
                k = 1;
                label269:
                if (n == 1073741824) {
                    break label296;
                }
            }
            label296:
            for (m = 1; ; m = 0) {
                f = i / j;
                break;
                k = 0;
                break label269;
            }
            label302:
            i = Math.max(i2 + i3 + i, getSuggestedMinimumWidth());
            j = Math.max(n + i1 + j, getSuggestedMinimumHeight());
            i = b(i, paramInt1);
            paramInt1 = b(j, paramInt2);
            paramInt2 = i;
            continue;
            label359:
            continue;
            label362:
            paramInt2 = i;
            i = 0;
            break label172;
            label371:
            paramInt2 = i;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/comics/view/ConstantRatioImageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */