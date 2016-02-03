package com.quoord.newonboarding;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
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
import com.quoord.tools.UserBehavior;
import com.quoord.tools.tracking.GoogleAnalyticsTools;

import java.io.Serializable;
import java.util.ArrayList;

public class ObWelcomeFragment
        extends GooglePlusFragment
        implements GooglePlusFragment.GoogleGetToken, View.OnClickListener {
    private ObEntryActivity activity;
    private ArrayList<Fragment> cardFragments = new ArrayList();
    private CardPageAdapter cardPageAdapter;
    private RelativeLayout emailButton;
    private RelativeLayout facebookButton;
    private RelativeLayout googleButton;
    private TextView loginButton;
    private Handler mHandler;
    private SignInWithOtherUtil mSignInUtil;
    private ObWelcomeCardview newWelcomeCardview;
    private ObActivitiesStackManager obStack;
    private ObWelcomeCardview obWelcomeAccessCard;
    private ObWelcomeCardview obWelcomeAppiconCard;
    private ObWelcomeCardview obWelcomeDiscoverCard;
    private ObWelcomeCardview obWelcomeJoinCard;
    public ImageView obWelcomebg1;
    public ImageView obWelcomebg2;
    public ImageView obWelcomebg3;
    public ImageView obWelcomebg4;
    private ImageView point;
    private TextView skipButton;
    private int status;
    private TextView textmsg;
    private ViewPager viewPager;

    private void initNeedAfterActivityCreated(Bundle paramBundle) {
        this.mHandler = new Handler(Looper.getMainLooper()) {
            public void handleMessage(Message paramAnonymousMessage) {
            }
        };
        paramBundle = new TapatalkIdCallBack(getActivity());
        TapatalkJsonEngine localTapatalkJsonEngine = new TapatalkJsonEngine(this.activity, paramBundle);
        paramBundle.setHandleListener(new HandleCallBackResultListener() {
            public void handleOver(CallBackResult paramAnonymousCallBackResult) {
                SharedPreferences localSharedPreferences = Prefs.get(ObWelcomeFragment.this.activity);
                SharedPreferences.Editor localEditor = localSharedPreferences.edit();
                if ((paramAnonymousCallBackResult.getConnectionResult()) && (paramAnonymousCallBackResult.getInvokeResult())) {
                    if ((!localSharedPreferences.getString("handle", "").equalsIgnoreCase("tapatalkId")) && (ObWelcomeFragment.this.activity.isNotification)) {
                        RegisterTidAction.registerTapatalkIdLog(ObWelcomeFragment.this.activity, "1");
                        ObWelcomeFragment.this.activity.notification_register = true;
                        localEditor.putBoolean("notification_register", ObWelcomeFragment.this.activity.notification_register);
                        localEditor.commit();
                    }
                    if (TapatalkIdFactory.getTapatalkId(ObWelcomeFragment.this.getActivity()).isHasAccounts()) {
                        if (ObWelcomeFragment.this.activity.innerLogin) {
                            paramAnonymousCallBackResult = new Intent();
                            ObWelcomeFragment.this.activity.setResult(1, paramAnonymousCallBackResult);
                            ObWelcomeFragment.this.activity.finish();
                        }
                    }
                }
                for (; ; ) {
                    ObWelcomeFragment.this.mSignInUtil.closeProgress();
                    return;
                    if (ObWelcomeFragment.this.activity.loginPage) {
                        paramAnonymousCallBackResult = new Intent(ObWelcomeFragment.this.activity, AccountEntryActivity.class);
                        ObWelcomeFragment.this.activity.setResult(1, paramAnonymousCallBackResult);
                        ObWelcomeFragment.this.activity.finish();
                    } else {
                        paramAnonymousCallBackResult = new Intent(ObWelcomeFragment.this.activity, AccountEntryActivity.class);
                        paramAnonymousCallBackResult.putExtra(AccountEntryActivity.OB_ADDACCOUNTS, true);
                        paramAnonymousCallBackResult.setFlags(32768);
                        ObWelcomeFragment.this.startActivity(paramAnonymousCallBackResult);
                        ObWelcomeFragment.this.obStack.finishActivities();
                        continue;
                        paramAnonymousCallBackResult = new Intent(ObWelcomeFragment.this.activity, ObStartActivity.class);
                        paramAnonymousCallBackResult.setFlags(32768);
                        ObWelcomeFragment.this.startActivity(paramAnonymousCallBackResult);
                        ObWelcomeFragment.this.obStack.finishActivities();
                        continue;
                        if ((!localSharedPreferences.getString("handle", "").equalsIgnoreCase("tapatalkId")) && (ObWelcomeFragment.this.activity.isNotification)) {
                            RegisterTidAction.registerTapatalkIdLog(ObWelcomeFragment.this.activity, "0");
                            ObWelcomeFragment.this.activity.notification_register = true;
                            localEditor.putBoolean("notification_register", ObWelcomeFragment.this.activity.notification_register);
                            localEditor.commit();
                        }
                        Util.showToastForLong(ObWelcomeFragment.this.getActivity(), paramAnonymousCallBackResult.getResultText());
                    }
                }
            }
        });
        this.mSignInUtil = new SignInWithOtherUtil(this.activity, localTapatalkJsonEngine, this.mHandler);
    }

    private void startIntent(String paramString) {
        Intent localIntent = new Intent();
        localIntent.putExtra(paramString, true);
        localIntent.putExtra("loginPage", this.activity.loginPage);
        localIntent.putExtra("innerLogin", this.activity.innerLogin);
        localIntent.putExtra("isNotification", this.activity.isNotification);
        localIntent.putExtra("guestLogin", this.activity.guestLogin);
        localIntent.setClass(this.activity, ObJoinActivity.class);
        startActivityForResult(localIntent, 300);
    }

    public void getTokenResult(boolean paramBoolean, String paramString) {
        if ((paramBoolean) && (paramString != null) && (this.currentPerson != null)) {
            this.mSignInUtil.showProgress();
            this.mSignInUtil.callSignInTapatalkIDnWithGoogle(paramString, this.accountName, null, this.currentPerson.getDisplayName(), this.currentPerson.toString());
        }
    }

    public void initCardFragments() {
        this.cardFragments.clear();
        if (this.obWelcomeAppiconCard == null) {
            this.point.setBackgroundResource(2130839193);
            this.obWelcomeAppiconCard = ObWelcomeCardview.newInstance(1, this.activity);
        }
        this.cardFragments.add(this.obWelcomeAppiconCard);
        if (this.obWelcomeAccessCard == null) {
            this.obWelcomeAccessCard = ObWelcomeCardview.newInstance(2, this.activity);
        }
        this.cardFragments.add(this.obWelcomeAccessCard);
        if (this.obWelcomeDiscoverCard == null) {
            this.obWelcomeDiscoverCard = ObWelcomeCardview.newInstance(3, this.activity);
        }
        this.cardFragments.add(this.obWelcomeDiscoverCard);
        if (this.obWelcomeJoinCard == null) {
            this.obWelcomeJoinCard = ObWelcomeCardview.newInstance(4, this.activity);
        }
        this.cardFragments.add(this.obWelcomeJoinCard);
        if (this.newWelcomeCardview == null) {
            this.newWelcomeCardview = ObWelcomeCardview.newInstance(5, this.activity);
        }
        this.cardFragments.add(this.newWelcomeCardview);
    }

    public void initTextFont() {
        try {
            Typeface localTypeface = Typeface.createFromAsset(getActivity().getAssets(), "font/KlinicSlabBookIt.ttf");
            this.loginButton.setText(Html.fromHtml("<u>" + getString(2131100879) + "</u>"));
            this.loginButton.setTypeface(localTypeface);
            this.textmsg.setTypeface(localTypeface);
            localTypeface = Typeface.createFromAsset(getActivity().getAssets(), "font/KlinicSlabMediumIt.ttf");
            this.skipButton.setTypeface(localTypeface);
            return;
        } catch (Exception localException) {
        }
    }

    public void onActivityCreated(Bundle paramBundle) {
        super.onActivityCreated(paramBundle);
        this.activity = ((ObEntryActivity) getActivity());
        showHints();
        this.obStack = ObActivitiesStackManager.getInstance();
        GoogleAnalyticsTools.trackPageView(this.activity, "ob_welcome_view");
        UserBehavior.logNOBWelcome(this.activity);
        this.status = getGooglePlayServiceStatus();
        this.getToken = this;
        initTextFont();
        initNeedAfterActivityCreated(paramBundle);
        initCardFragments();
        this.cardPageAdapter = new CardPageAdapter(this, getActivity(), this.viewPager, this.point, this.cardFragments);
        if ((this.activity.innerLogin) || (this.activity.guestLogin)) {
            this.skipButton.setVisibility(8);
        }
        for (; ; ) {
            this.facebookButton.setOnClickListener(this);
            this.googleButton.setOnClickListener(this);
            this.emailButton.setOnClickListener(this);
            this.skipButton.setOnClickListener(this);
            this.loginButton.setOnClickListener(this);
            return;
            this.skipButton.setVisibility(0);
        }
    }

    public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
        super.onActivityResult(paramInt1, paramInt2, paramIntent);
        if (paramInt1 == 300) {
            if (paramInt2 == 1) {
                this.activity.finish();
            }
            return;
        }
        if (paramInt1 == 9001) {
            getToken(this.accountName);
            return;
        }
        this.mSignInUtil.signinOnResult(paramInt1, paramInt2, paramIntent);
    }

    public void onClick(View paramView) {
        final Object localObject;
        switch (paramView.getId()) {
            case 2131231342:
            case 2131231344:
            case 2131231346:
            case 2131231347:
            case 2131231348:
            default:
            case 2131231341:
            case 2131231343:
                int j;
                do {
                    return;
                    this.mSignInUtil.callFacebookVerify();
                    UserBehavior.logNOBFacebookSSO(this.activity);
                    return;
                    paramView = new AlertDialog.Builder(this.activity);
                    paramView.setTitle(getString(2131100462));
                    localObject = AccountManager.get(this.activity).getAccountsByType("com.google");
                    j = localObject.length;
                } while (j == 0);
                String[] arrayOfString = new String[j];
                int i = 0;
                for (; ; ) {
                    if (i >= j) {
                        paramView.setItems(arrayOfString, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                                if (ObWelcomeFragment.this.status != 0) {
                                    ObWelcomeFragment.this.buildPlusClient(localObject[paramAnonymousInt].name);
                                    ObWelcomeFragment.this.showErrorDialog(ObWelcomeFragment.this.status);
                                }
                                for (; ; ) {
                                    UserBehavior.logNOBGoogleSSO(ObWelcomeFragment.this.activity);
                                    return;
                                    ObWelcomeFragment.this.mSignInUtil.showProgress();
                                    ObWelcomeFragment.this.buildPlusClient(localObject[paramAnonymousInt].name);
                                }
                            }
                        });
                        paramView.create().show();
                        return;
                    }
                    arrayOfString[i] = localObject[i].name;
                    i += 1;
                }
            case 2131231345:
                startIntent("fromOBSignUp");
                return;
            case 2131231350:
                if (ObEntryActivity.tapstreamForum != null) {
                    paramView = new Intent(this.activity, ObRecommendListActivity.class);
                    localObject = new ArrayList();
                    ((ArrayList) localObject).add(ObEntryActivity.tapstreamForum);
                    paramView.putExtra("toAddForums", (Serializable) localObject);
                    startActivity(paramView);
                    return;
                }
                startActivity(new Intent(this.activity, ObStartActivity.class));
                return;
        }
        startIntent("fromOBLogin");
    }

    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        Util.setPortrait(getActivity());
        paramLayoutInflater = paramLayoutInflater.inflate(2130903252, null);
        this.obWelcomebg1 = ((ImageView) paramLayoutInflater.findViewById(2131231339));
        this.obWelcomebg2 = ((ImageView) paramLayoutInflater.findViewById(2131231338));
        this.obWelcomebg3 = ((ImageView) paramLayoutInflater.findViewById(2131231337));
        this.obWelcomebg4 = ((ImageView) paramLayoutInflater.findViewById(2131231336));
        this.viewPager = ((ViewPager) paramLayoutInflater.findViewById(2131231333));
        this.point = ((ImageView) paramLayoutInflater.findViewById(2131231276));
        this.textmsg = ((TextView) paramLayoutInflater.findViewById(2131231348));
        this.skipButton = ((TextView) paramLayoutInflater.findViewById(2131231350));
        this.facebookButton = ((RelativeLayout) paramLayoutInflater.findViewById(2131231341));
        this.googleButton = ((RelativeLayout) paramLayoutInflater.findViewById(2131231343));
        this.emailButton = ((RelativeLayout) paramLayoutInflater.findViewById(2131231345));
        this.loginButton = ((TextView) paramLayoutInflater.findViewById(2131231349));
        return paramLayoutInflater;
    }

    public void onPause() {
        super.onPause();
        if (this.cardPageAdapter != null) {
            this.cardPageAdapter.stopTimer();
        }
    }

    public void onResume() {
        super.onResume();
    }

    public void onStart() {
        super.onStart();
        CustomTracker.start(getActivity());
    }

    public void onStop() {
        super.onStop();
        CustomTracker.stop(getActivity());
    }

    public void showFragment(Fragment paramFragment) {
        FragmentTransaction localFragmentTransaction = getFragmentManager().beginTransaction();
        if (getFragmentManager().findFragmentByTag(String.valueOf(paramFragment.hashCode())) != null) {
            localFragmentTransaction.show(paramFragment);
        }
        for (; ; ) {
            localFragmentTransaction.commitAllowingStateLoss();
            return;
            localFragmentTransaction.add(2131231313, paramFragment, String.valueOf(paramFragment.hashCode()));
        }
    }

    public void showHints() {
        Object localObject = Prefs.get(getActivity());
        int i = ((SharedPreferences) localObject).getInt("show_hints_obwelcome_count", 1);
        localObject = ((SharedPreferences) localObject).edit();
        if (i == 1) {
            ((SharedPreferences.Editor) localObject).putBoolean("show_hints_isshow_hintview", true);
        }
        for (; ; ) {
            ((SharedPreferences.Editor) localObject).putInt("show_hints_obwelcome_count", i + 1);
            ((SharedPreferences.Editor) localObject).commit();
            return;
            ((SharedPreferences.Editor) localObject).putBoolean("show_hints_isshow_hintview", false);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/newonboarding/ObWelcomeFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */