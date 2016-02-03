package com.quoord.tapatalkpro.action;

import android.app.Activity;
import android.content.Context;
import com.androidquery.AQuery;
import com.androidquery.callback.AjaxCallback;
import com.androidquery.callback.AjaxStatus;
import com.quoord.tapatalkpro.TapatalkApp;
import com.quoord.tapatalkpro.bean.Feed;
import com.quoord.tapatalkpro.bean.Forum;
import com.quoord.tapatalkpro.bean.RecommondImage;
import com.quoord.tapatalkpro.bean.TapatalkForum;
import com.quoord.tapatalkpro.bean.TapatalkForumForSearch;
import com.quoord.tapatalkpro.bean.Topic;
import com.quoord.tapatalkpro.sqlhelper.FavoriateSqlHelper;
import com.quoord.tapatalkpro.util.MySSLSocketFactory;
import com.quoord.tapatalkpro.util.Util;
import com.quoord.tools.directoryurl.DirectoryUrlUtil;

import java.security.KeyStore;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.apache.http.conn.ssl.SSLSocketFactory;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FeedAction {
    private AQuery aq = null;
    private FavoriateSqlHelper helper;
    private boolean isForum;
    private boolean isLoadingMore;
    private Context mActivity;

    public FeedAction(Context paramContext, boolean paramBoolean) {
        this.mActivity = paramContext;
        this.isForum = paramBoolean;
        this.aq = new AQuery(this.mActivity);
        this.helper = new FavoriateSqlHelper(paramContext, TapatalkApp.database_name, null, Integer.parseInt(TapatalkApp.database_version));
    }

    private ArrayList<TapatalkForumForSearch> getSearchForumResult(JSONObject paramJSONObject) {
        if (paramJSONObject == null) {
            paramJSONObject = null;
            return paramJSONObject;
        }
        if ((!paramJSONObject.has("forums")) && (!paramJSONObject.has("tapatalk_forums"))) {
            return null;
        }
        Object localObject2 = paramJSONObject.optJSONArray("tapatalk_forums");
        Object localObject1 = localObject2;
        if (localObject2 == null) {
            paramJSONObject = paramJSONObject.optJSONArray("forums");
            localObject1 = paramJSONObject;
            if (paramJSONObject == null) {
                return null;
            }
        }
        localObject2 = new ArrayList();
        int i = 0;
        for (; ; ) {
            paramJSONObject = (JSONObject) localObject2;
            if (i >= ((JSONArray) localObject1).length()) {
                break;
            }
            ((ArrayList) localObject2).add(TapatalkForumForSearch.getForum(((JSONArray) localObject1).optJSONObject(i), null, null, null));
            i += 1;
        }
    }

    public ArrayList<Object> getFeedDatas(Context paramContext, JSONObject paramJSONObject, int paramInt)
            throws Exception {
        ArrayList localArrayList = new ArrayList();
        if ((paramJSONObject != null) && (paramJSONObject.length() > 0)) {
            Object localObject1;
            int j;
            int i;
            if (paramJSONObject.has("tapatalk_forums")) {
                localObject1 = paramJSONObject.optJSONArray("tapatalk_forums");
                j = ((JSONArray) localObject1).length();
                i = 0;
                if (i < j) {
                }
            } else {
                if (paramJSONObject.has("forums")) {
                    localObject1 = paramJSONObject.optJSONArray("forums");
                    j = ((JSONArray) localObject1).length();
                    i = 0;
                    label81:
                    if (i < j) {
                        break label209;
                    }
                }
                if (paramJSONObject.has("images")) {
                    localObject1 = paramJSONObject.getJSONArray("images");
                    paramInt = 0;
                }
            }
            Object localObject2;
            for (; ; ) {
                if (paramInt >= ((JSONArray) localObject1).length()) {
                    if (paramJSONObject.has("topics")) {
                        paramJSONObject = paramJSONObject.optJSONArray("topics");
                        i = paramJSONObject.length();
                        localObject1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                        localObject2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
                        paramInt = 0;
                        if (paramInt < i) {
                            break label354;
                        }
                        if (i <= 0) {
                            break label812;
                        }
                        this.isLoadingMore = false;
                    }
                    return localArrayList;
                    localArrayList.add(TapatalkForum.getForum(((JSONArray) localObject1).getJSONObject(i), null, null, null));
                    i += 1;
                    break;
                    label209:
                    localObject2 = new Forum();
                    localJSONObject = ((JSONArray) localObject1).getJSONObject(i);
                    ((Forum) localObject2).setId(localJSONObject.optString("id", ""));
                    ((Forum) localObject2).setName(localJSONObject.optString("forum_name", ""));
                    ((Forum) localObject2).setForum_image(localJSONObject.optString("forum_image", ""));
                    if ((!this.isForum) || (paramInt <= 1)) {
                        localArrayList.add(localObject2);
                    }
                    i += 1;
                    break label81;
                }
                localObject2 = new RecommondImage();
                localJSONObject = ((JSONArray) localObject1).getJSONObject(paramInt);
                ((RecommondImage) localObject2).imageUrl = localJSONObject.getString("url");
                ((RecommondImage) localObject2).title = localJSONObject.getString("title");
                localArrayList.add(localObject2);
                paramInt += 1;
            }
            label354:
            JSONObject localJSONObject = paramJSONObject.getJSONObject(paramInt);
            Topic localTopic = new Topic();
            label420:
            boolean bool;
            if (localJSONObject.has("last_reply_time")) {
                if (localJSONObject.optString("last_reply_time", "").contains("T")) {
                    localTopic.setLastReplyTime((Date) ((SimpleDateFormat) localObject2).parseObject(localJSONObject.optString("last_reply_time", "")), paramContext);
                }
            } else {
                localTopic.setReplyCount(localJSONObject.optInt("reply_number", 0));
                if (localJSONObject.optInt("is_closed", 0) <= 0) {
                    break label791;
                }
                bool = true;
                label447:
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
                        break label797;
                    }
                    bool = true;
                    label609:
                    localTopic.setApproved(bool);
                }
                localTopic.setTimeStamp(localJSONObject.optInt("timestamp"));
                localTopic.setId(localJSONObject.optString("topic_id", ""));
                localTopic.setTapatalkForumName(localJSONObject.optString("fname", ""));
                localTopic.setTapatalkForumId(localJSONObject.optString("fid", ""));
                localTopic.setTopicImgUrl(localJSONObject.optString("topic_image", ""));
                localTopic.setViewCount(0);
                localTopic.setNewPost(true);
                localTopic.setThumbCount(localJSONObject.optInt("thumb_count", 0));
                localTopic.setThumbType(localJSONObject.optInt("thumb_type", 0));
                if (localTopic.getThumbType() != 2) {
                    localArrayList.add(localTopic);
                    if (localTopic.getThumbType() != 1) {
                        break label803;
                    }
                    localTopic.setThumbUp(true);
                }
            }
            for (; ; ) {
                paramInt += 1;
                break;
                localTopic.setLastReplyTime(((SimpleDateFormat) localObject1).parse(localJSONObject.optString("last_reply_time", "")), paramContext);
                break label420;
                label791:
                bool = false;
                break label447;
                label797:
                bool = false;
                break label609;
                label803:
                localTopic.setThumbUp(false);
            }
            label812:
            this.isLoadingMore = true;
            return localArrayList;
        }
        return null;
    }

    public void getFeedNotification(final Activity paramActivity, String paramString, final FeedActionCallBack paramFeedActionCallBack) {
        this.aq.ajax(paramString, JSONObject.class, new AjaxCallback() {
            public void callback(String paramAnonymousString, JSONObject paramAnonymousJSONObject, AjaxStatus paramAnonymousAjaxStatus) {
                super.callback(paramAnonymousString, paramAnonymousJSONObject, paramAnonymousAjaxStatus);
                paramAnonymousString = new ArrayList();
                int j;
                int i;
                if ((paramAnonymousJSONObject != null) && (paramAnonymousJSONObject.has("feed"))) {
                    paramAnonymousJSONObject = paramAnonymousJSONObject.optJSONArray("feed");
                    j = paramAnonymousJSONObject.length();
                    i = 0;
                }
                for (; ; ) {
                    if (i >= j) {
                        paramFeedActionCallBack.actionCallBack(paramAnonymousString, FeedAction.this.isLoadingMore);
                        return;
                    }
                    try {
                        paramAnonymousString.add(Feed.createFeeds(paramAnonymousJSONObject.getJSONObject(i), paramActivity, FeedAction.this.helper));
                        i += 1;
                    } catch (JSONException paramAnonymousAjaxStatus) {
                        for (; ; ) {
                            paramAnonymousAjaxStatus.printStackTrace();
                        }
                    }
                }
            }
        });
    }

    public void getFeeds(String paramString, final int paramInt, final FeedActionCallBack paramFeedActionCallBack) {
        try {
            MySSLSocketFactory localMySSLSocketFactory = new MySSLSocketFactory(KeyStore.getInstance(KeyStore.getDefaultType()));
            localMySSLSocketFactory.setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
            paramFeedActionCallBack = new AjaxCallback() {
                public void callback(String paramAnonymousString, JSONObject paramAnonymousJSONObject, AjaxStatus paramAnonymousAjaxStatus) {
                    super.callback(paramAnonymousString, paramAnonymousJSONObject, paramAnonymousAjaxStatus);
                    if (paramAnonymousJSONObject != null) {
                    }
                    try {
                        paramFeedActionCallBack.actionCallBack(FeedAction.this.getFeedDatas(FeedAction.this.mActivity, paramAnonymousJSONObject, paramInt), FeedAction.this.isLoadingMore);
                        return;
                    } catch (Exception paramAnonymousString) {
                        paramAnonymousString.printStackTrace();
                    }
                }
            };
            AjaxCallback.setSSF(localMySSLSocketFactory);
            AjaxCallback.setTimeout(10000);
            this.aq.ajax(paramString + "&page=" + paramInt, JSONObject.class, paramFeedActionCallBack);
            return;
        } catch (Exception paramString) {
        }
    }

    public ArrayList<Object> getForumFeedDatas(JSONArray paramJSONArray)
            throws JSONException {
        ArrayList localArrayList = new ArrayList();
        int j;
        int i;
        if (paramJSONArray != null) {
            j = paramJSONArray.length();
            if (j > 0) {
                i = 0;
            }
        }
        for (; ; ) {
            if (i >= j) {
                return localArrayList;
            }
            localArrayList.add(TapatalkForum.getForum(paramJSONArray.getJSONObject(i), null, null, null));
            i += 1;
        }
    }

    public ArrayList<Object> getKeyWordsDatas(JSONArray paramJSONArray)
            throws JSONException {
        Object localObject;
        if (paramJSONArray == null) {
            localObject = null;
        }
        ArrayList localArrayList;
        int j;
        do {
            return (ArrayList<Object>) localObject;
            localArrayList = new ArrayList();
            j = paramJSONArray.length();
            localObject = localArrayList;
        } while (j <= 0);
        int i = 0;
        for (; ; ) {
            localObject = localArrayList;
            if (i >= j) {
                break;
            }
            localArrayList.add(paramJSONArray.getString(i));
            i += 1;
        }
    }

    public void getRecommendForumFeeds(String paramString, final FeedActionCallBack paramFeedActionCallBack) {
        this.aq.ajax(paramString, JSONArray.class, new AjaxCallback() {
            public void callback(String paramAnonymousString, JSONArray paramAnonymousJSONArray, AjaxStatus paramAnonymousAjaxStatus) {
                super.callback(paramAnonymousString, paramAnonymousJSONArray, paramAnonymousAjaxStatus);
                try {
                    paramFeedActionCallBack.actionCallBack(FeedAction.this.getForumFeedDatas(paramAnonymousJSONArray), FeedAction.this.isLoadingMore);
                    return;
                } catch (Exception paramAnonymousString) {
                    paramAnonymousString.printStackTrace();
                }
            }
        });
    }

    public ArrayList<Object> getRecommendTopicFeedDatas(JSONArray paramJSONArray)
            throws Exception {
        if (paramJSONArray == null) {
            localObject = null;
        }
        ArrayList localArrayList;
        int j;
        int i;
        do {
            do {
                return (ArrayList<Object>) localObject;
                localArrayList = new ArrayList();
                j = paramJSONArray.length();
                localObject = localArrayList;
            } while (j <= 0);
            i = 0;
            localObject = localArrayList;
        } while (i >= j);
        Object localObject = new Topic();
        JSONObject localJSONObject = paramJSONArray.getJSONObject(i);
        SimpleDateFormat localSimpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        SimpleDateFormat localSimpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        if (localJSONObject.has("last_reply_time")) {
            if (localJSONObject.optString("last_reply_time", "").contains("T")) {
                ((Topic) localObject).setLastReplyTime((Date) localSimpleDateFormat2.parseObject(localJSONObject.optString("last_reply_time", "")), this.mActivity);
            }
        } else {
            label134:
            ((Topic) localObject).setReplyCount(localJSONObject.optInt("reply_number", 0));
            if (localJSONObject.optInt("is_closed", 0) <= 0) {
                break label537;
            }
            bool = true;
            label161:
            ((Topic) localObject).setClosed(bool);
            ((Topic) localObject).setAuthorName(localJSONObject.optString("topic_author_name", ""));
            ((Topic) localObject).setAuthorId(localJSONObject.optString("topic_author_id", ""));
            ((Topic) localObject).setForumName(localJSONObject.optString("forum_name", ""));
            ((Topic) localObject).setIconUrl(localJSONObject.optString("icon_url", ""));
            ((Topic) localObject).setForumUrl(localJSONObject.optString("furl", ""));
            ((Topic) localObject).setTitle(localJSONObject.optString("topic_title", ""));
            ((Topic) localObject).setShortContent(localJSONObject.optString("short_content", ""));
            ((Topic) localObject).setForumId(localJSONObject.optString("forum_id", ""));
            ((Topic) localObject).setPrefix(localJSONObject.optString("prefix", ""));
            ((Topic) localObject).setTimeStamp(new Integer((String) localJSONObject.get("timestamp")).intValue());
            if (localJSONObject.has("is_approved")) {
                if (localJSONObject.optInt("is_approved", 0) <= 0) {
                    break label543;
                }
            }
        }
        label537:
        label543:
        for (boolean bool = true; ; bool = false) {
            ((Topic) localObject).setApproved(bool);
            ((Topic) localObject).setId(localJSONObject.optString("topic_id", ""));
            ((Topic) localObject).setTapatalkForumName(localJSONObject.optString("fname", ""));
            ((Topic) localObject).setTapatalkForumId(localJSONObject.optString("fid", ""));
            ((Topic) localObject).setTopicImgUrl(localJSONObject.optString("topic_image", ""));
            ((Topic) localObject).setViewCount(0);
            ((Topic) localObject).setNewPost(true);
            if (!this.isForum) {
                if ((Util.checkString(((Topic) localObject).getTapatalkForumName())) && (!"null".equals(((Topic) localObject).getTapatalkForumName()))) {
                    ((Topic) localObject).setAuthorName(((Topic) localObject).getTapatalkForumName());
                }
                if (localJSONObject.has("flogo")) {
                    ((Topic) localObject).setIconUrl(localJSONObject.optString("flogo", ""));
                }
            }
            localArrayList.add(localObject);
            i += 1;
            break;
            ((Topic) localObject).setLastReplyTime(localSimpleDateFormat1.parse(localJSONObject.optString("last_reply_time", "")), this.mActivity);
            break label134;
            bool = false;
            break label161;
        }
    }

    public void getRecommendTopicFeeds(String paramString, final FeedActionCallBack paramFeedActionCallBack) {
        this.aq.ajax(paramString, JSONArray.class, new AjaxCallback() {
            public void callback(String paramAnonymousString, JSONArray paramAnonymousJSONArray, AjaxStatus paramAnonymousAjaxStatus) {
                super.callback(paramAnonymousString, paramAnonymousJSONArray, paramAnonymousAjaxStatus);
                try {
                    paramFeedActionCallBack.actionCallBack(FeedAction.this.getRecommendTopicFeedDatas(paramAnonymousJSONArray), FeedAction.this.isLoadingMore);
                    return;
                } catch (Exception paramAnonymousString) {
                    paramAnonymousString.printStackTrace();
                }
            }
        });
    }

    public void getSearchKeyWords(String paramString, final FeedActionCallBack paramFeedActionCallBack) {
        this.aq.ajax(paramString, JSONArray.class, new AjaxCallback() {
            public void callback(String paramAnonymousString, JSONArray paramAnonymousJSONArray, AjaxStatus paramAnonymousAjaxStatus) {
                super.callback(paramAnonymousString, paramAnonymousJSONArray, paramAnonymousAjaxStatus);
                try {
                    paramFeedActionCallBack.actionCallBack(FeedAction.this.getKeyWordsDatas(paramAnonymousJSONArray), FeedAction.this.isLoadingMore);
                    return;
                } catch (Exception paramAnonymousString) {
                    paramAnonymousString.printStackTrace();
                }
            }
        });
    }

    public void getTapatalkForums(String paramString, final FeedActionCallBack paramFeedActionCallBack) {
        this.aq.ajax(paramString, JSONArray.class, new AjaxCallback() {
            public void callback(String paramAnonymousString, JSONArray paramAnonymousJSONArray, AjaxStatus paramAnonymousAjaxStatus) {
                super.callback(paramAnonymousString, paramAnonymousJSONArray, paramAnonymousAjaxStatus);
                try {
                    paramFeedActionCallBack.actionCallBack(FeedAction.this.getForumFeedDatas(paramAnonymousJSONArray), FeedAction.this.isLoadingMore);
                    return;
                } catch (JSONException paramAnonymousString) {
                    paramAnonymousString.printStackTrace();
                }
            }
        });
    }

    public void searchForums(Activity paramActivity, String paramString1, String paramString2, String paramString3, final FeedActionCallBack paramFeedActionCallBack) {
        paramActivity = DirectoryUrlUtil.getDirectorySearchForumsUrl(paramActivity, paramString1, paramString2, paramString3);
        try {
            paramString1 = new MySSLSocketFactory(KeyStore.getInstance(KeyStore.getDefaultType()));
            paramString1.setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
            paramString2 = new AjaxCallback() {
                public void callback(String paramAnonymousString, JSONArray paramAnonymousJSONArray, AjaxStatus paramAnonymousAjaxStatus) {
                    super.callback(paramAnonymousString, paramAnonymousJSONArray, paramAnonymousAjaxStatus);
                    try {
                        paramFeedActionCallBack.actionCallBack(FeedAction.this.getForumFeedDatas(paramAnonymousJSONArray), FeedAction.this.isLoadingMore);
                        return;
                    } catch (JSONException paramAnonymousString) {
                        paramAnonymousString.printStackTrace();
                    }
                }
            };
            AjaxCallback.setSSF(paramString1);
            AjaxCallback.setTimeout(10000);
            this.aq.ajax(paramActivity, JSONArray.class, paramString2);
            return;
        } catch (Exception paramActivity) {
        }
    }

    public void updateFeed(String paramString, final FeedActionCallBack paramFeedActionCallBack) {
        this.aq.ajax(paramString, JSONObject.class, new AjaxCallback() {
            public void callback(String paramAnonymousString, JSONObject paramAnonymousJSONObject, AjaxStatus paramAnonymousAjaxStatus) {
                super.callback(paramAnonymousString, paramAnonymousJSONObject, paramAnonymousAjaxStatus);
                try {
                    boolean bool = paramAnonymousJSONObject.getBoolean("result");
                    paramFeedActionCallBack.actionCallBack(null, bool);
                    return;
                } catch (JSONException paramAnonymousString) {
                    paramAnonymousString.printStackTrace();
                }
            }
        });
    }

    public static abstract interface FeedActionCallBack {
        public abstract void actionCallBack(ArrayList<Object> paramArrayList, boolean paramBoolean);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/action/FeedAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */