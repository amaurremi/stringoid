package com.facebook;

import java.io.Serializable;

class AppEventsLogger$AccessTokenAppIdPair$SerializationProxyV1
        implements Serializable {
    private static final long serialVersionUID = -2488473066578201069L;
    private final String accessToken;
    private final String appId;

    private AppEventsLogger$AccessTokenAppIdPair$SerializationProxyV1(String paramString1, String paramString2) {
        this.accessToken = paramString1;
        this.appId = paramString2;
    }

    private Object readResolve() {
        return new AppEventsLogger.AccessTokenAppIdPair(this.accessToken, this.appId);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/AppEventsLogger$AccessTokenAppIdPair$SerializationProxyV1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */