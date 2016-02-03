package com.mopub.common.util;

public enum ResponseHeader {
    private final String a;

    static {
        CUSTOM_EVENT_HTML_DATA = new ResponseHeader("CUSTOM_EVENT_HTML_DATA", 5, "X-Custom-Event-Html-Data");
        DSP_CREATIVE_ID = new ResponseHeader("DSP_CREATIVE_ID", 6, "X-DspCreativeid");
        FAIL_URL = new ResponseHeader("FAIL_URL", 7, "X-Failurl");
        FULL_AD_TYPE = new ResponseHeader("FULL_AD_TYPE", 8, "X-Fulladtype");
        HEIGHT = new ResponseHeader("HEIGHT", 9, "X-Height");
        IMPRESSION_URL = new ResponseHeader("IMPRESSION_URL", 10, "X-Imptracker");
        REDIRECT_URL = new ResponseHeader("REDIRECT_URL", 11, "X-Launchpage");
        NATIVE_PARAMS = new ResponseHeader("NATIVE_PARAMS", 12, "X-Nativeparams");
        NETWORK_TYPE = new ResponseHeader("NETWORK_TYPE", 13, "X-Networktype");
        REFRESH_TIME = new ResponseHeader("REFRESH_TIME", 14, "X-Refreshtime");
        SCROLLABLE = new ResponseHeader("SCROLLABLE", 15, "X-Scrollable");
        WARMUP = new ResponseHeader("WARMUP", 16, "X-Warmup");
        WIDTH = new ResponseHeader("WIDTH", 17, "X-Width");
        LOCATION = new ResponseHeader("LOCATION", 18, "Location");
        USER_AGENT = new ResponseHeader("USER_AGENT", 19, "User-Agent");
    }

    private ResponseHeader(String paramString) {
        this.a = paramString;
    }

    public String getKey() {
        return this.a;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/common/util/ResponseHeader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */