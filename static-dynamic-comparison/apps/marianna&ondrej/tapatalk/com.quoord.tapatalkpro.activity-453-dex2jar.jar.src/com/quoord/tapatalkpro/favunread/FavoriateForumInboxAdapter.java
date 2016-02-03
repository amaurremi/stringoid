package com.quoord.tapatalkpro.favunread;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import com.quoord.tapatalkpro.TapatalkApp;
import com.quoord.tapatalkpro.activity.forum.ForumActivityStatus;
import com.quoord.tapatalkpro.bean.Conversation;
import com.quoord.tapatalkpro.bean.PrivateMessage;
import com.quoord.tapatalkpro.bean.TapatalkForum;
import com.quoord.tapatalkpro.bean.Topic;
import com.quoord.tapatalkpro.sqlhelper.FavoriateSqlHelper;
import com.quoord.tapatalkpro.ui.ButtomProgress;
import com.quoord.tapatalkpro.util.Util;
import com.quoord.tools.LoginStatus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class FavoriateForumInboxAdapter
        extends BaseExpandableListAdapter {
    private ForumActivityStatus activityStatus;
    private ArrayList<TapatalkForum> baseData;
    Comparator<UnreadStatus> comparator;
    private int expandedGroupPos = -1;
    private ArrayList<UnreadStatus> mList = new ArrayList();

    public FavoriateForumInboxAdapter(ForumActivityStatus paramForumActivityStatus, ArrayList<TapatalkForum> paramArrayList, ExpandableListView paramExpandableListView) {
        this.activityStatus = paramForumActivityStatus;
        this.baseData = paramArrayList;
    }

    private void initForum() {
        FavoriateSqlHelper localFavoriateSqlHelper = new FavoriateSqlHelper(this.activityStatus.getDefaultActivity(), TapatalkApp.database_name, null, Integer.parseInt(TapatalkApp.database_version));
        int j = this.baseData.size();
        int i = 0;
        for (; ; ) {
            if (i >= j) {
                return;
            }
            if (Util.isSignedUser(this.activityStatus.getDefaultActivity(), (TapatalkForum) this.baseData.get(i))) {
                TapatalkForum localTapatalkForum = localFavoriateSqlHelper.getFavrivateById(((TapatalkForum) this.baseData.get(i)).getId());
                if (localTapatalkForum != null) {
                    ((TapatalkForum) this.baseData.get(i)).setSupportConve(localTapatalkForum.isSupportConve());
                }
            }
            i += 1;
        }
    }

    private void sort() {
        if (this.mList != null) {
            if (this.comparator == null) {
                this.comparator = new Comparator() {
                    public int compare(UnreadStatus paramAnonymousUnreadStatus1, UnreadStatus paramAnonymousUnreadStatus2) {
                        return paramAnonymousUnreadStatus1.getListIndex() - paramAnonymousUnreadStatus2.getListIndex();
                    }
                };
            }
            Collections.sort(this.mList, this.comparator);
        }
    }

    public void clearChildrenData() {
        int i = 0;
        for (; ; ) {
            if (i >= this.mList.size()) {
                return;
            }
            ((UnreadStatus) this.mList.get(i)).removeAllChild();
            i += 1;
        }
    }

    public Object getChild(int paramInt1, int paramInt2) {
        if (paramInt1 < this.mList.size()) {
            UnreadStatus localUnreadStatus = (UnreadStatus) this.mList.get(paramInt1);
            if (localUnreadStatus.isHasSubOrPm()) {
                return localUnreadStatus.getChildrenList().get(paramInt2);
            }
            if (localUnreadStatus.isShouldhasSubOrPm()) {
                return new IndexObject(1);
            }
        }
        return new IndexObject(2);
    }

    public long getChildId(int paramInt1, int paramInt2) {
        return paramInt1 * 100 + paramInt2;
    }

    public int getChildType(int paramInt1, int paramInt2) {
        Object localObject = getChild(paramInt1, paramInt2);
        if ((localObject instanceof Topic)) {
            return 0;
        }
        if ((localObject instanceof PrivateMessage)) {
            return 1;
        }
        if ((localObject instanceof Conversation)) {
            return 2;
        }
        return 3;
    }

    public int getChildTypeCount() {
        return 5;
    }

    public View getChildView(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup) {
        Object localObject = getChild(paramInt1, paramInt2);
        if (((UnreadStatus) this.mList.get(paramInt1)).isHasSubOrPm()) {
            if ((localObject instanceof Topic)) {
                paramViewGroup = (Topic) localObject;
                localObject = new HashMap();
                ((HashMap) localObject).put("showForumName", Boolean.valueOf(true));
                ((HashMap) localObject).put("isSubscribedTab", Boolean.valueOf(false));
                paramViewGroup = paramViewGroup.createView((HashMap) localObject, paramView, this.activityStatus);
            }
        }
        do {
            do {
                return paramViewGroup;
                if ((localObject instanceof PrivateMessage)) {
                    localObject = (PrivateMessage) localObject;
                    return ((PrivateMessage) localObject).getPMView(paramInt2, (PrivateMessage) localObject, paramView, paramViewGroup, this.activityStatus.getDefaultActivity(), true, this.activityStatus, null, false);
                }
                paramViewGroup = paramView;
            } while (!(localObject instanceof Conversation));
            return ((Conversation) localObject).getConversationView(paramInt2, paramView, this.activityStatus.getDefaultActivity(), null);
            paramViewGroup = paramView;
        } while (!(localObject instanceof IndexObject));
        if (((IndexObject) localObject).tag == 1) {
            return ButtomProgress.get(this.activityStatus.getDefaultActivity());
        }
        return new View(this.activityStatus.getDefaultActivity());
    }

    public int getChildrenCount(int paramInt) {
        UnreadStatus localUnreadStatus = (UnreadStatus) this.mList.get(paramInt);
        if (localUnreadStatus.isHasSubOrPm()) {
            return localUnreadStatus.getChildrenList().size();
        }
        return 1;
    }

    public Object getGroup(int paramInt) {
        return this.mList.get(paramInt);
    }

    public int getGroupCount() {
        return this.mList.size();
    }

    public long getGroupId(int paramInt) {
        return paramInt * 100;
    }

    public View getGroupView(int paramInt, boolean paramBoolean, View paramView, ViewGroup paramViewGroup) {
        return ((UnreadStatus) this.mList.get(paramInt)).createView(1, paramView, this.activityStatus);
    }

    public int getGroupidByforum(String paramString) {
        int i = 0;
        for (; ; ) {
            int j;
            if (i >= this.mList.size()) {
                j = -1;
            }
            String str;
            do {
                return j;
                str = ((UnreadStatus) this.mList.get(i)).getLoginStatus().getPrimaryKey();
                if (Util.compareTwoString(str, "0")) {
                    break;
                }
                j = i;
            } while (Util.compareTwoString(paramString, str));
            i += 1;
        }
    }

    public ArrayList<UnreadStatus> getmList() {
        return this.mList;
    }

    public boolean hasStableIds() {
        return true;
    }

    public boolean isChildSelectable(int paramInt1, int paramInt2) {
        return true;
    }

    public boolean removeChild(int paramInt1, int paramInt2) {
        UnreadStatus localUnreadStatus = (UnreadStatus) this.mList.get(paramInt1);
        if (localUnreadStatus.isHasSubOrPm()) {
            boolean bool = localUnreadStatus.removeChild(paramInt2);
            if ((bool) && (!localUnreadStatus.isHasSubOrPm())) {
                this.mList.remove(paramInt1);
            }
            return bool;
        }
        return false;
    }

    public void setBaseData(ArrayList<TapatalkForum> paramArrayList) {
        this.baseData = paramArrayList;
    }

    public void setExpandedGroup(int paramInt) {
        this.expandedGroupPos = paramInt;
    }

    public void setmList(ArrayList<UnreadStatus> paramArrayList) {
        this.mList = paramArrayList;
    }

    public void start() {
        initForum();
    }

    private class IndexObject {
        static final int Tag_HasMore = 1;
        static final int Tag_NoMore = 2;
        public int tag;

        public IndexObject(int paramInt) {
            this.tag = paramInt;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/favunread/FavoriateForumInboxAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */