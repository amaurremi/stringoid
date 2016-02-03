package com.amazon.device.ads;

class Version {
    private static String buildVersion = "5.4.78";
    private static String devBuild = "(DEV)";
    private static String prefixVersion = "amznAdSDK-android-";
    private static String sdkVersion = null;

    public static String getRawSDKVersion() {
        String str2 = buildVersion;
        String str1;
        if ((str2 == null) || (str2.equals(""))) {
            str1 = devBuild;
        }
        do {
            return str1;
            str1 = str2;
        } while (!str2.endsWith("x"));
        return str2 + devBuild;
    }

    public static String getSDKVersion() {
        if (sdkVersion == null) {
            sdkVersion = prefixVersion + getRawSDKVersion();
        }
        return sdkVersion;
    }

    protected static void setSDKVersion(String paramString) {
        sdkVersion = paramString;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/amazon/device/ads/Version.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */