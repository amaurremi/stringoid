package com.quoord.tapatalkpro.activity.forum.feed;

import android.app.ActionBar;
import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.quoord.tapatalkpro.action.AddToFavoriate;
import com.quoord.tapatalkpro.action.AddToFavoriate.AddFavoriate;
import com.quoord.tapatalkpro.activity.forum.DrawerLayoutStatus;
import com.quoord.tapatalkpro.activity.forum.ProfilesOuterFragment;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.bean.RecommondPerson;
import com.quoord.tapatalkpro.bean.TapatalkForum;
import com.quoord.tapatalkpro.bean.Topic;
import com.quoord.tapatalkpro.ics.slidingMenu.SlidingMenuActivity;
import com.quoord.tapatalkpro.ui.ButtomProgress;
import com.quoord.tapatalkpro.ui.GroupBean;
import com.quoord.tapatalkpro.ui.ics.QuoordFragment;
import com.quoord.tapatalkpro.util.ThemeUtil;
import com.quoord.tapatalkpro.util.Util;
import com.quoord.tapatalkpro.view.SectionTitleListView;
import com.quoord.tapatalkpro.view.SectionTitleListView.OnScrollListenerForOtherUse;
import com.quoord.tools.TwoPanelControllerWithId;
import com.quoord.tools.directoryurl.DirectoryUrlUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class ForumFeedFragment
        extends QuoordFragment
        implements AddToFavoriate.AddFavoriate, ExpandableListView.OnChildClickListener, TwoPanelControllerWithId {
    private NewForumFeedAdapter adapter;
    private AddToFavoriate addToForums;
    private ActionBar bar;
    private ForumFeedAction feedAction;
    private int fid;
    private View footProgressView;
    private ForumStatus forumStatus;
    private SectionTitleListView groupTreeView;
    private boolean isCanRefresh = true;
    private boolean isLoadingMore = false;
    public SlidingMenuActivity mActivity;
    private TextView noDataView;
    private int page = 1;

    private void initActionBar() {
        if (this.bar == null) {
            this.bar = this.mActivity.getActionBar();
        }
        this.bar.setNavigationMode(0);
        this.bar.setDisplayShowTitleEnabled(true);
        this.bar.setTitle(getActivity().getString(2131100638));
        this.bar.setSubtitle(null);
    }

    public static ForumFeedFragment newInstance(int paramInt, String paramString) {
        paramString = new ForumFeedFragment();
        paramString.fid = paramInt;
        Bundle localBundle = new Bundle();
        localBundle.putInt("fid", paramInt);
        paramString.setArguments(localBundle);
        return paramString;
    }

    public BaseAdapter getAdapter() {
        return null;
    }

    public void getFeedData(final int paramInt) {
        this.feedAction.getFeeds(DirectoryUrlUtil.getForumFeedTest(getActivity(), new StringBuilder(String.valueOf(this.fid)).toString()) + "&page=" + paramInt, paramInt, new ForumFeedAction.FeedActionCallBack() {
            public void actionCallBack(HashMap<String, ArrayList> paramAnonymousHashMap) {
                if (paramAnonymousHashMap != null) {
                    ForumFeedFragment.this.groupTreeView.removeFooterView(ForumFeedFragment.this.footProgressView);
                    if (paramAnonymousHashMap.containsKey("topics")) {
                        if (!ForumFeedFragment.this.adapter.groupList.contains(ForumFeedFragment.this.adapter.topicGoupBean)) {
                            ForumFeedFragment.this.adapter.groupList.add(ForumFeedFragment.this.adapter.topicGoupBean);
                        }
                        ForumFeedFragment.this.adapter.topicGoupBean.getChildrenList().addAll((Collection) paramAnonymousHashMap.get("topics"));
                    }
                    int i = 0;
                    if (i >= ForumFeedFragment.this.adapter.getGroupCount()) {
                        if (ForumFeedFragment.this.adapter.getGroupCount() <= 0) {
                            break label218;
                        }
                        ForumFeedFragment.this.noDataView.setVisibility(8);
                        ForumFeedFragment.this.groupTreeView.setVisibility(0);
                    }
                    for (; ; ) {
                        ForumFeedFragment.this.isLoadingMore = false;
                        ForumFeedFragment.this.isCanRefresh = true;
                        ForumFeedFragment.this.page = (paramInt + 1);
                        ForumFeedFragment.this.adapter.notifyDataSetChanged();
                        return;
                        ForumFeedFragment.this.groupTreeView.expandGroup(i);
                        i += 1;
                        break;
                        label218:
                        ForumFeedFragment.this.noDataView.setVisibility(0);
                        ForumFeedFragment.this.groupTreeView.setVisibility(8);
                    }
                }
                ForumFeedFragment.this.isCanRefresh = true;
                ForumFeedFragment.this.noDataView.setVisibility(0);
                ForumFeedFragment.this.groupTreeView.setVisibility(8);
            }
        });
    }

    public String getIdByTwoPanel() {
        return null;
    }

    public void onActivityCreated(Bundle paramBundle) {
        super.onActivityCreated(paramBundle);
        this.bar = this.mActivity.getActionBar();
        this.bar.setDisplayShowHomeEnabled(true);
        this.bar.setDisplayShowTitleEnabled(true);
        initActionBar();
        this.feedAction = new ForumFeedAction(this.mActivity);
        this.adapter = new NewForumFeedAdapter(this.mActivity, this.groupTreeView);
        if ((this.mActivity.forumStatus.isLogin()) && (this.addToForums.layout != null)) {
            this.addToForums.layout.setVisibility(8);
        }
        this.groupTreeView.setGroupIndicator(null);
        this.groupTreeView.setHeaderView(getActivity().getLayoutInflater().inflate(2130903356, this.groupTreeView, false));
        this.groupTreeView.setFooterDividersEnabled(true);
        this.footProgressView = ButtomProgress.get(this.mActivity);
        this.groupTreeView.addFooterView(this.footProgressView);
        this.groupTreeView.setOnChildClickListener(this);
        this.groupTreeView.setAdapter(this.adapter);
        getFeedData(this.page);
        this.groupTreeView.setOnScrollListenerForOther(new SectionTitleListView.OnScrollListenerForOtherUse() {
            public void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {
                paramAnonymousInt1 += paramAnonymousInt2;
                if ((paramAnonymousInt1 != 1) && (paramAnonymousInt1 == paramAnonymousInt3) && (!ForumFeedFragment.this.isLoadingMore)) {
                    ForumFeedFragment.this.groupTreeView.addFooterView(ForumFeedFragment.this.footProgressView);
                    ForumFeedFragment.this.getFeedData(ForumFeedFragment.this.page);
                    ForumFeedFragment.this.isLoadingMore = true;
                }
            }

            public void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt) {
            }
        });
    }

    public boolean onChildClick(ExpandableListView paramExpandableListView, View paramView, int paramInt1, int paramInt2, long paramLong) {
        this.adapter.getGroup(paramInt1).equals(this.mActivity.getString(2131100712));
        if (!this.adapter.getGroup(paramInt1).equals(this.mActivity.getString(2131100713))) {
            if ((this.adapter.getChild(paramInt1, paramInt2) instanceof Topic)) {
                ((Topic) this.adapter.getChild(paramInt1, paramInt2)).openThreadAndChangeUnreadNum(this.adapter, this.mActivity, this.mActivity.forumStatus);
            }
            if ((this.adapter.getChild(paramInt1, paramInt2) instanceof RecommondPerson)) {
                paramExpandableListView = (RecommondPerson) this.adapter.getChild(paramInt1, paramInt2);
                paramExpandableListView = ProfilesOuterFragment.newInstance(paramExpandableListView.username, paramExpandableListView.uid, this.mActivity.forumStatus);
                this.mActivity.getActionBar().setDisplayShowTitleEnabled(false);
                this.mActivity.showDetail(paramExpandableListView);
            }
        }
        return false;
    }

    public void onConfigurationChanged(Configuration paramConfiguration) {
    }

    public void onCreate(Bundle paramBundle) {
        this.mActivity = ((SlidingMenuActivity) getActivity());
        this.bar = getActivity().getActionBar();
        if (getArguments().containsKey("fid")) {
            this.fid = getArguments().getInt("fid");
        }
        super.onCreate(paramBundle);
    }

    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        paramViewGroup = paramLayoutInflater.inflate(2130903166, null);
        this.groupTreeView = ((SectionTitleListView) paramViewGroup.findViewById(2131231089));
        this.noDataView = ((TextView) paramViewGroup.findViewById(2131231090));
        this.groupTreeView.setSelector(2131165212);
        this.groupTreeView.setDivider(null);
        this.addToForums = new AddToFavoriate(getActivity(), false);
        if ((this.mActivity.forumStatus != null) && (this.mActivity.forumStatus.tapatalkForum == null)) {
            paramLayoutInflater = this.addToForums.getView(paramViewGroup, this);
        }
        do {
            do {
                do {
                    return paramLayoutInflater;
                    paramLayoutInflater = paramViewGroup;
                } while (this.mActivity.forumStatus == null);
                paramLayoutInflater = paramViewGroup;
            } while (this.mActivity.forumStatus.isLogin());
            paramLayoutInflater = paramViewGroup;
        } while (Util.isFavoriate(getActivity(), this.mActivity.forumStatus.tapatalkForum.getId().intValue()));
        return this.addToForums.getView(paramViewGroup, this);
    }

    public void onHiddenChanged(boolean paramBoolean) {
        super.onHiddenChanged(paramBoolean);
        if (!paramBoolean) {
            initActionBar();
            refresh();
        }
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        if ((paramMenuItem.getItemId() == 1001) && (this.isCanRefresh)) {
            this.isCanRefresh = false;
            if (this.noDataView.getVisibility() == 0) {
                this.noDataView.setVisibility(8);
            }
            this.page = 1;
        }
        try {
            this.adapter.topicGoupBean.clear();
            this.adapter.groupList.clear();
            this.groupTreeView.setVisibility(0);
            this.groupTreeView.setmHeaderViewVisible(false);
            if (this.groupTreeView.getFooterViewsCount() == 0) {
                this.groupTreeView.addFooterView(this.footProgressView);
            }
            this.adapter.notifyDataSetChanged();
            getFeedData(this.page);
            return true;
            return super.onOptionsItemSelected(paramMenuItem);
        } catch (Exception paramMenuItem) {
            for (; ; ) {
            }
        }
    }

    public void onPrepareOptionsMenu(Menu paramMenu) {
        super.onPrepareOptionsMenu(paramMenu);
        if (((getActivity() instanceof DrawerLayoutStatus)) && (((DrawerLayoutStatus) getActivity()).isDrawMenuOpen())) {
            return;
        }
        paramMenu.removeGroup(0);
        paramMenu.add(0, 1001, 1, getString(2131099796)).setIcon(ThemeUtil.getMenuIconByPicName("menu_refresh_new", getActivity())).setShowAsAction(2);
    }

    public void refresh() {
        if (((this.mActivity instanceof SlidingMenuActivity)) && (this.mActivity.isHide_addFavoriate_view) && (this.addToForums != null) && (this.addToForums.layout != null)) {
            this.addToForums.layout.setVisibility(8);
        }
    }

    public void saveFavoriate() {
        Util.saveFavoriate(this.mActivity, this.mActivity.forumStatus.tapatalkForum, this.mActivity.channel, true);
    }

    public void setActionBar(Activity paramActivity) {
        if (this.bar == null) {
            this.bar = getActivity().getActionBar();
        }
        this.bar.setNavigationMode(0);
        this.bar.setDisplayShowTitleEnabled(true);
        this.bar.setTitle(getActivity().getString(2131100638));
        this.bar.setSubtitle(null);
        refresh();
    }

    public void setIdByTwoPanel(String paramString) {
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/activity/forum/feed/ForumFeedFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */