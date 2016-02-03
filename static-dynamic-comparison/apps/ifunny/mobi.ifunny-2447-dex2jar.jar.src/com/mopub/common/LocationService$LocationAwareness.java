package com.mopub.common;

public enum LocationService$LocationAwareness {
    private LocationService$LocationAwareness() {
    }

    @Deprecated
    public static LocationAwareness fromMoPubLocationAwareness(MoPub.LocationAwareness paramLocationAwareness) {
        if (paramLocationAwareness == MoPub.LocationAwareness.DISABLED) {
            return DISABLED;
        }
        if (paramLocationAwareness == MoPub.LocationAwareness.TRUNCATED) {
            return TRUNCATED;
        }
        return NORMAL;
    }

    @Deprecated
    public MoPub.LocationAwareness getNewLocationAwareness() {
        if (this == TRUNCATED) {
            return MoPub.LocationAwareness.TRUNCATED;
        }
        if (this == DISABLED) {
            return MoPub.LocationAwareness.DISABLED;
        }
        return MoPub.LocationAwareness.NORMAL;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/common/LocationService$LocationAwareness.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */