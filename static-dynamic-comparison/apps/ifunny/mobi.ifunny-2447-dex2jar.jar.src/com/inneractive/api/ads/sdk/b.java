package com.inneractive.api.ads.sdk;

import java.lang.reflect.Constructor;

final class b {
    private static b a = new b();

    static a a(String paramString) {
        b localb = a;
        paramString = Class.forName(paramString).asSubclass(a.class).getDeclaredConstructor(null);
        paramString.setAccessible(true);
        return (a) paramString.newInstance(new Object[0]);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inneractive/api/ads/sdk/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */