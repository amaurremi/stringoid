package com.quoord.tapatalkpro.adapter.forum;

import android.app.Activity;
import android.app.AlertDialog;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.quoord.tapatalkpro.activity.forum.ForumActivityStatus;
import com.quoord.tapatalkpro.bean.EngineResponse;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.bean.NoTopicView;
import com.quoord.tapatalkpro.bean.Topic;
import com.quoord.tapatalkpro.bean.TopicParser;
import com.quoord.tapatalkpro.ics.BaseListFragment;
import com.quoord.tapatalkpro.ics.slidingMenu.SlidingMenuActivity;
import com.quoord.tapatalkpro.ui.ButtomProgress;
import com.quoord.tapatalkpro.util.TapatalkEngine;

import java.util.ArrayList;
import java.util.HashMap;

public class ModerateTopicAdapter
        extends ForumRootAdapter
        implements AdapterView.OnItemClickListener {
    public static final int postTabId = 1;
    public static final int topicTabId = 0;
    private int countPerPage = 20;
    private int currentSelectPosition = -1;
    LinearLayout footLay;
    private BaseListFragment fragment;
    private boolean isTopic;
    private boolean loadingMore;
    private Activity mContext;
    private ArrayList mDatas = new ArrayList();
    int mStart = 0;
    int mStartPost = 0;
    private ArrayList moderatePostDatas = new ArrayList();
    private ArrayList moderateTopicDatas = new ArrayList();
    private ListView topicList = null;
    private int total_post_num;
    private int total_topic_num;

    public ModerateTopicAdapter(Activity paramActivity, String paramString, ListView paramListView, final boolean paramBoolean, BaseListFragment paramBaseListFragment) {
        super(paramActivity, paramString);
        this.mContext = paramActivity;
        setOpCancel(false);
        this.topicList = paramListView;
        this.isTopic = paramBoolean;
        this.fragment = paramBaseListFragment;
        this.footLay = ButtomProgress.get(this.mContext);
        this.topicList.addFooterView(this.footLay);
        this.topicList.setFooterDividersEnabled(false);
        this.topicList.setAdapter(this);
        this.topicList.setOnItemLongClickListener(new topicListLongClickListener());
        this.topicList.setOnItemClickListener(this);
        this.topicList.setOnScrollListener(new AbsListView.OnScrollListener() {
            public void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {
                if ((paramAnonymousInt1 + paramAnonymousInt2 == paramAnonymousInt3) && (!ModerateTopicAdapter.this.loadingMore) && (ModerateTopicAdapter.this.isFootNeeded())) {
                    if (paramBoolean) {
                        ModerateTopicAdapter.this.getModerateTopic();
                    }
                } else {
                    return;
                }
                ModerateTopicAdapter.this.getModeratePost();
            }

            public void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt) {
            }
        });
        setOpCancel(false);
        if (paramBoolean) {
            getModerateTopic();
            return;
        }
        getModeratePost();
    }

    public int getCount() {
        return this.mDatas.size();
    }

    public Object getItem(int paramInt) {
        return this.mDatas.get(paramInt);
    }

    public long getItemId(int paramInt) {
        return paramInt;
    }

    public int getItemViewType(int paramInt) {
        if ((getItem(paramInt) instanceof Topic)) {
            return 0;
        }
        if (this.isTopic) {
            return 1;
        }
        return 2;
    }

    public void getModeratePost() {
        if (this.topicList.getFooterViewsCount() == 0) {
            this.topicList.addFooterView(this.footLay);
        }
        this.loadingMore = true;
        ArrayList localArrayList = new ArrayList();
        if (this.forumStatus.getApiLevel() >= 4) {
            localArrayList.add(Integer.valueOf(this.mStartPost));
            localArrayList.add(Integer.valueOf(this.mStartPost + this.countPerPage - 1));
        }
        this.engine.call("m_get_moderate_post", localArrayList);
    }

    public void getModerateTopic() {
        if (this.topicList.getFooterViewsCount() == 0) {
            this.topicList.addFooterView(this.footLay);
        }
        this.loadingMore = true;
        ArrayList localArrayList = new ArrayList();
        if (this.forumStatus.getApiLevel() >= 4) {
            localArrayList.add(Integer.valueOf(this.mStart));
            localArrayList.add(Integer.valueOf(this.mStart + this.countPerPage - 1));
        }
        if (this.topicList.getFooterViewsCount() == 0) {
            this.topicList.addFooterView(this.footLay);
        }
        this.engine.call("m_get_moderate_topic", localArrayList);
    }

    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
        if ((getItem(paramInt) instanceof Topic)) {
            paramViewGroup = new HashMap();
            paramViewGroup.put("showForumName", Boolean.valueOf(true));
            paramViewGroup.put("isSubscribedTab", Boolean.valueOf(false));
            if (((this.mContext instanceof SlidingMenuActivity)) && (((SlidingMenuActivity) this.mContext).getShowSlectionStatus())) {
                if (paramInt != this.currentSelectPosition) {
                    break label104;
                }
                paramViewGroup.put("showSelectBg", Boolean.valueOf(true));
            }
            for (; ; ) {
                return ((Topic) getItem(paramInt)).createView(paramViewGroup, paramView, (ForumActivityStatus) this.mContext);
                label104:
                paramViewGroup.put("showSelectBg", Boolean.valueOf(false));
            }
        }
        if ((getItem(paramInt) instanceof NoTopicView)) {
            if (this.isTopic) {
                return ((NoTopicView) getItem(paramInt)).getItemView(this.baseContext);
            }
            return ((NoTopicView) getItem(paramInt)).getItemView(this.baseContext, this.mContext.getString(2131100209));
        }
        return null;
    }

    public int getViewTypeCount() {
        return 3;
    }

    public boolean isEnabled(int paramInt) {
        return (getItem(paramInt) instanceof Topic);
    }

    public boolean isFootNeeded() {
        if (!this.isTopic) {
            if (this.mStartPost >= this.total_post_num) {
            }
        }
        while (this.mStart < this.total_topic_num) {
            return true;
            return false;
        }
        return false;
    }

    public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {
        if (getCount() <= paramInt - this.topicList.getHeaderViewsCount()) {
            return;
        }
        paramAdapterView = (Topic) getItem(paramInt - this.topicList.getHeaderViewsCount());
        if (paramAdapterView.getPostId() != null) {
            paramAdapterView.openThreadByPost(this.mContext, this.forumStatus);
        }
        for (; ; ) {
            this.currentSelectPosition = paramInt;
            notifyDataSetChanged();
            return;
            paramAdapterView.openThread(this.mContext, this.forumStatus);
        }
    }

    public void parseCallBack(EngineResponse paramEngineResponse) {
        this.loadingMore = false;
        Object localObject = paramEngineResponse.getMethod();
        int i;
        if (((String) localObject).equals("m_get_moderate_topic")) {
            this.moderateTopicDatas.clear();
            paramEngineResponse = (HashMap) paramEngineResponse.getResponse();
            localObject = (Object[]) paramEngineResponse.get("topics");
            if (this.topicList.getFooterViewsCount() > 0) {
                this.topicList.removeFooterView(this.footLay);
            }
            this.mStart += this.countPerPage;
            i = 0;
            if (i >= localObject.length) {
                if (this.moderateTopicDatas.size() != 0) {
                    break label185;
                }
                this.moderateTopicDatas.add(new NoTopicView());
                this.total_topic_num = 0;
                label118:
                if ((this.moderateTopicDatas == null) || (this.moderateTopicDatas.size() <= 0)) {
                    break label383;
                }
            }
        }
        label185:
        label369:
        label383:
        for (this.mDatas = this.moderateTopicDatas; ; this.mDatas = this.moderatePostDatas) {
            notifyDataSetChanged();
            return;
            Topic localTopic = TopicParser.createTopicBean((HashMap) localObject[i], null, this.mContext, this.forumStatus);
            this.moderateTopicDatas.add(localTopic);
            i += 1;
            break;
            if (this.forumStatus.getApiLevel() >= 4) {
                this.total_topic_num = ((Integer) paramEngineResponse.get("total_topic_num")).intValue();
                break label118;
            }
            this.total_topic_num = this.moderateTopicDatas.size();
            break label118;
            if (!((String) localObject).equals("m_get_moderate_post")) {
                break label118;
            }
            if (this.topicList.getFooterViewsCount() > 0) {
                this.topicList.removeFooterView(this.footLay);
            }
            this.mStartPost += this.countPerPage;
            paramEngineResponse = (Object[]) ((HashMap) paramEngineResponse.getResponse()).get("posts");
            this.moderatePostDatas.clear();
            i = 0;
            for (; ; ) {
                if (i >= paramEngineResponse.length) {
                    if (this.moderatePostDatas.size() != 0) {
                        break label369;
                    }
                    this.moderatePostDatas.add(new NoTopicView());
                    this.total_post_num = 0;
                    break;
                }
                localObject = Topic.createTopicBean((HashMap) paramEngineResponse[i], this.mContext);
                this.moderatePostDatas.add(localObject);
                i += 1;
            }
            this.total_post_num = this.moderatePostDatas.size();
            break label118;
        }
    }

    public void refresh() {
        setOpCancel(false);
        if (this.isTopic) {
            this.mStart = 0;
            this.moderateTopicDatas.clear();
            getModerateTopic();
            return;
        }
        this.mStartPost = 0;
        this.moderatePostDatas.clear();
        getModeratePost();
    }

    public void removeItem(int paramInt) {
        this.mDatas.remove(paramInt);
    }

    class topicListLongClickListener
            implements AdapterView.OnItemLongClickListener {
        topicListLongClickListener() {
        }

        public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {
            ModerateTopicAdapter.this.mLongclickItemPosition = (paramInt - ModerateTopicAdapter.this.topicList.getHeaderViewsCount());
            if ((ModerateTopicAdapter.this.getItem(ModerateTopicAdapter.this.getmLongclickItemPosition()) instanceof Topic)) {
                ((Topic) ModerateTopicAdapter.this.getItem(ModerateTopicAdapter.this.getmLongclickItemPosition())).getLongClickDialog(ModerateTopicAdapter.this, ModerateTopicAdapter.this.mContext, ModerateTopicAdapter.this.forumStatus).show();
            }
            return true;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/adapter/forum/ModerateTopicAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */