package com.mopub.nativeads;

import android.os.Handler;

class ClientPositioningSource
        implements PositioningSource {
    private Handler mHandler = new Handler();
    private final MoPubNativeAdPositioning.MoPubClientPositioning mPositioning;

    ClientPositioningSource(MoPubNativeAdPositioning.MoPubClientPositioning paramMoPubClientPositioning) {
        this.mPositioning = MoPubNativeAdPositioning.clone(paramMoPubClientPositioning);
    }

    public void loadPositions(String paramString, PositioningSource.PositioningListener paramPositioningListener) {
        this.mHandler.post(new ClientPositioningSource .1 (this, paramPositioningListener));
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/nativeads/ClientPositioningSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */