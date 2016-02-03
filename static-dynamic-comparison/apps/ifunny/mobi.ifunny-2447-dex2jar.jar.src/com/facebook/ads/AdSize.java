package com.facebook.ads;

public enum AdSize {
    BANNER_320_50(320, 50), INTERSTITIAL(0, 0);

    private final int height;
    private final int width;

    private AdSize(int paramInt1, int paramInt2) {
        this.width = paramInt1;
        this.height = paramInt2;
    }

    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/ads/AdSize.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */