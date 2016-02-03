package com.quoord.tapatalkpro.adapter.forum;

import android.app.Activity;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.bean.PrivateMessage;
import com.quoord.tapatalkpro.util.ThemeUtil;

import java.util.ArrayList;

public class PMActionMode
        implements ActionMode.Callback, AdapterView.OnItemClickListener {
    private ForumStatus forumStatus;
    private boolean isInbox;
    private ListView listView;
    private Activity mActivity;
    private PrivateMessage pm;
    private PMAdapter pmAdapter;
    public ArrayList<String> pmDeletePositions = new ArrayList();
    private ArrayList<String> pmPositons = new ArrayList();
    public ArrayList<PrivateMessage> pms = new ArrayList();
    private int position;

    public PMActionMode(Activity paramActivity, PrivateMessage paramPrivateMessage, ForumStatus paramForumStatus, int paramInt, PMAdapter paramPMAdapter, ListView paramListView, boolean paramBoolean) {
        this.pm = paramPrivateMessage;
        this.forumStatus = paramForumStatus;
        this.mActivity = paramActivity;
        this.pmAdapter = paramPMAdapter;
        this.listView = paramListView;
        this.position = paramInt;
        this.isInbox = paramBoolean;
        if (!this.pms.contains(paramPrivateMessage.getMsgId())) {
            this.pms.add(paramPrivateMessage);
            this.pmDeletePositions.add(paramInt);
        }
        if ((!this.pmPositons.contains(paramInt)) && (paramPrivateMessage.getMsgState() != 1) && (paramForumStatus.isMarkPmUnread())) {
            this.pmPositons.add(paramInt);
        }
    }

    public void addMenu(Menu paramMenu, boolean paramBoolean) {
        if (this.isInbox) {
            paramMenu.add(0, 1040, 0, this.mActivity.getString(2131099815)).setIcon(ThemeUtil.getMenuIconByPicName("bubble_reply", this.mActivity)).setShowAsAction(2);
            if ((this.forumStatus.isMarkPmUnread()) && (this.pm.getMsgState() != 1) && (paramBoolean)) {
                paramMenu.add(0, 2030, 1, this.mActivity.getString(2131099818)).setIcon(ThemeUtil.getMenuIconByPicName("bubble_mark_unread", this.mActivity)).setShowAsAction(2);
            }
            paramMenu.add(0, 1145, 3, this.mActivity.getString(2131099811)).setIcon(ThemeUtil.getMenuIconByPicName("bubble_viewuser", this.mActivity)).setShowAsAction(1);
        }
        paramMenu.add(0, 1049, 4, this.mActivity.getString(2131099816)).setIcon(ThemeUtil.getMenuIconByPicName("bubble_forward", this.mActivity)).setShowAsAction(1);
        if ((!this.forumStatus.getAppVersion(this.mActivity).equals("proboards")) && (paramBoolean)) {
            paramMenu.add(0, 1147, 2, this.mActivity.getString(2131099817)).setIcon(ThemeUtil.getMenuIconByPicName("bubble_delete", this.mActivity)).setShowAsAction(2);
        }
    }

    public void addUnreadMenu() {
        if (this.pmAdapter.anMode != null) {
            if (this.pms.size() != 1) {
                break label76;
            }
            removeMenu();
            addMenu(this.pmAdapter.anMode.getMenu(), false);
            if (this.isInbox) {
                if (this.pmPositons.size() != 0) {
                    break label83;
                }
                this.pmAdapter.anMode.getMenu().removeItem(2030);
            }
        }
        label76:
        label83:
        while (!this.forumStatus.isMarkPmUnread()) {
            return;
            removeMenu();
            break;
        }
        this.pmAdapter.anMode.getMenu().removeItem(2030);
        this.pmAdapter.anMode.getMenu().add(0, 2030, 1, this.mActivity.getString(2131099818)).setIcon(ThemeUtil.getMenuIconByPicName("bubble_mark_unread", this.mActivity)).setShowAsAction(2);
    }

    public void dataClear() {
        this.pms.clear();
        this.pmDeletePositions.clear();
        this.pmPositons.clear();
    }

    public String getMsgtoName() {
        ArrayList localArrayList = ((PrivateMessage) this.pmAdapter.getItem(Integer.parseInt((String) this.pmDeletePositions.get(0)))).getMsgTo();
        StringBuffer localStringBuffer = new StringBuffer();
        int i = 0;
        for (; ; ) {
            if (i >= localArrayList.size()) {
                return localStringBuffer.toString();
            }
            if (localStringBuffer.length() != 0) {
                localStringBuffer.append(",");
            }
            localStringBuffer.append((String) localArrayList.get(i));
            i += 1;
        }
    }

    public boolean onActionItemClicked(ActionMode paramActionMode, MenuItem paramMenuItem) {
        switch (paramMenuItem.getItemId()) {
        }
        for (; ; ) {
            return false;
            if (this.pmAdapter != null) {
                this.pmAdapter.replyPm(this.pm);
                this.pmAdapter.anMode.finish();
                continue;
                if (this.pmAdapter != null) {
                    this.pmAdapter.forwordPm(this.pm);
                    this.pmAdapter.anMode.finish();
                    continue;
                    if (this.pmAdapter != null) {
                        int i = 0;
                        for (; ; ) {
                            if (i >= this.pms.size()) {
                                this.pmAdapter.anMode.finish();
                                break;
                            }
                            this.pmAdapter.deletePm((PrivateMessage) this.pms.get(i));
                            i += 1;
                        }
                        if (this.pmAdapter != null) {
                            i = 0;
                            for (; ; ) {
                                if (i >= this.pmPositons.size()) {
                                    this.pmAdapter.anMode.finish();
                                    break;
                                }
                                this.pmAdapter.markMessageUnread(Integer.parseInt((String) this.pmPositons.get(i)));
                                i += 1;
                            }
                            if (this.pmAdapter != null) {
                                this.pmAdapter.viewPmProfile(this.pm);
                                this.pmAdapter.anMode.finish();
                            }
                        }
                    }
                }
            }
        }
    }

    public boolean onCreateActionMode(ActionMode paramActionMode, Menu paramMenu) {
        if (this.isInbox) {
            paramActionMode.setTitle(this.pm.getMsgFrom());
        }
        for (; ; ) {
            addMenu(paramMenu, true);
            this.listView.setOnItemClickListener(this);
            this.listView.setOnItemLongClickListener(null);
            return true;
            paramActionMode.setTitle(getMsgtoName());
        }
    }

    public void onDestroyActionMode(ActionMode paramActionMode) {
        dataClear();
        if (this.pmAdapter != null) {
            this.pmAdapter.addOnitemclickEven();
            this.pmAdapter.addOnitemLongclickEven();
            this.pmAdapter.anMode = null;
            this.pmAdapter.pmActionMode = null;
            this.pmAdapter.notifyDataSetChanged();
        }
    }

    public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {
        paramAdapterView = (PrivateMessage) this.pmAdapter.getItem(paramInt);
        if (this.pms.contains(paramAdapterView)) {
            this.pms.remove(paramAdapterView);
            this.pmDeletePositions.remove(paramInt);
            if (!this.pmPositons.contains(paramInt)) {
                break label183;
            }
            this.pmPositons.remove(paramInt);
            label100:
            if (this.pmAdapter != null) {
                if (this.pms.size() != 0) {
                    break label226;
                }
                if (this.pmAdapter.anMode != null) {
                    this.pmAdapter.anMode.finish();
                }
            }
        }
        for (; ; ) {
            addUnreadMenu();
            this.pmAdapter.notifyDataSetChanged();
            return;
            this.pms.add(paramAdapterView);
            this.pmDeletePositions.add(paramInt);
            break;
            label183:
            if ((paramAdapterView.getMsgState() == 1) || (!this.forumStatus.isMarkPmUnread())) {
                break label100;
            }
            this.pmPositons.add(paramInt);
            break label100;
            label226:
            if (this.pms.size() == 1) {
                if (this.isInbox) {
                    paramAdapterView = ((PrivateMessage) this.pmAdapter.getItem(Integer.parseInt((String) this.pmDeletePositions.get(0)))).getMsgFrom();
                    this.pmAdapter.anMode.setTitle(paramAdapterView);
                } else {
                    this.pmAdapter.anMode.setTitle(getMsgtoName());
                }
            } else {
                this.pmAdapter.anMode.setTitle(String.format(this.mActivity.getString(2131100157), new Object[]{Integer.valueOf(this.pms.size())}));
            }
        }
    }

    public boolean onPrepareActionMode(ActionMode paramActionMode, Menu paramMenu) {
        return false;
    }

    public void removeMenu() {
        if (this.isInbox) {
            this.pmAdapter.anMode.getMenu().removeItem(1040);
            this.pmAdapter.anMode.getMenu().removeItem(1145);
        }
        this.pmAdapter.anMode.getMenu().removeItem(1049);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/adapter/forum/PMActionMode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */