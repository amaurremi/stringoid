package com.flurry.sdk;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.flurry.android.impl.ads.FlurryAdModule;
import com.flurry.android.impl.ads.avro.protocol.v10.AdUnit;
import com.inmobi.commons.InMobi;
import com.inmobi.monetization.IMErrorCode;
import com.inmobi.monetization.IMInterstitial;
import com.inmobi.monetization.IMInterstitial.State;
import com.inmobi.monetization.IMInterstitialListener;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Map;

public class bv
        extends ba {
    private static final String b = bv.class.getSimpleName();
    private static final Method c = g();
    private final String d;
    private IMInterstitial e;
    private a f;

    public bv(Context paramContext, FlurryAdModule paramFlurryAdModule, e parame, AdUnit paramAdUnit, Bundle paramBundle) {
        super(paramContext, paramFlurryAdModule, parame, paramAdUnit);
        this.d = paramBundle.getString("com.flurry.inmobi.MY_APP_ID");
        InMobi.initialize((Activity) b(), this.d);
    }

    private void a(IMInterstitial paramIMInterstitial, a parama) {
        if (paramIMInterstitial == null) {
        }
        for (; ; ) {
            return;
            try {
                if (c != null) {
                    c.invoke(paramIMInterstitial, new Object[]{parama});
                    return;
                }
            } catch (Exception paramIMInterstitial) {
                eo.a(3, b, "InMobi set listener failed.");
            }
        }
    }

    private static Method g() {
        Method[] arrayOfMethod = IMInterstitial.class.getMethods();
        int j = arrayOfMethod.length;
        int i = 0;
        while (i < j) {
            Method localMethod = arrayOfMethod[i];
            String str = localMethod.getName();
            if ((str.equals("setIMInterstitialListener")) || (str.equals("setImInterstitialListener"))) {
                return localMethod;
            }
            i += 1;
        }
        return null;
    }

    public void a() {
        this.e = new IMInterstitial((Activity) b(), this.d);
        this.f = new a(null);
        a(this.e, this.f);
        this.e.loadInterstitial();
    }

    final class a
            implements IMInterstitialListener {
        private a() {
        }

        public void onDismissInterstitialScreen(IMInterstitial paramIMInterstitial) {
            bv.this.c(Collections.emptyMap());
            eo.a(3, bv.f(), "InMobi Interstitial ad dismissed.");
        }

        public void onInterstitialFailed(IMInterstitial paramIMInterstitial, IMErrorCode paramIMErrorCode) {
            bv.this.d(Collections.emptyMap());
            eo.a(3, bv.f(), "InMobi imAdView ad request failed. ErrorCode  = " + paramIMErrorCode.toString());
        }

        public void onInterstitialInteraction(IMInterstitial paramIMInterstitial, Map<String, String> paramMap) {
            bv.this.b(Collections.emptyMap());
            eo.a(3, bv.f(), "InMobi onBannerInteraction");
        }

        public void onInterstitialLoaded(IMInterstitial paramIMInterstitial) {
            eo.a(3, bv.f(), "InMobi Interstitial ad request completed.");
            if (IMInterstitial.State.READY.equals(paramIMInterstitial.getState())) {
                bv.this.a(Collections.emptyMap());
                paramIMInterstitial.show();
            }
        }

        public void onLeaveApplication(IMInterstitial paramIMInterstitial) {
            bv.this.b(Collections.emptyMap());
            eo.a(3, bv.f(), "InMobi onLeaveApplication");
        }

        public void onShowInterstitialScreen(IMInterstitial paramIMInterstitial) {
            eo.a(3, bv.f(), "InMobi Interstitial ad shown.");
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/bv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */