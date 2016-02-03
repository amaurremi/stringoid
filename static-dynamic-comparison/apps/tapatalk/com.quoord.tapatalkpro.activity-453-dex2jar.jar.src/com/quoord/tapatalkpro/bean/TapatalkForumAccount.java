package com.quoord.tapatalkpro.bean;

public class TapatalkForumAccount {
    private String displayName;
    private String email;
    private int forumId;
    private boolean isAdmin;
    private boolean isCanPm;
    private boolean isLogin;
    private boolean isSinginAccount;
    private String password;
    private String username;

    public String getDisplayName() {
        return this.displayName;
    }

    public String getEmail() {
        return this.email;
    }

    public int getForumId() {
        return this.forumId;
    }

    public String getLowerUsername() {
        return this.username.toLowerCase();
    }

    public String getPassword() {
        return this.password;
    }

    public String getUsername() {
        return this.username;
    }

    public boolean isAdmin() {
        return this.isAdmin;
    }

    public boolean isCanPm() {
        return this.isCanPm;
    }

    public boolean isLogin() {
        return this.isLogin;
    }

    public boolean isSinginAccount() {
        return this.isSinginAccount;
    }

    public void setAdmin(boolean paramBoolean) {
        this.isAdmin = paramBoolean;
    }

    public void setCanPm(boolean paramBoolean) {
        this.isCanPm = paramBoolean;
    }

    public void setDisplayName(String paramString) {
        this.displayName = paramString;
    }

    public void setEmail(String paramString) {
        this.email = paramString;
    }

    public void setForumId(int paramInt) {
        this.forumId = paramInt;
    }

    public void setLogin(boolean paramBoolean) {
        this.isLogin = paramBoolean;
    }

    public void setPassword(String paramString) {
        this.password = paramString;
    }

    public void setSinginAccount(boolean paramBoolean) {
        this.isSinginAccount = paramBoolean;
    }

    public void setUsername(String paramString) {
        this.username = paramString;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/bean/TapatalkForumAccount.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */