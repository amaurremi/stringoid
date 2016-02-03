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
import com.quoord.tapatalkpro.ics.slidingMenu.ReportTopicFragment;
import com.quoord.tapatalkpro.ui.ButtomProgress;
import com.quoord.tapatalkpro.util.TapatalkEngine;

import java.util.ArrayList;
import java.util.HashMap;

public class ReportedTopicAdapter
        extends ForumRootAdapter
        implements AdapterView.OnItemClickListener {
    LinearLayout container;
    LinearLayout footLay;
    private ReportTopicFragment fragment;
    private Activity mContext;
    private ArrayList mDatas = new ArrayList();
    private ListView postList = null;

    public ReportedTopicAdapter(Activity paramActivity, String paramString, ListView paramListView, ReportTopicFragment paramReportTopicFragment) {
        super(paramActivity, paramString);
        this.mContext = paramActivity;
        setOpCancel(false);
        this.footLay = ButtomProgress.get(this.mContext);
        this.postList = paramListView;
        this.fragment = paramReportTopicFragment;
        this.postList.addFooterView(this.footLay);
        this.postList.setAdapter(this);
        this.postList.setOnItemLongClickListener(new topicListLongClickListener());
        this.postList.setFooterDividersEnabled(false);
        this.postList.setOnItemClickListener(this);
        getReportedPost();
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

    public void getReportedPost() {
        if (this.postList.getFooterViewsCount() == 0) {
            this.postList.addFooterView(this.footLay);
        }
        ArrayList localArrayList = new ArrayList();
        this.engine.call("m_get_report_post", localArrayList);
    }

    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
        if ((getItem(paramInt) instanceof NoTopicView)) {
            return ((NoTopicView) getItem(paramInt)).getItemView(this.baseContext, this.mContext.getString(2131100209));
        }
        paramViewGroup = new HashMap();
        paramViewGroup.put("showForumName", Boolean.valueOf(true));
        paramViewGroup.put("isSubscribedTab", Boolean.valueOf(false));
        return ((Topic) getItem(paramInt)).createView(paramViewGroup, paramView, (ForumActivityStatus) this.mContext);
    }

    public boolean isEnabled(int paramInt) {
        return true;
    }

    public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {
        paramAdapterView = (Topic) getItem(paramInt);
        if (paramAdapterView.getPostId() != null) {
            paramAdapterView.openThreadByPost(this.mContext, this.forumStatus);
            return;
        }
        paramAdapterView.openThread(this.mContext, this.forumStatus);
    }

    public void parseCallBack(EngineResponse paramEngineResponse) {
        int i;
        if (paramEngineResponse.getMethod().equals("m_get_report_post")) {
            paramEngineResponse = (Object[]) ((HashMap) paramEngineResponse.getResponse()).get("reports");
            this.mDatas.clear();
            if (this.postList.getFooterViewsCount() > 0) {
                this.postList.removeFooterView(this.footLay);
            }
            i = 0;
        }
        for (; ; ) {
            if (i >= paramEngineResponse.length) {
                if (this.mDatas.size() == 0) {
                    this.mDatas.add(new NoTopicView());
                }
                notifyDataSetChanged();
                return;
            }
            HashMap localHashMap = (HashMap) paramEngineResponse[i];
            this.mDatas.add(Topic.createTopicBean(localHashMap, this.mContext));
            i += 1;
        }
    }

    public void refresh() {
        setOpCancel(false);
        this.mDatas.clear();
        getReportedPost();
    }

    public void removeItem(int paramInt) {
        this.mDatas.remove(paramInt);
    }

    class topicListLongClickListener
            implements AdapterView.OnItemLongClickListener {
        topicListLongClickListener() {
        }

        public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {
            ReportedTopicAdapter.this.mLongclickItemPosition = paramInt;
            ((Topic) ReportedTopicAdapter.this.getItem(ReportedTopicAdapter.this.getmLongclickItemPosition())).getLongClickDialog(ReportedTopicAdapter.this, ReportedTopicAdapter.this.mContext, ReportedTopicAdapter.this.forumStatus).show();
            return true;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/adapter/forum/ReportedTopicAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */