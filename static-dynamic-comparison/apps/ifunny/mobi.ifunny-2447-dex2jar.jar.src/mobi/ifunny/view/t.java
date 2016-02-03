package mobi.ifunny.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import mobi.ifunny.j;

public class t
        extends LinearLayout.LayoutParams {
    public int a;

    private t(int paramInt1, int paramInt2, int paramInt3) {
        super(paramInt1, paramInt2);
        this.a = paramInt3;
    }

    private t(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
        paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, j.mobi_ifunny_view_PriorityLinearLayout);
        this.a = paramContext.getInt(4, PriorityLinearLayout.a);
        paramContext.recycle();
    }

    public t(ViewGroup.LayoutParams paramLayoutParams) {
        super(paramLayoutParams);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/view/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */