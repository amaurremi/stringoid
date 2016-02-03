package com.quoord.tapatalkpro.ics.slidingMenu;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import com.quoord.tapatalkpro.activity.directory.ics.IcsEntryActivity;
import com.quoord.tapatalkpro.activity.forum.ForumActivityStatus;
import com.quoord.tapatalkpro.alarm.notification.TopTopicNotification;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.bean.TapatalkForum;
import com.quoord.tapatalkpro.util.ThemeUtil;

public class SettingsActivity
        extends Activity
        implements ForumActivityStatus {
    ForumStatus forumStatus;
    private boolean needBackToAccount = false;

    public void closeProgress() {
    }

    public Activity getDefaultActivity() {
        return this;
    }

    public ForumActivityStatus getForumActivityStatus() {
        return this;
    }

    public ForumStatus getForumStatus() {
        return this.forumStatus;
    }

    public ForumStatus getForumStatus(TapatalkForum paramTapatalkForum) {
        return null;
    }

    protected void onCreate(Bundle paramBundle) {
        ThemeUtil.setTheme(this);
        super.onCreate(paramBundle);
        setContentView(2130903359);
        paramBundle = getIntent();
        this.forumStatus = ((ForumStatus) paramBundle.getSerializableExtra("forumstatus"));
        this.needBackToAccount = paramBundle.getBooleanExtra(TopTopicNotification.VIEW_TOP_TOPIC_ACTION, false);
        if (this.forumStatus != null) {
        }
        for (paramBundle = SettingsFragment.newInstance(1029, this.forumStatus); ; paramBundle = SettingsFragment.newInstance()) {
            FragmentTransaction localFragmentTransaction = getFragmentManager().beginTransaction();
            localFragmentTransaction.add(2131230953, paramBundle, String.valueOf(paramBundle.hashCode()));
            localFragmentTransaction.commitAllowingStateLoss();
            return;
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.needBackToAccount) {
        }
        try {
            Intent localIntent = new Intent(this, IcsEntryActivity.class);
            localIntent.setFlags(32768);
            startActivity(localIntent);
            return;
        } catch (Exception localException) {
        }
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        switch (paramMenuItem.getItemId()) {
            default:
                return super.onOptionsItemSelected(paramMenuItem);
        }
        finish();
        return true;
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


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/ics/slidingMenu/SettingsActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */