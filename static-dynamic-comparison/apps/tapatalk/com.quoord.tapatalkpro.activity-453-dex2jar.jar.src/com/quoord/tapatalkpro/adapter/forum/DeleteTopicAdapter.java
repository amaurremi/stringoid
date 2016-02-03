package com.quoord.tapatalkpro.adapter.forum;

import android.app.Activity;
import android.app.AlertDialog;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.quoord.tapatalkpro.activity.forum.ForumActivityStatus;
import com.quoord.tapatalkpro.bean.EngineResponse;
import com.quoord.tapatalkpro.bean.NoTopicView;
import com.quoord.tapatalkpro.bean.Topic;
import com.quoord.tapatalkpro.bean.TopicParser;
import com.quoord.tapatalkpro.ics.BaseListFragment;
import com.quoord.tapatalkpro.ics.slidingMenu.SlidingMenuActivity;
import com.quoord.tapatalkpro.ui.ButtomProgress;
import com.quoord.tapatalkpro.util.TapatalkEngine;

import java.util.ArrayList;
import java.util.HashMap;

public class DeleteTopicAdapter
        extends ForumRootAdapter
        implements AdapterView.OnItemClickListener {
    public static final int postTabId = 1;
    public static final int topicTabId = 0;
    private int currentSelectPosition = -1;
    LinearLayout footLay;
    private BaseListFragment fragment;
    private boolean isTopic;
    private Activity mContext;
    private ArrayList mDatas = new ArrayList();
    public ArrayList postDatas = new ArrayList();
    private ArrayList topicDatas = new ArrayList();
    private ListView topicList = null;
    private int total_post_num;
    private int total_topic_num;

    public DeleteTopicAdapter(Activity paramActivity, String paramString, ListView paramListView, boolean paramBoolean, BaseListFragment paramBaseListFragment) {
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
        if (paramBoolean) {
            getDeleteTopic();
            return;
        }
        getDeletePost();
    }

    public int getCount() {
        return this.mDatas.size();
    }

    public void getDeletePost() {
        if (this.topicList.getFooterViewsCount() == 0) {
            this.topicList.addFooterView(this.footLay);
        }
        ArrayList localArrayList = new ArrayList();
        this.engine.call("m_get_delete_post", localArrayList);
    }

    public void getDeleteTopic() {
        if (this.topicList.getFooterViewsCount() == 0) {
            this.topicList.addFooterView(this.footLay);
        }
        ArrayList localArrayList = new ArrayList();
        this.engine.call("m_get_delete_topic", localArrayList);
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

    public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {
        if (getCount() < paramInt) {
            return;
        }
        ((Topic) getItem(paramInt - this.topicList.getHeaderViewsCount())).openThread(this.mContext, this.forumStatus);
        this.currentSelectPosition = paramInt;
        notifyDataSetChanged();
    }

    public void parseCallBack(EngineResponse paramEngineResponse) {
        Object localObject = paramEngineResponse.getMethod();
        int i;
        if (((String) localObject).equals("m_get_delete_topic")) {
            paramEngineResponse = (Object[]) ((HashMap) paramEngineResponse.getResponse()).get("topics");
            this.topicDatas.clear();
            if (this.topicList.getFooterViewsCount() > 0) {
                this.topicList.removeFooterView(this.footLay);
            }
            i = 0;
            if (i >= paramEngineResponse.length) {
                if (this.topicDatas.size() != 0) {
                    break label167;
                }
                this.topicDatas.add(new NoTopicView());
                this.total_topic_num = 0;
                label97:
                if ((this.topicDatas == null) || (this.topicDatas.size() <= 0)) {
                    break label326;
                }
            }
        }
        label167:
        label312:
        label326:
        for (this.mDatas = this.topicDatas; ; this.mDatas = this.postDatas) {
            notifyDataSetChanged();
            return;
            localObject = TopicParser.createTopicBean((HashMap) paramEngineResponse[i], null, this.mContext, this.forumStatus);
            ((Topic) localObject).setDeleted(true);
            this.topicDatas.add(localObject);
            i += 1;
            break;
            this.total_topic_num = this.topicDatas.size();
            break label97;
            if (!((String) localObject).equals("m_get_delete_post")) {
                break label97;
            }
            paramEngineResponse = (Object[]) ((HashMap) paramEngineResponse.getResponse()).get("posts");
            this.postDatas.clear();
            if (this.topicList.getFooterViewsCount() > 0) {
                this.topicList.removeFooterView(this.footLay);
            }
            i = 0;
            for (; ; ) {
                if (i >= paramEngineResponse.length) {
                    if (this.postDatas.size() != 0) {
                        break label312;
                    }
                    this.postDatas.add(new NoTopicView());
                    this.total_post_num = 0;
                    break;
                }
                localObject = Topic.createTopicBean((HashMap) paramEngineResponse[i], this.mContext);
                ((Topic) localObject).setDeleted(true);
                this.postDatas.add(localObject);
                i += 1;
            }
            this.total_post_num = this.postDatas.size();
            break label97;
        }
    }

    public void refresh() {
        setOpCancel(false);
        if (this.isTopic) {
            this.topicDatas.clear();
            getDeleteTopic();
            return;
        }
        this.postDatas.clear();
        getDeletePost();
    }

    public void removeItem(int paramInt) {
        this.mDatas.remove(paramInt);
    }

    class topicListLongClickListener
            implements AdapterView.OnItemLongClickListener {
        topicListLongClickListener() {
        }

        public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {
            DeleteTopicAdapter.this.mLongclickItemPosition = (paramInt - DeleteTopicAdapter.this.topicList.getHeaderViewsCount());
            DeleteTopicAdapter.this.setmLongclickItemPosition(DeleteTopicAdapter.this.mLongclickItemPosition);
            if ((DeleteTopicAdapter.this.getItem(DeleteTopicAdapter.this.getmLongclickItemPosition()) instanceof Topic)) {
                ((Topic) DeleteTopicAdapter.this.getItem(DeleteTopicAdapter.this.getmLongclickItemPosition())).getLongClickDialog(DeleteTopicAdapter.this, DeleteTopicAdapter.this.mContext, DeleteTopicAdapter.this.forumStatus).show();
            }
            return true;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/adapter/forum/DeleteTopicAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */