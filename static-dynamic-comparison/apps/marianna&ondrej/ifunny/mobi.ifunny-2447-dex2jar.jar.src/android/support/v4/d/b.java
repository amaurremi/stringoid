package android.support.v4.d;

import java.util.Map;

class b
        extends g<K, V> {
    b(a parama) {
    }

    protected int a() {
        return this.a.h;
    }

    protected int a(Object paramObject) {
        if (paramObject == null) {
            return this.a.a();
        }
        return this.a.a(paramObject, paramObject.hashCode());
    }

    protected Object a(int paramInt1, int paramInt2) {
        return this.a.g[((paramInt1 << 1) + paramInt2)];
    }

    protected V a(int paramInt, V paramV) {
        return (V) this.a.a(paramInt, paramV);
    }

    protected void a(int paramInt) {
        this.a.d(paramInt);
    }

    protected void a(K paramK, V paramV) {
        this.a.put(paramK, paramV);
    }

    protected int b(Object paramObject) {
        return this.a.a(paramObject);
    }

    protected Map<K, V> b() {
        return this.a;
    }

    protected void c() {
        this.a.clear();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v4/d/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */