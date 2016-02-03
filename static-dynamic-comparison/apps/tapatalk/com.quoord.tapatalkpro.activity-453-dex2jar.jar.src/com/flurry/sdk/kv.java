package com.flurry.sdk;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class kv
        extends jc {
    protected final ConcurrentHashMap<sh, jg<Object>> a = new ConcurrentHashMap(64, 0.75F, 2);
    protected final HashMap<sh, jg<Object>> b = new HashMap(8);
    protected final rh c;
    protected jb d;

    public kv() {
        this(kq.h);
    }

    public kv(jb paramjb) {
        this.d = paramjb;
        this.c = new rh();
    }

    public im a(iy paramiy, sh paramsh)
            throws jh {
        return this.c.a(paramsh, paramiy);
    }

    public jc a(ip paramip) {
        return a(this.d.a(paramip));
    }

    public jc a(jd paramjd) {
        return a(this.d.a(paramjd));
    }

    public jc a(jm paramjm) {
        return a(this.d.a(paramjm));
    }

    public jc a(ky paramky) {
        return a(this.d.a(paramky));
    }

    public jg<Object> a(iy paramiy, sh paramsh, is paramis)
            throws jh {
        Object localObject = a(paramsh);
        if (localObject != null) {
            paramsh = (sh) localObject;
            if ((localObject instanceof iv)) {
                paramsh = ((iv) localObject).a(paramiy, paramis);
            }
        }
        do {
            return paramsh;
            jg localjg = d(paramiy, paramsh, paramis);
            localObject = localjg;
            if (localjg == null) {
                localObject = b(paramsh);
            }
            paramsh = (sh) localObject;
        } while (!(localObject instanceof iv));
        return ((iv) localObject).a(paramiy, paramis);
    }

    protected jg<Object> a(sh paramsh) {
        if (paramsh == null) {
            throw new IllegalArgumentException();
        }
        return (jg) this.a.get(paramsh);
    }

    public kv a(jb paramjb) {
        if (getClass() != kv.class) {
            throw new IllegalStateException("DeserializerProvider of type " + getClass().getName() + " does not override 'withFactory()' method");
        }
        return new kv(paramjb);
    }

    protected void a(iy paramiy, js paramjs)
            throws jh {
        paramjs.a(paramiy, this);
    }

    public jg<Object> b(iy paramiy, sh paramsh, is paramis)
            throws jh {
        jg localjg = a(paramiy, paramsh, paramis);
        paramiy = this.d.b(paramiy, paramsh, paramis);
        if (paramiy != null) {
            return new a(paramiy, localjg);
        }
        return localjg;
    }

    protected jg<Object> b(sh paramsh)
            throws jh {
        if (!qy.d(paramsh.p())) {
            throw new jh("Can not find a Value deserializer for abstract type " + paramsh);
        }
        throw new jh("Can not find a Value deserializer for type " + paramsh);
    }

    public jl c(iy paramiy, sh paramsh, is paramis)
            throws jh {
        jl localjl2 = this.d.a(paramiy, paramsh, paramis);
        jl localjl1 = localjl2;
        if ((localjl2 instanceof iw)) {
            localjl1 = ((iw) localjl2).a(paramiy, paramis);
        }
        paramiy = localjl1;
        if (localjl1 == null) {
            paramiy = c(paramsh);
        }
        return paramiy;
    }

    protected jl c(sh paramsh)
            throws jh {
        throw new jh("Can not find a (Map) Key deserializer for type " + paramsh);
    }

    protected jg<Object> d(iy paramiy, sh paramsh, is paramis)
            throws jh {
        int i;
        synchronized (this.b) {
            jg localjg = a(paramsh);
            if (localjg != null) {
                return localjg;
            }
            i = this.b.size();
            if (i > 0) {
                localjg = (jg) this.b.get(paramsh);
                if (localjg != null) {
                    return localjg;
                }
            }
        }
        try {
            paramiy = e(paramiy, paramsh, paramis);
            if ((i == 0) && (this.b.size() > 0)) {
                this.b.clear();
            }
            return paramiy;
        } finally {
            paramiy =finally;
            if ((i == 0) && (this.b.size() > 0)) {
                this.b.clear();
            }
            throw paramiy;
        }
    }

    protected jg<Object> e(iy paramiy, sh paramsh, is paramis)
            throws jh {
        try {
            paramis = f(paramiy, paramsh, paramis);
            if (paramis == null) {
                paramiy = null;
                return paramiy;
            }
        } catch (IllegalArgumentException paramiy) {
            throw new jh(paramiy.getMessage(), null, paramiy);
        }
        boolean bool3 = paramis instanceof js;
        if (paramis.getClass() == ko.class) {
        }
        for (boolean bool1 = true; ; bool1 = false) {
            boolean bool2 = bool1;
            if (!bool1) {
                bool2 = bool1;
                if (paramiy.a(iy.a.a)) {
                    Object localObject = paramiy.a();
                    localObject = ((iq) localObject).a(mn.a(paramis.getClass(), (iq) localObject, null));
                    bool2 = bool1;
                    if (localObject != null) {
                        bool2 = ((Boolean) localObject).booleanValue();
                    }
                }
            }
            if (bool3) {
                this.b.put(paramsh, paramis);
                a(paramiy, (js) paramis);
                this.b.remove(paramsh);
            }
            paramiy = paramis;
            if (!bool2) {
                break;
            }
            this.a.put(paramsh, paramis);
            return paramis;
        }
    }

    protected jg<Object> f(iy paramiy, sh paramsh, is paramis)
            throws jh {
        if (paramsh.r()) {
            return this.d.b(paramiy, this, paramsh, paramis);
        }
        if (paramsh.f()) {
            if (paramsh.b()) {
                return this.d.a(paramiy, this, (qi) paramsh, paramis);
            }
            if (paramsh.j()) {
                paramsh = (qn) paramsh;
                if (paramsh.l()) {
                    return this.d.a(paramiy, this, (qo) paramsh, paramis);
                }
                return this.d.a(paramiy, this, paramsh, paramis);
            }
            if (paramsh.i()) {
                paramsh = (qk) paramsh;
                if (paramsh.a_()) {
                    return this.d.a(paramiy, this, (ql) paramsh, paramis);
                }
                return this.d.a(paramiy, this, paramsh, paramis);
            }
        }
        if (hh.class.isAssignableFrom(paramsh.p())) {
            return this.d.c(paramiy, this, paramsh, paramis);
        }
        return this.d.a(paramiy, this, paramsh, paramis);
    }

    public static final class a
            extends jg<Object> {
        final jy a;
        final jg<Object> b;

        public a(jy paramjy, jg<Object> paramjg) {
            this.a = paramjy;
            this.b = paramjg;
        }

        public Object a(hj paramhj, iz paramiz)
                throws IOException, hk {
            return this.b.a(paramhj, paramiz, this.a);
        }

        public Object a(hj paramhj, iz paramiz, jy paramjy)
                throws IOException, hk {
            throw new IllegalStateException("Type-wrapped deserializer's deserializeWithType should never get called");
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/kv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */