package com.google.gson;

import java.lang.reflect.Type;

class g
        implements JsonDeserializationContext {
    g(Gson paramGson) {
    }

    public <T> T deserialize(JsonElement paramJsonElement, Type paramType) {
        return (T) this.a.fromJson(paramJsonElement, paramType);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/gson/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */