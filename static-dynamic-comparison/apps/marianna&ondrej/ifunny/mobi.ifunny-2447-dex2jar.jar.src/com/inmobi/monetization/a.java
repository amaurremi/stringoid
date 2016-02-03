package com.inmobi.monetization;

import com.inmobi.monetization.internal.AdErrorCode;
import com.inmobi.monetization.internal.IMAdListener;

import java.util.Map;

class a
        implements IMAdListener {
    a(IMInterstitial paramIMInterstitial) {
    }

    public void onAdInteraction(Map<String, String> paramMap) {
        IMInterstitial.a(this.a, 105, null, paramMap);
    }

    public void onAdRequestFailed(AdErrorCode paramAdErrorCode) {
        IMInterstitial.a(this.a, IMInterstitial.State.INIT);
        IMInterstitial.a(this.a, 101, paramAdErrorCode, null);
    }

    public void onAdRequestSucceeded() {
        IMInterstitial.a(this.a, IMInterstitial.State.READY);
        IMInterstitial.a(this.a, 100, null, null);
    }

    public void onDismissAdScreen() {
        IMInterstitial.a(this.a, IMInterstitial.State.INIT);
        IMInterstitial.a(this.a, 103, null, null);
    }

    public void onIncentCompleted(Map<Object, Object> paramMap) {
        IMInterstitial.a(this.a, 106, null, paramMap);
    }

    public void onLeaveApplication() {
        IMInterstitial.a(this.a, 104, null, null);
    }

    public void onShowAdScreen() {
        IMInterstitial.a(this.a, IMInterstitial.State.ACTIVE);
        IMInterstitial.a(this.a, 102, null, null);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/monetization/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */