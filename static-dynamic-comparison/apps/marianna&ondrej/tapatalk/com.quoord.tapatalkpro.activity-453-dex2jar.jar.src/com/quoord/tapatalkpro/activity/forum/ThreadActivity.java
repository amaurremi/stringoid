package com.quoord.tapatalkpro.activity.forum;

import android.app.ActionBar;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.MenuItem;
import com.quoord.tapatalkpro.action.ForumConfigHelper;
import com.quoord.tapatalkpro.action.ForumConfigHelper.ActionCallBack;
import com.quoord.tapatalkpro.action.TapatalkAccountAction;
import com.quoord.tapatalkpro.activity.directory.ics.AccountEntryActivity;
import com.quoord.tapatalkpro.alarm.notification.TopTopicNotification;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.bean.TapatalkForum;
import com.quoord.tapatalkpro.commonvalue.IntentValue;
import com.quoord.tapatalkpro.dev.DebugModeUtil;
import com.quoord.tapatalkpro.ics.slidingMenu.login.ForceViewTopicDailog;
import com.quoord.tapatalkpro.util.CustomTracker;
import com.quoord.tapatalkpro.util.TapatalkJsonEngine;
import com.quoord.tapatalkpro.util.ThemeUtil;
import com.quoord.tapatalkpro.util.Util;
import com.quoord.tools.TwoPanelController;
import com.quoord.tools.TwoPanelOutController;
import com.quoord.tools.net.TapatalkAjaxLogAction;
import com.quoord.tools.net.TapatalkLogUrlUtil;

import java.util.HashMap;

public class ThreadActivity
        extends FragmentActivity
        implements TwoPanelOutController, ForumActivityStatus {
    private String channel;
    private boolean forceShowThread = false;
    public ForumStatus forumStatus;
    private boolean isFromFeed = false;
    private boolean isFromNotification = false;
    private boolean isFromTopTopicNotification = false;
    private boolean isShare = false;
    public ThreadOuterFragment outerFragment;
    ProgressDialog progressDialog;
    private TapatalkForum tapatalkForum;

    private void showThreadFragment() {
        FragmentTransaction localFragmentTransaction = getSupportFragmentManager().beginTransaction();
        localFragmentTransaction.setCustomAnimations(2130968598, 2130968599);
        this.outerFragment = new ThreadOuterFragment(this.forceShowThread);
        localFragmentTransaction.add(2131230953, this.outerFragment);
        localFragmentTransaction.commit();
        this.outerFragment.setActionBar(this);
        if (this.forceShowThread) {
            ForceViewTopicDailog.newInstance().show(getSupportFragmentManager(), "dailog");
        }
    }

    public void closeProgress() {
        if ((this.progressDialog != null) && (this.progressDialog.isShowing())) {
            this.progressDialog.cancel();
        }
    }

    public void finishActivity(String paramString, boolean paramBoolean, HashMap<String, String> paramHashMap) {
        Intent localIntent = new Intent();
        localIntent.putExtra("com.quoord.tapatalkpro.apk.topicid", paramString);
        localIntent.putExtra("com.quoord.tapatalkpro.apk.topicid.flag", paramBoolean);
        localIntent.putExtra("cookie", paramHashMap);
        setResult(-1, localIntent);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                ThreadActivity.this.finish();
            }
        }, 300L);
    }

    public Activity getDefaultActivity() {
        return this;
    }

    public ForumActivityStatus getForumActivityStatus() {
        return null;
    }

    public ForumStatus getForumStatus() {
        return this.forumStatus;
    }

    public ForumStatus getForumStatus(TapatalkForum paramTapatalkForum) {
        return null;
    }

    public Fragment getOuterFragment() {
        return this.outerFragment;
    }

    protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
        super.onActivityResult(paramInt1, paramInt2, paramIntent);
    }

    public void onCreate(Bundle paramBundle) {
        ThemeUtil.setTheme(this);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setDisplayShowTitleEnabled(false);
        getActionBar().setIcon(2130837525);
        super.onCreate(paramBundle);
        setContentView(2130903112);
        DebugModeUtil.opCrashEmial(this);
        this.forumStatus = ((ForumStatus) getIntent().getSerializableExtra("forumStatus"));
        this.channel = getIntent().getStringExtra("channel");
        this.isShare = getIntent().getBooleanExtra("isShare", false);
        this.tapatalkForum = ((TapatalkForum) getIntent().getSerializableExtra("forum"));
        this.isFromFeed = getIntent().getBooleanExtra("fromFeed", false);
        this.forceShowThread = getIntent().getBooleanExtra(IntentValue.FORCE_VIEW_THREAD, false);
        if ((this.isFromFeed) && (this.tapatalkForum != null)) {
            showProgress();
            if (getIntent().getBooleanExtra(TopTopicNotification.VIEW_TOP_TOPIC_ACTION, false)) {
                this.isFromTopTopicNotification = true;
                paramBundle = getIntent().getStringExtra("topic_id");
                new TapatalkAjaxLogAction(this).logTapatalkLog(TapatalkLogUrlUtil.getTopTopicLogUrl(this, this.tapatalkForum.getId().intValue(), paramBundle));
            }
            new ForumConfigHelper(this, this.tapatalkForum).getForumStatusAndTryLogin(true, true, new ForumConfigHelper.ActionCallBack() {
                public void actionBack(ForumStatus paramAnonymousForumStatus) {
                    if (!ThreadActivity.this.isFinishing()) {
                        ThreadActivity.this.closeProgress();
                        ThreadActivity.this.forumStatus = paramAnonymousForumStatus;
                        if ((ThreadActivity.this.getIntent().getBooleanExtra(TopTopicNotification.VIEW_TOP_TOPIC_ACTION, false)) && (!Util.isFavoriate(ThreadActivity.this, ThreadActivity.this.forumStatus.tapatalkForum.getId().intValue()))) {
                            TapatalkJsonEngine.auAddAccount(ThreadActivity.this, ThreadActivity.this.forumStatus.tapatalkForum.getId(), "Guest", null, "0", null, "toptopic", ThreadActivity.this.forumStatus.tapatalkForum);
                            TapatalkAccountAction.addToCurrenForums(ThreadActivity.this.forumStatus.tapatalkForum, ThreadActivity.this);
                        }
                        ThreadActivity.this.showThreadFragment();
                    }
                }

                public void actionErrorBack(String paramAnonymousString) {
                    ThreadActivity.this.finish();
                }
            });
            return;
        }
        showThreadFragment();
    }

    public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent) {
        if (paramInt == 4) {
            if ((this.channel != null) && (this.channel.equals("push"))) {
                this.tapatalkForum.openTapatalkForum(this, false);
            }
            if (this.isShare) {
                this.tapatalkForum.openTapatalkForum(this, false);
            }
            if (this.isFromTopTopicNotification) {
                startActivity(new Intent(this, AccountEntryActivity.class));
            }
            finish();
        }
        return false;
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        switch (paramMenuItem.getItemId()) {
        }
        for (; ; ) {
            return super.onOptionsItemSelected(paramMenuItem);
            finish();
            if ((this.channel != null) && (this.channel.equals("push"))) {
                this.tapatalkForum.openTapatalkForum(this, false);
            }
            if (this.isShare) {
                this.tapatalkForum.openTapatalkForum(this, false);
            }
        }
    }

    protected void onStart() {
        super.onStart();
        CustomTracker.start(this);
    }

    public void onStop() {
        super.onStop();
        CustomTracker.stop(this);
    }

    public void showProgress() {
        if (this.progressDialog == null) {
            this.progressDialog = new ProgressDialog(this);
            this.progressDialog.setMessage(getString(2131099870));
            this.progressDialog.setIndeterminate(true);
            this.progressDialog.setCancelable(true);
        }
        if (!this.progressDialog.isShowing()) {
            this.progressDialog.show();
        }
    }

    public void showProgress(String paramString) {
    }

    public void updateDialog(int paramInt) {
    }

    public void updateUI(int paramInt, Object paramObject) {
    }

    public void updateUI(String paramString) {
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/activity/forum/ThreadActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */