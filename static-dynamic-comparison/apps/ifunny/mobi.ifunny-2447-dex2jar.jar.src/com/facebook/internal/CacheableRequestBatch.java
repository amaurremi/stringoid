package com.facebook.internal;

import com.facebook.Request;
import com.facebook.RequestBatch;

public class CacheableRequestBatch
        extends RequestBatch {
    private String cacheKey;
    private boolean forceRoundTrip;

    public CacheableRequestBatch() {
    }

    public CacheableRequestBatch(Request... paramVarArgs) {
        super(paramVarArgs);
    }

    public final String getCacheKeyOverride() {
        return this.cacheKey;
    }

    public final boolean getForceRoundTrip() {
        return this.forceRoundTrip;
    }

    public final void setCacheKeyOverride(String paramString) {
        this.cacheKey = paramString;
    }

    public final void setForceRoundTrip(boolean paramBoolean) {
        this.forceRoundTrip = paramBoolean;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/internal/CacheableRequestBatch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */