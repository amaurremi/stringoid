package com.facebook;

import android.app.Activity;
import android.content.Intent;

class AuthorizationClient$2
        implements AuthorizationClient.StartActivityDelegate {
    AuthorizationClient$2(AuthorizationClient paramAuthorizationClient) {
    }

    public Activity getActivityContext() {
        return this.this$0.pendingRequest.getStartActivityDelegate().getActivityContext();
    }

    public void startActivityForResult(Intent paramIntent, int paramInt) {
        this.this$0.pendingRequest.getStartActivityDelegate().startActivityForResult(paramIntent, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/AuthorizationClient$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */