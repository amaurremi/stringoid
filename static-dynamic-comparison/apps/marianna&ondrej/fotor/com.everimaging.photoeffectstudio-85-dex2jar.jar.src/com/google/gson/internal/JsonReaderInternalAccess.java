package com.google.gson.internal;

import com.google.gson.stream.JsonReader;

import java.io.IOException;

public abstract class JsonReaderInternalAccess {
    public static JsonReaderInternalAccess INSTANCE;

    public abstract void promoteNameToValue(JsonReader paramJsonReader)
            throws IOException;
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/google/gson/internal/JsonReaderInternalAccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */