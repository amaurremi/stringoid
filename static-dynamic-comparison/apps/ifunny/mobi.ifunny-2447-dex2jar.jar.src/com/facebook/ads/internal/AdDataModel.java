package com.facebook.ads.internal;

import java.util.Collection;

public abstract interface AdDataModel {
    public abstract Collection<String> getDetectionStrings();

    public abstract AdInvalidationBehavior getInvalidationBehavior();
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/ads/internal/AdDataModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */