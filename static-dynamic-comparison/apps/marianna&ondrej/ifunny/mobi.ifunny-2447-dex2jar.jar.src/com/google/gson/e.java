package com.google.gson;

import java.lang.reflect.Field;

enum e {
    e() {
        super(paramString,paramInt,null);
    }

    public String translateName(Field paramField) {
        return FieldNamingPolicy.access$200(paramField.getName(), "_").toLowerCase();
    }
    }


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/gson/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */