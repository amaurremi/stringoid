package com.flurry.sdk;

import android.content.Context;
import com.flurry.android.impl.ads.FlurryAdModule;
import com.flurry.android.impl.ads.avro.protocol.v10.AdFrame;
import com.flurry.android.impl.ads.avro.protocol.v10.AdUnit;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class o
        implements k {
    static final String a = o.class.getSimpleName();
    private static final Map<String, k> b = a();

    private static k a(String paramString) {
        return (k) b.get(paramString);
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

    private static Map<String, k> a() {
        HashMap localHashMap = new HashMap();
        localHashMap.put("FLURRY", new a(null));
        localHashMap.put("THIRD_PARTY", new bk());
        return Collections.unmodifiableMap(localHashMap);
    }

    public i a(Context paramContext, FlurryAdModule paramFlurryAdModule, e parame, AdUnit paramAdUnit) {
        if ((paramContext == null) || (paramFlurryAdModule == null) || (parame == null) || (paramAdUnit == null)) {
        }
        String str;
        do {
            return null;
            str = a(paramAdUnit);
        } while (str == null);
        k localk = a(str);
        if (localk == null) {
            eo.d(a, "Cannot create ad banner for type: " + str);
            return null;
        }
        eo.a(3, a, "Creating ad banner for type: " + str);
        return localk.a(paramContext, paramFlurryAdModule, parame, paramAdUnit);
    }

    static final class a
            implements k {
        public i a(Context paramContext, FlurryAdModule paramFlurryAdModule, e parame, AdUnit paramAdUnit) {
            return new g(paramContext, paramFlurryAdModule, parame, paramAdUnit, 0);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */