package uk.co.chrisjenx.paralloid.b;

import android.view.View;
import android.widget.AbsListView;

public class a
        extends b<AbsListView> {
    public static int a(AbsListView paramAbsListView) {
        View localView = paramAbsListView.getChildAt(0);
        if (localView == null) {
            return 0;
        }
        int i = -localView.getTop();
        int j = paramAbsListView.getFirstVisiblePosition();
        return i + localView.getHeight() * j;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/uk/co/chrisjenx/paralloid/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */