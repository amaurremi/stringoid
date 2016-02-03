package com.inmobi.commons.analytics.bootstrapper;

import com.inmobi.commons.internal.InternalSDKUtil;

import java.util.Map;

public class AutomaticCaptureConfig {
    private boolean a = true;
    private boolean b = false;
    private boolean c = true;

    public boolean isAutoLocationCaptureEnabled() {
        return this.c;
    }

    public boolean isAutoPurchaseCaptureEnabled() {
        return this.b;
    }

    public boolean isAutoSessionCaptureEnabled() {
        return this.a;
    }

    public void setFromMap(Map<String, Object> paramMap) {
        this.a = InternalSDKUtil.getBooleanFromMap(paramMap, "session");
        this.b = InternalSDKUtil.getBooleanFromMap(paramMap, "purchase");
        this.c = InternalSDKUtil.getBooleanFromMap(paramMap, "location");
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/commons/analytics/bootstrapper/AutomaticCaptureConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */