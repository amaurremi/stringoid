package com.facebook;

import android.os.Bundle;
import com.facebook.internal.PlatformServiceClient.CompletedListener;

class AuthorizationClient$GetTokenAuthHandler$1
        implements PlatformServiceClient.CompletedListener {
    AuthorizationClient$GetTokenAuthHandler$1(AuthorizationClient.GetTokenAuthHandler paramGetTokenAuthHandler, AuthorizationClient.AuthorizationRequest paramAuthorizationRequest) {
    }

    public void completed(Bundle paramBundle) {
        this.this$1.getTokenCompleted(this.val$request, paramBundle);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/AuthorizationClient$GetTokenAuthHandler$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */