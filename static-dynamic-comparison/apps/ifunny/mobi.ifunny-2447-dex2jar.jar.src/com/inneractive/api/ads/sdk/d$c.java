package com.inneractive.api.ads.sdk;

final class d$c
        extends d {
    private IAresponseData b;

    public d$c(IAresponseData paramIAresponseData) {
        this.b = paramIAresponseData;
    }

    final void a() {
        if (this.b != null) {
            a.a(this.b);
            return;
        }
        InneractiveAdView.InneractiveErrorCode localInneractiveErrorCode = InneractiveAdView.InneractiveErrorCode.SERVER_INVALID_RESPONSE;
        a.a(localInneractiveErrorCode);
    }

    final void b() {
        this.b = null;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inneractive/api/ads/sdk/d$c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */