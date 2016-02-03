package com.uservoice.uservoicesdk.model;

import com.uservoice.uservoicesdk.Session;
import com.uservoice.uservoicesdk.rest.Callback;
import com.uservoice.uservoicesdk.rest.RestTaskCallback;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

public class User
        extends BaseModel {
    private String email;
    private String name;

    public static void discover(String paramString, final Callback<User> paramCallback) {
        HashMap localHashMap = new HashMap();
        localHashMap.put("email", paramString);
        doGet(apiPath("/users/discover.json", new Object[0]), localHashMap, new RestTaskCallback(paramCallback) {
            public void onComplete(JSONObject paramAnonymousJSONObject)
                    throws JSONException {
                paramCallback.onModel(BaseModel.deserializeObject(paramAnonymousJSONObject, "user", User.class));
            }
        });
    }

    public static void findOrCreate(String paramString1, String paramString2, final Callback<AccessTokenResult<User>> paramCallback) {
        HashMap localHashMap = new HashMap();
        localHashMap.put("user[display_name]", paramString2);
        localHashMap.put("user[email]", paramString1);
        localHashMap.put("request_token", Session.getInstance().getRequestToken().getKey());
        doPost(apiPath("/users.json", new Object[0]), localHashMap, new RestTaskCallback(paramCallback) {
            public void onComplete(JSONObject paramAnonymousJSONObject)
                    throws JSONException {
                AccessToken localAccessToken = (AccessToken) BaseModel.deserializeObject(paramAnonymousJSONObject, "token", AccessToken.class);
                paramAnonymousJSONObject = (User) BaseModel.deserializeObject(paramAnonymousJSONObject, "user", User.class);
                paramCallback.onModel(new AccessTokenResult(paramAnonymousJSONObject, localAccessToken));
            }
        });
    }

    public static void findOrCreate(String paramString1, String paramString2, String paramString3, final Callback<AccessTokenResult<User>> paramCallback) {
        HashMap localHashMap = new HashMap();
        localHashMap.put("user[display_name]", paramString2);
        localHashMap.put("user[email]", paramString1);
        localHashMap.put("user[guid]", paramString3);
        localHashMap.put("request_token", Session.getInstance().getRequestToken().getKey());
        doPost(apiPath("/users/find_or_create.json", new Object[0]), localHashMap, new RestTaskCallback(paramCallback) {
            public void onComplete(JSONObject paramAnonymousJSONObject)
                    throws JSONException {
                AccessToken localAccessToken = (AccessToken) BaseModel.deserializeObject(paramAnonymousJSONObject, "token", AccessToken.class);
                paramAnonymousJSONObject = (User) BaseModel.deserializeObject(paramAnonymousJSONObject, "user", User.class);
                paramCallback.onModel(new AccessTokenResult(paramAnonymousJSONObject, localAccessToken));
            }
        });
    }

    public static void loadCurrentUser(final Callback<User> paramCallback) {
        doGet(apiPath("/users/current.json", new Object[0]), new RestTaskCallback(paramCallback) {
            public void onComplete(JSONObject paramAnonymousJSONObject)
                    throws JSONException {
                paramCallback.onModel(BaseModel.deserializeObject(paramAnonymousJSONObject, "user", User.class));
            }
        });
    }

    public static void sendForgotPassword(String paramString, final Callback<User> paramCallback) {
        HashMap localHashMap = new HashMap();
        localHashMap.put("user[email]", paramString);
        doGet(apiPath("/users/forgot_password.json", new Object[0]), localHashMap, new RestTaskCallback(paramCallback) {
            public void onComplete(JSONObject paramAnonymousJSONObject)
                    throws JSONException {
                paramCallback.onModel(BaseModel.deserializeObject(paramAnonymousJSONObject, "user", User.class));
            }
        });
    }

    public String getEmail() {
        return this.email;
    }

    public String getName() {
        return this.name;
    }

    public void load(JSONObject paramJSONObject)
            throws JSONException {
        super.load(paramJSONObject);
        this.name = getString(paramJSONObject, "name");
        this.email = getString(paramJSONObject, "email");
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/uservoice/uservoicesdk/model/User.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */