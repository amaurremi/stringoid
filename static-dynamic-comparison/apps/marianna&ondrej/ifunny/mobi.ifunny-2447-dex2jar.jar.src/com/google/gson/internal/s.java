package com.google.gson.internal;

class s<K, V> {
    private y<K, V> a;

    public y<K, V> a() {
        y localy2 = this.a;
        if (localy2 == null) {
            return null;
        }
        Object localObject2 = localy2.a;
        localy2.a = null;
        y localy1;
        for (Object localObject1 = localy2.c; localObject1 != null; localObject1 = localy1) {
            ((y) localObject1).a = ((y) localObject2);
            localy1 = ((y) localObject1).b;
            localObject2 = localObject1;
        }
        this.a = ((y) localObject2);
        return localy2;
    }

    void a(y<K, V> paramy) {
        y<K, V> localy = null;
        while (paramy != null) {
            paramy.a = localy;
            y localy1 = paramy.b;
            localy = paramy;
            paramy = localy1;
        }
        this.a = localy;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/gson/internal/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */