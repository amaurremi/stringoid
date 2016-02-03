package com.amazon.device.ads;

import java.util.Set;

public enum ai {
    private final int d;

    private ai(int paramInt) {
        this.d = paramInt;
    }

    static ai a(int paramInt) {
        switch (paramInt) {
            default:
                return null;
            case 1007:
                return a;
            case 1016:
                return b;
        }
        return c;
    }

    static ai a(Set<ai> paramSet) {
        ai localai = null;
        if (paramSet.contains(b)) {
            localai = b;
        }
        while (!paramSet.contains(a)) {
            return localai;
        }
        return a;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/amazon/device/ads/ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */