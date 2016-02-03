package com.flurry.sdk;

import com.flurry.android.AdCreative;
import com.flurry.android.impl.ads.avro.protocol.v10.AdFrame;
import com.flurry.android.impl.ads.avro.protocol.v10.AdSpaceLayout;
import com.flurry.android.impl.ads.avro.protocol.v10.AdUnit;
import com.flurry.android.impl.ads.avro.protocol.v10.ScreenOrientationType;

import java.util.List;

public final class cc {
    public static AdCreative a(AdSpaceLayout paramAdSpaceLayout) {
        if (paramAdSpaceLayout == null) {
            return null;
        }
        return new AdCreative(paramAdSpaceLayout.c().intValue(), paramAdSpaceLayout.b().intValue(), paramAdSpaceLayout.e().toString(), paramAdSpaceLayout.d().toString(), paramAdSpaceLayout.f().toString());
    }

    public static AdCreative a(AdUnit paramAdUnit) {
        if (paramAdUnit == null) {
            return null;
        }
        paramAdUnit = paramAdUnit.d();
        if ((paramAdUnit == null) || (paramAdUnit.isEmpty())) {
            return null;
        }
        paramAdUnit = (AdFrame) paramAdUnit.get(0);
        if (paramAdUnit == null) {
            return null;
        }
        paramAdUnit = paramAdUnit.e();
        if (paramAdUnit == null) {
            return null;
        }
        return a(paramAdUnit);
    }

    public static ScreenOrientationType a() {
        int i = fc.i();
        if (i == 1) {
            return ScreenOrientationType.a;
        }
        if (i == 2) {
            return ScreenOrientationType.b;
        }
        return ScreenOrientationType.c;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/cc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */