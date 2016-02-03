package mobi.ifunny.social.auth;

import android.view.inputmethod.InputMethodManager;

class r
        implements Runnable {
    r(LoginActivity paramLoginActivity) {
    }

    public void run() {
        ((InputMethodManager) this.a.getSystemService("input_method")).showSoftInput(this.a.emailEdit, 1);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/social/auth/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */