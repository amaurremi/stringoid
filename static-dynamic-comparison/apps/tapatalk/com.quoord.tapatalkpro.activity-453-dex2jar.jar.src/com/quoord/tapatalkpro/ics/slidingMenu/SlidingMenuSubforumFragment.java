package com.quoord.tapatalkpro.ics.slidingMenu;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.quoord.tapatalkpro.adapter.TryTwiceCallBackInterface;
import com.quoord.tapatalkpro.adapter.forum.SubForumAdapter;
import com.quoord.tapatalkpro.bean.EngineResponse;
import com.quoord.tapatalkpro.bean.Forum;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.ics.BaseListFragment;
import com.quoord.tapatalkpro.ui.ButtomProgress;
import com.quoord.tapatalkpro.util.TapatalkEngine;
import com.quoord.tapatalkpro.util.ThemeUtil;

import java.util.ArrayList;
import java.util.HashMap;

public class SlidingMenuSubforumFragment
        extends BaseListFragment
        implements TryTwiceCallBackInterface {
    protected TapatalkEngine engine = null;
    private ArrayList<Forum> flattenForumList = new ArrayList();
    private LinearLayout footlay;
    private Forum forum;
    private String forumId;
    private ListView listview;
    private Activity mActivity;
    private SubForumAdapter mAdapter = null;
    public ArrayList<Forum> mDatas = new ArrayList();
    public int maxLevel = 0;
    private String title;

    public static SlidingMenuSubforumFragment newInstance(ForumStatus paramForumStatus, String paramString1, String paramString2) {
        SlidingMenuSubforumFragment localSlidingMenuSubforumFragment = new SlidingMenuSubforumFragment();
        localSlidingMenuSubforumFragment.forumId = paramString1;
        localSlidingMenuSubforumFragment.forumstatus = paramForumStatus;
        localSlidingMenuSubforumFragment.title = paramString2;
        return localSlidingMenuSubforumFragment;
    }

    public void callBack(EngineResponse paramEngineResponse) {
        int i;
        if (paramEngineResponse.getMethod().equals("get_forum")) {
            this.mDatas.clear();
            paramEngineResponse = (Object[]) paramEngineResponse.getResponse();
            i = 0;
        }
        for (; ; ) {
            if (i >= paramEngineResponse.length) {
                this.listview.removeFooterView(this.footlay);
                if ((this.forum != null) && (this.listview != null)) {
                    this.mAdapter = new SubForumAdapter(this.mActivity, this.forumstatus.getUrl(), this.forum, this.listview, "byo_subforum_statck_tag");
                    this.mAdapter.notifyDataSetChanged();
                }
                return;
            }
            HashMap localHashMap = (HashMap) paramEngineResponse[i];
            if (localHashMap.get("forum_id").equals(this.forumId)) {
                this.forum = Forum.createForumBean(localHashMap, this.forumstatus, this.mActivity, this.flattenForumList, null, 0);
            }
            i += 1;
        }
    }

    public boolean getSaxCall() {
        return false;
    }

    public boolean getTryTwice() {
        return false;
    }

    public boolean isOpCancel() {
        return false;
    }

    public void onActivityCreated(Bundle paramBundle) {
        super.onActivityCreated(paramBundle);
        this.mActivity = getActivity();
        if (this.forumstatus != null) {
            this.engine = new TapatalkEngine(this, this.forumstatus, this.mActivity);
            this.forum = this.forumstatus.getForumById(this.mActivity, this.forumId);
        }
        this.footlay = ButtomProgress.get(this.mActivity);
        if ((this.forum != null) && (this.listview != null)) {
            this.mAdapter = new SubForumAdapter(this.mActivity, this.forumstatus.getUrl(), this.forum, this.listview, "byo_subforum_statck_tag");
        }
        for (; ; ) {
            paramBundle = getActivity().getActionBar();
            paramBundle.setTitle(this.title);
            paramBundle.setDisplayShowHomeEnabled(true);
            paramBundle.setDisplayShowTitleEnabled(true);
            return;
            this.listview.addFooterView(this.footlay);
            this.engine.call("get_forum", new ArrayList());
        }
    }

    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        paramLayoutInflater = paramLayoutInflater.inflate(2130903212, paramViewGroup, false);
        this.listview = ((ListView) paramLayoutInflater.findViewById(2131231254));
        this.listview.setDivider(null);
        this.listview.setSelector(2131165212);
        return paramLayoutInflater;
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        if (this.mAdapter != null) {
        }
        switch (paramMenuItem.getItemId()) {
            default:
                return super.onOptionsItemSelected(paramMenuItem);
        }
        this.mAdapter.refresh();
        return true;
    }

    public void onPrepareOptionsMenu(Menu paramMenu) {
        super.onPrepareOptionsMenu(paramMenu);
        paramMenu.removeGroup(0);
        if ((this.forum != null) && (!this.forum.isSubOnly())) {
            paramMenu.add(0, 1001, 1, getString(2131099796)).setIcon(ThemeUtil.getMenuIconByPicName("menu_refresh_new", getActivity())).setShowAsAction(2);
        }
    }

    public void setOpCancel(boolean paramBoolean) {
    }

    public void setSaxCall(boolean paramBoolean) {
    }

    public void setTryTwice(boolean paramBoolean) {
    }

    public void tryFailed(String paramString) {
    }

    public void updateSubclassDialog(int paramInt) {
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/ics/slidingMenu/SlidingMenuSubforumFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */