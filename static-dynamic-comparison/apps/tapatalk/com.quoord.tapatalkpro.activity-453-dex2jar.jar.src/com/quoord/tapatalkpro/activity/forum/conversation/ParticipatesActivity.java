package com.quoord.tapatalkpro.activity.forum.conversation;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.MenuItem;
import com.quoord.tapatalkpro.activity.forum.ForumActivityStatus;
import com.quoord.tapatalkpro.adapter.forum.conversation.ConvDetailAdapter;
import com.quoord.tapatalkpro.bean.Conversation;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.bean.TapatalkForum;
import com.quoord.tapatalkpro.ui.ics.IQuoordInterface;
import com.quoord.tapatalkpro.ui.ics.QuoordFragment;
import com.quoord.tapatalkpro.util.ThemeUtil;

import java.util.HashMap;
import java.util.Stack;

public class ParticipatesActivity
        extends FragmentActivity
        implements ForumActivityStatus {
    private ConvDetailAdapter adapter;
    public boolean can_invite;
    public boolean can_upload;
    public Conversation conv;
    private IQuoordInterface currentFragment = null;
    public ForumStatus forumStatus;
    private ParticipatesFragment fragment;
    public Stack<QuoordFragment> participateStack = new Stack();
    public HashMap raw_parts;

    public void addFragmentToStack(IQuoordInterface paramIQuoordInterface, boolean paramBoolean) {
        this.participateStack.push((QuoordFragment) paramIQuoordInterface);
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

    protected void onCreate(Bundle paramBundle) {
        ThemeUtil.setTheme(this);
        super.onCreate(paramBundle);
        getActionBar().setDisplayShowTitleEnabled(false);
        getActionBar().setIcon(2130837525);
        setContentView(2130903112);
        paramBundle = getIntent().getExtras();
        if (paramBundle.containsKey("raw_parts")) {
            this.raw_parts = ((HashMap) paramBundle.get("raw_parts"));
        }
        if (paramBundle.containsKey("can_invite")) {
            this.can_invite = paramBundle.getBoolean("can_invite");
        }
        if (paramBundle.containsKey("forumStatus")) {
            this.forumStatus = ((ForumStatus) paramBundle.getSerializable("forumStatus"));
        }
        if (paramBundle.containsKey("conversation")) {
            this.conv = ((Conversation) paramBundle.getSerializable("conversation"));
        }
        if (paramBundle.containsKey("can_upload")) {
            this.can_upload = paramBundle.getBoolean("can_upload");
        }
        this.fragment = ParticipatesFragment.newInstance();
        addFragmentToStack(this.fragment, true);
    }

    public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent) {
        closeProgress();
        if (paramInt == 4) {
            if (this.participateStack.size() > 1) {
                this.participateStack.pop();
                showToFront((QuoordFragment) this.participateStack.peek(), false);
                return true;
            }
            finish();
            return true;
        }
        return false;
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        switch (paramMenuItem.getItemId()) {
            default:
                return super.onOptionsItemSelected(paramMenuItem);
        }
        if (this.participateStack.size() > 1) {
            this.participateStack.pop();
            showToFront((QuoordFragment) this.participateStack.peek(), false);
            return true;
        }
        finish();
        return true;
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
            invalidateOptionsMenu();
            return;
            if ((QuoordFragment) getSupportFragmentManager().findFragmentByTag(String.valueOf(paramIQuoordInterface.hashCode())) != null) {
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


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/activity/forum/conversation/ParticipatesActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */