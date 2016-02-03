package com.facebook;

public class FacebookDialogException
        extends FacebookException {
    static final long serialVersionUID = 1L;
    private int errorCode;
    private String failingUrl;

    public FacebookDialogException(String paramString1, int paramInt, String paramString2) {
        super(paramString1);
        this.errorCode = paramInt;
        this.failingUrl = paramString2;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getFailingUrl() {
        return this.failingUrl;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/FacebookDialogException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */