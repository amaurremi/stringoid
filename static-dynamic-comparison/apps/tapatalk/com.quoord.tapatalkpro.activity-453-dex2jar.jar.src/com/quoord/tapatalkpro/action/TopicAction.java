package com.quoord.tapatalkpro.action;

import android.app.Activity;
import android.widget.Toast;
import com.quoord.tapatalkpro.adapter.TryTwiceCallBackInterface;
import com.quoord.tapatalkpro.bean.EngineResponse;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.util.TapatalkEngine;

import java.util.ArrayList;

public class TopicAction
        implements TryTwiceCallBackInterface {
    private Activity context;
    private TapatalkEngine engine;
    private ForumStatus forumStatus;
    private boolean tryTwice;

    public TopicAction(Activity paramActivity, ForumStatus paramForumStatus) {
        this.context = paramActivity;
        this.forumStatus = paramForumStatus;
        this.engine = new TapatalkEngine(this, this.forumStatus, paramActivity);
    }

    public void callBack(EngineResponse paramEngineResponse) {
        if ((CallBackChecker.checkCallBack(paramEngineResponse, this.context, this.forumStatus, this.engine, isOpCancel(), this)) && (paramEngineResponse.isSuccess())) {
            Toast.makeText(this.context, this.context.getString(2131099903), 0).show();
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

    public void markTopicRead(String paramString) {
        setTryTwice(false);
        setOpCancel(false);
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(new String[]{paramString});
        this.engine.call("mark_topic_read", localArrayList);
    }

    public void markTopicRead(String paramString, int paramInt) {
        setTryTwice(false);
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(paramString);
        int i;
        if (paramInt <= 20) {
            i = 0;
        }
        for (; ; ) {
            localArrayList.add(Integer.valueOf(i));
            localArrayList.add(Integer.valueOf(paramInt));
            if (this.forumStatus.isSupprotBBcode()) {
                localArrayList.add(Boolean.valueOf(true));
            }
            this.engine.call("get_thread", localArrayList);
            return;
            i = paramInt - 20;
            paramInt += 1;
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


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/action/TopicAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */