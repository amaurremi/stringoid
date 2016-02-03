package mobi.ifunny.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v4.view.bd;
import android.util.AttributeSet;
import android.widget.ScrollView;

public class ScrollViewEx
        extends ScrollView {
    private y a;

    public ScrollViewEx(Context paramContext) {
        super(paramContext);
    }

    public ScrollViewEx(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
    }

    public ScrollViewEx(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
    }

    private boolean a() {
        return (getScrollY() != 0) || (bd.b(this, 1));
    }

    public void a(int paramInt) {
        this.a = new x(this, paramInt);
    }

    @SuppressLint({"WrongCall"})
    protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
        if (this.a != null) {
            this.a.a();
        }
    }

    public boolean shouldDelayChildPressedState() {
        return a();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/view/ScrollViewEx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */