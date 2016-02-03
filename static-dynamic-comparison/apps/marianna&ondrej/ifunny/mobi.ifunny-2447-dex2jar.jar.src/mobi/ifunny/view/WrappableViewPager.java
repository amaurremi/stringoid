package mobi.ifunny.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;

public class WrappableViewPager
        extends ViewPager {
    public WrappableViewPager(Context paramContext) {
        super(paramContext);
    }

    public WrappableViewPager(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
    }

    protected void onMeasure(int paramInt1, int paramInt2) {
        paramInt2 = 0;
        int j;
        for (int i = 0; paramInt2 < getChildCount(); i = j) {
            View localView = getChildAt(paramInt2);
            localView.measure(paramInt1, View.MeasureSpec.makeMeasureSpec(0, 0));
            int k = localView.getMeasuredHeight();
            j = i;
            if (k > i) {
                j = k;
            }
            paramInt2 += 1;
        }
        super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(i, 1073741824));
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/view/WrappableViewPager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */