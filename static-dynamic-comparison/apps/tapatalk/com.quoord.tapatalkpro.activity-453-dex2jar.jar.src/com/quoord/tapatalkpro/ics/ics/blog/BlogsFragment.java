package com.quoord.tapatalkpro.ics.ics.blog;

import android.app.ActionBar;
import android.app.ActionBar.OnNavigationListener;
import android.app.Activity;
import android.content.Context;
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
import com.quoord.tapatalkpro.adapter.forum.BlogsAdapter;
import com.quoord.tapatalkpro.adapter.forum.conversation.SubscribeTitleAdapter;
import com.quoord.tapatalkpro.bean.EngineResponse;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.bean.RebrandingConfig;
import com.quoord.tapatalkpro.bean.TapatalkForum;
import com.quoord.tapatalkpro.ics.slidingMenu.SettingsFragment;
import com.quoord.tapatalkpro.ics.slidingMenu.SlidingMenuActivity;
import com.quoord.tapatalkpro.ui.ics.QuoordFragment;
import com.quoord.tapatalkpro.util.ThemeUtil;
import com.quoord.tapatalkpro.util.Util;
import com.quoord.tools.TwoPanelController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class BlogsFragment
        extends QuoordFragment
        implements TwoPanelController, AddToFavoriate.AddFavoriate, BlogsAction.BlogsActionCallBack {
    private BlogsAdapter adapter = null;
    private AddToFavoriate addToForums;
    private ActionBar bar;
    private BlogsAction blogsAction;
    private int clickPosition = 0;
    private ForumStatus forumStatus = null;
    private ListView listView = null;
    private ArrayList<Blog> mDatas = new ArrayList();
    private int newCatid;
    private TextView noDataView;
    private int oldCatid;
    final ArrayList<String> titleDatas = new ArrayList();
    private int total;

    public static BlogsFragment newInstance() {
        return new BlogsFragment();
    }

    public void actionCallBack(EngineResponse paramEngineResponse) {
        Object localObject;
        if (paramEngineResponse != null) {
            localObject = paramEngineResponse.getMethod();
            if ((localObject != null) && (((String) localObject).contains("tapatalk=category")) && (paramEngineResponse.isSuccess())) {
                this.total = 0;
                paramEngineResponse = paramEngineResponse.getResponse().toString();
            }
        }
        for (; ; ) {
            try {
                paramEngineResponse = new JSONObject(paramEngineResponse).getJSONArray("result");
                i = 0;
                if (i < paramEngineResponse.length()) {
                    continue;
                }
                paramEngineResponse = new Blog();
                paramEngineResponse.setCategory_id("0");
                paramEngineResponse.setCategory_name(getString(2131100724));
                paramEngineResponse.setCategory_count(this.total);
                this.mDatas.add(0, paramEngineResponse);
                shortDatas(this.mDatas);
            } catch (JSONException paramEngineResponse) {
                int i;
                JSONObject localJSONObject;
                paramEngineResponse.printStackTrace();
                continue;
            }
            setActionBar(getActivity());
            return;
            localObject = new Blog();
            localJSONObject = paramEngineResponse.getJSONObject(i);
            ((Blog) localObject).setCategory_id(localJSONObject.getString("cat_id"));
            ((Blog) localObject).setCategory_name(localJSONObject.getString("name"));
            ((Blog) localObject).setCategory_count(localJSONObject.getString("count"));
            ((Blog) localObject).setCategory_parent(localJSONObject.getString("parent"));
            this.total += Integer.parseInt(localJSONObject.getString("count"));
            this.mDatas.add(localObject);
            i += 1;
        }
    }

    public BaseAdapter getAdapter() {
        return this.adapter;
    }

    public void getBlogsCategory() {
        this.blogsAction.getBlogsCategoryList();
    }

    public String getCategoryUrl() {
        if (getActivity().getResources().getBoolean(2131558401)) {
            return this.forumStatus.getRebrandingConfig().getCms_url() + "/index.php?tapatalk=category";
        }
        return this.forumStatus.tapatalkForum.getCms_url() + "/index.php?tapatalk=category";
    }

    public void initDropDown() {
        this.bar.setListNavigationCallbacks(new SubscribeTitleAdapter(getActivity(), this.titleDatas), new ActionBar.OnNavigationListener() {
            public boolean onNavigationItemSelected(int paramAnonymousInt, long paramAnonymousLong) {
                if ((BlogsFragment.this.getActivity() instanceof DrawerLayoutStatus)) {
                    ((DrawerLayoutStatus) BlogsFragment.this.getActivity()).closeDrawerLay();
                }
                if ((BlogsFragment.this.adapter != null) && (BlogsFragment.this.mDatas != null) && (BlogsFragment.this.mDatas.size() != 0)) {
                    BlogsFragment.this.adapter.setCategoryId(Integer.parseInt(((Blog) BlogsFragment.this.mDatas.get(paramAnonymousInt)).getCategory_id()));
                    if (BlogsFragment.this.clickPosition != paramAnonymousInt) {
                        BlogsFragment.this.clickPosition = paramAnonymousInt;
                        BlogsFragment.this.bar.setSelectedNavigationItem(paramAnonymousInt);
                        BlogsFragment.this.adapter.refresh(Integer.parseInt(((Blog) BlogsFragment.this.mDatas.get(paramAnonymousInt)).getCategory_id()));
                    }
                }
                return true;
            }
        });
    }

    public void initDropDownList() {
        this.titleDatas.clear();
        int i;
        if ((this.mDatas != null) && (this.mDatas.size() != 0)) {
            i = 0;
        }
        for (; ; ) {
            if (i >= this.mDatas.size()) {
                if (this.titleDatas.size() == 0) {
                    this.titleDatas.add(getString(2131100724));
                }
                return;
            }
            this.titleDatas.add(((Blog) this.mDatas.get(i)).getCategory_name() + "  (" + ((Blog) this.mDatas.get(i)).getCategory_count() + ")");
            i += 1;
        }
    }

    public void onActivityCreated(Bundle paramBundle) {
        super.onActivityCreated(paramBundle);
        this.forumStatus = ((SlidingMenuActivity) getActivity()).forumStatus;
        this.blogsAction = new BlogsAction(getActivity(), getCategoryUrl(), this.forumStatus, this);
        getBlogsCategory();
        if (this.forumStatus != null) {
            this.adapter = new BlogsAdapter(getActivity(), this.forumStatus, this.listView, this.noDataView);
        }
        setActionBar(getActivity());
    }

    public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
        super.onActivityResult(paramInt1, paramInt2, paramIntent);
    }

    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        paramViewGroup = paramLayoutInflater.inflate(2130903078, null);
        this.listView = ((ListView) paramViewGroup.findViewById(2131230887));
        this.listView.setDivider(null);
        this.listView.setSelector(2131165212);
        this.noDataView = ((TextView) paramViewGroup.findViewById(2131230888));
        if (this.forumStatus == null) {
            this.forumStatus = ((SlidingMenuActivity) getActivity()).forumStatus;
        }
        this.addToForums = new AddToFavoriate(getActivity(), false);
        if (this.forumStatus.tapatalkForum == null) {
            paramLayoutInflater = this.addToForums.getView(paramViewGroup, this);
        }
        do {
            do {
                do {
                    return paramLayoutInflater;
                    paramLayoutInflater = paramViewGroup;
                } while (this.forumStatus == null);
                paramLayoutInflater = paramViewGroup;
            } while (this.forumStatus.isLogin());
            paramLayoutInflater = paramViewGroup;
        } while (Util.isFavoriate(getActivity(), this.forumStatus.tapatalkForum.getId().intValue()));
        return this.addToForums.getView(paramViewGroup, this);
    }

    public void onHiddenChanged(boolean paramBoolean) {
        super.onHiddenChanged(paramBoolean);
        if (!paramBoolean) {
            setActionBar(getActivity());
            refresh();
        }
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        switch (paramMenuItem.getItemId()) {
        }
        for (; ; ) {
            return super.onOptionsItemSelected(paramMenuItem);
            if (this.adapter != null) {
                if (this.mDatas.size() == 0) {
                    this.adapter.refresh();
                } else {
                    this.adapter.refresh(Integer.parseInt(((Blog) this.mDatas.get(this.clickPosition)).getCategory_id()));
                }
            }
        }
    }

    public void onPrepareOptionsMenu(Menu paramMenu) {
        super.onPrepareOptionsMenu(paramMenu);
        paramMenu.removeGroup(0);
        if (((getActivity() instanceof DrawerLayoutStatus)) && (((DrawerLayoutStatus) getActivity()).isDrawMenuOpen())) {
            return;
        }
        paramMenu.add(0, 1001, 1, getString(2131099796)).setIcon(ThemeUtil.getMenuIconByPicName("menu_refresh_new", getActivity())).setShowAsAction(9);
    }

    public void refresh() {
        if (((getActivity() instanceof SlidingMenuActivity)) && (((SlidingMenuActivity) getActivity()).isHide_addFavoriate_view) && (this.addToForums != null) && (this.addToForums.layout != null)) {
            this.addToForums.layout.setVisibility(8);
        }
    }

    public void saveFavoriate() {
        Util.saveFavoriate(getActivity(), this.forumStatus.tapatalkForum, ((SlidingMenuActivity) getActivity()).channel, true);
    }

    public void setActionBar(Activity paramActivity) {
        if (((paramActivity instanceof SlidingMenuActivity)) && ((((SlidingMenuActivity) paramActivity).currentFragment instanceof BlogsFragment))) {
            if (this.bar == null) {
                this.bar = paramActivity.getActionBar();
            }
            setActionBarTitle();
        }
    }

    public void setActionBarTitle() {
        this.bar.setDisplayShowCustomEnabled(false);
        this.bar.setDisplayShowTitleEnabled(false);
        this.bar.setNavigationMode(1);
        initDropDownList();
        initDropDown();
        this.bar.setSelectedNavigationItem(this.clickPosition);
    }

    public void setQuoordBackGround(Context paramContext) {
        if (SettingsFragment.isLightTheme(getActivity())) {
            getView().setBackgroundResource(2131165281);
            return;
        }
        getView().setBackgroundResource(2131165282);
    }

    public void shortDatas(ArrayList<Blog> paramArrayList) {
        Collections.sort(paramArrayList, new Comparator() {
            public int compare(Blog paramAnonymousBlog1, Blog paramAnonymousBlog2) {
                if (!paramAnonymousBlog1.getCategory_count().equals(paramAnonymousBlog2.getCategory_count())) {
                    return -(Integer.parseInt(paramAnonymousBlog1.getCategory_count()) - Integer.parseInt(paramAnonymousBlog2.getCategory_count()));
                }
                return 0;
            }
        });
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/ics/ics/blog/BlogsFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */