package com.quoord.tapatalkpro.ics.slidingMenu.login;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.ActionBar;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.plus.model.people.Person;
import com.quoord.tapatalkpro.action.ForumLoginOrSignAction;
import com.quoord.tapatalkpro.action.ForumLoginOrSignAction.ActionCallBack;
import com.quoord.tapatalkpro.action.ForumLoginOrSignAction.ActionFoceViewAThread;
import com.quoord.tapatalkpro.activity.forum.ForumActivityStatus;
import com.quoord.tapatalkpro.activity.forum.ThreadActivity;
import com.quoord.tapatalkpro.adapter.CallBackResult;
import com.quoord.tapatalkpro.adapter.forum.TapatalkIdCallBack;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.bean.SimpleTapatalkForumAccount;
import com.quoord.tapatalkpro.bean.TapatalkForum;
import com.quoord.tapatalkpro.bean.TapatalkId;
import com.quoord.tapatalkpro.commonvalue.IntentValue;
import com.quoord.tapatalkpro.ics.slidingMenu.SettingsFragment;
import com.quoord.tapatalkpro.ics.slidingMenu.SlidingMenuActivity;
import com.quoord.tapatalkpro.ics.slidingMenu.login.action.PrefetchAccoutAction;
import com.quoord.tapatalkpro.ics.slidingMenu.login.action.PrefetchAccoutAction.ActionCallBack;
import com.quoord.tapatalkpro.ics.tapatalkid.GooglePlusFragment;
import com.quoord.tapatalkpro.ics.tapatalkid.GooglePlusFragment.GoogleGetToken;
import com.quoord.tapatalkpro.ics.tapatalkid.SignInWithOtherUtil;
import com.quoord.tapatalkpro.ics.tapatalkid.TapatalkIdFactory;
import com.quoord.tapatalkpro.net.HandleCallBackResultListener;
import com.quoord.tapatalkpro.util.AvatarTool;
import com.quoord.tapatalkpro.util.Prefs;
import com.quoord.tapatalkpro.util.TapatalkJsonEngine;
import com.quoord.tapatalkpro.util.TextFontUtil;
import com.quoord.tapatalkpro.util.ThemeUtil;
import com.quoord.tapatalkpro.util.Util;
import com.quoord.tools.ImageTools;
import com.quoord.tools.bitmap.ui.GifImageView;

import java.util.ArrayList;

public class TapatalkFacebookSigninFragment
        extends GooglePlusFragment
        implements GooglePlusFragment.GoogleGetToken {
    private ActionBar bar;
    private TextView contentText;
    private AlertDialog editUserDialog;
    private TextView facebookSigninButton;
    private LinearLayout facebooksigninbuttonlay;
    private TextView forumTitle;
    private TextView forumUrl;
    private TextView googleSignButton;
    private ImageView imageForum;
    private View invisible;
    private AlertDialog loginerrorDialog;
    private SimpleTapatalkForumAccount mAccount;
    private FragmentActivity mActivity;
    private ForumStatus mForumStatus;
    private boolean needForceRead = true;
    private View rootLay;
    private ForumLoginOrSignAction signAction;
    private SignInWithOtherUtil signinUtil;
    private int status;
    private TapatalkId tapatalkid;
    private Button useAnother;

    private void callForumSignin(final String paramString, boolean paramBoolean) {
        this.signinUtil.closeProgress();
        checkTapatalkId();
        this.mForumStatus.tapatalkForum.setUserName(paramString);
        this.signAction = new ForumLoginOrSignAction(this.mActivity, this.mForumStatus);
        this.signAction.signForum(paramString, this.tapatalkid.getTapatalkIdEmail(), true, true, true, paramBoolean, new ForumLoginOrSignAction.ActionCallBack()
        new ForumLoginOrSignAction.ActionFoceViewAThread
        {
            public void actionErrorBack (String paramAnonymousString1, String paramAnonymousString2)
            {
                ((ForumActivityStatus) TapatalkFacebookSigninFragment.this.mActivity).closeProgress();
                if (paramAnonymousString2.equals("1")) {
                    paramAnonymousString2 = paramAnonymousString1;
                    if (!Util.checkString(paramAnonymousString1)) {
                        paramAnonymousString2 = String.format(TapatalkFacebookSigninFragment.this.getString(2131100532), new Object[]{paramString});
                    }
                    TapatalkFacebookSigninFragment.this.showSignErrorDialog(paramAnonymousString2);
                }
                while (paramAnonymousString2.equals("2")) {
                    return;
                }
                if (paramAnonymousString2.equals("3")) {
                    TapatalkFacebookSigninFragment.this.showErrorDialog(TapatalkFacebookSigninFragment.this.getString(2131100697));
                    return;
                }
                Util.showToastForLong(TapatalkFacebookSigninFragment.this.mActivity, paramAnonymousString1);
            }

        public void actionSuccessBack (ForumStatus paramAnonymousForumStatus)
        {
            if ((TapatalkFacebookSigninFragment.this.mActivity instanceof SlidingMenuActivity)) {
                ((SlidingMenuActivity) TapatalkFacebookSigninFragment.this.mActivity).closeProgress();
                ((SlidingMenuActivity) TapatalkFacebookSigninFragment.this.mActivity).clearStack();
                ((SlidingMenuActivity) TapatalkFacebookSigninFragment.this.mActivity).showView();
                ((SlidingMenuActivity) TapatalkFacebookSigninFragment.this.mActivity).getUnreadNumbers();
            }
            if ((TapatalkFacebookSigninFragment.this.mActivity instanceof ForumLoginActivity)) {
                ((ForumLoginActivity) TapatalkFacebookSigninFragment.this.mActivity).closeProgress();
                TapatalkFacebookSigninFragment.this.mActivity.getIntent().putExtra("forumStatus", paramAnonymousForumStatus);
                TapatalkFacebookSigninFragment.this.mActivity.setResult(-1, TapatalkFacebookSigninFragment.this.mActivity.getIntent());
                TapatalkFacebookSigninFragment.this.mActivity.finish();
            }
        }
        },new ForumLoginOrSignAction.ActionFoceViewAThread() {
            public void actionViewThread(String paramAnonymousString) {
                ((ForumActivityStatus) TapatalkFacebookSigninFragment.this.mActivity).closeProgress();
                Intent localIntent = new Intent(TapatalkFacebookSigninFragment.this.mActivity, ThreadActivity.class);
                localIntent.putExtra("forumStatus", TapatalkFacebookSigninFragment.this.mForumStatus);
                localIntent.putExtra("topic_id", paramAnonymousString);
                localIntent.putExtra(IntentValue.FORCE_VIEW_THREAD, true);
                TapatalkFacebookSigninFragment.this.startActivity(localIntent);
            }
        });
    }

    private void checkTapatalkId() {
        if (this.tapatalkid == null) {
            this.tapatalkid = TapatalkIdFactory.getTapatalkId(getActivity());
        }
    }

    private void initLoad() {
        if (SettingsFragment.isLightTheme(this.mActivity)) {
            this.imageForum.setBackgroundResource(2131165574);
        }
        for (; ; ) {
            if (this.mForumStatus != null) {
                this.forumTitle.setText(this.mForumStatus.tapatalkForum.getName());
                Object localObject2 = this.mForumStatus.tapatalkForum.getUrl();
                Object localObject1 = localObject2;
                if (((String) localObject2).contains("http://")) {
                    localObject1 = ((String) localObject2).replaceAll("http://", "");
                }
                localObject2 = localObject1;
                if (((String) localObject1).contains("https://")) {
                    localObject2 = ((String) localObject1).replaceAll("https://", "");
                }
                this.forumUrl.setText((CharSequence) localObject2);
                ImageTools.glideLoad(this.mForumStatus.tapatalkForum.getIconUrl(), this.imageForum);
            }
            this.facebooksigninbuttonlay.setBackgroundDrawable(ThemeUtil.getDrawableByPicName("topic_item_bg", getActivity()));
            if (!SettingsFragment.isLightTheme(getActivity())) {
                this.forumTitle.setTextColor(-1);
                this.contentText.setTextColor(-1);
            }
            return;
            this.imageForum.setBackgroundResource(2131165573);
        }
    }

    private void initTapatalkIdSignin() {
        TapatalkIdCallBack localTapatalkIdCallBack = new TapatalkIdCallBack(getActivity());
        TapatalkJsonEngine localTapatalkJsonEngine = new TapatalkJsonEngine(getActivity(), localTapatalkIdCallBack);
        this.signinUtil = new SignInWithOtherUtil(getActivity(), localTapatalkJsonEngine, new Handler(Looper.getMainLooper()));
        localTapatalkIdCallBack.setHandleListener(new HandleCallBackResultListener() {
            public void handleOver(CallBackResult paramAnonymousCallBackResult) {
                if ((paramAnonymousCallBackResult.getConnectionResult()) && (paramAnonymousCallBackResult.getInvokeResult())) {
                    TapatalkFacebookSigninFragment.this.signinUtil.closeProgress();
                    TapatalkFacebookSigninFragment.this.callPrefechAccount(TapatalkFacebookSigninFragment.this.mForumStatus);
                    return;
                }
                TapatalkFacebookSigninFragment.this.signinUtil.closeProgress();
                Util.showToastForLong(TapatalkFacebookSigninFragment.this.getActivity(), paramAnonymousCallBackResult.getResultText());
            }
        });
    }

    public static TapatalkFacebookSigninFragment newInstance(ForumStatus paramForumStatus) {
        TapatalkFacebookSigninFragment localTapatalkFacebookSigninFragment = new TapatalkFacebookSigninFragment();
        localTapatalkFacebookSigninFragment.mForumStatus = paramForumStatus;
        return localTapatalkFacebookSigninFragment;
    }

    public static TapatalkFacebookSigninFragment newInstance(ForumStatus paramForumStatus, boolean paramBoolean) {
        TapatalkFacebookSigninFragment localTapatalkFacebookSigninFragment = new TapatalkFacebookSigninFragment();
        localTapatalkFacebookSigninFragment.mForumStatus = paramForumStatus;
        localTapatalkFacebookSigninFragment.needForceRead = paramBoolean;
        return localTapatalkFacebookSigninFragment;
    }

    private void setListener() {
        this.facebookSigninButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View paramAnonymousView) {
                if (TapatalkFacebookSigninFragment.this.signinUtil == null) {
                    TapatalkFacebookSigninFragment.this.initTapatalkIdSignin();
                }
                TapatalkFacebookSigninFragment.this.signinUtil.callFacebookVerify(TapatalkFacebookSigninFragment.this);
            }
        });
        this.useAnother.setOnClickListener(new View.OnClickListener() {
            public void onClick(View paramAnonymousView) {
                TapatalkFacebookSigninFragment.this.showLoginView();
            }
        });
        this.googleSignButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View paramAnonymousView) {
                paramAnonymousView = new AlertDialog.Builder(TapatalkFacebookSigninFragment.this.mActivity);
                paramAnonymousView.setTitle(TapatalkFacebookSigninFragment.this.getString(2131100462));
                final Account[] arrayOfAccount = AccountManager.get(TapatalkFacebookSigninFragment.this.mActivity).getAccountsByType("com.google");
                int j = arrayOfAccount.length;
                String[] arrayOfString;
                int i;
                if (j != 0) {
                    arrayOfString = new String[j];
                    i = 0;
                }
                for (; ; ) {
                    if (i >= j) {
                        paramAnonymousView.setItems(arrayOfString, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {
                                if (TapatalkFacebookSigninFragment.this.status != 0) {
                                    TapatalkFacebookSigninFragment.this.buildPlusClient(arrayOfAccount[paramAnonymous2Int].name);
                                    TapatalkFacebookSigninFragment.this.showErrorDialog(TapatalkFacebookSigninFragment.this.status);
                                    return;
                                }
                                TapatalkFacebookSigninFragment.this.signinUtil.showProgress();
                                TapatalkFacebookSigninFragment.this.buildPlusClient(arrayOfAccount[paramAnonymous2Int].name);
                            }
                        });
                        paramAnonymousView.create().show();
                        return;
                    }
                    arrayOfString[i] = arrayOfAccount[i].name;
                    i += 1;
                }
            }
        });
    }

    public void callPrefechAccount(final ForumStatus paramForumStatus) {
        if ((paramForumStatus.isSsoLogin()) || (paramForumStatus.isSsoSign())) {
            Object localObject = Prefs.get(getActivity());
            boolean bool = ((SharedPreferences) localObject).getBoolean("login", false);
            localObject = ((SharedPreferences) localObject).getString("email", "");
            if ((bool) && (Util.checkString((String) localObject))) {
                new PrefetchAccoutAction(paramForumStatus, getActivity()).prefetch((String) localObject, new PrefetchAccoutAction.ActionCallBack() {
                    public void actionCallBack(PrefetchAccountInfo paramAnonymousPrefetchAccountInfo) {
                        if (paramAnonymousPrefetchAccountInfo != null) {
                            if (paramAnonymousPrefetchAccountInfo.hasUser) {
                                TapatalkFacebookSigninFragment.this.callForumSignin(paramAnonymousPrefetchAccountInfo.userName, false);
                            }
                            do {
                                return;
                                if ((paramAnonymousPrefetchAccountInfo.customFields == null) || (paramAnonymousPrefetchAccountInfo.customFields.size() <= 0)) {
                                    break;
                                }
                                paramAnonymousPrefetchAccountInfo = ForumRequiedFieldFragment.newInstance(paramAnonymousPrefetchAccountInfo.customFields, paramForumStatus);
                                if ((TapatalkFacebookSigninFragment.this.mActivity instanceof SlidingMenuActivity)) {
                                    SlidingMenuActivity localSlidingMenuActivity1 = (SlidingMenuActivity) TapatalkFacebookSigninFragment.this.mActivity;
                                    SlidingMenuActivity localSlidingMenuActivity2 = (SlidingMenuActivity) TapatalkFacebookSigninFragment.this.mActivity;
                                    localSlidingMenuActivity1.addFragmentToStack(paramAnonymousPrefetchAccountInfo, "login_fragment_stack_tag", false);
                                }
                            } while (!(TapatalkFacebookSigninFragment.this.mActivity instanceof ForumLoginActivity));
                            ((ForumActivityStatus) TapatalkFacebookSigninFragment.this.mActivity).closeProgress();
                            ((ForumLoginActivity) TapatalkFacebookSigninFragment.this.mActivity).showFragmentAndAddToStack(paramAnonymousPrefetchAccountInfo);
                            return;
                            TapatalkFacebookSigninFragment.this.showEditUsernameDialog();
                            return;
                        }
                        TapatalkFacebookSigninFragment.this.showEditUsernameDialog();
                    }
                });
            }
        }
    }

    public void getTokenResult(boolean paramBoolean, String paramString) {
        if ((paramBoolean) && (paramString != null) && (this.currentPerson != null)) {
            this.signinUtil.showProgress();
            this.signinUtil.callSignInTapatalkIDnWithGoogle(paramString, this.accountName, null, this.currentPerson.getDisplayName(), this.currentPerson.toString());
        }
    }

    public void onActivityCreated(Bundle paramBundle) {
        super.onActivityCreated(paramBundle);
        if (paramBundle != null) {
            this.mForumStatus = ((ForumStatus) paramBundle.getSerializable("status"));
            this.needForceRead = paramBundle.getBoolean("needForceread");
        }
        this.mActivity = getActivity();
        this.bar = this.mActivity.getActionBar();
        this.bar.setTitle(2131100509);
        this.bar.setDisplayHomeAsUpEnabled(true);
        this.status = getGooglePlayServiceStatus();
        this.getToken = this;
        initLoad();
        initTapatalkIdSignin();
        setListener();
        if (Util.getDeviceSize(getActivity()) > 4.0D) {
            this.invisible.setVisibility(0);
        }
    }

    public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
        super.onActivityResult(paramInt1, paramInt2, paramIntent);
        if (paramInt1 == 100) {
            this.signinUtil.signinOnResult(paramInt1, paramInt2, paramIntent);
        }
        if (paramInt1 == 9001) {
            getToken(this.accountName);
        }
    }

    public void onConfigurationChanged(Configuration paramConfiguration) {
        super.onConfigurationChanged(paramConfiguration);
        this.rootLay.setPadding((int) getResources().getDimension(2131427375), 0, (int) getResources().getDimension(2131427375), 0);
    }

    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        paramLayoutInflater = paramLayoutInflater.inflate(2130903254, null);
        this.rootLay = paramLayoutInflater.findViewById(2131231107);
        this.facebooksigninbuttonlay = ((LinearLayout) paramLayoutInflater.findViewById(2131231354));
        this.forumUrl = ((TextView) paramLayoutInflater.findViewById(2131231352));
        this.forumTitle = ((TextView) paramLayoutInflater.findViewById(2131231092));
        this.imageForum = ((ImageView) paramLayoutInflater.findViewById(2131231076));
        this.facebookSigninButton = ((TextView) paramLayoutInflater.findViewById(2131231356));
        this.googleSignButton = ((TextView) paramLayoutInflater.findViewById(2131231357));
        this.useAnother = ((Button) paramLayoutInflater.findViewById(2131231359));
        this.contentText = ((TextView) paramLayoutInflater.findViewById(2131231355));
        this.invisible = paramLayoutInflater.findViewById(2131231358);
        return paramLayoutInflater;
    }

    public void onSaveInstanceState(Bundle paramBundle) {
        super.onSaveInstanceState(paramBundle);
        paramBundle.putSerializable("status", this.mForumStatus);
        paramBundle.putSerializable("needForceRead", Boolean.valueOf(this.needForceRead));
    }

    public void onViewCreated(View paramView, Bundle paramBundle) {
        super.onViewCreated(paramView, paramBundle);
    }

    public void showEditUsernameDialog() {
        if ((this.editUserDialog != null) && (this.editUserDialog.isShowing())) {
            this.editUserDialog.cancel();
        }
        AlertDialog.Builder localBuilder = new AlertDialog.Builder(getActivity());
        LinearLayout localLinearLayout = (LinearLayout) getActivity().getLayoutInflater().inflate(2130903234, null);
        Object localObject = (TextView) localLinearLayout.findViewById(2131230900);
        GifImageView localGifImageView = (GifImageView) localLinearLayout.findViewById(2131230794);
        final EditText localEditText = (EditText) localLinearLayout.findViewById(2131230982);
        TextView localTextView = (TextView) localLinearLayout.findViewById(2131231299);
        ((TextView) localObject).setText(getActivity().getString(2131100528));
        TextFontUtil.setRobotoFont(localTextView, getActivity());
        localTextView.setText(getActivity().getString(2131100529));
        checkTapatalkId();
        localObject = "https://directory.tapatalk.com/au_avatar.php?au_id=" + this.tapatalkid.getAuid();
        AvatarTool.showAvatar(getActivity(), null, localGifImageView, (String) localObject, 0);
        localBuilder.setView(localLinearLayout);
        localBuilder.setPositiveButton(getActivity().getString(2131100288), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                if (Util.checkEditText(localEditText)) {
                    paramAnonymousDialogInterface = localEditText.getText().toString().trim();
                    if ((Util.checkString(paramAnonymousDialogInterface)) && (Util.checkUsernameFormat(paramAnonymousDialogInterface))) {
                        if (TapatalkFacebookSigninFragment.this.mAccount == null) {
                            TapatalkFacebookSigninFragment.this.mAccount = new SimpleTapatalkForumAccount();
                        }
                        TapatalkFacebookSigninFragment.this.mAccount.setTapatalkUserName(paramAnonymousDialogInterface);
                        TapatalkFacebookSigninFragment.this.callForumSignin(paramAnonymousDialogInterface, true);
                        Util.hideSoftKeyb(TapatalkFacebookSigninFragment.this.getActivity(), localEditText);
                    }
                } else {
                    return;
                }
                TapatalkFacebookSigninFragment.this.editUserDialog.cancel();
                TapatalkFacebookSigninFragment.this.showEditUsernameDialog();
                Util.showToastForLong(TapatalkFacebookSigninFragment.this.getActivity(), TapatalkFacebookSigninFragment.this.getActivity().getString(2131100307));
            }
        });
        localBuilder.setNegativeButton(getActivity().getString(2131100289), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
            }
        });
        this.editUserDialog = localBuilder.create();
        this.editUserDialog.show();
    }

    public void showErrorDialog(String paramString) {
        if (this.loginerrorDialog == null) {
            AlertDialog.Builder localBuilder = new AlertDialog.Builder(this.mActivity);
            LinearLayout localLinearLayout = (LinearLayout) this.mActivity.getLayoutInflater().inflate(2130903233, null);
            TextView localTextView1 = (TextView) localLinearLayout.findViewById(2131230900);
            TextView localTextView2 = (TextView) localLinearLayout.findViewById(2131231298);
            localTextView1.setText(this.mActivity.getString(2131100538));
            localTextView2.setText(paramString);
            localBuilder.setView(localLinearLayout);
            localBuilder.setNegativeButton(this.mActivity.getString(2131100288), new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                }
            });
            this.loginerrorDialog = localBuilder.create();
        }
        if (!this.loginerrorDialog.isShowing()) {
            this.loginerrorDialog.show();
        }
    }

    public void showLoginView() {
        if ((this.mActivity instanceof SlidingMenuActivity)) {
            SlidingMenuActivity localSlidingMenuActivity1 = (SlidingMenuActivity) this.mActivity;
            ForumLoginFragment localForumLoginFragment = ForumLoginFragment.newInstance("", this.mForumStatus);
            SlidingMenuActivity localSlidingMenuActivity2 = (SlidingMenuActivity) this.mActivity;
            localSlidingMenuActivity1.addFragmentToStack(localForumLoginFragment, "login_fragment_stack_tag", false);
        }
        if ((this.mActivity instanceof ForumLoginActivity)) {
            ((ForumLoginActivity) this.mActivity).showFragmentAndAddToStack(ForumLoginFragment.newInstance("", this.mForumStatus));
        }
    }

    public void showSignErrorDialog(String paramString) {
        if (this.loginerrorDialog == null) {
            AlertDialog.Builder localBuilder = new AlertDialog.Builder(this.mActivity);
            LinearLayout localLinearLayout = (LinearLayout) this.mActivity.getLayoutInflater().inflate(2130903233, null);
            TextView localTextView1 = (TextView) localLinearLayout.findViewById(2131230900);
            TextView localTextView2 = (TextView) localLinearLayout.findViewById(2131231298);
            localTextView1.setText(this.mActivity.getString(2131100538));
            localTextView2.setText(paramString);
            localBuilder.setView(localLinearLayout);
            localBuilder.setPositiveButton(this.mActivity.getString(2131100539), new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                }
            });
            localBuilder.setNegativeButton(this.mActivity.getString(2131100289), new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                    TapatalkFacebookSigninFragment.this.showEditUsernameDialog();
                }
            });
            this.loginerrorDialog = localBuilder.create();
        }
        if (!this.loginerrorDialog.isShowing()) {
            this.loginerrorDialog.show();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/ics/slidingMenu/login/TapatalkFacebookSigninFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */