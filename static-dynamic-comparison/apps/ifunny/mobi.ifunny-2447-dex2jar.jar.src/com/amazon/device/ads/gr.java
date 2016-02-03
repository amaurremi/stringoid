package com.amazon.device.ads;

public class gr {
    public static boolean a(String paramString) {
        try {
            Class.forName(paramString);
            return true;
        } catch (ClassNotFoundException paramString) {
        }
        return false;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/amazon/device/ads/gr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */