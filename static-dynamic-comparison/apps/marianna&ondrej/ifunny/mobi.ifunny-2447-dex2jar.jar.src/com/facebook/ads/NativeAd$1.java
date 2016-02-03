package com.facebook.ads;

import com.facebook.ads.internal.AdRequest.Callback;
import com.facebook.ads.internal.AdResponse;
import com.facebook.ads.internal.NativeAdDataModel;

class NativeAd$1
        implements AdRequest.Callback {
    NativeAd$1(NativeAd paramNativeAd) {
    }

    public void onCompleted(AdResponse paramAdResponse) {
        if ((!(paramAdResponse.getDataModel() instanceof NativeAdDataModel)) && (NativeAd.access$000(this.this$0) != null)) {
            NativeAd.access$000(this.this$0).onError(this.this$0, AdError.INTERNAL_ERROR);
        }
        NativeAd.access$102(this.this$0, (NativeAdDataModel) paramAdResponse.getDataModel());
        if ((NativeAd.access$100(this.this$0) != null) && (NativeAd.access$100(this.this$0).isValid())) {
            NativeAd.access$202(this.this$0, true);
            if (NativeAd.access$000(this.this$0) != null) {
                NativeAd.access$000(this.this$0).onAdLoaded(this.this$0);
            }
        }
        do {
            do {
                return;
                if (NativeAd.access$100(this.this$0) != null) {
                    break;
                }
                NativeAd.access$202(this.this$0, false);
            } while (NativeAd.access$000(this.this$0) == null);
            AdListener localAdListener = NativeAd.access$000(this.this$0);
            NativeAd localNativeAd = this.this$0;
            if (paramAdResponse.getError() != null) {
            }
            for (paramAdResponse = paramAdResponse.getError(); ; paramAdResponse = AdError.INTERNAL_ERROR) {
                localAdListener.onError(localNativeAd, paramAdResponse);
                return;
            }
            NativeAd.access$202(this.this$0, false);
            NativeAd.access$102(this.this$0, null);
        } while (NativeAd.access$000(this.this$0) == null);
        NativeAd.access$000(this.this$0).onError(this.this$0, AdError.MISSING_PROPERTIES);
    }

    public void onError(AdError paramAdError) {
        NativeAd.access$202(this.this$0, false);
        if (NativeAd.access$000(this.this$0) != null) {
            NativeAd.access$000(this.this$0).onError(this.this$0, paramAdError);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/ads/NativeAd$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */