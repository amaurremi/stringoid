package com.mopub.common;

public class MoPub {
    public static final String SDK_VERSION = "3.0.0";
    private static volatile MoPub.LocationAwareness a = MoPub.LocationAwareness.NORMAL;
    private static volatile int b = 6;

    public static MoPub.LocationAwareness getLocationAwareness() {
        return a;
    }

    public static int getLocationPrecision() {
        return b;
    }

    public static void setLocationAwareness(MoPub.LocationAwareness paramLocationAwareness) {
        a = paramLocationAwareness;
    }

    public static void setLocationPrecision(int paramInt) {
        b = Math.min(Math.max(0, paramInt), 6);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/common/MoPub.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */