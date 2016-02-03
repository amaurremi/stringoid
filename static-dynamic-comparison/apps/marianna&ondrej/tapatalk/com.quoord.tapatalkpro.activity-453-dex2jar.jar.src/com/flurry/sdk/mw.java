package com.flurry.sdk;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class mw
        extends ir {
    protected final jn<?> b;
    protected final iq c;
    protected final mn d;
    protected qr e;
    protected final List<it> f;
    protected mr g;
    protected Map<Object, mq> h;
    protected Set<String> i;
    protected Set<String> j;
    protected mr k;
    protected mr l;

    protected mw(jn<?> paramjn, sh paramsh, mn parammn, List<it> paramList) {
        super(paramsh);
        this.b = paramjn;
        if (paramjn == null) {
        }
        for (paramjn = null; ; paramjn = paramjn.a()) {
            this.c = paramjn;
            this.d = parammn;
            this.f = paramList;
            return;
        }
    }

    public static mw a(jn<?> paramjn, sh paramsh, mn parammn) {
        return new mw(paramjn, paramsh, parammn, Collections.emptyList());
    }

    public static mw a(nc paramnc) {
        mw localmw = new mw(paramnc.a(), paramnc.b(), paramnc.c(), paramnc.d());
        localmw.g = paramnc.h();
        localmw.i = paramnc.i();
        localmw.j = paramnc.j();
        localmw.h = paramnc.e();
        return localmw;
    }

    public static mw b(nc paramnc) {
        mw localmw = new mw(paramnc.a(), paramnc.b(), paramnc.c(), paramnc.d());
        localmw.k = paramnc.f();
        localmw.l = paramnc.g();
        return localmw;
    }

    public kg.a a(kg.a parama) {
        if (this.c == null) {
            return parama;
        }
        return this.c.a(this.d, parama);
    }

    public mr a(String paramString, Class<?>[] paramArrayOfClass) {
        return this.d.a(paramString, paramArrayOfClass);
    }

    public sh a(Type paramType) {
        if (paramType == null) {
            return null;
        }
        return j().a(paramType);
    }

    public Object a(boolean paramBoolean) {
        Object localObject = this.d.h();
        if (localObject == null) {
            return null;
        }
        if (paramBoolean) {
            ((mo) localObject).k();
        }
        for (; ; ) {
            try {
                localObject = ((mo) localObject).e().newInstance(new Object[0]);
                return localObject;
            } catch (Exception localException) {
                continue;
            }
            if (((Throwable) localObject).getCause() == null) {
                continue;
            }
            localObject = ((Throwable) localObject).getCause();
        }
        if ((localObject instanceof Error)) {
            throw ((Error) localObject);
        }
        if ((localObject instanceof RuntimeException)) {
            throw ((RuntimeException) localObject);
        }
        throw new IllegalArgumentException("Failed to instantiate bean of type " + this.d.e().getName() + ": (" + localObject.getClass().getName() + ") " + ((Throwable) localObject).getMessage(), (Throwable) localObject);
    }

    public Constructor<?> a(Class<?>... paramVarArgs) {
        Iterator localIterator = this.d.i().iterator();
        while (localIterator.hasNext()) {
            mo localmo = (mo) localIterator.next();
            if (localmo.f() == 1) {
                Class localClass = localmo.a(0);
                int n = paramVarArgs.length;
                int m = 0;
                while (m < n) {
                    if (paramVarArgs[m] == localClass) {
                        return localmo.e();
                    }
                    m += 1;
                }
            }
        }
        return null;
    }

    protected boolean a(mr parammr) {
        Class localClass = parammr.d();
        if (!b().isAssignableFrom(localClass)) {
        }
        do {
            return false;
            if (this.c.k(parammr)) {
                return true;
            }
        } while (!"valueOf".equals(parammr.b()));
        return true;
    }

    public Method b(Class<?>... paramVarArgs) {
        Iterator localIterator = this.d.j().iterator();
        while (localIterator.hasNext()) {
            mr localmr = (mr) localIterator.next();
            if (a(localmr)) {
                Class localClass = localmr.a(0);
                int n = paramVarArgs.length;
                int m = 0;
                while (m < n) {
                    if (localClass.isAssignableFrom(paramVarArgs[m])) {
                        return localmr.e();
                    }
                    m += 1;
                }
            }
        }
        return null;
    }

    public mn c() {
        return this.d;
    }

    public List<it> d() {
        return this.f;
    }

    public mr e() {
        return this.k;
    }

    public Set<String> f() {
        if (this.i == null) {
            return Collections.emptySet();
        }
        return this.i;
    }

    public Set<String> g() {
        return this.j;
    }

    public boolean h() {
        return this.d.g();
    }

    public qv i() {
        return this.d.f();
    }

    public qr j() {
        if (this.e == null) {
            this.e = new qr(this.b.m(), this.a);
        }
        return this.e;
    }

    public mo k() {
        return this.d.h();
    }

    public mr l()
            throws IllegalArgumentException {
        if (this.g != null) {
            Class localClass = this.g.a(0);
            if ((localClass != String.class) && (localClass != Object.class)) {
                throw new IllegalArgumentException("Invalid 'any-setter' annotation on method " + this.g.b() + "(): first argument not of type String or Object, but " + localClass.getName());
            }
        }
        return this.g;
    }

    public Map<Object, mq> m() {
        return this.h;
    }

    public List<mo> n() {
        return this.d.i();
    }

    public List<mr> o() {
        Object localObject = this.d.j();
        if (((List) localObject).isEmpty()) {
            return (List<mr>) localObject;
        }
        ArrayList localArrayList = new ArrayList();
        localObject = ((List) localObject).iterator();
        while (((Iterator) localObject).hasNext()) {
            mr localmr = (mr) ((Iterator) localObject).next();
            if (a(localmr)) {
                localArrayList.add(localmr);
            }
        }
        return localArrayList;
    }

    public mr p()
            throws IllegalArgumentException {
        if ((this.l != null) && (!Map.class.isAssignableFrom(this.l.d()))) {
            throw new IllegalArgumentException("Invalid 'any-getter' annotation on method " + this.l.b() + "(): return type is not instance of java.util.Map");
        }
        return this.l;
    }

    public Map<String, mq> q() {
        HashMap localHashMap = null;
        Iterator localIterator = this.f.iterator();
        for (; ; ) {
            mq localmq;
            Object localObject;
            if (localIterator.hasNext()) {
                localmq = ((it) localIterator.next()).k();
                if (localmq == null) {
                    continue;
                }
                localObject = this.c.a(localmq);
                if ((localObject == null) || (!((iq.a) localObject).c())) {
                    continue;
                }
                if (localHashMap != null) {
                    break label127;
                }
                localHashMap = new HashMap();
            }
            label127:
            for (; ; ) {
                localObject = ((iq.a) localObject).a();
                if (localHashMap.put(localObject, localmq) == null) {
                    break;
                }
                throw new IllegalArgumentException("Multiple back-reference properties with name '" + (String) localObject + "'");
                return localHashMap;
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/mw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */