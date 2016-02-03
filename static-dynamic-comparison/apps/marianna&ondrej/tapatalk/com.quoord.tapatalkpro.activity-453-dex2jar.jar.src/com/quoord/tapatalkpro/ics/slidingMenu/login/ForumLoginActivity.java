package com.quoord.tapatalkpro.ics.slidingMenu.login;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Dialog;
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
import com.quoord.tapatalkpro.activity.forum.ForumActivityStatus;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.bean.TapatalkForum;
import com.quoord.tapatalkpro.bean.TapatalkId;
import com.quoord.tapatalkpro.ics.slidingMenu.login.action.PrefetchAccoutAction;
import com.quoord.tapatalkpro.ics.slidingMenu.login.action.PrefetchAccoutAction.ActionCallBack;
import com.quoord.tapatalkpro.ics.tapatalkid.TapatalkIdFactory;
import com.quoord.tapatalkpro.ui.ics.QuoordFragment;
import com.quoord.tapatalkpro.util.ThemeUtil;

import java.util.Stack;

public class ForumLoginActivity
        extends FragmentActivity
        implements ForumActivityStatus {
    private PrefetchAccountInfo accountInfo;
    private QuoordFragment currentFragment = null;
    public ForumStatus forumStatus;
    private Stack<QuoordFragment> fragmentStack = new Stack();
    private TapatalkId tapatalkId;

    private void manageStack() {
        if (this.fragmentStack.size() > 1) {
            FragmentTransaction localFragmentTransaction = getSupportFragmentManager().beginTransaction();
            localFragmentTransaction.remove((Fragment) this.fragmentStack.pop());
            localFragmentTransaction.commitAllowingStateLoss();
            showToFront((QuoordFragment) this.fragmentStack.peek());
            return;
        }
        this.fragmentStack.clear();
        finish();
    }

    private void showToFront(QuoordFragment paramQuoordFragment) {
        FragmentTransaction localFragmentTransaction = getSupportFragmentManager().beginTransaction();
        localFragmentTransaction.setCustomAnimations(2130968598, 2130968599);
        if (this.currentFragment == null) {
            localFragmentTransaction.add(2131230953, paramQuoordFragment, String.valueOf(paramQuoordFragment.hashCode()));
        }
        for (; ; ) {
            this.currentFragment = paramQuoordFragment;
            localFragmentTransaction.commitAllowingStateLoss();
            invalidateOptionsMenu();
            return;
            if (getSupportFragmentManager().findFragmentByTag(String.valueOf(paramQuoordFragment.hashCode())) != null) {
                localFragmentTransaction.hide(this.currentFragment);
                localFragmentTransaction.show(paramQuoordFragment);
            } else {
                localFragmentTransaction.add(2131230953, paramQuoordFragment, String.valueOf(paramQuoordFragment.hashCode()));
                localFragmentTransaction.hide(this.currentFragment);
                localFragmentTransaction.show(paramQuoordFragment);
            }
        }
    }

    public void closeProgress() {
        new Handler().postDelayed(new Runnable() {
            public void run() {
                try {
                    ForumLoginActivity.this.removeDialog(0);
                    return;
                } catch (Exception localException) {
                }
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

    protected void onCreate(Bundle paramBundle) {
        ThemeUtil.setTheme(this);
        super.onCreate(paramBundle);
        setContentView(2130903112);
        getActionBar().setIcon(2130837525);
        this.forumStatus = ((ForumStatus) getIntent().getSerializableExtra("forumStatus"));
        showProgress();
        this.tapatalkId = TapatalkIdFactory.getTapatalkId(this);
        if ((this.tapatalkId.isTapatalkIdLogin()) && (this.tapatalkId.isConfirmed())) {
            if (this.forumStatus.isSsoSign()) {
                showSSoLoginView();
                return;
            }
            if ((this.forumStatus.isSsoLogin()) && (this.accountInfo != null) && (this.accountInfo.hasUser)) {
                showSSoLoginView();
                return;
            }
            showNativeLoginView();
            return;
        }
        if ((this.tapatalkId.isTapatalkIdLogin()) && (!this.tapatalkId.isConfirmed())) {
            showNativeLoginView();
            return;
        }
        if (this.forumStatus.isSsoSign()) {
            showFaceBookLoginView();
            return;
        }
        showNativeLoginView();
    }

    protected Dialog onCreateDialog(int paramInt) {
        switch (paramInt) {
            default:
                return null;
        }
        ProgressDialog localProgressDialog = new ProgressDialog(this);
        localProgressDialog.setMessage(getString(2131099870));
        localProgressDialog.setIndeterminate(true);
        localProgressDialog.setCancelable(true);
        return localProgressDialog;
    }

    public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent) {
        if (paramInt == 4) {
            manageStack();
        }
        return false;
    }

    public boolean onMenuItemSelected(int paramInt, MenuItem paramMenuItem) {
        switch (paramMenuItem.getItemId()) {
        }
        for (; ; ) {
            return super.onMenuItemSelected(paramInt, paramMenuItem);
            manageStack();
        }
    }

    public void showFaceBookLoginView() {
        closeProgress();
        showFragmentAndAddToStack(TapatalkFacebookSigninFragment.newInstance(this.forumStatus, false));
    }

    public void showFragmentAndAddToStack(QuoordFragment paramQuoordFragment) {
        this.fragmentStack.push(paramQuoordFragment);
        showToFront(paramQuoordFragment);
    }

    public void showNativeLoginView() {
        closeProgress();
        showFragmentAndAddToStack(ForumLoginFragment.newInstance(this.forumStatus.tapatalkForum.getUserName(), this.forumStatus, false));
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

    public void showSSoLoginView() {
        new PrefetchAccoutAction(this.forumStatus, this).prefetch(this.tapatalkId.getTapatalkIdEmail(), new PrefetchAccoutAction.ActionCallBack() {
            public void actionCallBack(PrefetchAccountInfo paramAnonymousPrefetchAccountInfo) {
                ForumLoginActivity.this.closeProgress();
                ForumLoginActivity.this.accountInfo = paramAnonymousPrefetchAccountInfo;
                paramAnonymousPrefetchAccountInfo = ForumJoinFragment.newInstance(ForumLoginActivity.this.forumStatus, ForumLoginActivity.this.accountInfo, false);
                ForumLoginActivity.this.showFragmentAndAddToStack(paramAnonymousPrefetchAccountInfo);
            }
        });
    }

    public void updateDialog(int paramInt) {
    }

    public void updateUI(int paramInt, Object paramObject) {
    }

    public void updateUI(String paramString) {
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/ics/slidingMenu/login/ForumLoginActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */