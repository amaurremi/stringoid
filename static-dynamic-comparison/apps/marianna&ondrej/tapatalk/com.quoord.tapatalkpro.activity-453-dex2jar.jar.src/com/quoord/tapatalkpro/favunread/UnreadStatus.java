package com.quoord.tapatalkpro.favunread;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.quoord.tapatalkpro.TapatalkApp;
import com.quoord.tapatalkpro.activity.forum.ForumActivityStatus;
import com.quoord.tapatalkpro.bean.Conversation;
import com.quoord.tapatalkpro.bean.ListItemClickable;
import com.quoord.tapatalkpro.bean.PrivateMessage;
import com.quoord.tapatalkpro.bean.Topic;
import com.quoord.tapatalkpro.ics.slidingMenu.SettingsFragment;
import com.quoord.tapatalkpro.sqlhelper.SubscribeForumSqlHelper;
import com.quoord.tapatalkpro.util.ThemeUtil;
import com.quoord.tools.ImageTools;
import com.quoord.tools.LoginStatus;

import java.util.ArrayList;
import java.util.HashMap;

public class UnreadStatus
        implements ListItemClickable {
    public static final int CHILD_TAG = 2;
    public static final int GROUP_TAG = 1;
    private ForumUnreadStatusCall call;
    private ArrayList childrenList = new ArrayList();
    private String forumPri;
    private boolean hasSubOrPm = false;
    private boolean isConver = false;
    private int listIndex;
    private LoginStatus loginStatus;
    private Handler mHandler = new Handler() {
        public void handleMessage(Message paramAnonymousMessage) {
            if (new SubscribeForumSqlHelper((Context) paramAnonymousMessage.obj, TapatalkApp.database_name, null, Integer.parseInt(TapatalkApp.database_version)).get(UnreadStatus.this.loginStatus.getUrl()).size() > 3) {
            }
        }
    };
    private ArrayList<PrivateMessage> realPmList = new ArrayList();
    private ArrayList<Topic> realSubScribeList = new ArrayList();
    private ArrayList<Conversation> realconversationList = new ArrayList();
    private boolean shouldhasSubOrPm = false;
    private int unreadPm = 0;
    private int unreadSubscribed = 0;

    private void reSetUnreadNum() {
        if (this.unreadSubscribed < this.realSubScribeList.size()) {
            this.unreadSubscribed = this.realSubScribeList.size();
        }
        if (isConver()) {
            if (this.unreadPm < this.realconversationList.size()) {
                this.unreadPm = this.realconversationList.size();
            }
        }
        while (this.unreadPm >= this.realPmList.size()) {
            return;
        }
        this.unreadPm = this.realPmList.size();
    }

    public void addConversationList(ArrayList<Conversation> paramArrayList) {
        if (paramArrayList != null) {
            this.realconversationList.addAll(paramArrayList);
        }
    }

    public void addPmList(ArrayList<PrivateMessage> paramArrayList) {
        if (paramArrayList != null) {
            this.realPmList.clear();
            this.realPmList.addAll(paramArrayList);
        }
    }

    public void addTopicList(ArrayList<Topic> paramArrayList) {
        if (paramArrayList != null) {
            this.realSubScribeList.clear();
            this.realSubScribeList.addAll(paramArrayList);
        }
    }

    public void clearPm() {
        this.realPmList.clear();
        this.realconversationList.clear();
    }

    public void clearTopic() {
        this.realSubScribeList.clear();
    }

    public View createView(int paramInt, View paramView, ForumActivityStatus paramForumActivityStatus) {
        View localView = paramView;
        GroupHolder localGroupHolder;
        if (1 == paramInt) {
            if (paramView != null) {
                break label188;
            }
            localGroupHolder = new GroupHolder(null);
            paramView = paramForumActivityStatus.getDefaultActivity().getLayoutInflater().inflate(2130903412, null);
            localGroupHolder.icon = ((ImageView) paramView.findViewById(2131231076));
            localGroupHolder.title = ((TextView) paramView.findViewById(2131231215));
            localGroupHolder.icon.setBackgroundDrawable(ThemeUtil.getDrawableByPicName("avator_background", paramForumActivityStatus.getDefaultActivity()));
            paramView.setTag(localGroupHolder);
        }
        for (; ; ) {
            if (this.loginStatus.getForumIconUrl() != null) {
                ImageTools.glideLoad(this.loginStatus.getForumIconUrl(), localGroupHolder.icon);
            }
            localGroupHolder.title.setText(this.loginStatus.getForumName());
            localView = paramView;
            if (!SettingsFragment.isLightTheme(paramForumActivityStatus.getDefaultActivity())) {
                localGroupHolder.title.setTextColor(paramForumActivityStatus.getDefaultActivity().getResources().getColor(2131165213));
                localView = paramView;
            }
            if (!isShouldhasSubOrPm()) {
                break;
            }
            localView.setVisibility(0);
            return localView;
            label188:
            localGroupHolder = (GroupHolder) paramView.getTag();
        }
        localView.setVisibility(8);
        return localView;
    }

    public View createView(HashMap paramHashMap, View paramView, ForumActivityStatus paramForumActivityStatus) {
        return null;
    }

    public boolean equals(Object paramObject) {
        return ((paramObject instanceof UnreadStatus)) && (((UnreadStatus) paramObject).getForumPri().equals(this.forumPri));
    }

    public ForumUnreadStatusCall getCall() {
        return this.call;
    }

    public ArrayList getChildrenList() {
        if (this.childrenList == null) {
            this.childrenList = new ArrayList();
            if (isConver()) {
                this.childrenList.addAll(this.realconversationList);
                this.childrenList.addAll(this.realSubScribeList);
            }
        }
        while ((this.realconversationList.size() <= 0) && (this.realPmList.size() <= 0) && (this.realSubScribeList.size() <= 0)) {
            for (; ; ) {
                reSetUnreadNum();
                return this.childrenList;
                this.childrenList.addAll(this.realPmList);
            }
        }
        int j = this.childrenList.size();
        int i;
        if (isConver()) {
            i = 0 + this.realconversationList.size();
            label128:
            if (i + this.realSubScribeList.size() == j) {
                break label193;
            }
            this.childrenList.clear();
            if (!isConver()) {
                break label195;
            }
            this.childrenList.addAll(this.realconversationList);
        }
        for (; ; ) {
            this.childrenList.addAll(this.realSubScribeList);
            break;
            i = 0 + this.realPmList.size();
            break label128;
            label193:
            break;
            label195:
            this.childrenList.addAll(this.realPmList);
        }
    }

    public ArrayList getCorrectPmList() {
        if (isConver()) {
            return this.realconversationList;
        }
        return this.realPmList;
    }

    public String getForumPri() {
        return this.forumPri;
    }

    public int getListIndex() {
        return this.listIndex;
    }

    public LoginStatus getLoginStatus() {
        return this.loginStatus;
    }

    public ArrayList<PrivateMessage> getRealPmList() {
        return this.realPmList;
    }

    public ArrayList<Topic> getRealSubScribeList() {
        return this.realSubScribeList;
    }

    public ArrayList<Conversation> getRealconversationList() {
        return this.realconversationList;
    }

    public int getSumOfTopicAndPm() {
        return this.realSubScribeList.size() + getCorrectPmList().size();
    }

    public int getUnreadPm() {
        return this.unreadPm;
    }

    public int getUnreadSubscribed() {
        return this.unreadSubscribed;
    }

    public void initLocalSubscribeForum(Context paramContext) {
        Message localMessage = this.mHandler.obtainMessage(1);
        localMessage.obj = paramContext;
        this.mHandler.sendMessage(localMessage);
    }

    public boolean isConver() {
        return this.isConver;
    }

    public boolean isHasSubOrPm() {
        if (getSumOfTopicAndPm() > 0) {
        }
        for (this.hasSubOrPm = true; ; this.hasSubOrPm = false) {
            return this.hasSubOrPm;
        }
    }

    public boolean isLoginOver() {
        return (this.call.isLoginSuccess()) || (this.call.getLoginNum() >= 2);
    }

    public boolean isShouldHasPm() {
        return this.unreadPm > 0;
    }

    public boolean isShouldHasSub() {
        return this.unreadSubscribed > 0;
    }

    public boolean isShouldhasSubOrPm() {
        if (this.unreadPm + this.unreadSubscribed > 0) {
        }
        for (this.shouldhasSubOrPm = true; ; this.shouldhasSubOrPm = false) {
            return this.shouldhasSubOrPm;
        }
    }

    public boolean onClick(View paramView, ForumActivityStatus paramForumActivityStatus) {
        return false;
    }

    public boolean onLongClick(View paramView, ForumActivityStatus paramForumActivityStatus) {
        return false;
    }

    public void removeAllChild() {
        this.childrenList.clear();
        this.realconversationList.clear();
        this.realPmList.clear();
        this.realSubScribeList.clear();
    }

    public boolean removeChild(int paramInt) {
        if ((this.childrenList == null) || (this.childrenList.size() <= paramInt)) {
            return false;
        }
        Object localObject = this.childrenList.remove(paramInt);
        if ((localObject instanceof Topic)) {
            if (this.realSubScribeList.remove(localObject)) {
                this.unreadSubscribed -= 1;
                return true;
            }
        } else if ((localObject instanceof PrivateMessage)) {
            if (this.realPmList.remove(localObject)) {
                this.unreadPm -= 1;
                return true;
            }
        } else if (((localObject instanceof Conversation)) && (this.realconversationList.remove(localObject))) {
            this.unreadPm -= 1;
            return true;
        }
        reSetUnreadNum();
        return false;
    }

    public void selfChange(View paramView, ForumActivityStatus paramForumActivityStatus) {
    }

    public void setCall(ForumUnreadStatusCall paramForumUnreadStatusCall) {
        this.call = paramForumUnreadStatusCall;
    }

    public void setForumPri(String paramString) {
        this.forumPri = paramString;
    }

    public void setListIndex(int paramInt) {
        this.listIndex = paramInt;
    }

    public void setLoginStatus(LoginStatus paramLoginStatus) {
        this.loginStatus = paramLoginStatus;
        this.isConver = paramLoginStatus.isSupportConve();
    }

    public void setUnreadPm(int paramInt) {
        this.unreadPm = paramInt;
    }

    public void setUnreadSubscribed(int paramInt) {
        this.unreadSubscribed = paramInt;
    }

    private class GroupHolder {
        ImageView icon;
        TextView title;

        private GroupHolder() {
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/favunread/UnreadStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */