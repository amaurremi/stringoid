package com.quoord.tapatalkpro.adapter.directory.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.androidquery.AQuery;
import com.quoord.tapatalkpro.activity.directory.ics.AccountEntryActivity;
import com.quoord.tapatalkpro.activity.directory.ics.ExploreChildActivity;
import com.quoord.tapatalkpro.activity.directory.ics.ExploreChildFragment;
import com.quoord.tapatalkpro.activity.directory.ics.ShowFragmentActivityInter;
import com.quoord.tapatalkpro.bean.TapatalkCategory;
import com.quoord.tapatalkpro.ics.slidingMenu.SettingsFragment;
import com.quoord.tapatalkpro.ui.CategoryGridView;
import com.quoord.tapatalkpro.util.ThemeUtil;
import com.quoord.tapatalkpro.util.Util;
import com.quoord.tools.ImageTools;

import java.util.ArrayList;

public class CategoriesView {
    public static final int LANDSCAPE_COLUMNS = 4;
    public static final int PORTRAIT_COLUMNS = 3;
    public boolean HD_LANDSCAPE = false;
    private AQuery aq;
    private GridView gridView;
    private Activity mContext;
    private Display mDisplay;
    private int numColumns;
    private WindowSizeHolder sizeHolder;

    public CategoriesView(Activity paramActivity, int paramInt) {
        this.mContext = paramActivity;
        this.numColumns = paramInt;
        this.aq = new AQuery(paramActivity);
        if (this.sizeHolder == null) {
            this.sizeHolder = new WindowSizeHolder();
        }
        this.mDisplay = paramActivity.getWindowManager().getDefaultDisplay();
    }

    public View getAllCategories(int paramInt1, int paramInt2, TapatalkCategory paramTapatalkCategory, int paramInt3) {
        View localView = null;
        AllCategoriesViewHolder localAllCategoriesViewHolder;
        if (0 == 0) {
            localAllCategoriesViewHolder = new AllCategoriesViewHolder();
            localView = LayoutInflater.from(this.mContext).inflate(2130903281, null);
            localAllCategoriesViewHolder.icon = ((ImageView) localView.findViewById(2131231400));
            localAllCategoriesViewHolder.name = ((TextView) localView.findViewById(2131231401));
            localAllCategoriesViewHolder.categorylist = ((RelativeLayout) localView.findViewById(2131230890));
            localAllCategoriesViewHolder.divice = ((ImageView) localView.findViewById(2131231020));
            localAllCategoriesViewHolder.text = ((TextView) localView.findViewById(2131230919));
            localAllCategoriesViewHolder.divice.setBackgroundDrawable(ThemeUtil.getDrawableByPicName("forum_item_diver", this.mContext));
            localView.setTag(localAllCategoriesViewHolder);
            if (paramInt2 != 0) {
                break label259;
            }
            localAllCategoriesViewHolder.categorylist.setBackgroundDrawable(ThemeUtil.getDrawableByPicName("forum_top_item_bg", this.mContext));
            localAllCategoriesViewHolder.divice.setVisibility(0);
            localAllCategoriesViewHolder.name.setPadding(0, 14, 0, 0);
            if (SettingsFragment.isLightTheme(this.mContext)) {
                break label326;
            }
            localAllCategoriesViewHolder.name.setTextColor(this.mContext.getResources().getColor(2131165213));
        }
        for (; ; ) {
            if (paramTapatalkCategory.getIconURL() != null) {
                setCategoryIcon(localAllCategoriesViewHolder.icon, paramTapatalkCategory.getId(), paramTapatalkCategory.getIconURL(), false);
            }
            if (paramTapatalkCategory.getName() != null) {
                localAllCategoriesViewHolder.name.setText(paramTapatalkCategory.getName());
            }
            return localView;
            throw new NullPointerException();
            label259:
            if (paramInt2 == paramInt3 - 1) {
                localAllCategoriesViewHolder.categorylist.setBackgroundDrawable(ThemeUtil.getDrawableByPicName("forum_bottom_item_bg", this.mContext));
                localAllCategoriesViewHolder.divice.setVisibility(8);
                break;
            }
            localAllCategoriesViewHolder.categorylist.setBackgroundDrawable(ThemeUtil.getDrawableByPicName("forum_mid_item_bg", this.mContext));
            localAllCategoriesViewHolder.divice.setVisibility(0);
            break;
            label326:
            localAllCategoriesViewHolder.name.setTextColor(this.mContext.getResources().getColor(2131165214));
        }
    }

    public View getCategoryItemView(TapatalkCategory paramTapatalkCategory, View paramView, boolean paramBoolean) {
        CategoryItemViewHolder localCategoryItemViewHolder;
        label109:
        AQuery localAQuery;
        label192:
        int i;
        if (paramView == null) {
            localCategoryItemViewHolder = new CategoryItemViewHolder();
            paramView = LayoutInflater.from(this.mContext).inflate(2130903085, null);
            localCategoryItemViewHolder.icon = ((ImageView) paramView.findViewById(2131230897));
            if (Util.isHDDevice(this.mContext)) {
                localCategoryItemViewHolder.name = ((TextView) paramView.findViewById(2131230901));
                localCategoryItemViewHolder.name.setVisibility(0);
                localCategoryItemViewHolder.iconBg = ((ImageView) paramView.findViewById(2131230898));
                localCategoryItemViewHolder.iconSelected = ((ImageView) paramView.findViewById(2131230899));
                paramView.setTag(localCategoryItemViewHolder);
                localAQuery = (AQuery) this.aq.recycle(paramView);
                if (!paramBoolean) {
                    break label457;
                }
                localCategoryItemViewHolder.iconSelected.setVisibility(0);
                if (!paramTapatalkCategory.isSelected()) {
                    break label416;
                }
                localCategoryItemViewHolder.name.setVisibility(8);
                localCategoryItemViewHolder.iconBg.setVisibility(8);
                if (!Util.isHDDevice(this.mContext)) {
                    break label392;
                }
                localCategoryItemViewHolder.iconSelected.setBackgroundDrawable(this.mContext.getResources().getDrawable(2130839164));
                if (!Util.isHDDevice(this.mContext)) {
                    break label543;
                }
                if (!this.HD_LANDSCAPE) {
                    break label490;
                }
                i = (this.mDisplay.getWidth() - (this.numColumns + 1) * this.mContext.getResources().getDimensionPixelOffset(2131427404) - (int) this.mContext.getResources().getDimension(2131427405) * 2) / this.numColumns;
                label259:
                ((AQuery) localAQuery.id(localCategoryItemViewHolder.icon)).width(i, false);
                ((AQuery) localAQuery.id(localCategoryItemViewHolder.icon)).height(i, false);
                if (!"".equals(paramTapatalkCategory.getObName())) {
                    break label597;
                }
                ((AQuery) localAQuery.id(localCategoryItemViewHolder.name)).text(paramTapatalkCategory.getName());
            }
        }
        for (; ; ) {
            setCategoryIcon(localCategoryItemViewHolder.icon, paramTapatalkCategory.getId(), paramTapatalkCategory.getIconURL(), paramBoolean);
            return paramView;
            localCategoryItemViewHolder.name = ((TextView) paramView.findViewById(2131230900));
            localCategoryItemViewHolder.name.setVisibility(0);
            break;
            localCategoryItemViewHolder = (CategoryItemViewHolder) paramView.getTag();
            break label109;
            label392:
            localCategoryItemViewHolder.iconSelected.setBackgroundDrawable(this.mContext.getResources().getDrawable(2130839163));
            break label192;
            label416:
            localCategoryItemViewHolder.name.setVisibility(0);
            localCategoryItemViewHolder.iconBg.setVisibility(0);
            localCategoryItemViewHolder.iconBg.setBackgroundResource(2130839161);
            localCategoryItemViewHolder.iconSelected.setBackgroundDrawable(null);
            break label192;
            label457:
            localCategoryItemViewHolder.iconSelected.setVisibility(8);
            localCategoryItemViewHolder.iconBg.setVisibility(0);
            localCategoryItemViewHolder.iconBg.setBackgroundResource(2130837758);
            break label192;
            label490:
            i = (this.mDisplay.getWidth() - (this.numColumns - 1) * this.mContext.getResources().getDimensionPixelOffset(2131427404) - this.mContext.getResources().getDimensionPixelOffset(2131427411) * 2) / this.numColumns;
            break label259;
            label543:
            i = (this.mDisplay.getWidth() - (this.numColumns - 1) * this.mContext.getResources().getDimensionPixelOffset(2131427403) - this.mContext.getResources().getDimensionPixelOffset(2131427411) * 2) / this.numColumns;
            break label259;
            label597:
            ((AQuery) localAQuery.id(localCategoryItemViewHolder.name)).text(paramTapatalkCategory.getObName());
        }
    }

    public int getNumColumns() {
        return this.numColumns;
    }

    public View getPopularCategoriesView(ArrayList<TapatalkCategory> paramArrayList) {
        View localView = LayoutInflater.from(this.mContext).inflate(2130903374, null);
        this.gridView = ((CategoryGridView) localView.findViewById(2131231614));
        this.gridView.setOnLongClickListener(null);
        this.gridView.setNumColumns(this.numColumns);
        if (Util.isHDDevice(this.mContext)) {
            this.gridView.setHorizontalSpacing((int) this.mContext.getResources().getDimension(2131427404));
        }
        for (; ; ) {
            this.gridView.setAdapter(new GridAdapter(this.mContext, paramArrayList));
            setGridViewClickListener(paramArrayList);
            return localView;
            this.gridView.setHorizontalSpacing((int) this.mContext.getResources().getDimension(2131427403));
        }
    }

    public void setCategoryIcon(ImageView paramImageView, String paramString1, String paramString2, boolean paramBoolean) {
        int i = this.mContext.getResources().getIdentifier("category_" + paramString1, "drawable", "com.quoord.tapatalkpro.activity");
        if (i > 0) {
        }
        for (; ; ) {
            try {
                paramImageView.setBackgroundDrawable(this.mContext.getResources().getDrawable(i));
                return;
            } catch (Exception paramImageView) {
            }
            if ((paramString2 != null) && (!"".equals(paramString2))) {
                if (paramBoolean) {
                    ImageTools.glideLoad(paramString2, paramImageView, 2130839162);
                    return;
                }
                ImageTools.glideLoad(paramString2, paramImageView);
                return;
            }
        }
    }

    public void setGridViewClickListener(final ArrayList<TapatalkCategory> paramArrayList) {
        this.gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong) {
                paramAnonymousAdapterView = (TapatalkCategory) paramArrayList.get(paramAnonymousInt);
                if ((CategoriesView.this.mContext instanceof AccountEntryActivity)) {
                    paramAnonymousView = new Intent(CategoriesView.this.mContext, ExploreChildActivity.class);
                    paramAnonymousView.putExtra("childcategory", paramAnonymousAdapterView);
                    CategoriesView.this.mContext.startActivity(paramAnonymousView);
                    return;
                }
                ((ShowFragmentActivityInter) CategoriesView.this.mContext).addFragmentToStack(ExploreChildFragment.newInstance(paramAnonymousAdapterView));
            }
        });
    }

    public void setNumColumns(int paramInt) {
        this.numColumns = paramInt;
    }

    public class AllCategoriesViewHolder {
        RelativeLayout categorylist;
        ImageView divice;
        ImageView icon;
        TextView name;
        TextView text;

        public AllCategoriesViewHolder() {
        }
    }

    public class CategoryItemViewHolder {
        ImageView icon;
        ImageView iconBg;
        ImageView iconSelected;
        TextView name;

        public CategoryItemViewHolder() {
        }
    }

    public class GridAdapter
            extends BaseAdapter {
        private ArrayList<TapatalkCategory> mDatas = new ArrayList();

        public GridAdapter(ArrayList<TapatalkCategory> paramArrayList) {
            ArrayList localArrayList;
            this.mDatas = localArrayList;
            notifyDataSetChanged();
        }

        public int getCount() {
            return this.mDatas.size();
        }

        public Object getItem(int paramInt) {
            return this.mDatas.get(paramInt);
        }

        public long getItemId(int paramInt) {
            return paramInt & 0x3E8;
        }

        public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
            return CategoriesView.this.getCategoryItemView((TapatalkCategory) this.mDatas.get(paramInt), paramView, false);
        }
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


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/adapter/directory/view/CategoriesView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */