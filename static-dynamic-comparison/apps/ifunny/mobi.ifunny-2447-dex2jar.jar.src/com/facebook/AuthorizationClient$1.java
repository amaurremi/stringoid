package com.facebook;

import android.app.Activity;
import android.content.Intent;

class AuthorizationClient$1
        implements AuthorizationClient.StartActivityDelegate {
    AuthorizationClient$1(AuthorizationClient paramAuthorizationClient, Activity paramActivity) {
    }

    public Activity getActivityContext() {
        return this.val$activity;
    }

    public void startActivityForResult(Intent paramIntent, int paramInt) {
        this.val$activity.startActivityForResult(paramIntent, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/AuthorizationClient$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */