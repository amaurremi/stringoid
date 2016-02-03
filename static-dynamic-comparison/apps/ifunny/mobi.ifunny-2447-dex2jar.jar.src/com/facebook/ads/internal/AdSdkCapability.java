package com.facebook.ads.internal;

import org.json.JSONArray;

enum AdSdkCapability {
    private static final AdSdkCapability[] supportedCapabilities;
    private static final String supportedCapabilitiesStr;
    private final int value;

    static {
        int i = 0;
        APP_AD = new AdSdkCapability("APP_AD", 0, 0);
        LINK_AD = new AdSdkCapability("LINK_AD", 1, 1);
        APP_AD_V2 = new AdSdkCapability("APP_AD_V2", 2, 2);
        LINK_AD_V2 = new AdSdkCapability("LINK_AD_V2", 3, 3);
        APP_ENGAGEMENT_AD = new AdSdkCapability("APP_ENGAGEMENT_AD", 4, 4);
        AD_CHOICES = new AdSdkCapability("AD_CHOICES", 5, 5);
        JS_TRIGGER = new AdSdkCapability("JS_TRIGGER", 6, 6);
        JS_TRIGGER_NO_AUTO_IMP_LOGGING = new AdSdkCapability("JS_TRIGGER_NO_AUTO_IMP_LOGGING", 7, 7);
        $VALUES = new AdSdkCapability[]{APP_AD, LINK_AD, APP_AD_V2, LINK_AD_V2, APP_ENGAGEMENT_AD, AD_CHOICES, JS_TRIGGER, JS_TRIGGER_NO_AUTO_IMP_LOGGING};
        supportedCapabilities = new AdSdkCapability[]{APP_ENGAGEMENT_AD, LINK_AD_V2, AD_CHOICES, JS_TRIGGER_NO_AUTO_IMP_LOGGING};
        JSONArray localJSONArray = new JSONArray();
        AdSdkCapability[] arrayOfAdSdkCapability = supportedCapabilities;
        int j = arrayOfAdSdkCapability.length;
        while (i < j) {
            localJSONArray.put(arrayOfAdSdkCapability[i].getValue());
            i += 1;
        }
        supportedCapabilitiesStr = localJSONArray.toString();
    }

    private AdSdkCapability(int paramInt) {
        this.value = paramInt;
    }

    public static String getSupportedCapabilitiesAsJSONString() {
        return supportedCapabilitiesStr;
    }

    int getValue() {
        return this.value;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/ads/internal/AdSdkCapability.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */