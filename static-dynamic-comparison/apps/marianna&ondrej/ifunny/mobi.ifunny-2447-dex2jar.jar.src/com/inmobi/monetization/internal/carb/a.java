package com.inmobi.monetization.internal.carb;

import com.inmobi.commons.cache.CacheController.Validator;

import java.util.Map;

final class a
        implements CacheController.Validator {
    public boolean validate(Map<String, Object> paramMap) {
        return CarbInitializer.a(paramMap);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/monetization/internal/carb/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */