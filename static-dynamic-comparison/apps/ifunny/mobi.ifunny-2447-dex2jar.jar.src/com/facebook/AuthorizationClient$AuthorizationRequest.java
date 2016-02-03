package com.facebook;

import java.io.Serializable;
import java.util.List;

class AuthorizationClient$AuthorizationRequest
        implements Serializable {
    private static final long serialVersionUID = 1L;
    private final String applicationId;
    private final String authId;
    private final SessionDefaultAudience defaultAudience;
    private boolean isLegacy = false;
    private boolean isRerequest = false;
    private final SessionLoginBehavior loginBehavior;
    private List<String> permissions;
    private final String previousAccessToken;
    private final int requestCode;
    private final transient AuthorizationClient.StartActivityDelegate startActivityDelegate;

    AuthorizationClient$AuthorizationRequest(SessionLoginBehavior paramSessionLoginBehavior, int paramInt, boolean paramBoolean, List<String> paramList, SessionDefaultAudience paramSessionDefaultAudience, String paramString1, String paramString2, AuthorizationClient.StartActivityDelegate paramStartActivityDelegate, String paramString3) {
        this.loginBehavior = paramSessionLoginBehavior;
        this.requestCode = paramInt;
        this.isLegacy = paramBoolean;
        this.permissions = paramList;
        this.defaultAudience = paramSessionDefaultAudience;
        this.applicationId = paramString1;
        this.previousAccessToken = paramString2;
        this.startActivityDelegate = paramStartActivityDelegate;
        this.authId = paramString3;
    }

    String getApplicationId() {
        return this.applicationId;
    }

    String getAuthId() {
        return this.authId;
    }

    SessionDefaultAudience getDefaultAudience() {
        return this.defaultAudience;
    }

    SessionLoginBehavior getLoginBehavior() {
        return this.loginBehavior;
    }

    List<String> getPermissions() {
        return this.permissions;
    }

    String getPreviousAccessToken() {
        return this.previousAccessToken;
    }

    int getRequestCode() {
        return this.requestCode;
    }

    AuthorizationClient.StartActivityDelegate getStartActivityDelegate() {
        return this.startActivityDelegate;
    }

    boolean isLegacy() {
        return this.isLegacy;
    }

    boolean isRerequest() {
        return this.isRerequest;
    }

    boolean needsNewTokenValidation() {
        return (this.previousAccessToken != null) && (!this.isLegacy);
    }

    void setIsLegacy(boolean paramBoolean) {
        this.isLegacy = paramBoolean;
    }

    void setPermissions(List<String> paramList) {
        this.permissions = paramList;
    }

    void setRerequest(boolean paramBoolean) {
        this.isRerequest = paramBoolean;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/AuthorizationClient$AuthorizationRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */