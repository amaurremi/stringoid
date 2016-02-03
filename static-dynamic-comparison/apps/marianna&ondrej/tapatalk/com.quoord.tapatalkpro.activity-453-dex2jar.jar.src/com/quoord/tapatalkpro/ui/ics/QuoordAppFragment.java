package com.quoord.tapatalkpro.ui.ics;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import com.quoord.tapatalkpro.activity.forum.DrawerLayoutStatus;
import com.quoord.tapatalkpro.ics.slidingMenu.SettingsFragment;

public class QuoordAppFragment
        extends Fragment
        implements IQuoordInterface {
    public void onActivityCreated(Bundle paramBundle) {
        super.onActivityCreated(paramBundle);
        setQuoordBackGround(getActivity());
    }

    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        setHasOptionsMenu(true);
        getActivity().getActionBar().setDisplayShowTitleEnabled(true);
    }

    public void onPrepareOptionsMenu(Menu paramMenu) {
        super.onPrepareOptionsMenu(paramMenu);
        paramMenu.removeGroup(0);
        if (((getActivity() instanceof DrawerLayoutStatus)) && (((DrawerLayoutStatus) getActivity()).isDrawMenuOpen())) {
            ((DrawerLayoutStatus) getActivity()).createDrawerMenu(paramMenu);
        }
    }

    public void setQuoordBackGround(Context paramContext) {
        if (!SettingsFragment.isLightTheme(getActivity())) {
            getView().setBackgroundResource(2131165282);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/ui/ics/QuoordAppFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */