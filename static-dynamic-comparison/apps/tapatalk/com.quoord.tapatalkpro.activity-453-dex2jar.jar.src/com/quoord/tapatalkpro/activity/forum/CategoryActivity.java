package com.quoord.tapatalkpro.activity.forum;

import android.app.ActionBar;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.widget.EditText;
import com.quoord.DialogUtil.DialogUtil;
import com.quoord.tapatalkpro.adapter.forum.moderation.ModerateAdapter;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.bean.TapatalkForum;
import com.quoord.tapatalkpro.ui.ics.QuoordFragment;
import com.quoord.tapatalkpro.util.CustomTracker;
import com.quoord.tapatalkpro.util.ThemeUtil;

import java.util.Stack;

public class CategoryActivity
        extends FragmentActivity
        implements ForumActivityStatus {
    public ActionBar bar = null;
    private ForumStatus forumStatus = null;
    public CategoriesFragment fragment;
    private Activity mActivity = null;
    private ProgressDialog mProgressDlg;

    public void closeProgress() {
        try {
            this.mActivity.dismissDialog(0);
            return;
        } catch (Exception localException) {
        }
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
        return this.forumStatus;
    }

    protected void onCreate(Bundle paramBundle) {
        ThemeUtil.setTheme(this);
        super.onCreate(paramBundle);
        this.mActivity = this;
        this.bar = this.mActivity.getActionBar();
        this.bar.setDisplayHomeAsUpEnabled(true);
        this.bar.setTitle(2131100126);
        this.bar.setIcon(2130837525);
        setContentView(2130903386);
        if ((getIntent().hasExtra("forumStatus")) && (getIntent().getSerializableExtra("forumStatus") != null)) {
            this.forumStatus = ((ForumStatus) getIntent().getSerializableExtra("forumStatus"));
        }
        this.fragment = CategoriesFragment.newInstance(this.forumStatus);
        showToForumStack(this.fragment, true);
    }

    public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent) {
        if ((paramInt == 4) && ((this.fragment instanceof CategoriesFragment))) {
            if ((this.fragment.mForumAdapter.forumStack.size() > 0) && (!this.fragment.mForumAdapter.forumStack.empty())) {
                this.fragment.mForumAdapter.backToTopLevel();
                return true;
            }
            new Handler().postAtTime(new Runnable() {
                public void run() {
                    CategoryActivity.this.mActivity.finish();
                }
            }, 300L);
            return true;
        }
        return super.onKeyUp(paramInt, paramKeyEvent);
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

    public void setTargetForum(String paramString) {
        if ((!paramString.equals("")) && (paramString != null)) {
            this.fragment.textView.setText(paramString);
        }
    }

    public void showProgress() {
        try {
            showDialog(0);
            return;
        } catch (Exception localException) {
            localException.printStackTrace();
        }
    }

    public void showProgress(String paramString) {
    }

    public void showToForumStack(QuoordFragment paramQuoordFragment, boolean paramBoolean) {
        FragmentTransaction localFragmentTransaction = getSupportFragmentManager().beginTransaction();
        localFragmentTransaction.add(2131230953, paramQuoordFragment);
        localFragmentTransaction.commit();
    }

    public void updateDialog(int paramInt) {
        DialogUtil.updateProgressDialog(this.mProgressDlg, paramInt, this.mActivity);
    }

    public void updateUI(int paramInt, Object paramObject) {
    }

    public void updateUI(String paramString) {
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/activity/forum/CategoryActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */