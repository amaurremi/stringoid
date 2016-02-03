package com.quoord.tapatalkpro.adapter.forum.moderation;

import android.app.Activity;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;
import com.quoord.tapatalkpro.activity.forum.moderation.ModerateActivity;
import com.quoord.tapatalkpro.ui.GroupBean;
import com.quoord.tapatalkpro.util.ThemeUtil;
import com.quoord.tapatalkpro.util.Util;
import com.quoord.tapatalkpro.view.SectionTitleListView;
import com.quoord.tapatalkpro.view.SectionTitleListView.IphoneTreeHeaderAdapter;

import java.util.ArrayList;

public class SectionTitleListViewAdapter
        extends BaseExpandableListAdapter
        implements SectionTitleListView.IphoneTreeHeaderAdapter {
    public ArrayList<GroupBean> groupList;
    public SparseIntArray groupStatusMap;
    public SectionTitleListView groupTreeView;
    public Activity mContext;

    public void configureTreeHeader(View paramView, int paramInt1, int paramInt2, int paramInt3) {
        paramInt2 = paramInt1;
        if (paramInt1 < 0) {
            paramInt2 = 0;
        }
        ((TextView) paramView.findViewById(2131231075)).setText(((GroupBean) this.groupList.get(paramInt2)).getTitle());
        Util.setBg(paramView, ThemeUtil.getDrawableByPicName("ob_section_title", this.mContext));
    }

    public Object getChild(int paramInt1, int paramInt2) {
        int i = paramInt2;
        if (paramInt2 < 0) {
            i = 0;
        }
        return ((GroupBean) this.groupList.get(paramInt1)).getChildrenList().get(i);
    }

    public long getChildId(int paramInt1, int paramInt2) {
        return paramInt1 * 100 + paramInt2;
    }

    public View getChildView(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup) {
        return paramView;
    }

    public int getChildrenCount(int paramInt) {
        if (paramInt < 0) {
            return 0;
        }
        return ((GroupBean) this.groupList.get(paramInt)).getChildrenList().size();
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
            paramViewGroup = LayoutInflater.from(this.mContext).inflate(2130903356, null);
        }
        ((TextView) paramViewGroup.findViewById(2131231075)).setText(((GroupBean) this.groupList.get(paramInt)).getTitle());
        if (((this.mContext instanceof ModerateActivity)) && (((ModerateActivity) this.mContext).select_forum_action == 4)) {
            paramViewGroup.setVisibility(8);
        }
        Util.setBg(paramViewGroup, ThemeUtil.getDrawableByPicName("ob_section_title", this.mContext));
        paramViewGroup.setClickable(false);
        return paramViewGroup;
    }

    public int getHeadViewClickStatus(int paramInt) {
        if (this.groupStatusMap.get(paramInt) != 0) {
            return this.groupStatusMap.get(paramInt);
        }
        return 0;
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
        return false;
    }

    public boolean isChildSelectable(int paramInt1, int paramInt2) {
        return true;
    }

    public void onHeadViewClick(int paramInt1, int paramInt2) {
        this.groupStatusMap.put(paramInt1, paramInt2);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/adapter/forum/moderation/SectionTitleListViewAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */