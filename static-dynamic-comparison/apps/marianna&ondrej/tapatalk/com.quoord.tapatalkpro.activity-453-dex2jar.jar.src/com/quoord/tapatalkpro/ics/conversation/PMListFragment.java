package com.quoord.tapatalkpro.ics.conversation;

import android.app.ActionBar;
import android.app.ActionBar.OnNavigationListener;
import android.app.Activity;
import android.content.Intent;
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
import com.quoord.tapatalkpro.activity.forum.CreatePmActivity;
import com.quoord.tapatalkpro.activity.forum.DrawerLayoutStatus;
import com.quoord.tapatalkpro.adapter.forum.PMAdapter;
import com.quoord.tapatalkpro.adapter.forum.conversation.PmTitleAdapter;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.ics.BaseListFragment;
import com.quoord.tapatalkpro.ics.slidingMenu.SlidingMenuActivity;
import com.quoord.tapatalkpro.util.ThemeUtil;
import com.quoord.tapatalkpro.util.Util;
import com.quoord.tools.TwoPanelControllerWithId;

import java.util.ArrayList;

public class PMListFragment
        extends BaseListFragment
        implements TwoPanelControllerWithId {
    public static final int MENU_NEWPM = 0;
    private ActionBar bar;
    public int currentPosition = 0;
    private PMAdapter inboxAdapter;
    private ListView inboxList;
    private ArrayList<String> mData = new ArrayList();
    private PMAdapter outboxAdapter;
    private ListView outboxList;
    private String pmId;

    public static PMListFragment newInstance() {
        return new PMListFragment();
    }

    public BaseAdapter getAdapter() {
        return null;
    }

    public String getIdByTwoPanel() {
        return this.pmId;
    }

    public void initDropDown() {
        if (this.mData.size() == 0) {
            this.mData.add(getResources().getString(2131099880));
            this.mData.add(getResources().getString(2131099882));
        }
        this.bar.setListNavigationCallbacks(new PmTitleAdapter(getActivity(), this.mData), new ActionBar.OnNavigationListener() {
            public boolean onNavigationItemSelected(int paramAnonymousInt, long paramAnonymousLong) {
                if (paramAnonymousInt == 0) {
                    PMListFragment.this.showInbox(0);
                }
                for (; ; ) {
                    PMListFragment.this.getActivity().invalidateOptionsMenu();
                    return true;
                    PMListFragment.this.showInbox(1);
                }
            }
        });
    }

    public void onActivityCreated(Bundle paramBundle) {
        ThemeUtil.setTheme(getActivity());
        super.onActivityCreated(paramBundle);
        setHasOptionsMenu(true);
        this.bar = getActivity().getActionBar();
        setBar();
        initDropDown();
        this.mActivity = ((SlidingMenuActivity) getActivity());
        this.forumstatus = ((SlidingMenuActivity) getActivity()).getForumStatus();
        this.inboxList.setDivider(null);
        this.inboxList.setSelector(2131165212);
        this.outboxList.setDivider(null);
        this.outboxList.setSelector(2131165212);
        showInbox(this.currentPosition);
    }

    public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
        if (this.outboxAdapter != null) {
            this.outboxAdapter.refresh();
        }
        super.onActivityResult(paramInt1, paramInt2, paramIntent);
    }

    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        paramLayoutInflater = paramLayoutInflater.inflate(2130903228, paramViewGroup, false);
        this.inboxList = ((ListView) paramLayoutInflater.findViewById(2131231290));
        this.outboxList = ((ListView) paramLayoutInflater.findViewById(2131231291));
        return paramLayoutInflater;
    }

    public void onHiddenChanged(boolean paramBoolean) {
        super.onHiddenChanged(paramBoolean);
        if (!paramBoolean) {
            setBar();
        }
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        switch (paramMenuItem.getItemId()) {
            default:
            case 1001:
                do {
                    do {
                        return super.onOptionsItemSelected(paramMenuItem);
                        if (this.currentPosition != 0) {
                            break;
                        }
                    } while (this.inboxAdapter == null);
                    this.inboxAdapter.refresh();
                    ((SlidingMenuActivity) getActivity()).getUnreadNumbers();
                    return true;
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

    public void setActionBar(Activity paramActivity) {
        if (this.bar == null) {
            this.bar = paramActivity.getActionBar();
        }
        setBar();
    }

    public void setBar() {
        this.bar.setDisplayShowTitleEnabled(false);
        this.bar.setNavigationMode(1);
        if (this.mData.size() == 0) {
            this.mData.add(getResources().getString(2131099880));
            this.mData.add(getResources().getString(2131099882));
        }
        initDropDown();
        this.bar.setSelectedNavigationItem(this.currentPosition);
    }

    public void setIdByTwoPanel(String paramString) {
        this.pmId = paramString;
    }

    public void showInbox(int paramInt) {
        if (paramInt == 0) {
            this.currentPosition = 0;
            this.inboxList.setVisibility(0);
            this.outboxList.setVisibility(8);
            if ((this.forumstatus != null) && (this.inboxAdapter == null)) {
                this.inboxAdapter = new PMAdapter(this.mActivity, this.forumstatus.getUrl(), true, this.inboxList);
                this.inboxAdapter.getboxInfo();
            }
        }
        do {
            return;
            this.currentPosition = 1;
            this.inboxList.setVisibility(8);
            this.outboxList.setVisibility(0);
        } while ((this.forumstatus == null) || (this.outboxAdapter != null));
        this.outboxAdapter = new PMAdapter(this.mActivity, this.forumstatus.getUrl(), false, this.outboxList);
        this.outboxAdapter.getboxInfo();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/ics/conversation/PMListFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */