package com.flurry.sdk;

import android.content.Context;
import android.view.ViewGroup;
import com.flurry.android.impl.ads.FlurryAdModule;
import com.flurry.android.impl.ads.avro.protocol.v10.AdUnit;

public abstract class ah {
    private final FlurryAdModule a;
    private final AdUnit b;
    private final e c;
    private final String d;

    public ah(FlurryAdModule paramFlurryAdModule, AdUnit paramAdUnit, e parame) {
        this.a = paramFlurryAdModule;
        this.b = paramAdUnit;
        this.c = parame;
        if (paramAdUnit != null) {
        }
        for (paramFlurryAdModule = paramAdUnit.b().toString(); ; paramFlurryAdModule = null) {
            this.d = paramFlurryAdModule;
            return;
        }
    }

    public abstract void a(Context paramContext, ViewGroup paramViewGroup);

    public FlurryAdModule b() {
        return this.a;
    }

    public AdUnit c() {
        return this.b;
    }

    public e d() {
        return this.c;
    }

    public String e() {
        return this.d;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */