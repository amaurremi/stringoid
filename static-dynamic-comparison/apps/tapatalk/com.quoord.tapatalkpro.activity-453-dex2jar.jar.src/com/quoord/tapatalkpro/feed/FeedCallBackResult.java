package com.quoord.tapatalkpro.feed;

import android.content.Context;
import com.quoord.tapatalkpro.activity.forum.ForumActivityStatus;
import com.quoord.tapatalkpro.adapter.CallBackResult;
import com.quoord.tapatalkpro.bean.EngineResponse;
import com.quoord.tapatalkpro.bean.Topic;
import com.quoord.tapatalkpro.util.Util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

public class FeedCallBackResult
        extends CallBackResult {
    public void handleBackResult(EngineResponse paramEngineResponse, Context paramContext) {
    }

    public void handleBackResult(EngineResponse paramEngineResponse, ForumActivityStatus paramForumActivityStatus) {
    }

    public void handleBackResult(String paramString, Context paramContext) {
    }

    public void handleBackResult(String paramString, ForumActivityStatus paramForumActivityStatus) {
    }

    public void handleBackResult(JSONArray paramJSONArray, Context paramContext) {
    }

    public void handleBackResult(JSONArray paramJSONArray, ForumActivityStatus paramForumActivityStatus) {
    }

    public void handleBackResult(JSONObject paramJSONObject, Context paramContext)
            throws Exception {
        SimpleDateFormat localSimpleDateFormat;
        ArrayList localArrayList;
        int i;
        if (paramJSONObject != null) {
            setConnectionResult(true);
            if (paramJSONObject.has("topics")) {
                paramJSONObject = paramJSONObject.optJSONArray("topics");
                int j = paramJSONObject.length();
                localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                localArrayList = new ArrayList();
                i = 0;
                if (i < j) {
                    break label66;
                }
                setDataList(localArrayList);
            }
        }
        return;
        label66:
        JSONObject localJSONObject = paramJSONObject.getJSONObject(i);
        Topic localTopic = new Topic();
        if (localJSONObject.has("last_reply_time")) {
            localTopic.setLastReplyTime(localSimpleDateFormat.parse(localJSONObject.optString("last_reply_time", "")), paramContext);
        }
        localTopic.setReplyCount(localJSONObject.optInt("reply_number", 0));
        if (localJSONObject.optInt("is_closed", 0) > 0) {
            bool = true;
            label139:
            localTopic.setClosed(bool);
            localTopic.setAuthorName(localJSONObject.optString("topic_author_name", ""));
            localTopic.setAuthorId(localJSONObject.optString("topic_author_id", ""));
            localTopic.setForumName(localJSONObject.optString("forum_name", ""));
            localTopic.setIconUrl(localJSONObject.optString("icon_url", ""));
            localTopic.setForumUrl(localJSONObject.optString("furl", ""));
            localTopic.setTitle(localJSONObject.optString("topic_title", ""));
            localTopic.setShortContent(localJSONObject.optString("short_content", ""));
            localTopic.setForumId(localJSONObject.optString("forum_id", ""));
            localTopic.setPrefix(localJSONObject.optString("prefix", ""));
            if (localJSONObject.optInt("is_approved", 0) <= 0) {
                break label440;
            }
        }
        label440:
        for (boolean bool = true; ; bool = false) {
            localTopic.setApproved(bool);
            localTopic.setId(localJSONObject.optString("topic_id", ""));
            localTopic.setTapatalkForumName(localJSONObject.optString("fname", ""));
            localTopic.setTapatalkForumId(localJSONObject.optString("fid", ""));
            localTopic.setTopicImgUrl(localJSONObject.optString("topic_image", ""));
            localTopic.setViewCount(0);
            localTopic.setNewPost(true);
            if ((Util.checkString(localTopic.getTapatalkForumName())) && (!"null".equals(localTopic.getTapatalkForumName()))) {
                localTopic.setAuthorName(localTopic.getTapatalkForumName());
            }
            if (localJSONObject.has("flogo")) {
                localTopic.setIconUrl(localJSONObject.optString("flogo", ""));
            }
            localArrayList.add(localTopic);
            i += 1;
            break;
            bool = false;
            break label139;
        }
    }

    public void handleBackResult(JSONObject paramJSONObject, ForumActivityStatus paramForumActivityStatus) {
    }

    public void saveResponseValue(EngineResponse paramEngineResponse, Context paramContext) {
    }

    public void saveResponseValue(EngineResponse paramEngineResponse, ForumActivityStatus paramForumActivityStatus) {
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/feed/FeedCallBackResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */