package com.inmobi.monetization.internal.configs;

import android.content.Context;
import com.inmobi.commons.InMobi;
import com.inmobi.commons.cache.CacheController;
import com.inmobi.commons.cache.CacheController.Validator;
import com.inmobi.commons.cache.ProductConfig;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.metric.Logger;
import com.inmobi.commons.uid.UID;

import java.util.HashMap;
import java.util.Map;

public class Initializer {
    public static final String PRODUCT_ADNETWORK = "adNetwork";
    private static Context a = null;
    private static Map<String, String> b = new HashMap();
    private static Logger c = new Logger(1, "network");
    private static ConfigParams d = new ConfigParams();
    private static CacheController.Validator e = new b();

    private static void a(Context paramContext) {
        if ((paramContext != null) && (a == null)) {
            if (a == null) {
            }
        }
        while ((a != null) || (paramContext != null)) {
            return;
            a = paramContext.getApplicationContext();
            b = getUidMap(paramContext);
            try {
                b(CacheController.getConfig("adNetwork", paramContext, b, e).getData());
                return;
            } catch (Exception paramContext) {
                return;
            }
        }
        throw new NullPointerException();
    }

    private static void b(Context paramContext) {
        a(paramContext);
        try {
            CacheController.getConfig("adNetwork", paramContext, b, e);
            return;
        } catch (Exception paramContext) {
        }
    }

    private static boolean b(Map<String, Object> paramMap) {
        b = getUidMap(a);
        try {
            paramMap = InternalSDKUtil.populateToNewMap((Map) paramMap.get("AND"), (Map) paramMap.get("common"), true);
            ConfigParams localConfigParams = new ConfigParams();
            localConfigParams.setFromMap(paramMap);
            d = localConfigParams;
            c.setMetricConfigParams(localConfigParams.getMetric());
            return true;
        } catch (Exception paramMap) {
            Log.internal("[InMobi]-[Monetization]", "Config couldn't be parsed", paramMap);
        }
        return false;
    }

    public static ConfigParams getConfigParams() {
        if ((InternalSDKUtil.getContext() != null) && (InMobi.getAppId() != null)) {
            b(InternalSDKUtil.getContext());
        }
        return d;
    }

    public static Logger getLogger() {
        return c;
    }

    public static Map<String, String> getUidMap(Context paramContext) {
        return UID.getInstance().getMapForEncryption(d.getDeviceIdMaskMap());
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/monetization/internal/configs/Initializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */