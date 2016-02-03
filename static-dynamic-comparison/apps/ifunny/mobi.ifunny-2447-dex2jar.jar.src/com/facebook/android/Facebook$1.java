package com.facebook.android;

import com.facebook.Session;
import com.facebook.Session.StatusCallback;
import com.facebook.SessionState;

class Facebook$1
        implements Session.StatusCallback {
    Facebook$1(Facebook paramFacebook, Facebook.DialogListener paramDialogListener) {
    }

    public void call(Session paramSession, SessionState paramSessionState, Exception paramException) {
        Facebook.access$000(this.this$0, paramSession, paramSessionState, paramException, this.val$listener);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/android/Facebook$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */