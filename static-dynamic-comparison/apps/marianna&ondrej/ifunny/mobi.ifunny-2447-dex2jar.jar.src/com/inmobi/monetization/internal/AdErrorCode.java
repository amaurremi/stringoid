package com.inmobi.monetization.internal;

public enum AdErrorCode {
    private String a;

    static {
        INTERNAL_ERROR = new AdErrorCode("INTERNAL_ERROR", 1, "An error occurred while fetching the ad");
        NO_FILL = new AdErrorCode("NO_FILL", 2, "The ad request was successful, but no ad was returned");
        AD_CLICK_IN_PROGRESS = new AdErrorCode("AD_CLICK_IN_PROGRESS", 3, "Ad click is in progress, cannot load new ad");
        AD_DOWNLOAD_IN_PROGRESS = new AdErrorCode("AD_DOWNLOAD_IN_PROGRESS", 4, "Ad download is in progress, cannot load new ad");
        INVALID_APP_ID = new AdErrorCode("INVALID_APP_ID", 5, "Invalid App Id");
    }

    private AdErrorCode(String paramString) {
        this.a = paramString;
    }

    public void setMessage(String paramString) {
        this.a = paramString;
    }

    public String toString() {
        return this.a;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/monetization/internal/AdErrorCode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */