package com.quoord.tapatalkpro.action;

import android.app.Activity;
import com.quoord.tapatalkpro.adapter.TryTwiceCallBackInterface;
import com.quoord.tapatalkpro.bean.EngineResponse;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.util.TapatalkEngine;

import java.util.ArrayList;

public class GetAnnTopicAction
        implements TryTwiceCallBackInterface {
    private ActionCallBack actionCallBack;
    private TapatalkEngine engine;
    private ForumStatus forumStatus;
    private Activity mContext;
    private boolean tryTwice;

    public GetAnnTopicAction(ForumStatus paramForumStatus, Activity paramActivity) {
        this.engine = new TapatalkEngine(this, paramForumStatus, paramActivity);
        this.forumStatus = paramForumStatus;
        this.mContext = paramActivity;
    }

    public void callBack(EngineResponse paramEngineResponse) {
        if ((CallBackChecker.checkCallBack(paramEngineResponse, this.mContext, this.forumStatus, this.engine, isOpCancel(), this)) && (this.actionCallBack != null)) {
            this.actionCallBack.actionCallBack(paramEngineResponse);
        }
    }

    public void getAnnTopic(String paramString, ActionCallBack paramActionCallBack) {
        this.actionCallBack = paramActionCallBack;
        setTryTwice(false);
        setOpCancel(false);
        paramActionCallBack = new ArrayList();
        paramActionCallBack.add(paramString);
        paramActionCallBack.add(Integer.valueOf(0));
        paramActionCallBack.add(Integer.valueOf(19));
        paramActionCallBack.add("ANN");
        this.engine.call("get_topic", paramActionCallBack);
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

    public static abstract interface ActionCallBack {
        public abstract void actionCallBack(EngineResponse paramEngineResponse);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/action/GetAnnTopicAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */