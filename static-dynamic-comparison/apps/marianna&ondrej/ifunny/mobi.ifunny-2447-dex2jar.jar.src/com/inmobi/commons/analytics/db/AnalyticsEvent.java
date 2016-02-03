package com.inmobi.commons.analytics.db;

public class AnalyticsEvent {
    public static final String EVENT_ID = "id";
    public static final String IN_APP = "inapp";
    public static final String SUBS = "subs";
    public static final String TYPE_CUSTOM_EVENT = "ce";
    public static final String TYPE_END_SESSION = "es";
    public static final String TYPE_LEVEL_BEGIN = "lb";
    public static final String TYPE_LEVEL_END = "le";
    public static final String TYPE_START_SESSION = "ss";
    public static final String TYPE_TAG_TRANSACTION = "pi";
    public static final String TYPE_USER_ATTRIBUTE = "ae";
    private long a;
    private String b;
    private String c;
    private long d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private String k;
    private String l;
    private String m;
    private String n;
    private AnalyticsEvent.TRANSACTION_ITEM_TYPE o;
    private double p;
    private int q;
    private String r;
    private String s;
    private String t;
    private AnalyticsEvent.TRANSACTION_STATUS_SERVER_CODE u;
    private long v;
    private long w;
    private String x;
    private String y;

    public AnalyticsEvent(String paramString) {
        this.b = paramString;
    }

    public String getAttributeName() {
        return this.x;
    }

    public String getAttributeValue() {
        return this.y;
    }

    public String getEventAttemptCount() {
        return this.j;
    }

    public String getEventAttemptTime() {
        return this.k;
    }

    public String getEventAttributeMap() {
        return this.e;
    }

    public String getEventCustomName() {
        return this.l;
    }

    public long getEventId() {
        return this.a;
    }

    public String getEventLevelId() {
        return this.f;
    }

    public String getEventLevelName() {
        return this.g;
    }

    public String getEventLevelStatus() {
        return this.h;
    }

    public String getEventSessionId() {
        return this.c;
    }

    public long getEventSessionTimeStamp() {
        return this.d;
    }

    public long getEventTableId() {
        return this.w;
    }

    public long getEventTimeStamp() {
        return this.v;
    }

    public String getEventTimeTaken() {
        return this.i;
    }

    public String getEventType() {
        return this.b;
    }

    public String getTransactionCurrencyCode() {
        return this.r;
    }

    public String getTransactionId() {
        return this.t;
    }

    public int getTransactionItemCount() {
        return this.q;
    }

    public String getTransactionItemDescription() {
        return this.n;
    }

    public String getTransactionItemName() {
        return this.m;
    }

    public double getTransactionItemPrice() {
        return this.p;
    }

    public int getTransactionItemType() {
        if (this.o == null) {
            return AnalyticsEvent.TRANSACTION_ITEM_TYPE.INVALID.getValue();
        }
        return this.o.getValue();
    }

    public String getTransactionProductId() {
        return this.s;
    }

    public int getTransactionStatus() {
        if (this.u == null) {
            return AnalyticsEvent.TRANSACTION_STATUS_SERVER_CODE.INVALID.getValue();
        }
        return this.u.getValue();
    }

    public void setEventAttemptCount(String paramString) {
        this.j = paramString;
    }

    public void setEventAttemptTime(String paramString) {
        this.k = paramString;
    }

    public void setEventAttributeMap(String paramString) {
        this.e = paramString;
    }

    public void setEventCustomName(String paramString) {
        this.l = paramString;
    }

    public void setEventId(long paramLong) {
        this.a = paramLong;
    }

    public void setEventLevelId(String paramString) {
        this.f = paramString;
    }

    public void setEventLevelName(String paramString) {
        this.g = paramString;
    }

    public void setEventLevelStatus(String paramString) {
        this.h = paramString;
    }

    public void setEventSessionId(String paramString) {
        this.c = paramString;
    }

    public void setEventSessionTimeStamp(long paramLong) {
        this.d = paramLong;
    }

    public void setEventTableId(long paramLong) {
        this.w = paramLong;
    }

    public void setEventTimeStamp(long paramLong) {
        this.v = paramLong;
    }

    public void setEventTimeTaken(String paramString) {
        this.i = paramString;
    }

    public void setTransactionCurrencyCode(String paramString) {
        this.r = paramString;
    }

    public void setTransactionId(String paramString) {
        this.t = paramString;
    }

    public void setTransactionItemCount(int paramInt) {
        this.q = paramInt;
    }

    public void setTransactionItemDescription(String paramString) {
        this.n = paramString;
    }

    public void setTransactionItemName(String paramString) {
        this.m = paramString;
    }

    public void setTransactionItemPrice(double paramDouble) {
        this.p = paramDouble;
    }

    public void setTransactionItemType(int paramInt) {
        if (AnalyticsEvent.TRANSACTION_ITEM_TYPE.INAPP.getValue() == paramInt) {
            this.o = AnalyticsEvent.TRANSACTION_ITEM_TYPE.INAPP;
            return;
        }
        if (AnalyticsEvent.TRANSACTION_ITEM_TYPE.SUBSCRIPTION.getValue() == paramInt) {
            this.o = AnalyticsEvent.TRANSACTION_ITEM_TYPE.SUBSCRIPTION;
            return;
        }
        this.o = AnalyticsEvent.TRANSACTION_ITEM_TYPE.INVALID;
    }

    public void setTransactionProductId(String paramString) {
        this.s = paramString;
    }

    public void setTransactionStatus(int paramInt) {
        if (AnalyticsEvent.TRANSACTION_STATUS_SERVER_CODE.PURCHASED.getValue() == paramInt) {
            this.u = AnalyticsEvent.TRANSACTION_STATUS_SERVER_CODE.PURCHASED;
            return;
        }
        if (AnalyticsEvent.TRANSACTION_STATUS_SERVER_CODE.REFUNDED.getValue() == paramInt) {
            this.u = AnalyticsEvent.TRANSACTION_STATUS_SERVER_CODE.REFUNDED;
            return;
        }
        if (AnalyticsEvent.TRANSACTION_STATUS_SERVER_CODE.FAILED.getValue() == paramInt) {
            this.u = AnalyticsEvent.TRANSACTION_STATUS_SERVER_CODE.FAILED;
            return;
        }
        this.u = AnalyticsEvent.TRANSACTION_STATUS_SERVER_CODE.INVALID;
    }

    public void setUserAttribute(String paramString1, String paramString2) {
        if ((paramString1 != null) && (paramString2 != null) && (!"".equals(paramString1.trim())) && (!"".equals(paramString2.trim()))) {
            this.x = paramString1;
            this.y = paramString2;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/commons/analytics/db/AnalyticsEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */