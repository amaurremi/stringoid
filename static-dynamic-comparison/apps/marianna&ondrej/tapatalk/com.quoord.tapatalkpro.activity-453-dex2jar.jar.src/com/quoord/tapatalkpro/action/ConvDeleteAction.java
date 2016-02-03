package com.quoord.tapatalkpro.action;

import android.app.Activity;
import android.content.Intent;
import android.widget.Toast;
import com.quoord.tapatalkpro.adapter.TryTwiceCallBackInterface;
import com.quoord.tapatalkpro.adapter.forum.conversation.ConvAdapter;
import com.quoord.tapatalkpro.bean.Conversation;
import com.quoord.tapatalkpro.bean.EngineResponse;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.ics.slidingMenu.SlidingMenuActivity;
import com.quoord.tapatalkpro.util.TapatalkEngine;

import java.util.ArrayList;
import java.util.HashMap;

public class ConvDeleteAction
        implements TryTwiceCallBackInterface {
    private static final int HARD_DELETE = 2;
    private static final int SOFT_DELETE = 1;
    private ConvAdapter convAdapter;
    protected TapatalkEngine engine = null;
    private ForumStatus forumStatus = null;
    private Activity mContext = null;

    public ConvDeleteAction(Activity paramActivity, ForumStatus paramForumStatus, ConvAdapter paramConvAdapter) {
        this.mContext = paramActivity;
        this.forumStatus = paramForumStatus;
        this.convAdapter = paramConvAdapter;
        this.engine = new TapatalkEngine(this, this.forumStatus, this.mContext);
    }

    public ConvDeleteAction(Activity paramActivity, ForumStatus paramForumStatus, Conversation paramConversation, ConvAdapter paramConvAdapter) {
        this.mContext = paramActivity;
        this.forumStatus = paramForumStatus;
        this.convAdapter = paramConvAdapter;
        this.engine = new TapatalkEngine(this, this.forumStatus, this.mContext);
        deleteConversation(paramConversation);
    }

    public void callBack(EngineResponse paramEngineResponse) {
        if (paramEngineResponse.getMethod().equals("delete_conversation")) {
            Object localObject = (HashMap) paramEngineResponse.getResponse();
            if ((localObject != null) && (((Boolean) ((HashMap) localObject).get("result")).booleanValue()) && (this.convAdapter == null)) {
                localObject = new Intent(this.mContext, SlidingMenuActivity.class);
                this.mContext.setResult(29, (Intent) localObject);
                this.mContext.finish();
            }
            if ((paramEngineResponse.getErrorMessage() != null) && (!paramEngineResponse.getErrorMessage().equals(""))) {
                Toast.makeText(this.mContext, paramEngineResponse.getErrorMessage().toString(), 1).show();
            }
        }
    }

    public void deleteConversation(Conversation paramConversation) {
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(paramConversation.getConv_id());
        if (this.forumStatus.isXF()) {
            localArrayList.add(Integer.valueOf(1));
        }
        for (; ; ) {
            this.engine.call("delete_conversation", localArrayList);
            this.mContext.showDialog(0);
            return;
            localArrayList.add(Integer.valueOf(2));
        }
    }

    public void deleteConversation(String paramString) {
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(paramString);
        if (this.forumStatus.isXF()) {
            localArrayList.add(Integer.valueOf(1));
        }
        for (; ; ) {
            this.engine.call("delete_conversation", localArrayList);
            return;
            localArrayList.add(Integer.valueOf(2));
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


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/action/ConvDeleteAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */