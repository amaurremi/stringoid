package com.umeng.analytics.d;

import com.umeng.a.a.a.a.g;
import com.umeng.a.a.a.b.h;
import com.umeng.a.a.a.b.i;
import com.umeng.a.a.a.j;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class z
        implements com.umeng.a.a.a.d<z, e>, Serializable, Cloneable {
    public static final Map<e, com.umeng.a.a.a.a.b> j;
    private static final com.umeng.a.a.a.b.m k = new com.umeng.a.a.a.b.m("UALogEntry");
    private static final com.umeng.a.a.a.b.c l = new com.umeng.a.a.a.b.c("client_stats", (byte) 12, (short) 1);
    private static final com.umeng.a.a.a.b.c m = new com.umeng.a.a.a.b.c("app_info", (byte) 12, (short) 2);
    private static final com.umeng.a.a.a.b.c n = new com.umeng.a.a.a.b.c("device_info", (byte) 12, (short) 3);
    private static final com.umeng.a.a.a.b.c o = new com.umeng.a.a.a.b.c("misc_info", (byte) 12, (short) 4);
    private static final com.umeng.a.a.a.b.c p = new com.umeng.a.a.a.b.c("activate_msg", (byte) 12, (short) 5);
    private static final com.umeng.a.a.a.b.c q = new com.umeng.a.a.a.b.c("instant_msgs", (byte) 15, (short) 6);
    private static final com.umeng.a.a.a.b.c r = new com.umeng.a.a.a.b.c("sessions", (byte) 15, (short) 7);
    private static final com.umeng.a.a.a.b.c s = new com.umeng.a.a.a.b.c("imprint", (byte) 12, (short) 8);
    private static final com.umeng.a.a.a.b.c t = new com.umeng.a.a.a.b.c("id_tracking", (byte) 12, (short) 9);
    private static final Map<Class<? extends com.umeng.a.a.a.c.a>, com.umeng.a.a.a.c.b> u = new HashMap();
    public d a;
    public c b;
    public e c;
    public r d;
    public b e;
    public List<p> f;
    public List<x> g;
    public n h;
    public m i;
    private e[] v = {e.e, e.f, e.g, e.h, e.i};

    static {
        u.put(com.umeng.a.a.a.c.c.class, new b(null));
        u.put(com.umeng.a.a.a.c.d.class, new d(null));
        EnumMap localEnumMap = new EnumMap(e.class);
        localEnumMap.put(e.a, new com.umeng.a.a.a.a.b("client_stats", (byte) 1, new g((byte) 12, d.class)));
        localEnumMap.put(e.b, new com.umeng.a.a.a.a.b("app_info", (byte) 1, new g((byte) 12, c.class)));
        localEnumMap.put(e.c, new com.umeng.a.a.a.a.b("device_info", (byte) 1, new g((byte) 12, e.class)));
        localEnumMap.put(e.d, new com.umeng.a.a.a.a.b("misc_info", (byte) 1, new g((byte) 12, r.class)));
        localEnumMap.put(e.e, new com.umeng.a.a.a.a.b("activate_msg", (byte) 2, new g((byte) 12, b.class)));
        localEnumMap.put(e.f, new com.umeng.a.a.a.a.b("instant_msgs", (byte) 2, new com.umeng.a.a.a.a.d((byte) 15, new g((byte) 12, p.class))));
        localEnumMap.put(e.g, new com.umeng.a.a.a.a.b("sessions", (byte) 2, new com.umeng.a.a.a.a.d((byte) 15, new g((byte) 12, x.class))));
        localEnumMap.put(e.h, new com.umeng.a.a.a.a.b("imprint", (byte) 2, new g((byte) 12, n.class)));
        localEnumMap.put(e.i, new com.umeng.a.a.a.a.b("id_tracking", (byte) 2, new g((byte) 12, m.class)));
        j = Collections.unmodifiableMap(localEnumMap);
        com.umeng.a.a.a.a.b.a(z.class, j);
    }

    public z() {
    }

    public z(d paramd, c paramc, e parame, r paramr) {
        this();
        this.a = paramd;
        this.b = paramc;
        this.c = parame;
        this.d = paramr;
    }

    public z(z paramz) {
        if (paramz.e()) {
            this.a = new d(paramz.a);
        }
        if (paramz.i()) {
            this.b = new c(paramz.b);
        }
        if (paramz.l()) {
            this.c = new e(paramz.c);
        }
        if (paramz.o()) {
            this.d = new r(paramz.d);
        }
        if (paramz.r()) {
            this.e = new b(paramz.e);
        }
        ArrayList localArrayList;
        Iterator localIterator;
        if (paramz.w()) {
            localArrayList = new ArrayList();
            localIterator = paramz.f.iterator();
            while (localIterator.hasNext()) {
                localArrayList.add(new p((p) localIterator.next()));
            }
            this.f = localArrayList;
        }
        if (paramz.B()) {
            localArrayList = new ArrayList();
            localIterator = paramz.g.iterator();
            while (localIterator.hasNext()) {
                localArrayList.add(new x((x) localIterator.next()));
            }
            this.g = localArrayList;
        }
        if (paramz.E()) {
            this.h = new n(paramz.h);
        }
        if (paramz.H()) {
            this.i = new m(paramz.i);
        }
    }

    private void a(ObjectInputStream paramObjectInputStream)
            throws IOException, ClassNotFoundException {
        try {
            a(new com.umeng.a.a.a.b.b(new com.umeng.a.a.a.d.a(paramObjectInputStream)));
            return;
        } catch (j paramObjectInputStream) {
            throw new IOException(paramObjectInputStream.getMessage());
        }
    }

    private void a(ObjectOutputStream paramObjectOutputStream)
            throws IOException {
        try {
            b(new com.umeng.a.a.a.b.b(new com.umeng.a.a.a.d.a(paramObjectOutputStream)));
            return;
        } catch (j paramObjectOutputStream) {
            throw new IOException(paramObjectOutputStream.getMessage());
        }
    }

    public void A() {
        this.g = null;
    }

    public boolean B() {
        return this.g != null;
    }

    public n C() {
        return this.h;
    }

    public void D() {
        this.h = null;
    }

    public boolean E() {
        return this.h != null;
    }

    public m F() {
        return this.i;
    }

    public void G() {
        this.i = null;
    }

    public boolean H() {
        return this.i != null;
    }

    public void I()
            throws j {
        if (this.a == null) {
            throw new i("Required field 'client_stats' was not present! Struct: " + toString());
        }
        if (this.b == null) {
            throw new i("Required field 'app_info' was not present! Struct: " + toString());
        }
        if (this.c == null) {
            throw new i("Required field 'device_info' was not present! Struct: " + toString());
        }
        if (this.d == null) {
            throw new i("Required field 'misc_info' was not present! Struct: " + toString());
        }
        if (this.a != null) {
            this.a.m();
        }
        if (this.b != null) {
            this.b.H();
        }
        if (this.c != null) {
            this.c.ac();
        }
        if (this.d != null) {
            this.d.K();
        }
        if (this.e != null) {
            this.e.f();
        }
        if (this.h != null) {
            this.h.n();
        }
        if (this.i != null) {
            this.i.p();
        }
    }

    public e a(int paramInt) {
        return e.a(paramInt);
    }

    public z a() {
        return new z(this);
    }

    public z a(b paramb) {
        this.e = paramb;
        return this;
    }

    public z a(c paramc) {
        this.b = paramc;
        return this;
    }

    public z a(d paramd) {
        this.a = paramd;
        return this;
    }

    public z a(e parame) {
        this.c = parame;
        return this;
    }

    public z a(m paramm) {
        this.i = paramm;
        return this;
    }

    public z a(n paramn) {
        this.h = paramn;
        return this;
    }

    public z a(r paramr) {
        this.d = paramr;
        return this;
    }

    public z a(List<p> paramList) {
        this.f = paramList;
        return this;
    }

    public void a(h paramh)
            throws j {
        ((com.umeng.a.a.a.c.b) u.get(paramh.D())).b().b(paramh, this);
    }

    public void a(p paramp) {
        if (this.f == null) {
            this.f = new ArrayList();
        }
        this.f.add(paramp);
    }

    public void a(x paramx) {
        if (this.g == null) {
            this.g = new ArrayList();
        }
        this.g.add(paramx);
    }

    public void a(boolean paramBoolean) {
        if (!paramBoolean) {
            this.a = null;
        }
    }

    public z b(List<x> paramList) {
        this.g = paramList;
        return this;
    }

    public void b() {
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
    }

    public void b(h paramh)
            throws j {
        ((com.umeng.a.a.a.c.b) u.get(paramh.D())).b().a(paramh, this);
    }

    public void b(boolean paramBoolean) {
        if (!paramBoolean) {
            this.b = null;
        }
    }

    public d c() {
        return this.a;
    }

    public void c(boolean paramBoolean) {
        if (!paramBoolean) {
            this.c = null;
        }
    }

    public void d() {
        this.a = null;
    }

    public void d(boolean paramBoolean) {
        if (!paramBoolean) {
            this.d = null;
        }
    }

    public void e(boolean paramBoolean) {
        if (!paramBoolean) {
            this.e = null;
        }
    }

    public boolean e() {
        return this.a != null;
    }

    public c f() {
        return this.b;
    }

    public void f(boolean paramBoolean) {
        if (!paramBoolean) {
            this.f = null;
        }
    }

    public void g(boolean paramBoolean) {
        if (!paramBoolean) {
            this.g = null;
        }
    }

    public void h() {
        this.b = null;
    }

    public void h(boolean paramBoolean) {
        if (!paramBoolean) {
            this.h = null;
        }
    }

    public void i(boolean paramBoolean) {
        if (!paramBoolean) {
            this.i = null;
        }
    }

    public boolean i() {
        return this.b != null;
    }

    public e j() {
        return this.c;
    }

    public void k() {
        this.c = null;
    }

    public boolean l() {
        return this.c != null;
    }

    public r m() {
        return this.d;
    }

    public void n() {
        this.d = null;
    }

    public boolean o() {
        return this.d != null;
    }

    public b p() {
        return this.e;
    }

    public void q() {
        this.e = null;
    }

    public boolean r() {
        return this.e != null;
    }

    public int s() {
        if (this.f == null) {
            return 0;
        }
        return this.f.size();
    }

    public Iterator<p> t() {
        if (this.f == null) {
            return null;
        }
        return this.f.iterator();
    }

    public String toString() {
        StringBuilder localStringBuilder = new StringBuilder("UALogEntry(");
        localStringBuilder.append("client_stats:");
        if (this.a == null) {
            localStringBuilder.append("null");
            localStringBuilder.append(", ");
            localStringBuilder.append("app_info:");
            if (this.b != null) {
                break label342;
            }
            localStringBuilder.append("null");
            label65:
            localStringBuilder.append(", ");
            localStringBuilder.append("device_info:");
            if (this.c != null) {
                break label354;
            }
            localStringBuilder.append("null");
            label96:
            localStringBuilder.append(", ");
            localStringBuilder.append("misc_info:");
            if (this.d != null) {
                break label366;
            }
            localStringBuilder.append("null");
            label127:
            if (r()) {
                localStringBuilder.append(", ");
                localStringBuilder.append("activate_msg:");
                if (this.e != null) {
                    break label378;
                }
                localStringBuilder.append("null");
            }
            label165:
            if (w()) {
                localStringBuilder.append(", ");
                localStringBuilder.append("instant_msgs:");
                if (this.f != null) {
                    break label390;
                }
                localStringBuilder.append("null");
            }
            label203:
            if (B()) {
                localStringBuilder.append(", ");
                localStringBuilder.append("sessions:");
                if (this.g != null) {
                    break label402;
                }
                localStringBuilder.append("null");
            }
            label241:
            if (E()) {
                localStringBuilder.append(", ");
                localStringBuilder.append("imprint:");
                if (this.h != null) {
                    break label414;
                }
                localStringBuilder.append("null");
            }
            label279:
            if (H()) {
                localStringBuilder.append(", ");
                localStringBuilder.append("id_tracking:");
                if (this.i != null) {
                    break label426;
                }
                localStringBuilder.append("null");
            }
        }
        for (; ; ) {
            localStringBuilder.append(")");
            return localStringBuilder.toString();
            localStringBuilder.append(this.a);
            break;
            label342:
            localStringBuilder.append(this.b);
            break label65;
            label354:
            localStringBuilder.append(this.c);
            break label96;
            label366:
            localStringBuilder.append(this.d);
            break label127;
            label378:
            localStringBuilder.append(this.e);
            break label165;
            label390:
            localStringBuilder.append(this.f);
            break label203;
            label402:
            localStringBuilder.append(this.g);
            break label241;
            label414:
            localStringBuilder.append(this.h);
            break label279;
            label426:
            localStringBuilder.append(this.i);
        }
    }

    public List<p> u() {
        return this.f;
    }

    public void v() {
        this.f = null;
    }

    public boolean w() {
        return this.f != null;
    }

    public int x() {
        if (this.g == null) {
            return 0;
        }
        return this.g.size();
    }

    public Iterator<x> y() {
        if (this.g == null) {
            return null;
        }
        return this.g.iterator();
    }

    public List<x> z() {
        return this.g;
    }

    private static class a
            extends com.umeng.a.a.a.c.c<z> {
        public void a(h paramh, z paramz)
                throws j {
            paramh.j();
            Object localObject1 = paramh.l();
            if (((com.umeng.a.a.a.b.c) localObject1).b == 0) {
                paramh.k();
                paramz.I();
                return;
            }
            switch (((com.umeng.a.a.a.b.c) localObject1).c) {
                default:
                    com.umeng.a.a.a.b.k.a(paramh, ((com.umeng.a.a.a.b.c) localObject1).b);
            }
            for (; ; ) {
                paramh.m();
                break;
                if (((com.umeng.a.a.a.b.c) localObject1).b == 12) {
                    paramz.a = new d();
                    paramz.a.a(paramh);
                    paramz.a(true);
                } else {
                    com.umeng.a.a.a.b.k.a(paramh, ((com.umeng.a.a.a.b.c) localObject1).b);
                    continue;
                    if (((com.umeng.a.a.a.b.c) localObject1).b == 12) {
                        paramz.b = new c();
                        paramz.b.a(paramh);
                        paramz.b(true);
                    } else {
                        com.umeng.a.a.a.b.k.a(paramh, ((com.umeng.a.a.a.b.c) localObject1).b);
                        continue;
                        if (((com.umeng.a.a.a.b.c) localObject1).b == 12) {
                            paramz.c = new e();
                            paramz.c.a(paramh);
                            paramz.c(true);
                        } else {
                            com.umeng.a.a.a.b.k.a(paramh, ((com.umeng.a.a.a.b.c) localObject1).b);
                            continue;
                            if (((com.umeng.a.a.a.b.c) localObject1).b == 12) {
                                paramz.d = new r();
                                paramz.d.a(paramh);
                                paramz.d(true);
                            } else {
                                com.umeng.a.a.a.b.k.a(paramh, ((com.umeng.a.a.a.b.c) localObject1).b);
                                continue;
                                if (((com.umeng.a.a.a.b.c) localObject1).b == 12) {
                                    paramz.e = new b();
                                    paramz.e.a(paramh);
                                    paramz.e(true);
                                } else {
                                    com.umeng.a.a.a.b.k.a(paramh, ((com.umeng.a.a.a.b.c) localObject1).b);
                                    continue;
                                    int i;
                                    Object localObject2;
                                    if (((com.umeng.a.a.a.b.c) localObject1).b == 15) {
                                        localObject1 = paramh.p();
                                        paramz.f = new ArrayList(((com.umeng.a.a.a.b.d) localObject1).b);
                                        i = 0;
                                        while (i < ((com.umeng.a.a.a.b.d) localObject1).b) {
                                            localObject2 = new p();
                                            ((p) localObject2).a(paramh);
                                            paramz.f.add(localObject2);
                                            i += 1;
                                        }
                                        paramh.q();
                                        paramz.f(true);
                                    } else {
                                        com.umeng.a.a.a.b.k.a(paramh, ((com.umeng.a.a.a.b.c) localObject1).b);
                                        continue;
                                        if (((com.umeng.a.a.a.b.c) localObject1).b == 15) {
                                            localObject1 = paramh.p();
                                            paramz.g = new ArrayList(((com.umeng.a.a.a.b.d) localObject1).b);
                                            i = 0;
                                            while (i < ((com.umeng.a.a.a.b.d) localObject1).b) {
                                                localObject2 = new x();
                                                ((x) localObject2).a(paramh);
                                                paramz.g.add(localObject2);
                                                i += 1;
                                            }
                                            paramh.q();
                                            paramz.g(true);
                                        } else {
                                            com.umeng.a.a.a.b.k.a(paramh, ((com.umeng.a.a.a.b.c) localObject1).b);
                                            continue;
                                            if (((com.umeng.a.a.a.b.c) localObject1).b == 12) {
                                                paramz.h = new n();
                                                paramz.h.a(paramh);
                                                paramz.h(true);
                                            } else {
                                                com.umeng.a.a.a.b.k.a(paramh, ((com.umeng.a.a.a.b.c) localObject1).b);
                                                continue;
                                                if (((com.umeng.a.a.a.b.c) localObject1).b == 12) {
                                                    paramz.i = new m();
                                                    paramz.i.a(paramh);
                                                    paramz.i(true);
                                                } else {
                                                    com.umeng.a.a.a.b.k.a(paramh, ((com.umeng.a.a.a.b.c) localObject1).b);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        public void b(h paramh, z paramz)
                throws j {
            paramz.I();
            paramh.a(z.J());
            if (paramz.a != null) {
                paramh.a(z.K());
                paramz.a.b(paramh);
                paramh.c();
            }
            if (paramz.b != null) {
                paramh.a(z.L());
                paramz.b.b(paramh);
                paramh.c();
            }
            if (paramz.c != null) {
                paramh.a(z.M());
                paramz.c.b(paramh);
                paramh.c();
            }
            if (paramz.d != null) {
                paramh.a(z.N());
                paramz.d.b(paramh);
                paramh.c();
            }
            if ((paramz.e != null) && (paramz.r())) {
                paramh.a(z.O());
                paramz.e.b(paramh);
                paramh.c();
            }
            Iterator localIterator;
            if ((paramz.f != null) && (paramz.w())) {
                paramh.a(z.P());
                paramh.a(new com.umeng.a.a.a.b.d((byte) 12, paramz.f.size()));
                localIterator = paramz.f.iterator();
                while (localIterator.hasNext()) {
                    ((p) localIterator.next()).b(paramh);
                }
                paramh.f();
                paramh.c();
            }
            if ((paramz.g != null) && (paramz.B())) {
                paramh.a(z.Q());
                paramh.a(new com.umeng.a.a.a.b.d((byte) 12, paramz.g.size()));
                localIterator = paramz.g.iterator();
                while (localIterator.hasNext()) {
                    ((x) localIterator.next()).b(paramh);
                }
                paramh.f();
                paramh.c();
            }
            if ((paramz.h != null) && (paramz.E())) {
                paramh.a(z.R());
                paramz.h.b(paramh);
                paramh.c();
            }
            if ((paramz.i != null) && (paramz.H())) {
                paramh.a(z.S());
                paramz.i.b(paramh);
                paramh.c();
            }
            paramh.d();
            paramh.b();
        }
    }

    private static class b
            implements com.umeng.a.a.a.c.b {
        public z.a a() {
            return new z.a(null);
        }
    }

    private static class c
            extends com.umeng.a.a.a.c.d<z> {
        public void a(h paramh, z paramz)
                throws j {
            paramh = (com.umeng.a.a.a.b.n) paramh;
            paramz.a.b(paramh);
            paramz.b.b(paramh);
            paramz.c.b(paramh);
            paramz.d.b(paramh);
            Object localObject = new BitSet();
            if (paramz.r()) {
                ((BitSet) localObject).set(0);
            }
            if (paramz.w()) {
                ((BitSet) localObject).set(1);
            }
            if (paramz.B()) {
                ((BitSet) localObject).set(2);
            }
            if (paramz.E()) {
                ((BitSet) localObject).set(3);
            }
            if (paramz.H()) {
                ((BitSet) localObject).set(4);
            }
            paramh.a((BitSet) localObject, 5);
            if (paramz.r()) {
                paramz.e.b(paramh);
            }
            if (paramz.w()) {
                paramh.a(paramz.f.size());
                localObject = paramz.f.iterator();
                while (((Iterator) localObject).hasNext()) {
                    ((p) ((Iterator) localObject).next()).b(paramh);
                }
            }
            if (paramz.B()) {
                paramh.a(paramz.g.size());
                localObject = paramz.g.iterator();
                while (((Iterator) localObject).hasNext()) {
                    ((x) ((Iterator) localObject).next()).b(paramh);
                }
            }
            if (paramz.E()) {
                paramz.h.b(paramh);
            }
            if (paramz.H()) {
                paramz.i.b(paramh);
            }
        }

        public void b(h paramh, z paramz)
                throws j {
            int j = 0;
            paramh = (com.umeng.a.a.a.b.n) paramh;
            paramz.a = new d();
            paramz.a.a(paramh);
            paramz.a(true);
            paramz.b = new c();
            paramz.b.a(paramh);
            paramz.b(true);
            paramz.c = new e();
            paramz.c.a(paramh);
            paramz.c(true);
            paramz.d = new r();
            paramz.d.a(paramh);
            paramz.d(true);
            BitSet localBitSet = paramh.b(5);
            if (localBitSet.get(0)) {
                paramz.e = new b();
                paramz.e.a(paramh);
                paramz.e(true);
            }
            com.umeng.a.a.a.b.d locald;
            int i;
            Object localObject;
            if (localBitSet.get(1)) {
                locald = new com.umeng.a.a.a.b.d((byte) 12, paramh.w());
                paramz.f = new ArrayList(locald.b);
                i = 0;
                while (i < locald.b) {
                    localObject = new p();
                    ((p) localObject).a(paramh);
                    paramz.f.add(localObject);
                    i += 1;
                }
                paramz.f(true);
            }
            if (localBitSet.get(2)) {
                locald = new com.umeng.a.a.a.b.d((byte) 12, paramh.w());
                paramz.g = new ArrayList(locald.b);
                i = j;
                while (i < locald.b) {
                    localObject = new x();
                    ((x) localObject).a(paramh);
                    paramz.g.add(localObject);
                    i += 1;
                }
                paramz.g(true);
            }
            if (localBitSet.get(3)) {
                paramz.h = new n();
                paramz.h.a(paramh);
                paramz.h(true);
            }
            if (localBitSet.get(4)) {
                paramz.i = new m();
                paramz.i.a(paramh);
                paramz.i(true);
            }
        }
    }

    private static class d
            implements com.umeng.a.a.a.c.b {
        public z.c a() {
            return new z.c(null);
        }
    }

    public static enum e
            implements com.umeng.a.a.a.k {
        private static final Map<String, e> j;
        private final short k;
        private final String l;

        static {
            j = new HashMap();
            Iterator localIterator = EnumSet.allOf(e.class).iterator();
            while (localIterator.hasNext()) {
                e locale = (e) localIterator.next();
                j.put(locale.b(), locale);
            }
        }

        private e(short paramShort, String paramString) {
            this.k = paramShort;
            this.l = paramString;
        }

        public static e a(int paramInt) {
            switch (paramInt) {
                default:
                    return null;
                case 1:
                    return a;
                case 2:
                    return b;
                case 3:
                    return c;
                case 4:
                    return d;
                case 5:
                    return e;
                case 6:
                    return f;
                case 7:
                    return g;
                case 8:
                    return h;
            }
            return i;
        }

        public static e a(String paramString) {
            return (e) j.get(paramString);
        }

        public static e b(int paramInt) {
            e locale = a(paramInt);
            if (locale == null) {
                throw new IllegalArgumentException("Field " + paramInt + " doesn't exist!");
            }
            return locale;
        }

        public short a() {
            return this.k;
        }

        public String b() {
            return this.l;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/umeng/analytics/d/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */