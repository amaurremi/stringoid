package android.support.v7.internal.widget;

import android.support.v7.a.e;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;

class aj
        implements View.OnClickListener {
    private aj(ScrollingTabContainerView paramScrollingTabContainerView) {
    }

    public void onClick(View paramView) {
        ((ScrollingTabContainerView.TabView) paramView).getTab().e();
        int j = ScrollingTabContainerView.a(this.a).getChildCount();
        int i = 0;
        if (i < j) {
            View localView = ScrollingTabContainerView.a(this.a).getChildAt(i);
            if (localView == paramView) {
            }
            for (boolean bool = true; ; bool = false) {
                localView.setSelected(bool);
                i += 1;
                break;
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v7/internal/widget/aj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */