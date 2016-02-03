package com.flurry.sdk;

import android.content.Context;
import com.flurry.android.impl.ads.FlurryAdModule;
import com.flurry.android.impl.ads.avro.protocol.v10.AdUnit;

import java.lang.ref.WeakReference;

public abstract class aj {
    static final String a = aj.class.getSimpleName();
    private final WeakReference<Context> b;
    private final FlurryAdModule c;
    private final e d;
    private final AdUnit e;

    public aj(Context paramContext, FlurryAdModule paramFlurryAdModule, e parame, AdUnit paramAdUnit) {
        this.b = new WeakReference(paramContext);
        this.c = paramFlurryAdModule;
        this.d = parame;
        this.e = paramAdUnit;
    }

    public abstract void a();

    public Context b() {
        return (Context) this.b.get();
    }

    public FlurryAdModule c() {
        return this.c;
    }

    public e d() {
        return this.d;
    }

    public AdUnit e() {
        return this.e;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/aj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */