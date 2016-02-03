package com.quoord.tapatalkpro.ics.slidingMenu;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.quoord.tapatalkpro.TapatalkApp;
import com.quoord.tapatalkpro.action.CmsUrlWordPressSupportAction;
import com.quoord.tapatalkpro.action.CmsUrlWordPressSupportAction.CmsUrlInterface;
import com.quoord.tapatalkpro.adapter.forum.ForumAdapter;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.bean.TapatalkForum;
import com.quoord.tapatalkpro.resourcefactory.AbsColorFactory;
import com.quoord.tapatalkpro.resourcefactory.AbsColorRender;
import com.quoord.tapatalkpro.resourcefactory.backlist.BackListItemBackColorFactory;
import com.quoord.tapatalkpro.util.Prefs;
import com.quoord.tapatalkpro.util.RebrandingUtil;
import com.quoord.tapatalkpro.util.ThemeUtil;
import com.zgy.view.listview.StickyListHeadersListView;

import java.util.ArrayList;

public class BackListFragment
        extends Fragment {
    public CmsUrlWordPressSupportAction action;
    private BackListAdapter adapter = null;
    private AddBlogMenuItem addBlogMenuitem = null;
    private RelativeLayout backLay;
    private ChangeUnreadNumbers changeIngerface = null;
    public ForumStatus forumStatus;
    private LinearLayout layout = null;
    private StickyListHeadersListView listview;
    private SlidingMenuActivity mActivity;
    private Handler mListClickHandler;
    private ArrayList order;
    private SharedPreferences prefs = null;
    private int selectedMid = -1;
    private boolean subscribe = false;
    private ArrayList<TabItem> tabLists = new ArrayList();
    private TextView tip;

    public static BackListFragment newInstance(ForumStatus paramForumStatus, int paramInt) {
        BackListFragment localBackListFragment = new BackListFragment();
        localBackListFragment.forumStatus = paramForumStatus;
        localBackListFragment.selectedMid = paramInt;
        return localBackListFragment;
    }

    private void setListSelectorAndBackgroud() {
        AbsColorRender localAbsColorRender = new BackListItemBackColorFactory().createColorRender(getActivity(), -1);
        this.backLay.setBackgroundColor(localAbsColorRender.getDefaultColor());
        this.listview.setBackgroundColor(localAbsColorRender.getDefaultColor());
    }

    public void AddBlogMenuItem() {
        if (this.addBlogMenuitem != null) {
            this.addBlogMenuitem.addBlogMenuItem(this.adapter);
        }
    }

    public void ChangeUnreadNumbers() {
        if ((this.changeIngerface != null) && (this.adapter != null)) {
            this.changeIngerface.setUnreadNumbers(this.adapter);
        }
    }

    public void SetSelectMenuTab(int paramInt) {
        int i;
        if ((this.adapter != null) && (paramInt != -1)) {
            i = 0;
            if (i >= this.adapter.tabItemList.size()) {
                this.adapter.notifyDataSetChanged();
            }
        } else {
            return;
        }
        if (((TabItem) this.adapter.tabItemList.get(i)).getMenuid() == paramInt) {
            ((TabItem) this.adapter.tabItemList.get(i)).setSelected(true);
        }
        for (; ; ) {
            i += 1;
            break;
            ((TabItem) this.adapter.tabItemList.get(i)).setSelected(false);
        }
    }

    public BackListAdapter getAdapter() {
        return this.adapter;
    }

    public AddBlogMenuItem getAddBlogMenuitem() {
        return this.addBlogMenuitem;
    }

    public ChangeUnreadNumbers getChangeIngerface() {
        return this.changeIngerface;
    }

    public void initTabMenu(final Activity paramActivity, ArrayList<TabItem> paramArrayList) {
        if ((this.forumStatus != null) && (this.forumStatus.isLogin())) {
            if (this.selectedMid != 1018) {
                new Thread() {
                    public void run() {
                        Looper.prepare();
                        ForumAdapter localForumAdapter = new ForumAdapter(paramActivity, BackListFragment.this.forumStatus.getUrl(), true);
                        localForumAdapter.setOnlyRefresh(true);
                        localForumAdapter.getForum();
                    }
                }.start();
            }
            paramArrayList.add(new TabItem(paramActivity.getString(2131100425), false, 1010));
            if ((this.forumStatus != null) && (this.forumStatus.tapatalkForum != null) && (this.forumStatus.tapatalkForum.isFeed())) {
                localTabItem = new TabItem(paramActivity.getResources().getString(2131100638), false, 2002);
                paramArrayList.add(localTabItem);
                if (SettingsFragment.isLightTheme(paramActivity)) {
                    localTabItem.setIcon(2130839027);
                    localTabItem.setIconSelected(2130839026);
                }
            } else {
                if ((this.forumStatus != null) && (this.forumStatus.isAlert())) {
                    localTabItem = new TabItem(paramActivity.getString(2131100413), false, 1024);
                    if (!SettingsFragment.isLightTheme(paramActivity)) {
                        break label850;
                    }
                    localTabItem.setIcon(2130839015);
                    localTabItem.setIconSelected(2130839014);
                    label191:
                    paramArrayList.add(localTabItem);
                }
                if (((this.forumStatus != null) && (this.forumStatus.isSubscribeForum())) || (this.subscribe)) {
                    localTabItem = new TabItem(paramActivity.getString(2131100417), false, 1019);
                    if (!SettingsFragment.isLightTheme(paramActivity)) {
                        break label865;
                    }
                    localTabItem.setIcon(2130839059);
                    localTabItem.setIconSelected(2130839058);
                    label258:
                    paramArrayList.add(localTabItem);
                }
                if (!this.subscribe) {
                    localTabItem = new TabItem(paramActivity.getString(2131100417), false, 1036);
                    if (!SettingsFragment.isLightTheme(paramActivity)) {
                        break label880;
                    }
                    localTabItem.setIcon(2130839059);
                    localTabItem.setIconSelected(2130839058);
                    label308:
                    paramArrayList.add(localTabItem);
                }
                localTabItem = new TabItem(paramActivity.getString(2131100416), false, 1014);
                if (!SettingsFragment.isLightTheme(paramActivity)) {
                    break label895;
                }
                localTabItem.setIcon(2130839081);
                localTabItem.setIconSelected(2130839080);
                label351:
                paramArrayList.add(localTabItem);
                if ((this.forumStatus != null) && (this.forumStatus.isCanUnread())) {
                    localTabItem = new TabItem(paramActivity.getString(2131100415), false, 1013);
                    if (!SettingsFragment.isLightTheme(paramActivity)) {
                        break label910;
                    }
                    localTabItem.setIcon(2130839104);
                    localTabItem.setIconSelected(2130839103);
                    label411:
                    paramArrayList.add(localTabItem);
                }
                if ((this.forumStatus != null) && (this.forumStatus.tapatalkForum != null) && (this.forumStatus.tapatalkForum.isPMEnable()) && (this.forumStatus.isLogin())) {
                    if (!this.forumStatus.tapatalkForum.isSupportConve()) {
                        break label940;
                    }
                    localTabItem = new TabItem(paramActivity.getString(2131100422), false, 1020);
                    if (!SettingsFragment.isLightTheme(paramActivity)) {
                        break label925;
                    }
                    localTabItem.setIcon(2130839021);
                    localTabItem.setIconSelected(2130839020);
                    label507:
                    paramArrayList.add(localTabItem);
                }
                label513:
                localTabItem = new TabItem(paramActivity.getString(2131100418), false, 1016);
                if (!SettingsFragment.isLightTheme(paramActivity)) {
                    break label1015;
                }
                localTabItem.setIcon(2130839100);
                localTabItem.setIconSelected(2130839099);
                label551:
                paramArrayList.add(localTabItem);
                localTabItem = new TabItem(paramActivity.getString(2131100428), false, 1018);
                if (!SettingsFragment.isLightTheme(paramActivity)) {
                    break label1032;
                }
                localTabItem.setIcon(2130839030);
                localTabItem.setIconSelected(2130839029);
                label597:
                paramArrayList.add(localTabItem);
                if ((this.forumStatus != null) && (this.forumStatus.isCanSearch())) {
                    localTabItem = new TabItem(paramActivity.getString(2131100412), false, 1011);
                    if (!SettingsFragment.isLightTheme(paramActivity)) {
                        break label1049;
                    }
                    localTabItem.setIcon(2130839011);
                    localTabItem.setIconSelected(2130839010);
                    label660:
                    paramArrayList.add(localTabItem);
                }
                if ((this.forumStatus != null) && (this.forumStatus.isLogin()) && (this.forumStatus.isCanWhoOnline())) {
                    localTabItem = new TabItem(paramActivity.getString(2131100423), false, 1028);
                    if (!SettingsFragment.isLightTheme(paramActivity)) {
                        break label1066;
                    }
                    localTabItem.setIcon(2130839049);
                    localTabItem.setIconSelected(2130839048);
                    label733:
                    paramArrayList.add(localTabItem);
                }
                if ((this.forumStatus != null) && (this.forumStatus.isVersionSupportMod()) && (this.forumStatus.isCanModerate())) {
                    localTabItem = new TabItem(paramActivity.getString(2131099855), false, 1038);
                    if (!SettingsFragment.isLightTheme(paramActivity)) {
                        break label1083;
                    }
                    localTabItem.setIcon(2130839045);
                    localTabItem.setIconSelected(2130839044);
                    label806:
                    paramArrayList.add(localTabItem);
                }
                paramArrayList.add(new TabItem(paramActivity.getString(2131100425), false, 1044));
            }
        }
        label850:
        label865:
        label880:
        label895:
        label910:
        label925:
        label940:
        label1015:
        label1032:
        label1049:
        label1066:
        label1083:
        label1198:
        label1251:
        label1257:
        label1312:
        label1378:
        do {
            return;
            localTabItem.setIcon(2130839026);
            localTabItem.setIconSelected(2130839026);
            break;
            localTabItem.setIcon(2130839014);
            localTabItem.setIconSelected(2130839014);
            break label191;
            localTabItem.setIcon(2130839058);
            localTabItem.setIconSelected(2130839058);
            break label258;
            localTabItem.setIcon(2130839058);
            localTabItem.setIconSelected(2130839058);
            break label308;
            localTabItem.setIcon(2130839080);
            localTabItem.setIconSelected(2130839080);
            break label351;
            localTabItem.setIcon(2130839103);
            localTabItem.setIconSelected(2130839103);
            break label411;
            localTabItem.setIcon(2130839020);
            localTabItem.setIconSelected(2130839020);
            break label507;
            if (!this.forumStatus.tapatalkForum.isPMEnable()) {
                break label513;
            }
            localTabItem = new TabItem(paramActivity.getString(2131099861), false, 1021);
            if (SettingsFragment.isLightTheme(paramActivity)) {
                localTabItem.setIcon(2130839021);
                localTabItem.setIconSelected(2130839020);
            }
            for (; ; ) {
                paramArrayList.add(localTabItem);
                break;
                localTabItem.setIcon(2130839020);
                localTabItem.setIconSelected(2130839020);
            }
            localTabItem.setIcon(2130839099);
            localTabItem.setIconSelected(2130839099);
            break label551;
            localTabItem.setIcon(2130839029);
            localTabItem.setIconSelected(2130839029);
            break label597;
            localTabItem.setIcon(2130839010);
            localTabItem.setIconSelected(2130839010);
            break label660;
            localTabItem.setIcon(2130839048);
            localTabItem.setIconSelected(2130839048);
            break label733;
            localTabItem.setIcon(2130839044);
            localTabItem.setIconSelected(2130839044);
            break label806;
            paramArrayList.add(new TabItem(paramActivity.getString(2131100425), false, 1010));
            if ((this.forumStatus != null) && (this.forumStatus.tapatalkForum != null) && (this.forumStatus.tapatalkForum.isFeed())) {
                localTabItem = new TabItem(paramActivity.getResources().getString(2131100638), false, 2002);
                paramArrayList.add(localTabItem);
                if (!SettingsFragment.isLightTheme(paramActivity)) {
                    break label1451;
                }
                localTabItem.setIcon(2130839027);
                localTabItem.setIconSelected(2130839026);
            }
            if (!paramActivity.getResources().getBoolean(2131558401)) {
                break label1483;
            }
            localTabItem = new TabItem(paramActivity.getString(2131100719), false, 1027);
            if (!SettingsFragment.isLightTheme(paramActivity)) {
                break label1466;
            }
            localTabItem.setIcon(2130839045);
            localTabItem.setIconSelected(2130839044);
            paramArrayList.add(localTabItem);
            if ((this.forumStatus == null) || (!this.forumStatus.isGuestOkay())) {
                break label1530;
            }
            localTabItem = new TabItem(paramActivity.getString(2131100418), false, 1016);
            if (!SettingsFragment.isLightTheme(paramActivity)) {
                break label1549;
            }
            localTabItem.setIcon(2130839100);
            localTabItem.setIconSelected(2130839099);
            if ((this.forumStatus.isLogin()) || (this.forumStatus.isGuestSearch())) {
                paramArrayList.add(localTabItem);
            }
            localTabItem = new TabItem(paramActivity.getString(2131100428), false, 1018);
            if (!SettingsFragment.isLightTheme(paramActivity)) {
                break label1566;
            }
            localTabItem.setIcon(2130839030);
            localTabItem.setIconSelected(2130839029);
            paramArrayList.add(localTabItem);
        } while ((!this.forumStatus.isGuestSearch()) || (!this.forumStatus.isCanSearch()));
        TabItem localTabItem = new TabItem(paramActivity.getString(2131100412), false, 1011);
        if (SettingsFragment.isLightTheme(paramActivity)) {
            localTabItem.setIcon(2130839011);
            localTabItem.setIconSelected(2130839010);
        }
        for (; ; ) {
            paramArrayList.add(localTabItem);
            return;
            label1451:
            localTabItem.setIcon(2130839026);
            localTabItem.setIconSelected(2130839026);
            break label1198;
            label1466:
            localTabItem.setIcon(2130839044);
            localTabItem.setIconSelected(2130839044);
            break label1251;
            label1483:
            localTabItem = new TabItem(paramActivity.getString(2131100509), false, 1027);
            if (SettingsFragment.isLightTheme(paramActivity)) {
                localTabItem.setIcon(2130839045);
                localTabItem.setIconSelected(2130839044);
            }
            for (; ; ) {
                paramArrayList.add(localTabItem);
                break label1257;
                label1530:
                break;
                localTabItem.setIcon(2130839044);
                localTabItem.setIconSelected(2130839044);
            }
            label1549:
            localTabItem.setIcon(2130839099);
            localTabItem.setIconSelected(2130839099);
            break label1312;
            label1566:
            localTabItem.setIcon(2130839029);
            localTabItem.setIconSelected(2130839029);
            break label1378;
            localTabItem.setIcon(2130839010);
            localTabItem.setIconSelected(2130839010);
        }
    }

    public void onActivityCreated(Bundle paramBundle) {
        super.onActivityCreated(paramBundle);
        setListSelectorAndBackgroud();
        this.mActivity = ((SlidingMenuActivity) getActivity());
        if (!this.mActivity.getResources().getBoolean(2131558401)) {
            setListSelectorAndBackgroud();
            this.prefs = Prefs.get(this.mActivity);
            this.subscribe = this.prefs.getBoolean("subscribe", true);
            this.tabLists = RebrandingUtil.initTabMenu(getActivity(), this, this.forumStatus, this.selectedMid);
            this.adapter = new BackListAdapter((SlidingMenuActivity) getActivity(), this, this.tabLists);
            this.adapter.initColorRender();
            this.tip.setBackgroundColor(this.adapter.itemBackColorRender.getBackColor());
            if (!SettingsFragment.isLightTheme(this.mActivity)) {
                break label382;
            }
            this.tip.setTextColor(this.mActivity.getResources().getColor(2131165214));
        }
        int i;
        for (; ; ) {
            this.listview.setAdapter(this.adapter);
            this.listview.post(new Runnable() {
                public void run() {
                    BackListFragment.this.listview.setSelection(BackListFragment.this.adapter.getSelection());
                }
            });
            if ((!this.mActivity.getResources().getBoolean(2131558401)) && (this.forumStatus != null) && (this.forumStatus.tapatalkForum != null) && (this.forumStatus.tapatalkForum.getCms_url() != null) && (!this.forumStatus.tapatalkForum.getCms_url().equals(""))) {
                this.action = new CmsUrlWordPressSupportAction(this.mActivity, this.forumStatus.tapatalkForum.getCms_url(), this.forumStatus, new CmsUrlWordPressSupportAction.CmsUrlInterface() {
                    public void cmsUrlCallback(boolean paramAnonymousBoolean) {
                        TabItem localTabItem;
                        if (paramAnonymousBoolean) {
                            localTabItem = new TabItem(BackListFragment.this.mActivity.getString(2131100429), false, 1201);
                            if (!SettingsFragment.isLightTheme(BackListFragment.this.mActivity)) {
                                break label101;
                            }
                            localTabItem.setIcon(2130839040);
                            localTabItem.setIconSelected(2130839039);
                        }
                        for (; ; ) {
                            if (!BackListFragment.this.adapter.tabItemList.contains(Integer.valueOf(1201))) {
                                BackListFragment.this.adapter.tabItemList.add(1, localTabItem);
                            }
                            BackListFragment.this.adapter.notifyDataSetChanged();
                            return;
                            label101:
                            localTabItem.setIcon(2130839039);
                            localTabItem.setIconSelected(2130839039);
                        }
                    }
                });
            }
            if (this.selectedMid != -1) {
                i = 0;
                if (i < this.adapter.tabItemList.size()) {
                    break label405;
                }
            }
            if (this.mListClickHandler == null) {
                this.mListClickHandler = new Handler(Looper.getMainLooper()) {
                    public void handleMessage(Message paramAnonymousMessage) {
                        BackListFragment.this.mActivity.showFragment(((TabItem) BackListFragment.this.adapter.tabItemList.get(paramAnonymousMessage.what)).getMenuid());
                        int i = 0;
                        for (; ; ) {
                            if (i >= BackListFragment.this.adapter.tabItemList.size()) {
                                ((TabItem) BackListFragment.this.adapter.tabItemList.get(paramAnonymousMessage.what)).setSelected(true);
                                BackListFragment.this.adapter.notifyDataSetChanged();
                                return;
                            }
                            ((TabItem) BackListFragment.this.adapter.tabItemList.get(i)).setSelected(false);
                            i += 1;
                        }
                    }
                };
            }
            this.listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong) {
                    BackListFragment.this.mActivity.toggle();
                    paramAnonymousAdapterView = BackListFragment.this.mListClickHandler.obtainMessage(paramAnonymousInt);
                    BackListFragment.this.mListClickHandler.sendMessageDelayed(paramAnonymousAdapterView, 250L);
                }
            });
            return;
            this.listview.setSelector(2131165212);
            ThemeUtil.setMenuListBackground(getActivity(), this.backLay);
            break;
            label382:
            this.tip.setTextColor(this.mActivity.getResources().getColor(2131165213));
        }
        label405:
        if (this.selectedMid == 1039) {
            this.selectedMid = 1038;
        }
        for (; ; ) {
            if (((TabItem) this.adapter.tabItemList.get(i)).getMenuid() == this.selectedMid) {
                ((TabItem) this.adapter.tabItemList.get(i)).setSelected(true);
            }
            i += 1;
            break;
            if (this.selectedMid == 1040) {
                this.selectedMid = 1038;
            } else if (this.selectedMid == 1041) {
                this.selectedMid = 1038;
            } else if (this.selectedMid == 1042) {
                this.selectedMid = 1038;
            }
        }
    }

    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        paramLayoutInflater = paramLayoutInflater.inflate(2130903191, null);
        this.backLay = ((RelativeLayout) paramLayoutInflater.findViewById(2131231183));
        this.tip = ((TextView) paramLayoutInflater.findViewById(2131231184));
        if ((!getActivity().getResources().getBoolean(2131558401)) || (TapatalkApp.powerBy == 0)) {
            this.tip.setVisibility(8);
        }
        this.listview = ((StickyListHeadersListView) paramLayoutInflater.findViewById(2131231185));
        ThemeUtil.setDiverResource(getActivity(), this.listview);
        if (getActivity().getResources().getBoolean(2131558401)) {
            this.listview.setDividerHeight(1);
            paramViewGroup = new ColorDrawable(getActivity().getResources().getColor(2131165544));
            this.listview.setDivider(paramViewGroup);
        }
        for (; ; ) {
            this.listview.setDrawingListUnderStickyHeader(true);
            return paramLayoutInflater;
            this.listview.setDividerHeight(2);
        }
    }

    public void setAdapter(BackListAdapter paramBackListAdapter) {
        this.adapter = paramBackListAdapter;
    }

    public void setAddBlogMenuitem(AddBlogMenuItem paramAddBlogMenuItem) {
        this.addBlogMenuitem = paramAddBlogMenuItem;
    }

    public void setChangeIngerface(ChangeUnreadNumbers paramChangeUnreadNumbers) {
        this.changeIngerface = paramChangeUnreadNumbers;
    }

    public static abstract interface AddBlogMenuItem {
        public abstract void addBlogMenuItem(BackListAdapter paramBackListAdapter);
    }

    public static abstract interface ChangeUnreadNumbers {
        public abstract void setUnreadNumbers(BackListAdapter paramBackListAdapter);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/ics/slidingMenu/BackListFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */