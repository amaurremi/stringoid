package com.flurry.sdk;

import com.flurry.org.codehaus.jackson.annotate.JsonTypeInfo.As;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@kc
public class ko
        extends lz<Object>
        implements js {
    protected final mn a;
    protected final sh b;
    protected final is c;
    protected final kx d;
    protected jg<Object> e;
    protected final ld f;
    protected boolean g;
    protected final kz h;
    protected final lh[] i;
    protected ks j;
    protected final HashSet<String> k;
    protected final boolean l;
    protected final Map<String, kt> m;
    protected HashMap<qj, jg<Object>> n;
    protected lg o;
    protected lc p;

    public ko(ir paramir, is paramis, kx paramkx, kz paramkz, Map<String, kt> paramMap, HashSet<String> paramHashSet, boolean paramBoolean, ks paramks, List<lh> paramList) {
        this(paramir.c(), paramir.a(), paramis, paramkx, paramkz, paramMap, paramHashSet, paramBoolean, paramks, paramList);
    }

    protected ko(ko paramko) {
        this(paramko, paramko.l);
    }

    protected ko(ko paramko, boolean paramBoolean) {
        super(paramko.b);
        this.a = paramko.a;
        this.b = paramko.b;
        this.c = paramko.c;
        this.d = paramko.d;
        this.e = paramko.e;
        this.f = paramko.f;
        this.h = paramko.h;
        this.m = paramko.m;
        this.k = paramko.k;
        this.l = paramBoolean;
        this.j = paramko.j;
        this.i = paramko.i;
        this.g = paramko.g;
        this.o = paramko.o;
    }

    protected ko(mn parammn, sh paramsh, is paramis, kx paramkx, kz paramkz, Map<String, kt> paramMap, HashSet<String> paramHashSet, boolean paramBoolean, ks paramks, List<lh> paramList) {
        super(paramsh);
        this.a = parammn;
        this.b = paramsh;
        this.c = paramis;
        this.d = paramkx;
        if (paramkx.j()) {
            this.f = new ld(paramkx);
            this.h = paramkz;
            this.m = paramMap;
            this.k = paramHashSet;
            this.l = paramBoolean;
            this.j = paramks;
            parammn = (mn) localObject;
            if (paramList != null) {
                if (!paramList.isEmpty()) {
                    break label154;
                }
                parammn = (mn) localObject;
            }
            label101:
            this.i = parammn;
            if ((!paramkx.i()) && (this.f == null) && (paramkx.h()) && (this.o == null)) {
                break label178;
            }
        }
        label154:
        label178:
        for (paramBoolean = true; ; paramBoolean = false) {
            this.g = paramBoolean;
            return;
            this.f = null;
            break;
            parammn = (lh[]) paramList.toArray(new lh[paramList.size()]);
            break label101;
        }
    }

    private final void b(hj paramhj, iz paramiz, Object paramObject, String paramString)
            throws IOException, hk {
        if ((this.k != null) && (this.k.contains(paramString))) {
            paramhj.d();
            return;
        }
        if (this.j != null) {
            try {
                this.j.a(paramhj, paramiz, paramObject, paramString);
                return;
            } catch (Exception paramhj) {
                a(paramhj, paramObject, paramString, paramiz);
                return;
            }
        }
        a(paramhj, paramiz, paramObject, paramString);
    }

    public jg<Object> a() {
        if (getClass() != ko.class) {
            return this;
        }
        return new ko(this, true);
    }

    protected kt a(iy paramiy, kt paramkt) {
        String str = paramkt.e();
        if (str == null) {
            return paramkt;
        }
        paramiy = paramkt.h();
        boolean bool = false;
        if ((paramiy instanceof ko)) {
            paramiy = ((ko) paramiy).a(str);
        }
        while (paramiy == null) {
            throw new IllegalArgumentException("Can not handle managed/back reference '" + str + "': no back reference property found from type " + paramkt.a());
            if ((paramiy instanceof lo)) {
                paramiy = ((lo) paramiy).d();
                if (!(paramiy instanceof ko)) {
                    throw new IllegalArgumentException("Can not handle managed/back reference '" + str + "': value deserializer is of type ContainerDeserializerBase, but content type is not handled by a BeanDeserializer " + " (instead it's of type " + paramiy.getClass().getName() + ")");
                }
                paramiy = ((ko) paramiy).a(str);
                bool = true;
            } else {
                if ((paramiy instanceof km)) {
                    throw new IllegalArgumentException("Can not handle managed/back reference for abstract types (property " + this.b.p().getName() + "." + paramkt.c() + ")");
                }
                throw new IllegalArgumentException("Can not handle managed/back reference '" + str + "': type for value deserializer is not BeanDeserializer or ContainerDeserializerBase, but " + paramiy.getClass().getName());
            }
        }
        sh localsh1 = this.b;
        sh localsh2 = paramiy.a();
        if (!localsh2.p().isAssignableFrom(localsh1.p())) {
            throw new IllegalArgumentException("Can not handle managed/back reference '" + str + "': back reference type (" + localsh2.p().getName() + ") not compatible with managed type (" + localsh1.p().getName() + ")");
        }
        return new kt.c(str, paramkt, paramiy, this.a.f(), bool);
    }

    public kt a(String paramString) {
        if (this.m == null) {
            return null;
        }
        return (kt) this.m.get(paramString);
    }

    public final Object a(hj paramhj, iz paramiz)
            throws IOException, hk {
        hm localhm = paramhj.e();
        if (localhm == hm.b) {
            paramhj.b();
            return b(paramhj, paramiz);
        }
        switch (1. a[localhm.ordinal()])
        {
            default:
                throw paramiz.b(d());
            case 1:
                return d(paramhj, paramiz);
            case 2:
                return e(paramhj, paramiz);
            case 3:
                return f(paramhj, paramiz);
            case 4:
                return paramhj.z();
            case 5:
            case 6:
                return g(paramhj, paramiz);
            case 7:
                return h(paramhj, paramiz);
        }
        return b(paramhj, paramiz);
    }

    public Object a(hj paramhj, iz paramiz, jy paramjy)
            throws IOException, hk {
        return paramjy.a(paramhj, paramiz);
    }

    public Object a(hj paramhj, iz paramiz, Object paramObject)
            throws IOException, hk {
        if (this.i != null) {
            a(paramiz, paramObject);
        }
        if (this.o != null) {
            localObject2 = b(paramhj, paramiz, paramObject);
        }
        do {
            return localObject2;
            if (this.p != null) {
                return c(paramhj, paramiz, paramObject);
            }
            localObject2 = paramhj.e();
            localObject1 = localObject2;
            if (localObject2 == hm.b) {
                localObject1 = paramhj.b();
            }
            localObject2 = paramObject;
        } while (localObject1 != hm.f);
        Object localObject1 = paramhj.g();
        paramhj.b();
        Object localObject2 = this.h.a((String) localObject1);
        if (localObject2 != null) {
        }
        for (; ; ) {
            try {
                ((kt) localObject2).a(paramhj, paramiz, paramObject);
                localObject1 = paramhj.b();
            } catch (Exception localException) {
                a(localException, paramObject, (String) localObject1, paramiz);
                continue;
            }
            if ((this.k != null) && (this.k.contains(localObject1))) {
                paramhj.d();
            } else if (this.j != null) {
                this.j.a(paramhj, paramiz, paramObject, (String) localObject1);
            } else {
                a(paramhj, paramiz, paramObject, (String) localObject1);
            }
        }
    }

    protected Object a(hj paramhj, iz paramiz, Object paramObject, sq paramsq)
            throws IOException, hk {
        jg localjg = b(paramiz, paramObject, paramsq);
        if (localjg != null) {
            if (paramsq == null) {
                break label105;
            }
            paramsq.e();
            paramsq = paramsq.h();
            paramsq.b();
        }
        label105:
        for (paramsq = localjg.a(paramsq, paramiz, paramObject); ; paramsq = (sq) paramObject) {
            paramObject = paramsq;
            if (paramhj != null) {
                paramObject = localjg.a(paramhj, paramiz, paramsq);
            }
            return paramObject;
            if (paramsq != null) {
            }
            for (paramsq = a(paramiz, paramObject, paramsq); ; paramsq = (sq) paramObject) {
                paramObject = paramsq;
                if (paramhj == null) {
                    break;
                }
                return a(paramhj, paramiz, paramsq);
            }
        }
    }

    protected Object a(iz paramiz, Object paramObject, sq paramsq)
            throws IOException, hk {
        paramsq.e();
        paramsq = paramsq.h();
        while (paramsq.b() != hm.c) {
            String str = paramsq.g();
            paramsq.b();
            a(paramsq, paramiz, paramObject, str);
        }
        return paramObject;
    }

    protected void a(hj paramhj, iz paramiz, Object paramObject, String paramString)
            throws IOException, hk {
        if ((this.l) || ((this.k != null) && (this.k.contains(paramString)))) {
            paramhj.d();
            return;
        }
        super.a(paramhj, paramiz, paramObject, paramString);
    }

    public void a(iy paramiy, jc paramjc)
            throws jh {
        Iterator localIterator = this.h.c();
        lc.a locala = null;
        Object localObject1 = null;
        Object localObject4;
        if (localIterator.hasNext()) {
            localObject4 = (kt) localIterator.next();
            if (((kt) localObject4).f()) {
                break label510;
            }
        }
        label510:
        for (Object localObject2 = ((kt) localObject4).a(a(paramiy, paramjc, ((kt) localObject4).a(), (is) localObject4)); ; localObject2 = localObject4) {
            localObject2 = a(paramiy, (kt) localObject2);
            Object localObject3 = b(paramiy, (kt) localObject2);
            if (localObject3 != null) {
                localObject2 = localObject1;
                if (localObject1 == null) {
                    localObject2 = new lg();
                }
                ((lg) localObject2).a((kt) localObject3);
            }
            for (localObject1 = localObject3; ; localObject1 = localObject3) {
                localObject3 = c(paramiy, (kt) localObject1);
                if (localObject3 != localObject4) {
                    this.h.a((kt) localObject3);
                }
                localObject1 = localObject2;
                if (!((kt) localObject3).g()) {
                    break;
                }
                localObject4 = ((kt) localObject3).i();
                localObject1 = localObject2;
                if (((jy) localObject4).a() != JsonTypeInfo.As.EXTERNAL_PROPERTY) {
                    break;
                }
                if (locala == null) {
                    locala = new lc.a();
                }
                for (; ; ) {
                    locala.a((kt) localObject3, ((jy) localObject4).b());
                    this.h.b((kt) localObject3);
                    localObject1 = localObject2;
                    break;
                    if ((this.j != null) && (!this.j.b())) {
                        this.j = this.j.a(a(paramiy, paramjc, this.j.c(), this.j.a()));
                    }
                    if (this.d.i()) {
                        localObject2 = this.d.l();
                        if (localObject2 == null) {
                            throw new IllegalArgumentException("Invalid delegate-creator definition for " + this.b + ": value instantiator (" + this.d.getClass().getName() + ") returned true for 'canCreateUsingDelegate()', but null for 'getDelegateType()'");
                        }
                        localObject3 = this.d.o();
                        this.e = a(paramiy, paramjc, (sh) localObject2, new is.a(null, (sh) localObject2, this.a.f(), (mq) localObject3));
                    }
                    if (this.f != null) {
                        localObject2 = this.f.a().iterator();
                        while (((Iterator) localObject2).hasNext()) {
                            localObject3 = (kt) ((Iterator) localObject2).next();
                            if (!((kt) localObject3).f()) {
                                this.f.a((kt) localObject3, a(paramiy, paramjc, ((kt) localObject3).a(), (is) localObject3));
                            }
                        }
                    }
                    if (locala != null) {
                        this.p = locala.a();
                        this.g = true;
                    }
                    this.o = ((lg) localObject1);
                    if (localObject1 != null) {
                        this.g = true;
                    }
                    return;
                }
                localObject3 = localObject2;
                localObject2 = localObject1;
            }
        }
    }

    protected void a(iz paramiz, Object paramObject)
            throws IOException, hk {
        lh[] arrayOflh = this.i;
        int i2 = arrayOflh.length;
        int i1 = 0;
        while (i1 < i2) {
            arrayOflh[i1].b(paramiz, paramObject);
            i1 += 1;
        }
    }

    protected void a(Throwable paramThrowable, iz paramiz)
            throws IOException {
        while (((paramThrowable instanceof InvocationTargetException)) && (paramThrowable.getCause() != null)) {
            paramThrowable = paramThrowable.getCause();
        }
        if ((paramThrowable instanceof Error)) {
            throw ((Error) paramThrowable);
        }
        if ((paramiz == null) || (paramiz.a(iy.a.n))) {
        }
        for (int i1 = 1; (paramThrowable instanceof IOException); i1 = 0) {
            throw ((IOException) paramThrowable);
        }
        if ((i1 == 0) && ((paramThrowable instanceof RuntimeException))) {
            throw ((RuntimeException) paramThrowable);
        }
        throw paramiz.a(this.b.p(), paramThrowable);
    }

    public void a(Throwable paramThrowable, Object paramObject, String paramString, iz paramiz)
            throws IOException {
        while (((paramThrowable instanceof InvocationTargetException)) && (paramThrowable.getCause() != null)) {
            paramThrowable = paramThrowable.getCause();
        }
        if ((paramThrowable instanceof Error)) {
            throw ((Error) paramThrowable);
        }
        if ((paramiz == null) || (paramiz.a(iy.a.n))) {
        }
        for (int i1 = 1; (paramThrowable instanceof IOException); i1 = 0) {
            if ((i1 != 0) && ((paramThrowable instanceof jh))) {
                break label100;
            }
            throw ((IOException) paramThrowable);
        }
        if ((i1 == 0) && ((paramThrowable instanceof RuntimeException))) {
            throw ((RuntimeException) paramThrowable);
        }
        label100:
        throw jh.a(paramThrowable, paramObject, paramString);
    }

    protected jg<Object> b(iz paramiz, Object paramObject, sq paramsq)
            throws IOException, hk {
        try {
            if (this.n == null) {
            }
            for (paramsq = null; ; paramsq = (jg) this.n.get(new qj(paramObject.getClass()))) {
                if (paramsq == null) {
                    break;
                }
                return paramsq;
            }
            localjc = paramiz.b();
        } finally {
        }
        jc localjc;
        if (localjc != null) {
            paramsq = paramiz.a(paramObject.getClass());
            paramiz = localjc.a(paramiz.a(), paramsq, this.c);
            paramsq = paramiz;
            if (paramiz != null) {
                try {
                    if (this.n == null) {
                        this.n = new HashMap();
                    }
                    this.n.put(new qj(paramObject.getClass()), paramiz);
                    return paramiz;
                } finally {
                }
            }
        }
        return paramsq;
    }

    protected kt b(iy paramiy, kt paramkt) {
        Object localObject = paramkt.b();
        if ((localObject != null) && (paramiy.a().b((mq) localObject) == Boolean.TRUE)) {
            paramiy = paramkt.h();
            localObject = paramiy.a();
            if ((localObject != paramiy) && (localObject != null)) {
                return paramkt.a((jg) localObject);
            }
        }
        return null;
    }

    public Object b(hj paramhj, iz paramiz)
            throws IOException, hk {
        if (this.g) {
            if (this.o != null) {
                localObject1 = j(paramhj, paramiz);
            }
        }
        Object localObject2;
        do {
            return localObject1;
            if (this.p != null) {
                return l(paramhj, paramiz);
            }
            return c(paramhj, paramiz);
            localObject2 = this.d.m();
            if (this.i != null) {
                a(paramiz, localObject2);
            }
            localObject1 = localObject2;
        } while (paramhj.e() == hm.c);
        Object localObject1 = paramhj.g();
        paramhj.b();
        kt localkt = this.h.a((String) localObject1);
        if (localkt != null) {
        }
        for (; ; ) {
            try {
                localkt.a(paramhj, paramiz, localObject2);
                paramhj.b();
            } catch (Exception localException) {
                a(localException, localObject2, (String) localObject1, paramiz);
                continue;
            }
            b(paramhj, paramiz, localObject2, (String) localObject1);
        }
    }

    protected Object b(hj paramhj, iz paramiz, Object paramObject)
            throws IOException, hk {
        Object localObject2 = paramhj.e();
        Object localObject1 = localObject2;
        if (localObject2 == hm.b) {
            localObject1 = paramhj.b();
        }
        localObject2 = new sq(paramhj.a());
        ((sq) localObject2).d();
        if (localObject1 == hm.f) {
            localObject1 = paramhj.g();
            kt localkt = this.h.a((String) localObject1);
            paramhj.b();
            if (localkt != null) {
            }
            for (; ; ) {
                try {
                    localkt.a(paramhj, paramiz, paramObject);
                    localObject1 = paramhj.b();
                } catch (Exception localException) {
                    a(localException, paramObject, (String) localObject1, paramiz);
                    continue;
                }
                if ((this.k != null) && (this.k.contains(localObject1))) {
                    paramhj.d();
                } else {
                    ((sq) localObject2).a((String) localObject1);
                    ((sq) localObject2).c(paramhj);
                    if (this.j != null) {
                        this.j.a(paramhj, paramiz, paramObject, (String) localObject1);
                    }
                }
            }
        }
        ((sq) localObject2).e();
        this.o.a(paramhj, paramiz, paramObject, (sq) localObject2);
        return paramObject;
    }

    protected kt c(iy paramiy, kt paramkt) {
        Object localObject2 = paramkt.h();
        Object localObject1 = paramkt;
        Object localObject3;
        int i2;
        int i1;
        if ((localObject2 instanceof ko)) {
            localObject1 = paramkt;
            if (!((ko) localObject2).e().h()) {
                localObject3 = paramkt.a().p();
                localObject2 = qy.b((Class) localObject3);
                localObject1 = paramkt;
                if (localObject2 != null) {
                    localObject1 = paramkt;
                    if (localObject2 == this.b.p()) {
                        localObject3 = ((Class) localObject3).getConstructors();
                        i2 = localObject3.length;
                        i1 = 0;
                    }
                }
            }
        }
        for (; ; ) {
            localObject1 = paramkt;
            if (i1 < i2) {
                localObject1 = localObject3[i1];
                Class[] arrayOfClass = ((Constructor) localObject1).getParameterTypes();
                if ((arrayOfClass.length == 1) && (arrayOfClass[0] == localObject2)) {
                    if (paramiy.a(iy.a.f)) {
                        qy.a((Member) localObject1);
                    }
                    localObject1 = new kt.b(paramkt, (Constructor) localObject1);
                }
            } else {
                return (kt) localObject1;
            }
            i1 += 1;
        }
    }

    protected Object c(hj paramhj, iz paramiz)
            throws IOException, hk {
        if (this.e != null) {
            return this.d.a(this.e.a(paramhj, paramiz));
        }
        if (this.f != null) {
            return i(paramhj, paramiz);
        }
        if (this.b.c()) {
            throw jh.a(paramhj, "Can not instantiate abstract type " + this.b + " (need to add/enable type information?)");
        }
        throw jh.a(paramhj, "No suitable constructor found for type " + this.b + ": can not instantiate from JSON object (need to add/enable type information?)");
    }

    protected Object c(hj paramhj, iz paramiz, Object paramObject)
            throws IOException, hk {
        lc locallc = this.p.a();
        if (paramhj.e() != hm.c) {
            String str = paramhj.g();
            paramhj.b();
            kt localkt = this.h.a(str);
            if (localkt != null) {
            }
            for (; ; ) {
                try {
                    localkt.a(paramhj, paramiz, paramObject);
                    paramhj.b();
                } catch (Exception localException1) {
                    a(localException1, paramObject, str, paramiz);
                    continue;
                }
                if ((this.k != null) && (this.k.contains(str))) {
                    paramhj.d();
                } else if (!locallc.a(paramhj, paramiz, str, paramObject)) {
                    if (this.j != null) {
                        try {
                            this.j.a(paramhj, paramiz, paramObject, str);
                        } catch (Exception localException2) {
                            a(localException2, paramObject, str, paramiz);
                        }
                    } else {
                        a(paramhj, paramiz, paramObject, str);
                    }
                }
            }
        }
        return locallc.a(paramhj, paramiz, paramObject);
    }

    public final Class<?> d() {
        return this.b.p();
    }

    public Object d(hj paramhj, iz paramiz)
            throws IOException, hk {
        if ((this.e != null) && (!this.d.c())) {
            paramhj = this.d.a(this.e.a(paramhj, paramiz));
            if (this.i != null) {
                a(paramiz, paramhj);
            }
            return paramhj;
        }
        return this.d.a(paramhj.k());
    }

    public kx e() {
        return this.d;
    }

    public Object e(hj paramhj, iz paramiz)
            throws IOException, hk {
        Object localObject;
        switch (1. b[paramhj.q().ordinal()])
        {
            default:
                if (this.e == null) {
                    break label201;
                }
                localObject = this.d.a(this.e.a(paramhj, paramiz));
                paramhj = (hj) localObject;
                if (this.i != null) {
                    a(paramiz, localObject);
                    paramhj = (hj) localObject;
                }
                break;
        }
        do {
            do {
                return paramhj;
                if ((this.e == null) || (this.d.d())) {
                    break;
                }
                localObject = this.d.a(this.e.a(paramhj, paramiz));
                paramhj = (hj) localObject;
            } while (this.i == null);
            a(paramiz, localObject);
            return localObject;
            return this.d.a(paramhj.t());
            if ((this.e == null) || (this.d.d())) {
                break;
            }
            localObject = this.d.a(this.e.a(paramhj, paramiz));
            paramhj = (hj) localObject;
        } while (this.i == null);
        a(paramiz, localObject);
        return localObject;
        return this.d.a(paramhj.u());
        label201:
        throw paramiz.a(d(), "no suitable creator method found to deserialize from JSON integer number");
    }

    public Object f(hj paramhj, iz paramiz)
            throws IOException, hk {
        switch (1. b[paramhj.q().ordinal()])
        {
            default:
                if (this.e != null) {
                    paramhj = this.d.a(this.e.a(paramhj, paramiz));
                }
                break;
            case 3:
            case 4:
                Object localObject;
                do {
                    return paramhj;
                    if ((this.e == null) || (this.d.f())) {
                        break;
                    }
                    localObject = this.d.a(this.e.a(paramhj, paramiz));
                    paramhj = (hj) localObject;
                } while (this.i == null);
                a(paramiz, localObject);
                return localObject;
            return this.d.a(paramhj.x());
        }
        throw paramiz.a(d(), "no suitable creator method found to deserialize from JSON floating-point number");
    }

    public Object g(hj paramhj, iz paramiz)
            throws IOException, hk {
        if ((this.e != null) && (!this.d.g())) {
            paramhj = this.d.a(this.e.a(paramhj, paramiz));
            if (this.i != null) {
                a(paramiz, paramhj);
            }
            return paramhj;
        }
        if (paramhj.e() == hm.k) {
        }
        for (boolean bool = true; ; bool = false) {
            return this.d.a(bool);
        }
    }

    public Object h(hj paramhj, iz paramiz)
            throws IOException, hk {
        if (this.e != null) {
            try {
                paramhj = this.d.a(this.e.a(paramhj, paramiz));
                if (this.i != null) {
                    a(paramiz, paramhj);
                }
                return paramhj;
            } catch (Exception paramhj) {
                a(paramhj, paramiz);
            }
        }
        throw paramiz.b(d());
    }

    protected final Object i(hj paramhj, iz paramiz)
            throws IOException, hk {
        ld localld = this.f;
        lf locallf = localld.a(paramhj, paramiz);
        Object localObject2 = paramhj.e();
        Object localObject1 = null;
        Object localObject4;
        Object localObject3;
        for (; ; ) {
            if (localObject2 == hm.f) {
                localObject4 = paramhj.g();
                paramhj.b();
                kt localkt = localld.a((String) localObject4);
                if (localkt != null) {
                    Object localObject5 = localkt.a(paramhj, paramiz);
                    localObject2 = localObject1;
                    if (locallf.a(localkt.j(), localObject5)) {
                        paramhj.b();
                        try {
                            localObject2 = localld.a(locallf);
                            if (localObject2.getClass() == this.b.p()) {
                                break label159;
                            }
                            return a(paramhj, paramiz, localObject2, (sq) localObject1);
                        } catch (Exception localException) {
                            a(localException, this.b.p(), (String) localObject4, paramiz);
                            localObject3 = localObject1;
                        }
                    } else {
                        localObject4 = paramhj.b();
                        localObject1 = localObject3;
                        localObject3 = localObject4;
                        continue;
                    }
                    label159:
                    if (localObject1 == null) {
                        break label369;
                    }
                }
            }
        }
        label367:
        label369:
        for (localObject1 = a(paramiz, localObject3, (sq) localObject1); ; localObject1 = localObject3) {
            return a(paramhj, paramiz, localObject1);
            localObject3 = this.h.a((String) localObject4);
            if (localObject3 != null) {
                locallf.a((kt) localObject3, ((kt) localObject3).a(paramhj, paramiz));
                localObject3 = localObject1;
                break;
            }
            if ((this.k != null) && (this.k.contains(localObject4))) {
                paramhj.d();
                localObject3 = localObject1;
                break;
            }
            if (this.j != null) {
                locallf.a(this.j, (String) localObject4, this.j.a(paramhj, paramiz));
                localObject3 = localObject1;
                break;
            }
            localObject3 = localObject1;
            if (localObject1 == null) {
                localObject3 = new sq(paramhj.a());
            }
            ((sq) localObject3).a((String) localObject4);
            ((sq) localObject3).c(paramhj);
            break;
            try {
                paramhj = localld.a(locallf);
                if (localObject1 == null) {
                    break label367;
                }
                if (paramhj.getClass() != this.b.p()) {
                    return a(null, paramiz, paramhj, (sq) localObject1);
                }
            } catch (Exception paramhj) {
                a(paramhj, paramiz);
                return null;
            }
            return a(paramiz, paramhj, (sq) localObject1);
            return paramhj;
        }
    }

    protected Object j(hj paramhj, iz paramiz)
            throws IOException, hk {
        if (this.e != null) {
            return this.d.a(this.e.a(paramhj, paramiz));
        }
        if (this.f != null) {
            return k(paramhj, paramiz);
        }
        sq localsq = new sq(paramhj.a());
        localsq.d();
        Object localObject = this.d.m();
        if (this.i != null) {
            a(paramiz, localObject);
        }
        if (paramhj.e() != hm.c) {
            String str = paramhj.g();
            paramhj.b();
            kt localkt = this.h.a(str);
            if (localkt != null) {
            }
            for (; ; ) {
                try {
                    localkt.a(paramhj, paramiz, localObject);
                    paramhj.b();
                } catch (Exception localException1) {
                    a(localException1, localObject, str, paramiz);
                    continue;
                }
                if ((this.k != null) && (this.k.contains(str))) {
                    paramhj.d();
                } else {
                    localsq.a(str);
                    localsq.c(paramhj);
                    if (this.j != null) {
                        try {
                            this.j.a(paramhj, paramiz, localObject, str);
                        } catch (Exception localException2) {
                            a(localException2, localObject, str, paramiz);
                        }
                    }
                }
            }
        }
        localsq.e();
        this.o.a(paramhj, paramiz, localObject, localsq);
        return localObject;
    }

    protected Object k(hj paramhj, iz paramiz)
            throws IOException, hk {
        ld localld = this.f;
        lf locallf = localld.a(paramhj, paramiz);
        sq localsq = new sq(paramhj.a());
        localsq.d();
        Object localObject1 = paramhj.e();
        Object localObject2;
        if (localObject1 == hm.f) {
            String str = paramhj.g();
            paramhj.b();
            localObject1 = localld.a(str);
            Object localObject3;
            if (localObject1 != null) {
                localObject3 = ((kt) localObject1).a(paramhj, paramiz);
                if (locallf.a(((kt) localObject1).j(), localObject3)) {
                    localObject1 = paramhj.b();
                    try {
                        localObject3 = localld.a(locallf);
                        while (localObject1 == hm.f) {
                            paramhj.b();
                            localsq.c(paramhj);
                            localObject1 = paramhj.b();
                            continue;
                            localObject2 = paramhj.b();
                        }
                    } catch (Exception localException) {
                        a(localException, this.b.p(), str, paramiz);
                    }
                }
            }
            for (; ; ) {
                break;
                localsq.e();
                if (localObject3.getClass() != this.b.p()) {
                    throw paramiz.b("Can not create polymorphic instances with unwrapped values");
                }
                return this.o.a(paramhj, paramiz, localObject3, localsq);
                localObject2 = this.h.a(str);
                if (localObject2 != null) {
                    locallf.a((kt) localObject2, ((kt) localObject2).a(paramhj, paramiz));
                } else if ((this.k != null) && (this.k.contains(str))) {
                    paramhj.d();
                } else {
                    localsq.a(str);
                    localsq.c(paramhj);
                    if (this.j != null) {
                        locallf.a(this.j, str, this.j.a(paramhj, paramiz));
                    }
                }
            }
        }
        try {
            localObject2 = localld.a(locallf);
            return this.o.a(paramhj, paramiz, localObject2, localsq);
        } catch (Exception paramhj) {
            a(paramhj, paramiz);
        }
        return null;
    }

    protected Object l(hj paramhj, iz paramiz)
            throws IOException, hk {
        if (this.f != null) {
            return m(paramhj, paramiz);
        }
        return c(paramhj, paramiz, this.d.m());
    }

    protected Object m(hj paramhj, iz paramiz)
            throws IOException, hk {
        lc locallc = this.p.a();
        ld localld = this.f;
        lf locallf = localld.a(paramhj, paramiz);
        sq localsq = new sq(paramhj.a());
        localsq.d();
        Object localObject1 = paramhj.e();
        Object localObject2;
        if (localObject1 == hm.f) {
            String str = paramhj.g();
            paramhj.b();
            localObject1 = localld.a(str);
            Object localObject3;
            if (localObject1 != null) {
                localObject3 = ((kt) localObject1).a(paramhj, paramiz);
                if (locallf.a(((kt) localObject1).j(), localObject3)) {
                    localObject1 = paramhj.b();
                    try {
                        localObject3 = localld.a(locallf);
                        while (localObject1 == hm.f) {
                            paramhj.b();
                            localsq.c(paramhj);
                            localObject1 = paramhj.b();
                            continue;
                            localObject2 = paramhj.b();
                        }
                    } catch (Exception localException) {
                        a(localException, this.b.p(), str, paramiz);
                    }
                }
            }
            for (; ; ) {
                break;
                if (localObject3.getClass() != this.b.p()) {
                    throw paramiz.b("Can not create polymorphic instances with unwrapped values");
                }
                return locallc.a(paramhj, paramiz, localObject3);
                localObject2 = this.h.a(str);
                if (localObject2 != null) {
                    locallf.a((kt) localObject2, ((kt) localObject2).a(paramhj, paramiz));
                } else if (!locallc.a(paramhj, paramiz, str, null)) {
                    if ((this.k != null) && (this.k.contains(str))) {
                        paramhj.d();
                    } else if (this.j != null) {
                        locallf.a(this.j, str, this.j.a(paramhj, paramiz));
                    }
                }
            }
        }
        try {
            localObject2 = localld.a(locallf);
            return locallc.a(paramhj, paramiz, localObject2);
        } catch (Exception paramhj) {
            a(paramhj, paramiz);
        }
        return null;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/ko.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */