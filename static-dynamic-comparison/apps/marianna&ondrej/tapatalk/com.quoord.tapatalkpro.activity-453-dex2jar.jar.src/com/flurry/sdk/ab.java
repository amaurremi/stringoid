package com.flurry.sdk;

import android.content.Context;
import android.content.Intent;
import com.flurry.android.FlurryFullscreenTakeoverActivity;
import com.flurry.android.impl.ads.FlurryAdModule;
import com.flurry.android.impl.ads.avro.protocol.v10.AdUnit;

public final class ab
        extends aj {
    public ab(Context paramContext, FlurryAdModule paramFlurryAdModule, e parame, AdUnit paramAdUnit) {
        super(paramContext, paramFlurryAdModule, parame, paramAdUnit);
    }

    public void a() {
        Intent localIntent = new Intent( do.a().b(), FlurryFullscreenTakeoverActivity.class);
        if (!c().a().a(b(), localIntent, e().b().toString())) {
            eo.b(a, "Unable to launch FlurryFullscreenTakeoverActivity. Fix by declaring this Activity in your AndroidManifest.xml");
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */