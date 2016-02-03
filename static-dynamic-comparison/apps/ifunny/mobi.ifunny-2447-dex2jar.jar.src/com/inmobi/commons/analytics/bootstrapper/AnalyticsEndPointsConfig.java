package com.inmobi.commons.analytics.bootstrapper;

import com.inmobi.commons.internal.InternalSDKUtil;

import java.util.Map;

public class AnalyticsEndPointsConfig {
    private String a = "http://a.ai.inmobi.com/v2/ad.html";
    private String b = "https://rules-ltvp.inmobi.com/v2/rules.json";
    private String c = "https://e-ltvp.inmobi.com/storm/v1/event";

    public String getEventsUrl() {
        return this.c;
    }

    public String getHouseUrl() {
        return this.a;
    }

    public String getRulesUrl() {
        return this.b;
    }

    public void setFromMap(Map<String, Object> paramMap) {
        this.a = InternalSDKUtil.getStringFromMap(paramMap, "house");
        this.b = InternalSDKUtil.getStringFromMap(paramMap, "rules");
        this.c = InternalSDKUtil.getStringFromMap(paramMap, "events");
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/commons/analytics/bootstrapper/AnalyticsEndPointsConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */