package com.quoord.tapatalkpro.ics.conversation;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.quoord.tapatalkpro.activity.forum.CreatePmActivity;
import com.quoord.tapatalkpro.activity.forum.DrawerLayoutStatus;
import com.quoord.tapatalkpro.adapter.forum.PMAdapter;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.ics.BaseListFragment;
import com.quoord.tapatalkpro.ics.slidingMenu.SlidingMenuActivity;
import com.quoord.tapatalkpro.util.ThemeUtil;
import com.quoord.tapatalkpro.util.Util;

public class PMSendBoxFragment
        extends BaseListFragment {
    private ActionBar bar;
    private ListView listview;
    private PMAdapter outboxAdapter;

    public static PMSendBoxFragment newInstance() {
        return new PMSendBoxFragment();
    }

    public void onActivityCreated(Bundle paramBundle) {
        super.onActivityCreated(paramBundle);
        setMactivity(getActivity());
        setHasOptionsMenu(true);
        this.bar = getActivity().getActionBar();
        this.bar.setDisplayShowTitleEnabled(false);
        this.forumstatus = ((SlidingMenuActivity) getActivity()).getForumStatus();
        if ((this.forumstatus != null) && (this.outboxAdapter == null)) {
            this.outboxAdapter = new PMAdapter(this.mActivity, this.forumstatus.getUrl(), false, this.listview);
            this.outboxAdapter.getboxInfo();
        }
        this.bar.setNavigationMode(1);
    }

    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        paramLayoutInflater = paramLayoutInflater.inflate(2130903182, paramViewGroup, false);
        this.listview = ((ListView) paramLayoutInflater.findViewById(2131231148));
        this.listview.setDivider(null);
        this.listview.setSelector(2131165212);
        return paramLayoutInflater;
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        switch (paramMenuItem.getItemId()) {
            default:
            case 1001:
                do {
                    return super.onOptionsItemSelected(paramMenuItem);
                } while (this.outboxAdapter == null);
                this.outboxAdapter.refresh();
                ((SlidingMenuActivity) getActivity()).getUnreadNumbers();
                return true;
        }
        if (Util.isFastDoubleClick()) {
            paramMenuItem = new Intent(getActivity(), CreatePmActivity.class);
            paramMenuItem.putExtra("forumStatus", this.forumstatus);
            paramMenuItem.putExtra("action", 6);
            startActivityForResult(paramMenuItem, 0);
        }
        return true;
    }

    public void onPrepareOptionsMenu(Menu paramMenu) {
        super.onPrepareOptionsMenu(paramMenu);
        if (((getActivity() instanceof DrawerLayoutStatus)) && (((DrawerLayoutStatus) getActivity()).isDrawMenuOpen())) {
            return;
        }
        MenuItem localMenuItem = paramMenu.add(0, 0, 0, getActivity().getString(2131099799));
        localMenuItem.setIcon(ThemeUtil.getMenuIconByPicName("bubble_edit", getActivity()));
        localMenuItem.setShowAsAction(6);
        paramMenu.add(0, 1001, 1, getString(2131099796)).setIcon(ThemeUtil.getMenuIconByPicName("menu_refresh_new", getActivity())).setShowAsAction(9);
    }

    public void onResume() {
        super.onResume();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/ics/conversation/PMSendBoxFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */