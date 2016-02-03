package com.inmobi.monetization.internal;

import android.os.Handler;
import android.os.Message;
import com.inmobi.commons.internal.Log;
import com.inmobi.monetization.internal.configs.NetworkEventType;
import com.inmobi.re.container.IMWebView;

import java.lang.ref.WeakReference;

class InterstitialAd$b
        extends Handler {
    private final WeakReference<InterstitialAd> a;

    public InterstitialAd$b(InterstitialAd paramInterstitialAd) {
        this.a = new WeakReference(paramInterstitialAd);
    }

    public void handleMessage(Message paramMessage) {
        InterstitialAd localInterstitialAd = (InterstitialAd) this.a.get();
        if (localInterstitialAd != null) {
            try {
                switch (paramMessage.what) {
                    case 301:
                        InterstitialAd.b(localInterstitialAd).cancelLoad();
                        InterstitialAd.b(localInterstitialAd).stopLoading();
                        InterstitialAd.b(localInterstitialAd).deinit();
                        InterstitialAd.a(localInterstitialAd, null);
                        long l1 = System.currentTimeMillis();
                        long l2 = InterstitialAd.c(localInterstitialAd);
                        localInterstitialAd.collectMetrics(InterstitialAd.d(localInterstitialAd), l1 - l2, NetworkEventType.RENDER_TIMEOUT);
                        if (localInterstitialAd.mAdListener != null) {
                            localInterstitialAd.mAdListener.onAdRequestFailed(AdErrorCode.AD_RENDERING_TIMEOUT);
                            return;
                        }
                        break;
                }
            } catch (Exception paramMessage) {
                Log.internal("[InMobi]-[Monetization]", "Exception handling message in Interstitial", paramMessage);
                return;
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/monetization/internal/InterstitialAd$b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */