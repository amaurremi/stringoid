package com.uservoice.uservoicesdk.model;

import com.uservoice.uservoicesdk.Config;
import com.uservoice.uservoicesdk.rest.Callback;
import com.uservoice.uservoicesdk.rest.RestTask;
import com.uservoice.uservoicesdk.rest.RestTaskCallback;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

public class Article
        extends BaseModel {
    private String html;
    private String title;
    private String topicName;
    private int weight;

    public static void loadAll(final Callback<List<Article>> paramCallback) {
        HashMap localHashMap = new HashMap();
        localHashMap.put("sort", "ordered");
        doGet(apiPath("/articles.json", new Object[0]), localHashMap, new RestTaskCallback(paramCallback) {
            public void onComplete(JSONObject paramAnonymousJSONObject)
                    throws JSONException {
                paramCallback.onModel(BaseModel.deserializeList(paramAnonymousJSONObject, "articles", Article.class));
            }
        });
    }

    public static void loadForTopic(int paramInt, final Callback<List<Article>> paramCallback) {
        HashMap localHashMap = new HashMap();
        localHashMap.put("sort", "ordered");
        doGet(apiPath("/topics/%d/articles.json", new Object[]{Integer.valueOf(paramInt)}), localHashMap, new RestTaskCallback(paramCallback) {
            public void onComplete(JSONObject paramAnonymousJSONObject)
                    throws JSONException {
                paramCallback.onModel(BaseModel.deserializeList(paramAnonymousJSONObject, "articles", Article.class));
            }
        });
    }

    public static RestTask loadInstantAnswers(String paramString, final Callback<List<BaseModel>> paramCallback) {
        HashMap localHashMap = new HashMap();
        localHashMap.put("per_page", "3");
        localHashMap.put("forum_id", String.valueOf(getConfig().getForumId()));
        localHashMap.put("query", paramString);
        if (getConfig().getTopicId() != -1) {
            localHashMap.put("topic_id", String.valueOf(getConfig().getTopicId()));
        }
        doGet(apiPath("/instant_answers/search.json", new Object[0]), localHashMap, new RestTaskCallback(paramCallback) {
            public void onComplete(JSONObject paramAnonymousJSONObject)
                    throws JSONException {
                paramCallback.onModel(BaseModel.deserializeHeterogenousList(paramAnonymousJSONObject, "instant_answers"));
            }
        });
    }

    public String getHtml() {
        return this.html;
    }

    public String getTitle() {
        return this.title;
    }

    public String getTopicName() {
        return this.topicName;
    }

    public int getWeight() {
        return this.weight;
    }

    public void load(JSONObject paramJSONObject)
            throws JSONException {
        super.load(paramJSONObject);
        this.title = getString(paramJSONObject, "question");
        this.html = getHtml(paramJSONObject, "answer_html");
        if (paramJSONObject.has("normalized_weight")) {
            this.weight = paramJSONObject.getInt("normalized_weight");
        }
        if (!paramJSONObject.isNull("topic")) {
            this.topicName = paramJSONObject.getJSONObject("topic").getString("name");
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/uservoice/uservoicesdk/model/Article.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */