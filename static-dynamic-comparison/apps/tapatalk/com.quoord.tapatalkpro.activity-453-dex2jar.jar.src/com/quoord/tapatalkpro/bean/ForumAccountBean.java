package com.quoord.tapatalkpro.bean;

import java.io.Serializable;

import org.json.JSONObject;

public class ForumAccountBean
        implements Serializable {
    private static final long serialVersionUID = -8246957136290913002L;
    public String displayName;
    public int fid;
    public int hide;
    public int postCount;
    public String uid;
    public String use_au_email;
    public String username;

    // todo values are put in JSON object fields
    public static ForumAccountBean getDataByJson(JSONObject paramJSONObject) {
        try {
            ForumAccountBean localForumAccountBean = new ForumAccountBean();
            if (paramJSONObject.has("fid")) {
                localForumAccountBean.fid = paramJSONObject.getInt("fid");
            }
            if (paramJSONObject.has("username")) {
                localForumAccountBean.username = paramJSONObject.getString("username");
            }
            if (paramJSONObject.has("display_name")) {
                localForumAccountBean.displayName = paramJSONObject.getString("display_name");
            }
            if (paramJSONObject.has("uid")) {
                localForumAccountBean.uid = paramJSONObject.getString("uid");
            }
            if (paramJSONObject.has("post")) {
                localForumAccountBean.postCount = paramJSONObject.getInt("post");
            }
            if (paramJSONObject.has("hide")) {
                localForumAccountBean.hide = paramJSONObject.getInt("hide");
            }
            if (paramJSONObject.has("use_au_email")) {
                localForumAccountBean.use_au_email = paramJSONObject.getString("use_au_email");
            }
            return localForumAccountBean;
        } catch (Exception paramJSONObject) {
        }
        return null;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/bean/ForumAccountBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */