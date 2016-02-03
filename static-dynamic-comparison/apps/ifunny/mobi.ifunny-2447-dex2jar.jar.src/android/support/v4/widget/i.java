package android.support.v4.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;

public class i
        extends ViewGroup.MarginLayoutParams {
    public int a = 0;
    float b;
    boolean c;
    boolean d;

    public i(int paramInt1, int paramInt2) {
        super(paramInt1, paramInt2);
    }

    public i(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
        paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, DrawerLayout.c());
        this.a = paramContext.getInt(0, 0);
        paramContext.recycle();
    }

    public i(i parami) {
        super(parami);
        this.a = parami.a;
    }

    public i(ViewGroup.LayoutParams paramLayoutParams) {
        super(paramLayoutParams);
    }

    public i(ViewGroup.MarginLayoutParams paramMarginLayoutParams) {
        super(paramMarginLayoutParams);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v4/widget/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */