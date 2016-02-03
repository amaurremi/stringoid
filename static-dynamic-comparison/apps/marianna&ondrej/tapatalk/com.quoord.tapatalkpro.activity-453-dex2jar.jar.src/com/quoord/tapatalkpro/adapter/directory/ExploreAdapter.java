package com.quoord.tapatalkpro.adapter.directory;

import android.app.Activity;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.quoord.tapatalkpro.adapter.directory.view.CategoriesView;
import com.quoord.tapatalkpro.bean.TapatalkCategory;
import com.quoord.tapatalkpro.ui.GroupBean;
import com.quoord.tapatalkpro.util.ThemeUtil;
import com.quoord.tapatalkpro.util.Util;
import com.quoord.tapatalkpro.view.SectionTitleListView;
import com.quoord.tapatalkpro.view.SectionTitleListView.IphoneTreeHeaderAdapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ExploreAdapter
        extends BaseExpandableListAdapter
        implements SectionTitleListView.IphoneTreeHeaderAdapter {
    public CategoriesView categoriesView;
    public ArrayList<GroupBean> groupList;
    private SparseIntArray groupStatusMap;
    private Activity mContext;
    private int numColumns;
    private SectionTitleListView sectionTitleListView;

    public ExploreAdapter(Activity paramActivity, SectionTitleListView paramSectionTitleListView, LinearLayout paramLinearLayout) {
        this.sectionTitleListView = paramSectionTitleListView;
        this.mContext = paramActivity;
        this.numColumns = 3;
        this.categoriesView = new CategoriesView(paramActivity, 3);
        initGroup();
        paramSectionTitleListView.addFooterView(paramLinearLayout);
        paramSectionTitleListView.setAdapter(this);
    }

    public void configureTreeHeader(View paramView, int paramInt1, int paramInt2, int paramInt3) {
        paramInt2 = paramInt1;
        if (paramInt1 < 0) {
            paramInt2 = 0;
        }
        ((TextView) paramView.findViewById(2131231075)).setText(((GroupBean) this.groupList.get(paramInt2)).getTitle());
        Util.setBg(paramView, ThemeUtil.getDrawableByPicName("ob_section_title", this.mContext));
    }

    public Object getChild(int paramInt1, int paramInt2) {
        return ((GroupBean) this.groupList.get(paramInt1)).getChildrenList().get(paramInt2);
    }

    public long getChildId(int paramInt1, int paramInt2) {
        return paramInt1 * 100 + paramInt2;
    }

    public View getChildView(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup) {
        paramView = ((GroupBean) this.groupList.get(paramInt1)).getChildrenList().get(paramInt2);
        if (paramInt1 == 1) {
            return this.categoriesView.getAllCategories(paramInt1, paramInt2, (TapatalkCategory) paramView, ((GroupBean) this.groupList.get(1)).getChildrenList().size());
        }
        return this.categoriesView.getPopularCategoriesView(getExplorePopularCategories((ArrayList) ((GroupBean) this.groupList.get(paramInt1)).getChildrenList().get(paramInt2)));
    }

    public int getChildrenCount(int paramInt) {
        if (paramInt < 0) {
            return 0;
        }
        return ((GroupBean) this.groupList.get(paramInt)).getChildrenList().size();
    }

    public ArrayList<TapatalkCategory> getExplorePopularCategories(ArrayList<TapatalkCategory> paramArrayList) {
        if ((paramArrayList != null) && (paramArrayList.size() != 0)) {
            shortDatas(paramArrayList);
        }
        ArrayList localArrayList = new ArrayList();
        Object localObject;
        if (paramArrayList.size() <= 6) {
            localObject = paramArrayList;
            return (ArrayList<TapatalkCategory>) localObject;
        }
        int i = 0;
        for (; ; ) {
            localObject = localArrayList;
            if (i >= 6) {
                break;
            }
            localArrayList.add((TapatalkCategory) paramArrayList.get(i));
            i += 1;
        }
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
        Util.setBg(paramViewGroup, ThemeUtil.getDrawableByPicName("ob_section_title", this.mContext));
        paramViewGroup.setClickable(false);
        return paramViewGroup;
    }

    public int getHeadViewClickStatus(int paramInt) {
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

    public int getNumColumns() {
        return this.numColumns;
    }

    public int getTreeHeaderState(int paramInt1, int paramInt2) {
        if (paramInt2 == getChildrenCount(paramInt1) - 1) {
            return 2;
        }
        if ((paramInt2 == -1) && (!this.sectionTitleListView.isGroupExpanded(paramInt1))) {
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
        return true;
    }

    public void onHeadViewClick(int paramInt1, int paramInt2) {
    }

    public void setNumColumns(int paramInt) {
        this.numColumns = paramInt;
    }

    public void shortDatas(ArrayList<TapatalkCategory> paramArrayList) {
        Collections.sort(paramArrayList, new Comparator() {
            public int compare(TapatalkCategory paramAnonymousTapatalkCategory1, TapatalkCategory paramAnonymousTapatalkCategory2) {
                return paramAnonymousTapatalkCategory1.getCat_order() - paramAnonymousTapatalkCategory2.getCat_order();
            }
        });
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/adapter/directory/ExploreAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */