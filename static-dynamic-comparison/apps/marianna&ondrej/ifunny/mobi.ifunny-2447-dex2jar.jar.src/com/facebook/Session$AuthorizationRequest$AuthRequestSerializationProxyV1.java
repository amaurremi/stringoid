package com.facebook;

import java.io.Serializable;
import java.util.List;

class Session$AuthorizationRequest$AuthRequestSerializationProxyV1
        implements Serializable {
    private static final long serialVersionUID = -8748347685113614927L;
    private final String applicationId;
    private final String defaultAudience;
    private boolean isLegacy;
    private final SessionLoginBehavior loginBehavior;
    private final List<String> permissions;
    private final int requestCode;
    private final String validateSameFbidAsToken;

    private Session$AuthorizationRequest$AuthRequestSerializationProxyV1(SessionLoginBehavior paramSessionLoginBehavior, int paramInt, List<String> paramList, String paramString1, boolean paramBoolean, String paramString2, String paramString3) {
        this.loginBehavior = paramSessionLoginBehavior;
        this.requestCode = paramInt;
        this.permissions = paramList;
        this.defaultAudience = paramString1;
        this.isLegacy = paramBoolean;
        this.applicationId = paramString2;
        this.validateSameFbidAsToken = paramString3;
    }

    private Object readResolve() {
        return new Session.AuthorizationRequest(this.loginBehavior, this.requestCode, this.permissions, this.defaultAudience, this.isLegacy, this.applicationId, this.validateSameFbidAsToken, null);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/Session$AuthorizationRequest$AuthRequestSerializationProxyV1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */