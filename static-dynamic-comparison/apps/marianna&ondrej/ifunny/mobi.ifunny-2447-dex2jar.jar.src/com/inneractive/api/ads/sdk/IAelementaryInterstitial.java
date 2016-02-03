package com.inneractive.api.ads.sdk;

import android.content.Context;
import android.net.Uri;

class IAelementaryInterstitial
        extends a {
    private String a;
    private Context b;
    private IAadConfig c;

    protected final void a() {
        InneractiveInterstitialAdActivity.start(this.b, this.a, this.c);
    }

    protected final void a(Context paramContext, a.a parama, IAresponseData paramIAresponseData) {
        this.b = paramContext;
        if (!c.b(paramIAresponseData.a)) {
        }
        for (int i = 1; i != 0; i = 0) {
            this.a = Uri.decode(paramIAresponseData.a);
            this.c = IAadConfig.a(paramIAresponseData);
            paramContext = this.c;
            InneractiveInterstitialAdActivity.displayAhead(this.b, parama, this.a, paramContext);
            return;
        }
        parama.a(InneractiveAdView.InneractiveErrorCode.SERVER_INVALID_RESPONSE);
    }

    protected final void b() {
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inneractive/api/ads/sdk/IAelementaryInterstitial.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */