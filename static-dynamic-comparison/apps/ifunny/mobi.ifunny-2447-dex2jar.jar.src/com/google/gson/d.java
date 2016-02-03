package com.google.gson;

import java.lang.reflect.Field;

enum d {
    d() {
        super(paramString,paramInt,null);
    }

    public String translateName(Field paramField) {
        return FieldNamingPolicy.access$100(FieldNamingPolicy.access$200(paramField.getName(), " "));
    }
    }


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/gson/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */