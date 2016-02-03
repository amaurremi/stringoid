package com.mopub.common.event;

import com.mopub.common.ClientMetadata;

public abstract class BaseEvent {
    private final ClientMetadata a;
    private final String b;
    private final String c;
    private final long d = System.currentTimeMillis();

    BaseEvent(BaseEvent.Type paramType, String paramString, ClientMetadata paramClientMetadata) {
        this.b = paramType.mName;
        this.c = paramString;
        this.a = paramClientMetadata;
    }

    public String getEventName() {
        return this.b;
    }

    public long getEventTimeUtcMillis() {
        return this.d;
    }

    public ClientMetadata getMetadata() {
        return this.a;
    }

    public String getRequestUrl() {
        return this.c;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/common/event/BaseEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */