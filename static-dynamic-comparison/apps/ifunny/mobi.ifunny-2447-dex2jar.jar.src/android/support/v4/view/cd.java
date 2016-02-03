package android.support.v4.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;

public class cd
        extends ViewGroup.LayoutParams {
    public boolean a;
    public int b;
    float c = 0.0F;
    boolean d;
    int e;
    int f;

    public cd() {
        super(-1, -1);
    }

    public cd(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
        paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, ViewPager.f());
        this.b = paramContext.getInteger(0, 48);
        paramContext.recycle();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v4/view/cd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */