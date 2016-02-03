package com.quoord.tapatalkpro.adapter.forum.conversation;

import android.app.Activity;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.quoord.tapatalkpro.bean.Conversation;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.bean.Participant;
import com.quoord.tapatalkpro.util.ThemeUtil;

import java.util.ArrayList;
import java.util.HashMap;

public class ConversationActionMode
        implements ActionMode.Callback, AdapterView.OnItemClickListener {
    private ConvAdapter convAdapter;
    private Conversation conversation;
    public ArrayList<Conversation> conversations = new ArrayList();
    private ForumStatus forumStatus;
    private ArrayList<String> index = new ArrayList();
    private ListView listView;
    private Activity mActivity;
    private int position;
    private ArrayList<String> unreadConversationPosition = new ArrayList();

    public ConversationActionMode(Activity paramActivity, Conversation paramConversation, int paramInt, ListView paramListView, ConvAdapter paramConvAdapter, ForumStatus paramForumStatus) {
        this.mActivity = paramActivity;
        this.listView = paramListView;
        this.conversation = paramConversation;
        this.position = paramInt;
        this.convAdapter = paramConvAdapter;
        this.forumStatus = paramForumStatus;
        if (!this.conversations.contains(paramConversation)) {
            this.conversations.add(paramConversation);
            this.index.add(paramInt);
        }
        if ((!this.unreadConversationPosition.contains(paramInt)) && (!paramConversation.isNew_post()) && (paramForumStatus.isMarkCsUnread())) {
            this.unreadConversationPosition.add(paramInt);
        }
    }

    public void addUnreadMenu() {
        if (this.convAdapter.anMode != null) {
            if (this.unreadConversationPosition.size() == 0) {
                this.convAdapter.anMode.getMenu().removeItem(2030);
            }
            if ((this.unreadConversationPosition.size() > 0) && (this.forumStatus.isMarkCsUnread())) {
                this.convAdapter.anMode.getMenu().removeItem(2030);
                this.convAdapter.anMode.getMenu().add(0, 2030, 0, this.mActivity.getString(2131099818)).setIcon(ThemeUtil.getMenuIconByPicName("bubble_mark_unread", this.mActivity)).setShowAsAction(2);
            }
        }
    }

    public void dataClear() {
        this.conversations.clear();
        this.unreadConversationPosition.clear();
        this.index.clear();
    }

    public boolean onActionItemClicked(ActionMode paramActionMode, MenuItem paramMenuItem) {
        switch (paramMenuItem.getItemId()) {
        }
        do {
            do {
                return false;
            } while (this.convAdapter == null);
            i = 0;
            for (; ; ) {
                if (i >= this.unreadConversationPosition.size()) {
                    this.convAdapter.anMode.finish();
                    break;
                }
                this.convAdapter.markConsUnread(Integer.parseInt((String) this.unreadConversationPosition.get(i)));
                i += 1;
            }
        } while (this.convAdapter == null);
        int i = 0;
        for (; ; ) {
            if (i >= this.conversations.size()) {
                this.convAdapter.anMode.finish();
                break;
            }
            this.convAdapter.deleteConversation((Conversation) this.conversations.get(i));
            i += 1;
        }
    }

    public boolean onCreateActionMode(ActionMode paramActionMode, Menu paramMenu) {
        if ((this.conversation != null) && (this.conversation.partcipated != null) && (this.conversation.getLast_user_id() != null)) {
            paramActionMode.setTitle(((Participant) this.conversation.partcipated.get(this.conversation.getLast_user_id())).getUserName());
        }
        this.listView.setOnItemClickListener(this);
        this.listView.setOnItemLongClickListener(null);
        paramMenu.add(0, 1147, 1, this.mActivity.getString(2131099817)).setIcon(ThemeUtil.getMenuIconByPicName("ic_menu_delete", this.mActivity)).setShowAsAction(2);
        if ((this.forumStatus.isMarkCsUnread()) && (!this.conversation.isNew_post())) {
            paramMenu.add(0, 2030, 0, this.mActivity.getString(2131099818)).setIcon(ThemeUtil.getMenuIconByPicName("bubble_mark_unread", this.mActivity)).setShowAsAction(2);
        }
        return true;
    }

    public void onDestroyActionMode(ActionMode paramActionMode) {
        dataClear();
        if (this.convAdapter != null) {
            this.convAdapter.addListViewOnItemClickEvent();
            this.convAdapter.addListViewOnLongItemClickEvent();
            this.convAdapter.anMode = null;
            this.convAdapter.conversationActionMode = null;
            this.convAdapter.notifyDataSetChanged();
        }
    }

    public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {
        paramAdapterView = (Conversation) this.convAdapter.getItem(paramInt);
        if (this.conversations.contains(paramAdapterView)) {
            this.conversations.remove(paramAdapterView);
            this.index.remove(paramInt);
            if (!this.unreadConversationPosition.contains(paramInt)) {
                break label183;
            }
            this.unreadConversationPosition.remove(paramInt);
            label100:
            if (this.convAdapter != null) {
                if (this.conversations.size() != 0) {
                    break label225;
                }
                if (this.convAdapter.anMode != null) {
                    this.convAdapter.anMode.finish();
                }
            }
        }
        for (; ; ) {
            addUnreadMenu();
            this.convAdapter.notifyDataSetChanged();
            return;
            this.index.add(paramInt);
            this.conversations.add(paramAdapterView);
            break;
            label183:
            if ((paramAdapterView.isNew_post()) || (!this.forumStatus.isMarkCsUnread())) {
                break label100;
            }
            this.unreadConversationPosition.add(paramInt);
            break label100;
            label225:
            if (this.conversations.size() == 1) {
                paramAdapterView = (Conversation) this.convAdapter.getItem(Integer.parseInt((String) this.index.get(0)));
                if ((paramAdapterView != null) && (paramAdapterView.partcipated != null) && (paramAdapterView.getLast_user_id() != null)) {
                    paramAdapterView = ((Participant) paramAdapterView.partcipated.get(paramAdapterView.getLast_user_id())).getUserName();
                    this.convAdapter.anMode.setTitle(paramAdapterView);
                } else {
                    this.convAdapter.anMode.setTitle("");
                }
            } else {
                this.convAdapter.anMode.setTitle(String.format(this.mActivity.getString(2131100157), new Object[]{Integer.valueOf(this.conversations.size())}));
            }
        }
    }

    public boolean onPrepareActionMode(ActionMode paramActionMode, Menu paramMenu) {
        return false;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/adapter/forum/conversation/ConversationActionMode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */