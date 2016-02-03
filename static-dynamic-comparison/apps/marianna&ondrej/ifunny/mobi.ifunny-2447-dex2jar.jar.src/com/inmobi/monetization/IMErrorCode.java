package com.inmobi.monetization;

import com.inmobi.monetization.internal.AdErrorCode;

public enum IMErrorCode {
    private String a;

    static {
        INTERNAL_ERROR = new IMErrorCode("INTERNAL_ERROR", 1, "An error occurred while fetching the ad");
        NO_FILL = new IMErrorCode("NO_FILL", 2, "The ad request was successful, but no ad was returned");
    }

    private IMErrorCode(String paramString) {
        this.a = paramString;
    }

    static IMErrorCode a(AdErrorCode paramAdErrorCode) {
        IMErrorCode localIMErrorCode = INTERNAL_ERROR;
        switch (IMErrorCode.a.a[paramAdErrorCode.ordinal()]) {
            default:
                localIMErrorCode = INTERNAL_ERROR;
        }
        for (; ; ) {
            localIMErrorCode.setMessage(paramAdErrorCode.toString());
            return localIMErrorCode;
            localIMErrorCode = INVALID_REQUEST;
            continue;
            localIMErrorCode = INTERNAL_ERROR;
            continue;
            localIMErrorCode = NO_FILL;
            continue;
            localIMErrorCode = NETWORK_ERROR;
            continue;
            localIMErrorCode = DO_MONETIZE;
            continue;
            localIMErrorCode = DO_NOTHING;
        }
    }

    public void setMessage(String paramString) {
        this.a = paramString;
    }

    public String toString() {
        return this.a;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/monetization/IMErrorCode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */