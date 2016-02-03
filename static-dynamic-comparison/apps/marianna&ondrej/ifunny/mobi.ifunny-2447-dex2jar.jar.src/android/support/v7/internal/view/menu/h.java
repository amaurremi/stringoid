package android.support.v7.internal.view.menu;

import android.view.MenuItem;

class h
        implements ah {
    private h(ActionMenuPresenter paramActionMenuPresenter) {
    }

    public void a(q paramq, boolean paramBoolean) {
        if ((paramq instanceof am)) {
            ((am) paramq).p().a(false);
        }
    }

    public boolean b(q paramq) {
        if (paramq == null) {
            return false;
        }
        this.a.b = ((am) paramq).getItem().getItemId();
        return false;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v7/internal/view/menu/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */