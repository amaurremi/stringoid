package com.uservoice.uservoicesdk.model;

import com.uservoice.uservoicesdk.Session;
import com.uservoice.uservoicesdk.rest.Callback;
import com.uservoice.uservoicesdk.rest.RestTaskCallback;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

public class AccessToken
        extends BaseModel {
    private String key;
    private String secret;

    public static void authorize(String paramString1, String paramString2, final Callback<AccessToken> paramCallback) {
        HashMap localHashMap = new HashMap();
        localHashMap.put("email", paramString1);
        localHashMap.put("password", paramString2);
        localHashMap.put("request_token", Session.getInstance().getRequestToken().getKey());
        doPost(apiPath("/oauth/authorize.json", new Object[0]), localHashMap, new RestTaskCallback(paramCallback) {
            public void onComplete(JSONObject paramAnonymousJSONObject)
                    throws JSONException {
                paramCallback.onModel(BaseModel.deserializeObject(paramAnonymousJSONObject, "token", AccessToken.class));
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

    public void save(JSONObject paramJSONObject)
            throws JSONException {
        paramJSONObject.put("oauth_token", this.key);
        paramJSONObject.put("oauth_token_secret", this.secret);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/uservoice/uservoicesdk/model/AccessToken.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */