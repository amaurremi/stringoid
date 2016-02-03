package com.quoord.tapatalkpro.activity.forum.home;

import android.app.Activity;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.quoord.tapatalkpro.activity.forum.ForumActivityStatus;
import com.quoord.tapatalkpro.bean.RecommondPerson;
import com.quoord.tapatalkpro.bean.Topic;
import com.quoord.tapatalkpro.ics.slidingMenu.SettingsFragment;
import com.quoord.tapatalkpro.ui.GroupBean;
import com.quoord.tapatalkpro.util.ThemeUtil;
import com.quoord.tapatalkpro.util.Util;
import com.quoord.tapatalkpro.view.SectionTitleListView;
import com.quoord.tapatalkpro.view.SectionTitleListView.IphoneTreeHeaderAdapter;
import com.quoord.tools.ImageTools;

import java.util.ArrayList;
import java.util.HashMap;

public class NewForumFeedAdapter
        extends BaseExpandableListAdapter
        implements SectionTitleListView.IphoneTreeHeaderAdapter {
    private Activity context;
    public GroupBean forumGoupBean;
    private RelativeLayout forumHorizonView;
    public ArrayList<GroupBean> groupList = new ArrayList();
    private SparseIntArray groupStatusMap;
    private SectionTitleListView groupTreeView;
    public GroupBean imageGoupBean;
    private RelativeLayout imagesHorizonView;
    public GroupBean topicGoupBean;
    public GroupBean userGoupBean;

    public NewForumFeedAdapter(Activity paramActivity, SectionTitleListView paramSectionTitleListView) {
        this.context = paramActivity;
        this.groupTreeView = paramSectionTitleListView;
        this.groupStatusMap = new SparseIntArray();
        initGroup();
    }

    public void configureTreeHeader(View paramView, int paramInt1, int paramInt2, int paramInt3) {
        ((TextView) paramView.findViewById(2131231075)).setText(((GroupBean) this.groupList.get(paramInt1)).getTitle());
        Util.setBg(paramView, ThemeUtil.getDrawableByPicName("ob_section_title", this.context));
    }

    public Object getChild(int paramInt1, int paramInt2) {
        GroupBean localGroupBean = (GroupBean) this.groupList.get(paramInt1);
        if (!localGroupBean.isSigleView) {
            return localGroupBean.getChildrenList().get(paramInt2);
        }
        return localGroupBean.getObj();
    }

    public long getChildId(int paramInt1, int paramInt2) {
        return paramInt1 * 100 + paramInt2;
    }

    public View getChildView(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup) {
        Object localObject = (GroupBean) this.groupList.get(paramInt1);
        paramViewGroup = LayoutInflater.from(this.context);
        if (((GroupBean) localObject).isSigleView) {
            if (((GroupBean) localObject).viewType.equals("forums")) {
                paramView = getRecommondForumHListView(paramViewGroup);
            }
        }
        for (; ; ) {
            paramView.setTag(2131231366, Integer.valueOf(paramInt1));
            paramView.setTag(2131231367, Integer.valueOf(paramInt2));
            return paramView;
            paramView = getHotImagesHListView(paramViewGroup);
            continue;
            localObject = ((GroupBean) localObject).getChildrenList().get(paramInt2);
            if ((localObject instanceof RecommondPerson)) {
                paramBoolean = false;
                if (this.userGoupBean.getChildrenList().get(this.userGoupBean.getChildrenList().size() - 1) == localObject) {
                    paramBoolean = true;
                }
                paramView = getHotUserView(paramViewGroup, (RecommondPerson) localObject, paramBoolean);
            } else {
                paramViewGroup = (Topic) localObject;
                localObject = new HashMap();
                ((HashMap) localObject).put("showForumName", Boolean.valueOf(false));
                ((HashMap) localObject).put("isSubscribedTab", Boolean.valueOf(false));
                paramView = paramViewGroup.createView((HashMap) localObject, paramView, (ForumActivityStatus) this.context);
            }
        }
    }

    public int getChildrenCount(int paramInt) {
        if (paramInt < 0) {
            return 0;
        }
        GroupBean localGroupBean = (GroupBean) this.groupList.get(paramInt);
        if (localGroupBean.isSigleView) {
            return 1;
        }
        return localGroupBean.getSize();
    }

    public Object getGroup(int paramInt) {
        return ((GroupBean) this.groupList.get(paramInt)).getTitle();
    }

    public int getGroupCount() {
        return this.groupList.size();
    }

    public long getGroupId(int paramInt) {
        return paramInt * 100;
    }

    public View getGroupView(int paramInt, boolean paramBoolean, View paramView, ViewGroup paramViewGroup) {
        paramViewGroup = paramView;
        if (paramView == null) {
            paramViewGroup = LayoutInflater.from(this.context).inflate(2130903356, null);
        }
        paramView = (TextView) paramViewGroup.findViewById(2131231075);
        Util.setBg(paramViewGroup, ThemeUtil.getDrawableByPicName("ob_section_title", this.context));
        paramView.setText(((GroupBean) this.groupList.get(paramInt)).getTitle());
        return paramViewGroup;
    }

    public int getHeadViewClickStatus(int paramInt) {
        if (this.groupStatusMap.get(paramInt) != 0) {
            return this.groupStatusMap.get(paramInt);
        }
        return 0;
    }

    public View getHotImagesHListView(LayoutInflater paramLayoutInflater) {
        int i;
        GridView localGridView;
        Object localObject;
        if (this.imagesHorizonView == null) {
            this.imagesHorizonView = ((RelativeLayout) paramLayoutInflater.inflate(2130903158, null));
            paramLayoutInflater = (ArrayList) this.imageGoupBean.getObj();
            i = (int) this.context.getResources().getDimension(2131427410);
            localGridView = (GridView) this.imagesHorizonView.findViewById(2131231066);
            localObject = (TextView) this.imagesHorizonView.findViewById(2131231026);
            if (!SettingsFragment.isLightTheme(this.context)) {
                break label170;
            }
            ((TextView) localObject).setBackgroundColor(this.context.getResources().getColor(2131165565));
        }
        for (; ; ) {
            localObject = new FeedImageAdapter(this.context, paramLayoutInflater);
            int j = paramLayoutInflater.size();
            localGridView.setLayoutParams(new LinearLayout.LayoutParams((i + 35) * j, -2));
            localGridView.setColumnWidth(i);
            localGridView.setStretchMode(0);
            localGridView.setNumColumns(j);
            localGridView.setAdapter((ListAdapter) localObject);
            return this.imagesHorizonView;
            label170:
            ((TextView) localObject).setBackgroundColor(this.context.getResources().getColor(2131165578));
        }
    }

    public View getHotUserView(LayoutInflater paramLayoutInflater, RecommondPerson paramRecommondPerson, boolean paramBoolean) {
        paramLayoutInflater = paramLayoutInflater.inflate(2130903148, null);
        ImageView localImageView = (ImageView) paramLayoutInflater.findViewById(2131231022);
        TextView localTextView1 = (TextView) paramLayoutInflater.findViewById(2131231023);
        TextView localTextView2 = (TextView) paramLayoutInflater.findViewById(2131231024);
        TextView localTextView3 = (TextView) paramLayoutInflater.findViewById(2131231025);
        TextView localTextView4 = (TextView) paramLayoutInflater.findViewById(2131231026);
        if (paramBoolean) {
            localTextView4.setVisibility(0);
        }
        if ((paramRecommondPerson.imageUrl != null) && (!paramRecommondPerson.imageUrl.equals(""))) {
            ImageTools.glideLoad(paramRecommondPerson.imageUrl, localImageView);
            if (!SettingsFragment.isLightTheme(this.context)) {
                break label215;
            }
            localTextView4.setBackgroundColor(this.context.getResources().getColor(2131165565));
        }
        for (; ; ) {
            if (!SettingsFragment.isLightTheme(this.context)) {
                localTextView3.setTextColor(this.context.getResources().getColor(2131165213));
            }
            localTextView2.setText(paramRecommondPerson.username);
            localTextView3.setText(paramRecommondPerson.description);
            return paramLayoutInflater;
            localImageView.setVisibility(8);
            localTextView1.setVisibility(0);
            localTextView1.setText(paramRecommondPerson.username.substring(0, 1).toUpperCase());
            break;
            label215:
            localTextView4.setBackgroundColor(this.context.getResources().getColor(2131165578));
        }
    }

    public View getRecommondForumHListView(LayoutInflater paramLayoutInflater) {
        int i;
        GridView localGridView;
        Object localObject;
        if (this.forumHorizonView == null) {
            this.forumHorizonView = ((RelativeLayout) paramLayoutInflater.inflate(2130903158, null));
            paramLayoutInflater = (ArrayList) this.forumGoupBean.getObj();
            i = (int) this.context.getResources().getDimension(2131427409);
            localGridView = (GridView) this.forumHorizonView.findViewById(2131231066);
            localObject = (TextView) this.forumHorizonView.findViewById(2131231026);
            if (!SettingsFragment.isLightTheme(this.context)) {
                break label171;
            }
            ((TextView) localObject).setBackgroundColor(this.context.getResources().getColor(2131165565));
        }
        for (; ; ) {
            localObject = new FeedCategoryAdapter(this.context, paramLayoutInflater);
            int j = paramLayoutInflater.size();
            localGridView.setLayoutParams(new LinearLayout.LayoutParams((i + 30) * j, -2));
            localGridView.setColumnWidth(i);
            localGridView.setStretchMode(0);
            localGridView.setNumColumns(j);
            localGridView.setAdapter((ListAdapter) localObject);
            return this.forumHorizonView;
            label171:
            ((TextView) localObject).setBackgroundColor(this.context.getResources().getColor(2131165578));
        }
    }

    public int getTreeHeaderState(int paramInt1, int paramInt2) {
        if (paramInt2 == getChildrenCount(paramInt1) - 1) {
            return 2;
        }
        if ((paramInt2 == -1) && (!this.groupTreeView.isGroupExpanded(paramInt1))) {
            return 0;
        }
        return 1;
    }

    public boolean hasStableIds() {
        return true;
    }

    public void initGroup() {
        if (this.groupList == null) {
            this.groupList = new ArrayList();
        }
        this.groupList.clear();
        this.forumGoupBean = new GroupBean(this.context.getString(2131100712));
        this.imageGoupBean = new GroupBean(this.context.getString(2131100713));
        this.userGoupBean = new GroupBean(this.context.getString(2131100714));
        this.topicGoupBean = new GroupBean(this.context.getString(2131100715));
    }

    public boolean isChildSelectable(int paramInt1, int paramInt2) {
        return true;
    }

    public void onHeadViewClick(int paramInt1, int paramInt2) {
        this.groupStatusMap.put(paramInt1, paramInt2);
    }

    public void unregisterDataSetObserver(DataSetObserver paramDataSetObserver) {
        if (paramDataSetObserver != null) {
            super.unregisterDataSetObserver(paramDataSetObserver);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/activity/forum/home/NewForumFeedAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */