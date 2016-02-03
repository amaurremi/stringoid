package android.support.v4.d;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class f<K, V> {
    private final LinkedHashMap<K, V> a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;

    public f(int paramInt) {
        if (paramInt <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.c = paramInt;
        this.a = new LinkedHashMap(0, 0.75F, true);
    }

    private int b(K paramK, V paramV) {
        int i = a(paramK, paramV);
        if (i < 0) {
            throw new IllegalStateException("Negative size: " + paramK + "=" + paramV);
        }
        return i;
    }

    protected int a(K paramK, V paramV) {
        return 1;
    }

    protected V a(K paramK) {
        return null;
    }

    protected void a(boolean paramBoolean, K paramK, V paramV1, V paramV2) {
    }

    public final int createCount() {
        try {
            int i = this.e;
            return i;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    public final void evictAll() {
        trimToSize(-1);
    }

    public final int evictionCount() {
        try {
            int i = this.f;
            return i;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    public final V get(K paramK) {
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
            localObject1 = a(paramK);
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
                this.b += b(paramK, localObject1);
            }
            trimToSize(this.c);
        } finally {
        }
        return (V) localObject1;
    }

    public final int hitCount() {
        try {
            int i = this.g;
            return i;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    public final int maxSize() {
        try {
            int i = this.c;
            return i;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    public final int missCount() {
        try {
            int i = this.h;
            return i;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    public final V put(K paramK, V paramV) {
        if ((paramK == null) || (paramV == null)) {
            throw new NullPointerException("key == null || value == null");
        }
        try {
            this.d += 1;
            this.b += b(paramK, paramV);
            Object localObject = this.a.put(paramK, paramV);
            if (localObject != null) {
                this.b -= b(paramK, localObject);
            }
            if (localObject != null) {
                a(false, paramK, localObject, paramV);
            }
            trimToSize(this.c);
            return (V) localObject;
        } finally {
        }
    }

    public final int putCount() {
        try {
            int i = this.d;
            return i;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    public final V remove(K paramK) {
        if (paramK == null) {
            throw new NullPointerException("key == null");
        }
        try {
            Object localObject = this.a.remove(paramK);
            if (localObject != null) {
                this.b -= b(paramK, localObject);
            }
            if (localObject != null) {
                a(false, paramK, localObject, null);
            }
            return (V) localObject;
        } finally {
        }
    }

    public final int size() {
        try {
            int i = this.b;
            return i;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    public final Map<K, V> snapshot() {
        try {
            LinkedHashMap localLinkedHashMap = new LinkedHashMap(this.a);
            return localLinkedHashMap;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
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

    public void trimToSize(int paramInt) {
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
            this.b -= b(localObject2, localObject3);
            this.f += 1;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v4/d/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */