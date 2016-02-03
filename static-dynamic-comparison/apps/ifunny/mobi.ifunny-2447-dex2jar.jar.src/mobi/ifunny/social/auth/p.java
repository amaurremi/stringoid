package mobi.ifunny.social.auth;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;

class p
        implements View.OnFocusChangeListener {
    p(LoginActivity paramLoginActivity) {
    }

    public void onFocusChange(View paramView, boolean paramBoolean) {
        int i;
        if (paramBoolean) {
            i = LoginActivity.o();
            label8:
            if (!paramBoolean) {
                break label56;
            }
        }
        label56:
        for (int j = LoginActivity.o(); ; j = LoginActivity.q()) {
            switch (paramView.getId()) {
                default:
                    return;
                i = LoginActivity.p();
                break label8;
            }
        }
        this.a.emailEdit.setTextColor(i);
        this.a.emailBottomLine.setBackgroundColor(j);
        return;
        this.a.passEdit.setTextColor(i);
        this.a.passwordBottomLine.setBackgroundColor(j);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/social/auth/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */