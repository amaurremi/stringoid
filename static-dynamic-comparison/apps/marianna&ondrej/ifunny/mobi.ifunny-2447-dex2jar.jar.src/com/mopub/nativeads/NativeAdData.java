package com.mopub.nativeads;

class NativeAdData {
    private final MoPubAdRenderer adRenderer;
    private final NativeResponse adResponse;
    private final String adUnitId;

    NativeAdData(String paramString, MoPubAdRenderer paramMoPubAdRenderer, NativeResponse paramNativeResponse) {
        this.adUnitId = paramString;
        this.adRenderer = paramMoPubAdRenderer;
        this.adResponse = paramNativeResponse;
    }

    NativeResponse getAd() {
        return this.adResponse;
    }

    MoPubAdRenderer getAdRenderer() {
        return this.adRenderer;
    }

    String getAdUnitId() {
        return this.adUnitId;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/nativeads/NativeAdData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */