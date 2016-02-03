package com.millennialmedia.a.a.b;

class z<K, V> {
    private af<K, V> a;

    public af<K, V> a() {
        af localaf2 = this.a;
        if (localaf2 == null) {
            return null;
        }
        Object localObject2 = localaf2.a;
        localaf2.a = null;
        af localaf1;
        for (Object localObject1 = localaf2.c; localObject1 != null; localObject1 = localaf1) {
            ((af) localObject1).a = ((af) localObject2);
            localaf1 = ((af) localObject1).b;
            localObject2 = localObject1;
        }
        this.a = ((af) localObject2);
        return localaf2;
    }

    void a(af<K, V> paramaf) {
        af<K, V> localaf = null;
        while (paramaf != null) {
            paramaf.a = localaf;
            af localaf1 = paramaf.b;
            localaf = paramaf;
            paramaf = localaf1;
        }
        this.a = localaf;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/a/a/b/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */