package com.quoord.tapatalkpro.ics.conversation;

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
import com.quoord.tapatalkpro.activity.forum.DrawerLayoutStatus;
import com.quoord.tapatalkpro.activity.forum.ForumActivityStatus;
import com.quoord.tapatalkpro.activity.forum.conversation.CreateOrReplyConversationActivity;
import com.quoord.tapatalkpro.adapter.forum.ForumRootAdapter;
import com.quoord.tapatalkpro.adapter.forum.conversation.ConvAdapter;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.bean.TapatalkForum;
import com.quoord.tapatalkpro.ics.BaseListFragment;
import com.quoord.tapatalkpro.ics.slidingMenu.SlidingMenuActivity;
import com.quoord.tapatalkpro.saxparser.TabConvSaxParser;
import com.quoord.tapatalkpro.util.ThemeUtil;
import com.quoord.tools.TwoPanelControllerWithId;

public class ConversationListFragment
        extends BaseListFragment
        implements ForumActivityStatus, TwoPanelControllerWithId {
    private String convId;
    private ListView listview;

    public static ConversationListFragment newInstance() {
        return new ConversationListFragment();
    }

    public void closeProgress() {
    }

    public BaseAdapter getAdapter() {
        return this.adapter;
    }

    public Activity getDefaultActivity() {
        return getActivity();
    }

    public ForumActivityStatus getForumActivityStatus() {
        return this;
    }

    public ForumStatus getForumStatus() {
        return this.forumstatus;
    }

    public ForumStatus getForumStatus(TapatalkForum paramTapatalkForum) {
        return null;
    }

    public String getIdByTwoPanel() {
        return this.convId;
    }

    public void onActivityCreated(Bundle paramBundle) {
        super.onActivityCreated(paramBundle);
        setMactivity(getActivity());
        this.mActivity.getActionBar().setNavigationMode(0);
        this.forumstatus = ((SlidingMenuActivity) getActivity()).forumStatus;
        if ((this.forumstatus != null) && (this.forumstatus.isLogin())) {
            this.adapter = new ConvAdapter(this.mActivity, this.forumstatus.getUrl(), this.listview);
        }
    }

    public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
        if ((paramInt1 == 53) && (paramInt2 == 26)) {
            this.adapter.refresh();
        }
        super.onActivityResult(paramInt1, paramInt2, paramIntent);
    }

    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        paramLayoutInflater = paramLayoutInflater.inflate(2130903182, paramViewGroup, false);
        this.listview = ((ListView) paramLayoutInflater.findViewById(2131231148));
        this.listview.setDivider(null);
        this.listview.setSelector(2131165212);
        return paramLayoutInflater;
    }

    public void onHiddenChanged(boolean paramBoolean) {
        super.onHiddenChanged(paramBoolean);
        if (!paramBoolean) {
            setActionBar(this.mActivity);
        }
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        switch (paramMenuItem.getItemId()) {
        }
        for (; ; ) {
            return super.onOptionsItemSelected(paramMenuItem);
            if (this.adapter != null) {
                ((ConvAdapter) this.adapter).refresh();
                ((SlidingMenuActivity) getActivity()).getUnreadNumbers();
            }
            return true;
            this.mActivity.finish();
            return true;
            Intent localIntent = new Intent(this.mActivity, CreateOrReplyConversationActivity.class);
            localIntent.putExtra("forumStatus", this.forumstatus);
            localIntent.putExtra("is_newConversation", true);
            if ((this.adapter != null) && (((ConvAdapter) this.adapter).convSaxParser != null)) {
                localIntent.putExtra("can_upload", ((ConvAdapter) this.adapter).convSaxParser.isCan_upload());
            }
            startActivityForResult(localIntent, 53);
        }
    }

    public void onPrepareOptionsMenu(Menu paramMenu) {
        super.onPrepareOptionsMenu(paramMenu);
        if (((getActivity() instanceof DrawerLayoutStatus)) && (((DrawerLayoutStatus) getActivity()).isDrawMenuOpen())) {
            return;
        }
        MenuItem localMenuItem = paramMenu.add(0, 1020, 1, getActivity().getResources().getString(2131100164));
        localMenuItem.setIcon(ThemeUtil.getMenuIconByPicName("bubble_edit", getActivity()));
        localMenuItem.setShowAsAction(1);
        paramMenu.add(0, 1001, 1, getString(2131099796)).setIcon(ThemeUtil.getMenuIconByPicName("menu_refresh_new", getActivity())).setShowAsAction(9);
    }

    public void setActionBar(Activity paramActivity) {
        paramActivity.getActionBar().setNavigationMode(0);
        paramActivity.getActionBar().setDisplayShowTitleEnabled(true);
        paramActivity.getActionBar().setTitle(paramActivity.getString(2131100422));
    }

    public void setIdByTwoPanel(String paramString) {
        this.convId = paramString;
    }

    public void showDialog(int paramInt) {
    }

    public void showProgress() {
    }

    public void showProgress(String paramString) {
    }

    public void updateDialog(int paramInt) {
    }

    public void updateUI(int paramInt, Object paramObject) {
    }

    public void updateUI(String paramString) {
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/ics/conversation/ConversationListFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */