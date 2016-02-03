package com.flurry.sdk;

public abstract class ov {
    public static ov a() {
        return b.a;
    }

    public abstract jk<Object> a(Class<?> paramClass);

    public final d a(sh paramsh, jw paramjw, is paramis)
            throws jh {
        paramjw = paramjw.a(paramsh, paramis);
        return new d(paramjw, a(paramsh.p(), paramjw));
    }

    public final d a(Class<?> paramClass, jw paramjw, is paramis)
            throws jh {
        paramjw = paramjw.a(paramClass, paramis);
        return new d(paramjw, a(paramClass, paramjw));
    }

    public abstract ov a(Class<?> paramClass, jk<Object> paramjk);

    static final class a
            extends ov {
        private final Class<?> a;
        private final Class<?> b;
        private final jk<Object> c;
        private final jk<Object> d;

        public a(Class<?> paramClass1, jk<Object> paramjk1, Class<?> paramClass2, jk<Object> paramjk2) {
            this.a = paramClass1;
            this.c = paramjk1;
            this.b = paramClass2;
            this.d = paramjk2;
        }

        public jk<Object> a(Class<?> paramClass) {
            if (paramClass == this.a) {
                return this.c;
            }
            if (paramClass == this.b) {
                return this.d;
            }
            return null;
        }

        public ov a(Class<?> paramClass, jk<Object> paramjk) {
            return new ov.c(new ov.f[]{new ov.f(this.a, this.c), new ov.f(this.b, this.d)});
        }
    }

    static final class b
            extends ov {
        protected static final b a = new b();

        public jk<Object> a(Class<?> paramClass) {
            return null;
        }

        public ov a(Class<?> paramClass, jk<Object> paramjk) {
            return new ov.e(paramClass, paramjk);
        }
    }

    static final class c
            extends ov {
        private final ov.f[] a;

        public c(ov.f[] paramArrayOff) {
            this.a = paramArrayOff;
        }

        public jk<Object> a(Class<?> paramClass) {
            int i = 0;
            int j = this.a.length;
            while (i < j) {
                ov.f localf = this.a[i];
                if (localf.a == paramClass) {
                    return localf.b;
                }
                i += 1;
            }
            return null;
        }

        public ov a(Class<?> paramClass, jk<Object> paramjk) {
            int i = this.a.length;
            if (i == 8) {
                return this;
            }
            ov.f[] arrayOff = new ov.f[i + 1];
            System.arraycopy(this.a, 0, arrayOff, 0, i);
            arrayOff[i] = new ov.f(paramClass, paramjk);
            return new c(arrayOff);
        }
    }

    public static final class d {
        public final jk<Object> a;
        public final ov b;

        public d(jk<Object> paramjk, ov paramov) {
            this.a = paramjk;
            this.b = paramov;
        }
    }

    static final class e
            extends ov {
        private final Class<?> a;
        private final jk<Object> b;

        public e(Class<?> paramClass, jk<Object> paramjk) {
            this.a = paramClass;
            this.b = paramjk;
        }

        public jk<Object> a(Class<?> paramClass) {
            if (paramClass == this.a) {
                return this.b;
            }
            return null;
        }

        public ov a(Class<?> paramClass, jk<Object> paramjk) {
            return new ov.a(this.a, this.b, paramClass, paramjk);
        }
    }

    static final class f {
        public final Class<?> a;
        public final jk<Object> b;

        public f(Class<?> paramClass, jk<Object> paramjk) {
            this.a = paramClass;
            this.b = paramjk;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/ov.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */