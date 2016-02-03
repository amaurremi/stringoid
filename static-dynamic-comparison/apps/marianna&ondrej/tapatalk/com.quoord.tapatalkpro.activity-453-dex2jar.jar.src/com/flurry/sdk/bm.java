package com.flurry.sdk;

import android.content.Context;
import android.os.Bundle;
import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdListener;
import com.facebook.ads.AdSettings;
import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;
import com.flurry.android.AdCreative;
import com.flurry.android.AdNetworkView;
import com.flurry.android.impl.ads.FlurryAdModule;

import java.util.Collections;

public class bm
        extends AdNetworkView
        implements AdListener {
    private static final String a = bm.class.getSimpleName();
    private final String b;
    private final String c;
    private final boolean d;
    private AdView e;

    public bm(Context paramContext, FlurryAdModule paramFlurryAdModule, e parame, AdCreative paramAdCreative, Bundle paramBundle) {
        super(paramContext, paramFlurryAdModule, parame, paramAdCreative);
        this.b = paramBundle.getString("com.flurry.fan.MY_APP_ID");
        this.c = paramBundle.getString("com.flurry.fan.MYTEST_AD_DEVICE_ID");
        this.d = paramBundle.getBoolean("com.flurry.fan.test");
        setFocusable(true);
    }

    public void initLayout() {
        eo.a(4, a, "FAN banner initLayout.");
        this.e = new AdView(getContext(), this.b, AdSize.BANNER_320_50);
        this.e.setAdListener(this);
        addView(this.e);
        if (this.d) {
            AdSettings.addTestDevice(this.c);
        }
        this.e.loadAd();
    }

    public void onAdClicked(Ad paramAd) {
        eo.a(4, a, "FAN banner onAdClicked.");
        onAdClicked(Collections.emptyMap());
    }

    public void onAdLoaded(Ad paramAd) {
        onAdShown(Collections.emptyMap());
        eo.a(4, a, "FAN banner onAdLoaded.");
    }

    public void onDestroy() {
        eo.a(4, a, "FAN banner onDestroy.");
        if (this.e != null) {
            this.e.destroy();
            this.e = null;
        }
        super.onDestroy();
    }

    public void onError(Ad paramAd, AdError paramAdError) {
        onRenderFailed(Collections.emptyMap());
        if (this.e != null) {
            this.e.destroy();
            this.e = null;
        }
        eo.a(6, a, "FAN banner onError.");
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/bm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */