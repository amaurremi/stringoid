package com.inneractive.api.ads.sdk;

import java.lang.reflect.Method;

class IAreflectionHandler {
    static Method a(Class paramClass, String paramString, Class... paramVarArgs) {
        while (paramClass != null) {
            try {
                Method localMethod = paramClass.getDeclaredMethod(paramString, paramVarArgs);
                return localMethod;
            } catch (NoSuchMethodException localNoSuchMethodException) {
                paramClass = paramClass.getSuperclass();
            }
        }
        throw new NoSuchMethodException();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inneractive/api/ads/sdk/IAreflectionHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */