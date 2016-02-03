package com.quoord.tapatalkpro.bean;

import com.quoord.tools.net.JSONUtil;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;

import org.json.JSONObject;

public class TapatalkForumForSearch
        extends TapatalkForum {
    private static final long serialVersionUID = -2810326151369199393L;
    private ArrayList<Topic> mTopics = null;
    private JSONObject mTrendingDiscussionJson = null;

    public static TapatalkForumForSearch getForum(JSONObject paramJSONObject, String paramString1, String paramString2, String paramString3) {
        localTapatalkForumForSearch = new TapatalkForumForSearch();
        if (paramString1 != null) {
        }
        try {
            localTapatalkForumForSearch.setUserName(paramString1);
            if (paramString2 != null) {
                localTapatalkForumForSearch.setmUseEmail(paramString2);
            }
            if ((paramString3 != null) && (!paramString3.equals("0"))) {
                localTapatalkForumForSearch.setUserId(paramString3);
            }
            paramString1 = new JSONUtil(paramJSONObject);
            localTapatalkForumForSearch.setIab_catid(paramString1.optInteger("iab_catid", null));
            localTapatalkForumForSearch.setId(paramString1.optInteger("id", null));
            localTapatalkForumForSearch.setHasImage(paramString1.optBoolean("topic_image", Boolean.valueOf(false)).booleanValue());
            if (paramJSONObject.has("forum_name")) {
                localTapatalkForumForSearch.setName(paramString1.optString("forum_name"));
            }
            for (; ; ) {
                localTapatalkForumForSearch.setDescription(paramString1.optString("description"));
                localTapatalkForumForSearch.setCategoryName(paramString1.optString("category"));
                if (paramJSONObject.has("created")) {
                    localTapatalkForumForSearch.setCreationDate((Date) paramString1.opt("created"));
                }
                localTapatalkForumForSearch.setFolder(paramString1.optString("mobiquo_dir"));
                localTapatalkForumForSearch.setExt(paramString1.optString("ext"));
                localTapatalkForumForSearch.setUrl(paramString1.optString("url"));
                localTapatalkForumForSearch.setSignatureType(paramString1.optInteger("tapatalk_signature").intValue());
                localTapatalkForumForSearch.setViglinkSupport(paramString1.optBoolean("viglink_support", Boolean.valueOf(false)).booleanValue());
                localTapatalkForumForSearch.setSupportTkUpload(paramString1.optBoolean("hosted_image_support", Boolean.valueOf(false)).booleanValue());
                localTapatalkForumForSearch.setMedia_sharing(paramString1.optBoolean("media_sharing", Boolean.valueOf(false)).booleanValue());
                paramString2 = paramString1.optString("logo", "");
                if (!paramString2.equals("")) {
                    localTapatalkForumForSearch.setIconUrl(paramString2.replace("90x90", "HD"));
                }
                localTapatalkForumForSearch.setSupportedPR(paramString1.optInteger("pr").intValue());
                localTapatalkForumForSearch.setIsPT(paramString1.optInteger("pt").intValue());
                localTapatalkForumForSearch.setDfp(paramString1.optInteger("dfp").intValue());
                localTapatalkForumForSearch.setNetworkCode(paramString1.optString("dfp_network_code"));
                localTapatalkForumForSearch.setPropertyCode(paramString1.optString("dfp_property_code"));
                localTapatalkForumForSearch.setSlotName(paramString1.optString("android_dfp_320x50"));
                localTapatalkForumForSearch.setSlotNameWeb(paramString1.optString("android_dfp_300x250"));
                localTapatalkForumForSearch.setForumUrl(paramString1.optString("android_product_url"));
                localTapatalkForumForSearch.setCms_url(paramString1.optString("cms_url"));
                localTapatalkForumForSearch.setGa(paramString1.optString("ga"));
                localTapatalkForumForSearch.setType(paramString1.optString("type"));
                localTapatalkForumForSearch.setVersion(paramString1.optString("type"));
                localTapatalkForumForSearch.setFeed(paramString1.optBoolean("feed").booleanValue());
                localTapatalkForumForSearch.setTotalThreads(paramString1.optInteger("total_threads", null));
                localTapatalkForumForSearch.setTapatalkUserCount(paramString1.optInteger("tapatalk_user_count", null));
                if (!paramJSONObject.has("topic")) {
                    break;
                }
                localTapatalkForumForSearch.setTrendingDiscussionJson((JSONObject) paramJSONObject.get("topic"));
                return localTapatalkForumForSearch;
                localTapatalkForumForSearch.setName(paramString1.optString("name"));
            }
            return localTapatalkForumForSearch;
        } catch (Exception paramJSONObject) {
            paramJSONObject.printStackTrace();
        }
    }

    private void readObject(ObjectInputStream paramObjectInputStream)
            throws IOException, ClassNotFoundException {
    }

    private void writeObject(ObjectOutputStream paramObjectOutputStream)
            throws IOException {
    }

    public void addTopic(Topic paramTopic) {
        if (this.mTopics == null) {
            this.mTopics = new ArrayList();
        }
        this.mTopics.add(paramTopic);
    }

    public void addTopic(Topic paramTopic, Boolean paramBoolean) {
        if (!paramBoolean.booleanValue()) {
            addTopic(paramTopic);
            return;
        }
        if (this.mTopics == null) {
            this.mTopics = new ArrayList();
        }
        int j = paramTopic.getSearchScore().intValue();
        int i = 0;
        for (; ; ) {
            if (i >= this.mTopics.size()) {
            }
            while (j > ((Topic) this.mTopics.get(i)).getSearchScore().intValue()) {
                this.mTopics.add(i, paramTopic);
                return;
            }
            i += 1;
        }
    }

    public ArrayList<Topic> getTopics() {
        return this.mTopics;
    }

    public JSONObject getTrendingDiscussionJson() {
        return this.mTrendingDiscussionJson;
    }

    public void setTopics(ArrayList<Topic> paramArrayList) {
        this.mTopics = paramArrayList;
    }

    public void setTrendingDiscussionJson(JSONObject paramJSONObject) {
        this.mTrendingDiscussionJson = paramJSONObject;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/bean/TapatalkForumForSearch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */