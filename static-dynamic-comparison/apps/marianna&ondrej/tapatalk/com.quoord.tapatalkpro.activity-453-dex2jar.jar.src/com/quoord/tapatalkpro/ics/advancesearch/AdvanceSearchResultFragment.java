package com.quoord.tapatalkpro.ics.advancesearch;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.quoord.tapatalkpro.activity.forum.DrawerLayoutStatus;
import com.quoord.tapatalkpro.activity.forum.SearchActivity;
import com.quoord.tapatalkpro.adapter.forum.SearchAdapter;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.bean.Topic;
import com.quoord.tapatalkpro.ics.slidingMenu.SlidingMenuActivity;
import com.quoord.tapatalkpro.ui.ButtomProgress;
import com.quoord.tapatalkpro.ui.ics.QuoordFragment;
import com.quoord.tapatalkpro.util.AdvancesearchContrast;
import com.quoord.tapatalkpro.util.ThemeUtil;
import com.quoord.tools.TwoPanelController;

public class AdvanceSearchResultFragment
        extends QuoordFragment
        implements TwoPanelController {
    private ActionBar bar;
    private boolean byPost = false;
    private AdvancesearchContrast constast = null;
    private LinearLayout footlay;
    private ForumStatus forumStatus = null;
    public ListView listView = null;
    private Activity mActivity;
    private View resultLayout = null;
    private SearchAdapter searchAdapter;
    private String searchTitle = null;

    public static AdvanceSearchResultFragment newInstance(ForumStatus paramForumStatus, AdvancesearchContrast paramAdvancesearchContrast) {
        AdvanceSearchResultFragment localAdvanceSearchResultFragment = new AdvanceSearchResultFragment();
        localAdvanceSearchResultFragment.forumStatus = paramForumStatus;
        localAdvanceSearchResultFragment.constast = paramAdvancesearchContrast;
        return localAdvanceSearchResultFragment;
    }

    public BaseAdapter getAdapter() {
        return this.searchAdapter;
    }

    public Object getItem(int paramInt) {
        if ((this.listView.getAdapter().getItem(paramInt) instanceof Topic)) {
            return this.searchAdapter.getItem(paramInt);
        }
        return "";
    }

    public void onActivityCreated(Bundle paramBundle) {
        super.onActivityCreated(paramBundle);
        this.mActivity = getActivity();
        this.bar = this.mActivity.getActionBar();
        this.bar.setDisplayShowHomeEnabled(true);
        this.bar.setDisplayShowTitleEnabled(true);
        this.footlay = ButtomProgress.get(this.mActivity);
        this.listView.addFooterView(this.footlay);
        this.listView.setDivider(null);
        this.listView.setSelector(2131165212);
        if (this.constast != null) {
            this.byPost = this.constast.SHOWPOSTS;
        }
        if ((this.forumStatus != null) && (this.constast != null)) {
            this.searchAdapter = new SearchAdapter(this.mActivity, this.forumStatus.getUrl(), this.constast, this);
            this.listView.setAdapter(this.searchAdapter);
        }
        if ((this.constast != null) && (!this.constast.KEYWORD.equals(""))) {
            this.searchTitle = this.constast.KEYWORD;
        }
        if (this.searchTitle != null) {
            this.bar.setTitle(this.searchTitle);
        }
        for (; ; ) {
            AdvanceSearchHistoryFragment.isFromResultFragment = true;
            setOnclick();
            return;
            this.bar.setTitle(2131100129);
        }
    }

    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        this.resultLayout = paramLayoutInflater.inflate(2130903057, null);
        this.listView = ((ListView) this.resultLayout.findViewById(2131230807));
        return this.resultLayout;
    }

    public void onHiddenChanged(boolean paramBoolean) {
        super.onHiddenChanged(paramBoolean);
        this.bar.setDisplayShowTitleEnabled(true);
        if ((!paramBoolean) && (this.searchTitle != null)) {
            this.bar.setTitle(this.searchTitle);
            this.bar.setSubtitle(null);
            return;
        }
        this.bar.setTitle(2131100129);
        this.bar.setSubtitle(null);
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        switch (paramMenuItem.getItemId()) {
            default:
                return super.onOptionsItemSelected(paramMenuItem);
            case 1082:
                setAdvanceOnclick();
                return true;
        }
        getActivity().finish();
        return true;
    }

    public void onPrepareOptionsMenu(Menu paramMenu) {
        super.onPrepareOptionsMenu(paramMenu);
        paramMenu.removeGroup(0);
        if (((getActivity() instanceof DrawerLayoutStatus)) && (((DrawerLayoutStatus) getActivity()).isDrawMenuOpen())) {
        }
        while ((this.forumStatus == null) || (!this.forumStatus.isAdvancedSearch())) {
            return;
        }
        paramMenu = paramMenu.add(0, 1082, 0, getString(2131100136));
        paramMenu.setIcon(ThemeUtil.getMenuIconByPicName("filter_icon", getActivity()));
        paramMenu.setShowAsAction(1);
    }

    public void refresh() {
        if (this.byPost) {
            if (this.listView.getFooterViewsCount() == 0) {
                this.listView.addFooterView(this.footlay);
            }
            this.searchAdapter.refresh();
            return;
        }
        if (this.listView.getFooterViewsCount() == 0) {
            this.listView.addFooterView(this.footlay);
        }
        this.searchAdapter.refresh();
    }

    public void removeListFootLay() {
        if (this.listView.getFooterViewsCount() > 0) {
            this.listView.removeFooterView(this.footlay);
        }
    }

    public void setActionBar(Activity paramActivity) {
        if (this.bar == null) {
            this.bar = paramActivity.getActionBar();
        }
        this.bar.setNavigationMode(0);
        this.bar.setDisplayShowTitleEnabled(true);
        if (this.searchTitle != null) {
            this.bar.setTitle(this.searchTitle);
            return;
        }
        this.bar.setTitle(2131100129);
    }

    public void setAdvanceOnclick() {
        AdvanceSearchFragment localAdvanceSearchFragment = AdvanceSearchFragment.newInstance(this.forumStatus, "", this.constast);
        if ((getActivity() instanceof SlidingMenuActivity)) {
            ((SlidingMenuActivity) getActivity()).addFragmentToStack(localAdvanceSearchFragment, "advance_fragment_stack_tag", true);
        }
        do {
            return;
            if ((getActivity() instanceof AdvanceSearchActivity)) {
                ((AdvanceSearchActivity) getActivity()).addFragmentToStack(localAdvanceSearchFragment, "advance_fragment_stack_tag", true);
                return;
            }
        } while (!(getActivity() instanceof SearchActivity));
        ((SearchActivity) this.mActivity).addFragmentToStack(localAdvanceSearchFragment, "advance_fragment_stack_tag", true);
    }

    public void setOnclick() {
        this.listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            public void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {
                if ((paramAnonymousInt1 + paramAnonymousInt2 == paramAnonymousInt3) && (AdvanceSearchResultFragment.this.searchAdapter != null) && (!AdvanceSearchResultFragment.this.searchAdapter.loadingMore) && (AdvanceSearchResultFragment.this.searchAdapter.isFootNeeded()) && (AdvanceSearchResultFragment.this.searchAdapter.getCount() != 0)) {
                    AdvanceSearchResultFragment.this.listView.addFooterView(AdvanceSearchResultFragment.this.footlay);
                    if (AdvanceSearchResultFragment.this.forumStatus.isAdvancedSearch()) {
                        AdvanceSearchResultFragment.this.searchAdapter.getSearchTopicAdvance();
                    }
                } else {
                    return;
                }
                AdvanceSearchResultFragment.this.searchAdapter.getSearchTopic();
            }

            public void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt) {
            }
        });
        this.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong) {
                if ((AdvanceSearchResultFragment.this.getItem(paramAnonymousInt) instanceof Topic)) {
                    if (AdvanceSearchResultFragment.this.byPost) {
                        break label74;
                    }
                    ((Topic) AdvanceSearchResultFragment.this.getItem(paramAnonymousInt)).openThread(AdvanceSearchResultFragment.this.mActivity, AdvanceSearchResultFragment.this.forumStatus);
                }
                for (; ; ) {
                    AdvanceSearchResultFragment.this.searchAdapter.currentSelectedPosition = paramAnonymousInt;
                    AdvanceSearchResultFragment.this.searchAdapter.notifyDataSetChanged();
                    return;
                    label74:
                    ((Topic) AdvanceSearchResultFragment.this.getItem(paramAnonymousInt)).openThreadByPost(AdvanceSearchResultFragment.this.mActivity, AdvanceSearchResultFragment.this.forumStatus);
                }
            }
        });
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/ics/advancesearch/AdvanceSearchResultFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */