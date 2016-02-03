package mobi.ifunny.social.auth;

import android.view.inputmethod.InputMethodManager;

class ah
        implements Runnable {
    ah(RegisterActivityMain paramRegisterActivityMain) {
    }

    public void run() {
        ((InputMethodManager) this.a.getSystemService("input_method")).showSoftInput(this.a.nickEdit, 1);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/social/auth/ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */