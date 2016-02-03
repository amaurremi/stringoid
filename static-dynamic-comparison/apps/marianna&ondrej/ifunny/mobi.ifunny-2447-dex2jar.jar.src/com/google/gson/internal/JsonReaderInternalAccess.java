package com.google.gson.internal;

import com.google.gson.stream.JsonReader;

public abstract class JsonReaderInternalAccess {
    public static JsonReaderInternalAccess INSTANCE;

    public abstract void promoteNameToValue(JsonReader paramJsonReader);
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/gson/internal/JsonReaderInternalAccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */