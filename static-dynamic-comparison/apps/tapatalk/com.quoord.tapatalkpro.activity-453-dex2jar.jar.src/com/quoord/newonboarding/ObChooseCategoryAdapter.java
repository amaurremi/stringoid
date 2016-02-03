package com.quoord.newonboarding;

import android.app.Activity;
import android.content.res.Resources;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.quoord.tapatalkpro.action.CategoriesAction;
import com.quoord.tapatalkpro.action.CategoriesAction.CategoriesActionCallBack;
import com.quoord.tapatalkpro.adapter.directory.view.CategoriesView;
import com.quoord.tapatalkpro.bean.TapatalkCategory;
import com.quoord.tapatalkpro.util.Util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ObChooseCategoryAdapter
        extends BaseAdapter {
    private ObChooseActivity activity;
    private CategoriesAction categoriesAction;
    private CategoriesView categoriesView;
    private ArrayList<TapatalkCategory> datas = new ArrayList();
    private GridView gridView;
    private Display mDisplay;
    private ProgressBar progress;
    private ArrayList<TapatalkCategory> selectedCategoryList = new ArrayList();
    private WindowSizeHolder sizeHolder;

    public ObChooseCategoryAdapter(Activity paramActivity, GridView paramGridView, ProgressBar paramProgressBar) {
        this.activity = ((ObChooseActivity) paramActivity);
        this.gridView = paramGridView;
        this.progress = paramProgressBar;
        if (this.sizeHolder == null) {
            this.sizeHolder = new WindowSizeHolder();
        }
        this.categoriesView = new CategoriesView(paramActivity, 3);
        this.mDisplay = this.activity.getWindowManager().getDefaultDisplay();
        this.gridView.setAdapter(this);
        this.categoriesAction = new CategoriesAction(this.activity);
        this.categoriesAction.getCategories(new CategoriesAction.CategoriesActionCallBack() {
            public void actionCallBack(ArrayList<TapatalkCategory> paramAnonymousArrayList) {
                ObChooseCategoryAdapter.this.datas = ObChooseCategoryAdapter.this.categoriesAction.getPopularCategorys(paramAnonymousArrayList);
                ObChooseCategoryAdapter.this.shortDatas(ObChooseCategoryAdapter.this.datas);
                ObChooseCategoryAdapter.this.datas = ObChooseCategoryAdapter.this.getExplorePopularCategories(ObChooseCategoryAdapter.this.datas);
                ObChooseCategoryAdapter.this.progress.setVisibility(8);
                ObChooseCategoryAdapter.this.gridView.setVisibility(0);
                ObChooseCategoryAdapter.this.notifyDataSetChanged();
            }
        });
    }

    public void changeSelected(int paramInt) {
        TapatalkCategory localTapatalkCategory = (TapatalkCategory) this.datas.get(paramInt);
        boolean bool;
        if (localTapatalkCategory.isSelected()) {
            bool = false;
            localTapatalkCategory.setSelected(bool);
            notifyDataSetChanged();
            if (!localTapatalkCategory.isSelected()) {
                break label107;
            }
            if (!this.selectedCategoryList.contains(localTapatalkCategory)) {
                this.selectedCategoryList.add(localTapatalkCategory);
            }
        }
        for (; ; ) {
            if (this.selectedCategoryList.size() <= 0) {
                break label130;
            }
            this.activity.next.setBackgroundResource(2130839159);
            this.activity.next.setTextColor(this.activity.getResources().getColor(2131165213));
            return;
            bool = true;
            break;
            label107:
            if (this.selectedCategoryList.contains(localTapatalkCategory)) {
                this.selectedCategoryList.remove(localTapatalkCategory);
            }
        }
        label130:
        this.activity.next.setBackgroundResource(2130839160);
        this.activity.next.setTextColor(this.activity.getResources().getColor(2131165237));
    }

    public int getCount() {
        return this.datas.size();
    }

    public ArrayList<TapatalkCategory> getDatas() {
        return this.datas;
    }

    public ArrayList<TapatalkCategory> getExplorePopularCategories(ArrayList<TapatalkCategory> paramArrayList) {
        if ((paramArrayList != null) && (paramArrayList.size() != 0)) {
            shortDatas(paramArrayList);
        }
        ArrayList localArrayList = new ArrayList();
        Object localObject;
        if (paramArrayList.size() <= 12) {
            localObject = paramArrayList;
            return (ArrayList<TapatalkCategory>) localObject;
        }
        int i = 0;
        for (; ; ) {
            localObject = localArrayList;
            if (i >= 12) {
                break;
            }
            localArrayList.add((TapatalkCategory) paramArrayList.get(i));
            i += 1;
        }
    }

    public Object getItem(int paramInt) {
        return this.datas.get(paramInt);
    }

    public long getItemId(int paramInt) {
        return 0L;
    }

    public ArrayList<TapatalkCategory> getSelectedCategoryList() {
        return this.selectedCategoryList;
    }

    public View getView(final int paramInt, View paramView, ViewGroup paramViewGroup) {
        paramView = this.categoriesView.getCategoryItemView((TapatalkCategory) getItem(paramInt), paramView, true);
        paramView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View paramAnonymousView) {
                ObChooseCategoryAdapter.this.changeSelected(paramInt);
            }
        });
        return paramView;
    }

    public void setDatas(ArrayList<TapatalkCategory> paramArrayList) {
        this.datas = paramArrayList;
    }

    public void shortDatas(ArrayList<TapatalkCategory> paramArrayList) {
        Collections.sort(paramArrayList, new Comparator() {
            public int compare(TapatalkCategory paramAnonymousTapatalkCategory1, TapatalkCategory paramAnonymousTapatalkCategory2) {
                return paramAnonymousTapatalkCategory1.getCat_order() - paramAnonymousTapatalkCategory2.getCat_order();
            }
        });
    }

    static class ViewHolder {
        ImageView icon;
        ImageView iconSelected;
        TextView name;
    }

    class WindowSizeHolder {
        public int columsNum = -1;
        public int[] windowSize = null;

        WindowSizeHolder() {
        }

        public void reset(int paramInt, Activity paramActivity) {
            this.columsNum = paramInt;
            this.windowSize = Util.getWindowSize(paramActivity);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/newonboarding/ObChooseCategoryAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */