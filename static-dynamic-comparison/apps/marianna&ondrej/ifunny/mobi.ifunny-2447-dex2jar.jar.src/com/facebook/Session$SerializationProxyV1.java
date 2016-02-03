package com.facebook;

import java.io.Serializable;
import java.util.Date;

class Session$SerializationProxyV1
        implements Serializable {
    private static final long serialVersionUID = 7663436173185080063L;
    private final String applicationId;
    private final Date lastAttemptedTokenExtendDate;
    private final Session.AuthorizationRequest pendingAuthorizationRequest;
    private final boolean shouldAutoPublish;
    private final SessionState state;
    private final AccessToken tokenInfo;

    Session$SerializationProxyV1(String paramString, SessionState paramSessionState, AccessToken paramAccessToken, Date paramDate, boolean paramBoolean, Session.AuthorizationRequest paramAuthorizationRequest) {
        this.applicationId = paramString;
        this.state = paramSessionState;
        this.tokenInfo = paramAccessToken;
        this.lastAttemptedTokenExtendDate = paramDate;
        this.shouldAutoPublish = paramBoolean;
        this.pendingAuthorizationRequest = paramAuthorizationRequest;
    }

    private Object readResolve() {
        return new Session(this.applicationId, this.state, this.tokenInfo, this.lastAttemptedTokenExtendDate, this.shouldAutoPublish, this.pendingAuthorizationRequest, null);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/Session$SerializationProxyV1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */