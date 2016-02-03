package com.flurry.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.flurry.android.impl.ads.FlurryAdModule;
import com.flurry.android.impl.ads.avro.protocol.v10.AdFrame;
import com.flurry.android.impl.ads.avro.protocol.v10.AdUnit;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public final class bk
        implements k {
    private static final String a = bk.class.getSimpleName();
    private static final Map<String, k> b = a();

    private static k a(String paramString) {
        return (k) b.get(paramString);
    }

    private static Map<String, k> a() {
        HashMap localHashMap = new HashMap();
        localHashMap.put("AdMob".toUpperCase(Locale.US), new bq());
        localHashMap.put("Millennial Media".toUpperCase(Locale.US), new bw());
        localHashMap.put("InMobi".toUpperCase(Locale.US), new bs());
        localHashMap.put("Facebook Audience Network".toUpperCase(Locale.US), new bn());
        return Collections.unmodifiableMap(localHashMap);
    }

    public i a(Context paramContext, FlurryAdModule paramFlurryAdModule, e parame, AdUnit paramAdUnit) {
        if ((paramContext == null) || (paramFlurryAdModule == null) || (parame == null) || (paramAdUnit == null)) {
            paramContext = null;
        }
        do {
            return paramContext;
            Object localObject = paramAdUnit.d();
            if ((localObject == null) || (((List) localObject).isEmpty())) {
                return null;
            }
            localObject = (AdFrame) ((List) localObject).get(0);
            if (localObject == null) {
                return null;
            }
            localObject = ((AdFrame) localObject).d().toString();
            if (TextUtils.isEmpty((CharSequence) localObject)) {
                return null;
            }
            k localk = a(((String) localObject).toUpperCase(Locale.US));
            if (localk == null) {
                return null;
            }
            eo.a(3, a, "Creating ad network view for type: " + (String) localObject);
            paramFlurryAdModule = localk.a(paramContext, paramFlurryAdModule, parame, paramAdUnit);
            if (paramFlurryAdModule == null) {
                eo.b(a, "Cannot create ad network view for type: " + (String) localObject);
                return null;
            }
            paramContext = paramFlurryAdModule;
        } while (paramFlurryAdModule == null);
        paramFlurryAdModule.setAdUnit(paramAdUnit);
        return paramFlurryAdModule;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/bk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */