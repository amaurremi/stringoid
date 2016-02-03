package com.inneractive.api.ads.sdk;

import java.util.Map;

final class s
        extends p {
    s(Map paramMap, IAmraidWebView paramIAmraidWebView) {
        super(paramMap, paramIAmraidWebView);
    }

    final void a() {
        int j = a("w");
        int k = a("h");
        String str = b("url");
        boolean bool1 = c("shouldUseCustomClose");
        boolean bool2 = c("lockOrientation");
        int i = j;
        if (j <= 0) {
            i = this.b.getMraidWebViewController().mScreenWidth;
        }
        j = k;
        if (k <= 0) {
            j = this.b.getMraidWebViewController().mScreenHeight;
        }
        this.b.getMraidWebViewController().expand(str, i, j, bool1, bool2);
    }

    protected final boolean a(IAmraidWebView.MraidPlacementType paramMraidPlacementType) {
        boolean bool = false;
        switch (s .1.a[paramMraidPlacementType.ordinal()])
        {
            default:
                bool = super.a(paramMraidPlacementType);
        }
        return bool;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inneractive/api/ads/sdk/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */