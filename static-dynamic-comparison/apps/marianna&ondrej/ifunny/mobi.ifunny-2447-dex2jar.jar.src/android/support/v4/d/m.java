package android.support.v4.d;

import java.util.Map;

public class m<K, V> {
    static Object[] b;
    static int c;
    static Object[] d;
    static int e;
    int[] f;
    Object[] g;
    int h;

    public m() {
        this.f = c.a;
        this.g = c.c;
        this.h = 0;
    }

    public m(int paramInt) {
        if (paramInt == 0) {
            this.f = c.a;
            this.g = c.c;
        }
        for (; ; ) {
            this.h = 0;
            return;
            e(paramInt);
        }
    }

    private static void a(int[] paramArrayOfInt, Object[] paramArrayOfObject, int paramInt) {
        if (paramArrayOfInt.length == 8) {
            try {
                if (e < 10) {
                    paramArrayOfObject[0] = d;
                    paramArrayOfObject[1] = paramArrayOfInt;
                    paramInt = (paramInt << 1) - 1;
                    break label117;
                    d = paramArrayOfObject;
                    e += 1;
                }
                return;
            } finally {
            }
        }
        if (paramArrayOfInt.length == 4) {
        }
        for (; ; ) {
            try {
                if (c < 10) {
                    paramArrayOfObject[0] = b;
                    paramArrayOfObject[1] = paramArrayOfInt;
                    paramInt = (paramInt << 1) - 1;
                    break label134;
                    b = paramArrayOfObject;
                    c += 1;
                }
                return;
            } finally {
            }
            label117:
            while (paramInt >= 2) {
                paramArrayOfObject[paramInt] = null;
                paramInt -= 1;
            }
            break;
            return;
            label134:
            while (paramInt >= 2) {
                paramArrayOfObject[paramInt] = null;
                paramInt -= 1;
            }
        }
    }

    private void e(int paramInt) {
        if (paramInt == 8) {
        }
        for (; ; ) {
            try {
                if (d != null) {
                    Object[] arrayOfObject1 = d;
                    this.g = arrayOfObject1;
                    d = (Object[]) arrayOfObject1[0];
                    this.f = ((int[]) arrayOfObject1[1]);
                    arrayOfObject1[1] = null;
                    arrayOfObject1[0] = null;
                    e -= 1;
                    return;
                }
                this.f = new int[paramInt];
                this.g = new Object[paramInt << 1];
                return;
            } finally {
            }
            if (paramInt == 4) {
                try {
                    if (b != null) {
                        Object[] arrayOfObject2 = b;
                        this.g = arrayOfObject2;
                        b = (Object[]) arrayOfObject2[0];
                        this.f = ((int[]) arrayOfObject2[1]);
                        arrayOfObject2[1] = null;
                        arrayOfObject2[0] = null;
                        c -= 1;
                        return;
                    }
                } finally {
                }
            }
        }
    }

    int a() {
        int m = this.h;
        int i;
        if (m == 0) {
            i = -1;
        }
        int j;
        do {
            do {
                return i;
                j = c.a(this.f, m, 0);
                i = j;
            } while (j < 0);
            i = j;
        } while (this.g[(j << 1)] == null);
        int k = j + 1;
        while ((k < m) && (this.f[k] == 0)) {
            if (this.g[(k << 1)] == null) {
                return k;
            }
            k += 1;
        }
        j -= 1;
        for (; ; ) {
            if ((j < 0) || (this.f[j] != 0)) {
                break label121;
            }
            i = j;
            if (this.g[(j << 1)] == null) {
                break;
            }
            j -= 1;
        }
        label121:
        return k ^ 0xFFFFFFFF;
    }

    int a(Object paramObject) {
        int i = 1;
        int j = 1;
        int k = this.h * 2;
        Object[] arrayOfObject = this.g;
        if (paramObject == null) {
            i = j;
            while (i < k) {
                if (arrayOfObject[i] == null) {
                    return i >> 1;
                }
                i += 2;
            }
        }
        do {
            i += 2;
            if (i >= k) {
                break;
            }
        } while (!paramObject.equals(arrayOfObject[i]));
        return i >> 1;
        return -1;
    }

    int a(Object paramObject, int paramInt) {
        int m = this.h;
        int i;
        if (m == 0) {
            i = -1;
        }
        int j;
        do {
            do {
                return i;
                j = c.a(this.f, m, paramInt);
                i = j;
            } while (j < 0);
            i = j;
        } while (paramObject.equals(this.g[(j << 1)]));
        int k = j + 1;
        while ((k < m) && (this.f[k] == paramInt)) {
            if (paramObject.equals(this.g[(k << 1)])) {
                return k;
            }
            k += 1;
        }
        j -= 1;
        for (; ; ) {
            if ((j < 0) || (this.f[j] != paramInt)) {
                break label156;
            }
            i = j;
            if (paramObject.equals(this.g[(j << 1)])) {
                break;
            }
            j -= 1;
        }
        label156:
        return k ^ 0xFFFFFFFF;
    }

    public V a(int paramInt, V paramV) {
        paramInt = (paramInt << 1) + 1;
        Object localObject = this.g[paramInt];
        this.g[paramInt] = paramV;
        return (V) localObject;
    }

    public void a(int paramInt) {
        if (this.f.length < paramInt) {
            int[] arrayOfInt = this.f;
            Object[] arrayOfObject = this.g;
            e(paramInt);
            if (this.h > 0) {
                System.arraycopy(arrayOfInt, 0, this.f, 0, this.h);
                System.arraycopy(arrayOfObject, 0, this.g, 0, this.h << 1);
            }
            a(arrayOfInt, arrayOfObject, this.h);
        }
    }

    public K b(int paramInt) {
        return (K) this.g[(paramInt << 1)];
    }

    public V c(int paramInt) {
        return (V) this.g[((paramInt << 1) + 1)];
    }

    public void clear() {
        if (this.h != 0) {
            a(this.f, this.g, this.h);
            this.f = c.a;
            this.g = c.c;
            this.h = 0;
        }
    }

    public boolean containsKey(Object paramObject) {
        if (paramObject == null) {
            if (a() < 0) {
            }
        }
        while (a(paramObject, paramObject.hashCode()) >= 0) {
            return true;
            return false;
        }
        return false;
    }

    public boolean containsValue(Object paramObject) {
        return a(paramObject) >= 0;
    }

    public V d(int paramInt) {
        int i = 8;
        Object localObject = this.g[((paramInt << 1) + 1)];
        if (this.h <= 1) {
            a(this.f, this.g, this.h);
            this.f = c.a;
            this.g = c.c;
            this.h = 0;
        }
        int[] arrayOfInt;
        Object[] arrayOfObject;
        do {
            return (V) localObject;
            if ((this.f.length <= 8) || (this.h >= this.f.length / 3)) {
                break;
            }
            if (this.h > 8) {
                i = this.h + (this.h >> 1);
            }
            arrayOfInt = this.f;
            arrayOfObject = this.g;
            e(i);
            this.h -= 1;
            if (paramInt > 0) {
                System.arraycopy(arrayOfInt, 0, this.f, 0, paramInt);
                System.arraycopy(arrayOfObject, 0, this.g, 0, paramInt << 1);
            }
        } while (paramInt >= this.h);
        System.arraycopy(arrayOfInt, paramInt + 1, this.f, paramInt, this.h - paramInt);
        System.arraycopy(arrayOfObject, paramInt + 1 << 1, this.g, paramInt << 1, this.h - paramInt << 1);
        return (V) localObject;
        this.h -= 1;
        if (paramInt < this.h) {
            System.arraycopy(this.f, paramInt + 1, this.f, paramInt, this.h - paramInt);
            System.arraycopy(this.g, paramInt + 1 << 1, this.g, paramInt << 1, this.h - paramInt << 1);
        }
        this.g[(this.h << 1)] = null;
        this.g[((this.h << 1) + 1)] = null;
        return (V) localObject;
    }

    public boolean equals(Object paramObject) {
        if (this == paramObject) {
        }
        for (; ; ) {
            return true;
            if ((paramObject instanceof Map)) {
                paramObject = (Map) paramObject;
                if (size() != ((Map) paramObject).size()) {
                    return false;
                }
                int i = 0;
                try {
                    while (i < this.h) {
                        Object localObject1 = b(i);
                        Object localObject2 = c(i);
                        Object localObject3 = ((Map) paramObject).get(localObject1);
                        if (localObject2 == null) {
                            if (localObject3 != null) {
                                break label121;
                            }
                            if (!((Map) paramObject).containsKey(localObject1)) {
                                break label121;
                            }
                        } else {
                            boolean bool = localObject2.equals(localObject3);
                            if (!bool) {
                                return false;
                            }
                        }
                        i += 1;
                    }
                    return false;
                } catch (NullPointerException paramObject) {
                    return false;
                } catch (ClassCastException paramObject) {
                    return false;
                }
            }
        }
        label121:
        return false;
    }

    public V get(Object paramObject) {
        if (paramObject == null) {
        }
        for (int i = a(); i >= 0; i = a(paramObject, paramObject.hashCode())) {
            return (V) this.g[((i << 1) + 1)];
        }
        return null;
    }

    public int hashCode() {
        int[] arrayOfInt = this.f;
        Object[] arrayOfObject = this.g;
        int n = this.h;
        int i = 1;
        int j = 0;
        int k = 0;
        if (j < n) {
            Object localObject = arrayOfObject[i];
            int i1 = arrayOfInt[j];
            if (localObject == null) {
            }
            for (int m = 0; ; m = localObject.hashCode()) {
                k += (m ^ i1);
                j += 1;
                i += 2;
                break;
            }
        }
        return k;
    }

    public boolean isEmpty() {
        return this.h <= 0;
    }

    public V put(K paramK, V paramV) {
        int k = 8;
        int i;
        int j;
        if (paramK == null) {
            i = a();
            j = 0;
        }
        while (i >= 0) {
            i = (i << 1) + 1;
            paramK = this.g[i];
            this.g[i] = paramV;
            return paramK;
            j = paramK.hashCode();
            i = a(paramK, j);
        }
        int m = i ^ 0xFFFFFFFF;
        if (this.h >= this.f.length) {
            if (this.h < 8) {
                break label267;
            }
            i = this.h + (this.h >> 1);
        }
        for (; ; ) {
            int[] arrayOfInt = this.f;
            Object[] arrayOfObject = this.g;
            e(i);
            if (this.f.length > 0) {
                System.arraycopy(arrayOfInt, 0, this.f, 0, arrayOfInt.length);
                System.arraycopy(arrayOfObject, 0, this.g, 0, arrayOfObject.length);
            }
            a(arrayOfInt, arrayOfObject, this.h);
            if (m < this.h) {
                System.arraycopy(this.f, m, this.f, m + 1, this.h - m);
                System.arraycopy(this.g, m << 1, this.g, m + 1 << 1, this.h - m << 1);
            }
            this.f[m] = j;
            this.g[(m << 1)] = paramK;
            this.g[((m << 1) + 1)] = paramV;
            this.h += 1;
            return null;
            label267:
            i = k;
            if (this.h < 4) {
                i = 4;
            }
        }
    }

    public V remove(Object paramObject) {
        if (paramObject == null) {
        }
        for (int i = a(); i >= 0; i = a(paramObject, paramObject.hashCode())) {
            return (V) d(i);
        }
        return null;
    }

    public int size() {
        return this.h;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder localStringBuilder = new StringBuilder(this.h * 28);
        localStringBuilder.append('{');
        int i = 0;
        if (i < this.h) {
            if (i > 0) {
                localStringBuilder.append(", ");
            }
            Object localObject = b(i);
            if (localObject != this) {
                localStringBuilder.append(localObject);
                label70:
                localStringBuilder.append('=');
                localObject = c(i);
                if (localObject == this) {
                    break label111;
                }
                localStringBuilder.append(localObject);
            }
            for (; ; ) {
                i += 1;
                break;
                localStringBuilder.append("(this Map)");
                break label70;
                label111:
                localStringBuilder.append("(this Map)");
            }
        }
        localStringBuilder.append('}');
        return localStringBuilder.toString();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v4/d/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */