package mobi.ifunny.social.auth;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;

class ae
        implements TextWatcher {
    ae(RegisterActivityMain paramRegisterActivityMain) {
    }

    public void afterTextChanged(Editable paramEditable) {
        paramEditable = paramEditable.toString().trim();
        if (!TextUtils.isEmpty(paramEditable)) {
            if (this.a.l()) {
                RegisterActivityMain.a(this.a, paramEditable);
            }
            return;
        }
        RegisterActivityMain.a(this.a);
    }

    public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {
    }

    public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/social/auth/ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */