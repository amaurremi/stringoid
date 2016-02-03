package android.support.v7.internal.view.menu;

import android.content.DialogInterface;

class d
        extends t {
    public d(ActionMenuPresenter paramActionMenuPresenter, am paramam) {
        super(paramam);
        paramActionMenuPresenter.a(paramActionMenuPresenter.a);
    }

    public void onDismiss(DialogInterface paramDialogInterface) {
        super.onDismiss(paramDialogInterface);
        ActionMenuPresenter.a(this.a, null);
        this.a.b = 0;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v7/internal/view/menu/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */