package com.quoord.tapatalkpro.net;

import com.quoord.tapatalkpro.adapter.CallBackResult;
import com.quoord.tapatalkpro.adapter.directory.ics.SearchForumsCallBack;
import com.quoord.tapatalkpro.feed.FeedCallBackResult;
import com.quoord.tapatalkpro.ics.forum.ForumCallBackResult;
import com.quoord.tapatalkpro.util.Util;

public class AQueryEngineCallBackResultFactory {
    public CallBackResult getBackResultInstance(String paramString) {
        if (!Util.checkString(paramString)) {
        }
        do {
            return null;
            if (paramString.equals("feed")) {
                paramString = new FeedCallBackResult();
                paramString.setMethodName("feed");
                paramString.setResultTypeCode(0);
                return paramString;
            }
            if (paramString.equals("getforumbyurl")) {
                paramString = new ForumCallBackResult();
                paramString.setMethodName("getforumbyurl");
                paramString.setResultTypeCode(0);
                return paramString;
            }
            if (paramString.equals("getforumbyid")) {
                paramString = new ForumCallBackResult();
                paramString.setMethodName("getforumbyid");
                paramString.setResultTypeCode(1);
                return paramString;
            }
        } while (!paramString.equals("searchforum"));
        paramString = new SearchForumsCallBack();
        paramString.setMethodName("searchforum");
        paramString.setResultTypeCode(1);
        return paramString;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/net/AQueryEngineCallBackResultFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */