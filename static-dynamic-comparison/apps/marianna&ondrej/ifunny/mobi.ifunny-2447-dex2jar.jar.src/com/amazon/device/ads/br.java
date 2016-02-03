package com.amazon.device.ads;

import java.util.HashMap;
import java.util.Map;

public class br {
    private static final String a = br.class.getSimpleName();
    private long b = Long.MIN_VALUE;
    private Map<String, String> c = new HashMap();
    private boolean d = false;
    private int e = Integer.MIN_VALUE;

    public long a() {
        return this.b;
    }

    public br a(String paramString1, String paramString2) {
        if (hu.d(paramString1)) {
            throw new IllegalArgumentException("Option Key must not be null or empty string");
        }
        if (paramString2 != null) {
            this.c.put(paramString1, paramString2);
            return this;
        }
        this.c.remove(paramString1);
        return this;
    }

    boolean b() {
        return this.b > -1L;
    }

    HashMap<String, String> c() {
        return new HashMap(this.c);
    }

    public boolean d() {
        return this.d;
    }

    public int e() {
        return this.e;
    }

    boolean f() {
        return this.e > -1;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/amazon/device/ads/br.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */