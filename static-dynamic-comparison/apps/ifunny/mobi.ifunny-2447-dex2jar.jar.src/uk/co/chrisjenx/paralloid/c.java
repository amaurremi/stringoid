package uk.co.chrisjenx.paralloid;

import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import uk.co.chrisjenx.paralloid.b.a;

public class c
        extends b
        implements AbsListView.OnScrollListener {
    protected c(T paramT) {
        super(paramT);
        b();
    }

    public static c a(View paramView) {
        return new c(paramView);
    }

    private void b() {
        if (this.h == null) {
            throw new IllegalArgumentException("The wrapped view cannot be null");
        }
        if ((this.h instanceof AbsListView)) {
            ((AbsListView) this.h).setOnScrollListener(this);
        }
    }

    public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {
        paramInt1 = a.a(paramAbsListView);
        this.e = false;
        a(a(), ((View) this.h).getScrollX(), paramInt1, this.f, this.g);
        this.e = true;
    }

    public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/uk/co/chrisjenx/paralloid/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */