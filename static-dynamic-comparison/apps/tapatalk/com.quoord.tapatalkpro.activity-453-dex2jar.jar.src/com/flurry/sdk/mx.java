package com.flurry.sdk;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Collection;
import java.util.Map;

public class mx
        extends iu<mw> {
    protected static final mw a;
    protected static final mw b;
    protected static final mw c;
    protected static final mw d;
    @Deprecated
    public static final a e = new a(null);
    @Deprecated
    public static final d f = new d();
    @Deprecated
    public static final c g = new c();
    protected static final na h = new b(null);
    public static final mx i = new mx();

    static {
        mn localmn = mn.b(String.class, null, null);
        a = mw.a(null, qp.d(String.class), localmn);
        localmn = mn.b(Boolean.TYPE, null, null);
        b = mw.a(null, qp.d(Boolean.TYPE), localmn);
        localmn = mn.b(Integer.TYPE, null, null);
        c = mw.a(null, qp.d(Integer.TYPE), localmn);
        localmn = mn.b(Long.TYPE, null, null);
        d = mw.a(null, qp.d(Long.TYPE), localmn);
    }

    protected mw a(sh paramsh) {
        paramsh = paramsh.p();
        if (paramsh == String.class) {
            return a;
        }
        if (paramsh == Boolean.TYPE) {
            return b;
        }
        if (paramsh == Integer.TYPE) {
            return c;
        }
        if (paramsh == Long.TYPE) {
            return d;
        }
        return null;
    }

    protected nc a(jn<?> paramjn, mn parammn, sh paramsh, boolean paramBoolean) {
        return new nc(paramjn, paramBoolean, paramsh, parammn);
    }

    public nc a(jn<?> paramjn, sh paramsh, iu.a parama, boolean paramBoolean) {
        parama = c(paramjn, paramsh, parama);
        parama.a(h);
        parama.n();
        return a(paramjn, parama, paramsh, paramBoolean).k();
    }

    public mw b(jn<?> paramjn, sh paramsh, iu.a parama) {
        boolean bool = paramjn.b();
        iq localiq = paramjn.a();
        Class localClass = paramsh.p();
        if (bool) {
        }
        for (; ; ) {
            return mw.a(paramjn, paramsh, mn.a(localClass, localiq, parama));
            localiq = null;
        }
    }

    public mw b(ju paramju, sh paramsh, iu.a parama) {
        mw localmw2 = a(paramsh);
        mw localmw1 = localmw2;
        if (localmw2 == null) {
            localmw1 = mw.b(a(paramju, paramsh, parama, true));
        }
        return localmw1;
    }

    public mn c(jn<?> paramjn, sh paramsh, iu.a parama) {
        boolean bool = paramjn.b();
        paramjn = paramjn.a();
        paramsh = paramsh.p();
        if (bool) {
        }
        for (; ; ) {
            paramjn = mn.a(paramsh, paramjn, parama);
            paramjn.a(h);
            paramjn.a(true);
            return paramjn;
            paramjn = null;
        }
    }

    public mw c(iy paramiy, sh paramsh, iu.a parama) {
        mw localmw2 = a(paramsh);
        mw localmw1 = localmw2;
        if (localmw2 == null) {
            localmw1 = mw.a(a(paramiy, paramsh, parama, false));
        }
        return localmw1;
    }

    public mw d(iy paramiy, sh paramsh, iu.a parama) {
        mw localmw2 = a(paramsh);
        mw localmw1 = localmw2;
        if (localmw2 == null) {
            localmw1 = mw.a(a(paramiy, paramsh, parama, false));
        }
        return localmw1;
    }

    @Deprecated
    public static class a
            implements na {
        public boolean a(Method paramMethod) {
            return qy.a(paramMethod);
        }
    }

    static class b
            implements na {
        public boolean a(Method paramMethod) {
            if (Modifier.isStatic(paramMethod.getModifiers())) {
            }
            while (paramMethod.getParameterTypes().length > 2) {
                return false;
            }
            return true;
        }
    }

    @Deprecated
    public static final class c
            extends mx.d {
        public boolean a(Method paramMethod) {
            if (super.a(paramMethod)) {
            }
            do {
                return true;
                if (!qy.a(paramMethod)) {
                    return false;
                }
                paramMethod = paramMethod.getReturnType();
            } while ((Collection.class.isAssignableFrom(paramMethod)) || (Map.class.isAssignableFrom(paramMethod)));
            return false;
        }
    }

    @Deprecated
    public static class d
            implements na {
        public boolean a(Method paramMethod) {
            if (Modifier.isStatic(paramMethod.getModifiers())) {
                return false;
            }
            switch (paramMethod.getParameterTypes().length) {
                default:
                    return false;
                case 1:
                    return true;
            }
            return true;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/mx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */