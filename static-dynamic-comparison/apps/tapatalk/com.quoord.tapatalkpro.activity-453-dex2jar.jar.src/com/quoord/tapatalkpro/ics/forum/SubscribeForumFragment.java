package com.quoord.tapatalkpro.ics.forum;

import android.app.ActionBar;
import android.app.ActionBar.OnNavigationListener;
import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import com.quoord.tapatalkpro.activity.forum.DrawerLayoutStatus;
import com.quoord.tapatalkpro.adapter.forum.NewSubscribeForumAndTopicAdapter;
import com.quoord.tapatalkpro.adapter.forum.conversation.SubscribeTitleAdapter;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.ics.BaseListFragment;
import com.quoord.tapatalkpro.ics.slidingMenu.SlidingMenuActivity;
import com.quoord.tapatalkpro.util.ThemeUtil;
import com.quoord.tapatalkpro.view.SectionTitleListView;
import com.quoord.tools.TwoPanelControllerWithId;

import java.util.ArrayList;

public class SubscribeForumFragment
        extends BaseListFragment
        implements TwoPanelControllerWithId {
    public NewSubscribeForumAndTopicAdapter adapter2;
    private ActionBar bar;
    private boolean isUnread;
    private SectionTitleListView listview;
    private LinearLayout subsLayout;
    final ArrayList<String> titleDatas = new ArrayList();
    private String topicId;

    private void initDropDownList() {
        this.titleDatas.add(getActivity().getResources().getString(2131100547));
        this.titleDatas.add(getActivity().getResources().getString(2131100548));
    }

    public static SubscribeForumFragment newInstance() {
        return new SubscribeForumFragment();
    }

    public BaseAdapter getAdapter() {
        return null;
    }

    public String getIdByTwoPanel() {
        return this.topicId;
    }

    public void initDropDown() {
        this.bar.setListNavigationCallbacks(new SubscribeTitleAdapter(getActivity(), this.titleDatas), new ActionBar.OnNavigationListener() {
            public boolean onNavigationItemSelected(int paramAnonymousInt, long paramAnonymousLong) {
                if ((SubscribeForumFragment.this.getActivity() instanceof DrawerLayoutStatus)) {
                    ((DrawerLayoutStatus) SubscribeForumFragment.this.getActivity()).closeDrawerLay();
                }
                if (paramAnonymousInt == 0) {
                    SubscribeForumFragment.this.isUnread = false;
                }
                for (; ; ) {
                    if (SubscribeForumFragment.this.adapter2 != null) {
                        SubscribeForumFragment.this.adapter2.getUnreadSubcribe(SubscribeForumFragment.this.isUnread);
                    }
                    return true;
                    if (paramAnonymousInt == 1) {
                        SubscribeForumFragment.this.isUnread = true;
                    }
                }
            }
        });
    }

    public void onActivityCreated(Bundle paramBundle) {
        super.onActivityCreated(paramBundle);
        this.mActivity = getActivity();
        this.forumstatus = ((SlidingMenuActivity) getActivity()).forumStatus;
        this.bar = getActivity().getActionBar();
        setActionBarTitle();
        this.listview.setGroupIndicator(null);
        this.listview.setHeaderView(this.mActivity.getLayoutInflater().inflate(2130903356, this.listview, false));
        if ((this.forumstatus != null) && (this.forumstatus.isLogin())) {
            this.adapter2 = new NewSubscribeForumAndTopicAdapter(this.subsLayout, "subscribe_forum_statck_tag", this.forumstatus.getUrl(), this.forumstatus, this.mActivity, this.listview, this);
        }
        initDropDownList();
        setActionBarTitle();
    }

    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        setHasOptionsMenu(true);
    }

    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        paramLayoutInflater = paramLayoutInflater.inflate(2130903190, paramViewGroup, false);
        this.subsLayout = ((LinearLayout) paramLayoutInflater.findViewById(2131231182));
        this.listview = ((SectionTitleListView) paramLayoutInflater.findViewById(2131231181));
        this.listview.setDivider(null);
        this.listview.setSelector(2131165212);
        return paramLayoutInflater;
    }

    public void onHiddenChanged(boolean paramBoolean) {
        super.onHiddenChanged(paramBoolean);
        if (!paramBoolean) {
            setActionBarTitle();
        }
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        switch (paramMenuItem.getItemId()) {
        }
        do {
            return super.onOptionsItemSelected(paramMenuItem);
        } while (this.adapter2 == null);
        this.adapter2.refresh();
        ((SlidingMenuActivity) getActivity()).getUnreadNumbers();
        return true;
    }

    public void onPrepareOptionsMenu(Menu paramMenu) {
        super.onPrepareOptionsMenu(paramMenu);
        if (((getActivity() instanceof DrawerLayoutStatus)) && (((DrawerLayoutStatus) getActivity()).isDrawMenuOpen())) {
            return;
        }
        paramMenu.add(0, 1001, 1, getString(2131099796)).setIcon(ThemeUtil.getMenuIconByPicName("menu_refresh_new", getActivity())).setShowAsAction(9);
    }

    public void onResume() {
        super.onResume();
        if (this.adapter2 != null) {
            this.adapter2.notifyDataSetChanged();
        }
    }

    public void setActionBar(Activity paramActivity) {
        if (this.bar == null) {
            this.bar = paramActivity.getActionBar();
        }
        setActionBarTitle();
        getActivity().invalidateOptionsMenu();
    }

    public void setActionBarTitle() {
        this.bar.setDisplayShowTitleEnabled(false);
        this.bar.setNavigationMode(1);
        initDropDown();
        if (this.isUnread) {
            this.bar.setSelectedNavigationItem(1);
            return;
        }
        this.bar.setSelectedNavigationItem(0);
    }

    public void setIdByTwoPanel(String paramString) {
        this.topicId = paramString;
    }

    void showDialog(int paramInt) {
        switch (paramInt) {
            default:
                return;
        }
        new ArrayList();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/ics/forum/SubscribeForumFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */