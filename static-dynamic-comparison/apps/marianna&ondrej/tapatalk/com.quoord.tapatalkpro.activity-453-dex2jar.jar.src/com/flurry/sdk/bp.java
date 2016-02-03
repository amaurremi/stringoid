package com.flurry.sdk;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RelativeLayout.LayoutParams;
import com.flurry.android.AdCreative;
import com.flurry.android.AdNetworkView;
import com.flurry.android.impl.ads.FlurryAdModule;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdRequest.Builder;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;

import java.util.Collections;

public final class bp
        extends AdNetworkView {
    private static final String a = bp.class.getSimpleName();
    private final String b;
    private final String c;
    private final boolean d;
    private AdView e;
    private AdListener f;

    public bp(Context paramContext, FlurryAdModule paramFlurryAdModule, e parame, AdCreative paramAdCreative, Bundle paramBundle) {
        super(paramContext, paramFlurryAdModule, parame, paramAdCreative);
        this.b = paramBundle.getString("com.flurry.gms.ads.MY_AD_UNIT_ID");
        this.c = paramBundle.getString("com.flurry.gms.ads.MYTEST_AD_DEVICE_ID");
        this.d = paramBundle.getBoolean("com.flurry.gms.ads.test");
        setFocusable(true);
    }

    private AdSize a(int paramInt1, int paramInt2) {
        if ((paramInt1 >= 728) && (paramInt2 >= 90)) {
            return AdSize.LEADERBOARD;
        }
        if ((paramInt1 >= 468) && (paramInt2 >= 60)) {
            return AdSize.FULL_BANNER;
        }
        if ((paramInt1 >= 320) && (paramInt2 >= 50)) {
            return AdSize.BANNER;
        }
        if ((paramInt1 >= 300) && (paramInt2 >= 250)) {
            return AdSize.MEDIUM_RECTANGLE;
        }
        eo.a(3, a, "Could not find GMS AdSize that matches size");
        return null;
    }

    private AdSize a(Context paramContext, int paramInt1, int paramInt2) {
        int j = fc.h();
        int k = fc.g();
        int i;
        if (paramInt1 > 0) {
            i = paramInt1;
            if (paramInt1 <= k) {
            }
        } else {
            i = k;
        }
        if (paramInt2 > 0) {
            paramInt1 = paramInt2;
            if (paramInt2 <= j) {
            }
        } else {
            paramInt1 = j;
        }
        return a(i, paramInt1);
    }

    AdListener getAdListener() {
        return this.f;
    }

    AdView getAdView() {
        return this.e;
    }

    public void initLayout() {
        eo.a(4, a, "GMS AdView initLayout.");
        Object localObject = getContext();
        int i = getAdCreative().getWidth();
        int j = getAdCreative().getHeight();
        AdSize localAdSize = a((Context) localObject, i, j);
        if (localAdSize == null) {
            eo.a(6, a, "Could not find GMS AdSize that matches {width = " + i + ", height " + j + "}");
            return;
        }
        eo.a(3, a, "Determined GMS AdSize as " + localAdSize + " that best matches {width = " + i + ", height = " + j + "}");
        this.f = new a(null);
        this.e = new AdView((Context) localObject);
        this.e.setAdSize(localAdSize);
        this.e.setAdUnitId(this.b);
        this.e.setAdListener(this.f);
        setGravity(17);
        addView(this.e, new RelativeLayout.LayoutParams(localAdSize.getWidthInPixels((Context) localObject), localAdSize.getHeightInPixels((Context) localObject)));
        localObject = new AdRequest.Builder();
        if (this.d) {
            eo.a(3, a, "GMS AdView set to Test Mode.");
            ((AdRequest.Builder) localObject).addTestDevice(AdRequest.DEVICE_ID_EMULATOR);
            if (!TextUtils.isEmpty(this.c)) {
                ((AdRequest.Builder) localObject).addTestDevice(this.c);
            }
        }
        this.e.loadAd(((AdRequest.Builder) localObject).build());
    }

    public void onDestroy() {
        eo.a(4, a, "GMS AdView onDestroy.");
        if (this.e != null) {
            this.e.destroy();
            this.e = null;
        }
        super.onDestroy();
    }

    final class a
            extends AdListener {
        private a() {
        }

        public void onAdClosed() {
            bp.this.onAdClosed(Collections.emptyMap());
            eo.a(4, bp.a(), "GMS AdView onAdClosed.");
        }

        public void onAdFailedToLoad(int paramInt) {
            bp.this.onRenderFailed(Collections.emptyMap());
            eo.a(5, bp.a(), "GMS AdView onAdFailedToLoad: " + paramInt + ".");
        }

        public void onAdLeftApplication() {
            bp.this.onAdClicked(Collections.emptyMap());
            eo.a(4, bp.a(), "GMS AdView onAdLeftApplication.");
        }

        public void onAdLoaded() {
            bp.this.onAdShown(Collections.emptyMap());
            eo.a(4, bp.a(), "GMS AdView onAdLoaded.");
        }

        public void onAdOpened() {
            eo.a(4, bp.a(), "GMS AdView onAdOpened.");
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/bp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */