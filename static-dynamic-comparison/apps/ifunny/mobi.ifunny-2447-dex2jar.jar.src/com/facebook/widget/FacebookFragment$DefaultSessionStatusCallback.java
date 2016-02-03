package com.facebook.widget;

import com.facebook.Session;
import com.facebook.Session.StatusCallback;
import com.facebook.SessionState;

class FacebookFragment$DefaultSessionStatusCallback
        implements Session.StatusCallback {
    private FacebookFragment$DefaultSessionStatusCallback(FacebookFragment paramFacebookFragment) {
    }

    public void call(Session paramSession, SessionState paramSessionState, Exception paramException) {
        this.this$0.onSessionStateChange(paramSessionState, paramException);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/widget/FacebookFragment$DefaultSessionStatusCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */