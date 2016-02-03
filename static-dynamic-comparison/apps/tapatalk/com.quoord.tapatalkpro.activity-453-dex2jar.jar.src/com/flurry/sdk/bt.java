package com.flurry.sdk;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.LinearLayout.LayoutParams;
import com.flurry.android.AdCreative;
import com.flurry.android.AdNetworkView;
import com.flurry.android.impl.ads.FlurryAdModule;
import com.inmobi.commons.InMobi;
import com.inmobi.monetization.IMBanner;
import com.inmobi.monetization.IMBannerListener;
import com.inmobi.monetization.IMErrorCode;

import java.util.Collections;
import java.util.Map;

public final class bt
        extends AdNetworkView {
    private static final String a = bt.class.getSimpleName();
    private final String b;
    private IMBanner c;
    private IMBannerListener d;

    bt(Context paramContext, FlurryAdModule paramFlurryAdModule, e parame, AdCreative paramAdCreative, Bundle paramBundle) {
        super(paramContext, paramFlurryAdModule, parame, paramAdCreative);
        this.b = paramBundle.getString("com.flurry.inmobi.MY_APP_ID");
        InMobi.initialize((Activity) getContext(), this.b);
        setFocusable(true);
    }

    IMBannerListener getAdListener() {
        return this.d;
    }

    IMBanner getAdView() {
        return this.c;
    }

    public void initLayout() {
        eo.a(3, a, "InMobi initLayout");
        int k = getAdCreative().getWidth();
        int m = getAdCreative().getHeight();
        int n = fc.h();
        int j = fc.g();
        int i = j;
        if (k > 0) {
            if (k > j) {
                i = j;
            }
        } else {
            j = n;
            if (m > 0) {
                if (m <= n) {
                    break label280;
                }
            }
        }
        label280:
        for (j = n; ; j = m) {
            n = bu.a(new Point(i, j));
            if (-1 == n) {
                break label286;
            }
            this.c = new IMBanner((Activity) getContext(), this.b, n);
            j = 320;
            i = 50;
            Point localPoint = bu.a(n);
            if (localPoint != null) {
                j = localPoint.x;
                i = localPoint.y;
            }
            eo.a(3, a, "Determined InMobi AdSize as " + j + "x" + i);
            float f = fc.c().density;
            j = (int) (j * f + 0.5F);
            i = (int) (i * f + 0.5F);
            this.c.setLayoutParams(new LinearLayout.LayoutParams(j, i));
            this.d = new a(null);
            this.c.setIMBannerListener(this.d);
            setGravity(17);
            addView(this.c);
            this.c.setRefreshInterval(-1);
            this.c.loadBanner();
            return;
            i = k;
            break;
        }
        label286:
        eo.a(3, a, "Could not find InMobi AdSize that matches size " + k + "x" + m);
        eo.a(3, a, "Could not load InMobi Ad");
    }

    public void onDestroy() {
        eo.a(3, a, "InMobi onDestroy");
        if (this.c != null) {
            this.c.destroy();
            this.c = null;
        }
        super.onDestroy();
    }

    final class a
            implements IMBannerListener {
        private a() {
        }

        public void onBannerInteraction(IMBanner paramIMBanner, Map<String, String> paramMap) {
            bt.this.onAdClicked(Collections.emptyMap());
            eo.a(3, bt.a(), "InMobi onBannerInteraction");
        }

        public void onBannerRequestFailed(IMBanner paramIMBanner, IMErrorCode paramIMErrorCode) {
            bt.this.onRenderFailed(Collections.emptyMap());
            eo.a(3, bt.a(), "InMobi imAdView ad request failed. " + paramIMErrorCode.toString());
        }

        public void onBannerRequestSucceeded(IMBanner paramIMBanner) {
            bt.this.onAdShown(Collections.emptyMap());
            eo.a(3, bt.a(), "InMobi imAdView ad request completed.");
        }

        public void onDismissBannerScreen(IMBanner paramIMBanner) {
            bt.this.onAdClosed(Collections.emptyMap());
            eo.a(3, bt.a(), "InMobi imAdView dismiss ad.");
        }

        public void onLeaveApplication(IMBanner paramIMBanner) {
            eo.a(3, bt.a(), "InMobi onLeaveApplication");
        }

        public void onShowBannerScreen(IMBanner paramIMBanner) {
            bt.this.onAdClicked(Collections.emptyMap());
            eo.a(3, bt.a(), "InMobi imAdView ad shown.");
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/bt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */