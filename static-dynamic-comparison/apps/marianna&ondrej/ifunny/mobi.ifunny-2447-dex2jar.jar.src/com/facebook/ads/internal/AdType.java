package com.facebook.ads.internal;

public enum AdType {
    HTML(0), NATIVE(1);

    private final int value;

    private AdType(int paramInt) {
        this.value = paramInt;
    }

    public int getValue() {
        return this.value;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/ads/internal/AdType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */