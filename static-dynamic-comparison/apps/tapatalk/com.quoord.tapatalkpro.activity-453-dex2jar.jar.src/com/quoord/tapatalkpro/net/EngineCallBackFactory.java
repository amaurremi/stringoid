package com.quoord.tapatalkpro.net;

import android.content.Context;
import com.quoord.tapatalkpro.adapter.forum.PrefetchAccountCallBack;

public class EngineCallBackFactory {
    public static final String Method_PrefetchAccount = "prefetch_account";

    public static CallBackInterfaceHasHandleListener getCallBackInstance(String paramString, Context paramContext) {
        if (paramString.equals("prefetch_account")) {
            return new PrefetchAccountCallBack(paramContext);
        }
        return null;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/net/EngineCallBackFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */