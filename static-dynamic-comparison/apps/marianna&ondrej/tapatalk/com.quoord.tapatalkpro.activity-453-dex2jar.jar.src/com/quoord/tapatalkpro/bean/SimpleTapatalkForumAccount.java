package com.quoord.tapatalkpro.bean;

public class SimpleTapatalkForumAccount {
    private String iconUrl;
    private String tapatalkDisplayName;
    private String tapatalkForumId;
    private String tapatalkForumPassqord;
    private String tapatalkForumUserName;
    private String tapatalkUserName;

    public SimpleTapatalkForumAccount() {
    }

    public SimpleTapatalkForumAccount(String paramString1, String paramString2, String paramString3) {
        this.tapatalkForumId = paramString1;
        this.tapatalkForumUserName = paramString2;
        this.tapatalkForumPassqord = paramString3;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public String getTapatalkDisplayName() {
        return this.tapatalkDisplayName;
    }

    public String getTapatalkForumId() {
        return this.tapatalkForumId;
    }

    public String getTapatalkForumPassqord() {
        return this.tapatalkForumPassqord;
    }

    public String getTapatalkForumUserName() {
        return this.tapatalkForumUserName;
    }

    public String getTapatalkUserName() {
        return this.tapatalkUserName;
    }

    public void setIconUrl(String paramString) {
        this.iconUrl = paramString;
    }

    public void setTapatalkDisplayName(String paramString) {
        this.tapatalkDisplayName = paramString;
    }

    public void setTapatalkForumId(String paramString) {
        this.tapatalkForumId = paramString;
    }

    public void setTapatalkForumPassqord(String paramString) {
        this.tapatalkForumPassqord = paramString;
    }

    public void setTapatalkForumUserName(String paramString) {
        this.tapatalkForumUserName = paramString;
    }

    public void setTapatalkUserName(String paramString) {
        this.tapatalkUserName = paramString;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/bean/SimpleTapatalkForumAccount.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */