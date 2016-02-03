package com.flurry.sdk;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public abstract class gq {
    public static final gq c = new o("null");
    public static final gq d = new o("boolean");
    public static final gq e = new o("int");
    public static final gq f = new o("long");
    public static final gq g = new o("float");
    public static final gq h = new o("double");
    public static final gq i = new o("string");
    public static final gq j = new o("bytes");
    public static final gq k = new o("fixed");
    public static final gq l = new o("enum");
    public static final gq m = new o("union");
    public static final gq n = new o("array-start");
    public static final gq o = new o("array-end");
    public static final gq p = new o("map-start");
    public static final gq q = new o("map-end");
    public static final gq r = new o("item-end");
    public static final gq s = new o("field-action");
    public static final gq t = new g(false, null);
    public static final gq u = new g(true, null);
    public static final gq v = new g(true, null);
    public static final gq w = new g(true, null);
    public static final gq x = new g(true, null);
    public static final gq y = new o("map-key-marker");
    public final i a;
    public final gq[] b;

    protected gq(i parami) {
        this(parami, null);
    }

    protected gq(i parami, gq[] paramArrayOfgq) {
        this.b = paramArrayOfgq;
        this.a = parami;
    }

    protected static int a(gq[] paramArrayOfgq, int paramInt) {
        int i2 = 0;
        int i1 = paramInt;
        paramInt = i2;
        if (i1 < paramArrayOfgq.length) {
            if ((paramArrayOfgq[i1] instanceof m)) {
                paramInt = ((m) paramArrayOfgq[i1]).a() + paramInt;
            }
            for (; ; ) {
                i1 += 1;
                break;
                paramInt += 1;
            }
        }
        return paramInt;
    }

    static gq a(gq paramgq1, gq paramgq2) {
        return new k(paramgq1, paramgq2, null);
    }

    static gq a(gq paramgq, gq... paramVarArgs) {
        return new j(paramgq, paramVarArgs, null);
    }

    static gq a(String paramString) {
        return new d(paramString, null);
    }

    static gq a(gq... paramVarArgs) {
        return new l(paramVarArgs, null);
    }

    static gq a(gq[] paramArrayOfgq, String[] paramArrayOfString) {
        return new a(paramArrayOfgq, paramArrayOfString, null);
    }

    static void a(gq[] paramArrayOfgq1, int paramInt1, gq[] paramArrayOfgq2, int paramInt2, Map<m, m> paramMap, Map<m, List<f>> paramMap1) {
        int i1 = paramInt2;
        paramInt2 = paramInt1;
        if (paramInt2 < paramArrayOfgq1.length) {
            Object localObject = paramArrayOfgq1[paramInt2].a(paramMap, paramMap1);
            gq[] arrayOfgq;
            if ((localObject instanceof m)) {
                arrayOfgq = ((gq) localObject).b;
                localObject = (List) paramMap1.get(localObject);
                if (localObject == null) {
                    System.arraycopy(arrayOfgq, 0, paramArrayOfgq2, i1, arrayOfgq.length);
                }
            }
            label69:
            for (paramInt1 = i1 + arrayOfgq.length; ; paramInt1 = i1 + 1) {
                paramInt2 += 1;
                i1 = paramInt1;
                break;
                ((List) localObject).add(new f(paramArrayOfgq2, i1));
                break label69;
                paramArrayOfgq2[i1] = localObject;
            }
        }
    }

    static gq b(gq... paramVarArgs) {
        return new m(paramVarArgs, null);
    }

    public int a() {
        return 1;
    }

    public gq a(Map<m, m> paramMap, Map<m, List<f>> paramMap1) {
        return this;
    }

    public static class a
            extends gq {
        public final String[] A;
        public final gq[] z;

        private a(gq[] paramArrayOfgq, String[] paramArrayOfString) {
            super();
            this.z = paramArrayOfgq;
            this.A = paramArrayOfString;
        }

        public gq a(int paramInt) {
            return this.z[paramInt];
        }

        public a b(Map<gq.m, gq.m> paramMap, Map<gq.m, List<gq.f>> paramMap1) {
            gq[] arrayOfgq = new gq[this.z.length];
            int i = 0;
            while (i < arrayOfgq.length) {
                arrayOfgq[i] = this.z[i].a(paramMap, paramMap1);
                i += 1;
            }
            return new a(arrayOfgq, this.A);
        }
    }

    public static class b
            extends gq.g {
        public final byte[] z;

        public b(byte[] paramArrayOfByte) {
            super();
            this.z = paramArrayOfByte;
        }
    }

    public static class c
            extends gq.h {
        public final Object[] z;

        public c(int paramInt, Object[] paramArrayOfObject) {
            super();
            this.z = paramArrayOfObject;
        }
    }

    public static class d
            extends gq.g {
        public final String z;

        private d(String paramString) {
            super();
            this.z = paramString;
        }
    }

    public static final class e
            extends gq.g {
        public final fn.f[] z;

        public e(fn.f[] paramArrayOff) {
            super();
            this.z = paramArrayOff;
        }
    }

    static class f {
        public final gq[] a;
        public final int b;

        public f(gq[] paramArrayOfgq, int paramInt) {
            this.a = paramArrayOfgq;
            this.b = paramInt;
        }
    }

    public static class g
            extends gq {
        public final boolean A;

        private g() {
            this(false);
        }

        private g(boolean paramBoolean) {
            super();
            this.A = paramBoolean;
        }
    }

    public static class h
            extends gq {
        public final int A;

        public h(int paramInt) {
            super();
            this.A = paramInt;
        }
    }

    public static enum i {
        private i() {
        }
    }

    public static class j
            extends gq {
        public final gq z;

        private j(gq paramgq, gq... paramVarArgs) {
            super(c(paramVarArgs));
            this.z = paramgq;
            this.b[0] = this;
        }

        private static gq[] c(gq[] paramArrayOfgq) {
            gq[] arrayOfgq = new gq[paramArrayOfgq.length + 1];
            System.arraycopy(paramArrayOfgq, 0, arrayOfgq, 1, paramArrayOfgq.length);
            return arrayOfgq;
        }

        public j b(Map<gq.m, gq.m> paramMap, Map<gq.m, List<gq.f>> paramMap1) {
            j localj = new j(this.z, new gq[a(this.b, 1)]);
            a(this.b, 1, localj.b, 1, paramMap, paramMap1);
            return localj;
        }
    }

    public static class k
            extends gq.g {
        public final gq B;
        public final gq z;

        private k(gq paramgq1, gq paramgq2) {
            super();
            this.z = paramgq1;
            this.B = paramgq2;
        }

        public k b(Map<gq.m, gq.m> paramMap, Map<gq.m, List<gq.f>> paramMap1) {
            return new k(this.z.a(paramMap, paramMap1), this.B.a(paramMap, paramMap1));
        }
    }

    public static class l
            extends gq {
        private l(gq... paramVarArgs) {
            super(c(paramVarArgs));
            this.b[0] = this;
        }

        private static gq[] c(gq[] paramArrayOfgq) {
            gq[] arrayOfgq = new gq[a(paramArrayOfgq, 0) + 1];
            a(paramArrayOfgq, 0, arrayOfgq, 1, new HashMap(), new HashMap());
            return arrayOfgq;
        }
    }

    public static class m
            extends gq
            implements Iterable<gq> {
        private m(gq[] paramArrayOfgq) {
            super(paramArrayOfgq);
        }

        public final int a() {
            return a(this.b, 0);
        }

        public m b(Map<m, m> paramMap, Map<m, List<gq.f>> paramMap1) {
            Object localObject2 = (m) paramMap.get(this);
            Object localObject1 = localObject2;
            if (localObject2 == null) {
                localObject1 = new m(new gq[a()]);
                paramMap.put(this, localObject1);
                localObject2 = new ArrayList();
                paramMap1.put(localObject1, localObject2);
                a(this.b, 0, ((m) localObject1).b, 0, paramMap, paramMap1);
                paramMap = ((List) localObject2).iterator();
                while (paramMap.hasNext()) {
                    localObject2 = (gq.f) paramMap.next();
                    System.arraycopy(((m) localObject1).b, 0, ((gq.f) localObject2).a, ((gq.f) localObject2).b, ((m) localObject1).b.length);
                }
                paramMap1.remove(localObject1);
            }
            return (m) localObject1;
        }

        public Iterator<gq> iterator() {
            new Iterator() {
                private int b = gq.m.this.b.length;

                public gq a() {
                    if (this.b > 0) {
                        gq[] arrayOfgq = gq.m.this.b;
                        int i = this.b - 1;
                        this.b = i;
                        return arrayOfgq[i];
                    }
                    throw new NoSuchElementException();
                }

                public boolean hasNext() {
                    return this.b > 0;
                }

                public void remove() {
                    throw new UnsupportedOperationException();
                }
            };
        }
    }

    public static class n
            extends gq.g {
        public final gq z;

        public n(gq paramgq) {
            super(null);
            this.z = paramgq;
        }

        public n b(Map<gq.m, gq.m> paramMap, Map<gq.m, List<gq.f>> paramMap1) {
            return new n(this.z.a(paramMap, paramMap1));
        }
    }

    static class o
            extends gq {
        private final String z;

        public o(String paramString) {
            super();
            this.z = paramString;
        }

        public String toString() {
            return this.z;
        }
    }

    public static class p
            extends gq.g {
        public final gq B;
        public final int z;

        public p(int paramInt, gq paramgq) {
            super();
            this.z = paramInt;
            this.B = paramgq;
        }

        public p b(Map<gq.m, gq.m> paramMap, Map<gq.m, List<gq.f>> paramMap1) {
            return new p(this.z, this.B.a(paramMap, paramMap1));
        }
    }

    public static class q
            extends gq.g {
        public q() {
            super();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/gq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */