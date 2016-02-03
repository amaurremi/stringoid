package com.flurry.sdk;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.flurry.android.impl.ads.FlurryAdModule;
import com.flurry.android.impl.ads.avro.protocol.v10.AdUnit;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdRequest.Builder;
import com.google.android.gms.ads.InterstitialAd;

import java.util.Collections;

public final class br
        extends ba {
    private static final String b = br.class.getSimpleName();
    private final String c;
    private final String d;
    private final boolean e;
    private final InterstitialAd f;
    private final AdListener g;

    public br(Context paramContext, FlurryAdModule paramFlurryAdModule, e parame, AdUnit paramAdUnit, Bundle paramBundle) {
        super(paramContext, paramFlurryAdModule, parame, paramAdUnit);
        this.c = paramBundle.getString("com.flurry.gms.ads.MY_AD_UNIT_ID");
        this.d = paramBundle.getString("com.flurry.gms.ads.MYTEST_AD_DEVICE_ID");
        this.e = paramBundle.getBoolean("com.flurry.gms.ads.test");
        this.g = new a(null);
        this.f = new InterstitialAd(b());
        this.f.setAdUnitId(this.c);
        this.f.setAdListener(this.g);
    }

    public void a() {
        AdRequest.Builder localBuilder = new AdRequest.Builder();
        if (this.e) {
            eo.a(3, b, "GMS AdView set to Test Mode.");
            localBuilder.addTestDevice(AdRequest.DEVICE_ID_EMULATOR);
            if (!TextUtils.isEmpty(this.d)) {
                localBuilder.addTestDevice(this.d);
            }
        }
        this.f.loadAd(localBuilder.build());
    }

    final class a
            extends AdListener {
        private a() {
        }

        public void onAdClosed() {
            br.this.c(Collections.emptyMap());
            eo.a(4, br.f(), "GMS AdView onAdClosed.");
        }

        public void onAdFailedToLoad(int paramInt) {
            br.this.d(Collections.emptyMap());
            eo.a(5, br.f(), "GMS AdView onAdFailedToLoad: " + paramInt + ".");
        }

        public void onAdLeftApplication() {
            br.this.b(Collections.emptyMap());
            eo.a(4, br.f(), "GMS AdView onAdLeftApplication.");
        }

        public void onAdLoaded() {
            br.this.a(Collections.emptyMap());
            eo.a(4, br.f(), "GMS AdView onAdLoaded.");
            br.a(br.this).show();
        }

        public void onAdOpened() {
            eo.a(4, br.f(), "GMS AdView onAdOpened.");
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/br.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */