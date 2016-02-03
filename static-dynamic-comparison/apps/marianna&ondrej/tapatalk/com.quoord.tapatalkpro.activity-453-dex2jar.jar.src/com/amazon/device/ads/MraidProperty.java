package com.amazon.device.ads;

abstract class MraidProperty {
    private String sanitize(String paramString) {
        if (paramString != null) {
            return paramString.replaceAll("[^a-zA-Z0-9_,:\\s\\{\\}\\'\\\"]", "");
        }
        return "";
    }

    public abstract String toJsonPair();

    public String toString() {
        return sanitize(toJsonPair());
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/amazon/device/ads/MraidProperty.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */