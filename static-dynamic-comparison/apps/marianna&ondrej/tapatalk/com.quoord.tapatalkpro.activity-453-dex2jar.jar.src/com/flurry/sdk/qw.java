package com.flurry.sdk;

import java.lang.reflect.Array;
import java.util.HashSet;
import java.util.Iterator;
import java.util.NoSuchElementException;

public final class qw {
    b a = null;
    c b = null;
    h c = null;
    f d = null;
    g e = null;
    e f = null;
    d g = null;

    public static <T> HashSet<T> a(T[] paramArrayOfT) {
        HashSet localHashSet = new HashSet();
        if (paramArrayOfT != null) {
            int j = paramArrayOfT.length;
            int i = 0;
            while (i < j) {
                localHashSet.add(paramArrayOfT[i]);
                i += 1;
            }
        }
        return localHashSet;
    }

    public static <T> T[] a(T[] paramArrayOfT, T paramT) {
        int j = paramArrayOfT.length;
        int i = 0;
        while (i < j) {
            if (paramArrayOfT[i] == paramT) {
                if (i == 0) {
                    return paramArrayOfT;
                }
                arrayOfObject = (Object[]) Array.newInstance(paramArrayOfT.getClass().getComponentType(), j);
                System.arraycopy(paramArrayOfT, 0, arrayOfObject, 1, i);
                paramArrayOfT[0] = paramT;
                return arrayOfObject;
            }
            i += 1;
        }
        Object[] arrayOfObject = (Object[]) Array.newInstance(paramArrayOfT.getClass().getComponentType(), j + 1);
        if (j > 0) {
            System.arraycopy(paramArrayOfT, 0, arrayOfObject, 1, j);
        }
        arrayOfObject[0] = paramT;
        return arrayOfObject;
    }

    public static <T> Iterable<T> b(T[] paramArrayOfT) {
        return new a(paramArrayOfT);
    }

    public b a() {
        if (this.a == null) {
            this.a = new b();
        }
        return this.a;
    }

    public c b() {
        if (this.b == null) {
            this.b = new c();
        }
        return this.b;
    }

    public h c() {
        if (this.c == null) {
            this.c = new h();
        }
        return this.c;
    }

    public f d() {
        if (this.d == null) {
            this.d = new f();
        }
        return this.d;
    }

    public g e() {
        if (this.e == null) {
            this.e = new g();
        }
        return this.e;
    }

    public e f() {
        if (this.f == null) {
            this.f = new e();
        }
        return this.f;
    }

    public d g() {
        if (this.g == null) {
            this.g = new d();
        }
        return this.g;
    }

    static final class a<T>
            implements Iterable<T>, Iterator<T> {
        private final T[] a;
        private int b;

        public a(T[] paramArrayOfT) {
            this.a = paramArrayOfT;
            this.b = 0;
        }

        public boolean hasNext() {
            return this.b < this.a.length;
        }

        public Iterator<T> iterator() {
            return this;
        }

        public T next() {
            if (this.b >= this.a.length) {
                throw new NoSuchElementException();
            }
            Object[] arrayOfObject = this.a;
            int i = this.b;
            this.b = (i + 1);
            return (T) arrayOfObject[i];
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public static final class b
            extends rf<boolean[]> {
        public final boolean[] a(int paramInt) {
            return new boolean[paramInt];
        }
    }

    public static final class c
            extends rf<byte[]> {
        public final byte[] a(int paramInt) {
            return new byte[paramInt];
        }
    }

    public static final class d
            extends rf<double[]> {
        public final double[] a(int paramInt) {
            return new double[paramInt];
        }
    }

    public static final class e
            extends rf<float[]> {
        public final float[] a(int paramInt) {
            return new float[paramInt];
        }
    }

    public static final class f
            extends rf<int[]> {
        public final int[] a(int paramInt) {
            return new int[paramInt];
        }
    }

    public static final class g
            extends rf<long[]> {
        public final long[] a(int paramInt) {
            return new long[paramInt];
        }
    }

    public static final class h
            extends rf<short[]> {
        public final short[] a(int paramInt) {
            return new short[paramInt];
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/qw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */