package com.flurry.sdk;

import android.content.Context;
import android.view.ViewGroup;
import com.flurry.android.impl.ads.FlurryAdModule;
import com.flurry.android.impl.ads.avro.protocol.v10.AdUnit;

public final class ai
        extends ah {
    private static final String a = ai.class.getSimpleName();
    private aj b;

    public ai(FlurryAdModule paramFlurryAdModule, AdUnit paramAdUnit, e parame) {
        super(paramFlurryAdModule, paramAdUnit, parame);
    }

    public void a(Context paramContext, ViewGroup paramViewGroup) {
        if (paramContext == null) {
            eo.a(6, a, "failed to render takeover ad for adspace: " + e() + " context: " + paramContext + " viewGroup: " + paramViewGroup);
        }
        FlurryAdModule localFlurryAdModule;
        AdUnit localAdUnit;
        e locale;
        do {
            return;
            localFlurryAdModule = b();
            localAdUnit = c();
            locale = d();
            if (localAdUnit == null) {
                eo.a(6, a, "failed to render takeover ad, adUnit is null for adspace: " + e() + " context: " + paramContext + " viewGroup: " + paramViewGroup);
                return;
            }
            this.b = b().c().a_(paramContext, localFlurryAdModule, locale, localAdUnit);
        } while (this.b == null);
        localFlurryAdModule.a(localAdUnit);
        localFlurryAdModule.a(locale);
        this.b.a();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */