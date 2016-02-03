package com.facebook;

import android.app.Activity;
import android.support.v4.app.Fragment;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Session$AuthorizationRequest
        implements Serializable {
    private static final long serialVersionUID = 1L;
    private String applicationId;
    private final String authId = UUID.randomUUID().toString();
    private SessionDefaultAudience defaultAudience = SessionDefaultAudience.FRIENDS;
    private boolean isLegacy = false;
    private final Map<String, String> loggingExtras = new HashMap();
    private SessionLoginBehavior loginBehavior = SessionLoginBehavior.SSO_WITH_FALLBACK;
    private List<String> permissions = Collections.emptyList();
    private int requestCode = 64206;
    private final Session.StartActivityDelegate startActivityDelegate;
    private Session.StatusCallback statusCallback;
    private String validateSameFbidAsToken;

    Session$AuthorizationRequest(Activity paramActivity) {
        this.startActivityDelegate = new Session.AuthorizationRequest .1 (this, paramActivity);
    }

    Session$AuthorizationRequest(Fragment paramFragment) {
        this.startActivityDelegate = new Session.AuthorizationRequest .2 (this, paramFragment);
    }

    private Session$AuthorizationRequest(SessionLoginBehavior paramSessionLoginBehavior, int paramInt, List<String> paramList, String paramString1, boolean paramBoolean, String paramString2, String paramString3) {
        this.startActivityDelegate = new Session.AuthorizationRequest .3 (this);
        this.loginBehavior = paramSessionLoginBehavior;
        this.requestCode = paramInt;
        this.permissions = paramList;
        this.defaultAudience = SessionDefaultAudience.valueOf(paramString1);
        this.isLegacy = paramBoolean;
        this.applicationId = paramString2;
        this.validateSameFbidAsToken = paramString3;
    }

    private void readObject(ObjectInputStream paramObjectInputStream) {
        throw new InvalidObjectException("Cannot readObject, serialization proxy required");
    }

    String getApplicationId() {
        return this.applicationId;
    }

    String getAuthId() {
        return this.authId;
    }

    AuthorizationClient.AuthorizationRequest getAuthorizationClientRequest() {
        Session.AuthorizationRequest .4 local4 = new Session.AuthorizationRequest .4 (this);
        return new AuthorizationClient.AuthorizationRequest(this.loginBehavior, this.requestCode, this.isLegacy, this.permissions, this.defaultAudience, this.applicationId, this.validateSameFbidAsToken, local4, this.authId);
    }

    Session.StatusCallback getCallback() {
        return this.statusCallback;
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

    int getRequestCode() {
        return this.requestCode;
    }

    Session.StartActivityDelegate getStartActivityDelegate() {
        return this.startActivityDelegate;
    }

    String getValidateSameFbidAsToken() {
        return this.validateSameFbidAsToken;
    }

    boolean isLegacy() {
        return this.isLegacy;
    }

    void setApplicationId(String paramString) {
        this.applicationId = paramString;
    }

    AuthorizationRequest setCallback(Session.StatusCallback paramStatusCallback) {
        this.statusCallback = paramStatusCallback;
        return this;
    }

    AuthorizationRequest setDefaultAudience(SessionDefaultAudience paramSessionDefaultAudience) {
        if (paramSessionDefaultAudience != null) {
            this.defaultAudience = paramSessionDefaultAudience;
        }
        return this;
    }

    public void setIsLegacy(boolean paramBoolean) {
        this.isLegacy = paramBoolean;
    }

    AuthorizationRequest setLoginBehavior(SessionLoginBehavior paramSessionLoginBehavior) {
        if (paramSessionLoginBehavior != null) {
            this.loginBehavior = paramSessionLoginBehavior;
        }
        return this;
    }

    AuthorizationRequest setPermissions(List<String> paramList) {
        if (paramList != null) {
            this.permissions = paramList;
        }
        return this;
    }

    AuthorizationRequest setPermissions(String... paramVarArgs) {
        return setPermissions(Arrays.asList(paramVarArgs));
    }

    AuthorizationRequest setRequestCode(int paramInt) {
        if (paramInt >= 0) {
            this.requestCode = paramInt;
        }
        return this;
    }

    void setValidateSameFbidAsToken(String paramString) {
        this.validateSameFbidAsToken = paramString;
    }

    Object writeReplace() {
        return new Session.AuthorizationRequest.AuthRequestSerializationProxyV1(this.loginBehavior, this.requestCode, this.permissions, this.defaultAudience.name(), this.isLegacy, this.applicationId, this.validateSameFbidAsToken, null);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/Session$AuthorizationRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */