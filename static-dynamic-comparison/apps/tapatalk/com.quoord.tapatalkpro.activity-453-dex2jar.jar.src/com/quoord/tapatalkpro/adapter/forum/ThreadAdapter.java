package com.quoord.tapatalkpro.adapter.forum;

import android.app.ActionBar;
import android.app.ActionBar.OnNavigationListener;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.ViewFlipper;
import com.quoord.tapatalkpro.TapatalkApp;
import com.quoord.tapatalkpro.action.AddBannerInterface;
import com.quoord.tapatalkpro.activity.forum.CreateTopicActivity;
import com.quoord.tapatalkpro.activity.forum.ForumActivityStatus;
import com.quoord.tapatalkpro.activity.forum.ThreadFragment;
import com.quoord.tapatalkpro.activity.forum.ThreadOuterFragment;
import com.quoord.tapatalkpro.activity.forum.ThreadPagerAdapter;
import com.quoord.tapatalkpro.adapter.directory.ics.ThreadNavigationAdapter;
import com.quoord.tapatalkpro.ads.AdsService;
import com.quoord.tapatalkpro.ads.FlurryAdbean;
import com.quoord.tapatalkpro.bean.Banner;
import com.quoord.tapatalkpro.bean.EngineResponse;
import com.quoord.tapatalkpro.bean.Forum;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.bean.ImageInThread;
import com.quoord.tapatalkpro.bean.PostData;
import com.quoord.tapatalkpro.bean.RebrandingConfig;
import com.quoord.tapatalkpro.bean.TapatalkForum;
import com.quoord.tapatalkpro.bean.ThreadFootView;
import com.quoord.tapatalkpro.bean.ThreadHeaderView;
import com.quoord.tapatalkpro.bean.ThreadPageView;
import com.quoord.tapatalkpro.bean.Topic;
import com.quoord.tapatalkpro.bean.TopicController;
import com.quoord.tapatalkpro.cache.AppCacheManager;
import com.quoord.tapatalkpro.ics.slidingMenu.SettingsFragment;
import com.quoord.tapatalkpro.ics.slidingMenu.SlidingMenuActivity;
import com.quoord.tapatalkpro.saxparser.PostSaxParser;
import com.quoord.tapatalkpro.saxparser.PostSaxParser.ICallback;
import com.quoord.tapatalkpro.ui.CustomImageViewLayout;
import com.quoord.tapatalkpro.util.Prefs;
import com.quoord.tapatalkpro.util.TapatalkEngine;
import com.quoord.tapatalkpro.util.ThreadPoolManager;
import com.quoord.tapatalkpro.util.Util;
import com.quoord.tools.tracking.GoogleAnalyticsTools;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class ThreadAdapter
        extends ForumRootAdapter
        implements AddBannerInterface {
    private int SAX_CLOSE_PROGRESS = 0;
    private int SAX_DISPLAY_ERROR = 4;
    private int SAX_UPDATE_BEGIN = 3;
    private int SAX_UPDATE_END = 2;
    private int SAX_UPDATE_ITEM = 1;
    private int SAX_UPDATE_POSITION = 5;
    View adView;
    private AddBannerInterface addRebrandBanner;
    private FlurryAdbean banerAdBean;
    private HashMap<Integer, Object> bannerHash = new HashMap();
    public boolean canReply = false;
    public boolean canUpload = true;
    public int currentIndex;
    public String currentMethod;
    public int currentScrollState;
    private int currentTag;
    int editJumpPosition = 0;
    public ViewFlipper flipper;
    View footView;
    public ArrayList<ImageInThread> images = new ArrayList();
    private boolean inRelease = false;
    private boolean isAnn = false;
    private boolean isFirstTag = false;
    public boolean isFootRefresh;
    private boolean issubscribe;
    int jumpPosition;
    public int jump_to = 0;
    public ArrayList<Object> mDatas = new ArrayList();
    public int mFocusItemPosition;
    private ThreadFragment mFragment;
    public ThreadOuterFragment mOutFragment = null;
    private int mPosition;
    protected PostSaxParser mPostParser;
    public String mPrefix;
    private int mStart = 0;
    public String mTopicId;
    private Handler mUIHandler;
    HashMap<String, PostData> postDatas = new HashMap();
    public ArrayList<String> repliedIds = new ArrayList();
    private int replyPosition = -1;
    public String shouldAnimId;
    public boolean shouldCache = true;
    public boolean shouldJumpToLast = false;
    private boolean should_jump = false;
    private ArrayList<Object> tempDatas = new ArrayList();
    String userNameCacheAddress = "";
    public HashMap<String, String> userNameList;

    public ThreadAdapter(ThreadOuterFragment paramThreadOuterFragment, String paramString, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, Topic paramTopic, int paramInt2, boolean paramBoolean3, ThreadFragment paramThreadFragment) {
        super(paramThreadOuterFragment.activity, paramThreadOuterFragment, paramString);
        this.mOutFragment = paramThreadOuterFragment;
        this.mOutFragment.mTopic = paramTopic;
        this.mFragment = paramThreadFragment;
        this.isAnn = paramBoolean2;
        this.isFirstTag = paramBoolean3;
        if ((paramThreadOuterFragment.activity != null) && ((paramThreadOuterFragment.activity instanceof SlidingMenuActivity))) {
            paramThreadOuterFragment = (SlidingMenuActivity) paramThreadOuterFragment.activity;
            this.stackType = "all_forum_statck_tag";
        }
        this.userNameCacheAddress = AppCacheManager.getForumUseNameUrl(this.mOutFragment.activity, this.mOutFragment.forumStatus.getUrl(), this.mOutFragment.forumStatus.tapatalkForum.getLowerUserName());
        paramThreadOuterFragment = AppCacheManager.getCacheData(this.userNameCacheAddress);
        if (paramThreadOuterFragment == null) {
            this.userNameList = new HashMap();
            if (this.forumStatus.getApiLevel() < 4) {
                break label407;
            }
            this.canUpload = false;
            if (this.forumStatus != null) {
                this.forumStatus.setCan_upload_attachment_post(false);
            }
        }
        for (; ; ) {
            initialPostParser();
            initUiHandler();
            if ((this.isFirstTag) || (paramInt2 == this.mOutFragment.getCurrentPageNum())) {
                getData(this.mOutFragment.mTopic.getPostId(), paramBoolean1);
            }
            return;
            if ((paramThreadOuterFragment instanceof HashMap)) {
                this.userNameList = ((HashMap) paramThreadOuterFragment);
                break;
            }
            this.userNameList = new HashMap();
            break;
            label407:
            if (this.forumStatus != null) {
                this.forumStatus.setCan_upload_attachment_post(true);
            }
        }
    }

    private void getThreadData(String paramString, boolean paramBoolean) {
        if ((this.isAnn) && (this.forumStatus.isVB())) {
            get_ann();
            return;
        }
        if (!this.isFirstTag) {
            getThreadByPage(this.mFragment.getCurrentPage(), false);
            return;
        }
        if ((this.mOutFragment.dataCache != null) && (this.mOutFragment.dataCache.containsKey("last_page"))) {
            getThreadByPage(((Integer) this.mOutFragment.dataCache.get("last_page")).intValue(), false);
            return;
        }
        if (((this.forumStatus.isSupportGoUnread()) || (Prefs.get(this.mOutFragment.activity).getInt(this.forumStatus.getForumId() + "|api_level", 0) > 3)) && (!this.mOutFragment.activity.getResources().getBoolean(2131558402))) {
            if (this.mOutFragment.openMode != null) {
                if (this.mOutFragment.openMode.equalsIgnoreCase("0")) {
                    getThreadByPage(0, false);
                }
                for (; ; ) {
                    this.mOutFragment.openMode = null;
                    return;
                    if (this.mOutFragment.openMode.equalsIgnoreCase("2")) {
                        this.shouldJumpToLast = true;
                        this.mFragment.currentPage = (this.mOutFragment.mTopicController.getPageNum() - 1);
                        getThreadByPage(this.mOutFragment.mTopicController.getPageNum() - 1, false);
                    } else {
                        getThreadGoUnread();
                    }
                }
            }
            if ((this.mOutFragment.getDeepPage() != -1) && (this.mOutFragment.getDeepPerpage() != -1)) {
                getThreadByPage(this.mOutFragment.getDeepPage() - 1, false);
                return;
            }
            if ((SettingsFragment.getLandBehavior(this.mOutFragment.activity).equalsIgnoreCase("0")) || (this.mOutFragment.goto_first_post)) {
                getThreadByPage(0, false);
                return;
            }
            if (SettingsFragment.getLandBehavior(this.mOutFragment.activity).equalsIgnoreCase("2")) {
                this.shouldJumpToLast = true;
                getThreadByPage(this.mOutFragment.mTopicController.getPageNum() - 1, false);
                this.mFragment.currentPage = (this.mOutFragment.mTopicController.getPageNum() - 1);
                return;
            }
            getThreadGoUnread();
            return;
        }
        if ((this.mOutFragment.getDeepPage() != -1) && (this.mOutFragment.getDeepPerpage() != -1)) {
            getThreadByPage(this.mOutFragment.getDeepPage() - 1, false);
            this.mOutFragment.setPagerAdapterAndPosition(this.mOutFragment.getDeepPage() - 1, this.mFragment, 0, 0, false);
            return;
        }
        if (this.mOutFragment.openMode != null) {
            if (this.mOutFragment.openMode.equalsIgnoreCase("0")) {
                getThreadByPage(0, false);
                return;
            }
            this.shouldJumpToLast = true;
            this.mFragment.currentPage = (this.mOutFragment.mTopicController.getPageNum() - 1);
            getThreadByPage(this.mOutFragment.mTopicController.getPageNum() - 1, false);
            return;
        }
        if ((SettingsFragment.getLandBehavior(this.mOutFragment.activity).equalsIgnoreCase("0")) || (this.mOutFragment.goto_first_post)) {
            getThreadByPage(0, false);
            return;
        }
        this.shouldJumpToLast = true;
        this.mFragment.currentPage = (this.mOutFragment.mTopicController.getPageNum() - 1);
        getThreadByPage(this.mOutFragment.mTopicController.getPageNum() - 1, false);
    }

    private void getThreadGoPost() {
        this.currentMethod = "get_thread_by_post";
        setTryTwice(false);
        ArrayList localArrayList = new ArrayList();
        this.mDatas.clear();
        this.mDatas.add(new ThreadHeaderView());
        notifyDataSetChanged();
        this.postDatas.clear();
        localArrayList.add(this.mOutFragment.mTopic.getPostId());
        localArrayList.add(Integer.valueOf(this.mOutFragment.mTopicController.getCountPerPage()));
        if (this.forumStatus.isSupprotBBcode()) {
            localArrayList.add(Boolean.valueOf(true));
        }
        this.engine.saxcall(this.mPostParser, "get_thread_by_post", localArrayList);
    }

    private void getThreadGoUnread() {
        this.mDatas.clear();
        this.mDatas.add(new ThreadHeaderView());
        this.postDatas.clear();
        notifyDataSetChanged();
        this.currentMethod = "get_thread_by_unread";
        setTryTwice(false);
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(this.mOutFragment.mTopic.getId());
        localArrayList.add(Integer.valueOf(this.mOutFragment.mTopicController.getCountPerPage()));
        if (this.forumStatus.isSupprotBBcode()) {
            localArrayList.add(Boolean.valueOf(true));
        }
        this.engine.saxcall(this.mPostParser, "get_thread_by_unread", localArrayList);
    }

    private void get_ann() {
        this.currentMethod = "get_announcement";
        setTryTwice(false);
        this.mDatas.clear();
        this.mDatas.add(new ThreadHeaderView());
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(this.mOutFragment.mTopic.getId());
        this.engine.saxcall(this.mPostParser, "get_announcement", localArrayList);
    }

    private void get_thread(ArrayList paramArrayList) {
        this.currentMethod = "get_thread";
        notifyDataSetChanged();
        cleanPostDatas();
        this.postDatas.clear();
        this.mPosition = 0;
        initialPostParser();
        setTryTwice(false);
        this.engine.saxcall(this.mPostParser, "get_thread", paramArrayList);
    }

    public void AddRebrandBannerItem() {
        if (this.addRebrandBanner != null) {
            notifyDataSetChanged();
        }
    }

    public void addBanner(ArrayList<Object> paramArrayList) {
        if ((this.forumStatus != null) && (this.forumStatus.getRebrandingConfig() != null) && (this.forumStatus.isAdShow()) && (((this.forumStatus.getRebrandingConfig().getDfp_320x50() != null) && (!this.forumStatus.getRebrandingConfig().getDfp_320x50().equals(""))) || ((this.forumStatus.getRebrandingConfig().getDfp_300x250() != null) && (!this.forumStatus.getRebrandingConfig().getDfp_300x250().equals(""))) || ((this.forumStatus.getRebrandingConfig().getAdmobId() != null) && (!this.forumStatus.getRebrandingConfig().getAdmobId().equals(""))))) {
            Banner.addBanner(this.mOutFragment.activity, paramArrayList);
        }
    }

    public void addItem(HashMap paramHashMap) {
        if ((this.mDatas == null) || (this.mDatas.size() == 0)) {
            refresh();
            return;
        }
        if ((this.mDatas.get(this.mDatas.size() - 1) instanceof ThreadPageView)) {
            if ((this.mDatas.get(this.mDatas.size() - 2) instanceof ThreadFootView)) {
                this.mDatas.remove(this.mDatas.size() - 2);
            }
            this.mDatas.remove(this.mDatas.size() - 1);
            this.mDatas.add(this.mDatas.size(), paramHashMap);
            if (this.mOutFragment.mTopicController.getPageNum() > 1) {
                this.mDatas.add(new ThreadFootView());
            }
            this.mDatas.add(new ThreadPageView());
        }
        PostData localPostData = new PostData(this.mOutFragment, this, this.mOutFragment.mTopic.getId());
        this.postDatas.put((String) paramHashMap.get("post_id"), localPostData);
        localPostData.canEdit = true;
        localPostData.fillData(paramHashMap, this.mOutFragment.activity, this.forumStatus);
        if ((this.forumStatus.getAvatarUrl() != null) && (this.forumStatus.getAvatarUrl().length() > 0)) {
            localPostData.icon_url = this.forumStatus.getAvatarUrl();
        }
        localPostData.authorDisplayName = this.forumStatus.getCurrentUserName();
        this.shouldAnimId = localPostData.postId;
        if (!this.repliedIds.contains(this.shouldAnimId)) {
            this.repliedIds.add(this.shouldAnimId);
        }
        notifyDataSetChanged();
        this.mOutFragment.mTopicController.setTotal_post_num(this.mOutFragment.mTopicController.getTotal_post_num() + 1);
        if (this.mOutFragment.mTopicController.isNeedNotifyDataSetChanged()) {
            this.mOutFragment.mTopicController.setNeedNotifyDataSetChanged(false);
            this.mOutFragment.pagerAdapter.notifyDataSetChanged();
        }
        this.shouldCache = false;
        ((HashMap) this.mOutFragment.dataCache.get("data")).remove(Integer.valueOf(this.mFragment.getCurrentPage()));
        cacheData(this.mOutFragment.cacheFile);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                try {
                    ThreadAdapter.this.mOutFragment.updateUI(38, null);
                    return;
                } catch (Exception localException) {
                    localException.printStackTrace();
                }
            }
        }, 500L);
    }

    public void addLastBanner(ArrayList<Object> paramArrayList) {
        if ((this.forumStatus != null) && (this.forumStatus.getRebrandingConfig() != null) && (this.forumStatus.isAdShow()) && (((this.forumStatus.getRebrandingConfig().getDfp_320x50() != null) && (!this.forumStatus.getRebrandingConfig().getDfp_320x50().equals(""))) || ((this.forumStatus.getRebrandingConfig().getDfp_300x250() != null) && (!this.forumStatus.getRebrandingConfig().getDfp_300x250().equals(""))) || ((this.forumStatus.getRebrandingConfig().getAdmobId() != null) && (!this.forumStatus.getRebrandingConfig().getAdmobId().equals(""))))) {
            Banner.addThreadBanner(this.mOutFragment.activity, paramArrayList);
        }
    }

    public void addRebrandBanner() {
    }

    public void cacheData(String paramString) {
        ArrayList localArrayList = new ArrayList();
        localArrayList.addAll(this.mDatas);
        this.mOutFragment.dataCache.put("total_post_num", Integer.valueOf(this.mOutFragment.mTopicController.getTotal_post_num()));
        ((HashMap) this.mOutFragment.dataCache.get("data")).put(Integer.valueOf(this.mFragment.getCurrentPage()), localArrayList);
        this.mOutFragment.dataCache.put("issubscribe", Boolean.valueOf(this.issubscribe));
        this.mOutFragment.dataCache.put("canReply", Boolean.valueOf(this.canReply));
        this.mOutFragment.dataCache.put("last_page", Integer.valueOf(this.mFragment.getCurrentPage()));
        AppCacheManager.cacheData(paramString, this.mOutFragment.dataCache);
    }

    public void cacheLastPosition(String paramString) {
        if (this.mOutFragment.dataCache != null) {
            if (this.mFragment.threadList != null) {
                this.mOutFragment.dataCache.put("last_position", Integer.valueOf(this.mFragment.threadList.getFirstVisiblePosition()));
            }
            AppCacheManager.cacheData(paramString, this.mOutFragment.dataCache);
        }
    }

    public void checkImages() {
        if (this.inRelease) {
            return;
        }
        this.inRelease = true;
        int i = 0;
        for (; ; ) {
            if (i >= this.mDatas.size()) {
                this.inRelease = false;
                return;
            }
            try {
                if ((this.mDatas.get(i) instanceof HashMap)) {
                    recycleImage(getPost(i).mBeansFinished);
                }
                if ((this.mDatas.get(i) instanceof PostData)) {
                    recycleImage(((PostData) this.mDatas.get(i)).mBeansFinished);
                }
            } catch (Exception localException) {
                for (; ; ) {
                }
            }
            i += 1;
        }
    }

    public void checkMorePost() {
        ArrayList localArrayList = new ArrayList();
        this.currentMethod = "get_thread";
        localArrayList.add(this.mOutFragment.mTopic.getId());
        if (this.mOutFragment.mTopicController.getTotal_post_num() % this.mOutFragment.mTopicController.getCountPerPage() != 0) {
            localArrayList.add(Integer.valueOf(this.mOutFragment.mTopicController.getTotal_post_num()));
            localArrayList.add(Integer.valueOf((this.mOutFragment.mTopicController.getTotal_post_num() / this.mOutFragment.mTopicController.getCountPerPage() + 1) * this.mOutFragment.mTopicController.getCountPerPage() - 1));
        }
        for (; ; ) {
            if (this.forumStatus.isSupprotBBcode()) {
                localArrayList.add(Boolean.valueOf(true));
            }
            initialPostParser();
            setTryTwice(false);
            this.engine.saxcall(this.mPostParser, "get_thread", localArrayList);
            return;
            localArrayList.add(Integer.valueOf((this.mOutFragment.mTopicController.getTotal_post_num() / this.mOutFragment.mTopicController.getCountPerPage() - 1) * this.mOutFragment.mTopicController.getCountPerPage()));
            localArrayList.add(Integer.valueOf(this.mOutFragment.mTopicController.getTotal_post_num() - 1));
        }
    }

    public void cleanPostDatas() {
        Object[] arrayOfObject = this.postDatas.values().toArray();
        int i = 0;
        for (; ; ) {
            if (i >= arrayOfObject.length) {
                return;
            }
            ((PostData) arrayOfObject[i]).destory();
            i += 1;
        }
    }

    public void clearAll() {
        this.mDatas.clear();
        notifyDataSetChanged();
    }

    public void destroy() {
        new Handler().post(new Runnable() {
            public void run() {
                Object[] arrayOfObject = ThreadAdapter.this.postDatas.values().toArray();
                int i = 0;
                if (i >= arrayOfObject.length) {
                    i = 0;
                }
                for (; ; ) {
                    if (i >= ThreadAdapter.this.mDatas.size()) {
                        ThreadAdapter.this.mDatas.clear();
                        System.gc();
                        System.runFinalization();
                        return;
                        ((PostData) arrayOfObject[i]).destory();
                        i += 1;
                        break;
                    }
                    ThreadAdapter.this.mDatas.set(i, null);
                    i += 1;
                }
            }
        });
    }

    public AddBannerInterface getAddRebrandBanner() {
        return this.addRebrandBanner;
    }

    public int getCount() {
        return this.mDatas.size();
    }

    public void getData(String paramString, boolean paramBoolean) {
        if (this.mOutFragment.dataCache == null) {
            this.mOutFragment.dataCache = new HashMap();
        }
        if ((this.mOutFragment.dataCache != null) && (!this.mOutFragment.dataCache.containsKey("data"))) {
            this.mOutFragment.dataCache.put("data", new HashMap());
        }
        if (this.mOutFragment.getPost) {
            if ((this.forumStatus.isSupportGoPost()) && (paramString != null) && (paramString.length() > 0)) {
                getThreadGoPost();
                return;
            }
            getThreadData(paramString, paramBoolean);
            return;
        }
        getThreadData(paramString, paramBoolean);
    }

    public Object getItem(int paramInt) {
        if (paramInt < this.mDatas.size()) {
            return this.mDatas.get(paramInt);
        }
        return null;
    }

    public long getItemId(int paramInt) {
        return paramInt;
    }

    public int getItemViewType(int paramInt) {
        if ((this.mDatas.get(paramInt) instanceof HashMap)) {
            return 0;
        }
        if ((this.mDatas.get(paramInt) instanceof ThreadHeaderView)) {
            return 1;
        }
        if ((this.mDatas.get(paramInt) instanceof ThreadPageView)) {
            return 2;
        }
        if ((this.mDatas.get(paramInt) instanceof FlurryAdbean)) {
            return 3;
        }
        return 4;
    }

    public int getJumpTo() {
        if (this.should_jump) {
            return this.jump_to;
        }
        return 0;
    }

    public boolean getNewest() {
        int i = this.mOutFragment.mTopicController.getTotal_post_num() - 1;
        int j = i + 1 - this.mOutFragment.mTopicController.getCountPerPage();
        if (this.mStart == j) {
            return false;
        }
        this.mDatas.clear();
        this.mDatas.add(new ThreadHeaderView());
        this.mStart = j;
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(this.mOutFragment.mTopic.getId());
        localArrayList.add(Integer.valueOf(this.mStart));
        localArrayList.add(Integer.valueOf(i));
        if (this.forumStatus.isSupprotBBcode()) {
            localArrayList.add(Boolean.valueOf(true));
        }
        get_thread(localArrayList);
        return true;
    }

    public PostData getPost(int paramInt) {
        if ((this.mDatas.get(paramInt) instanceof HashMap)) {
            String str = (String) ((HashMap) this.mDatas.get(paramInt)).get("post_id");
            return (PostData) this.postDatas.get(str);
        }
        if ((this.mDatas.get(paramInt) instanceof PostData)) {
            return (PostData) this.mDatas.get(paramInt);
        }
        return null;
    }

    public PostData getPostByPostId(String paramString) {
        return (PostData) this.postDatas.get(paramString);
    }

    public boolean getPreviousThread() {
        int i = this.mStart - this.mOutFragment.mTopicController.getCountPerPage();
        if (i >= 0) {
            this.mStart = i;
            ArrayList localArrayList = new ArrayList();
            this.mDatas.clear();
            this.mDatas.add(new ThreadHeaderView());
            localArrayList.add(this.mOutFragment.mTopic.getId());
            localArrayList.add(Integer.valueOf(this.mStart));
            localArrayList.add(Integer.valueOf(this.mStart + this.mOutFragment.mTopicController.getCountPerPage() - 1));
            if (this.forumStatus.isSupprotBBcode()) {
                localArrayList.add(Boolean.valueOf(true));
            }
            get_thread(localArrayList);
            return true;
        }
        return false;
    }

    public void getRemoteThreadData() {
    }

    public int getReplyPosition() {
        return this.replyPosition;
    }

    public boolean getThreadByPage(int paramInt, boolean paramBoolean) {
        try {

            if ((paramInt > this.mOutFragment.mTopicController.getPageNum()) && (paramInt != 1)) {
                return false;
            }
            this.jump_to = 0;
            this.should_jump = false;
            ArrayList localArrayList;
            if ((this.mOutFragment.dataCache.containsKey("data")) && (((HashMap) this.mOutFragment.dataCache.get("data")).containsKey(Integer.valueOf(paramInt)))) {
                this.mDatas.clear();
                this.postDatas.clear();
                localArrayList = (ArrayList) ((HashMap) this.mOutFragment.dataCache.get("data")).get(Integer.valueOf(paramInt));
                paramInt = 0;
                if (paramInt >= localArrayList.size()) {
                    this.mDatas.addAll(localArrayList);
                    this.mOutFragment.mTopicController.setTotal_post_num(((Integer) this.mOutFragment.dataCache.get("total_post_num")).intValue());
                    if (this.mOutFragment.mTopicController.isNeedNotifyDataSetChanged()) {
                        this.mOutFragment.mTopicController.setNeedNotifyDataSetChanged(false);
                        this.mOutFragment.pagerAdapter.notifyDataSetChanged();
                    }
                    if (this.mOutFragment.dataCache.containsKey("repliedIds")) {
                        this.repliedIds = ((ArrayList) this.mOutFragment.dataCache.get("repliedIds"));
                    }
                    if (this.mOutFragment.dataCache.containsKey("issubscribe")) {
                        this.issubscribe = ((Boolean) this.mOutFragment.dataCache.get("issubscribe")).booleanValue();
                    }
                    if (this.mOutFragment.dataCache.containsKey("can_reply")) {
                        this.canReply = ((Boolean) this.mOutFragment.dataCache.get("can_reply")).booleanValue();
                    }
                    this.mStart = (this.mFragment.getCurrentPage() * this.mOutFragment.mTopicController.getCountPerPage());
                    if (this.mOutFragment.dataCache != null) {
                        this.mOutFragment.dataCache.put("last_page", Integer.valueOf(this.mFragment.getCurrentPage()));
                    }
                    GoogleAnalyticsTools.trackPageView(this.mOutFragment.activity, "thread", this.forumStatus.getForumId(), this.forumStatus.getUrl());
                    notifyDataSetChanged();
                }
            }
            for (; ; ) {
                return true;
                if ((localArrayList.get(paramInt) instanceof HashMap)) {
                    PostData localPostData = new PostData(this.mOutFragment, this, this.mOutFragment.mTopic.getId());
                    localPostData.fillData((HashMap) localArrayList.get(paramInt), this.mOutFragment.activity, this.forumStatus);
                    this.postDatas.put(localPostData.getPostId(), localPostData);
                }
                paramInt += 1;
                break;
                this.mDatas.clear();
                this.mDatas.add(new ThreadHeaderView());
                int j = this.mOutFragment.mTopicController.getCountPerPage();
                int i = (paramInt + 1) * this.mOutFragment.mTopicController.getCountPerPage() - 1;
                this.mStart = (paramInt * j);
                localArrayList = new ArrayList();
                if (this.mStart >= 0) {
                    paramInt = i;
                    if (i >= 0) {
                    }
                } else {
                    this.mStart = 0;
                    paramInt = this.mOutFragment.mTopicController.getCountPerPage();
                    this.mFragment.currentPage = 1;
                }
                localArrayList.add(this.mOutFragment.mTopic.getId());
                localArrayList.add(Integer.valueOf(this.mStart));
                localArrayList.add(Integer.valueOf(paramInt));
                if (this.forumStatus.isSupprotBBcode()) {
                    localArrayList.add(Boolean.valueOf(true));
                }
                get_thread(localArrayList);
            }
        } catch (Exception localException) {
            for (; ; ) {
            }
        }
    }

    public int getTotalPosts() {
        return this.mOutFragment.mTopicController.getTotal_post_num();
    }

    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
        int i = getItemViewType(paramInt);
        if (i == 0) {
            paramViewGroup = getPost(paramInt);
            if (((HashMap) this.mDatas.get(paramInt)).get("floor_number") != null) {
                paramViewGroup.floorNum = ((Integer) ((HashMap) this.mDatas.get(paramInt)).get("floor_number")).intValue();
            }
            if (paramViewGroup == null) {
                return new View(this.mOutFragment.activity);
            }
            i = paramInt;
            int j = i;
            if (paramInt > 2) {
                if ((!(this.mDatas.get(2) instanceof Banner)) && (!(this.mDatas.get(2) instanceof FlurryAdbean))) {
                    j = i;
                    if (!(this.mDatas.get(this.mDatas.size() - 1) instanceof FlurryAdbean)) {
                    }
                } else {
                    j = i - 1;
                }
            }
            if ((paramViewGroup.postId != null) && (paramViewGroup.postId == this.shouldAnimId)) {
                return paramViewGroup.getPostView(paramView, j, true, this.forumStatus, this, this.mOutFragment, this.mFragment.getCurrentPage() * this.mOutFragment.mTopicController.getCountPerPage(), paramInt);
            }
            return paramViewGroup.getPostView(paramView, j, false, this.forumStatus, this, this.mOutFragment, this.mFragment.getCurrentPage() * this.mOutFragment.mTopicController.getCountPerPage(), paramInt);
        }
        if (i == 1) {
            paramView = ThreadHeaderView.getHeaderView(this.mOutFragment, this, this.mFragment.getCurrentPage());
            paramViewGroup = (LinearLayout) paramView.findViewById(2131230848);
            if (getCount() > 1) {
                paramViewGroup.setVisibility(8);
                return paramView;
            }
            paramViewGroup.setVisibility(0);
            SettingsFragment.isLightTheme(this.mOutFragment.activity);
            return paramView;
        }
        if (i == 2) {
            paramView = ((ThreadPageView) this.mDatas.get(paramInt)).setTextView(this.mOutFragment, this.mOutFragment.activity, this.mFragment.currentPage);
        }
        for (; ; ) {
            return paramView;
            if (i == 3) {
                paramView = ((FlurryAdbean) this.mDatas.get(paramInt)).getPtBannerAdView(this.mOutFragment.activity, this, this.forumStatus, this.mOutFragment.mTopic);
            } else {
                paramView = ThreadFootView.getFootView(this.mOutFragment, this, this.mFragment.getCurrentPage(), this.forumStatus, this.mOutFragment.mTopic.getForumId(), this.mOutFragment.mTopic.getId());
            }
        }
    }

    public int getViewTypeCount() {
        return 5;
    }

    public ThreadFragment getmFragment() {
        return this.mFragment;
    }

    public void initUiHandler() {
        this.mUIHandler = new Handler() {
            public void handleMessage(Message paramAnonymousMessage) {
                Object localObject;
                if (paramAnonymousMessage.what == ThreadAdapter.this.SAX_UPDATE_BEGIN) {
                    if ((ThreadAdapter.this.mDatas.size() > 0) && ((ThreadAdapter.this.mDatas.get(ThreadAdapter.this.mDatas.size() - 1) instanceof ThreadFootView))) {
                        ThreadAdapter.this.mDatas.remove(ThreadAdapter.this.mDatas.size() - 1);
                    } else {
                        if (paramAnonymousMessage.what == ThreadAdapter.this.SAX_DISPLAY_ERROR) {
                            localObject = (String) paramAnonymousMessage.obj;
                            Toast.makeText(ThreadAdapter.this.mOutFragment.activity, (CharSequence) localObject, 1).show();
                            if (!ThreadAdapter.this.forumStatus.isLogin()) {
                                ThreadAdapter.this.mOutFragment.finishActiviry(true);
                            }
                        }
                        if (paramAnonymousMessage.what != ThreadAdapter.this.SAX_UPDATE_ITEM) {
                            break label840;
                        }
                        paramAnonymousMessage = (HashMap) paramAnonymousMessage.obj;
                        localObject = new PostData(ThreadAdapter.this.mOutFragment, ThreadAdapter.this, ThreadAdapter.this.mOutFragment.mTopic.getId());
                        ThreadAdapter.this.postDatas.put((String) paramAnonymousMessage.get("post_id"), localObject);
                        ((PostData) localObject).fillData(paramAnonymousMessage, ThreadAdapter.this.mOutFragment.activity, ThreadAdapter.this.forumStatus);
                        ThreadAdapter.this.tempDatas.add(paramAnonymousMessage);
                        if (AdsService.showAdmode(ThreadAdapter.this.mOutFragment.activity) != AdsService.SHOWNATIVE) {
                            break label691;
                        }
                        if ((ThreadAdapter.this.mFragment.currentPage + 1 == 1) && (ThreadAdapter.this.mDatas.size() == 1) && (ThreadAdapter.this.tempDatas.size() == 1)) {
                            ThreadAdapter.this.banerAdBean = AdsService.getBanerBean(ThreadAdapter.this.mOutFragment.activity, ThreadAdapter.this.forumStatus.tapatalkForum.getId().intValue(), ThreadAdapter.this.forumStatus);
                            if (ThreadAdapter.this.banerAdBean != null) {
                                ThreadAdapter.this.tempDatas.add(ThreadAdapter.this.banerAdBean);
                            }
                        }
                        label390:
                        if ((((PostData) localObject).authorDisplayName == null) || (((PostData) localObject).authorDisplayName.length() <= 0)) {
                            break label816;
                        }
                        ThreadAdapter.this.userNameList.put(((PostData) localObject).authorName, ((PostData) localObject).authorDisplayName);
                    }
                }
                for (; ; ) {
                    if ((paramAnonymousMessage.containsKey("icon_url")) && (((String) paramAnonymousMessage.get("icon_url")).length() > 0)) {
                        ((PostData) localObject).icon_url = ((String) paramAnonymousMessage.get("icon_url"));
                    }
                    if ((ThreadAdapter.this.mListView != null) && (ThreadAdapter.this.mDatas != null) && (ThreadAdapter.this.mDatas.size() % 3 == 0)) {
                        ThreadAdapter.this.mDatas.addAll(ThreadAdapter.this.tempDatas);
                        ThreadAdapter.this.tempDatas.clear();
                        ThreadAdapter.this.notifyDataSetChanged();
                    }
                    ThreadAdapter.this.should_jump = true;
                    return;
                    if (paramAnonymousMessage.what != ThreadAdapter.this.SAX_UPDATE_POSITION) {
                        break;
                    }
                    i = ((Integer) paramAnonymousMessage.obj).intValue();
                    int j = i / ThreadAdapter.this.mOutFragment.mTopicController.getCountPerPage();
                    ThreadAdapter.this.jumpPosition = (i % ThreadAdapter.this.mOutFragment.mTopicController.getCountPerPage());
                    if (ThreadAdapter.this.currentMethod.equalsIgnoreCase("get_thread")) {
                        break;
                    }
                    i = j;
                    if (ThreadAdapter.this.jumpPosition == 0) {
                        i = j;
                        if (j != 0) {
                            i = j - 1;
                            ThreadAdapter.this.jumpPosition = ThreadAdapter.this.mOutFragment.mTopicController.getCountPerPage();
                        }
                    }
                    if (!ThreadAdapter.this.isFirstTag) {
                        break;
                    }
                    ThreadAdapter.this.mFragment.currentPage = i;
                    break;
                    label691:
                    if ((!ThreadAdapter.this.mOutFragment.activity.getResources().getBoolean(2131558401)) || (ThreadAdapter.this.mDatas.size() != 1) || (ThreadAdapter.this.tempDatas.size() != 1) || (!ThreadAdapter.this.forumStatus.isAdShow()) || (ThreadAdapter.this.mOutFragment.mTopicController.getPageNum() == 1) || (ThreadAdapter.this.mFragment.currentPage + 1 == ThreadAdapter.this.mOutFragment.mTopicController.getPageNum())) {
                        break label390;
                    }
                    ThreadAdapter.this.addBanner(ThreadAdapter.this.tempDatas);
                    break label390;
                    label816:
                    ThreadAdapter.this.userNameList.put(((PostData) localObject).authorName, ((PostData) localObject).authorName);
                }
                label840:
                if (paramAnonymousMessage.what == ThreadAdapter.this.SAX_UPDATE_END) {
                    AppCacheManager.cacheData(ThreadAdapter.this.userNameCacheAddress, ThreadAdapter.this.userNameList);
                    if (ThreadAdapter.this.tempDatas.size() > 0) {
                        ThreadAdapter.this.mDatas.addAll(ThreadAdapter.this.tempDatas);
                        ThreadAdapter.this.tempDatas.clear();
                    }
                    if (AdsService.showAdmode(ThreadAdapter.this.mOutFragment.activity) == AdsService.SHOWNATIVE) {
                        if (!AdsService.adLeavel) {
                            if (ThreadAdapter.this.mFragment.currentPage + 1 == ThreadAdapter.this.mOutFragment.mTopicController.getPageNum()) {
                                ThreadAdapter.this.banerAdBean = AdsService.getBanerBean(ThreadAdapter.this.mOutFragment.activity, ThreadAdapter.this.forumStatus.tapatalkForum.getId().intValue(), ThreadAdapter.this.forumStatus);
                                if (ThreadAdapter.this.banerAdBean != null) {
                                    ThreadAdapter.this.mDatas.add(ThreadAdapter.this.banerAdBean);
                                }
                            }
                            label1036:
                            ThreadAdapter.this.mDatas.add(new ThreadFootView());
                            ThreadAdapter.this.mDatas.add(ThreadAdapter.this.mDatas.size(), new ThreadPageView());
                            ThreadAdapter.this.cacheData(ThreadAdapter.this.mOutFragment.cacheFile);
                            ThreadAdapter.this.notifyDataSetChanged();
                            if (ThreadAdapter.this.isFirstTag) {
                                if ((ThreadAdapter.this.shouldJumpToLast) && (ThreadAdapter.this.mOutFragment.mTopicController != null)) {
                                    ThreadAdapter.this.jumpPosition = (ThreadAdapter.this.mOutFragment.mTopicController.getTotal_post_num() % ThreadAdapter.this.mOutFragment.mTopicController.getCountPerPage());
                                    if (ThreadAdapter.this.jumpPosition == 0) {
                                        ThreadAdapter.this.jumpPosition = ThreadAdapter.this.mOutFragment.mTopicController.getCountPerPage();
                                    }
                                }
                                ThreadAdapter.this.mOutFragment.setPagerAdapterAndPosition(ThreadAdapter.this.mFragment.currentPage, ThreadAdapter.this.mFragment, ThreadAdapter.this.mFragment.currentPage, ThreadAdapter.this.jumpPosition, ThreadAdapter.this.isFirstTag);
                                ThreadAdapter.this.isFirstTag = false;
                            }
                            GoogleAnalyticsTools.trackPageView(ThreadAdapter.this.mOutFragment.activity, "thread", ThreadAdapter.this.forumStatus.getForumId(), ThreadAdapter.this.forumStatus.getUrl());
                            ThreadAdapter.this.mOutFragment.titleList.clear();
                            if (!SettingsFragment.isShowThreadPrefix(ThreadAdapter.this.mOutFragment.activity)) {
                                break label1826;
                            }
                            ThreadAdapter.this.mOutFragment.titleList.add(ThreadAdapter.this.mOutFragment.mTopic.getPrefix() + ThreadAdapter.this.mOutFragment.mTopic.getTitle());
                            label1382:
                            ThreadAdapter.this.mOutFragment.forumList.clear();
                            ThreadAdapter.this.mOutFragment.forumList = ThreadAdapter.this.forumStatus.getForumHierarch(ThreadAdapter.this.mOutFragment.activity, ThreadAdapter.this.mOutFragment.mTopic.getForumId());
                            i = 0;
                            label1440:
                            if (i < ThreadAdapter.this.mOutFragment.forumList.size()) {
                                break label1856;
                            }
                            if (!ThreadAdapter.this.mOutFragment.activity.getResources().getBoolean(2131558401)) {
                                break label1917;
                            }
                            ThreadAdapter.this.mOutFragment.titleList.add(TapatalkApp.rebranding_name);
                        }
                    }
                    for (; ; ) {
                        ThreadAdapter.this.mOutFragment.bar.setListNavigationCallbacks(new ThreadNavigationAdapter(ThreadAdapter.this.mOutFragment.activity, ThreadAdapter.this.mOutFragment.titleList), new ActionBar.OnNavigationListener() {
                            public boolean onNavigationItemSelected(int paramAnonymous2Int, long paramAnonymous2Long) {
                                if (paramAnonymous2Int == 0) {
                                }
                                do {
                                    return false;
                                    if ((paramAnonymous2Int == 0) || (paramAnonymous2Int == ThreadAdapter.this.mOutFragment.titleList.size() - 1)) {
                                        break;
                                    }
                                }
                                while (!(ThreadAdapter.this.mOutFragment.forumList.get(paramAnonymous2Int - 1) instanceof Forum));
                                Forum localForum = (Forum) ThreadAdapter.this.mOutFragment.forumList.get(paramAnonymous2Int - 1);
                                ThreadAdapter.this.mOutFragment.finishActiviry(localForum.getId());
                                return false;
                                ThreadAdapter.this.mOutFragment.finishActiviry(SlidingMenuActivity.CATOGORIES_FORUM_ID);
                                return false;
                            }
                        });
                        if ((ThreadAdapter.this.editJumpPosition > 0) && (ThreadAdapter.this.mFragment.threadList != null)) {
                            ThreadAdapter.this.mFragment.threadList.setSelection(ThreadAdapter.this.editJumpPosition);
                            ThreadAdapter.this.editJumpPosition = 0;
                        }
                        if ((ThreadAdapter.this.getReplyPosition() != -1) && (ThreadAdapter.this.mFragment.threadList != null)) {
                            ThreadAdapter.this.mFragment.threadList.setSelection(ThreadAdapter.this.getReplyPosition());
                            ThreadAdapter.this.setReplyPosition(-1);
                        }
                        if (!ThreadAdapter.this.mOutFragment.mTopicController.isNeedNotifyDataSetChanged()) {
                            break;
                        }
                        ThreadAdapter.this.mOutFragment.mTopicController.setNeedNotifyDataSetChanged(false);
                        ThreadAdapter.this.mOutFragment.pagerAdapter.notifyDataSetChanged();
                        return;
                        ThreadAdapter.this.banerAdBean = AdsService.getBanerBean(ThreadAdapter.this.mOutFragment.activity, ThreadAdapter.this.forumStatus.tapatalkForum.getId().intValue(), ThreadAdapter.this.forumStatus);
                        if ((ThreadAdapter.this.banerAdBean == null) || (ThreadAdapter.this.mFragment.currentPage + 1 == 1)) {
                            break label1036;
                        }
                        ThreadAdapter.this.mDatas.add(ThreadAdapter.this.banerAdBean);
                        break label1036;
                        if (ThreadAdapter.this.mFragment.currentPage + 1 != ThreadAdapter.this.mOutFragment.mTopicController.getPageNum()) {
                            break label1036;
                        }
                        ThreadAdapter.this.addLastBanner(ThreadAdapter.this.mDatas);
                        break label1036;
                        label1826:
                        ThreadAdapter.this.mOutFragment.titleList.add(ThreadAdapter.this.mOutFragment.mTopic.getTitle());
                        break label1382;
                        label1856:
                        if ((ThreadAdapter.this.mOutFragment.forumList.get(i) instanceof Forum)) {
                            ThreadAdapter.this.mOutFragment.titleList.add(((Forum) ThreadAdapter.this.mOutFragment.forumList.get(i)).getName());
                        }
                        i += 1;
                        break label1440;
                        label1917:
                        ThreadAdapter.this.mOutFragment.titleList.add(ThreadAdapter.this.forumStatus.tapatalkForum.getName());
                    }
                }
                int i = paramAnonymousMessage.what;
            }
        };
    }

    public void initialPostParser() {
        this.currentTag = ((int) (System.currentTimeMillis() % 10000L));
        if (this.mPostParser != null) {
            this.mPostParser.setCancel(true);
            this.mPostParser = null;
        }
        this.mPostParser = new PostSaxParser(this.mOutFragment, this, this.currentTag);
        this.mPostParser.setCallback(new PostSaxParser.ICallback() {
            public void onAddItem(HashMap paramAnonymousHashMap, int paramAnonymousInt1, int paramAnonymousInt2) {
                Message localMessage = ThreadAdapter.this.mUIHandler.obtainMessage();
                localMessage.what = ThreadAdapter.this.SAX_UPDATE_ITEM;
                localMessage.obj = paramAnonymousHashMap;
                localMessage.arg1 = paramAnonymousInt1;
                localMessage.arg2 = paramAnonymousInt2;
                ThreadAdapter.this.mUIHandler.sendMessage(localMessage);
            }

            public void onDocBegin(int paramAnonymousInt1, int paramAnonymousInt2) {
                Message localMessage = ThreadAdapter.this.mUIHandler.obtainMessage();
                localMessage.what = ThreadAdapter.this.SAX_UPDATE_BEGIN;
                localMessage.arg1 = paramAnonymousInt1;
                localMessage.arg2 = paramAnonymousInt2;
                if ((localMessage.arg1 == ThreadAdapter.this.currentTag) && (localMessage.arg2 == paramAnonymousInt2) && (!ThreadAdapter.this.isFootRefresh) && (ThreadAdapter.this.mDatas != null)) {
                    ThreadAdapter.this.mDatas.clear();
                    ThreadAdapter.this.mDatas.add(new ThreadHeaderView());
                    ThreadAdapter.this.postDatas.clear();
                }
                ThreadAdapter.this.mUIHandler.sendMessage(localMessage);
            }

            public void onDocEnd(int paramAnonymousInt1, int paramAnonymousInt2) {
                Message localMessage = ThreadAdapter.this.mUIHandler.obtainMessage();
                localMessage.what = ThreadAdapter.this.SAX_UPDATE_END;
                localMessage.arg1 = paramAnonymousInt1;
                localMessage.arg2 = paramAnonymousInt2;
                ThreadAdapter.this.mUIHandler.sendMessage(localMessage);
            }

            public void onGetPostNum(int paramAnonymousInt) {
                if (ThreadAdapter.this.mOutFragment.mTopicController.getTotal_post_num() != paramAnonymousInt) {
                    ThreadAdapter.this.mOutFragment.mTopicController.setTotal_post_num(paramAnonymousInt);
                    Message localMessage = ThreadAdapter.this.mUIHandler.obtainMessage();
                    localMessage.what = ThreadAdapter.this.SAX_CLOSE_PROGRESS;
                    ThreadAdapter.this.mUIHandler.sendMessage(localMessage);
                }
            }

            public void onGetResultText(String paramAnonymousString) {
                Message localMessage = ThreadAdapter.this.mUIHandler.obtainMessage();
                localMessage.what = ThreadAdapter.this.SAX_DISPLAY_ERROR;
                localMessage.obj = paramAnonymousString;
                ThreadAdapter.this.mUIHandler.sendMessage(localMessage);
            }

            public void onPosition(int paramAnonymousInt) {
                ThreadAdapter.this.mPosition = paramAnonymousInt;
                if (ThreadAdapter.this.currentMethod.equalsIgnoreCase("get_thread")) {
                    ThreadAdapter.this.mPosition = 0;
                }
                Message localMessage = ThreadAdapter.this.mUIHandler.obtainMessage();
                localMessage.what = ThreadAdapter.this.SAX_UPDATE_POSITION;
                localMessage.obj = Integer.valueOf(ThreadAdapter.this.mPosition);
                ThreadAdapter.this.mUIHandler.sendMessage(localMessage);
            }
        });
    }

    public boolean isCanReply() {
        return this.canReply;
    }

    public boolean isCanUpload() {
        return this.canUpload;
    }

    public void parseCallBack(EngineResponse paramEngineResponse) {
        String str1 = paramEngineResponse.getMethod();
        HashMap localHashMap;
        String str2;
        String str3;
        if (str1.equals("get_raw_post")) {
            localHashMap = (HashMap) paramEngineResponse.getResponse();
            str2 = (String) localHashMap.get("post_id");
            str3 = new String((byte[]) localHashMap.get("post_title"));
        }
        do {
            for (; ; ) {
                try {
                    paramEngineResponse = new String(Util.parseByteArray((byte[]) localHashMap.get("post_content")), "UTF-8");
                    str1 = "";
                    if (localHashMap.containsKey("edit_reason")) {
                        str1 = new String((byte[]) localHashMap.get("edit_reason"));
                    }
                    boolean bool = false;
                    if (localHashMap.containsKey("show_reason")) {
                        bool = ((Boolean) localHashMap.get("show_reason")).booleanValue();
                    }
                    this.mOutFragment.closeProgress();
                    startEditActivity(str2, str3, paramEngineResponse, str1, bool, this.mOutFragment.getCountdownNumber());
                    return;
                } catch (UnsupportedEncodingException paramEngineResponse) {
                    paramEngineResponse = new String((byte[]) localHashMap.get("post_content"));
                    continue;
                }
                if (str1.equals("m_delete_post")) {
                    Toast.makeText(this.baseContext, this.baseContext.getString(2131100025), 1).show();
                    refresh();
                    return;
                }
                if (str1.equals("subscribe_topic")) {
                    this.mOutFragment.closeProgress();
                }
                try {
                    if ((paramEngineResponse.getResponse() instanceof Boolean)) {
                        if (((Boolean) paramEngineResponse.getResponse()).booleanValue()) {
                            Toast.makeText(this.mOutFragment.activity, this.mOutFragment.activity.getString(2131099902), 1).show();
                        }
                    } else {
                        paramEngineResponse = (HashMap) paramEngineResponse.getResponse();
                        if (((Boolean) paramEngineResponse.get("result")).booleanValue()) {
                            Toast.makeText(this.mOutFragment.activity, this.mOutFragment.activity.getString(2131099902), 1).show();
                            return;
                        }
                        Toast.makeText(this.mOutFragment.activity, (String) paramEngineResponse.get("result_text"), 1).show();
                        return;
                    }
                } catch (Exception paramEngineResponse) {
                }
            }
        } while (!str1.equals("m_approve_post"));
        this.mOutFragment.closeProgress();
        paramEngineResponse = getPost(this.mFocusItemPosition);
        if (paramEngineResponse.isApprove) {
            paramEngineResponse.isApprove = false;
            Toast.makeText(this.baseContext, this.baseContext.getString(2131100048), 1).show();
        }
        for (; ; ) {
            notifyDataSetChanged();
            return;
            paramEngineResponse.isApprove = true;
            Toast.makeText(this.baseContext, this.baseContext.getString(2131100047), 1).show();
        }
    }

    void parseCallBackCommonMethod(List paramList) {
        paramList = paramList.get(0).toString();
        this.mStatus.closeProgress();
        if (paramList.equals("m_delete_topic")) {
            this.mOutFragment.mTopic.setDeleted(true);
            Toast.makeText(this.baseContext, this.baseContext.getString(2131100024), 1).show();
        }
        do {
            return;
            if (paramList.equals("m_undelete_topic")) {
                this.mOutFragment.mTopic.setDeleted(false);
                Toast.makeText(this.baseContext, this.baseContext.getString(2131100029), 1).show();
                return;
            }
            if (paramList.equals("m_undelete_post")) {
                Toast.makeText(this.baseContext, this.baseContext.getString(2131100026), 1).show();
                refresh();
                return;
            }
        } while (!paramList.equals("m_ban_user"));
        paramList = getPost(this.mFocusItemPosition).getRealName() + " " + this.baseContext.getString(2131100061);
        getPost(this.mFocusItemPosition).isBan = true;
        Toast.makeText(this.baseContext, paramList, 1).show();
        notifyDataSetChanged();
    }

    public void parsePosts(ArrayList paramArrayList) {
        int i = 0;
        for (; ; ) {
            if (i >= paramArrayList.size()) {
                notifyDataSetChanged();
                this.mOutFragment.closeProgress();
                return;
            }
            if ((paramArrayList.get(i) instanceof HashMap)) {
                HashMap localHashMap = (HashMap) paramArrayList.get(i);
                PostData localPostData = new PostData(this.mOutFragment, this, this.mOutFragment.mTopic.getId());
                this.postDatas.put((String) localHashMap.get("post_id"), localPostData);
                localPostData.fillData(localHashMap, this.mOutFragment.activity, this.forumStatus);
                this.mDatas.add(localHashMap);
            }
            i += 1;
        }
    }

    public void recycleImage(ArrayList<ImageInThread> paramArrayList) {
        int i = 0;
        for (; ; ) {
            if (i >= paramArrayList.size()) {
                return;
            }
            if (paramArrayList.get(i) != null) {
                int[] arrayOfInt = new int[2];
                ((ImageInThread) paramArrayList.get(i)).iv.getLocationInWindow(arrayOfInt);
                int j = arrayOfInt[1];
                if ((j >= this.mOutFragment.activity.getWindowManager().getDefaultDisplay().getHeight() - 30) || (j <= -(((ImageInThread) paramArrayList.get(i)).iv.getMeasuredHeight() - 20)) || (!((ImageInThread) paramArrayList.get(i)).iv.isShown())) {
                    ((ImageInThread) paramArrayList.get(i)).iv.recyle();
                }
            }
            i += 1;
        }
    }

    public void refresh() {
        this.mDatas.clear();
        this.postDatas.clear();
        this.bannerHash.clear();
        this.mDatas.add(new ThreadHeaderView());
        ((HashMap) this.mOutFragment.dataCache.get("data")).remove(Integer.valueOf(this.mFragment.getCurrentPage()));
        if ((this.isAnn) && (this.forumStatus.isVB())) {
            get_ann();
            return;
        }
        if (this.mFragment.getCurrentPage() > this.mOutFragment.mTopicController.getPageNum()) {
            this.mFragment.currentPage = this.mOutFragment.mTopicController.getPageNum();
        }
        getThreadByPage(this.mFragment.getCurrentPage(), false);
    }

    public void refresh(int paramInt) {
        this.mDatas.clear();
        this.postDatas.clear();
        this.mDatas.add(new ThreadHeaderView());
        ((HashMap) this.mOutFragment.dataCache.get("data")).remove(Integer.valueOf(paramInt));
        getThreadByPage(paramInt, false);
    }

    public void removeOnePage() {
        if (this.mOutFragment.pagerAdapter != null) {
            this.mOutFragment.pagerAdapter.setTopicController(this.mOutFragment.mTopicController);
            this.mOutFragment.pagerAdapter.destroyFragment(this.mOutFragment.mPager, this.mFragment.getCurrentPage() + 1);
            this.mOutFragment.pagerAdapter.notifyDataSetChanged();
        }
    }

    public void report_post(ArrayList paramArrayList) {
        setTryTwice(false);
        this.engine.call("report_post", paramArrayList);
    }

    public void setAddRebrandBanner(AddBannerInterface paramAddBannerInterface) {
        this.addRebrandBanner = paramAddBannerInterface;
    }

    public void setReplyPosition(int paramInt) {
        this.replyPosition = paramInt;
    }

    public void setShouldJumpToLast() {
        this.shouldJumpToLast = true;
    }

    public void setTopicId(String paramString) {
        this.mOutFragment.mTopic.setId(paramString);
    }

    public void setmFragment(ThreadFragment paramThreadFragment) {
        this.mFragment = paramThreadFragment;
    }

    public void startEditActivity(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean, int paramInt) {
        Intent localIntent = new Intent(this.mOutFragment.activity, CreateTopicActivity.class);
        localIntent.putExtra("postid", paramString1);
        localIntent.putExtra("posttitle", paramString2);
        localIntent.putExtra("postcontent", paramString3);
        localIntent.putExtra("modifytype", 40);
        localIntent.putExtra("forumStatus", this.forumStatus);
        localIntent.putExtra("edit_reason", paramString4);
        localIntent.putExtra("show_reason", paramBoolean);
        localIntent.putExtra("countdown", paramInt);
        localIntent.putExtra("canUpload", false);
        paramInt = 0;
        for (; ; ) {
            if (paramInt >= this.mDatas.size()) {
                this.mOutFragment.startActivityForResult(localIntent, 40);
                return;
            }
            if (((this.mDatas.get(paramInt) instanceof HashMap)) && (((HashMap) this.mDatas.get(paramInt)).get("post_id").equals(paramString1))) {
                this.editJumpPosition = paramInt;
            }
            paramInt += 1;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/adapter/forum/ThreadAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */