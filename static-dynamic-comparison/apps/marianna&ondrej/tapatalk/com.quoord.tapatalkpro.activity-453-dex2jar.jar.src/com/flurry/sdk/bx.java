package com.flurry.sdk;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import com.flurry.android.AdCreative;
import com.flurry.android.AdNetworkView;
import com.flurry.android.impl.ads.FlurryAdModule;
import com.millennialmedia.android.MMAd;
import com.millennialmedia.android.MMAdView;
import com.millennialmedia.android.MMException;
import com.millennialmedia.android.MMSDK;
import com.millennialmedia.android.RequestListener;

import java.util.Collections;

public final class bx
        extends AdNetworkView {
    private static final String a = bx.class.getSimpleName();
    private final String b;
    private final String c;
    private MMAdView d;
    private RequestListener e;

    public bx(Context paramContext, FlurryAdModule paramFlurryAdModule, e parame, AdCreative paramAdCreative, Bundle paramBundle) {
        super(paramContext, paramFlurryAdModule, parame, paramAdCreative);
        this.b = paramBundle.getString("com.flurry.millennial.MYAPID");
        this.c = paramBundle.getString("com.flurry.millennial.MYAPIDRECTANGLE");
        setFocusable(true);
    }

    RequestListener getAdListener() {
        return this.e;
    }

    MMAdView getAdView() {
        return this.d;
    }

    public void initLayout() {
        eo.a(3, a, "Millennial initLayout");
        int j = getAdCreative().getWidth();
        int k = getAdCreative().getHeight();
        int i = by.a(new Point(j, k));
        if (-1 == i) {
            eo.a(3, a, "Could not find Millennial AdSize that matches size " + j + "x" + k);
            eo.a(3, a, "Could not load Millennial Ad");
            return;
        }
        Point localPoint = by.a(i);
        if (localPoint == null) {
            eo.a(3, a, "Could not find Millennial AdSize that matches size " + j + "x" + k);
            eo.a(3, a, "Could not load Millennial Ad");
            return;
        }
        j = localPoint.x;
        k = localPoint.y;
        eo.a(3, a, "Determined Millennial AdSize as " + j + "x" + k);
        this.d = new MMAdView((Activity) getContext());
        setId(MMSDK.getDefaultAdId());
        this.d.setApid(this.b);
        if (2 == i) {
            this.d.setApid(this.c);
        }
        this.d.setWidth(j);
        this.d.setHeight(k);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        setGravity(17);
        this.e = new a(null);
        this.d.setListener(this.e);
        addView(this.d);
        this.d.getAd();
    }

    public void onDestroy() {
        eo.a(3, a, "Millennial onDestroy");
        if (this.d != null) {
            this.d = null;
        }
        super.onDestroy();
    }

    final class a
            implements RequestListener {
        private a() {
        }

        public void MMAdOverlayClosed(MMAd paramMMAd) {
            eo.a(3, bx.a(), "Millennial MMAdView banner overlay closed.");
        }

        public void MMAdOverlayLaunched(MMAd paramMMAd) {
            eo.a(3, bx.a(), "Millennial MMAdView banner overlay launched.");
        }

        public void MMAdRequestIsCaching(MMAd paramMMAd) {
            eo.a(3, bx.a(), "Millennial MMAdView banner request is caching.");
        }

        public void onSingleTap(MMAd paramMMAd) {
            bx.this.onAdClicked(Collections.emptyMap());
            eo.a(3, bx.a(), "Millennial MMAdView banner tapped.");
        }

        public void requestCompleted(MMAd paramMMAd) {
            bx.this.onAdShown(Collections.emptyMap());
            eo.a(3, bx.a(), "Millennial MMAdView returned ad." + System.currentTimeMillis());
        }

        public void requestFailed(MMAd paramMMAd, MMException paramMMException) {
            bx.this.onRenderFailed(Collections.emptyMap());
            eo.a(3, bx.a(), "Millennial MMAdView failed to load ad with error: " + paramMMException);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/bx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */