package com.google.android.gms.internal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

class sr {
    private sp<?, ?> a;
    private Object b;
    private List<su> c = new ArrayList();

    private byte[] b() {
        byte[] arrayOfByte = new byte[a()];
        a(sm.a(arrayOfByte));
        return arrayOfByte;
    }

    int a() {
        int j;
        if (this.b != null) {
            j = this.a.a(this.b);
            return j;
        }
        Iterator localIterator = this.c.iterator();
        for (int i = 0; ; i = ((su) localIterator.next()).a() + i) {
            j = i;
            if (!localIterator.hasNext()) {
                break;
            }
        }
    }

    void a(sm paramsm) {
        if (this.b != null) {
            this.a.a(this.b, paramsm);
        }
        for (; ; ) {
            return;
            Iterator localIterator = this.c.iterator();
            while (localIterator.hasNext()) {
                ((su) localIterator.next()).a(paramsm);
            }
        }
    }

    public boolean equals(Object paramObject) {
        boolean bool2 = false;
        boolean bool1;
        if (paramObject == this) {
            bool1 = true;
        }
        do {
            do {
                return bool1;
                bool1 = bool2;
            } while (!(paramObject instanceof sr));
            paramObject = (sr) paramObject;
            if ((this.b == null) || (((sr) paramObject).b == null)) {
                break;
            }
            bool1 = bool2;
        } while (this.a != ((sr) paramObject).a);
        if (!this.a.b.isArray()) {
            return this.b.equals(((sr) paramObject).b);
        }
        if ((this.b instanceof byte[])) {
            return Arrays.equals((byte[]) this.b, (byte[]) ((sr) paramObject).b);
        }
        if ((this.b instanceof int[])) {
            return Arrays.equals((int[]) this.b, (int[]) ((sr) paramObject).b);
        }
        if ((this.b instanceof long[])) {
            return Arrays.equals((long[]) this.b, (long[]) ((sr) paramObject).b);
        }
        if ((this.b instanceof float[])) {
            return Arrays.equals((float[]) this.b, (float[]) ((sr) paramObject).b);
        }
        if ((this.b instanceof double[])) {
            return Arrays.equals((double[]) this.b, (double[]) ((sr) paramObject).b);
        }
        if ((this.b instanceof boolean[])) {
            return Arrays.equals((boolean[]) this.b, (boolean[]) ((sr) paramObject).b);
        }
        return Arrays.deepEquals((Object[]) this.b, (Object[]) ((sr) paramObject).b);
        if ((this.c != null) && (((sr) paramObject).c != null)) {
            return this.c.equals(((sr) paramObject).c);
        }
        try {
            bool1 = Arrays.equals(b(), ((sr) paramObject).b());
            return bool1;
        } catch (IOException paramObject) {
            throw new IllegalStateException((Throwable) paramObject);
        }
    }

    public int hashCode() {
        try {
            int i = Arrays.hashCode(b());
            return i + 527;
        } catch (IOException localIOException) {
            throw new IllegalStateException(localIOException);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/sr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */