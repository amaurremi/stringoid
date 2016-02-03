package com.facebook;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.Fragment;

class Session$AuthorizationRequest$2
        implements Session.StartActivityDelegate {
    Session$AuthorizationRequest$2(Session.AuthorizationRequest paramAuthorizationRequest, Fragment paramFragment) {
    }

    public Activity getActivityContext() {
        return this.val$fragment.getActivity();
    }

    public void startActivityForResult(Intent paramIntent, int paramInt) {
        this.val$fragment.startActivityForResult(paramIntent, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/Session$AuthorizationRequest$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */