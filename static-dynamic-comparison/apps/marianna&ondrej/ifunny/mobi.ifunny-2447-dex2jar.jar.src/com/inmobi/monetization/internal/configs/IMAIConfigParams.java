package com.inmobi.monetization.internal.configs;

import com.inmobi.commons.internal.InternalSDKUtil;

import java.util.Map;

public class IMAIConfigParams {
    int a = 3;
    int b = 10;
    int c = 120;
    int d = 10;
    int e = 1000;

    public int getMaxRetry() {
        return this.a;
    }

    public int getPingTimeOut() {
        return this.c * 1000;
    }

    public int getRetryInterval() {
        return this.b * 1000;
    }

    public int getmDefaultEventsBatch() {
        return this.d;
    }

    public int getmMaxDb() {
        return this.e;
    }

    public void setFromMap(Map<String, Object> paramMap) {
        this.a = InternalSDKUtil.getIntFromMap(paramMap, "mr", 0, 2147483647L);
        this.b = InternalSDKUtil.getIntFromMap(paramMap, "pint", 1, 2147483647L);
        this.c = InternalSDKUtil.getIntFromMap(paramMap, "pto", 1, 2147483647L);
        this.d = InternalSDKUtil.getIntFromMap(paramMap, "eb", 1, 2147483647L);
        this.e = InternalSDKUtil.getIntFromMap(paramMap, "mdb", 1, 2147483647L);
    }

    public void setmDefaultEventsBatch(int paramInt) {
        this.d = paramInt;
    }

    public void setmMaxDb(int paramInt) {
        this.e = paramInt;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/monetization/internal/configs/IMAIConfigParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */