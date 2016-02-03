package com.quoord.tapatalkpro.activity.forum;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.widget.ListView;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.bean.TapatalkForum;
import com.quoord.tapatalkpro.ui.ics.IQuoordInterface;
import com.quoord.tapatalkpro.ui.ics.QuoordFragment;
import com.quoord.tapatalkpro.util.AdvancesearchContrast;
import com.quoord.tapatalkpro.util.CustomTracker;
import com.quoord.tapatalkpro.util.ThemeUtil;

import java.util.Stack;

public class SearchActivity
        extends FragmentActivity
        implements ForumActivityStatus {
    public static final String ADVANCEFRAGMENTSTACK = "advance_fragment_stack_tag";
    public Stack<QuoordFragment> advanceFragmentStack = new Stack();
    private AdvancesearchContrast contrast;
    private IQuoordInterface currentFragment = null;
    private ForumStatus forumStatus = null;
    public SearchActivity mActivity;
    public SearchFragment showFragment;

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
        if (this.advanceFragmentStack.size() > 1) {
            this.advanceFragmentStack.pop();
            showToFront((QuoordFragment) this.advanceFragmentStack.peek(), false);
            return;
        }
        finish();
        this.advanceFragmentStack.clear();
    }

    protected void onCreate(Bundle paramBundle) {
        ThemeUtil.setTheme(this);
        super.onCreate(paramBundle);
        this.mActivity = this;
        setContentView(2130903386);
        paramBundle = getActionBar();
        paramBundle.setDisplayHomeAsUpEnabled(true);
        paramBundle.setDisplayShowHomeEnabled(true);
        paramBundle.setIcon(2130837525);
        paramBundle = getIntent().getExtras();
        this.contrast = ((AdvancesearchContrast) paramBundle.getSerializable("contrast"));
        if ((this.contrast.FORUMNAME != null) && (!this.contrast.FORUMNAME.equals(""))) {
            setTitle(this.mActivity.getString(2131100122) + this.contrast.FORUMNAME);
        }
        for (; ; ) {
            this.forumStatus = ((ForumStatus) paramBundle.getSerializable("forumStatus"));
            this.showFragment = SearchFragment.newInstance(this.forumStatus, this.contrast);
            addFragmentToStack(this.showFragment, "advance_fragment_stack_tag", true);
            return;
            if ((this.contrast.KEYWORD != null) && (!this.contrast.KEYWORD.equals(""))) {
                setTitle(this.contrast.KEYWORD);
            } else {
                setTitle(2131100121);
            }
        }
    }

    public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent) {
        if (paramInt == 4) {
            onBack();
        }
        return false;
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        switch (paramMenuItem.getItemId()) {
        }
        for (; ; ) {
            return super.onOptionsItemSelected(paramMenuItem);
            finish();
        }
    }

    public void onStart() {
        super.onStart();
        CustomTracker.start(this);
    }

    public void onStop() {
        super.onStop();
        CustomTracker.stop(this);
    }

    public void removeListFootLay() {
        if ((this.showFragment != null) && (this.showFragment.listView != null) && (this.showFragment.listView.getFooterViewsCount() > 0)) {
            this.showFragment.listView.removeFooterView(this.showFragment.footlay);
        }
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


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/activity/forum/SearchActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */