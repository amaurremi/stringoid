package com.google.gson;

enum m {
    m() {
        super(paramString,paramInt,null);
    }

    public JsonElement serialize(Long paramLong) {
        return new JsonPrimitive(paramLong);
    }
    }


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/gson/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */