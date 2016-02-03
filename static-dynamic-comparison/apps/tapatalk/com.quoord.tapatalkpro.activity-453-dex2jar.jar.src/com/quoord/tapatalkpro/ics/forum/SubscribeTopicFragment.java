package com.quoord.tapatalkpro.ics.forum;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import com.quoord.tapatalkpro.activity.forum.DrawerLayoutStatus;
import com.quoord.tapatalkpro.adapter.forum.ForumRootAdapter;
import com.quoord.tapatalkpro.adapter.forum.SubscribeForumAndTopicAdapter;
import com.quoord.tapatalkpro.bean.Forum;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.bean.Topic;
import com.quoord.tapatalkpro.ics.BaseListFragment;
import com.quoord.tapatalkpro.ics.slidingMenu.SlidingMenuActivity;
import com.quoord.tapatalkpro.util.ThemeUtil;

import java.util.ArrayList;

public class SubscribeTopicFragment
        extends BaseListFragment {
    private ActionBar bar;
    private ListView listView;

    public static SubscribeTopicFragment newInstance() {
        return new SubscribeTopicFragment();
    }

    public void onActivityCreated(Bundle paramBundle) {
        super.onActivityCreated(paramBundle);
        this.mActivity = getActivity();
        this.forumstatus = ((SlidingMenuActivity) getActivity()).forumStatus;
        this.bar = getActivity().getActionBar();
        this.bar.setTitle(2131100417);
        this.bar.setSubtitle(null);
        if ((this.forumstatus != null) && (this.forumstatus.isLogin())) {
            this.adapter = new SubscribeForumAndTopicAdapter(this.mActivity, this.forumstatus.getUrl(), this.listView, "subscribe_topic_statck_tag", true);
            this.listView.setOnItemLongClickListener(new topicListLongClickListener());
        }
    }

    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        setHasOptionsMenu(true);
    }

    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        paramLayoutInflater = paramLayoutInflater.inflate(2130903189, paramViewGroup, false);
        this.listView = ((ListView) paramLayoutInflater.findViewById(2131231181));
        this.listView.setDivider(null);
        this.listView.setSelector(2131165212);
        return paramLayoutInflater;
    }

    public void onHiddenChanged(boolean paramBoolean) {
        super.onHiddenChanged(paramBoolean);
        if (!paramBoolean) {
            this.bar.setTitle(2131100417);
            this.bar.setSubtitle(null);
        }
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        switch (paramMenuItem.getItemId()) {
        }
        do {
            return super.onOptionsItemSelected(paramMenuItem);
        } while (this.adapter == null);
        ((SubscribeForumAndTopicAdapter) this.adapter).refresh();
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

    void showDialog(int paramInt) {
        switch (paramInt) {
            default:
                return;
        }
        new ArrayList();
        ((Forum) this.adapter.getItem(this.adapter.getmLongclickItemPosition())).getLongPressDialogFragment(this.adapter, this.mActivity).show(getFragmentManager(), "dailog");
    }

    class topicListLongClickListener
            implements AdapterView.OnItemLongClickListener {
        topicListLongClickListener() {
        }

        public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {
            SubscribeTopicFragment.this.adapter.mLongclickItemPosition = (paramInt - SubscribeTopicFragment.this.listView.getHeaderViewsCount());
            paramAdapterView = SubscribeTopicFragment.this.adapter.getItem(SubscribeTopicFragment.this.adapter.mLongclickItemPosition);
            if (SubscribeTopicFragment.this.forumstatus.isLogin()) {
                if ((paramAdapterView instanceof Forum)) {
                    SubscribeTopicFragment.this.showDialog(12);
                }
                if ((paramAdapterView instanceof Topic)) {
                    ((Topic) SubscribeTopicFragment.this.adapter.getItem(SubscribeTopicFragment.this.adapter.mLongclickItemPosition)).getLongClickDialog(SubscribeTopicFragment.this.adapter, SubscribeTopicFragment.this.mActivity, SubscribeTopicFragment.this.forumstatus).show();
                }
            }
            return true;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/ics/forum/SubscribeTopicFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */