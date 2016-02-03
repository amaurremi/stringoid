package com.quoord.tapatalkpro.bean;

import java.io.Serializable;

public class Participant
        extends BaseBean
        implements Serializable {
    private String icon_url;
    private String userId;
    private String userName;

    public String getIcon_url() {
        return this.icon_url;
    }

    public String getUserId() {
        return this.userId;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setIcon_url(String paramString) {
        this.icon_url = paramString;
    }

    public void setUserId(String paramString) {
        this.userId = paramString;
    }

    public void setUserName(String paramString) {
        this.userName = paramString;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/bean/Participant.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */