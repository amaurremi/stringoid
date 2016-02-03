package com.uservoice.uservoicesdk.model;

import com.uservoice.uservoicesdk.babayaga.Babayaga;
import com.uservoice.uservoicesdk.babayaga.Babayaga.Event;
import com.uservoice.uservoicesdk.rest.Callback;
import com.uservoice.uservoicesdk.rest.RestTask;
import com.uservoice.uservoicesdk.rest.RestTaskCallback;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

public class Suggestion
        extends BaseModel {
    private String adminResponseAvatarUrl;
    private Date adminResponseCreatedAt;
    private String adminResponseText;
    private String adminResponseUserName;
    private Category category;
    private Date createdAt;
    private String creatorName;
    private int forumId;
    private String forumName;
    private int numberOfComments;
    private int numberOfSubscribers;
    private String status;
    private String statusColor;
    private boolean subscribed;
    private String text;
    private String title;
    private int weight;

    public static void createSuggestion(Forum paramForum, Category paramCategory, String paramString1, String paramString2, int paramInt, final Callback<Suggestion> paramCallback) {
        HashMap localHashMap = new HashMap();
        localHashMap.put("subscribe", "true");
        localHashMap.put("suggestion[title]", paramString1);
        localHashMap.put("suggestion[text]", paramString2);
        if (paramCategory != null) {
            localHashMap.put("suggestion[category_id]", String.valueOf(paramCategory.getId()));
        }
        doPost(apiPath("/forums/%d/suggestions.json", new Object[]{Integer.valueOf(paramForum.getId())}), localHashMap, new RestTaskCallback(paramCallback) {
            public void onComplete(JSONObject paramAnonymousJSONObject)
                    throws JSONException {
                paramCallback.onModel(BaseModel.deserializeObject(paramAnonymousJSONObject, "suggestion", Suggestion.class));
            }
        });
    }

    public static void loadSuggestions(Forum paramForum, int paramInt, final Callback<List<Suggestion>> paramCallback) {
        HashMap localHashMap = new HashMap();
        localHashMap.put("page", String.valueOf(paramInt));
        localHashMap.put("per_page", "20");
        localHashMap.put("filter", "public");
        localHashMap.put("sort", getClientConfig().getSuggestionSort());
        doGet(apiPath("/forums/%d/suggestions.json", new Object[]{Integer.valueOf(paramForum.getId())}), localHashMap, new RestTaskCallback(paramCallback) {
            public void onComplete(JSONObject paramAnonymousJSONObject)
                    throws JSONException {
                paramCallback.onModel(BaseModel.deserializeList(paramAnonymousJSONObject, "suggestions", Suggestion.class));
            }
        });
    }

    public static RestTask searchSuggestions(Forum paramForum, String paramString, final Callback<List<Suggestion>> paramCallback) {
        HashMap localHashMap = new HashMap();
        localHashMap.put("query", paramString);
        doGet(apiPath("/forums/%d/suggestions/search.json", new Object[]{Integer.valueOf(paramForum.getId())}), localHashMap, new RestTaskCallback(paramCallback) {
            public void onComplete(JSONObject paramAnonymousJSONObject)
                    throws JSONException {
                paramCallback.onModel(BaseModel.deserializeList(paramAnonymousJSONObject, "suggestions", Suggestion.class));
            }
        });
    }

    public void commentPosted(Comment paramComment) {
        this.numberOfComments += 1;
    }

    public String getAdminResponseAvatarUrl() {
        return this.adminResponseAvatarUrl;
    }

    public Date getAdminResponseCreatedAt() {
        return this.adminResponseCreatedAt;
    }

    public String getAdminResponseText() {
        return this.adminResponseText;
    }

    public String getAdminResponseUserName() {
        return this.adminResponseUserName;
    }

    public Category getCategory() {
        return this.category;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public String getCreatorName() {
        return this.creatorName;
    }

    public int getForumId() {
        return this.forumId;
    }

    public String getForumName() {
        return this.forumName;
    }

    public int getNumberOfComments() {
        return this.numberOfComments;
    }

    public int getNumberOfSubscribers() {
        return this.numberOfSubscribers;
    }

    public String getStatus() {
        return this.status;
    }

    public String getStatusColor() {
        return this.statusColor;
    }

    public String getText() {
        return this.text;
    }

    public String getTitle() {
        return this.title;
    }

    public int getWeight() {
        return this.weight;
    }

    public boolean isSubscribed() {
        return this.subscribed;
    }

    public void load(JSONObject paramJSONObject)
            throws JSONException {
        super.load(paramJSONObject);
        this.title = getString(paramJSONObject, "title");
        this.text = getString(paramJSONObject, "formatted_text");
        this.createdAt = getDate(paramJSONObject, "created_at");
        this.forumId = paramJSONObject.getJSONObject("topic").getJSONObject("forum").getInt("id");
        this.forumName = paramJSONObject.getJSONObject("topic").getJSONObject("forum").getString("name");
        if ((paramJSONObject.has("subscribed")) && (paramJSONObject.getBoolean("subscribed"))) {
        }
        for (boolean bool = true; ; bool = false) {
            this.subscribed = bool;
            if (!paramJSONObject.isNull("category")) {
                this.category = ((Category) deserializeObject(paramJSONObject, "category", Category.class));
            }
            this.numberOfComments = paramJSONObject.getInt("comments_count");
            this.numberOfSubscribers = paramJSONObject.getInt("subscriber_count");
            if (!paramJSONObject.isNull("creator")) {
                this.creatorName = getString(paramJSONObject.getJSONObject("creator"), "name");
            }
            JSONObject localJSONObject;
            if (!paramJSONObject.isNull("status")) {
                localJSONObject = paramJSONObject.getJSONObject("status");
                this.status = getString(localJSONObject, "name");
                this.statusColor = getString(localJSONObject, "hex_color");
            }
            if (!paramJSONObject.isNull("response")) {
                localJSONObject = paramJSONObject.getJSONObject("response");
                this.adminResponseText = getString(localJSONObject, "formatted_text");
                this.adminResponseCreatedAt = getDate(localJSONObject, "created_at");
                localJSONObject = localJSONObject.getJSONObject("creator");
                this.adminResponseUserName = getString(localJSONObject, "name");
                this.adminResponseAvatarUrl = getString(localJSONObject, "avatar_url");
            }
            if (paramJSONObject.has("normalized_weight")) {
                this.weight = paramJSONObject.getInt("normalized_weight");
            }
            return;
        }
    }

    public void subscribe(final Callback<Suggestion> paramCallback) {
        HashMap localHashMap = new HashMap();
        localHashMap.put("subscribe", "true");
        doPost(apiPath("/forums/%d/suggestions/%d/watch.json", new Object[]{Integer.valueOf(this.forumId), Integer.valueOf(this.id)}), localHashMap, new RestTaskCallback(paramCallback) {
            public void onComplete(JSONObject paramAnonymousJSONObject)
                    throws JSONException {
                Babayaga.track(Babayaga.Event.VOTE_IDEA, Suggestion.this.getId());
                Babayaga.track(Babayaga.Event.SUBSCRIBE_IDEA, Suggestion.this.getId());
                Suggestion.this.load(paramAnonymousJSONObject.getJSONObject("suggestion"));
                paramCallback.onModel(Suggestion.this);
            }
        });
    }

    public void unsubscribe(final Callback<Suggestion> paramCallback) {
        HashMap localHashMap = new HashMap();
        localHashMap.put("subscribe", "false");
        doPost(apiPath("/forums/%d/suggestions/%d/watch.json", new Object[]{Integer.valueOf(this.forumId), Integer.valueOf(this.id)}), localHashMap, new RestTaskCallback(paramCallback) {
            public void onComplete(JSONObject paramAnonymousJSONObject)
                    throws JSONException {
                Suggestion.this.load(paramAnonymousJSONObject.getJSONObject("suggestion"));
                paramCallback.onModel(Suggestion.this);
            }
        });
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/uservoice/uservoicesdk/model/Suggestion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */