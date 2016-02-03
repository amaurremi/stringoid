package com.quoord.tapatalkpro.ics.slidingMenu.login;

import android.app.ActionBar;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.quoord.tapatalkpro.TapatalkApp;
import com.quoord.tapatalkpro.adapter.TryTwiceCallBackInterface;
import com.quoord.tapatalkpro.bean.EngineResponse;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.bean.TapatalkForum;
import com.quoord.tapatalkpro.ics.slidingMenu.SettingsFragment;
import com.quoord.tapatalkpro.ics.tapatalkid.TapatalkEmailActivity;
import com.quoord.tapatalkpro.sqlhelper.FavoriateSqlHelper;
import com.quoord.tapatalkpro.ui.ics.QuoordFragment;
import com.quoord.tapatalkpro.util.Prefs;
import com.quoord.tapatalkpro.util.TapatalkEngine;
import com.quoord.tapatalkpro.view.TapaButton;

import java.util.ArrayList;
import java.util.HashMap;

public class ForumUpdateEmailFragment
        extends QuoordFragment
        implements TryTwiceCallBackInterface {
    private ActionBar bar = null;
    private TapaButton change = null;
    private LinearLayout changeLayout = null;
    private TextView changePassword_tips = null;
    private EditText confirm_newPassword = null;
    private String email = null;
    private TapatalkEngine engine = null;
    private boolean isUpdate = false;
    private View layout = null;
    private TapatalkEmailActivity mActivity = null;
    private EditText newEmail = null;
    private EditText newPassword = null;
    private EditText password = null;
    private EditText password1 = null;
    private SharedPreferences prefs;
    private ProgressDialog progress = null;
    private TapaButton update = null;
    private TextView updateEmail_tips = null;
    private LinearLayout updateLayout = null;

    public static ForumUpdateEmailFragment newInstance(boolean paramBoolean) {
        ForumUpdateEmailFragment localForumUpdateEmailFragment = new ForumUpdateEmailFragment();
        localForumUpdateEmailFragment.isUpdate = paramBoolean;
        return localForumUpdateEmailFragment;
    }

    public void callBack(EngineResponse paramEngineResponse) {
        Object localObject = paramEngineResponse.getMethod();
        if ((!"".equals(localObject)) && ((paramEngineResponse.getResponse() instanceof HashMap))) {
            paramEngineResponse = (HashMap) paramEngineResponse.getResponse();
            try {
                if (((Boolean) paramEngineResponse.get("result")).booleanValue()) {
                    if (((String) localObject).equals("update_email")) {
                        localObject = this.prefs.edit();
                        ((SharedPreferences.Editor) localObject).putString("register_email", this.newEmail.getText().toString().trim());
                        ((SharedPreferences.Editor) localObject).commit();
                        paramEngineResponse = (byte[]) paramEngineResponse.get("result_text");
                        Toast.makeText(this.mActivity, new String(paramEngineResponse), 1).show();
                    }
                    for (; ; ) {
                        paramEngineResponse = (InputMethodManager) this.mActivity.getSystemService("input_method");
                        if (this.mActivity.getCurrentFocus() != null) {
                            paramEngineResponse.hideSoftInputFromWindow(this.mActivity.getCurrentFocus().getWindowToken(), 2);
                        }
                        this.mActivity.finish();
                        return;
                        this.mActivity.forumStatus.tapatalkForum.setPassword(this.confirm_newPassword.getText().toString().trim());
                        new FavoriateSqlHelper(this.mActivity, TapatalkApp.database_name, null, Integer.parseInt(TapatalkApp.database_version)).saveFavoriate(this.mActivity.forumStatus.tapatalkForum);
                        localObject = (byte[]) paramEngineResponse.get("result_text");
                        paramEngineResponse = (EngineResponse) localObject;
                        if (localObject.length <= 0) {
                            paramEngineResponse = this.mActivity.getResources().getString(2131100310).getBytes();
                        }
                        Toast.makeText(this.mActivity, new String(paramEngineResponse), 1).show();
                    }
                }
                paramEngineResponse = (byte[]) paramEngineResponse.get("result_text");
            } catch (Exception paramEngineResponse) {
                paramEngineResponse.printStackTrace();
                return;
            }
            Toast.makeText(this.mActivity, new String(paramEngineResponse), 1).show();
            this.progress.dismiss();
        }
    }

    public boolean getSaxCall() {
        return false;
    }

    public boolean getTryTwice() {
        return false;
    }

    public boolean isOpCancel() {
        return false;
    }

    public void onActivityCreated(Bundle paramBundle) {
        super.onActivityCreated(paramBundle);
        this.mActivity = ((TapatalkEmailActivity) getActivity());
        this.bar = this.mActivity.getActionBar();
        this.bar.setDisplayHomeAsUpEnabled(true);
        this.prefs = Prefs.get(this.mActivity);
        if (this.prefs.contains("register_email")) {
            this.email = this.prefs.getString("register_email", "");
        }
        this.progress = new ProgressDialog(this.mActivity);
        this.progress.setMessage(this.mActivity.getResources().getString(2131100313));
        this.engine = new TapatalkEngine(this, this.mActivity.forumStatus, this.mActivity);
        if (this.isUpdate) {
            this.bar.setTitle(this.mActivity.getResources().getString(2131100398));
            this.changeLayout.setVisibility(8);
            this.updateLayout.setVisibility(0);
            this.updateEmail_tips.setText(this.mActivity.getResources().getString(2131100408) + this.email);
        }
        for (; ; ) {
            setOnclick();
            return;
            this.bar.setTitle(this.mActivity.getResources().getString(2131100296));
            this.changeLayout.setVisibility(0);
            this.updateLayout.setVisibility(8);
            this.changePassword_tips.setText(this.mActivity.getResources().getString(2131100407) + this.mActivity.forumStatus.tapatalkForum.getUrl());
        }
    }

    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        this.layout = paramLayoutInflater.inflate(2130903415, null);
        this.updateLayout = ((LinearLayout) this.layout.findViewById(2131231690));
        this.password = ((EditText) this.layout.findViewById(2131230912));
        this.newEmail = ((EditText) this.layout.findViewById(2131231692));
        this.update = ((TapaButton) this.layout.findViewById(2131231693));
        this.changeLayout = ((LinearLayout) this.layout.findViewById(2131230915));
        this.password1 = ((EditText) this.layout.findViewById(2131231694));
        this.newPassword = ((EditText) this.layout.findViewById(2131230913));
        this.confirm_newPassword = ((EditText) this.layout.findViewById(2131230914));
        this.change = ((TapaButton) this.layout.findViewById(2131231695));
        this.changePassword_tips = ((TextView) this.layout.findViewById(2131230916));
        this.updateEmail_tips = ((TextView) this.layout.findViewById(2131231696));
        return this.layout;
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        switch (paramMenuItem.getItemId()) {
            default:
                return super.onOptionsItemSelected(paramMenuItem);
        }
        paramMenuItem = (InputMethodManager) this.mActivity.getSystemService("input_method");
        if (this.mActivity.getCurrentFocus() != null) {
            paramMenuItem.hideSoftInputFromWindow(this.mActivity.getCurrentFocus().getWindowToken(), 2);
        }
        this.mActivity.finish();
        return true;
    }

    public void setOnclick() {
        this.update.setOnClickListener(new View.OnClickListener() {
            public void onClick(View paramAnonymousView) {
                paramAnonymousView = ForumUpdateEmailFragment.this.password.getText().toString().trim();
                String str = ForumUpdateEmailFragment.this.newEmail.getText().toString().trim();
                if ((paramAnonymousView != null) && (!paramAnonymousView.equals("")) && (str != null) && (!str.equals(""))) {
                    if (!str.equals(ForumUpdateEmailFragment.this.email)) {
                        ArrayList localArrayList = new ArrayList();
                        localArrayList.add(paramAnonymousView.getBytes());
                        localArrayList.add(str.getBytes());
                        ForumUpdateEmailFragment.this.engine.call("update_email", localArrayList);
                        ForumUpdateEmailFragment.this.progress.show();
                        return;
                    }
                    Toast.makeText(ForumUpdateEmailFragment.this.mActivity, "email can not the same as old email", 1).show();
                    return;
                }
                Toast.makeText(ForumUpdateEmailFragment.this.mActivity, "email or password can not empty", 1).show();
            }
        });
        this.change.setOnClickListener(new View.OnClickListener() {
            public void onClick(View paramAnonymousView) {
                paramAnonymousView = ForumUpdateEmailFragment.this.password1.getText().toString().trim();
                Object localObject = ForumUpdateEmailFragment.this.newPassword.getText().toString().trim();
                String str = ForumUpdateEmailFragment.this.confirm_newPassword.getText().toString().trim();
                if ((!"".equals(paramAnonymousView)) && (!"".equals(localObject)) && (!"".equals(str))) {
                    if ((((String) localObject).length() > 3) && (str.length() > 3)) {
                        if (!((String) localObject).equals(str)) {
                            Toast.makeText(ForumUpdateEmailFragment.this.mActivity, ForumUpdateEmailFragment.this.mActivity.getResources().getString(2131100308), 1).show();
                        }
                    }
                }
                do {
                    return;
                    localObject = new ArrayList();
                    ((ArrayList) localObject).add(paramAnonymousView.getBytes());
                    ((ArrayList) localObject).add(str.getBytes());
                    ForumUpdateEmailFragment.this.engine.call("update_password", (ArrayList) localObject);
                    ForumUpdateEmailFragment.this.progress.show();
                    return;
                    Toast.makeText(ForumUpdateEmailFragment.this.mActivity, ForumUpdateEmailFragment.this.mActivity.getResources().getString(2131100315), 1).show();
                    return;
                    if (("".equals(paramAnonymousView)) || ("".equals(localObject))) {
                        Toast.makeText(ForumUpdateEmailFragment.this.mActivity, ForumUpdateEmailFragment.this.mActivity.getResources().getString(2131100303), 1).show();
                        return;
                    }
                } while (!"".equals(str));
                Toast.makeText(ForumUpdateEmailFragment.this.mActivity, ForumUpdateEmailFragment.this.mActivity.getResources().getString(2131100309), 1).show();
            }
        });
    }

    public void setOpCancel(boolean paramBoolean) {
    }

    public void setQuoordBackGround(Context paramContext) {
        if (SettingsFragment.isLightTheme(getActivity())) {
            getView().setBackgroundResource(2131165281);
            return;
        }
        getView().setBackgroundResource(2131165282);
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


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/ics/slidingMenu/login/ForumUpdateEmailFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */