package com.flurry.sdk;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class kq
        extends kn {
    public static final kq h = new kq(null);
    private static final Class<?>[] j = {Throwable.class};
    protected final jb.a i;

    @Deprecated
    public kq() {
        this(null);
    }

    public kq(jb.a parama) {
        Object localObject = parama;
        if (parama == null) {
            localObject = new a();
        }
        this.i = ((jb.a) localObject);
    }

    private jl c(iy paramiy, sh paramsh, is paramis)
            throws jh {
        Object localObject = (mw) paramiy.b(paramsh);
        paramsh = paramsh.p();
        paramis = a(paramsh, paramiy);
        localObject = ((mw) localObject).o().iterator();
        while (((Iterator) localObject).hasNext()) {
            mr localmr = (mr) ((Iterator) localObject).next();
            if (paramiy.a().k(localmr)) {
                if ((localmr.f() == 1) && (localmr.d().isAssignableFrom(paramsh))) {
                    if (localmr.b(0) != String.class) {
                        throw new IllegalArgumentException("Parameter #0 type for factory method (" + localmr + ") not suitable, must be java.lang.String");
                    }
                    if (paramiy.c()) {
                        qy.a(localmr.i());
                    }
                    return mb.a(paramis, localmr);
                }
                throw new IllegalArgumentException("Unsuitable method (" + localmr + ") decorated with @JsonCreator (for Enum type " + paramsh.getName() + ")");
            }
        }
        return mb.a(paramis);
    }

    public final jb.a a() {
        return this.i;
    }

    public jb a(jb.a parama) {
        if (this.i == parama) {
            return this;
        }
        if (getClass() != kq.class) {
            throw new IllegalStateException("Subtype of BeanDeserializerFactory (" + getClass().getName() + ") has not properly overridden method 'withAdditionalDeserializers': can not instantiate subtype with " + "additional deserializer definitions");
        }
        return new kq(parama);
    }

    public jg<Object> a(iy paramiy, jc paramjc, sh paramsh, is paramis)
            throws jh {
        sh localsh = paramsh;
        if (paramsh.c()) {
            localsh = a(paramiy, paramsh);
        }
        mw localmw = (mw) paramiy.b(localsh);
        paramsh = a(paramiy, localmw.c(), paramis);
        if (paramsh != null) {
            return paramsh;
        }
        paramsh = a(paramiy, localmw.c(), localsh, null);
        if (paramsh.p() != localsh.p()) {
            localmw = (mw) paramiy.b(paramsh);
            localsh = paramsh;
        }
        for (; ; ) {
            jg localjg = a(localsh, paramiy, paramjc, localmw, paramis);
            paramsh = localjg;
            if (localjg != null) {
                break;
            }
            if (localsh.q()) {
                return b(paramiy, localsh, localmw, paramis);
            }
            if (localsh.c()) {
                paramsh = b(paramiy, localmw);
                if (paramsh != null) {
                    return a(paramiy, paramsh, (mw) paramiy.b(paramsh), paramis);
                }
            }
            paramjc = d(paramiy, paramjc, localsh, paramis);
            paramsh = paramjc;
            if (paramjc != null) {
                break;
            }
            if (!a(localsh.p())) {
                return null;
            }
            return a(paramiy, localsh, localmw, paramis);
        }
    }

    public jg<Object> a(iy paramiy, sh paramsh, mw parammw, is paramis)
            throws jh {
        Object localObject = a(paramiy, parammw);
        if ((paramsh.c()) && (!((kx) localObject).b())) {
            paramis = new km(paramsh);
            return paramis;
        }
        paramsh = a(parammw);
        paramsh.a((kx) localObject);
        a(paramiy, parammw, paramsh);
        b(paramiy, parammw, paramsh);
        c(paramiy, parammw, paramsh);
        if (this.i.g()) {
            Iterator localIterator = this.i.c().iterator();
            for (; ; ) {
                localObject = paramsh;
                if (!localIterator.hasNext()) {
                    break;
                }
                paramsh = ((kr) localIterator.next()).a(paramiy, parammw, paramsh);
            }
        }
        localObject = paramsh;
        paramsh = ((kp) localObject).a(paramis);
        if (this.i.g()) {
            localObject = this.i.c().iterator();
            for (; ; ) {
                paramis = paramsh;
                if (!((Iterator) localObject).hasNext()) {
                    break;
                }
                paramsh = ((kr) ((Iterator) localObject).next()).a(paramiy, parammw, paramsh);
            }
        }
        return paramsh;
    }

    protected jg<?> a(qi paramqi, iy paramiy, jc paramjc, is paramis, jy paramjy, jg<?> paramjg)
            throws jh {
        Iterator localIterator = this.i.a().iterator();
        while (localIterator.hasNext()) {
            jg localjg = ((jd) localIterator.next()).a(paramqi, paramiy, paramjc, paramis, paramjy, paramjg);
            if (localjg != null) {
                return localjg;
            }
        }
        return null;
    }

    protected jg<?> a(qk paramqk, iy paramiy, jc paramjc, mw parammw, is paramis, jy paramjy, jg<?> paramjg)
            throws jh {
        Iterator localIterator = this.i.a().iterator();
        while (localIterator.hasNext()) {
            jg localjg = ((jd) localIterator.next()).a(paramqk, paramiy, paramjc, parammw, paramis, paramjy, paramjg);
            if (localjg != null) {
                return localjg;
            }
        }
        return null;
    }

    protected jg<?> a(ql paramql, iy paramiy, jc paramjc, mw parammw, is paramis, jy paramjy, jg<?> paramjg)
            throws jh {
        Iterator localIterator = this.i.a().iterator();
        while (localIterator.hasNext()) {
            jg localjg = ((jd) localIterator.next()).a(paramql, paramiy, paramjc, parammw, paramis, paramjy, paramjg);
            if (localjg != null) {
                return localjg;
            }
        }
        return null;
    }

    protected jg<?> a(qn paramqn, iy paramiy, jc paramjc, mw parammw, is paramis, jl paramjl, jy paramjy, jg<?> paramjg)
            throws jh {
        Iterator localIterator = this.i.a().iterator();
        while (localIterator.hasNext()) {
            jg localjg = ((jd) localIterator.next()).a(paramqn, paramiy, paramjc, parammw, paramis, paramjl, paramjy, paramjg);
            if (localjg != null) {
                return localjg;
            }
        }
        return null;
    }

    protected jg<?> a(qo paramqo, iy paramiy, jc paramjc, mw parammw, is paramis, jl paramjl, jy paramjy, jg<?> paramjg)
            throws jh {
        Iterator localIterator = this.i.a().iterator();
        while (localIterator.hasNext()) {
            jg localjg = ((jd) localIterator.next()).a(paramqo, paramiy, paramjc, parammw, paramis, paramjl, paramjy, paramjg);
            if (localjg != null) {
                return localjg;
            }
        }
        return null;
    }

    protected jg<Object> a(sh paramsh, iy paramiy, jc paramjc, mw parammw, is paramis)
            throws jh {
        Iterator localIterator = this.i.a().iterator();
        while (localIterator.hasNext()) {
            jg localjg = ((jd) localIterator.next()).a(paramsh, paramiy, paramjc, parammw, paramis);
            if (localjg != null) {
                return localjg;
            }
        }
        return null;
    }

    protected jg<?> a(Class<? extends hh> paramClass, iy paramiy, is paramis)
            throws jh {
        Iterator localIterator = this.i.a().iterator();
        while (localIterator.hasNext()) {
            jg localjg = ((jd) localIterator.next()).a(paramClass, paramiy, paramis);
            if (localjg != null) {
                return localjg;
            }
        }
        return null;
    }

    protected jg<?> a(Class<?> paramClass, iy paramiy, mw parammw, is paramis)
            throws jh {
        Iterator localIterator = this.i.a().iterator();
        while (localIterator.hasNext()) {
            jg localjg = ((jd) localIterator.next()).a(paramClass, paramiy, parammw, paramis);
            if (localjg != null) {
                return localjg;
            }
        }
        return null;
    }

    public jl a(iy paramiy, sh paramsh, is paramis)
            throws jh {
        Object localObject2;
        Object localObject1;
        if (this.i.f()) {
            localObject2 = (mw) paramiy.c(paramsh.p());
            Iterator localIterator = this.i.b().iterator();
            do {
                if (!localIterator.hasNext()) {
                    break;
                }
                localObject1 = ((jm) localIterator.next()).a(paramsh, paramiy, (ir) localObject2, paramis);
            } while (localObject1 == null);
        }
        do {
            return (jl) localObject1;
            localObject1 = paramsh.p();
            if ((localObject1 == String.class) || (localObject1 == Object.class)) {
                return mb.a(paramiy, paramsh);
            }
            localObject2 = (jl) c.get(paramsh);
            localObject1 = localObject2;
        } while (localObject2 != null);
        if (paramsh.r()) {
            return c(paramiy, paramsh, paramis);
        }
        return mb.b(paramiy, paramsh);
    }

    protected kp a(mw parammw) {
        return new kp(parammw);
    }

    protected ks a(iy paramiy, mw parammw, mr parammr)
            throws jh {
        if (paramiy.a(iy.a.f)) {
            parammr.k();
        }
        Object localObject = parammw.j().a(parammr.b(1));
        is.a locala = new is.a(parammr.b(), (sh) localObject, parammw.i(), parammr);
        parammw = a(paramiy, parammw, (sh) localObject, parammr, locala);
        localObject = a(paramiy, parammr, locala);
        if (localObject != null) {
            return new ks(locala, parammr, parammw, (jg) localObject);
        }
        return new ks(locala, parammr, a(paramiy, parammr, parammw, locala.c()), null);
    }

    protected kt a(iy paramiy, mw parammw, String paramString, mp parammp)
            throws jh {
        if (paramiy.a(iy.a.f)) {
            parammp.k();
        }
        sh localsh2 = parammw.j().a(parammp.c());
        Object localObject2 = new is.a(paramString, localsh2, parammw.i(), parammp);
        sh localsh1 = a(paramiy, parammw, localsh2, parammp, (is) localObject2);
        Object localObject1 = localObject2;
        if (localsh1 != localsh2) {
            localObject1 = ((is.a) localObject2).a(localsh1);
        }
        localObject1 = a(paramiy, parammp, (is) localObject1);
        localObject2 = a(paramiy, parammp, localsh1, paramString);
        paramString = new kt.a(paramString, (sh) localObject2, (jy) ((sh) localObject2).o(), parammw.i(), parammp);
        parammw = paramString;
        if (localObject1 != null) {
            parammw = paramString.a((jg) localObject1);
        }
        paramiy = paramiy.a().a(parammp);
        if ((paramiy != null) && (paramiy.b())) {
            parammw.a(paramiy.a());
        }
        return parammw;
    }

    protected kt a(iy paramiy, mw parammw, String paramString, mr parammr)
            throws jh {
        if (paramiy.a(iy.a.f)) {
            parammr.k();
        }
        sh localsh2 = parammw.j().a(parammr.b(0));
        Object localObject2 = new is.a(paramString, localsh2, parammw.i(), parammr);
        sh localsh1 = a(paramiy, parammw, localsh2, parammr, (is) localObject2);
        Object localObject1 = localObject2;
        if (localsh1 != localsh2) {
            localObject1 = ((is.a) localObject2).a(localsh1);
        }
        localObject1 = a(paramiy, parammr, (is) localObject1);
        localObject2 = a(paramiy, parammr, localsh1, paramString);
        paramString = new kt.d(paramString, (sh) localObject2, (jy) ((sh) localObject2).o(), parammw.i(), parammr);
        parammw = paramString;
        if (localObject1 != null) {
            parammw = paramString.a((jg) localObject1);
        }
        paramiy = paramiy.a().a(parammr);
        if ((paramiy != null) && (paramiy.b())) {
            parammw.a(paramiy.a());
        }
        return parammw;
    }

    public kx a(iy paramiy, mw parammw)
            throws jh {
        Object localObject1 = parammw.c();
        Object localObject2 = paramiy.a().j((mn) localObject1);
        if (localObject2 != null) {
            if ((localObject2 instanceof kx)) {
                localObject1 = (kx) localObject2;
            }
        }
        while (this.i.i()) {
            Iterator localIterator = this.i.e().iterator();
            ky localky;
            do {
                localObject2 = localObject1;
                if (!localIterator.hasNext()) {
                    break;
                }
                localky = (ky) localIterator.next();
                localObject2 = localky.a(paramiy, parammw, (kx) localObject1);
                localObject1 = localObject2;
            } while (localObject2 != null);
            throw new jh("Broken registered ValueInstantiators (of type " + localky.getClass().getName() + "): returned null ValueInstantiator");
            if (!(localObject2 instanceof Class)) {
                throw new IllegalStateException("Invalid value instantiator returned for type " + parammw + ": neither a Class nor ValueInstantiator");
            }
            localObject2 = (Class) localObject2;
            if (!kx.class.isAssignableFrom((Class) localObject2)) {
                throw new IllegalStateException("Invalid instantiator Class<?> returned for type " + parammw + ": " + ((Class) localObject2).getName() + " not a ValueInstantiator");
            }
            localObject1 = paramiy.c((mm) localObject1, (Class) localObject2);
            continue;
            localObject1 = c(paramiy, parammw);
        }
        localObject2 = localObject1;
        return (kx) localObject2;
    }

    protected lb a(iy paramiy, mw parammw, String paramString, int paramInt, mt parammt, Object paramObject)
            throws jh {
        Object localObject3 = paramiy.m().a(parammt.e(), parammw.j());
        Object localObject2 = new is.a(paramString, (sh) localObject3, parammw.i(), parammt);
        sh localsh = a(paramiy, parammw, (sh) localObject3, parammt, (is) localObject2);
        Object localObject1 = localObject2;
        if (localsh != localObject3) {
            localObject1 = ((is.a) localObject2).a(localsh);
        }
        localObject3 = a(paramiy, parammt, (is) localObject1);
        localsh = a(paramiy, parammt, localsh, paramString);
        localObject2 = (jy) localsh.o();
        if (localObject2 == null) {
        }
        for (paramiy = b(paramiy, localsh, (is) localObject1); ; paramiy = (iy) localObject2) {
            parammw = new lb(paramString, localsh, paramiy, parammw.i(), parammt, paramInt, paramObject);
            paramiy = parammw;
            if (localObject3 != null) {
                paramiy = parammw.b((jg) localObject3);
            }
            return paramiy;
        }
    }

    public sh a(iy paramiy, sh paramsh)
            throws jh {
        for (; ; ) {
            sh localsh = b(paramiy, paramsh);
            if (localsh == null) {
                return paramsh;
            }
            Class localClass1 = paramsh.p();
            Class localClass2 = localsh.p();
            if ((localClass1 == localClass2) || (!localClass1.isAssignableFrom(localClass2))) {
                throw new IllegalArgumentException("Invalid abstract type resolution from " + paramsh + " to " + localsh + ": latter is not a subtype of former");
            }
            paramsh = localsh;
        }
    }

    protected void a(iy paramiy, mw parammw, kp paramkp)
            throws jh {
        Object localObject3 = parammw.d();
        Object localObject1 = paramiy.a();
        Object localObject2 = ((iq) localObject1).d(parammw.c());
        if (localObject2 != null) {
            paramkp.a(((Boolean) localObject2).booleanValue());
        }
        localObject2 = qw.a(((iq) localObject1).c(parammw.c()));
        localObject1 = ((Set) localObject2).iterator();
        while (((Iterator) localObject1).hasNext()) {
            paramkp.a((String) ((Iterator) localObject1).next());
        }
        Object localObject4 = parammw.l();
        if (localObject4 == null) {
        }
        for (localObject1 = parammw.f(); localObject1 != null; localObject1 = parammw.g()) {
            localObject1 = ((Collection) localObject1).iterator();
            while (((Iterator) localObject1).hasNext()) {
                paramkp.a((String) ((Iterator) localObject1).next());
            }
        }
        localObject1 = new HashMap();
        Object localObject5 = ((List) localObject3).iterator();
        while (((Iterator) localObject5).hasNext()) {
            Object localObject7 = (it) ((Iterator) localObject5).next();
            Object localObject6 = ((it) localObject7).a();
            if (!((Set) localObject2).contains(localObject6)) {
                if (((it) localObject7).e()) {
                    paramkp.a((it) localObject7);
                } else if (((it) localObject7).c()) {
                    localObject7 = ((it) localObject7).h();
                    if (a(paramiy, parammw, ((mr) localObject7).a(0), (Map) localObject1)) {
                        paramkp.a((String) localObject6);
                    } else {
                        localObject6 = a(paramiy, parammw, (String) localObject6, (mr) localObject7);
                        if (localObject6 != null) {
                            paramkp.a((kt) localObject6);
                        }
                    }
                } else if (((it) localObject7).d()) {
                    localObject7 = ((it) localObject7).i();
                    if (a(paramiy, parammw, ((mp) localObject7).d(), (Map) localObject1)) {
                        paramkp.a((String) localObject6);
                    } else {
                        localObject6 = a(paramiy, parammw, (String) localObject6, (mp) localObject7);
                        if (localObject6 != null) {
                            paramkp.a((kt) localObject6);
                        }
                    }
                }
            }
        }
        if (localObject4 != null) {
            paramkp.a(a(paramiy, parammw, (mr) localObject4));
        }
        if (paramiy.a(iy.a.e)) {
            localObject1 = ((List) localObject3).iterator();
            while (((Iterator) localObject1).hasNext()) {
                localObject4 = (it) ((Iterator) localObject1).next();
                if (((it) localObject4).b()) {
                    localObject3 = ((it) localObject4).a();
                    if ((!paramkp.b((String) localObject3)) && (!((Set) localObject2).contains(localObject3))) {
                        localObject4 = ((it) localObject4).g();
                        localObject5 = ((mr) localObject4).d();
                        if (((Collection.class.isAssignableFrom((Class) localObject5)) || (Map.class.isAssignableFrom((Class) localObject5))) && (!((Set) localObject2).contains(localObject3)) && (!paramkp.b((String) localObject3))) {
                            paramkp.a(b(paramiy, parammw, (String) localObject3, (mr) localObject4));
                        }
                    }
                }
            }
        }
    }

    protected void a(iy paramiy, mw parammw, ne<?> paramne, iq paramiq, la paramla)
            throws jh {
        Iterator localIterator = parammw.n().iterator();
        while (localIterator.hasNext()) {
            mo localmo = (mo) localIterator.next();
            int i3 = localmo.f();
            if (i3 >= 1) {
                boolean bool1 = paramiq.k(localmo);
                boolean bool2 = paramne.a(localmo);
                if (i3 == 1) {
                    a(paramiy, parammw, paramne, paramiq, paramla, localmo, bool1, bool2);
                } else if ((bool1) || (bool2)) {
                    Object localObject1 = null;
                    int m = 0;
                    int n = 0;
                    lb[] arrayOflb = new lb[i3];
                    int k = 0;
                    if (k < i3) {
                        mt localmt = localmo.c(k);
                        Object localObject2;
                        label145:
                        Object localObject3;
                        int i2;
                        int i1;
                        if (localmt == null) {
                            localObject2 = null;
                            localObject3 = paramiq.d(localmt);
                            if ((localObject2 == null) || (((String) localObject2).length() <= 0)) {
                                break label233;
                            }
                            i2 = m + 1;
                            arrayOflb[k] = a(paramiy, parammw, (String) localObject2, k, localmt, localObject3);
                            localObject2 = localObject1;
                            i1 = n;
                        }
                        for (; ; ) {
                            k += 1;
                            localObject1 = localObject2;
                            n = i1;
                            m = i2;
                            break;
                            localObject2 = paramiq.a(localmt);
                            break label145;
                            label233:
                            if (localObject3 != null) {
                                i1 = n + 1;
                                arrayOflb[k] = a(paramiy, parammw, (String) localObject2, k, localmt, localObject3);
                                i2 = m;
                                localObject2 = localObject1;
                            } else {
                                i1 = n;
                                i2 = m;
                                localObject2 = localmt;
                                if (localObject1 != null) {
                                    i1 = n;
                                    i2 = m;
                                    localObject2 = localObject1;
                                }
                            }
                        }
                    }
                    if ((bool1) || (m > 0) || (n > 0)) {
                        if (m + n == i3) {
                            paramla.a(localmo, arrayOflb);
                        } else {
                            if ((m == 0) && (n + 1 == i3)) {
                                throw new IllegalArgumentException("Delegated constructor with Injectables not yet supported (see [JACKSON-712]) for " + localmo);
                            }
                            throw new IllegalArgumentException("Argument #" + ((mt) localObject1).g() + " of constructor " + localmo + " has no property name annotation; must have name when multiple-paramater constructor annotated as Creator");
                        }
                    }
                }
            }
        }
    }

    protected boolean a(iy paramiy, mw parammw, ne<?> paramne, iq paramiq, la paramla, mo parammo, boolean paramBoolean1, boolean paramBoolean2)
            throws jh {
        paramne = parammo.c(0);
        String str = paramiq.a(paramne);
        paramiq = paramiq.d(paramne);
        if ((paramiq != null) || ((str != null) && (str.length() > 0))) {
            paramla.a(parammo, new lb[]{a(paramiy, parammw, str, 0, paramne, paramiq)});
            return true;
        }
        paramiy = parammo.a(0);
        if (paramiy == String.class) {
            if ((paramBoolean1) || (paramBoolean2)) {
                paramla.a(parammo);
            }
            return true;
        }
        if ((paramiy == Integer.TYPE) || (paramiy == Integer.class)) {
            if ((paramBoolean1) || (paramBoolean2)) {
                paramla.b(parammo);
            }
            return true;
        }
        if ((paramiy == Long.TYPE) || (paramiy == Long.class)) {
            if ((paramBoolean1) || (paramBoolean2)) {
                paramla.c(parammo);
            }
            return true;
        }
        if ((paramiy == Double.TYPE) || (paramiy == Double.class)) {
            if ((paramBoolean1) || (paramBoolean2)) {
                paramla.d(parammo);
            }
            return true;
        }
        if (paramBoolean1) {
            paramla.f(parammo);
            return true;
        }
        return false;
    }

    protected boolean a(iy paramiy, mw parammw, ne<?> paramne, iq paramiq, la paramla, mr parammr, boolean paramBoolean)
            throws jh {
        paramiy = parammr.a(0);
        if (paramiy == String.class) {
            if ((paramBoolean) || (paramne.a(parammr))) {
                paramla.a(parammr);
            }
        }
        do {
            do {
                do {
                    do {
                        return true;
                        if ((paramiy != Integer.TYPE) && (paramiy != Integer.class)) {
                            break;
                        }
                    } while ((!paramBoolean) && (!paramne.a(parammr)));
                    paramla.b(parammr);
                    return true;
                    if ((paramiy != Long.TYPE) && (paramiy != Long.class)) {
                        break;
                    }
                } while ((!paramBoolean) && (!paramne.a(parammr)));
                paramla.c(parammr);
                return true;
                if ((paramiy != Double.TYPE) && (paramiy != Double.class)) {
                    break;
                }
            } while ((!paramBoolean) && (!paramne.a(parammr)));
            paramla.d(parammr);
            return true;
            if ((paramiy != Boolean.TYPE) && (paramiy != Boolean.class)) {
                break;
            }
        } while ((!paramBoolean) && (!paramne.a(parammr)));
        paramla.e(parammr);
        return true;
        if (paramiq.k(parammr)) {
            paramla.f(parammr);
            return true;
        }
        return false;
    }

    protected boolean a(iy paramiy, mw parammw, Class<?> paramClass, Map<Class<?>, Boolean> paramMap) {
        paramMap = (Boolean) paramMap.get(paramClass);
        parammw = paramMap;
        if (paramMap == null) {
            parammw = (mw) paramiy.c(paramClass);
            paramiy = paramiy.a().e(parammw.c());
            parammw = paramiy;
            if (paramiy == null) {
                parammw = Boolean.FALSE;
            }
        }
        return parammw.booleanValue();
    }

    protected boolean a(Class<?> paramClass) {
        String str = qy.a(paramClass);
        if (str != null) {
            throw new IllegalArgumentException("Can not deserialize Class " + paramClass.getName() + " (of type " + str + ") as a Bean");
        }
        if (qy.c(paramClass)) {
            throw new IllegalArgumentException("Can not deserialize Proxy class " + paramClass.getName() + " as a Bean");
        }
        str = qy.a(paramClass, true);
        if (str != null) {
            throw new IllegalArgumentException("Can not deserialize Class " + paramClass.getName() + " (of type " + str + ") as a Bean");
        }
        return true;
    }

    public jg<Object> b(iy paramiy, sh paramsh, mw parammw, is paramis)
            throws jh {
        paramsh = a(parammw);
        paramsh.a(a(paramiy, parammw));
        a(paramiy, parammw, paramsh);
        Object localObject = parammw.a("initCause", j);
        if (localObject != null) {
            localObject = a(paramiy, parammw, "cause", (mr) localObject);
            if (localObject != null) {
                paramsh.a((kt) localObject, true);
            }
        }
        paramsh.a("localizedMessage");
        paramsh.a("message");
        if (this.i.g()) {
            Iterator localIterator = this.i.c().iterator();
            for (; ; ) {
                localObject = paramsh;
                if (!localIterator.hasNext()) {
                    break;
                }
                paramsh = ((kr) localIterator.next()).a(paramiy, parammw, paramsh);
            }
        }
        localObject = paramsh;
        paramis = ((kp) localObject).a(paramis);
        paramsh = paramis;
        if ((paramis instanceof ko)) {
            paramsh = new mg((ko) paramis);
        }
        if (this.i.g()) {
            localObject = this.i.c().iterator();
            for (; ; ) {
                paramis = paramsh;
                if (!((Iterator) localObject).hasNext()) {
                    break;
                }
                paramsh = ((kr) ((Iterator) localObject).next()).a(paramiy, parammw, paramsh);
            }
        }
        paramis = paramsh;
        return paramis;
    }

    protected kt b(iy paramiy, mw parammw, String paramString, mr parammr)
            throws jh {
        if (paramiy.a(iy.a.f)) {
            parammr.k();
        }
        sh localsh = parammr.a(parammw.j());
        jg localjg = a(paramiy, parammr, new is.a(paramString, localsh, parammw.i(), parammr));
        paramiy = a(paramiy, parammr, localsh, paramString);
        parammw = new kt.f(paramString, paramiy, (jy) paramiy.o(), parammw.i(), parammr);
        paramiy = parammw;
        if (localjg != null) {
            paramiy = parammw.a(localjg);
        }
        return paramiy;
    }

    protected sh b(iy paramiy, mw parammw)
            throws jh {
        parammw = parammw.a();
        Iterator localIterator = this.i.d().iterator();
        while (localIterator.hasNext()) {
            sh localsh = ((ip) localIterator.next()).b(paramiy, parammw);
            if (localsh != null) {
                return localsh;
            }
        }
        return null;
    }

    protected sh b(iy paramiy, sh paramsh)
            throws jh {
        Class localClass = paramsh.p();
        if (this.i.h()) {
            Iterator localIterator = this.i.d().iterator();
            while (localIterator.hasNext()) {
                sh localsh = ((ip) localIterator.next()).a(paramiy, paramsh);
                if ((localsh != null) && (localsh.p() != localClass)) {
                    return localsh;
                }
            }
        }
        return null;
    }

    protected void b(iy paramiy, mw parammw, kp paramkp)
            throws jh {
        Object localObject1 = parammw.q();
        if (localObject1 != null) {
            localObject1 = ((Map) localObject1).entrySet().iterator();
            while (((Iterator) localObject1).hasNext()) {
                Object localObject2 = (Map.Entry) ((Iterator) localObject1).next();
                String str = (String) ((Map.Entry) localObject2).getKey();
                localObject2 = (mq) ((Map.Entry) localObject2).getValue();
                if ((localObject2 instanceof mr)) {
                    paramkp.a(str, a(paramiy, parammw, ((mq) localObject2).b(), (mr) localObject2));
                } else {
                    paramkp.a(str, a(paramiy, parammw, ((mq) localObject2).b(), (mp) localObject2));
                }
            }
        }
    }

    protected void b(iy paramiy, mw parammw, ne<?> paramne, iq paramiq, la paramla)
            throws jh {
        Iterator localIterator = parammw.o().iterator();
        while (localIterator.hasNext()) {
            mr localmr = (mr) localIterator.next();
            int m = localmr.f();
            if (m >= 1) {
                boolean bool = paramiq.k(localmr);
                Object localObject2;
                if (m == 1) {
                    localObject1 = localmr.c(0);
                    localObject2 = paramiq.a((mt) localObject1);
                    if ((paramiq.d((mq) localObject1) == null) && ((localObject2 == null) || (((String) localObject2).length() == 0))) {
                        a(paramiy, parammw, paramne, paramiq, paramla, localmr, bool);
                    }
                } else {
                    if (!paramiq.k(localmr)) {
                        continue;
                    }
                }
                Object localObject1 = new lb[m];
                int k = 0;
                while (k < m) {
                    localObject2 = localmr.c(k);
                    String str = paramiq.a((mt) localObject2);
                    Object localObject3 = paramiq.d((mq) localObject2);
                    if (((str == null) || (str.length() == 0)) && (localObject3 == null)) {
                        throw new IllegalArgumentException("Argument #" + k + " of factory method " + localmr + " has no property name annotation; must have when multiple-paramater static method annotated as Creator");
                    }
                    localObject1[k] = a(paramiy, parammw, str, k, (mt) localObject2, localObject3);
                    k += 1;
                }
                paramla.a(localmr, (lb[]) localObject1);
            }
        }
    }

    protected kx c(iy paramiy, mw parammw)
            throws jh {
        boolean bool = paramiy.a(iy.a.f);
        la localla = new la(parammw, bool);
        iq localiq = paramiy.a();
        if (parammw.a().d()) {
            localObject = parammw.k();
            if (localObject != null) {
                if (bool) {
                    qy.a(((mo) localObject).e());
                }
                localla.a((mo) localObject);
            }
        }
        Object localObject = paramiy.e();
        localObject = paramiy.a().a(parammw.c(), (ne) localObject);
        b(paramiy, parammw, (ne) localObject, localiq, localla);
        a(paramiy, parammw, (ne) localObject, localiq, localla);
        return localla.a(paramiy);
    }

    protected void c(iy paramiy, mw parammw, kp paramkp)
            throws jh {
        Object localObject = parammw.m();
        if (localObject != null) {
            boolean bool = paramiy.a(iy.a.f);
            paramiy = ((Map) localObject).entrySet().iterator();
            while (paramiy.hasNext()) {
                localObject = (Map.Entry) paramiy.next();
                mq localmq = (mq) ((Map.Entry) localObject).getValue();
                if (bool) {
                    localmq.k();
                }
                paramkp.a(localmq.b(), parammw.a(localmq.c()), parammw.i(), localmq, ((Map.Entry) localObject).getKey());
            }
        }
    }

    public static class a
            extends jb.a {
        protected static final jm[] a = new jm[0];
        protected static final kr[] b = new kr[0];
        protected static final ip[] c = new ip[0];
        protected static final ky[] d = new ky[0];
        protected final jd[] e;
        protected final jm[] f;
        protected final kr[] g;
        protected final ip[] h;
        protected final ky[] i;

        public a() {
            this(null, null, null, null, null);
        }

        protected a(jd[] paramArrayOfjd, jm[] paramArrayOfjm, kr[] paramArrayOfkr, ip[] paramArrayOfip, ky[] paramArrayOfky) {
            jd[] arrayOfjd = paramArrayOfjd;
            if (paramArrayOfjd == null) {
                arrayOfjd = kq.b();
            }
            this.e = arrayOfjd;
            paramArrayOfjd = paramArrayOfjm;
            if (paramArrayOfjm == null) {
                paramArrayOfjd = a;
            }
            this.f = paramArrayOfjd;
            paramArrayOfjd = paramArrayOfkr;
            if (paramArrayOfkr == null) {
                paramArrayOfjd = b;
            }
            this.g = paramArrayOfjd;
            paramArrayOfjd = paramArrayOfip;
            if (paramArrayOfip == null) {
                paramArrayOfjd = c;
            }
            this.h = paramArrayOfjd;
            paramArrayOfjd = paramArrayOfky;
            if (paramArrayOfky == null) {
                paramArrayOfjd = d;
            }
            this.i = paramArrayOfjd;
        }

        public jb.a a(ip paramip) {
            if (paramip == null) {
                throw new IllegalArgumentException("Can not pass null resolver");
            }
            paramip = (ip[]) qw.a(this.h, paramip);
            return new a(this.e, this.f, this.g, paramip, this.i);
        }

        public jb.a a(jd paramjd) {
            if (paramjd == null) {
                throw new IllegalArgumentException("Can not pass null Deserializers");
            }
            return new a((jd[]) qw.a(this.e, paramjd), this.f, this.g, this.h, this.i);
        }

        public jb.a a(jm paramjm) {
            if (paramjm == null) {
                throw new IllegalArgumentException("Can not pass null KeyDeserializers");
            }
            paramjm = (jm[]) qw.a(this.f, paramjm);
            return new a(this.e, paramjm, this.g, this.h, this.i);
        }

        public jb.a a(ky paramky) {
            if (paramky == null) {
                throw new IllegalArgumentException("Can not pass null resolver");
            }
            paramky = (ky[]) qw.a(this.i, paramky);
            return new a(this.e, this.f, this.g, this.h, paramky);
        }

        public Iterable<jd> a() {
            return qw.b(this.e);
        }

        public Iterable<jm> b() {
            return qw.b(this.f);
        }

        public Iterable<kr> c() {
            return qw.b(this.g);
        }

        public Iterable<ip> d() {
            return qw.b(this.h);
        }

        public Iterable<ky> e() {
            return qw.b(this.i);
        }

        public boolean f() {
            return this.f.length > 0;
        }

        public boolean g() {
            return this.g.length > 0;
        }

        public boolean h() {
            return this.h.length > 0;
        }

        public boolean i() {
            return this.i.length > 0;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/kq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */