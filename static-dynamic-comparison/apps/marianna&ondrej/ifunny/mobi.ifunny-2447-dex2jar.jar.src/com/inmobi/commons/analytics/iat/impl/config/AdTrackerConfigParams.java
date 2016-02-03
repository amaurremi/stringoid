package com.inmobi.commons.analytics.iat.impl.config;

import android.content.Context;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.metric.MetricConfigParams;
import com.inmobi.commons.uid.UIDMapConfigParams;

import java.util.Map;

public class AdTrackerConfigParams {
    private static final String a = "Starting.*: Intent.*(?:http://market.android.com/details|market://details|play.google.com).*(?:id=" + InternalSDKUtil.getContext().getPackageName() + ").*referrer=([^&\\s]+)";
    private int b = 60;
    private int c = 300;
    private String d = a;
    private AdTrackerGoalRetryParams e = new AdTrackerGoalRetryParams();
    private MetricConfigParams f = new MetricConfigParams();
    private UIDMapConfigParams g = new UIDMapConfigParams();

    public int getConnectionTimeout() {
        return this.b * 1000;
    }

    public Map<String, Boolean> getDeviceIdMaskMap() {
        return this.g.getMap();
    }

    public String getLogcatPattern() {
        return this.d;
    }

    public MetricConfigParams getMetric() {
        return this.f;
    }

    public int getReferrerWaitTime() {
        return 300000;
    }

    public int getReferrerWaitTimeRetryCount() {
        return 3;
    }

    public int getReferrerWaitTimeRetryInterval() {
        return 5000;
    }

    public AdTrackerGoalRetryParams getRetryParams() {
        return this.e;
    }

    public int getWebviewTimeout() {
        return this.c * 1000;
    }

    public void setFromMap(Map<String, Object> paramMap) {
        this.b = InternalSDKUtil.getIntFromMap(paramMap, "cto", 1, 2147483647L);
        this.c = InternalSDKUtil.getIntFromMap(paramMap, "wto", 1, 2147483647L);
        this.d = InternalSDKUtil.getStringFromMap(paramMap, "rlp").replace("$PKG", InternalSDKUtil.getContext().getPackageName());
        this.e.setFromMap((Map) paramMap.get("rp"));
        this.f.setFromMap((Map) paramMap.get("metric"));
        this.g.setMap(InternalSDKUtil.getObjectFromMap(paramMap, "ids"));
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/commons/analytics/iat/impl/config/AdTrackerConfigParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */