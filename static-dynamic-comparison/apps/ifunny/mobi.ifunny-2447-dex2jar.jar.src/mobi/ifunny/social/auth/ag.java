package mobi.ifunny.social.auth;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;

class ag
        implements View.OnFocusChangeListener {
    ag(RegisterActivityMain paramRegisterActivityMain) {
    }

    public void onFocusChange(View paramView, boolean paramBoolean) {
        int i;
        if (paramBoolean) {
            i = RegisterActivityMain.r();
            label8:
            if (!paramBoolean) {
                break label64;
            }
        }
        label64:
        for (int j = RegisterActivityMain.r(); ; j = RegisterActivityMain.t()) {
            switch (paramView.getId()) {
                default:
                    return;
                i = RegisterActivityMain.s();
                break label8;
            }
        }
        RegisterActivityMain.a(this.a, paramBoolean);
        RegisterActivityMain.a(this.a, RegisterActivityMain.c(this.a));
        this.a.nickBottomLine.setBackgroundColor(j);
        return;
        RegisterActivityMain.b(this.a, paramBoolean);
        RegisterActivityMain.d(this.a);
        this.a.emailBottomLine.setBackgroundColor(j);
        return;
        this.a.passEdit.setTextColor(i);
        this.a.passwordBottomLine.setBackgroundColor(j);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/social/auth/ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */