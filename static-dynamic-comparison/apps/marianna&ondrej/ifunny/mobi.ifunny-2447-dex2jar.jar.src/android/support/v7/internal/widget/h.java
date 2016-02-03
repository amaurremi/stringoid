package android.support.v7.internal.widget;

import android.support.v7.internal.view.menu.u;
import android.view.View;
import android.view.View.OnClickListener;

class h
        implements View.OnClickListener {
    h(ActionBarView paramActionBarView) {
    }

    public void onClick(View paramView) {
        paramView = ActionBarView.b(this.a).b;
        if (paramView != null) {
            paramView.collapseActionView();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v7/internal/widget/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */