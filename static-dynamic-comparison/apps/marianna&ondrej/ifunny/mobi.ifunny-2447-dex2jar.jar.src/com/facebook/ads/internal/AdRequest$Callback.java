package com.facebook.ads.internal;

import com.facebook.ads.AdError;

public abstract interface AdRequest$Callback {
    public abstract void onCompleted(AdResponse paramAdResponse);

    public abstract void onError(AdError paramAdError);
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/ads/internal/AdRequest$Callback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */