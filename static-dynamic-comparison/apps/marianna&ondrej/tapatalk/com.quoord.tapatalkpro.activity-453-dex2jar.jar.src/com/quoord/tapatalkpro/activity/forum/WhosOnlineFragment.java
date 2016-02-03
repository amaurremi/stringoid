package com.quoord.tapatalkpro.activity.forum;

import android.app.ActionBar;
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
import android.widget.ListView;
import com.quoord.tapatalkpro.adapter.forum.WhosOnlineAdapter;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.bean.RebrandingConfig;
import com.quoord.tapatalkpro.ics.BaseListFragment;
import com.quoord.tapatalkpro.ics.slidingMenu.SlidingMenuActivity;
import com.quoord.tapatalkpro.ics.slidingMenu.TabItem;
import com.quoord.tapatalkpro.util.ThemeUtil;
import com.quoord.tools.TwoPanelController;

import java.util.ArrayList;

public class WhosOnlineFragment
        extends BaseListFragment
        implements TwoPanelController {
    private ActionBar bar;
    private ForumStatus forumstatus;
    private ListView listview;
    private SlidingMenuActivity mActivity;
    private int menuId;
    private String title;

    private void initActionBar() {
        this.bar.setNavigationMode(0);
        this.bar.setDisplayShowTitleEnabled(true);
        if ((this.title != null) && (!this.title.equals(""))) {
            this.bar.setTitle(this.title);
        }
        for (; ; ) {
            this.bar.setSubtitle(null);
            return;
            this.bar.setTitle(getActivity().getString(2131100423));
        }
    }

    public static WhosOnlineFragment newInstance(int paramInt) {
        WhosOnlineFragment localWhosOnlineFragment = new WhosOnlineFragment();
        localWhosOnlineFragment.menuId = paramInt;
        return localWhosOnlineFragment;
    }

    public BaseAdapter getAdapter() {
        return this.adapter;
    }

    public void onActivityCreated(Bundle paramBundle) {
        super.onActivityCreated(paramBundle);
        setMactivity(getActivity());
        setHasOptionsMenu(true);
        this.mActivity = ((SlidingMenuActivity) getActivity());
        this.bar = getActivity().getActionBar();
        this.bar.setDisplayShowHomeEnabled(true);
        int i;
        if ((this.mActivity.getResources().getBoolean(2131558401)) && (this.mActivity.forumStatus != null) && (this.mActivity.forumStatus.getRebrandingConfig() != null) && (this.mActivity.forumStatus.getRebrandingConfig().getOrder() != null)) {
            paramBundle = this.mActivity.forumStatus.getRebrandingConfig().getOrder();
            if ((this.mActivity.getResources().getBoolean(2131558401)) && (this.mActivity.forumStatus != null) && (this.mActivity.forumStatus.getRebrandingConfig() != null) && (this.mActivity.forumStatus != null) && (this.mActivity.forumStatus.getRebrandingConfig() != null) && (paramBundle != null) && (paramBundle.size() > 0)) {
                i = 0;
            }
        }
        for (; ; ) {
            if (i >= paramBundle.size()) {
                initActionBar();
                this.forumstatus = ((SlidingMenuActivity) getActivity()).forumStatus;
                if ((this.forumstatus != null) && (this.forumstatus.isLogin())) {
                    this.adapter = new WhosOnlineAdapter(getActivity(), this.listview, this.forumstatus.getUrl());
                }
                return;
            }
            if (((TabItem) paramBundle.get(i)).getMenuid() == this.menuId) {
                this.title = ((TabItem) paramBundle.get(i)).getDisplay_name();
            }
            i += 1;
        }
    }

    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        paramLayoutInflater = paramLayoutInflater.inflate(2130903225, paramViewGroup, false);
        this.listview = ((ListView) paramLayoutInflater.findViewById(2131231284));
        this.listview.setDivider(null);
        this.listview.setSelector(2131165212);
        return paramLayoutInflater;
    }

    public void onHiddenChanged(boolean paramBoolean) {
        super.onHiddenChanged(paramBoolean);
        if (!paramBoolean) {
            initActionBar();
        }
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        switch (paramMenuItem.getItemId()) {
            default:
                return super.onOptionsItemSelected(paramMenuItem);
        }
        if (this.adapter != null) {
            ((WhosOnlineAdapter) this.adapter).refresh();
        }
        return true;
    }

    public void onPrepareOptionsMenu(Menu paramMenu) {
        super.onPrepareOptionsMenu(paramMenu);
        paramMenu.removeGroup(0);
        if (((getActivity() instanceof DrawerLayoutStatus)) && (((DrawerLayoutStatus) getActivity()).isDrawMenuOpen())) {
            return;
        }
        paramMenu.add(0, 1001, 1, getString(2131099796)).setIcon(ThemeUtil.getMenuIconByPicName("menu_refresh_new", getActivity())).setShowAsAction(9);
    }

    public void setActionBar(Activity paramActivity) {
        if (this.bar == null) {
            this.bar = paramActivity.getActionBar();
        }
        initActionBar();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/activity/forum/WhosOnlineFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */