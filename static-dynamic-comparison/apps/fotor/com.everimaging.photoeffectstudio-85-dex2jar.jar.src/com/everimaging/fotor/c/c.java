package com.everimaging.fotor.c;

import com.google.gson.Gson;

public class c {
    public int a;
    public int b;

    public c() {
    }

    public c(int paramInt1, int paramInt2) {
        this.a = paramInt1;
        this.b = paramInt2;
    }

    public String a() {
        return new Gson().toJson(this);
    }

    public boolean equals(Object paramObject) {
        if (!(paramObject instanceof c)) {
        }
        do {
            return false;
            paramObject = (c) paramObject;
        } while ((this.a != ((c) paramObject).a) || (this.b != ((c) paramObject).b));
        return true;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotor/c/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */