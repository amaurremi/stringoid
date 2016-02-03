package com.facebook.ads.internal;

import com.facebook.ads.AdError;

class AdRequestController$2
        implements AdRequest.Callback {
    AdRequestController$2(AdRequestController paramAdRequestController) {
    }

    public void onCompleted(AdResponse paramAdResponse) {
        AdRequestController.access$402(this.this$0, paramAdResponse.getRefreshIntervalMillis());
        AdRequestController.access$502(this.this$0, paramAdResponse.getRefreshThresholdMillis());
        AdRequestController.access$200(this.this$0).onCompleted(paramAdResponse);
        AdRequestController.access$302(this.this$0, true);
    }

    public void onError(AdError paramAdError) {
        AdRequestController.access$200(this.this$0).onError(paramAdError);
        AdRequestController.access$302(this.this$0, true);
        this.this$0.scheduleRefresh("onError");
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/ads/internal/AdRequestController$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */