package com.facebook.ads;

import com.facebook.ads.internal.AdRequestController;
import com.facebook.ads.internal.HtmlAdHandler.ImpressionHelper;

class AdView$1
        implements HtmlAdHandler.ImpressionHelper {
    AdView$1(AdView paramAdView) {
    }

    public void afterImpressionSent() {
        if (AdView.access$200(this.this$0) != null) {
            AdView.access$200(this.this$0).scheduleRefresh("on imp sent");
        }
    }

    public boolean shouldSendImpression() {
        return AdView.access$100(this.this$0);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/ads/AdView$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */