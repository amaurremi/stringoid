package com.quoord.tapatalkpro.activity.forum;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.quoord.DialogUtil.DialogUtil;
import com.quoord.tapatalkpro.adapter.TryTwiceCallBackInterface;
import com.quoord.tapatalkpro.bean.EngineResponse;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.bean.TapatalkForum;
import com.quoord.tapatalkpro.cache.AppCacheManager;
import com.quoord.tapatalkpro.cache.ForumCookiesCache;
import com.quoord.tapatalkpro.util.TapatalkEngine;
import com.quoord.tapatalkpro.util.ThemeUtil;
import com.quoord.tapatalkpro.util.Util;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class BanUserActivity
        extends FragmentActivity
        implements ForumActivityStatus, TryTwiceCallBackInterface {
    public static final int MENU_BAN = 0;
    private EditText ban_Reason;
    private String cookieCacheUrl = null;
    private int day = 0;
    private int deleteMode = 1;
    private boolean deletePost = false;
    public TapatalkEngine engine = null;
    private String[] expiration;
    private LinearLayout expirationLayout;
    private TextView expiration_content;
    private TextView expiration_divice;
    private ForumStatus forumStatus;
    private int index = 0;
    private boolean isBan;
    private Activity mActivity;
    public ProgressDialog mProgressDlg;
    private int month = 0;
    private CheckBox spamCheckBox;
    private RelativeLayout spamLayout;
    private TextView spam_divice;
    private int year = 0;

    public void banUser(String paramString1, String paramString2, int paramInt) {
        ((ForumActivityStatus) this.mActivity).showProgress();
        localArrayList = new ArrayList();
        try {
            byte[] arrayOfByte = paramString1.getBytes("UTF-8");
            paramString1 = arrayOfByte;
        } catch (UnsupportedEncodingException localUnsupportedEncodingException) {
            for (; ; ) {
                try {
                    paramString1 = paramString2.getBytes("UTF-8");
                    localArrayList.add(paramString1);
                    if ((this.forumStatus.isBanExpires()) && (!this.deletePost)) {
                        if (this.index != 0) {
                            break;
                        }
                        paramInt = 0;
                        localArrayList.add(Integer.valueOf(paramInt));
                    }
                    this.engine.call("m_ban_user", localArrayList);
                    return;
                    localUnsupportedEncodingException = localUnsupportedEncodingException;
                    paramString1 = paramString1.getBytes();
                } catch (UnsupportedEncodingException paramString1) {
                    paramString1 = paramString2.getBytes();
                    continue;
                }
                localArrayList.add(new byte[0]);
            }
        } catch (Exception paramString1) {
            for (; ; ) {
                paramString1.printStackTrace();
                continue;
                paramInt = getTimeStamp();
            }
        }
        localArrayList.add(paramString1);
        localArrayList.add(Integer.valueOf(paramInt));
        if (paramString2 != null) {
            paramInt = paramString2.length();
            if (paramInt <= 0) {
            }
        }
    }

    public void callBack(EngineResponse paramEngineResponse) {
        paramEngineResponse.getMethod();
        paramEngineResponse = (HashMap) paramEngineResponse.getResponse();
        ((ForumActivityStatus) this.mActivity).closeProgress();
        if (paramEngineResponse != null) {
            retryLogin(paramEngineResponse);
            if ((paramEngineResponse.containsKey("result")) && (((Boolean) paramEngineResponse.get("result")).booleanValue())) {
                Toast.makeText(this.mActivity, this.mActivity.getString(2131100061), 1).show();
                paramEngineResponse = new Intent();
                paramEngineResponse.putExtra("isBan", true);
                this.mActivity.setResult(-1, paramEngineResponse);
                this.mActivity.finish();
            }
        } else {
            return;
        }
        Toast.makeText(this.mActivity, new String((byte[]) paramEngineResponse.get("result_text")).toString(), 1).show();
    }

    public void closeProgress() {
        try {
            this.mActivity.dismissDialog(0);
            return;
        } catch (Exception localException) {
        }
    }

    public Activity getDefaultActivity() {
        return null;
    }

    public ForumActivityStatus getForumActivityStatus() {
        return this;
    }

    public ForumStatus getForumStatus() {
        return this.forumStatus;
    }

    public ForumStatus getForumStatus(TapatalkForum paramTapatalkForum) {
        return this.forumStatus;
    }

    public boolean getSaxCall() {
        return false;
    }

    public int getTimeStamp() {
        try {
            Calendar localCalendar = Calendar.getInstance();
            int i = localCalendar.get(5);
            int j = localCalendar.get(2);
            int k = localCalendar.get(1);
            localCalendar.set(this.year + k, this.month + j, this.day + i);
            i = Integer.parseInt(Long.valueOf(localCalendar.getTimeInMillis() / 1000L).toString());
            this.day = 0;
            this.month = 0;
            this.year = 0;
            return i;
        } catch (Exception localException) {
            localException.printStackTrace();
        }
        return Integer.parseInt(System.currentTimeMillis());
    }

    public boolean getTryTwice() {
        return false;
    }

    public boolean isOpCancel() {
        return false;
    }

    protected void onCreate(Bundle paramBundle) {
        ThemeUtil.setTheme(this);
        super.onCreate(paramBundle);
        this.mActivity = this;
        paramBundle = this.mActivity.getActionBar();
        paramBundle.setDisplayHomeAsUpEnabled(true);
        paramBundle.setDisplayShowTitleEnabled(true);
        paramBundle.setDisplayShowHomeEnabled(true);
        paramBundle.setIcon(2130837525);
        paramBundle.setTitle(getResources().getString(2131100057) + getIntent().getStringExtra("username"));
        this.forumStatus = ((ForumStatus) getIntent().getSerializableExtra("forumStatus"));
        this.isBan = getIntent().getBooleanExtra("isBan", false);
        this.engine = new TapatalkEngine(this, this.forumStatus, this.mActivity);
        this.cookieCacheUrl = AppCacheManager.getModerateCookieCacheUrl(this.mActivity, this.forumStatus.tapatalkForum.getUrl(), this.forumStatus.tapatalkForum.getCacheUsernameDir());
        paramBundle = AppCacheManager.getForumCookiesData(this.cookieCacheUrl);
        if ((paramBundle != null) && (paramBundle.cookies != null)) {
            this.forumStatus.cookies = paramBundle.cookies;
            this.forumStatus.loginExpire = false;
        }
        setContentView(2130903072);
        this.ban_Reason = ((EditText) findViewById(2131230854));
        this.spamLayout = ((RelativeLayout) findViewById(2131230855));
        this.spamCheckBox = ((CheckBox) findViewById(2131230856));
        this.spam_divice = ((TextView) findViewById(2131230857));
        this.expiration = getResources().getStringArray(2131492891);
        this.expirationLayout = ((LinearLayout) findViewById(2131230858));
        this.expiration_content = ((TextView) findViewById(2131230860));
        this.expiration_divice = ((TextView) findViewById(2131230861));
        if (this.forumStatus.isBanExpires()) {
            this.expirationLayout.setVisibility(0);
            this.expiration_divice.setVisibility(0);
            if ((this.forumStatus == null) || (!this.forumStatus.isBan_delete_type())) {
                break label414;
            }
            this.spamLayout.setVisibility(8);
            this.spam_divice.setVisibility(8);
        }
        for (; ; ) {
            setOnExpiration();
            setSpamOnClick();
            return;
            this.expirationLayout.setVisibility(8);
            this.expiration_divice.setVisibility(8);
            break;
            label414:
            this.spamLayout.setVisibility(0);
            this.spam_divice.setVisibility(0);
        }
    }

    protected Dialog onCreateDialog(int paramInt) {
        switch (paramInt) {
            default:
                return null;
        }
        ProgressDialog localProgressDialog = new ProgressDialog(this.mActivity);
        localProgressDialog.setMessage(this.mActivity.getString(2131099870));
        localProgressDialog.setIndeterminate(true);
        localProgressDialog.setCancelable(true);
        this.mProgressDlg = localProgressDialog;
        return localProgressDialog;
    }

    public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent) {
        if (4 == paramInt) {
            finish();
        }
        return super.onKeyUp(paramInt, paramKeyEvent);
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        switch (paramMenuItem.getItemId()) {
            default:
            case 16908332:
                for (; ; ) {
                    return super.onOptionsItemSelected(paramMenuItem);
                    finish();
                }
        }
        switch (this.index) {
            case 0:
            default:
                label136:
                if (!this.deletePost) {
                    break;
                }
        }
        for (this.deleteMode = 2; ; this.deleteMode = 1) {
            if ((this.ban_Reason != null) && (!this.ban_Reason.getText().equals(""))) {
                String str = this.ban_Reason.getText().toString();
                banUser(getIntent().getStringExtra("username"), str, this.deleteMode);
            }
            Util.hideSoftKeyb(this.mActivity, this.ban_Reason);
            break;
            this.day = 1;
            break label136;
            this.day = 2;
            break label136;
            this.day = 3;
            break label136;
            this.day = 4;
            break label136;
            this.day = 5;
            break label136;
            this.day = 6;
            break label136;
            this.day = 7;
            break label136;
            this.day = 14;
            break label136;
            this.day = 21;
            break label136;
            this.month = 1;
            break label136;
            this.month = 2;
            break label136;
            this.month = 3;
            break label136;
            this.month = 4;
            break label136;
            this.month = 5;
            break label136;
            this.month = 6;
            break label136;
            this.year = 1;
            break label136;
            this.year = 2;
            break label136;
        }
    }

    public boolean onPrepareOptionsMenu(Menu paramMenu) {
        paramMenu.removeGroup(0);
        paramMenu.add(0, 0, 0, getString(2131100057)).setShowAsAction(2);
        return true;
    }

    public void recallAfterLoginMod() {
        if (this.engine != null) {
            ((ForumActivityStatus) this.mActivity).showProgress();
            ForumCookiesCache localForumCookiesCache = new ForumCookiesCache();
            localForumCookiesCache.writeTime = System.currentTimeMillis();
            localForumCookiesCache.saveForTime = 1800000L;
            localForumCookiesCache.cookies = this.forumStatus.cookies;
            AppCacheManager.cacheForumCookiesData(this.cookieCacheUrl, localForumCookiesCache);
            this.engine.reCall();
        }
    }

    public void retryLogin(HashMap paramHashMap) {
        if ((paramHashMap.containsKey("is_login_mod")) && (!((Boolean) paramHashMap.get("is_login_mod")).booleanValue())) {
            DialogUtil.getLoginModDialog(this.mActivity, this.forumStatus, this).show();
        }
    }

    public void setOnExpiration() {
        this.expirationLayout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View paramAnonymousView) {
                new AlertDialog.Builder(BanUserActivity.this.mActivity).setTitle(BanUserActivity.this.mActivity.getResources().getString(2131100758)).setSingleChoiceItems(BanUserActivity.this.expiration, BanUserActivity.this.index, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {
                        BanUserActivity.this.index = paramAnonymous2Int;
                    }
                }).setPositiveButton(BanUserActivity.this.mActivity.getResources().getString(2131099792), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {
                        BanUserActivity.this.expiration_content.setText(BanUserActivity.this.expiration[BanUserActivity.this.index]);
                    }
                }).setNegativeButton(BanUserActivity.this.mActivity.getResources().getString(2131099974), null).show();
            }
        });
    }

    public void setOpCancel(boolean paramBoolean) {
    }

    public void setSaxCall(boolean paramBoolean) {
    }

    public void setSpamOnClick() {
        this.spamLayout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View paramAnonymousView) {
                if (BanUserActivity.this.spamCheckBox.isChecked()) {
                    BanUserActivity.this.deletePost = false;
                    BanUserActivity.this.spamCheckBox.setChecked(false);
                    if (BanUserActivity.this.forumStatus.isBanExpires()) {
                        BanUserActivity.this.expirationLayout.setVisibility(0);
                        BanUserActivity.this.expiration_divice.setVisibility(0);
                    }
                    return;
                }
                BanUserActivity.this.deletePost = true;
                BanUserActivity.this.spamCheckBox.setChecked(true);
                BanUserActivity.this.expirationLayout.setVisibility(8);
                BanUserActivity.this.expiration_divice.setVisibility(8);
            }
        });
        this.spamCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean) {
                if (paramAnonymousBoolean) {
                    BanUserActivity.this.deletePost = true;
                    BanUserActivity.this.spamCheckBox.setChecked(true);
                    BanUserActivity.this.expirationLayout.setVisibility(8);
                    BanUserActivity.this.expiration_divice.setVisibility(8);
                }
                do {
                    return;
                    BanUserActivity.this.deletePost = false;
                    BanUserActivity.this.spamCheckBox.setChecked(false);
                } while (!BanUserActivity.this.forumStatus.isBanExpires());
                BanUserActivity.this.expirationLayout.setVisibility(0);
                BanUserActivity.this.expiration_divice.setVisibility(0);
            }
        });
    }

    public void setTryTwice(boolean paramBoolean) {
    }

    public void showProgress() {
        try {
            this.mActivity.showDialog(0);
            return;
        } catch (Exception localException) {
            localException.printStackTrace();
        }
    }

    public void showProgress(String paramString) {
    }

    public void tryFailed(String paramString) {
    }

    public void updateDialog(int paramInt) {
        DialogUtil.updateProgressDialog(this.mProgressDlg, paramInt, this.mActivity);
    }

    public void updateSubclassDialog(int paramInt) {
    }

    public void updateUI(int paramInt, Object paramObject) {
    }

    public void updateUI(String paramString) {
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/activity/forum/BanUserActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */