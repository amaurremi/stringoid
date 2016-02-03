package com.quoord.tapatalkpro.ics.slidingMenu;

import android.app.ActionBar;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Handler;
import android.preference.PreferenceManager;
import com.quoord.tapatalkpro.activity.forum.WhosOnlineFragment;
import com.quoord.tapatalkpro.activity.forum.feed.ForumFeedFragment;
import com.quoord.tapatalkpro.activity.forum.moderation.ModerateFragment;
import com.quoord.tapatalkpro.adapter.forum.ForumRootAdapter;
import com.quoord.tapatalkpro.adapter.forum.LatestTopicAdapter;
import com.quoord.tapatalkpro.adapter.forum.NewSubscribeForumAndTopicAdapter;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.bean.RebrandingConfig;
import com.quoord.tapatalkpro.bean.TapatalkForum;
import com.quoord.tapatalkpro.bean.TapatalkId;
import com.quoord.tapatalkpro.byo.RebrandingOrderName;
import com.quoord.tapatalkpro.ics.BaseListFragment;
import com.quoord.tapatalkpro.ics.advancesearch.AdvanceSearchHistoryFragment;
import com.quoord.tapatalkpro.ics.alert.AlertFragment;
import com.quoord.tapatalkpro.ics.conversation.ConversationListFragment;
import com.quoord.tapatalkpro.ics.conversation.PMListFragment;
import com.quoord.tapatalkpro.ics.forum.ForumListFragment;
import com.quoord.tapatalkpro.ics.forum.SubForumFragment;
import com.quoord.tapatalkpro.ics.forum.SubscribeForumFragment;
import com.quoord.tapatalkpro.ics.forum.SubscribeTopicFragment;
import com.quoord.tapatalkpro.ics.ics.blog.BlogsFragment;
import com.quoord.tapatalkpro.ics.slidingMenu.login.ForumJoinFragment;
import com.quoord.tapatalkpro.ics.slidingMenu.login.ForumLoginFragment;
import com.quoord.tapatalkpro.ics.slidingMenu.login.ForumRegisterFragment;
import com.quoord.tapatalkpro.ics.slidingMenu.login.PrefetchAccountInfo;
import com.quoord.tapatalkpro.ics.slidingMenu.login.TapatalkFacebookSigninFragment;
import com.quoord.tapatalkpro.ics.tapatalkid.TapatalkIdFactory;
import com.quoord.tapatalkpro.ics.topics.TopicsFragment;
import com.quoord.tapatalkpro.ui.ics.IQuoordInterface;
import com.quoord.tapatalkpro.ui.ics.QuoordFragment;
import com.quoord.tapatalkpro.util.Prefs;
import com.quoord.tapatalkpro.util.RebrandingUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class SlidingMenuTool {
    public static String MENU_FLAG = "menu_flag";
    private static SharedPreferences prefs;

    public static void openRegisterPage(SlidingMenuActivity paramSlidingMenuActivity) {
        if (paramSlidingMenuActivity.forumStatus.getUrl().endsWith("/")) {
        }
        for (String str = paramSlidingMenuActivity.forumStatus.getUrl() + paramSlidingMenuActivity.forumStatus.getRegUrl(); ; str = paramSlidingMenuActivity.forumStatus.getUrl() + "/" + paramSlidingMenuActivity.forumStatus.getRegUrl()) {
            paramSlidingMenuActivity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
            return;
        }
    }

    public static void setDisplayName(SlidingMenuActivity paramSlidingMenuActivity, int paramInt) {
        ArrayList localArrayList = paramSlidingMenuActivity.forumStatus.getRebrandingConfig().getOrder();
        int i;
        if ((paramSlidingMenuActivity.forumStatus != null) && (paramSlidingMenuActivity.forumStatus.getRebrandingConfig() != null) && (localArrayList != null) && (localArrayList.size() > 0)) {
            i = 0;
            if (i < localArrayList.size()) {
            }
        } else {
            return;
        }
        if ((paramInt == 1020) || (paramInt == 1021)) {
            if (((TabItem) localArrayList.get(i)).getMenuid() == 1035) {
                paramSlidingMenuActivity.bar.setTitle(((TabItem) localArrayList.get(i)).getDisplay_name());
            }
        }
        for (; ; ) {
            i += 1;
            break;
            if (((TabItem) localArrayList.get(i)).getMenuid() == paramInt) {
                paramSlidingMenuActivity.bar.setTitle(((TabItem) localArrayList.get(i)).getDisplay_name());
            }
        }
    }

    public static void setFragment(SlidingMenuActivity paramSlidingMenuActivity, TabItem paramTabItem, int paramInt) {
        if (paramSlidingMenuActivity.fragmentMap.containsKey(Integer.valueOf(paramInt))) {
            paramSlidingMenuActivity.showToFront((IQuoordInterface) paramSlidingMenuActivity.fragmentMap.get(Integer.valueOf(paramTabItem.getMenuid())), false);
        }
        do {
            do {
                paramSlidingMenuActivity.bar.setTitle(paramTabItem.getDisplay_name());
                return;
            } while (paramTabItem.getMenuid() != paramInt);
            if (paramTabItem.getName().equalsIgnoreCase(RebrandingOrderName.ORDER_WEB)) {
                localObject = WebFragment.newInstance(paramTabItem.getValue(), paramTabItem.getDisplay_name());
                paramSlidingMenuActivity.fragmentMap.put(Integer.valueOf(paramTabItem.getMenuid()), localObject);
                paramSlidingMenuActivity.showToFront((IQuoordInterface) localObject, true);
                return;
            }
        } while (!paramTabItem.getName().equalsIgnoreCase(RebrandingOrderName.ORDER_SUBFORUM));
        Object localObject = SlidingMenuSubforumFragment.newInstance(paramSlidingMenuActivity.forumStatus, paramTabItem.getValue(), paramTabItem.getDisplay_name());
        paramSlidingMenuActivity.fragmentMap.put(Integer.valueOf(paramTabItem.getMenuid()), localObject);
        paramSlidingMenuActivity.showToFront((IQuoordInterface) localObject, true);
    }

    public static void showFaceBookLoginView(SlidingMenuActivity paramSlidingMenuActivity) {
        TapatalkFacebookSigninFragment localTapatalkFacebookSigninFragment = TapatalkFacebookSigninFragment.newInstance(paramSlidingMenuActivity.forumStatus);
        paramSlidingMenuActivity.fragmentMap.put(Integer.valueOf(1027), localTapatalkFacebookSigninFragment);
        paramSlidingMenuActivity.addFragmentToStack(localTapatalkFacebookSigninFragment, "login_fragment_stack_tag", true);
    }

    public static void showFragment(SlidingMenuActivity paramSlidingMenuActivity, final int paramInt) {
        prefs = Prefs.get(paramSlidingMenuActivity);
        Object localObject3;
        Object localObject2;
        Object localObject1;
        if (paramInt != 1011) {
            if ((paramInt != 1021) && (paramInt != 1014) && (paramInt != 1019) && (paramInt != 1036) && (paramInt != 1038) && (paramInt != 1039) && (paramInt != 1040) && (paramInt != 1041) && (paramInt != 1042) && (paramInt != 1201)) {
                paramSlidingMenuActivity.getActionBar().setDisplayShowTitleEnabled(true);
                paramSlidingMenuActivity.getActionBar().setNavigationMode(0);
                if ((1011 == paramSlidingMenuActivity.currentTabMenuId) && ((paramSlidingMenuActivity.currentFragment instanceof AdvanceSearchHistoryFragment))) {
                    ((AdvanceSearchHistoryFragment) paramSlidingMenuActivity.currentFragment).hideKeyBoard();
                }
                paramSlidingMenuActivity.currentTabMenuId = paramInt;
                if (paramSlidingMenuActivity.outerFragment != null) {
                    paramSlidingMenuActivity.removeDetail(paramSlidingMenuActivity.outerFragment);
                }
                switch (paramInt) {
                    default:
                        localObject3 = null;
                        localObject2 = null;
                        localObject1 = null;
                        if ((paramSlidingMenuActivity.forumStatus != null) && (paramSlidingMenuActivity.forumStatus.getRebrandingConfig() != null) && (paramSlidingMenuActivity.forumStatus.getRebrandingConfig() != null) && (paramSlidingMenuActivity.forumStatus.getRebrandingConfig().getOrder() != null) && (paramSlidingMenuActivity.forumStatus.getRebrandingConfig().getOrder().size() > 0)) {
                            localObject2 = paramSlidingMenuActivity.forumStatus.getRebrandingConfig().getOrder();
                            i = 0;
                            label390:
                            if (i < ((ArrayList) localObject2).size()) {
                                break;
                            }
                        }
                        break;
                }
            }
        }
        label592:
        label705:
        label948:
        label1118:
        label1270:
        label1460:
        label1650:
        label1764:
        label1989:
        label2187:
        ArrayList localArrayList;
        do {
            if (localObject1 != null) {
                setFragment(paramSlidingMenuActivity, (TabItem) localObject1, paramInt);
            }
            for (; ; ) {
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        if ((SlidingMenuTool.this.forumStatus != null) && (SlidingMenuTool.this.forumStatus.isLogin()) && (paramInt != 1029) && (paramInt != 1010) && (paramInt != 1044)) {
                            SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(SlidingMenuTool.this).edit();
                            localEditor.putInt(new StringBuilder().append(SlidingMenuTool.this.forumStatus.tapatalkForum.getId()).append(SlidingMenuTool.this.forumStatus.tapatalkForum.getUserNameOrDisplayName()).toString().hashCode() + "|last_visit_tab", paramInt);
                            localEditor.commit();
                        }
                    }
                }, 300L);
                return;
                paramSlidingMenuActivity.getActionBar().setNavigationMode(1);
                paramSlidingMenuActivity.getActionBar().setDisplayShowTitleEnabled(false);
                break;
                paramSlidingMenuActivity.getActionBar().hide();
                paramSlidingMenuActivity.getActionBar().setDisplayShowTitleEnabled(false);
                paramSlidingMenuActivity.getActionBar().setNavigationMode(16);
                paramSlidingMenuActivity.getActionBar().show();
                break;
                if (paramSlidingMenuActivity.advanceFragmentStack.size() > 0) {
                    paramSlidingMenuActivity.showToFront((QuoordFragment) paramSlidingMenuActivity.advanceFragmentStack.peek(), false);
                }
                for (; ; ) {
                    if ((!paramSlidingMenuActivity.getResources().getBoolean(2131558401)) || (paramSlidingMenuActivity.forumStatus.getRebrandingConfig() == null) || (paramSlidingMenuActivity.forumStatus.getRebrandingConfig().getOrder().size() <= 0)) {
                        break label592;
                    }
                    setDisplayName(paramSlidingMenuActivity, paramInt);
                    break;
                    localObject1 = AdvanceSearchHistoryFragment.newInstance(paramSlidingMenuActivity, null, null, null, paramInt);
                    paramSlidingMenuActivity.fragmentMap.put(Integer.valueOf(1011), localObject1);
                    paramSlidingMenuActivity.addFragmentToStack((IQuoordInterface) localObject1, "advance_fragment_stack_tag", true);
                }
                continue;
                if (paramSlidingMenuActivity.fragmentMap.containsKey(Integer.valueOf(1024))) {
                    paramSlidingMenuActivity.showToFront((QuoordFragment) paramSlidingMenuActivity.fragmentMap.get(Integer.valueOf(1024)), false);
                }
                for (; ; ) {
                    if ((!paramSlidingMenuActivity.getResources().getBoolean(2131558401)) || (paramSlidingMenuActivity.forumStatus.getRebrandingConfig() == null) || (paramSlidingMenuActivity.forumStatus.getRebrandingConfig().getOrder().size() <= 0)) {
                        break label705;
                    }
                    setDisplayName(paramSlidingMenuActivity, paramInt);
                    break;
                    localObject1 = AlertFragment.newInstance(paramInt);
                    paramSlidingMenuActivity.fragmentMap.put(Integer.valueOf(1024), localObject1);
                    paramSlidingMenuActivity.showToFront((IQuoordInterface) localObject1, true);
                }
                continue;
                if (paramSlidingMenuActivity.allForumStack.size() > 0) {
                    paramSlidingMenuActivity.showToFront((BaseListFragment) paramSlidingMenuActivity.allForumStack.peek(), false);
                } else {
                    localObject1 = ForumListFragment.newInstance("all_forum_statck_tag", paramInt);
                    paramSlidingMenuActivity.fragmentMap.put(Integer.valueOf(1018), localObject1);
                    paramSlidingMenuActivity.addFragmentToStack((IQuoordInterface) localObject1, "all_forum_statck_tag", true);
                    continue;
                    if (!paramSlidingMenuActivity.isShare) {
                        if (paramSlidingMenuActivity.allForumStack.size() > 0) {
                            paramSlidingMenuActivity.showToFront((BaseListFragment) paramSlidingMenuActivity.allForumStack.peek(), false);
                        }
                    }
                    for (; ; ) {
                        if ((!paramSlidingMenuActivity.getResources().getBoolean(2131558401)) || (paramSlidingMenuActivity.forumStatus.getRebrandingConfig() == null) || (paramSlidingMenuActivity.forumStatus.getRebrandingConfig().getOrder().size() <= 0)) {
                            break label948;
                        }
                        setDisplayName(paramSlidingMenuActivity, paramInt);
                        break;
                        localObject1 = ForumListFragment.newInstance("all_forum_statck_tag", paramInt);
                        paramSlidingMenuActivity.fragmentMap.put(Integer.valueOf(1018), localObject1);
                        paramSlidingMenuActivity.addFragmentToStack((IQuoordInterface) localObject1, "all_forum_statck_tag", true);
                        continue;
                        if (paramSlidingMenuActivity.allForumStack.size() > 0) {
                            paramSlidingMenuActivity.showToFront((BaseListFragment) paramSlidingMenuActivity.allForumStack.peek(), false);
                        } else {
                            localObject1 = ModerateFragment.newInstance(paramSlidingMenuActivity.forumStatus, null);
                            paramSlidingMenuActivity.fragmentMap.put(Integer.valueOf(1018), localObject1);
                            paramSlidingMenuActivity.addFragmentToStack((IQuoordInterface) localObject1, "all_forum_statck_tag", true);
                        }
                    }
                    paramSlidingMenuActivity.bar.setTitle(paramSlidingMenuActivity.forumStatus.tapatalkForum.getName());
                    continue;
                    if (paramSlidingMenuActivity.subscribeForumStack.size() > 0) {
                        localObject1 = (BaseListFragment) paramSlidingMenuActivity.subscribeForumStack.peek();
                        paramSlidingMenuActivity.showToFront((IQuoordInterface) localObject1, false);
                        if ((SlidingMenuActivity.needRefreshSubscribe) && ((localObject1 instanceof SubscribeForumFragment)) && (((SubscribeForumFragment) localObject1).adapter2 != null)) {
                            ((SubscribeForumFragment) localObject1).adapter2.refresh();
                        }
                        if ((SlidingMenuActivity.needRefreshSubscribe) && ((localObject1 instanceof SubForumFragment)) && (((SubForumFragment) localObject1).adapter != null)) {
                            ((SubForumFragment) localObject1).adapter.refresh();
                        }
                    }
                    for (; ; ) {
                        if (paramSlidingMenuActivity.subscirbeForum == null) {
                            break label1118;
                        }
                        paramSlidingMenuActivity.addFragmentToStack(SubForumFragment.newInstance(paramSlidingMenuActivity.subscirbeForum, "subscribe_forum_statck_tag"), "subscribe_forum_statck_tag", true);
                        break;
                        localObject1 = SubscribeForumFragment.newInstance();
                        paramSlidingMenuActivity.fragmentMap.put(Integer.valueOf(1019), localObject1);
                        paramSlidingMenuActivity.addFragmentToStack((IQuoordInterface) localObject1, "subscribe_forum_statck_tag", true);
                    }
                    continue;
                    if (paramSlidingMenuActivity.subscribeTopicStack.size() > 0) {
                        localObject1 = (BaseListFragment) paramSlidingMenuActivity.subscribeTopicStack.peek();
                        paramSlidingMenuActivity.showToFront((IQuoordInterface) localObject1, false);
                        if ((SlidingMenuActivity.needRefreshSubscribe) && ((localObject1 instanceof SubscribeTopicFragment)) && (((SubscribeForumFragment) localObject1).adapter2 != null)) {
                            ((SubscribeForumFragment) localObject1).adapter2.refresh();
                        }
                        if ((SlidingMenuActivity.needRefreshSubscribe) && ((localObject1 instanceof SubForumFragment)) && (((SubForumFragment) localObject1).adapter != null)) {
                            ((SubForumFragment) localObject1).adapter.refresh();
                        }
                    }
                    for (; ; ) {
                        if (paramSlidingMenuActivity.subscirbeForum == null) {
                            break label1270;
                        }
                        paramSlidingMenuActivity.addFragmentToStack(SubForumFragment.newInstance(paramSlidingMenuActivity.subscirbeForum, "subscribe_topic_statck_tag"), "subscribe_topic_statck_tag", true);
                        break;
                        localObject1 = SubscribeTopicFragment.newInstance();
                        paramSlidingMenuActivity.fragmentMap.put(Integer.valueOf(1036), localObject1);
                        paramSlidingMenuActivity.addFragmentToStack((IQuoordInterface) localObject1, "subscribe_topic_statck_tag", true);
                    }
                    continue;
                    if (paramSlidingMenuActivity.fragmentMap.containsKey(Integer.valueOf(1013))) {
                        paramSlidingMenuActivity.showToFront((BaseListFragment) paramSlidingMenuActivity.fragmentMap.get(Integer.valueOf(1013)), false);
                    } else {
                        localObject1 = TopicsFragment.newInstance(LatestTopicAdapter.UNREAD, null, paramInt);
                        paramSlidingMenuActivity.fragmentMap.put(Integer.valueOf(1013), localObject1);
                        paramSlidingMenuActivity.showToFront((IQuoordInterface) localObject1, true);
                        continue;
                        if (paramSlidingMenuActivity.fragmentMap.containsKey(Integer.valueOf(1013))) {
                            paramSlidingMenuActivity.showToFront((BaseListFragment) paramSlidingMenuActivity.fragmentMap.get(Integer.valueOf(1013)), false);
                        }
                        for (; ; ) {
                            if ((!paramSlidingMenuActivity.getResources().getBoolean(2131558401)) || (paramSlidingMenuActivity.forumStatus.getRebrandingConfig() == null) || (paramSlidingMenuActivity.forumStatus.getRebrandingConfig().getOrder().size() <= 0)) {
                                break label1460;
                            }
                            setDisplayName(paramSlidingMenuActivity, paramInt);
                            break;
                            localObject1 = TopicsFragment.newInstance(LatestTopicAdapter.UNREAD, null, paramInt);
                            paramSlidingMenuActivity.fragmentMap.put(Integer.valueOf(1013), localObject1);
                            paramSlidingMenuActivity.showToFront((IQuoordInterface) localObject1, true);
                        }
                        continue;
                        if (paramSlidingMenuActivity.fragmentMap.containsKey(Integer.valueOf(1014))) {
                            paramSlidingMenuActivity.showToFront((BaseListFragment) paramSlidingMenuActivity.fragmentMap.get(Integer.valueOf(1014)), false);
                        } else {
                            localObject1 = TopicsFragment.newInstance(LatestTopicAdapter.PARTICIPATED, null, paramInt);
                            paramSlidingMenuActivity.fragmentMap.put(Integer.valueOf(1014), localObject1);
                            paramSlidingMenuActivity.showToFront((IQuoordInterface) localObject1, true);
                            continue;
                            if (paramSlidingMenuActivity.fragmentMap.containsKey(Integer.valueOf(1016))) {
                                paramSlidingMenuActivity.showToFront((BaseListFragment) paramSlidingMenuActivity.fragmentMap.get(Integer.valueOf(1016)), false);
                            }
                            for (; ; ) {
                                if ((!paramSlidingMenuActivity.getResources().getBoolean(2131558401)) || (paramSlidingMenuActivity.forumStatus.getRebrandingConfig() == null) || (paramSlidingMenuActivity.forumStatus.getRebrandingConfig().getOrder().size() <= 0)) {
                                    break label1650;
                                }
                                setDisplayName(paramSlidingMenuActivity, paramInt);
                                break;
                                localObject1 = TopicsFragment.newInstance(LatestTopicAdapter.LATEST, null, paramInt);
                                paramSlidingMenuActivity.fragmentMap.put(Integer.valueOf(1016), localObject1);
                                paramSlidingMenuActivity.showToFront((IQuoordInterface) localObject1, true);
                            }
                            continue;
                            if (paramSlidingMenuActivity.fragmentMap.containsKey(Integer.valueOf(1020))) {
                                paramSlidingMenuActivity.showToFront((BaseListFragment) paramSlidingMenuActivity.fragmentMap.get(Integer.valueOf(1020)), false);
                            }
                            for (; ; ) {
                                if ((!paramSlidingMenuActivity.getResources().getBoolean(2131558401)) || (paramSlidingMenuActivity.forumStatus.getRebrandingConfig() == null) || (paramSlidingMenuActivity.forumStatus.getRebrandingConfig().getOrder().size() <= 0)) {
                                    break label1764;
                                }
                                setDisplayName(paramSlidingMenuActivity, paramInt);
                                break;
                                localObject1 = ConversationListFragment.newInstance();
                                paramSlidingMenuActivity.fragmentMap.put(Integer.valueOf(1020), localObject1);
                                paramSlidingMenuActivity.showToFront((IQuoordInterface) localObject1, true);
                            }
                            paramSlidingMenuActivity.bar.setTitle(paramSlidingMenuActivity.getString(2131100422));
                            continue;
                            if (paramSlidingMenuActivity.fragmentMap.containsKey(Integer.valueOf(1021))) {
                                paramSlidingMenuActivity.showToFront((BaseListFragment) paramSlidingMenuActivity.fragmentMap.get(Integer.valueOf(1021)), false);
                            } else {
                                localObject1 = PMListFragment.newInstance();
                                paramSlidingMenuActivity.fragmentMap.put(Integer.valueOf(1021), localObject1);
                                paramSlidingMenuActivity.showToFront((IQuoordInterface) localObject1, true);
                                continue;
                                showLogin(paramSlidingMenuActivity);
                                continue;
                                if (!paramSlidingMenuActivity.forumStatus.isRegister()) {
                                    openRegisterPage(paramSlidingMenuActivity);
                                }
                                for (; ; ) {
                                    if ((!paramSlidingMenuActivity.getResources().getBoolean(2131558401)) || (paramSlidingMenuActivity.forumStatus.getRebrandingConfig() == null) || (paramSlidingMenuActivity.forumStatus.getRebrandingConfig().getOrder().size() <= 0)) {
                                        break label1989;
                                    }
                                    setDisplayName(paramSlidingMenuActivity, paramInt);
                                    break;
                                    if (paramSlidingMenuActivity.fragmentMap.containsKey(Integer.valueOf(1026))) {
                                        paramSlidingMenuActivity.showToFront((QuoordFragment) paramSlidingMenuActivity.fragmentMap.get(Integer.valueOf(1026)), false);
                                    } else {
                                        localObject1 = ForumRegisterFragment.newInstance(paramSlidingMenuActivity.forumStatus);
                                        paramSlidingMenuActivity.fragmentMap.put(Integer.valueOf(1026), localObject1);
                                        paramSlidingMenuActivity.showToFront((IQuoordInterface) localObject1, true);
                                    }
                                }
                                paramSlidingMenuActivity.bar.setTitle(paramSlidingMenuActivity.getString(2131100295));
                                continue;
                                if (paramSlidingMenuActivity.fragmentMap.containsKey(Integer.valueOf(1028))) {
                                    paramSlidingMenuActivity.showToFront((QuoordFragment) paramSlidingMenuActivity.fragmentMap.get(Integer.valueOf(1028)), false);
                                } else {
                                    localObject1 = WhosOnlineFragment.newInstance(paramInt);
                                    paramSlidingMenuActivity.fragmentMap.put(Integer.valueOf(1028), localObject1);
                                    paramSlidingMenuActivity.showToFront((IQuoordInterface) localObject1, true);
                                    continue;
                                    if (paramSlidingMenuActivity.fragmentMap.containsKey(Integer.valueOf(1201))) {
                                        paramSlidingMenuActivity.showToFront((QuoordFragment) paramSlidingMenuActivity.fragmentMap.get(Integer.valueOf(1201)), false);
                                    }
                                    for (; ; ) {
                                        if ((!paramSlidingMenuActivity.getResources().getBoolean(2131558401)) || (paramSlidingMenuActivity.forumStatus.getRebrandingConfig() == null) || (paramSlidingMenuActivity.forumStatus.getRebrandingConfig().getOrder().size() <= 0)) {
                                            break label2187;
                                        }
                                        setDisplayName(paramSlidingMenuActivity, paramInt);
                                        break;
                                        localObject1 = BlogsFragment.newInstance();
                                        paramSlidingMenuActivity.fragmentMap.put(Integer.valueOf(1201), localObject1);
                                        paramSlidingMenuActivity.showToFront((IQuoordInterface) localObject1, true);
                                    }
                                    paramSlidingMenuActivity.bar.setTitle("");
                                    continue;
                                    if (paramSlidingMenuActivity.fragmentMap.containsKey(Integer.valueOf(1029))) {
                                        paramSlidingMenuActivity.showToFront((IQuoordInterface) paramSlidingMenuActivity.fragmentMap.get(Integer.valueOf(1029)), false);
                                    } else {
                                        localObject1 = SettingsFragment.newInstance(paramInt, paramSlidingMenuActivity.forumStatus);
                                        paramSlidingMenuActivity.fragmentMap.put(Integer.valueOf(1029), localObject1);
                                        paramSlidingMenuActivity.showToFront((IQuoordInterface) localObject1, true);
                                        continue;
                                        if (paramSlidingMenuActivity.fragmentMap.containsKey(Integer.valueOf(1038))) {
                                            paramSlidingMenuActivity.showToFront((IQuoordInterface) paramSlidingMenuActivity.fragmentMap.get(Integer.valueOf(1038)), false);
                                        } else {
                                            localObject1 = ModerationFragment.newInstance();
                                            paramSlidingMenuActivity.fragmentMap.put(Integer.valueOf(1038), localObject1);
                                            paramSlidingMenuActivity.showToFront((IQuoordInterface) localObject1, true);
                                            continue;
                                            if (paramSlidingMenuActivity.fragmentMap.containsKey(Integer.valueOf(2002))) {
                                                paramSlidingMenuActivity.showToFront((QuoordFragment) paramSlidingMenuActivity.fragmentMap.get(Integer.valueOf(2002)), false);
                                            } else {
                                                localObject1 = ForumFeedFragment.newInstance(paramSlidingMenuActivity.forumStatus.tapatalkForum.getId().intValue(), "feed_forum_stack_tag");
                                                paramSlidingMenuActivity.fragmentMap.put(Integer.valueOf(2002), localObject1);
                                                paramSlidingMenuActivity.addFragmentToStack((IQuoordInterface) localObject1, "feed_forum_stack_tag", true);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (((TabItem) ((ArrayList) localObject2).get(i)).getMenuid() == paramInt) {
                localObject1 = (TabItem) ((ArrayList) localObject2).get(i);
            }
            i += 1;
            break label390;
            localArrayList = RebrandingUtil.getTabItem(paramSlidingMenuActivity, paramSlidingMenuActivity.forumStatus);
            localObject1 = localObject3;
        } while (localArrayList == null);
        int i = 0;
        for (; ; ) {
            localObject1 = localObject2;
            if (i >= localArrayList.size()) {
                break;
            }
            if (((TabItem) localArrayList.get(i)).getMenuid() == paramInt) {
                localObject2 = (TabItem) localArrayList.get(i);
            }
            i += 1;
        }
    }

    public static void showFragment(SlidingMenuActivity paramSlidingMenuActivity, int paramInt, TabItem paramTabItem) {
        showFragment(paramSlidingMenuActivity, paramInt);
    }

    public static void showLogin(SlidingMenuActivity paramSlidingMenuActivity) {
        if (paramSlidingMenuActivity.loginFragmentStack.size() > 0) {
            paramSlidingMenuActivity.showToFront((QuoordFragment) paramSlidingMenuActivity.loginFragmentStack.peek(), false);
        }
        for (; ; ) {
            paramSlidingMenuActivity.bar.setTitle(paramSlidingMenuActivity.getString(2131100013));
            return;
            if ((paramSlidingMenuActivity.forumStatus.getUser() != null) && (!paramSlidingMenuActivity.forumStatus.getUser().equals(""))) {
                showNativeLoginView(paramSlidingMenuActivity);
            } else {
                TapatalkId localTapatalkId = TapatalkIdFactory.getTapatalkId(paramSlidingMenuActivity);
                if ((localTapatalkId.isTapatalkIdLogin()) && (localTapatalkId.isConfirmed())) {
                    if (paramSlidingMenuActivity.forumStatus.isSsoSign()) {
                        showSSoLoginView(paramSlidingMenuActivity);
                    } else if ((paramSlidingMenuActivity.forumStatus.isSsoLogin()) && (paramSlidingMenuActivity.accountInfo != null) && (paramSlidingMenuActivity.accountInfo.hasUser)) {
                        showSSoLoginView(paramSlidingMenuActivity);
                    } else {
                        showNativeLoginView(paramSlidingMenuActivity);
                    }
                } else if ((localTapatalkId.isTapatalkIdLogin()) && (!localTapatalkId.isConfirmed())) {
                    showNativeLoginView(paramSlidingMenuActivity);
                } else if (paramSlidingMenuActivity.forumStatus.isSsoSign()) {
                    showFaceBookLoginView(paramSlidingMenuActivity);
                } else {
                    showNativeLoginView(paramSlidingMenuActivity);
                }
            }
        }
    }

    public static void showNativeLoginView(SlidingMenuActivity paramSlidingMenuActivity) {
        ForumLoginFragment localForumLoginFragment = ForumLoginFragment.newInstance(paramSlidingMenuActivity.forumStatus.tapatalkForum.getUserName(), paramSlidingMenuActivity.forumStatus);
        paramSlidingMenuActivity.fragmentMap.put(Integer.valueOf(1027), localForumLoginFragment);
        paramSlidingMenuActivity.addFragmentToStack(localForumLoginFragment, "login_fragment_stack_tag", true);
    }

    public static void showRegister(SlidingMenuActivity paramSlidingMenuActivity) {
        if ((!paramSlidingMenuActivity.forumStatus.isSsoRegist()) && (!paramSlidingMenuActivity.forumStatus.isNativeRegist())) {
            openRegisterPage(paramSlidingMenuActivity);
            return;
        }
        if (paramSlidingMenuActivity.fragmentMap.containsKey(Integer.valueOf(1026))) {
            paramSlidingMenuActivity.addFragmentToStack((QuoordFragment) paramSlidingMenuActivity.fragmentMap.get(Integer.valueOf(1026)), "login_fragment_stack_tag", true);
            return;
        }
        ForumRegisterFragment localForumRegisterFragment = ForumRegisterFragment.newInstance(paramSlidingMenuActivity.forumStatus);
        paramSlidingMenuActivity.fragmentMap.put(Integer.valueOf(1026), localForumRegisterFragment);
        paramSlidingMenuActivity.addFragmentToStack(localForumRegisterFragment, "login_fragment_stack_tag", true);
    }

    public static void showSSoLoginView(SlidingMenuActivity paramSlidingMenuActivity) {
        ForumJoinFragment localForumJoinFragment = ForumJoinFragment.newInstance(paramSlidingMenuActivity.forumStatus, paramSlidingMenuActivity.accountInfo);
        paramSlidingMenuActivity.fragmentMap.put(Integer.valueOf(1027), localForumJoinFragment);
        paramSlidingMenuActivity.addFragmentToStack(localForumJoinFragment, "login_fragment_stack_tag", true);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/ics/slidingMenu/SlidingMenuTool.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */