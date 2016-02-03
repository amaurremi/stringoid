package com.quoord.tapatalkpro.activity.directory.ics;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SectionIndexer;
import android.widget.TextView;
import com.quoord.tapatalkpro.TapatalkApp;
import com.quoord.tapatalkpro.action.RebrandingChecker;
import com.quoord.tapatalkpro.adapter.CallBackInterface;
import com.quoord.tapatalkpro.bean.EngineResponse;
import com.quoord.tapatalkpro.bean.ForumItemBean;
import com.quoord.tapatalkpro.bean.TapatalkForum;
import com.quoord.tapatalkpro.cache.AppCacheManager;
import com.quoord.tapatalkpro.ics.slidingMenu.SettingsActivity;
import com.quoord.tapatalkpro.ics.slidingMenu.SettingsFragment;
import com.quoord.tapatalkpro.sqlhelper.FavoriateSqlHelper;
import com.quoord.tapatalkpro.ui.ButtomProgress;
import com.quoord.tapatalkpro.ui.ics.QuoordFragment;
import com.quoord.tapatalkpro.util.AvatarTool;
import com.quoord.tapatalkpro.util.CustomTracker;
import com.quoord.tapatalkpro.util.Prefs;
import com.quoord.tapatalkpro.util.TapatalkJsonEngine;
import com.quoord.tapatalkpro.util.ThemeUtil;
import com.quoord.tapatalkpro.util.Util;
import com.quoord.tapatalkpro.view.SideBar;

import java.util.ArrayList;
import java.util.HashMap;

public class NetWorkFragment
        extends QuoordFragment {
    private NetWorkAdapter adapter = null;
    private ActionBar bar = null;
    private String cacheFile = null;
    public int currentScrollState;
    private RelativeLayout dfpLayout;
    private LinearLayout footlay = null;
    private FavoriateSqlHelper helper;
    boolean inRelease = false;
    private SideBar indexBar;
    private ListView listView = null;
    private IcsRebrandingEntryActivity mActivity = null;
    private TextView mDialogText;
    private WindowManager mWindowManager;
    private SharedPreferences prefs = null;
    private RebrandingChecker rebrandingChecker;

    public static NetWorkFragment newInstance(RebrandingChecker paramRebrandingChecker) {
        NetWorkFragment localNetWorkFragment = new NetWorkFragment();
        localNetWorkFragment.rebrandingChecker = paramRebrandingChecker;
        return localNetWorkFragment;
    }

    private void setOnScrollListener() {
        this.listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            public void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {
                if ((!NetWorkFragment.this.inRelease) && (paramAnonymousInt1 != 0)) {
                    NetWorkFragment.this.inRelease = true;
                    paramAnonymousInt1 = 0;
                }
                for (; ; ) {
                    if (paramAnonymousInt1 >= NetWorkFragment.this.adapter.ivList.size()) {
                        NetWorkFragment.this.inRelease = false;
                        return;
                    }
                    NetWorkFragment.this.recycleImage((ImageView) NetWorkFragment.this.adapter.ivList.get(paramAnonymousInt1));
                    paramAnonymousInt1 += 1;
                }
            }

            public void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt) {
                int j = 0;
                int i = j;
                if (paramAnonymousInt != 2) {
                    i = j;
                    if (NetWorkFragment.this.currentScrollState == 2) {
                        i = 1;
                    }
                }
                j = i;
                if (paramAnonymousInt == 0) {
                    j = i;
                    if (NetWorkFragment.this.currentScrollState == 1) {
                        j = 1;
                    }
                }
                NetWorkFragment.this.currentScrollState = paramAnonymousInt;
                if (j != 0) {
                    NetWorkFragment.this.adapter.notifyDataSetChanged();
                }
                if ((paramAnonymousInt != 2) && (!NetWorkFragment.this.inRelease) && (paramAnonymousAbsListView.getScrollY() > 10)) {
                    NetWorkFragment.this.inRelease = true;
                    paramAnonymousInt = 0;
                }
                for (; ; ) {
                    if (paramAnonymousInt >= NetWorkFragment.this.adapter.ivList.size()) {
                        NetWorkFragment.this.inRelease = false;
                        return;
                    }
                    NetWorkFragment.this.recycleImage((ImageView) NetWorkFragment.this.adapter.ivList.get(paramAnonymousInt));
                    paramAnonymousInt += 1;
                }
            }
        });
    }

    public int getScrollState() {
        return this.currentScrollState;
    }

    public void onActivityCreated(Bundle paramBundle) {
        super.onActivityCreated(paramBundle);
        this.mActivity = ((IcsRebrandingEntryActivity) getActivity());
        this.bar = this.mActivity.getActionBar();
        this.bar.setDisplayShowHomeEnabled(true);
        this.bar.setDisplayShowTitleEnabled(true);
        this.bar.setTitle(TapatalkApp.rebranding_name);
        Util.showMenu(getActivity());
        this.mDialogText = ((TextView) LayoutInflater.from(this.mActivity).inflate(2130903263, null));
        if (SettingsFragment.isLightTheme(this.mActivity)) {
            this.mDialogText.setBackgroundColor(this.mActivity.getResources().getColor(2131165526));
        }
        for (; ; ) {
            this.mDialogText.setVisibility(4);
            this.mWindowManager = ((WindowManager) getActivity().getSystemService("window"));
            paramBundle = new WindowManager.LayoutParams(-2, -2, 2, 24, -3);
            this.mWindowManager.addView(this.mDialogText, paramBundle);
            this.indexBar.setTextView(this.mDialogText);
            this.indexBar.setListView(this.listView);
            this.prefs = Prefs.get(this.mActivity);
            this.footlay = ButtomProgress.get(this.mActivity);
            this.adapter = new NetWorkAdapter(this.mActivity);
            this.helper = new FavoriateSqlHelper(this.mActivity, TapatalkApp.database_name, null, Integer.parseInt(TapatalkApp.database_version));
            if (this.prefs.contains("dfp_320x50")) {
                this.prefs.getString("dfp_320x50", "");
            }
            this.listView.setAdapter(this.adapter);
            ThemeUtil.setListViewStyle(this.listView, this.mActivity);
            this.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong) {
                    paramAnonymousAdapterView = (ForumItemBean) NetWorkFragment.NetWorkAdapter.access$0(NetWorkFragment.this.adapter).get(paramAnonymousInt);
                    paramAnonymousView = NetWorkFragment.this.helper.getFavrivateById(paramAnonymousAdapterView.getForumId());
                    if (paramAnonymousView != null) {
                        paramAnonymousView.openTapatalkForum(NetWorkFragment.this.mActivity, false);
                        return;
                    }
                    paramAnonymousView = new TapatalkForum();
                    paramAnonymousView.setId(Integer.valueOf(paramAnonymousAdapterView.getForumId()));
                    paramAnonymousView.setIconUrl(paramAnonymousAdapterView.getIconUrl());
                    paramAnonymousView.setName(paramAnonymousAdapterView.getForumName());
                    paramAnonymousView.setUrl(paramAnonymousAdapterView.getForumUrl());
                    paramAnonymousView.openTapatalkForum(NetWorkFragment.this.mActivity, false);
                }
            });
            setOnScrollListener();
            return;
            this.mDialogText.setBackgroundColor(this.mActivity.getResources().getColor(2131165527));
        }
    }

    public void onCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater) {
        paramMenu.removeGroup(0);
        paramMenu.add(0, 1, 0, getResources().getString(2131100000)).setIcon(ThemeUtil.getMenuIconByPicName("ic_menu_setting", getActivity())).setShowAsAction(2);
        super.onCreateOptionsMenu(paramMenu, paramMenuInflater);
    }

    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        paramLayoutInflater = paramLayoutInflater.inflate(2130903278, null);
        this.listView = ((ListView) paramLayoutInflater.findViewById(2131231395));
        this.listView.setDivider(null);
        this.listView.setSelector(2131165212);
        this.dfpLayout = ((RelativeLayout) paramLayoutInflater.findViewById(2131230775));
        this.indexBar = ((SideBar) paramLayoutInflater.findViewById(2131231396));
        return (RelativeLayout) getActivity().getLayoutInflater().inflate(2130903267, null);
    }

    public void onDestroy() {
        super.onDestroy();
        this.mWindowManager.removeView(this.mDialogText);
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        switch (paramMenuItem.getItemId()) {
            default:
                return false;
        }
        startActivity(new Intent(this.mActivity, SettingsActivity.class));
        return true;
    }

    public void onResume() {
        super.onResume();
        this.adapter.mDatas.clear();
        this.adapter.createTempFromDB();
        this.adapter.call();
        this.adapter.notifyDataSetChanged();
    }

    public void onStart() {
        super.onStart();
        CustomTracker.start(this.mActivity);
    }

    public void onStop() {
        super.onStop();
        CustomTracker.stop(this.mActivity);
    }

    public void recycleImage(ImageView paramImageView) {
        if ((paramImageView != null) && (!paramImageView.isShown()) && (paramImageView.getDrawable() != null) && (!((BitmapDrawable) paramImageView.getDrawable()).getBitmap().isRecycled())) {
            ((BitmapDrawable) paramImageView.getDrawable()).getBitmap().recycle();
            paramImageView.setImageDrawable(null);
            paramImageView.setBackgroundColor(this.mActivity.getResources().getColor(2131165213));
        }
    }

    public void setLoadingMoreEnabled(boolean paramBoolean) {
        if ((paramBoolean) && (this.listView.getFooterViewsCount() == 0)) {
            this.listView.addFooterView(this.footlay);
        }
        while ((paramBoolean) || (this.listView.getFooterViewsCount() <= 0)) {
            return;
        }
        this.listView.removeFooterView(this.footlay);
    }

    public class NetWorkAdapter
            extends BaseAdapter
            implements CallBackInterface, SectionIndexer {
        private TapatalkJsonEngine JsonEngine = null;
        private boolean hasItem;
        private FavoriateSqlHelper helper;
        public ArrayList<ImageView> ivList = new ArrayList();
        public ArrayList<ForumItemBean> list = new ArrayList();
        private Activity mActivity = null;
        private ArrayList<ForumItemBean> mDatas = new ArrayList();
        private Typeface tf;

        public NetWorkAdapter(Activity paramActivity) {
            this.mActivity = paramActivity;
            NetWorkFragment.this.cacheFile = AppCacheManager.getNetWorkUrl(this.mActivity);
            this.tf = Typeface.createFromAsset(this.mActivity.getAssets(), "font/Roboto-Light.ttf");
            createTempFromDB();
            call();
        }

        private void call() {
            label82:
            label87:
            int j;
            if (AppCacheManager.checkFile(NetWorkFragment.this.cacheFile)) {
                try {
                    Object localObject = AppCacheManager.getCacheData(NetWorkFragment.this.cacheFile);
                    if ((!(localObject instanceof ArrayList)) || (localObject == null)) {
                        break label189;
                    }
                    this.mDatas = ((ArrayList) localObject);
                    i = 0;
                    if (i < this.list.size()) {
                        break label87;
                    }
                    AppCacheManager.cacheData(NetWorkFragment.this.cacheFile, this.mDatas);
                    NetWorkFragment.this.setLoadingMoreEnabled(false);
                    notifyDataSetChanged();
                } catch (Exception localException) {
                    int i;
                    for (; ; ) {
                    }
                }
                notifyDataSetChanged();
                return;
                j = 0;
            }
            for (; ; ) {
                if (j >= this.mDatas.size()) {
                    i += 1;
                    break;
                }
                if ((((ForumItemBean) this.mDatas.get(i)).getForumName().equals(((ForumItemBean) this.list.get(j)).getForumName())) && (((ForumItemBean) this.mDatas.get(i)).getUserName() == null)) {
                    this.mDatas.remove(i);
                    this.mDatas.add(0, (ForumItemBean) this.list.get(j));
                    break label264;
                    label189:
                    NetWorkFragment.this.setLoadingMoreEnabled(true);
                    break label82;
                    AppCacheManager.del(NetWorkFragment.this.cacheFile);
                    NetWorkFragment.this.setLoadingMoreEnabled(true);
                    this.JsonEngine = new TapatalkJsonEngine(this.mActivity, this);
                    this.JsonEngine.callUri("http://directory.tapatalk.com/n-in-1/network.php?rid=" + TapatalkApp.rebranding_id);
                    return;
                }
                label264:
                j += 1;
            }
        }

        private void createTempFromDB() {
            this.list.clear();
            this.helper = new FavoriateSqlHelper(this.mActivity, TapatalkApp.database_name, null, Integer.parseInt(TapatalkApp.database_version));
            ArrayList localArrayList = this.helper.getFavrivate();
            int i;
            if (localArrayList != null) {
                i = 0;
            }
            for (; ; ) {
                if (i >= localArrayList.size()) {
                    return;
                }
                if ((((TapatalkForum) localArrayList.get(i)).getUserName() != null) && (((TapatalkForum) localArrayList.get(i)).getUserName().length() > 0) && (((TapatalkForum) localArrayList.get(i)).hasPassword())) {
                    ForumItemBean localForumItemBean = new ForumItemBean();
                    TapatalkForum localTapatalkForum = (TapatalkForum) localArrayList.get(i);
                    localForumItemBean.setForumName(localTapatalkForum.getName());
                    localForumItemBean.setForumId(localTapatalkForum.getId().intValue());
                    localForumItemBean.setForumUrl(localTapatalkForum.getUrl());
                    localForumItemBean.setIconUrl(localTapatalkForum.getIconUrl());
                    localForumItemBean.setUserName(((TapatalkForum) localArrayList.get(i)).getUserName());
                    this.list.add(localForumItemBean);
                }
                i += 1;
            }
        }

        private void setSection(LinearLayout paramLinearLayout, String paramString) {
            TextView localTextView = new TextView(this.mActivity);
            paramLinearLayout.setBackgroundColor(-5588020);
            localTextView.setTextColor(-1);
            localTextView.setText(paramString.substring(0, 1).toUpperCase());
            localTextView.setTextSize(20.0F);
            localTextView.setPadding(5, 0, 0, 0);
            localTextView.setGravity(16);
            paramLinearLayout.addView(localTextView);
        }

        public void callBack(EngineResponse paramEngineResponse) {
            HashMap localHashMap = (HashMap) paramEngineResponse.getResponse();
            paramEngineResponse = (Object[]) localHashMap.get("list");
            ((Integer) localHashMap.get("total_forums_num")).intValue();
            this.mDatas.clear();
            int i = 0;
            if (i >= paramEngineResponse.length) {
                AppCacheManager.cacheData(NetWorkFragment.this.cacheFile, this.mDatas);
                NetWorkFragment.this.setLoadingMoreEnabled(false);
                NetWorkFragment.this.adapter.notifyDataSetChanged();
                return;
            }
            localHashMap = (HashMap) paramEngineResponse[i];
            ForumItemBean localForumItemBean = new ForumItemBean();
            localForumItemBean.setForumName((String) localHashMap.get("name"));
            localForumItemBean.setForumId(((Integer) localHashMap.get("id")).intValue());
            localForumItemBean.setForumUrl((String) localHashMap.get("url"));
            if ((localHashMap.containsKey("logo_new")) && (!((String) localHashMap.get("logo_new")).equals(""))) {
                localForumItemBean.setIconUrl((String) localHashMap.get("logo_new"));
            }
            for (; ; ) {
                this.mDatas.add(i, localForumItemBean);
                i += 1;
                break;
                localForumItemBean.setIconUrl((String) localHashMap.get("logo"));
            }
        }

        public int getCount() {
            return this.mDatas.size();
        }

        public Object getItem(int paramInt) {
            return this.mDatas.get(paramInt);
        }

        public long getItemId(int paramInt) {
            return paramInt;
        }

        public int getPositionForSection(int paramInt) {
            int j;
            if (paramInt == 35) {
                j = 0;
                return j;
            }
            int i = 0;
            for (; ; ) {
                if (i >= this.mDatas.size()) {
                    return -1;
                }
                j = i;
                if (((ForumItemBean) this.mDatas.get(i)).getForumName().toUpperCase().charAt(0) == paramInt) {
                    break;
                }
                i += 1;
            }
        }

        public int getSectionForPosition(int paramInt) {
            return 0;
        }

        public Object[] getSections() {
            return null;
        }

        public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
            Object localObject = (ForumItemBean) this.mDatas.get(paramInt);
            TapatalkForum localTapatalkForum = this.helper.getFavrivateById(((ForumItemBean) localObject).getForumId());
            label199:
            label261:
            int i;
            if (paramView == null) {
                paramView = this.mActivity.getLayoutInflater().inflate(2130903279, null);
                paramViewGroup = new ViewHolder(null);
                paramViewGroup.icon = ((ImageView) paramView.findViewById(2131230992));
                paramViewGroup.text = ((TextView) paramView.findViewById(2131230904));
                paramViewGroup.description = ((TextView) paramView.findViewById(2131230993));
                paramViewGroup.header = ((LinearLayout) paramView.findViewById(2131231398));
                paramViewGroup.textView = ((TextView) paramView.findViewById(2131230838));
                paramViewGroup.icon.setBackgroundDrawable(ThemeUtil.getDrawableByPicName("avator_background", this.mActivity));
                paramView.setTag(paramViewGroup);
                AvatarTool.showLogo(this.mActivity, paramViewGroup.icon, ((ForumItemBean) localObject).getIconUrl(), 5);
                if (paramInt % 2 != 1) {
                    break label324;
                }
                paramView.setBackgroundDrawable(ThemeUtil.getDrawableByPicName("favforum_item1_color", this.mActivity));
                paramViewGroup.description.setTypeface(this.tf);
                paramViewGroup.description.setText(((ForumItemBean) localObject).getForumName());
                if ((localTapatalkForum == null) || (localTapatalkForum.getUserName() == null) || (localTapatalkForum.getUserName().equals(""))) {
                    break label341;
                }
                paramViewGroup.text.setText(localTapatalkForum.getUserName());
                localObject = ((ForumItemBean) this.mDatas.get(paramInt)).getForumName();
                i = ((String) localObject).toUpperCase().charAt(0);
                if (paramInt != 0) {
                    break label356;
                }
                setSection(paramViewGroup.header, (String) localObject);
            }
            for (; ; ) {
                paramViewGroup.textView.setText((CharSequence) localObject);
                return paramView;
                paramViewGroup = (ViewHolder) paramView.getTag();
                break;
                label324:
                paramView.setBackgroundDrawable(ThemeUtil.getDrawableByPicName("favforum_item2_color", this.mActivity));
                break label199;
                label341:
                paramViewGroup.text.setText(((ForumItemBean) localObject).getUserName());
                break label261;
                label356:
                if (i != ((ForumItemBean) this.mDatas.get(paramInt - 1)).getForumName().toUpperCase().charAt(0)) {
                    setSection(paramViewGroup.header, (String) localObject);
                    paramViewGroup.header.setVisibility(0);
                } else {
                    paramViewGroup.header.setVisibility(8);
                }
            }
        }

        public boolean isOpCancel() {
            return false;
        }

        public void setOpCancel(boolean paramBoolean) {
        }

        public void updateSubclassDialog(int paramInt) {
        }

        private class ViewHolder {
            TextView description;
            LinearLayout header;
            ImageView icon;
            TextView text;
            TextView textView;

            private ViewHolder() {
            }
        }
    }

    public static class ViewHolder {
        public TextView name;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/activity/directory/ics/NetWorkFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */