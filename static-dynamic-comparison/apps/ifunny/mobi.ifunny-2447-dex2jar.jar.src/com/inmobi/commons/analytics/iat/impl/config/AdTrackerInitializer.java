package com.inmobi.commons.analytics.iat.impl.config;

import android.content.Context;
import com.inmobi.commons.InMobi;
import com.inmobi.commons.cache.CacheController;
import com.inmobi.commons.cache.CacheController.Validator;
import com.inmobi.commons.cache.ProductConfig;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.metric.Logger;
import com.inmobi.commons.uid.UID;

import java.util.Map;

public class AdTrackerInitializer {
    public static final String PRODUCT_IAT = "iat";
    private static Context a = null;
    private static Map<String, String> b;
    private static AdTrackerConfigParams c = new AdTrackerConfigParams();
    private static Logger d = new Logger(2, "iat");
    private static CacheController.Validator e = new a();

    private static void a(Context paramContext) {
        if ((paramContext != null) && (a == null)) {
            if (a == null) {
            }
        }
        while ((a != null) || (paramContext != null)) {
            return;
            a = paramContext.getApplicationContext();
            b = UID.getInstance().getMapForEncryption(getConfigParams().getDeviceIdMaskMap());
            try {
                b(CacheController.getConfig("iat", paramContext, b, e).getData());
                return;
            } catch (Exception paramContext) {
                Log.internal("[InMobi]-[AdTracker]-4.5.1", "Exception while retreiving configs.");
                return;
            }
        }
        a.getApplicationContext();
    }

    private static void b(Context paramContext) {
        a(paramContext);
        try {
            CacheController.getConfig("iat", paramContext, b, e);
            return;
        } catch (Exception paramContext) {
        }
    }

    private static boolean b(Map<String, Object> paramMap) {
        b = getUidMap(a);
        paramMap = InternalSDKUtil.populateToNewMap((Map) paramMap.get("AND"), (Map) paramMap.get("common"), true);
        try {
            AdTrackerConfigParams localAdTrackerConfigParams = new AdTrackerConfigParams();
            localAdTrackerConfigParams.setFromMap(paramMap);
            c = localAdTrackerConfigParams;
            return true;
        } catch (Exception paramMap) {
        }
        return false;
    }

    public static AdTrackerConfigParams getConfigParams() {
        if ((InternalSDKUtil.getContext() != null) && (InMobi.getAppId() != null)) {
            b(InternalSDKUtil.getContext());
        }
        d.setMetricConfigParams(c.getMetric());
        return c;
    }

    public static Logger getLogger() {
        return d;
    }

    public static Map<String, String> getUidMap(Context paramContext) {
        return UID.getInstance().getMapForEncryption(getConfigParams().getDeviceIdMaskMap());
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/commons/analytics/iat/impl/config/AdTrackerInitializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */