package com.flurry.sdk;

import android.content.Context;
import com.flurry.android.impl.ads.FlurryAdModule;
import com.flurry.android.impl.ads.avro.protocol.v10.AdFrame;
import com.flurry.android.impl.ads.avro.protocol.v10.AdUnit;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class p
        implements ak {
    static final String a = p.class.getSimpleName();
    private static final Map<String, ak> b = a();

    private static ak a(String paramString) {
        return (ak) b.get(paramString);
    }

    private static String a(AdUnit paramAdUnit) {
        if (paramAdUnit == null) {
            return null;
        }
        Object localObject = paramAdUnit.d();
        if ((localObject == null) || (((List) localObject).isEmpty())) {
            return null;
        }
        localObject = (AdFrame) ((List) localObject).get(0);
        if (localObject == null) {
            return null;
        }
        int i = ((AdFrame) localObject).b().intValue();
        if ((paramAdUnit.e().intValue() == 1) || (i == 2) || (i == 1) || (i == 3)) {
            return "FLURRY";
        }
        if (i == 4) {
            return "THIRD_PARTY";
        }
        return null;
    }

    private static Map<String, ak> a() {
        HashMap localHashMap = new HashMap();
        localHashMap.put("FLURRY", new a(null));
        localHashMap.put("THIRD_PARTY", new bl());
        return Collections.unmodifiableMap(localHashMap);
    }

    public aj a_(Context paramContext, FlurryAdModule paramFlurryAdModule, e parame, AdUnit paramAdUnit) {
        if ((paramContext == null) || (paramFlurryAdModule == null) || (parame == null) || (paramAdUnit == null)) {
        }
        String str;
        do {
            return null;
            str = a(paramAdUnit);
        } while (str == null);
        ak localak = a(str);
        if (localak == null) {
            eo.d(a, "Cannot create ad takeover for type: " + str);
            return null;
        }
        eo.a(3, a, "Creating ad takeover for type: " + str);
        return localak.a_(paramContext, paramFlurryAdModule, parame, paramAdUnit);
    }

    static final class a
            implements ak {
        public aj a_(Context paramContext, FlurryAdModule paramFlurryAdModule, e parame, AdUnit paramAdUnit) {
            return new ab(paramContext, paramFlurryAdModule, parame, paramAdUnit);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */