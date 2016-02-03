package com.facebook;

import android.content.ActivityNotFoundException;
import android.content.Intent;

abstract class AuthorizationClient$KatanaAuthHandler
        extends AuthorizationClient.AuthHandler {
    private static final long serialVersionUID = 1L;

    AuthorizationClient$KatanaAuthHandler(AuthorizationClient paramAuthorizationClient) {
        super(paramAuthorizationClient);
    }

    protected boolean tryIntent(Intent paramIntent, int paramInt) {
        if (paramIntent == null) {
            return false;
        }
        try {
            this.this$0.getStartActivityDelegate().startActivityForResult(paramIntent, paramInt);
            return true;
        } catch (ActivityNotFoundException paramIntent) {
        }
        return false;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/AuthorizationClient$KatanaAuthHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */