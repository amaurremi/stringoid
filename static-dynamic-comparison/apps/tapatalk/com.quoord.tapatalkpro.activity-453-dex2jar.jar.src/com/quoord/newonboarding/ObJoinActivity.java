package com.quoord.newonboarding;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import com.quoord.tapatalkpro.ui.ics.QuoordFragment;
import com.quoord.tapatalkpro.util.CustomTracker;
import com.quoord.tapatalkpro.util.ThemeUtil;

import java.util.Stack;

public class ObJoinActivity
        extends FragmentActivity {
    public static final int ONBOARDINGJOIN = 300;
    public Stack<QuoordFragment> allstack = new Stack();
    public QuoordFragment currentFragment;
    public boolean fromOBLogin = false;
    public boolean fromOBSignUp = false;
    public boolean guestLogin = false;
    public boolean innerLogin = false;
    public boolean isNotification = false;
    private LoginFragment loginFragment;
    public boolean loginPage = false;
    public boolean needBadk = false;
    public boolean notification_register = false;
    private SignUpFragment signUpFragment;

    public void getData(Intent paramIntent) {
        if (paramIntent.hasExtra("fromOBLogin")) {
            this.fromOBLogin = paramIntent.getBooleanExtra("fromOBLogin", false);
        }
        if (paramIntent.hasExtra("fromOBSignUp")) {
            this.fromOBSignUp = paramIntent.getBooleanExtra("fromOBSignUp", false);
        }
        if (paramIntent.hasExtra("needBack")) {
            this.needBadk = paramIntent.getBooleanExtra("needBack", false);
        }
        if (paramIntent.hasExtra("loginPage")) {
            this.loginPage = paramIntent.getBooleanExtra("loginPage", false);
        }
        if (paramIntent.hasExtra("innerLogin")) {
            this.innerLogin = paramIntent.getBooleanExtra("innerLogin", false);
        }
        if (paramIntent.hasExtra("isNotification")) {
            this.isNotification = paramIntent.getBooleanExtra("isNotification", false);
        }
        if (paramIntent.hasExtra("guestLogin")) {
            this.guestLogin = paramIntent.getBooleanExtra("guestLogin", false);
        }
    }

    public void getFragment() {
        if (this.fromOBLogin) {
            this.loginFragment = new LoginFragment();
            showFragmentAndAddStack(this.loginFragment);
        }
        while (!this.fromOBSignUp) {
            return;
        }
        this.signUpFragment = new SignUpFragment();
        showFragmentAndAddStack(this.signUpFragment);
    }

    protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
        super.onActivityResult(paramInt1, paramInt2, paramIntent);
        this.currentFragment.onActivityResult(paramInt1, paramInt2, paramIntent);
    }

    protected void onCreate(Bundle paramBundle) {
        ThemeUtil.setTheme(this);
        super.onCreate(paramBundle);
        setContentView(2130903243);
        ObActivitiesStackManager.getInstance().addActivity(this);
        getData(getIntent());
        getFragment();
    }

    public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent) {
        if (paramInt == 4) {
            if (this.allstack.size() > 1) {
                this.allstack.pop();
                showFragment((QuoordFragment) this.allstack.peek());
            }
        } else {
            return true;
        }
        finish();
        return true;
    }

    public void onStart() {
        super.onStart();
        CustomTracker.start(this);
    }

    public void onStop() {
        super.onStop();
        CustomTracker.stop(this);
    }

    public void removeAllFragment() {
        this.allstack.removeAllElements();
        FragmentTransaction localFragmentTransaction = getSupportFragmentManager().beginTransaction();
        getSupportFragmentManager().popBackStack(null, 1);
        localFragmentTransaction.commitAllowingStateLoss();
    }

    public void removeFragment(QuoordFragment paramQuoordFragment) {
        this.allstack.remove(paramQuoordFragment);
        if (!this.allstack.empty()) {
            showFragment((QuoordFragment) this.allstack.peek());
        }
    }

    public void showFragment(QuoordFragment paramQuoordFragment) {
        FragmentTransaction localFragmentTransaction = getSupportFragmentManager().beginTransaction();
        if (this.currentFragment != null) {
            localFragmentTransaction.hide(this.currentFragment);
        }
        if (getSupportFragmentManager().findFragmentByTag(String.valueOf(paramQuoordFragment.hashCode())) != null) {
            localFragmentTransaction.show(paramQuoordFragment);
        }
        for (; ; ) {
            this.currentFragment = paramQuoordFragment;
            localFragmentTransaction.commitAllowingStateLoss();
            invalidateOptionsMenu();
            return;
            localFragmentTransaction.add(2131231313, paramQuoordFragment, String.valueOf(paramQuoordFragment.hashCode()));
        }
    }

    public void showFragmentAndAddStack(QuoordFragment paramQuoordFragment) {
        this.allstack.add(paramQuoordFragment);
        showFragment(paramQuoordFragment);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/newonboarding/ObJoinActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */