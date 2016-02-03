package com.facebook.android;

public class FacebookError
        extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private int mErrorCode = 0;
    private String mErrorType;

    @Deprecated
    public FacebookError(String paramString) {
        super(paramString);
    }

    @Deprecated
    public FacebookError(String paramString1, String paramString2, int paramInt) {
        super(paramString1);
        this.mErrorType = paramString2;
        this.mErrorCode = paramInt;
    }

    @Deprecated
    public int getErrorCode() {
        return this.mErrorCode;
    }

    @Deprecated
    public String getErrorType() {
        return this.mErrorType;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/android/FacebookError.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */