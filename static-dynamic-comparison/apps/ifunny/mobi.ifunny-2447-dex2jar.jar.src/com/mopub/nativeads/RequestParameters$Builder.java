package com.mopub.nativeads;

import android.location.Location;

import java.util.EnumSet;

public final class RequestParameters$Builder {
    private EnumSet<RequestParameters.NativeAdAsset> desiredAssets;
    private String keywords;
    private Location location;

    public final RequestParameters build() {
        return new RequestParameters(this, null);
    }

    public final Builder desiredAssets(EnumSet<RequestParameters.NativeAdAsset> paramEnumSet) {
        this.desiredAssets = EnumSet.copyOf(paramEnumSet);
        return this;
    }

    public final Builder keywords(String paramString) {
        this.keywords = paramString;
        return this;
    }

    public final Builder location(Location paramLocation) {
        this.location = paramLocation;
        return this;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/nativeads/RequestParameters$Builder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */