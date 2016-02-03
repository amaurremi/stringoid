package com.quoord.tapatalkpro.adapter.forum;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.quoord.tapatalkpro.TapatalkApp;
import com.quoord.tapatalkpro.action.AddBannerInterface;
import com.quoord.tapatalkpro.bean.Banner;
import com.quoord.tapatalkpro.bean.EngineResponse;
import com.quoord.tapatalkpro.bean.Forum;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.bean.NoTopicView;
import com.quoord.tapatalkpro.bean.RebrandingConfig;
import com.quoord.tapatalkpro.bean.TapatalkForum;
import com.quoord.tapatalkpro.bean.Topic;
import com.quoord.tapatalkpro.bean.TopicParser;
import com.quoord.tapatalkpro.ics.forum.SubscribeForumFragment;
import com.quoord.tapatalkpro.ics.slidingMenu.SlidingMenuActivity;
import com.quoord.tapatalkpro.sqlhelper.SubscribeForumSqlHelper;
import com.quoord.tapatalkpro.ui.ButtomProgress;
import com.quoord.tapatalkpro.util.Prefs;
import com.quoord.tapatalkpro.util.TapatalkEngine;
import com.quoord.tapatalkpro.util.TapatalkJsonEngine;
import com.quoord.tools.tracking.GoogleAnalyticsTools;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONObject;

public class SubscribeForumAndTopicAdapter
        extends ForumRootAdapter
        implements AdapterView.OnItemClickListener, AddBannerInterface {
    private AddBannerInterface addRebrandBanner;
    private HashMap<Integer, Object> bannerHash = new HashMap();
    public int currentSelectedPosition = -1;
    private int favForumSize = 0;
    private LinearLayout footProgressView;
    private ArrayList<String> ids = new ArrayList();
    private boolean isDislayUnread = false;
    private TapatalkJsonEngine jsonEngine;
    private ArrayList<Forum> loForums = new ArrayList();
    private boolean loadingMoreLatest = false;
    public ArrayList<Object> mAllDatas = new ArrayList();
    SlidingMenuActivity mContext;
    private int mCountPerpage = 20;
    public ArrayList<Object> mDatas = new ArrayList();
    private int mStart = 0;
    private NoTopicView noTopicView = new NoTopicView();
    private ArrayList<Object> subTopics = new ArrayList();
    private boolean subscribeTopic;
    private int totalCagetoryCount;
    private int total_topic_count = 0;
    private boolean updateLocalSubscribeForum = false;
    private NoTopicView view;

    public SubscribeForumAndTopicAdapter(Activity paramActivity, String paramString1, ListView paramListView, String paramString2, boolean paramBoolean) {
        super(paramActivity, paramString1);
        this.mContext = ((SlidingMenuActivity) paramActivity);
        this.mListView = paramListView;
        this.stackType = paramString2;
        this.subscribeTopic = paramBoolean;
        this.footProgressView = ButtomProgress.get(this.mContext);
        paramListView.addFooterView(this.footProgressView);
        this.view = new NoTopicView();
        this.mListView.setOnItemClickListener(this);
        this.mListView.setAdapter(this);
        this.jsonEngine = new TapatalkJsonEngine(this.mContext, this);
        Prefs.get(this.mContext);
        getLocalSubscribeForum();
        get_subscribe_topic();
        GoogleAnalyticsTools.trackPageView(this.mContext, "subscribed", this.forumStatus.getForumId(), this.forumStatus.getUrl());
        this.mListView.setOnScrollListener(new AbsListView.OnScrollListener() {
            public void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {
                if ((paramAnonymousInt1 + paramAnonymousInt2 == paramAnonymousInt3) && (!SubscribeForumAndTopicAdapter.this.loadingMoreLatest) && (SubscribeForumAndTopicAdapter.this.isFootNeeded())) {
                    SubscribeForumAndTopicAdapter.this.get_subscribe_topic();
                    SubscribeForumAndTopicAdapter.this.loadingMoreLatest = true;
                }
            }

            public void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt) {
            }
        });
    }

    private void changeData() {
        this.mListView.removeFooterView(this.footProgressView);
        if (this.updateLocalSubscribeForum) {
            getLocalSubscribeForum();
        }
        ArrayList localArrayList;
        int i;
        if (this.isDislayUnread) {
            localArrayList = new ArrayList();
            i = 0;
            if (i >= this.mAllDatas.size()) {
                this.mDatas = localArrayList;
                label56:
                if (this.mDatas.size() != 0) {
                    break label214;
                }
                this.mDatas.add(this.noTopicView);
            }
        }
        for (; ; ) {
            notifyDataSetChanged();
            return;
            if (((this.mAllDatas.get(i) instanceof Topic)) && (((Topic) this.mAllDatas.get(i)).getNewPost())) {
                addBanner(this.mContext, localArrayList);
                localArrayList.add(this.mAllDatas.get(i));
            }
            if (((this.mAllDatas.get(i) instanceof Forum)) && (this.forumStatus.checkNewPost(((Forum) this.mAllDatas.get(i)).getId()))) {
                addBanner(this.mContext, localArrayList);
                localArrayList.add(this.mAllDatas.get(i));
            }
            i += 1;
            break;
            this.mDatas = this.mAllDatas;
            break label56;
            label214:
            if (this.mDatas.contains(this.noTopicView)) {
                this.mDatas.remove(this.noTopicView);
            }
        }
    }

    private void getLocalSubscribeForum() {
        this.updateLocalSubscribeForum = false;
        ArrayList localArrayList = new SubscribeForumSqlHelper(this.mContext, TapatalkApp.database_name, null, Integer.parseInt(TapatalkApp.database_version)).get(this.forumStatus.getUrl());
        int i = 0;
        for (; ; ) {
            if (i >= localArrayList.size()) {
                if (this.loForums.size() > 0) {
                    this.mAllDatas.addAll(this.loForums);
                    changeData();
                }
                return;
            }
            if (!this.ids.contains(((Forum) localArrayList.get(i)).getId())) {
                ((Forum) localArrayList.get(i)).setSubscribe(true);
                this.loForums.add((Forum) localArrayList.get(i));
                this.ids.add(((Forum) localArrayList.get(i)).getId());
            }
            i += 1;
        }
    }

    public void AddRebrandBannerItem() {
        if (this.addRebrandBanner != null) {
            this.addRebrandBanner.addRebrandBanner();
            notifyDataSetChanged();
        }
    }

    public void addBanner(Activity paramActivity, ArrayList<Object> paramArrayList) {
        if ((this.forumStatus != null) && (this.forumStatus.getRebrandingConfig() != null) && (this.forumStatus.isAdShow()) && (((this.forumStatus.getRebrandingConfig().getDfp_320x50() != null) && (!this.forumStatus.getRebrandingConfig().getDfp_320x50().equals(""))) || ((this.forumStatus.getRebrandingConfig().getAdmobId() != null) && (!this.forumStatus.getRebrandingConfig().getAdmobId().equals(""))))) {
            Banner.addBanner(paramActivity, paramArrayList);
        }
    }

    public void addRebrandBanner() {
    }

    public AddBannerInterface getAddRebrandBanner() {
        return this.addRebrandBanner;
    }

    public int getCount() {
        return this.mDatas.size();
    }

    public Object getItem(int paramInt) {
        if ((this.mDatas != null) && (this.mDatas.size() > 0)) {
            return this.mDatas.get(paramInt);
        }
        return null;
    }

    public long getItemId(int paramInt) {
        return paramInt;
    }

    public int getItemViewType(int paramInt) {
        if ((getItem(paramInt) instanceof Forum)) {
            return 0;
        }
        if ((getItem(paramInt) instanceof Topic)) {
            return 1;
        }
        if ((getItem(paramInt) instanceof Banner)) {
            if (((Banner) this.mDatas.get(paramInt)).view == null) {
                return 2;
            }
            if (((Banner) this.mDatas.get(paramInt)).displayBanner) {
                return 3;
            }
            return 4;
        }
        if ((getItem(paramInt) instanceof NoTopicView)) {
            return 5;
        }
        return 6;
    }

    public void getTapatalkSubscribeForum() {
        SharedPreferences localSharedPreferences = Prefs.get(this.mContext);
        if ((localSharedPreferences.getBoolean("login", false)) && (this.forumStatus != null) && (this.forumStatus.tapatalkForum != null)) {
            this.jsonEngine.getSubscribeForum(localSharedPreferences.getInt("tapatalk_auid", 0), localSharedPreferences.getString("token", ""), this.forumStatus.tapatalkForum.getId());
        }
    }

    public void getUnreadSubcribe(boolean paramBoolean) {
        this.isDislayUnread = paramBoolean;
        changeData();
    }

    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
        if ((getItem(paramInt) instanceof Topic)) {
            paramViewGroup = new HashMap();
            paramViewGroup.put("showForumName", Boolean.valueOf(true));
            paramViewGroup.put("isSubscribedTab", Boolean.valueOf(true));
            if (((this.mContext instanceof SlidingMenuActivity)) && (this.mContext.getShowSlectionStatus())) {
                if (paramInt != this.currentSelectedPosition) {
                    break label101;
                }
                paramViewGroup.put("showSelectBg", Boolean.valueOf(true));
            }
            for (; ; ) {
                return ((Topic) getItem(paramInt)).createView(paramViewGroup, paramView, this.mContext);
                label101:
                paramViewGroup.put("showSelectBg", Boolean.valueOf(false));
            }
        }
        if ((getItem(paramInt) instanceof Forum)) {
            if (paramInt == 0) {
                return Forum.getForumView(Forum.TOP_FORUM_ITEM, (Forum) getItem(paramInt), paramView, paramViewGroup, this.forumStatus, this.mContext, this, true);
            }
            if (paramInt == this.favForumSize - 1) {
                return Forum.getForumView(Forum.BOTTOM_FORUM_ITEM, (Forum) getItem(paramInt), paramView, paramViewGroup, this.forumStatus, this.mContext, this, true);
            }
            return Forum.getForumView(Forum.MID_FORUM_ITEM, (Forum) getItem(paramInt), paramView, paramViewGroup, this.forumStatus, this.mContext, this, true);
        }
        if ((getItem(paramInt) instanceof NoTopicView)) {
            return ((NoTopicView) getItem(paramInt)).getItemView(this.mContext, this.mContext.getString(2131100154));
        }
        return ((IItemView) getItem(paramInt)).getItemView();
    }

    public int getViewTypeCount() {
        return 7;
    }

    public void get_subscribe_forum() {
        if ((this.forumStatus.getApiLevel() >= 3) && (this.forumStatus.isSubscribeForum())) {
            if (this.mListView.getFooterViewsCount() == 0) {
                this.mListView.addFooterView(this.footProgressView);
            }
            this.loadingMore = true;
            setTryTwice(false);
            ArrayList localArrayList = new ArrayList();
            this.engine.call("get_subscribed_forum", localArrayList);
        }
    }

    public void get_subscribe_topic() {
        if (this.mListView.getFooterViewsCount() == 0) {
            this.mListView.addFooterView(this.footProgressView);
        }
        this.loadingMore = true;
        setTryTwice(false);
        this.icons.clear();
        ArrayList localArrayList = new ArrayList();
        if (this.forumStatus.isSubscribeLoad()) {
            localArrayList.add(Integer.valueOf(this.mStart));
            localArrayList.add(Integer.valueOf(this.mStart + this.mCountPerpage - 1));
        }
        this.engine.call("get_subscribed_topic", localArrayList);
    }

    public boolean isEnabled(int paramInt) {
        if ((getItem(paramInt) instanceof Forum)) {
        }
        while (((getItem(paramInt) instanceof Topic)) || ((getItem(paramInt) instanceof String)) || ((getItem(paramInt) instanceof NoTopicView))) {
            return true;
        }
        return false;
    }

    public boolean isFootNeeded() {
        return this.mStart < this.total_topic_count;
    }

    public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {
        if (((this.mListView.getFooterViewsCount() > 0) && (this.mDatas.size() <= 0)) || (paramInt >= this.mDatas.size())) {
        }
        do {
            do {
                return;
                this.currentSelectedPosition = paramInt;
                notifyDataSetChanged();
                paramAdapterView = getItem(paramInt);
                if (((paramAdapterView instanceof Forum)) && ((this.mContext instanceof SlidingMenuActivity))) {
                    boolean bool = false;
                    if (((Forum) paramAdapterView).isProtected()) {
                        bool = getIsLogin(((Forum) paramAdapterView).getId());
                    }
                    forumItemClicked((Forum) paramAdapterView, bool, this.mContext, this.stackType);
                }
            } while ((!(paramAdapterView instanceof Topic)) || (this.mContext == null) || (this.forumStatus == null));
            ((Topic) paramAdapterView).openThreadAndChangeUnreadNum(this, this.mContext, this.forumStatus);
        } while (!(this.mContext.currentFragment instanceof SubscribeForumFragment));
        ((SubscribeForumFragment) this.mContext.currentFragment).setIdByTwoPanel(((Topic) paramAdapterView).getId());
    }

    public void parseCallBack(EngineResponse paramEngineResponse) {
        Object localObject1 = paramEngineResponse.getMethod();
        Object localObject2;
        int i;
        if (((String) localObject1).equals("get_subscribed_forum")) {
            localObject2 = (Object[]) ((HashMap) paramEngineResponse.getResponse()).get("forums");
            if ((localObject2 != null) && (localObject2.length > 0)) {
                this.favForumSize = localObject2.length;
                i = 0;
                if (i < localObject2.length) {
                    break label346;
                }
                setOpCancel(false);
            }
        }
        if ((((String) localObject1).contains("au_get_subscribed_forums")) && (paramEngineResponse.isSuccess())) {
        }
        try {
            localObject2 = (JSONArray) ((JSONObject) paramEngineResponse.getResponse()).get("subscribed_forums");
            i = 0;
            label105:
            int j = ((JSONArray) localObject2).length();
            if (i < j) {
                break label415;
            }
        } catch (Exception localException) {
            label346:
            label415:
            for (; ; ) {
            }
        }
        if (((String) localObject1).equals("get_subscribed_topic")) {
            Prefs.get(this.mContext).getBoolean("subscribe", true);
            get_subscribe_forum();
            getTapatalkSubscribeForum();
            this.loadingMoreLatest = false;
            localObject1 = (HashMap) paramEngineResponse.getResponse();
            paramEngineResponse = (Object[]) ((HashMap) localObject1).get("topics");
            this.total_topic_count = ((Integer) ((HashMap) localObject1).get("total_topic_num")).intValue();
            this.mStart += this.mCountPerpage;
            if ((paramEngineResponse != null) && (paramEngineResponse.length > 0)) {
                i = 0;
            }
        }
        for (; ; ) {
            if (i >= paramEngineResponse.length) {
                if ((!isFootNeeded()) || (!this.forumStatus.isSubscribeLoad())) {
                    this.mListView.removeFooterView(this.footProgressView);
                }
                if (!this.forumStatus.isSubscribeLoad()) {
                    this.total_topic_count = (this.subTopics.size() - 1);
                }
                if ((!this.mContext.getApplicationContext().getResources().getBoolean(2131558401)) && (!this.forumStatus.isPush())) {
                    this.loadingMore = false;
                }
                if (this.subTopics.size() > 0) {
                    this.mAllDatas.addAll(this.subTopics);
                    this.subTopics.clear();
                }
                changeData();
                return;
                Object localObject3 = Forum.createForumBean((HashMap) localObject2[i], this.forumStatus, this.mContext, null, null, 0);
                if (!this.ids.contains(((Forum) localObject3).getId())) {
                    saveSubscribevForum((Forum) localObject3);
                    this.ids.add(((Forum) localObject3).getId());
                    this.updateLocalSubscribeForum = true;
                }
                i += 1;
                break;
                localObject3 = ((JSONObject) ((JSONArray) localObject2).get(i)).getString("sfid");
                localObject3 = this.forumStatus.getForumById(this.mContext, (String) localObject3);
                if ((localObject3 != null) && (!this.ids.contains(((Forum) localObject3).getId()))) {
                    ((Forum) localObject3).setSubscribe(true);
                    saveSubscribevForum((Forum) localObject3);
                    this.ids.add(((Forum) localObject3).getId());
                    this.updateLocalSubscribeForum = true;
                }
                i += 1;
                break label105;
            }
            localObject1 = TopicParser.createTopicBean((HashMap) paramEngineResponse[i], null, this.mContext, this.forumStatus);
            ((Topic) localObject1).setSubscribe(true);
            ((Topic) localObject1).setCanSubscribe(true);
            addBanner(this.mContext, this.subTopics);
            if (!this.ids.contains(((Topic) localObject1).getId())) {
                this.subTopics.add(localObject1);
                this.ids.add(((Topic) localObject1).getId());
            }
            i += 1;
        }
    }

    public void refresh() {
        if (!this.loadingMoreLatest) {
            setOpCancel(false);
            this.favForumSize = 0;
            this.total_topic_count = 0;
            if (this.mListView.getFooterViewsCount() == 0) {
                this.mListView.addFooterView(this.footProgressView);
            }
            this.ids.clear();
            this.mDatas.clear();
            this.loForums.clear();
            this.mAllDatas.clear();
            this.subTopics.clear();
            this.bannerHash.clear();
            refreshTopic();
            getLocalSubscribeForum();
        }
    }

    public void refreshForum() {
        get_subscribe_forum();
    }

    public void refreshTopic() {
        this.mStart = 0;
        get_subscribe_topic();
    }

    public void removeItem(int paramInt) {
        ArrayList localArrayList = new SubscribeForumSqlHelper(this.mContext, TapatalkApp.database_name, null, Integer.parseInt(TapatalkApp.database_version)).get(this.forumStatus.getUrl());
        this.mDatas.remove(paramInt);
        if ((this.totalCagetoryCount > 0) && (paramInt <= this.totalCagetoryCount + 1)) {
            this.totalCagetoryCount = localArrayList.size();
        }
        if (this.mDatas.size() == 0) {
            this.mDatas.add(new NoTopicView());
        }
        notifyDataSetChanged();
    }

    public void removeItem(Object paramObject) {
        this.mDatas.remove(paramObject);
        this.total_topic_count -= 1;
        notifyDataSetChanged();
    }

    public void saveSubscribevForum(Forum paramForum) {
        new SubscribeForumSqlHelper(this.mContext, TapatalkApp.database_name, null, Integer.parseInt(TapatalkApp.database_version)).save(paramForum, this.forumStatus.getUrl());
    }

    public void setAddRebrandBanner(AddBannerInterface paramAddBannerInterface) {
        this.addRebrandBanner = paramAddBannerInterface;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/adapter/forum/SubscribeForumAndTopicAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */