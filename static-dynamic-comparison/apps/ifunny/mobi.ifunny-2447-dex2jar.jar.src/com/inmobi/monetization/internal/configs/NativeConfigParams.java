package com.inmobi.monetization.internal.configs;

import com.inmobi.commons.internal.InternalSDKUtil;

import java.util.Map;

public class NativeConfigParams {
    int a = 100;
    int b = 1;
    int c = 2;
    long d = 3300L;

    public long getTimeToLive() {
        return this.d;
    }

    public int getmFetchLimit() {
        return this.c;
    }

    public int getmMaxCacheSize() {
        return this.a;
    }

    public int getmMinLimit() {
        return this.b;
    }

    public void setFromMap(Map<String, Object> paramMap) {
        this.a = InternalSDKUtil.getIntFromMap(paramMap, "mcl", 1, 2147483647L);
        this.b = InternalSDKUtil.getIntFromMap(paramMap, "mt", 1, 2147483647L);
        this.c = InternalSDKUtil.getIntFromMap(paramMap, "fl", 1, 2147483647L);
        this.d = InternalSDKUtil.getLongFromMap(paramMap, "ttl", 1L, Long.MAX_VALUE);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/monetization/internal/configs/NativeConfigParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */