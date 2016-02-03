package android.support.v7.internal.view.menu;

import android.view.View;

class e
        implements Runnable {
    private g b;

    public e(ActionMenuPresenter paramActionMenuPresenter, g paramg) {
        this.b = paramg;
    }

    public void run() {
        this.a.e.f();
        View localView = (View) this.a.h;
        if ((localView != null) && (localView.getWindowToken() != null) && (this.b.a())) {
            ActionMenuPresenter.a(this.a, this.b);
        }
        ActionMenuPresenter.a(this.a, null);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v7/internal/view/menu/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */