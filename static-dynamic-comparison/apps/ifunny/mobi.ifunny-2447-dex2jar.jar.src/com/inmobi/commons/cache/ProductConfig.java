package com.inmobi.commons.cache;

import java.util.HashMap;
import java.util.Map;

public abstract class ProductConfig {
    private String a = null;
    private String b = null;
    private String c = null;
    private int d = 0;
    private int e = 3;
    private int f = 60;
    private int g = 0;
    private int h = -1;
    private boolean i = true;

    Map<String, Object> a(String paramString) {
        if (getProtocol().equals("json")) {
            return new JSONMapBuilder().buildMap(paramString);
        }
        HashMap localHashMap = new HashMap();
        localHashMap.put("data", paramString);
        return localHashMap;
    }

    public Map<String, Object> getData() {
        return a(this.c);
    }

    public int getExpiry() {
        return this.d;
    }

    public int getMaxRetry() {
        return this.e;
    }

    public String getProtocol() {
        return this.b;
    }

    public String getRawData() {
        return this.c;
    }

    public int getRetryInterval() {
        return this.f;
    }

    public int getRetryNumber() {
        return this.g;
    }

    public int getTimestamp() {
        return this.h;
    }

    public String getUrl() {
        return this.a;
    }

    public boolean isSendUidMap() {
        return this.i;
    }

    public void setData(String paramString) {
        this.c = paramString;
    }

    public void setExpiry(int paramInt) {
        this.d = paramInt;
    }

    public void setMaxRetry(int paramInt) {
        this.e = paramInt;
    }

    public void setProtocol(String paramString) {
        this.b = paramString;
    }

    public void setRetryInterval(int paramInt) {
        this.f = paramInt;
    }

    public void setRetryNumber(int paramInt) {
        this.g = paramInt;
    }

    public void setSendUidMap(boolean paramBoolean) {
        this.i = paramBoolean;
    }

    public void setTimestamp(int paramInt) {
        this.h = paramInt;
    }

    public void setUrl(String paramString) {
        this.a = paramString;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/commons/cache/ProductConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */