package com.quoord.tapatalkpro.activity.directory.ics;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.Activity;
import android.app.ProgressDialog;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.provider.SearchRecentSuggestions;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.SearchView;
import android.widget.SearchView.OnQueryTextListener;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabHost.TabContentFactory;
import android.widget.TabHost.TabSpec;
import android.widget.TabWidget;
import android.widget.TextView;
import com.quoord.tapatalkpro.activity.forum.ForumActivityStatus;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.bean.TapatalkForum;
import com.quoord.tapatalkpro.ui.ics.QuoordFragment;
import com.quoord.tapatalkpro.util.Prefs;
import com.quoord.tapatalkpro.util.TabsUtil4;
import com.quoord.tapatalkpro.util.ThemeUtil;
import com.quoord.tapatalkpro.util.Util;

import java.util.ArrayList;
import java.util.Stack;

public class IcsSearchActivity
        extends FragmentActivity
        implements ForumActivityStatus, ActionBar.TabListener {
    public int countNum = 3;
    private QuoordFragment currentFragment = null;
    private IcsSearchFragment forumFragment;
    private String keyword;
    private SearchSectionsPagerAdapter mPagerAdapter;
    private TabHost mTabHost;
    private ViewPager mViewPager;
    ProgressDialog progressDialog = null;
    private MenuItem searchMenuItem;
    private Stack<QuoordFragment> searchStack = new Stack();
    private SearchView searchView;
    public int startCount = 0;
    private IcsSearchFragment topicFragment;

    private void createSearchMenu(Menu paramMenu) {
        getMenuInflater().inflate(2131623941, paramMenu);
        this.searchMenuItem = paramMenu.findItem(2131231471);
        SearchManager localSearchManager = (SearchManager) getSystemService("search");
        this.searchView = ((SearchView) paramMenu.findItem(2131231471).getActionView());
        try {
            int i = getResources().getIdentifier("android:id/search_mag_icon", null, null);
            ((ImageView) this.searchView.findViewById(i)).setImageResource(2130838902);
            this.searchView.setSearchableInfo(localSearchManager.getSearchableInfo(getComponentName()));
            this.searchView.setFocusable(false);
            this.searchView.setQuery(this.keyword, false);
            this.searchView.setIconifiedByDefault(false);
            i = getResources().getIdentifier("android:id/search_plate", null, null);
            ((ViewGroup) this.searchView.findViewById(i)).setBackgroundResource(2130839292);
            this.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                public boolean onQueryTextChange(String paramAnonymousString) {
                    return true;
                }

                public boolean onQueryTextSubmit(String paramAnonymousString) {
                    Util.hideSoftKeyb(IcsSearchActivity.this, IcsSearchActivity.this.searchView);
                    new SearchRecentSuggestions(IcsSearchActivity.this, "com.quoord.tapatalkpro.activity.SearchSuggestionProvider", 1).saveRecentQuery(paramAnonymousString, null);
                    IcsSearchActivity.this.searchView.clearFocus();
                    int i = 0;
                    for (; ; ) {
                        if (i >= IcsSearchActivity.SearchSectionsPagerAdapter.access$0(IcsSearchActivity.this.mPagerAdapter).size()) {
                            IcsSearchActivity.this.keyword = paramAnonymousString;
                            return true;
                        }
                        if ((IcsSearchActivity.SearchSectionsPagerAdapter.TabInfo.access$0((IcsSearchActivity.SearchSectionsPagerAdapter.TabInfo) IcsSearchActivity.SearchSectionsPagerAdapter.access$0(IcsSearchActivity.this.mPagerAdapter).get(i)) instanceof IcsSearchFragment)) {
                            ((IcsSearchFragment) IcsSearchActivity.SearchSectionsPagerAdapter.TabInfo.access$0((IcsSearchActivity.SearchSectionsPagerAdapter.TabInfo) IcsSearchActivity.SearchSectionsPagerAdapter.access$0(IcsSearchActivity.this.mPagerAdapter).get(i))).startNewQuery(paramAnonymousString);
                        }
                        i += 1;
                    }
                }
            });
            this.searchView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View paramAnonymousView) {
                }
            });
            return;
        } catch (Exception paramMenu) {
            for (; ; ) {
            }
        }
    }

    private void handleIntent(Intent paramIntent) {
        int i;
        if ("android.intent.action.SEARCH".equals(paramIntent.getAction())) {
            paramIntent = paramIntent.getStringExtra("query");
            this.searchView.setQuery(paramIntent, false);
            this.searchView.clearFocus();
            this.keyword = paramIntent;
            i = 0;
        }
        for (; ; ) {
            if (i >= this.mPagerAdapter.mTabs.size()) {
                return;
            }
            if ((((IcsSearchActivity.SearchSectionsPagerAdapter.TabInfo) SearchSectionsPagerAdapter.access$0(this.mPagerAdapter).get(i)).clss instanceof IcsSearchFragment)) {
                ((IcsSearchFragment) ((IcsSearchActivity.SearchSectionsPagerAdapter.TabInfo) SearchSectionsPagerAdapter.access$0(this.mPagerAdapter).get(i)).clss).startNewQuery(paramIntent);
            }
            i += 1;
        }
    }

    private void initView() {
        setContentView(2130903200);
        this.mViewPager = ((ViewPager) findViewById(2131231216));
        this.mTabHost = ((TabHost) findViewById(16908306));
        if (this.mTabHost != null) {
            this.mTabHost.setup();
            this.mTabHost.getTabWidget().setDividerDrawable(null);
            this.mTabHost.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() {
                public void onViewAttachedToWindow(View paramAnonymousView) {
                    IcsSearchActivity.this.mTabHost.getViewTreeObserver().removeOnTouchModeChangeListener(IcsSearchActivity.this.mTabHost);
                }

                public void onViewDetachedFromWindow(View paramAnonymousView) {
                }
            });
        }
        this.forumFragment = IcsSearchFragment.newInstance(this.keyword, 0);
        this.topicFragment = IcsSearchFragment.newInstance(this.keyword, 1);
        if ((this.mViewPager != null) && (this.mTabHost != null)) {
            this.mViewPager.setOffscreenPageLimit(0);
            this.mPagerAdapter = new SearchSectionsPagerAdapter(this, this.mTabHost, this.mViewPager);
            this.mPagerAdapter.notifyDataSetChanged();
        }
        this.mPagerAdapter.addTab(this.mTabHost.newTabSpec(getString(2131100665).toUpperCase()).setIndicator(getString(2131100665).toUpperCase()), this.forumFragment, null, false);
        this.mPagerAdapter.addTab(this.mTabHost.newTabSpec(getString(2131100666).toUpperCase()).setIndicator(getString(2131100666).toUpperCase()), this.topicFragment, null, true);
        ActionBar localActionBar = getActionBar();
        localActionBar.setIcon(2130837525);
        localActionBar.setDisplayHomeAsUpEnabled(true);
        localActionBar.setDisplayShowTitleEnabled(true);
        if (this.mTabHost != null) {
            this.mTabHost.setCurrentTab(0);
        }
        invalidateOptionsMenu();
    }

    public void addFragmentToStack(QuoordFragment paramQuoordFragment) {
        this.searchStack.push(paramQuoordFragment);
        showToFront(paramQuoordFragment);
    }

    public void closeProgress() {
        if (this.progressDialog != null) {
            this.progressDialog.dismiss();
        }
    }

    public Activity getDefaultActivity() {
        return this;
    }

    public ForumActivityStatus getForumActivityStatus() {
        return null;
    }

    public ForumStatus getForumStatus() {
        return null;
    }

    public ForumStatus getForumStatus(TapatalkForum paramTapatalkForum) {
        return null;
    }

    public void manageStack() {
        if (this.searchStack.size() > 1) {
            android.support.v4.app.FragmentTransaction localFragmentTransaction = getSupportFragmentManager().beginTransaction();
            localFragmentTransaction.remove((Fragment) this.searchStack.pop());
            localFragmentTransaction.commitAllowingStateLoss();
            showToFront((QuoordFragment) this.searchStack.peek());
            return;
        }
        this.searchStack.clear();
        finish();
    }

    public void onConfigurationChanged(Configuration paramConfiguration) {
        super.onConfigurationChanged(paramConfiguration);
        paramConfiguration = new LinearLayout.LayoutParams(-1, -1);
        int i = (int) getResources().getDimension(2131427376);
        paramConfiguration.setMargins(i, 0, i, 0);
        this.mViewPager.setLayoutParams(paramConfiguration);
    }

    protected void onCreate(Bundle paramBundle) {
        ThemeUtil.setTheme(this);
        super.onCreate(paramBundle);
        this.keyword = getIntent().getStringExtra("queryKeyword");
        initView();
        paramBundle = Prefs.get(this);
        this.startCount = paramBundle.getInt("search_ad_count", 0);
        if (this.startCount < this.countNum) {
            this.startCount += 1;
            paramBundle.edit().putInt("search_ad_count", this.startCount).commit();
        }
    }

    public boolean onMenuItemSelected(int paramInt, MenuItem paramMenuItem) {
        switch (paramMenuItem.getItemId()) {
        }
        for (; ; ) {
            return super.onMenuItemSelected(paramInt, paramMenuItem);
            manageStack();
        }
    }

    public void onNewIntent(Intent paramIntent) {
        super.onNewIntent(paramIntent);
        handleIntent(paramIntent);
    }

    public boolean onPrepareOptionsMenu(Menu paramMenu) {
        paramMenu.removeGroup(0);
        createSearchMenu(paramMenu);
        return true;
    }

    public void onTabReselected(ActionBar.Tab paramTab, android.app.FragmentTransaction paramFragmentTransaction) {
    }

    public void onTabSelected(ActionBar.Tab paramTab, android.app.FragmentTransaction paramFragmentTransaction) {
        if (this.mViewPager.getCurrentItem() != paramTab.getPosition()) {
            this.mViewPager.setCurrentItem(paramTab.getPosition());
        }
    }

    public void onTabUnselected(ActionBar.Tab paramTab, android.app.FragmentTransaction paramFragmentTransaction) {
    }

    public void showProgress() {
        if (this.progressDialog == null) {
            this.progressDialog = new ProgressDialog(this);
            this.progressDialog.setMessage(getString(2131099870));
            this.progressDialog.setIndeterminate(true);
            this.progressDialog.setCancelable(true);
        }
        if (!this.progressDialog.isShowing()) {
            new Handler().post(new Runnable() {
                public void run() {
                    try {
                        IcsSearchActivity.this.progressDialog.show();
                        return;
                    } catch (Exception localException) {
                    }
                }
            });
        }
    }

    public void showProgress(String paramString) {
    }

    public void showToFront(QuoordFragment paramQuoordFragment) {
        android.support.v4.app.FragmentTransaction localFragmentTransaction = getSupportFragmentManager().beginTransaction();
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

    public void updateDialog(int paramInt) {
    }

    public void updateUI(int paramInt, Object paramObject) {
    }

    public void updateUI(String paramString) {
    }

    public class SearchSectionsPagerAdapter
            extends FragmentStatePagerAdapter
            implements TabHost.OnTabChangeListener, ViewPager.OnPageChangeListener {
        private final Context mContext;
        private final TabHost mTabHost;
        private final ArrayList<TabInfo> mTabs = new ArrayList();
        private final ViewPager mViewPager;
        private TextView textView;

        public SearchSectionsPagerAdapter(FragmentActivity paramFragmentActivity, TabHost paramTabHost, ViewPager paramViewPager) {
            super();
            this.mContext = paramFragmentActivity;
            this.mTabHost = paramTabHost;
            this.mViewPager = paramViewPager;
            this.mTabHost.setOnTabChangedListener(this);
            this.mViewPager.setAdapter(this);
            this.mViewPager.setOnPageChangeListener(this);
        }

        public void addTab(TabHost.TabSpec paramTabSpec, Fragment paramFragment, Bundle paramBundle, boolean paramBoolean) {
            paramTabSpec.setContent(new DummyTabFactory(this.mContext));
            TabsUtil4.setTabIndicator(paramTabSpec, Util.prepareTabView(paramTabSpec.getTag(), (Activity) this.mContext, paramBoolean));
            paramFragment = new TabInfo(paramTabSpec.getTag(), paramFragment, paramBundle);
            this.mTabs.add(paramFragment);
            this.mTabHost.addTab(paramTabSpec);
            notifyDataSetChanged();
        }

        public int getCount() {
            return this.mTabs.size();
        }

        public Fragment getItem(int paramInt) {
            TabInfo localTabInfo = (TabInfo) this.mTabs.get(paramInt);
            switch (paramInt) {
                default:
                    return null;
                case 0:
                    IcsSearchActivity.this.forumFragment = ((IcsSearchFragment) localTabInfo.clss);
                    if (IcsSearchActivity.this.forumFragment == null) {
                        IcsSearchActivity.this.forumFragment = IcsSearchFragment.newInstance(IcsSearchActivity.this.keyword, 0);
                    }
                    return IcsSearchActivity.this.forumFragment;
            }
            IcsSearchActivity.this.topicFragment = ((IcsSearchFragment) localTabInfo.clss);
            if (IcsSearchActivity.this.topicFragment == null) {
                IcsSearchActivity.this.topicFragment = new IcsSearchFragment();
            }
            return IcsSearchActivity.this.topicFragment;
        }

        public void onPageScrollStateChanged(int paramInt) {
        }

        public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {
        }

        public void onPageSelected(int paramInt) {
            try {
                TabWidget localTabWidget = this.mTabHost.getTabWidget();
                int i = localTabWidget.getDescendantFocusability();
                localTabWidget.setDescendantFocusability(393216);
                this.mTabHost.setCurrentTab(paramInt);
                this.mViewPager.setOffscreenPageLimit(0);
                localTabWidget.setDescendantFocusability(i);
                return;
            } catch (Exception localException) {
                localException.printStackTrace();
            }
        }

        public void onTabChanged(String paramString) {
            int i = this.mTabHost.getCurrentTab();
            this.mViewPager.setCurrentItem(i);
        }

        class DummyTabFactory
                implements TabHost.TabContentFactory {
            private final Context mContext;

            public DummyTabFactory(Context paramContext) {
                this.mContext = paramContext;
            }

            public View createTabContent(String paramString) {
                paramString = new View(this.mContext);
                paramString.setMinimumWidth(0);
                paramString.setMinimumHeight(0);
                return paramString;
            }
        }

        final class TabInfo {
            private final Bundle args;
            private final Fragment clss;
            private final String tag;

            TabInfo(String paramString, Fragment paramFragment, Bundle paramBundle) {
                this.tag = paramString;
                this.clss = paramFragment;
                this.args = paramBundle;
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/activity/directory/ics/IcsSearchActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */