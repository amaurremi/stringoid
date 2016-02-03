package com.quoord.tapatalkpro.ics.slidingMenu.login;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.quoord.tapatalkpro.action.ForumLoginOrSignAction;
import com.quoord.tapatalkpro.action.ForumLoginOrSignAction.ActionCallBack;
import com.quoord.tapatalkpro.action.ForumLoginOrSignAction.ActionFoceViewAThread;
import com.quoord.tapatalkpro.action.LogNewLogin;
import com.quoord.tapatalkpro.activity.forum.ForumActivityStatus;
import com.quoord.tapatalkpro.activity.forum.ThreadActivity;
import com.quoord.tapatalkpro.adapter.TryTwiceCallBackInterface;
import com.quoord.tapatalkpro.bean.EngineResponse;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.bean.TapatalkForum;
import com.quoord.tapatalkpro.bean.TapatalkId;
import com.quoord.tapatalkpro.commonvalue.IntentValue;
import com.quoord.tapatalkpro.ics.slidingMenu.SettingsFragment;
import com.quoord.tapatalkpro.ics.slidingMenu.SlidingMenuActivity;
import com.quoord.tapatalkpro.ics.tapatalkid.TapatalkIdFactory;
import com.quoord.tapatalkpro.ui.ics.QuoordFragment;
import com.quoord.tapatalkpro.util.AvatarTool;
import com.quoord.tapatalkpro.util.Prefs;
import com.quoord.tapatalkpro.util.TapatalkEngine;
import com.quoord.tapatalkpro.util.ThemeUtil;
import com.quoord.tapatalkpro.util.Util;
import com.quoord.tapatalkpro.view.TapaButton;
import com.quoord.tools.ImageTools;
import com.quoord.tools.bitmap.ui.GifImageView;
import com.quoord.tools.roundedimageview.RoundedImageView;

import java.util.ArrayList;
import java.util.HashMap;

public class ForumJoinFragment
        extends QuoordFragment
        implements TryTwiceCallBackInterface {
    String _loginName;
    private PrefetchAccountInfo accountInfo;
    private int au_id = 0;
    private ActionBar bar;
    Bitmap bitmap1;
    Bitmap bitmap2;
    AlertDialog editUserDialog;
    String editUsernameFromEditUsernameDialog;
    private String email = null;
    String email_info = null;
    private EditText email_register = null;
    Typeface enFont;
    TapatalkEngine engine;
    private ForumStatus forumStatus = null;
    private TextView forumTitle;
    private TextView forumUrl;
    LinearLayout imageLay;
    private View layout = null;
    private boolean login = false;
    String loginUserOrEmail;
    private TextView login_email;
    AlertDialog loginerrorDialog;
    public FragmentActivity mActivity;
    ImageView mImageMiddle;
    RoundedImageView mImageView1;
    ImageView mImageView2;
    LinearLayout mUserInfoLay;
    private RelativeLayout main;
    private boolean needForceRead = true;
    String pass_word = null;
    String password_info = null;
    private EditText password_register = null;
    private SharedPreferences prefs;
    private CheckBox showPass = null;
    private ForumLoginOrSignAction siginAction;
    private LinearLayout signinbuttonlay;
    private TapatalkId tapatalkId;
    private TapaButton tapatalkIdSignin = null;
    private RelativeLayout tapatalkSigninLay = null;
    private TextView textcontent;
    private String token = null;
    private Button useOtherEmail;
    String user_name = null;
    String username_info = null;
    private EditText username_register = null;

    public static ForumJoinFragment newInstance(ForumStatus paramForumStatus, PrefetchAccountInfo paramPrefetchAccountInfo) {
        ForumJoinFragment localForumJoinFragment = new ForumJoinFragment();
        localForumJoinFragment.forumStatus = paramForumStatus;
        localForumJoinFragment.accountInfo = paramPrefetchAccountInfo;
        return localForumJoinFragment;
    }

    public static ForumJoinFragment newInstance(ForumStatus paramForumStatus, PrefetchAccountInfo paramPrefetchAccountInfo, boolean paramBoolean) {
        ForumJoinFragment localForumJoinFragment = new ForumJoinFragment();
        localForumJoinFragment.forumStatus = paramForumStatus;
        localForumJoinFragment.accountInfo = paramPrefetchAccountInfo;
        localForumJoinFragment.needForceRead = paramBoolean;
        return localForumJoinFragment;
    }

    private void setOnclickListener() {
        this.tapatalkIdSignin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View paramAnonymousView) {
                if (ForumJoinFragment.this.accountInfo != null) {
                    if (ForumJoinFragment.this.accountInfo.hasUser) {
                        ForumJoinFragment.this.tapatalkIdSigninLis(ForumJoinFragment.this.accountInfo.userName);
                        return;
                    }
                    if ((ForumJoinFragment.this.accountInfo.customFields != null) && (ForumJoinFragment.this.accountInfo.customFields.size() > 0)) {
                        ForumJoinFragment.this.showRequiedFeild();
                        return;
                    }
                    ForumJoinFragment.this.showEditUsernameDialog(ForumJoinFragment.this.showUserNameOrEmail());
                    return;
                }
                ForumJoinFragment.this.showEditUsernameDialog(ForumJoinFragment.this.showUserNameOrEmail());
            }
        });
        this.useOtherEmail.setOnClickListener(new View.OnClickListener() {
            public void onClick(View paramAnonymousView) {
                ForumJoinFragment.this.showLoginView();
            }
        });
    }

    private void setRobotoFont(TextView paramTextView) {
        if (this.enFont == null) {
            this.enFont = Typeface.createFromAsset(this.mActivity.getAssets(), "font/Roboto_Condensed.ttf");
        }
        paramTextView.setTypeface(this.enFont);
    }

    private void showKeyboard(EditText paramEditText) {
        ((InputMethodManager) paramEditText.getContext().getSystemService("input_method")).toggleSoftInput(0, 2);
    }

    private void showResetPasswordDialogStep2() {
        AlertDialog.Builder localBuilder = new AlertDialog.Builder(this.mActivity);
        LinearLayout localLinearLayout = (LinearLayout) this.mActivity.getLayoutInflater().inflate(2130903236, null);
        TextView localTextView1 = (TextView) localLinearLayout.findViewById(2131230900);
        final EditText localEditText = (EditText) localLinearLayout.findViewById(2131230982);
        localEditText.setInputType(144);
        TextView localTextView2 = (TextView) localLinearLayout.findViewById(2131231299);
        localTextView1.setText(getString(2131100520));
        setRobotoFont(localTextView2);
        localTextView2.setText(getString(2131100527));
        localBuilder.setView(localLinearLayout);
        localBuilder.setPositiveButton(getString(2131100288), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                if (Util.checkEditText(localEditText)) {
                    paramAnonymousDialogInterface = localEditText.getText().toString().trim();
                    if ((!paramAnonymousDialogInterface.equals("")) && (paramAnonymousDialogInterface != null)) {
                        ArrayList localArrayList = new ArrayList();
                        localArrayList.add(paramAnonymousDialogInterface.getBytes());
                        localArrayList.add(ForumJoinFragment.this.token);
                        localArrayList.add(Util.getMD5(ForumJoinFragment.this.forumStatus.getForumId() + "|" + ForumJoinFragment.this.au_id + "|" + ForumJoinFragment.this.email));
                        ForumJoinFragment.this.engine.call("update_password", localArrayList);
                        ((ForumActivityStatus) ForumJoinFragment.this.getActivity()).showProgress();
                    }
                }
            }
        });
        localBuilder.create().show();
    }

    private void signForum(final String paramString1, String paramString2, boolean paramBoolean) {
        this.forumStatus.tapatalkForum.setUserName(paramString1);
        this.siginAction.signForum(paramString1, paramString2, true, true, true, paramBoolean, new ForumLoginOrSignAction.ActionCallBack()
        new ForumLoginOrSignAction.ActionFoceViewAThread
        {
            public void actionErrorBack (String paramAnonymousString1, String paramAnonymousString2)
            {
                ((ForumActivityStatus) ForumJoinFragment.this.mActivity).closeProgress();
                if (paramAnonymousString2.equals("1")) {
                    paramAnonymousString2 = paramAnonymousString1;
                    if (!Util.checkString(paramAnonymousString1)) {
                        paramAnonymousString2 = String.format(ForumJoinFragment.this.getString(2131100532), new Object[]{paramString1});
                    }
                    ForumJoinFragment.this.showSignErrorDialog(paramAnonymousString2);
                    return;
                }
                if (paramAnonymousString2.equals("2")) {
                    ForumJoinFragment.this.showLoginErrorDialog4HasStatus("2");
                    return;
                }
                if (paramAnonymousString2.equals("3")) {
                    ForumJoinFragment.this.showErrorDialog(ForumJoinFragment.this.getString(2131100697));
                    return;
                }
                Util.showToastForLong(ForumJoinFragment.this.mActivity, paramAnonymousString1);
            }

        public void actionSuccessBack (ForumStatus paramAnonymousForumStatus)
        {
            if ((ForumJoinFragment.this.mActivity instanceof SlidingMenuActivity)) {
                ((SlidingMenuActivity) ForumJoinFragment.this.mActivity).closeProgress();
                ((SlidingMenuActivity) ForumJoinFragment.this.mActivity).clearStack();
                ((SlidingMenuActivity) ForumJoinFragment.this.mActivity).showView();
                ((SlidingMenuActivity) ForumJoinFragment.this.mActivity).getUnreadNumbers();
            }
            if ((ForumJoinFragment.this.mActivity instanceof ForumLoginActivity)) {
                ((ForumLoginActivity) ForumJoinFragment.this.mActivity).closeProgress();
                ForumJoinFragment.this.mActivity.getIntent().putExtra("forumStatus", paramAnonymousForumStatus);
                ForumJoinFragment.this.mActivity.setResult(-1, ForumJoinFragment.this.mActivity.getIntent());
                ForumJoinFragment.this.mActivity.finish();
            }
        }
        },new ForumLoginOrSignAction.ActionFoceViewAThread() {
            public void actionViewThread(String paramAnonymousString) {
                if (ForumJoinFragment.this.needForceRead) {
                    Intent localIntent = new Intent(ForumJoinFragment.this.mActivity, ThreadActivity.class);
                    localIntent.putExtra("forumStatus", ForumJoinFragment.this.forumStatus);
                    localIntent.putExtra("topic_id", paramAnonymousString);
                    localIntent.putExtra(IntentValue.FORCE_VIEW_THREAD, true);
                    ForumJoinFragment.this.startActivity(localIntent);
                }
            }
        });
    }

    private void tapatalkIdSigninLis(String paramString) {
        SharedPreferences localSharedPreferences;
        if (this.forumStatus.isTapatalkSignIn(this.mActivity)) {
            this.forumStatus.clearForumCache(this.mActivity);
            localSharedPreferences = Prefs.get(getActivity());
        }
        try {
            new StringBuilder().append(this.forumStatus.tapatalkForum.getId()).append("|").append(localSharedPreferences.getInt("tapatalk_auid", 0)).append("|").append(localSharedPreferences.getString("email", "")).toString();
            signForum(paramString, null, false);
            ((ForumActivityStatus) getActivity()).showProgress();
            new LogNewLogin(getActivity(), this.forumStatus).reset();
            return;
        } catch (Exception localException) {
            for (; ; ) {
            }
        }
    }

    public void callBack(EngineResponse paramEngineResponse) {
        ((ForumActivityStatus) getActivity()).closeProgress();
        this.forumStatus.clearForumCache(this.mActivity);
        String str = paramEngineResponse.getMethod();
        if ((!"".equals(str)) && ((paramEngineResponse.getResponse() instanceof HashMap))) {
            paramEngineResponse = (HashMap) paramEngineResponse.getResponse();
            if (!str.equals("register")) {
                break label125;
            }
            if (!((Boolean) paramEngineResponse.get("result")).booleanValue()) {
                break label101;
            }
            new LogNewLogin(getActivity(), this.forumStatus).reset();
        }
        label101:
        label125:
        do {
            return;
            paramEngineResponse = (byte[]) paramEngineResponse.get("result_text");
            Util.showToastForLong(this.mActivity, paramEngineResponse);
            showCreateAccountDialog();
            return;
            if (str.equals("forget_password")) {
                if (((Boolean) paramEngineResponse.get("result")).booleanValue()) {
                    if (((Boolean) paramEngineResponse.get("verified")).booleanValue()) {
                        paramEngineResponse = (byte[]) paramEngineResponse.get("result_text");
                        if ((paramEngineResponse != null) && (paramEngineResponse.length > 0)) {
                            Util.showToastForLong(this.mActivity, paramEngineResponse);
                        }
                        for (; ; ) {
                            showResetPasswordDialogStep2();
                            return;
                            paramEngineResponse = getActivity().getString(2131100533);
                            Util.showToastForLong(this.mActivity, paramEngineResponse);
                        }
                    }
                    paramEngineResponse = (byte[]) paramEngineResponse.get("result_text");
                    if ((paramEngineResponse != null) && (paramEngineResponse.length > 0)) {
                        Util.showToastForLong(this.mActivity, paramEngineResponse);
                        return;
                    }
                    paramEngineResponse = getActivity().getString(2131100533);
                    Util.showToastForLong(this.mActivity, paramEngineResponse);
                    return;
                }
                paramEngineResponse = (byte[]) paramEngineResponse.get("result_text");
                if ((paramEngineResponse != null) && (paramEngineResponse.length > 0)) {
                    Util.showToastForLong(this.mActivity, paramEngineResponse);
                }
                for (; ; ) {
                    showResetPasswordDialog();
                    return;
                    paramEngineResponse = String.format(getActivity().getString(2131100534), new Object[]{this.forumStatus.getRegister_email()});
                    Util.showToastForLong(this.mActivity, paramEngineResponse);
                }
            }
        } while (!str.equals("update_password"));
        if (((Boolean) paramEngineResponse.get("result")).booleanValue()) {
            paramEngineResponse = (byte[]) paramEngineResponse.get("result_text");
            Util.showToastForLong(this.mActivity, paramEngineResponse);
            return;
        }
        paramEngineResponse = (byte[]) paramEngineResponse.get("result_text");
        Util.showToastForLong(this.mActivity, paramEngineResponse);
        showResetPasswordDialogStep2();
    }

    public String getNeededString(int paramInt) {
        return this.editUsernameFromEditUsernameDialog;
    }

    public boolean getSaxCall() {
        return false;
    }

    public boolean getTryTwice() {
        return false;
    }

    public void initViewByPrefetchAccount() {
        String str1;
        if ((this.accountInfo != null) && (this.accountInfo.hasUser)) {
            String str2 = this.accountInfo.avatorUrl;
            str1 = str2;
            if (!Util.checkString(str2)) {
                str1 = "https://directory.tapatalk.com/au_avatar.php?au_id=" + this.au_id;
            }
            setUserAvater(this.mImageView1, str1);
            if (!SettingsFragment.isLightTheme(getActivity())) {
                break label140;
            }
            this.mImageView2.setBackgroundResource(2131165574);
        }
        for (; ; ) {
            AvatarTool.showLogo(getActivity(), this.mImageView2, this.forumStatus.tapatalkForum.getIconUrl(), 5);
            return;
            str1 = "https://directory.tapatalk.com/au_avatar.php?au_id=" + this.au_id;
            setUserAvater(this.mImageView1, str1);
            break;
            label140:
            this.mImageView2.setBackgroundResource(2131165573);
        }
    }

    public boolean isOpCancel() {
        return false;
    }

    public void onActivityCreated(Bundle paramBundle) {
        super.onActivityCreated(paramBundle);
        if (paramBundle != null) {
            this.forumStatus = ((ForumStatus) paramBundle.getSerializable("status"));
            this.accountInfo = ((PrefetchAccountInfo) paramBundle.getSerializable("accountInfo"));
            this.needForceRead = paramBundle.getBoolean("needForceread");
        }
        this.tapatalkId = TapatalkIdFactory.getTapatalkId(getActivity());
        this.mActivity = getActivity();
        this.siginAction = new ForumLoginOrSignAction(this.mActivity, this.forumStatus);
        this.signinbuttonlay.setBackgroundDrawable(ThemeUtil.getDrawableByPicName("topic_item_bg", getActivity()));
        this.mImageView1.setImageResource(ThemeUtil.getDrawableIdByPicName("default_avatar", getActivity()));
        this.bar = this.mActivity.getActionBar();
        this.bar.setTitle(2131100510);
        this.bar.setDisplayHomeAsUpEnabled(true);
        int i = getActivity().getResources().getDimensionPixelOffset(2131427362);
        int j = getActivity().getResources().getDimensionPixelOffset(2131427365);
        int k = getActivity().getResources().getDimensionPixelOffset(2131427366);
        this.tapatalkSigninLay.setPadding(i, k, i, j);
        getActivity().getResources().getDimensionPixelOffset(2131427364);
        this.prefs = Prefs.get(this.mActivity);
        if (this.forumStatus != null) {
            if (this.prefs.contains("token")) {
                this.token = this.prefs.getString("token", null);
            }
            if (this.prefs.contains("email")) {
                this.email = this.prefs.getString("email", "");
            }
            if (this.prefs.contains("tapatalk_auid")) {
                this.au_id = this.prefs.getInt("tapatalk_auid", 0);
            }
            if (this.prefs.contains("login")) {
                if (!this.prefs.getBoolean("login", false)) {
                    break label697;
                }
                this.login = true;
            }
        }
        initViewByPrefetchAccount();
        this.tapatalkIdSignin.setTextColor(this.mActivity.getResources().getColor(2131165213));
        if ((this.accountInfo != null) && (this.accountInfo.hasUser)) {
            this.tapatalkIdSignin.setText(2131100518);
            this.textcontent.setText(2131100661);
            this.useOtherEmail.setText(2131100597);
            if (!this.email.equals("")) {
                this.login_email.setText(this.accountInfo.displayName + " (" + this.email + ")");
                label500:
                if (!SettingsFragment.isLightTheme(this.mActivity)) {
                    break label766;
                }
                Util.setBg(this.tapatalkIdSignin, this.mActivity.getResources().getDrawable(2130838824));
                Util.setBg(this.useOtherEmail, this.mActivity.getResources().getDrawable(2130838826));
            }
        }
        for (; ; ) {
            setOnclickListener();
            this.engine = new TapatalkEngine(this, this.forumStatus, this.mActivity);
            if (this.forumStatus != null) {
                this.forumTitle.setText(this.forumStatus.tapatalkForum.getName());
                Object localObject = this.forumStatus.tapatalkForum.getUrl();
                paramBundle = (Bundle) localObject;
                if (((String) localObject).contains("http://")) {
                    paramBundle = ((String) localObject).replaceAll("http://", "");
                }
                localObject = paramBundle;
                if (paramBundle.contains("https://")) {
                    localObject = paramBundle.replaceAll("https://", "");
                }
                this.forumUrl.setText((CharSequence) localObject);
            }
            if (!SettingsFragment.isLightTheme(getActivity())) {
                this.forumTitle.setTextColor(-1);
                this.textcontent.setTextColor(-1);
            }
            return;
            label697:
            this.login = false;
            break;
            this.login_email.setText(this.accountInfo.displayName);
            break label500;
            this.loginUserOrEmail = showUserNameOrEmail();
            if (this.loginUserOrEmail != null) {
                this.login_email.setText(this.tapatalkId.getTapatalkIdEmail());
            }
            this.useOtherEmail.setText(2131100659);
            break label500;
            label766:
            Util.setBg(this.tapatalkIdSignin, this.mActivity.getResources().getDrawable(2130838825));
            Util.setBg(this.useOtherEmail, this.mActivity.getResources().getDrawable(2130838827));
        }
    }

    public void onConfigurationChanged(Configuration paramConfiguration) {
        super.onConfigurationChanged(paramConfiguration);
        this.main.setPadding((int) getResources().getDimension(2131427375), 0, (int) getResources().getDimension(2131427375), 0);
    }

    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        this.layout = paramLayoutInflater.inflate(2130903381, paramViewGroup, false);
        this.main = ((RelativeLayout) this.layout.findViewById(2131231416));
        this.tapatalkSigninLay = ((RelativeLayout) this.layout.findViewById(2131231621));
        this.imageLay = ((LinearLayout) this.layout.findViewById(2131231622));
        this.mImageView1 = ((RoundedImageView) this.layout.findViewById(2131231372));
        this.mImageView2 = ((ImageView) this.layout.findViewById(2131231623));
        this.mImageMiddle = ((ImageView) this.layout.findViewById(2131231624));
        this.useOtherEmail = ((Button) this.layout.findViewById(2131231627));
        this.forumTitle = ((TextView) this.layout.findViewById(2131231092));
        this.forumUrl = ((TextView) this.layout.findViewById(2131231352));
        this.textcontent = ((TextView) this.layout.findViewById(2131231355));
        this.login_email = ((TextView) this.layout.findViewById(2131231625));
        this.tapatalkIdSignin = ((TapaButton) this.layout.findViewById(2131231626));
        this.signinbuttonlay = ((LinearLayout) this.layout.findViewById(2131231354));
        return this.layout;
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void onHiddenChanged(boolean paramBoolean) {
        super.onHiddenChanged(paramBoolean);
        if (!paramBoolean) {
            this.bar.setTitle(2131100510);
        }
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        switch (paramMenuItem.getItemId()) {
        }
        for (; ; ) {
            return super.onOptionsItemSelected(paramMenuItem);
            this.mActivity.finish();
        }
    }

    public void onSaveInstanceState(Bundle paramBundle) {
        super.onSaveInstanceState(paramBundle);
        paramBundle.putSerializable("status", this.forumStatus);
        paramBundle.putSerializable("accountInfo", this.accountInfo);
        paramBundle.putSerializable("needForceRead", Boolean.valueOf(this.needForceRead));
    }

    public void openRegisterPage() {
        String str;
        if (this.forumStatus.getUrl().endsWith("/")) {
            str = this.forumStatus.getUrl() + this.forumStatus.getRegUrl();
        }
        for (; ; ) {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
            return;
            if ((this.forumStatus.isKN1()) || (this.forumStatus.isKN2())) {
                str = this.forumStatus.getUrl() + "/" + "index.php?option=com_users&view=registration";
            } else {
                str = this.forumStatus.getUrl() + "/" + this.forumStatus.getRegUrl();
            }
        }
    }

    public void setOpCancel(boolean paramBoolean) {
    }

    public void setSaxCall(boolean paramBoolean) {
    }

    public void setTryTwice(boolean paramBoolean) {
    }

    public void setUserAvater(RoundedImageView paramRoundedImageView, String paramString) {
        if ((paramString != null) && (!"".equals(paramString))) {
            ImageTools.glideLoad(paramString, this.mImageView1, ThemeUtil.getDrawableIdByPicName("default_avatar", getActivity()));
            return;
        }
        this.mImageView1.setImageResource(ThemeUtil.getDrawableIdByPicName("default_avatar", getActivity()));
    }

    public void showCreateAccountDialog() {
        AlertDialog.Builder localBuilder = new AlertDialog.Builder(this.mActivity);
        LinearLayout localLinearLayout = (LinearLayout) this.mActivity.getLayoutInflater().inflate(2130903125, null);
        ((TextView) localLinearLayout.findViewById(2131230900)).setText(getString(2131100530));
        this.username_register = ((EditText) localLinearLayout.findViewById(2131230982));
        this.password_register = ((EditText) localLinearLayout.findViewById(2131230983));
        this.email_register = ((EditText) localLinearLayout.findViewById(2131230984));
        if (this.prefs == null) {
            this.prefs = Prefs.get(this.mActivity);
        }
        String str = this.prefs.getString("register_email", "");
        if (Util.checkString(this.pass_word)) {
            this.password_register.setText(this.pass_word);
        }
        if (Util.checkString(this.email_info)) {
            this.email_register.setText(this.email_info);
            if (this.username_info == null) {
                break label312;
            }
            this.username_register.setText(this.username_info);
        }
        for (; ; ) {
            this.showPass = ((CheckBox) localLinearLayout.findViewById(2131230985));
            this.showPass.setText(getString(2131100531));
            this.showPass.setChecked(false);
            this.showPass.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean) {
                    int i = ForumJoinFragment.this.password_register.getHeight();
                    if (paramAnonymousBoolean) {
                        ForumJoinFragment.this.password_register.setInputType(144);
                        ForumJoinFragment.this.password_register.setHeight(i);
                        return;
                    }
                    ForumJoinFragment.this.password_register.setInputType(129);
                    ForumJoinFragment.this.password_register.setHeight(i);
                }
            });
            localBuilder.setView(localLinearLayout);
            localBuilder.setPositiveButton(getString(2131100514), new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                    ((InputMethodManager) ForumJoinFragment.this.mActivity.getSystemService("input_method")).hideSoftInputFromWindow(ForumJoinFragment.this.username_register.getWindowToken(), 0);
                    ForumJoinFragment.this.username_info = ForumJoinFragment.this.username_register.getText().toString().trim();
                    ForumJoinFragment.this.password_info = ForumJoinFragment.this.password_register.getText().toString().trim();
                    ForumJoinFragment.this.email_info = ForumJoinFragment.this.email_register.getText().toString().trim();
                    if ((Util.checkString(ForumJoinFragment.this.username_info)) && (Util.checkString(ForumJoinFragment.this.password_info)) && (Util.checkString(ForumJoinFragment.this.email_info))) {
                        if (ForumJoinFragment.this.password_info.length() > 3) {
                            if ((Util.checkEmailFormat(ForumJoinFragment.this.email_info)) && (Util.checkUsernameFormat(ForumJoinFragment.this.username_info))) {
                                paramAnonymousDialogInterface = new ArrayList();
                                ((ForumActivityStatus) ForumJoinFragment.this.getActivity()).showProgress();
                                if ((ForumJoinFragment.this.login) && (ForumJoinFragment.this.email_info.equals(ForumJoinFragment.this.email))) {
                                    paramAnonymousDialogInterface.add(ForumJoinFragment.this.username_info.getBytes());
                                    paramAnonymousDialogInterface.add(ForumJoinFragment.this.password_info.getBytes());
                                    paramAnonymousDialogInterface.add(ForumJoinFragment.this.email_info.getBytes());
                                    paramAnonymousDialogInterface.add(ForumJoinFragment.this.token);
                                    paramAnonymousDialogInterface.add(Util.getMD5(ForumJoinFragment.this.forumStatus.getForumId() + "|" + ForumJoinFragment.this.au_id + "|" + ForumJoinFragment.this.email));
                                }
                                for (; ; ) {
                                    ForumJoinFragment.this.engine.call("register", paramAnonymousDialogInterface);
                                    return;
                                    paramAnonymousDialogInterface.add(ForumJoinFragment.this.username_info.getBytes());
                                    paramAnonymousDialogInterface.add(ForumJoinFragment.this.password_info.getBytes());
                                    paramAnonymousDialogInterface.add(ForumJoinFragment.this.email_info.getBytes());
                                }
                            }
                            Toast.makeText(ForumJoinFragment.this.mActivity, ForumJoinFragment.this.getResources().getString(2131100312), 1).show();
                            ForumJoinFragment.this.showCreateAccountDialog();
                            return;
                        }
                        Toast.makeText(ForumJoinFragment.this.mActivity, ForumJoinFragment.this.getResources().getString(2131100315), 1).show();
                        ForumJoinFragment.this.showCreateAccountDialog();
                        return;
                    }
                    Toast.makeText(ForumJoinFragment.this.mActivity, ForumJoinFragment.this.getResources().getString(2131100304), 1).show();
                    ForumJoinFragment.this.showCreateAccountDialog();
                }
            });
            localBuilder.setNegativeButton(this.mActivity.getString(2131100515), new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                }
            });
            localBuilder.create().show();
            return;
            if (!Util.checkString(str)) {
                break;
            }
            this.email_register.setText(str);
            break;
            label312:
            if (Util.checkString(this.user_name)) {
                if (Util.checkEmailFormat(this.user_name)) {
                    this.email_register.setText(this.user_name);
                } else {
                    this.username_register.setText(this.user_name);
                }
            }
        }
    }

    public void showEditUsernameDialog(String paramString) {
        if ((this.editUserDialog == null) || (!this.editUserDialog.isShowing())) {
            AlertDialog.Builder localBuilder = new AlertDialog.Builder(this.mActivity);
            LinearLayout localLinearLayout = (LinearLayout) this.mActivity.getLayoutInflater().inflate(2130903234, null);
            TextView localTextView1 = (TextView) localLinearLayout.findViewById(2131230900);
            GifImageView localGifImageView = (GifImageView) localLinearLayout.findViewById(2131230794);
            final EditText localEditText = (EditText) localLinearLayout.findViewById(2131230982);
            TextView localTextView2 = (TextView) localLinearLayout.findViewById(2131231299);
            localTextView1.setText(this.mActivity.getString(2131100528));
            localEditText.setText(paramString);
            setRobotoFont(localTextView2);
            localTextView2.setText(this.mActivity.getString(2131100529));
            paramString = "https://directory.tapatalk.com/au_avatar.php?au_id=" + this.au_id;
            AvatarTool.showAvatar(this.mActivity, null, localGifImageView, paramString, 0);
            localBuilder.setView(localLinearLayout);
            localBuilder.setPositiveButton(this.mActivity.getString(2131100288), new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                    if (Util.checkEditText(localEditText)) {
                        ForumJoinFragment.this.editUsernameFromEditUsernameDialog = localEditText.getText().toString().trim();
                        if ((Util.checkString(ForumJoinFragment.this.editUsernameFromEditUsernameDialog)) && (Util.checkUsernameFormat(ForumJoinFragment.this.editUsernameFromEditUsernameDialog))) {
                            ForumJoinFragment.this.forumStatus.tapatalkForum.setUserName(ForumJoinFragment.this.editUsernameFromEditUsernameDialog);
                            ForumJoinFragment.this.signForum(localEditText.getText().toString().trim(), ForumJoinFragment.this.email, true);
                            ((ForumActivityStatus) ForumJoinFragment.this.mActivity).showProgress();
                            Util.hideSoftKeyb(ForumJoinFragment.this.mActivity, localEditText);
                        }
                    } else {
                        return;
                    }
                    ForumJoinFragment.this.editUserDialog.cancel();
                    ForumJoinFragment.this.showEditUsernameDialog(ForumJoinFragment.this.editUsernameFromEditUsernameDialog);
                    Util.showToastForLong(ForumJoinFragment.this.mActivity, ForumJoinFragment.this.mActivity.getString(2131100307));
                }
            });
            localBuilder.setNegativeButton(this.mActivity.getString(2131100289), new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                }
            });
            this.editUserDialog = localBuilder.create();
            this.editUserDialog.show();
        }
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

    public void showLoginErrorDialog(String paramString) {
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
                    ForumJoinFragment.this.showResetPasswordDialog();
                }
            });
            localBuilder.setNegativeButton(this.mActivity.getString(2131100289), new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                }
            });
            this.loginerrorDialog = localBuilder.create();
        }
        if (!this.loginerrorDialog.isShowing()) {
            this.loginerrorDialog.show();
        }
    }

    public void showLoginErrorDialog4HasStatus(String paramString) {
        paramString = new AlertDialog.Builder(this.mActivity);
        LinearLayout localLinearLayout = (LinearLayout) this.mActivity.getLayoutInflater().inflate(2130903233, null);
        TextView localTextView1 = (TextView) localLinearLayout.findViewById(2131230900);
        TextView localTextView2 = (TextView) localLinearLayout.findViewById(2131231298);
        localTextView1.setText(this.mActivity.getResources().getString(2131100536));
        localTextView2.setText(this.mActivity.getResources().getString(2131100537));
        paramString.setView(localLinearLayout);
        paramString.setPositiveButton(this.mActivity.getString(2131100288), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                if (ForumJoinFragment.this.forumStatus.isRegister()) {
                    ForumJoinFragment.this.showCreateAccountDialog();
                    return;
                }
                ForumJoinFragment.this.openRegisterPage();
            }
        });
        paramString.setNegativeButton(this.mActivity.getString(2131100289), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
            }
        });
        paramString.create().show();
    }

    public void showLoginNoAccountDialog() {
        AlertDialog.Builder localBuilder = new AlertDialog.Builder(this.mActivity);
        localBuilder.setMessage(getString(2131100524));
        localBuilder.setPositiveButton(getString(2131100288), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
            }
        });
        localBuilder.setNegativeButton(getString(2131100289), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
            }
        });
        localBuilder.create().show();
    }

    public void showLoginView() {
        if ((this.mActivity instanceof SlidingMenuActivity)) {
            SlidingMenuActivity localSlidingMenuActivity1 = (SlidingMenuActivity) this.mActivity;
            ForumLoginFragment localForumLoginFragment = ForumLoginFragment.newInstance("", this.forumStatus);
            SlidingMenuActivity localSlidingMenuActivity2 = (SlidingMenuActivity) this.mActivity;
            localSlidingMenuActivity1.addFragmentToStack(localForumLoginFragment, "login_fragment_stack_tag", false);
        }
        if ((this.mActivity instanceof ForumLoginActivity)) {
            ((ForumLoginActivity) this.mActivity).showFragmentAndAddToStack(ForumLoginFragment.newInstance("", this.forumStatus));
        }
    }

    public void showRequiedFeild() {
        ForumRequiedFieldFragment localForumRequiedFieldFragment = ForumRequiedFieldFragment.newInstance(this.accountInfo.customFields, this.forumStatus);
        if ((this.mActivity instanceof SlidingMenuActivity)) {
            SlidingMenuActivity localSlidingMenuActivity1 = (SlidingMenuActivity) this.mActivity;
            SlidingMenuActivity localSlidingMenuActivity2 = (SlidingMenuActivity) this.mActivity;
            localSlidingMenuActivity1.addFragmentToStack(localForumRequiedFieldFragment, "login_fragment_stack_tag", false);
        }
        if ((this.mActivity instanceof ForumLoginActivity)) {
            ((ForumLoginActivity) this.mActivity).showFragmentAndAddToStack(localForumRequiedFieldFragment);
        }
    }

    public void showResetPasswordDialog() {
        AlertDialog.Builder localBuilder = new AlertDialog.Builder(this.mActivity);
        LinearLayout localLinearLayout = (LinearLayout) this.mActivity.getLayoutInflater().inflate(2130903235, null);
        TextView localTextView1 = (TextView) localLinearLayout.findViewById(2131230900);
        final EditText localEditText = (EditText) localLinearLayout.findViewById(2131230982);
        localEditText.setText(this.editUsernameFromEditUsernameDialog);
        TextView localTextView2 = (TextView) localLinearLayout.findViewById(2131231299);
        localTextView1.setText(getString(2131100520));
        setRobotoFont(localTextView2);
        localTextView2.setText(getString(2131100523));
        localBuilder.setView(localLinearLayout);
        localBuilder.setPositiveButton(getString(2131100288), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                if (Util.checkEditText(localEditText)) {
                    paramAnonymousDialogInterface = localEditText.getText().toString().trim();
                    Util.hideSoftKeyb(ForumJoinFragment.this.mActivity, localEditText);
                    if ((!paramAnonymousDialogInterface.equals("")) && (paramAnonymousDialogInterface != null)) {
                        ArrayList localArrayList = new ArrayList();
                        localArrayList.add(paramAnonymousDialogInterface.getBytes());
                        localArrayList.add(ForumJoinFragment.this.token);
                        localArrayList.add(Util.getMD5(ForumJoinFragment.this.forumStatus.getForumId() + "|" + ForumJoinFragment.this.au_id + "|" + ForumJoinFragment.this.email));
                        ForumJoinFragment.this.engine.call("forget_password", localArrayList);
                        ((ForumActivityStatus) ForumJoinFragment.this.getActivity()).showProgress();
                        return;
                    }
                    ForumJoinFragment.this.showResetPasswordDialog();
                    return;
                }
                ForumJoinFragment.this.showResetPasswordDialog();
            }
        });
        localBuilder.setNegativeButton(getResources().getString(2131100522), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
            }
        });
        localBuilder.create().show();
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
                    ForumJoinFragment.this.showResetPasswordDialog();
                }
            });
            localBuilder.setNegativeButton(this.mActivity.getString(2131100289), new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                    ForumJoinFragment.this.showEditUsernameDialog(ForumJoinFragment.this.showUserNameOrEmail());
                }
            });
            this.loginerrorDialog = localBuilder.create();
        }
        if (!this.loginerrorDialog.isShowing()) {
            this.loginerrorDialog.show();
        }
    }

    public String showUserNameOrEmail() {
        String str = null;
        SharedPreferences localSharedPreferences = Prefs.get(this.mActivity);
        if (localSharedPreferences.getString("username", null) != null) {
            str = localSharedPreferences.getString("username", null);
        }
        while (localSharedPreferences.getString("email", null) == null) {
            return str;
        }
        return localSharedPreferences.getString("email", null);
    }

    public void tryFailed(String paramString) {
    }

    public void updateSubclassDialog(int paramInt) {
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/ics/slidingMenu/login/ForumJoinFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */