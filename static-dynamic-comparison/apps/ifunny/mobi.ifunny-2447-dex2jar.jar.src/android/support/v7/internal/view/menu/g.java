package android.support.v7.internal.view.menu;

import android.content.Context;
import android.view.View;

class g
        extends ae {
    public g(ActionMenuPresenter paramActionMenuPresenter, Context paramContext, q paramq, View paramView, boolean paramBoolean) {
        super(paramContext, paramq, paramView, paramBoolean);
        a(paramActionMenuPresenter.a);
    }

    public void onDismiss() {
        super.onDismiss();
        this.a.e.close();
        ActionMenuPresenter.a(this.a, null);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v7/internal/view/menu/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */