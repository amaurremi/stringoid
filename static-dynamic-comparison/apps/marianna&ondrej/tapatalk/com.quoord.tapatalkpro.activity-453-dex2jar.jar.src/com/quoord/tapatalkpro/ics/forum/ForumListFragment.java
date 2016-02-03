package com.quoord.tapatalkpro.ics.forum;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.SearchView.OnCloseListener;
import android.widget.SearchView.OnQueryTextListener;
import com.quoord.tapatalkpro.action.AddToFavoriate;
import com.quoord.tapatalkpro.action.AddToFavoriate.AddFavoriate;
import com.quoord.tapatalkpro.activity.forum.DrawerLayoutStatus;
import com.quoord.tapatalkpro.activity.forum.SearchActivity;
import com.quoord.tapatalkpro.adapter.forum.ForumAdapter;
import com.quoord.tapatalkpro.adapter.forum.ForumRootAdapter;
import com.quoord.tapatalkpro.bean.Forum;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.bean.RebrandingConfig;
import com.quoord.tapatalkpro.bean.TapatalkForum;
import com.quoord.tapatalkpro.ics.BaseListFragment;
import com.quoord.tapatalkpro.ics.advancesearch.AdvanceSearchActivity;
import com.quoord.tapatalkpro.ics.slidingMenu.SlidingMenuActivity;
import com.quoord.tapatalkpro.ics.slidingMenu.TabItem;
import com.quoord.tapatalkpro.util.AdvancesearchContrast;
import com.quoord.tapatalkpro.util.ThemeUtil;
import com.quoord.tapatalkpro.util.Util;
import com.quoord.tools.TwoPanelController;

import java.util.ArrayList;

public class ForumListFragment
        extends BaseListFragment
        implements SearchView.OnQueryTextListener, SearchView.OnCloseListener, TwoPanelController, AddToFavoriate.AddFavoriate {
    private static String type;
    private AddToFavoriate addToForums;
    private ActionBar bar;
    public ForumAdapter forumadaper;
    private boolean isLogin;
    private boolean isSortByName = false;
    private ListView listview;
    private SlidingMenuActivity mActivity;
    private SearchView mSearchView;
    private int menuId;
    private MenuItem searchItem;
    private String title;
    public String which;

    private void initActionBar() {
        if (this.bar == null) {
            this.bar = getActivity().getActionBar();
        }
        this.bar.setNavigationMode(0);
        this.bar.setDisplayShowTitleEnabled(true);
        if ((this.title != null) && (!this.title.equals(""))) {
            this.bar.setTitle(this.title);
        }
        for (; ; ) {
            this.bar.setSubtitle(null);
            return;
            if ((this.forumstatus != null) && (this.forumstatus.tapatalkForum != null)) {
                this.bar.setTitle(this.forumstatus.tapatalkForum.getName());
            } else {
                this.bar.setTitle(2131100420);
            }
        }
    }

    public static ForumListFragment newInstance(String paramString, int paramInt) {
        ForumListFragment localForumListFragment = new ForumListFragment();
        type = paramString;
        localForumListFragment.menuId = paramInt;
        return localForumListFragment;
    }

    private void setupSearchView(MenuItem paramMenuItem) {
        this.mSearchView.setOnQueryTextListener(this);
        this.mSearchView.setOnCloseListener(this);
    }

    public BaseAdapter getAdapter() {
        return null;
    }

    public void hideKeyBoard() {
        try {
            ((InputMethodManager) getActivity().getSystemService("input_method")).hideSoftInputFromWindow(this.mSearchView.getWindowToken(), 0);
            return;
        } catch (Exception localException) {
        }
    }

    public void onActivityCreated(Bundle paramBundle) {
        super.onActivityCreated(paramBundle);
        setMactivity(getActivity());
        this.bar = getActivity().getActionBar();
        this.mActivity = ((SlidingMenuActivity) getActivity());
        int i;
        if ((this.mActivity.getResources().getBoolean(2131558401)) && (this.forumstatus != null) && (this.forumstatus.getRebrandingConfig() != null)) {
            paramBundle = this.forumstatus.getRebrandingConfig().getOrder();
            if ((paramBundle != null) && (paramBundle.size() > 0)) {
                i = 0;
            }
        }
        for (; ; ) {
            if (i >= paramBundle.size()) {
                initActionBar();
                this.bar.setSubtitle(null);
                this.forumstatus = ((SlidingMenuActivity) getActivity()).forumStatus;
                if (this.forumstatus != null) {
                    this.isLogin = this.forumstatus.isLogin();
                    boolean bool = false;
                    if (this.isLogin) {
                        bool = true;
                    }
                    this.forumadaper = new ForumAdapter(this.mActivity, this.forumstatus.getUrl(), bool, this.listview, type);
                    this.isLogin = this.forumstatus.isLogin();
                    if (this.isLogin) {
                        this.forumadaper.setOnlyRefresh(true);
                    }
                    this.adapter = this.forumadaper;
                    this.listview.setOnItemLongClickListener(new topicListLongClickListener());
                }
                return;
            }
            if (((TabItem) paramBundle.get(i)).getMenuid() == this.menuId) {
                this.title = ((TabItem) paramBundle.get(i)).getDisplay_name();
            }
            i += 1;
        }
    }

    public boolean onClose() {
        return false;
    }

    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        paramViewGroup = paramLayoutInflater.inflate(2130903189, paramViewGroup, false);
        this.listview = ((ListView) paramViewGroup.findViewById(2131231181));
        this.listview.setDivider(null);
        this.listview.setSelector(2131165212);
        if (this.forumstatus == null) {
            this.forumstatus = ((SlidingMenuActivity) getActivity()).forumStatus;
        }
        this.addToForums = new AddToFavoriate(getActivity(), false);
        if ((this.forumstatus != null) && (this.forumstatus.tapatalkForum == null)) {
            paramLayoutInflater = this.addToForums.getView(paramViewGroup, this);
        }
        do {
            do {
                do {
                    return paramLayoutInflater;
                    paramLayoutInflater = paramViewGroup;
                } while (this.forumstatus == null);
                paramLayoutInflater = paramViewGroup;
            } while (this.forumstatus.isLogin());
            paramLayoutInflater = paramViewGroup;
        } while (Util.isFavoriate(getActivity(), this.forumstatus.tapatalkForum.getId().intValue()));
        return this.addToForums.getView(paramViewGroup, this);
    }

    public void onHiddenChanged(boolean paramBoolean) {
        super.onHiddenChanged(paramBoolean);
        if (!paramBoolean) {
            initActionBar();
            if ((SlidingMenuActivity.needRefreshCategories) && (this.forumadaper != null)) {
                this.forumadaper.notifyDataSetChanged();
            }
            refresh();
        }
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        if (this.forumadaper != null) {
            switch (paramMenuItem.getItemId()) {
            }
        }
        for (; ; ) {
            return super.onOptionsItemSelected(paramMenuItem);
            this.forumadaper.refresh();
            return true;
            if (this.adapter.getMForum() == null) {
                showDialog(23);
            }
            for (; ; ) {
                return true;
                this.adapter.getMForum().markForumRead(this.adapter, getActivity());
            }
            ((SlidingMenuActivity) getActivity()).showSelectView(1027);
            return true;
            this.isSortByName = true;
            this.forumadaper.tabChange(1);
            getActivity().invalidateOptionsMenu();
            return true;
            this.isSortByName = false;
            this.forumadaper.tabChange(0);
            getActivity().invalidateOptionsMenu();
            return true;
            Intent localIntent = new Intent(this.mActivity, AdvanceSearchActivity.class);
            localIntent.putExtra("forumStatus", this.forumstatus);
            this.mActivity.startActivity(localIntent);
        }
    }

    public void onPrepareOptionsMenu(Menu paramMenu) {
        super.onPrepareOptionsMenu(paramMenu);
        if (((getActivity() instanceof DrawerLayoutStatus)) && (((DrawerLayoutStatus) getActivity()).isDrawMenuOpen())) {
        }
        do {
            return;
            paramMenu.clear();
        } while (((SlidingMenuActivity) getActivity()).isShare);
        if ((this.forumstatus != null) && (this.forumstatus.isCanSearch()) && (this.forumstatus.isAdvancedSearch())) {
            if ((this.mActivity != null) && (!this.mActivity.getResources().getBoolean(2131558401))) {
                getActivity().getMenuInflater().inflate(2131623942, paramMenu);
                this.searchItem = paramMenu.findItem(2131231753);
                this.searchItem.setIcon(ThemeUtil.getMenuIconByPicName("ic_menu_search", this.mActivity));
                this.mSearchView = ((SearchView) this.searchItem.getActionView());
                this.mSearchView.requestFocus();
                this.mSearchView.setMaxWidth(this.mActivity.getResources().getDimensionPixelOffset(2131427370));
                int i = getResources().getIdentifier("android:id/search_plate", null, null);
                ((ViewGroup) this.mSearchView.findViewById(i)).setBackgroundResource(2130839292);
                setupSearchView(this.searchItem);
            }
        } else {
            if ((this.forumstatus != null) && (this.forumstatus.isLogin())) {
                paramMenu.add(0, 1030, 1, getString(2131099909)).setIcon(ThemeUtil.getMenuIconByPicName("menu_mark_read_new", getActivity())).setShowAsAction(0);
            }
            if (this.isSortByName) {
                break label412;
            }
            paramMenu.add(0, 1005, 1, getString(2131099876)).setIcon(ThemeUtil.getMenuIconByPicName("menu_forum_by_name", getActivity())).setShowAsAction(0);
        }
        for (; ; ) {
            paramMenu.add(0, 1001, 1, getString(2131099796)).setIcon(ThemeUtil.getMenuIconByPicName("menu_refresh_new", getActivity())).setShowAsAction(0);
            return;
            paramMenu.add(0, 1081, 1, getString(2131099795)).setIcon(ThemeUtil.getMenuIconByPicName("ic_menu_search", getActivity())).setShowAsAction(5);
            break;
            label412:
            paramMenu.add(0, 1006, 1, getString(2131099875)).setIcon(ThemeUtil.getMenuIconByPicName("menu_forum_by_category", getActivity())).setShowAsAction(0);
        }
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

    public void queryResult(String paramString) {
        AdvancesearchContrast localAdvancesearchContrast = new AdvancesearchContrast();
        localAdvancesearchContrast.KEYWORD = paramString.trim();
        localAdvancesearchContrast.SHOWPOSTS = false;
        paramString = new Intent(this.mActivity, SearchActivity.class);
        Bundle localBundle = new Bundle();
        localBundle.putSerializable("contrast", localAdvancesearchContrast);
        localBundle.putSerializable("forumStatus", this.forumstatus);
        paramString.putExtras(localBundle);
        this.mActivity.startActivity(paramString);
    }

    public void refresh() {
        if (((this.mActivity instanceof SlidingMenuActivity)) && (this.mActivity.isHide_addFavoriate_view) && (this.addToForums != null) && (this.addToForums.layout != null)) {
            this.addToForums.layout.setVisibility(8);
        }
    }

    public void saveFavoriate() {
        Util.saveFavoriate(this.mActivity, this.forumstatus.tapatalkForum, this.mActivity.channel, true);
    }

    public void setActionBar(Activity paramActivity) {
        if (this.bar == null) {
            this.bar = paramActivity.getActionBar();
        }
        initActionBar();
    }

    void showDialog(int paramInt) {
        switch (paramInt) {
        }
        do {
            return;
            new DialogFragment() {
                public Dialog onCreateDialog(Bundle paramAnonymousBundle) {
                    new AlertDialog.Builder(getActivity()).setMessage(ForumListFragment.this.mActivity.getString(2131099971)).setPositiveButton(ForumListFragment.this.mActivity.getString(2131099792), new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {
                            ForumListFragment.this.forumadaper.markForumRead();
                            ((SlidingMenuActivity) ForumListFragment .1. this.getActivity()).getUnreadNumbers();
                        }
                    }).setNegativeButton(ForumListFragment.this.mActivity.getString(2131099974), new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {
                        }
                    }).create();
                }
            }.show(getFragmentManager(), "dailog");
            return;
        } while (this.forumadaper == null);
        new ArrayList();
        ((Forum) this.forumadaper.getItem(this.forumadaper.getmLongclickItemPosition())).getLongPressDialogFragment(this.forumadaper, this.mActivity).show(getFragmentManager(), "dailog");
    }

    class topicListLongClickListener
            implements AdapterView.OnItemLongClickListener {
        topicListLongClickListener() {
        }

        public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {
            ForumListFragment.this.forumadaper.mLongclickItemPosition = (paramInt - ForumListFragment.this.listview.getHeaderViewsCount());
            if (ForumListFragment.this.forumstatus.isLogin()) {
                ForumListFragment.this.showDialog(12);
            }
            return true;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/ics/forum/ForumListFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */