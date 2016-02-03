package com.flurry.sdk;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.flurry.android.impl.ads.FlurryAdModule;
import com.flurry.android.impl.ads.avro.protocol.v10.AdUnit;
import com.millennialmedia.android.MMAd;
import com.millennialmedia.android.MMException;
import com.millennialmedia.android.MMInterstitial;
import com.millennialmedia.android.RequestListener;

import java.util.Collections;

public final class bz
        extends ba {
    private static final String b = bz.class.getSimpleName();
    private boolean c;
    private final String d;
    private MMInterstitial e;
    private RequestListener f;

    public bz(Context paramContext, FlurryAdModule paramFlurryAdModule, e parame, AdUnit paramAdUnit, Bundle paramBundle) {
        super(paramContext, paramFlurryAdModule, parame, paramAdUnit);
        this.d = paramBundle.getString("com.flurry.millennial.MYAPIDINTERSTITIAL");
    }

    public void a() {
        this.e = new MMInterstitial((Activity) b());
        this.e.setApid(this.d);
        this.f = new a(null);
        this.e.setListener(this.f);
        this.e.fetch();
        this.c = this.e.display();
        if (this.c) {
            eo.a(3, b, "Millennial MMAdView Interstitial ad displayed immediately:" + System.currentTimeMillis() + " " + this.c);
            return;
        }
        eo.a(3, b, "Millennial MMAdView Interstitial ad did not display immediately:" + System.currentTimeMillis() + " " + this.c);
    }

    final class a
            implements RequestListener {
        private a() {
        }

        public void MMAdOverlayClosed(MMAd paramMMAd) {
            bz.this.c(Collections.emptyMap());
            eo.a(3, bz.f(), "Millennial MMAdView Interstitial overlay closed.");
        }

        public void MMAdOverlayLaunched(MMAd paramMMAd) {
            bz.this.a(Collections.emptyMap());
            eo.a(3, bz.f(), "Millennial MMAdView Interstitial overlay launched." + System.currentTimeMillis());
        }

        public void MMAdRequestIsCaching(MMAd paramMMAd) {
            eo.a(3, bz.f(), "Millennial MMAdView Interstitial request is caching.");
        }

        public void onSingleTap(MMAd paramMMAd) {
            bz.this.b(Collections.emptyMap());
            eo.a(3, bz.f(), "Millennial MMAdView Interstitial tapped.");
        }

        public void requestCompleted(MMAd paramMMAd) {
            eo.a(3, bz.f(), "Millennial MMAdView returned interstitial ad: " + System.currentTimeMillis());
            if (!bz.a(bz.this)) {
                bz.b(bz.this).display();
            }
        }

        public void requestFailed(MMAd paramMMAd, MMException paramMMException) {
            bz.this.d(Collections.emptyMap());
            eo.a(3, bz.f(), "Millennial MMAdView Interstitial failed to load ad.");
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/bz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */