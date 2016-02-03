package android.support.v7.internal.widget;

import android.support.v7.a.e;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;

class ai
        extends BaseAdapter {
    private ai(ScrollingTabContainerView paramScrollingTabContainerView) {
    }

    public int getCount() {
        return ScrollingTabContainerView.a(this.a).getChildCount();
    }

    public Object getItem(int paramInt) {
        return ((ScrollingTabContainerView.TabView) ScrollingTabContainerView.a(this.a).getChildAt(paramInt)).getTab();
    }

    public long getItemId(int paramInt) {
        return paramInt;
    }

    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
        if (paramView == null) {
            return ScrollingTabContainerView.a(this.a, (e) getItem(paramInt), true);
        }
        ((ScrollingTabContainerView.TabView) paramView).a((e) getItem(paramInt));
        return paramView;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v7/internal/widget/ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */