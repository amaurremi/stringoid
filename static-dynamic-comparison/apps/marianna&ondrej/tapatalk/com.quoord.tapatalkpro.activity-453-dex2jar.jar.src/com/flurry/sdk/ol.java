package com.flurry.sdk;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class ol
        extends og {
    public static final ol e = new ol(null);
    protected final jv.a f;

    protected ol(jv.a parama) {
        Object localObject = parama;
        if (parama == null) {
            localObject = new a();
        }
        this.f = ((jv.a) localObject);
    }

    protected jk<Object> a(ju paramju, mw parammw, is paramis)
            throws jh {
        if (parammw.b() == Object.class) {
            throw new IllegalArgumentException("Can not create bean serializer for Object.class");
        }
        ok localok = a(parammw);
        Object localObject2 = c(paramju, parammw);
        Object localObject1 = localObject2;
        if (localObject2 == null) {
            localObject1 = new ArrayList();
        }
        Iterator localIterator;
        if (this.f.b()) {
            localIterator = this.f.e().iterator();
            for (; ; ) {
                localObject2 = localObject1;
                if (!localIterator.hasNext()) {
                    break;
                }
                localObject1 = ((om) localIterator.next()).a(paramju, parammw, (List) localObject1);
            }
        }
        localObject2 = localObject1;
        localObject1 = b(paramju, parammw, a(paramju, parammw, (List) localObject2));
        if (this.f.b()) {
            localIterator = this.f.e().iterator();
            for (; ; ) {
                localObject2 = localObject1;
                if (!localIterator.hasNext()) {
                    break;
                }
                localObject1 = ((om) localIterator.next()).b(paramju, parammw, (List) localObject1);
            }
        }
        localObject2 = localObject1;
        localok.a((List) localObject2);
        localok.a(b(paramju, parammw));
        localObject1 = parammw.p();
        if (localObject1 != null) {
            if (paramju.a(ju.a.e)) {
                ((mr) localObject1).k();
            }
            localObject2 = ((mr) localObject1).a(parammw.j());
            localok.a(new of((mr) localObject1, po.a(null, (sh) localObject2, paramju.a(ju.a.h), b(paramju, ((sh) localObject2).g(), paramis), paramis, null, null)));
        }
        a(paramju, localok);
        if (this.f.b()) {
            localObject2 = this.f.e().iterator();
            for (paramis = localok; ; paramis = ((om) ((Iterator) localObject2).next()).a(paramju, parammw, paramis)) {
                localObject1 = paramis;
                if (!((Iterator) localObject2).hasNext()) {
                    break;
                }
            }
        }
        localObject1 = localok;
        paramis = ((ok) localObject1).b();
        paramju = paramis;
        if (paramis == null) {
            paramju = paramis;
            if (parammw.h()) {
                paramju = ((ok) localObject1).c();
            }
        }
        return paramju;
    }

    public jk<Object> a(ju paramju, sh paramsh, is paramis)
            throws jh {
        mw localmw = (mw) paramju.b(paramsh);
        jk localjk = a(paramju, localmw.c(), paramis);
        if (localjk != null) {
            paramsh = localjk;
        }
        sh localsh;
        boolean bool;
        do {
            do {
                do {
                    return paramsh;
                    localsh = a(paramju, localmw.c(), paramsh);
                    if (localsh != paramsh) {
                    }
                    for (bool = true; paramsh.f(); bool = false) {
                        return b(paramju, localsh, localmw, paramis, bool);
                    }
                    paramsh = this.f.c().iterator();
                    while (paramsh.hasNext()) {
                        localjk = ((jx) paramsh.next()).a(paramju, localsh, localmw, paramis);
                        if (localjk != null) {
                            return localjk;
                        }
                    }
                    localjk = a(localsh, paramju, localmw, paramis, bool);
                    paramsh = localjk;
                } while (localjk != null);
                localjk = b(localsh, paramju, localmw, paramis, bool);
                paramsh = localjk;
            } while (localjk != null);
            localjk = a(paramju, localsh, localmw, paramis);
            paramsh = localjk;
        } while (localjk != null);
        return a(paramju, localsh, localmw, paramis, bool);
    }

    public jk<Object> a(ju paramju, sh paramsh, mw parammw, is paramis)
            throws jh {
        if (!b(paramsh.p())) {
            paramis = null;
            return paramis;
        }
        paramsh = a(paramju, parammw, paramis);
        if (this.f.b()) {
            Iterator localIterator = this.f.e().iterator();
            for (; ; ) {
                paramis = paramsh;
                if (!localIterator.hasNext()) {
                    break;
                }
                paramsh = ((om) localIterator.next()).a(paramju, parammw, paramsh);
            }
        }
        return paramsh;
    }

    public jv.a a() {
        return this.f;
    }

    public jv a(jv.a parama) {
        if (this.f == parama) {
            return this;
        }
        if (getClass() != ol.class) {
            throw new IllegalStateException("Subtype of BeanSerializerFactory (" + getClass().getName() + ") has not properly overridden method 'withAdditionalSerializers': can not instantiate subtype with " + "additional serializer definitions");
        }
        return new ol(parama);
    }

    public jz a(sh paramsh, ju paramju, mq parammq, is paramis)
            throws jh {
        iq localiq = paramju.a();
        ni localni = localiq.a(paramju, parammq, paramsh);
        if (localni == null) {
            return b(paramju, paramsh, paramis);
        }
        return localni.a(paramju, paramsh, paramju.l().a(parammq, paramju, localiq), paramis);
    }

    protected oi a(ju paramju, qr paramqr, op paramop, boolean paramBoolean, String paramString, mq parammq)
            throws jh {
        if (paramju.a(ju.a.e)) {
            parammq.k();
        }
        sh localsh = parammq.a(paramqr);
        is.a locala = new is.a(paramString, localsh, paramop.a(), parammq);
        jk localjk = a(paramju, parammq, locala);
        paramqr = null;
        if (qy.e(localsh.p())) {
            paramqr = b(localsh, paramju, parammq, locala);
        }
        paramqr = paramop.a(paramString, localsh, localjk, a(localsh, paramju, parammq, locala), paramqr, parammq, paramBoolean);
        paramqr.a(paramju.a().g(parammq));
        return paramqr;
    }

    protected oi a(oi paramoi, Class<?>[] paramArrayOfClass) {
        return oo.a(paramoi, paramArrayOfClass);
    }

    protected ok a(mw parammw) {
        return new ok(parammw);
    }

    protected op a(ju paramju, mw parammw) {
        return new op(paramju, parammw);
    }

    protected List<oi> a(ju paramju, mw parammw, List<oi> paramList) {
        paramju = paramju.a().c(parammw.c());
        if ((paramju != null) && (paramju.length > 0)) {
            paramju = qw.a(paramju);
            parammw = paramList.iterator();
            while (parammw.hasNext()) {
                if (paramju.contains(((oi) parammw.next()).d())) {
                    parammw.remove();
                }
            }
        }
        return paramList;
    }

    protected void a(ju paramju, ok paramok) {
        List localList = paramok.a();
        boolean bool = paramju.a(ju.a.i);
        int m = localList.size();
        paramju = new oi[m];
        int k = 0;
        int i = 0;
        if (k < m) {
            oi localoi = (oi) localList.get(k);
            Class[] arrayOfClass = localoi.h();
            int j;
            if (arrayOfClass == null) {
                j = i;
                if (!bool) {
                    break label108;
                }
                paramju[k] = localoi;
            }
            for (; ; ) {
                k += 1;
                break;
                j = i + 1;
                paramju[k] = a(localoi, arrayOfClass);
                label108:
                i = j;
            }
        }
        if ((bool) && (i == 0)) {
            return;
        }
        paramok.a(paramju);
    }

    public jz b(sh paramsh, ju paramju, mq parammq, is paramis)
            throws jh {
        sh localsh = paramsh.g();
        iq localiq = paramju.a();
        paramsh = localiq.b(paramju, parammq, paramsh);
        if (paramsh == null) {
            return b(paramju, localsh, paramis);
        }
        return paramsh.a(paramju, localsh, paramju.l().a(parammq, paramju, localiq), paramis);
    }

    protected Iterable<jx> b() {
        return this.f.c();
    }

    protected Object b(ju paramju, mw parammw) {
        return paramju.a().f(parammw.c());
    }

    @Deprecated
    protected List<oi> b(ju paramju, mw parammw, List<oi> paramList) {
        return paramList;
    }

    protected boolean b(Class<?> paramClass) {
        return (qy.a(paramClass) == null) && (!qy.c(paramClass));
    }

    public jk<Object> c(ju paramju, sh paramsh, is paramis) {
        Object localObject = null;
        jk localjk = null;
        if (!this.f.a()) {
            localObject = localjk;
        }
        do {
            mw localmw;
            Iterator localIterator;
            while (!localIterator.hasNext()) {
                return (jk<Object>) localObject;
                localmw = (mw) paramju.c(paramsh.p());
                localIterator = this.f.d().iterator();
            }
            localjk = ((jx) localIterator.next()).a(paramju, paramsh, localmw, paramis);
            localObject = localjk;
        } while (localjk == null);
        return localjk;
    }

    protected List<oi> c(ju paramju, mw parammw)
            throws jh {
        Object localObject1 = parammw.d();
        iq localiq = paramju.a();
        c(paramju, parammw, (List) localObject1);
        if (paramju.a(ju.a.f)) {
            d(paramju, parammw, (List) localObject1);
        }
        if (((List) localObject1).isEmpty()) {
            return null;
        }
        boolean bool = a(paramju, parammw, null, null);
        op localop = a(paramju, parammw);
        ArrayList localArrayList = new ArrayList(((List) localObject1).size());
        parammw = parammw.j();
        localObject1 = ((List) localObject1).iterator();
        while (((Iterator) localObject1).hasNext()) {
            Object localObject2 = (it) ((Iterator) localObject1).next();
            mq localmq = ((it) localObject2).j();
            iq.a locala = localiq.a(localmq);
            if ((locala == null) || (!locala.c())) {
                localObject2 = ((it) localObject2).a();
                if ((localmq instanceof mr)) {
                    localArrayList.add(a(paramju, parammw, localop, bool, (String) localObject2, (mr) localmq));
                } else {
                    localArrayList.add(a(paramju, parammw, localop, bool, (String) localObject2, (mp) localmq));
                }
            }
        }
        return localArrayList;
    }

    protected void c(ju paramju, mw parammw, List<it> paramList) {
        iq localiq = paramju.a();
        HashMap localHashMap = new HashMap();
        Iterator localIterator = paramList.iterator();
        while (localIterator.hasNext()) {
            parammw = ((it) localIterator.next()).j();
            if (parammw == null) {
                localIterator.remove();
            } else {
                Class localClass = parammw.d();
                paramList = (Boolean) localHashMap.get(localClass);
                parammw = paramList;
                if (paramList == null) {
                    paramList = localiq.e(((mw) paramju.c(localClass)).c());
                    parammw = paramList;
                    if (paramList == null) {
                        parammw = Boolean.FALSE;
                    }
                    localHashMap.put(localClass, parammw);
                }
                if (parammw.booleanValue()) {
                    localIterator.remove();
                }
            }
        }
    }

    protected void d(ju paramju, mw parammw, List<it> paramList) {
        paramju = paramList.iterator();
        while (paramju.hasNext()) {
            if (!((it) paramju.next()).f()) {
                paramju.remove();
            }
        }
    }

    public static class a
            extends jv.a {
        protected static final jx[] a = new jx[0];
        protected static final om[] b = new om[0];
        protected final jx[] c;
        protected final jx[] d;
        protected final om[] e;

        public a() {
            this(null, null, null);
        }

        protected a(jx[] paramArrayOfjx1, jx[] paramArrayOfjx2, om[] paramArrayOfom) {
            jx[] arrayOfjx = paramArrayOfjx1;
            if (paramArrayOfjx1 == null) {
                arrayOfjx = a;
            }
            this.c = arrayOfjx;
            paramArrayOfjx1 = paramArrayOfjx2;
            if (paramArrayOfjx2 == null) {
                paramArrayOfjx1 = a;
            }
            this.d = paramArrayOfjx1;
            paramArrayOfjx1 = paramArrayOfom;
            if (paramArrayOfom == null) {
                paramArrayOfjx1 = b;
            }
            this.e = paramArrayOfjx1;
        }

        public jv.a a(jx paramjx) {
            if (paramjx == null) {
                throw new IllegalArgumentException("Can not pass null Serializers");
            }
            return new a((jx[]) qw.a(this.c, paramjx), this.d, this.e);
        }

        public boolean a() {
            return this.d.length > 0;
        }

        public jv.a b(jx paramjx) {
            if (paramjx == null) {
                throw new IllegalArgumentException("Can not pass null Serializers");
            }
            paramjx = (jx[]) qw.a(this.d, paramjx);
            return new a(this.c, paramjx, this.e);
        }

        public boolean b() {
            return this.e.length > 0;
        }

        public Iterable<jx> c() {
            return qw.b(this.c);
        }

        public Iterable<jx> d() {
            return qw.b(this.d);
        }

        public Iterable<om> e() {
            return qw.b(this.e);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/ol.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */