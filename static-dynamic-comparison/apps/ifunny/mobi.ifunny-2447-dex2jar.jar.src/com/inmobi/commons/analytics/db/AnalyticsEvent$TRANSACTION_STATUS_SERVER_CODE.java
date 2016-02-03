package com.inmobi.commons.analytics.db;

public enum AnalyticsEvent$TRANSACTION_STATUS_SERVER_CODE {
    private final int a;

    static {
        FAILED = new TRANSACTION_STATUS_SERVER_CODE("FAILED", 2, 2);
        RESTORED = new TRANSACTION_STATUS_SERVER_CODE("RESTORED", 3, 3);
    }

    private AnalyticsEvent$TRANSACTION_STATUS_SERVER_CODE(int paramInt) {
        this.a = paramInt;
    }

    public int getValue() {
        return this.a;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/commons/analytics/db/AnalyticsEvent$TRANSACTION_STATUS_SERVER_CODE.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */