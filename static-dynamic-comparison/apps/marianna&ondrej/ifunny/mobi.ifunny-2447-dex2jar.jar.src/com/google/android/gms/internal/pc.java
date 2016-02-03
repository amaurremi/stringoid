package com.google.android.gms.internal;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;

public class pc<K, V> {
    private final LinkedHashMap<K, V> a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;

    private int c(K paramK, V paramV) {
        int i = a(paramK, paramV);
        if (i < 0) {
            throw new IllegalStateException("Negative size: " + paramK + "=" + paramV);
        }
        return i;
    }

    protected int a(K paramK, V paramV) {
        return 1;
    }

    public final V a(K paramK) {
        if (paramK == null) {
            throw new NullPointerException("key == null");
        }
        Object localObject1;
        try {
            localObject1 = this.a.get(paramK);
            if (localObject1 != null) {
                this.g += 1;
                return (V) localObject1;
            }
            this.h += 1;
            localObject1 = b(paramK);
            if (localObject1 == null) {
                return null;
            }
        } finally {
        }
        try {
            this.e += 1;
            Object localObject2 = this.a.put(paramK, localObject1);
            if (localObject2 != null) {
                this.a.put(paramK, localObject2);
            }
            for (; ; ) {
                if (localObject2 == null) {
                    break;
                }
                a(false, paramK, localObject1, localObject2);
                return (V) localObject2;
                this.b += c(paramK, localObject1);
            }
            a(this.c);
        } finally {
        }
        return (V) localObject1;
    }

    public final void a() {
        a(-1);
    }

    public void a(int paramInt) {
        Object localObject3;
        Object localObject2;
        try {
            if ((this.b < 0) || ((this.a.isEmpty()) && (this.b != 0))) {
                throw new IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
            }
        } finally {
            throw ((Throwable) localObject1);
            if ((this.b <= paramInt) || (this.a.isEmpty())) {
                return;
            }
            localObject3 = (Map.Entry) this.a.entrySet().iterator().next();
            localObject2 = ((Map.Entry) localObject3).getKey();
            localObject3 = ((Map.Entry) localObject3).getValue();
            this.a.remove(localObject2);
            this.b -= c(localObject2, localObject3);
            this.f += 1;
        }
    }

    protected void a(boolean paramBoolean, K paramK, V paramV1, V paramV2) {
    }

    protected V b(K paramK) {
        return null;
    }

    public final V b(K paramK, V paramV) {
        if ((paramK == null) || (paramV == null)) {
            throw new NullPointerException("key == null || value == null");
        }
        try {
            this.d += 1;
            this.b += c(paramK, paramV);
            Object localObject = this.a.put(paramK, paramV);
            if (localObject != null) {
                this.b -= c(paramK, localObject);
            }
            if (localObject != null) {
                a(false, paramK, localObject, paramV);
            }
            a(this.c);
            return (V) localObject;
        } finally {
        }
    }

    public final String toString() {
        int i = 0;
        try {
            int j = this.g + this.h;
            if (j != 0) {
                i = this.g * 100 / j;
            }
            String str = String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", new Object[]{Integer.valueOf(this.c), Integer.valueOf(this.g), Integer.valueOf(this.h), Integer.valueOf(i)});
            return str;
        } finally {
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/pc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */