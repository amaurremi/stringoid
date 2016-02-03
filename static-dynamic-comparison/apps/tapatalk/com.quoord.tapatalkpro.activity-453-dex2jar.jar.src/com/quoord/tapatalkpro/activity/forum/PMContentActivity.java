package com.quoord.tapatalkpro.activity.forum;

import android.app.ActionBar;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.MenuItem;
import com.quoord.tapatalkpro.util.ThemeUtil;

public class PMContentActivity
        extends FragmentActivity {
    public PmContentFragment outerFragment;

    public void onCreate(Bundle paramBundle) {
        ThemeUtil.setTheme(this);
        super.onCreate(paramBundle);
        setContentView(2130903112);
        getActionBar().setIcon(2130837525);
        paramBundle = getSupportFragmentManager().beginTransaction();
        this.outerFragment = new PmContentFragment();
        paramBundle.add(2131230953, this.outerFragment);
        paramBundle.commit();
    }

    public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent) {
        if (paramKeyEvent.getKeyCode() == 4) {
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    PMContentActivity.this.finish();
                }
            }, 300L);
            return true;
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
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/activity/forum/PMContentActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */