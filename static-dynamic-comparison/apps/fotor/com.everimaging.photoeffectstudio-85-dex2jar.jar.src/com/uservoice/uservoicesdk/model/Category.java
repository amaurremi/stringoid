package com.uservoice.uservoicesdk.model;

import org.json.JSONException;
import org.json.JSONObject;

public class Category
        extends BaseModel {
    private String name;

    public String getName() {
        return this.name;
    }

    public void load(JSONObject paramJSONObject)
            throws JSONException {
        super.load(paramJSONObject);
        this.name = getString(paramJSONObject, "name");
    }

    public String toString() {
        return this.name;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/uservoice/uservoicesdk/model/Category.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */