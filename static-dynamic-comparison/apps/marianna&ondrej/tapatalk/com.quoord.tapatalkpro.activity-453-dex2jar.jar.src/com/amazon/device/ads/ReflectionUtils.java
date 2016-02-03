package com.amazon.device.ads;

public class ReflectionUtils {
    public static boolean isClassAvailable(String paramString) {
        try {
            Class.forName(paramString);
            return true;
        } catch (ClassNotFoundException paramString) {
        }
        return false;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/amazon/device/ads/ReflectionUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */