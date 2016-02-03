package com.inmobi.monetization.internal;

import java.util.HashMap;

public class LtvpRulesObject {
    private String a;
    private long b;
    private HashMap<String, Integer> c;
    private long d;
    private long e;

    public long getHardExpiry() {
        return this.e;
    }

    public String getRuleId() {
        return this.a;
    }

    public HashMap<String, Integer> getRules() {
        return this.c;
    }

    public long getSoftExpiry() {
        return this.d;
    }

    public long getTimeStamp() {
        return this.b;
    }

    public void setHardExpiry(long paramLong) {
        this.e = paramLong;
    }

    public void setRuleId(String paramString) {
        this.a = paramString;
    }

    public void setRules(HashMap<String, Integer> paramHashMap) {
        this.c = paramHashMap;
    }

    public void setSoftExpiry(long paramLong) {
        this.d = paramLong;
    }

    public void setTimeStamp(long paramLong) {
        this.b = paramLong;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/monetization/internal/LtvpRulesObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */