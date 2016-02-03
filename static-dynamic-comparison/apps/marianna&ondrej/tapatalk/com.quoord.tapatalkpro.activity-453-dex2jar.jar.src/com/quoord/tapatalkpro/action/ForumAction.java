package com.quoord.tapatalkpro.action;

import android.app.Activity;
import com.quoord.tapatalkpro.adapter.TryTwiceCallBackInterface;
import com.quoord.tapatalkpro.bean.EngineResponse;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.util.TapatalkEngine;

import java.util.ArrayList;

public class ForumAction
        implements TryTwiceCallBackInterface {
    private ActionCallBack actionCallBack;
    private TapatalkEngine engine;
    private ForumStatus forumStatus;
    private Activity mContext;

    public ForumAction(ForumStatus paramForumStatus, Activity paramActivity) {
        this.engine = new TapatalkEngine(this, paramForumStatus, paramActivity);
        this.forumStatus = paramForumStatus;
        this.mContext = paramActivity;
    }

    public void callBack(EngineResponse paramEngineResponse) {
        if ((CallBackChecker.checkCallBack(paramEngineResponse, this.mContext, this.forumStatus, this.engine, isOpCancel(), this)) && (this.actionCallBack != null)) {
            this.actionCallBack.actionCallBack(paramEngineResponse);
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

    public void markAllRead(ActionCallBack paramActionCallBack) {
        this.actionCallBack = paramActionCallBack;
        setTryTwice(false);
        paramActionCallBack = new ArrayList();
        this.engine.call("mark_all_as_read", paramActionCallBack);
        this.forumStatus.cleanNewPost();
    }

    public void markForumRead(String paramString, ActionCallBack paramActionCallBack) {
        this.actionCallBack = paramActionCallBack;
        setTryTwice(false);
        paramActionCallBack = new ArrayList();
        paramActionCallBack.add(paramString);
        this.engine.call("mark_all_as_read", paramActionCallBack);
        this.forumStatus.cleanNewPost();
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

    public static abstract interface ActionCallBack {
        public abstract void actionCallBack(EngineResponse paramEngineResponse);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/action/ForumAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */