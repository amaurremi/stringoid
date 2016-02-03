package com.quoord.tapatalkpro.activity.forum;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.quoord.tapatalkpro.adapter.forum.SearchAdapter;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.bean.Topic;
import com.quoord.tapatalkpro.ics.advancesearch.AdvanceSearchFragment;
import com.quoord.tapatalkpro.ui.ButtomProgress;
import com.quoord.tapatalkpro.ui.ics.QuoordFragment;
import com.quoord.tapatalkpro.util.AdvancesearchContrast;
import com.quoord.tapatalkpro.util.BroadcastControl;
import com.quoord.tapatalkpro.util.ThemeUtil;

public class SearchFragment
        extends QuoordFragment
        implements AdapterView.OnItemClickListener {
    private BroadcastControl broadcastControl;
    private AdvancesearchContrast contrast;
    public LinearLayout footlay;
    private ForumStatus forumStatus;
    public ListView listView;
    private Activity mActivity;
    private SearchAdapter searchAdapter;

    public static SearchFragment newInstance(ForumStatus paramForumStatus, AdvancesearchContrast paramAdvancesearchContrast) {
        SearchFragment localSearchFragment = new SearchFragment();
        localSearchFragment.forumStatus = paramForumStatus;
        localSearchFragment.contrast = paramAdvancesearchContrast;
        return localSearchFragment;
    }

    public void onActivityCreated(Bundle paramBundle) {
        super.onActivityCreated(paramBundle);
        this.mActivity = getActivity();
        registBroad();
        paramBundle = this.mActivity.getActionBar();
        paramBundle.setDisplayHomeAsUpEnabled(true);
        paramBundle.setDisplayShowHomeEnabled(true);
        if (this.contrast != null) {
            if ((this.contrast.FORUMNAME != null) && (!this.contrast.FORUMNAME.equals(""))) {
                paramBundle.setTitle(this.mActivity.getString(2131100122) + this.contrast.FORUMNAME);
            }
        }
        for (; ; ) {
            this.footlay = ButtomProgress.get(this.mActivity);
            this.listView.addFooterView(this.footlay);
            if ((this.forumStatus != null) && (this.contrast != null)) {
                this.searchAdapter = new SearchAdapter(this.mActivity, this.forumStatus.getUrl(), this.contrast, null);
            }
            this.listView.setAdapter(this.searchAdapter);
            this.listView.setOnItemClickListener(this);
            this.listView.setOnScrollListener(new AbsListView.OnScrollListener() {
                public void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {
                    if ((paramAnonymousInt1 + paramAnonymousInt2 == paramAnonymousInt3) && (SearchFragment.this.searchAdapter != null) && (!SearchFragment.this.searchAdapter.loadingMore) && (SearchFragment.this.searchAdapter.isFootNeeded()) && (SearchFragment.this.searchAdapter.getCount() != 0)) {
                        SearchFragment.this.listView.addFooterView(SearchFragment.this.footlay);
                        if (SearchFragment.this.forumStatus.isAdvancedSearch()) {
                            SearchFragment.this.searchAdapter.getSearchTopicAdvance();
                        }
                    } else {
                        return;
                    }
                    SearchFragment.this.searchAdapter.getSearchTopic();
                }

                public void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt) {
                }
            });
            return;
            if ((this.contrast.KEYWORD != null) && (!this.contrast.KEYWORD.equals(""))) {
                paramBundle.setTitle(this.contrast.KEYWORD);
            } else {
                paramBundle.setTitle(2131100121);
                continue;
                paramBundle.setTitle(2131100121);
            }
        }
    }

    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        paramLayoutInflater = paramLayoutInflater.inflate(2130903349, null);
        this.listView = ((ListView) paramLayoutInflater.findViewById(2131231587));
        this.listView.setDivider(null);
        this.listView.setSelector(2131165212);
        return paramLayoutInflater;
    }

    public void onDestroy() {
        this.broadcastControl.unregistBroad();
        super.onDestroy();
    }

    public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {
        if ((this.searchAdapter != null) && ((this.searchAdapter.getItem(paramInt) instanceof Topic))) {
            if (this.contrast.SHOWPOSTS) {
                break label62;
            }
            ((Topic) this.searchAdapter.getItem(paramInt)).openThread(this.mActivity, this.forumStatus);
        }
        for (; ; ) {
            this.searchAdapter.currentSelectedPosition = paramInt;
            return;
            label62:
            ((Topic) this.searchAdapter.getItem(paramInt)).openThreadByPost(this.mActivity, this.forumStatus);
        }
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        switch (paramMenuItem.getItemId()) {
            default:
                return super.onOptionsItemSelected(paramMenuItem);
        }
        setAdvanceOnclick();
        return true;
    }

    public void onPrepareOptionsMenu(Menu paramMenu) {
        super.onPrepareOptionsMenu(paramMenu);
        paramMenu.removeGroup(0);
        if ((this.forumStatus != null) && (this.forumStatus.isAdvancedSearch())) {
            paramMenu = paramMenu.add(0, 1082, 0, getString(2131100136));
            paramMenu.setIcon(ThemeUtil.getMenuIconByPicName("filter_icon", getActivity()));
            paramMenu.setShowAsAction(1);
        }
    }

    public void registBroad() {
        this.broadcastControl = new BroadcastControl(this.mActivity, this.mActivity);
        this.broadcastControl.registBroad(BroadcastControl.FINISH_ACTIVITY);
    }

    public void setAdvanceOnclick() {
        AdvanceSearchFragment localAdvanceSearchFragment = AdvanceSearchFragment.newInstance(this.forumStatus, "", this.contrast);
        if ((getActivity() instanceof SearchActivity)) {
            ((SearchActivity) this.mActivity).addFragmentToStack(localAdvanceSearchFragment, "advance_fragment_stack_tag", true);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/activity/forum/SearchFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */