package com.google.gson;

import java.lang.reflect.Field;

enum f {
    f() {
        super(paramString,paramInt,null);
    }

    public String translateName(Field paramField) {
        return FieldNamingPolicy.access$200(paramField.getName(), "-").toLowerCase();
    }
    }


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/gson/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */