package com.quoord.tapatalkpro.activity.forum;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.SearchView.OnCloseListener;
import android.widget.SearchView.OnQueryTextListener;
import com.quoord.tapatalkpro.adapter.forum.ThreadAdapter;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.bean.PostData;
import com.quoord.tapatalkpro.bean.ThreadFootView;
import com.quoord.tapatalkpro.bean.ThreadHeaderView;
import com.quoord.tapatalkpro.bean.Topic;
import com.quoord.tapatalkpro.ics.slidingMenu.SettingsFragment;
import com.quoord.tapatalkpro.ui.ThreadQuoteHelper;
import com.quoord.tapatalkpro.ui.ics.QuoordFragment;
import com.quoord.tapatalkpro.util.AdvancesearchContrast;
import com.quoord.tools.TwoPanelOutController;

import java.util.ArrayList;
import java.util.HashMap;

public class ThreadFragment
        extends QuoordFragment
        implements SearchView.OnQueryTextListener, SearchView.OnCloseListener {
    public static int MAX_PROGRESS = 100;
    public int currentPage;
    private boolean isFirstTag;
    public SearchView mSearchView;
    public ThreadAdapter mThreadAdapter;
    private ThreadOuterFragment outerFragment;
    private String threadId;
    public ListView threadList;
    public View threadView = null;

    private ThreadOuterFragment getOutFragment() {
        if ((getActivity() instanceof TwoPanelOutController)) {
            return (ThreadOuterFragment) ((TwoPanelOutController) getActivity()).getOuterFragment();
        }
        return null;
    }

    private void initPageView() {
        if ((this.mThreadAdapter == null) && (this.outerFragment != null) && (this.outerFragment.activity != null)) {
            this.mThreadAdapter = new ThreadAdapter(this.outerFragment, this.outerFragment.forumStatus.getUrl(), this.outerFragment.mReplyCount, this.outerFragment.isNew, this.outerFragment.isAnn, this.outerFragment.mTopic, this.currentPage, this.isFirstTag, this);
        }
        this.threadList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong) {
                ThreadFragment.this.mThreadAdapter.mFocusItemPosition = paramAnonymousInt;
                ThreadFragment.this.mThreadAdapter.setmLongclickItemPosition(paramAnonymousInt);
                if ((ThreadFragment.this.mThreadAdapter.getItem(paramAnonymousInt) == null) || ((ThreadFragment.this.mThreadAdapter.getItem(paramAnonymousInt) instanceof ThreadHeaderView)) || ((ThreadFragment.this.mThreadAdapter.getItem(paramAnonymousInt) instanceof ThreadFootView))) {
                }
                do {
                    do {
                        return;
                    } while (!(ThreadFragment.this.mThreadAdapter.getItem(paramAnonymousInt) instanceof HashMap));
                    if ((ThreadFragment.this.outerFragment.quoteHelper.multiQuoteIds != null) && (ThreadFragment.this.outerFragment.quoteHelper.multiQuoteIds.size() > 0)) {
                        ThreadFragment.this.outerFragment.quoteHelper.actionMulti(ThreadFragment.this.mThreadAdapter.forumStatus, ThreadFragment.this.mThreadAdapter.getPost(paramAnonymousInt));
                        return;
                    }
                }
                while ((ThreadFragment.this.mThreadAdapter.forumStatus == null) || (ThreadFragment.this.mThreadAdapter.getPost(paramAnonymousInt) == null) || (!ThreadFragment.this.mThreadAdapter.forumStatus.isLogin()));
                ThreadFragment.this.mThreadAdapter.getPost(paramAnonymousInt).showQuickAction(ThreadFragment.this.outerFragment.mThreadAdapter.forumStatus, paramAnonymousInt);
            }
        });
        this.threadList.setOnScrollListener(new AbsListView.OnScrollListener() {
            public void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {
                if (paramAnonymousInt1 != ThreadFragment.this.mThreadAdapter.currentIndex) {
                    ThreadFragment.this.mThreadAdapter.checkImages();
                    ThreadFragment.this.mThreadAdapter.currentIndex = paramAnonymousInt1;
                }
            }

            public void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt) {
                int j = 0;
                int i = j;
                if (paramAnonymousInt != 2) {
                    i = j;
                    if (ThreadFragment.this.mThreadAdapter.currentScrollState == 2) {
                        i = 1;
                    }
                }
                j = i;
                if (paramAnonymousInt == 0) {
                    j = i;
                    if (ThreadFragment.this.mThreadAdapter.currentScrollState == 1) {
                        j = 1;
                    }
                }
                ThreadFragment.this.mThreadAdapter.currentScrollState = paramAnonymousInt;
                if (j != 0) {
                    ThreadFragment.this.mThreadAdapter.notifyDataSetChanged();
                }
                if (paramAnonymousInt != 2) {
                    ThreadFragment.this.mThreadAdapter.checkImages();
                    ThreadFragment.this.mThreadAdapter.notifyDataSetChanged();
                }
            }
        });
        if ((this.isFirstTag) || (this.currentPage == this.outerFragment.getCurrentPageNum())) {
            this.threadList.setAdapter(this.mThreadAdapter);
            this.isFirstTag = false;
            this.threadList.setSelection(this.outerFragment.getJumpToPosition());
            getActivity().invalidateOptionsMenu();
        }
    }

    public static ThreadFragment newInstance(int paramInt, boolean paramBoolean) {
        ThreadFragment localThreadFragment = new ThreadFragment();
        localThreadFragment.currentPage = paramInt;
        localThreadFragment.isFirstTag = paramBoolean;
        Bundle localBundle = new Bundle();
        localBundle.putInt("currentPage", paramInt);
        localBundle.putBoolean("isFirstTag", paramBoolean);
        localThreadFragment.setArguments(localBundle);
        return localThreadFragment;
    }

    public static ThreadFragment newInstance(boolean paramBoolean) {
        ThreadFragment localThreadFragment = new ThreadFragment();
        localThreadFragment.isFirstTag = paramBoolean;
        Bundle localBundle = new Bundle();
        localBundle.putBoolean("isFirstTag", paramBoolean);
        localThreadFragment.setArguments(localBundle);
        return localThreadFragment;
    }

    public int getCurrentPage() {
        return this.currentPage;
    }

    public void getPageData() {
        try {
            this.mThreadAdapter.getThreadByPage(this.currentPage, false);
            this.threadList.setAdapter(this.mThreadAdapter);
            this.outerFragment.activity.invalidateOptionsMenu();
            return;
        } catch (Exception localException) {
        }
    }

    public void onActivityCreated(Bundle paramBundle) {
        super.onActivityCreated(paramBundle);
        this.outerFragment = getOutFragment();
        if ((this.outerFragment != null) && (this.outerFragment.activity == null)) {
            this.outerFragment.removeDetail();
        }
        if ((this.outerFragment != null) && (this.outerFragment.forumStatus != null) && (this.outerFragment.activity != null)) {
        }
        try {
            if (SettingsFragment.isLightTheme(getActivity())) {
                getView().setBackgroundResource(2131165503);
            }
            this.threadList.setSelector(2131165212);
            this.threadList.setDivider(null);
            this.threadId = this.outerFragment.mTopic.getId();
            initPageView();
            return;
        } catch (Exception paramBundle) {
            for (; ; ) {
            }
        }
    }

    public boolean onClose() {
        return false;
    }

    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        if (getArguments().containsKey("currentPage")) {
            this.currentPage = getArguments().getInt("currentPage");
        }
    }

    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        paramLayoutInflater = paramLayoutInflater.inflate(2130903403, paramViewGroup, false);
        this.threadList = ((ListView) paramLayoutInflater.findViewById(2131230759));
        return paramLayoutInflater;
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.mThreadAdapter != null) {
            this.mThreadAdapter.destroy();
        }
    }

    public boolean onQueryTextChange(String paramString) {
        return false;
    }

    public boolean onQueryTextSubmit(String paramString) {
        if ((paramString != null) && (!paramString.equals(""))) {
            queryResult(paramString);
        }
        if (this.mSearchView != null) {
            ((InputMethodManager) this.outerFragment.activity.getSystemService("input_method")).hideSoftInputFromWindow(this.mSearchView.getWindowToken(), 0);
            this.mSearchView.clearFocus();
        }
        return true;
    }

    public void onResume() {
        super.onResume();
        if (this.mThreadAdapter != null) {
            this.mThreadAdapter.notifyDataSetChanged();
        }
        if ((this.outerFragment != null) && (this.outerFragment.quoteHelper != null)) {
            this.outerFragment.quoteHelper.setFirst(true);
        }
    }

    public void queryResult(String paramString) {
        AdvancesearchContrast localAdvancesearchContrast = new AdvancesearchContrast();
        localAdvancesearchContrast.KEYWORD = paramString.trim();
        localAdvancesearchContrast.THREADID = this.threadId;
        localAdvancesearchContrast.SHOWPOSTS = true;
        paramString = new Intent(this.outerFragment.activity, SearchActivity.class);
        Bundle localBundle = new Bundle();
        localBundle.putSerializable("contrast", localAdvancesearchContrast);
        localBundle.putSerializable("forumStatus", this.outerFragment.forumStatus);
        paramString.putExtras(localBundle);
        this.outerFragment.activity.startActivity(paramString);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/activity/forum/ThreadFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */