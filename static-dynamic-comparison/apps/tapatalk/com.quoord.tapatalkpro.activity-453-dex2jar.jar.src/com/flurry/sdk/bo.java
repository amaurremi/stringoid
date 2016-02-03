package com.flurry.sdk;

import android.content.Context;
import android.os.Bundle;
import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdSettings;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.InterstitialAdListener;
import com.flurry.android.impl.ads.FlurryAdModule;
import com.flurry.android.impl.ads.avro.protocol.v10.AdUnit;

import java.util.Collections;

public class bo
        extends ba
        implements InterstitialAdListener {
    private static final String b = bo.class.getSimpleName();
    private final String c;
    private final String d;
    private final boolean e;
    private InterstitialAd f;

    public bo(Context paramContext, FlurryAdModule paramFlurryAdModule, e parame, AdUnit paramAdUnit, Bundle paramBundle) {
        super(paramContext, paramFlurryAdModule, parame, paramAdUnit);
        this.c = paramBundle.getString("com.flurry.fan.MY_APP_ID");
        this.d = paramBundle.getString("com.flurry.fan.MYTEST_AD_DEVICE_ID");
        this.e = paramBundle.getBoolean("com.flurry.fan.test");
    }

    public void a() {
        Context localContext = b();
        if (this.e) {
            AdSettings.addTestDevice(this.d);
        }
        this.f = new InterstitialAd(localContext, this.c);
        this.f.setAdListener(this);
        this.f.loadAd();
    }

    public void onAdClicked(Ad paramAd) {
        eo.a(4, b, "FAN interstitial onAdClicked.");
        b(Collections.emptyMap());
    }

    public void onAdLoaded(Ad paramAd) {
        eo.a(4, b, "FAN interstitial onAdLoaded.");
        if ((this.f != null) && (this.f.isAdLoaded())) {
            this.f.show();
        }
    }

    public void onError(Ad paramAd, AdError paramAdError) {
        eo.a(4, b, "FAN interstitial onError.");
        d(Collections.emptyMap());
        this.f.destroy();
        this.f = null;
    }

    public void onInterstitialDismissed(Ad paramAd) {
        eo.a(4, b, "FAN interstitial onInterstitialDismissed.");
        c(Collections.emptyMap());
    }

    public void onInterstitialDisplayed(Ad paramAd) {
        eo.a(4, b, "FAN interstitial onInterstitialDisplayed.");
        a(Collections.emptyMap());
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/bo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */