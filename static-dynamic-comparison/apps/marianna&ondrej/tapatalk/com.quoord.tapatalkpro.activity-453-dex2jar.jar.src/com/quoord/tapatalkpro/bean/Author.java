package com.quoord.tapatalkpro.bean;

import org.json.JSONException;
import org.json.JSONObject;

public class Author {
    private String avatar = null;
    private String password = null;
    private String status = null;
    private String user_id = null;
    private String user_name = null;

    public Author(JSONObject paramJSONObject) {
        try {
            setUser_name(paramJSONObject.getString("name"));
            setUser_id(paramJSONObject.getString("user_id"));
            setAvatar(paramJSONObject.getString("avatar"));
            setStatus(paramJSONObject.getString("status"));
            setPassword(paramJSONObject.getString("password"));
            return;
        } catch (JSONException paramJSONObject) {
            paramJSONObject.printStackTrace();
        }
    }

    public String getAvatar() {
        return this.avatar;
    }

    public String getPassword() {
        return this.password;
    }

    public String getStatus() {
        return this.status;
    }

    public String getUser_id() {
        return this.user_id;
    }

    public String getUser_name() {
        return this.user_name;
    }

    public void setAvatar(String paramString) {
        this.avatar = paramString;
    }

    public void setPassword(String paramString) {
        this.password = paramString;
    }

    public void setStatus(String paramString) {
        this.status = paramString;
    }

    public void setUser_id(String paramString) {
        this.user_id = paramString;
    }

    public void setUser_name(String paramString) {
        this.user_name = paramString;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/bean/Author.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */