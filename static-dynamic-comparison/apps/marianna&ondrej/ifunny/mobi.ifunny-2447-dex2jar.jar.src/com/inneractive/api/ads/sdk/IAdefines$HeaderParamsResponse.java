package com.inneractive.api.ads.sdk;

enum IAdefines$HeaderParamsResponse {
    final String j;

    static {
        a = new HeaderParamsResponse("RETURNED_AD_TYPE", 1, "X-IA-Ad-Type");
        b = new HeaderParamsResponse("HEIGHT", 2, "X-IA-Ad-Height");
        c = new HeaderParamsResponse("WIDTH", 3, "X-IA-Ad-Width");
        d = new HeaderParamsResponse("AD_NETWORK", 4, "X-IA-AdNetwork");
        l = new HeaderParamsResponse("CLIENT_ID", 5, "X-IA-Cid");
        m = new HeaderParamsResponse("CLIENT_UNIQUE_ID", 6, "X-IA-Cuid");
    }

    private IAdefines$HeaderParamsResponse(String paramString1) {
        this.j = paramString1;
    }
    }


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inneractive/api/ads/sdk/IAdefines$HeaderParamsResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */