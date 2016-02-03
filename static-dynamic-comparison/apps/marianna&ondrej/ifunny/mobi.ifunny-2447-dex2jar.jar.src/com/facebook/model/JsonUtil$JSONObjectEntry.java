package com.facebook.model;

import android.annotation.SuppressLint;

import java.util.Map.Entry;

final class JsonUtil$JSONObjectEntry
        implements Map.Entry<String, Object> {
    private final String key;
    private final Object value;

    JsonUtil$JSONObjectEntry(String paramString, Object paramObject) {
        this.key = paramString;
        this.value = paramObject;
    }

    @SuppressLint({"FieldGetter"})
    public String getKey() {
        return this.key;
    }

    public Object getValue() {
        return this.value;
    }

    public Object setValue(Object paramObject) {
        throw new UnsupportedOperationException("JSONObjectEntry is immutable");
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/model/JsonUtil$JSONObjectEntry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */