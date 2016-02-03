package com.inmobi.monetization.internal;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import com.inmobi.commons.internal.Log;
import com.inmobi.monetization.internal.configs.NetworkEventType;
import com.inmobi.re.container.IMWebView;
import com.inmobi.re.container.mraidimpl.MRAIDInterstitialController;

import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;

class BannerAd$b
        extends Handler {
    private final WeakReference<BannerAd> a;

    public BannerAd$b(BannerAd paramBannerAd) {
        this.a = new WeakReference(paramBannerAd);
    }

    public void handleMessage(Message paramMessage) {
        BannerAd localBannerAd = (BannerAd) this.a.get();
        if (localBannerAd != null) {
        }
        for (; ; ) {
            try {
                int i = paramMessage.what;
                switch (i) {
                }
            } catch (Exception localException) {
                long l1;
                long l2;
                Log.internal("[InMobi]-[Monetization]", "Exception hanlde message adview", localException);
                continue;
                BannerAd.b(localException, null);
                continue;
                if (BannerAd.f(localException).hasWindowFocus()) {
                    continue;
                }
                Log.debug("[InMobi]-[Monetization]", "Activity is not in the foreground. New ad will not be loaded.");
                continue;
                if (!MRAIDInterstitialController.isInterstitialDisplayed.get()) {
                    continue;
                }
                Log.debug("[InMobi]-[Monetization]", "Ad cannot be loaded.Interstitial Ad is displayed.");
                continue;
                BannerAd.a(localException, true);
                continue;
            }
            super.handleMessage(paramMessage);
            return;
            l1 = System.currentTimeMillis();
            l2 = BannerAd.c(localBannerAd);
            localBannerAd.collectMetrics(BannerAd.d(localBannerAd), l1 - l2, NetworkEventType.RENDER_TIMEOUT);
            if (!BannerAd.e(localBannerAd)) {
                continue;
            }
            BannerAd.a(localBannerAd, null);
            if (localBannerAd.mCurrentWebView != null) {
                localBannerAd.mCurrentWebView.cancelLoad();
                localBannerAd.mCurrentWebView.stopLoading();
                localBannerAd.mCurrentWebView.deinit();
                localBannerAd.mCurrentWebView = null;
            }
            if (localBannerAd.mAdListener != null) {
                localBannerAd.mAdListener.onAdRequestFailed(AdErrorCode.AD_RENDERING_TIMEOUT);
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/monetization/internal/BannerAd$b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */