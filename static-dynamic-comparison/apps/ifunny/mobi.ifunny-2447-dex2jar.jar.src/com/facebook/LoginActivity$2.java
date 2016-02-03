package com.facebook;

import android.view.View;
import com.facebook.android.R.id;

class LoginActivity$2
        implements AuthorizationClient.BackgroundProcessingListener {
    LoginActivity$2(LoginActivity paramLoginActivity) {
    }

    public void onBackgroundProcessingStarted() {
        this.this$0.findViewById(R.id.com_facebook_login_activity_progress_bar).setVisibility(0);
    }

    public void onBackgroundProcessingStopped() {
        this.this$0.findViewById(R.id.com_facebook_login_activity_progress_bar).setVisibility(8);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/LoginActivity$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */