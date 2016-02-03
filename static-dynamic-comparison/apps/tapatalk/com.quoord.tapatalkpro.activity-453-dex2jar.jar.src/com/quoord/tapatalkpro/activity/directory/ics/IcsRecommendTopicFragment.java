package com.quoord.tapatalkpro.activity.directory.ics;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
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
import android.widget.TextView;
import com.quoord.tapatalkpro.activity.forum.DrawerLayoutStatus;
import com.quoord.tapatalkpro.adapter.directory.ics.IcsRecommendTopicAdapter;
import com.quoord.tapatalkpro.ics.slidingMenu.SettingsFragment;
import com.quoord.tapatalkpro.ui.ics.QuoordFragment;
import com.quoord.tools.TwoPanelController;

import java.util.ArrayList;

public class IcsRecommendTopicFragment
        extends QuoordFragment
        implements TwoPanelController {
    private ArrayList<Object> mDatas;
    private ListView mListView;
    private TextView noDataView;
    private IcsRecommendTopicAdapter recommendTopicAdapter;
    private TextView text;

    private void initNeedAfterActivityCreated() {
        this.text.setText(getString(2131100656));
        this.text.setGravity(3);
        this.text.setEnabled(false);
        this.text.setPadding(24, 23, 24, 23);
        this.text.setLineSpacing(4.0F, 1.0F);
        this.text.setTextSize(14.0F);
        if (!SettingsFragment.isLightTheme(getActivity())) {
            this.text.setTextColor(getResources().getColor(2131165283));
        }
        for (; ; ) {
            this.mListView.setAdapter(this.recommendTopicAdapter);
            this.mListView.setSelector(2131165212);
            return;
            this.text.setTextColor(getResources().getColor(2131165570));
        }
    }

    public static IcsRecommendTopicFragment newInstance(ArrayList<Object> paramArrayList) {
        IcsRecommendTopicFragment localIcsRecommendTopicFragment = new IcsRecommendTopicFragment();
        localIcsRecommendTopicFragment.mDatas = paramArrayList;
        return localIcsRecommendTopicFragment;
    }

    public BaseAdapter getAdapter() {
        return this.recommendTopicAdapter;
    }

    public void onActivityCreated(Bundle paramBundle) {
        super.onActivityCreated(paramBundle);
        getActivity().getActionBar().setDisplayShowTitleEnabled(true);
        getActivity().getActionBar().setDisplayShowHomeEnabled(true);
        getActivity().getActionBar().setDisplayHomeAsUpEnabled(true);
        setActionBar(getActivity());
        if ((this.mDatas != null) && (this.mDatas.size() <= 0)) {
            this.noDataView.setVisibility(0);
        }
        paramBundle = getActivity().getIntent().getStringExtra("round");
        this.recommendTopicAdapter = new IcsRecommendTopicAdapter(getActivity(), this.mDatas, this.mListView, paramBundle);
        initNeedAfterActivityCreated();
    }

    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        paramLayoutInflater = paramLayoutInflater.inflate(2130903340, null);
        this.mListView = ((ListView) paramLayoutInflater.findViewById(2131231569));
        this.mListView.setFooterDividersEnabled(false);
        this.mListView.setDivider(null);
        this.noDataView = ((TextView) paramLayoutInflater.findViewById(2131231090));
        this.text = ((TextView) paramLayoutInflater.findViewById(2131231568));
        return paramLayoutInflater;
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        if ((paramMenuItem.getItemId() == 16908332) && ((getActivity() instanceof IcsRecommendActivity))) {
            Intent localIntent = new Intent(getActivity(), AccountEntryActivity.class);
            getActivity().startActivity(localIntent);
            getActivity().finish();
        }
        return super.onOptionsItemSelected(paramMenuItem);
    }

    public void onPrepareOptionsMenu(Menu paramMenu) {
        super.onPrepareOptionsMenu(paramMenu);
        if (((getActivity() instanceof DrawerLayoutStatus)) && (((DrawerLayoutStatus) getActivity()).isDrawMenuOpen())) {
            return;
        }
        paramMenu.removeGroup(0);
    }

    public void setActionBar(Activity paramActivity) {
        getActivity().getActionBar().show();
        getActivity().getActionBar().setTitle(getString(2131100655));
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/activity/directory/ics/IcsRecommendTopicFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */