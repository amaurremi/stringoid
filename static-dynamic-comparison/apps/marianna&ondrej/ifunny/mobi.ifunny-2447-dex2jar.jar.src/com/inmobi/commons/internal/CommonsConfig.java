package com.inmobi.commons.internal;

import com.inmobi.commons.metric.MetricConfigParams;
import com.inmobi.commons.uid.UID;
import com.inmobi.commons.uid.UIDMapConfigParams;

import java.util.Map;

public class CommonsConfig {
    private static Log.INTERNAL_LOG_LEVEL a = Log.INTERNAL_LOG_LEVEL.NONE;
    private static Log.INTERNAL_LOG_LEVEL b = a;
    private MetricConfigParams c = new MetricConfigParams();

    protected static int getLogLevelConfig() {
        return b.getValue();
    }

    public MetricConfigParams getApiStatsConfig() {
        return this.c;
    }

    public final void setFromMap(Map<String, Object> paramMap) {
        paramMap = InternalSDKUtil.populateToNewMap((Map) paramMap.get("AND"), (Map) paramMap.get("common"), true);
        UIDMapConfigParams localUIDMapConfigParams = new UIDMapConfigParams();
        localUIDMapConfigParams.setMap(InternalSDKUtil.getObjectFromMap(paramMap, "ids"));
        UID.getInstance().setCommonsDeviceIdMaskMap(localUIDMapConfigParams.getMap());
        b = Log.getLogLevelValue(InternalSDKUtil.getIntFromMap(paramMap, "ll", 0, 2L));
        this.c.setFromMap((Map) paramMap.get("api"));
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/commons/internal/CommonsConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */