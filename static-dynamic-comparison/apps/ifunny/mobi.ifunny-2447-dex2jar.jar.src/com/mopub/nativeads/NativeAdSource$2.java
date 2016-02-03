package com.mopub.nativeads;

import android.os.Handler;

import java.util.List;

class NativeAdSource$2
        implements MoPubNative.MoPubNativeNetworkListener {
    NativeAdSource$2(NativeAdSource paramNativeAdSource) {
    }

    public void onNativeFail(NativeErrorCode paramNativeErrorCode) {
        this.this$0.mRequestInFlight = false;
        if (this.this$0.mRetryTimeMilliseconds >= 300000) {
            this.this$0.resetRetryTime();
            return;
        }
        this.this$0.updateRetryTime();
        this.this$0.mRetryInFlight = true;
        NativeAdSource.access$400(this.this$0).postDelayed(NativeAdSource.access$300(this.this$0), this.this$0.mRetryTimeMilliseconds);
    }

    public void onNativeLoad(NativeResponse paramNativeResponse) {
        if (NativeAdSource.access$000(this.this$0) == null) {
            return;
        }
        this.this$0.mRequestInFlight = false;
        NativeAdSource localNativeAdSource = this.this$0;
        localNativeAdSource.mSequenceNumber += 1;
        this.this$0.resetRetryTime();
        NativeAdSource.access$100(this.this$0).add(new TimestampWrapper(paramNativeResponse));
        if ((NativeAdSource.access$100(this.this$0).size() == 1) && (NativeAdSource.access$200(this.this$0) != null)) {
            NativeAdSource.access$200(this.this$0).onAdsAvailable();
        }
        this.this$0.replenishCache();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/nativeads/NativeAdSource$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */