package com.quoord.tapatalkpro.action;

import android.app.Activity;
import com.quoord.tapatalkpro.adapter.TryTwiceCallBackInterface;
import com.quoord.tapatalkpro.bean.Conversation;
import com.quoord.tapatalkpro.bean.EngineResponse;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.bean.PrivateMessage;
import com.quoord.tapatalkpro.ics.slidingMenu.SlidingMenuActivity;
import com.quoord.tapatalkpro.util.TapatalkEngine;

import java.util.ArrayList;

public class PMAction
        implements TryTwiceCallBackInterface {
    private Activity context;
    private TapatalkEngine engine;
    private ForumStatus forumStatus;
    private boolean tryTwice;

    public PMAction(Activity paramActivity, ForumStatus paramForumStatus) {
        this.context = paramActivity;
        this.forumStatus = paramForumStatus;
        this.engine = new TapatalkEngine(this, this.forumStatus, paramActivity);
    }

    public void callBack(EngineResponse paramEngineResponse) {
        if (CallBackChecker.checkCallBack(paramEngineResponse, this.context, this.forumStatus, this.engine, isOpCancel(), this)) {
            paramEngineResponse.isSuccess();
        }
    }

    public boolean getSaxCall() {
        return false;
    }

    public boolean getTryTwice() {
        return this.tryTwice;
    }

    public boolean isOpCancel() {
        return false;
    }

    public void markConsUnread(Conversation paramConversation) {
        setTryTwice(false);
        ArrayList localArrayList = new ArrayList();
        if (paramConversation != null) {
            localArrayList.add(paramConversation.getConv_id());
            paramConversation.setNew_post(true);
        }
        this.engine.call("mark_conversation_unread", localArrayList);
        if ((this.context instanceof SlidingMenuActivity)) {
            ((SlidingMenuActivity) this.context).getUnreadNumbers();
        }
    }

    public void markMessageUnread(PrivateMessage paramPrivateMessage) {
        setTryTwice(false);
        ArrayList localArrayList = new ArrayList();
        if (paramPrivateMessage != null) {
            localArrayList.add(paramPrivateMessage.getMsgId());
            paramPrivateMessage.setMsgState(1);
        }
        this.engine.call("mark_pm_unread", localArrayList);
        if ((this.context instanceof SlidingMenuActivity)) {
            ((SlidingMenuActivity) this.context).getUnreadNumbers();
        }
    }

    public void setOpCancel(boolean paramBoolean) {
    }

    public void setSaxCall(boolean paramBoolean) {
    }

    public void setTryTwice(boolean paramBoolean) {
        this.tryTwice = paramBoolean;
    }

    public void tryFailed(String paramString) {
    }

    public void updateSubclassDialog(int paramInt) {
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/action/PMAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */