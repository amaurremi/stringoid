package com.facebook.widget;

import com.facebook.FacebookRequestError;
import com.facebook.Request.GraphUserCallback;
import com.facebook.Response;
import com.facebook.Session;
import com.facebook.model.GraphUser;

class UserSettingsFragment$1
        implements Request.GraphUserCallback {
    UserSettingsFragment$1(UserSettingsFragment paramUserSettingsFragment, Session paramSession) {
    }

    public void onCompleted(GraphUser paramGraphUser, Response paramResponse) {
        if (this.val$currentSession == this.this$0.getSession()) {
            UserSettingsFragment.access$002(this.this$0, paramGraphUser);
            UserSettingsFragment.access$100(this.this$0);
        }
        if (paramResponse.getError() != null) {
            UserSettingsFragment.access$200(this.this$0).handleError(paramResponse.getError().getException());
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/widget/UserSettingsFragment$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */