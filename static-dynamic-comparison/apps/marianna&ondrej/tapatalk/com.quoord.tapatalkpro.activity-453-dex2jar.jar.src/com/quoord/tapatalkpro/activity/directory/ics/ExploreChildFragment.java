package com.quoord.tapatalkpro.activity.directory.ics;

import android.app.ActionBar;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.quoord.tapatalkpro.adapter.directory.ExploreChildAdapter;
import com.quoord.tapatalkpro.bean.TapatalkCategory;
import com.quoord.tapatalkpro.ui.ics.QuoordFragment;
import com.quoord.tools.tracking.GoogleAnalyticsTools;

public class ExploreChildFragment
        extends QuoordFragment {
    private ActionBar acbar;
    private ExploreChildAdapter categoryChildAdapter;
    private ListView listView;
    private LinearLayout noDataView;
    private TapatalkCategory tapatalkCategory;

    public static ExploreChildFragment newInstance(TapatalkCategory paramTapatalkCategory) {
        ExploreChildFragment localExploreChildFragment = new ExploreChildFragment();
        localExploreChildFragment.tapatalkCategory = paramTapatalkCategory;
        return localExploreChildFragment;
    }

    public void onActivityCreated(Bundle paramBundle) {
        super.onActivityCreated(paramBundle);
        this.acbar = getActivity().getActionBar();
        GoogleAnalyticsTools.trackPageView(getActivity(), "tap_sub_category_child");
        setActionBar();
        this.categoryChildAdapter = new ExploreChildAdapter(getActivity(), this.tapatalkCategory, this.listView, this.noDataView);
        this.listView.setAdapter(this.categoryChildAdapter);
        this.listView.setSelector(2131165212);
    }

    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        paramLayoutInflater = paramLayoutInflater.inflate(2130903208, paramViewGroup, false);
        this.listView = ((ListView) paramLayoutInflater.findViewById(2131231247));
        this.noDataView = ((LinearLayout) paramLayoutInflater.findViewById(2131231112));
        this.listView.setDivider(null);
        return paramLayoutInflater;
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        if (this.categoryChildAdapter != null) {
        }
        switch (paramMenuItem.getItemId()) {
            default:
                return super.onOptionsItemSelected(paramMenuItem);
        }
        this.categoryChildAdapter.refresh();
        return true;
    }

    public void onPrepareOptionsMenu(Menu paramMenu) {
        super.onPrepareOptionsMenu(paramMenu);
    }

    public void onResume() {
        if (this.categoryChildAdapter != null) {
            this.categoryChildAdapter.notifyDataSetChanged();
        }
        super.onResume();
    }

    public void setActionBar() {
        this.acbar.setDisplayHomeAsUpEnabled(true);
        this.acbar.setDisplayShowTitleEnabled(true);
        this.acbar.setIcon(2130837525);
        if (this.tapatalkCategory != null) {
            if (this.tapatalkCategory.getName() != null) {
                this.acbar.setTitle(this.tapatalkCategory.getName());
            }
        } else {
            return;
        }
        this.acbar.setTitle(getActivity().getResources().getString(2131100583));
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/activity/directory/ics/ExploreChildFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */