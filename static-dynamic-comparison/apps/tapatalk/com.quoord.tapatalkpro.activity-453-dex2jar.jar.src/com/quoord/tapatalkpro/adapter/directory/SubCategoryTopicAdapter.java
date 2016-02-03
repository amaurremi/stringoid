package com.quoord.tapatalkpro.adapter.directory;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.quoord.tapatalkpro.activity.forum.ForumActivityStatus;
import com.quoord.tapatalkpro.adapter.forum.moderation.SectionTitleListViewAdapter;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.bean.Topic;
import com.quoord.tapatalkpro.ui.GroupBean;
import com.quoord.tapatalkpro.view.SectionTitleListView;

import java.util.ArrayList;
import java.util.HashMap;

public class SubCategoryTopicAdapter
        extends SectionTitleListViewAdapter {
    public ForumStatus forumStatus;
    public GroupBean topicGroupBean;

    public SubCategoryTopicAdapter(Activity paramActivity, SectionTitleListView paramSectionTitleListView) {
        this.mContext = paramActivity;
        initGroup();
        this.groupTreeView = paramSectionTitleListView;
        this.forumStatus = new ForumStatus(this.mContext);
    }

    public View getChildView(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup) {
        Object localObject = ((GroupBean) this.groupList.get(paramInt1)).getChildrenList().get(paramInt2);
        paramViewGroup = paramView;
        if ((localObject instanceof Topic)) {
            paramViewGroup = (Topic) localObject;
            localObject = new HashMap();
            ((HashMap) localObject).put("showForumName", Boolean.valueOf(true));
            ((HashMap) localObject).put("isSubscribedTab", Boolean.valueOf(false));
            paramViewGroup = paramViewGroup.createView((HashMap) localObject, paramView, (ForumActivityStatus) this.mContext, true, paramInt2);
        }
        paramViewGroup.setTag(2131231366, Integer.valueOf(paramInt1));
        paramViewGroup.setTag(2131231367, Integer.valueOf(paramInt2));
        return paramViewGroup;
    }

    public void initGroup() {
        if (this.groupList == null) {
            this.groupList = new ArrayList();
        }
        this.groupList.clear();
        this.topicGroupBean = new GroupBean(this.mContext.getString(2131100593));
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/adapter/directory/SubCategoryTopicAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */