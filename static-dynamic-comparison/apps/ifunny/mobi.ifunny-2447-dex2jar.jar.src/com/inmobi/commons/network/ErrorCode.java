package com.inmobi.commons.network;

public enum ErrorCode {
    private String a;

    static {
        INTERNAL_ERROR = new ErrorCode("INTERNAL_ERROR", 1, "An internal error occurred while fetching");
    }

    private ErrorCode(String paramString) {
        this.a = paramString;
    }

    public void setMessage(String paramString) {
        this.a = paramString;
    }

    public String toString() {
        return this.a;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/commons/network/ErrorCode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */