package com.flurry.sdk;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;

class kw {
    final HashMap<qj, jg<Object>> a = new HashMap();

    private kw() {
        a(new mj());
        Object localObject = new mf();
        a((lz) localObject, String.class);
        a((lz) localObject, CharSequence.class);
        a(new lm());
        a(new lz.c(Boolean.class, null));
        a(new lz.d(Byte.class, null));
        a(new lz.l(Short.class, null));
        a(new lz.e(Character.class, null));
        a(new lz.h(Integer.class, null));
        a(new lz.i(Long.class, null));
        a(new lz.g(Float.class, null));
        a(new lz.f(Double.class, null));
        a(new lz.c(Boolean.TYPE, Boolean.FALSE));
        a(new lz.d(Byte.TYPE, Byte.valueOf((byte) 0)));
        a(new lz.l(Short.TYPE, Short.valueOf((short) 0)));
        a(new lz.e(Character.TYPE, Character.valueOf('\000')));
        a(new lz.h(Integer.TYPE, Integer.valueOf(0)));
        a(new lz.i(Long.TYPE, Long.valueOf(0L)));
        a(new lz.g(Float.TYPE, Float.valueOf(0.0F)));
        a(new lz.f(Double.TYPE, Double.valueOf(0.0D)));
        a(new lz.j());
        a(new lz.a());
        a(new lz.b());
        a(new ll());
        a(new lp());
        a(new ll(GregorianCalendar.class), GregorianCalendar.class);
        a(new lz.m());
        a(new mh());
        localObject = lt.d().iterator();
        while (((Iterator) localObject).hasNext()) {
            a((lt) ((Iterator) localObject).next());
        }
        a(new lz.n());
        a(new li());
        a(new mi());
        a(new lu());
    }

    public static HashMap<qj, jg<Object>> a() {
        return new kw().a;
    }

    private void a(lz<?> paramlz) {
        a(paramlz, paramlz.f());
    }

    private void a(lz<?> paramlz, Class<?> paramClass) {
        this.a.put(new qj(paramClass), paramlz);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/kw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */