package com.quoord.tapatalkpro.activity.forum;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.quoord.tapatalkpro.adapter.forum.StartPostAdapter;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.bean.TapatalkForum;
import com.quoord.tapatalkpro.bean.Topic;
import com.quoord.tapatalkpro.ics.BaseListFragment;
import com.quoord.tools.TwoPanelOutController;

public class StartPostFragment
        extends BaseListFragment {
    private ForumStatus forumStatus;
    public ListView listView;
    private Activity mActivity;
    private ProfilesOuterFragment outFragment;
    private LinearLayout progress;
    public StartPostAdapter startPostAdapter;
    private String userId;
    private String userName;

    private ProfilesOuterFragment getOutFragment() {
        if ((getActivity() instanceof TwoPanelOutController)) {
            return (ProfilesOuterFragment) ((TwoPanelOutController) getActivity()).getOuterFragment();
        }
        return null;
    }

    public static StartPostFragment newInstance() {
        return new StartPostFragment();
    }

    public Object getItem(int paramInt) {
        if ((this.listView.getAdapter().getItem(paramInt) instanceof Topic)) {
            return this.startPostAdapter.getItem(paramInt);
        }
        return "";
    }

    public void onActivityCreated(Bundle paramBundle) {
        super.onActivityCreated(paramBundle);
        setRetainInstance(true);
        this.mActivity = getActivity();
        this.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong) {
                StartPostFragment.this.startPostAdapter.setmLongclickItemPosition(paramAnonymousInt);
                if (((StartPostFragment.this.getItem(paramAnonymousInt) instanceof Topic)) && (StartPostFragment.this.forumStatus != null)) {
                    paramAnonymousAdapterView = new Intent(StartPostFragment.this.mActivity, ThreadActivity.class);
                    paramAnonymousAdapterView.putExtra("forumStatus", StartPostFragment.this.forumStatus);
                    paramAnonymousAdapterView.putExtra("goto_first_post", true);
                    paramAnonymousAdapterView.putExtra("topic", (Topic) StartPostFragment.this.getItem(paramAnonymousInt));
                    StartPostFragment.this.mActivity.startActivity(paramAnonymousAdapterView);
                }
            }
        });
        this.listView.setOnItemLongClickListener(new topicListLongClickListener());
    }

    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        paramLayoutInflater = paramLayoutInflater.inflate(2130903370, null);
        this.listView = ((ListView) paramLayoutInflater.findViewById(2131231610));
        this.listView.setDivider(null);
        this.listView.setSelector(2131165212);
        this.progress = ((LinearLayout) paramLayoutInflater.findViewById(2131230891));
        return paramLayoutInflater;
    }

    public void refresh() {
        if (this.listView != null) {
            setDatas();
        }
    }

    public void removeListFootLay() {
        if (this.progress != null) {
            this.progress.setVisibility(8);
        }
    }

    public void setDatas() {
        this.outFragment = getOutFragment();
        if (this.outFragment != null) {
            this.forumStatus = this.outFragment.forumStatus;
        }
        if (this.outFragment != null) {
            if (this.outFragment.userId != null) {
                this.userId = this.outFragment.userId;
            }
        }
        for (this.userName = this.outFragment.mIconUsername; ; this.userName = this.forumStatus.tapatalkForum.getUserName()) {
            if (this.forumStatus != null) {
                this.startPostAdapter = new StartPostAdapter(this.outFragment, this.forumStatus, this.forumStatus.getUrl(), this.userName, this.userId, this.progress);
                this.listView.setAdapter(this.startPostAdapter);
            }
            return;
            this.forumStatus = this.outFragment.forumStatus;
            this.userId = this.forumStatus.tapatalkForum.getUserId();
        }
    }

    class topicListLongClickListener
            implements AdapterView.OnItemLongClickListener {
        topicListLongClickListener() {
        }

        public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {
            paramInt -= StartPostFragment.this.listView.getHeaderViewsCount();
            if ((paramInt >= StartPostFragment.this.startPostAdapter.getCount()) || (StartPostFragment.this.startPostAdapter.getCount() <= paramInt)) {
                return true;
            }
            ((Topic) StartPostFragment.this.startPostAdapter.getItem(paramInt)).getLongClickDialog(StartPostFragment.this.startPostAdapter, StartPostFragment.this.mActivity, StartPostFragment.this.forumStatus).show();
            return true;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/activity/forum/StartPostFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */