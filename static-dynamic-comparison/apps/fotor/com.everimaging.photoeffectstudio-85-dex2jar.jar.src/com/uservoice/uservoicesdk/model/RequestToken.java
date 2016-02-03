package com.uservoice.uservoicesdk.model;

import com.uservoice.uservoicesdk.rest.Callback;
import com.uservoice.uservoicesdk.rest.RestTaskCallback;
import org.json.JSONException;
import org.json.JSONObject;

public class RequestToken
        extends BaseModel {
    private String key;
    private String secret;

    public static void getRequestToken(final Callback<RequestToken> paramCallback) {
        doGet(apiPath("/oauth/request_token.json", new Object[0]), new RestTaskCallback(paramCallback) {
            public void onComplete(JSONObject paramAnonymousJSONObject)
                    throws JSONException {
                paramCallback.onModel(BaseModel.deserializeObject(paramAnonymousJSONObject, "token", RequestToken.class));
            }
        });
    }

    public String getKey() {
        return this.key;
    }

    public String getSecret() {
        return this.secret;
    }

    public void load(JSONObject paramJSONObject)
            throws JSONException {
        this.key = paramJSONObject.getString("oauth_token");
        this.secret = paramJSONObject.getString("oauth_token_secret");
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/uservoice/uservoicesdk/model/RequestToken.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */