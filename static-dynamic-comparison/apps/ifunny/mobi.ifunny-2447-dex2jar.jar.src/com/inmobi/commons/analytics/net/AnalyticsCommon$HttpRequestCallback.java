package com.inmobi.commons.analytics.net;

public abstract interface AnalyticsCommon$HttpRequestCallback {
    public static final int HTTP_FAILURE = 1;
    public static final int HTTP_SUCCESS = 0;

    public abstract void notifyResult(int paramInt, Object paramObject);
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/commons/analytics/net/AnalyticsCommon$HttpRequestCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */