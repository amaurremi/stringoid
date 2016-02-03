package mobi.ifunny.studio.comics.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import mobi.ifunny.j;

public class g
        extends ViewGroup.LayoutParams {
    public int a;

    private g(int paramInt1, int paramInt2, int paramInt3) {
        super(paramInt1, paramInt2);
        this.a = paramInt3;
    }

    private g(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
        paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, j.mobi_ifunny_editor_view_HorizontalAdapterView);
        this.a = paramContext.getInt(0, 0);
        paramContext.recycle();
    }

    public g(ViewGroup.LayoutParams paramLayoutParams) {
        super(paramLayoutParams);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/comics/view/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */