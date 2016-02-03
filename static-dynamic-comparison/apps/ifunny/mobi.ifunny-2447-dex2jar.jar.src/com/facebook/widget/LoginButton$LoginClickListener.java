package com.facebook.widget;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.AppEventsLogger;
import com.facebook.Session;
import com.facebook.Session.Builder;
import com.facebook.Session.OpenRequest;
import com.facebook.SessionState;
import com.facebook.android.R.string;
import com.facebook.internal.SessionAuthorizationType;
import com.facebook.internal.SessionTracker;
import com.facebook.model.GraphUser;

class LoginButton$LoginClickListener
        implements View.OnClickListener {
    private LoginButton$LoginClickListener(LoginButton paramLoginButton) {
    }

    public void onClick(View paramView) {
        Object localObject3 = this.this$0.getContext();
        Session localSession = LoginButton.access$400(this.this$0).getOpenSession();
        Object localObject2;
        Object localObject1;
        if (localSession != null) {
            if (LoginButton.access$700(this.this$0)) {
                localObject2 = this.this$0.getResources().getString(R.string.com_facebook_loginview_log_out_action);
                String str = this.this$0.getResources().getString(R.string.com_facebook_loginview_cancel_action);
                if ((LoginButton.access$500(this.this$0) != null) && (LoginButton.access$500(this.this$0).getName() != null)) {
                    localObject1 = String.format(this.this$0.getResources().getString(R.string.com_facebook_loginview_logged_in_as), new Object[]{LoginButton.access$500(this.this$0).getName()});
                    localObject3 = new AlertDialog.Builder((Context) localObject3);
                    ((AlertDialog.Builder) localObject3).setMessage((CharSequence) localObject1).setCancelable(true).setPositiveButton((CharSequence) localObject2, new LoginButton.LoginClickListener
                    .1 (this, localSession)).setNegativeButton(str, null);
                    ((AlertDialog.Builder) localObject3).create().show();
                }
            }
        }
        label205:
        label492:
        label495:
        for (; ; ) {
            localObject1 = AppEventsLogger.newLogger(this.this$0.getContext());
            localObject2 = new Bundle();
            int i;
            if (localSession != null) {
                i = 0;
                ((Bundle) localObject2).putInt("logging_in", i);
                ((AppEventsLogger) localObject1).logSdkEvent(LoginButton.access$1500(this.this$0), null, (Bundle) localObject2);
                if (LoginButton.access$1600(this.this$0) != null) {
                    LoginButton.access$1600(this.this$0).onClick(paramView);
                }
                return;
                localObject1 = this.this$0.getResources().getString(R.string.com_facebook_loginview_logged_in_using_facebook);
                break;
                localSession.closeAndClearTokenInformation();
                continue;
                localObject1 = LoginButton.access$400(this.this$0).getSession();
                if (localObject1 != null) {
                    localObject2 = localObject1;
                    if (!((Session) localObject1).getState().isClosed()) {
                    }
                } else {
                    LoginButton.access$400(this.this$0).setSession(null);
                    localObject2 = new Session.Builder((Context) localObject3).setApplicationId(LoginButton.access$800(this.this$0)).build();
                    Session.setActiveSession((Session) localObject2);
                }
                if (((Session) localObject2).isOpened()) {
                    continue;
                }
                if (LoginButton.access$900(this.this$0) != null) {
                    localObject1 = new Session.OpenRequest(LoginButton.access$900(this.this$0));
                }
            }
            for (; ; ) {
                if (localObject1 == null) {
                    break label495;
                }
                ((Session.OpenRequest) localObject1).setDefaultAudience(LoginButton.LoginButtonProperties.access$1100(LoginButton.access$1000(this.this$0)));
                ((Session.OpenRequest) localObject1).setPermissions(LoginButton.LoginButtonProperties.access$1200(LoginButton.access$1000(this.this$0)));
                ((Session.OpenRequest) localObject1).setLoginBehavior(LoginButton.LoginButtonProperties.access$1300(LoginButton.access$1000(this.this$0)));
                if (SessionAuthorizationType.PUBLISH.equals(LoginButton.LoginButtonProperties.access$1400(LoginButton.access$1000(this.this$0)))) {
                    ((Session) localObject2).openForPublish((Session.OpenRequest) localObject1);
                    break;
                    if (!(localObject3 instanceof Activity)) {
                        break label492;
                    }
                    localObject1 = new Session.OpenRequest((Activity) localObject3);
                    continue;
                }
                ((Session) localObject2).openForRead((Session.OpenRequest) localObject1);
                break;
                i = 1;
                break label205;
                localObject1 = null;
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/widget/LoginButton$LoginClickListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */