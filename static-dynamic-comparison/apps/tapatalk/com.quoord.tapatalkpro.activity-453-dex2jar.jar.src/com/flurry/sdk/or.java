package com.flurry.sdk;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

public class or
        extends jw {
    public static final jk<Object> d = new ot("Null key for a Map not allowed in JSON (use a converting NullKeySerializer?)");
    @Deprecated
    public static final jk<Object> e = new qb();
    public static final jk<Object> f = new oy();
    protected final jv g;
    protected final ox h;
    protected final rh i;
    protected jk<Object> j = f;
    protected jk<Object> k;
    protected jk<Object> l = pq.a;
    protected jk<Object> m = d;
    protected final ow n;
    protected DateFormat o;

    public or() {
        super(null);
        this.g = null;
        this.h = new ox();
        this.n = null;
        this.i = new rh();
    }

    protected or(ju paramju, or paramor, jv paramjv) {
        super(paramju);
        if (paramju == null) {
            throw new NullPointerException();
        }
        this.g = paramjv;
        this.h = paramor.h;
        this.j = paramor.j;
        this.k = paramor.k;
        this.l = paramor.l;
        this.m = paramor.m;
        this.i = paramor.i;
        this.n = this.h.a();
    }

    protected jk<Object> a(jk<Object> paramjk, is paramis)
            throws jh {
        if (!(paramjk instanceof ix)) {
            return paramjk;
        }
        paramis = ((ix) paramjk).a(this.b, paramis);
        if (paramis != paramjk) {
            paramjk = paramis;
            if ((paramis instanceof jt)) {
                ((jt) paramis).a(this);
                paramjk = paramis;
            }
        }
        for (; ; ) {
            return paramjk;
        }
    }

    public jk<Object> a(sh paramsh, is paramis)
            throws jh {
        jk localjk2 = this.n.b(paramsh);
        jk localjk1 = localjk2;
        if (localjk2 == null) {
            localjk2 = this.h.a(paramsh);
            localjk1 = localjk2;
            if (localjk2 == null) {
                localjk2 = c(paramsh, paramis);
                localjk1 = localjk2;
                if (localjk2 == null) {
                    return a(paramsh.p());
                }
            }
        }
        return a(localjk1, paramis);
    }

    public jk<Object> a(sh paramsh, boolean paramBoolean, is paramis)
            throws jh {
        Object localObject = this.n.a(paramsh);
        if (localObject != null) {
        }
        jk localjk;
        do {
            return (jk<Object>) localObject;
            localjk = this.h.b(paramsh);
            localObject = localjk;
        } while (localjk != null);
        localObject = a(paramsh, paramis);
        paramis = this.g.b(this.b, paramsh, paramis);
        if (paramis != null) {
        }
        for (paramis = new a(paramis, (jk) localObject); ; paramis = (is) localObject) {
            localObject = paramis;
            if (!paramBoolean) {
                break;
            }
            this.h.a(paramsh, paramis);
            return paramis;
        }
    }

    public jk<Object> a(Class<?> paramClass) {
        return this.j;
    }

    public jk<Object> a(Class<?> paramClass, is paramis)
            throws jh {
        jk localjk2 = this.n.b(paramClass);
        jk localjk1 = localjk2;
        if (localjk2 == null) {
            localjk2 = this.h.a(paramClass);
            localjk1 = localjk2;
            if (localjk2 == null) {
                localjk2 = this.h.a(this.b.b(paramClass));
                localjk1 = localjk2;
                if (localjk2 == null) {
                    localjk2 = b(paramClass, paramis);
                    localjk1 = localjk2;
                    if (localjk2 == null) {
                        return a(paramClass);
                    }
                }
            }
        }
        return a(localjk1, paramis);
    }

    public jk<Object> a(Class<?> paramClass, boolean paramBoolean, is paramis)
            throws jh {
        Object localObject = this.n.a(paramClass);
        if (localObject != null) {
        }
        jk localjk;
        do {
            return (jk<Object>) localObject;
            localjk = this.h.b(paramClass);
            localObject = localjk;
        } while (localjk != null);
        localObject = a(paramClass, paramis);
        paramis = this.g.b(this.b, this.b.b(paramClass), paramis);
        if (paramis != null) {
        }
        for (paramis = new a(paramis, (jk) localObject); ; paramis = (is) localObject) {
            localObject = paramis;
            if (!paramBoolean) {
                break;
            }
            this.h.a(paramClass, paramis);
            return paramis;
        }
    }

    protected or a(ju paramju, jv paramjv) {
        return new or(paramju, this, paramjv);
    }

    public final void a(long paramLong, hf paramhf)
            throws IOException, hk {
        if (a(ju.a.q)) {
            paramhf.a(paramLong);
            return;
        }
        if (this.o == null) {
            this.o = ((DateFormat) this.b.n().clone());
        }
        paramhf.b(this.o.format(new Date(paramLong)));
    }

    protected void a(hf paramhf, Object paramObject)
            throws IOException, hk {
        Object localObject;
        int i1;
        if (paramObject == null) {
            localObject = d();
            i1 = 0;
        }
        for (; ; ) {
            try {
                ((jk) localObject).a(paramObject, paramhf, this);
                if (i1 != 0) {
                    paramhf.e();
                }
                return;
            } catch (IOException paramhf) {
                jk localjk;
                boolean bool;
                throw paramhf;
            } catch (Exception localException) {
                paramObject = localException.getMessage();
                paramhf = (hf) paramObject;
                if (paramObject != null) {
                    continue;
                }
                paramhf = "[no message for " + localException.getClass().getName() + "]";
                throw new jh(paramhf, localException);
            }
            localjk = a(paramObject.getClass(), true, null);
            bool = this.b.a(ju.a.j);
            i1 = bool;
            localObject = localjk;
            if (bool) {
                paramhf.d();
                paramhf.a(this.i.a(paramObject.getClass(), this.b));
                i1 = bool;
                localObject = localjk;
            }
        }
    }

    public final void a(ju paramju, hf paramhf, Object paramObject, jv paramjv)
            throws IOException, he {
        if (paramjv == null) {
            throw new IllegalArgumentException("Can not pass null serializerFactory");
        }
        paramju = a(paramju, paramjv);
        if (paramju.getClass() != getClass()) {
            throw new IllegalStateException("Broken serializer provider: createInstance returned instance of type " + paramju.getClass() + "; blueprint of type " + getClass());
        }
        paramju.a(paramhf, paramObject);
    }

    public final void a(Date paramDate, hf paramhf)
            throws IOException, hk {
        if (a(ju.a.q)) {
            paramhf.a(paramDate.getTime());
            return;
        }
        if (this.o == null) {
            this.o = ((DateFormat) this.b.n().clone());
        }
        paramhf.b(this.o.format(paramDate));
    }

    public jk<Object> b(sh paramsh, is paramis)
            throws jh {
        jk localjk2 = this.g.c(this.b, paramsh, paramis);
        jk localjk1 = localjk2;
        if (localjk2 == null) {
            if (this.k != null) {
                break label61;
            }
        }
        label61:
        for (localjk1 = qc.a(paramsh); ; localjk1 = this.k) {
            paramsh = localjk1;
            if ((localjk1 instanceof ix)) {
                paramsh = ((ix) localjk1).a(this.b, paramis);
            }
            return paramsh;
        }
    }

    protected jk<Object> b(Class<?> paramClass, is paramis)
            throws jh {
        try {
            paramis = d(this.b.b(paramClass), paramis);
            if (paramis != null) {
                this.h.a(paramClass, paramis, this);
            }
            return paramis;
        } catch (IllegalArgumentException paramClass) {
            throw new jh(paramClass.getMessage(), null, paramClass);
        }
    }

    public void b(long paramLong, hf paramhf)
            throws IOException, hk {
        if (a(ju.a.r)) {
            paramhf.a(String.valueOf(paramLong));
            return;
        }
        if (this.o == null) {
            this.o = ((DateFormat) this.b.n().clone());
        }
        paramhf.a(this.o.format(new Date(paramLong)));
    }

    public void b(Date paramDate, hf paramhf)
            throws IOException, hk {
        if (a(ju.a.r)) {
            paramhf.a(String.valueOf(paramDate.getTime()));
            return;
        }
        if (this.o == null) {
            this.o = ((DateFormat) this.b.n().clone());
        }
        paramhf.a(this.o.format(paramDate));
    }

    public jk<Object> c() {
        return this.m;
    }

    protected jk<Object> c(sh paramsh, is paramis)
            throws jh {
        try {
            paramis = d(paramsh, paramis);
            if (paramis != null) {
                this.h.a(paramsh, paramis, this);
            }
            return paramis;
        } catch (IllegalArgumentException paramsh) {
            throw new jh(paramsh.getMessage(), null, paramsh);
        }
    }

    public jk<Object> d() {
        return this.l;
    }

    protected jk<Object> d(sh paramsh, is paramis)
            throws jh {
        return this.g.a(this.b, paramsh, paramis);
    }

    static final class a
            extends jk<Object> {
        protected final jz a;
        protected final jk<Object> b;

        public a(jz paramjz, jk<Object> paramjk) {
            this.a = paramjz;
            this.b = paramjk;
        }

        public void a(Object paramObject, hf paramhf, jw paramjw)
                throws IOException, hk {
            this.b.a(paramObject, paramhf, paramjw, this.a);
        }

        public void a(Object paramObject, hf paramhf, jw paramjw, jz paramjz)
                throws IOException, hk {
            this.b.a(paramObject, paramhf, paramjw, paramjz);
        }

        public Class<Object> c() {
            return Object.class;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/or.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */