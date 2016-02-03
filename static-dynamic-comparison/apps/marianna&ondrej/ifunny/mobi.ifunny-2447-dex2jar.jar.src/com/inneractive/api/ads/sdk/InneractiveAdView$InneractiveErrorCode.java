package com.inneractive.api.ads.sdk;

public enum InneractiveAdView$InneractiveErrorCode {
    private final String a;

    static {
        SDK_INTERNAL_ERROR = new InneractiveErrorCode("SDK_INTERNAL_ERROR", 3, "SDK Internal Error.");
        CANCELLED = new InneractiveErrorCode("CANCELLED", 4, "Ad Request Was Cancelled.");
        CONNECTION_TIMEOUT = new InneractiveErrorCode("CONNECTION_TIMEOUT", 5, "Connection Timed Out.");
        CONNECTION_ERROR = new InneractiveErrorCode("CONNECTION_ERROR", 6, "Network Connection Error.");
        UNKNOWN_APP_ID = new InneractiveErrorCode("UNKNOWN_APP_ID", 7, "Unknown App ID.");
    }

    private InneractiveAdView$InneractiveErrorCode(String paramString1) {
        this.a = paramString1;
    }

    public final String toString() {
        return this.a;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inneractive/api/ads/sdk/InneractiveAdView$InneractiveErrorCode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */