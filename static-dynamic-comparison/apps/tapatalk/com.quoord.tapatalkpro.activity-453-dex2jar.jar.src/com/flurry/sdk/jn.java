package com.flurry.sdk;

import java.text.DateFormat;
import java.util.HashMap;

public abstract class jn<T extends jn<T>>
        implements iu.a {
    protected static final DateFormat d = ri.f;
    protected a e;
    protected HashMap<qj, Class<?>> f;
    protected boolean g;
    protected ng h;

    protected jn(iu<? extends ir> paramiu, iq paramiq, ne<?> paramne, ng paramng, jr paramjr, qs paramqs, je paramje) {
        this.e = new a(paramiu, paramiq, paramne, paramjr, paramqs, null, d, paramje);
        this.h = paramng;
        this.g = true;
    }

    protected jn(jn<T> paramjn, a parama, ng paramng) {
        this.e = parama;
        this.h = paramng;
        this.g = true;
        this.f = paramjn.f;
    }

    public iq a() {
        return this.e.b();
    }

    public abstract <DESC extends ir> DESC a(sh paramsh);

    public sh a(sh paramsh, Class<?> paramClass) {
        return m().a(paramsh, paramClass);
    }

    public final Class<?> a(Class<?> paramClass) {
        if (this.f == null) {
            return null;
        }
        return (Class) this.f.get(new qj(paramClass));
    }

    public final void a(Class<?> paramClass1, Class<?> paramClass2) {
        if (this.f == null) {
            this.g = false;
            this.f = new HashMap();
        }
        for (; ; ) {
            this.f.put(new qj(paramClass1), paramClass2);
            return;
            if (this.g) {
                this.g = false;
                this.f = new HashMap(this.f);
            }
        }
    }

    public final sh b(Class<?> paramClass) {
        return m().a(paramClass, (qr) null);
    }

    public abstract boolean b();

    public <DESC extends ir> DESC c(Class<?> paramClass) {
        return a(b(paramClass));
    }

    public abstract boolean c();

    public ni<?> d(mm parammm, Class<? extends ni<?>> paramClass) {
        je localje = k();
        if (localje != null) {
            parammm = localje.a(this, parammm, paramClass);
            if (parammm != null) {
                return parammm;
            }
        }
        return (ni) qy.b(paramClass, c());
    }

    public final ni<?> d(sh paramsh) {
        return this.e.f();
    }

    public abstract boolean d();

    public ne<?> e() {
        return this.e.c();
    }

    public nh e(mm parammm, Class<? extends nh> paramClass) {
        je localje = k();
        if (localje != null) {
            parammm = localje.b(this, parammm, paramClass);
            if (parammm != null) {
                return parammm;
            }
        }
        return (nh) qy.b(paramClass, c());
    }

    public iu<? extends ir> i() {
        return this.e.a();
    }

    public final jr j() {
        return this.e.d();
    }

    public final je k() {
        return this.e.h();
    }

    public final ng l() {
        if (this.h == null) {
            this.h = new nt();
        }
        return this.h;
    }

    public final qs m() {
        return this.e.e();
    }

    public final DateFormat n() {
        return this.e.g();
    }

    public static class a {
        protected final iu<? extends ir> a;
        protected final iq b;
        protected final ne<?> c;
        protected final jr d;
        protected final qs e;
        protected final ni<?> f;
        protected final DateFormat g;
        protected final je h;

        public a(iu<? extends ir> paramiu, iq paramiq, ne<?> paramne, jr paramjr, qs paramqs, ni<?> paramni, DateFormat paramDateFormat, je paramje) {
            this.a = paramiu;
            this.b = paramiq;
            this.c = paramne;
            this.d = paramjr;
            this.e = paramqs;
            this.f = paramni;
            this.g = paramDateFormat;
            this.h = paramje;
        }

        public iu<? extends ir> a() {
            return this.a;
        }

        public iq b() {
            return this.b;
        }

        public ne<?> c() {
            return this.c;
        }

        public jr d() {
            return this.d;
        }

        public qs e() {
            return this.e;
        }

        public ni<?> f() {
            return this.f;
        }

        public DateFormat g() {
            return this.g;
        }

        public je h() {
            return this.h;
        }
    }

    public static abstract interface b {
        public abstract boolean a();

        public abstract int b();
    }

    static abstract class c<CFG extends jn.b, T extends c<CFG, T>>
            extends jn<T> {
        protected int i;

        protected c(iu<? extends ir> paramiu, iq paramiq, ne<?> paramne, ng paramng, jr paramjr, qs paramqs, je paramje, int paramInt) {
            super(paramiq, paramne, paramng, paramjr, paramqs, paramje);
            this.i = paramInt;
        }

        protected c(c<CFG, T> paramc, jn.a parama, ng paramng) {
            super(parama, paramng);
            this.i = paramc.i;
        }

        static <F extends Enum<F>,extends jn.b>

        int d(Class<F> paramClass) {
            paramClass = (Enum[]) paramClass.getEnumConstants();
            int m = paramClass.length;
            int k = 0;
            int j = 0;
            if (k < m) {
                Object localObject = paramClass[k];
                if (!((jn.b) localObject).a()) {
                    break label60;
                }
                j = ((jn.b) localObject).b() | j;
            }
            label60:
            for (; ; ) {
                k += 1;
                break;
                return j;
            }
        }

        @Deprecated
        public void a(CFG paramCFG) {
            this.i &= (paramCFG.b() ^ 0xFFFFFFFF);
        }

        @Deprecated
        public void a(CFG paramCFG, boolean paramBoolean) {
            if (paramBoolean) {
                b(paramCFG);
                return;
            }
            a(paramCFG);
        }

        @Deprecated
        public void b(CFG paramCFG) {
            this.i |= paramCFG.b();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/jn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */