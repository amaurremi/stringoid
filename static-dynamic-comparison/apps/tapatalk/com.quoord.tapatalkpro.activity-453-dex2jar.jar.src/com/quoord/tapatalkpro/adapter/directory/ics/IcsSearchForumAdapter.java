package com.quoord.tapatalkpro.adapter.directory.ics;

import android.app.Activity;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Toast;
import com.quoord.tapatalkpro.action.TapatalkAccountAction;
import com.quoord.tapatalkpro.activity.directory.ics.IcsSearchActivity;
import com.quoord.tapatalkpro.adapter.directory.view.IcsSearchForumView;
import com.quoord.tapatalkpro.adapter.directory.view.IcsSearchForumView.SearchForumTag;
import com.quoord.tapatalkpro.ads.SearchAd;
import com.quoord.tapatalkpro.ads.SearchAd.SearchAdViewBack;
import com.quoord.tapatalkpro.bean.TapatalkForum;
import com.quoord.tapatalkpro.bean.TapatalkForumForSearch;
import com.quoord.tapatalkpro.ics.action.IcsSearchForumAction;
import com.quoord.tapatalkpro.ics.action.IcsSearchForumAction.IcsSearchForumActionBack;
import com.quoord.tapatalkpro.ui.ButtomProgress;
import com.quoord.tapatalkpro.util.ForumOnClick;
import com.quoord.tapatalkpro.util.Util;
import com.quoord.tools.tracking.GoogleAnalyticsTools;

import java.util.ArrayList;
import java.util.Iterator;

public class IcsSearchForumAdapter
        extends BaseAdapter
        implements SearchAd.SearchAdViewBack {
    private static final int LISTVIEWTYPE_AD = 3;
    private static final int LISTVIEWTYPE_HAS_NO_DESCRIPTION = 2;
    private static final int LISTVIEWTYPE_HAS_NO_TRENDING = 0;
    private static final int LISTVIEWTYPE_HAS_TRENDING = 1;
    private static final int PER_PAGE = 20;
    private boolean isLoadFinished = false;
    private int loading = 0;
    private Activity mActivity = null;
    private View mBottomProcessView = null;
    private ArrayList<Integer> mCurrentForumIds = null;
    private Integer mCurrentPage = Integer.valueOf(1);
    private ArrayList<Object> mDatas = new ArrayList();
    private String mKeyword = null;
    private View mMiddleProcessView = null;
    private View mNoResultView = null;
    private ListView mResultListView = null;
    private SearchAd searchAd;

    public IcsSearchForumAdapter(Activity paramActivity, String paramString, ListView paramListView, View paramView1, View paramView2) {
        this.mActivity = paramActivity;
        this.mKeyword = paramString;
        this.mResultListView = paramListView;
        this.mMiddleProcessView = paramView1;
        this.mBottomProcessView = ButtomProgress.get(this.mActivity);
        this.mNoResultView = paramView2;
        initFavForumCache();
        initResultListView();
        getSearchForum(this.mKeyword, true);
        GoogleAnalyticsTools.trackPageView(this.mActivity, "tap_search");
    }

    private void initFavForumCache() {
        this.mCurrentForumIds = new ArrayList();
        Iterator localIterator = TapatalkAccountAction.getCurrnentAllAccount(this.mActivity).iterator();
        for (; ; ) {
            if (!localIterator.hasNext()) {
                return;
            }
            TapatalkForum localTapatalkForum = (TapatalkForum) localIterator.next();
            if (!this.mCurrentForumIds.contains(localTapatalkForum.getId())) {
                this.mCurrentForumIds.add(localTapatalkForum.getId());
            }
        }
    }

    private void initResultListView() {
        this.mResultListView.addFooterView(this.mBottomProcessView);
        this.mResultListView.setAdapter(this);
        this.mResultListView.removeFooterView(this.mBottomProcessView);
        this.mResultListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong) {
                if ((IcsSearchForumAdapter.this.getItem(paramAnonymousInt) instanceof TapatalkForum)) {
                    ((TapatalkForum) IcsSearchForumAdapter.this.getItem(paramAnonymousInt)).openTapatalkForum(IcsSearchForumAdapter.this.mActivity, false);
                }
            }
        });
        this.mResultListView.setOnScrollListener(new AbsListView.OnScrollListener() {
            public void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {
                paramAnonymousInt1 += paramAnonymousInt2;
                if ((paramAnonymousInt1 != 0) && (paramAnonymousInt1 == paramAnonymousInt3) && (IcsSearchForumAdapter.this.loading == 0) && (!IcsSearchForumAdapter.this.isLoadFinished)) {
                    IcsSearchForumAdapter.this.getSearchForum(IcsSearchForumAdapter.this.mKeyword, false);
                }
            }

            public void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt) {
            }
        });
    }

    public int getCount() {
        return this.mDatas.size();
    }

    public Object getItem(int paramInt) {
        try {
            Object localObject = this.mDatas.get(paramInt);
            return localObject;
        } catch (Exception localException) {
        }
        return null;
    }

    public long getItemId(int paramInt) {
        return paramInt;
    }

    public int getItemViewType(int paramInt) {
        if ((this.mDatas.get(paramInt) instanceof TapatalkForumForSearch)) {
            TapatalkForumForSearch localTapatalkForumForSearch = (TapatalkForumForSearch) this.mDatas.get(paramInt);
            if ((localTapatalkForumForSearch.getDescription() == null) || (localTapatalkForumForSearch.getDescription().equals(""))) {
                return 2;
            }
            if (localTapatalkForumForSearch.getTrendingDiscussionJson() == null) {
                return 0;
            }
            return 1;
        }
        return 3;
    }

    public void getSearchForum(String paramString, boolean paramBoolean) {
        if ((((IcsSearchActivity) this.mActivity).startCount >= ((IcsSearchActivity) this.mActivity).countNum) && (this.mCurrentPage.intValue() == 1)) {
            this.searchAd = new SearchAd(this.mActivity, paramString, this);
        }
        if (paramBoolean) {
            this.mDatas.clear();
            notifyDataSetChanged();
            this.isLoadFinished = false;
            this.mCurrentPage = Integer.valueOf(1);
            this.mKeyword = paramString;
        }
        this.loading += 1;
        this.mNoResultView.setVisibility(8);
        if (this.mCurrentPage.intValue() == 1) {
            this.mMiddleProcessView.setVisibility(0);
            this.mResultListView.removeFooterView(this.mBottomProcessView);
        }
        for (; ; ) {
            if ((this.mKeyword != null) && (!this.mKeyword.equals(""))) {
                v2SearchForums();
            }
            return;
            this.mResultListView.addFooterView(this.mBottomProcessView);
        }
    }

    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
        if ((getItemViewType(paramInt) == 0) || (getItemViewType(paramInt) == 1) || (getItemViewType(paramInt) == 2)) {
            TapatalkForumForSearch localTapatalkForumForSearch = (TapatalkForumForSearch) this.mDatas.get(paramInt);
            IcsSearchForumView localIcsSearchForumView = new IcsSearchForumView(this.mActivity, "search", true);
            if (this.mCurrentForumIds.contains(localTapatalkForumForSearch.getId())) {
                localSearchForumTag = IcsSearchForumView.SearchForumTag.ADD_BTN_SHOW_UNCONTAINED;
                if (getCount() - 1 == paramInt) {
                }
                for (bool = true; ; bool = false) {
                    paramView = localIcsSearchForumView.getSearchForumView(localTapatalkForumForSearch, localSearchForumTag, paramInt, paramView, paramViewGroup, false, bool);
                    localIcsSearchForumView.setOnAddListener(new ForumOnClick(localTapatalkForumForSearch.getId().toString(), localTapatalkForumForSearch, this.mActivity, localIcsSearchForumView.getAddImg(), localIcsSearchForumView.getAddView(), "search", true, true));
                    return paramView;
                }
            }
            if (Util.isFavoriate(this.mActivity, localTapatalkForumForSearch.getId().intValue())) {
                localSearchForumTag = IcsSearchForumView.SearchForumTag.ADD_BTN_SHOW_CHECK;
                if (getCount() - 1 == paramInt) {
                }
                for (bool = true; ; bool = false) {
                    paramView = localIcsSearchForumView.getSearchForumView(localTapatalkForumForSearch, localSearchForumTag, paramInt, paramView, paramViewGroup, false, bool);
                    break;
                }
            }
            IcsSearchForumView.SearchForumTag localSearchForumTag = IcsSearchForumView.SearchForumTag.ADD_BTN_SHOW_ADD;
            if (getCount() - 1 == paramInt) {
            }
            for (boolean bool = true; ; bool = false) {
                paramView = localIcsSearchForumView.getSearchForumView(localTapatalkForumForSearch, localSearchForumTag, paramInt, paramView, paramViewGroup, false, bool);
                break;
            }
        }
        return this.searchAd.getSearchView();
    }

    public int getViewTypeCount() {
        return 4;
    }

    public void searchAdViewBack() {
        if (this.mCurrentPage.intValue() == 1) {
            if ((this.mDatas.size() > 0) && (this.searchAd != null)) {
                this.mDatas.add(1, this.searchAd);
            }
            notifyDataSetChanged();
        }
    }

    public void v2SearchForums() {
        new IcsSearchForumAction(this.mActivity).icsSearchForum(this.mKeyword, this.mCurrentPage.intValue(), 20, false, new IcsSearchForumAction.IcsSearchForumActionBack() {
            public void searchForumActionBack(ArrayList<TapatalkForumForSearch> paramAnonymousArrayList) {
                IcsSearchForumAdapter localIcsSearchForumAdapter = IcsSearchForumAdapter.this;
                localIcsSearchForumAdapter.loading -= 1;
                if (IcsSearchForumAdapter.this.loading > 0) {
                    return;
                }
                IcsSearchForumAdapter.this.mMiddleProcessView.setVisibility(8);
                IcsSearchForumAdapter.this.mResultListView.removeFooterView(IcsSearchForumAdapter.this.mBottomProcessView);
                if (paramAnonymousArrayList != null) {
                }
                for (; ; ) {
                    try {
                        if (paramAnonymousArrayList.size() != 0) {
                            continue;
                        }
                        IcsSearchForumAdapter.this.isLoadFinished = true;
                        if (IcsSearchForumAdapter.this.mCurrentPage.intValue() == 1) {
                            IcsSearchForumAdapter.this.mNoResultView.setVisibility(0);
                        }
                    } catch (Exception paramAnonymousArrayList) {
                        paramAnonymousArrayList.printStackTrace();
                        paramAnonymousArrayList = IcsSearchForumAdapter.this.mActivity.getResources().getString(2131100069);
                        Toast.makeText(IcsSearchForumAdapter.this.mActivity, paramAnonymousArrayList, 1).show();
                        continue;
                    }
                    IcsSearchForumAdapter.this.notifyDataSetChanged();
                    return;
                    IcsSearchForumAdapter.this.mDatas.addAll(paramAnonymousArrayList);
                    if ((IcsSearchForumAdapter.this.mCurrentPage.intValue() == 1) && (IcsSearchForumAdapter.this.searchAd != null) && (!IcsSearchForumAdapter.this.mDatas.contains(IcsSearchForumAdapter.this.searchAd)) && (IcsSearchForumAdapter.this.searchAd.isAdViewBack)) {
                        IcsSearchForumAdapter.this.mDatas.add(1, IcsSearchForumAdapter.this.searchAd);
                    }
                    paramAnonymousArrayList = IcsSearchForumAdapter.this;
                    paramAnonymousArrayList.mCurrentPage = Integer.valueOf(paramAnonymousArrayList.mCurrentPage.intValue() + 1);
                }
            }
        });
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/adapter/directory/ics/IcsSearchForumAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */