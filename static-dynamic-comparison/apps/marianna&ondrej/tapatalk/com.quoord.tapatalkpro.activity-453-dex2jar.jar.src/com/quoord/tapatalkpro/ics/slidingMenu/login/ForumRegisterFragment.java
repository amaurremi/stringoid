package com.quoord.tapatalkpro.ics.slidingMenu.login;

import android.app.ActionBar;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.quoord.tapatalkpro.TapatalkApp;
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
import com.quoord.tapatalkpro.sqlhelper.FavoriateSqlHelper;
import com.quoord.tapatalkpro.ui.ics.QuoordFragment;
import com.quoord.tapatalkpro.util.Prefs;
import com.quoord.tapatalkpro.util.TapatalkEngine;
import com.quoord.tapatalkpro.util.Util;
import com.quoord.tapatalkpro.view.TapaButton;
import com.quoord.tools.ImageTools;

import java.util.ArrayList;
import java.util.HashMap;

public class ForumRegisterFragment
        extends QuoordFragment
        implements TryTwiceCallBackInterface {
    private int au_id = 0;
    private ActionBar bar = null;
    private EditText confirm_password = null;
    private String email = null;
    private TapatalkEngine engine = null;
    private ImageView forumIcon;
    private String forumId = null;
    private TextView forumName;
    private ForumStatus forumStatus = null;
    private View layout = null;
    private boolean login = false;
    private FragmentActivity mActivity;
    private boolean needForceRead = true;
    private EditText password = null;
    private SharedPreferences prefs = null;
    private ProgressDialog progress = null;
    private TapaButton registerButton = null;
    private TextView registerTip = null;
    private EditText register_email = null;
    private String token = null;
    private EditText username = null;

    private void callRegister(boolean paramBoolean) {
        String str1 = this.username.getText().toString().trim();
        String str2 = this.password.getText().toString().trim();
        Object localObject = this.confirm_password.getText().toString().trim();
        if ((Util.checkString(str1)) && (Util.checkString(str2)) && (Util.checkString((String) localObject))) {
            if ((str2.length() > 3) && (((String) localObject).length() > 3)) {
                if (!str2.equals(localObject)) {
                    Toast.makeText(this.mActivity, this.mActivity.getResources().getString(2131100308), 1).show();
                }
            }
        }
        do {
            return;
            localObject = new ArrayList();
            if ((this.login) && (this.register_email.getText().toString().trim().equals(this.email)) && (!paramBoolean) && (this.forumStatus.isSsoRegist())) {
                ((ArrayList) localObject).add(str1.getBytes());
                ((ArrayList) localObject).add(str2.getBytes());
                ((ArrayList) localObject).add(this.register_email.getText().toString().trim().getBytes());
                ((ArrayList) localObject).add(this.token);
                ((ArrayList) localObject).add(Util.getMD5(this.forumId + "|" + this.au_id + "|" + this.email));
            }
            for (; ; ) {
                this.engine.call("register", (ArrayList) localObject);
                if ((this.progress == null) || (this.progress.isShowing())) {
                    break;
                }
                this.progress.show();
                return;
                ((ArrayList) localObject).add(str1.getBytes());
                ((ArrayList) localObject).add(str2.getBytes());
                ((ArrayList) localObject).add(this.register_email.getText().toString().trim().getBytes());
            }
            Toast.makeText(this.mActivity, this.mActivity.getResources().getString(2131100315), 1).show();
            return;
            if (("".equals(str1)) || ("".equals(str2))) {
                Toast.makeText(this.mActivity, this.mActivity.getResources().getString(2131100303), 1).show();
                return;
            }
        } while (!"".equals(localObject));
        Toast.makeText(this.mActivity, this.mActivity.getResources().getString(2131100309), 1).show();
    }

    public static ForumRegisterFragment newInstance(ForumStatus paramForumStatus) {
        ForumRegisterFragment localForumRegisterFragment = new ForumRegisterFragment();
        localForumRegisterFragment.forumStatus = paramForumStatus;
        return localForumRegisterFragment;
    }

    public static ForumRegisterFragment newInstance(ForumStatus paramForumStatus, boolean paramBoolean) {
        ForumRegisterFragment localForumRegisterFragment = new ForumRegisterFragment();
        localForumRegisterFragment.forumStatus = paramForumStatus;
        localForumRegisterFragment.needForceRead = paramBoolean;
        return localForumRegisterFragment;
    }

    public void callBack(EngineResponse paramEngineResponse) {
        if ((!"".equals(paramEngineResponse.getMethod())) && ((paramEngineResponse.getResponse() instanceof HashMap))) {
            paramEngineResponse = (HashMap) paramEngineResponse.getResponse();
            try {
                if (((Boolean) paramEngineResponse.get("result")).booleanValue()) {
                    this.progress.dismiss();
                    this.forumStatus.tapatalkForum.setUserName(this.username.getText().toString().trim());
                    this.forumStatus.tapatalkForum.setUnEncodePassword(this.password.getText().toString().trim());
                    paramEngineResponse = new Intent();
                    paramEngineResponse.putExtra("forumStatus", this.forumStatus);
                    this.mActivity.setResult(1, paramEngineResponse);
                    paramEngineResponse = this.prefs.edit();
                    paramEngineResponse.putString("register_email", this.register_email.getText().toString().trim());
                    paramEngineResponse.commit();
                    Toast.makeText(this.mActivity, this.mActivity.getResources().getString(2131100411), 1).show();
                    paramEngineResponse = new FavoriateSqlHelper(this.mActivity, TapatalkApp.database_name, null, Integer.parseInt(TapatalkApp.database_version));
                    if ((this.forumStatus.tapatalkForum.getPassword() != null) && (!this.forumStatus.tapatalkForum.getPassword().equals(""))) {
                        paramEngineResponse.saveFavoriate(this.forumStatus.tapatalkForum);
                    }
                    ((ForumActivityStatus) this.mActivity).showProgress();
                    new ForumLoginOrSignAction(this.mActivity, this.forumStatus).loginForum(this.forumStatus.tapatalkForum.getUserName(), this.forumStatus.tapatalkForum.getPassword(), true, true, true, true, new ForumLoginOrSignAction.ActionCallBack()
                    new ForumLoginOrSignAction.ActionFoceViewAThread
                    {
                        public void actionErrorBack (String paramAnonymousString1, String paramAnonymousString2)
                        {
                            ((ForumActivityStatus) ForumRegisterFragment.this.mActivity).closeProgress();
                            if ((paramAnonymousString1 != null) && (paramAnonymousString1.equals(""))) {
                                Toast.makeText(ForumRegisterFragment.this.mActivity, paramAnonymousString1, 1).show();
                            }
                        }

                    public void actionSuccessBack (ForumStatus paramAnonymousForumStatus)
                    {
                        if ((ForumRegisterFragment.this.mActivity instanceof SlidingMenuActivity)) {
                            ((SlidingMenuActivity) ForumRegisterFragment.this.mActivity).closeProgress();
                            ((SlidingMenuActivity) ForumRegisterFragment.this.mActivity).clearStack();
                            ((SlidingMenuActivity) ForumRegisterFragment.this.mActivity).showView();
                            ((SlidingMenuActivity) ForumRegisterFragment.this.mActivity).getUnreadNumbers();
                        }
                        if ((ForumRegisterFragment.this.mActivity instanceof ForumLoginActivity)) {
                            ((ForumLoginActivity) ForumRegisterFragment.this.mActivity).closeProgress();
                            ForumRegisterFragment.this.mActivity.getIntent().putExtra("forumStatus", ForumRegisterFragment.this.forumStatus);
                            ForumRegisterFragment.this.mActivity.setResult(-1, ForumRegisterFragment.this.mActivity.getIntent());
                            ForumRegisterFragment.this.mActivity.finish();
                        }
                    }
                    },new ForumLoginOrSignAction.ActionFoceViewAThread() {
                        public void actionViewThread(String paramAnonymousString) {
                            Intent localIntent = new Intent(ForumRegisterFragment.this.mActivity, ThreadActivity.class);
                            localIntent.putExtra("forumStatus", ForumRegisterFragment.this.forumStatus);
                            localIntent.putExtra("topic_id", paramAnonymousString);
                            localIntent.putExtra(IntentValue.FORCE_VIEW_THREAD, true);
                            ForumRegisterFragment.this.startActivity(localIntent);
                        }
                    });
                    ((ForumActivityStatus) this.mActivity).showProgress();
                    new LogNewLogin(getActivity(), this.forumStatus).reset();
                    return;
                }
                paramEngineResponse = new String((byte[]) paramEngineResponse.get("result_text"));
                if (!Util.checkString(paramEngineResponse)) {
                    return;
                }
                if (paramEngineResponse.contains("Forum is not configured well, please contact administrator to set up push key for the forum")) {
                    callRegister(true);
                    return;
                }
            } catch (Exception paramEngineResponse) {
                paramEngineResponse.printStackTrace();
                return;
            }
            this.progress.dismiss();
            Util.showToastForLong(this.mActivity, paramEngineResponse);
        }
    }

    public boolean getSaxCall() {
        return false;
    }

    public boolean getTryTwice() {
        return false;
    }

    public String getUrl() {
        Object localObject2 = this.forumStatus.getUrl();
        Object localObject1 = localObject2;
        if (((String) localObject2).contains("https://")) {
            localObject1 = ((String) localObject2).replaceAll("https://", "");
        }
        localObject2 = localObject1;
        if (((String) localObject1).contains("http://")) {
            localObject2 = ((String) localObject1).replaceAll("http://", "");
        }
        return (String) localObject2;
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
            this.needForceRead = paramBundle.getBoolean("needForceRead");
        }
        initForumIconandName();
        this.prefs = Prefs.get(this.mActivity);
        this.bar = this.mActivity.getActionBar();
        this.bar.setDisplayShowHomeEnabled(true);
        this.bar.setTitle(2131100939);
        if (this.forumStatus != null) {
            this.forumStatus.tapatalkForum.getUrl();
            this.progress = new ProgressDialog(this.mActivity);
            this.progress.setMessage(this.mActivity.getResources().getString(2131100313));
            if (this.prefs.contains("token")) {
                this.token = this.prefs.getString("token", "");
            }
            if (this.prefs.contains("tapatalk_auid")) {
                this.au_id = this.prefs.getInt("tapatalk_auid", 0);
            }
            if (this.prefs.contains("email")) {
                this.email = this.prefs.getString("email", "");
            }
            if (this.prefs.contains("login")) {
                if (!this.prefs.getBoolean("login", false)) {
                    break label385;
                }
                this.login = true;
            }
            this.forumId = this.forumStatus.getForumId();
            this.engine = new TapatalkEngine(this, this.forumStatus, this.mActivity);
            this.registerTip.setText(this.mActivity.getResources().getString(2131100404) + getUrl());
            if (!this.mActivity.getResources().getBoolean(2131558401)) {
                break label393;
            }
            this.registerTip.setVisibility(8);
        }
        for (; ; ) {
            this.register_email.setText(this.email);
            register();
            return;
            label385:
            this.login = false;
            break;
            label393:
            this.registerTip.setVisibility(0);
        }
    }

    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        this.layout = paramLayoutInflater.inflate(2130903167, null);
        this.register_email = ((EditText) this.layout.findViewById(2131231094));
        this.username = ((EditText) this.layout.findViewById(2131231093));
        this.password = ((EditText) this.layout.findViewById(2131231095));
        this.password.setTypeface(Typeface.DEFAULT);
        this.password.setTransformationMethod(new PasswordTransformationMethod());
        this.confirm_password = ((EditText) this.layout.findViewById(2131231096));
        this.confirm_password.setImeOptions(6);
        this.confirm_password.setTypeface(Typeface.DEFAULT);
        this.confirm_password.setTransformationMethod(new PasswordTransformationMethod());
        this.registerButton = ((TapaButton) this.layout.findViewById(2131231097));
        this.registerTip = ((TextView) this.layout.findViewById(2131231098));
        this.forumIcon = ((ImageView) this.layout.findViewById(2131231076));
        this.forumName = ((TextView) this.layout.findViewById(2131231092));
        return this.layout;
    }

    public void onHiddenChanged(boolean paramBoolean) {
        super.onHiddenChanged(paramBoolean);
        if (!paramBoolean) {
            this.bar.setTitle(2131100939);
        }
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        return super.onOptionsItemSelected(paramMenuItem);
    }

    public void onSaveInstanceState(Bundle paramBundle) {
        super.onSaveInstanceState(paramBundle);
        paramBundle.putSerializable("forumStatus", this.forumStatus);
        paramBundle.putBoolean("needForceRead", this.needForceRead);
    }

    public void register() {
        if (SettingsFragment.isLightTheme(this.mActivity)) {
            this.registerButton.setTextColor(this.mActivity.getResources().getColor(2131165213));
            Util.setBg(this.registerButton, this.mActivity.getResources().getDrawable(2130838824));
        }
        for (; ; ) {
            this.registerButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View paramAnonymousView) {
                    Util.hideSoftKeyb(ForumRegisterFragment.this.mActivity, ForumRegisterFragment.this.registerButton);
                    ForumRegisterFragment.this.callRegister(false);
                }
            });
            return;
            Util.setBg(this.registerButton, this.mActivity.getResources().getDrawable(2130838825));
        }
    }

    public void setOpCancel(boolean paramBoolean) {
    }

    public void setSaxCall(boolean paramBoolean) {
    }

    public void setTryTwice(boolean paramBoolean) {
    }

    public void tryFailed(String paramString) {
    }

    public void updateSubclassDialog(int paramInt) {
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/ics/slidingMenu/login/ForumRegisterFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */