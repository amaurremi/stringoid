package com.mopub.nativeads;

import com.mopub.common.GpsHelper.GpsHelperListener;

class MoPubNative$NativeGpsHelperListener
        implements GpsHelper.GpsHelperListener {
    private final RequestParameters mRequestParameters;

    MoPubNative$NativeGpsHelperListener(MoPubNative paramMoPubNative, RequestParameters paramRequestParameters) {
        this.mRequestParameters = paramRequestParameters;
    }

    public void onFetchAdInfoCompleted() {
        this.this$0.loadNativeAd(this.mRequestParameters);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/nativeads/MoPubNative$NativeGpsHelperListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */