package com.inmobi.monetization;

import com.inmobi.commons.internal.Log;
import com.inmobi.monetization.internal.AdErrorCode;

import java.util.Map;

class IMInterstitial$a
        implements Runnable {
    IMInterstitial$a(IMInterstitial paramIMInterstitial, int paramInt, AdErrorCode paramAdErrorCode, Map paramMap) {
    }

    public void run() {
        switch (this.a) {
            default:
                Log.debug("[InMobi]-[Monetization]", this.b.toString());
        }
        do {
            return;
            IMInterstitial.a(this.d).onInterstitialLoaded(this.d);
            return;
            IMInterstitial.a(this.d).onInterstitialFailed(this.d, IMErrorCode.a(this.b));
            return;
            IMInterstitial.a(this.d).onDismissInterstitialScreen(this.d);
            return;
            IMInterstitial.a(this.d).onShowInterstitialScreen(this.d);
            return;
            IMInterstitial.a(this.d).onLeaveApplication(this.d);
            return;
            IMInterstitial.a(this.d).onInterstitialInteraction(this.d, this.c);
            return;
        } while (IMInterstitial.b(this.d) == null);
        IMInterstitial.b(this.d).onIncentCompleted(this.d, this.c);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/monetization/IMInterstitial$a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */