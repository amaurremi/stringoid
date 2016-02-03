package com.quoord.tapatalkpro.adapter.forum;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.res.Resources;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.androidquery.callback.AjaxStatus;
import com.quoord.tapatalkpro.TapatalkApp;
import com.quoord.tapatalkpro.action.AddBannerInterface;
import com.quoord.tapatalkpro.action.SubscribeForumAndTopicAction;
import com.quoord.tapatalkpro.action.SubscribeForumAndTopicAction.SubscribeForumAndTopicActionCallBack;
import com.quoord.tapatalkpro.action.log.LogTopicSubscription;
import com.quoord.tapatalkpro.activity.forum.ForumActivityStatus;
import com.quoord.tapatalkpro.bean.Banner;
import com.quoord.tapatalkpro.bean.EngineResponse;
import com.quoord.tapatalkpro.bean.Forum;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.bean.NoTopicView;
import com.quoord.tapatalkpro.bean.RebrandingConfig;
import com.quoord.tapatalkpro.bean.TapatalkForum;
import com.quoord.tapatalkpro.bean.Topic;
import com.quoord.tapatalkpro.bean.TopicParser;
import com.quoord.tapatalkpro.cache.AppCacheManager;
import com.quoord.tapatalkpro.cache.ProtectedForumCache;
import com.quoord.tapatalkpro.ics.BaseListFragment;
import com.quoord.tapatalkpro.ics.forum.SubscribeForumFragment;
import com.quoord.tapatalkpro.ics.slidingMenu.SlidingMenuActivity;
import com.quoord.tapatalkpro.ics.topics.TopicImageAction;
import com.quoord.tapatalkpro.ics.topics.TopicImageAction.TopicImageCallBack;
import com.quoord.tapatalkpro.sqlhelper.SubscribeForumSqlHelper;
import com.quoord.tapatalkpro.ui.ButtomProgress;
import com.quoord.tapatalkpro.ui.GroupBean;
import com.quoord.tapatalkpro.util.Prefs;
import com.quoord.tapatalkpro.util.TapatalkEngine;
import com.quoord.tapatalkpro.util.ThemeUtil;
import com.quoord.tapatalkpro.util.Util;
import com.quoord.tapatalkpro.view.SectionTitleListView;
import com.quoord.tapatalkpro.view.SectionTitleListView.IphoneTreeHeaderAdapter;
import com.quoord.tapatalkpro.view.SectionTitleListView.OnScrollListenerForOtherUse;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class NewSubscribeForumAndTopicAdapter
        extends BaseExpandableListAdapter
        implements SectionTitleListView.IphoneTreeHeaderAdapter, AddBannerInterface, SubscribeForumAndTopicAction.SubscribeForumAndTopicActionCallBack, ExpandableListView.OnChildClickListener, AdapterView.OnItemLongClickListener, TopicImageAction.TopicImageCallBack {
    public int currentSelectedPosition = -1;
    public TapatalkEngine engine = null;
    private int favForumSize = 0;
    private LinearLayout footProgressView;
    public ArrayList<Forum> forumDatas = new ArrayList();
    private GroupBean forumGroup;
    private int forumSize = 0;
    public ForumStatus forumStatus;
    public String forumUrl;
    public ArrayList<GroupBean> groupList = new ArrayList();
    private SparseIntArray groupStatusMap;
    private SectionTitleListView groupTreeView;
    private ArrayList<String> ids = new ArrayList();
    public boolean isCanRefresh = true;
    public boolean isFirstLoading = true;
    private boolean isLandscape = false;
    public boolean isLoadingFinsh = false;
    public boolean isShowUnread = false;
    private LinearLayout layout;
    public boolean loadingMore = false;
    private boolean loadingMoreLatest = false;
    private LogTopicSubscription logTopicSubscription;
    public ArrayList<Object> mAllDatas = new ArrayList();
    private Activity mContext;
    private int mCountPerpage = 20;
    public int mLongclickItemPosition;
    private int mStart = 0;
    private GroupBean noData;
    private View noLayout;
    private NoTopicView noTopicView = new NoTopicView();
    public String stackType;
    public boolean startGetTopic = true;
    public SubscribeForumAndTopicAction subscribeForumAndTopicAction;
    public ArrayList<Object> topicDatas = new ArrayList();
    private GroupBean topicGroupBean;
    private TopicImageAction topicImageCall;
    private int total_topic_count = 0;
    public ArrayList<Forum> unreadForums = new ArrayList();
    public ArrayList<Object> unreadTopics = new ArrayList();
    private boolean updateLocalSubscribeForum = false;

    public NewSubscribeForumAndTopicAdapter(LinearLayout paramLinearLayout, String paramString1, String paramString2, ForumStatus paramForumStatus, Activity paramActivity, SectionTitleListView paramSectionTitleListView, BaseListFragment paramBaseListFragment) {
        this.layout = paramLinearLayout;
        this.stackType = paramString1;
        this.forumUrl = paramString2;
        this.topicImageCall = new TopicImageAction(paramActivity, this);
        this.subscribeForumAndTopicAction = new SubscribeForumAndTopicAction(paramForumStatus, paramActivity, paramString1, this, this);
        this.logTopicSubscription = new LogTopicSubscription(paramActivity);
        this.groupTreeView = paramSectionTitleListView;
        this.mContext = paramActivity;
        this.forumStatus = paramForumStatus;
        this.footProgressView = ButtomProgress.get(this.mContext);
        this.noLayout = this.noTopicView.getItemView(this.mContext, this.mContext.getString(2131100154));
        initGroup();
        paramSectionTitleListView.addFooterView(this.footProgressView);
        paramSectionTitleListView.setAdapter(this);
        getLocalSubscribeForum();
        getData();
        this.groupStatusMap = new SparseIntArray();
        paramLinearLayout = this.mContext.getActionBar();
        paramLinearLayout.setDisplayHomeAsUpEnabled(true);
        paramLinearLayout.setDisplayShowTitleEnabled(true);
        this.mContext.invalidateOptionsMenu();
        paramSectionTitleListView.setOnChildClickListener(this);
        paramSectionTitleListView.setOnItemLongClickListener(this);
        getMoreTopics();
        int i = 0;
        for (; ; ) {
            if (i >= getGroupCount()) {
                return;
            }
            paramSectionTitleListView.expandGroup(i);
            i += 1;
        }
    }

    private void getLocalSubscribeForum() {
        ArrayList localArrayList = new SubscribeForumSqlHelper(this.mContext, TapatalkApp.database_name, null, Integer.parseInt(TapatalkApp.database_version)).get(this.forumStatus.getUrl());
        int i = 0;
        if (i >= localArrayList.size()) {
            if (this.forumDatas.size() != 0) {
                if (!this.groupList.contains(this.forumGroup)) {
                    this.groupList.add(this.forumGroup);
                }
                this.forumGroup.setChildrenList(this.forumDatas);
            }
            this.forumSize = this.forumDatas.size();
            this.favForumSize = this.forumDatas.size();
            notifyDataSetChanged();
            return;
        }
        if (!this.ids.contains(((Forum) localArrayList.get(i)).getId())) {
            ((Forum) localArrayList.get(i)).setSubscribe(true);
            this.ids.add(((Forum) localArrayList.get(i)).getId());
            if (!this.isShowUnread) {
                break label232;
            }
            if (this.forumStatus.checkNewPost(((Forum) localArrayList.get(i)).getId())) {
                this.forumDatas.add((Forum) localArrayList.get(i));
            }
        }
        for (; ; ) {
            this.mAllDatas.add(localArrayList.get(i));
            i += 1;
            break;
            label232:
            this.forumDatas.add((Forum) localArrayList.get(i));
        }
    }

    public void actionCallBack(EngineResponse paramEngineResponse) {
        Object localObject1 = paramEngineResponse.getMethod();
        Object localObject2;
        if ((((String) localObject1).equals("get_subscribed_forum")) || (((String) localObject1).contains("au_get_subscribed_forums"))) {
            if (((String) localObject1).equals("get_subscribed_forum")) {
                localObject2 = (Object[]) ((HashMap) paramEngineResponse.getResponse()).get("forums");
                if ((localObject2 != null) && (localObject2.length > 0)) {
                    i = 0;
                    if (i < localObject2.length) {
                        break label671;
                    }
                    this.favForumSize = this.forumDatas.size();
                }
                this.subscribeForumAndTopicAction.getTapatalkSubscribeForum();
            }
            if (!((String) localObject1).contains("au_get_subscribed_forums")) {
            }
        }
        try {
            localObject1 = (JSONArray) ((JSONObject) paramEngineResponse.getResponse()).get("subscribed_forums");
            i = 0;
            label126:
            if (i < ((JSONArray) localObject1).length()) {
                break label784;
            }
            this.favForumSize = this.forumDatas.size();
            this.groupTreeView.setVisibility(0);
        } catch (Exception localException) {
            int j;
            for (; ; ) {
            }
        }
        if ((this.forumDatas.size() != 0) && (!this.loadingMoreLatest)) {
            if (!this.groupList.contains(this.forumGroup)) {
                this.groupList.add(0, this.forumGroup);
            }
            this.forumGroup.setChildrenList(this.forumDatas);
            if (this.layout.getChildCount() != 0) {
                this.layout.removeView(this.noLayout);
            }
        }
        if (this.startGetTopic) {
            this.subscribeForumAndTopicAction.get_subscribe_topic(this.mStart, this.mCountPerpage);
            this.startGetTopic = false;
        }
        if (paramEngineResponse.getMethod().equals("get_subscribed_topic")) {
            localObject1 = new ArrayList();
            j = this.topicDatas.size();
            this.isCanRefresh = false;
            Prefs.get(this.mContext);
            localObject2 = (HashMap) paramEngineResponse.getResponse();
            paramEngineResponse = (Object[]) ((HashMap) localObject2).get("topics");
            if (((HashMap) localObject2).containsKey("total_topic_num")) {
                this.total_topic_count = ((Integer) ((HashMap) localObject2).get("total_topic_num")).intValue();
            }
            this.mStart += this.mCountPerpage;
            if ((paramEngineResponse != null) && (paramEngineResponse.length > 0)) {
                i = 0;
                if (i < paramEngineResponse.length) {
                    break label917;
                }
            }
            if (((ArrayList) localObject1).size() > 0) {
                if (this.forumStatus.tapatalkForum.isHasImage()) {
                    this.topicImageCall.getTopicImgUrl(this.forumStatus.tapatalkForum.getId(), (ArrayList) localObject1);
                }
                this.logTopicSubscription.log(this.forumStatus.tapatalkForum.getId().intValue(), this.forumStatus.tapatalkForum.getUserId(), (ArrayList) localObject1);
            }
            if ((this.topicDatas.size() == 0) && (this.forumDatas.size() == 0)) {
                this.groupList.clear();
                this.layout.addView(this.noLayout);
            }
            if ((this.topicDatas.size() != 0) && (!this.loadingMoreLatest)) {
                if (!this.groupList.contains(this.topicGroupBean)) {
                    this.groupList.add(this.topicGroupBean);
                }
                this.topicGroupBean.setChildrenList(this.topicDatas);
            }
            this.groupTreeView.removeFooterView(this.footProgressView);
            this.loadingMoreLatest = false;
            if (j == this.topicDatas.size()) {
                this.isLoadingFinsh = true;
            }
            this.isCanRefresh = true;
            this.isFirstLoading = false;
            if (!this.forumStatus.isSubscribeLoad()) {
                this.total_topic_count = (this.topicDatas.size() - 1);
            }
            if ((!this.mContext.getApplicationContext().getResources().getBoolean(2131558401)) && (!this.forumStatus.isPush())) {
                this.loadingMore = false;
            }
        }
        int i = 0;
        for (; ; ) {
            if (i >= getGroupCount()) {
                notifyDataSetChanged();
                return;
                label671:
                Forum localForum = Forum.createForumBean((HashMap) localObject2[i], this.forumStatus, this.mContext, null, null, 0);
                if (!this.ids.contains(localForum.getId())) {
                    saveSubscribevForum(localForum);
                    this.ids.add(localForum.getId());
                    this.updateLocalSubscribeForum = true;
                    if (!this.forumDatas.contains(localForum)) {
                        this.forumDatas.add(localForum);
                    }
                    if (!this.mAllDatas.contains(localForum)) {
                        this.mAllDatas.add(localForum);
                    }
                }
                i += 1;
                break;
                label784:
                localObject2 = ((JSONObject) ((JSONArray) localObject1).get(i)).getString("sfid");
                localObject2 = this.forumStatus.getForumById(this.mContext, (String) localObject2);
                if ((localObject2 != null) && (!this.ids.contains(((Forum) localObject2).getId()))) {
                    ((Forum) localObject2).setSubscribe(true);
                    saveSubscribevForum((Forum) localObject2);
                    this.ids.add(((Forum) localObject2).getId());
                    if (!this.forumDatas.contains(localObject2)) {
                        this.forumDatas.add(localObject2);
                    }
                    if (!this.mAllDatas.contains(localObject2)) {
                        this.mAllDatas.add(localObject2);
                    }
                    this.updateLocalSubscribeForum = true;
                }
                i += 1;
                break label126;
                label917:
                localObject2 = TopicParser.createTopicBean((HashMap) paramEngineResponse[i], null, this.mContext, this.forumStatus);
                ((ArrayList) localObject1).add(((Topic) localObject2).getId());
                ((Topic) localObject2).setSubscribe(true);
                ((Topic) localObject2).setCanSubscribe(true);
                addBanner(this.mContext, this.topicDatas);
                if (!this.ids.contains(((Topic) localObject2).getId())) {
                    if (!this.isShowUnread) {
                        break label1042;
                    }
                    if (((Topic) localObject2).getNewPost()) {
                        this.topicDatas.add(localObject2);
                    }
                }
                for (; ; ) {
                    this.ids.add(((Topic) localObject2).getId());
                    this.mAllDatas.add(localObject2);
                    i += 1;
                    break;
                    label1042:
                    this.topicDatas.add(localObject2);
                }
            }
            this.groupTreeView.expandGroup(i);
            i += 1;
        }
    }

    public void addBanner(Activity paramActivity, ArrayList<Object> paramArrayList) {
        if ((this.forumStatus != null) && (this.forumStatus.getRebrandingConfig() != null) && (this.forumStatus.isAdShow()) && (((this.forumStatus.getRebrandingConfig().getDfp_320x50() != null) && (!this.forumStatus.getRebrandingConfig().getDfp_320x50().equals(""))) || ((this.forumStatus.getRebrandingConfig().getAdmobId() != null) && (!this.forumStatus.getRebrandingConfig().getAdmobId().equals(""))))) {
            Banner.addBanner(paramActivity, paramArrayList);
        }
    }

    public void addRebrandBanner() {
    }

    public void changeData() {
        this.groupTreeView.setVisibility(0);
        this.layout.removeView(this.noLayout);
        this.unreadForums.clear();
        this.unreadTopics.clear();
        this.topicDatas.clear();
        this.forumDatas.clear();
        int i;
        if (this.isShowUnread) {
            i = 0;
            if (i >= this.mAllDatas.size()) {
                this.topicDatas = this.unreadTopics;
                this.forumDatas = this.unreadForums;
                resetGroupBeanDatas();
                if ((this.unreadForums.size() != 0) || (this.unreadTopics.size() != 0)) {
                    break label251;
                }
                this.groupList.clear();
                this.layout.addView(this.noLayout);
                label125:
                i = 0;
            }
        }
        for (; ; ) {
            if (i >= getGroupCount()) {
                notifyDataSetChanged();
                return;
                if (((this.mAllDatas.get(i) instanceof Forum)) && (this.forumStatus.checkNewPost(((Forum) this.mAllDatas.get(i)).getId()))) {
                    this.unreadForums.add((Forum) this.mAllDatas.get(i));
                }
                if (((this.mAllDatas.get(i) instanceof Topic)) && (((Topic) this.mAllDatas.get(i)).getNewPost())) {
                    this.unreadTopics.add(this.mAllDatas.get(i));
                }
                i += 1;
                break;
                label251:
                if ((this.forumDatas.size() == 0) && (this.groupList.contains(this.forumGroup))) {
                    this.groupList.remove(this.forumGroup);
                }
                if ((this.topicDatas.size() != 0) || (!this.groupList.contains(this.topicGroupBean))) {
                    break label125;
                }
                this.groupList.remove(this.topicGroupBean);
                break label125;
                this.isLoadingFinsh = false;
                initGroup();
                i = 0;
                for (; ; ) {
                    if (i >= this.mAllDatas.size()) {
                        if ((this.forumDatas.size() != 0) || (this.topicDatas.size() != 0)) {
                            break label462;
                        }
                        this.groupList.clear();
                        this.layout.addView(this.noLayout);
                        break;
                    }
                    if ((this.mAllDatas.get(i) instanceof Forum)) {
                        this.forumDatas.add((Forum) this.mAllDatas.get(i));
                    }
                    if ((this.mAllDatas.get(i) instanceof Topic)) {
                        this.topicDatas.add((Topic) this.mAllDatas.get(i));
                    }
                    i += 1;
                }
                label462:
                if (this.forumDatas.size() != 0) {
                    this.groupList.add(this.forumGroup);
                }
                if (this.topicDatas.size() != 0) {
                    this.groupList.add(this.topicGroupBean);
                }
                resetGroupBeanDatas();
                break label125;
            }
            this.groupTreeView.expandGroup(i);
            i += 1;
        }
    }

    public void configureTreeHeader(View paramView, int paramInt1, int paramInt2, int paramInt3) {
        ((TextView) paramView.findViewById(2131231075)).setText(((GroupBean) this.groupList.get(paramInt1)).getTitle());
        Util.setBg(paramView, ThemeUtil.getDrawableByPicName("ob_section_title", this.mContext));
    }

    public Object getChild(int paramInt1, int paramInt2) {
        return ((GroupBean) this.groupList.get(paramInt1)).getChildrenList().get(paramInt2);
    }

    public long getChildId(int paramInt1, int paramInt2) {
        return paramInt1 * 100 + paramInt2;
    }

    public View getChildView(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup) {
        Object localObject = ((GroupBean) this.groupList.get(paramInt1)).getChildrenList().get(paramInt2);
        if ((localObject instanceof Topic)) {
            paramViewGroup = (Topic) localObject;
            localObject = new HashMap();
            ((HashMap) localObject).put("showForumName", Boolean.valueOf(true));
            ((HashMap) localObject).put("isSubscribedTab", Boolean.valueOf(true));
            paramView = paramViewGroup.createView((HashMap) localObject, paramView, (ForumActivityStatus) this.mContext);
        }
        for (; ; ) {
            paramView.setTag(2131231366, Integer.valueOf(paramInt1));
            paramView.setTag(2131231367, Integer.valueOf(paramInt2));
            return paramView;
            if ((localObject instanceof Forum)) {
                paramView = getForumView(paramInt1, paramInt2, paramView, paramViewGroup);
            } else {
                paramView = this.noTopicView.getItemView(this.mContext, this.mContext.getString(2131100154));
            }
        }
    }

    public int getChildrenCount(int paramInt) {
        if (paramInt < 0) {
            return 0;
        }
        return ((GroupBean) this.groupList.get(paramInt)).getChildrenList().size();
    }

    public void getData() {
        if ((this.forumStatus.getApiLevel() >= 3) && (this.forumStatus.isSubscribeForum())) {
            this.subscribeForumAndTopicAction.get_subscribe_forum();
            return;
        }
        this.subscribeForumAndTopicAction.get_subscribe_topic(this.mStart, this.mCountPerpage);
    }

    public Object getForumItem(int paramInt) {
        if ((this.forumDatas != null) && (this.forumDatas.size() > 0)) {
            return this.forumDatas.get(paramInt);
        }
        return null;
    }

    public View getForumView(int paramInt1, int paramInt2, View paramView, ViewGroup paramViewGroup) {
        if (paramInt2 == 0) {
            return Forum.getForumView(Forum.TOP_FORUM_ITEM, (Forum) getForumItem(paramInt2), paramView, paramViewGroup, this.forumStatus, this.mContext, null, true);
        }
        if (paramInt2 == this.favForumSize - 1) {
            return Forum.getForumView(Forum.BOTTOM_FORUM_ITEM, (Forum) getForumItem(paramInt2), paramView, paramViewGroup, this.forumStatus, this.mContext, null, true);
        }
        return Forum.getForumView(Forum.MID_FORUM_ITEM, (Forum) getForumItem(paramInt2), paramView, paramViewGroup, this.forumStatus, this.mContext, null, true);
    }

    public Object getGroup(int paramInt) {
        return ((GroupBean) this.groupList.get(paramInt)).getTitle();
    }

    public int getGroupCount() {
        return this.groupList.size();
    }

    public long getGroupId(int paramInt) {
        return paramInt * 100;
    }

    public View getGroupView(int paramInt, boolean paramBoolean, View paramView, ViewGroup paramViewGroup) {
        paramViewGroup = paramView;
        if (paramView == null) {
            paramViewGroup = LayoutInflater.from(this.mContext).inflate(2130903356, null);
        }
        ((TextView) paramViewGroup.findViewById(2131231075)).setText(((GroupBean) this.groupList.get(paramInt)).getTitle());
        Util.setBg(paramViewGroup, ThemeUtil.getDrawableByPicName("ob_section_title", this.mContext));
        paramViewGroup.setTag(2131231366, Integer.valueOf(paramInt));
        return paramViewGroup;
    }

    public int getHeadViewClickStatus(int paramInt) {
        if (this.groupStatusMap.get(paramInt) != 0) {
            return this.groupStatusMap.get(paramInt);
        }
        return 0;
    }

    public boolean getIsLogin(String paramString) {
        boolean bool1 = false;
        boolean bool4 = false;
        boolean bool3 = false;
        boolean bool2 = bool4;
        try {
            String str = AppCacheManager.getForumSessionProtectedUrl(this.mContext, this.forumStatus.getUrl(), this.forumStatus.tapatalkForum.getCacheUsernameDir());
            bool2 = bool4;
            if (AppCacheManager.checkFile(str)) {
                bool2 = bool4;
                ProtectedForumCache localProtectedForumCache = AppCacheManager.getForumSessionProtected(str);
                bool1 = bool3;
                if (localProtectedForumCache != null) {
                    bool1 = bool3;
                    bool2 = bool4;
                    if (localProtectedForumCache.protects != null) {
                        bool1 = bool3;
                        bool2 = bool4;
                        if (localProtectedForumCache.protects.containsKey(paramString)) {
                            bool1 = true;
                        }
                    }
                }
                bool2 = bool1;
                localProtectedForumCache.writeTime = System.currentTimeMillis();
                bool2 = bool1;
                AppCacheManager.cacheData(str, localProtectedForumCache);
            }
            return bool1;
        } catch (Exception paramString) {
        }
        return bool2;
    }

    public void getMoreTopics() {
        this.groupTreeView.setOnScrollListenerForOther(new SectionTitleListView.OnScrollListenerForOtherUse() {
            public void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {
                if ((paramAnonymousInt1 + paramAnonymousInt2 == paramAnonymousInt3) && (!NewSubscribeForumAndTopicAdapter.this.loadingMoreLatest) && (NewSubscribeForumAndTopicAdapter.this.isFootNeeded()) && (!NewSubscribeForumAndTopicAdapter.this.isLoadingFinsh) && (NewSubscribeForumAndTopicAdapter.this.topicGroupBean != null) && (NewSubscribeForumAndTopicAdapter.this.groupList.contains(NewSubscribeForumAndTopicAdapter.this.topicGroupBean))) {
                    NewSubscribeForumAndTopicAdapter.this.groupTreeView.addFooterView(NewSubscribeForumAndTopicAdapter.this.footProgressView);
                    NewSubscribeForumAndTopicAdapter.this.loadingMoreLatest = true;
                    NewSubscribeForumAndTopicAdapter.this.isCanRefresh = false;
                    NewSubscribeForumAndTopicAdapter.this.subscribeForumAndTopicAction.get_subscribe_topic(NewSubscribeForumAndTopicAdapter.this.mStart, NewSubscribeForumAndTopicAdapter.this.mCountPerpage);
                }
            }

            public void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt) {
            }
        });
    }

    public SubscribeForumAndTopicAction getSubscribeForumAndTopicAction() {
        return this.subscribeForumAndTopicAction;
    }

    public int getTreeHeaderState(int paramInt1, int paramInt2) {
        if (paramInt2 == getChildrenCount(paramInt1) - 1) {
            return 2;
        }
        if ((paramInt2 == -1) && (!this.groupTreeView.isGroupExpanded(paramInt1))) {
            return 0;
        }
        return 1;
    }

    public void getUnreadSubcribe(boolean paramBoolean) {
        this.isShowUnread = paramBoolean;
        if ((this.isCanRefresh) && (!this.isFirstLoading)) {
            changeData();
        }
    }

    public boolean hasStableIds() {
        return true;
    }

    public void imageLoad(JSONObject paramJSONObject, AjaxStatus paramAjaxStatus) {
        int i;
        if (paramJSONObject != null) {
            i = 0;
        }
        for (; ; ) {
            if (i >= this.topicDatas.size()) {
                notifyDataSetChanged();
                return;
            }
            if ((this.topicDatas.get(i) instanceof Topic)) {
                paramAjaxStatus = ((Topic) this.topicDatas.get(i)).getId();
                if (!paramJSONObject.has(paramAjaxStatus)) {
                }
            }
            try {
                paramAjaxStatus = paramJSONObject.getString(paramAjaxStatus);
                if ((paramAjaxStatus != null) && (!paramAjaxStatus.equals(""))) {
                    ((Topic) this.topicDatas.get(i)).setTopicImgUrl(paramAjaxStatus);
                }
            } catch (JSONException paramAjaxStatus) {
                for (; ; ) {
                    paramAjaxStatus.printStackTrace();
                }
            }
            i += 1;
        }
    }

    public void initGroup() {
        if (this.groupList == null) {
            this.groupList = new ArrayList();
        }
        this.groupList.clear();
        this.noData = new GroupBean("");
        this.forumGroup = new GroupBean(this.mContext.getString(2131100710));
        this.topicGroupBean = new GroupBean(this.mContext.getString(2131100711));
    }

    public boolean isChildSelectable(int paramInt1, int paramInt2) {
        return true;
    }

    public boolean isFootNeeded() {
        return this.mStart < this.total_topic_count;
    }

    public void noData(boolean paramBoolean) {
        if (paramBoolean) {
            this.groupTreeView.setVisibility(8);
        }
        this.layout.addView(this.noTopicView.getItemView(this.mContext, this.mContext.getString(2131100154)));
    }

    public boolean onChildClick(ExpandableListView paramExpandableListView, View paramView, int paramInt1, int paramInt2, long paramLong) {
        if ((paramInt1 == 3) && (paramInt2 >= this.topicGroupBean.getChildrenList().size())) {
        }
        do {
            do {
                do {
                    return true;
                    if (!(getChild(paramInt1, paramInt2) instanceof Forum)) {
                        break;
                    }
                } while (!(this.mContext instanceof SlidingMenuActivity));
                boolean bool = false;
                if (((Forum) getChild(paramInt1, paramInt2)).isProtected()) {
                    bool = getIsLogin(((Forum) getChild(paramInt1, paramInt2)).getId());
                }
                this.subscribeForumAndTopicAction.forumItemClicked((Forum) getChild(paramInt1, paramInt2), bool, (SlidingMenuActivity) this.mContext, this.stackType);
                return true;
            }
            while ((!(getChild(paramInt1, paramInt2) instanceof Topic)) || (this.mContext == null) || (this.forumStatus == null));
            ((Topic) getChild(paramInt1, paramInt2)).openThreadAndChangeUnreadNum(this, this.mContext, this.forumStatus);
        } while (!(((SlidingMenuActivity) this.mContext).currentFragment instanceof SubscribeForumFragment));
        ((SubscribeForumFragment) ((SlidingMenuActivity) this.mContext).currentFragment).setIdByTwoPanel(((Topic) getChild(paramInt1, paramInt2)).getId());
        return true;
    }

    public void onHeadViewClick(int paramInt1, int paramInt2) {
        this.groupStatusMap.put(paramInt1, paramInt2);
    }

    public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {
        if ((paramView.getTag(2131231366) != null) && (paramView.getTag(2131231367) != null)) {
            paramInt = ((Integer) paramView.getTag(2131231366)).intValue();
            int i = ((Integer) paramView.getTag(2131231367)).intValue();
            this.mLongclickItemPosition = i;
            paramAdapterView = ((GroupBean) this.groupList.get(paramInt)).getChildrenList().get(i);
            if ((paramAdapterView instanceof Forum)) {
                ((Forum) paramAdapterView).getLongPressDialogFragment(this, this.mContext).show();
            }
            if ((paramAdapterView instanceof Topic)) {
                ((Topic) paramAdapterView).getLongClickDialog(this, this.mContext, this.forumStatus).show();
            }
        }
        return false;
    }

    public void refresh() {
        if (this.isCanRefresh) {
            this.forumSize = 0;
            this.startGetTopic = true;
            this.isCanRefresh = false;
            this.layout.removeView(this.noLayout);
            getSubscribeForumAndTopicAction().setOpCancel(false);
            if (this.groupTreeView.getFooterViewsCount() == 0) {
                this.groupTreeView.addFooterView(this.footProgressView);
            }
            this.mStart = 0;
            this.favForumSize = 0;
            this.total_topic_count = 0;
            this.ids.clear();
            this.forumDatas.clear();
            this.mAllDatas.clear();
            this.topicDatas.clear();
            if (this.groupList.contains(this.topicGroupBean)) {
                this.groupList.remove(this.topicGroupBean);
            }
            this.groupTreeView.setmHeaderViewVisible(false);
            notifyDataSetChanged();
            getLocalSubscribeForum();
            getData();
        }
    }

    public void removeForumsItem(Object paramObject) {
        this.forumDatas.remove(paramObject);
        this.mAllDatas.remove(paramObject);
        if (this.forumDatas.size() == 0) {
            this.groupList.remove(this.forumGroup);
            if (this.topicDatas.size() == 0) {
                this.layout.addView(this.noLayout);
            }
        }
        notifyDataSetChanged();
    }

    public void removeTopicsItem(Object paramObject) {
        this.topicDatas.remove(paramObject);
        this.mAllDatas.remove(paramObject);
        this.total_topic_count -= 1;
        if (this.topicDatas.size() == 0) {
            this.groupList.remove(this.topicGroupBean);
            if (this.forumDatas.size() == 0) {
                this.layout.addView(this.noLayout);
            }
        }
        notifyDataSetChanged();
    }

    public void resetGroupBeanDatas() {
        if (this.forumDatas.size() > 0) {
            this.forumGroup.setChildrenList(this.forumDatas);
        }
        if (this.topicDatas.size() > 0) {
            this.topicGroupBean.setChildrenList(this.topicDatas);
        }
    }

    public void saveSubscribevForum(Forum paramForum) {
        new SubscribeForumSqlHelper(this.mContext, TapatalkApp.database_name, null, Integer.parseInt(TapatalkApp.database_version)).save(paramForum, this.forumStatus.getUrl());
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/adapter/forum/NewSubscribeForumAndTopicAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */