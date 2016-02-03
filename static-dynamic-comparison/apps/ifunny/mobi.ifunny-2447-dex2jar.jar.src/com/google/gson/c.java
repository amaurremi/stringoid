package com.google.gson;

import java.lang.reflect.Field;

enum c {
    c() {
        super(paramString,paramInt,null);
    }

    public String translateName(Field paramField) {
        return FieldNamingPolicy.access$100(paramField.getName());
    }
    }


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/gson/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */