package com.quoord.tapatalkpro.ui.ics;

import android.app.ActionBar;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.View;
import com.quoord.tapatalkpro.activity.forum.DrawerLayoutStatus;
import com.quoord.tapatalkpro.ics.slidingMenu.SettingsFragment;

public class QuoordFragment
        extends Fragment
        implements IQuoordInterface {
    public void onActivityCreated(Bundle paramBundle) {
        super.onActivityCreated(paramBundle);
        setQuoordBackGround(getActivity());
        getActivity().getActionBar().setDisplayShowTitleEnabled(true);
    }

    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        setHasOptionsMenu(true);
    }

    public void onPrepareOptionsMenu(Menu paramMenu) {
        super.onPrepareOptionsMenu(paramMenu);
        if (((getActivity() instanceof DrawerLayoutStatus)) && (((DrawerLayoutStatus) getActivity()).isDrawMenuOpen())) {
            ((DrawerLayoutStatus) getActivity()).createDrawerMenu(paramMenu);
        }
    }

    public void setQuoordBackGround(Context paramContext) {
        if (SettingsFragment.isLightTheme(getActivity())) {
            getView().setBackgroundResource(2131165281);
            return;
        }
        getView().setBackgroundResource(2131165282);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/ui/ics/QuoordFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */