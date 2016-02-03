package com.quoord.tapatalkpro.feed;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.DrawerLayout;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.BaseAdapter;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.HeaderViewListAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.quoord.tapatalkpro.TapatalkApp;
import com.quoord.tapatalkpro.action.FeedAction;
import com.quoord.tapatalkpro.action.FeedAction.FeedActionCallBack;
import com.quoord.tapatalkpro.action.OpenThreadAction;
import com.quoord.tapatalkpro.action.TapatalkAccountAction;
import com.quoord.tapatalkpro.activity.directory.ics.AccountEntryActivity;
import com.quoord.tapatalkpro.activity.forum.PMContentActivity;
import com.quoord.tapatalkpro.activity.forum.ThreadActivity;
import com.quoord.tapatalkpro.activity.forum.conversation.ConverSationActivity;
import com.quoord.tapatalkpro.bean.Conversation;
import com.quoord.tapatalkpro.bean.Feed;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.bean.PrivateMessage;
import com.quoord.tapatalkpro.bean.TapatalkForum;
import com.quoord.tapatalkpro.bean.TapatalkId;
import com.quoord.tapatalkpro.bean.Topic;
import com.quoord.tapatalkpro.ics.tapatalkid.TapatalkIdFactory;
import com.quoord.tapatalkpro.sqlhelper.FavoriateSqlHelper;
import com.quoord.tapatalkpro.ui.ButtomProgress;
import com.quoord.tapatalkpro.ui.GroupBean;
import com.quoord.tapatalkpro.ui.ics.QuoordFragment;
import com.quoord.tapatalkpro.util.CustomTrackType;
import com.quoord.tapatalkpro.util.Prefs;
import com.quoord.tapatalkpro.util.TapatalkJsonEngine;
import com.quoord.tapatalkpro.util.ThemeUtil;
import com.quoord.tapatalkpro.util.Util;
import com.quoord.tapatalkpro.view.SectionTitleListView;
import com.quoord.tapatalkpro.view.SectionTitleListView.OnScrollListenerForOtherUse;
import com.quoord.tools.directoryurl.DirectoryUrlUtil;
import com.quoord.tools.net.TapatalkAjaxLogAction;
import com.quoord.tools.net.TapatalkLogUrlUtil;
import com.quoord.tools.tracking.GoogleAnalyticsTools;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class FeedFragment
        extends QuoordFragment
        implements ExpandableListView.OnChildClickListener {
    private static int OPENCONVERSATION = 2;
    private static int OPENPRIVATEMESSAGE;
    private static int OPENTHREADACTIVITY = 3;
    private static int UPDATENOTIFICATION;
    private static String defaultValue;
    private static String saveKey_ArrayList;
    private static String saveKey_String = "id";
    public FeedListAdapter adapter;
    public boolean autoRefreshFromSettings = false;
    private String categoryId = null;
    private int child_position;
    public int default_notification_num;
    private Feed feed;
    private FeedAction feedAction;
    private TextView feedHint;
    private ArrayList<Object> feedList = new ArrayList();
    public int finalWidth;
    public LinearLayout footLay;
    private ArrayList<String> forumsList = null;
    private SectionTitleListView groupTreeView;
    public Handler handler = new Handler() {
        public void handleMessage(Message paramAnonymousMessage) {
            if (paramAnonymousMessage.what == FeedFragment.UPDATENOTIFICATION) {
                FeedFragment.this.updateNotificationFeeds(FeedFragment.this.feed.getFeed_id());
                FeedFragment.this.adapter.notificationGroupBean.getChildrenList().remove(FeedFragment.this.child_position);
                if (FeedFragment.this.notifiDatas.size() > 0) {
                    FeedFragment.this.feedList.add(FeedFragment.this.notifiDatas.get(0));
                    FeedFragment.this.notifiDatas.remove(FeedFragment.this.notifiDatas.get(0));
                }
                if (FeedFragment.this.feedList.size() == 0) {
                    FeedFragment.this.adapter.groupList.remove(0);
                }
                FeedFragment.this.adapter.notifyDataSetChanged();
            }
            do {
                return;
                Intent localIntent;
                Object localObject;
                if (paramAnonymousMessage.what == FeedFragment.OPENPRIVATEMESSAGE) {
                    paramAnonymousMessage = FeedFragment.this.getPM(FeedFragment.this.feed.getId());
                    paramAnonymousMessage.setMsgState(0);
                    localIntent = new Intent();
                    localIntent.setClass(FeedFragment.this.mActivity, PMContentActivity.class);
                    localObject = new Bundle();
                    ((Bundle) localObject).putSerializable("pm", paramAnonymousMessage);
                    ((Bundle) localObject).putSerializable("forumStatus", FeedFragment.this.adapter.forumStatus);
                    localIntent.putExtras((Bundle) localObject);
                    FeedFragment.this.mActivity.startActivity(localIntent);
                    try {
                        FeedFragment.this.logAction.logTapatalkLog(TapatalkLogUrlUtil.getFeedLogUrl(FeedFragment.this.mActivity, FeedFragment.this.tapatalkForum.getId().intValue(), paramAnonymousMessage.getMsgId(), 1));
                        return;
                    } catch (Exception paramAnonymousMessage) {
                        return;
                    }
                }
                if (paramAnonymousMessage.what == FeedFragment.OPENCONVERSATION) {
                    paramAnonymousMessage = FeedFragment.this.getConv(FeedFragment.this.feed.getId());
                    paramAnonymousMessage.setNew_post(false);
                    localIntent = new Intent();
                    localIntent.setClass(FeedFragment.this.mActivity, ConverSationActivity.class);
                    localObject = new HashMap();
                    ((HashMap) localObject).put("forumStatus", FeedFragment.this.adapter.forumStatus);
                    ((HashMap) localObject).put("conv_id", paramAnonymousMessage.getConv_id());
                    ((HashMap) localObject).put("fid", FeedFragment.this.feed.getFid());
                    localIntent.putExtra("hashmap", (Serializable) localObject);
                    localIntent.putExtra("viewConvos", true);
                    FeedFragment.this.mActivity.startActivity(localIntent);
                    try {
                        FeedFragment.this.logAction.logTapatalkLog(TapatalkLogUrlUtil.getFeedLogUrl(FeedFragment.this.mActivity, FeedFragment.this.tapatalkForum.getId().intValue(), paramAnonymousMessage.getConv_id(), 1));
                        return;
                    } catch (Exception paramAnonymousMessage) {
                        return;
                    }
                }
            } while (paramAnonymousMessage.what != FeedFragment.OPENTHREADACTIVITY);
            paramAnonymousMessage = new Intent();
            paramAnonymousMessage.putExtra("fid", FeedFragment.this.feed.getFid());
            paramAnonymousMessage.putExtra("topic", FeedFragment.this.getTopic(FeedFragment.this.feed.getId(), FeedFragment.this.feed.getSub_id()));
            paramAnonymousMessage.putExtra("post_id", FeedFragment.this.feed.getId());
            paramAnonymousMessage.putExtra("forumStatus", FeedFragment.this.adapter.forumStatus);
            paramAnonymousMessage.putExtra("forum", FeedFragment.this.adapter.forumStatus.tapatalkForum);
            paramAnonymousMessage.putExtra("fromFeed", true);
            paramAnonymousMessage.setClass(FeedFragment.this.mActivity, ThreadActivity.class);
            FeedFragment.this.mActivity.startActivity(paramAnonymousMessage);
            try {
                FeedFragment.this.logAction.logTapatalkLog(TapatalkLogUrlUtil.getFeedLogUrl(FeedFragment.this.mActivity, FeedFragment.this.tapatalkForum.getId().intValue(), FeedFragment.this.feed.getId(), 2));
                return;
            } catch (Exception paramAnonymousMessage) {
            }
        }
    };
    private boolean isLoadMore = true;
    private boolean isShowNotif = true;
    private boolean isUseSelfdata = true;
    private TapatalkAjaxLogAction logAction;
    public Activity mActivity;
    public ArrayList<TapatalkForum> mAllDatas = new ArrayList();
    private String newUrl;
    private LinearLayout noDataText;
    private ArrayList<Object> notifiDatas = new ArrayList();
    private ArrayList<String> notifiList = null;
    private String oldUrl;
    public int page = 1;
    private SharedPreferences prefs;
    private FavoriateSqlHelper sqlHelper;
    public TapatalkForum tapatalkForum;
    public ArrayList<Object> topicList = new ArrayList();
    private ArrayList<String> userList = null;

    static {
        saveKey_ArrayList = "ids";
        defaultValue = "default";
        UPDATENOTIFICATION = 0;
        OPENPRIVATEMESSAGE = 1;
    }

    private void checkCategoryId() {
        if ((getArguments() != null) && (getArguments().containsKey(saveKey_String))) {
            String str = getArguments().getString(saveKey_String, defaultValue);
            if (!str.equals(defaultValue)) {
                this.categoryId = str;
            }
        }
    }

    private void checkForumIds() {
        if ((getArguments() != null) && (getArguments().containsKey(saveKey_ArrayList))) {
            Serializable localSerializable = getArguments().getSerializable(saveKey_ArrayList);
            if ((localSerializable != null) && ((localSerializable instanceof ArrayList))) {
                this.forumsList = ((ArrayList) localSerializable);
            }
        }
    }

    private void configurationChanged(Configuration paramConfiguration) {
        checkCategoryId();
        ViewGroup.MarginLayoutParams localMarginLayoutParams;
        if ((Util.getDeviceSize(this.mActivity) >= 7.0D) && (this.categoryId == null)) {
            localMarginLayoutParams = (ViewGroup.MarginLayoutParams) this.groupTreeView.getLayoutParams();
            switch (paramConfiguration.orientation) {
            }
        }
        for (; ; ) {
            this.groupTreeView.invalidate();
            return;
            int i = (int) getResources().getDimension(2131427405);
            localMarginLayoutParams.setMargins(i, 0, i, 0);
            continue;
            localMarginLayoutParams.setMargins(0, 0, 0, 0);
        }
    }

    private void initAdapter() {
        if ((this.adapter == null) && (this.mActivity != null)) {
            this.adapter = new FeedListAdapter(this.topicList, this.mActivity, this.groupTreeView, this);
        }
    }

    public static FeedFragment newInstance(String paramString, boolean paramBoolean) {
        FeedFragment localFeedFragment = new FeedFragment();
        Bundle localBundle = new Bundle();
        localBundle.putString(saveKey_String, paramString);
        localFeedFragment.setArguments(localBundle);
        localFeedFragment.isShowNotif = paramBoolean;
        return localFeedFragment;
    }

    public static FeedFragment newInstance(ArrayList<String> paramArrayList, boolean paramBoolean) {
        FeedFragment localFeedFragment = new FeedFragment();
        Bundle localBundle = new Bundle();
        localBundle.putSerializable(saveKey_ArrayList, paramArrayList);
        localFeedFragment.setArguments(localBundle);
        localFeedFragment.isUseSelfdata = paramBoolean;
        return localFeedFragment;
    }

    public void clearData() {
        this.topicList.clear();
        this.notifiDatas.clear();
        this.feedList.clear();
        this.adapter.groupList.clear();
        this.groupTreeView.setmHeaderViewVisible(false);
        this.adapter.notifyDataSetChanged();
    }

    public void closeHint(int paramInt) {
        Util.hideHintview(this.feedHint, paramInt);
    }

    public Conversation getConv(String paramString) {
        Conversation localConversation = new Conversation();
        localConversation.setConv_id(paramString);
        return localConversation;
    }

    public void getFeedByTapatalkForumId() {
        if ((this.forumsList != null) && (this.forumsList.size() > 0) && (this.mActivity != null)) {
            this.feedAction.getFeeds(DirectoryUrlUtil.getTapatalkForumsFeed(this.forumsList, this.mActivity, true), this.page, new FeedAction.FeedActionCallBack() {
                public void actionCallBack(ArrayList<Object> paramAnonymousArrayList, boolean paramAnonymousBoolean) {
                    if (paramAnonymousArrayList != null) {
                        FeedFragment.this.refreshDatas(paramAnonymousArrayList, true);
                        GoogleAnalyticsTools.trackEvent(FeedFragment.this.mActivity, CustomTrackType.FEED_TYPE, CustomTrackType.GET_TRENDTOPIC);
                    }
                }
            });
            this.isLoadMore = true;
        }
    }

    public void getFeeds() {
        checkCategoryId();
        checkForumIds();
        getNotifications();
        getTrendingTopic();
    }

    public ArrayList<String> getForumsList() {
        return this.forumsList;
    }

    public ArrayList<String> getNotifiList() {
        return this.notifiList;
    }

    public void getNotificationFeed() {
        this.feedAction.getFeedNotification(this.mActivity, DirectoryUrlUtil.getNotificationUrl(this.mActivity), new FeedAction.FeedActionCallBack() {
            public void actionCallBack(ArrayList<Object> paramAnonymousArrayList, boolean paramAnonymousBoolean) {
                FeedFragment.this.notifiDatas.clear();
                FeedFragment.this.feedList.clear();
                if (paramAnonymousArrayList == null) {
                }
                Object localObject;
                ArrayList localArrayList;
                label109:
                do {
                    return;
                    if (FeedFragment.this.notifiList == null) {
                        FeedFragment.this.notifiList = new ArrayList();
                    }
                    if (FeedFragment.this.userList == null) {
                        FeedFragment.this.userList = new ArrayList();
                    }
                    localObject = new ArrayList();
                    localArrayList = TapatalkAccountAction.getCurrnentAllAccount(FeedFragment.this.getActivity());
                    if ((localArrayList != null) && (localArrayList.size() > 0)) {
                        i = 0;
                        if (i < localArrayList.size()) {
                            break;
                        }
                    }
                }
                while ((paramAnonymousArrayList.size() <= 0) || (FeedFragment.this.notifiList.size() <= 0) || (FeedFragment.this.userList.size() <= 0));
                int i = 0;
                label153:
                if (i >= paramAnonymousArrayList.size()) {
                    if (FeedFragment.this.notifiDatas.size() > FeedFragment.this.default_notification_num) {
                        break label513;
                    }
                    FeedFragment.this.feedList.addAll(FeedFragment.this.notifiDatas);
                    i = 0;
                    label201:
                    if (i < FeedFragment.this.notifiDatas.size()) {
                        break label494;
                    }
                }
                for (; ; ) {
                    if (FeedFragment.this.notifiDatas.size() > 0) {
                        GoogleAnalyticsTools.trackEvent(FeedFragment.this.mActivity, CustomTrackType.FEED_TYPE, CustomTrackType.GET_UNRADNOTICITAION);
                    }
                    if (!FeedFragment.this.isShowNotif) {
                        break;
                    }
                    FeedFragment.this.setNotificationDatas();
                    return;
                    if ((!((ArrayList) localObject).contains(((TapatalkForum) localArrayList.get(i)).getId())) && (((TapatalkForum) localArrayList.get(i)).isFeed())) {
                        ((ArrayList) localObject).add(((TapatalkForum) localArrayList.get(i)).getId());
                    }
                    FeedFragment.this.notifiList.add(((TapatalkForum) localArrayList.get(i)).getId());
                    FeedFragment.this.userList.add(((TapatalkForum) localArrayList.get(i)).getUserId());
                    i += 1;
                    break label109;
                    if (FeedFragment.this.notifiList.contains(((Feed) paramAnonymousArrayList.get(i)).getFid())) {
                        localObject = FeedFragment.this.getTapatalkForum(((Feed) paramAnonymousArrayList.get(i)).getFid());
                        if ((localObject != null) && (Util.isLoginedUser(FeedFragment.this.mActivity, (TapatalkForum) localObject))) {
                            FeedFragment.this.notifiDatas.add(paramAnonymousArrayList.get(i));
                        }
                    }
                    i += 1;
                    break label153;
                    label494:
                    FeedFragment.this.notifiDatas.remove(i);
                    i += 1;
                    break label201;
                    label513:
                    i = 0;
                    while (i < FeedFragment.this.default_notification_num) {
                        FeedFragment.this.feedList.add(FeedFragment.this.notifiDatas.get(0));
                        FeedFragment.this.notifiDatas.remove(0);
                        i += 1;
                    }
                }
            }
        });
    }

    public void getNotifications() {
        TapatalkId localTapatalkId = TapatalkIdFactory.getTapatalkId(getActivity());
        if ((this.isShowNotif) && (localTapatalkId != null) && (localTapatalkId.getAuid() != -1) && (localTapatalkId.getToken() != null)) {
            getNotificationFeed();
            this.isLoadMore = true;
            this.adapter.notifyDataSetChanged();
        }
    }

    public PrivateMessage getPM(String paramString) {
        PrivateMessage localPrivateMessage = new PrivateMessage();
        localPrivateMessage.setMsgid(paramString);
        return localPrivateMessage;
    }

    public TapatalkForum getTapatalkForum(String paramString) {
        return new FavoriateSqlHelper(this.mActivity, TapatalkApp.database_name, null, Integer.parseInt(TapatalkApp.database_version)).getFavrivateById(paramString);
    }

    public Topic getTopic(String paramString1, String paramString2) {
        Topic localTopic = new Topic();
        localTopic.setNewPost(true);
        localTopic.setId(paramString1);
        localTopic.setSubscribe(true);
        if (paramString2 != null) {
            localTopic.setPostId(paramString2);
        }
        return localTopic;
    }

    public ArrayList<Object> getTopicList() {
        return this.topicList;
    }

    public void getTrendingTopic() {
        if ((this.forumsList != null) && (this.forumsList.size() > 0) && (this.mActivity != null)) {
            new StringBuilder(String.valueOf(DirectoryUrlUtil.getTapatalkForumsFeed(this.forumsList, this.mActivity, true))).append("&page=").append(this.page).toString();
            this.oldUrl = DirectoryUrlUtil.getTapatalkForumsFeed(this.forumsList, this.mActivity, true);
            new Handler().post(new Runnable() {
                public void run() {
                    FeedFragment.this.getFeedByTapatalkForumId();
                }
            });
        }
        for (; ; ) {
            this.isLoadMore = true;
            return;
            if ((this.groupTreeView.getAdapter() instanceof HeaderViewListAdapter)) {
                this.groupTreeView.removeFooterView(this.footLay);
            }
            this.groupTreeView.setVisibility(8);
            this.noDataText.setVisibility(0);
        }
    }

    public ArrayList<String> getUserList() {
        return this.userList;
    }

    public ArrayList<TapatalkForum> getmAllDatas() {
        return this.mAllDatas;
    }

    public boolean hasData() {
        return (this.topicList != null) && (this.topicList.size() > 0);
    }

    public void notifyDataChanged() {
        if (this.adapter != null) {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                public void run() {
                    FeedFragment.this.adapter.notifyDataSetChanged();
                }
            });
        }
    }

    public void onActivityCreated(Bundle paramBundle) {
        super.onActivityCreated(paramBundle);
        this.mActivity = getActivity();
        paramBundle = this.groupTreeView.getViewTreeObserver();
        this.finalWidth = this.groupTreeView.getMeasuredWidth();
        if (paramBundle != null) {
            paramBundle.addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
                public boolean onPreDraw() {
                    FeedFragment.this.finalWidth = FeedFragment.this.groupTreeView.getMeasuredWidth();
                    return true;
                }
            });
        }
        Prefs.isShowHint(this.mActivity, this.feedHint);
        this.prefs = Prefs.get(this.mActivity);
        this.default_notification_num = this.prefs.getInt("default_notification_num", 5);
        this.footLay = ButtomProgress.get(this.mActivity);
        this.groupTreeView.setGroupIndicator(null);
        this.groupTreeView.setSelector(2131165212);
        this.groupTreeView.addFooterView(this.footLay);
        this.sqlHelper = new FavoriateSqlHelper(getActivity(), TapatalkApp.database_name, null, Integer.parseInt(TapatalkApp.database_version));
        initAdapter();
        this.feedAction = new FeedAction(this.mActivity, true);
        if ((this.isUseSelfdata) && (this.topicList.size() == 0)) {
            getFeeds();
        }
        this.groupTreeView.setAdapter(this.adapter);
        this.groupTreeView.setOnChildClickListener(this);
        this.groupTreeView.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent) {
                FeedFragment.this.closeHint(0);
                return false;
            }
        });
        this.noDataText.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent) {
                FeedFragment.this.closeHint(0);
                return false;
            }
        });
        this.feedHint.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent) {
                FeedFragment.this.closeHint(0);
                return true;
            }
        });
        int i = 0;
        for (; ; ) {
            if (i >= this.adapter.getGroupCount()) {
                this.groupTreeView.setOnScrollListenerForOther(new SectionTitleListView.OnScrollListenerForOtherUse() {
                    public void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {
                        if ((paramAnonymousInt1 + paramAnonymousInt2 == paramAnonymousInt3) && (!FeedFragment.this.isLoadMore)) {
                            FeedFragment.this.groupTreeView.addFooterView(FeedFragment.this.footLay);
                            FeedFragment.this.getTrendingTopic();
                            FeedFragment.this.isLoadMore = true;
                        }
                    }

                    public void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt) {
                    }
                });
                this.groupTreeView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                    public boolean onItemLongClick(final AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong) {
                        int i = ((Integer) paramAnonymousView.getTag(2131231366)).intValue();
                        int j = ((Integer) paramAnonymousView.getTag(2131231367)).intValue();
                        paramAnonymousAdapterView = FeedFragment.this.adapter.getChild(i, j);
                        FeedFragment.this.child_position = (paramAnonymousInt - 1);
                        if ((paramAnonymousAdapterView instanceof Feed)) {
                            FeedFragment.this.feed = ((Feed) paramAnonymousAdapterView);
                            paramAnonymousAdapterView = new FeedFragment.OnLongItemClickFeedAdapter(FeedFragment.this.mActivity);
                            new AlertDialog.Builder(FeedFragment.this.mActivity).setTitle(FeedFragment.this.feed.getFeed_title()).setAdapter(paramAnonymousAdapterView, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {
                                    if (((String) paramAnonymousAdapterView.getItem(paramAnonymous2Int)).equalsIgnoreCase(FeedFragment.this.mActivity.getResources().getString(2131099817))) {
                                        paramAnonymous2DialogInterface = FeedFragment.this.handler.obtainMessage();
                                        paramAnonymous2DialogInterface.what = FeedFragment.UPDATENOTIFICATION;
                                        FeedFragment.this.handler.sendMessage(paramAnonymous2DialogInterface);
                                    }
                                }
                            }).create().show();
                        }
                        return true;
                    }
                });
                configurationChanged(getResources().getConfiguration());
                this.adapter.notifyDataSetChanged();
                this.logAction = new TapatalkAjaxLogAction(this.mActivity);
                return;
            }
            this.groupTreeView.expandGroup(i);
            i += 1;
        }
    }

    public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
        super.onActivityResult(paramInt1, paramInt2, paramIntent);
    }

    public boolean onChildClick(ExpandableListView paramExpandableListView, View paramView, int paramInt1, int paramInt2, long paramLong) {
        paramView = this.adapter.getChild(paramInt1, paramInt2);
        if ((paramView instanceof Feed)) {
            this.adapter.animationDelete(paramInt1, paramInt2);
            this.child_position = paramInt2;
            this.feed = ((Feed) paramView);
            paramExpandableListView = this.handler.obtainMessage();
            paramExpandableListView.what = UPDATENOTIFICATION;
            this.handler.sendMessage(paramExpandableListView);
            paramInt1 = 0;
            if (paramInt1 >= this.mAllDatas.size()) {
                if (this.adapter.forumStatus.tapatalkForum != null) {
                    this.adapter.forumStatus = ForumStatus.initialForumStatus(this.mActivity, this.adapter.forumStatus.tapatalkForum, this.adapter.forumStatus.tapatalkForum.getUserName(), null, true);
                    if (Util.isLoginedUser(this.mActivity, this.adapter.forumStatus.tapatalkForum)) {
                        this.adapter.forumStatus.setLogin(true);
                    }
                }
                if (!((Feed) paramView).getType().equals("pm")) {
                    break label310;
                }
                paramView = this.handler.obtainMessage();
                paramExpandableListView.what = OPENPRIVATEMESSAGE;
                this.handler.sendMessage(paramView);
            }
            for (; ; ) {
                GoogleAnalyticsTools.trackEvent(this.mActivity, CustomTrackType.FEED_TYPE, CustomTrackType.CLICK_UNRADNOTICITAION);
                return true;
                if (((TapatalkForum) this.mAllDatas.get(paramInt1)).getId().equals(Integer.valueOf(Integer.parseInt(((Feed) paramView).getFid())))) {
                    this.adapter.forumStatus.tapatalkForum = ((TapatalkForum) this.mAllDatas.get(paramInt1));
                    this.tapatalkForum = ((TapatalkForum) this.mAllDatas.get(paramInt1));
                    this.sqlHelper.saveFavoriate(this.adapter.forumStatus.tapatalkForum);
                }
                paramInt1 += 1;
                break;
                label310:
                if (((Feed) paramView).getType().equals("conv")) {
                    paramView = this.handler.obtainMessage();
                    paramExpandableListView.what = OPENCONVERSATION;
                    this.handler.sendMessage(paramView);
                } else {
                    paramView = this.handler.obtainMessage();
                    paramExpandableListView.what = OPENTHREADACTIVITY;
                    this.handler.sendMessage(paramView);
                }
            }
        }
        paramInt1 = 0;
        for (; ; ) {
            if (paramInt1 >= this.mAllDatas.size()) {
                OpenThreadAction.openThread(this.mActivity, (Topic) paramView, "account");
                paramExpandableListView = new TapatalkAjaxLogAction(this.mActivity);
                if (this.tapatalkForum != null) {
                    paramExpandableListView.logTapatalkLog(TapatalkLogUrlUtil.getFeedLogUrl(this.mActivity, this.tapatalkForum.getId().intValue(), ((Topic) paramView).getId(), 3));
                }
                GoogleAnalyticsTools.trackEvent(this.mActivity, CustomTrackType.FEED_TYPE, CustomTrackType.CLICK_TRENDTOPIC);
                break;
            }
            if (((TapatalkForum) this.mAllDatas.get(paramInt1)).getId().equals(Integer.valueOf(Integer.parseInt(((Topic) paramView).getTapatalkForumId())))) {
                this.adapter.forumStatus.tapatalkForum = ((TapatalkForum) this.mAllDatas.get(paramInt1));
                this.tapatalkForum = ((TapatalkForum) this.mAllDatas.get(paramInt1));
                this.sqlHelper.saveFavoriate(this.adapter.forumStatus.tapatalkForum);
            }
            paramInt1 += 1;
        }
    }

    public void onConfigurationChanged(Configuration paramConfiguration) {
        configurationChanged(paramConfiguration);
        DisplayMetrics localDisplayMetrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
        int i = localDisplayMetrics.widthPixels;
        int j = localDisplayMetrics.heightPixels;
        int k = this.mActivity.getResources().getDimensionPixelOffset(2131427414);
        int m = this.mActivity.getResources().getDimensionPixelOffset(2131427416);
        switch (paramConfiguration.orientation) {
        }
        for (; ; ) {
            this.adapter.notifyDataSetChanged();
            return;
            this.adapter.trendingTopicImageHeight = (k * i / j);
            this.adapter.trendingTopicNoImageHeight = (m * i / j);
            continue;
            this.adapter.trendingTopicImageHeight = k;
            this.adapter.trendingTopicNoImageHeight = m;
        }
    }

    public void onCreate(Bundle paramBundle) {
        ThemeUtil.setTheme(getActivity());
        super.onCreate(paramBundle);
    }

    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        paramLayoutInflater = paramLayoutInflater.inflate(2130903186, null);
        this.groupTreeView = ((SectionTitleListView) paramLayoutInflater.findViewById(2131231174));
        this.noDataText = ((LinearLayout) paramLayoutInflater.findViewById(2131231010));
        this.feedHint = ((TextView) paramLayoutInflater.findViewById(2131231175));
        return paramLayoutInflater;
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        if (paramMenuItem.getItemId() == 1001) {
            refresh();
        }
        for (; ; ) {
            return super.onOptionsItemSelected(paramMenuItem);
            if ((paramMenuItem.getItemId() == 6000) && ((getActivity() instanceof AccountEntryActivity))) {
                if ((((AccountEntryActivity) getActivity()).mDrawerLayout != null) && (!((AccountEntryActivity) getActivity()).mDrawerLayout.isDrawerOpen(5))) {
                    ((AccountEntryActivity) getActivity()).mDrawerLayout.openDrawer(5);
                } else {
                    ((AccountEntryActivity) getActivity()).mDrawerLayout.closeDrawers();
                }
            }
        }
    }

    public void onPrepareOptionsMenu(Menu paramMenu) {
        super.onPrepareOptionsMenu(paramMenu);
    }

    public void onResume() {
        super.onResume();
    }

    public void refresh() {
        if (this.adapter == null) {
            return;
        }
        this.page = 1;
        this.topicList.clear();
        this.notifiDatas.clear();
        this.feedList.clear();
        if ((this.adapter != null) && (this.adapter.groupList != null)) {
            this.adapter.groupList.clear();
        }
        this.groupTreeView.setmHeaderViewVisible(false);
        this.noDataText.setVisibility(8);
        if (this.groupTreeView.getFooterViewsCount() == 0) {
            this.groupTreeView.addFooterView(this.footLay);
        }
        this.groupTreeView.setVisibility(0);
        this.adapter.notifyDataSetChanged();
        getFeeds();
    }

    public void refreshDatas(ArrayList<Object> paramArrayList, boolean paramBoolean) {
        int i;
        if (((paramArrayList != null) && (paramArrayList.size() > 0)) || (this.topicList.size() > 0)) {
            if ((paramArrayList.size() > 0) && (this.groupTreeView != null)) {
                this.noDataText.setVisibility(8);
                this.groupTreeView.setHeaderView(getActivity().getLayoutInflater().inflate(2130903356, this.groupTreeView, false));
                this.groupTreeView.setVisibility(0);
                this.groupTreeView.removeFooterView(this.footLay);
                this.page += 1;
                if (this.topicList == null) {
                    this.topicList = new ArrayList();
                    this.isLoadMore = false;
                    i = 0;
                    label124:
                    if (i < paramArrayList.size()) {
                        break label254;
                    }
                    this.adapter.setDataList(this.topicList);
                    if (!paramBoolean) {
                        break label289;
                    }
                    if (!this.adapter.groupList.contains(this.adapter.feedGroupBean)) {
                        this.adapter.groupList.add(this.adapter.feedGroupBean);
                    }
                    this.adapter.feedGroupBean.setChildrenList(this.topicList);
                    label199:
                    i = 0;
                    label201:
                    if (i < this.adapter.getGroupCount()) {
                        break label344;
                    }
                }
            }
        }
        for (; ; ) {
            if (paramArrayList.size() == 0) {
                this.isLoadMore = true;
            }
            this.adapter.notifyDataSetChanged();
            return;
            if (!this.autoRefreshFromSettings) {
                break;
            }
            this.topicList.clear();
            this.autoRefreshFromSettings = false;
            break;
            label254:
            if (!this.topicList.contains(paramArrayList.get(i))) {
                this.topicList.add(paramArrayList.get(i));
            }
            i += 1;
            break label124;
            label289:
            if (!this.adapter.groupList.contains(this.adapter.topicGroupBean)) {
                this.adapter.groupList.add(this.adapter.topicGroupBean);
            }
            this.adapter.topicGroupBean.setChildrenList(this.topicList);
            break label199;
            label344:
            this.groupTreeView.expandGroup(i);
            i += 1;
            break label201;
            this.groupTreeView.removeFooterView(this.footLay);
            continue;
            this.groupTreeView.removeFooterView(this.footLay);
            this.groupTreeView.setVisibility(8);
            this.noDataText.setVisibility(0);
        }
    }

    public void setActivity(Activity paramActivity) {
        this.mActivity = paramActivity;
    }

    public void setForumsList(ArrayList<String> paramArrayList) {
        if (paramArrayList != null) {
            this.forumsList = paramArrayList;
            getArguments().putSerializable(saveKey_ArrayList, this.forumsList);
        }
    }

    public void setNotifiList(ArrayList<String> paramArrayList) {
        this.notifiList = paramArrayList;
    }

    public void setNotificationDatas() {
        if (this.feedList.size() > 0) {
            this.groupTreeView.setHeaderView(getActivity().getLayoutInflater().inflate(2130903356, this.groupTreeView, false));
            this.groupTreeView.setVisibility(0);
            if (!this.adapter.groupList.contains(this.adapter.notificationGroupBean)) {
                this.adapter.groupList.add(0, this.adapter.notificationGroupBean);
            }
            this.adapter.notificationGroupBean.setChildrenList(this.feedList);
            this.adapter.notifyDataSetChanged();
            this.groupTreeView.invalidate();
            i = 0;
            if (i < this.adapter.getGroupCount()) {
            }
        }
        while (!this.adapter.groupList.contains(this.adapter.notificationGroupBean)) {
            for (; ; ) {
                int i;
                return;
                this.groupTreeView.expandGroup(i);
                i += 1;
            }
        }
        this.adapter.groupList.remove(this.adapter.notificationGroupBean);
        this.adapter.notifyDataSetChanged();
    }

    public void setUserList(ArrayList<String> paramArrayList) {
        this.userList = paramArrayList;
    }

    public void setmAllDatas(ArrayList<TapatalkForum> paramArrayList) {
        this.mAllDatas = ((ArrayList) paramArrayList.clone());
    }

    public void updateNotificationFeeds(String paramString) {
        paramString = TapatalkJsonEngine.AU_UPDATE_FEED + "?au_id=" + Prefs.get(this.mActivity).getInt("tapatalk_auid", -1) + "&feed_id=" + paramString + "&" + TapatalkApp.APP_KEY;
        this.feedAction.updateFeed(paramString, new FeedAction.FeedActionCallBack() {
            public void actionCallBack(ArrayList<Object> paramAnonymousArrayList, boolean paramAnonymousBoolean) {
            }
        });
    }

    public static class OnLongItemClickFeedAdapter
            extends BaseAdapter {
        private ArrayList<String> list = new ArrayList();
        private Context mContext;

        public OnLongItemClickFeedAdapter(Context paramContext) {
            this.mContext = paramContext;
            this.list.add(this.mContext.getResources().getString(2131099817));
        }

        public int getCount() {
            return this.list.size();
        }

        public Object getItem(int paramInt) {
            return this.list.get(paramInt);
        }

        public long getItemId(int paramInt) {
            return paramInt;
        }

        public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
            paramView = (TextView) LayoutInflater.from(this.mContext).inflate(2130903172, null);
            paramView.setText((CharSequence) this.list.get(paramInt));
            paramView.setCompoundDrawablePadding(5);
            if (((String) this.list.get(paramInt)).equalsIgnoreCase(this.mContext.getResources().getString(2131099817))) {
                paramView.setCompoundDrawablesWithIntrinsicBounds(ThemeUtil.getDialogDrawableId("bubble_delete", this.mContext), 0, 0, 0);
            }
            return paramView;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/feed/FeedFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */