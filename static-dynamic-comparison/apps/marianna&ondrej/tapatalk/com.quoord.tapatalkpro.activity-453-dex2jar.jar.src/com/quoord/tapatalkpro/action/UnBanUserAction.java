package com.quoord.tapatalkpro.action;

import android.app.Activity;
import com.quoord.tapatalkpro.adapter.TryTwiceCallBackInterface;
import com.quoord.tapatalkpro.bean.EngineResponse;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.util.TapatalkEngine;
import com.quoord.tapatalkpro.util.Util;

import java.util.ArrayList;
import java.util.HashMap;

public class UnBanUserAction
        implements TryTwiceCallBackInterface {
    private unBanUserCallback callBack;
    private TapatalkEngine engine = null;
    private Activity mActivity;
    private String userId;

    public UnBanUserAction(Activity paramActivity, ForumStatus paramForumStatus, String paramString) {
        this.mActivity = paramActivity;
        this.userId = paramString;
        this.engine = new TapatalkEngine(this, paramForumStatus, this.mActivity);
    }

    public void callBack(EngineResponse paramEngineResponse) {
        if (paramEngineResponse == null) {
        }
        while (!paramEngineResponse.isSuccess()) {
            return;
        }
        paramEngineResponse = (HashMap) paramEngineResponse.getResponse();
        if (((Boolean) paramEngineResponse.get("result")).booleanValue()) {
            Util.showToastForLong(this.mActivity, "unban success!");
        }
        for (; ; ) {
            this.callBack.callback(((Boolean) paramEngineResponse.get("result")).booleanValue());
            return;
            String str = new String((byte[]) paramEngineResponse.get("result_text")).toString();
            Util.showToastForLong(this.mActivity, str);
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

    public void unBanUsre(unBanUserCallback paramunBanUserCallback) {
        this.callBack = paramunBanUserCallback;
        paramunBanUserCallback = new ArrayList();
        paramunBanUserCallback.add(this.userId);
        this.engine.call("m_unban_user", paramunBanUserCallback);
    }

    public void updateSubclassDialog(int paramInt) {
    }

    public static abstract interface unBanUserCallback {
        public abstract void callback(boolean paramBoolean);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/action/UnBanUserAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */