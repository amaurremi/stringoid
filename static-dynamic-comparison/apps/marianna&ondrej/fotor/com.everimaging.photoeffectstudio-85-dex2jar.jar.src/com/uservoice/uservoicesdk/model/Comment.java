package com.uservoice.uservoicesdk.model;

import com.uservoice.uservoicesdk.babayaga.Babayaga;
import com.uservoice.uservoicesdk.babayaga.Babayaga.Event;
import com.uservoice.uservoicesdk.rest.Callback;
import com.uservoice.uservoicesdk.rest.RestTaskCallback;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

public class Comment
        extends BaseModel {
    private String avatarUrl;
    private Date createdAt;
    private String text;
    private String userName;

    public static void createComment(final Suggestion paramSuggestion, String paramString, final Callback<Comment> paramCallback) {
        HashMap localHashMap = new HashMap();
        localHashMap.put("comment[text]", paramString);
        doPost(apiPath("/forums/%d/suggestions/%d/comments.json", new Object[]{Integer.valueOf(paramSuggestion.getForumId()), Integer.valueOf(paramSuggestion.getId())}), localHashMap, new RestTaskCallback(paramCallback) {
            public void onComplete(JSONObject paramAnonymousJSONObject)
                    throws JSONException {
                Babayaga.track(Babayaga.Event.COMMENT_IDEA, paramSuggestion.getId());
                paramCallback.onModel(BaseModel.deserializeObject(paramAnonymousJSONObject, "comment", Comment.class));
            }
        });
    }

    public static void loadComments(Suggestion paramSuggestion, int paramInt, final Callback<List<Comment>> paramCallback) {
        HashMap localHashMap = new HashMap();
        localHashMap.put("page", String.valueOf(paramInt));
        doGet(apiPath("/forums/%d/suggestions/%d/comments.json", new Object[]{Integer.valueOf(paramSuggestion.getForumId()), Integer.valueOf(paramSuggestion.getId())}), localHashMap, new RestTaskCallback(paramCallback) {
            public void onComplete(JSONObject paramAnonymousJSONObject)
                    throws JSONException {
                paramCallback.onModel(BaseModel.deserializeList(paramAnonymousJSONObject, "comments", Comment.class));
            }
        });
    }

    public String getAvatarUrl() {
        return this.avatarUrl;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public String getText() {
        return this.text;
    }

    public String getUserName() {
        return this.userName;
    }

    public void load(JSONObject paramJSONObject)
            throws JSONException {
        super.load(paramJSONObject);
        this.text = getString(paramJSONObject, "formatted_text");
        JSONObject localJSONObject = paramJSONObject.getJSONObject("creator");
        this.userName = getString(localJSONObject, "name");
        this.avatarUrl = getString(localJSONObject, "avatar_url");
        this.createdAt = getDate(paramJSONObject, "created_at");
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/uservoice/uservoicesdk/model/Comment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */