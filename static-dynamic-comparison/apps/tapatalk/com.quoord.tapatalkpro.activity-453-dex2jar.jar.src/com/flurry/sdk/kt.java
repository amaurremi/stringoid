package com.flurry.sdk;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public abstract class kt
        implements is {
    protected final String a;
    protected final sh b;
    protected final qv c;
    protected jg<Object> d;
    protected jy e;
    protected e f;
    protected String g;
    protected int h = -1;

    protected kt(kt paramkt) {
        this.a = paramkt.a;
        this.b = paramkt.b;
        this.c = paramkt.c;
        this.d = paramkt.d;
        this.e = paramkt.e;
        this.f = paramkt.f;
        this.g = paramkt.g;
        this.h = paramkt.h;
    }

    protected kt(kt paramkt, jg<Object> paramjg) {
        this.a = paramkt.a;
        this.b = paramkt.b;
        this.c = paramkt.c;
        this.e = paramkt.e;
        this.g = paramkt.g;
        this.h = paramkt.h;
        this.d = paramjg;
        if (paramjg == null) {
            this.f = null;
            return;
        }
        paramkt = paramjg.b();
        if (paramkt == null) {
        }
        for (paramkt = (kt) localObject; ; paramkt = new e(this.b, paramkt)) {
            this.f = paramkt;
            return;
        }
    }

    protected kt(String paramString, sh paramsh, jy paramjy, qv paramqv) {
        if ((paramString == null) || (paramString.length() == 0)) {
        }
        for (this.a = ""; ; this.a = sm.a.a(paramString)) {
            this.b = paramsh;
            this.c = paramqv;
            this.e = paramjy;
            return;
        }
    }

    public abstract kt a(jg<Object> paramjg);

    public sh a() {
        return this.b;
    }

    protected IOException a(Exception paramException)
            throws IOException {
        if ((paramException instanceof IOException)) {
            throw ((IOException) paramException);
        }
        Object localObject = paramException;
        if ((paramException instanceof RuntimeException)) {
            throw ((RuntimeException) paramException);
        }
        while (((Throwable) localObject).getCause() != null) {
            localObject = ((Throwable) localObject).getCause();
        }
        throw new jh(((Throwable) localObject).getMessage(), null, (Throwable) localObject);
    }

    public final Object a(hj paramhj, iz paramiz)
            throws IOException, hk {
        if (paramhj.e() == hm.m) {
            if (this.f == null) {
                return null;
            }
            return this.f.a(paramiz);
        }
        if (this.e != null) {
            return this.d.a(paramhj, paramiz, this.e);
        }
        return this.d.a(paramhj, paramiz);
    }

    public void a(int paramInt) {
        if (this.h != -1) {
            throw new IllegalStateException("Property '" + c() + "' already had index (" + this.h + "), trying to assign " + paramInt);
        }
        this.h = paramInt;
    }

    public abstract void a(hj paramhj, iz paramiz, Object paramObject)
            throws IOException, hk;

    protected void a(Exception paramException, Object paramObject)
            throws IOException {
        if ((paramException instanceof IllegalArgumentException)) {
            StringBuilder localStringBuilder;
            if (paramObject == null) {
                paramObject = "[NULL]";
                localStringBuilder = new StringBuilder("Problem deserializing property '").append(d());
                localStringBuilder.append("' (expected type: ").append(a());
                localStringBuilder.append("; actual type: ").append((String) paramObject).append(")");
                paramObject = paramException.getMessage();
                if (paramObject == null) {
                    break label106;
                }
                localStringBuilder.append(", problem: ").append((String) paramObject);
            }
            for (; ; ) {
                throw new jh(localStringBuilder.toString(), null, paramException);
                paramObject = paramObject.getClass().getName();
                break;
                label106:
                localStringBuilder.append(" (no error message provided)");
            }
        }
        a(paramException);
    }

    public abstract void a(Object paramObject1, Object paramObject2)
            throws IOException;

    public void a(String paramString) {
        this.g = paramString;
    }

    public abstract mq b();

    public final String c() {
        return this.a;
    }

    @Deprecated
    public String d() {
        return this.a;
    }

    public String e() {
        return this.g;
    }

    public boolean f() {
        return this.d != null;
    }

    public boolean g() {
        return this.e != null;
    }

    public jg<Object> h() {
        return this.d;
    }

    public jy i() {
        return this.e;
    }

    public int j() {
        return this.h;
    }

    public Object k() {
        return null;
    }

    public String toString() {
        return "[property '" + c() + "']";
    }

    public static final class a
            extends kt {
        protected final mp i;
        protected final Field j;

        protected a(a parama, jg<Object> paramjg) {
            super(paramjg);
            this.i = parama.i;
            this.j = parama.j;
        }

        public a(String paramString, sh paramsh, jy paramjy, qv paramqv, mp parammp) {
            super(paramsh, paramjy, paramqv);
            this.i = parammp;
            this.j = parammp.e();
        }

        public void a(hj paramhj, iz paramiz, Object paramObject)
                throws IOException, hk {
            a(paramObject, a(paramhj, paramiz));
        }

        public final void a(Object paramObject1, Object paramObject2)
                throws IOException {
            try {
                this.j.set(paramObject1, paramObject2);
                return;
            } catch (Exception paramObject1) {
                a((Exception) paramObject1, paramObject2);
            }
        }

        public a b(jg<Object> paramjg) {
            return new a(this, paramjg);
        }

        public mq b() {
            return this.i;
        }
    }

    public static final class b
            extends kt {
        protected final kt i;
        protected final Constructor<?> j;

        protected b(b paramb, jg<Object> paramjg) {
            super(paramjg);
            this.i = paramb.i.a(paramjg);
            this.j = paramb.j;
        }

        public b(kt paramkt, Constructor<?> paramConstructor) {
            super();
            this.i = paramkt;
            this.j = paramConstructor;
        }

        public void a(hj paramhj, iz paramiz, Object paramObject)
                throws IOException, hk {
            Object localObject1 = null;
            Object localObject2 = null;
            if (paramhj.e() == hm.m) {
                if (this.f == null) {
                    paramhj = (hj) localObject2;
                }
            }
            for (; ; ) {
                a(paramObject, paramhj);
                return;
                paramhj = this.f.a(paramiz);
                continue;
                if (this.e != null) {
                    paramhj = this.d.a(paramhj, paramiz, this.e);
                }
                try {
                    localObject2 = this.j.newInstance(new Object[]{paramObject});
                    localObject1 = localObject2;
                } catch (Exception localException) {
                    for (; ; ) {
                        qy.b(localException, "Failed to instantiate class " + this.j.getDeclaringClass().getName() + ", problem: " + localException.getMessage());
                    }
                }
                this.d.a(paramhj, paramiz, localObject1);
                paramhj = (hj) localObject1;
            }
        }

        public final void a(Object paramObject1, Object paramObject2)
                throws IOException {
            this.i.a(paramObject1, paramObject2);
        }

        public b b(jg<Object> paramjg) {
            return new b(this, paramjg);
        }

        public mq b() {
            return this.i.b();
        }
    }

    public static final class c
            extends kt {
        protected final String i;
        protected final boolean j;
        protected final kt k;
        protected final kt l;

        protected c(c paramc, jg<Object> paramjg) {
            super(paramjg);
            this.i = paramc.i;
            this.j = paramc.j;
            this.k = paramc.k;
            this.l = paramc.l;
        }

        public c(String paramString, kt paramkt1, kt paramkt2, qv paramqv, boolean paramBoolean) {
            super(paramkt1.a(), paramkt1.e, paramqv);
            this.i = paramString;
            this.k = paramkt1;
            this.l = paramkt2;
            this.j = paramBoolean;
        }

        public void a(hj paramhj, iz paramiz, Object paramObject)
                throws IOException, hk {
            a(paramObject, this.k.a(paramhj, paramiz));
        }

        public final void a(Object paramObject1, Object paramObject2)
                throws IOException {
            this.k.a(paramObject1, paramObject2);
            if (paramObject2 != null) {
                if (this.j) {
                    Object localObject;
                    if ((paramObject2 instanceof Object[])) {
                        paramObject2 = (Object[]) paramObject2;
                        int n = paramObject2.length;
                        int m = 0;
                        while (m < n) {
                            localObject = paramObject2[m];
                            if (localObject != null) {
                                this.l.a(localObject, paramObject1);
                            }
                            m += 1;
                        }
                    }
                    if ((paramObject2 instanceof Collection)) {
                        paramObject2 = ((Collection) paramObject2).iterator();
                        while (((Iterator) paramObject2).hasNext()) {
                            localObject = ((Iterator) paramObject2).next();
                            if (localObject != null) {
                                this.l.a(localObject, paramObject1);
                            }
                        }
                    }
                    if ((paramObject2 instanceof Map)) {
                        paramObject2 = ((Map) paramObject2).values().iterator();
                        while (((Iterator) paramObject2).hasNext()) {
                            localObject = ((Iterator) paramObject2).next();
                            if (localObject != null) {
                                this.l.a(localObject, paramObject1);
                            }
                        }
                    }
                    throw new IllegalStateException("Unsupported container type (" + paramObject2.getClass().getName() + ") when resolving reference '" + this.i + "'");
                }
                this.l.a(paramObject2, paramObject1);
            }
        }

        public c b(jg<Object> paramjg) {
            return new c(this, paramjg);
        }

        public mq b() {
            return this.k.b();
        }
    }

    public static final class d
            extends kt {
        protected final mr i;
        protected final Method j;

        protected d(d paramd, jg<Object> paramjg) {
            super(paramjg);
            this.i = paramd.i;
            this.j = paramd.j;
        }

        public d(String paramString, sh paramsh, jy paramjy, qv paramqv, mr parammr) {
            super(paramsh, paramjy, paramqv);
            this.i = parammr;
            this.j = parammr.e();
        }

        public void a(hj paramhj, iz paramiz, Object paramObject)
                throws IOException, hk {
            a(paramObject, a(paramhj, paramiz));
        }

        public final void a(Object paramObject1, Object paramObject2)
                throws IOException {
            try {
                this.j.invoke(paramObject1, new Object[]{paramObject2});
                return;
            } catch (Exception paramObject1) {
                a((Exception) paramObject1, paramObject2);
            }
        }

        public d b(jg<Object> paramjg) {
            return new d(this, paramjg);
        }

        public mq b() {
            return this.i;
        }
    }

    public static final class e {
        private final Object a;
        private final boolean b;
        private final Class<?> c;

        protected e(sh paramsh, Object paramObject) {
            this.a = paramObject;
            this.b = paramsh.t();
            this.c = paramsh.p();
        }

        public Object a(iz paramiz)
                throws hk {
            if ((this.b) && (paramiz.a(iy.a.l))) {
                throw paramiz.b("Can not map JSON null into type " + this.c.getName() + " (set DeserializationConfig.Feature.FAIL_ON_NULL_FOR_PRIMITIVES to 'false' to allow)");
            }
            return this.a;
        }
    }

    public static final class f
            extends kt {
        protected final mr i;
        protected final Method j;

        protected f(f paramf, jg<Object> paramjg) {
            super(paramjg);
            this.i = paramf.i;
            this.j = paramf.j;
        }

        public f(String paramString, sh paramsh, jy paramjy, qv paramqv, mr parammr) {
            super(paramsh, paramjy, paramqv);
            this.i = parammr;
            this.j = parammr.e();
        }

        public final void a(hj paramhj, iz paramiz, Object paramObject)
                throws IOException, hk {
            if (paramhj.e() == hm.m) {
                return;
            }
            try {
                paramObject = this.j.invoke(paramObject, new Object[0]);
                if (paramObject == null) {
                    throw new jh("Problem deserializing 'setterless' property '" + c() + "': get method returned null");
                }
            } catch (Exception paramhj) {
                a(paramhj);
                return;
            }
            this.d.a(paramhj, paramiz, paramObject);
        }

        public final void a(Object paramObject1, Object paramObject2)
                throws IOException {
            throw new UnsupportedOperationException("Should never call 'set' on setterless property");
        }

        public f b(jg<Object> paramjg) {
            return new f(this, paramjg);
        }

        public mq b() {
            return this.i;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/kt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */