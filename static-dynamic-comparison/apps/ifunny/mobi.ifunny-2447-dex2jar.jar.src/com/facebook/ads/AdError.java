package com.facebook.ads;

public class AdError {
    public static final AdError INTERNAL_ERROR = new AdError(2001, "Internal Error");
    public static final int INVALID_ERROR_CODE = -1;
    public static final AdError LOAD_TOO_FREQUENTLY;
    public static final AdError MISSING_PROPERTIES = new AdError(2002, "Native ad failed to load due to missing properties");
    public static final AdError NO_FILL = new AdError(1001, "No Fill");
    private final int errorCode;
    private final String errorMessage;

    static {
        LOAD_TOO_FREQUENTLY = new AdError(1002, "Ad was re-loaded too frequently");
    }

    public AdError(int paramInt, String paramString) {
        this.errorCode = paramInt;
        this.errorMessage = paramString;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/ads/AdError.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */