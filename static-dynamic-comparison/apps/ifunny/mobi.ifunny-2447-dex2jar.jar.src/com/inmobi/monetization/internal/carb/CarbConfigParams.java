package com.inmobi.monetization.internal.carb;

import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.uid.UIDMapConfigParams;

import java.util.Map;

public class CarbConfigParams {
    boolean a = false;
    String b = "http://dock.inmobi.com/carb/v1/i";
    String c = "http://dock.inmobi.com/carb/v1/o";
    long d = 86400L;
    int e = 3;
    long f = 60L;
    long g = 60L;
    private UIDMapConfigParams h = new UIDMapConfigParams();

    public String getCarbEndpoint() {
        return this.b;
    }

    public String getCarbPostpoint() {
        return this.c;
    }

    public Map<String, Boolean> getDeviceIdMaskMap() {
        return this.h.getMap();
    }

    public long getRetreiveFrequncy() {
        return this.d * 1000L;
    }

    public int getRetryCount() {
        return this.e;
    }

    public long getRetryInterval() {
        return this.f;
    }

    public long getTimeoutInterval() {
        return this.g;
    }

    public boolean isCarbEnabled() {
        return this.a;
    }

    public void setFromMap(Map<String, Object> paramMap) {
        try {
            this.h.setMap(InternalSDKUtil.getObjectFromMap(paramMap, "ids"));
            this.a = InternalSDKUtil.getBooleanFromMap(paramMap, "enabled");
            this.b = InternalSDKUtil.getStringFromMap(paramMap, "gep");
            if ((!this.b.startsWith("http")) && (!this.b.startsWith("https"))) {
                throw new IllegalArgumentException("URL wrong");
            }
        } catch (IllegalArgumentException paramMap) {
            Log.internal("CarbConfigParams", "Invalid value");
            this.a = false;
            this.b = "http://dock.inmobi.com/carb/v1/i";
            this.c = "http://dock.inmobi.com/carb/v1/o";
            this.d = 86400L;
            this.e = 3;
            this.f = 60L;
            this.g = 60L;
            throw new IllegalArgumentException();
        }
        this.c = InternalSDKUtil.getStringFromMap(paramMap, "pep");
        if ((!this.c.startsWith("http")) && (!this.c.startsWith("https"))) {
            throw new IllegalArgumentException("URL wrong");
        }
        this.d = InternalSDKUtil.getLongFromMap(paramMap, "fq_s", 1L, Long.MAX_VALUE);
        this.e = InternalSDKUtil.getIntFromMap(paramMap, "mr", 0, 2147483647L);
        this.f = InternalSDKUtil.getLongFromMap(paramMap, "ri", 1L, Long.MAX_VALUE);
        this.g = InternalSDKUtil.getLongFromMap(paramMap, "to", 1L, Long.MAX_VALUE);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/monetization/internal/carb/CarbConfigParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */