package com.quoord.tapatalkpro.callbackhandle;

import com.quoord.tapatalkpro.activity.forum.ForumActivityStatus;
import com.quoord.tapatalkpro.bean.EngineResponse;

public abstract interface AbsCallBackHandler {
    public abstract String getMethodName();

    public abstract HandlerState handleCallback(EngineResponse paramEngineResponse, ForumActivityStatus paramForumActivityStatus);
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/callbackhandle/AbsCallBackHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */