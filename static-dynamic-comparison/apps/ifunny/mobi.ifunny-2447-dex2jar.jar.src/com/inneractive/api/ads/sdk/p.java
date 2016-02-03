package com.inneractive.api.ads.sdk;

import java.util.Map;

abstract class p {
    protected Map a;
    protected IAmraidWebView b;

    p(Map paramMap, IAmraidWebView paramIAmraidWebView) {
        this.a = paramMap;
        this.b = paramIAmraidWebView;
    }

    protected final int a(String paramString) {
        paramString = (String) this.a.get(paramString);
        if (paramString == null) {
            return -1;
        }
        try {
            int i = Integer.parseInt(paramString, 10);
            return i;
        } catch (NumberFormatException paramString) {
        }
        return -1;
    }

    abstract void a();

    protected boolean a(IAmraidWebView.MraidPlacementType paramMraidPlacementType) {
        return false;
    }

    protected final String b(String paramString) {
        return (String) this.a.get(paramString);
    }

    protected final boolean c(String paramString) {
        return "true".equals(this.a.get(paramString));
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inneractive/api/ads/sdk/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */