package com.quoord.tapatalkpro.ics.tapatalkid;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.ics.BaseListFragment;
import com.quoord.tapatalkpro.ics.slidingMenu.login.ForumUpdateEmailFragment;
import com.quoord.tapatalkpro.ui.ics.QuoordFragment;
import com.quoord.tapatalkpro.util.CustomTracker;
import com.quoord.tapatalkpro.util.ThemeUtil;

import java.util.Stack;

public class TapatalkEmailActivity
        extends FragmentActivity {
    public static final String PROFILESEMAIL = "profile_email_statck_tag";
    public static QuoordFragment currentFragment = null;
    public ForumStatus forumStatus = null;
    public Stack<BaseListFragment> profileEmail = new Stack();
    private boolean update = false;

    public void addFragmentToStack(BaseListFragment paramBaseListFragment, boolean paramBoolean) {
        this.profileEmail.push(paramBaseListFragment);
        showToFront(paramBaseListFragment, paramBoolean);
    }

    protected void onCreate(Bundle paramBundle) {
        ThemeUtil.setTheme(this);
        super.onCreate(paramBundle);
        paramBundle = getActionBar();
        paramBundle.setDisplayHomeAsUpEnabled(true);
        paramBundle.setIcon(2130837525);
        setContentView(2130903386);
        if (getIntent().hasExtra("forumStatus")) {
            this.forumStatus = ((ForumStatus) getIntent().getSerializableExtra("forumStatus"));
        }
        if (getIntent().hasExtra("update")) {
            this.update = getIntent().getBooleanExtra("update", false);
        }
        showToFront(ForumUpdateEmailFragment.newInstance(this.update), true);
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

    public void showToFront(QuoordFragment paramQuoordFragment, boolean paramBoolean) {
        FragmentTransaction localFragmentTransaction = getSupportFragmentManager().beginTransaction();
        localFragmentTransaction.add(2131230953, paramQuoordFragment);
        localFragmentTransaction.commit();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/ics/tapatalkid/TapatalkEmailActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */