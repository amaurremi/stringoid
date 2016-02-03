package com.quoord.tapatalkpro.ics.action;

import android.app.Activity;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.RequestQueue;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.quoord.tapatalkpro.bean.TapatalkForumForSearch;
import com.quoord.tapatalkpro.bean.Topic;
import com.quoord.tapatalkpro.util.FakeX509TrustManager;
import com.quoord.tools.directoryurl.DirectoryUrlUtil;
import com.quoord.tools.net.JSONUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONObject;

public class IcsSearchTopicAction {
    private Activity mActivity;
    private IcsSearchTopicActionBack mCallBack;
    private RequestQueue mQueue = null;
    private Integer mTopicCount = Integer.valueOf(0);

    public IcsSearchTopicAction(Activity paramActivity) {
        this.mActivity = paramActivity;
        this.mQueue = Volley.newRequestQueue(this.mActivity);
    }

    private Date getLastReplyTime(String paramString) {
        if (paramString == null) {
            return null;
        }
        if (paramString.contains("T")) {
            localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            try {
                paramString = localSimpleDateFormat.parse(paramString);
                return paramString;
            } catch (ParseException paramString) {
                paramString.printStackTrace();
                return null;
            }
        }
        SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        try {
            paramString = localSimpleDateFormat.parse(paramString);
            return paramString;
        } catch (ParseException paramString) {
            paramString.printStackTrace();
        }
        return null;
    }

    private ArrayList<TapatalkForumForSearch> getSearchTopicResult(JSONObject paramJSONObject) {
        if (paramJSONObject == null) {
            paramJSONObject = null;
            return paramJSONObject;
        }
        if ((!paramJSONObject.has("tapatalk_forums")) || (!paramJSONObject.has("topics"))) {
            return null;
        }
        JSONArray localJSONArray = paramJSONObject.optJSONArray("topics");
        paramJSONObject = paramJSONObject.optJSONArray("tapatalk_forums");
        if ((paramJSONObject == null) || (localJSONArray == null)) {
            return null;
        }
        ArrayList localArrayList = new ArrayList();
        int i = 0;
        for (; ; ) {
            if (i >= paramJSONObject.length()) {
                this.mTopicCount = Integer.valueOf(localJSONArray.length());
                i = 0;
                if (i < localJSONArray.length()) {
                    break label170;
                }
                i = localArrayList.size() - 1;
                for (; ; ) {
                    paramJSONObject = localArrayList;
                    if (i < 0) {
                        break;
                    }
                    paramJSONObject = (TapatalkForumForSearch) localArrayList.get(i);
                    if ((paramJSONObject.getTopics() == null) || (paramJSONObject.getTopics().size() == 0)) {
                        localArrayList.remove(i);
                    }
                    i -= 1;
                }
            }
            localArrayList.add(TapatalkForumForSearch.getForum(paramJSONObject.optJSONObject(i), null, null, null));
            i += 1;
        }
        label170:
        Object localObject = new JSONUtil(localJSONArray.optJSONObject(i));
        paramJSONObject = new Topic();
        paramJSONObject.setId(((JSONUtil) localObject).optString("topic_id", ""));
        paramJSONObject.setTitle(((JSONUtil) localObject).optString("topic_title", ""));
        paramJSONObject.setAuthorId(((JSONUtil) localObject).optString("topic_author_id", ""));
        paramJSONObject.setAuthorName(((JSONUtil) localObject).optString("topic_author_name", ""));
        paramJSONObject.setShortContent(((JSONUtil) localObject).optString("short_content", ""));
        paramJSONObject.setClosed(((JSONUtil) localObject).optBoolean("is_closed", Boolean.valueOf(false)).booleanValue());
        paramJSONObject.setReplyCount(((JSONUtil) localObject).optInteger("reply_number", Integer.valueOf(0)).intValue());
        paramJSONObject.setIconUrl(((JSONUtil) localObject).optString("icon_url", ""));
        paramJSONObject.setForumId(((JSONUtil) localObject).optString("forum_id", ""));
        paramJSONObject.setForumName(((JSONUtil) localObject).optString("forum_name", ""));
        paramJSONObject.setTapatalkForumId(((JSONUtil) localObject).optString("fid", ""));
        paramJSONObject.setTapatalkForumName(((JSONUtil) localObject).optString("fname", ""));
        paramJSONObject.setForumUrl(((JSONUtil) localObject).optString("furl", ""));
        paramJSONObject.setTimeStamp(((JSONUtil) localObject).optInteger("timestamp", null).intValue());
        paramJSONObject.setLastReplyTime(getLastReplyTime(((JSONUtil) localObject).optString("last_reply_time", "")), this.mActivity);
        paramJSONObject.setTopicImgUrl(((JSONUtil) localObject).optString("topic_image"));
        localObject = localArrayList.iterator();
        for (; ; ) {
            if (!((Iterator) localObject).hasNext()) {
                i += 1;
                break;
            }
            TapatalkForumForSearch localTapatalkForumForSearch = (TapatalkForumForSearch) ((Iterator) localObject).next();
            if (localTapatalkForumForSearch.getId().equals(Integer.valueOf(Integer.parseInt(paramJSONObject.getTapatalkForumId())))) {
                localTapatalkForumForSearch.addTopic(paramJSONObject, Boolean.valueOf(true));
            }
        }
    }

    public void icsSearchTopic(String paramString, int paramInt1, int paramInt2, boolean paramBoolean, IcsSearchTopicActionBack paramIcsSearchTopicActionBack) {
        if ((paramString == null) || (paramString.length() == 0) || (paramIcsSearchTopicActionBack == null)) {
            return;
        }
        this.mCallBack = paramIcsSearchTopicActionBack;
        this.mTopicCount = Integer.valueOf(0);
        paramString = DirectoryUrlUtil.getIcsSearchTopicUrl(this.mActivity, paramString, paramInt1, paramInt2, paramBoolean);
        FakeX509TrustManager.allowAllSSL();
        paramString = new JsonObjectRequest(paramString, null, new Response.Listener() new Response.ErrorListener
        {
            public void onResponse (JSONObject paramAnonymousJSONObject)
            {
                if (paramAnonymousJSONObject == null) {
                    IcsSearchTopicAction.this.mCallBack.searchTopicActionBack(null, Integer.valueOf(0));
                    return;
                }
                new ArrayList();
                paramAnonymousJSONObject = IcsSearchTopicAction.this.getSearchTopicResult(paramAnonymousJSONObject);
                IcsSearchTopicAction.this.mCallBack.searchTopicActionBack(paramAnonymousJSONObject, IcsSearchTopicAction.this.mTopicCount);
            }
        },new Response.ErrorListener() {
            public void onErrorResponse(VolleyError paramAnonymousVolleyError) {
                IcsSearchTopicAction.this.mCallBack.searchTopicActionBack(null, Integer.valueOf(0));
            }
        });
        paramString.setRetryPolicy(new DefaultRetryPolicy(10000, 1, 1.0F));
        this.mQueue.add(paramString);
    }

    public static abstract interface IcsSearchTopicActionBack {
        public abstract void searchTopicActionBack(ArrayList<TapatalkForumForSearch> paramArrayList, Integer paramInteger);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/ics/action/IcsSearchTopicAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */