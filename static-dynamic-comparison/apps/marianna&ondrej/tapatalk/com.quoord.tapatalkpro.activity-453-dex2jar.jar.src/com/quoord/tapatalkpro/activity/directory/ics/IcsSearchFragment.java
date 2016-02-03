package com.quoord.tapatalkpro.activity.directory.ics;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.quoord.tapatalkpro.adapter.directory.ics.IcsSearchForumAdapter;
import com.quoord.tapatalkpro.adapter.directory.ics.IcsSearchTopicAdapter;
import com.quoord.tapatalkpro.ui.ics.QuoordFragment;
import com.quoord.tapatalkpro.util.Util;

public class IcsSearchFragment
        extends QuoordFragment {
    public static final int TAB_SEARCH_FORUMS = 0;
    public static final int TAB_SEARCH_TOPICS = 1;
    private String mKeyword;
    private View mMiddleProgressView;
    private View mNoResultView;
    private ListView mResultListView;
    private BaseAdapter mSearchAdapter;
    private int mTabType;

    public static IcsSearchFragment newInstance(String paramString, int paramInt) {
        IcsSearchFragment localIcsSearchFragment = new IcsSearchFragment();
        localIcsSearchFragment.mKeyword = paramString;
        localIcsSearchFragment.mTabType = paramInt;
        return localIcsSearchFragment;
    }

    public void onActivityCreated(Bundle paramBundle) {
        super.onActivityCreated(paramBundle);
        this.mResultListView.setSelector(2131165212);
        this.mResultListView.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent) {
                Util.hideSoftKeyb(IcsSearchFragment.this.getActivity(), paramAnonymousView);
                return false;
            }
        });
        this.mMiddleProgressView.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent) {
                Util.hideSoftKeyb(IcsSearchFragment.this.getActivity(), paramAnonymousView);
                return false;
            }
        });
        this.mNoResultView.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent) {
                Util.hideSoftKeyb(IcsSearchFragment.this.getActivity(), paramAnonymousView);
                return false;
            }
        });
        if (this.mTabType == 0) {
            this.mSearchAdapter = new IcsSearchForumAdapter(getActivity(), this.mKeyword, this.mResultListView, this.mMiddleProgressView, this.mNoResultView);
        }
        for (; ; ) {
            if ((getActivity() instanceof ShowFragmentActivityInter)) {
                ((ShowFragmentActivityInter) getActivity()).actionBar4ShowTitle("defaultTitleString");
            }
            return;
            if (this.mTabType == 1) {
                this.mSearchAdapter = new IcsSearchTopicAdapter(getActivity(), this.mKeyword, this.mResultListView, this.mMiddleProgressView, this.mNoResultView);
            }
        }
    }

    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
    }

    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        paramLayoutInflater = paramLayoutInflater.inflate(2130903201, paramViewGroup, false);
        this.mResultListView = ((ListView) paramLayoutInflater.findViewById(2131231217));
        this.mMiddleProgressView = ((LinearLayout) paramLayoutInflater.findViewById(2131231218));
        this.mNoResultView = ((LinearLayout) paramLayoutInflater.findViewById(2131231219));
        return paramLayoutInflater;
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        switch (paramMenuItem.getItemId()) {
            default:
                return super.onOptionsItemSelected(paramMenuItem);
        }
        return true;
    }

    public void onPrepareOptionsMenu(Menu paramMenu) {
        super.onPrepareOptionsMenu(paramMenu);
    }

    public void onResume() {
        super.onResume();
        if (this.mSearchAdapter != null) {
            this.mSearchAdapter.notifyDataSetChanged();
        }
        Util.hideSoftKeyb(getActivity(), this.mResultListView);
    }

    public void startNewQuery(String paramString) {
        this.mKeyword = paramString;
        if (this.mSearchAdapter != null) {
            if (this.mTabType != 0) {
                break label35;
            }
            ((IcsSearchForumAdapter) this.mSearchAdapter).getSearchForum(this.mKeyword, true);
        }
        label35:
        while (this.mTabType != 1) {
            return;
        }
        ((IcsSearchTopicAdapter) this.mSearchAdapter).getSearchTopic(this.mKeyword, true);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/activity/directory/ics/IcsSearchFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */