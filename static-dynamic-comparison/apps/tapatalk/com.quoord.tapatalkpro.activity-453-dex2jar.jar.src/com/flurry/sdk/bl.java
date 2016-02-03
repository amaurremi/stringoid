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

public final class bl
        implements ak {
    private static final String a = bl.class.getSimpleName();
    private static final Map<String, ak> b = a();

    private static ak a(String paramString) {
        return (ak) b.get(paramString);
    }

    private static Map<String, ak> a() {
        HashMap localHashMap = new HashMap();
        localHashMap.put("AdMob".toUpperCase(Locale.US), new bq());
        localHashMap.put("Millennial Media".toUpperCase(Locale.US), new bw());
        localHashMap.put("InMobi".toUpperCase(Locale.US), new bs());
        localHashMap.put("Facebook Audience Network".toUpperCase(Locale.US), new bn());
        return Collections.unmodifiableMap(localHashMap);
    }

    public aj a_(Context paramContext, FlurryAdModule paramFlurryAdModule, e parame, AdUnit paramAdUnit) {
        if ((paramContext == null) || (paramFlurryAdModule == null) || (parame == null) || (paramAdUnit == null)) {
            paramContext = null;
        }
        Object localObject;
        do {
            return paramContext;
            localObject = paramAdUnit.d();
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
            ak localak = a(((String) localObject).toUpperCase(Locale.US));
            if (localak == null) {
                return null;
            }
            eo.a(3, a, "Creating ad network takeover launcher: " + localak.getClass().getSimpleName() + " for type: " + (String) localObject);
            paramFlurryAdModule = localak.a_(paramContext, paramFlurryAdModule, parame, paramAdUnit);
            paramContext = paramFlurryAdModule;
        } while (paramFlurryAdModule != null);
        eo.b(a, "Cannot create ad network takeover launcher for type: " + (String) localObject);
        return paramFlurryAdModule;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/bl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */