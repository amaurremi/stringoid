package com.quoord.tapatalkpro.activity.forum;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.quoord.tapatalkpro.adapter.forum.ProfilesAdapter;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.ui.ics.QuoordFragment;
import com.quoord.tools.TwoPanelOutController;

public class ProfilesFragment
        extends QuoordFragment {
    private ForumStatus forumStatus;
    private ProfilesOuterFragment outFragment;
    public ProfilesAdapter profilesAdapter = null;
    private LinearLayout progress;
    private ListView topics_list = null;
    private String userId;
    public String username = null;

    private ProfilesOuterFragment getOutFragment() {
        if ((getActivity() instanceof TwoPanelOutController)) {
            return (ProfilesOuterFragment) ((TwoPanelOutController) getActivity()).getOuterFragment();
        }
        return null;
    }

    public static ProfilesFragment newInstance(String paramString1, String paramString2) {
        ProfilesFragment localProfilesFragment = new ProfilesFragment();
        localProfilesFragment.username = paramString1;
        localProfilesFragment.userId = paramString2;
        return localProfilesFragment;
    }

    public void onActivityCreated(Bundle paramBundle) {
        super.onActivityCreated(paramBundle);
        setRetainInstance(true);
        this.outFragment = getOutFragment();
        if (this.outFragment != null) {
            this.forumStatus = this.outFragment.forumStatus;
            if (this.outFragment.mActivity == null) {
                getActivity().finish();
            }
        }
        if (paramBundle != null) {
            this.forumStatus = ((ForumStatus) paramBundle.getSerializable("forumStatus"));
            this.userId = paramBundle.getString("userId");
            this.username = paramBundle.getString("username");
        }
        if ((this.username != null) && (!this.username.equals("")) && (this.outFragment != null) && (this.outFragment.mActivity != null)) {
            this.profilesAdapter = new ProfilesAdapter(this.outFragment, this.forumStatus.getUrl(), this.username, this.userId, this.forumStatus, this.progress);
            this.topics_list.setAdapter(this.profilesAdapter);
            this.profilesAdapter.notifyDataSetChanged();
        }
    }

    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
    }

    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        paramLayoutInflater = paramLayoutInflater.inflate(2130903324, null);
        this.topics_list = ((ListView) paramLayoutInflater.findViewById(2131231539));
        this.topics_list.setDivider(null);
        this.topics_list.setSelector(2131165212);
        this.progress = ((LinearLayout) paramLayoutInflater.findViewById(2131230891));
        return paramLayoutInflater;
    }

    public void onResume() {
        super.onResume();
        if (this.profilesAdapter != null) {
            this.profilesAdapter.notifyDataSetChanged();
        }
    }

    public void onSaveInstanceState(Bundle paramBundle) {
        super.onSaveInstanceState(paramBundle);
        paramBundle.putSerializable("forumStatus", this.forumStatus);
        paramBundle.putString("userId", this.userId);
        paramBundle.putString("username", this.username);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/activity/forum/ProfilesFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */