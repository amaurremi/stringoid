package com.mopub.nativeads;

class MoPubCustomEventNative$1
        implements CustomEventNative.ImageListener {
    MoPubCustomEventNative$1(MoPubCustomEventNative paramMoPubCustomEventNative, CustomEventNative.CustomEventNativeListener paramCustomEventNativeListener, MoPubCustomEventNative.MoPubForwardingNativeAd paramMoPubForwardingNativeAd) {
    }

    public void onImagesCached() {
        this.val$customEventNativeListener.onNativeAdLoaded(this.val$moPubForwardingNativeAd);
    }

    public void onImagesFailedToCache(NativeErrorCode paramNativeErrorCode) {
        this.val$customEventNativeListener.onNativeAdFailed(paramNativeErrorCode);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/nativeads/MoPubCustomEventNative$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */