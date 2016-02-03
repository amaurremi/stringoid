package com.google.android.gms.internal;

import java.io.IOException;
import java.lang.reflect.Array;

public class sp<M extends so<M>, T> {
    protected final int a;
    protected final Class<T> b;
    protected final int c;
    protected final boolean d;

    int a(Object paramObject) {
        if (this.d) {
            return b(paramObject);
        }
        return c(paramObject);
    }

    void a(Object paramObject, sm paramsm) {
        if (this.d) {
            c(paramObject, paramsm);
            return;
        }
        b(paramObject, paramsm);
    }

    protected int b(Object paramObject) {
        int j = 0;
        int m = Array.getLength(paramObject);
        int i = 0;
        while (i < m) {
            int k = j;
            if (Array.get(paramObject, i) != null) {
                k = j + c(Array.get(paramObject, i));
            }
            i += 1;
            j = k;
        }
        return j;
    }

    protected void b(Object paramObject, sm paramsm) {
        for (; ; ) {
            try {
                paramsm.e(this.c);
                switch (this.a) {
                    case 10:
                        throw new IllegalArgumentException("Unknown type " + this.a);
                }
            } catch (IOException paramObject) {
                throw new IllegalStateException((Throwable) paramObject);
            }
            paramObject = (ss) paramObject;
            int i = sv.a(this.c);
            paramsm.a((ss) paramObject);
            paramsm.c(i, 4);
            return;
            paramsm.b((ss) paramObject);
            return;
        }
    }

    protected int c(Object paramObject) {
        int i = sv.a(this.c);
        switch (this.a) {
            default:
                throw new IllegalArgumentException("Unknown type " + this.a);
            case 10:
                return sm.a(i, (ss) paramObject);
        }
        return sm.b(i, (ss) paramObject);
    }

    protected void c(Object paramObject, sm paramsm) {
        int j = Array.getLength(paramObject);
        int i = 0;
        while (i < j) {
            Object localObject = Array.get(paramObject, i);
            if (localObject != null) {
                b(localObject, paramsm);
            }
            i += 1;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/sp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */