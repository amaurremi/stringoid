package com.facebook.widget;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.facebook.FacebookException;
import com.facebook.FacebookRequestError;
import com.facebook.Request;
import com.facebook.Request.GraphUserCallback;
import com.facebook.Response;
import com.facebook.Session;
import com.facebook.Session.Builder;
import com.facebook.Session.OpenRequest;
import com.facebook.Session.StatusCallback;
import com.facebook.SessionDefaultAudience;
import com.facebook.SessionLoginBehavior;
import com.facebook.SessionState;
import com.facebook.android.R.color;
import com.facebook.android.R.dimen;
import com.facebook.android.R.drawable;
import com.facebook.android.R.string;
import com.facebook.android.R.styleable;
import com.facebook.internal.SessionAuthorizationType;
import com.facebook.internal.SessionTracker;
import com.facebook.internal.Utility;
import com.facebook.model.GraphUser;

import java.util.Collections;
import java.util.List;

public class LoginButton
        extends Button {
    private static final String TAG = LoginButton.class.getName();
    private String applicationId = null;
    private boolean confirmLogout;
    private boolean fetchUserInfo;
    private String loginText;
    private String logoutText;
    private Fragment parentFragment;
    private LoginButtonProperties properties = new LoginButtonProperties();
    private SessionTracker sessionTracker;
    private GraphUser user = null;
    private UserInfoChangedCallback userInfoChangedCallback;
    private Session userInfoSession = null;

    public LoginButton(Context paramContext) {
        super(paramContext);
        initializeActiveSessionWithCachedToken(paramContext);
        finishInit();
    }

    public LoginButton(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
        if (paramAttributeSet.getStyleAttribute() == 0) {
            setTextColor(getResources().getColor(R.color.com_facebook_loginview_text_color));
            setTextSize(0, getResources().getDimension(R.dimen.com_facebook_loginview_text_size));
            setPadding(getResources().getDimensionPixelSize(R.dimen.com_facebook_loginview_padding_left), getResources().getDimensionPixelSize(R.dimen.com_facebook_loginview_padding_top), getResources().getDimensionPixelSize(R.dimen.com_facebook_loginview_padding_right), getResources().getDimensionPixelSize(R.dimen.com_facebook_loginview_padding_bottom));
            setWidth(getResources().getDimensionPixelSize(R.dimen.com_facebook_loginview_width));
            setHeight(getResources().getDimensionPixelSize(R.dimen.com_facebook_loginview_height));
            setGravity(17);
            if (!isInEditMode()) {
                break label194;
            }
            setBackgroundColor(getResources().getColor(R.color.com_facebook_blue));
            this.loginText = "Log in";
        }
        for (; ; ) {
            parseAttributes(paramAttributeSet);
            if (!isInEditMode()) {
                initializeActiveSessionWithCachedToken(paramContext);
            }
            return;
            label194:
            setBackgroundResource(R.drawable.com_facebook_loginbutton_blue);
        }
    }

    public LoginButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
        parseAttributes(paramAttributeSet);
        initializeActiveSessionWithCachedToken(paramContext);
    }

    private void fetchUserInfo() {
        if (this.fetchUserInfo) {
            final Session localSession = this.sessionTracker.getOpenSession();
            if (localSession == null) {
                break label57;
            }
            if (localSession != this.userInfoSession) {
                Request.executeBatchAsync(new Request[]{Request.newMeRequest(localSession, new Request.GraphUserCallback() {
                    public void onCompleted(GraphUser paramAnonymousGraphUser, Response paramAnonymousResponse) {
                        if (localSession == LoginButton.this.sessionTracker.getOpenSession()) {
                            LoginButton.this.user = paramAnonymousGraphUser;
                            if (LoginButton.this.userInfoChangedCallback != null) {
                                LoginButton.this.userInfoChangedCallback.onUserInfoFetched(LoginButton.this.user);
                            }
                        }
                        if (paramAnonymousResponse.getError() != null) {
                            LoginButton.this.handleError(paramAnonymousResponse.getError().getException());
                        }
                    }
                })});
                this.userInfoSession = localSession;
            }
        }
        label57:
        do {
            return;
            this.user = null;
        } while (this.userInfoChangedCallback == null);
        this.userInfoChangedCallback.onUserInfoFetched(this.user);
    }

    private void finishInit() {
        setOnClickListener(new LoginClickListener(null));
        setButtonText();
        if (!isInEditMode()) {
            this.sessionTracker = new SessionTracker(getContext(), new LoginButtonCallback(null), null, false);
            fetchUserInfo();
        }
    }

    private boolean initializeActiveSessionWithCachedToken(Context paramContext) {
        if (paramContext == null) {
        }
        do {
            return false;
            Session localSession = Session.getActiveSession();
            if (localSession != null) {
                return localSession.isOpened();
            }
        }
        while ((Utility.getMetadataApplicationId(paramContext) == null) || (Session.openActiveSessionFromCache(paramContext) == null));
        return true;
    }

    private void parseAttributes(AttributeSet paramAttributeSet) {
        paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.com_facebook_login_view);
        this.confirmLogout = paramAttributeSet.getBoolean(0, true);
        this.fetchUserInfo = paramAttributeSet.getBoolean(1, true);
        this.loginText = paramAttributeSet.getString(2);
        this.logoutText = paramAttributeSet.getString(3);
        paramAttributeSet.recycle();
    }

    private void setButtonText() {
        if ((this.sessionTracker != null) && (this.sessionTracker.getOpenSession() != null)) {
            if (this.logoutText != null) {
            }
            for (str = this.logoutText; ; str = getResources().getString(R.string.com_facebook_loginview_log_out_button)) {
                setText(str);
                return;
            }
        }
        if (this.loginText != null) {
        }
        for (String str = this.loginText; ; str = getResources().getString(R.string.com_facebook_loginview_log_in_button)) {
            setText(str);
            return;
        }
    }

    public void clearPermissions() {
        this.properties.clearPermissions();
    }

    public SessionDefaultAudience getDefaultAudience() {
        return this.properties.getDefaultAudience();
    }

    public SessionLoginBehavior getLoginBehavior() {
        return this.properties.getLoginBehavior();
    }

    public OnErrorListener getOnErrorListener() {
        return this.properties.getOnErrorListener();
    }

    List<String> getPermissions() {
        return this.properties.getPermissions();
    }

    public Session.StatusCallback getSessionStatusCallback() {
        return this.properties.getSessionStatusCallback();
    }

    public UserInfoChangedCallback getUserInfoChangedCallback() {
        return this.userInfoChangedCallback;
    }

    void handleError(Exception paramException) {
        if (this.properties.onErrorListener != null) {
            if ((paramException instanceof FacebookException)) {
                this.properties.onErrorListener.onError((FacebookException) paramException);
            }
        } else {
            return;
        }
        this.properties.onErrorListener.onError(new FacebookException(paramException));
    }

    public boolean onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
        Session localSession = this.sessionTracker.getSession();
        if (localSession != null) {
            return localSession.onActivityResult((Activity) getContext(), paramInt1, paramInt2, paramIntent);
        }
        return false;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if ((this.sessionTracker != null) && (!this.sessionTracker.isTracking())) {
            this.sessionTracker.startTracking();
            fetchUserInfo();
            setButtonText();
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.sessionTracker != null) {
            this.sessionTracker.stopTracking();
        }
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        finishInit();
    }

    public void setApplicationId(String paramString) {
        this.applicationId = paramString;
    }

    public void setDefaultAudience(SessionDefaultAudience paramSessionDefaultAudience) {
        this.properties.setDefaultAudience(paramSessionDefaultAudience);
    }

    public void setFragment(Fragment paramFragment) {
        this.parentFragment = paramFragment;
    }

    public void setLoginBehavior(SessionLoginBehavior paramSessionLoginBehavior) {
        this.properties.setLoginBehavior(paramSessionLoginBehavior);
    }

    public void setOnErrorListener(OnErrorListener paramOnErrorListener) {
        this.properties.setOnErrorListener(paramOnErrorListener);
    }

    void setProperties(LoginButtonProperties paramLoginButtonProperties) {
        this.properties = paramLoginButtonProperties;
    }

    public void setPublishPermissions(List<String> paramList) {
        this.properties.setPublishPermissions(paramList, this.sessionTracker.getSession());
    }

    public void setReadPermissions(List<String> paramList) {
        this.properties.setReadPermissions(paramList, this.sessionTracker.getSession());
    }

    public void setSession(Session paramSession) {
        this.sessionTracker.setSession(paramSession);
        fetchUserInfo();
        setButtonText();
    }

    public void setSessionStatusCallback(Session.StatusCallback paramStatusCallback) {
        this.properties.setSessionStatusCallback(paramStatusCallback);
    }

    public void setUserInfoChangedCallback(UserInfoChangedCallback paramUserInfoChangedCallback) {
        this.userInfoChangedCallback = paramUserInfoChangedCallback;
    }

    private class LoginButtonCallback
            implements Session.StatusCallback {
        private LoginButtonCallback() {
        }

        public void call(Session paramSession, SessionState paramSessionState, Exception paramException) {
            LoginButton.this.fetchUserInfo();
            LoginButton.this.setButtonText();
            if (paramException != null) {
                LoginButton.this.handleError(paramException);
            }
            if (LoginButton.LoginButtonProperties.access$4(LoginButton.this.properties) != null) {
                LoginButton.LoginButtonProperties.access$4(LoginButton.this.properties).call(paramSession, paramSessionState, paramException);
            }
        }
    }

    static class LoginButtonProperties {
        private SessionAuthorizationType authorizationType = null;
        private SessionDefaultAudience defaultAudience = SessionDefaultAudience.FRIENDS;
        private SessionLoginBehavior loginBehavior = SessionLoginBehavior.SSO_WITH_FALLBACK;
        private LoginButton.OnErrorListener onErrorListener;
        private List<String> permissions = Collections.emptyList();
        private Session.StatusCallback sessionStatusCallback;

        private boolean validatePermissions(List<String> paramList, SessionAuthorizationType paramSessionAuthorizationType, Session paramSession) {
            if ((SessionAuthorizationType.PUBLISH.equals(paramSessionAuthorizationType)) && (Utility.isNullOrEmpty(paramList))) {
                throw new IllegalArgumentException("Permissions for publish actions cannot be null or empty.");
            }
            if ((paramSession != null) && (paramSession.isOpened()) && (!Utility.isSubset(paramList, paramSession.getPermissions()))) {
                Log.e(LoginButton.TAG, "Cannot set additional permissions when session is already open.");
                return false;
            }
            return true;
        }

        public void clearPermissions() {
            this.permissions = null;
            this.authorizationType = null;
        }

        public SessionDefaultAudience getDefaultAudience() {
            return this.defaultAudience;
        }

        public SessionLoginBehavior getLoginBehavior() {
            return this.loginBehavior;
        }

        public LoginButton.OnErrorListener getOnErrorListener() {
            return this.onErrorListener;
        }

        List<String> getPermissions() {
            return this.permissions;
        }

        public Session.StatusCallback getSessionStatusCallback() {
            return this.sessionStatusCallback;
        }

        public void setDefaultAudience(SessionDefaultAudience paramSessionDefaultAudience) {
            this.defaultAudience = paramSessionDefaultAudience;
        }

        public void setLoginBehavior(SessionLoginBehavior paramSessionLoginBehavior) {
            this.loginBehavior = paramSessionLoginBehavior;
        }

        public void setOnErrorListener(LoginButton.OnErrorListener paramOnErrorListener) {
            this.onErrorListener = paramOnErrorListener;
        }

        public void setPublishPermissions(List<String> paramList, Session paramSession) {
            if (SessionAuthorizationType.READ.equals(this.authorizationType)) {
                throw new UnsupportedOperationException("Cannot call setPublishPermissions after setReadPermissions has been called.");
            }
            if (validatePermissions(paramList, SessionAuthorizationType.PUBLISH, paramSession)) {
                this.permissions = paramList;
                this.authorizationType = SessionAuthorizationType.PUBLISH;
            }
        }

        public void setReadPermissions(List<String> paramList, Session paramSession) {
            if (SessionAuthorizationType.PUBLISH.equals(this.authorizationType)) {
                throw new UnsupportedOperationException("Cannot call setReadPermissions after setPublishPermissions has been called.");
            }
            if (validatePermissions(paramList, SessionAuthorizationType.READ, paramSession)) {
                this.permissions = paramList;
                this.authorizationType = SessionAuthorizationType.READ;
            }
        }

        public void setSessionStatusCallback(Session.StatusCallback paramStatusCallback) {
            this.sessionStatusCallback = paramStatusCallback;
        }
    }

    private class LoginClickListener
            implements View.OnClickListener {
        private LoginClickListener() {
        }

        public void onClick(View paramView) {
            Object localObject2 = LoginButton.this.getContext();
            final Object localObject1 = LoginButton.this.sessionTracker.getOpenSession();
            if (localObject1 != null) {
                if (LoginButton.this.confirmLogout) {
                    String str1 = LoginButton.this.getResources().getString(R.string.com_facebook_loginview_log_out_action);
                    String str2 = LoginButton.this.getResources().getString(R.string.com_facebook_loginview_cancel_action);
                    if ((LoginButton.this.user != null) && (LoginButton.this.user.getName() != null)) {
                        paramView = String.format(LoginButton.this.getResources().getString(R.string.com_facebook_loginview_logged_in_as), new Object[]{LoginButton.this.user.getName()});
                        localObject2 = new AlertDialog.Builder((Context) localObject2);
                        ((AlertDialog.Builder) localObject2).setMessage(paramView).setCancelable(true).setPositiveButton(str1, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                                localObject1.closeAndClearTokenInformation();
                            }
                        }).setNegativeButton(str2, null);
                        ((AlertDialog.Builder) localObject2).create().show();
                    }
                }
            }
            for (; ; ) {
                return;
                paramView = LoginButton.this.getResources().getString(R.string.com_facebook_loginview_logged_in_using_facebook);
                break;
                ((Session) localObject1).closeAndClearTokenInformation();
                return;
                paramView = LoginButton.this.sessionTracker.getSession();
                if (paramView != null) {
                    localObject1 = paramView;
                    if (!paramView.getState().isClosed()) {
                    }
                } else {
                    LoginButton.this.sessionTracker.setSession(null);
                    localObject1 = new Session.Builder((Context) localObject2).setApplicationId(LoginButton.this.applicationId).build();
                    Session.setActiveSession((Session) localObject1);
                }
                if (!((Session) localObject1).isOpened()) {
                    paramView = null;
                    if (LoginButton.this.parentFragment != null) {
                        paramView = new Session.OpenRequest(LoginButton.this.parentFragment);
                    }
                    while (paramView != null) {
                        paramView.setDefaultAudience(LoginButton.access$6(LoginButton.this).defaultAudience);
                        paramView.setPermissions(LoginButton.access$6(LoginButton.this).permissions);
                        paramView.setLoginBehavior(LoginButton.access$6(LoginButton.this).loginBehavior);
                        if (!SessionAuthorizationType.PUBLISH.equals(LoginButton.access$6(LoginButton.this).authorizationType)) {
                            break label387;
                        }
                        ((Session) localObject1).openForPublish(paramView);
                        return;
                        if ((localObject2 instanceof Activity)) {
                            paramView = new Session.OpenRequest((Activity) localObject2);
                        }
                    }
                }
            }
            label387:
            ((Session) localObject1).openForRead(paramView);
        }
    }

    public static abstract interface OnErrorListener {
        public abstract void onError(FacebookException paramFacebookException);
    }

    public static abstract interface UserInfoChangedCallback {
        public abstract void onUserInfoFetched(GraphUser paramGraphUser);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/facebook/widget/LoginButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */