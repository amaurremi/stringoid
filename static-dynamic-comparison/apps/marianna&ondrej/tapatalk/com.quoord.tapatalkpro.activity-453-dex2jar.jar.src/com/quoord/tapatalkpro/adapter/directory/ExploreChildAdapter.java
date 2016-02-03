package com.quoord.tapatalkpro.adapter.directory;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.androidquery.AQuery;
import com.quoord.tapatalkpro.action.CategoryForumListAction;
import com.quoord.tapatalkpro.action.CategoryForumListAction.CategoryForumListActionCallBack;
import com.quoord.tapatalkpro.adapter.directory.view.IcsSearchForumView;
import com.quoord.tapatalkpro.adapter.directory.view.IcsSearchForumView.SearchForumTag;
import com.quoord.tapatalkpro.bean.TapatalkCategory;
import com.quoord.tapatalkpro.bean.TapatalkForum;
import com.quoord.tapatalkpro.ui.ButtomProgress;
import com.quoord.tapatalkpro.util.ForumOnClick;

import java.util.ArrayList;

public class ExploreChildAdapter
        extends BaseAdapter {
    private AQuery aq;
    private CategoryForumListAction categoriesAction;
    private int currentPage = 1;
    private LinearLayout footlay;
    private boolean isLoding = false;
    private ListView listView;
    private boolean loadFinished = false;
    private Activity mContext;
    private ArrayList<Object> mDatas = new ArrayList();
    private LinearLayout noDataView;
    private TapatalkCategory parentCategory;
    private int perPage = 20;

    public ExploreChildAdapter(Activity paramActivity, TapatalkCategory paramTapatalkCategory, ListView paramListView, LinearLayout paramLinearLayout) {
        try {
            this.mContext = paramActivity;
            this.aq = new AQuery(this.mContext);
            this.parentCategory = paramTapatalkCategory;
            this.listView = paramListView;
            this.noDataView = paramLinearLayout;
            this.footlay = ButtomProgress.get(this.mContext);
            this.listView.addFooterView(this.footlay);
            getForumCategories(this.parentCategory.getId());
            this.listView.setOnScrollListener(new AbsListView.OnScrollListener() {
                public void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {
                    paramAnonymousInt1 += paramAnonymousInt2;
                    if ((paramAnonymousInt1 != 0) && (paramAnonymousInt1 == paramAnonymousInt3) && (!ExploreChildAdapter.this.isLoding) && (!ExploreChildAdapter.this.loadFinished)) {
                        if (ExploreChildAdapter.this.parentCategory != null) {
                            ExploreChildAdapter.this.getForumCategories(ExploreChildAdapter.this.parentCategory.getId());
                        }
                        if (ExploreChildAdapter.this.listView.getFooterViewsCount() == 0) {
                            ExploreChildAdapter.this.listView.addFooterView(ExploreChildAdapter.this.footlay);
                        }
                    }
                }

                public void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt) {
                }
            });
            this.listView.setOnItemClickListener(new SubCategoryOnItemClickListener());
            return;
        } catch (Exception paramActivity) {
        }
    }

    public int getCount() {
        return this.mDatas.size();
    }

    public void getForumCategories(String paramString) {
        this.isLoding = true;
        this.categoriesAction = new CategoryForumListAction(this.mContext);
        this.categoriesAction.getRemoteCategoryForumList(paramString, this.currentPage, new CategoryForumListAction.CategoryForumListActionCallBack() {
            public void actionCallBack(ArrayList<Object> paramAnonymousArrayList) {
                ExploreChildAdapter.this.isLoding = false;
                ExploreChildAdapter.this.mDatas.addAll(paramAnonymousArrayList);
                if ((ExploreChildAdapter.this.mDatas != null) && (ExploreChildAdapter.this.mDatas.size() != 0)) {
                    paramAnonymousArrayList = ExploreChildAdapter.this;
                    paramAnonymousArrayList.currentPage += 1;
                }
                for (; ; ) {
                    if (ExploreChildAdapter.this.listView.getFooterViewsCount() > 0) {
                        ExploreChildAdapter.this.listView.removeFooterView(ExploreChildAdapter.this.footlay);
                    }
                    ExploreChildAdapter.this.notifyDataSetChanged();
                    return;
                    if (ExploreChildAdapter.this.currentPage != 1) {
                        ExploreChildAdapter.this.loadFinished = true;
                    } else {
                        ExploreChildAdapter.this.noDataView.setVisibility(0);
                    }
                }
            }
        });
    }

    public Object getItem(int paramInt) {
        return this.mDatas.get(paramInt);
    }

    public long getItemId(int paramInt) {
        return paramInt;
    }

    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
        IcsSearchForumView localIcsSearchForumView = new IcsSearchForumView(this.mContext, "", false);
        TapatalkForum localTapatalkForum = (TapatalkForum) this.mDatas.get(paramInt);
        IcsSearchForumView.SearchForumTag localSearchForumTag = IcsSearchForumView.SearchForumTag.ADD_BTN_SHOW_UNCONTAINED;
        if (getCount() - 1 == paramInt) {
        }
        for (boolean bool = true; ; bool = false) {
            paramView = localIcsSearchForumView.getSearchForumView(localTapatalkForum, localSearchForumTag, paramInt, paramView, paramViewGroup, false, bool);
            localIcsSearchForumView.setOnAddListener(new ForumOnClick(((TapatalkForum) getItem(paramInt)).getId().intValue(), (TapatalkForum) this.mDatas.get(paramInt), this.mContext, localIcsSearchForumView.getAddImg(), localIcsSearchForumView.getAddView(), "explore", true));
            return paramView;
        }
    }

    public void refresh() {
        this.mDatas.clear();
        this.currentPage = 1;
        if (this.listView.getFooterViewsCount() > 0) {
            this.listView.removeFooterView(this.footlay);
        }
        for (; ; ) {
            if (this.parentCategory != null) {
                getForumCategories(this.parentCategory.getId());
            }
            return;
            this.listView.addFooterView(this.footlay);
        }
    }

    class SubCategoryOnItemClickListener
            implements AdapterView.OnItemClickListener {
        SubCategoryOnItemClickListener() {
        }

        public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {
            if ((paramInt < ExploreChildAdapter.this.mDatas.size()) && ((ExploreChildAdapter.this.getItem(paramInt) instanceof TapatalkForum))) {
                ((TapatalkForum) ExploreChildAdapter.this.getItem(paramInt)).openTapatalkForum(ExploreChildAdapter.this.mContext, false);
            }
        }
    }

    private static class ViewHolder {
        TextView description;
        ImageView forumIcon;
        TextView forumName;
        LinearLayout selected;
        ImageView selectedicon;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/adapter/directory/ExploreChildAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */