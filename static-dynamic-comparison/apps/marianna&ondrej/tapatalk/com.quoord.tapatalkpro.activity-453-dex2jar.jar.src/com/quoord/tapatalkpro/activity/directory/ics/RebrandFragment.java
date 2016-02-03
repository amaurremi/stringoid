package com.quoord.tapatalkpro.activity.directory.ics;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.SearchView.OnCloseListener;
import android.widget.SearchView.OnQueryTextListener;
import com.quoord.tapatalkpro.TapatalkApp;
import com.quoord.tapatalkpro.action.YukuSearchAction;
import com.quoord.tapatalkpro.adapter.directory.ics.RebrandAdapter;
import com.quoord.tapatalkpro.bean.ForumItemBean;
import com.quoord.tapatalkpro.bean.TapatalkForum;
import com.quoord.tapatalkpro.cache.AppCacheManager;
import com.quoord.tapatalkpro.sqlhelper.FavoriateSqlHelper;
import com.quoord.tapatalkpro.ui.ics.QuoordFragment;
import com.quoord.tapatalkpro.util.ThemeUtil;
import com.quoord.tapatalkpro.util.Util;

import java.util.ArrayList;

public class RebrandFragment
        extends QuoordFragment
        implements SearchView.OnQueryTextListener, SearchView.OnCloseListener {
    public RebrandAdapter adapter = null;
    private ActionMode anMode;
    private ActionBar bar;
    private AnActionModeOfYuku callback = null;
    private FavoriateSqlHelper helper;
    private ListView listView = null;
    private IcsRebrandingEntryActivity mActivity = null;
    private SearchView mSearchView;
    private MenuItem searchItem;
    public int selectedPosition = -1;

    public static RebrandFragment newInstance() {
        return new RebrandFragment();
    }

    private void setupSearchView(MenuItem paramMenuItem) {
        paramMenuItem.setShowAsActionFlags(9);
        this.mSearchView.setOnQueryTextListener(this);
        this.mSearchView.setOnCloseListener(this);
    }

    public void onActivityCreated(Bundle paramBundle) {
        super.onActivityCreated(paramBundle);
        this.mActivity = ((IcsRebrandingEntryActivity) getActivity());
        this.bar = this.mActivity.getActionBar();
        this.bar.setDisplayShowHomeEnabled(true);
        this.bar.setDisplayShowTitleEnabled(true);
        this.bar.setTitle(TapatalkApp.rebranding_name);
        Util.showMenu(getActivity());
        this.mActivity.setmFrag(this);
        this.helper = new FavoriateSqlHelper(this.mActivity, TapatalkApp.database_name, null, Integer.parseInt(TapatalkApp.database_version));
        this.adapter = new RebrandAdapter(this.mActivity);
        this.listView.setAdapter(this.adapter);
        this.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong) {
                paramAnonymousAdapterView = (ForumItemBean) RebrandFragment.this.adapter.mDatas.get(paramAnonymousInt);
                paramAnonymousView = RebrandFragment.this.helper.getFavrivateById(paramAnonymousAdapterView.getForumId());
                if (paramAnonymousView != null) {
                    paramAnonymousView.openTapatalkForum(RebrandFragment.this.mActivity, false);
                    return;
                }
                paramAnonymousView = new TapatalkForum();
                paramAnonymousView.setId(Integer.valueOf(paramAnonymousAdapterView.getForumId()));
                paramAnonymousView.setIconUrl(paramAnonymousAdapterView.getIconUrl());
                paramAnonymousView.setName(paramAnonymousAdapterView.getForumName());
                paramAnonymousView.setUrl(paramAnonymousAdapterView.getForumUrl());
                paramAnonymousView.openTapatalkForum(RebrandFragment.this.mActivity, false);
            }
        });
        this.listView.setOnItemLongClickListener(new RebrandOnItemLongClickListener());
    }

    public boolean onClose() {
        return false;
    }

    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        paramLayoutInflater = paramLayoutInflater.inflate(2130903337, null);
        this.listView = ((ListView) paramLayoutInflater.findViewById(2131231395));
        this.listView.setDivider(null);
        this.listView.setSelector(2131165212);
        return paramLayoutInflater;
    }

    public void onHiddenChanged(boolean paramBoolean) {
        super.onHiddenChanged(paramBoolean);
        if (!paramBoolean) {
            this.bar.setDisplayShowTitleEnabled(true);
            this.bar.setTitle(TapatalkApp.rebranding_name);
        }
    }

    public void onPrepareOptionsMenu(Menu paramMenu) {
        paramMenu.removeGroup(0);
        getActivity().getMenuInflater().inflate(2131623942, paramMenu);
        this.searchItem = paramMenu.findItem(2131231753);
        this.searchItem.setIcon(ThemeUtil.getMenuIconByPicName("ic_menu_search", getActivity()));
        this.mSearchView = ((SearchView) this.searchItem.getActionView());
        this.mSearchView.requestFocus();
        setupSearchView(this.searchItem);
    }

    public boolean onQueryTextChange(String paramString) {
        return false;
    }

    public boolean onQueryTextSubmit(String paramString) {
        queryResult(paramString);
        ((InputMethodManager) getActivity().getSystemService("input_method")).hideSoftInputFromWindow(this.mSearchView.getWindowToken(), 0);
        this.mSearchView.clearFocus();
        return true;
    }

    public void onResume() {
        super.onResume();
        this.adapter.mDatas.clear();
        this.adapter.addDefualtForum();
        this.adapter.getLoginForum();
        this.adapter.getCacheForum();
        this.adapter.notifyDataSetChanged();
    }

    public void queryResult(String paramString) {
        new YukuSearchAction(this.mActivity, paramString, this.adapter);
    }

    class AnActionModeOfYuku
            implements ActionMode.Callback {
        private TapatalkForum forum;
        private int position;

        public AnActionModeOfYuku(int paramInt, TapatalkForum paramTapatalkForum) {
            this.position = paramInt;
            this.forum = paramTapatalkForum;
        }

        public boolean onActionItemClicked(ActionMode paramActionMode, MenuItem paramMenuItem) {
            switch (paramMenuItem.getItemId()) {
            }
            for (; ; ) {
                return true;
                if (this.forum != null) {
                    paramMenuItem = RebrandFragment.this.helper.getFavrivateById(this.forum.getId());
                    if (paramMenuItem != null) {
                        RebrandFragment.this.helper.deleteFavoriate(paramMenuItem);
                    }
                }
                RebrandFragment.this.adapter.forumItemId.remove(this.position);
                RebrandFragment.this.adapter.mDatas.remove(this.position);
                RebrandFragment.this.adapter.notifyDataSetChanged();
                AppCacheManager.cacheData(RebrandFragment.this.adapter.cacheFile, RebrandFragment.this.adapter.mDatas);
                paramActionMode.finish();
            }
        }

        public boolean onCreateActionMode(ActionMode paramActionMode, Menu paramMenu) {
            paramMenu.add(0, 1147, 0, RebrandFragment.this.mActivity.getString(2131099790)).setIcon(ThemeUtil.getMenuIconByPicName("ic_menu_delete", RebrandFragment.this.mActivity)).setShowAsAction(2);
            return true;
        }

        public void onDestroyActionMode(ActionMode paramActionMode) {
            RebrandFragment.this.selectedPosition = -1;
            RebrandFragment.this.callback = null;
            RebrandFragment.this.listView.setOnItemLongClickListener(new RebrandFragment.RebrandOnItemLongClickListener(RebrandFragment.this));
            RebrandFragment.this.adapter.notifyDataSetChanged();
        }

        public boolean onPrepareActionMode(ActionMode paramActionMode, Menu paramMenu) {
            return false;
        }
    }

    class RebrandOnItemLongClickListener
            implements AdapterView.OnItemLongClickListener {
        RebrandOnItemLongClickListener() {
        }

        public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {
            paramAdapterView = (ForumItemBean) RebrandFragment.this.adapter.mDatas.get(paramInt);
            RebrandFragment.this.selectedPosition = (paramAdapterView.getForumId() + paramAdapterView.getUserName()).hashCode();
            paramAdapterView = RebrandFragment.this.helper.getFavrivateById(paramAdapterView.getForumId());
            if (RebrandFragment.this.callback == null) {
                RebrandFragment.this.callback = new RebrandFragment.AnActionModeOfYuku(RebrandFragment.this, paramInt, paramAdapterView);
                RebrandFragment.this.anMode = RebrandFragment.this.mActivity.startActionMode(RebrandFragment.this.callback);
                RebrandFragment.this.adapter.notifyDataSetChanged();
            }
            return true;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/activity/directory/ics/RebrandFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */