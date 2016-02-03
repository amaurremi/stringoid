package com.quoord.tapatalkpro.activity.directory.migration;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.quoord.tapatalkpro.ui.ics.QuoordFragment;
import com.quoord.tapatalkpro.util.ThemeUtil;

import java.util.Stack;

public class MigrationActivity
        extends FragmentActivity {
    private QuoordFragment currentFragment = null;
    private Stack<QuoordFragment> fragmentStack = new Stack();

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

    protected void onCreate(Bundle paramBundle) {
        ThemeUtil.setTheme(this);
        super.onCreate(paramBundle);
        setContentView(2130903112);
        showFragmentAndAddToStack(new MigrationFragment());
    }

    public void showFragmentAndAddToStack(QuoordFragment paramQuoordFragment) {
        this.fragmentStack.push(paramQuoordFragment);
        showToFront(paramQuoordFragment);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/activity/directory/migration/MigrationActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */