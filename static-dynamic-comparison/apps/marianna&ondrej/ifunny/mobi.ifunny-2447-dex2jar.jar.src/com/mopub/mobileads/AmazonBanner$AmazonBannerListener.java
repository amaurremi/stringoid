package com.mopub.mobileads;

import com.amazon.device.ads.aa;
import com.amazon.device.ads.aj;
import com.amazon.device.ads.bd;
import com.amazon.device.ads.be;
import com.amazon.device.ads.cy;
import mobi.ifunny.d;

final class AmazonBanner$AmazonBannerListener
        extends cy {
    private AmazonBanner$AmazonBannerListener(AmazonBanner paramAmazonBanner) {
    }

    public void onAdCollapsed(aa paramaa) {
        d.b(AmazonBanner.access$100(), "Amazon ad collapsed.");
        AmazonBanner.access$300(this.this$0).onBannerCollapsed();
    }

    public void onAdExpanded(aa paramaa) {
        d.b(AmazonBanner.access$100(), "Amazon ad expanded.");
        AmazonBanner.access$300(this.this$0).onBannerExpanded();
    }

    public void onAdFailedToLoad(aa paramaa, aj paramaj) {
        paramaa = paramaj.a();
        paramaj = paramaj.b();
        d.b(AmazonBanner.access$100(), "Amazon ad failed to load. Code: " + paramaa + ", Message: " + paramaj);
        switch (AmazonBanner .1.$SwitchMap$com$amazon$device$ads$AdError$ErrorCode[paramaa.ordinal()])
        {
            default:
                paramaa = MoPubErrorCode.UNSPECIFIED;
        }
        for (; ; ) {
            AmazonBanner.access$300(this.this$0).onBannerFailed(paramaa);
            return;
            paramaa = MoPubErrorCode.ADAPTER_CONFIGURATION_ERROR;
            continue;
            paramaa = MoPubErrorCode.NETWORK_INVALID_STATE;
            continue;
            paramaa = MoPubErrorCode.NETWORK_TIMEOUT;
            continue;
            paramaa = MoPubErrorCode.NETWORK_NO_FILL;
            continue;
            paramaa = MoPubErrorCode.INTERNAL_ERROR;
        }
    }

    public void onAdLoaded(aa paramaa, bd parambd) {
        d.b(AmazonBanner.access$100(), parambd.a().toString() + " amazon ad loaded successfully.");
        AmazonBanner.access$300(this.this$0).onBannerLoaded(AmazonBanner.access$200(this.this$0));
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/mobileads/AmazonBanner$AmazonBannerListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */