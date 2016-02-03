package com.facebook.ads;

import org.json.JSONObject;

public class NativeAd$Rating {
    private final double scale;
    private final double value;

    private NativeAd$Rating(double paramDouble1, double paramDouble2) {
        this.value = paramDouble1;
        this.scale = paramDouble2;
    }

    public static Rating fromJSONObject(JSONObject paramJSONObject) {
        if (paramJSONObject == null) {
        }
        double d1;
        double d2;
        do {
            return null;
            d1 = paramJSONObject.optDouble("value", 0.0D);
            d2 = paramJSONObject.optDouble("scale", 0.0D);
        } while ((d1 == 0.0D) || (d2 == 0.0D));
        return new Rating(d1, d2);
    }

    public double getScale() {
        return this.scale;
    }

    public double getValue() {
        return this.value;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/ads/NativeAd$Rating.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */