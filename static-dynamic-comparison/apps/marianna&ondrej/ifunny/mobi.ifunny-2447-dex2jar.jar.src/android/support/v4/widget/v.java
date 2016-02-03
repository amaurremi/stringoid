package android.support.v4.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;

public class v
        extends ViewGroup.MarginLayoutParams {
    private static final int[] e = {16843137};
    public float a = 0.0F;
    boolean b;
    boolean c;
    Paint d;

    public v() {
        super(-1, -1);
    }

    public v(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
        paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, e);
        this.a = paramContext.getFloat(0, 0.0F);
        paramContext.recycle();
    }

    public v(ViewGroup.LayoutParams paramLayoutParams) {
        super(paramLayoutParams);
    }

    public v(ViewGroup.MarginLayoutParams paramMarginLayoutParams) {
        super(paramMarginLayoutParams);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v4/widget/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */