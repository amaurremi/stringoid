package com.quoord.tapatalkpro.activity.directory.ics;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.quoord.tapatalkpro.action.CategoriesAction;
import com.quoord.tapatalkpro.action.CategoriesAction.CategoriesActionCallBack;
import com.quoord.tapatalkpro.adapter.directory.ExploreAdapter;
import com.quoord.tapatalkpro.adapter.directory.view.CategoriesView;
import com.quoord.tapatalkpro.bean.TapatalkCategory;
import com.quoord.tapatalkpro.cache.AppCacheManager;
import com.quoord.tapatalkpro.cache.ExploreCache;
import com.quoord.tapatalkpro.ui.ButtomProgress;
import com.quoord.tapatalkpro.ui.GroupBean;
import com.quoord.tapatalkpro.ui.ics.QuoordFragment;
import com.quoord.tapatalkpro.util.Prefs;
import com.quoord.tapatalkpro.util.Util;
import com.quoord.tapatalkpro.view.SectionTitleListView;

import java.util.ArrayList;

public class ExploreFragment
        extends QuoordFragment
        implements ExpandableListView.OnChildClickListener {
    private CategoriesAction categoriesAction;
    private TextView categoriesHint;
    private LinearLayout footLayout;
    private Activity mActivity;
    private ArrayList<TapatalkCategory> mDatas = new ArrayList();
    private ExploreAdapter newCategoryAdapter;
    private ArrayList<TapatalkCategory> popularCatetories = new ArrayList();
    private SectionTitleListView sectionTitleListView;

    public void closeHint(int paramInt) {
        Util.hideHintview(this.categoriesHint, paramInt);
    }

    public void getExploreData() {
        this.categoriesAction = new CategoriesAction(this.mActivity);
        this.categoriesAction.getCategories(new CategoriesAction.CategoriesActionCallBack() {
            public void actionCallBack(ArrayList<TapatalkCategory> paramAnonymousArrayList) {
                ExploreFragment.this.mDatas = paramAnonymousArrayList;
                ExploreFragment.this.sectionTitleListView.removeFooterView(ExploreFragment.this.footLayout);
                if ((ExploreFragment.this.mDatas == null) || (ExploreFragment.this.mDatas.size() == 0)) {
                    Toast.makeText(ExploreFragment.this.mActivity, ExploreFragment.this.mActivity.getResources().getString(2131100069), 1).show();
                    return;
                }
                paramAnonymousArrayList = AppCacheManager.getExploreData();
                if ((paramAnonymousArrayList == null) || (paramAnonymousArrayList.categoryData == null) || (paramAnonymousArrayList.categoryData.size() == 0)) {
                    ExploreFragment.this.categoriesAction.saveToExploreCache(ExploreFragment.this.mDatas);
                }
                ExploreFragment.this.popularCatetories = ExploreFragment.this.categoriesAction.getPopularCategorys(ExploreFragment.this.mDatas);
                ExploreFragment.this.initGroupData();
            }
        });
    }

    public void initGroupData() {
        if (this.popularCatetories.size() > 0) {
            localGroupBean = new GroupBean(this.mActivity.getString(2131100881));
            ArrayList localArrayList = new ArrayList();
            localArrayList.add(this.popularCatetories);
            localGroupBean.setChildrenList(localArrayList);
            this.newCategoryAdapter.groupList.add(localGroupBean);
        }
        GroupBean localGroupBean = new GroupBean(this.mActivity.getString(2131100882));
        this.newCategoryAdapter.groupList.add(localGroupBean);
        localGroupBean.setChildrenList(this.mDatas);
        int i = 0;
        for (; ; ) {
            if (i >= this.newCategoryAdapter.getGroupCount()) {
                this.newCategoryAdapter.notifyDataSetChanged();
                return;
            }
            this.sectionTitleListView.expandGroup(i);
            i += 1;
        }
    }

    public void onActivityCreated(Bundle paramBundle) {
        super.onActivityCreated(paramBundle);
        this.mActivity = getActivity();
        Prefs.isShowHint(this.mActivity, this.categoriesHint);
        this.footLayout = ButtomProgress.get(this.mActivity);
        this.newCategoryAdapter = new ExploreAdapter(this.mActivity, this.sectionTitleListView, this.footLayout);
        this.sectionTitleListView.setHeaderView(this.mActivity.getLayoutInflater().inflate(2130903356, this.sectionTitleListView, false));
        this.sectionTitleListView.setGroupIndicator(null);
        this.sectionTitleListView.setOnChildClickListener(this);
        this.sectionTitleListView.setSelector(2131165212);
        this.sectionTitleListView.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent) {
                ExploreFragment.this.closeHint(0);
                Util.hideSoftKeyb(ExploreFragment.this.mActivity, paramAnonymousView);
                if ((ExploreFragment.this.mActivity instanceof AccountEntryActivity)) {
                    ((AccountEntryActivity) ExploreFragment.this.mActivity).collapseSearchView();
                }
                return false;
            }
        });
        this.categoriesHint.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent) {
                ExploreFragment.this.closeHint(0);
                return true;
            }
        });
        getExploreData();
        onConfigurationChanged(getActivity().getResources().getConfiguration());
    }

    public boolean onChildClick(ExpandableListView paramExpandableListView, View paramView, int paramInt1, int paramInt2, long paramLong) {
        closeHint(0);
        if (paramInt1 == 1) {
            paramExpandableListView = (TapatalkCategory) ((GroupBean) this.newCategoryAdapter.groupList.get(paramInt1)).getChildrenList().get(paramInt2);
            if ((this.mActivity instanceof AccountEntryActivity)) {
                paramView = new Intent(this.mActivity, ExploreChildActivity.class);
                paramView.putExtra("childcategory", paramExpandableListView);
                this.mActivity.startActivity(paramView);
            }
        } else {
            return true;
        }
        ((ShowFragmentActivityInter) this.mActivity).addFragmentToStack(ExploreChildFragment.newInstance(paramExpandableListView));
        return true;
    }

    public void onConfigurationChanged(Configuration paramConfiguration) {
        ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams) this.sectionTitleListView.getLayoutParams();
        switch (paramConfiguration.orientation) {
        }
        for (; ; ) {
            super.onConfigurationChanged(paramConfiguration);
            return;
            if ((this.newCategoryAdapter != null) && (this.newCategoryAdapter.categoriesView != null)) {
                if (Util.isHDDevice(getActivity())) {
                    this.newCategoryAdapter.categoriesView.HD_LANDSCAPE = true;
                    int i = (int) getResources().getDimension(2131427405);
                    localMarginLayoutParams.setMargins(i, 0, i, 0);
                    this.sectionTitleListView.invalidate();
                    this.newCategoryAdapter.categoriesView.setNumColumns(3);
                }
                for (; ; ) {
                    this.newCategoryAdapter.notifyDataSetChanged();
                    break;
                    this.newCategoryAdapter.categoriesView.setNumColumns(4);
                }
                if ((this.newCategoryAdapter != null) && (this.newCategoryAdapter.categoriesView != null)) {
                    if (Util.isHDDevice(getActivity())) {
                        this.newCategoryAdapter.categoriesView.HD_LANDSCAPE = false;
                        localMarginLayoutParams.setMargins(0, 0, 0, 0);
                        this.sectionTitleListView.invalidate();
                    }
                    this.newCategoryAdapter.categoriesView.setNumColumns(3);
                    this.newCategoryAdapter.notifyDataSetChanged();
                }
            }
        }
    }

    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        paramLayoutInflater = paramLayoutInflater.inflate(2130903195, null);
        this.sectionTitleListView = ((SectionTitleListView) paramLayoutInflater.findViewById(2131231196));
        this.categoriesHint = ((TextView) paramLayoutInflater.findViewById(2131231197));
        return paramLayoutInflater;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/activity/directory/ics/ExploreFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */