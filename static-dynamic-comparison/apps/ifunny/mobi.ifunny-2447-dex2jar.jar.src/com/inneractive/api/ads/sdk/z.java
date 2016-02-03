package com.inneractive.api.ads.sdk;

import java.util.Map;

final class z
        extends p {
    public z(Map paramMap, IAmraidWebView paramIAmraidWebView) {
        super(paramMap, paramIAmraidWebView);
    }

    final void a() {
        String str = b("uri");
        if ((str != null) && (!"".equals(str))) {
            this.b.getMraidWebViewController().displayVideo(str);
            return;
        }
        this.b.fireErrorEvent(IAmraidActionFactory.MraidJavascriptCommand.i, "Video can't be played with null or empty URL");
    }

    protected final boolean a(IAmraidWebView.MraidPlacementType paramMraidPlacementType) {
        switch (z .1.a[paramMraidPlacementType.ordinal()])
        {
            default:
                return super.a(paramMraidPlacementType);
            case 1:
                return true;
        }
        return false;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inneractive/api/ads/sdk/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */