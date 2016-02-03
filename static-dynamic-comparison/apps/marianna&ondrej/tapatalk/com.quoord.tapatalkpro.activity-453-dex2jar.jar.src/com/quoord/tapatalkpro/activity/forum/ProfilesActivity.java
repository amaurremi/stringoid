package com.quoord.tapatalkpro.activity.forum;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.MenuItem;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.bean.TapatalkForum;
import com.quoord.tapatalkpro.util.CustomTracker;
import com.quoord.tapatalkpro.util.ThemeUtil;
import com.quoord.tools.TwoPanelOutController;
import com.quoord.tools.tracking.GoogleAnalyticsTools;

public class ProfilesActivity
        extends FragmentActivity
        implements TwoPanelOutController, ForumActivityStatus {
    private ActionBar bar = null;
    public boolean can_upload;
    public ForumStatus forumStatus;
    public String mIconUsername = null;
    public String mUserId = null;
    public ProfilesOuterFragment outerFragment;

    public void closeProgress() {
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
        this.outerFragment.getActivityResult(paramInt1, paramInt2, paramIntent);
    }

    protected void onCreate(Bundle paramBundle) {
        ThemeUtil.setTheme(this);
        super.onCreate(paramBundle);
        this.bar = getActionBar();
        this.bar.setDisplayShowTitleEnabled(false);
        this.bar.setDisplayHomeAsUpEnabled(true);
        this.bar.setIcon(2130837525);
        this.forumStatus = ((ForumStatus) getIntent().getSerializableExtra("forumStatus"));
        this.can_upload = getIntent().getBooleanExtra("can_upload", false);
        this.mIconUsername = getIntent().getStringExtra("iconusername");
        if ((this.mIconUsername == null) || (this.mIconUsername.equals(""))) {
            this.mIconUsername = this.forumStatus.tapatalkForum.getUserName();
        }
        this.mUserId = getIntent().getStringExtra("userid");
        if ((this.mUserId == null) || (this.mUserId.equals(""))) {
            this.mUserId = "0";
        }
        setContentView(2130903386);
        paramBundle = getSupportFragmentManager().beginTransaction();
        this.outerFragment = ProfilesOuterFragment.newInstance(this.mIconUsername, this.mUserId, this.forumStatus);
        paramBundle.add(2131230953, this.outerFragment);
        paramBundle.commit();
        GoogleAnalyticsTools.trackPageView(this, "profile", this.forumStatus.getForumId(), this.forumStatus.getUrl());
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        switch (paramMenuItem.getItemId()) {
        }
        for (; ; ) {
            return super.onOptionsItemSelected(paramMenuItem);
            finish();
        }
    }

    protected void onPause() {
        super.onPause();
        CustomTracker.comScorePause(this);
    }

    protected void onResume() {
        super.onResume();
        CustomTracker.comScoreResume(this);
    }

    public void onStart() {
        super.onStart();
        CustomTracker.start(this);
    }

    public void onStop() {
        super.onStop();
        CustomTracker.stop(this);
    }

    public void showProgress() {
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


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/activity/forum/ProfilesActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */