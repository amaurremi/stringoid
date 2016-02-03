package com.quoord.tapatalkpro.callbackhandle;

import android.app.Activity;
import android.content.res.Resources;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.quoord.tapatalkpro.activity.forum.ForumActivityStatus;
import com.quoord.tapatalkpro.bean.EngineResponse;
import com.quoord.tapatalkpro.util.Util;

import java.util.HashMap;

class UpdatePasswordCallbackHandler
        implements AbsCallBackHandler {
    public String getMethodName() {
        return "update_password";
    }

    public HandlerState handleCallback(EngineResponse paramEngineResponse, ForumActivityStatus paramForumActivityStatus) {
        paramEngineResponse = (HashMap) paramEngineResponse.getResponse();
        if (((Boolean) paramEngineResponse.get("result")).booleanValue()) {
            arrayOfByte = (byte[]) paramEngineResponse.get("result_text");
            paramEngineResponse = arrayOfByte;
            if (arrayOfByte.length <= 0) {
                paramEngineResponse = paramForumActivityStatus.getDefaultActivity().getResources().getString(2131100572).getBytes();
            }
            Util.showToastForLong(paramForumActivityStatus.getDefaultActivity(), paramEngineResponse);
            paramEngineResponse = (InputMethodManager) paramForumActivityStatus.getDefaultActivity().getSystemService("input_method");
            if (paramForumActivityStatus.getDefaultActivity().getCurrentFocus() != null) {
                paramEngineResponse.hideSoftInputFromWindow(paramForumActivityStatus.getDefaultActivity().getCurrentFocus().getWindowToken(), 2);
            }
            return HandlerState.state_COMPLETED;
        }
        byte[] arrayOfByte = (byte[]) paramEngineResponse.get("result_text");
        paramEngineResponse = arrayOfByte;
        if (arrayOfByte.length <= 0) {
            paramEngineResponse = paramForumActivityStatus.getDefaultActivity().getResources().getString(2131100573).getBytes();
        }
        Util.showToastForLong(paramForumActivityStatus.getDefaultActivity(), paramEngineResponse);
        return HandlerState.state_FALSEHANDLED;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/callbackhandle/UpdatePasswordCallbackHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */