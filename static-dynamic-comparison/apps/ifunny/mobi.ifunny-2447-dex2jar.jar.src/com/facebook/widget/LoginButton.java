package com.facebook.widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.facebook.FacebookException;
import com.facebook.Request;
import com.facebook.Session;
import com.facebook.Session.StatusCallback;
import com.facebook.SessionDefaultAudience;
import com.facebook.SessionLoginBehavior;
import com.facebook.android.R.color;
import com.facebook.android.R.dimen;
import com.facebook.android.R.drawable;
import com.facebook.android.R.string;
import com.facebook.android.R.styleable;
import com.facebook.internal.SessionTracker;
import com.facebook.internal.Utility;
import com.facebook.internal.Utility.FetchedAppSettings;
import com.facebook.model.GraphUser;

import java.util.Arrays;
import java.util.List;

public class LoginButton
        extends Button {
    private static final String TAG = LoginButton.class.getName();
    private String applicationId = null;
    private boolean confirmLogout;
    private boolean fetchUserInfo;
    private View.OnClickListener listenerCallback;
    private String loginLogoutEventName = "fb_login_view_usage";
    private String loginText;
    private String logoutText;
    private boolean nuxChecked;
    private long nuxDisplayTime = 6000L;
    private LoginButton.ToolTipMode nuxMode = LoginButton.ToolTipMode.DEFAULT;
    private ToolTipPopup nuxPopup;
    private ToolTipPopup.Style nuxStyle = ToolTipPopup.Style.BLUE;
    private Fragment parentFragment;
    private LoginButton.LoginButtonProperties properties = new LoginButton.LoginButtonProperties();
    private SessionTracker sessionTracker;
    private GraphUser user = null;
    private LoginButton.UserInfoChangedCallback userInfoChangedCallback;
    private Session userInfoSession = null;

    public LoginButton(Context paramContext) {
        super(paramContext);
        initializeActiveSessionWithCachedToken(paramContext);
        finishInit();
    }

    public LoginButton(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
        if (paramAttributeSet.getStyleAttribute() == 0) {
            setGravity(17);
            setTextColor(getResources().getColor(R.color.com_facebook_loginview_text_color));
            setTextSize(0, getResources().getDimension(R.dimen.com_facebook_loginview_text_size));
            setTypeface(Typeface.DEFAULT_BOLD);
            if (!isInEditMode()) {
                break label156;
            }
            setBackgroundColor(getResources().getColor(R.color.com_facebook_blue));
            this.loginText = "Log in with Facebook";
        }
        for (; ; ) {
            parseAttributes(paramAttributeSet);
            if (!isInEditMode()) {
                initializeActiveSessionWithCachedToken(paramContext);
            }
            return;
            label156:
            setBackgroundResource(R.drawable.com_facebook_button_blue);
            setCompoundDrawablesWithIntrinsicBounds(R.drawable.com_facebook_inverse_icon, 0, 0, 0);
            setCompoundDrawablePadding(getResources().getDimensionPixelSize(R.dimen.com_facebook_loginview_compound_drawable_padding));
            setPadding(getResources().getDimensionPixelSize(R.dimen.com_facebook_loginview_padding_left), getResources().getDimensionPixelSize(R.dimen.com_facebook_loginview_padding_top), getResources().getDimensionPixelSize(R.dimen.com_facebook_loginview_padding_right), getResources().getDimensionPixelSize(R.dimen.com_facebook_loginview_padding_bottom));
        }
    }

    public LoginButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
        parseAttributes(paramAttributeSet);
        initializeActiveSessionWithCachedToken(paramContext);
    }

    private void checkNuxSettings() {
        if (this.nuxMode == LoginButton.ToolTipMode.DISPLAY_ALWAYS) {
            displayNux(getResources().getString(R.string.com_facebook_tooltip_default));
            return;
        }
        new LoginButton .1 (this, Utility.getMetadataApplicationId(getContext())).execute((Void[]) null);
    }

    private void displayNux(String paramString) {
        this.nuxPopup = new ToolTipPopup(paramString, this);
        this.nuxPopup.setStyle(this.nuxStyle);
        this.nuxPopup.setNuxDisplayTime(this.nuxDisplayTime);
        this.nuxPopup.show();
    }

    private void fetchUserInfo() {
        if (this.fetchUserInfo) {
            Session localSession = this.sessionTracker.getOpenSession();
            if (localSession == null) {
                break label57;
            }
            if (localSession != this.userInfoSession) {
                Request.executeBatchAsync(new Request[]{Request.newMeRequest(localSession, new LoginButton.2(this, localSession))})
                ;
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
        super.setOnClickListener(new LoginButton.LoginClickListener(this, null));
        setButtonText();
        if (!isInEditMode()) {
            this.sessionTracker = new SessionTracker(getContext(), new LoginButton.LoginButtonCallback(this, null), null, false);
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
        this.confirmLogout = paramAttributeSet.getBoolean(R.styleable.com_facebook_login_view_confirm_logout, true);
        this.fetchUserInfo = paramAttributeSet.getBoolean(R.styleable.com_facebook_login_view_fetch_user_info, true);
        this.loginText = paramAttributeSet.getString(R.styleable.com_facebook_login_view_login_text);
        this.logoutText = paramAttributeSet.getString(R.styleable.com_facebook_login_view_logout_text);
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

    private void showNuxPerSettings(Utility.FetchedAppSettings paramFetchedAppSettings) {
        if ((paramFetchedAppSettings != null) && (paramFetchedAppSettings.getNuxEnabled()) && (getVisibility() == 0)) {
            displayNux(paramFetchedAppSettings.getNuxContent());
        }
    }

    public void clearPermissions() {
        this.properties.clearPermissions();
    }

    public void dismissToolTip() {
        if (this.nuxPopup != null) {
            this.nuxPopup.dismiss();
            this.nuxPopup = null;
        }
    }

    public SessionDefaultAudience getDefaultAudience() {
        return this.properties.getDefaultAudience();
    }

    public SessionLoginBehavior getLoginBehavior() {
        return this.properties.getLoginBehavior();
    }

    public LoginButton.OnErrorListener getOnErrorListener() {
        return this.properties.getOnErrorListener();
    }

    List<String> getPermissions() {
        return this.properties.getPermissions();
    }

    public Session.StatusCallback getSessionStatusCallback() {
        return this.properties.getSessionStatusCallback();
    }

    public long getToolTipDisplayTime() {
        return this.nuxDisplayTime;
    }

    public LoginButton.ToolTipMode getToolTipMode() {
        return this.nuxMode;
    }

    public LoginButton.UserInfoChangedCallback getUserInfoChangedCallback() {
        return this.userInfoChangedCallback;
    }

    void handleError(Exception paramException) {
        if (LoginButton.LoginButtonProperties.access$2000(this.properties) != null) {
            if ((paramException instanceof FacebookException)) {
                LoginButton.LoginButtonProperties.access$2000(this.properties).onError((FacebookException) paramException);
            }
        } else {
            return;
        }
        LoginButton.LoginButtonProperties.access$2000(this.properties).onError(new FacebookException(paramException));
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
        dismissToolTip();
    }

    protected void onDraw(Canvas paramCanvas) {
        super.onDraw(paramCanvas);
        if ((!this.nuxChecked) && (this.nuxMode != LoginButton.ToolTipMode.NEVER_DISPLAY) && (!isInEditMode())) {
            this.nuxChecked = true;
            checkNuxSettings();
        }
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        finishInit();
    }

    protected void onVisibilityChanged(View paramView, int paramInt) {
        super.onVisibilityChanged(paramView, paramInt);
        if (paramInt != 0) {
            dismissToolTip();
        }
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

    void setLoginLogoutEventName(String paramString) {
        this.loginLogoutEventName = paramString;
    }

    public void setOnClickListener(View.OnClickListener paramOnClickListener) {
        this.listenerCallback = paramOnClickListener;
    }

    public void setOnErrorListener(LoginButton.OnErrorListener paramOnErrorListener) {
        this.properties.setOnErrorListener(paramOnErrorListener);
    }

    void setProperties(LoginButton.LoginButtonProperties paramLoginButtonProperties) {
        this.properties = paramLoginButtonProperties;
    }

    public void setPublishPermissions(List<String> paramList) {
        this.properties.setPublishPermissions(paramList, this.sessionTracker.getSession());
    }

    public void setPublishPermissions(String... paramVarArgs) {
        this.properties.setPublishPermissions(Arrays.asList(paramVarArgs), this.sessionTracker.getSession());
    }

    public void setReadPermissions(List<String> paramList) {
        this.properties.setReadPermissions(paramList, this.sessionTracker.getSession());
    }

    public void setReadPermissions(String... paramVarArgs) {
        this.properties.setReadPermissions(Arrays.asList(paramVarArgs), this.sessionTracker.getSession());
    }

    public void setSession(Session paramSession) {
        this.sessionTracker.setSession(paramSession);
        fetchUserInfo();
        setButtonText();
    }

    public void setSessionStatusCallback(Session.StatusCallback paramStatusCallback) {
        this.properties.setSessionStatusCallback(paramStatusCallback);
    }

    public void setToolTipDisplayTime(long paramLong) {
        this.nuxDisplayTime = paramLong;
    }

    public void setToolTipMode(LoginButton.ToolTipMode paramToolTipMode) {
        this.nuxMode = paramToolTipMode;
    }

    public void setToolTipStyle(ToolTipPopup.Style paramStyle) {
        this.nuxStyle = paramStyle;
    }

    public void setUserInfoChangedCallback(LoginButton.UserInfoChangedCallback paramUserInfoChangedCallback) {
        this.userInfoChangedCallback = paramUserInfoChangedCallback;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/widget/LoginButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */