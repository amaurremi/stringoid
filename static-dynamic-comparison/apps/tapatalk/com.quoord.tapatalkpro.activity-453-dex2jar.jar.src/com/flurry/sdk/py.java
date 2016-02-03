package com.flurry.sdk;

import java.io.IOException;

public class py {
    public static abstract class a<T>
            extends pf<T> {
        protected final jz e;
        protected final is f;

        protected a(Class<T> paramClass, jz paramjz, is paramis) {
            super();
            this.e = paramjz;
            this.f = paramis;
        }

        public final void a(T paramT, hf paramhf, jw paramjw)
                throws IOException, he {
            paramhf.b();
            b(paramT, paramhf, paramjw);
            paramhf.c();
        }

        public final void a(T paramT, hf paramhf, jw paramjw, jz paramjz)
                throws IOException, he {
            paramjz.c(paramT, paramhf);
            b(paramT, paramhf, paramjw);
            paramjz.f(paramT, paramhf);
        }

        protected abstract void b(T paramT, hf paramhf, jw paramjw)
                throws IOException, he;
    }

    @kb
    public static final class b
            extends py.a<boolean[]> {
        public b() {
            super(null, null);
        }

        public pf<?> a(jz paramjz) {
            return this;
        }

        public void a(boolean[] paramArrayOfBoolean, hf paramhf, jw paramjw)
                throws IOException, he {
            int i = 0;
            int j = paramArrayOfBoolean.length;
            while (i < j) {
                paramhf.a(paramArrayOfBoolean[i]);
                i += 1;
            }
        }
    }

    @kb
    public static final class c
            extends pw<byte[]> {
        public c() {
            super();
        }

        public void a(byte[] paramArrayOfByte, hf paramhf, jw paramjw)
                throws IOException, he {
            paramhf.a(paramArrayOfByte);
        }

        public void a(byte[] paramArrayOfByte, hf paramhf, jw paramjw, jz paramjz)
                throws IOException, he {
            paramjz.a(paramArrayOfByte, paramhf);
            paramhf.a(paramArrayOfByte);
            paramjz.d(paramArrayOfByte, paramhf);
        }
    }

    @kb
    public static final class d
            extends pw<char[]> {
        public d() {
            super();
        }

        private final void a(hf paramhf, char[] paramArrayOfChar)
                throws IOException, he {
            int i = 0;
            int j = paramArrayOfChar.length;
            while (i < j) {
                paramhf.a(paramArrayOfChar, i, 1);
                i += 1;
            }
        }

        public void a(char[] paramArrayOfChar, hf paramhf, jw paramjw)
                throws IOException, he {
            if (paramjw.a(ju.a.s)) {
                paramhf.b();
                a(paramhf, paramArrayOfChar);
                paramhf.c();
                return;
            }
            paramhf.a(paramArrayOfChar, 0, paramArrayOfChar.length);
        }

        public void a(char[] paramArrayOfChar, hf paramhf, jw paramjw, jz paramjz)
                throws IOException, he {
            if (paramjw.a(ju.a.s)) {
                paramjz.c(paramArrayOfChar, paramhf);
                a(paramhf, paramArrayOfChar);
                paramjz.f(paramArrayOfChar, paramhf);
                return;
            }
            paramjz.a(paramArrayOfChar, paramhf);
            paramhf.a(paramArrayOfChar, 0, paramArrayOfChar.length);
            paramjz.d(paramArrayOfChar, paramhf);
        }
    }

    @kb
    public static final class e
            extends py.a<double[]> {
        public e() {
            super(null, null);
        }

        public pf<?> a(jz paramjz) {
            return this;
        }

        public void a(double[] paramArrayOfDouble, hf paramhf, jw paramjw)
                throws IOException, he {
            int i = 0;
            int j = paramArrayOfDouble.length;
            while (i < j) {
                paramhf.a(paramArrayOfDouble[i]);
                i += 1;
            }
        }
    }

    @kb
    public static final class f
            extends py.a<float[]> {
        public f() {
            this(null);
        }

        public f(jz paramjz) {
            super(paramjz, null);
        }

        public pf<?> a(jz paramjz) {
            return new f(paramjz);
        }

        public void a(float[] paramArrayOfFloat, hf paramhf, jw paramjw)
                throws IOException, he {
            int i = 0;
            int j = paramArrayOfFloat.length;
            while (i < j) {
                paramhf.a(paramArrayOfFloat[i]);
                i += 1;
            }
        }
    }

    @kb
    public static final class g
            extends py.a<int[]> {
        public g() {
            super(null, null);
        }

        public pf<?> a(jz paramjz) {
            return this;
        }

        public void a(int[] paramArrayOfInt, hf paramhf, jw paramjw)
                throws IOException, he {
            int i = 0;
            int j = paramArrayOfInt.length;
            while (i < j) {
                paramhf.b(paramArrayOfInt[i]);
                i += 1;
            }
        }
    }

    @kb
    public static final class h
            extends py.a<long[]> {
        public h() {
            this(null);
        }

        public h(jz paramjz) {
            super(paramjz, null);
        }

        public pf<?> a(jz paramjz) {
            return new h(paramjz);
        }

        public void a(long[] paramArrayOfLong, hf paramhf, jw paramjw)
                throws IOException, he {
            int i = 0;
            int j = paramArrayOfLong.length;
            while (i < j) {
                paramhf.a(paramArrayOfLong[i]);
                i += 1;
            }
        }
    }

    @kb
    public static final class i
            extends py.a<short[]> {
        public i() {
            this(null);
        }

        public i(jz paramjz) {
            super(paramjz, null);
        }

        public pf<?> a(jz paramjz) {
            return new i(paramjz);
        }

        public void a(short[] paramArrayOfShort, hf paramhf, jw paramjw)
                throws IOException, he {
            int i = 0;
            int j = paramArrayOfShort.length;
            while (i < j) {
                paramhf.b(paramArrayOfShort[i]);
                i += 1;
            }
        }
    }

    @kb
    public static final class j
            extends py.a<String[]>
            implements jt {
        protected jk<Object> a;

        public j(is paramis) {
            super(null, paramis);
        }

        private void a(String[] paramArrayOfString, hf paramhf, jw paramjw, jk<Object> paramjk)
                throws IOException, he {
            int i = 0;
            int j = paramArrayOfString.length;
            if (i < j) {
                if (paramArrayOfString[i] == null) {
                    paramjw.a(paramhf);
                }
                for (; ; ) {
                    i += 1;
                    break;
                    paramjk.a(paramArrayOfString[i], paramhf, paramjw);
                }
            }
        }

        public pf<?> a(jz paramjz) {
            return this;
        }

        public void a(jw paramjw)
                throws jh {
            paramjw = paramjw.a(String.class, this.f);
            if ((paramjw != null) && (paramjw.getClass().getAnnotation(kb.class) == null)) {
                this.a = paramjw;
            }
        }

        public void a(String[] paramArrayOfString, hf paramhf, jw paramjw)
                throws IOException, he {
            int j = paramArrayOfString.length;
            if (j == 0) {
                return;
            }
            if (this.a != null) {
                a(paramArrayOfString, paramhf, paramjw, this.a);
                return;
            }
            int i = 0;
            label32:
            if (i < j) {
                if (paramArrayOfString[i] != null) {
                    break label59;
                }
                paramhf.f();
            }
            for (; ; ) {
                i += 1;
                break label32;
                break;
                label59:
                paramhf.b(paramArrayOfString[i]);
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/py.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */