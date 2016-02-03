package com.amazon.device.ads;

abstract interface PreferredMarketplaceRetriever {
    public abstract String retrievePreferredMarketplace();

    public static class NullPreferredMarketplaceRetriever
            implements PreferredMarketplaceRetriever {
        public String retrievePreferredMarketplace() {
            return null;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/amazon/device/ads/PreferredMarketplaceRetriever.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */