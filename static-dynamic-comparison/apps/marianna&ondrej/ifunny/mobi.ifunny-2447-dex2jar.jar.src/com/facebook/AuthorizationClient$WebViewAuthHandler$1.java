package com.facebook;

import android.os.Bundle;
import com.facebook.widget.WebDialog.OnCompleteListener;

class AuthorizationClient$WebViewAuthHandler$1
        implements WebDialog.OnCompleteListener {
    AuthorizationClient$WebViewAuthHandler$1(AuthorizationClient.WebViewAuthHandler paramWebViewAuthHandler, AuthorizationClient.AuthorizationRequest paramAuthorizationRequest) {
    }

    public void onComplete(Bundle paramBundle, FacebookException paramFacebookException) {
        this.this$1.onWebDialogComplete(this.val$request, paramBundle, paramFacebookException);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/AuthorizationClient$WebViewAuthHandler$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */