package com.quoord.tapatalkpro.ics.slidingMenu.login;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
import com.quoord.tapatalkpro.commonvalue.IntentValue;
import com.quoord.tapatalkpro.ics.slidingMenu.SettingsFragment;
import com.quoord.tapatalkpro.ics.slidingMenu.SlidingMenuActivity;
import com.quoord.tapatalkpro.ui.ics.QuoordFragment;
import com.quoord.tapatalkpro.util.Prefs;
import com.quoord.tapatalkpro.util.TapatalkEngine;
import com.quoord.tapatalkpro.util.Util;
import com.quoord.tapatalkpro.view.TapaButton;
import com.quoord.tools.ImageTools;

import java.util.ArrayList;
import java.util.HashMap;

public class ForumLoginFragment
        extends QuoordFragment
        implements TryTwiceCallBackInterface {
    public static final int MENU_JOIN = 1;
    private int au_id = 0;
    private ActionBar bar;
    private String email = null;
    private TapatalkEngine engine;
    private TextView forgotPassword = null;
    private ImageView forumIcon;
    private TextView forumName;
    private ForumStatus forumStatus = null;
    private View layout = null;
    private boolean login = false;
    private ForumLoginOrSignAction loginAction;
    private TextView logingTips = null;
    private FragmentActivity mActivity = null;
    private LinearLayout main;
    private boolean needForceRead = true;
    String pass_word;
    private EditText password = null;
    private SharedPreferences prefs;
    private ProgressDialog progress = null;
    private TapaButton signIn = null;
    private String token = null;
    private String user = null;
    String user_name;
    private EditText username = null;

    public static ForumLoginFragment newInstance(String paramString, ForumStatus paramForumStatus) {
        ForumLoginFragment localForumLoginFragment = new ForumLoginFragment();
        localForumLoginFragment.user = paramString;
        localForumLoginFragment.forumStatus = paramForumStatus;
        return localForumLoginFragment;
    }

    public static ForumLoginFragment newInstance(String paramString, ForumStatus paramForumStatus, boolean paramBoolean) {
        ForumLoginFragment localForumLoginFragment = new ForumLoginFragment();
        localForumLoginFragment.user = paramString;
        localForumLoginFragment.forumStatus = paramForumStatus;
        localForumLoginFragment.needForceRead = paramBoolean;
        return localForumLoginFragment;
    }

    private void setOnclickListener() {
        this.signIn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View paramAnonymousView) {
                ForumLoginFragment.this.user_name = ForumLoginFragment.this.username.getText().toString().trim();
                ForumLoginFragment.this.pass_word = ForumLoginFragment.this.password.getText().toString().trim();
                if ((!"".equals(ForumLoginFragment.this.user_name)) && (!"".equals(ForumLoginFragment.this.pass_word)) && (ForumLoginFragment.this.forumStatus != null) && (ForumLoginFragment.this.forumStatus.tapatalkForum != null)) {
                    ForumLoginFragment.this.forumStatus.tapatalkForum.setUserName(ForumLoginFragment.this.user_name);
                    ForumLoginFragment.this.forumStatus.tapatalkForum.setUnEncodePassword(ForumLoginFragment.this.pass_word);
                    if ((ForumLoginFragment.this.forumStatus.tapatalkForum.getUserName().length() <= 0) || (!ForumLoginFragment.this.forumStatus.tapatalkForum.hasPassword())) {
                        Toast.makeText(ForumLoginFragment.this.getActivity(), ForumLoginFragment.this.getString(2131099814), 1).show();
                    }
                    for (; ; ) {
                        new LogNewLogin(ForumLoginFragment.this.getActivity(), ForumLoginFragment.this.forumStatus).reset();
                        ((InputMethodManager) ForumLoginFragment.this.getActivity().getSystemService("input_method")).hideSoftInputFromWindow(ForumLoginFragment.this.signIn.getWindowToken(), 0);
                        return;
                        ForumLoginFragment.this.forumStatus.clearForumCache(ForumLoginFragment.this.mActivity);
                        ForumLoginFragment.this.forumStatus.tapatalkForum.setUserName(ForumLoginFragment.this.user_name);
                        ForumLoginFragment.this.loginAction.loginForum(ForumLoginFragment.this.user_name, ForumLoginFragment.this.pass_word, true, true, false, true, new ForumLoginOrSignAction.ActionCallBack()
                        new ForumLoginOrSignAction.ActionFoceViewAThread
                        {
                            public void actionErrorBack (String paramAnonymous2String1, String paramAnonymous2String2)
                            {
                                ((ForumActivityStatus) ForumLoginFragment.this.mActivity).closeProgress();
                                if ((paramAnonymous2String1 != null) && (!paramAnonymous2String1.equals(""))) {
                                    Toast.makeText(ForumLoginFragment.this.mActivity, paramAnonymous2String1, 1).show();
                                }
                            }

                        public void actionSuccessBack (ForumStatus paramAnonymous2ForumStatus)
                        {
                            if ((ForumLoginFragment.this.mActivity instanceof SlidingMenuActivity)) {
                                ((SlidingMenuActivity) ForumLoginFragment.this.mActivity).closeProgress();
                                ((SlidingMenuActivity) ForumLoginFragment.this.mActivity).clearStack();
                                ((SlidingMenuActivity) ForumLoginFragment.this.mActivity).showView();
                                ((SlidingMenuActivity) ForumLoginFragment.this.mActivity).getUnreadNumbers();
                            }
                            if ((ForumLoginFragment.this.mActivity instanceof ForumLoginActivity)) {
                                ((ForumLoginActivity) ForumLoginFragment.this.mActivity).closeProgress();
                                ForumLoginFragment.this.mActivity.getIntent().putExtra("forumStatus", ForumLoginFragment.this.forumStatus);
                                ForumLoginFragment.this.mActivity.setResult(-1, ForumLoginFragment.this.mActivity.getIntent());
                                ForumLoginFragment.this.mActivity.finish();
                            }
                        }
                        },new ForumLoginOrSignAction.ActionFoceViewAThread() {
                            public void actionViewThread(String paramAnonymous2String) {
                                Intent localIntent = new Intent(ForumLoginFragment.this.mActivity, ThreadActivity.class);
                                localIntent.putExtra("forumStatus", ForumLoginFragment.this.forumStatus);
                                localIntent.putExtra("topic_id", paramAnonymous2String);
                                localIntent.putExtra(IntentValue.FORCE_VIEW_THREAD, true);
                                ForumLoginFragment.this.startActivity(localIntent);
                            }
                        });
                        ((ForumActivityStatus) ForumLoginFragment.this.mActivity).showProgress();
                    }
                }
                Toast.makeText(ForumLoginFragment.this.mActivity, ForumLoginFragment.this.mActivity.getResources().getString(2131100394), 1).show();
            }
        });
        this.forgotPassword.setOnClickListener(new View.OnClickListener() {
            public void onClick(View paramAnonymousView) {
                ForumLoginFragment.this.showForgetPassView();
            }
        });
    }

    public void callBack(EngineResponse paramEngineResponse) {
        ((ForumActivityStatus) getActivity()).closeProgress();
        String str = paramEngineResponse.getMethod();
        if ((!"".equals(str)) && ((paramEngineResponse.getResponse() instanceof HashMap))) {
            paramEngineResponse = (HashMap) paramEngineResponse.getResponse();
            if (str.equals("forget_password")) {
                if (!((Boolean) paramEngineResponse.get("result")).booleanValue()) {
                    break label115;
                }
                paramEngineResponse = (byte[]) paramEngineResponse.get("result_text");
                if ((paramEngineResponse == null) || (paramEngineResponse.length <= 0)) {
                    break label96;
                }
                Util.showToastForLong(this.mActivity, paramEngineResponse);
            }
        }
        return;
        label96:
        paramEngineResponse = getActivity().getString(2131100533);
        Util.showToastForLong(this.mActivity, paramEngineResponse);
        return;
        label115:
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

    public boolean getSaxCall() {
        return false;
    }

    public boolean getTryTwice() {
        return false;
    }

    public void initForumIconandName() {
        if (this.forumStatus != null) {
            this.forumName.setText(this.forumStatus.tapatalkForum.getName());
            if (SettingsFragment.isLightTheme(getActivity())) {
                ImageTools.glideLoad(this.forumStatus.tapatalkForum.getIconUrl(), this.forumIcon, 2131165574);
            }
        } else {
            return;
        }
        this.forumName.setTextColor(-1);
        ImageTools.glideLoad(this.forumStatus.tapatalkForum.getIconUrl(), this.forumIcon, 2131165573);
    }

    public boolean isOpCancel() {
        return false;
    }

    public void onActivityCreated(Bundle paramBundle) {
        super.onActivityCreated(paramBundle);
        this.mActivity = getActivity();
        if (paramBundle != null) {
            this.forumStatus = ((ForumStatus) paramBundle.getSerializable("forumStatus"));
            this.user = paramBundle.getString("user");
            this.needForceRead = paramBundle.getBoolean("needForceRead");
        }
        initForumIconandName();
        this.bar = this.mActivity.getActionBar();
        this.bar.setDisplayHomeAsUpEnabled(true);
        this.bar.setTitle(2131100936);
        this.prefs = Prefs.get(this.mActivity);
        if (this.forumStatus != null) {
            if (this.prefs.contains("token")) {
                this.token = this.prefs.getString("token", null);
            }
            if (this.prefs.contains("tapatalk_auid")) {
                this.au_id = this.prefs.getInt("tapatalk_auid", 0);
            }
            if (this.prefs.contains("username")) {
                this.email = this.prefs.getString("username", null);
            }
            if (this.prefs.contains("login")) {
                if (this.prefs.getBoolean("login", false)) {
                    this.login = true;
                }
            } else {
                this.progress = new ProgressDialog(this.mActivity);
                this.progress.setMessage(this.mActivity.getResources().getString(2131100313));
            }
        } else {
            if ((this.user != null) && (!this.user.equals(""))) {
                this.username.setText(this.user);
            }
            if (!this.mActivity.getResources().getBoolean(2131558401)) {
                break label509;
            }
            this.logingTips.setVisibility(8);
            label326:
            if (this.forumStatus != null) {
                this.engine = new TapatalkEngine(this, this.forumStatus, this.mActivity);
                this.loginAction = new ForumLoginOrSignAction(this.mActivity, this.forumStatus);
                paramBundle = this.forumStatus.tapatalkForum.getUrl().split("/");
                if ((!paramBundle[0].startsWith("http")) || (paramBundle.length < 3)) {
                    break label520;
                }
                this.logingTips.setText(getString(2131100535) + " " + paramBundle[2]);
            }
            label446:
            if (!SettingsFragment.isLightTheme(this.mActivity)) {
                break label580;
            }
            this.signIn.setTextColor(this.mActivity.getResources().getColor(2131165213));
            Util.setBg(this.signIn, this.mActivity.getResources().getDrawable(2130838824));
        }
        for (; ; ) {
            setOnclickListener();
            return;
            this.login = false;
            break;
            label509:
            this.logingTips.setVisibility(0);
            break label326;
            label520:
            if ((paramBundle[0].startsWith("http")) || (paramBundle.length < 1)) {
                break label446;
            }
            this.logingTips.setText(getString(2131100535) + " " + paramBundle[0]);
            break label446;
            label580:
            Util.setBg(this.signIn, this.mActivity.getResources().getDrawable(2130838825));
        }
    }

    public void onConfigurationChanged(Configuration paramConfiguration) {
        super.onConfigurationChanged(paramConfiguration);
    }

    public void onCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater) {
        super.onCreateOptionsMenu(paramMenu, paramMenuInflater);
        paramMenu.removeGroup(0);
        paramMenu.add(0, 1, 0, getActivity().getString(2131100510)).setShowAsAction(1);
    }

    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        this.layout = paramLayoutInflater.inflate(2130903383, paramViewGroup, false);
        this.signIn = ((TapaButton) this.layout.findViewById(2131231631));
        this.username = ((EditText) this.layout.findViewById(2131231093));
        this.password = ((EditText) this.layout.findViewById(2131231095));
        this.logingTips = ((TextView) this.layout.findViewById(2131231098));
        this.forgotPassword = ((TextView) this.layout.findViewById(2131231632));
        this.forgotPassword.setText(Html.fromHtml("<u><font color='#33b5e5'>" + getString(2131100291) + "</font></u>"));
        this.forumIcon = ((ImageView) this.layout.findViewById(2131231076));
        this.forumName = ((TextView) this.layout.findViewById(2131231092));
        return this.layout;
    }

    public void onHiddenChanged(boolean paramBoolean) {
        super.onHiddenChanged(paramBoolean);
        if (!paramBoolean) {
            this.bar.setTitle(2131100936);
        }
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        switch (paramMenuItem.getItemId()) {
        }
        for (; ; ) {
            return super.onOptionsItemSelected(paramMenuItem);
            if ((this.mActivity instanceof SlidingMenuActivity)) {
                ((SlidingMenuActivity) this.mActivity).showRegist();
            }
            if ((this.mActivity instanceof ForumLoginActivity)) {
                if ((!((ForumLoginActivity) this.mActivity).forumStatus.isSsoRegist()) && (!((ForumLoginActivity) this.mActivity).forumStatus.isNativeRegist())) {
                    openRegisterPage();
                } else {
                    ForumRegisterFragment localForumRegisterFragment = ForumRegisterFragment.newInstance(this.forumStatus, this.needForceRead);
                    ((ForumLoginActivity) this.mActivity).showFragmentAndAddToStack(localForumRegisterFragment);
                }
            }
        }
    }

    public void onResume() {
        super.onResume();
    }

    public void onSaveInstanceState(Bundle paramBundle) {
        super.onSaveInstanceState(paramBundle);
        paramBundle.putSerializable("forumStatus", this.forumStatus);
        paramBundle.putString("user", this.user);
        paramBundle.putBoolean("needForceRead", this.needForceRead);
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

    public void showForgetPassView() {
        if ((this.mActivity instanceof SlidingMenuActivity)) {
            SlidingMenuActivity localSlidingMenuActivity1 = (SlidingMenuActivity) this.mActivity;
            ForumForgetPasswordFragment localForumForgetPasswordFragment = ForumForgetPasswordFragment.newInstance(this.forumStatus, this.token, this.au_id, this.prefs.getString("email", ""));
            SlidingMenuActivity localSlidingMenuActivity2 = (SlidingMenuActivity) this.mActivity;
            localSlidingMenuActivity1.addFragmentToStack(localForumForgetPasswordFragment, "login_fragment_stack_tag", false);
        }
        if ((this.mActivity instanceof ForumLoginActivity)) {
            ((ForumLoginActivity) this.mActivity).showFragmentAndAddToStack(ForumForgetPasswordFragment.newInstance(this.forumStatus, this.token, this.au_id, this.prefs.getString("email", "")));
        }
    }

    public void showResetPasswordDialog() {
        AlertDialog.Builder localBuilder = new AlertDialog.Builder(this.mActivity);
        LinearLayout localLinearLayout = (LinearLayout) this.mActivity.getLayoutInflater().inflate(2130903235, null);
        TextView localTextView1 = (TextView) localLinearLayout.findViewById(2131230900);
        final EditText localEditText = (EditText) localLinearLayout.findViewById(2131230982);
        TextView localTextView2 = (TextView) localLinearLayout.findViewById(2131231299);
        localTextView1.setText(this.mActivity.getString(2131100520));
        localTextView2.setTypeface(Typeface.createFromAsset(this.mActivity.getAssets(), "font/Roboto_Condensed.ttf"));
        localTextView2.setText(this.mActivity.getString(2131100523));
        localBuilder.setView(localLinearLayout);
        localBuilder.setPositiveButton(this.mActivity.getString(2131100288), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                if (Util.checkEditText(localEditText)) {
                    paramAnonymousDialogInterface = localEditText.getText().toString().trim();
                    if ((!paramAnonymousDialogInterface.equals("")) && (paramAnonymousDialogInterface != null)) {
                        ArrayList localArrayList = new ArrayList();
                        localArrayList.add(paramAnonymousDialogInterface.getBytes());
                        localArrayList.add(ForumLoginFragment.this.token);
                        localArrayList.add(Util.getMD5(ForumLoginFragment.this.forumStatus.getForumId() + "|" + ForumLoginFragment.this.au_id + "|" + ForumLoginFragment.this.email));
                        ForumLoginFragment.this.engine.call("forget_password", localArrayList);
                        ((ForumActivityStatus) ForumLoginFragment.this.getActivity()).showProgress();
                        return;
                    }
                    ForumLoginFragment.this.showResetPasswordDialog();
                    return;
                }
                ForumLoginFragment.this.showResetPasswordDialog();
            }
        });
        localBuilder.setNegativeButton(this.mActivity.getResources().getString(2131100522), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
            }
        });
        localBuilder.create().show();
    }

    public void tryFailed(String paramString) {
    }

    public void updateSubclassDialog(int paramInt) {
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/ics/slidingMenu/login/ForumLoginFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */