package com.inmobi.monetization.internal.configs;

import com.inmobi.commons.cache.CacheController.Validator;

import java.util.Map;

final class b
        implements CacheController.Validator {
    public boolean validate(Map<String, Object> paramMap) {
        return Initializer.a(paramMap);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/monetization/internal/configs/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */