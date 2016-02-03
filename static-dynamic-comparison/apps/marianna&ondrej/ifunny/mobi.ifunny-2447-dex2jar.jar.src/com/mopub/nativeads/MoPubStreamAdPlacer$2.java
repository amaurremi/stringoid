package com.mopub.nativeads;

class MoPubStreamAdPlacer$2
        implements PositioningSource.PositioningListener {
    MoPubStreamAdPlacer$2(MoPubStreamAdPlacer paramMoPubStreamAdPlacer) {
    }

    public void onFailed() {
    }

    public void onLoad(MoPubNativeAdPositioning.MoPubClientPositioning paramMoPubClientPositioning) {
        this.this$0.handlePositioningLoad(paramMoPubClientPositioning);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/nativeads/MoPubStreamAdPlacer$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */