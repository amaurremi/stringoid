package com.inmobi.commons.analytics.bootstrapper;

import android.content.Context;
import com.inmobi.commons.InMobi;
import com.inmobi.commons.cache.CacheController;
import com.inmobi.commons.cache.CacheController.Validator;
import com.inmobi.commons.cache.ProductConfig;
import com.inmobi.commons.internal.CommonsException;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.internal.ThinICE;
import com.inmobi.commons.uid.UID;

import java.util.HashMap;
import java.util.Map;

public class AnalyticsInitializer {
    public static final String PRODUCT_ANALYTICS = "ltvp";
    private static Context a = null;
    private static Map<String, String> b = new HashMap();
    private static AnalyticsConfigParams c = new AnalyticsConfigParams();
    private static CacheController.Validator d = new a();

    private static void a(Context paramContext) {
        if ((paramContext != null) && (a == null)) {
            if (a == null) {
            }
        }
        while ((a != null) || (paramContext != null)) {
            for (; ; ) {
                return;
                a = paramContext.getApplicationContext();
                b = getUidMap(paramContext);
                try {
                    paramContext = CacheController.getConfig("ltvp", paramContext, b, d);
                    if (paramContext.getRawData() != null) {
                        b(paramContext.getData());
                        return;
                    }
                } catch (CommonsException paramContext) {
                    Log.internal("[InMobi]-[Analytics]-4.5.1", "Exception while retreiving configs due to commons Exception with code " + paramContext.getCode());
                    return;
                } catch (Exception paramContext) {
                    Log.internal("[InMobi]-[Analytics]-4.5.1", "Exception while retreiving configs.", paramContext);
                    return;
                }
            }
        }
        a.getApplicationContext();
    }

    private static void b(Context paramContext) {
        a(paramContext);
        b = getUidMap(a);
        try {
            CacheController.getConfig("ltvp", paramContext, b, d);
            return;
        } catch (Exception paramContext) {
        }
    }

    private static boolean b(Map<String, Object> paramMap) {
        AnalyticsConfigParams localAnalyticsConfigParams = new AnalyticsConfigParams();
        try {
            localAnalyticsConfigParams.setFromMap((Map) paramMap.get("common"));
            c = localAnalyticsConfigParams;
            ThinICE.setConfig(localAnalyticsConfigParams.getThinIceConfig());
            return true;
        } catch (Exception paramMap) {
            Log.internal("[InMobi]-[Analytics]-4.5.1", "Exception while saving configs.", paramMap);
        }
        return false;
    }

    public static AnalyticsConfigParams getConfigParams() {
        if ((InternalSDKUtil.getContext() != null) && (InMobi.getAppId() != null)) {
            b(InternalSDKUtil.getContext());
        }
        return c;
    }

    public static AnalyticsConfigParams getRawConfigParams() {
        return c;
    }

    public static Map<String, String> getUidMap(Context paramContext) {
        return UID.getInstance().getMapForEncryption(null);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/commons/analytics/bootstrapper/AnalyticsInitializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */