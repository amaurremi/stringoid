package com.inmobi.monetization;

import com.inmobi.commons.internal.Log;
import com.inmobi.monetization.internal.AdErrorCode;

import java.util.Map;

class IMBanner$a
        implements Runnable {
    IMBanner$a(IMBanner paramIMBanner, int paramInt, AdErrorCode paramAdErrorCode, Map paramMap) {
    }

    public void run() {
        for (; ; ) {
            try {
                switch (this.a) {
                    case 100:
                        Log.debug("[InMobi]-[Monetization]", this.b.toString());
                        return;
                }
            } catch (Exception localException) {
                Log.debug("[InMobi]-[Monetization]", "Exception giving callback to the publisher ", localException);
                return;
            }
            IMBanner.a(this.d).onBannerRequestSucceeded(this.d);
            return;
            IMBanner.a(this.d).onBannerRequestFailed(this.d, IMErrorCode.a(this.b));
            return;
            IMBanner.a(this.d).onDismissBannerScreen(this.d);
            return;
            IMBanner.a(this.d).onShowBannerScreen(this.d);
            return;
            IMBanner.a(this.d).onLeaveApplication(this.d);
            return;
            IMBanner.a(this.d).onBannerInteraction(this.d, this.c);
            return;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/monetization/IMBanner$a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */