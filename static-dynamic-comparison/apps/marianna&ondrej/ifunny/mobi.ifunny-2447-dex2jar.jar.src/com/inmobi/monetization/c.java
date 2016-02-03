package com.inmobi.monetization;

import com.inmobi.monetization.internal.AdErrorCode;
import com.inmobi.monetization.internal.IMAdListener;

import java.util.Map;

class c
        implements IMAdListener {
    c(IMBanner paramIMBanner) {
    }

    public void onAdInteraction(Map<String, String> paramMap) {
        IMBanner.a(this.a, 105, null, paramMap);
    }

    public void onAdRequestFailed(AdErrorCode paramAdErrorCode) {
        IMBanner.a(this.a, 101, paramAdErrorCode, null);
    }

    public void onAdRequestSucceeded() {
        IMBanner.a(this.a, 100, null, null);
    }

    public void onDismissAdScreen() {
        IMBanner.a(this.a, 103, null, null);
    }

    public void onIncentCompleted(Map<Object, Object> paramMap) {
    }

    public void onLeaveApplication() {
        IMBanner.a(this.a, 104, null, null);
    }

    public void onShowAdScreen() {
        IMBanner.a(this.a, 102, null, null);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/monetization/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */