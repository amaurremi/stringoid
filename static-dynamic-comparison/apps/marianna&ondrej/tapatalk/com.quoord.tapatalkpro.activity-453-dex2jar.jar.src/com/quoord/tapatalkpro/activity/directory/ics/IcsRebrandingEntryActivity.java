package com.quoord.tapatalkpro.activity.directory.ics;

import android.app.ActionBar;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.HitBuilders.AppViewBuilder;
import com.google.android.gms.analytics.Tracker;
import com.quoord.tapatalkpro.action.RebrandingChecker;
import com.quoord.tapatalkpro.alarm.NotificationAlarmService;
import com.quoord.tapatalkpro.cache.AppCacheManager;
import com.quoord.tapatalkpro.ics.slidingMenu.SlidingMenuActivity;
import com.quoord.tapatalkpro.ui.ics.QuoordFragment;
import com.quoord.tapatalkpro.util.CustomTracker;
import com.quoord.tapatalkpro.util.Prefs;
import com.quoord.tapatalkpro.util.ThemeUtil;
import com.quoord.tapatalkpro.util.ThreadPoolManager;
import com.quoord.tapatalkpro.util.Util;

import java.util.Stack;

public class IcsRebrandingEntryActivity
        extends FragmentActivity {
    public static final String ALLINONEFRAGMENTSTACK = "all_in_one_stack_tag";
    public static final String BACKACTION = "back_action";
    public static final String REBRANDFRAGMENTSTACK = "rebranding_stack_tag";
    public static final int RESULT_SETTING = 10;
    public static final int UPDATE_TAPATALKID = 1;
    public static final String VIEW_FROM_OUT_URL = "VIEW_FROM_OUT_URL";
    private static int openTime = 0;
    public RebrandFragment allInOneFragment = null;
    public Stack<QuoordFragment> allinoneFragmentStack = new Stack();
    public ActionBar bar;
    private QuoordFragment currentFragment = null;
    private IcsRebrandingEntryActivity mActivity;
    private Fragment mFrag;
    private NetWorkFragment netWorkFragment = null;
    private SharedPreferences prefs;
    public Stack<QuoordFragment> rebrandFragmentStack = new Stack();
    public RebrandingChecker rebrandingChecker;

    private void initGcm() {
    }

    public void addFragmentToStack(QuoordFragment paramQuoordFragment, String paramString, boolean paramBoolean) {
        if (paramString.equals("rebranding_stack_tag")) {
            this.rebrandFragmentStack.push(paramQuoordFragment);
        }
        for (; ; ) {
            showFragment(paramQuoordFragment, paramBoolean);
            return;
            if (paramString.equals("all_in_one_stack_tag")) {
                this.allinoneFragmentStack.push(paramQuoordFragment);
            }
        }
    }

    public Fragment getmFrag() {
        return this.mFrag;
    }

    protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
        if ((paramInt2 == 37) && (this.prefs.getBoolean("login", false)) && (paramIntent != null)) {
            paramIntent.getStringExtra("back_action").equals("regist");
        }
        super.onActivityResult(paramInt1, paramInt2, paramIntent);
    }

    protected void onCreate(Bundle paramBundle) {
        ThemeUtil.setTheme(this);
        this.mActivity = this;
        this.bar = getActionBar();
        getIntent();
        super.onCreate(paramBundle);
        this.prefs = Prefs.get(this);
        paramBundle = this.prefs.edit();
        if (this.prefs.getInt("openTime", 0) == 0) {
            AppCacheManager.del(AppCacheManager.getBaseCacheDir(this.mActivity));
        }
        NotificationAlarmService.setupPings(this);
        openTime += 1;
        paramBundle.putInt("openTime", openTime);
        paramBundle.commit();
        paramBundle = (WindowManager) getSystemService("window");
        if (paramBundle.getDefaultDisplay().getHeight() < paramBundle.getDefaultDisplay().getWidth()) {
        }
        paramBundle = GoogleAnalytics.getInstance(this).newTracker("UA-37125424-2");
        paramBundle.setScreenName("BYO");
        paramBundle.send(new HitBuilders.AppViewBuilder().build());
        AppCacheManager.createCacheDir(this.mActivity);
        paramBundle = getIntent();
        if ((paramBundle != null) && (paramBundle.getAction() != null) && (paramBundle.getAction().equalsIgnoreCase("android.intent.action.VIEW")) && (paramBundle.getData() != null) && (paramBundle.getData().toString().length() > 0)) {
            getWindow().setFlags(1024, 1024);
            this.bar.hide();
            setContentView(2130903339);
            String str = paramBundle.getScheme();
            if ((str != null) && (str.equalsIgnoreCase("tapatalk"))) {
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        try {
                            IcsRebrandingEntryActivity.this.rebrandingChecker = new RebrandingChecker(IcsRebrandingEntryActivity.this.mActivity);
                            return;
                        } catch (Exception localException) {
                            localException.printStackTrace();
                        }
                    }
                }, 2000L);
                return;
            }
            paramBundle.setClass(this, SlidingMenuActivity.class);
            paramBundle.putExtra("VIEW_FROM_OUT_URL", true);
            startActivity(paramBundle);
            new Handler().postAtTime(new Runnable() {
                public void run() {
                    IcsRebrandingEntryActivity.this.mActivity.finish();
                }
            }, 2000L);
            return;
        }
        getWindow().setFlags(1024, 1024);
        this.mActivity.getActionBar().hide();
        setContentView(2130903339);
        Util.showMenu(this);
        this.rebrandingChecker = new RebrandingChecker(this.mActivity);
    }

    public void onDestroy() {
        ThreadPoolManager.stopThreadPoolMannager();
        super.onDestroy();
    }

    public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent) {
        if (paramInt == 4) {
            if (this.netWorkFragment == null) {
                break label54;
            }
            if (this.rebrandFragmentStack.size() <= 1) {
                break label48;
            }
            this.rebrandFragmentStack.pop();
            showFragment((QuoordFragment) this.rebrandFragmentStack.peek(), false);
        }
        label48:
        label54:
        while (this.allInOneFragment == null) {
            return false;
            finish();
            return false;
        }
        if (this.allinoneFragmentStack.size() > 1) {
            this.allinoneFragmentStack.pop();
            showFragment((QuoordFragment) this.allinoneFragmentStack.peek(), false);
            return false;
        }
        finish();
        return false;
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        switch (paramMenuItem.getItemId()) {
        }
        for (; ; ) {
            return super.onOptionsItemSelected(paramMenuItem);
            if (this.netWorkFragment != null) {
                if (this.rebrandFragmentStack.size() > 1) {
                    this.rebrandFragmentStack.pop();
                    showFragment((QuoordFragment) this.rebrandFragmentStack.peek(), false);
                } else {
                    finish();
                }
            } else if (this.allInOneFragment != null) {
                if (this.allinoneFragmentStack.size() > 1) {
                    this.allinoneFragmentStack.pop();
                    showFragment((QuoordFragment) this.allinoneFragmentStack.peek(), false);
                } else {
                    finish();
                }
            }
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

    protected void onSaveInstanceState(Bundle paramBundle) {
        super.onSaveInstanceState(paramBundle);
    }

    protected void onStart() {
        super.onStart();
    }

    public void setmFrag(Fragment paramFragment) {
        this.mFrag = paramFragment;
    }

    public void showAllInOneFirstFragment() {
        if (this.mActivity.getResources().getBoolean(2131558402)) {
            if (this.allInOneFragment == null) {
                this.allInOneFragment = RebrandFragment.newInstance();
            }
            addFragmentToStack(this.allInOneFragment, "all_in_one_stack_tag", true);
            return;
        }
        if (this.netWorkFragment == null) {
            this.netWorkFragment = NetWorkFragment.newInstance(this.rebrandingChecker);
        }
        addFragmentToStack(this.netWorkFragment, "rebranding_stack_tag", true);
    }

    public void showFragment(QuoordFragment paramQuoordFragment, boolean paramBoolean) {
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
            return;
            localFragmentTransaction.add(2131230953, paramQuoordFragment, String.valueOf(paramQuoordFragment.hashCode()));
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/activity/directory/ics/IcsRebrandingEntryActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */