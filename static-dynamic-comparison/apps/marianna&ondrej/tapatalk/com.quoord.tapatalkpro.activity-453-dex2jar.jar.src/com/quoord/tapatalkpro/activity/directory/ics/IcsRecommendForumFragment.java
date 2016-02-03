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
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.quoord.tapatalkpro.action.AddToFavoriate;
import com.quoord.tapatalkpro.action.AddToFavoriate.AddFavoriate;
import com.quoord.tapatalkpro.activity.forum.DrawerLayoutStatus;
import com.quoord.tapatalkpro.adapter.directory.ics.IcsRecommendForumAdapter;
import com.quoord.tapatalkpro.bean.TapatalkForum;
import com.quoord.tapatalkpro.ics.slidingMenu.SettingsFragment;
import com.quoord.tapatalkpro.ui.ics.QuoordFragment;
import com.quoord.tapatalkpro.util.Util;
import com.quoord.tools.TwoPanelController;

import java.util.ArrayList;

public class IcsRecommendForumFragment
        extends QuoordFragment
        implements TwoPanelController, AddToFavoriate.AddFavoriate {
    private AddToFavoriate addToForums;
    private IcsRecommendForumAdapter icsRecommendForumAdapter;
    private ArrayList<Object> mDatas;
    private ListView mListView;
    private TextView noDataView;
    private TextView text;

    private void initNeedAfterActivityCreated() {
        this.text.setText(getString(2131100654));
        this.text.setGravity(3);
        this.text.setEnabled(false);
        this.text.setPadding(24, 23, 24, 23);
        this.text.setLineSpacing(4.0F, 1.0F);
        this.text.setTextSize(14.0F);
        if (!SettingsFragment.isLightTheme(getActivity())) {
            this.text.setTextColor(getResources().getColor(2131165283));
        }
        for (; ; ) {
            this.mListView.setAdapter(this.icsRecommendForumAdapter);
            this.mListView.setSelector(2131165212);
            return;
            this.text.setTextColor(getResources().getColor(2131165570));
        }
    }

    public static IcsRecommendForumFragment newInstance(ArrayList<Object> paramArrayList) {
        IcsRecommendForumFragment localIcsRecommendForumFragment = new IcsRecommendForumFragment();
        localIcsRecommendForumFragment.mDatas = paramArrayList;
        return localIcsRecommendForumFragment;
    }

    public BaseAdapter getAdapter() {
        return this.icsRecommendForumAdapter;
    }

    public void onActivityCreated(Bundle paramBundle) {
        getActivity().getActionBar().setDisplayShowTitleEnabled(true);
        getActivity().getActionBar().setDisplayShowHomeEnabled(true);
        getActivity().getActionBar().setDisplayHomeAsUpEnabled(true);
        setActionBar(getActivity());
        if ((this.mDatas != null) && (this.mDatas.size() <= 0)) {
            this.noDataView.setVisibility(0);
            this.addToForums.layout.setVisibility(8);
        }
        this.icsRecommendForumAdapter = new IcsRecommendForumAdapter(getActivity(), this.mDatas, this.mListView, this.addToForums);
        initNeedAfterActivityCreated();
        super.onActivityCreated(paramBundle);
    }

    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        paramLayoutInflater = paramLayoutInflater.inflate(2130903340, null);
        this.mListView = ((ListView) paramLayoutInflater.findViewById(2131231569));
        this.mListView.setFooterDividersEnabled(false);
        this.mListView.setDivider(null);
        this.noDataView = ((TextView) paramLayoutInflater.findViewById(2131231090));
        this.text = ((TextView) paramLayoutInflater.findViewById(2131231568));
        this.addToForums = new AddToFavoriate(getActivity(), false, true);
        return this.addToForums.getView(paramLayoutInflater, this);
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        switch (paramMenuItem.getItemId()) {
        }
        for (; ; ) {
            return super.onOptionsItemSelected(paramMenuItem);
            int i = 0;
            for (; ; ) {
                if (i >= this.icsRecommendForumAdapter.forumList.size()) {
                    this.icsRecommendForumAdapter.forumList.clear();
                    this.icsRecommendForumAdapter.notifyDataSetChanged();
                    getActivity().invalidateOptionsMenu();
                    this.addToForums.layout.setVisibility(8);
                    break;
                }
                if (((TapatalkForum) this.icsRecommendForumAdapter.getItem(i)).isSelected()) {
                    this.icsRecommendForumAdapter.setItemSelected(i);
                }
                i += 1;
            }
            i = 0;
            for (; ; ) {
                if (i >= this.icsRecommendForumAdapter.baseData.size()) {
                    this.icsRecommendForumAdapter.notifyDataSetChanged();
                    getActivity().invalidateOptionsMenu();
                    this.addToForums.layout.setVisibility(0);
                    break;
                }
                if (!((TapatalkForum) this.icsRecommendForumAdapter.getItem(i)).isSelected()) {
                    this.icsRecommendForumAdapter.setItemSelected(i);
                    this.icsRecommendForumAdapter.forumList.add((TapatalkForum) this.icsRecommendForumAdapter.getItem(i));
                }
                i += 1;
            }
            if ((getActivity() instanceof IcsRecommendActivity)) {
                if (((IcsRecommendActivity) getActivity()).add_favoriate) {
                    Intent localIntent = new Intent(getActivity(), AccountEntryActivity.class);
                    localIntent.putExtra("add_favoriate", ((IcsRecommendActivity) getActivity()).add_favoriate);
                    getActivity().startActivity(localIntent);
                }
                getActivity().finish();
            }
        }
    }

    public void onPrepareOptionsMenu(Menu paramMenu) {
        super.onPrepareOptionsMenu(paramMenu);
        if (((getActivity() instanceof DrawerLayoutStatus)) && (((DrawerLayoutStatus) getActivity()).isDrawMenuOpen())) {
            return;
        }
        paramMenu.removeGroup(0);
        if (this.icsRecommendForumAdapter != null) {
            if (this.icsRecommendForumAdapter.baseData.size() == this.icsRecommendForumAdapter.forumList.size()) {
                paramMenu.add(0, 4001, 1, getString(2131100664)).setShowAsAction(2);
                return;
            }
            paramMenu.add(0, 4000, 1, getString(2131100663)).setShowAsAction(2);
            return;
        }
        paramMenu.add(0, 4001, 1, getString(2131100664)).setShowAsAction(2);
    }

    public void refresh() {
    }

    public void saveFavoriate() {
        Util.saveFavoriate(getActivity(), this.icsRecommendForumAdapter.forumList, "push");
    }

    public void setActionBar(Activity paramActivity) {
        getActivity().getActionBar().show();
        getActivity().getActionBar().setTitle(getString(2131100653));
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/activity/directory/ics/IcsRecommendForumFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */