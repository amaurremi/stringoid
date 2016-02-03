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
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import com.google.android.gms.plus.model.people.Person;
import com.quoord.tapatalkpro.action.RegisterTidAction;
import com.quoord.tapatalkpro.activity.directory.ics.AccountEntryActivity;
import com.quoord.tapatalkpro.adapter.CallBackInterface;
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

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.TimeZone;

public class SignUpFragment
        extends GooglePlusFragment
        implements ActionBarController, GooglePlusFragment.GoogleGetToken {
    private ObJoinActivity activity;
    private ActionBar bar;
    private EditText emailEditText;
    private Handler mHandler;
    private SignInWithOtherUtil mSignInUtil;
    private ObActivitiesStackManager obStack;
    private EditText passwordEditText;
    private Button signupButton;
    private int status;
    private EditText usernameEditText;

    private void initViewListenerAfterAcitivtyCreated() {
        this.mHandler = new Handler(Looper.getMainLooper()) {
            public void handleMessage(Message paramAnonymousMessage) {
            }
        };
        Object localObject = new TapatalkIdCallBack(getActivity());
        final TapatalkJsonEngine localTapatalkJsonEngine = new TapatalkJsonEngine(this.activity, (CallBackInterface) localObject);
        ((TapatalkIdCallBack) localObject).setHandleListener(new HandleCallBackResultListener() {
            public void handleOver(CallBackResult paramAnonymousCallBackResult) {
                SharedPreferences.Editor localEditor = Prefs.get(SignUpFragment.this.activity).edit();
                if ((paramAnonymousCallBackResult.getConnectionResult()) && (paramAnonymousCallBackResult.getInvokeResult())) {
                    if (SignUpFragment.this.activity.isNotification) {
                        RegisterTidAction.registerTapatalkIdLog(SignUpFragment.this.activity, "1");
                        SignUpFragment.this.activity.notification_register = true;
                    }
                    if (TapatalkIdFactory.getTapatalkId(SignUpFragment.this.getActivity()).isHasAccounts()) {
                        if (SignUpFragment.this.activity.guestLogin) {
                            new Intent(SignUpFragment.this.activity, AccountEntryActivity.class).putExtra("fromOnboarding", true);
                            ObActivitiesStackManager.getInstance().finishActivities();
                        }
                    }
                }
                for (; ; ) {
                    localEditor.putBoolean("notification_register", SignUpFragment.this.activity.notification_register);
                    localEditor.commit();
                    SignUpFragment.this.mSignInUtil.closeProgress();
                    return;
                    if (SignUpFragment.this.activity.innerLogin) {
                        paramAnonymousCallBackResult = new Intent();
                        SignUpFragment.this.activity.setResult(1, paramAnonymousCallBackResult);
                        SignUpFragment.this.activity.finish();
                    } else if (SignUpFragment.this.activity.loginPage) {
                        paramAnonymousCallBackResult = new Intent(SignUpFragment.this.activity, AccountEntryActivity.class);
                        SignUpFragment.this.activity.setResult(1, paramAnonymousCallBackResult);
                        SignUpFragment.this.activity.finish();
                    } else {
                        paramAnonymousCallBackResult = new Intent(SignUpFragment.this.activity, AccountEntryActivity.class);
                        paramAnonymousCallBackResult.putExtra(AccountEntryActivity.OB_ADDACCOUNTS, true);
                        paramAnonymousCallBackResult.setFlags(32768);
                        SignUpFragment.this.startActivity(paramAnonymousCallBackResult);
                        SignUpFragment.this.obStack.finishActivities();
                        continue;
                        if (ObEntryActivity.tapstreamForum != null) {
                            paramAnonymousCallBackResult = new Intent(SignUpFragment.this.activity, ObRecommendListActivity.class);
                            paramAnonymousCallBackResult.setFlags(32768);
                            ArrayList localArrayList = new ArrayList();
                            localArrayList.add(ObEntryActivity.tapstreamForum);
                            paramAnonymousCallBackResult.putExtra("toAddForums", localArrayList);
                            SignUpFragment.this.startActivity(paramAnonymousCallBackResult);
                        } else {
                            paramAnonymousCallBackResult = new Intent(SignUpFragment.this.activity, ObStartActivity.class);
                            paramAnonymousCallBackResult.setFlags(32768);
                            SignUpFragment.this.startActivity(paramAnonymousCallBackResult);
                            SignUpFragment.this.obStack.finishActivities();
                            continue;
                            if (SignUpFragment.this.activity.isNotification) {
                                RegisterTidAction.registerTapatalkIdLog(SignUpFragment.this.activity, "0");
                                SignUpFragment.this.activity.notification_register = true;
                            }
                            Util.showToastForLong(SignUpFragment.this.getActivity(), paramAnonymousCallBackResult.getResultText());
                        }
                    }
                }
            }
        });
        this.mSignInUtil = new SignInWithOtherUtil(getActivity(), localTapatalkJsonEngine, this.mHandler);
        localObject = new View.OnClickListener() {
            public void onClick(View paramAnonymousView) {
                if (paramAnonymousView.getId() == SignUpFragment.this.signupButton.getId()) {
                    paramAnonymousView = SignUpFragment.this.usernameEditText.getText().toString().trim();
                    String str1 = SignUpFragment.this.emailEditText.getText().toString().trim();
                    String str2 = SignUpFragment.this.passwordEditText.getText().toString().trim();
                    if (("".equals(str1)) || ("".equals(str2)) || ("".equals(paramAnonymousView))) {
                        break label322;
                    }
                    if (str2.length() <= 3) {
                        break label299;
                    }
                    if (!Util.checkEmailFormat(str1)) {
                        break label276;
                    }
                    if ((paramAnonymousView.length() < 3) || (paramAnonymousView.length() > 32) || (!Util.checkUsernameFormat(paramAnonymousView))) {
                        break label253;
                    }
                    paramAnonymousView = TapatalkJsonEngine.SIGNUP + "?email=" + URLEncoder.encode(str1) + "&username=" + URLEncoder.encode(paramAnonymousView) + "&password=" + Util.getMD5(str2) + "&timezone=" + TimeZone.getDefault().getRawOffset() / 1000;
                    localTapatalkJsonEngine.call(paramAnonymousView);
                    SignUpFragment.this.mSignInUtil.showProgress();
                    if (SignUpFragment.this.activity.fromOBSignUp) {
                        UserBehavior.logNOBEmailSingUp(SignUpFragment.this.activity);
                    }
                }
                return;
                label253:
                Util.showToastForLong(SignUpFragment.this.getActivity(), SignUpFragment.this.getResources().getString(2131100307));
                return;
                label276:
                Util.showToastForLong(SignUpFragment.this.getActivity(), SignUpFragment.this.getResources().getString(2131100302));
                return;
                label299:
                Util.showToastForLong(SignUpFragment.this.getActivity(), SignUpFragment.this.getResources().getString(2131100315));
                return;
                label322:
                Util.showToastForLong(SignUpFragment.this.getActivity(), SignUpFragment.this.getResources().getString(2131100718));
            }
        };
        this.signupButton.setOnClickListener((View.OnClickListener) localObject);
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
        GoogleAnalyticsTools.trackPageView(this.activity, "ob_signup_view");
        this.obStack = ObActivitiesStackManager.getInstance();
        setActionBar(getActivity());
        this.status = getGooglePlayServiceStatus();
        this.getToken = this;
        initViewListenerAfterAcitivtyCreated();
    }

    public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    }

    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
    }

    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        Util.setPortrait(getActivity());
        paramLayoutInflater = paramLayoutInflater.inflate(2130903247, null);
        this.signupButton = ((Button) paramLayoutInflater.findViewById(2131231303));
        this.usernameEditText = ((EditText) paramLayoutInflater.findViewById(2131231190));
        this.emailEditText = ((EditText) paramLayoutInflater.findViewById(2131231093));
        this.passwordEditText = ((EditText) paramLayoutInflater.findViewById(2131231095));
        return paramLayoutInflater;
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
        this.bar.setTitle(getString(2131100599));
        this.bar.setDisplayHomeAsUpEnabled(true);
        this.bar.show();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/newonboarding/SignUpFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */