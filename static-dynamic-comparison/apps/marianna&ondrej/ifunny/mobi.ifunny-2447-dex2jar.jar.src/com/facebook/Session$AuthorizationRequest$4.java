package com.facebook;

import android.app.Activity;
import android.content.Intent;

class Session$AuthorizationRequest$4
        implements AuthorizationClient.StartActivityDelegate {
    Session$AuthorizationRequest$4(Session.AuthorizationRequest paramAuthorizationRequest) {
    }

    public Activity getActivityContext() {
        return Session.AuthorizationRequest.access$1900(this.this$0).getActivityContext();
    }

    public void startActivityForResult(Intent paramIntent, int paramInt) {
        Session.AuthorizationRequest.access$1900(this.this$0).startActivityForResult(paramIntent, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/Session$AuthorizationRequest$4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */