package com.quoord.tapatalkpro.ics.alert;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
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
import com.quoord.tapatalkpro.activity.forum.DrawerLayoutStatus;
import com.quoord.tapatalkpro.adapter.forum.AlertAdapter;
import com.quoord.tapatalkpro.alarm.notification.NotificationSettingActivity;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.bean.RebrandingConfig;
import com.quoord.tapatalkpro.ics.slidingMenu.SlidingMenuActivity;
import com.quoord.tapatalkpro.ics.slidingMenu.TabItem;
import com.quoord.tapatalkpro.ui.ics.QuoordFragment;
import com.quoord.tapatalkpro.util.ThemeUtil;
import com.quoord.tools.TwoPanelController;

import java.util.ArrayList;

public class AlertFragment
        extends QuoordFragment
        implements TwoPanelController {
    private AlertAdapter adapter = null;
    private ListView alertView = null;
    private ActionBar bar;
    private ForumStatus forumStatus = null;
    private SlidingMenuActivity mActivity;
    private int menuId;
    private String title;

    private void initActionBar() {
        this.bar.setNavigationMode(0);
        this.bar.setDisplayShowTitleEnabled(true);
        this.bar.setIcon(2130837525);
        if ((this.title != null) && (!this.title.equals(""))) {
            this.bar.setTitle(this.title);
        }
        for (; ; ) {
            this.bar.setSubtitle(null);
            return;
            this.bar.setTitle(2131100413);
        }
    }

    public static AlertFragment newInstance(int paramInt) {
        AlertFragment localAlertFragment = new AlertFragment();
        localAlertFragment.menuId = paramInt;
        return localAlertFragment;
    }

    public BaseAdapter getAdapter() {
        return null;
    }

    public void onActivityCreated(Bundle paramBundle) {
        super.onActivityCreated(paramBundle);
        this.mActivity = ((SlidingMenuActivity) getActivity());
        this.bar = getActivity().getActionBar();
        this.bar.setDisplayHomeAsUpEnabled(true);
        int i;
        if ((this.mActivity.getResources().getBoolean(2131558401)) && (this.mActivity.forumStatus != null) && (this.mActivity.forumStatus.getRebrandingConfig() != null)) {
            paramBundle = this.mActivity.forumStatus.getRebrandingConfig().getOrder();
            if ((this.mActivity.forumStatus != null) && (this.mActivity.forumStatus.getRebrandingConfig() != null) && (paramBundle != null) && (paramBundle.size() > 0)) {
                i = 0;
            }
        }
        for (; ; ) {
            if (i >= paramBundle.size()) {
                initActionBar();
                this.forumStatus = ((SlidingMenuActivity) getActivity()).forumStatus;
                if ((this.forumStatus != null) && (this.forumStatus.isLogin())) {
                    this.alertView.setDivider(null);
                    this.alertView.setSelector(2131165212);
                    this.adapter = new AlertAdapter(getActivity(), this.forumStatus.getUrl(), this.alertView);
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
        this.alertView = ((ListView) getActivity().getLayoutInflater().inflate(2130903061, null));
        return this.alertView;
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
            case 1001:
                do {
                    return super.onOptionsItemSelected(paramMenuItem);
                } while (this.adapter == null);
                this.adapter.refresh();
                return true;
            case 1024:
                paramMenuItem = new Intent();
                paramMenuItem.setClass(getActivity(), NotificationSettingActivity.class);
                paramMenuItem.putExtra("forumStatus", this.forumStatus);
                startActivity(paramMenuItem);
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
        do {
            return;
            MenuItem localMenuItem = paramMenu.add(0, 1001, 0, getString(2131099796));
            localMenuItem.setIcon(ThemeUtil.getMenuIconByPicName("menu_refresh_new", getActivity()));
            localMenuItem.setShowAsAction(1);
        }
        while ((getActivity() == null) || (!getActivity().getSharedPreferences("notificationsetting", 0).getBoolean(getResources().getString(2131100361), true)));
        paramMenu = paramMenu.add(0, 1024, 0, getString(2131099922));
        paramMenu.setIcon(ThemeUtil.getMenuIconByPicName("notification_setting", getActivity()));
        paramMenu.setShowAsAction(1);
    }

    public void onResume() {
        super.onResume();
    }

    public void setActionBar(Activity paramActivity) {
        if (this.bar == null) {
            this.bar = paramActivity.getActionBar();
        }
        initActionBar();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/ics/alert/AlertFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */