package com.mopub.nativeads;

import android.location.Location;
import android.text.TextUtils;

import java.util.EnumSet;

public final class RequestParameters {
    private final EnumSet<RequestParameters.NativeAdAsset> mDesiredAssets;
    private final String mKeywords;
    private final Location mLocation;

    private RequestParameters(RequestParameters.Builder paramBuilder) {
        this.mKeywords = RequestParameters.Builder.access$100(paramBuilder);
        this.mLocation = RequestParameters.Builder.access$200(paramBuilder);
        this.mDesiredAssets = RequestParameters.Builder.access$300(paramBuilder);
    }

    public final String getDesiredAssets() {
        String str = "";
        if (this.mDesiredAssets != null) {
            str = TextUtils.join(",", this.mDesiredAssets.toArray());
        }
        return str;
    }

    public final String getKeywords() {
        return this.mKeywords;
    }

    public final Location getLocation() {
        return this.mLocation;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/nativeads/RequestParameters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */