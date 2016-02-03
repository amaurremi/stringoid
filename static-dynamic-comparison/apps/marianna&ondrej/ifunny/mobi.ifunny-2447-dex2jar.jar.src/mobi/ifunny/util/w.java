package mobi.ifunny.util;

import android.content.Context;
import android.graphics.Point;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

public class w {
    private int a;
    private View b;
    private boolean c;
    private y d;
    private final ViewTreeObserver.OnGlobalLayoutListener e = new x(this);

    public w(Context paramContext, y paramy, int paramInt) {
        this.d = paramy;
        this.a = paramInt;
        if (paramInt <= 0) {
            this.a = (h.a(paramContext).y / 4);
        }
    }

    public void a() {
        this.b.getViewTreeObserver().removeGlobalOnLayoutListener(this.e);
    }

    public void a(View paramView) {
        this.b = paramView;
        paramView.getViewTreeObserver().addOnGlobalLayoutListener(this.e);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/util/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */