package com.quoord.tapatalkpro.ics.forum;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Dialog;
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
import com.quoord.tapatalkpro.activity.forum.DrawerLayoutStatus;
import com.quoord.tapatalkpro.activity.forum.SearchActivity;
import com.quoord.tapatalkpro.adapter.forum.ForumRootAdapter;
import com.quoord.tapatalkpro.adapter.forum.SubForumAdapter;
import com.quoord.tapatalkpro.adapter.forum.TopicAdapter;
import com.quoord.tapatalkpro.ads.AdBean;
import com.quoord.tapatalkpro.bean.Forum;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.bean.Topic;
import com.quoord.tapatalkpro.ics.BaseListFragment;
import com.quoord.tapatalkpro.ics.slidingMenu.SlidingMenuActivity;
import com.quoord.tapatalkpro.ui.ButtomProgress;
import com.quoord.tapatalkpro.util.AdvancesearchContrast;
import com.quoord.tapatalkpro.util.ThemeUtil;
import com.quoord.tools.TwoPanelControllerWithId;

import java.util.ArrayList;

public class SubForumFragment
        extends BaseListFragment
        implements SearchView.OnQueryTextListener, SearchView.OnCloseListener, TwoPanelControllerWithId {
    private ActionBar bar;
    LinearLayout footLay;
    private Forum forum;
    private boolean isentrance;
    private int lastclick = -1;
    private ListView listview;
    private SearchView mSearchView;
    private MenuItem searchItem;
    private String topicId;
    private String type;
    private String which;

    private void initActionBar() {
        this.bar.setNavigationMode(0);
        this.bar.setDisplayShowTitleEnabled(true);
        this.bar.setTitle(this.forum.getName());
        this.bar.setSubtitle(null);
    }

    public static SubForumFragment newInstance(Forum paramForum, String paramString) {
        SubForumFragment localSubForumFragment = new SubForumFragment();
        localSubForumFragment.forum = paramForum;
        localSubForumFragment.type = paramString;
        return localSubForumFragment;
    }

    private void setupSearchView(MenuItem paramMenuItem) {
        this.mSearchView.setOnQueryTextListener(this);
        this.mSearchView.setOnCloseListener(this);
    }

    private void showself(Forum paramForum) {
        this.adapter = new SubForumAdapter(this.mActivity, ((SlidingMenuActivity) this.mActivity).getForumStatus().getUrl(), paramForum, this.listview, this.type);
        this.listview.setDivider(null);
        this.listview.setSelector(2131165212);
        if ((this.forumstatus != null) && (this.forumstatus.isLogin())) {
            this.listview.setOnItemLongClickListener(new TopicListLongClickListener());
        }
        getActivity().invalidateOptionsMenu();
    }

    public void getActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
        if ((paramInt1 == 1) && (paramInt2 == -1)) {
            this.adapter.refresh();
        }
    }

    public BaseAdapter getAdapter() {
        return this.adapter;
    }

    public String getIdByTwoPanel() {
        return this.topicId;
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
        if (paramBundle != null) {
            this.forum = ((Forum) paramBundle.getSerializable("forum"));
            this.type = paramBundle.getString("type");
        }
        if ((getActivity() != null) && (this.forum != null)) {
            setMactivity(getActivity());
            initActionBar();
            showself(this.forum);
        }
        this.footLay = ButtomProgress.get(getActivity());
        getActivity().invalidateOptionsMenu();
    }

    public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
        getActivityResult(paramInt1, paramInt2, paramIntent);
        super.onActivityResult(paramInt1, paramInt2, paramIntent);
    }

    public boolean onClose() {
        return false;
    }

    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        if ((getActivity() instanceof SlidingMenuActivity)) {
            this.forumstatus = ((SlidingMenuActivity) getActivity()).forumStatus;
        }
        if (!this.isentrance) {
            setHasOptionsMenu(true);
        }
    }

    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        paramLayoutInflater = paramLayoutInflater.inflate(2130903212, paramViewGroup, false);
        this.listview = ((ListView) paramLayoutInflater.findViewById(2131231254));
        return paramLayoutInflater;
    }

    public void onHiddenChanged(boolean paramBoolean) {
        super.onHiddenChanged(paramBoolean);
        if ((!paramBoolean) && (this.forum != null)) {
            initActionBar();
            if ((SlidingMenuActivity.needRefreshCategories) && (this.adapter != null)) {
                this.adapter.notifyDataSetChanged();
            }
        }
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        switch (paramMenuItem.getItemId()) {
            default:
            case 1001:
            case 1030:
            case 1003:
            case 1007:
            case 1004:
                do {
                    do {
                        do {
                            return super.onOptionsItemSelected(paramMenuItem);
                        } while (this.adapter == null);
                        ((SubForumAdapter) this.adapter).refresh();
                        return true;
                    } while (this.adapter == null);
                    this.adapter.getMForum().markSubForumRead(this.adapter, this.mActivity);
                    return true;
                    if ((this.forum != null) && (this.adapter != null)) {
                        this.forum.subscribeForum(this.adapter, this.mActivity);
                    }
                    getActivity().invalidateOptionsMenu();
                    return true;
                    if ((this.forum != null) && (this.adapter != null)) {
                        this.forum.unSubscribeForum(this.adapter, this.mActivity);
                    }
                    getActivity().invalidateOptionsMenu();
                    return true;
                } while (this.adapter == null);
                ((SubForumAdapter) this.adapter).startNewTopic();
                return true;
            case 1002:
                ((SlidingMenuActivity) getActivity()).showSelectView(1027);
                return true;
        }
        hideKeyBoard();
        return true;
    }

    public void onPrepareOptionsMenu(Menu paramMenu) {
        super.onPrepareOptionsMenu(paramMenu);
        if (((getActivity() instanceof DrawerLayoutStatus)) && (((DrawerLayoutStatus) getActivity()).isDrawMenuOpen())) {
        }
        do {
            do {
                return;
                paramMenu.clear();
            } while (((SlidingMenuActivity) getActivity()).isShare);
            if ((this.forumstatus != null) && (this.forumstatus.isCanSearch()) && (this.forumstatus.isAdvancedSearch()) && (!this.mActivity.getResources().getBoolean(2131558401))) {
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
            if ((this.forumstatus != null) && (this.forumstatus.isLogin())) {
                if ((this.adapter != null) && (((SubForumAdapter) this.adapter).canPost())) {
                    paramMenu.add(0, 1004, 1, getString(2131099794)).setIcon(ThemeUtil.getMenuIconByPicName("bubble_edit", getActivity())).setShowAsAction(2);
                }
                if ((this.forum != null) && (!this.forum.isSubscribe())) {
                    paramMenu.add(0, 1003, 1, getString(2131099807)).setIcon(ThemeUtil.getMenuIconByPicName("menu_subscribe", getActivity())).setShowAsAction(0);
                }
                if ((this.forum != null) && (this.forum.isSubscribe())) {
                    paramMenu.add(0, 1007, 1, getString(2131099847)).setIcon(ThemeUtil.getMenuIconByPicName("menu_subscribe_selected", getActivity())).setShowAsAction(0);
                }
                if ((this.forumstatus != null) && (this.forumstatus.isMarkSubForum()) && (this.forum != null) && (!this.forum.isSubOnly())) {
                    paramMenu.add(0, 1030, 1, getString(2131099909)).setIcon(ThemeUtil.getMenuIconByPicName("menu_mark_read_new", getActivity())).setShowAsAction(5);
                }
            }
        } while ((this.forum == null) || (this.forum.isSubOnly()));
        paramMenu.add(0, 1001, 1, getString(2131099796)).setIcon(ThemeUtil.getMenuIconByPicName("menu_refresh_new", getActivity())).setShowAsAction(1);
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
        if ((this.adapter != null) && (((SubForumAdapter) this.adapter).getCurAdapter() != null)) {
            ((SubForumAdapter) this.adapter).getCurAdapter().notifyDataSetChanged();
        }
    }

    public void onSaveInstanceState(Bundle paramBundle) {
        super.onSaveInstanceState(paramBundle);
        paramBundle.putSerializable("forum", this.forum);
        paramBundle.putString("type", this.type);
    }

    public void queryResult(String paramString) {
        AdvancesearchContrast localAdvancesearchContrast = new AdvancesearchContrast();
        localAdvancesearchContrast.KEYWORD = paramString.trim();
        localAdvancesearchContrast.SHOWPOSTS = false;
        localAdvancesearchContrast.FORUMID = this.forum.getId();
        localAdvancesearchContrast.FORUMNAME = this.forum.getName();
        paramString = new Intent(this.mActivity, SearchActivity.class);
        Bundle localBundle = new Bundle();
        localBundle.putSerializable("contrast", localAdvancesearchContrast);
        localBundle.putSerializable("forumStatus", this.forumstatus);
        paramString.putExtras(localBundle);
        this.mActivity.startActivity(paramString);
    }

    public void setActionBar(Activity paramActivity) {
        if (this.bar == null) {
            this.bar = paramActivity.getActionBar();
        }
        initActionBar();
    }

    public void setIdByTwoPanel(String paramString) {
        this.topicId = paramString;
    }

    public void showDialog(int paramInt) {
        switch (paramInt) {
            default:
                return;
        }
        new ArrayList();
        ((Forum) this.adapter.getItem(this.adapter.getmLongclickItemPosition())).getLongPressDialogFragment(this.adapter, this.mActivity).show(getFragmentManager(), "dailog");
    }

    class TopicListLongClickListener
            implements AdapterView.OnItemLongClickListener {
        TopicListLongClickListener() {
        }

        public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {
            SubForumFragment.this.adapter.mLongclickItemPosition = (paramInt - SubForumFragment.this.listview.getHeaderViewsCount());
            if ((SubForumFragment.this.adapter.getItem(SubForumFragment.this.adapter.mLongclickItemPosition) instanceof AdBean)) {
                return false;
            }
            if ((SubForumFragment.this.adapter.getItem(SubForumFragment.this.adapter.mLongclickItemPosition) instanceof Topic)) {
                ((Topic) SubForumFragment.this.adapter.getItem(SubForumFragment.this.adapter.mLongclickItemPosition)).setForum(SubForumFragment.this.forum);
                ((Topic) SubForumFragment.this.adapter.getItem(SubForumFragment.this.adapter.mLongclickItemPosition)).getLongClickDialog(SubForumFragment.this.adapter, SubForumFragment.this.mActivity, SubForumFragment.this.forumstatus).show();
            }
            for (; ; ) {
                return true;
                if (SubForumFragment.this.forumstatus.isLogin()) {
                    SubForumFragment.this.showDialog(12);
                }
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/ics/forum/SubForumFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */