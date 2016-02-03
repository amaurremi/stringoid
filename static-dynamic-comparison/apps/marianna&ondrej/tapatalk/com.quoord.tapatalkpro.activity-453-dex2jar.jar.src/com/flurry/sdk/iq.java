package com.flurry.sdk;

import java.lang.annotation.Annotation;
import java.util.List;

public abstract class iq {
    public static iq a() {
        return nb.a;
    }

    public a a(mq parammq) {
        return null;
    }

    public kg.a a(mm parammm, kg.a parama) {
        return parama;
    }

    public ne<?> a(mn parammn, ne<?> paramne) {
        return paramne;
    }

    public ni<?> a(jn<?> paramjn, mn parammn, sh paramsh) {
        return null;
    }

    public ni<?> a(jn<?> paramjn, mq parammq, sh paramsh) {
        return null;
    }

    public Boolean a(mn parammn) {
        return null;
    }

    public Class<?> a(mm parammm, sh paramsh) {
        return null;
    }

    public abstract Class<?> a(mm parammm, sh paramsh, String paramString);

    public abstract String a(mt parammt);

    public abstract String a(Enum<?> paramEnum);

    public List<nf> a(mm parammm) {
        return null;
    }

    public abstract boolean a(mo parammo);

    public abstract boolean a(mp parammp);

    public abstract boolean a(mr parammr);

    public abstract boolean a(Annotation paramAnnotation);

    public ni<?> b(jn<?> paramjn, mq parammq, sh paramsh) {
        return null;
    }

    public Boolean b(mq parammq) {
        return null;
    }

    public Class<?> b(mm parammm, sh paramsh) {
        return null;
    }

    public abstract Class<?> b(mm parammm, sh paramsh, String paramString);

    public abstract Object b(mm parammm);

    public abstract String b(mn parammn);

    public abstract String b(mp parammp);

    public abstract String b(mr parammr);

    public Class<? extends jk<?>> c(mm parammm) {
        return null;
    }

    public abstract Class<?> c(mm parammm, sh paramsh, String paramString);

    public abstract String c(mp parammp);

    public boolean c(mq parammq) {
        if ((parammq instanceof mr)) {
            return a((mr) parammq);
        }
        if ((parammq instanceof mp)) {
            return a((mp) parammq);
        }
        if ((parammq instanceof mo)) {
            return a((mo) parammq);
        }
        return false;
    }

    public abstract boolean c(mr parammr);

    public abstract String[] c(mn parammn);

    public abstract Boolean d(mn parammn);

    public Class<? extends jk<?>> d(mm parammm) {
        return null;
    }

    public Object d(mq parammq) {
        return null;
    }

    public abstract String d(mr parammr);

    public Boolean e(mn parammn) {
        return null;
    }

    public abstract Class<?> e(mm parammm);

    public boolean e(mr parammr) {
        return false;
    }

    public abstract kg.b f(mm parammm);

    public Object f(mn parammn) {
        return null;
    }

    public boolean f(mr parammr) {
        return false;
    }

    public String g(mn parammn) {
        return null;
    }

    public abstract Class<?>[] g(mm parammm);

    public abstract Object h(mm parammm);

    public abstract String[] h(mn parammn);

    public abstract Boolean i(mn parammn);

    public abstract Class<? extends jl> i(mm parammm);

    public abstract Class<? extends jg<?>> j(mm parammm);

    public Object j(mn parammn) {
        return null;
    }

    public boolean k(mm parammm) {
        return false;
    }

    public static class a {
        private final a a;
        private final String b;

        public a(a parama, String paramString) {
            this.a = parama;
            this.b = paramString;
        }

        public static a a(String paramString) {
            return new a(a.a, paramString);
        }

        public static a b(String paramString) {
            return new a(a.b, paramString);
        }

        public String a() {
            return this.b;
        }

        public boolean b() {
            return this.a == a.a;
        }

        public boolean c() {
            return this.a == a.b;
        }

        public static enum a {
            private a() {
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/iq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */