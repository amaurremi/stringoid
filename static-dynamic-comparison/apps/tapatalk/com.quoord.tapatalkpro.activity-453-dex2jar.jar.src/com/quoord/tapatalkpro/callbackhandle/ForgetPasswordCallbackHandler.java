package com.quoord.tapatalkpro.callbackhandle;

import android.app.Activity;
import com.quoord.tapatalkpro.activity.forum.ForumActivityStatus;
import com.quoord.tapatalkpro.bean.EngineResponse;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.util.Util;

import java.util.HashMap;

class ForgetPasswordCallbackHandler
        implements AbsCallBackHandler {
    public String getMethodName() {
        return "forget_password";
    }

    public HandlerState handleCallback(EngineResponse paramEngineResponse, ForumActivityStatus paramForumActivityStatus) {
        Activity localActivity = paramForumActivityStatus.getDefaultActivity();
        paramForumActivityStatus = paramForumActivityStatus.getForumStatus().getRegister_email();
        paramEngineResponse = (HashMap) paramEngineResponse.getResponse();
        if (((Boolean) paramEngineResponse.get("result")).booleanValue()) {
            if (((Boolean) paramEngineResponse.get("verified")).booleanValue()) {
                return HandlerState.state_NEEDNEXTSTEP;
            }
            paramEngineResponse = (byte[]) paramEngineResponse.get("result_text");
            if ((paramEngineResponse != null) && (paramEngineResponse.length > 0)) {
                Util.showToastForLong(localActivity, paramEngineResponse);
            }
            for (; ; ) {
                return HandlerState.state_COMPLETED;
                Util.showToastForLong(localActivity, localActivity.getString(2131100533));
            }
        }
        paramEngineResponse = (byte[]) paramEngineResponse.get("result_text");
        if ((paramEngineResponse != null) && (paramEngineResponse.length > 0)) {
            Util.showToastForLong(localActivity, paramEngineResponse);
        }
        for (; ; ) {
            return HandlerState.state_FALSEHANDLED;
            Util.showToastForLong(localActivity, String.format(localActivity.getString(2131100534), new Object[]{paramForumActivityStatus}));
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/callbackhandle/ForgetPasswordCallbackHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */