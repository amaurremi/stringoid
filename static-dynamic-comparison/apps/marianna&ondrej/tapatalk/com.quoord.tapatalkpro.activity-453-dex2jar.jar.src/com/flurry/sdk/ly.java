package com.flurry.sdk;

import java.io.IOException;
import java.util.HashMap;

public class ly {
    static final ly b = new ly();
    HashMap<sh, jg<Object>> a = new HashMap();

    protected ly() {
        a(Boolean.TYPE, new b());
        a(Byte.TYPE, new c());
        a(Short.TYPE, new i());
        a(Integer.TYPE, new g());
        a(Long.TYPE, new h());
        a(Float.TYPE, new f());
        a(Double.TYPE, new e());
        a(String.class, new j());
        a(Character.TYPE, new d());
    }

    public static HashMap<sh, jg<Object>> a() {
        return b.a;
    }

    private void a(Class<?> paramClass, jg<?> paramjg) {
        this.a.put(qs.a().a(paramClass), paramjg);
    }

    static abstract class a<T>
            extends lz<T> {
        protected a(Class<T> paramClass) {
            super();
        }

        public Object a(hj paramhj, iz paramiz, jy paramjy)
                throws IOException, hk {
            return paramjy.b(paramhj, paramiz);
        }
    }

    @kb
    static final class b
            extends ly.a<boolean[]> {
        public b() {
            super();
        }

        private final boolean[] c(hj paramhj, iz paramiz)
                throws IOException, hk {
            if ((paramhj.e() == hm.h) && (paramiz.a(iy.a.q)) && (paramhj.k().length() == 0)) {
                return null;
            }
            if (!paramiz.a(iy.a.o)) {
                throw paramiz.b(this.q);
            }
            return new boolean[]{n(paramhj, paramiz)};
        }

        public boolean[] b(hj paramhj, iz paramiz)
                throws IOException, hk {
            if (!paramhj.j()) {
                return c(paramhj, paramiz);
            }
            qw.b localb = paramiz.h().a();
            boolean[] arrayOfBoolean = (boolean[]) localb.a();
            int i = 0;
            boolean bool;
            if (paramhj.b() != hm.e) {
                bool = n(paramhj, paramiz);
                if (i < arrayOfBoolean.length) {
                    break label104;
                }
                arrayOfBoolean = (boolean[]) localb.a(arrayOfBoolean, i);
                i = 0;
            }
            label104:
            for (; ; ) {
                int j = i + 1;
                arrayOfBoolean[i] = bool;
                i = j;
                break;
                return (boolean[]) localb.b(arrayOfBoolean, i);
            }
        }
    }

    @kb
    static final class c
            extends ly.a<byte[]> {
        public c() {
            super();
        }

        private final byte[] c(hj paramhj, iz paramiz)
                throws IOException, hk {
            if ((paramhj.e() == hm.h) && (paramiz.a(iy.a.q)) && (paramhj.k().length() == 0)) {
                return null;
            }
            if (!paramiz.a(iy.a.o)) {
                throw paramiz.b(this.q);
            }
            hm localhm = paramhj.e();
            if ((localhm == hm.i) || (localhm == hm.j)) {
            }
            for (int i = paramhj.r(); ; i = 0) {
                return new byte[]{i};
                if (localhm != hm.m) {
                    throw paramiz.b(this.q.getComponentType());
                }
            }
        }

        public byte[] b(hj paramhj, iz paramiz)
                throws IOException, hk {
            Object localObject = paramhj.e();
            if (localObject == hm.h) {
                return paramhj.a(paramiz.c());
            }
            if (localObject == hm.g) {
                localObject = paramhj.z();
                if (localObject == null) {
                    return null;
                }
                if ((localObject instanceof byte[])) {
                    return (byte[]) localObject;
                }
            }
            if (!paramhj.j()) {
                return c(paramhj, paramiz);
            }
            qw.c localc = paramiz.h().b();
            localObject = (byte[]) localc.a();
            int j = 0;
            hm localhm = paramhj.b();
            int i;
            if (localhm != hm.e) {
                if ((localhm == hm.i) || (localhm == hm.j)) {
                    i = paramhj.r();
                    label132:
                    if (j < localObject.length) {
                        break label214;
                    }
                    localObject = (byte[]) localc.a(localObject, j);
                    j = 0;
                }
            }
            label214:
            for (; ; ) {
                int k = j + 1;
                localObject[j] = i;
                j = k;
                break;
                if (localhm != hm.m) {
                    throw paramiz.b(this.q.getComponentType());
                }
                i = 0;
                break label132;
                return (byte[]) localc.b(localObject, j);
            }
        }
    }

    @kb
    static final class d
            extends ly.a<char[]> {
        public d() {
            super();
        }

        public char[] b(hj paramhj, iz paramiz)
                throws IOException, hk {
            Object localObject1 = paramhj.e();
            if (localObject1 == hm.h) {
                paramiz = paramhj.l();
                int i = paramhj.n();
                int j = paramhj.m();
                paramhj = new char[j];
                System.arraycopy(paramiz, i, paramhj, 0, j);
                return paramhj;
            }
            if (paramhj.j()) {
                localObject1 = new StringBuilder(64);
                for (; ; ) {
                    Object localObject2 = paramhj.b();
                    if (localObject2 == hm.e) {
                        break;
                    }
                    if (localObject2 != hm.h) {
                        throw paramiz.b(Character.TYPE);
                    }
                    localObject2 = paramhj.k();
                    if (((String) localObject2).length() != 1) {
                        throw jh.a(paramhj, "Can not convert a JSON String of length " + ((String) localObject2).length() + " into a char element of char array");
                    }
                    ((StringBuilder) localObject1).append(((String) localObject2).charAt(0));
                }
                return ((StringBuilder) localObject1).toString().toCharArray();
            }
            if (localObject1 == hm.g) {
                paramhj = paramhj.z();
                if (paramhj == null) {
                    return null;
                }
                if ((paramhj instanceof char[])) {
                    return (char[]) paramhj;
                }
                if ((paramhj instanceof String)) {
                    return ((String) paramhj).toCharArray();
                }
                if ((paramhj instanceof byte[])) {
                    return hb.a().a((byte[]) paramhj, false).toCharArray();
                }
            }
            throw paramiz.b(this.q);
        }
    }

    @kb
    static final class e
            extends ly.a<double[]> {
        public e() {
            super();
        }

        private final double[] c(hj paramhj, iz paramiz)
                throws IOException, hk {
            if ((paramhj.e() == hm.h) && (paramiz.a(iy.a.q)) && (paramhj.k().length() == 0)) {
                return null;
            }
            if (!paramiz.a(iy.a.o)) {
                throw paramiz.b(this.q);
            }
            return new double[]{A(paramhj, paramiz)};
        }

        public double[] b(hj paramhj, iz paramiz)
                throws IOException, hk {
            if (!paramhj.j()) {
                return c(paramhj, paramiz);
            }
            qw.d locald = paramiz.h().g();
            double[] arrayOfDouble = (double[]) locald.a();
            int i = 0;
            double d;
            if (paramhj.b() != hm.e) {
                d = A(paramhj, paramiz);
                if (i < arrayOfDouble.length) {
                    break label110;
                }
                arrayOfDouble = (double[]) locald.a(arrayOfDouble, i);
                i = 0;
            }
            label110:
            for (; ; ) {
                int j = i + 1;
                arrayOfDouble[i] = d;
                i = j;
                break;
                return (double[]) locald.b(arrayOfDouble, i);
            }
        }
    }

    @kb
    static final class f
            extends ly.a<float[]> {
        public f() {
            super();
        }

        private final float[] c(hj paramhj, iz paramiz)
                throws IOException, hk {
            if ((paramhj.e() == hm.h) && (paramiz.a(iy.a.q)) && (paramhj.k().length() == 0)) {
                return null;
            }
            if (!paramiz.a(iy.a.o)) {
                throw paramiz.b(this.q);
            }
            return new float[]{y(paramhj, paramiz)};
        }

        public float[] b(hj paramhj, iz paramiz)
                throws IOException, hk {
            if (!paramhj.j()) {
                return c(paramhj, paramiz);
            }
            qw.e locale = paramiz.h().f();
            float[] arrayOfFloat = (float[]) locale.a();
            int i = 0;
            float f;
            if (paramhj.b() != hm.e) {
                f = y(paramhj, paramiz);
                if (i < arrayOfFloat.length) {
                    break label110;
                }
                arrayOfFloat = (float[]) locale.a(arrayOfFloat, i);
                i = 0;
            }
            label110:
            for (; ; ) {
                int j = i + 1;
                arrayOfFloat[i] = f;
                i = j;
                break;
                return (float[]) locale.b(arrayOfFloat, i);
            }
        }
    }

    @kb
    static final class g
            extends ly.a<int[]> {
        public g() {
            super();
        }

        private final int[] c(hj paramhj, iz paramiz)
                throws IOException, hk {
            if ((paramhj.e() == hm.h) && (paramiz.a(iy.a.q)) && (paramhj.k().length() == 0)) {
                return null;
            }
            if (!paramiz.a(iy.a.o)) {
                throw paramiz.b(this.q);
            }
            return new int[]{t(paramhj, paramiz)};
        }

        public int[] b(hj paramhj, iz paramiz)
                throws IOException, hk {
            if (!paramhj.j()) {
                return c(paramhj, paramiz);
            }
            qw.f localf = paramiz.h().d();
            int[] arrayOfInt = (int[]) localf.a();
            int i = 0;
            int k;
            if (paramhj.b() != hm.e) {
                k = t(paramhj, paramiz);
                if (i < arrayOfInt.length) {
                    break label104;
                }
                arrayOfInt = (int[]) localf.a(arrayOfInt, i);
                i = 0;
            }
            label104:
            for (; ; ) {
                int j = i + 1;
                arrayOfInt[i] = k;
                i = j;
                break;
                return (int[]) localf.b(arrayOfInt, i);
            }
        }
    }

    @kb
    static final class h
            extends ly.a<long[]> {
        public h() {
            super();
        }

        private final long[] c(hj paramhj, iz paramiz)
                throws IOException, hk {
            if ((paramhj.e() == hm.h) && (paramiz.a(iy.a.q)) && (paramhj.k().length() == 0)) {
                return null;
            }
            if (!paramiz.a(iy.a.o)) {
                throw paramiz.b(this.q);
            }
            return new long[]{w(paramhj, paramiz)};
        }

        public long[] b(hj paramhj, iz paramiz)
                throws IOException, hk {
            if (!paramhj.j()) {
                return c(paramhj, paramiz);
            }
            qw.g localg = paramiz.h().e();
            long[] arrayOfLong = (long[]) localg.a();
            int i = 0;
            long l;
            if (paramhj.b() != hm.e) {
                l = w(paramhj, paramiz);
                if (i < arrayOfLong.length) {
                    break label104;
                }
                arrayOfLong = (long[]) localg.a(arrayOfLong, i);
                i = 0;
            }
            label104:
            for (; ; ) {
                int j = i + 1;
                arrayOfLong[i] = l;
                i = j;
                break;
                return (long[]) localg.b(arrayOfLong, i);
            }
        }
    }

    @kb
    static final class i
            extends ly.a<short[]> {
        public i() {
            super();
        }

        private final short[] c(hj paramhj, iz paramiz)
                throws IOException, hk {
            if ((paramhj.e() == hm.h) && (paramiz.a(iy.a.q)) && (paramhj.k().length() == 0)) {
                return null;
            }
            if (!paramiz.a(iy.a.o)) {
                throw paramiz.b(this.q);
            }
            return new short[]{s(paramhj, paramiz)};
        }

        public short[] b(hj paramhj, iz paramiz)
                throws IOException, hk {
            if (!paramhj.j()) {
                return c(paramhj, paramiz);
            }
            qw.h localh = paramiz.h().c();
            short[] arrayOfShort = (short[]) localh.a();
            int j = 0;
            int i;
            if (paramhj.b() != hm.e) {
                i = s(paramhj, paramiz);
                if (j < arrayOfShort.length) {
                    break label110;
                }
                arrayOfShort = (short[]) localh.a(arrayOfShort, j);
                j = 0;
            }
            label110:
            for (; ; ) {
                int k = j + 1;
                arrayOfShort[j] = i;
                j = k;
                break;
                return (short[]) localh.b(arrayOfShort, j);
            }
        }
    }

    @kb
    static final class j
            extends ly.a<String[]> {
        public j() {
            super();
        }

        private final String[] c(hj paramhj, iz paramiz)
                throws IOException, hk {
            Object localObject = null;
            if (!paramiz.a(iy.a.o)) {
                if ((paramhj.e() == hm.h) && (paramiz.a(iy.a.q)) && (paramhj.k().length() == 0)) {
                    return null;
                }
                throw paramiz.b(this.q);
            }
            if (paramhj.e() == hm.m) {
            }
            for (paramhj = (hj) localObject; ; paramhj = paramhj.k()) {
                return new String[]{paramhj};
            }
        }

        public String[] b(hj paramhj, iz paramiz)
                throws IOException, hk {
            if (!paramhj.j()) {
                return c(paramhj, paramiz);
            }
            re localre = paramiz.g();
            Object[] arrayOfObject = localre.a();
            int i = 0;
            Object localObject = paramhj.b();
            if (localObject != hm.e) {
                if (localObject == hm.m) {
                    localObject = null;
                    label54:
                    if (i < arrayOfObject.length) {
                        break label120;
                    }
                    arrayOfObject = localre.a(arrayOfObject);
                    i = 0;
                }
            }
            label120:
            for (; ; ) {
                int j = i + 1;
                arrayOfObject[i] = localObject;
                i = j;
                break;
                localObject = paramhj.k();
                break label54;
                paramhj = (String[]) localre.a(arrayOfObject, i, String.class);
                paramiz.a(localre);
                return paramhj;
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/ly.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */