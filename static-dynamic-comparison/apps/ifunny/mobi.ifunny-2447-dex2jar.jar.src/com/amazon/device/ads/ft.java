package com.amazon.device.ads;

abstract class ft {
    private String a(String paramString) {
        if (paramString != null) {
            return paramString.replaceAll("[^a-zA-Z0-9_,:\\s\\{\\}\\'\\\"]", "");
        }
        return "";
    }

    public abstract String a();

    public String toString() {
        return a(a());
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/amazon/device/ads/ft.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */