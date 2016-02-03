package com.quoord.tapatalkpro.ics.topics;

import android.app.ActionBar;
import android.app.ActionBar.OnNavigationListener;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.quoord.tapatalkpro.action.AddToFavoriate;
import com.quoord.tapatalkpro.action.AddToFavoriate.AddFavoriate;
import com.quoord.tapatalkpro.action.ForumAction;
import com.quoord.tapatalkpro.action.ForumAction.ActionCallBack;
import com.quoord.tapatalkpro.activity.forum.DrawerLayoutStatus;
import com.quoord.tapatalkpro.adapter.forum.ForumRootAdapter;
import com.quoord.tapatalkpro.adapter.forum.LatestTopicAdapter;
import com.quoord.tapatalkpro.adapter.forum.conversation.SubscribeTitleAdapter;
import com.quoord.tapatalkpro.bean.EngineResponse;
import com.quoord.tapatalkpro.bean.Forum;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.bean.ListItemClickable;
import com.quoord.tapatalkpro.bean.NoTopicView;
import com.quoord.tapatalkpro.bean.RebrandingConfig;
import com.quoord.tapatalkpro.bean.TapatalkForum;
import com.quoord.tapatalkpro.bean.Topic;
import com.quoord.tapatalkpro.ics.BaseListFragment;
import com.quoord.tapatalkpro.ics.slidingMenu.BackListAdapter;
import com.quoord.tapatalkpro.ics.slidingMenu.BackListFragment;
import com.quoord.tapatalkpro.ics.slidingMenu.BackListFragment.ChangeUnreadNumbers;
import com.quoord.tapatalkpro.ics.slidingMenu.SlidingMenuActivity;
import com.quoord.tapatalkpro.ics.slidingMenu.TabItem;
import com.quoord.tapatalkpro.ui.ButtomProgress;
import com.quoord.tapatalkpro.util.Prefs;
import com.quoord.tapatalkpro.util.ThemeUtil;
import com.quoord.tapatalkpro.util.Util;
import com.quoord.tools.TwoPanelControllerWithId;

import java.util.ArrayList;

public class TopicsFragment
        extends BaseListFragment
        implements AdapterView.OnItemClickListener, TwoPanelControllerWithId, AddToFavoriate.AddFavoriate {
    private AddToFavoriate addToForums;
    private ActionBar bar;
    private String displayName;
    private boolean isUnread;
    private ListView listview;
    private SlidingMenuActivity mActivity;
    private int menuId;
    private String tag;
    private String title;
    private String topicId;
    public int unReadNumbers = 0;

    public static TopicsFragment newInstance(String paramString1, String paramString2, int paramInt) {
        TopicsFragment localTopicsFragment = new TopicsFragment();
        localTopicsFragment.tag = paramString1;
        localTopicsFragment.displayName = paramString2;
        localTopicsFragment.menuId = paramInt;
        return localTopicsFragment;
    }

    public void changeUnreadNumber(final int paramInt) {
        this.unReadNumbers = paramInt;
        if (this.tag.equalsIgnoreCase(LatestTopicAdapter.UNREAD)) {
            if (isVisible()) {
                if (paramInt <= 0) {
                    break label124;
                }
                this.bar.setTitle(getString(2131100415) + " (" + paramInt + ")");
            }
        }
        for (; ; ) {
            label124:
            try {
                if (((SlidingMenuActivity) getActivity()).getmFrag() != null) {
                    ((BackListFragment) ((SlidingMenuActivity) getActivity()).getmFrag()).setChangeIngerface(new BackListFragment.ChangeUnreadNumbers() {
                        public void setUnreadNumbers(BackListAdapter paramAnonymousBackListAdapter) {
                            int i;
                            if ((paramAnonymousBackListAdapter != null) && (paramAnonymousBackListAdapter.tabItemList != null)) {
                                i = 0;
                                if (i >= paramAnonymousBackListAdapter.tabItemList.size()) {
                                    paramAnonymousBackListAdapter.notifyDataSetChanged();
                                }
                            } else {
                                return;
                            }
                            if (((TabItem) paramAnonymousBackListAdapter.tabItemList.get(i)).getMenuid() == 1013) {
                                if (paramInt <= 0) {
                                    break label116;
                                }
                                ((TabItem) paramAnonymousBackListAdapter.tabItemList.get(i)).setTabName(TopicsFragment.this.getString(2131100415) + " (" + paramInt + ") ");
                            }
                            for (; ; ) {
                                i += 1;
                                break;
                                label116:
                                ((TabItem) paramAnonymousBackListAdapter.tabItemList.get(i)).setTabName(TopicsFragment.this.getString(2131100415));
                            }
                        }
                    });
                    ((BackListFragment) ((SlidingMenuActivity) getActivity()).getmFrag()).ChangeUnreadNumbers();
                }
                return;
            } catch (Exception localException) {
            }
            this.bar.setTitle(getString(2131100415));
        }
    }

    public void changeUnreadTitle() {
        if ((this.title != null) && (!this.title.equals(""))) {
            if (this.unReadNumbers > 0) {
                this.bar.setTitle(this.title + " (" + this.unReadNumbers + ")");
                return;
            }
            this.bar.setTitle(this.title);
            return;
        }
        if (this.unReadNumbers > 0) {
            this.bar.setTitle(getString(2131100415) + " (" + this.unReadNumbers + ")");
            return;
        }
        this.bar.setTitle(getString(2131100415));
    }

    public BaseAdapter getAdapter() {
        return this.adapter;
    }

    public String getIdByTwoPanel() {
        return this.topicId;
    }

    public void initDropDown() {
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(getActivity().getResources().getString(2131100416));
        localArrayList.add(getActivity().getResources().getString(2131100549));
        this.bar.setListNavigationCallbacks(new SubscribeTitleAdapter(getActivity(), localArrayList), new ActionBar.OnNavigationListener() {
            public boolean onNavigationItemSelected(int paramAnonymousInt, long paramAnonymousLong) {
                if ((TopicsFragment.this.getActivity() instanceof DrawerLayoutStatus)) {
                    ((DrawerLayoutStatus) TopicsFragment.this.getActivity()).closeDrawerLay();
                }
                if ((TopicsFragment.this.adapter instanceof LatestTopicAdapter)) {
                    if (paramAnonymousInt != 0) {
                        break label75;
                    }
                    TopicsFragment.this.isUnread = false;
                }
                for (; ; ) {
                    ((LatestTopicAdapter) TopicsFragment.this.adapter).getUnreadTopic(TopicsFragment.this.isUnread);
                    return true;
                    label75:
                    if (paramAnonymousInt == 1) {
                        TopicsFragment.this.isUnread = true;
                    }
                }
            }
        });
    }

    public void markAllForumRead() {
        ((LatestTopicAdapter) this.adapter).cleanDatas();
        this.forumstatus.cleanNewPost();
        changeUnreadNumber(0);
        SlidingMenuActivity.needRefreshCategories = true;
        new ForumAction(this.forumstatus, this.mActivity).markAllRead(new ForumAction.ActionCallBack() {
            public void actionCallBack(EngineResponse paramAnonymousEngineResponse) {
                paramAnonymousEngineResponse.isSuccess();
            }
        });
    }

    public void onActivityCreated(Bundle paramBundle) {
        super.onActivityCreated(paramBundle);
        setMactivity(getActivity());
        this.forumstatus = ((SlidingMenuActivity) getActivity()).forumStatus;
        paramBundle = ButtomProgress.get(this.mActivity);
        if ((this.forumstatus != null) && (this.tag != null) && ((this.tag.equals(LatestTopicAdapter.LATEST)) || (this.forumstatus.isLogin()))) {
            this.adapter = new LatestTopicAdapter(this.mActivity, this.forumstatus.getUrl(), this.tag, this.listview, paramBundle, this.displayName, null, this.forumstatus);
        }
        this.listview.setOnItemClickListener(this);
        this.listview.setOnItemLongClickListener(new topicListLongClickListener());
    }

    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        setHasOptionsMenu(true);
        this.bar = getActivity().getActionBar();
        this.mActivity = ((SlidingMenuActivity) getActivity());
        this.forumstatus = ((SlidingMenuActivity) getActivity()).forumStatus;
        int i;
        if ((this.mActivity.getResources().getBoolean(2131558401)) && (this.mActivity.forumStatus != null) && (this.mActivity.forumStatus.getRebrandingConfig() != null)) {
            paramBundle = this.mActivity.forumStatus.getRebrandingConfig().getOrder();
            if ((this.mActivity.forumStatus != null) && (this.mActivity.forumStatus.getRebrandingConfig() != null) && (paramBundle != null) && (paramBundle.size() > 0)) {
                i = 0;
                if (i < paramBundle.size()) {
                    break label196;
                }
            }
        }
        if (this.displayName != null) {
            if (this.displayName.equals("")) {
                this.bar.setTitle(getActivity().getText(2131099852));
            }
        }
        for (; ; ) {
            this.bar.setDisplayShowHomeEnabled(true);
            this.bar.setHomeButtonEnabled(true);
            return;
            label196:
            if (((TabItem) paramBundle.get(i)).getMenuid() == this.menuId) {
                this.title = ((TabItem) paramBundle.get(i)).getDisplay_name();
            }
            i += 1;
            break;
            this.bar.setTitle(this.displayName);
            continue;
            setActionBar(this.mActivity);
        }
    }

    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        paramViewGroup = paramLayoutInflater.inflate(2130903189, paramViewGroup, false);
        this.listview = ((ListView) paramViewGroup.findViewById(2131231181));
        this.listview.setDivider(null);
        this.listview.setSelector(2131165212);
        this.addToForums = new AddToFavoriate(getActivity(), false);
        paramLayoutInflater = paramViewGroup;
        if (this.forumstatus != null) {
            if (this.forumstatus.tapatalkForum != null) {
                break label89;
            }
            paramLayoutInflater = this.addToForums.getView(paramViewGroup, this);
        }
        label89:
        do {
            do {
                do {
                    return paramLayoutInflater;
                    paramLayoutInflater = paramViewGroup;
                } while (!this.tag.equalsIgnoreCase(LatestTopicAdapter.LATEST));
                paramLayoutInflater = paramViewGroup;
            } while (Util.isFavoriate(getActivity(), this.forumstatus.tapatalkForum.getId().intValue()));
            paramLayoutInflater = paramViewGroup;
        } while (this.forumstatus.isLogin());
        return this.addToForums.getView(paramViewGroup, this);
    }

    public void onHiddenChanged(boolean paramBoolean) {
        super.onHiddenChanged(paramBoolean);
        if (!paramBoolean) {
            setActionBar(this.mActivity);
            refresh();
        }
    }

    public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {
        paramAdapterView = Prefs.get(this.mActivity);
        if (this.tag.equalsIgnoreCase(LatestTopicAdapter.UNREAD)) {
            reduceUnreadNumber();
        }
        if (paramInt < this.adapter.getCount()) {
            Object localObject = this.adapter.getItem(paramInt);
            if ((this.adapter instanceof LatestTopicAdapter)) {
                ((LatestTopicAdapter) this.adapter).currentSelectedPosition = paramInt;
                ((LatestTopicAdapter) this.adapter).notifyDataSetChanged();
            }
            if ((localObject instanceof ListItemClickable)) {
                ((ListItemClickable) localObject).onClick(paramView, this.mActivity);
                if ((localObject instanceof Topic)) {
                    setIdByTwoPanel(((Topic) localObject).getId());
                }
            }
            if ((paramAdapterView.getBoolean("not_landing_alert", true)) && (this.forumstatus.isCanUnread())) {
                this.mActivity.showDialog(40);
                paramAdapterView = Prefs.get(this.mActivity).edit();
                paramAdapterView.putBoolean("not_landing_alert", false);
                paramAdapterView.commit();
            }
        }
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        if (this.adapter != null) {
            switch (paramMenuItem.getItemId()) {
            }
        }
        for (; ; ) {
            return super.onOptionsItemSelected(paramMenuItem);
            ((LatestTopicAdapter) this.adapter).refresh();
            return true;
            if (this.adapter.getMForum() == null) {
                showDialog(23);
            }
            for (; ; ) {
                getActivity().invalidateOptionsMenu();
                return true;
                this.adapter.getMForum().markForumRead(this.adapter, this.mActivity);
            }
            this.mActivity.finish();
        }
    }

    public void onPrepareOptionsMenu(Menu paramMenu) {
        super.onPrepareOptionsMenu(paramMenu);
        if (((getActivity() instanceof DrawerLayoutStatus)) && (((DrawerLayoutStatus) getActivity()).isDrawMenuOpen())) {
            return;
        }
        if ((this.forumstatus != null) && (this.forumstatus.isMarkSubForum()) && (this.tag != null) && ((this.tag.equals(LatestTopicAdapter.UNREAD)) || (this.tag.equals(LatestTopicAdapter.PARTICIPATED))) && (this.adapter != null) && (this.adapter.getCount() > 0) && (!(this.adapter.getItem(0) instanceof NoTopicView))) {
            paramMenu.add(0, 1030, 1, getString(2131099909)).setIcon(ThemeUtil.getMenuIconByPicName("menu_mark_read_new", getActivity())).setShowAsAction(5);
        }
        paramMenu.add(0, 1001, 1, getString(2131099796)).setIcon(ThemeUtil.getMenuIconByPicName("menu_refresh_new", getActivity())).setShowAsAction(1);
    }

    public void onResume() {
        super.onResume();
        if (this.unReadNumbers > 0) {
            changeUnreadNumber(this.unReadNumbers);
        }
        if (this.adapter != null) {
            this.adapter.notifyDataSetChanged();
        }
    }

    public void reduceUnreadNumber() {
        if (this.unReadNumbers > 0) {
            this.unReadNumbers -= 1;
        }
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
        if ((this.tag != null) && (this.tag.equals(LatestTopicAdapter.UNREAD))) {
            setUnreadTitle();
        }
        for (; ; ) {
            this.bar.setSubtitle(null);
            refresh();
            return;
            if ((this.tag != null) && (this.tag.equals(LatestTopicAdapter.LATEST))) {
                setTimeLineTitle();
            } else if ((this.tag != null) && (this.tag.equals(LatestTopicAdapter.PARTICIPATED))) {
                setPaticipatedTitle();
            }
        }
    }

    public void setIdByTwoPanel(String paramString) {
        this.topicId = paramString;
    }

    public void setPaticipatedTitle() {
        this.bar.setTitle("");
        this.bar.setDisplayShowTitleEnabled(false);
        this.bar.setNavigationMode(1);
        initDropDown();
        if (this.isUnread) {
            this.bar.setSelectedNavigationItem(1);
            return;
        }
        this.bar.setSelectedNavigationItem(0);
    }

    public void setTimeLineTitle() {
        this.bar.setNavigationMode(0);
        this.bar.setDisplayShowTitleEnabled(true);
        if ((this.title != null) && (!this.title.equals(""))) {
            this.bar.setTitle(this.title);
            return;
        }
        this.bar.setTitle(getString(2131100418));
    }

    public void setUnreadTitle() {
        this.bar.setNavigationMode(0);
        this.bar.setDisplayShowTitleEnabled(true);
        changeUnreadTitle();
    }

    void showDialog(int paramInt) {
        switch (paramInt) {
            default:
                return;
        }
        new DialogFragment() {
            public Dialog onCreateDialog(Bundle paramAnonymousBundle) {
                new AlertDialog.Builder(getActivity()).setMessage(2131099971).setPositiveButton(2131099792, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {
                        TopicsFragment.this.markAllForumRead();
                    }
                }).setNegativeButton(2131099974, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {
                    }
                }).create();
            }
        }.show(getFragmentManager(), "dailog");
    }

    class topicListLongClickListener
            implements AdapterView.OnItemLongClickListener {
        topicListLongClickListener() {
        }

        public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {
            if (TopicsFragment.this.forumstatus.isLogin()) {
                paramInt -= TopicsFragment.this.listview.getHeaderViewsCount();
                if ((paramInt < TopicsFragment.this.adapter.getCount()) && (TopicsFragment.this.adapter.getCount() > paramInt)) {
                    break label56;
                }
            }
            label56:
            while (!(TopicsFragment.this.adapter.getItem(paramInt) instanceof Topic)) {
                return true;
            }
            ((Topic) TopicsFragment.this.adapter.getItem(paramInt)).getLongClickDialog(TopicsFragment.this.adapter, TopicsFragment.this.mActivity, TopicsFragment.this.forumstatus).show();
            return true;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/ics/topics/TopicsFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */