package com.quoord.tapatalkpro.ics.slidingMenu;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.app.Dialog;
import android.app.NotificationManager;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.view.Display;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.webkit.WebView;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.HitBuilders.AppViewBuilder;
import com.google.android.gms.analytics.Tracker;
import com.quoord.tapatalkpro.TapatalkApp;
import com.quoord.tapatalkpro.action.ForumConfigAction;
import com.quoord.tapatalkpro.action.ForumConfigAction.ActionCallBack;
import com.quoord.tapatalkpro.action.ForumConfigHelper;
import com.quoord.tapatalkpro.action.ForumLoginOrSignAction;
import com.quoord.tapatalkpro.action.ForumLoginOrSignAction.ActionCallBack;
import com.quoord.tapatalkpro.action.ForumLoginOrSignAction.ActionFoceViewAThread;
import com.quoord.tapatalkpro.action.GetInboxStat;
import com.quoord.tapatalkpro.action.Logout;
import com.quoord.tapatalkpro.action.RebrandingChecker;
import com.quoord.tapatalkpro.action.log.LogNewSession;
import com.quoord.tapatalkpro.activity.directory.ics.AccountEntryActivity;
import com.quoord.tapatalkpro.activity.directory.ics.IcsRebrandingEntryActivity;
import com.quoord.tapatalkpro.activity.forum.CreatePmActivity;
import com.quoord.tapatalkpro.activity.forum.DrawerLayoutStatus;
import com.quoord.tapatalkpro.activity.forum.ForumActivityStatus;
import com.quoord.tapatalkpro.activity.forum.PMContentActivity;
import com.quoord.tapatalkpro.activity.forum.ProfilesActivity;
import com.quoord.tapatalkpro.activity.forum.ProfilesOuterFragment;
import com.quoord.tapatalkpro.activity.forum.ThreadActivity;
import com.quoord.tapatalkpro.activity.forum.ThreadOuterFragment;
import com.quoord.tapatalkpro.activity.forum.conversation.ConverSationActivity;
import com.quoord.tapatalkpro.activity.forum.conversation.CreateOrReplyConversationActivity;
import com.quoord.tapatalkpro.activity.forum.moderation.ModerateFragment;
import com.quoord.tapatalkpro.adapter.forum.ForumRootAdapter;
import com.quoord.tapatalkpro.adapter.forum.LatestTopicAdapter;
import com.quoord.tapatalkpro.adapter.forum.SubForumAdapter;
import com.quoord.tapatalkpro.adapter.forum.TopicAdapter;
import com.quoord.tapatalkpro.adapter.forum.moderation.ModerateAdapter;
import com.quoord.tapatalkpro.ads.AdsService;
import com.quoord.tapatalkpro.alarm.notification.BaseNotification;
import com.quoord.tapatalkpro.bean.Conversation;
import com.quoord.tapatalkpro.bean.Forum;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.bean.PrivateMessage;
import com.quoord.tapatalkpro.bean.RebrandingConfig;
import com.quoord.tapatalkpro.bean.TapatalkForum;
import com.quoord.tapatalkpro.bean.TapatalkId;
import com.quoord.tapatalkpro.bean.Topic;
import com.quoord.tapatalkpro.cache.AppCacheManager;
import com.quoord.tapatalkpro.cache.ForumCookiesCache;
import com.quoord.tapatalkpro.cache.ForumStatusCache;
import com.quoord.tapatalkpro.commonvalue.IntentValue;
import com.quoord.tapatalkpro.dev.DebugModeUtil;
import com.quoord.tapatalkpro.ics.BaseListFragment;
import com.quoord.tapatalkpro.ics.advancesearch.AdvanceSearchFragment;
import com.quoord.tapatalkpro.ics.advancesearch.AdvanceSearchHistoryFragment;
import com.quoord.tapatalkpro.ics.forum.ForumListFragment;
import com.quoord.tapatalkpro.ics.forum.SubForumFragment;
import com.quoord.tapatalkpro.ics.slidingMenu.login.PrefetchAccountInfo;
import com.quoord.tapatalkpro.ics.slidingMenu.login.action.PrefetchAccoutAction;
import com.quoord.tapatalkpro.ics.slidingMenu.login.action.PrefetchAccoutAction.ActionCallBack;
import com.quoord.tapatalkpro.ics.tapatalkid.TapatalkIdFactory;
import com.quoord.tapatalkpro.ics.topics.TopicsFragment;
import com.quoord.tapatalkpro.sqlhelper.FavoriateSqlHelper;
import com.quoord.tapatalkpro.ui.ics.IQuoordInterface;
import com.quoord.tapatalkpro.ui.ics.QuoordFragment;
import com.quoord.tapatalkpro.util.BroadcastControl;
import com.quoord.tapatalkpro.util.CustomTracker;
import com.quoord.tapatalkpro.util.ForumUrlUtil;
import com.quoord.tapatalkpro.util.Prefs;
import com.quoord.tapatalkpro.util.RebrandingUtil;
import com.quoord.tapatalkpro.util.ThemeUtil;
import com.quoord.tapatalkpro.util.Util;
import com.quoord.tools.TwoPanelController;
import com.quoord.tools.TwoPanelOutController;
import com.quoord.tools.UserBehavior;
import com.quoord.tools.tracking.GoogleAnalyticsTools;
import com.wbtech.ums.UmsAgent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class SlidingMenuActivity
        extends FragmentActivity
        implements ForumActivityStatus, DrawerLayoutStatus, TwoPanelOutController {
    public static final String ADVANCEFRAGMENTSTACK = "advance_fragment_stack_tag";
    public static final String ALLFORUMSTACK = "all_forum_statck_tag";
    public static final String BLOGFRAGMENTSTACK = "blogs_fragment_stack_tag";
    public static final String BYOSUBFORUMSTACK = "byo_subforum_statck_tag";
    public static String CATOGORIES_FORUM_ID = "open_categories";
    public static final String FEEDFORUMSTACK = "feed_forum_stack_tag";
    public static final String LOGINFRAGMENTSTACK = "login_fragment_stack_tag";
    public static final int REGISTER_CODE = 1;
    public static final int REGISTER_REQUST = 3;
    public static final int SIGN_CODE = 2;
    public static final String SUBSCRIBEFORUMSTACK = "subscribe_forum_statck_tag";
    public static final String SUBSCRIBETOPICSTACK = "subscribe_topic_statck_tag";
    public static final Stack<QuoordFragment> blogsFragmentStack = new Stack();
    public static final Stack<QuoordFragment> byosubFragmentStack = new Stack();
    public static final Stack<QuoordFragment> feedForumStack = new Stack();
    public static boolean needRefreshCategories;
    public static boolean needRefreshSubscribe = false;
    public static Topic topic;
    public PrefetchAccountInfo accountInfo;
    public boolean add_favoriate;
    public Stack<QuoordFragment> advanceFragmentStack = new Stack();
    public Stack<QuoordFragment> allForumStack = new Stack();
    public ActionBar bar;
    private BroadcastControl broadcastControl;
    public String channel;
    public IQuoordInterface currentFragment = null;
    public int currentTabMenuId = 0;
    public int defaultMenuId;
    private String forumId;
    public ForumStatus forumStatus;
    public View fragmentDetail;
    private View fragmentLayout;
    @SuppressLint({"UseSparseArrays"})
    public HashMap<Integer, IQuoordInterface> fragmentMap = new HashMap();
    private boolean isFromShortcut = false;
    private boolean isFromWidget = false;
    public boolean isGoFeed;
    public boolean isHide_addFavoriate_view;
    private boolean isNotification = false;
    private boolean isOpenSubForumFromPostUrl;
    public boolean isShare;
    public Stack<QuoordFragment> loginFragmentStack = new Stack();
    private ForumLoginOrSignAction loginOrSignAction;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private Fragment mFrag;
    Menu mMenu;
    private RelativeLayout mMenuLayout;
    private Handler mUIhandler = new Handler() {
        public void handleMessage(Message paramAnonymousMessage) {
            if (35 == paramAnonymousMessage.what) {
                Util.showToastForLong(SlidingMenuActivity.this, (String) paramAnonymousMessage.obj);
            }
            while (13 != paramAnonymousMessage.what) {
                return;
            }
            SlidingMenuActivity.this.closeProgress();
        }
    };
    public boolean needLogSign = false;
    public Fragment outerFragment;
    public IQuoordInterface profilesCurrentFragment;
    private Conversation pushConv;
    private int pushCount;
    private int pushFid;
    private TapatalkForum pushForum;
    private String pushForumId;
    private PrivateMessage pushPM;
    private String pushPostId;
    private String pushSpkey;
    private Topic pushTopic;
    public TapatalkForum shareForum;
    private String shortcutURL = null;
    private boolean shouldLogin;
    public Forum subscirbeForum = null;
    public Stack<QuoordFragment> subscribeForumStack = new Stack();
    public Stack<QuoordFragment> subscribeTopicStack = new Stack();
    private TapatalkId tapatalkId;
    private boolean viewConvos = false;
    public boolean viewFromOutUrl = false;
    private boolean viewQuote = false;
    private boolean viewlike = false;
    private boolean viewpm = false;
    private boolean viewsubscribe = false;
    private String widgetConvId;
    private int widgetReplyCount;
    private String widgetTopicId;
    private String widgetTopicTitle;
    private boolean writeConversation = false;
    private boolean writePm = false;

    static {
        needRefreshCategories = false;
    }

    private void initMenuGroupTwo(Menu paramMenu) {
        if (paramMenu != null) {
            paramMenu.removeGroup(0);
            if (getForumStatus().isLogin()) {
                MenuItem localMenuItem;
                if (paramMenu.findItem(2001) == null) {
                    localMenuItem = paramMenu.add(9, 2001, 0, getString(2131100561));
                    localMenuItem.setShowAsAction(2);
                    localMenuItem.setIcon(ThemeUtil.getMenuIconByPicName("drawer_menu_profile", this));
                }
                if (paramMenu.findItem(2002) == null) {
                    localMenuItem = paramMenu.add(9, 2002, 0, getString(2131100562));
                    localMenuItem.setShowAsAction(2);
                    localMenuItem.setIcon(ThemeUtil.getMenuIconByPicName("drawer_menu_logout", this));
                }
            }
            if (paramMenu.findItem(2000) == null) {
                paramMenu = paramMenu.add(9, 2000, 0, getString(2131100560));
                paramMenu.setShowAsAction(2);
                paramMenu.setIcon(ThemeUtil.getMenuIconByPicName("notification_setting", this));
            }
        }
    }

    private boolean isDrawerIndicatorEnabled() {
        if (this.currentTabMenuId == 1018) {
            if (this.allForumStack.size() <= 1) {
            }
        } else {
            do {
                return false;
                if (this.currentTabMenuId != 1019) {
                    break;
                }
            } while (this.subscribeForumStack.size() > 1);
        }
        do {
            do {
                do {
                    do {
                        do {
                            return true;
                            if (this.currentTabMenuId != 1036) {
                                break;
                            }
                        } while (this.subscribeTopicStack.size() <= 1);
                        return false;
                        if (this.currentTabMenuId != 1027) {
                            break;
                        }
                    } while (this.loginFragmentStack.size() <= 1);
                    return false;
                    if (this.currentTabMenuId != 1011) {
                        break;
                    }
                } while (this.advanceFragmentStack.size() <= 1);
                return false;
                if (this.currentTabMenuId != 1201) {
                    break;
                }
            } while (blogsFragmentStack.size() <= 1);
            return false;
        } while ((this.currentTabMenuId != 2002) || (feedForumStack.size() <= 1));
        return false;
    }

    private void normalUserLogin() {
        this.loginOrSignAction.loginForum(this.forumStatus.tapatalkForum.getUserNameOrDisplayName(), this.forumStatus.tapatalkForum.getPassword(), true, false, false, false, new ForumLoginOrSignAction.ActionCallBack()
        new ForumLoginOrSignAction.ActionFoceViewAThread
        {
            public void actionErrorBack (String paramAnonymousString1, String paramAnonymousString2)
            {
                SlidingMenuActivity.this.closeProgress();
                SlidingMenuActivity.this.showLoginView();
            }

        public void actionSuccessBack (ForumStatus paramAnonymousForumStatus)
        {
            AdsService.initBaner(SlidingMenuActivity.this, 2, paramAnonymousForumStatus.tapatalkForum.getId().intValue(), paramAnonymousForumStatus);
            SlidingMenuActivity.this.closeProgress();
            SlidingMenuActivity.this.clearStack();
            SlidingMenuActivity.this.showView();
            SlidingMenuActivity.this.getUnreadNumbers();
            paramAnonymousForumStatus.tapatalkForum.setCurrentUserSso(false);
        }
        },new ForumLoginOrSignAction.ActionFoceViewAThread() {
            public void actionViewThread(String paramAnonymousString) {
                Intent localIntent = new Intent(SlidingMenuActivity.this, ThreadActivity.class);
                localIntent.putExtra("forumStatus", SlidingMenuActivity.this.forumStatus);
                localIntent.putExtra("topic_id", paramAnonymousString);
                localIntent.putExtra(IntentValue.FORCE_VIEW_THREAD, true);
                SlidingMenuActivity.this.startActivity(localIntent);
            }
        });
    }

    private void setDrawerToggle() {
        try {
            if (!getIntent().getBooleanExtra("isShare", false)) {
            }
            for (this.mDrawerToggle = new ActionBarDrawerToggle(this, this.mDrawerLayout, ThemeUtil.getDrawableIdByPicName("ic_drawer", this), 0, 0) {
                private float lasetOffset = 0.0F;

                public void onDrawerClosed(View paramAnonymousView) {
                    SlidingMenuActivity.this.invalidateOptionsMenu();
                    this.lasetOffset = 0.0F;
                }

                public void onDrawerOpened(View paramAnonymousView) {
                    SlidingMenuActivity.this.invalidateOptionsMenu();
                    this.lasetOffset = 1.0F;
                }

                public void onDrawerSlide(View paramAnonymousView, float paramAnonymousFloat) {
                    super.onDrawerSlide(paramAnonymousView, paramAnonymousFloat);
                    if (paramAnonymousFloat > this.lasetOffset) {
                        if ((SlidingMenuActivity.this.currentFragment instanceof AdvanceSearchHistoryFragment)) {
                            ((AdvanceSearchHistoryFragment) SlidingMenuActivity.this.currentFragment).hideKeyBoard();
                            SlidingMenuActivity.this.mMenu.setGroupVisible(0, false);
                            SlidingMenuActivity.this.mMenu.setGroupVisible(9, true);
                        }
                    }
                    for (; ; ) {
                        SlidingMenuActivity.this.invalidateOptionsMenu();
                        this.lasetOffset = paramAnonymousFloat;
                        return;
                        if ((SlidingMenuActivity.this.currentFragment instanceof ForumListFragment)) {
                            ((ForumListFragment) SlidingMenuActivity.this.currentFragment).hideKeyBoard();
                            break;
                        }
                        if (!(SlidingMenuActivity.this.currentFragment instanceof SubForumFragment)) {
                            break;
                        }
                        ((SubForumFragment) SlidingMenuActivity.this.currentFragment).hideKeyBoard();
                        break;
                        if ((paramAnonymousFloat < this.lasetOffset) && (paramAnonymousFloat == 0.0D)) {
                            SlidingMenuActivity.this.mMenu.setGroupVisible(9, false);
                            SlidingMenuActivity.this.mMenu.setGroupVisible(0, true);
                        }
                    }
                }
            }; ; this.mDrawerToggle = new ActionBarDrawerToggle(this, this.mDrawerLayout, 2130838863, 0, 0)) {
                this.mDrawerLayout.setDrawerListener(this.mDrawerToggle);
                this.mDrawerToggle.syncState();
                getActionBar().setDisplayHomeAsUpEnabled(true);
                getActionBar().setHomeButtonEnabled(true);
                return;
            }
            return;
        } catch (Exception localException) {
        }
    }

    private void ssoUserLogin() {
        this.loginOrSignAction.signForum(this.forumStatus.tapatalkForum.getUserNameOrDisplayName(), null, true, true, false, false, new ForumLoginOrSignAction.ActionCallBack()
        new ForumLoginOrSignAction.ActionFoceViewAThread
        {
            public void actionErrorBack (String paramAnonymousString1, String paramAnonymousString2)
            {
                SlidingMenuActivity.this.closeProgress();
                SlidingMenuActivity.this.showLoginView();
            }

        public void actionSuccessBack (ForumStatus paramAnonymousForumStatus)
        {
            AdsService.initBaner(SlidingMenuActivity.this, 2, paramAnonymousForumStatus.tapatalkForum.getId().intValue(), paramAnonymousForumStatus);
            SlidingMenuActivity.this.closeProgress();
            SlidingMenuActivity.this.clearStack();
            SlidingMenuActivity.this.showView();
            SlidingMenuActivity.this.getUnreadNumbers();
            paramAnonymousForumStatus.tapatalkForum.setCurrentUserSso(true);
        }
        },new ForumLoginOrSignAction.ActionFoceViewAThread() {
            public void actionViewThread(String paramAnonymousString) {
                Intent localIntent = new Intent(SlidingMenuActivity.this, ThreadActivity.class);
                localIntent.putExtra("forumStatus", SlidingMenuActivity.this.forumStatus);
                localIntent.putExtra("topic_id", paramAnonymousString);
                localIntent.putExtra(IntentValue.FORCE_VIEW_THREAD, true);
                SlidingMenuActivity.this.startActivity(localIntent);
            }
        });
    }

    private void startLogin() {
        if (this.forumStatus.loginExpire) {
            new ForumConfigAction(this, this.forumStatus).getConfig(new ForumConfigAction.ActionCallBack() {
                public void actionErrorBack(String paramAnonymousString) {
                    SlidingMenuActivity.this.closeProgress();
                    AppCacheManager.clearForumCache(SlidingMenuActivity.this, SlidingMenuActivity.this.forumStatus.getUrl());
                    if ((paramAnonymousString != null) && (!paramAnonymousString.equals(""))) {
                        Toast.makeText(SlidingMenuActivity.this, paramAnonymousString, 1).show();
                    }
                    SlidingMenuActivity.this.finish();
                }

                public void actionSuccessBack(ForumStatus paramAnonymousForumStatus) {
                    SlidingMenuActivity.this.forumStatus = paramAnonymousForumStatus;
                    if (Util.isSignOutUser(SlidingMenuActivity.this, SlidingMenuActivity.this.forumStatus.tapatalkForum)) {
                        SlidingMenuActivity.this.showUnSignedView();
                        return;
                    }
                    SlidingMenuActivity.this.loginOrSignAction = new ForumLoginOrSignAction(SlidingMenuActivity.this, SlidingMenuActivity.this.forumStatus);
                    if (((SlidingMenuActivity.this.forumStatus.isSsoSign()) || (SlidingMenuActivity.this.forumStatus.isSsoLogin())) && (SlidingMenuActivity.this.forumStatus.tapatalkForum.getUserName() != null) && (SlidingMenuActivity.this.forumStatus.tapatalkForum.getUserName().length() > 0) && (!SlidingMenuActivity.this.forumStatus.tapatalkForum.hasPassword())) {
                        SlidingMenuActivity.this.ssoUserLogin();
                        return;
                    }
                    if ((SlidingMenuActivity.this.forumStatus.tapatalkForum.getUserName() != null) && (SlidingMenuActivity.this.forumStatus.tapatalkForum.getUserName().length() > 0) && (SlidingMenuActivity.this.forumStatus.tapatalkForum.hasPassword())) {
                        SlidingMenuActivity.this.normalUserLogin();
                        return;
                    }
                    SlidingMenuActivity.this.showUnSignedView();
                    SlidingMenuActivity.this.forumStatus.tapatalkForum.setCurrentUserSso(false);
                }
            });
        }
        for (; ; ) {
            return;
            AdsService.initBaner(this, 2, this.forumStatus.tapatalkForum.getId().intValue(), this.forumStatus);
            if (this.defaultMenuId == 0) {
                showView();
            }
            while (this.forumStatus.isLogin()) {
                getUnreadNumbers();
                return;
                showSelectView(this.defaultMenuId);
            }
        }
    }

    public void addFragmentToStack(IQuoordInterface paramIQuoordInterface, String paramString, boolean paramBoolean) {
        if (paramString.equals("all_forum_statck_tag")) {
            this.allForumStack.push((QuoordFragment) paramIQuoordInterface);
        }
        for (; ; ) {
            showToFront(paramIQuoordInterface, paramBoolean);
            return;
            if (paramString.equals("subscribe_forum_statck_tag")) {
                this.subscribeForumStack.push((QuoordFragment) paramIQuoordInterface);
            } else if (paramString.equals("login_fragment_stack_tag")) {
                this.loginFragmentStack.push((QuoordFragment) paramIQuoordInterface);
            } else if (paramString.equals("advance_fragment_stack_tag")) {
                this.advanceFragmentStack.push((QuoordFragment) paramIQuoordInterface);
            } else if (paramString.equals("blogs_fragment_stack_tag")) {
                blogsFragmentStack.push((QuoordFragment) paramIQuoordInterface);
            } else if (paramString.equals("byo_subforum_statck_tag")) {
                byosubFragmentStack.push((QuoordFragment) paramIQuoordInterface);
            } else if (paramString.equals("subscribe_topic_statck_tag")) {
                this.subscribeTopicStack.push((QuoordFragment) paramIQuoordInterface);
            } else if (paramString.equals("feed_forum_stack_tag")) {
                feedForumStack.push((QuoordFragment) paramIQuoordInterface);
            }
        }
    }

    public void backStack(boolean paramBoolean) {
        if (!this.mDrawerLayout.isDrawerOpen(this.mMenuLayout)) {
            if (this.currentTabMenuId == 1018) {
                if (this.allForumStack.size() > 1) {
                    if (this.fragmentDetail.getVisibility() == 0) {
                        setBackStackAnimation(this.outerFragment);
                        return;
                    }
                    this.allForumStack.pop();
                    showToFront((BaseListFragment) this.allForumStack.peek(), false);
                    return;
                }
                if (paramBoolean) {
                    clearStackAndFinish();
                    return;
                }
                toggle();
                return;
            }
            if (this.currentTabMenuId == 1019) {
                if (this.subscribeForumStack.size() > 1) {
                    if (this.fragmentDetail.getVisibility() == 0) {
                        setBackStackAnimation(this.outerFragment);
                        return;
                    }
                    this.subscribeForumStack.pop();
                    showToFront((BaseListFragment) this.subscribeForumStack.peek(), false);
                    return;
                }
                setBackStackType(paramBoolean);
                return;
            }
            if (this.currentTabMenuId == 1036) {
                if (this.subscribeTopicStack.size() > 1) {
                    this.subscribeTopicStack.pop();
                    showToFront((BaseListFragment) this.subscribeTopicStack.peek(), false);
                    return;
                }
                if (paramBoolean) {
                    clearStackAndFinish();
                    return;
                }
                toggle();
                return;
            }
            if (this.currentTabMenuId == 1027) {
                if (this.loginFragmentStack.size() > 1) {
                    this.loginFragmentStack.pop();
                    showToFront((QuoordFragment) this.loginFragmentStack.peek(), false);
                    return;
                }
                if (paramBoolean) {
                    clearStackAndFinish();
                    return;
                }
                toggle();
                return;
            }
            if (this.currentTabMenuId == 1011) {
                if (this.advanceFragmentStack.size() > 1) {
                    if (this.fragmentDetail.getVisibility() == 0) {
                        setBackStackAnimation(this.outerFragment);
                        return;
                    }
                    this.advanceFragmentStack.pop();
                    showToFront((QuoordFragment) this.advanceFragmentStack.peek(), false);
                    return;
                }
                setBackStackType(paramBoolean);
                return;
            }
            if (this.currentTabMenuId == 1201) {
                if (blogsFragmentStack.size() > 1) {
                    if (this.fragmentDetail.getVisibility() == 0) {
                        setBackStackAnimation(this.outerFragment);
                        return;
                    }
                    blogsFragmentStack.pop();
                    showToFront((QuoordFragment) blogsFragmentStack.peek(), false);
                    return;
                }
                setBackStackType(paramBoolean);
                return;
            }
            if (this.currentTabMenuId == 2002) {
                if (feedForumStack.size() > 1) {
                    if (this.fragmentDetail.getVisibility() == 0) {
                        setBackStackAnimation(this.outerFragment);
                        return;
                    }
                    feedForumStack.pop();
                    showToFront((QuoordFragment) feedForumStack.peek(), false);
                    return;
                }
                setBackStackType(paramBoolean);
                return;
            }
            if (this.currentTabMenuId == 0) {
                clearStackAndFinish();
                return;
            }
            setBackStackType(paramBoolean);
            return;
        }
        if (paramBoolean) {
            clearStackAndFinish();
            return;
        }
        toggle();
    }

    public void breadcrumBackStack(final String paramString) {
        if (paramString != null) {
            if (this.fragmentMap.containsKey(Integer.valueOf(1018))) {
                this.fragmentMap.remove(Integer.valueOf(1018));
            }
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    for (; ; ) {
                        int i;
                        try {
                            SlidingMenuActivity.this.allForumStack.clear();
                            SlidingMenuActivity.this.showFragment(1018);
                            if (SlidingMenuActivity.this.mFrag != null) {
                                ((BackListFragment) SlidingMenuActivity.this.mFrag).SetSelectMenuTab(1018);
                            }
                            if (paramString.equals(SlidingMenuActivity.CATOGORIES_FORUM_ID)) {
                                break label149;
                            }
                            localArrayList = SlidingMenuActivity.this.forumStatus.getForumHierarch(SlidingMenuActivity.this, paramString);
                            if (localArrayList.size() <= 0) {
                                break label149;
                            }
                            i = localArrayList.size() - 1;
                        } catch (Exception localException) {
                            ArrayList localArrayList;
                            localException.printStackTrace();
                            SlidingMenuActivity.this.unloackNavigation();
                            return;
                        }
                        SlidingMenuActivity.this.addFragmentToStack(SubForumFragment.newInstance((Forum) localArrayList.get(i), "all_forum_statck_tag"), "all_forum_statck_tag", false);
                        SlidingMenuActivity.this.unloackNavigation();
                        i -= 1;
                        if (i < 0) {
                            label149:
                            return;
                        }
                        if (i != 0) {
                        }
                    }
                }
            }, 5L);
        }
    }

    public void cacheForumStatus() {
        try {
            if (this.forumStatus == null) {
                return;
            }
            localObject = AppCacheManager.getCookieCacheUrl(this, this.forumStatus.getUrl(), this.forumStatus.tapatalkForum.getCacheUsernameDir());
            ForumCookiesCache localForumCookiesCache = new ForumCookiesCache();
            localForumCookiesCache.writeTime = System.currentTimeMillis();
            localForumCookiesCache.saveForTime = 1800000L;
            localForumCookiesCache.cookies = this.forumStatus.cookies;
            AppCacheManager.cacheForumCookiesData((String) localObject, localForumCookiesCache);
        } catch (Exception localException1) {
            try {
                Object localObject = new ForumStatusCache();
                ((ForumStatusCache) localObject).writeTime = System.currentTimeMillis();
                ((ForumStatusCache) localObject).saveForTime = 86400000L;
                ((ForumStatusCache) localObject).forumStatus = this.forumStatus;
                AppCacheManager.cacheForumStatusData(AppCacheManager.getForumStatusCacheUrl(this, this.forumStatus.getUrl(), this.forumStatus.tapatalkForum.getCacheUsernameDir()), localObject);
                localObject = Prefs.get(this).edit();
                long l = System.currentTimeMillis();
                ((SharedPreferences.Editor) localObject).putLong(this.forumStatus.getForumId() + "|last_visit_time_new", Long.valueOf(l).longValue());
                ((SharedPreferences.Editor) localObject).putInt(this.forumStatus.getForumId() + "|api_level", this.forumStatus.getApiLevel());
                ((SharedPreferences.Editor) localObject).putString(this.forumStatus.getForumId() + "|version", this.forumStatus.tapatalkForum.getVersion());
                ((SharedPreferences.Editor) localObject).putBoolean(this.forumStatus.getForumId() + "|anonymous", this.forumStatus.isSupportAnonymous());
                if ((!this.forumStatus.isLogin()) || (this.forumStatus.tapatalkForum.getUserName() == null) || (!this.forumStatus.tapatalkForum.hasPassword())) {
                    break label481;
                }
                ((SharedPreferences.Editor) localObject).putString(this.forumStatus.getForumId() + "|version", this.forumStatus.tapatalkForum.getVersion());
                ((SharedPreferences.Editor) localObject).putBoolean(this.forumStatus.getForumId() + "|canpm", this.forumStatus.isCanPm());
                ((SharedPreferences.Editor) localObject).putBoolean(this.forumStatus.getForumId() + "|supportunread", this.forumStatus.isSupportGoUnread());
                label481:
                new FavoriateSqlHelper(this, TapatalkApp.database_name, null, Integer.parseInt(TapatalkApp.database_version)).saveFavoriate(this.forumStatus.tapatalkForum);
                ((SharedPreferences.Editor) localObject).commit();
                return;
                localException1 = localException1;
                localException1.printStackTrace();
            } catch (Exception localException2) {
                for (; ; ) {
                    localException2.printStackTrace();
                }
            }
        }
        if ((this.forumStatus != null) && (this.forumStatus.isLogin())) {
        }
    }

    public void callPrefechAccount(ForumStatus paramForumStatus) {
        if (((paramForumStatus.isSsoLogin()) || (paramForumStatus.isSsoSign())) && (this.tapatalkId.isTapatalkIdLogin()) && (this.tapatalkId.isConfirmed()) && (Util.checkString(this.tapatalkId.getTapatalkIdEmail()))) {
            new PrefetchAccoutAction(paramForumStatus, this).prefetch(this.tapatalkId.getTapatalkIdEmail(), new PrefetchAccoutAction.ActionCallBack() {
                public void actionCallBack(PrefetchAccountInfo paramAnonymousPrefetchAccountInfo) {
                    SlidingMenuActivity.this.accountInfo = paramAnonymousPrefetchAccountInfo;
                    SlidingMenuActivity.this.closeProgress();
                    if (SlidingMenuActivity.this.forumStatus.isGuestOkay()) {
                        SlidingMenuActivity.this.showView();
                        return;
                    }
                    SlidingMenuActivity.this.showLoginView();
                }
            });
        }
    }

    public void clearExistFragment() {
        this.currentFragment = null;
        FragmentManager localFragmentManager = getSupportFragmentManager();
        localFragmentManager.popBackStack();
        if (this.mFrag != null) {
            localFragmentManager.beginTransaction().remove(this.mFrag);
        }
        clearStack();
    }

    public void clearStack() {
        this.subscribeForumStack.clear();
        this.allForumStack.clear();
        this.fragmentMap.clear();
        this.loginFragmentStack.clear();
        this.advanceFragmentStack.clear();
        feedForumStack.clear();
    }

    public void clearStackAndFinish() {
        Intent localIntent;
        if ((this.add_favoriate) && (this.isGoFeed)) {
            localIntent = new Intent(this, AccountEntryActivity.class);
            localIntent.putExtra("add_favoriate", this.add_favoriate);
            localIntent.setFlags(67108864);
            setResult(-1, localIntent);
            finish();
            return;
        }
        if ((this.isFromWidget) || (this.isNotification) || (this.viewFromOutUrl)) {
            clearStack();
            if (!getResources().getBoolean(2131558401)) {
                localIntent = new Intent(this, AccountEntryActivity.class);
                localIntent.putExtra("add_favoriate", this.add_favoriate);
                localIntent.setFlags(67108864);
                startActivity(localIntent);
            }
            for (; ; ) {
                finish();
                return;
                if ((getResources().getBoolean(2131558402)) || (getResources().getBoolean(2131558406))) {
                    localIntent = new Intent(this, IcsRebrandingEntryActivity.class);
                    localIntent.setFlags(67108864);
                    startActivity(localIntent);
                }
            }
        }
        if (this.mDrawerLayout.isDrawerOpen(this.mMenuLayout)) {
            toggle();
            return;
        }
        clearStack();
        finish();
    }

    public void closeDrawerLay() {
        if ((this.mDrawerLayout != null) && (this.mMenuLayout != null) && (this.mDrawerLayout.isDrawerOpen(this.mMenuLayout))) {
            this.mDrawerLayout.closeDrawer(this.mMenuLayout);
        }
    }

    public void closeProgress() {
        new Handler().postDelayed(new Runnable() {
            public void run() {
                try {
                    SlidingMenuActivity.this.removeDialog(0);
                    return;
                } catch (Exception localException) {
                }
            }
        }, 300L);
    }

    public void createDrawerMenu(Menu paramMenu) {
        initMenuGroupTwo(paramMenu);
    }

    public void dealWithOutCallback() {
        if (this.isNotification) {
            notificationCallback();
        }
        if ((this.isFromWidget) || (this.viewFromOutUrl)) {
            openOutUrlAndWidgetCallback(this.defaultMenuId);
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

    public void getIntentValue() {
        try {
            if (getIntent().hasExtra("shortcut")) {
                this.isFromShortcut = getIntent().getBooleanExtra("shortcut", false);
            }
            if (getIntent().hasExtra("shortcutURL")) {
                this.shortcutURL = getIntent().getStringExtra("shortcutURL");
            }
            this.forumId = getIntent().getStringExtra("forumId");
            this.isFromWidget = getIntent().getBooleanExtra("fromWidget", false);
            this.widgetReplyCount = getIntent().getIntExtra("reply_count", 0);
            this.widgetTopicId = getIntent().getStringExtra("topic_id");
            this.widgetTopicTitle = getIntent().getStringExtra("topic_title");
            this.widgetConvId = getIntent().getStringExtra("conv_id");
            this.isNotification = getIntent().getBooleanExtra("notification", false);
            this.viewsubscribe = getIntent().getBooleanExtra("viewsubscribe", false);
            this.viewpm = getIntent().getBooleanExtra("viewpm", false);
            this.viewConvos = getIntent().getBooleanExtra("viewConvos", false);
            this.writePm = getIntent().getBooleanExtra("writePm", false);
            this.writeConversation = getIntent().getBooleanExtra("writeConversation", false);
            this.viewlike = getIntent().getBooleanExtra("viewlike", false);
            this.viewQuote = getIntent().getBooleanExtra("viewQuote", false);
            this.pushTopic = ((Topic) getIntent().getSerializableExtra("topic"));
            this.pushForum = ((TapatalkForum) getIntent().getSerializableExtra("forum"));
            this.pushPM = ((PrivateMessage) getIntent().getSerializableExtra("pm"));
            this.pushConv = ((Conversation) getIntent().getSerializableExtra("conversation"));
            this.pushPostId = getIntent().getStringExtra("post_id");
            this.pushFid = getIntent().getIntExtra("fid", 0);
            this.pushSpkey = getIntent().getStringExtra("spkey");
            this.subscirbeForum = ((Forum) getIntent().getSerializableExtra("subscribeForum"));
            if (!getResources().getBoolean(2131558401)) {
                this.pushForumId = getIntent().getStringExtra("forumId");
            }
            this.defaultMenuId = getIntent().getIntExtra("defaultclick", 0);
            this.pushCount = getIntent().getIntExtra("push_count", 1);
            this.isShare = getIntent().getBooleanExtra("isShare", false);
            if (this.isShare) {
                this.shareForum = ((TapatalkForum) getIntent().getSerializableExtra("forum"));
            }
            this.channel = getIntent().getStringExtra("channel");
            this.isGoFeed = getIntent().getBooleanExtra("isGoFeed", false);
            this.isOpenSubForumFromPostUrl = getIntent().getBooleanExtra("isOpenSubForumFromPostUrl", false);
            return;
        } catch (Exception localException) {
            localException.printStackTrace();
        }
    }

    public Fragment getOuterFragment() {
        return this.outerFragment;
    }

    public boolean getShowSlectionStatus() {
        if ((Util.getDeviceSize(this) < 7.0D) || (getResources().getConfiguration().orientation == 1)) {
        }
        while (this.fragmentDetail.getVisibility() != 0) {
            return false;
        }
        return true;
    }

    public void getUnreadNumbers() {
        new GetInboxStat(this, this.forumStatus);
    }

    public Fragment getmFrag() {
        return this.mFrag;
    }

    public void goToPush() {
        if ((this.isNotification) && (this.pushCount > 1)) {
            if (!this.forumStatus.isAlert()) {
                break label429;
            }
        }
        label429:
        for (this.defaultMenuId = 1024; ; this.defaultMenuId = 1019) {
            Intent localIntent;
            if (((this.viewsubscribe) || (this.viewlike) || (this.viewQuote)) && (this.pushCount == 1)) {
                localIntent = new Intent();
                if (this.isNotification) {
                    localIntent.putExtra("fid", this.pushFid);
                    localIntent.putExtra("spkey", this.pushSpkey);
                    localIntent.putExtra("notification", true);
                    localIntent.putExtra("topic", this.pushTopic);
                    localIntent.putExtra("post_id", this.pushPostId);
                    localIntent.putExtra("forum", this.pushForum);
                }
                if (Util.isLoginedUser(this, this.pushForum)) {
                    this.forumStatus.setLogin(true);
                }
                localIntent.putExtra("forumStatus", this.forumStatus);
                localIntent.setClass(this, ThreadActivity.class);
                startActivity(localIntent);
            }
            if ((this.viewpm) && (this.pushCount == 1)) {
                localIntent = new Intent();
                localIntent.putExtra("fid", this.pushFid);
                localIntent.putExtra("spkey", this.pushSpkey);
                localIntent.putExtra("notification", true);
                localIntent.putExtra("pm", this.pushPM);
                if (Util.isLoginedUser(this, this.pushForum)) {
                    this.forumStatus.setLogin(true);
                }
                localIntent.putExtra("forumStatus", this.forumStatus);
                localIntent.setClass(this, PMContentActivity.class);
                startActivity(localIntent);
            }
            if ((this.viewConvos) && (this.pushCount == 1)) {
                localIntent = new Intent();
                localIntent.putExtra("fid", this.pushFid);
                localIntent.putExtra("spkey", this.pushSpkey);
                localIntent.putExtra("notification", true);
                localIntent.putExtra("conversation", this.pushConv);
                localIntent.putExtra("conv_id", this.widgetConvId);
                if (Util.isLoginedUser(this, this.pushForum)) {
                    this.forumStatus.setLogin(true);
                }
                localIntent.putExtra("forumStatus", this.forumStatus);
                localIntent.setClass(this, ConverSationActivity.class);
                startActivity(localIntent);
            }
            return;
        }
    }

    public void goToSubscribe() {
        Intent localIntent;
        if (((this.viewsubscribe) || (this.viewlike) || (this.viewQuote)) && (this.defaultMenuId == 0)) {
            localIntent = new Intent();
            if (this.isNotification) {
                localIntent.putExtra("fid", this.pushFid);
                localIntent.putExtra("spkey", this.pushSpkey);
                localIntent.putExtra("notification", true);
                localIntent.putExtra("topic", this.pushTopic);
                localIntent.putExtra("post_id", this.pushPostId);
                localIntent.putExtra("forum", this.pushForum);
            }
            if (this.isFromWidget) {
                localIntent.putExtra("forumId", this.pushForumId);
                localIntent.putExtra("topic_id", this.widgetTopicId);
                localIntent.putExtra("topic_title", this.widgetTopicTitle);
                localIntent.putExtra("reply_count", this.widgetReplyCount);
            }
            this.defaultMenuId = 1019;
        }
        if ((this.viewpm) && (this.defaultMenuId == 0)) {
            localIntent = new Intent();
            localIntent.putExtra("fid", this.pushFid);
            localIntent.putExtra("spkey", this.pushSpkey);
            localIntent.putExtra("notification", true);
            localIntent.putExtra("pm", this.pushPM);
            localIntent.putExtra("forumStatus", this.forumStatus);
            this.defaultMenuId = 1021;
        }
        if ((this.viewConvos) && (this.defaultMenuId == 0)) {
            localIntent = new Intent();
            localIntent.putExtra("fid", this.pushFid);
            localIntent.putExtra("spkey", this.pushSpkey);
            localIntent.putExtra("notification", true);
            localIntent.putExtra("conversation", this.pushConv);
            localIntent.putExtra("conv_id", this.widgetConvId);
            localIntent.putExtra("forumStatus", this.forumStatus);
            this.defaultMenuId = 1020;
        }
        if (this.writePm) {
            localIntent = new Intent(this, CreatePmActivity.class);
            localIntent.putExtra("forumStatus", this.forumStatus);
            localIntent.putExtra("action", 1);
            startActivity(localIntent);
            this.defaultMenuId = 1021;
        }
        if (this.writeConversation) {
            localIntent = new Intent(this, CreateOrReplyConversationActivity.class);
            localIntent.putExtra("forumStatus", this.forumStatus);
            startActivity(localIntent);
            this.defaultMenuId = 1020;
        }
    }

    public boolean isDrawMenuOpen() {
        if ((this.mDrawerLayout != null) && (this.mMenuLayout != null)) {
            return this.mDrawerLayout.isDrawerVisible(this.mMenuLayout);
        }
        return false;
    }

    public void notificationCallback() {
        closeProgress();
        getActionBar().setDisplayShowTitleEnabled(true);
        showBackListFragment(this.defaultMenuId, true, false);
        showFragment(this.defaultMenuId);
    }

    protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
        if ((paramIntent == null) || ((paramInt1 != 21) || (paramInt2 != -1) || (paramIntent.hasExtra("cookie")))) {
        }
        try {
            this.forumStatus.cookies.putAll((HashMap) paramIntent.getSerializableExtra("cookie"));
            if (((this.currentFragment instanceof SubForumFragment)) && (((SubForumFragment) this.currentFragment).adapter != null)) {
                ((SubForumFragment) this.currentFragment).adapter.removeItem(((SubForumFragment) this.currentFragment).adapter.getmLongclickItemPosition());
                ((SubForumAdapter) ((SubForumFragment) this.currentFragment).adapter).getCurAdapter().notifyDataSetChanged();
            }
            Object localObject;
            boolean bool;
            if (paramInt1 == 8) {
                if (paramIntent.getBooleanExtra("needLogin", false)) {
                    showLoginView();
                    return;
                }
                localObject = paramIntent.getStringExtra("com.quoord.tapatalkpro.apk.topicid");
                bool = paramIntent.getBooleanExtra("com.quoord.tapatalkpro.apk.topicid.flag", false);
                breadcrumBackStack(paramIntent.getStringExtra("forumId"));
                if (!paramIntent.hasExtra("cookie")) {
                }
            }
            try {
                this.forumStatus.cookies.putAll((HashMap) paramIntent.getSerializableExtra("cookie"));
                ArrayList localArrayList;
                int i;
                if ((localObject != null) && (!((String) localObject).equals(""))) {
                    if (!(this.currentFragment instanceof TopicsFragment)) {
                        break label417;
                    }
                    localArrayList = ((LatestTopicAdapter) ((TopicsFragment) this.currentFragment).adapter).mDatas;
                    i = 0;
                    if (i < localArrayList.size()) {
                    }
                } else {
                    label252:
                    if ((paramInt1 == 53328) && ((this.currentFragment instanceof SubForumFragment)) && (((SubForumFragment) this.currentFragment).adapter != null)) {
                        ((SubForumAdapter) ((SubForumFragment) this.currentFragment).adapter).refresh();
                    }
                    if (!(this.outerFragment instanceof ProfilesOuterFragment)) {
                        break label697;
                    }
                    ((ProfilesOuterFragment) this.outerFragment).getActivityResult(paramInt1, paramInt2, paramIntent);
                }
                for (; ; ) {
                    super.onActivityResult(paramInt1, paramInt2, paramIntent);
                    return;
                    if (((localArrayList.get(i) instanceof Topic)) && (((Topic) localArrayList.get(i)).getId().equals(localObject))) {
                        ((Topic) ((LatestTopicAdapter) ((TopicsFragment) this.currentFragment).adapter).mDatas.get(i)).setSubscribe(bool);
                        ((LatestTopicAdapter) ((TopicsFragment) this.currentFragment).adapter).notifyDataSetChanged();
                    }
                    i += 1;
                    break;
                    label417:
                    if ((!(this.currentFragment instanceof SubForumFragment)) || (((SubForumFragment) this.currentFragment).adapter == null)) {
                        break label252;
                    }
                    localArrayList = ((SubForumAdapter) ((SubForumFragment) this.currentFragment).adapter).getCurAdapter().getDatas();
                    i = 0;
                    while (i < localArrayList.size()) {
                        if (((localArrayList.get(i) instanceof Topic)) && (((Topic) localArrayList.get(i)).getId().equals(localObject))) {
                            ((Topic) ((SubForumAdapter) ((SubForumFragment) this.currentFragment).adapter).getCurAdapter().getDatas().get(i)).setSubscribe(bool);
                            ((SubForumAdapter) ((SubForumFragment) this.currentFragment).adapter).getCurAdapter().notifyDataSetChanged();
                        }
                        i += 1;
                    }
                    break label252;
                    if (paramInt1 == 52) {
                        localObject = paramIntent.getExtras();
                        if (!(this.currentFragment instanceof AdvanceSearchFragment)) {
                            break label252;
                        }
                        ((AdvanceSearchFragment) this.currentFragment).categroiesText.setText(((Bundle) localObject).getString("forum_name"));
                        if (((Bundle) localObject).getString("forum_id") == null) {
                            break label252;
                        }
                        ((AdvanceSearchFragment) this.currentFragment).setForumId(((Bundle) localObject).getString("forum_id"));
                        break label252;
                    }
                    if (((paramInt1 != 1) && (paramInt1 != 601)) || (!(this.currentFragment instanceof SubForumFragment)) || (((SubForumFragment) this.currentFragment).adapter == null)) {
                        break label252;
                    }
                    ((SubForumAdapter) ((SubForumFragment) this.currentFragment).adapter).refresh();
                    break label252;
                    label697:
                    if ((this.outerFragment instanceof ThreadOuterFragment)) {
                        ((ThreadOuterFragment) this.outerFragment).onActivityResult(paramInt1, paramInt2, paramIntent);
                    }
                }
            } catch (Exception localException2) {
                for (; ; ) {
                }
            }
        } catch (Exception localException1) {
            for (; ; ) {
            }
        }
    }

    public void onConfigurationChanged(Configuration paramConfiguration) {
        super.onConfigurationChanged(paramConfiguration);
        if (paramConfiguration == null) {
        }
        do {
            do {
                do {
                    return;
                } while ((this.mDrawerToggle == null) || (this.mDrawerLayout == null));
                this.mDrawerToggle.onConfigurationChanged(paramConfiguration);
            } while (Util.getDeviceSize(this) < 7.0D);
            switch (paramConfiguration.orientation) {
                default:
                    return;
                case 1:
                    if (this.fragmentDetail.getVisibility() != 0) {
                        break label122;
                    }
                    this.fragmentLayout.setVisibility(8);
                    this.mDrawerToggle.setDrawerIndicatorEnabled(false);
                    this.mDrawerLayout.setDrawerLockMode(1);
                    return;
            }
        } while (this.fragmentLayout.getVisibility() != 8);
        unloackNavigation();
        return;
        label122:
        this.mDrawerToggle.setDrawerIndicatorEnabled(true);
    }

    public void onCreate(Bundle paramBundle) {
        ThemeUtil.setTheme(this);
        this.bar = getActionBar();
        super.onCreate(paramBundle);
        getActionBar().setIcon(2130837525);
        setContentView(2130903168);
        DebugModeUtil.opCrashEmial(this);
        this.tapatalkId = TapatalkIdFactory.getTapatalkId(this);
        registBroad();
        this.mDrawerLayout = ((DrawerLayout) findViewById(2131231099));
        this.mDrawerLayout.setDrawerLockMode(1);
        setDrawerToggle();
        this.mMenuLayout = ((RelativeLayout) findViewById(2131231102));
        this.fragmentDetail = findViewById(2131231101);
        this.fragmentLayout = findViewById(2131231100);
        clearStack();
        UmsAgent.setBaseURL("https://razor.tapatalk.com");
        Util.showMenu(this);
        if (getResources().getBoolean(2131558401)) {
            Util.byoRate(this);
        }
        paramBundle = Prefs.get(this);
        clearExistFragment();
        if ((getIntent() != null) && (getIntent().hasExtra("VIEW_FROM_OUT_URL"))) {
            this.viewFromOutUrl = getIntent().getBooleanExtra("VIEW_FROM_OUT_URL", false);
            if (this.viewFromOutUrl) {
                showProgress();
                ForumUrlUtil.openFromUrl(getIntent(), this, "all_forum_statck_tag");
            }
        }
        for (; ; ) {
            return;
            getIntentValue();
            UserBehavior.logUserAddForum(this);
            this.forumStatus = new ForumStatus(this);
            Object localObject1;
            if (this.forumId != null) {
                localObject1 = new FavoriateSqlHelper(this, TapatalkApp.database_name, null, Integer.parseInt(TapatalkApp.database_version)).getFavrivateById(this.forumId);
                this.forumStatus.tapatalkForum = ((TapatalkForum) localObject1);
                if (Util.isFavoriate(this, Integer.parseInt(this.forumId))) {
                    this.isHide_addFavoriate_view = true;
                }
            }
            try {
                if ((getIntent().getExtras() != null) && (getIntent().getSerializableExtra("forum") != null)) {
                    this.forumStatus.tapatalkForum = ((TapatalkForum) getIntent().getSerializableExtra("forum"));
                }
                Object localObject2;
                if (this.forumStatus.tapatalkForum != null) {
                    boolean bool = false;
                    if (this.isNotification) {
                        bool = true;
                    }
                    this.forumStatus = ForumStatus.initialForumStatus(this, this.forumStatus.tapatalkForum, this.forumStatus.tapatalkForum.getUserName(), this.shortcutURL, bool);
                    if (getResources().getBoolean(2131558401)) {
                        localObject1 = AppCacheManager.getRebrandingUrl(this);
                        if (AppCacheManager.checkFile((String) localObject1)) {
                            Util.getByoTabItemCache((String) localObject1, this, this.forumStatus);
                        }
                    } else {
                        localObject1 = AppCacheManager.getGroupUrl(this);
                        if ((AppCacheManager.checkFile((String) localObject1)) && (this.forumStatus.tapatalkForum != null) && (this.forumStatus.tapatalkForum.getUserName() != null)) {
                            localObject2 = this.forumStatus.tapatalkForum.getPassword();
                            if (localObject2 == null) {
                            }
                        }
                    }
                }
                for (; ; ) {
                    try {
                        localObject1 = (Object[]) AppCacheManager.getCacheData((String) localObject1);
                        if (localObject1 != null) {
                            i = 0;
                            int j = localObject1.length;
                            if (i < j) {
                                continue;
                            }
                        }
                    } catch (Exception localException2) {
                        int i;
                        continue;
                    }
                    if ((this.defaultMenuId == 0) && (!this.isFromWidget) && (this.forumStatus.tapatalkForum != null)) {
                        this.defaultMenuId = paramBundle.getInt(new StringBuilder().append(this.forumStatus.tapatalkForum.getId()).append(this.forumStatus.tapatalkForum.getUserName()).toString().hashCode() + "|last_visit_tab", 0);
                    }
                    if ((this.shortcutURL == null) && (!this.isFromShortcut)) {
                        continue;
                    }
                    this.defaultMenuId = 0;
                    this.forumStatus.setStartByShortCut(true);
                    if (this.forumStatus.tapatalkForum != null) {
                        continue;
                    }
                    finish();
                    return;
                    this.forumStatus.rebrandingConfig = ((RebrandingConfig) getIntent().getSerializableExtra("rebrandingConfig"));
                    break;
                    if (!getResources().getBoolean(2131558401)) {
                        RebrandingUtil.getForumById(this, this.forumStatus, this.pushForumId, this.shortcutURL);
                        break;
                    }
                    localObject1 = new FavoriateSqlHelper(this, TapatalkApp.database_name, null, Integer.parseInt(TapatalkApp.database_version)).getFavrivate();
                    i = 0;
                    if (i >= ((ArrayList) localObject1).size()) {
                        if (this.forumStatus.tapatalkForum != null) {
                            break;
                        }
                        this.forumStatus.tapatalkForum = new TapatalkForum();
                        this.forumStatus.tapatalkForum.setUrl(TapatalkApp.rebranding_url);
                        this.forumStatus.tapatalkForum.setName(TapatalkApp.rebranding_name);
                        this.forumStatus.tapatalkForum.setId(Integer.valueOf(0));
                        i = 0;
                        if (i < this.forumStatus.rebrandingConfig.getOrder().size()) {
                            localObject1 = (TabItem) this.forumStatus.rebrandingConfig.getOrder().get(i);
                            ((TabItem) localObject1).setDrawable(this, ((TabItem) localObject1).getName(), ((TabItem) localObject1).getDisplay_name(), ((TabItem) localObject1).getValue(), ((TabItem) localObject1).isSelected());
                            i += 1;
                            continue;
                        }
                        break;
                    }
                    if ((((TapatalkForum) ((ArrayList) localObject1).get(i)).getUserName() != null) && (((TapatalkForum) ((ArrayList) localObject1).get(i)).getUserName().length() > 0) && (((TapatalkForum) ((ArrayList) localObject1).get(i)).hasPassword())) {
                        this.forumStatus.tapatalkForum = ((TapatalkForum) ((ArrayList) localObject1).get(i));
                    }
                    i += 1;
                    continue;
                    this.forumStatus.setUserGroupId((String) localObject1[i]);
                    i += 1;
                }
                localObject1 = this.forumStatus.tapatalkForum;
                if (localObject1 != null) {
                }
                try {
                    localObject1 = this.forumStatus.tapatalkForum.getId() + "notification";
                    localObject2 = getSharedPreferences("notification", 0).edit();
                    ((SharedPreferences.Editor) localObject2).remove((String) localObject1);
                    ((SharedPreferences.Editor) localObject2).remove(localObject1 + "pushIds");
                    ((SharedPreferences.Editor) localObject2).commit();
                    BaseNotification.clearSavedList((String) localObject1, this);
                    ((NotificationManager) getSystemService("notification")).cancel(((String) localObject1).hashCode());
                    paramBundle.edit().putLong(this.forumStatus.getForumId() + "|" + "tapatalk_service_last_run_time", paramBundle.getLong(this.forumStatus.getForumId() + "|" + "tapatalk_service_last_read_pm_time", 0L)).commit();
                    AppCacheManager.cleanSessionCache(this, AppCacheManager.getNewCachePath(this.forumStatus.getUrl(), ""));
                    this.bar.setTitle(this.forumStatus.tapatalkForum.getName());
                    this.bar.setDisplayHomeAsUpEnabled(true);
                    this.bar.setIcon(2130837525);
                    showProgress();
                    if ((this.forumStatus.tapatalkForum.getGa() != null) && (this.forumStatus.tapatalkForum.getGa().length() > 0)) {
                        paramBundle = GoogleAnalytics.getInstance(this).newTracker(this.forumStatus.tapatalkForum.getGa());
                        paramBundle.setScreenName("tapatalk");
                        paramBundle.send(new HitBuilders.AppViewBuilder().build());
                    }
                    startLogin();
                    if (this.isNotification) {
                        GoogleAnalyticsTools.trackEvent(this, "launch", "notification");
                        Util.logAppSession(this);
                        goToPush();
                    }
                    if (!this.isFromWidget) {
                        continue;
                    }
                    GoogleAnalyticsTools.trackEvent(this, "launch", "widget");
                    Util.logAppSession(this);
                    goToSubscribe();
                    return;
                } catch (Exception localException1) {
                    for (; ; ) {
                        localException1.printStackTrace();
                    }
                }
                return;
            } catch (Exception paramBundle) {
            }
        }
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
        localProgressDialog.setOnKeyListener(new DialogInterface.OnKeyListener() {
            public boolean onKey(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent) {
                if ((paramAnonymousKeyEvent.getKeyCode() == 4) && (SlidingMenuActivity.this.currentTabMenuId == 0)) {
                    SlidingMenuActivity.this.finish();
                    return true;
                }
                return false;
            }
        });
        return localProgressDialog;
    }

    public boolean onCreateOptionsMenu(Menu paramMenu) {
        this.mMenu = paramMenu;
        return super.onCreateOptionsMenu(paramMenu);
    }

    public void onDestroy() {
        super.onDestroy();
        this.broadcastControl.unregistBroad();
        this.fragmentMap.clear();
        System.gc();
    }

    public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent) {
        boolean bool = false;
        closeProgress();
        if (paramInt == 4) {
            if ((this.fragmentLayout.getVisibility() == 8) && (this.fragmentDetail.getVisibility() == 0)) {
                removeDetail(this.outerFragment);
                this.mDrawerToggle.setDrawerIndicatorEnabled(true);
                this.mDrawerLayout.setDrawerLockMode(0);
                bool = true;
            }
        } else {
            return bool;
        }
        if ((this.isShare) && (this.allForumStack != null) && (this.allForumStack.size() == 1)) {
            if ((this.currentFragment instanceof ModerateFragment)) {
                if ((((ModerateFragment) this.currentFragment).mForumAdapter.forumStack.size() > 0) && (!((ModerateFragment) this.currentFragment).mForumAdapter.forumStack.empty())) {
                    ((ModerateFragment) this.currentFragment).mForumAdapter.backToTopLevel();
                    ((ModerateFragment) this.currentFragment).mForumAdapter.forum_id.remove(((ModerateFragment) this.currentFragment).mForumAdapter.currentForum.getId());
                }
                for (; ; ) {
                    if (this.isShare) {
                        invalidateOptionsMenu();
                    }
                    return true;
                    finish();
                }
            }
        } else {
            if ((this.currentFragment instanceof WebFragment)) {
                if (((WebFragment) this.currentFragment).mWebView.canGoBack()) {
                    ((WebFragment) this.currentFragment).mWebView.goBack();
                    ((WebFragment) this.currentFragment).mWebView.invalidate();
                }
                for (; ; ) {
                    return true;
                    backStack(true);
                }
            }
            backStack(true);
        }
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        switch (paramMenuItem.getItemId()) {
        }
        for (; ; ) {
            return super.onOptionsItemSelected(paramMenuItem);
            if ((this.fragmentLayout.getVisibility() == 8) && (this.fragmentDetail.getVisibility() == 0)) {
                removeDetail(this.outerFragment);
                this.mDrawerToggle.setDrawerIndicatorEnabled(true);
                this.mDrawerLayout.setDrawerLockMode(0);
                return true;
            }
            if ((this.isShare) && (this.allForumStack != null) && (this.allForumStack.size() == 1)) {
                if ((this.currentFragment instanceof ModerateFragment)) {
                    if ((((ModerateFragment) this.currentFragment).mForumAdapter.forumStack.size() > 0) && (!((ModerateFragment) this.currentFragment).mForumAdapter.forumStack.empty())) {
                        ((ModerateFragment) this.currentFragment).mForumAdapter.backToTopLevel();
                        ((ModerateFragment) this.currentFragment).mForumAdapter.forum_id.remove(((ModerateFragment) this.currentFragment).mForumAdapter.currentForum.getId());
                    }
                    for (; ; ) {
                        invalidateOptionsMenu();
                        return true;
                        finish();
                    }
                }
            } else {
                if (this.currentTabMenuId == 0) {
                    break label248;
                }
                backStack(false);
            }
            for (; ; ) {
                return true;
                label248:
                showProgress();
            }
            paramMenuItem = new Intent(this, SettingsActivity.class);
            paramMenuItem.putExtra("forumstatus", getForumStatus());
            paramMenuItem.addFlags(67108864);
            startActivityForResult(paramMenuItem, 10);
            return true;
            paramMenuItem = new Intent(this, ProfilesActivity.class);
            paramMenuItem.putExtra("forumStatus", getForumStatus());
            paramMenuItem.putExtra("iconusername", this.forumStatus.tapatalkForum.getDisplayNameOrUsername());
            paramMenuItem.putExtra("userid", getForumStatus().getUserId());
            startActivity(paramMenuItem);
            return true;
            showProgress();
            new Logout(getForumStatus(), this);
            this.defaultMenuId = 0;
            Util.deleteWidgetByForumId(this, this.forumStatus.tapatalkForum.getId());
        }
    }

    protected void onPause() {
        ForumConfigHelper.cacheForumStatus(this, this.forumStatus);
        UmsAgent.onPause(this);
        super.onPause();
    }

    protected void onPostCreate(Bundle paramBundle) {
        super.onPostCreate(paramBundle);
        if (this.mDrawerToggle != null) {
            this.mDrawerToggle.syncState();
        }
    }

    protected void onResume() {
        try {
            UmsAgent.onPause(this);
            super.onResume();
            return;
        } catch (Exception localException) {
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

    public void openOutUrlAndWidgetCallback(final int paramInt) {
        closeProgress();
        new Handler().postDelayed(new Runnable() {
            public void run() {
                switch (paramInt) {
                    default:
                        SlidingMenuActivity.this.showBackListFragment(1018, true, false);
                        SlidingMenuActivity.this.showFragment(1018);
                        return;
                    case 1021:
                        SlidingMenuActivity.this.showBackListFragment(1021, true, false);
                        SlidingMenuActivity.this.showFragment(1021);
                        return;
                    case 1020:
                        SlidingMenuActivity.this.showBackListFragment(1020, true, false);
                        SlidingMenuActivity.this.showFragment(1020);
                        return;
                    case 1018:
                        SlidingMenuActivity.this.showBackListFragment(1018, true, false);
                        SlidingMenuActivity.this.showFragment(1018);
                        return;
                    case 1019:
                        SlidingMenuActivity.this.showBackListFragment(1019, true, false);
                        SlidingMenuActivity.this.showFragment(1019);
                        return;
                }
                SlidingMenuActivity.this.showBackListFragment(1036, true, false);
                SlidingMenuActivity.this.showFragment(1036);
            }
        }, 500L);
    }

    public void openRegisterPage() {
        String str;
        if (this.forumStatus.getUrl().endsWith("/")) {
            str = this.forumStatus.getUrl() + this.forumStatus.getRegUrl();
        }
        for (; ; ) {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
            return;
            if ((this.forumStatus.isKN1()) || (this.forumStatus.isKN2())) {
                str = this.forumStatus.getUrl() + "/" + "index.php?option=com_users&view=registration";
            } else {
                str = this.forumStatus.getUrl() + "/" + this.forumStatus.getRegUrl();
            }
        }
    }

    public void registBroad() {
        this.broadcastControl = new BroadcastControl(this, this);
        this.broadcastControl.registBroad(BroadcastControl.FINISH_ACTIVITY);
    }

    public void removeDetail(Fragment paramFragment) {
        FragmentTransaction localFragmentTransaction = getSupportFragmentManager().beginTransaction();
        localFragmentTransaction.remove(paramFragment);
        localFragmentTransaction.commitAllowingStateLoss();
        this.fragmentDetail.setVisibility(8);
        this.fragmentLayout.setVisibility(0);
        this.mDrawerLayout.setDrawerLockMode(0);
        if ((this.currentFragment instanceof TwoPanelController)) {
            ((TwoPanelController) this.currentFragment).setActionBar(this);
            if ((((TwoPanelController) this.currentFragment).getAdapter() != null) && ((this.outerFragment instanceof ThreadOuterFragment)) && (!((ThreadOuterFragment) this.outerFragment).mTopic.isRedirect())) {
                ((TwoPanelController) this.currentFragment).getAdapter().notifyDataSetChanged();
            }
        }
    }

    public void removeProfilesFragment(QuoordFragment paramQuoordFragment) {
        FragmentTransaction localFragmentTransaction = getSupportFragmentManager().beginTransaction();
        localFragmentTransaction.remove(paramQuoordFragment);
        if (this.profilesCurrentFragment != null) {
            localFragmentTransaction.show((QuoordFragment) this.profilesCurrentFragment);
        }
        localFragmentTransaction.commitAllowingStateLoss();
        invalidateOptionsMenu();
        if (this.mDrawerToggle != null) {
            this.mDrawerToggle.setDrawerIndicatorEnabled(true);
        }
        if (this.mDrawerLayout != null) {
            this.mDrawerLayout.setDrawerLockMode(0);
        }
        if (this.profilesCurrentFragment != null) {
            this.currentFragment = this.profilesCurrentFragment;
        }
    }

    public void setBackStackAnimation(Fragment paramFragment) {
        FragmentTransaction localFragmentTransaction = getSupportFragmentManager().beginTransaction();
        localFragmentTransaction.remove(paramFragment);
        localFragmentTransaction.commitAllowingStateLoss();
        paramFragment = new TranslateAnimation(0.0F, getWindowManager().getDefaultDisplay().getWidth() * 4 / 7, 0.0F, 0.0F);
        paramFragment.setDuration(300L);
        this.fragmentDetail.setVisibility(8);
        this.fragmentLayout.setVisibility(0);
        this.fragmentDetail.setAnimation(paramFragment);
        this.mDrawerLayout.setDrawerLockMode(0);
        this.mDrawerToggle.setDrawerIndicatorEnabled(true);
        if ((this.currentFragment instanceof TwoPanelController)) {
            ((TwoPanelController) this.currentFragment).setActionBar(this);
        }
        invalidateOptionsMenu();
    }

    public void setBackStackType(boolean paramBoolean) {
        if (this.fragmentDetail.getVisibility() == 0) {
            setBackStackAnimation(this.outerFragment);
        }
        for (; ; ) {
            if ((this.currentFragment instanceof TwoPanelController)) {
                ((TwoPanelController) this.currentFragment).setActionBar(this);
            }
            invalidateOptionsMenu();
            return;
            if (paramBoolean) {
                clearStackAndFinish();
            } else {
                toggle();
            }
        }
    }

    public void setForumStatus(ForumStatus paramForumStatus) {
        this.forumStatus = paramForumStatus;
    }

    public void setmFrag(Fragment paramFragment) {
        this.mFrag = paramFragment;
    }

    public void showBackListFragment(int paramInt, boolean paramBoolean1, boolean paramBoolean2) {
        try {
            FragmentTransaction localFragmentTransaction = getSupportFragmentManager().beginTransaction();
            if ((this.mFrag == null) || (paramBoolean1) || (getSupportFragmentManager().findFragmentByTag(String.valueOf(this.mFrag.hashCode())) == null)) {
                this.mFrag = BackListFragment.newInstance(this.forumStatus, paramInt);
                localFragmentTransaction.replace(2131231102, this.mFrag, String.valueOf(this.mFrag.hashCode()));
                this.mDrawerLayout.setDrawerLockMode(0);
                this.mDrawerToggle.setDrawerIndicatorEnabled(isDrawerIndicatorEnabled());
            }
            for (; ; ) {
                localFragmentTransaction.commitAllowingStateLoss();
                return;
                localFragmentTransaction.show(this.mFrag);
            }
            return;
        } catch (Exception localException) {
        }
    }

    public void showDetail(Fragment paramFragment) {
        this.outerFragment = paramFragment;
        this.fragmentDetail.setVisibility(0);
        ((TwoPanelController) this.outerFragment).setActionBar(this);
        FragmentTransaction localFragmentTransaction = getSupportFragmentManager().beginTransaction();
        if (Util.getDeviceSize(this) >= 7.0D) {
            this.mDrawerToggle.setDrawerIndicatorEnabled(false);
            this.mDrawerLayout.setDrawerLockMode(1);
            if (getResources().getConfiguration().orientation == 1) {
                this.fragmentLayout.setVisibility(8);
                this.mDrawerToggle.setDrawerIndicatorEnabled(false);
                localFragmentTransaction.replace(2131231101, (QuoordFragment) paramFragment, String.valueOf(paramFragment.hashCode()));
                localFragmentTransaction.commitAllowingStateLoss();
                return;
            }
            localFragmentTransaction.replace(2131231101, (QuoordFragment) paramFragment, String.valueOf(paramFragment.hashCode()));
            localFragmentTransaction.commitAllowingStateLoss();
            return;
        }
        this.fragmentLayout.setVisibility(8);
        this.mDrawerToggle.setDrawerIndicatorEnabled(false);
        this.mDrawerLayout.setDrawerLockMode(1);
        localFragmentTransaction.replace(2131231101, (QuoordFragment) paramFragment, String.valueOf(paramFragment.hashCode()));
        localFragmentTransaction.commitAllowingStateLoss();
    }

    public void showFragment(int paramInt) {
        SlidingMenuTool.showFragment(this, paramInt);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                SlidingMenuActivity.this.invalidateOptionsMenu();
            }
        }, 500L);
    }

    public void showLoginView() {
        showBackListFragment(1027, true, false);
        showFragment(1027);
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

    public void showRegist() {
        SlidingMenuTool.showRegister(this);
    }

    public void showSelectView(int paramInt) {
        if ((getResources().getBoolean(2131558401)) && (RebrandingUtil.isGetMenuId) && (paramInt != 1027)) {
            RebrandingUtil.getSelectMenuId(this, this.forumStatus);
            paramInt = RebrandingUtil.defaultID;
        }
        for (this.defaultMenuId = paramInt; ; this.defaultMenuId = paramInt) {
            closeProgress();
            if (!this.forumStatus.isLogin()) {
                break label231;
            }
            if ((!this.isFromWidget) && (!this.isNotification)) {
                break;
            }
            dealWithOutCallback();
            return;
        }
        int j;
        RebrandingConfig localRebrandingConfig;
        int i;
        if ((paramInt == 1027) || (paramInt == 1026)) {
            j = 0;
            localRebrandingConfig = RebrandingUtil.getRebrandingConfig(this);
            i = 0;
        }
        for (; ; ) {
            if (i >= localRebrandingConfig.getOrder().size()) {
                if (j == 0) {
                    this.defaultMenuId = 1013;
                }
                if (!this.isShare) {
                    break;
                }
                showBackListFragment(1018, true, false);
                showFragment(1018);
                this.mDrawerLayout.setDrawerLockMode(1);
                return;
            }
            if (((TabItem) localRebrandingConfig.getOrder().get(i)).isSelected()) {
                this.defaultMenuId = ((TabItem) localRebrandingConfig.getOrder().get(i)).getMenuid();
                j = 1;
            }
            i += 1;
        }
        showBackListFragment(paramInt, true, false);
        showFragment(paramInt);
        this.mDrawerLayout.setDrawerLockMode(0);
        return;
        label231:
        this.shouldLogin = getIntent().getBooleanExtra("shouldLogin", false);
        if ((this.forumStatus.tapatalkForum != null) && (((this.forumStatus.tapatalkForum.getUserName() != null) && (this.forumStatus.tapatalkForum.getUserName().length() > 0)) || ((this.shouldLogin) && (!this.forumStatus.tapatalkForum.hasPassword())))) {
            showLoginView();
            return;
        }
        showBackListFragment(paramInt, true, false);
        showFragment(paramInt);
    }

    public void showToFront(IQuoordInterface paramIQuoordInterface, boolean paramBoolean) {
        for (; ; ) {
            FragmentTransaction localFragmentTransaction;
            try {
                localFragmentTransaction = getSupportFragmentManager().beginTransaction();
                localFragmentTransaction.setCustomAnimations(2130968582, 2130968583);
                if ((paramIQuoordInterface instanceof QuoordFragment)) {
                    if (this.currentFragment == null) {
                        localFragmentTransaction.add(2131231100, (QuoordFragment) paramIQuoordInterface, String.valueOf(paramIQuoordInterface.hashCode()));
                        this.currentFragment = paramIQuoordInterface;
                    }
                } else {
                    localFragmentTransaction.commitAllowingStateLoss();
                    invalidateOptionsMenu();
                    this.mDrawerToggle.setDrawerIndicatorEnabled(isDrawerIndicatorEnabled());
                    return;
                }
                if (getSupportFragmentManager().findFragmentByTag(String.valueOf(paramIQuoordInterface.hashCode())) != null) {
                    localFragmentTransaction.hide((QuoordFragment) this.currentFragment);
                    localFragmentTransaction.show((QuoordFragment) paramIQuoordInterface);
                    continue;
                }
                localFragmentTransaction.add(2131231100, (QuoordFragment) paramIQuoordInterface, String.valueOf(paramIQuoordInterface.hashCode()));
            } catch (Exception paramIQuoordInterface) {
                finish();
                return;
            }
            localFragmentTransaction.hide((QuoordFragment) this.currentFragment);
            localFragmentTransaction.show((QuoordFragment) paramIQuoordInterface);
        }
    }

    public void showToProfilesFront(IQuoordInterface paramIQuoordInterface, boolean paramBoolean) {
        FragmentTransaction localFragmentTransaction = getSupportFragmentManager().beginTransaction();
        localFragmentTransaction.add(2131231100, (QuoordFragment) paramIQuoordInterface, String.valueOf(paramIQuoordInterface.hashCode()));
        localFragmentTransaction.show((QuoordFragment) paramIQuoordInterface);
        localFragmentTransaction.hide((QuoordFragment) this.currentFragment);
        this.profilesCurrentFragment = this.currentFragment;
        this.currentFragment = paramIQuoordInterface;
        localFragmentTransaction.commitAllowingStateLoss();
        invalidateOptionsMenu();
    }

    public void showUnSignedView() {
        AdsService.initBaner(this, 2, this.forumStatus.tapatalkForum.getId().intValue(), this.forumStatus);
        new LogNewSession(this, this.forumStatus).log(false, false, true);
        if ((this.forumStatus.isSsoLogin()) && (this.tapatalkId.isTapatalkIdLogin()) && (this.tapatalkId.isConfirmed()) && (Util.checkString(this.tapatalkId.getTapatalkIdEmail())) && (this.forumStatus.tapatalkForum.getUserNameOrDisplayName().equals(""))) {
            callPrefechAccount(this.forumStatus);
            return;
        }
        if (this.forumStatus.isGuestOkay()) {
            showView();
            return;
        }
        showSelectView(1027);
    }

    public void showView() {
        closeProgress();
        if (this.isOpenSubForumFromPostUrl) {
            showSelectView(1018);
        }
        Object localObject;
        label82:
        do {
            return;
            if ((this.forumStatus == null) || (!this.forumStatus.isStartByShortCut())) {
                break label229;
            }
            showSelectView(1018);
            localObject = getIntent().getStringExtra("shortcutID");
            if ((localObject == null) || (((String) localObject).equals(""))) {
                break;
            }
            GoogleAnalyticsTools.trackEvent(this, "launch", "shortcut");
            Util.logAppSession(this);
            if (((String) localObject).equals(CATOGORIES_FORUM_ID)) {
                break label204;
            }
            localObject = this.forumStatus.getForumHierarch(this, (String) localObject);
        } while (((ArrayList) localObject).size() <= 0);
        int i = ((ArrayList) localObject).size() - 1;
        label116:
        if (i >= 0) {
            if ((((Forum) ((ArrayList) localObject).get(i)).getUrl() == null) || (((Forum) ((ArrayList) localObject).get(i)).getUrl().equals(""))) {
                break label206;
            }
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse(((Forum) ((ArrayList) localObject).get(i)).getUrl())));
        }
        for (; ; ) {
            i -= 1;
            break label116;
            break;
            GoogleAnalyticsTools.trackEvent(this, "launch", "subforum_shortcut");
            Util.logAppSession(this);
            break label82;
            label204:
            break;
            label206:
            addFragmentToStack(SubForumFragment.newInstance((Forum) ((ArrayList) localObject).get(i), "all_forum_statck_tag"), "all_forum_statck_tag", true);
        }
        label229:
        if ((this.isFromWidget) || (this.isNotification)) {
            dealWithOutCallback();
            return;
        }
        if (this.forumStatus.isLogin()) {
            if (getResources().getBoolean(2131558401)) {
                if (RebrandingChecker.isReset) {
                    RebrandingUtil.getSelectMenuId(this, this.forumStatus);
                }
                this.defaultMenuId = RebrandingUtil.defaultID;
                RebrandingUtil.showLoginSelectView(this, this.defaultMenuId);
                return;
            }
            if ((this.defaultMenuId != 0) && (this.defaultMenuId != 1027) && (this.defaultMenuId != 1026)) {
                showSelectView(this.defaultMenuId);
                return;
            }
            if (this.forumStatus.tapatalkForum.isFeed()) {
                showSelectView(2002);
                return;
            }
            if (this.forumStatus.isCanUnread()) {
                showSelectView(1013);
                return;
            }
            showSelectView(1016);
            return;
        }
        if (getResources().getBoolean(2131558401)) {
            showSelectView(RebrandingUtil.getSelectMenuId(this, this.forumStatus));
            return;
        }
        if (this.forumStatus.tapatalkForum.isFeed()) {
            showSelectView(2002);
            return;
        }
        if (this.forumStatus.isGuestSearch()) {
            showSelectView(1016);
            return;
        }
        if (this.forumStatus.isGuestOkay()) {
            showSelectView(1018);
            return;
        }
        showLoginView();
    }

    public void toggle() {
        if (this.mDrawerLayout.getDrawerLockMode(this.mMenuLayout) > 0) {
            clearStackAndFinish();
        }
        while ((this.mDrawerLayout == null) || (this.mMenuLayout == null)) {
            return;
        }
        if (this.mDrawerLayout.isDrawerOpen(this.mMenuLayout)) {
            this.mDrawerLayout.closeDrawer(this.mMenuLayout);
            return;
        }
        this.mDrawerLayout.openDrawer(this.mMenuLayout);
    }

    public void unloackNavigation() {
        if (this.mDrawerLayout != null) {
            this.mDrawerLayout.setDrawerLockMode(0);
            this.fragmentLayout.setVisibility(0);
            this.mDrawerToggle.setDrawerIndicatorEnabled(false);
        }
    }

    public void updateDialog(int paramInt) {
    }

    public void updateUI(int paramInt, Object paramObject) {
        Message localMessage = this.mUIhandler.obtainMessage();
        localMessage.what = paramInt;
        localMessage.obj = paramObject;
        this.mUIhandler.sendMessage(localMessage);
    }

    public void updateUI(String paramString) {
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/ics/slidingMenu/SlidingMenuActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */