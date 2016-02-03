package android.support.v7.internal.view.menu;

import android.support.v7.c.c;
import android.view.CollapsibleActionView;
import android.view.View;
import android.widget.FrameLayout;

class z
        extends FrameLayout
        implements CollapsibleActionView {
    final c a;

    z(View paramView) {
        super(paramView.getContext());
        this.a = ((c) paramView);
        addView(paramView);
    }

    View a() {
        return (View) this.a;
    }

    public void onActionViewCollapsed() {
        this.a.onActionViewCollapsed();
    }

    public void onActionViewExpanded() {
        this.a.onActionViewExpanded();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v7/internal/view/menu/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */