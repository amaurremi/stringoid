package com.facebook.ads;

import org.json.JSONObject;

public class NativeAd$Image {
    private final int height;
    private final String url;
    private final int width;

    private NativeAd$Image(String paramString, int paramInt1, int paramInt2) {
        this.url = paramString;
        this.width = paramInt1;
        this.height = paramInt2;
    }

    public static Image fromJSONObject(JSONObject paramJSONObject) {
        if (paramJSONObject == null) {
        }
        String str;
        do {
            return null;
            str = paramJSONObject.optString("url");
        } while (str == null);
        return new Image(str, paramJSONObject.optInt("width", 0), paramJSONObject.optInt("height", 0));
    }

    public int getHeight() {
        return this.height;
    }

    public String getUrl() {
        return this.url;
    }

    public int getWidth() {
        return this.width;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/ads/NativeAd$Image.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */