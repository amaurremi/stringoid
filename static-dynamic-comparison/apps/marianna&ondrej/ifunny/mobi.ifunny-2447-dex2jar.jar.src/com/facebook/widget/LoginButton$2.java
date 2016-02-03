package com.facebook.widget;

import com.facebook.FacebookRequestError;
import com.facebook.Request.GraphUserCallback;
import com.facebook.Response;
import com.facebook.Session;
import com.facebook.internal.SessionTracker;
import com.facebook.model.GraphUser;

class LoginButton$2
        implements Request.GraphUserCallback {
    LoginButton$2(LoginButton paramLoginButton, Session paramSession) {
    }

    public void onCompleted(GraphUser paramGraphUser, Response paramResponse) {
        if (this.val$currentSession == LoginButton.access$400(this.this$0).getOpenSession()) {
            LoginButton.access$502(this.this$0, paramGraphUser);
            if (LoginButton.access$600(this.this$0) != null) {
                LoginButton.access$600(this.this$0).onUserInfoFetched(LoginButton.access$500(this.this$0));
            }
        }
        if (paramResponse.getError() != null) {
            this.this$0.handleError(paramResponse.getError().getException());
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/widget/LoginButton$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */