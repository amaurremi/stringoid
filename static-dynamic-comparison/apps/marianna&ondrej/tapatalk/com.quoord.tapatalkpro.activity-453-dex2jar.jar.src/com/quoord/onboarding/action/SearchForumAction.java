package com.quoord.onboarding.action;

import android.app.Activity;
import com.androidquery.AQuery;
import com.androidquery.callback.AjaxCallback;
import com.androidquery.callback.AjaxStatus;
import com.quoord.tapatalkpro.bean.TapatalkForum;
import com.quoord.tapatalkpro.bean.TapatalkForumForSearch;
import com.quoord.tapatalkpro.bean.Topic;
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

public class SearchForumAction {
    private Activity activity;
    private AQuery aq = null;
    private boolean isTrendingTopic = false;
    private SearchForumActionBack searchAction;

    public SearchForumAction(Activity paramActivity, boolean paramBoolean) {
        this.activity = paramActivity;
        this.aq = new AQuery(this.activity);
        this.isTrendingTopic = paramBoolean;
    }

    public void directorySearchForums(String paramString, int paramInt, SearchForumActionBack paramSearchForumActionBack, boolean paramBoolean) {
        paramString = DirectoryUrlUtil.createSearchForumsURL(this.activity, paramString, paramInt);
        this.searchAction = paramSearchForumActionBack;
        try {
            paramSearchForumActionBack = new MySSLSocketFactory(KeyStore.getInstance(KeyStore.getDefaultType()));
            paramSearchForumActionBack.setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
            AjaxCallback local2 = new AjaxCallback() {
                public void callback(String paramAnonymousString, JSONArray paramAnonymousJSONArray, AjaxStatus paramAnonymousAjaxStatus) {
                    super.callback(paramAnonymousString, paramAnonymousJSONArray, paramAnonymousAjaxStatus);
                    paramAnonymousString = new ArrayList();
                    int j;
                    int i;
                    if (paramAnonymousJSONArray != null) {
                        j = paramAnonymousJSONArray.length();
                        if (j > 0) {
                            i = 0;
                        }
                    }
                    for (; ; ) {
                        if (i >= j) {
                            SearchForumAction.this.searchAction.SearchActionBack(paramAnonymousString);
                            return;
                        }
                        try {
                            paramAnonymousString.add(TapatalkForum.getForum(paramAnonymousJSONArray.getJSONObject(i), null, null, null));
                            i += 1;
                        } catch (JSONException paramAnonymousAjaxStatus) {
                            for (; ; ) {
                                paramAnonymousAjaxStatus.printStackTrace();
                            }
                        }
                    }
                }
            };
            AjaxCallback.setSSF(paramSearchForumActionBack);
            AjaxCallback.setTimeout(10000);
            this.aq.ajax(paramString, JSONArray.class, local2);
            return;
        } catch (Exception paramString) {
        }
    }

    public ArrayList<Object> getV2SearchResult(JSONObject paramJSONObject, boolean paramBoolean1, boolean paramBoolean2) {
        ArrayList localArrayList = new ArrayList();
        if (paramJSONObject != null) {
            int i;
            int j;
            label568:
            label573:
            do {
                for (; ; ) {
                    try {
                        Object localObject;
                        SimpleDateFormat localSimpleDateFormat;
                        if (paramJSONObject.has("tapatalk_forums")) {
                            localObject = paramJSONObject.getJSONArray("tapatalk_forums");
                            i = 0;
                            if (i < ((JSONArray) localObject).length()) {
                            }
                        } else {
                            if ((paramBoolean2) || (!paramJSONObject.has("topics"))) {
                                break label585;
                            }
                            paramJSONObject = paramJSONObject.getJSONArray("topics");
                            j = paramJSONObject.length();
                            localObject = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                            localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
                            i = 0;
                            break;
                        }
                        localArrayList.add(TapatalkForumForSearch.getForum((JSONObject) ((JSONArray) localObject).get(i), null, null, null));
                        i += 1;
                        continue;
                        JSONObject localJSONObject = paramJSONObject.getJSONObject(i);
                        Topic localTopic = new Topic();
                        if (localJSONObject.has("last_reply_time")) {
                            if (localJSONObject.optString("last_reply_time", "").contains("T")) {
                                localTopic.setLastReplyTime((Date) localSimpleDateFormat.parseObject(localJSONObject.optString("last_reply_time", "")), this.activity);
                            }
                        } else {
                            localTopic.setReplyCount(localJSONObject.optInt("reply_number", 0));
                            if (localJSONObject.optInt("is_closed", 0) <= 0) {
                                break label568;
                            }
                            paramBoolean1 = true;
                            localTopic.setClosed(paramBoolean1);
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
                                    break label573;
                                }
                                paramBoolean1 = true;
                                localTopic.setApproved(paramBoolean1);
                            }
                            localTopic.setId(localJSONObject.optString("topic_id", ""));
                            localTopic.setTapatalkForumName(localJSONObject.optString("fname", ""));
                            localTopic.setTapatalkForumId(localJSONObject.optString("fid", ""));
                            localTopic.setTopicImgUrl(localJSONObject.optString("topic_image", ""));
                            localTopic.setViewCount(0);
                            localTopic.setNewPost(true);
                            if (this.isTrendingTopic) {
                                if ((Util.checkString(localTopic.getTapatalkForumName())) && (!"null".equals(localTopic.getTapatalkForumName()))) {
                                    localTopic.setAuthorName(localTopic.getTapatalkForumName());
                                }
                                if (localJSONObject.has("flogo")) {
                                    localTopic.setIconUrl(localJSONObject.optString("flogo", ""));
                                }
                            }
                            localArrayList.add(localTopic);
                            i += 1;
                            break;
                        }
                        localTopic.setLastReplyTime(((SimpleDateFormat) localObject).parse(localJSONObject.optString("last_reply_time", "")), this.activity);
                        continue;
                        paramBoolean1 = false;
                    } catch (Exception paramJSONObject) {
                        return localArrayList;
                    }
                    continue;
                    paramBoolean1 = false;
                }
            } while (i < j);
        }
        label585:
        return localArrayList;
    }

    public void v2SearchForums(String paramString, int paramInt, SearchForumActionBack paramSearchForumActionBack, final boolean paramBoolean1, final boolean paramBoolean2) {
        paramString = DirectoryUrlUtil.createSuggestSearchForumsURL(this.activity, paramString, paramInt, paramBoolean1);
        this.searchAction = paramSearchForumActionBack;
        try {
            paramSearchForumActionBack = new MySSLSocketFactory(KeyStore.getInstance(KeyStore.getDefaultType()));
            paramSearchForumActionBack.setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
            AjaxCallback local1 = new AjaxCallback() {
                public void callback(String paramAnonymousString, JSONObject paramAnonymousJSONObject, AjaxStatus paramAnonymousAjaxStatus) {
                    super.callback(paramAnonymousString, paramAnonymousJSONObject, paramAnonymousAjaxStatus);
                    paramAnonymousString = new ArrayList();
                    if (paramAnonymousJSONObject != null) {
                        paramAnonymousString = SearchForumAction.this.getV2SearchResult(paramAnonymousJSONObject, paramBoolean1, paramBoolean2);
                    }
                    SearchForumAction.this.searchAction.SearchActionBack(paramAnonymousString);
                }
            };
            AjaxCallback.setSSF(paramSearchForumActionBack);
            AjaxCallback.setTimeout(10000);
            this.aq.ajax(paramString, JSONObject.class, local1);
            return;
        } catch (Exception paramString) {
        }
    }

    public static abstract interface SearchForumActionBack {
        public abstract void SearchActionBack(ArrayList<Object> paramArrayList);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/onboarding/action/SearchForumAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */