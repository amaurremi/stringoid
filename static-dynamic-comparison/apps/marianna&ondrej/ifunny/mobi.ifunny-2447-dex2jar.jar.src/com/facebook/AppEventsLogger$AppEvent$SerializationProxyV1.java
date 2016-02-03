package com.facebook;

import java.io.Serializable;

class AppEventsLogger$AppEvent$SerializationProxyV1
        implements Serializable {
    private static final long serialVersionUID = -2488473066578201069L;
    private final boolean isImplicit;
    private final String jsonString;

    private AppEventsLogger$AppEvent$SerializationProxyV1(String paramString, boolean paramBoolean) {
        this.jsonString = paramString;
        this.isImplicit = paramBoolean;
    }

    private Object readResolve() {
        return new AppEventsLogger.AppEvent(this.jsonString, this.isImplicit, null);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/AppEventsLogger$AppEvent$SerializationProxyV1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */