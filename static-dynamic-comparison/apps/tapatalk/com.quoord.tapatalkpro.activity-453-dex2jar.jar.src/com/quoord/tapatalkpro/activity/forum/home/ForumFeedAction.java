package com.quoord.tapatalkpro.activity.forum.home;

import android.content.Context;
import com.androidquery.AQuery;
import com.androidquery.callback.AjaxCallback;
import com.androidquery.callback.AjaxStatus;
import com.quoord.tapatalkpro.bean.Forum;
import com.quoord.tapatalkpro.bean.RecommondImage;
import com.quoord.tapatalkpro.bean.RecommondPerson;
import com.quoord.tapatalkpro.bean.Topic;
import com.quoord.tapatalkpro.util.MySSLSocketFactory;

import java.security.KeyStore;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import org.apache.http.conn.ssl.SSLSocketFactory;
import org.json.JSONArray;
import org.json.JSONObject;

public class ForumFeedAction {
    private AQuery aq = null;
    private Context mActivity;

    public ForumFeedAction(Context paramContext) {
        this.mActivity = paramContext;
        this.aq = new AQuery(this.mActivity);
    }

    public HashMap<String, ArrayList> getFeedDatas(Context paramContext, JSONObject paramJSONObject, int paramInt)
            throws Exception {
        HashMap localHashMap = new HashMap();
        if ((paramJSONObject != null) && (paramJSONObject.length() > 0)) {
            ArrayList localArrayList;
            Object localObject1;
            int i;
            if (paramJSONObject.has("forums")) {
                localArrayList = new ArrayList();
                localObject1 = paramJSONObject.optJSONArray("forums");
                i = ((JSONArray) localObject1).length();
                paramInt = 0;
                if (paramInt < i) {
                    break label271;
                }
                if (localArrayList.size() > 0) {
                    localHashMap.put("forums", localArrayList);
                }
            }
            if (paramJSONObject.has("images")) {
                localArrayList = new ArrayList();
                localObject1 = paramJSONObject.getJSONArray("images");
                paramInt = 0;
                label107:
                if (paramInt < ((JSONArray) localObject1).length()) {
                    break label345;
                }
                if (localArrayList.size() > 0) {
                    localHashMap.put("images", localArrayList);
                }
            }
            if (paramJSONObject.has("users")) {
                localArrayList = new ArrayList();
                localObject1 = paramJSONObject.getJSONArray("users");
                paramInt = 0;
            }
            Object localObject2;
            for (; ; ) {
                if (paramInt >= ((JSONArray) localObject1).length()) {
                    if (localArrayList.size() > 0) {
                        localHashMap.put("users", localArrayList);
                    }
                    if (paramJSONObject.has("topics")) {
                        localArrayList = new ArrayList();
                        paramJSONObject = paramJSONObject.optJSONArray("topics");
                        i = paramJSONObject.length();
                        localObject1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                        localObject2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
                        paramInt = 0;
                        if (paramInt < i) {
                            break label493;
                        }
                        if (localArrayList.size() > 0) {
                            localHashMap.put("topics", localArrayList);
                        }
                    }
                    return localHashMap;
                    label271:
                    localObject2 = new Forum();
                    localJSONObject = ((JSONArray) localObject1).getJSONObject(paramInt);
                    ((Forum) localObject2).setId(localJSONObject.optString("id", ""));
                    ((Forum) localObject2).setName(localJSONObject.optString("forum_name", ""));
                    ((Forum) localObject2).setForum_image(localJSONObject.optString("forum_image", ""));
                    localArrayList.add(localObject2);
                    paramInt += 1;
                    break;
                    label345:
                    localObject2 = new RecommondImage();
                    localJSONObject = ((JSONArray) localObject1).getJSONObject(paramInt);
                    ((RecommondImage) localObject2).imageUrl = localJSONObject.getString("url");
                    ((RecommondImage) localObject2).title = localJSONObject.getString("title");
                    ((RecommondImage) localObject2).topicId = localJSONObject.getString("topic_id");
                    localArrayList.add(localObject2);
                    paramInt += 1;
                    break label107;
                }
                localObject2 = new RecommondPerson();
                localJSONObject = ((JSONArray) localObject1).getJSONObject(paramInt);
                ((RecommondPerson) localObject2).imageUrl = localJSONObject.getString("icon_url");
                ((RecommondPerson) localObject2).uid = localJSONObject.getString("uid");
                ((RecommondPerson) localObject2).username = localJSONObject.getString("uname");
                ((RecommondPerson) localObject2).description = localJSONObject.getString("title");
                localArrayList.add(localObject2);
                paramInt += 1;
            }
            label493:
            JSONObject localJSONObject = paramJSONObject.getJSONObject(paramInt);
            Topic localTopic = new Topic();
            if (localJSONObject.has("last_reply_time")) {
                if (localJSONObject.optString("last_reply_time", "").contains("T")) {
                    localTopic.setLastReplyTime((Date) ((SimpleDateFormat) localObject2).parseObject(localJSONObject.optString("last_reply_time", "")), paramContext);
                }
            } else {
                label559:
                localTopic.setReplyCount(localJSONObject.optInt("reply_number", 0));
                if (localJSONObject.optInt("is_closed", 0) <= 0) {
                    break label856;
                }
                bool = true;
                label586:
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
                if (localJSONObject.has("is_approved")) {
                    if (localJSONObject.optInt("is_approved", 0) <= 0) {
                        break label862;
                    }
                }
            }
            label856:
            label862:
            for (boolean bool = true; ; bool = false) {
                localTopic.setApproved(bool);
                localTopic.setId(localJSONObject.optString("topic_id", ""));
                localTopic.setTapatalkForumName(localJSONObject.optString("fname", ""));
                localTopic.setTapatalkForumId(localJSONObject.optString("fid", ""));
                localTopic.setTopicImgUrl(localJSONObject.optString("topic_image", ""));
                localTopic.setViewCount(0);
                localTopic.setNewPost(true);
                localArrayList.add(localTopic);
                paramInt += 1;
                break;
                localTopic.setLastReplyTime(((SimpleDateFormat) localObject1).parse(localJSONObject.optString("last_reply_time", "")), paramContext);
                break label559;
                bool = false;
                break label586;
            }
        }
        return null;
    }

    public void getFeeds(String paramString, final int paramInt, final FeedActionCallBack paramFeedActionCallBack) {
        try {
            MySSLSocketFactory localMySSLSocketFactory = new MySSLSocketFactory(KeyStore.getInstance(KeyStore.getDefaultType()));
            localMySSLSocketFactory.setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
            paramFeedActionCallBack = new AjaxCallback() {
                public void callback(String paramAnonymousString, JSONObject paramAnonymousJSONObject, AjaxStatus paramAnonymousAjaxStatus) {
                    super.callback(paramAnonymousString, paramAnonymousJSONObject, paramAnonymousAjaxStatus);
                    try {
                        paramFeedActionCallBack.actionCallBack(ForumFeedAction.this.getFeedDatas(ForumFeedAction.this.mActivity, paramAnonymousJSONObject, paramInt));
                        return;
                    } catch (Exception paramAnonymousString) {
                        paramAnonymousString.printStackTrace();
                    }
                }
            };
            AjaxCallback.setSSF(localMySSLSocketFactory);
            AjaxCallback.setTimeout(20000);
            this.aq.ajax(paramString + "&page=" + paramInt, JSONObject.class, paramFeedActionCallBack);
            return;
        } catch (Exception paramString) {
        }
    }

    public static abstract interface FeedActionCallBack {
        public abstract void actionCallBack(HashMap<String, ArrayList> paramHashMap);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/activity/forum/home/ForumFeedAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */