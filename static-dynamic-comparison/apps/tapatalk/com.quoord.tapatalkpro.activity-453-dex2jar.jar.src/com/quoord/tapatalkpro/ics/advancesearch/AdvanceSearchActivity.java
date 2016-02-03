package com.quoord.tapatalkpro.ics.advancesearch;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.quoord.tapatalkpro.activity.forum.ForumActivityStatus;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.bean.TapatalkForum;
import com.quoord.tapatalkpro.ui.ics.IQuoordInterface;
import com.quoord.tapatalkpro.ui.ics.QuoordFragment;
import com.quoord.tapatalkpro.util.CustomTracker;
import com.quoord.tapatalkpro.util.ThemeUtil;

import java.util.Stack;

public class AdvanceSearchActivity
        extends FragmentActivity
        implements ForumActivityStatus {
    public static final String ADVANCEFRAGMENTSTACK = "advance_fragment_stack_tag";
    public Stack<QuoordFragment> advanceFragmentStack = new Stack();
    private IQuoordInterface currentFragment = null;
    private String forumId;
    private String forumName;
    private ForumStatus forumStatus;
    public AdvanceSearchHistoryFragment showFragment;
    private String threadid;

    public void addFragmentToStack(IQuoordInterface paramIQuoordInterface, String paramString, boolean paramBoolean) {
        if (paramString.equals("advance_fragment_stack_tag")) {
            this.advanceFragmentStack.push((QuoordFragment) paramIQuoordInterface);
        }
        showToFront(paramIQuoordInterface, paramBoolean);
    }

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

    public void onBack() {
        if (getCurrentFocus() != null) {
            ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 2);
        }
        if (this.advanceFragmentStack.size() > 1) {
            this.advanceFragmentStack.pop();
            showToFront((QuoordFragment) this.advanceFragmentStack.peek(), false);
            return;
        }
        finish();
        this.advanceFragmentStack.clear();
    }

    public void onCreate(Bundle paramBundle) {
        ThemeUtil.setTheme(this);
        super.onCreate(paramBundle);
        setContentView(2130903386);
        getActionBar().setIcon(2130837525);
        if (getIntent().hasExtra("forumStatus")) {
            this.forumStatus = ((ForumStatus) getIntent().getSerializableExtra("forumStatus"));
        }
        if (getIntent().hasExtra("threadid")) {
            this.threadid = getIntent().getStringExtra("threadid");
        }
        if (getIntent().hasExtra("forumId")) {
            this.forumId = getIntent().getStringExtra("forumId");
        }
        if (getIntent().hasExtra("forumName")) {
            this.forumName = getIntent().getStringExtra("forumName");
        }
        this.showFragment = AdvanceSearchHistoryFragment.newInstance(this, this.threadid, this.forumId, this.forumName, 0);
        addFragmentToStack(this.showFragment, "advance_fragment_stack_tag", true);
    }

    public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent) {
        if (paramInt == 4) {
            onBack();
        }
        return false;
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        switch (paramMenuItem.getItemId()) {
            default:
                return super.onOptionsItemSelected(paramMenuItem);
        }
        onBack();
        return true;
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

    public void showToFront(IQuoordInterface paramIQuoordInterface, boolean paramBoolean) {
        FragmentTransaction localFragmentTransaction = getSupportFragmentManager().beginTransaction();
        if (this.currentFragment == null) {
            localFragmentTransaction.add(2131230953, (QuoordFragment) paramIQuoordInterface, String.valueOf(paramIQuoordInterface.hashCode()));
        }
        for (; ; ) {
            this.currentFragment = paramIQuoordInterface;
            invalidateOptionsMenu();
            localFragmentTransaction.commitAllowingStateLoss();
            return;
            if (getSupportFragmentManager().findFragmentByTag(String.valueOf(paramIQuoordInterface.hashCode())) != null) {
                localFragmentTransaction.hide((QuoordFragment) this.currentFragment);
                localFragmentTransaction.show((QuoordFragment) paramIQuoordInterface);
            } else {
                localFragmentTransaction.add(2131230953, (QuoordFragment) paramIQuoordInterface, String.valueOf(paramIQuoordInterface.hashCode()));
                localFragmentTransaction.hide((QuoordFragment) this.currentFragment);
                localFragmentTransaction.show((QuoordFragment) paramIQuoordInterface);
            }
        }
    }

    public void updateDialog(int paramInt) {
    }

    public void updateUI(int paramInt, Object paramObject) {
    }

    public void updateUI(String paramString) {
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/ics/advancesearch/AdvanceSearchActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */