package com.quoord.tapatalkHD;

import android.app.ActionBar;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.LoggingBehavior;
import com.facebook.Request;
import com.facebook.Request.GraphUserCallback;
import com.facebook.Response;
import com.facebook.Session;
import com.facebook.Session.OpenRequest;
import com.facebook.Session.StatusCallback;
import com.facebook.SessionState;
import com.facebook.Settings;
import com.facebook.UiLifecycleHelper;
import com.facebook.model.GraphUser;
import com.quoord.tapatalkpro.util.Util;

import java.util.Arrays;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity
        extends Activity {
    private static final String[] PERMISSIONS = {"publish_stream", "read_stream", "offline_access"};
    ProgressDialog mypDialog;
    Session session;
    private Session.StatusCallback statusCallback = new SessionStatusCallback(null);
    private UiLifecycleHelper uiHelper;

    private void makeMeRequest(final Session paramSession) {
        if ((paramSession != null) && (paramSession.isOpened())) {
            Request.newMeRequest(paramSession, new Request.GraphUserCallback() {
                public void onCompleted(GraphUser paramAnonymousGraphUser, Response paramAnonymousResponse) {
                    if ((paramAnonymousGraphUser != null) && (paramAnonymousResponse != null)) {
                    }
                    try {
                        if (paramAnonymousResponse.getRequest().getSession() == paramSession) {
                            paramAnonymousResponse = paramSession.getAccessToken();
                            String str1 = paramAnonymousGraphUser.getInnerJSONObject().getString("email");
                            String str2 = paramAnonymousGraphUser.getInnerJSONObject().toString();
                            paramAnonymousGraphUser = paramAnonymousGraphUser.getInnerJSONObject().getString("name");
                            Intent localIntent = new Intent();
                            localIntent.putExtra("token", paramAnonymousResponse);
                            localIntent.putExtra("email", str1);
                            localIntent.putExtra("name", paramAnonymousGraphUser);
                            localIntent.putExtra("data", str2);
                            MainActivity.this.setResult(-1, localIntent);
                            MainActivity.this.closeProgress();
                            MainActivity.this.finish();
                        }
                        return;
                    } catch (JSONException paramAnonymousGraphUser) {
                        paramAnonymousGraphUser.printStackTrace();
                        Util.showToastForLong(MainActivity.this, MainActivity.this.getString(2131100508));
                        MainActivity.this.finish();
                    }
                }
            }).executeAsync();
        }
    }

    private void onClickLogin() {
        Session localSession = Session.getActiveSession();
        if ((!localSession.isOpened()) && (!localSession.isClosed())) {
            localSession.openForRead(new Session.OpenRequest(this).setCallback(this.statusCallback));
            return;
        }
        Session.openActiveSession(this, true, this.statusCallback);
    }

    private void onClickLogout() {
        makeMeRequest(Session.getActiveSession());
    }

    public void closeProgress() {
        if ((this.mypDialog != null) && (this.mypDialog.isShowing())) {
            this.mypDialog.dismiss();
        }
    }

    public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
        super.onActivityResult(paramInt1, paramInt2, paramIntent);
        this.uiHelper.onActivityResult(paramInt1, paramInt2, paramIntent);
        Session.getActiveSession().onActivityResult(this, paramInt1, paramInt2, paramIntent);
    }

    public void onCreate(Bundle paramBundle) {
        Util.setPortrait(this);
        super.onCreate(paramBundle);
        setContentView(2130903131);
        getActionBar().setIcon(2130837525);
        this.uiHelper = new UiLifecycleHelper(this, this.statusCallback);
        this.uiHelper.onCreate(paramBundle);
        start();
    }

    public void onDestroy() {
        super.onDestroy();
        this.uiHelper.onDestroy();
    }

    public void onPause() {
        super.onPause();
        this.uiHelper.onPause();
    }

    public void onResume() {
        super.onResume();
        this.uiHelper.onResume();
    }

    protected void onSaveInstanceState(Bundle paramBundle) {
        super.onSaveInstanceState(paramBundle);
        this.uiHelper.onSaveInstanceState(paramBundle);
        Session.getActiveSession();
    }

    public void showProgress() {
        if (this.mypDialog == null) {
            this.mypDialog = new ProgressDialog(this);
            this.mypDialog.setProgressStyle(0);
            this.mypDialog.setIndeterminate(false);
            this.mypDialog.setCanceledOnTouchOutside(false);
        }
        if (!this.mypDialog.isShowing()) {
            this.mypDialog.show();
        }
    }

    public void start() {
        Settings.addLoggingBehavior(LoggingBehavior.INCLUDE_ACCESS_TOKENS);
        this.session = new Session(this);
        Session.setActiveSession(this.session);
        showProgress();
        if ((!this.session.isOpened()) && (!this.session.isClosed())) {
            closeProgress();
            this.session.openForRead(new Session.OpenRequest(this).setCallback(this.statusCallback).setPermissions(Arrays.asList(new String[]{"email"})));
            return;
        }
        showProgress();
        Session.openActiveSession(this, true, this.statusCallback);
    }

    private class SessionStatusCallback
            implements Session.StatusCallback {
        private SessionStatusCallback() {
        }

        public void call(Session paramSession, SessionState paramSessionState, Exception paramException) {
            if (paramSessionState == SessionState.OPENED) {
                MainActivity.this.makeMeRequest(paramSession);
            }
            do {
                return;
                if (paramSessionState == SessionState.CLOSED) {
                    Session.openActiveSession(MainActivity.this, true, MainActivity.this.statusCallback);
                    return;
                }
            } while (paramSessionState != SessionState.CLOSED_LOGIN_FAILED);
            Util.showToastForLong(MainActivity.this, MainActivity.this.getString(2131100508));
            MainActivity.this.finish();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkHD/MainActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */