package com.quoord.newonboarding;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.google.android.gms.plus.model.people.Person;
import com.quoord.tapatalkpro.action.RegisterTidAction;
import com.quoord.tapatalkpro.activity.directory.ics.AccountEntryActivity;
import com.quoord.tapatalkpro.adapter.CallBackResult;
import com.quoord.tapatalkpro.adapter.forum.TapatalkIdCallBack;
import com.quoord.tapatalkpro.bean.TapatalkId;
import com.quoord.tapatalkpro.ics.tapatalkid.GooglePlusFragment;
import com.quoord.tapatalkpro.ics.tapatalkid.GooglePlusFragment.GoogleGetToken;
import com.quoord.tapatalkpro.ics.tapatalkid.SignInWithOtherUtil;
import com.quoord.tapatalkpro.ics.tapatalkid.TapatalkIdFactory;
import com.quoord.tapatalkpro.net.HandleCallBackResultListener;
import com.quoord.tapatalkpro.util.CustomTracker;
import com.quoord.tapatalkpro.util.Prefs;
import com.quoord.tapatalkpro.util.TapatalkJsonEngine;
import com.quoord.tapatalkpro.util.Util;
import com.quoord.tools.ActionBarController;
import com.quoord.tools.UserBehavior;
import com.quoord.tools.tracking.GoogleAnalyticsTools;

import java.io.Serializable;
import java.util.ArrayList;

public class LoginFragment
        extends GooglePlusFragment
        implements ActionBarController, GooglePlusFragment.GoogleGetToken {
    public static final int CALLFOR_GOOGLE_SERVICE = 5001;
    private ObJoinActivity activity;
    private ActionBar bar;
    private TextView forgetPasswordTextButton;
    private Button loginButton;
    private Handler mHandler;
    private SignInWithOtherUtil mSignInUtil;
    private ObActivitiesStackManager obStack;
    private String passwordEdit = null;
    private EditText passwordEditText;
    private int status;
    private EditText usernameOrEmailEditText;

    private void clearEditFocus() {
        this.usernameOrEmailEditText.clearFocus();
        this.passwordEditText.clearFocus();
    }

    private void initListenerAfterActivityCreated() {
        Object localObject = new View.OnClickListener() {
            public void onClick(View paramAnonymousView) {
                int i = paramAnonymousView.getId();
                if (i == LoginFragment.this.loginButton.getId()) {
                    paramAnonymousView = LoginFragment.this.usernameOrEmailEditText.getText().toString().trim();
                    LoginFragment.this.passwordEdit = LoginFragment.this.passwordEditText.getText().toString().trim();
                    if ((Util.checkString(paramAnonymousView)) && (Util.checkString(LoginFragment.this.passwordEdit))) {
                        if (LoginFragment.this.passwordEdit.length() > 3) {
                            if (Util.checkEmailFormat(paramAnonymousView)) {
                                LoginFragment.this.mSignInUtil.callSignIn(null, paramAnonymousView, LoginFragment.this.passwordEdit, null);
                                if (LoginFragment.this.activity.fromOBLogin) {
                                    UserBehavior.logNOBLogin(LoginFragment.this.activity);
                                }
                            }
                        }
                    }
                }
                for (; ; ) {
                    LoginFragment.this.clearEditFocus();
                    return;
                    LoginFragment.this.mSignInUtil.callSignIn(paramAnonymousView, null, LoginFragment.this.passwordEdit, null);
                    break;
                    Util.showToastForLong(LoginFragment.this.getActivity(), LoginFragment.this.getResources().getString(2131100315));
                    continue;
                    Util.showToastForLong(LoginFragment.this.getActivity(), LoginFragment.this.getResources().getString(2131100304));
                    continue;
                    if (i == LoginFragment.this.forgetPasswordTextButton.getId()) {
                        LoginFragment.this.activity.showFragmentAndAddStack(new TapatalkIdForgetPasswordFragment());
                    }
                }
            }
        };
        this.loginButton.setOnClickListener((View.OnClickListener) localObject);
        this.forgetPasswordTextButton.setOnClickListener((View.OnClickListener) localObject);
        localObject = new View.OnFocusChangeListener() {
            public void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean) {
                if ((!LoginFragment.this.usernameOrEmailEditText.isFocused()) && (!LoginFragment.this.passwordEditText.isFocused())) {
                    Util.hideSoftKeyb(LoginFragment.this.getActivity(), LoginFragment.this.usernameOrEmailEditText);
                }
            }
        };
        this.usernameOrEmailEditText.setOnFocusChangeListener((View.OnFocusChangeListener) localObject);
        this.passwordEditText.setOnFocusChangeListener((View.OnFocusChangeListener) localObject);
    }

    private void initNeedAfterActivityCreated(Bundle paramBundle) {
        this.mHandler = new Handler(Looper.getMainLooper()) {
            public void handleMessage(Message paramAnonymousMessage) {
            }
        };
        paramBundle = new TapatalkIdCallBack(getActivity());
        TapatalkJsonEngine localTapatalkJsonEngine = new TapatalkJsonEngine(this.activity, paramBundle);
        paramBundle.setHandleListener(new HandleCallBackResultListener() {
            public void handleOver(CallBackResult paramAnonymousCallBackResult) {
                Object localObject = Prefs.get(LoginFragment.this.activity);
                SharedPreferences.Editor localEditor = ((SharedPreferences) localObject).edit();
                if ((paramAnonymousCallBackResult.getConnectionResult()) && (paramAnonymousCallBackResult.getInvokeResult())) {
                    if ((!((SharedPreferences) localObject).getString("handle", "").equalsIgnoreCase("tapatalkId")) && (LoginFragment.this.activity.isNotification)) {
                        RegisterTidAction.registerTapatalkIdLog(LoginFragment.this.activity, "1");
                        LoginFragment.this.activity.notification_register = true;
                        localEditor.putBoolean("notification_register", LoginFragment.this.activity.notification_register);
                        localEditor.commit();
                    }
                    if (Util.checkString(LoginFragment.this.passwordEdit)) {
                        TapatalkIdFactory.getTapatalkId(LoginFragment.this.getActivity()).saveTapatalkIdData("ttidpassword", LoginFragment.this.passwordEdit);
                    }
                    if (TapatalkIdFactory.getTapatalkId(LoginFragment.this.getActivity()).isHasAccounts()) {
                        if (LoginFragment.this.activity.guestLogin) {
                            new Intent(LoginFragment.this.activity, AccountEntryActivity.class).putExtra("fromOnboarding", true);
                            ObActivitiesStackManager.getInstance().finishActivities();
                        }
                    }
                }
                for (; ; ) {
                    LoginFragment.this.mSignInUtil.closeProgress();
                    return;
                    if (LoginFragment.this.activity.innerLogin) {
                        paramAnonymousCallBackResult = new Intent();
                        LoginFragment.this.activity.setResult(1, paramAnonymousCallBackResult);
                        LoginFragment.this.activity.finish();
                    } else if (LoginFragment.this.activity.loginPage) {
                        paramAnonymousCallBackResult = new Intent(LoginFragment.this.activity, AccountEntryActivity.class);
                        LoginFragment.this.activity.setResult(1, paramAnonymousCallBackResult);
                        LoginFragment.this.activity.finish();
                    } else {
                        paramAnonymousCallBackResult = new Intent(LoginFragment.this.activity, AccountEntryActivity.class);
                        paramAnonymousCallBackResult.putExtra(AccountEntryActivity.OB_ADDACCOUNTS, true);
                        paramAnonymousCallBackResult.setFlags(32768);
                        LoginFragment.this.startActivity(paramAnonymousCallBackResult);
                        LoginFragment.this.obStack.finishActivities();
                        continue;
                        if (ObEntryActivity.tapstreamForum != null) {
                            paramAnonymousCallBackResult = new Intent(LoginFragment.this.activity, ObRecommendListActivity.class);
                            paramAnonymousCallBackResult.setFlags(32768);
                            localObject = new ArrayList();
                            ((ArrayList) localObject).add(ObEntryActivity.tapstreamForum);
                            paramAnonymousCallBackResult.putExtra("toAddForums", (Serializable) localObject);
                            LoginFragment.this.startActivity(paramAnonymousCallBackResult);
                        }
                        for (; ; ) {
                            LoginFragment.this.obStack.finishActivities();
                            break;
                            paramAnonymousCallBackResult = new Intent(LoginFragment.this.activity, ObStartActivity.class);
                            paramAnonymousCallBackResult.setFlags(32768);
                            LoginFragment.this.startActivity(paramAnonymousCallBackResult);
                        }
                        if ((!((SharedPreferences) localObject).getString("handle", "").equalsIgnoreCase("tapatalkId")) && (LoginFragment.this.activity.isNotification)) {
                            RegisterTidAction.registerTapatalkIdLog(LoginFragment.this.activity, "0");
                            LoginFragment.this.activity.notification_register = true;
                            localEditor.putBoolean("notification_register", LoginFragment.this.activity.notification_register);
                            localEditor.commit();
                        }
                        Util.showToastForLong(LoginFragment.this.getActivity(), paramAnonymousCallBackResult.getResultText());
                    }
                }
            }
        });
        this.mSignInUtil = new SignInWithOtherUtil(getActivity(), localTapatalkJsonEngine, this.mHandler);
        initListenerAfterActivityCreated();
    }

    public void getTokenResult(boolean paramBoolean, String paramString) {
        if ((paramBoolean) && (paramString != null) && (this.currentPerson != null)) {
            this.mSignInUtil.showProgress();
            this.mSignInUtil.callSignInTapatalkIDnWithGoogle(paramString, this.accountName, null, this.currentPerson.getDisplayName(), this.currentPerson.toString());
        }
    }

    public void onActivityCreated(Bundle paramBundle) {
        super.onActivityCreated(paramBundle);
        this.activity = ((ObJoinActivity) getActivity());
        GoogleAnalyticsTools.trackPageView(this.activity, "ob_login_view");
        this.obStack = ObActivitiesStackManager.getInstance();
        this.status = getGooglePlayServiceStatus();
        this.getToken = this;
        setActionBar(getActivity());
        initNeedAfterActivityCreated(paramBundle);
    }

    public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
        super.onActivityResult(paramInt1, paramInt2, paramIntent);
        if (paramInt1 == 9001) {
            getToken(this.accountName);
            return;
        }
        this.mSignInUtil.signinOnResult(paramInt1, paramInt2, paramIntent);
    }

    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
    }

    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        Util.setPortrait(getActivity());
        paramLayoutInflater = paramLayoutInflater.inflate(2130903244, null);
        this.loginButton = ((Button) paramLayoutInflater.findViewById(2131231315));
        this.usernameOrEmailEditText = ((EditText) paramLayoutInflater.findViewById(2131231190));
        this.passwordEditText = ((EditText) paramLayoutInflater.findViewById(2131231095));
        this.forgetPasswordTextButton = ((TextView) paramLayoutInflater.findViewById(2131231316));
        this.forgetPasswordTextButton.setText(Html.fromHtml("<u><font color='#3b83dc'>" + getString(2131100291) + "</font></u>"));
        return paramLayoutInflater;
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void onHiddenChanged(boolean paramBoolean) {
        super.onHiddenChanged(paramBoolean);
        setActionBar(getActivity());
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        if (16908332 == paramMenuItem.getItemId()) {
            this.activity.finish();
            return true;
        }
        return super.onOptionsItemSelected(paramMenuItem);
    }

    public void onResume() {
        super.onResume();
        setActionBar(getActivity());
        if (this.mSignInUtil != null) {
            this.mSignInUtil.closeProgress();
        }
    }

    public void onStart() {
        super.onStart();
        CustomTracker.start(getActivity());
    }

    public void onStop() {
        super.onStop();
        CustomTracker.stop(getActivity());
    }

    public void setActionBar(Activity paramActivity) {
        if (this.bar == null) {
            this.bar = getActivity().getActionBar();
        }
        this.bar.setIcon(2130837525);
        this.bar.setTitle(getString(2131100600));
        this.bar.setDisplayHomeAsUpEnabled(true);
        this.bar.show();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/newonboarding/LoginFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */