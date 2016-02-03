package com.uservoice.uservoicesdk.model;

import com.uservoice.uservoicesdk.rest.Callback;
import com.uservoice.uservoicesdk.rest.RestTaskCallback;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Forum
        extends BaseModel {
    private List<Category> categories;
    private String name;
    private int numberOfOpenSuggestions;
    private int numberOfVotesAllowed;

    public static void loadForum(int paramInt, final Callback<Forum> paramCallback) {
        doGet(apiPath("/forums/%d.json", new Object[]{Integer.valueOf(paramInt)}), new RestTaskCallback(paramCallback) {
            public void onComplete(JSONObject paramAnonymousJSONObject)
                    throws JSONException {
                paramCallback.onModel(BaseModel.deserializeObject(paramAnonymousJSONObject, "forum", Forum.class));
            }
        });
    }

    public List<Category> getCategories() {
        return this.categories;
    }

    public String getName() {
        return this.name;
    }

    public int getNumberOfOpenSuggestions() {
        return this.numberOfOpenSuggestions;
    }

    public int getNumberOfVotesAllowed() {
        return this.numberOfVotesAllowed;
    }

    public void load(JSONObject paramJSONObject)
            throws JSONException {
        super.load(paramJSONObject);
        this.name = getString(paramJSONObject, "name");
        paramJSONObject = paramJSONObject.getJSONArray("topics").getJSONObject(0);
        this.numberOfOpenSuggestions = paramJSONObject.getInt("open_suggestions_count");
        this.numberOfVotesAllowed = paramJSONObject.getInt("votes_allowed");
        this.categories = deserializeList(paramJSONObject, "categories", Category.class);
        if (this.categories == null) {
            this.categories = new ArrayList();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/uservoice/uservoicesdk/model/Forum.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */