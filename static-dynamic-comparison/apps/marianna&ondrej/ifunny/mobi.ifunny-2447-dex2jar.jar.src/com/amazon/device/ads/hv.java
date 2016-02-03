package com.amazon.device.ads;

class hv {
    private static String a = "5.4.78";
    private static String b = "amznAdSDK-android-";
    private static String c = null;
    private static String d = "(DEV)";

    public static String a() {
        String str2 = a;
        String str1;
        if ((str2 == null) || (str2.equals(""))) {
            str1 = d;
        }
        do {
            return str1;
            str1 = str2;
        } while (!str2.endsWith("x"));
        return str2 + d;
    }

    public static String b() {
        if (c == null) {
            c = b + a();
        }
        return c;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/amazon/device/ads/hv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */