package com.quoord.tapatalkpro.adapter.directory.ics;

import android.content.Context;
import com.quoord.tapatalkpro.activity.forum.ForumActivityStatus;
import com.quoord.tapatalkpro.adapter.CallBackResult;
import com.quoord.tapatalkpro.bean.EngineResponse;
import com.quoord.tapatalkpro.bean.TapatalkForum;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

public class SearchForumsCallBack
        extends CallBackResult {
    public void handleBackResult(EngineResponse paramEngineResponse, Context paramContext)
            throws Exception {
    }

    public void handleBackResult(EngineResponse paramEngineResponse, ForumActivityStatus paramForumActivityStatus)
            throws Exception {
    }

    public void handleBackResult(String paramString, Context paramContext)
            throws Exception {
    }

    public void handleBackResult(String paramString, ForumActivityStatus paramForumActivityStatus)
            throws Exception {
    }

    public void handleBackResult(JSONArray paramJSONArray, Context paramContext)
            throws Exception {
        if (paramJSONArray == null) {
            return;
        }
        paramContext = new ArrayList();
        int j = paramJSONArray.length();
        int i = 0;
        for (; ; ) {
            if (i >= j) {
                setDataList(paramContext);
                return;
            }
            paramContext.add(TapatalkForum.getForum(paramJSONArray.getJSONObject(i), null, null, null));
            i += 1;
        }
    }

    public void handleBackResult(JSONArray paramJSONArray, ForumActivityStatus paramForumActivityStatus)
            throws Exception {
    }

    public void handleBackResult(JSONObject paramJSONObject, Context paramContext)
            throws Exception {
    }

    public void handleBackResult(JSONObject paramJSONObject, ForumActivityStatus paramForumActivityStatus)
            throws Exception {
    }

    public void saveResponseValue(EngineResponse paramEngineResponse, Context paramContext)
            throws Exception {
    }

    public void saveResponseValue(EngineResponse paramEngineResponse, ForumActivityStatus paramForumActivityStatus)
            throws Exception {
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/adapter/directory/ics/SearchForumsCallBack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */