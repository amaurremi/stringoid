package com.quoord.tapatalkpro.activity.directory.ics;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.Activity;
import android.app.ProgressDialog;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.SearchRecentSuggestions;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v4.widget.DrawerLayout;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SearchView;
import android.widget.SearchView.OnQueryTextListener;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabHost.TabContentFactory;
import android.widget.TabHost.TabSpec;
import android.widget.TabWidget;
import android.widget.TextView;
import com.google.android.gcm.GCMRegistrar;
import com.quoord.newonboarding.ObEntryActivity;
import com.quoord.tapatalkHD.TapatalkUnInstalledReceiver;
import com.quoord.tapatalkpro.TapatalkApp;
import com.quoord.tapatalkpro.action.GetAccountBybyoAction;
import com.quoord.tapatalkpro.action.InitGcmTool;
import com.quoord.tapatalkpro.action.RegisterTidAction;
import com.quoord.tapatalkpro.action.TapatalkAccountAction;
import com.quoord.tapatalkpro.activity.directory.migration.MigratioinDialogTool;
import com.quoord.tapatalkpro.activity.forum.ForumActivityStatus;
import com.quoord.tapatalkpro.adapter.directory.FavoriteForumAdapter;
import com.quoord.tapatalkpro.ads.AdsService;
import com.quoord.tapatalkpro.alarm.NotificationAlarmService;
import com.quoord.tapatalkpro.bean.FeedForum;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.bean.FunctionConfig;
import com.quoord.tapatalkpro.bean.TapatalkForum;
import com.quoord.tapatalkpro.bean.TapatalkId;
import com.quoord.tapatalkpro.cache.AppCacheManager;
import com.quoord.tapatalkpro.dev.DebugModeUtil;
import com.quoord.tapatalkpro.feed.FeedFragment;
import com.quoord.tapatalkpro.feed.FeedSettingsFragment;
import com.quoord.tapatalkpro.ics.slidingMenu.SettingsActivity;
import com.quoord.tapatalkpro.ics.slidingMenu.SettingsFragment;
import com.quoord.tapatalkpro.ics.slidingMenu.SlidingMenuActivity;
import com.quoord.tapatalkpro.ics.tapatalkid.SignInWithOtherUtil;
import com.quoord.tapatalkpro.ics.tapatalkid.TapatalkIdFactory;
import com.quoord.tapatalkpro.sqlhelper.FavoriateSqlHelper;
import com.quoord.tapatalkpro.ui.DisabledViewPager;
import com.quoord.tapatalkpro.ui.ics.QuoordFragment;
import com.quoord.tapatalkpro.util.CustomTracker;
import com.quoord.tapatalkpro.util.Prefs;
import com.quoord.tapatalkpro.util.TabsUtil4;
import com.quoord.tapatalkpro.util.TapatalkJsonEngine;
import com.quoord.tapatalkpro.util.ThemeUtil;
import com.quoord.tapatalkpro.util.ThreadPoolManager;
import com.quoord.tapatalkpro.util.Util;
import com.quoord.tools.UserBehavior;
import com.quoord.tools.directoryurl.DirectoryUrlUtil;
import com.quoord.tools.tracking.GoogleAnalyticsTools;
import com.wbtech.ums.UmsAgent;

import java.util.ArrayList;
import java.util.Stack;

public class AccountEntryActivity
        extends FragmentActivity
        implements ForumActivityStatus, ActionBar.TabListener {
    public static final String BACKACTION = "back_action";
    public static String ENTRY_FLAG = "entry_flag";
    public static String OB_ADDACCOUNTS = "addaccounttonet";
    public static final int REQUEST_CODE_FOR_TWITTER_MIGRATION = 1001;
    public static final int RESULT_SETTING = 10;
    public static final int TAG_RESULT_SIGNOUT = 62057;
    public static final int TAG_SIGNOUT_TID = 9489;
    public static final String TWITTER_MIGRATION_TYPE = "migration_type";
    public static final int UPDATE_TAPATALKID = 1;
    public static final String VIEW_FROM_OUT_URL = "VIEW_FROM_OUT_URL";
    public static boolean isSignOut = false;
    public static String lastVisitKey = "lastvisittag";
    public static final int tag_explore = 2;
    public static final int tag_feed = 4;
    public static final int tag_forums = 1;
    int actionbarHeight;
    private ActionBar bar;
    public ExploreFragment categoryFragment;
    private RelativeLayout contentOuterLayout;
    int contentViewTop;
    private int currentPosition = -1;
    public FavForumsFragment favforumFragment;
    public FeedFragment feedFragment;
    public FeedSettingsFragment feedSettingsFragment;
    private boolean feedfirstTag;
    private ArrayList<String> forumIds = new ArrayList();
    private ForumStatus forumStatus;
    public ArrayList<QuoordFragment> frags = new ArrayList();
    private Handler handler = null;
    private FavoriateSqlHelper helper;
    private int hintPosition = 0;
    private TapatalkUnInstalledReceiver installedReceiver = new TapatalkUnInstalledReceiver();
    public boolean isNotification = false;
    private int lastVisitedTag = -1;
    private Activity mActivity;
    public DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private SectionsPagerAdapter mPagerAdapter;
    private TabHost mTabHost;
    public DisabledViewPager mViewPager;
    public boolean notification_register = false;
    private SharedPreferences prefs;
    ProgressDialog progressDialog;
    private int radius = 48;
    SearchManager searchManager;
    private MenuItem searchMenuItem;
    public Stack<QuoordFragment> searchStack = new Stack();
    private SearchView searchView;
    int statusBarHeight;
    private TapatalkId tapatalkId;
    private String tapatalkUserName = null;

    private void addAccounts() {
        checkHelper();
        ArrayList localArrayList = this.helper.getFavrivate();
        int i;
        if (localArrayList != null) {
            i = 0;
        }
        for (; ; ) {
            if (i >= localArrayList.size()) {
                return;
            }
            TapatalkJsonEngine.auAddAccount(this, ((TapatalkForum) localArrayList.get(i)).getId().intValue(), "Guest", null, "0", null, "onboarding", null);
            i += 1;
        }
    }

    private void changeShowView() {
        this.mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            public void onPageScrollStateChanged(int paramAnonymousInt) {
            }

            public void onPageScrolled(int paramAnonymousInt1, float paramAnonymousFloat, int paramAnonymousInt2) {
            }

            public void onPageSelected(int paramAnonymousInt) {
                if (AccountEntryActivity.this.getTagInPager(paramAnonymousInt) == 4) {
                    if ((AccountEntryActivity.this.favforumFragment != null) && (AccountEntryActivity.this.favforumFragment.mNetworkAdapter != null)) {
                        AccountEntryActivity.this.getFeeds(AccountEntryActivity.this.favforumFragment.mNetworkAdapter.getmDatas());
                    }
                    GoogleAnalyticsTools.trackPageView(AccountEntryActivity.this, "account_feed");
                }
                if (AccountEntryActivity.this.getTagInPager(paramAnonymousInt) == 2) {
                    GoogleAnalyticsTools.trackPageView(AccountEntryActivity.this, "tap_category");
                }
                if (AccountEntryActivity.this.getTagInPager(paramAnonymousInt) == 1) {
                    GoogleAnalyticsTools.trackPageView(AccountEntryActivity.this, "accounts");
                }
                if (AccountEntryActivity.this.favforumFragment != null) {
                    AccountEntryActivity.this.favforumFragment.clearActionMode();
                }
                AccountEntryActivity.this.initActionBar();
                AccountEntryActivity.this.invalidateOptionsMenu();
            }
        });
        if (this.lastVisitedTag > 0) {
            if (this.mTabHost != null) {
                this.mTabHost.setCurrentTab(this.lastVisitedTag);
            }
        }
        for (; ; ) {
            if (getCurrentTabTag() == 2) {
                GoogleAnalyticsTools.trackPageView(this, "tap_category");
            }
            updateAccounts();
            return;
            if (this.mTabHost != null) {
                this.mTabHost.setCurrentTab(4);
            }
        }
    }

    private void checkHelper() {
        if (this.helper == null) {
            this.helper = new FavoriateSqlHelper(this, TapatalkApp.database_name, null, Integer.parseInt(TapatalkApp.database_version));
        }
    }

    private void closeHint() {
        if (this.hintPosition == 0) {
            if (this.feedFragment != null) {
                this.feedFragment.closeHint(1);
            }
        }
        do {
            do {
                return;
                if (this.hintPosition != 1) {
                    break;
                }
            } while (this.categoryFragment == null);
            this.categoryFragment.closeHint(1);
            return;
        } while (this.favforumFragment == null);
        this.favforumFragment.closeHint(1);
    }

    private int getCurrentTabTag() {
        int i = 2;
        if (this.mViewPager != null) {
            int j = this.mViewPager.getCurrentItem();
            if (j == 0) {
                i = 4;
            }
            while (j == 1) {
                return i;
            }
            if (j == 2) {
                return 1;
            }
        }
        return -1;
    }

    private int getTagInPager(int paramInt) {
        int i = 2;
        if (paramInt == 0) {
            i = 4;
        }
        while (paramInt == 1) {
            return i;
        }
        if (paramInt == 2) {
            return 1;
        }
        return -1;
    }

    private void handleIntent(Intent paramIntent) {
        if ("android.intent.action.SEARCH".equals(paramIntent.getAction())) {
            String str = paramIntent.getStringExtra("query");
            Intent localIntent = new Intent(this, IcsSearchActivity.class);
            localIntent.putExtra("queryKeyword", str);
            startActivity(localIntent);
        }
        if ("android.intent.action.VIEW".equals(paramIntent.getAction())) {
            paramIntent.setClass(this, SlidingMenuActivity.class);
            paramIntent.putExtra("VIEW_FROM_OUT_URL", true);
            paramIntent.setFlags(67108864);
            startActivity(paramIntent);
        }
    }

    private void initGcm() {
        new InitGcmTool(this).initGcm();
    }

    private void initLastVisit() {
        String str = SettingsFragment.getAccountTabBehaviour(this);
        if (str.equals("3")) {
            this.lastVisitedTag = this.prefs.getInt(lastVisitKey, -1);
            return;
        }
        if (str.equals("0")) {
            this.lastVisitedTag = 2;
            this.currentPosition = 1;
            return;
        }
        if (str.equals("1")) {
            this.lastVisitedTag = 4;
            this.currentPosition = 0;
            return;
        }
        this.lastVisitedTag = 1;
        this.currentPosition = 2;
    }

    private void saveLastVisit() {
        SharedPreferences.Editor localEditor = this.prefs.edit();
        localEditor.putInt(lastVisitKey, getCurrentTabTag());
        localEditor.commit();
    }

    private void signOut() {
        if (this.prefs == null) {
            this.prefs = Prefs.get(this);
        }
        if (this.prefs.getInt("tapatalk_status_twitter_user", 0) == 1) {
            MigratioinDialogTool.showMigrationDialog(this);
            return;
        }
        Intent localIntent = new Intent();
        localIntent.setClass(this, ObEntryActivity.class);
        startActivity(localIntent);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                try {
                    Object localObject = Prefs.get(AccountEntryActivity.this);
                    ((SharedPreferences) localObject).edit().putInt("tapatalk_status_twitter_user", 0).commit();
                    Prefs.clearAccountTime(AccountEntryActivity.this.mActivity);
                    TapatalkAccountAction.cleanCurrenForums();
                    ((SharedPreferences) localObject).getString("handle", SignInWithOtherUtil.unknow);
                    AccountEntryActivity.isSignOut = true;
                    int i = AccountEntryActivity.this.tapatalkId.getAuid();
                    AccountEntryActivity.this.tapatalkId.signOut();
                    AccountEntryActivity.this.checkHelper();
                    localObject = AccountEntryActivity.this.helper.getFavrivate();
                    FavForumsFragment.clearAllSigninForums(AccountEntryActivity.this, (ArrayList) localObject, i);
                    AccountEntryActivity.this.helper.deleteAllFavoriate();
                    AccountEntryActivity.this.forumIds.clear();
                    Util.deleteAllWidget(AccountEntryActivity.this);
                    Util.deleteAllSignOutCache(AccountEntryActivity.this);
                    localObject = AppCacheManager.getCloudAccountUrl(AccountEntryActivity.this);
                    String str = AppCacheManager.getOrderUrl(AccountEntryActivity.this);
                    AppCacheManager.del((String) localObject);
                    AppCacheManager.del(str);
                    AccountEntryActivity.this.finish();
                    return;
                } catch (Exception localException) {
                }
            }
        }, 200L);
    }

    private void updateAccounts() {
        if ((this.favforumFragment != null) && (this.favforumFragment.mNetworkAdapter != null)) {
            this.favforumFragment.mNetworkAdapter.updatedata(false);
        }
    }

    public void closeProgress() {
        if ((this.progressDialog != null) && (this.progressDialog.isShowing())) {
            new Handler().post(new Runnable() {
                public void run() {
                    AccountEntryActivity.this.progressDialog.cancel();
                }
            });
        }
    }

    public void collapseSearchView() {
        if ((this.searchMenuItem != null) && (this.searchMenuItem.isVisible())) {
            this.searchMenuItem.collapseActionView();
        }
    }

    public void createSearchMenu(Menu paramMenu) {
        getMenuInflater().inflate(2131623941, paramMenu);
        this.searchMenuItem = paramMenu.findItem(2131231471);
        SearchManager localSearchManager = (SearchManager) getSystemService("search");
        this.searchView = ((SearchView) paramMenu.findItem(2131231471).getActionView());
        try {
            int i = getResources().getIdentifier("android:id/search_mag_icon", null, null);
            ((ImageView) this.searchView.findViewById(i)).setImageResource(2130838902);
            this.searchView.setSearchableInfo(localSearchManager.getSearchableInfo(getComponentName()));
            i = getResources().getIdentifier("android:id/search_plate", null, null);
            ((ViewGroup) this.searchView.findViewById(i)).setBackgroundResource(2130839292);
            i = this.searchView.getContext().getResources().getIdentifier("android:id/search_src_text", null, null);
            ((TextView) this.searchView.findViewById(i)).setTextSize(16.0F);
            this.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                public boolean onQueryTextChange(String paramAnonymousString) {
                    return true;
                }

                public boolean onQueryTextSubmit(String paramAnonymousString) {
                    Util.hideSoftKeyb(AccountEntryActivity.this, AccountEntryActivity.this.searchView);
                    new SearchRecentSuggestions(AccountEntryActivity.this, "com.quoord.tapatalkpro.activity.SearchSuggestionProvider", 1).saveRecentQuery(paramAnonymousString, null);
                    AccountEntryActivity.this.searchView.clearFocus();
                    Intent localIntent = new Intent(AccountEntryActivity.this, IcsSearchActivity.class);
                    localIntent.putExtra("queryKeyword", paramAnonymousString);
                    AccountEntryActivity.this.startActivity(localIntent);
                    return true;
                }
            });
            this.searchMenuItem.setOnActionExpandListener(new MenuItem.OnActionExpandListener() {
                public boolean onMenuItemActionCollapse(MenuItem paramAnonymousMenuItem) {
                    AccountEntryActivity.this.initActionBar();
                    return true;
                }

                public boolean onMenuItemActionExpand(MenuItem paramAnonymousMenuItem) {
                    AccountEntryActivity.this.bar.setIcon(2130837525);
                    return true;
                }
            });
            return;
        } catch (Exception paramMenu) {
            for (; ; ) {
            }
        }
    }

    public void createTabHost() {
        if (this.mTabHost != null) {
            this.mTabHost.setup();
            this.mTabHost.getTabWidget().setDividerDrawable(null);
        }
        if ((this.mViewPager != null) && (this.mTabHost != null)) {
            this.mViewPager.setOffscreenPageLimit(2);
            this.mPagerAdapter = new SectionsPagerAdapter(this, this.mTabHost, this.mViewPager);
        }
        String str1 = getString(2131100591).toUpperCase();
        String str2 = getString(2131099813).toUpperCase();
        this.mPagerAdapter.addTab1(this.mTabHost.newTabSpec(str1).setIndicator(str1), this.feedFragment, null);
        this.mPagerAdapter.addTab2(this.mTabHost.newTabSpec("explore").setIndicator("explore"), this.categoryFragment, null);
        this.mPagerAdapter.addTab3(this.mTabHost.newTabSpec(str2).setIndicator(str2), this.favforumFragment, null);
        if (this.mTabHost != null) {
            if (this.lastVisitedTag != 1) {
                break label212;
            }
            this.mTabHost.setCurrentTab(2);
            this.mDrawerLayout.setDrawerLockMode(1);
        }
        for (; ; ) {
            this.mTabHost.invalidate();
            this.mActivity.invalidateOptionsMenu();
            return;
            label212:
            if (this.lastVisitedTag == 2) {
                this.mTabHost.setCurrentTab(1);
                this.mDrawerLayout.setDrawerLockMode(1);
            } else if (this.lastVisitedTag == 4) {
                this.mTabHost.setCurrentTab(0);
                this.mDrawerLayout.setDrawerLockMode(0);
            }
        }
    }

    public Activity getDefaultActivity() {
        return this;
    }

    public void getFeeds(ArrayList<TapatalkForum> paramArrayList) {
        ArrayList localArrayList1 = new ArrayList();
        ArrayList localArrayList2 = new ArrayList();
        if (this.feedFragment != null) {
            if ((paramArrayList == null) || (paramArrayList.size() <= 0)) {
                break label300;
            }
            this.forumIds.clear();
            i = 0;
            if (i < paramArrayList.size()) {
                break label167;
            }
            i = this.prefs.getInt("entry_get_local_account_size", 0);
            if ((!this.feedfirstTag) || (this.forumIds.size() != i)) {
                this.feedFragment.setForumsList(this.forumIds);
                this.feedFragment.setUserList(localArrayList1);
                this.feedFragment.setmAllDatas(paramArrayList);
                this.feedFragment.setNotifiList(localArrayList2);
                this.feedFragment.refresh();
                this.feedfirstTag = true;
            }
            paramArrayList = this.prefs.edit();
            paramArrayList.putInt("entry_get_local_account_size", this.forumIds.size());
            paramArrayList.commit();
        }
        label167:
        label300:
        while (paramArrayList != null) {
            for (; ; ) {
                int i;
                return;
                if ((!this.forumIds.contains(((TapatalkForum) paramArrayList.get(i)).getId())) && (((TapatalkForum) paramArrayList.get(i)).isFeed())) {
                    this.forumIds.add(((TapatalkForum) paramArrayList.get(i)).getId());
                }
                localArrayList2.add(((TapatalkForum) paramArrayList.get(i)).getId());
                localArrayList1.add(((TapatalkForum) paramArrayList.get(i)).getUserId());
                i += 1;
            }
        }
        paramArrayList.size();
    }

    public ForumActivityStatus getForumActivityStatus() {
        return this;
    }

    public ForumStatus getForumStatus() {
        return this.forumStatus;
    }

    public ForumStatus getForumStatus(TapatalkForum paramTapatalkForum) {
        ForumStatus localForumStatus = new ForumStatus(this);
        localForumStatus.setLogin(true);
        localForumStatus.tapatalkForum = paramTapatalkForum;
        return localForumStatus;
    }

    public void initActionBar() {
        if (this.bar == null) {
            this.bar = getActionBar();
        }
        this.bar.show();
        this.bar.setDisplayShowTitleEnabled(true);
        this.prefs = Prefs.get(this);
        this.bar.setIcon(2130837525);
        if (this.currentPosition == 0) {
            this.bar.setTitle(getResources().getString(2131100930));
            return;
        }
        if (this.currentPosition == 1) {
            this.bar.setTitle(getResources().getString(2131100931));
            return;
        }
        this.bar.setTitle(getResources().getString(2131100932));
    }

    public void initOtherService() {
        getSharedPreferences("notificationsetting", 0).getBoolean(getResources().getString(2131100361), true);
        initGcm();
        if (AdsService.isAddon) {
            AdsService.init(this);
        }
        sendBroadcast(new Intent("com.tapatalk.reboot"));
        NotificationAlarmService.setupPings(this);
        FunctionConfig.startInitialize(this);
    }

    public void initView() {
        setContentView(2130903184);
        this.mDrawerLayout = ((DrawerLayout) findViewById(2131231099));
        FrameLayout localFrameLayout = (FrameLayout) findViewById(2131231151);
        this.contentOuterLayout = ((RelativeLayout) findViewById(2131231150));
        Util.showMenu(this);
        AppCacheManager.createCacheDir(this);
        this.mViewPager = ((DisabledViewPager) findViewById(2131231008));
        this.mTabHost = ((TabHost) findViewById(16908306));
        initActionBar();
        this.mDrawerToggle = new ActionBarDrawerToggle(this, this.mDrawerLayout, 2130838868, 0, 0) {
            public void onDrawerClosed(View paramAnonymousView) {
                super.onDrawerClosed(paramAnonymousView);
                if (AccountEntryActivity.this.prefs == null) {
                    AccountEntryActivity.this.prefs = Prefs.get(AccountEntryActivity.this);
                }
                if ((AccountEntryActivity.this.feedFragment != null) && (AccountEntryActivity.this.feedFragment.default_notification_num != AccountEntryActivity.this.prefs.getInt("default_notification_num", 5))) {
                    AccountEntryActivity.this.feedFragment.default_notification_num = AccountEntryActivity.this.prefs.getInt("default_notification_num", 5);
                    AccountEntryActivity.this.feedFragment.getNotifications();
                }
                paramAnonymousView = new ArrayList();
                boolean bool = false;
                int i;
                if ((AccountEntryActivity.this.feedSettingsFragment != null) && (AccountEntryActivity.this.feedSettingsFragment.forumListDatas != null)) {
                    i = 0;
                }
                for (; ; ) {
                    if (i >= AccountEntryActivity.this.feedSettingsFragment.forumListDatas.size()) {
                        bool = AccountEntryActivity.this.prefs.getBoolean("feedsettings_photosonly", false);
                        if ((AccountEntryActivity.this.feedFragment != null) && (AccountEntryActivity.this.feedFragment.getForumsList() != null) && ((!AccountEntryActivity.this.feedFragment.getForumsList().equals(paramAnonymousView)) || (bool != AccountEntryActivity.this.feedSettingsFragment.isShowPhotoOnly) || (AccountEntryActivity.this.feedFragment.getForumsList().size() > paramAnonymousView.size()))) {
                            AccountEntryActivity.this.feedFragment.setForumsList(paramAnonymousView);
                            AccountEntryActivity.this.feedFragment.getTrendingTopic();
                            AccountEntryActivity.this.feedFragment.page = 1;
                            AccountEntryActivity.this.feedFragment.autoRefreshFromSettings = true;
                            paramAnonymousView = AccountEntryActivity.this.prefs.edit();
                            paramAnonymousView.putBoolean("feedsettings_photosonly", AccountEntryActivity.this.feedSettingsFragment.isShowPhotoOnly);
                            paramAnonymousView.commit();
                        }
                        return;
                    }
                    if (AccountEntryActivity.this.prefs != null) {
                        bool = AccountEntryActivity.this.prefs.getBoolean(AccountEntryActivity.this.prefs.getInt("tapatalk_auid", -1) + "|" + ((FeedForum) AccountEntryActivity.this.feedSettingsFragment.forumListDatas.get(i)).getForumid(), true);
                    }
                    if ((((FeedForum) AccountEntryActivity.this.feedSettingsFragment.forumListDatas.get(i)).isFeed()) && (bool)) {
                        paramAnonymousView.add(((FeedForum) AccountEntryActivity.this.feedSettingsFragment.forumListDatas.get(i)).getForumid());
                    }
                    i += 1;
                }
            }

            public void onDrawerOpened(View paramAnonymousView) {
                super.onDrawerOpened(paramAnonymousView);
            }

            public void onDrawerSlide(View paramAnonymousView, float paramAnonymousFloat) {
                super.onDrawerSlide(paramAnonymousView, paramAnonymousFloat);
            }
        };
        this.mDrawerLayout.setDrawerListener(this.mDrawerToggle);
        this.mDrawerToggle.syncState();
        createTabHost();
        updateAccounts();
    }

    protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
        super.onActivityResult(paramInt1, paramInt2, paramIntent);
        if (paramInt1 == 1001) {
            if (paramIntent != null) {
                MigratioinDialogTool.showMigrationFinishDialog(this, paramIntent.getStringExtra("migration_type"));
            }
            if (this.favforumFragment != null) {
                this.favforumFragment.mNetworkAdapter.updatedata(true);
            }
        }
        if ((paramInt1 == 42716) || (paramInt1 == 9667)) {
            this.favforumFragment.onActivityResult(paramInt1, paramInt2, paramIntent);
        }
        if (paramInt2 == 62057) {
            signOut();
        }
    }

    public void onConfigurationChanged(Configuration paramConfiguration) {
        super.onConfigurationChanged(paramConfiguration);
        invalidateOptionsMenu();
    }

    protected void onCreate(Bundle paramBundle) {
        ThemeUtil.setTheme(this);
        this.bar = getActionBar();
        super.onCreate(paramBundle);
        this.mActivity = this;
        DebugModeUtil.opCrashEmial(this);
        this.tapatalkId = TapatalkIdFactory.getTapatalkId(this);
        Object localObject = new IntentFilter();
        ((IntentFilter) localObject).addAction("android.intent.action.PACKAGE_ADDED");
        ((IntentFilter) localObject).addAction("android.intent.action.PACKAGE_REMOVED");
        ((IntentFilter) localObject).addDataScheme("package");
        registerReceiver(this.installedReceiver, (IntentFilter) localObject);
        this.forumStatus = new ForumStatus(this);
        NotificationAlarmService.setupPings(this);
        this.prefs = Prefs.get(this);
        new RegisterTidAction(this);
        initLastVisit();
        if (getIntent().getBooleanExtra("fromOnboarding", false)) {
            this.lastVisitedTag = 4;
        }
        if (getIntent().getBooleanExtra("add_favoriate", false)) {
            this.lastVisitedTag = 4;
        }
        if (getIntent().getBooleanExtra("add_forum_action", false)) {
            this.lastVisitedTag = 4;
        }
        UmsAgent.setBaseURL("https://razor.tapatalk.com");
        UmsAgent.uploadLog1(this);
        if (getIntent().getIntExtra(ENTRY_FLAG, -1) != -1) {
            this.lastVisitedTag = getIntent().getIntExtra(ENTRY_FLAG, -1);
        }
        this.isNotification = this.prefs.getBoolean("isNotification", false);
        this.notification_register = this.prefs.getBoolean("notification_register", false);
        if ((this.isNotification) && (!this.notification_register)) {
            TapatalkJsonEngine.callLogin(this, TapatalkJsonEngine.REGISTER_TAPATALK_ID_LOG + "0&" + TapatalkApp.APP_KEY);
            localObject = this.prefs.edit();
            ((SharedPreferences.Editor) localObject).putBoolean("notification_register", this.notification_register);
            ((SharedPreferences.Editor) localObject).commit();
        }
        GoogleAnalyticsTools.trackEvent(this, "launch", "account");
        Util.logAppSession(this);
        UserBehavior.logFirstSession(this);
        checkHelper();
        if (getIntent().getBooleanExtra(OB_ADDACCOUNTS, false)) {
            addAccounts();
        }
        String str = getIntent().getStringExtra("scheme_intentAction");
        localObject = getIntent().getStringExtra("scheme_intentDatas");
        if ((str != null) && (str.equalsIgnoreCase("android.intent.action.VIEW")) && (localObject != null)) {
            getWindow().setFlags(1024, 1024);
            this.bar.hide();
            startApp(this.helper);
            paramBundle = new GetAccountBybyoAction(this, this.favforumFragment, "byo");
            paramBundle.parseByoAccountInfo((String) localObject);
            paramBundle.callGetAccount();
            return;
        }
        startApp(this.helper);
        if (TapatalkIdFactory.getTapatalkId(this).isHasAccounts()) {
            Util.showSettingsDialog(this);
        }
        if (paramBundle != null) {
            this.mTabHost.setCurrentTabByTag(paramBundle.getString("tab"));
        }
        this.mTabHost.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() {
            public void onViewAttachedToWindow(View paramAnonymousView) {
                AccountEntryActivity.this.mTabHost.getViewTreeObserver().removeOnTouchModeChangeListener(AccountEntryActivity.this.mTabHost);
            }

            public void onViewDetachedFromWindow(View paramAnonymousView) {
            }
        });
        initOtherService();
        new RateUsTool(this).showRateUsDialog();
        if (Prefs.get(this).getInt("tapatalk_status_twitter_user", 0) == 1) {
            MigratioinDialogTool.showMigrationDialog(this);
        }
        this.handler = new Handler() {
            public void handleMessage(Message paramAnonymousMessage) {
                super.handleMessage(paramAnonymousMessage);
                if (paramAnonymousMessage.what == 9489) {
                    AccountEntryActivity.this.signOut();
                }
            }
        };
    }

    public void onDestroy() {
        GCMRegistrar.onDestroy(this);
        saveLastVisit();
        ThreadPoolManager.stopThreadPoolMannager();
        if (this.installedReceiver != null) {
            unregisterReceiver(this.installedReceiver);
        }
        super.onDestroy();
    }

    public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent) {
        if (paramKeyEvent.getKeyCode() == 4) {
            if (this.mDrawerLayout.isDrawerVisible(2)) {
                this.mDrawerLayout.closeDrawers();
            }
            if (this.favforumFragment != null) {
                if (this.favforumFragment.clearActionMode()) {
                    return true;
                }
                return super.onKeyDown(paramInt, paramKeyEvent);
            }
        }
        return super.onKeyDown(paramInt, paramKeyEvent);
    }

    public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent) {
        paramKeyEvent.getKeyCode();
        return super.onKeyUp(paramInt, paramKeyEvent);
    }

    public void onNewIntent(Intent paramIntent) {
        super.onNewIntent(paramIntent);
        handleIntent(paramIntent);
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        if (paramMenuItem.getItemId() == 1071) {
            Intent localIntent = new Intent(this, TapatalkIdWebviewActivity.class);
            paramMenuItem = DirectoryUrlUtil.getManageAccountUrl(this);
            localIntent.putExtra("change_url", paramMenuItem);
            localIntent = new Intent("android.intent.action.VIEW");
            localIntent.setData(Uri.parse(paramMenuItem));
            startActivity(localIntent);
            return true;
        }
        if (paramMenuItem.getItemId() == 1070) {
            signOut();
            return true;
        }
        if (paramMenuItem.getItemId() == 1029) {
            paramMenuItem = new Intent(this, SettingsActivity.class);
            paramMenuItem.addFlags(67108864);
            startActivityForResult(paramMenuItem, 10);
            return true;
        }
        return super.onOptionsItemSelected(paramMenuItem);
    }

    public void onPause() {
        super.onPause();
        CustomTracker.comScorePause(this);
        Prefs.closeHint(this);
    }

    public boolean onPrepareOptionsMenu(Menu paramMenu) {
        paramMenu.removeGroup(0);
        initActionBar();
        if (this.mViewPager == null) {
        }
        for (int i = 0; ; i = this.mViewPager.getCurrentItem()) {
            switch (i) {
                default:
                    return true;
            }
        }
        createSearchMenu(paramMenu);
        return true;
        paramMenu.add(0, 1001, 1, getString(2131099796)).setIcon(ThemeUtil.getMenuIconByPicName("menu_refresh_new", this)).setShowAsAction(2);
        paramMenu.add(0, 6000, 1, getString(2131100676)).setIcon(ThemeUtil.getMenuIconByPicName("feed_settings_icon", this)).setShowAsAction(2);
        return true;
        paramMenu.add(0, 1029, 1, getString(2131100217)).setIcon(ThemeUtil.getMenuIconByPicName("ic_setting_new", this)).setShowAsAction(2);
        return true;
    }

    protected void onResume() {
        super.onResume();
        collapseSearchView();
        CustomTracker.comScoreResume(this);
    }

    protected void onSaveInstanceState(Bundle paramBundle) {
        super.onSaveInstanceState(paramBundle);
    }

    protected void onStart() {
        super.onStart();
        CustomTracker.start(this);
    }

    public void onStop() {
        super.onStop();
        CustomTracker.stop(this);
    }

    public void onTabReselected(ActionBar.Tab paramTab, android.app.FragmentTransaction paramFragmentTransaction) {
    }

    public void onTabSelected(ActionBar.Tab paramTab, android.app.FragmentTransaction paramFragmentTransaction) {
        if (this.mViewPager.getCurrentItem() != paramTab.getPosition()) {
            this.mViewPager.setCurrentItem(paramTab.getPosition(), false);
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
                    AccountEntryActivity.this.progressDialog.show();
                }
            });
        }
    }

    public void showProgress(String paramString) {
    }

    public void startApp(FavoriateSqlHelper paramFavoriateSqlHelper) {
        getWindow().clearFlags(1024);
        initView();
    }

    public void updateDialog(int paramInt) {
    }

    public void updateFeedSettings(ArrayList<TapatalkForum> paramArrayList) {
        Object localObject = paramArrayList;
        if (paramArrayList == null) {
            localObject = new ArrayList();
        }
        if (this.feedSettingsFragment == null) {
            this.feedSettingsFragment = FeedSettingsFragment.newInstance((ArrayList) localObject);
        }
        this.feedSettingsFragment.setUpdate(this, (ArrayList) localObject);
        try {
            getSupportFragmentManager().beginTransaction().replace(2131231151, this.feedSettingsFragment).commitAllowingStateLoss();
            return;
        } catch (Exception paramArrayList) {
        }
    }

    public void updateUI(int paramInt, Object paramObject) {
    }

    public void updateUI(String paramString) {
    }

    public class SectionsPagerAdapter
            extends FragmentStatePagerAdapter
            implements TabHost.OnTabChangeListener, ViewPager.OnPageChangeListener {
        private final Context mContext;
        private final TabHost mTabHost;
        public final ArrayList<TabInfo> mTabs = new ArrayList();
        private final ViewPager mViewPager;

        public SectionsPagerAdapter(FragmentActivity paramFragmentActivity, TabHost paramTabHost, ViewPager paramViewPager) {
            super();
            this.mContext = paramFragmentActivity;
            this.mTabHost = paramTabHost;
            this.mViewPager = paramViewPager;
            this.mTabHost.setOnTabChangedListener(this);
            this.mViewPager.setAdapter(this);
            this.mViewPager.setOnPageChangeListener(this);
        }

        public void addTab1(TabHost.TabSpec paramTabSpec, Fragment paramFragment, Bundle paramBundle) {
            paramTabSpec.setContent(new DummyTabFactory(this.mContext));
            TabsUtil4.setTabIndicator(paramTabSpec, Util.prepareFeedImageView((Activity) this.mContext));
            paramFragment = new TabInfo(paramTabSpec.getTag(), paramFragment, paramBundle);
            this.mTabs.add(paramFragment);
            this.mTabHost.addTab(paramTabSpec);
            notifyDataSetChanged();
        }

        public void addTab2(TabHost.TabSpec paramTabSpec, Fragment paramFragment, Bundle paramBundle) {
            paramTabSpec.setContent(new DummyTabFactory(this.mContext));
            TabsUtil4.setTabIndicator(paramTabSpec, Util.prepareExploerImageView((Activity) this.mContext));
            paramFragment = new TabInfo(paramTabSpec.getTag(), paramFragment, paramBundle);
            this.mTabs.add(paramFragment);
            this.mTabHost.addTab(paramTabSpec);
            notifyDataSetChanged();
        }

        public void addTab3(TabHost.TabSpec paramTabSpec, Fragment paramFragment, Bundle paramBundle) {
            paramTabSpec.setContent(new DummyTabFactory(this.mContext));
            TabsUtil4.setTabIndicator(paramTabSpec, Util.prepareProfilesImageView((Activity) this.mContext));
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
                    AccountEntryActivity.this.feedFragment = FeedFragment.newInstance(new ArrayList(), false);
                    return AccountEntryActivity.this.feedFragment;
                case 1:
                    AccountEntryActivity.this.categoryFragment = new ExploreFragment();
                    return AccountEntryActivity.this.categoryFragment;
            }
            AccountEntryActivity.this.favforumFragment = new FavForumsFragment();
            return AccountEntryActivity.this.favforumFragment;
        }

        public void onPageScrollStateChanged(int paramInt) {
        }

        public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {
            AccountEntryActivity.this.mActivity.invalidateOptionsMenu();
        }

        public void onPageSelected(int paramInt) {
            AccountEntryActivity.this.currentPosition = paramInt;
            if (AccountEntryActivity.this.currentPosition == 0) {
                AccountEntryActivity.this.mDrawerLayout.setDrawerLockMode(0);
                if ((AccountEntryActivity.this.favforumFragment == null) || (AccountEntryActivity.this.favforumFragment.mNetworkAdapter == null)) {
                    break label245;
                }
                AccountEntryActivity.this.getFeeds(AccountEntryActivity.this.favforumFragment.mNetworkAdapter.getmDatas());
            }
            for (; ; ) {
                GoogleAnalyticsTools.trackPageView(AccountEntryActivity.this, "account_feed");
                if (AccountEntryActivity.this.currentPosition == 1) {
                    AccountEntryActivity.this.mDrawerLayout.setDrawerLockMode(1);
                    GoogleAnalyticsTools.trackPageView(AccountEntryActivity.this, "tap_category");
                }
                if (AccountEntryActivity.this.currentPosition == 2) {
                    AccountEntryActivity.this.mDrawerLayout.setDrawerLockMode(1);
                    GoogleAnalyticsTools.trackPageView(AccountEntryActivity.this, "accounts");
                }
                if (AccountEntryActivity.this.favforumFragment != null) {
                    AccountEntryActivity.this.favforumFragment.clearActionMode();
                }
                if ((paramInt == 1) && (AccountEntryActivity.this.searchView != null)) {
                    AccountEntryActivity.this.searchView.setIconifiedByDefault(false);
                }
                AccountEntryActivity.this.initActionBar();
                AccountEntryActivity.this.invalidateOptionsMenu();
                try {
                    TabWidget localTabWidget = this.mTabHost.getTabWidget();
                    int i = localTabWidget.getDescendantFocusability();
                    localTabWidget.setDescendantFocusability(393216);
                    this.mTabHost.setCurrentTab(paramInt);
                    this.mViewPager.setOffscreenPageLimit(2);
                    localTabWidget.setDescendantFocusability(i);
                    return;
                } catch (Exception localException) {
                    label245:
                    localException.printStackTrace();
                }
                if (AccountEntryActivity.this.feedFragment != null) {
                    AccountEntryActivity.this.getFeeds(TapatalkAccountAction.getCurrnentAllAccount(this.mContext));
                } else {
                    AccountEntryActivity.this.feedFragment = FeedFragment.newInstance(new ArrayList(), false);
                }
            }
        }

        public void onTabChanged(String paramString) {
            if ((this.mTabHost != null) && (this.mViewPager != null)) {
                AccountEntryActivity.this.closeHint();
                int i = this.mTabHost.getCurrentTab();
                AccountEntryActivity.this.hintPosition = i;
                this.mViewPager.setCurrentItem(i, false);
            }
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


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/activity/directory/ics/AccountEntryActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */