package com.quoord.tapatalkpro.feed;

import android.app.Activity;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.androidquery.AQuery;
import com.quoord.tapatalkpro.activity.forum.ForumActivityStatus;
import com.quoord.tapatalkpro.adapter.forum.moderation.SectionTitleListViewAdapter;
import com.quoord.tapatalkpro.bean.Feed;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.bean.TapatalkForum;
import com.quoord.tapatalkpro.bean.Topic;
import com.quoord.tapatalkpro.ics.slidingMenu.SettingsFragment;
import com.quoord.tapatalkpro.ui.GroupBean;
import com.quoord.tapatalkpro.ui.ListItemRemoveAnimatorController;
import com.quoord.tapatalkpro.ui.ListItemRemoveAnimatorController.DismissCallbacks;
import com.quoord.tapatalkpro.view.SectionTitleListView;
import com.quoord.tools.net.TapatalkAjaxLogAction;

import java.util.ArrayList;
import java.util.HashMap;

public class FeedListAdapter
        extends SectionTitleListViewAdapter {
    private int GroupPosition = 0;
    private AQuery aq;
    private ArrayList<Object> dataList;
    private FeedFragment feedFragment;
    public GroupBean feedGroupBean;
    public ForumStatus forumStatus;
    private TapatalkAjaxLogAction logAction;
    private ListItemRemoveAnimatorController mRemover = null;
    public GroupBean notificationGroupBean;
    private TapatalkForum tapatalkForum;
    public GroupBean topicGroupBean;
    public int trendingTopicImageHeight = 0;
    public int trendingTopicNoImageHeight = 0;

    public FeedListAdapter(ArrayList<Object> paramArrayList, Activity paramActivity, SectionTitleListView paramSectionTitleListView, FeedFragment paramFeedFragment) {
        setDataList(paramArrayList);
        this.mContext = paramActivity;
        initGroup();
        this.aq = new AQuery(this.mContext);
        this.trendingTopicImageHeight = this.mContext.getResources().getDimensionPixelOffset(2131427414);
        this.trendingTopicNoImageHeight = this.mContext.getResources().getDimensionPixelOffset(2131427416);
        this.groupTreeView = paramSectionTitleListView;
        this.feedFragment = paramFeedFragment;
        this.mRemover = new ListItemRemoveAnimatorController(this.groupTreeView, new TrendingTopicDismissCallbacks());
        this.logAction = new TapatalkAjaxLogAction(paramActivity);
        this.forumStatus = new ForumStatus(this.mContext);
    }

    private void checkData() {
        if (this.dataList == null) {
            this.dataList = new ArrayList();
        }
    }

    public void animationDelete(int paramInt1, int paramInt2) {
        this.GroupPosition = paramInt1;
        if (getGroupCount() == 1) {
            paramInt1 = paramInt2 - this.groupTreeView.getFirstVisiblePosition() + getGroupCount();
        }
        for (; ; ) {
            View localView = this.groupTreeView.getChildAt(paramInt1);
            if (this.mRemover == null) {
                this.mRemover = new ListItemRemoveAnimatorController(this.groupTreeView, new TrendingTopicDismissCallbacks());
            }
            if (localView != null) {
                this.mRemover.removeItem(localView, paramInt2);
            }
            return;
            int i = paramInt2 - this.groupTreeView.getFirstVisiblePosition() + getGroupCount();
            paramInt1 = i;
            if (i < 0) {
                paramInt1 = i + ((GroupBean) this.groupList.get(0)).getChildrenList().size();
            }
        }
    }

    public int getChildType(int paramInt1, int paramInt2) {
        if ((this.groupList.size() == 0) || (((GroupBean) this.groupList.get(paramInt1)).getChildrenList().size() == 0)) {
            return 0;
        }
        Object localObject = ((GroupBean) this.groupList.get(paramInt1)).getChildrenList().get(paramInt2);
        if ((localObject instanceof Feed)) {
            return 0;
        }
        localObject = (Topic) localObject;
        if ((SettingsFragment.isEnableTopicImg(this.mContext)) && (((Topic) localObject).getTopicImgUrl() != null) && (!((Topic) localObject).getTopicImgUrl().equals(""))) {
            return 1;
        }
        return 2;
    }

    public int getChildTypeCount() {
        return 3;
    }

    public View getChildView(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup) {
        Object localObject2 = ((GroupBean) this.groupList.get(paramInt1)).getChildrenList().get(paramInt2);
        int i;
        if ((localObject2 instanceof Topic)) {
            i = 0;
            if (i >= this.feedFragment.mAllDatas.size()) {
                localObject1 = (Topic) localObject2;
                localObject2 = new HashMap();
                ((HashMap) localObject2).put("showForumName", Boolean.valueOf(true));
                ((HashMap) localObject2).put("isSubscribedTab", Boolean.valueOf(false));
                if ((!SettingsFragment.isEnableTopicImg(this.mContext)) || (((Topic) localObject1).getTopicImgUrl() == null) || (((Topic) localObject1).getTopicImgUrl().equals(""))) {
                    break label248;
                }
                localObject1 = ((Topic) localObject1).getTrendingTopicView(paramInt2, paramView, paramViewGroup, (ForumActivityStatus) this.mContext, this.aq, this, this.tapatalkForum, this.logAction, this.trendingTopicImageHeight, this.mRemover);
            }
        }
        label248:
        do {
            for (; ; ) {
                ((View) localObject1).setTag(2131231366, Integer.valueOf(paramInt1));
                ((View) localObject1).setTag(2131231367, Integer.valueOf(paramInt2));
                return (View) localObject1;
                if (((TapatalkForum) this.feedFragment.mAllDatas.get(i)).getId().equals(Integer.valueOf(Integer.parseInt(((Topic) localObject2).getTapatalkForumId())))) {
                    this.tapatalkForum = ((TapatalkForum) this.feedFragment.mAllDatas.get(i));
                }
                i += 1;
                break;
                localObject1 = ((Topic) localObject1).getTrendingTopicView(paramInt2, paramView, paramViewGroup, (ForumActivityStatus) this.mContext, this.aq, this, this.tapatalkForum, this.logAction, false, this.trendingTopicNoImageHeight, this.mRemover);
            }
            localObject1 = paramView;
        } while (!(localObject2 instanceof Feed));
        Object localObject1 = (Feed) localObject2;
        if ((paramInt2 == 0) && (((GroupBean) this.groupList.get(paramInt1)).getChildrenList().size() == 1)) {
            i = Feed.ONE_ALERT_ITEM;
        }
        for (; ; ) {
            localObject1 = ((Feed) localObject1).createView(paramInt2, paramView, paramViewGroup, this.mContext, i);
            break;
            if ((paramInt2 == 0) && (((GroupBean) this.groupList.get(paramInt1)).getChildrenList().size() > 1)) {
                i = Feed.TOP_ALERT_ITEM;
            } else if ((paramInt2 == ((GroupBean) this.groupList.get(paramInt1)).getChildrenList().size() - 1) && (((GroupBean) this.groupList.get(paramInt1)).getChildrenList().size() > 1)) {
                i = Feed.BOTTOM_ALERT_ITEM;
            } else {
                i = Feed.MID_ALERT_ITEM;
            }
        }
    }

    public ArrayList<Object> getDataList() {
        return this.dataList;
    }

    public Object getItem(int paramInt1, int paramInt2) {
        try {
            Object localObject = ((GroupBean) this.groupList.get(paramInt1)).getChildrenList().get(paramInt2);
            return localObject;
        } catch (Exception localException) {
        }
        return null;
    }

    public void initGroup() {
        if (this.groupList == null) {
            this.groupList = new ArrayList();
        }
        this.groupList.clear();
        this.notificationGroupBean = new GroupBean(this.mContext.getString(2131100328));
        this.feedGroupBean = new GroupBean(this.mContext.getString(2131100933));
        this.topicGroupBean = new GroupBean(this.mContext.getString(2131100593));
    }

    public void setDataList(ArrayList<Object> paramArrayList) {
        checkData();
        this.dataList = paramArrayList;
    }

    class TrendingTopicDismissCallbacks
            implements ListItemRemoveAnimatorController.DismissCallbacks {
        TrendingTopicDismissCallbacks() {
        }

        public void onDismiss(ListView paramListView, int[] paramArrayOfInt) {
            int j = paramArrayOfInt.length;
            int i = 0;
            for (; ; ) {
                if (i >= j) {
                    FeedListAdapter.this.notifyDataSetChanged();
                    return;
                }
                int k = paramArrayOfInt[i];
                if (FeedListAdapter.this.GroupPosition < FeedListAdapter.this.getGroupCount()) {
                    ((GroupBean) FeedListAdapter.this.groupList.get(FeedListAdapter.this.GroupPosition)).getChildrenList().remove(k);
                }
                i += 1;
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/feed/FeedListAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */