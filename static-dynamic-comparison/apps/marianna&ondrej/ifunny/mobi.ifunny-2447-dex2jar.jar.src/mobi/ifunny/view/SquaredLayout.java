package mobi.ifunny.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;

public class SquaredLayout
        extends FrameLayoutEx {
    public SquaredLayout(Context paramContext) {
        super(paramContext);
    }

    public SquaredLayout(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
    }

    protected void onMeasure(int paramInt1, int paramInt2) {
        int j = 1;
        int m = View.MeasureSpec.getMode(paramInt1);
        int i = View.MeasureSpec.getSize(paramInt1);
        paramInt1 = View.MeasureSpec.getMode(paramInt2);
        int k = View.MeasureSpec.getSize(paramInt2);
        if (m == 0) {
            paramInt2 = 1;
            if (paramInt1 != 0) {
                break label69;
            }
            paramInt1 = j;
            label39:
            if ((paramInt2 == 0) || (paramInt1 == 0)) {
                break label74;
            }
            paramInt1 = 80;
        }
        for (; ; ) {
            paramInt1 = View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824);
            super.onMeasure(paramInt1, paramInt1);
            return;
            paramInt2 = 0;
            break;
            label69:
            paramInt1 = 0;
            break label39;
            label74:
            if ((paramInt2 != 0) || (paramInt1 != 0)) {
                paramInt1 = k;
                if (paramInt2 == 0) {
                    paramInt1 = i;
                }
            } else {
                paramInt1 = Math.min(i, k);
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/view/SquaredLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */