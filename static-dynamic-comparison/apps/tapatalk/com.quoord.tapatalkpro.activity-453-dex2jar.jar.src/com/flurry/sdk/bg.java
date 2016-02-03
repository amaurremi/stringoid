package com.flurry.sdk;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import com.flurry.android.AdCreative;
import com.flurry.android.impl.ads.FlurryAdModule;
import com.flurry.android.impl.ads.avro.protocol.v10.AdUnit;

import java.util.Collections;
import java.util.List;

public abstract class bg
        implements ak, k {
    protected abstract aj a(Context paramContext, FlurryAdModule paramFlurryAdModule, e parame, AdUnit paramAdUnit, Bundle paramBundle);

    protected bf a() {
        return c();
    }

    protected abstract i a(Context paramContext, FlurryAdModule paramFlurryAdModule, e parame, AdCreative paramAdCreative, Bundle paramBundle);

    public i a(Context paramContext, FlurryAdModule paramFlurryAdModule, e parame, AdUnit paramAdUnit) {
        if ((paramContext == null) || (paramFlurryAdModule == null) || (parame == null) || (paramAdUnit == null)) {
        }
        Bundle localBundle;
        do {
            do {
                do {
                    return null;
                } while (!b(paramContext, e()));
                localBundle = c(paramContext, paramFlurryAdModule, parame, paramAdUnit);
            } while (localBundle == null);
            paramAdUnit = cc.a(paramAdUnit);
        } while (paramAdUnit == null);
        return a(paramContext, paramFlurryAdModule, parame, paramAdUnit, localBundle);
    }

    protected boolean a(Context paramContext, bj parambj) {
        if ((paramContext == null) || (parambj == null)) {
        }
        bf localbf;
        do {
            return false;
            localbf = a();
        } while (localbf == null);
        return localbf.a(paramContext, parambj);
    }

    public aj a_(Context paramContext, FlurryAdModule paramFlurryAdModule, e parame, AdUnit paramAdUnit) {
        if ((paramContext == null) || (paramFlurryAdModule == null) || (parame == null) || (paramAdUnit == null)) {
        }
        Bundle localBundle;
        do {
            do {
                return null;
            } while (!a(paramContext, d()));
            localBundle = b(paramContext, paramFlurryAdModule, parame, paramAdUnit);
        } while (localBundle == null);
        return a(paramContext, paramFlurryAdModule, parame, paramAdUnit, localBundle);
    }

    protected Bundle b(Context paramContext, FlurryAdModule paramFlurryAdModule, e parame, AdUnit paramAdUnit) {
        return d(paramContext, paramFlurryAdModule, parame, paramAdUnit);
    }

    protected bf b() {
        return c();
    }

    protected boolean b(Context paramContext, bj parambj) {
        if ((paramContext == null) || (parambj == null)) {
        }
        bf localbf;
        do {
            return false;
            localbf = b();
        } while (localbf == null);
        return localbf.a(paramContext, parambj);
    }

    protected Bundle c(Context paramContext, FlurryAdModule paramFlurryAdModule, e parame, AdUnit paramAdUnit) {
        return d(paramContext, paramFlurryAdModule, parame, paramAdUnit);
    }

    protected bf c() {
        return new be();
    }

    protected Bundle d(Context paramContext, FlurryAdModule paramFlurryAdModule, e parame, AdUnit paramAdUnit) {
        return dx.d(paramContext);
    }

    protected bj d() {
        return new bj(f(), g(), h(), i(), j());
    }

    protected bj e() {
        return new bj(f(), k(), l(), m(), Collections.emptyList());
    }

    protected abstract String f();

    protected abstract List<bc> g();

    protected List<String> h() {
        return n();
    }

    protected List<String> i() {
        return o();
    }

    protected abstract List<ActivityInfo> j();

    protected abstract List<bc> k();

    protected List<String> l() {
        return n();
    }

    protected List<String> m() {
        return o();
    }

    protected abstract List<String> n();

    protected abstract List<String> o();
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/bg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */