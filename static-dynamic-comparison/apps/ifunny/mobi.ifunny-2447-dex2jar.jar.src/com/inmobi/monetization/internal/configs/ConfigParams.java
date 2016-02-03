package com.inmobi.monetization.internal.configs;

import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.metric.MetricConfigParams;
import com.inmobi.commons.uid.UIDMapConfigParams;

import java.util.Map;

public class ConfigParams {
    int a = 20;
    int b = 60;
    int c = 60;
    int d = 60;
    IMAIConfigParams e = new IMAIConfigParams();
    MetricConfigParams f = new MetricConfigParams();
    NativeConfigParams g = new NativeConfigParams();
    PlayableAdsConfigParams h = new PlayableAdsConfigParams();
    private UIDMapConfigParams i = new UIDMapConfigParams();

    public int getDefaultRefreshRate() {
        return this.b;
    }

    public Map<String, Boolean> getDeviceIdMaskMap() {
        return this.i.getMap();
    }

    public int getFetchTimeOut() {
        return this.c * 1000;
    }

    public IMAIConfigParams getImai() {
        return this.e;
    }

    public MetricConfigParams getMetric() {
        return this.f;
    }

    public int getMinimumRefreshRate() {
        return this.a;
    }

    public NativeConfigParams getNativeSdkConfigParams() {
        return this.g;
    }

    public PlayableAdsConfigParams getPlayableConfigParams() {
        return this.h;
    }

    public int getRenderTimeOut() {
        return this.d * 1000;
    }

    public void setFromMap(Map<String, Object> paramMap) {
        this.a = InternalSDKUtil.getIntFromMap(paramMap, "mrr", 1, 2147483647L);
        this.b = InternalSDKUtil.getIntFromMap(paramMap, "drr", -1, 2147483647L);
        this.c = InternalSDKUtil.getIntFromMap(paramMap, "fto", 1, 2147483647L);
        this.d = InternalSDKUtil.getIntFromMap(paramMap, "rto", 1, 2147483647L);
        this.e.setFromMap((Map) paramMap.get("imai"));
        this.f.setFromMap((Map) paramMap.get("metric"));
        this.i.setMap(InternalSDKUtil.getObjectFromMap(paramMap, "ids"));
        this.g.setFromMap((Map) paramMap.get("native"));
        this.h.setFromMap((Map) paramMap.get("playable"));
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/monetization/internal/configs/ConfigParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */