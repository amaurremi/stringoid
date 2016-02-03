package com.facebook.ads;

import com.facebook.ads.internal.AdRequest.Callback;
import com.facebook.ads.internal.AdRequestController;
import com.facebook.ads.internal.AdResponse;
import com.facebook.ads.internal.HtmlAdDataModel;
import com.facebook.ads.internal.HtmlAdHandler;

class AdView$2
        implements AdRequest.Callback {
    AdView$2(AdView paramAdView) {
    }

    public void onCompleted(AdResponse paramAdResponse) {
        AdView.access$400(this.this$0).cancelImpressionRetry();
        Object localObject = paramAdResponse.getDataModel();
        if ((localObject != null) && ((localObject instanceof HtmlAdDataModel))) {
            AdView.access$400(this.this$0).setAdDataModel((HtmlAdDataModel) localObject);
            AdView.access$600(this.this$0, (HtmlAdDataModel) localObject);
            if (AdView.access$500(this.this$0) != null) {
                AdView.access$500(this.this$0).onAdLoaded(this.this$0);
            }
        }
        label148:
        do {
            return;
            if (localObject == null) {
                AdView localAdView;
                if (AdView.access$500(this.this$0) != null) {
                    localObject = AdView.access$500(this.this$0);
                    localAdView = this.this$0;
                    if (paramAdResponse.getError() == null) {
                        break label148;
                    }
                }
                for (paramAdResponse = paramAdResponse.getError(); ; paramAdResponse = AdError.INTERNAL_ERROR) {
                    ((AdListener) localObject).onError(localAdView, paramAdResponse);
                    if (AdView.access$200(this.this$0) == null) {
                        break;
                    }
                    AdView.access$200(this.this$0).scheduleRefresh("on no fill");
                    return;
                }
            }
            if (AdView.access$500(this.this$0) != null) {
                AdView.access$500(this.this$0).onError(this.this$0, AdError.INTERNAL_ERROR);
            }
        } while (AdView.access$200(this.this$0) == null);
        AdView.access$200(this.this$0).scheduleRefresh("on internal error");
    }

    public void onError(AdError paramAdError) {
        AdView.access$400(this.this$0).cancelImpressionRetry();
        if (AdView.access$500(this.this$0) != null) {
            AdView.access$500(this.this$0).onError(this.this$0, paramAdError);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/ads/AdView$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */