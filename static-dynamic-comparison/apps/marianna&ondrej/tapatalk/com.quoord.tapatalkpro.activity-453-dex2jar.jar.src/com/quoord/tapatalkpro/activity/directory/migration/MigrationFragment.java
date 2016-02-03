package com.quoord.tapatalkpro.activity.directory.migration;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
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
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.google.android.gms.plus.model.people.Person;
import com.quoord.tapatalkpro.adapter.CallBackInterface;
import com.quoord.tapatalkpro.adapter.CallBackResult;
import com.quoord.tapatalkpro.adapter.forum.TapatalkIdCallBack;
import com.quoord.tapatalkpro.bean.TapatalkId;
import com.quoord.tapatalkpro.ics.tapatalkid.GooglePlusFragment;
import com.quoord.tapatalkpro.ics.tapatalkid.GooglePlusFragment.GoogleGetToken;
import com.quoord.tapatalkpro.ics.tapatalkid.SignInWithOtherUtil;
import com.quoord.tapatalkpro.ics.tapatalkid.TapatalkIdFactory;
import com.quoord.tapatalkpro.net.HandleCallBackResultListener;
import com.quoord.tapatalkpro.util.Prefs;
import com.quoord.tapatalkpro.util.TapatalkJsonEngine;
import com.quoord.tapatalkpro.util.Util;
import com.quoord.tools.ActionBarController;

import java.net.URLEncoder;
import java.util.TimeZone;

public class MigrationFragment
        extends GooglePlusFragment
        implements ActionBarController, GooglePlusFragment.GoogleGetToken {
    private Activity activity;
    private ActionBar bar;
    private EditText emailEditText;
    private RelativeLayout facebookSignupButton;
    private RelativeLayout googlebookSignupButton;
    private String loginType = SignInWithOtherUtil.tapatalkIdString;
    private Handler mHandler;
    private SignInWithOtherUtil mSignInUtil;
    private EditText passwordEditText;
    private Button signupButton;
    private int status;
    private TapatalkId tapatalkId;
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
                MigrationFragment.this.mSignInUtil.closeProgress();
                if (paramAnonymousCallBackResult.getInvokeResult()) {
                    Prefs.get(MigrationFragment.this.activity).edit().putInt("tapatalk_status_twitter_user", 0).commit();
                    paramAnonymousCallBackResult = new Intent();
                    paramAnonymousCallBackResult.putExtra("migration_type", MigrationFragment.this.loginType);
                    MigrationFragment.this.activity.setResult(1001, paramAnonymousCallBackResult);
                    MigrationFragment.this.activity.finish();
                    return;
                }
                Toast.makeText(MigrationFragment.this.activity, paramAnonymousCallBackResult.getResultText(), 1).show();
            }
        });
        this.mSignInUtil = new SignInWithOtherUtil(getActivity(), localTapatalkJsonEngine, this.mHandler);
        localObject = new View.OnClickListener() {
            public void onClick(View paramAnonymousView) {
                int i = paramAnonymousView.getId();
                if (i == MigrationFragment.this.facebookSignupButton.getId()) {
                    MigrationFragment.this.loginType = SignInWithOtherUtil.facebookString;
                    MigrationFragment.this.mSignInUtil.callFacebookVerify(MigrationFragment.this);
                }
                if (i == MigrationFragment.this.googlebookSignupButton.getId()) {
                    paramAnonymousView = new AlertDialog.Builder(MigrationFragment.this.activity);
                    paramAnonymousView.setTitle(MigrationFragment.this.getString(2131100462));
                    localObject1 = AccountManager.get(MigrationFragment.this.activity).getAccountsByType("com.google");
                    j = localObject1.length;
                    if (j != 0) {
                        localObject2 = new String[j];
                        i = 0;
                        if (i < j) {
                            break label149;
                        }
                        paramAnonymousView.setItems((CharSequence[]) localObject2, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {
                                MigrationFragment.this.loginType = SignInWithOtherUtil.googleString;
                                if (MigrationFragment.this.status != 0) {
                                    MigrationFragment.this.buildPlusClient(localObject1[paramAnonymous2Int].name);
                                    MigrationFragment.this.showErrorDialog(MigrationFragment.this.status);
                                    return;
                                }
                                MigrationFragment.this.mSignInUtil.showProgress();
                                MigrationFragment.this.buildPlusClient(localObject1[paramAnonymous2Int].name);
                            }
                        });
                        paramAnonymousView.create().show();
                    }
                }
                label149:
                while (i != MigrationFragment.this.signupButton.getId()) {
                    for (; ; ) {
                        int j;
                        return;
                        localObject2[i] = localObject1[i].name;
                        i += 1;
                    }
                }
                paramAnonymousView = MigrationFragment.this.usernameEditText.getText().toString().trim();
                final Object localObject1 = MigrationFragment.this.emailEditText.getText().toString().trim();
                Object localObject2 = MigrationFragment.this.passwordEditText.getText().toString().trim();
                if ((!"".equals(localObject1)) && (!"".equals(localObject2)) && (!"".equals(paramAnonymousView))) {
                    if (((String) localObject2).length() > 3) {
                        if (Util.checkEmailFormat((String) localObject1)) {
                            if ((paramAnonymousView.length() >= 3) && (paramAnonymousView.length() <= 32) && (Util.checkUsernameFormat(paramAnonymousView))) {
                                MigrationFragment.this.loginType = SignInWithOtherUtil.tapatalkIdString;
                                paramAnonymousView = new StringBuilder(String.valueOf(TapatalkJsonEngine.MIGRATE_TWITTER_WITH_EMAIL)).append("?email=").append(URLEncoder.encode((String) localObject1)).append("&username=").append(URLEncoder.encode(paramAnonymousView)).append("&password=").append(Util.getMD5((String) localObject2)).append("&timezone=").append(TimeZone.getDefault().getRawOffset() / 1000).toString() + "&from_twitter=1&au_id=" + MigrationFragment.this.tapatalkId.getAuid() + "&token=" + MigrationFragment.this.tapatalkId.getToken();
                                localTapatalkJsonEngine.call(paramAnonymousView);
                                MigrationFragment.this.mSignInUtil.showProgress();
                                return;
                            }
                            Util.showToastForLong(MigrationFragment.this.getActivity(), MigrationFragment.this.getResources().getString(2131100307));
                            return;
                        }
                        Util.showToastForLong(MigrationFragment.this.getActivity(), MigrationFragment.this.getResources().getString(2131100302));
                        return;
                    }
                    Util.showToastForLong(MigrationFragment.this.getActivity(), MigrationFragment.this.getResources().getString(2131100315));
                    return;
                }
                Util.showToastForLong(MigrationFragment.this.getActivity(), MigrationFragment.this.getResources().getString(2131100718));
            }
        };
        this.facebookSignupButton.setOnClickListener((View.OnClickListener) localObject);
        this.googlebookSignupButton.setOnClickListener((View.OnClickListener) localObject);
        this.signupButton.setOnClickListener((View.OnClickListener) localObject);
    }

    public void getTokenResult(boolean paramBoolean, String paramString) {
        if ((paramBoolean) && (paramString != null) && (this.currentPerson != null)) {
            this.mSignInUtil.showProgress();
            this.mSignInUtil.callSignInTapatalkIDnWithGoogleForTwitterMigration(paramString, this.accountName, null, this.currentPerson.getDisplayName(), this.currentPerson.toString());
        }
    }

    public void onActivityCreated(Bundle paramBundle) {
        super.onActivityCreated(paramBundle);
        this.activity = getActivity();
        setActionBar(getActivity());
        this.status = getGooglePlayServiceStatus();
        this.getToken = this;
        if (Util.hasGoogleAccount(getActivity())) {
            this.googlebookSignupButton.setVisibility(0);
        }
        for (; ; ) {
            this.tapatalkId = TapatalkIdFactory.getTapatalkId(this.activity);
            this.usernameEditText.setText(this.tapatalkId.getUsername());
            this.emailEditText.setText(this.tapatalkId.getTapatalkIdEmail());
            initViewListenerAfterAcitivtyCreated();
            return;
            this.googlebookSignupButton.setVisibility(8);
        }
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
        getActivity().setRequestedOrientation(-1);
        paramLayoutInflater = paramLayoutInflater.inflate(2130903239, null);
        this.facebookSignupButton = ((RelativeLayout) paramLayoutInflater.findViewById(2131231304));
        this.googlebookSignupButton = ((RelativeLayout) paramLayoutInflater.findViewById(2131231307));
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
        return super.onOptionsItemSelected(paramMenuItem);
    }

    public void onResume() {
        super.onResume();
        setActionBar(getActivity());
        if (this.mSignInUtil != null) {
            this.mSignInUtil.closeProgress();
        }
    }

    public void setActionBar(Activity paramActivity) {
        if (this.bar == null) {
            this.bar = getActivity().getActionBar();
        }
        this.bar.setTitle(getString(2131100392));
        this.bar.setDisplayHomeAsUpEnabled(true);
        this.bar.show();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/activity/directory/migration/MigrationFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */