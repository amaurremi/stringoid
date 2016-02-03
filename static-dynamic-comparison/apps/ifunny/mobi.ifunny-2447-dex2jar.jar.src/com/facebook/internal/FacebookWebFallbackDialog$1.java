package com.facebook.internal;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.FacebookException;
import com.facebook.widget.FacebookDialog;
import com.facebook.widget.FacebookDialog.Callback;
import com.facebook.widget.FacebookDialog.PendingCall;
import com.facebook.widget.WebDialog.OnCompleteListener;

final class FacebookWebFallbackDialog$1
        implements WebDialog.OnCompleteListener {
    FacebookWebFallbackDialog$1(Context paramContext, FacebookDialog.PendingCall paramPendingCall, FacebookDialog.Callback paramCallback) {
    }

    public void onComplete(Bundle paramBundle, FacebookException paramFacebookException) {
        Intent localIntent = new Intent();
        paramFacebookException = paramBundle;
        if (paramBundle == null) {
            paramFacebookException = new Bundle();
        }
        localIntent.putExtras(paramFacebookException);
        FacebookDialog.handleActivityResult(this.val$context, this.val$appCall, this.val$appCall.getRequestCode(), localIntent, this.val$callback);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/internal/FacebookWebFallbackDialog$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */