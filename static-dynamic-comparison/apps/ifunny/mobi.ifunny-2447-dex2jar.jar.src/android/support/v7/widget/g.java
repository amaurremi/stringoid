package android.support.v7.widget;

import android.view.View;
import android.view.View.OnFocusChangeListener;

class g
        implements View.OnFocusChangeListener {
    g(SearchView paramSearchView) {
    }

    public void onFocusChange(View paramView, boolean paramBoolean) {
        if (SearchView.access$200(this.a) != null) {
            SearchView.access$200(this.a).onFocusChange(this.a, paramBoolean);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v7/widget/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */