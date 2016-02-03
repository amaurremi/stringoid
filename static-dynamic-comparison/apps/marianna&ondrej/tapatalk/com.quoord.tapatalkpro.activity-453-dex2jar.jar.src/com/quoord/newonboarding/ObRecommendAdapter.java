package com.quoord.newonboarding;

import android.app.Activity;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.quoord.tapatalkpro.adapter.directory.view.IcsSearchForumView;
import com.quoord.tapatalkpro.adapter.directory.view.IcsSearchForumView.SearchForumTag;
import com.quoord.tapatalkpro.bean.TapatalkForumForSearch;
import com.quoord.tapatalkpro.ui.GroupBean;
import com.quoord.tapatalkpro.util.Util;
import com.quoord.tapatalkpro.view.SectionTitleListView;
import com.quoord.tapatalkpro.view.SectionTitleListView.IphoneTreeHeaderAdapter;

import java.util.ArrayList;

public class ObRecommendAdapter
        extends BaseExpandableListAdapter
        implements SectionTitleListView.IphoneTreeHeaderAdapter {
    private ArrayList<TapatalkForumForSearch> forumsList = new ArrayList();
    public ArrayList<GroupBean> groupList;
    private SparseIntArray groupStatusMap;
    private SectionTitleListView groupTreeView;
    private Activity mContext;

    public ObRecommendAdapter(Activity paramActivity, SectionTitleListView paramSectionTitleListView) {
        this.mContext = paramActivity;
        this.groupTreeView = paramSectionTitleListView;
        initGroup();
        this.groupStatusMap = new SparseIntArray();
    }

    public void changeSelected() {
        if ((this.mContext instanceof ObRecommendListActivity)) {
            if (this.forumsList.size() > 0) {
                ((ObRecommendListActivity) this.mContext).done.setBackgroundResource(2130839159);
            }
        } else {
            return;
        }
        ((ObRecommendListActivity) this.mContext).done.setBackgroundResource(2130839160);
    }

    public void configureTreeHeader(View paramView, int paramInt1, int paramInt2, int paramInt3) {
        paramInt2 = paramInt1;
        if (paramInt1 < 0) {
            paramInt2 = 0;
        }
        ((TextView) paramView.findViewById(2131231075)).setText(((GroupBean) this.groupList.get(paramInt2)).getTitle());
    }

    public Object getChild(int paramInt1, int paramInt2) {
        return ((GroupBean) this.groupList.get(paramInt1)).getChildrenList().get(paramInt2);
    }

    public long getChildId(int paramInt1, int paramInt2) {
        return paramInt1 * 100 + paramInt2;
    }

    public View getChildView(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup) {
        return getTapatalkForumView(paramInt1, paramInt2, paramView, (TapatalkForumForSearch) ((GroupBean) this.groupList.get(paramInt1)).getChildrenList().get(paramInt2));
    }

    public int getChildrenCount(int paramInt) {
        if (paramInt < 0) {
            return 0;
        }
        return ((GroupBean) this.groupList.get(paramInt)).getChildrenList().size();
    }

    public ArrayList<TapatalkForumForSearch> getForumsList() {
        return this.forumsList;
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
            if (!Util.isHDDevice(this.mContext)) {
                break label68;
            }
        }
        label68:
        for (paramViewGroup = LayoutInflater.from(this.mContext).inflate(2130903308, null); ; paramViewGroup = LayoutInflater.from(this.mContext).inflate(2130903307, null)) {
            ((TextView) paramViewGroup.findViewById(2131231075)).setText(((GroupBean) this.groupList.get(paramInt)).getTitle());
            paramViewGroup.setClickable(false);
            return paramViewGroup;
        }
    }

    public int getHeadViewClickStatus(int paramInt) {
        if (this.groupStatusMap.get(paramInt) != 0) {
            return this.groupStatusMap.get(paramInt);
        }
        return 0;
    }

    public Object getItem(int paramInt1, int paramInt2) {
        try {
            Object localObject = ((GroupBean) this.groupList.get(paramInt1)).getChildrenList().get(paramInt2);
            return localObject;
        } catch (Exception localException) {
        }
        return null;
    }

    public View getTapatalkForumView(final int paramInt1, final int paramInt2, View paramView, final TapatalkForumForSearch paramTapatalkForumForSearch) {
        paramTapatalkForumForSearch = new IcsSearchForumView(this.mContext, "", false);
        TapatalkForumForSearch localTapatalkForumForSearch = (TapatalkForumForSearch) getChild(paramInt1, paramInt2);
        if (paramInt1 == 0) {
            paramView = paramTapatalkForumForSearch.getSearchForumView(localTapatalkForumForSearch, IcsSearchForumView.SearchForumTag.ADD_BTN_DONT_SHOW, 0, paramView, null, true);
        }
        for (; ; ) {
            paramTapatalkForumForSearch.setOnAddListener(new View.OnClickListener() {
                public void onClick(View paramAnonymousView) {
                    if (!paramTapatalkForumForSearch.isAdded()) {
                        paramTapatalkForumForSearch.getAddImg().setImageResource(2130837513);
                        paramTapatalkForumForSearch.setAdded(true);
                        if (!ObRecommendAdapter.this.forumsList.contains(ObRecommendAdapter.this.getItem(paramInt1, paramInt2))) {
                            ObRecommendAdapter.this.forumsList.add((TapatalkForumForSearch) ObRecommendAdapter.this.getItem(paramInt1, paramInt2));
                        }
                    }
                    do {
                        return;
                        paramTapatalkForumForSearch.getAddImg().setImageResource(2130837512);
                        paramTapatalkForumForSearch.setAdded(false);
                    }
                    while (!ObRecommendAdapter.this.forumsList.contains(ObRecommendAdapter.this.getItem(paramInt1, paramInt2)));
                    ObRecommendAdapter.this.forumsList.remove(ObRecommendAdapter.this.getItem(paramInt1, paramInt2));
                }
            });
            return paramView;
            if (this.forumsList.contains(localTapatalkForumForSearch)) {
                paramTapatalkForumForSearch.setAdded(true);
                paramView = paramTapatalkForumForSearch.getSearchForumView(localTapatalkForumForSearch, IcsSearchForumView.SearchForumTag.ADD_BTN_SHOW_CHECK, 0, paramView, null, true);
            } else {
                paramView = paramTapatalkForumForSearch.getSearchForumView(localTapatalkForumForSearch, IcsSearchForumView.SearchForumTag.ADD_BTN_SHOW_ADD, 0, paramView, null, true);
            }
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
    }

    public boolean isChildSelectable(int paramInt1, int paramInt2) {
        return false;
    }

    public void onHeadViewClick(int paramInt1, int paramInt2) {
        this.groupStatusMap.put(paramInt1, paramInt2);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/newonboarding/ObRecommendAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */