package com.facebook.widget;

import com.facebook.Session;
import com.facebook.Session.StatusCallback;
import com.facebook.SessionState;

class LoginButton$LoginButtonCallback
        implements Session.StatusCallback {
    private LoginButton$LoginButtonCallback(LoginButton paramLoginButton) {
    }

    public void call(Session paramSession, SessionState paramSessionState, Exception paramException) {
        LoginButton.access$1700(this.this$0);
        LoginButton.access$1800(this.this$0);
        if (LoginButton.LoginButtonProperties.access$1900(LoginButton.access$1000(this.this$0)) != null) {
            LoginButton.LoginButtonProperties.access$1900(LoginButton.access$1000(this.this$0)).call(paramSession, paramSessionState, paramException);
        }
        while (paramException == null) {
            return;
        }
        this.this$0.handleError(paramException);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/widget/LoginButton$LoginButtonCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */