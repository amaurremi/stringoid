package com.google.gson;

import java.lang.reflect.Type;

class h
        implements JsonSerializationContext {
    h(Gson paramGson) {
    }

    public JsonElement serialize(Object paramObject) {
        return this.a.toJsonTree(paramObject);
    }

    public JsonElement serialize(Object paramObject, Type paramType) {
        return this.a.toJsonTree(paramObject, paramType);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/gson/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */