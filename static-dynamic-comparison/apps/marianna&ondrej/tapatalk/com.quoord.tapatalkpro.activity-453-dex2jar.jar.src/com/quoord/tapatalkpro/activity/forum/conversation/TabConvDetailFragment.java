package com.quoord.tapatalkpro.activity.forum.conversation;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.quoord.tapatalkpro.adapter.forum.conversation.ConvController;
import com.quoord.tapatalkpro.adapter.forum.conversation.ConvDetailAdapter;
import com.quoord.tapatalkpro.adapter.forum.conversation.ConvPagerAdapter;
import com.quoord.tapatalkpro.bean.Conversation;
import com.quoord.tapatalkpro.bean.ConversationData;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.ics.slidingMenu.SlidingMenuActivity;
import com.quoord.tapatalkpro.ui.ConversationQuoteHelper;
import com.quoord.tapatalkpro.ui.ics.QuoordFragment;

import java.util.ArrayList;
import java.util.HashMap;

public class TabConvDetailFragment
        extends QuoordFragment {
    public AlertDialog ad = null;
    Conversation conv;
    private ConversationOuterFragment convOuterFragment;
    public int detailFragment_CurrentPage;
    private ForumStatus forumStatus;
    private boolean isFirstTag;
    public ListView listview = null;
    public LinearLayout progress;
    public ConvDetailAdapter tabConvDetailAdapter = null;

    private void initPageView() {
        if ((this.tabConvDetailAdapter == null) && (this.forumStatus != null)) {
            this.tabConvDetailAdapter = new ConvDetailAdapter(this.forumStatus.getUrl(), this.conv, this.convOuterFragment, this, this.isFirstTag, this.detailFragment_CurrentPage);
            this.listview.setAdapter(this.tabConvDetailAdapter);
        }
        for (; ; ) {
            this.listview.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                public boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong) {
                    if ((TabConvDetailFragment.this.convOuterFragment != null) && (TabConvDetailFragment.this.convOuterFragment.quoteHelper != null)) {
                        TabConvDetailFragment.this.convOuterFragment.quoteHelper.actionMulti(TabConvDetailFragment.this.forumStatus, (ConversationData) TabConvDetailFragment.this.tabConvDetailAdapter.getItem(paramAnonymousInt));
                    }
                    return false;
                }
            });
            this.listview.setOnScrollListener(new AbsListView.OnScrollListener() {
                public void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {
                    if (paramAnonymousInt1 != TabConvDetailFragment.this.tabConvDetailAdapter.currentIndex) {
                        TabConvDetailFragment.this.tabConvDetailAdapter.currentIndex = paramAnonymousInt1;
                    }
                }

                public void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt) {
                    int j = 0;
                    int i = j;
                    if (paramAnonymousInt != 2) {
                        i = j;
                        if (TabConvDetailFragment.this.tabConvDetailAdapter.currentScrollState == 2) {
                            i = 1;
                        }
                    }
                    j = i;
                    if (paramAnonymousInt == 0) {
                        j = i;
                        if (TabConvDetailFragment.this.tabConvDetailAdapter.currentScrollState == 1) {
                            j = 1;
                        }
                    }
                    TabConvDetailFragment.this.tabConvDetailAdapter.currentScrollState = paramAnonymousInt;
                    if (j != 0) {
                        TabConvDetailFragment.this.tabConvDetailAdapter.notifyDataSetChanged();
                    }
                    if (paramAnonymousInt != 2) {
                        TabConvDetailFragment.this.tabConvDetailAdapter.checkImages();
                        TabConvDetailFragment.this.tabConvDetailAdapter.notifyDataSetChanged();
                    }
                }
            });
            if ((this.isFirstTag) || (this.detailFragment_CurrentPage == this.convOuterFragment.getCurrentPageNum())) {
                this.listview.setAdapter(this.tabConvDetailAdapter);
                this.listview.setSelection(this.convOuterFragment.getJumpToPosition());
                getActivity().invalidateOptionsMenu();
            }
            return;
            this.listview.setAdapter(this.tabConvDetailAdapter);
            if ((((TabConvDetailFragment) this.convOuterFragment.pagerAdapter.mPageReferenceConvMap.get(Integer.valueOf(this.detailFragment_CurrentPage))).progress != null) && (((TabConvDetailFragment) this.convOuterFragment.pagerAdapter.mPageReferenceConvMap.get(Integer.valueOf(this.detailFragment_CurrentPage))).progress.getVisibility() == 0)) {
                ((TabConvDetailFragment) this.convOuterFragment.pagerAdapter.mPageReferenceConvMap.get(Integer.valueOf(this.detailFragment_CurrentPage))).progress.setVisibility(8);
            }
        }
    }

    public static TabConvDetailFragment newInstance(int paramInt, boolean paramBoolean) {
        TabConvDetailFragment localTabConvDetailFragment = new TabConvDetailFragment();
        localTabConvDetailFragment.detailFragment_CurrentPage = paramInt;
        localTabConvDetailFragment.isFirstTag = paramBoolean;
        Bundle localBundle = new Bundle();
        localBundle.putInt("currentPage", paramInt);
        localBundle.putBoolean("isFirstTag", paramBoolean);
        localTabConvDetailFragment.setArguments(localBundle);
        return localTabConvDetailFragment;
    }

    public static TabConvDetailFragment newInstance(boolean paramBoolean) {
        TabConvDetailFragment localTabConvDetailFragment = new TabConvDetailFragment();
        localTabConvDetailFragment.isFirstTag = paramBoolean;
        Bundle localBundle = new Bundle();
        localBundle.putBoolean("isFirstTag", paramBoolean);
        localTabConvDetailFragment.setArguments(localBundle);
        return localTabConvDetailFragment;
    }

    public void getConversation() {
        this.tabConvDetailAdapter.getConversationDetail(0);
    }

    public int getCurrentPage() {
        return this.detailFragment_CurrentPage;
    }

    public void getPageData(final int paramInt) {
        new Handler().postDelayed(new Runnable() {
            public void run() {
                try {
                    TabConvDetailFragment.this.tabConvDetailAdapter = ((TabConvDetailFragment) TabConvDetailFragment.this.convOuterFragment.pagerAdapter.mPageReferenceConvMap.get(Integer.valueOf(paramInt))).tabConvDetailAdapter;
                    if (TabConvDetailFragment.this.tabConvDetailAdapter.mDatas.size() <= 0) {
                        TabConvDetailFragment.this.tabConvDetailAdapter.converId.clear();
                        TabConvDetailFragment.this.tabConvDetailAdapter.getConversationDetail(paramInt);
                        TabConvDetailFragment.this.listview.setAdapter(TabConvDetailFragment.this.tabConvDetailAdapter);
                        TabConvDetailFragment.this.listview.setSelection(TabConvDetailFragment.this.convOuterFragment.getJumpToPosition());
                    }
                    TabConvDetailFragment.this.getActivity().invalidateOptionsMenu();
                    return;
                } catch (Exception localException) {
                }
            }
        }, 300L);
    }

    public void onActivityCreated(Bundle paramBundle) {
        super.onActivityCreated(paramBundle);
        paramBundle = getActivity().getActionBar();
        paramBundle.setDisplayHomeAsUpEnabled(true);
        paramBundle.setDisplayShowHomeEnabled(true);
        if ((getActivity() instanceof ConverSationActivity)) {
        }
        for (this.convOuterFragment = ((ConverSationActivity) getActivity()).convsationFragment; ; this.convOuterFragment = ((ConversationOuterFragment) ((SlidingMenuActivity) getActivity()).getOuterFragment())) {
            if (this.convOuterFragment != null) {
                this.forumStatus = this.convOuterFragment.forumStatus;
                this.conv = this.convOuterFragment.conversation;
                if ((this.convOuterFragment.mConvController != null) && (this.convOuterFragment.mConvController.getPageNum() > 1)) {
                    this.progress.setVisibility(8);
                }
                if (this.convOuterFragment.mPager != null) {
                    this.convOuterFragment.mPager.setOffscreenPageLimit(2);
                }
                initPageView();
            }
            getActivity().invalidateOptionsMenu();
            return;
        }
    }

    public void onCreate(Bundle paramBundle) {
        getActivity().getActionBar().setDisplayShowTitleEnabled(false);
        super.onCreate(paramBundle);
        if ((getArguments() != null) && (getArguments().containsKey("currentPage"))) {
            this.detailFragment_CurrentPage = getArguments().getInt("currentPage");
        }
    }

    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        paramLayoutInflater = paramLayoutInflater.inflate(2130903114, null);
        this.progress = ((LinearLayout) paramLayoutInflater.findViewById(2131230891));
        this.listview = ((ListView) paramLayoutInflater.findViewById(2131230759));
        this.listview.setDivider(null);
        this.listview.setSelector(2131165212);
        return paramLayoutInflater;
    }

    public void updateTitle(int paramInt1, int paramInt2, int paramInt3) {
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/activity/forum/conversation/TabConvDetailFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */