package com.facebook;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.facebook.android.R.id;
import com.facebook.android.R.layout;

public class LoginActivity
        extends Activity {
    private static final String EXTRA_REQUEST = "request";
    private static final String NULL_CALLING_PKG_ERROR_MSG = "Cannot call LoginActivity with a null calling package. This can occur if the launchMode of the caller is singleInstance.";
    static final String RESULT_KEY = "com.facebook.LoginActivity:Result";
    private static final String SAVED_AUTH_CLIENT = "authorizationClient";
    private static final String SAVED_CALLING_PKG_KEY = "callingPackage";
    private AuthorizationClient authorizationClient;
    private String callingPackage;
    private AuthorizationClient.AuthorizationRequest request;

    private void onAuthClientCompleted(AuthorizationClient.Result paramResult) {
        this.request = null;
        if (paramResult.code == AuthorizationClient.Result.Code.CANCEL) {
        }
        for (int i = 0; ; i = -1) {
            Bundle localBundle = new Bundle();
            localBundle.putSerializable("com.facebook.LoginActivity:Result", paramResult);
            paramResult = new Intent();
            paramResult.putExtras(localBundle);
            setResult(i, paramResult);
            finish();
            return;
        }
    }

    static Bundle populateIntentExtras(AuthorizationClient.AuthorizationRequest paramAuthorizationRequest) {
        Bundle localBundle = new Bundle();
        localBundle.putSerializable("request", paramAuthorizationRequest);
        return localBundle;
    }

    protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
        this.authorizationClient.onActivityResult(paramInt1, paramInt2, paramIntent);
    }

    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        setContentView(R.layout.com_facebook_login_activity_layout);
        if (paramBundle != null) {
            this.callingPackage = paramBundle.getString("callingPackage");
            this.authorizationClient = ((AuthorizationClient) paramBundle.getSerializable("authorizationClient"));
        }
        for (; ; ) {
            this.authorizationClient.setContext(this);
            this.authorizationClient.setOnCompletedListener(new AuthorizationClient.OnCompletedListener() {
                public void onCompleted(AuthorizationClient.Result paramAnonymousResult) {
                    LoginActivity.this.onAuthClientCompleted(paramAnonymousResult);
                }
            });
            this.authorizationClient.setBackgroundProcessingListener(new AuthorizationClient.BackgroundProcessingListener() {
                public void onBackgroundProcessingStarted() {
                    LoginActivity.this.findViewById(R.id.com_facebook_login_activity_progress_bar).setVisibility(0);
                }

                public void onBackgroundProcessingStopped() {
                    LoginActivity.this.findViewById(R.id.com_facebook_login_activity_progress_bar).setVisibility(8);
                }
            });
            return;
            this.callingPackage = getCallingPackage();
            this.authorizationClient = new AuthorizationClient();
            this.request = ((AuthorizationClient.AuthorizationRequest) getIntent().getSerializableExtra("request"));
        }
    }

    public void onPause() {
        super.onPause();
        this.authorizationClient.cancelCurrentHandler();
        findViewById(R.id.com_facebook_login_activity_progress_bar).setVisibility(8);
    }

    public void onResume() {
        super.onResume();
        try {
            if (this.callingPackage == null) {
                throw new FacebookException("Cannot call LoginActivity with a null calling package. This can occur if the launchMode of the caller is singleInstance.");
            }
            this.authorizationClient.startOrContinueAuth(this.request);
            return;
        } catch (Exception localException) {
        }
    }

    public void onSaveInstanceState(Bundle paramBundle) {
        super.onSaveInstanceState(paramBundle);
        paramBundle.putString("callingPackage", this.callingPackage);
        paramBundle.putSerializable("authorizationClient", this.authorizationClient);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/facebook/LoginActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */