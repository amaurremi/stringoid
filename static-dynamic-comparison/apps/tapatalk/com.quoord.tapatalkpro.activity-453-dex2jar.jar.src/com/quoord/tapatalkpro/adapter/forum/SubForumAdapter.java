package com.quoord.tapatalkpro.adapter.forum;

import android.annotation.TargetApi;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.quoord.tapatalkpro.action.GetTopicAction;
import com.quoord.tapatalkpro.activity.forum.ForumActivityStatus;
import com.quoord.tapatalkpro.ads.AdBean;
import com.quoord.tapatalkpro.ads.AdsService;
import com.quoord.tapatalkpro.bean.EngineResponse;
import com.quoord.tapatalkpro.bean.Forum;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.bean.TapatalkForum;
import com.quoord.tapatalkpro.bean.Topic;
import com.quoord.tapatalkpro.ics.forum.SubForumFragment;
import com.quoord.tapatalkpro.ics.slidingMenu.SlidingMenuActivity;
import com.quoord.tapatalkpro.ui.ButtomProgress;
import com.quoord.tapatalkpro.util.ThemeUtil;
import com.quoord.tools.tracking.GoogleAnalyticsTools;

public class SubForumAdapter
        extends ForumRootAdapter
        implements AdapterView.OnItemClickListener {
    public int curTabId;
    LinearLayout footLay;
    RelativeLayout guestForumContainer;
    RelativeLayout guestView;
    ImageView loginButton;
    Activity mContext;
    SubForumAdapter mThis;
    ImageView registerButton;
    TopicAdapter topicAdapter;
    TextView tv;

    public SubForumAdapter(Activity paramActivity, String paramString1, Forum paramForum, ListView paramListView, String paramString2) {
        super(paramActivity, paramString1);
        this.mForum = paramForum;
        this.stackType = paramString2;
        this.mThis = this;
        this.mContext = paramActivity;
        int i;
        if (this.mForum != null) {
            if (this.forumStatus != null) {
                paramActivity = paramString1;
                if (paramString1 != null) {
                    paramActivity = paramString1;
                    if (!paramString1.endsWith("/")) {
                        paramActivity = paramString1 + "/";
                    }
                }
                new StringBuilder(String.valueOf(paramActivity)).append(this.mForum.getId()).toString();
                i = this.forumStatus.tapatalkForum.isPRSupport().intValue();
                if (!this.forumStatus.isLogin()) {
                    break label380;
                }
            }
        }
        label380:
        for (; ; ) {
            if (i > 0) {
                i = this.forumStatus.tapatalkForum.getIsPT();
                AdsService.addAdsByPt(this.mContext, this.mForum.getId(), i, this.forumStatus.tapatalkForum.getId().intValue(), false, this.forumStatus);
            }
            this.mListView = paramListView;
            ThemeUtil.setListViewStyle(this.mListView, this.mContext);
            this.mListView.setOnItemClickListener(this);
            if (!this.mForum.isSubOnly()) {
                this.footLay = ButtomProgress.get(this.mContext);
                this.mListView.addFooterView(this.footLay);
                this.mListView.setFooterDividersEnabled(false);
            }
            this.tv = ThemeUtil.getSectionTitle(this.mContext);
            if (this.mForum.getName() != null) {
                this.tv.setText(this.mForum.getName());
            }
            this.topicAdapter = new TopicAdapter(this.baseContext, this.forumStatus.getUrl(), paramForum, this);
            this.topicAdapter.mListView = this.mListView;
            this.mListView.setAdapter(this.topicAdapter);
            this.mListView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            this.mListView.setOnScrollListener(new AbsListView.OnScrollListener() {
                public void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {
                    paramAnonymousInt1 += paramAnonymousInt2;
                    if ((paramAnonymousInt1 >= 10) && (paramAnonymousInt1 == paramAnonymousInt3) && (!SubForumAdapter.this.topicAdapter.getTopicAction.loadingMore) && (SubForumAdapter.this.topicAdapter.isFootNeeded()) && (SubForumAdapter.this.topicAdapter.getCount() != 0)) {
                        SubForumAdapter.this.topicAdapter.getTopic();
                    }
                }

                public void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt) {
                }
            });
            GoogleAnalyticsTools.trackPageView(this.mContext, "forum", this.forumStatus.getForumId(), this.forumStatus.getUrl());
            return;
        }
    }

    public void addFooter() {
        if (!this.mForum.isSubOnly()) {
            this.mListView.addFooterView(this.footLay);
            this.mListView.setFooterDividersEnabled(false);
        }
    }

    public boolean canPost() {
        if (this.topicAdapter != null) {
            return this.topicAdapter.canPost();
        }
        return false;
    }

    @TargetApi(8)
    public void destroy() {
        if (this.mListView != null) {
            this.mListView.smoothScrollBy(0, 0);
        }
        if (this.topicAdapter != null) {
            this.topicAdapter.destroy();
        }
    }

    public int getCount() {
        return getCurAdapter().getCount();
    }

    public TopicAdapter getCurAdapter() {
        return this.topicAdapter;
    }

    public Object getItem(int paramInt) {
        return getCurAdapter().getItem(paramInt);
    }

    public long getItemId(int paramInt) {
        return paramInt;
    }

    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
        return getCurAdapter().getView(paramInt, paramView, paramViewGroup);
    }

    public boolean isEnabled(int paramInt) {
        return (getItem(paramInt) instanceof Forum);
    }

    public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {
        if (paramInt < getCurAdapter().getCount()) {
            paramAdapterView = getItem(paramInt);
            if (!(paramAdapterView instanceof Forum)) {
                break label72;
            }
            boolean bool = false;
            if (((Forum) paramAdapterView).isProtected()) {
                bool = getIsLogin(((Forum) paramAdapterView).getId());
            }
            forumItemClicked((Forum) paramAdapterView, bool, (SlidingMenuActivity) this.mContext, this.stackType);
        }
        label72:
        do {
            return;
            if ((paramAdapterView instanceof Topic)) {
                if ((getCurAdapter() instanceof TopicAdapter)) {
                    paramView = getCurAdapter().getTopicAction;
                    ((Topic) paramAdapterView).setRequiredPrefix(paramView.requiredPrefix());
                    ((Topic) paramAdapterView).setPrefixes(paramView.mPrefixes);
                    if (paramView.total_topic_num > 1) {
                        ((Topic) paramAdapterView).isShowMergeTopic = true;
                    }
                }
                getCurAdapter().currentSelectedPosition = paramInt;
                ((Topic) paramAdapterView).setForum(this.mForum);
                ((Topic) paramAdapterView).openThread(this.mContext, this.forumStatus);
                if ((((SlidingMenuActivity) this.mContext).currentFragment instanceof SubForumFragment)) {
                    ((SubForumFragment) ((SlidingMenuActivity) this.mContext).currentFragment).setIdByTwoPanel(((Topic) paramAdapterView).getId());
                }
                getCurAdapter().notifyDataSetChanged();
                return;
            }
        } while (!(paramAdapterView instanceof AdBean));
        ((AdBean) paramAdapterView).onClick(paramView, (ForumActivityStatus) this.mContext);
    }

    public void parseCallBack(EngineResponse paramEngineResponse) {
    }

    public void refresh() {
        getCurAdapter().refresh();
    }

    public void removeFooter() {
        if (this.footLay != null) {
        }
        try {
            this.mListView.removeFooterView(this.footLay);
            return;
        } catch (Exception localException) {
        }
    }

    public void removeItem(int paramInt) {
        getCurAdapter().removeItem(paramInt);
        getCurAdapter().notifyDataSetChanged();
    }

    public void startNewTopic() {
        this.topicAdapter.getTopicAction.startNewTopic();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/adapter/forum/SubForumAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */