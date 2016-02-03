package com.flurry.sdk;

import java.io.IOException;

public class lv
        extends lk<hh> {
    private static final lv a = new lv();

    protected lv() {
        super(hh.class);
    }

    public static jg<? extends hh> a(Class<?> paramClass) {
        if (paramClass == rw.class) {
            return b.d();
        }
        if (paramClass == rj.class) {
            return a.d();
        }
        return a;
    }

    public hh b(hj paramhj, iz paramiz)
            throws IOException, hk {
        switch (1. a[paramhj.e().ordinal()])
        {
            default:
                return c(paramhj, paramiz, paramiz.e());
            case 1:
                return a(paramhj, paramiz, paramiz.e());
        }
        return b(paramhj, paramiz, paramiz.e());
    }

    static final class a
            extends lk<rj> {
        protected static final a a = new a();

        protected a() {
            super();
        }

        public static a d() {
            return a;
        }

        public rj b(hj paramhj, iz paramiz)
                throws IOException, hk {
            if (paramhj.j()) {
                return b(paramhj, paramiz, paramiz.e());
            }
            throw paramiz.b(rj.class);
        }
    }

    static final class b
            extends lk<rw> {
        protected static final b a = new b();

        protected b() {
            super();
        }

        public static b d() {
            return a;
        }

        public rw b(hj paramhj, iz paramiz)
                throws IOException, hk {
            if (paramhj.e() == hm.b) {
                paramhj.b();
                return a(paramhj, paramiz, paramiz.e());
            }
            if (paramhj.e() == hm.f) {
                return a(paramhj, paramiz, paramiz.e());
            }
            throw paramiz.b(rw.class);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/lv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */