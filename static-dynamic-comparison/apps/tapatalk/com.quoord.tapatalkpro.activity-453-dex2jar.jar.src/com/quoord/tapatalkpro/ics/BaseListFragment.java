package com.quoord.tapatalkpro.ics;

import android.app.Activity;
import android.view.Menu;
import com.quoord.tapatalkpro.activity.forum.DrawerLayoutStatus;
import com.quoord.tapatalkpro.adapter.forum.ForumRootAdapter;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.ui.ics.QuoordFragment;

public class BaseListFragment
        extends QuoordFragment {
    public ForumRootAdapter adapter;
    public ForumStatus forumstatus;
    public Activity mActivity;
    public Menu menu;

    public Activity getMactivity() {
        return this.mActivity;
    }

    public void onPrepareOptionsMenu(Menu paramMenu) {
        super.onPrepareOptionsMenu(paramMenu);
        if (((getActivity() instanceof DrawerLayoutStatus)) && (((DrawerLayoutStatus) getActivity()).isDrawMenuOpen())) {
            ((DrawerLayoutStatus) getActivity()).createDrawerMenu(paramMenu);
            return;
        }
        paramMenu.removeGroup(0);
    }

    public void setMactivity(Activity paramActivity) {
        this.mActivity = paramActivity;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/ics/BaseListFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */