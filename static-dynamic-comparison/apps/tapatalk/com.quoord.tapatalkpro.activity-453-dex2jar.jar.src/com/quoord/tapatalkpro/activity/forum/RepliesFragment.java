package com.quoord.tapatalkpro.activity.forum;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.quoord.tapatalkpro.adapter.forum.RepliesAdapter;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.ics.BaseListFragment;
import com.quoord.tools.TwoPanelOutController;

public class RepliesFragment
        extends BaseListFragment {
    private ForumStatus forumStatus;
    private ListView listView;
    private RepliesAdapter mAdapter;
    private ProfilesOuterFragment outFragment;
    public LinearLayout progress;
    private String userId;
    private String userName;

    private ProfilesOuterFragment getOutFragment() {
        if ((getActivity() instanceof TwoPanelOutController)) {
            return (ProfilesOuterFragment) ((TwoPanelOutController) getActivity()).getOuterFragment();
        }
        return null;
    }

    public static RepliesFragment newInstance() {
        return new RepliesFragment();
    }

    public void onActivityCreated(Bundle paramBundle) {
        super.onActivityCreated(paramBundle);
        setRetainInstance(true);
        this.outFragment = getOutFragment();
        if (this.outFragment != null) {
            this.forumStatus = this.outFragment.forumStatus;
        }
        if (this.outFragment != null) {
            if (this.outFragment.userId != null) {
                this.userId = this.outFragment.userId;
            }
            this.forumStatus = this.outFragment.forumStatus;
            this.userName = this.outFragment.mIconUsername;
        }
        if ((this.forumStatus != null) && (this.listView != null) && (this.progress != null) && (this.outFragment != null) && (this.outFragment.mActivity != null)) {
            this.mAdapter = new RepliesAdapter(this.outFragment, this.forumStatus.getUrl(), this.userName, this.userId, this.listView, this.progress, this);
            this.listView.setAdapter(this.mAdapter);
        }
    }

    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        paramLayoutInflater = paramLayoutInflater.inflate(2130903342, null);
        this.listView = ((ListView) paramLayoutInflater.findViewById(2131231574));
        this.listView.setDivider(null);
        this.listView.setSelector(2131165212);
        this.progress = ((LinearLayout) paramLayoutInflater.findViewById(2131230891));
        return paramLayoutInflater;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/activity/forum/RepliesFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */