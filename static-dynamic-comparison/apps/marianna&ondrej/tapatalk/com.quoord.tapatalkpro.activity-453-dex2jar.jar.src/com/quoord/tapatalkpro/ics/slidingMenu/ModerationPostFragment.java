package com.quoord.tapatalkpro.ics.slidingMenu;

import android.app.ActionBar;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.quoord.tapatalkpro.activity.forum.DrawerLayoutStatus;
import com.quoord.tapatalkpro.adapter.forum.LatestTopicAdapter;
import com.quoord.tapatalkpro.adapter.forum.MarkAllReadAdapter;
import com.quoord.tapatalkpro.adapter.forum.ModerateTopicAdapter;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.ics.BaseListFragment;
import com.quoord.tapatalkpro.util.ThemeUtil;

public class ModerationPostFragment
        extends BaseListFragment {
    private ActionBar bar;
    private ForumStatus forumStatus;
    private ListView listView;
    private ModerateTopicAdapter moderateAdapter;

    public static ModerationPostFragment newInstance() {
        return new ModerationPostFragment();
    }

    public void onActivityCreated(Bundle paramBundle) {
        super.onActivityCreated(paramBundle);
        this.mActivity = getActivity();
        this.bar = getActivity().getActionBar();
        this.bar.setDisplayHomeAsUpEnabled(true);
        this.bar.setDisplayShowTitleEnabled(false);
        this.bar.setNavigationMode(1);
        this.forumStatus = ((SlidingMenuActivity) this.mActivity).forumStatus;
        this.moderateAdapter = new ModerateTopicAdapter(this.mActivity, this.forumStatus.getUrl(), this.listView, false, this);
    }

    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        paramLayoutInflater = paramLayoutInflater.inflate(2130903189, paramViewGroup, false);
        this.listView = ((ListView) paramLayoutInflater.findViewById(2131231181));
        this.listView.setDivider(null);
        this.listView.setSelector(2131165212);
        return paramLayoutInflater;
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        switch (paramMenuItem.getItemId()) {
            default:
                return super.onOptionsItemSelected(paramMenuItem);
        }
        this.moderateAdapter.refresh();
        return true;
    }

    public void onPrepareOptionsMenu(Menu paramMenu) {
        if (((getActivity() instanceof DrawerLayoutStatus)) && (((DrawerLayoutStatus) getActivity()).isDrawMenuOpen())) {
            return;
        }
        paramMenu.add(0, 1001, 1, getString(2131099796)).setIcon(ThemeUtil.getMenuIconByPicName("menu_refresh_new", getActivity())).setShowAsAction(9);
    }

    void showDialog(int paramInt) {
        switch (paramInt) {
            default:
                return;
        }
        new DialogFragment() {
            public Dialog onCreateDialog(Bundle paramAnonymousBundle) {
                new AlertDialog.Builder(getActivity()).setMessage(2131099971).setPositiveButton(2131099792, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {
                        ((LatestTopicAdapter) ModerationPostFragment.this.adapter).cleanDatas();
                        new MarkAllReadAdapter(ModerationPostFragment.this.mActivity, ModerationPostFragment.this.forumstatus.getUrl());
                    }
                }).setNegativeButton(2131099974, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {
                    }
                }).create();
            }
        }.show(getFragmentManager(), "dailog");
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/ics/slidingMenu/ModerationPostFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */