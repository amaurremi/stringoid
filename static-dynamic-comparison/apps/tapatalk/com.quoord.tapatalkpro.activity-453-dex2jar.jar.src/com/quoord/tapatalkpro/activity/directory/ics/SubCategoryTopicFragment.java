package com.quoord.tapatalkpro.activity.directory.ics;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.LinearLayout;
import com.quoord.tapatalkpro.action.FeedAction;
import com.quoord.tapatalkpro.action.FeedAction.FeedActionCallBack;
import com.quoord.tapatalkpro.action.OpenThreadAction;
import com.quoord.tapatalkpro.adapter.directory.SubCategoryTopicAdapter;
import com.quoord.tapatalkpro.bean.Topic;
import com.quoord.tapatalkpro.ui.ButtomProgress;
import com.quoord.tapatalkpro.ui.GroupBean;
import com.quoord.tapatalkpro.ui.ics.QuoordFragment;
import com.quoord.tapatalkpro.view.SectionTitleListView;
import com.quoord.tools.directoryurl.DirectoryUrlUtil;

import java.util.ArrayList;

public class SubCategoryTopicFragment
        extends QuoordFragment
        implements ExpandableListView.OnChildClickListener {
    private SubCategoryTopicAdapter adapter;
    public LinearLayout footLay;
    private SectionTitleListView groupTreeView;
    public boolean isCalling = false;
    public Activity mActivity;
    private LinearLayout noDataText;
    private int page = 1;
    private String tapatalkCategoryId;
    private ArrayList<Object> topicList = new ArrayList();

    public static SubCategoryTopicFragment newInstance(String paramString) {
        SubCategoryTopicFragment localSubCategoryTopicFragment = new SubCategoryTopicFragment();
        localSubCategoryTopicFragment.tapatalkCategoryId = paramString;
        return localSubCategoryTopicFragment;
    }

    public void getFeedByCategoryId(FeedAction paramFeedAction) {
        if (paramFeedAction == null) {
            return;
        }
        paramFeedAction.getFeeds(DirectoryUrlUtil.createSubCategoryFeed(this.mActivity, this.tapatalkCategoryId), this.page, new FeedAction.FeedActionCallBack() {
            public void actionCallBack(ArrayList<Object> paramAnonymousArrayList, boolean paramAnonymousBoolean) {
                SubCategoryTopicFragment.this.isCalling = false;
                if ((SubCategoryTopicFragment.this.adapter != null) && (paramAnonymousArrayList != null) && (paramAnonymousArrayList.size() > 0)) {
                    SubCategoryTopicFragment.this.topicList.addAll(paramAnonymousArrayList);
                    SubCategoryTopicFragment.this.adapter.topicGroupBean.setChildrenList(SubCategoryTopicFragment.this.topicList);
                }
                SubCategoryTopicFragment.this.adapter.notifyDataSetChanged();
                paramAnonymousArrayList = SubCategoryTopicFragment.this;
                paramAnonymousArrayList.page += 1;
            }
        });
    }

    public void onActivityCreated(Bundle paramBundle) {
        super.onActivityCreated(paramBundle);
        this.mActivity = getActivity();
        this.footLay = ButtomProgress.get(this.mActivity);
        this.groupTreeView.setGroupIndicator(null);
        this.groupTreeView.setSelector(2131165212);
        this.groupTreeView.addFooterView(this.footLay);
        this.adapter = new SubCategoryTopicAdapter(this.mActivity, this.groupTreeView);
        this.groupTreeView.setAdapter(this.adapter);
        this.groupTreeView.setOnChildClickListener(this);
        int i = 0;
        for (; ; ) {
            if (i >= this.adapter.getGroupCount()) {
                return;
            }
            this.groupTreeView.expandGroup(i);
            i += 1;
        }
    }

    public boolean onChildClick(ExpandableListView paramExpandableListView, View paramView, int paramInt1, int paramInt2, long paramLong) {
        if ((paramInt1 == 3) && (paramInt2 >= this.adapter.topicGroupBean.getChildrenList().size())) {
        }
        while (!(this.adapter.getChild(paramInt1, paramInt2) instanceof Topic)) {
            return true;
        }
        paramExpandableListView = (Topic) this.adapter.getChild(paramInt1, paramInt2);
        OpenThreadAction.openThread(this.mActivity, paramExpandableListView, "explore");
        return true;
    }

    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        paramLayoutInflater = paramLayoutInflater.inflate(2130903210, null);
        this.groupTreeView = ((SectionTitleListView) paramLayoutInflater.findViewById(2131231174));
        this.noDataText = ((LinearLayout) paramLayoutInflater.findViewById(2131231010));
        return paramLayoutInflater;
    }

    public void setActivity(Activity paramActivity) {
        this.mActivity = paramActivity;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/activity/directory/ics/SubCategoryTopicFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */