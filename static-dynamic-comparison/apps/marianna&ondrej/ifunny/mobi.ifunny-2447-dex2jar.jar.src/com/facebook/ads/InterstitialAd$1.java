package com.facebook.ads;

import com.facebook.ads.internal.AdRequest.Callback;
import com.facebook.ads.internal.AdResponse;
import com.facebook.ads.internal.HtmlAdDataModel;

class InterstitialAd$1
        implements AdRequest.Callback {
    InterstitialAd$1(InterstitialAd paramInterstitialAd) {
    }

    public void onCompleted(AdResponse paramAdResponse) {
        InterstitialAd.access$002(this.this$0, paramAdResponse);
        if ((paramAdResponse.getDataModel() != null) && ((paramAdResponse.getDataModel() instanceof HtmlAdDataModel))) {
            InterstitialAd.access$102(this.this$0, true);
            if (InterstitialAd.access$200(this.this$0) != null) {
                InterstitialAd.access$200(this.this$0).onAdLoaded(this.this$0);
            }
        }
        do {
            do {
                return;
                if (paramAdResponse.getDataModel() != null) {
                    break;
                }
                InterstitialAd.access$102(this.this$0, false);
            } while (InterstitialAd.access$200(this.this$0) == null);
            InterstitialAdListener localInterstitialAdListener = InterstitialAd.access$200(this.this$0);
            InterstitialAd localInterstitialAd = this.this$0;
            if (paramAdResponse.getError() != null) {
            }
            for (paramAdResponse = paramAdResponse.getError(); ; paramAdResponse = AdError.INTERNAL_ERROR) {
                localInterstitialAdListener.onError(localInterstitialAd, paramAdResponse);
                return;
            }
            InterstitialAd.access$102(this.this$0, false);
        } while (InterstitialAd.access$200(this.this$0) == null);
        InterstitialAd.access$200(this.this$0).onError(this.this$0, AdError.INTERNAL_ERROR);
    }

    public void onError(AdError paramAdError) {
        InterstitialAd.access$102(this.this$0, false);
        if (InterstitialAd.access$200(this.this$0) != null) {
            InterstitialAd.access$200(this.this$0).onError(this.this$0, paramAdError);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/ads/InterstitialAd$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */