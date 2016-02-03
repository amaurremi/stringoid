package com.quoord.tapatalkpro.activity.forum.conversation;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.MenuItem;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.dev.DebugModeUtil;
import com.quoord.tapatalkpro.util.CustomTracker;
import com.quoord.tapatalkpro.util.ThemeUtil;

import java.util.HashMap;

public class ConverSationActivity
        extends FragmentActivity {
    public ConversationOuterFragment convsationFragment;
    private ForumStatus forumStatus;
    public HashMap<String, Object> hash;

    protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
        this.convsationFragment.getActivityResult(paramInt1, paramInt2, paramIntent);
        super.onActivityResult(paramInt1, paramInt2, paramIntent);
    }

    protected void onCreate(Bundle paramBundle) {
        ThemeUtil.setTheme(this);
        super.onCreate(paramBundle);
        DebugModeUtil.opCrashEmial(this);
        getActionBar().setDisplayShowTitleEnabled(false);
        getActionBar().setDisplayShowHomeEnabled(true);
        getActionBar().setIcon(2130837525);
        setContentView(2130903112);
        if (getIntent().hasExtra("forumStatus")) {
            this.forumStatus = ((ForumStatus) getIntent().getSerializableExtra("forumStatus"));
        }
        if (getIntent().hasExtra("hashmap")) {
            this.hash = ((HashMap) getIntent().getSerializableExtra("hashmap"));
            this.forumStatus = ((ForumStatus) this.hash.get("forumStatus"));
        }
        paramBundle = getSupportFragmentManager().beginTransaction();
        if (this.hash != null) {
        }
        for (this.convsationFragment = new ConversationOuterFragment(false, this.hash); ; this.convsationFragment = new ConversationOuterFragment()) {
            paramBundle.add(2131230953, this.convsationFragment);
            paramBundle.commit();
            return;
        }
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
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/activity/forum/conversation/ConverSationActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */