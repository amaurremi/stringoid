package android.support.v7.internal.widget;

import android.os.Handler;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.PopupWindow;

class aa
        implements AbsListView.OnScrollListener {
    private aa(u paramu) {
    }

    public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {
    }

    public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {
        if ((paramInt == 1) && (!this.a.g()) && (u.b(this.a).getContentView() != null)) {
            u.d(this.a).removeCallbacks(u.c(this.a));
            u.c(this.a).run();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v7/internal/widget/aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */