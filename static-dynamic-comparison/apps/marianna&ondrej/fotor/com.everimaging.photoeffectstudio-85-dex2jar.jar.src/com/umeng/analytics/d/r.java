package com.umeng.analytics.d;

import com.umeng.a.a.a.a.g;
import com.umeng.a.a.a.b.h;
import com.umeng.a.a.a.b.m;
import com.umeng.a.a.a.b.n;
import com.umeng.a.a.a.j;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class r
        implements com.umeng.a.a.a.d<r, e>, Serializable, Cloneable {
    private static final int A = 1;
    private static final int B = 2;
    private static final int C = 3;
    public static final Map<e, com.umeng.a.a.a.a.b> l;
    private static final m m = new m("MiscInfo");
    private static final com.umeng.a.a.a.b.c n = new com.umeng.a.a.a.b.c("time_zone", (byte) 8, (short) 1);
    private static final com.umeng.a.a.a.b.c o = new com.umeng.a.a.a.b.c("language", (byte) 11, (short) 2);
    private static final com.umeng.a.a.a.b.c p = new com.umeng.a.a.a.b.c("country", (byte) 11, (short) 3);
    private static final com.umeng.a.a.a.b.c q = new com.umeng.a.a.a.b.c("latitude", (byte) 4, (short) 4);
    private static final com.umeng.a.a.a.b.c r = new com.umeng.a.a.a.b.c("longitude", (byte) 4, (short) 5);
    private static final com.umeng.a.a.a.b.c s = new com.umeng.a.a.a.b.c("carrier", (byte) 11, (short) 6);
    private static final com.umeng.a.a.a.b.c t = new com.umeng.a.a.a.b.c("latency", (byte) 8, (short) 7);
    private static final com.umeng.a.a.a.b.c u = new com.umeng.a.a.a.b.c("display_name", (byte) 11, (short) 8);
    private static final com.umeng.a.a.a.b.c v = new com.umeng.a.a.a.b.c("access_type", (byte) 8, (short) 9);
    private static final com.umeng.a.a.a.b.c w = new com.umeng.a.a.a.b.c("access_subtype", (byte) 11, (short) 10);
    private static final com.umeng.a.a.a.b.c x = new com.umeng.a.a.a.b.c("user_info", (byte) 12, (short) 11);
    private static final Map<Class<? extends com.umeng.a.a.a.c.a>, com.umeng.a.a.a.c.b> y = new HashMap();
    private static final int z = 0;
    private byte D = 0;
    private e[] E = {e.a, e.b, e.c, e.d, e.e, e.f, e.g, e.h, e.i, e.j, e.k};
    public int a;
    public String b;
    public String c;
    public double d;
    public double e;
    public String f;
    public int g;
    public String h;
    public a i;
    public String j;
    public A k;

    static {
        y.put(com.umeng.a.a.a.c.c.class, new b(null));
        y.put(com.umeng.a.a.a.c.d.class, new d(null));
        EnumMap localEnumMap = new EnumMap(e.class);
        localEnumMap.put(e.a, new com.umeng.a.a.a.a.b("time_zone", (byte) 2, new com.umeng.a.a.a.a.c((byte) 8)));
        localEnumMap.put(e.b, new com.umeng.a.a.a.a.b("language", (byte) 2, new com.umeng.a.a.a.a.c((byte) 11)));
        localEnumMap.put(e.c, new com.umeng.a.a.a.a.b("country", (byte) 2, new com.umeng.a.a.a.a.c((byte) 11)));
        localEnumMap.put(e.d, new com.umeng.a.a.a.a.b("latitude", (byte) 2, new com.umeng.a.a.a.a.c((byte) 4)));
        localEnumMap.put(e.e, new com.umeng.a.a.a.a.b("longitude", (byte) 2, new com.umeng.a.a.a.a.c((byte) 4)));
        localEnumMap.put(e.f, new com.umeng.a.a.a.a.b("carrier", (byte) 2, new com.umeng.a.a.a.a.c((byte) 11)));
        localEnumMap.put(e.g, new com.umeng.a.a.a.a.b("latency", (byte) 2, new com.umeng.a.a.a.a.c((byte) 8)));
        localEnumMap.put(e.h, new com.umeng.a.a.a.a.b("display_name", (byte) 2, new com.umeng.a.a.a.a.c((byte) 11)));
        localEnumMap.put(e.i, new com.umeng.a.a.a.a.b("access_type", (byte) 2, new com.umeng.a.a.a.a.a((byte) 16, a.class)));
        localEnumMap.put(e.j, new com.umeng.a.a.a.a.b("access_subtype", (byte) 2, new com.umeng.a.a.a.a.c((byte) 11)));
        localEnumMap.put(e.k, new com.umeng.a.a.a.a.b("user_info", (byte) 2, new g((byte) 12, A.class)));
        l = Collections.unmodifiableMap(localEnumMap);
        com.umeng.a.a.a.a.b.a(r.class, l);
    }

    public r() {
    }

    public r(r paramr) {
        this.D = paramr.D;
        this.a = paramr.a;
        if (paramr.i()) {
            this.b = paramr.b;
        }
        if (paramr.l()) {
            this.c = paramr.c;
        }
        this.d = paramr.d;
        this.e = paramr.e;
        if (paramr.u()) {
            this.f = paramr.f;
        }
        this.g = paramr.g;
        if (paramr.A()) {
            this.h = paramr.h;
        }
        if (paramr.D()) {
            this.i = paramr.i;
        }
        if (paramr.G()) {
            this.j = paramr.j;
        }
        if (paramr.J()) {
            this.k = new A(paramr.k);
        }
    }

    private void a(ObjectInputStream paramObjectInputStream)
            throws IOException, ClassNotFoundException {
        try {
            this.D = 0;
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

    public boolean A() {
        return this.h != null;
    }

    public a B() {
        return this.i;
    }

    public void C() {
        this.i = null;
    }

    public boolean D() {
        return this.i != null;
    }

    public String E() {
        return this.j;
    }

    public void F() {
        this.j = null;
    }

    public boolean G() {
        return this.j != null;
    }

    public A H() {
        return this.k;
    }

    public void I() {
        this.k = null;
    }

    public boolean J() {
        return this.k != null;
    }

    public void K()
            throws j {
        if (this.k != null) {
            this.k.p();
        }
    }

    public r a() {
        return new r(this);
    }

    public r a(double paramDouble) {
        this.d = paramDouble;
        d(true);
        return this;
    }

    public r a(int paramInt) {
        this.a = paramInt;
        a(true);
        return this;
    }

    public r a(A paramA) {
        this.k = paramA;
        return this;
    }

    public r a(a parama) {
        this.i = parama;
        return this;
    }

    public r a(String paramString) {
        this.b = paramString;
        return this;
    }

    public void a(h paramh)
            throws j {
        ((com.umeng.a.a.a.c.b) y.get(paramh.D())).b().b(paramh, this);
    }

    public void a(boolean paramBoolean) {
        this.D = com.umeng.a.a.a.a.a(this.D, 0, paramBoolean);
    }

    public r b(double paramDouble) {
        this.e = paramDouble;
        e(true);
        return this;
    }

    public r b(String paramString) {
        this.c = paramString;
        return this;
    }

    public void b() {
        a(false);
        this.a = 0;
        this.b = null;
        this.c = null;
        d(false);
        this.d = 0.0D;
        e(false);
        this.e = 0.0D;
        this.f = null;
        g(false);
        this.g = 0;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
    }

    public void b(h paramh)
            throws j {
        ((com.umeng.a.a.a.c.b) y.get(paramh.D())).b().a(paramh, this);
    }

    public void b(boolean paramBoolean) {
        if (!paramBoolean) {
            this.b = null;
        }
    }

    public int c() {
        return this.a;
    }

    public r c(int paramInt) {
        this.g = paramInt;
        g(true);
        return this;
    }

    public r c(String paramString) {
        this.f = paramString;
        return this;
    }

    public void c(boolean paramBoolean) {
        if (!paramBoolean) {
            this.c = null;
        }
    }

    public e d(int paramInt) {
        return e.a(paramInt);
    }

    public r d(String paramString) {
        this.h = paramString;
        return this;
    }

    public void d() {
        this.D = com.umeng.a.a.a.a.b(this.D, 0);
    }

    public void d(boolean paramBoolean) {
        this.D = com.umeng.a.a.a.a.a(this.D, 1, paramBoolean);
    }

    public r e(String paramString) {
        this.j = paramString;
        return this;
    }

    public void e(boolean paramBoolean) {
        this.D = com.umeng.a.a.a.a.a(this.D, 2, paramBoolean);
    }

    public boolean e() {
        return com.umeng.a.a.a.a.a(this.D, 0);
    }

    public String f() {
        return this.b;
    }

    public void f(boolean paramBoolean) {
        if (!paramBoolean) {
            this.f = null;
        }
    }

    public void g(boolean paramBoolean) {
        this.D = com.umeng.a.a.a.a.a(this.D, 3, paramBoolean);
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

    public String j() {
        return this.c;
    }

    public void j(boolean paramBoolean) {
        if (!paramBoolean) {
            this.j = null;
        }
    }

    public void k() {
        this.c = null;
    }

    public void k(boolean paramBoolean) {
        if (!paramBoolean) {
            this.k = null;
        }
    }

    public boolean l() {
        return this.c != null;
    }

    public double m() {
        return this.d;
    }

    public void n() {
        this.D = com.umeng.a.a.a.a.b(this.D, 1);
    }

    public boolean o() {
        return com.umeng.a.a.a.a.a(this.D, 1);
    }

    public double p() {
        return this.e;
    }

    public void q() {
        this.D = com.umeng.a.a.a.a.b(this.D, 2);
    }

    public boolean r() {
        return com.umeng.a.a.a.a.a(this.D, 2);
    }

    public String s() {
        return this.f;
    }

    public void t() {
        this.f = null;
    }

    public String toString() {
        int i3 = 0;
        StringBuilder localStringBuilder = new StringBuilder("MiscInfo(");
        int i2 = 1;
        if (e()) {
            localStringBuilder.append("time_zone:");
            localStringBuilder.append(this.a);
            i2 = 0;
        }
        int i1 = i2;
        if (i()) {
            if (i2 == 0) {
                localStringBuilder.append(", ");
            }
            localStringBuilder.append("language:");
            if (this.b == null) {
                localStringBuilder.append("null");
                i1 = 0;
            }
        } else {
            i2 = i1;
            if (l()) {
                if (i1 == 0) {
                    localStringBuilder.append(", ");
                }
                localStringBuilder.append("country:");
                if (this.c != null) {
                    break label538;
                }
                localStringBuilder.append("null");
                label140:
                i2 = 0;
            }
            i1 = i2;
            if (o()) {
                if (i2 == 0) {
                    localStringBuilder.append(", ");
                }
                localStringBuilder.append("latitude:");
                localStringBuilder.append(this.d);
                i1 = 0;
            }
            i2 = i1;
            if (r()) {
                if (i1 == 0) {
                    localStringBuilder.append(", ");
                }
                localStringBuilder.append("longitude:");
                localStringBuilder.append(this.e);
                i2 = 0;
            }
            i1 = i2;
            if (u()) {
                if (i2 == 0) {
                    localStringBuilder.append(", ");
                }
                localStringBuilder.append("carrier:");
                if (this.f != null) {
                    break label551;
                }
                localStringBuilder.append("null");
                label275:
                i1 = 0;
            }
            i2 = i1;
            if (x()) {
                if (i1 == 0) {
                    localStringBuilder.append(", ");
                }
                localStringBuilder.append("latency:");
                localStringBuilder.append(this.g);
                i2 = 0;
            }
            i1 = i2;
            if (A()) {
                if (i2 == 0) {
                    localStringBuilder.append(", ");
                }
                localStringBuilder.append("display_name:");
                if (this.h != null) {
                    break label564;
                }
                localStringBuilder.append("null");
                label367:
                i1 = 0;
            }
            i2 = i1;
            if (D()) {
                if (i1 == 0) {
                    localStringBuilder.append(", ");
                }
                localStringBuilder.append("access_type:");
                if (this.i != null) {
                    break label577;
                }
                localStringBuilder.append("null");
                label416:
                i2 = 0;
            }
            if (!G()) {
                break label618;
            }
            if (i2 == 0) {
                localStringBuilder.append(", ");
            }
            localStringBuilder.append("access_subtype:");
            if (this.j != null) {
                break label590;
            }
            localStringBuilder.append("null");
            i1 = i3;
        }
        for (; ; ) {
            label465:
            if (J()) {
                if (i1 == 0) {
                    localStringBuilder.append(", ");
                }
                localStringBuilder.append("user_info:");
                if (this.k != null) {
                    break label605;
                }
                localStringBuilder.append("null");
            }
            for (; ; ) {
                localStringBuilder.append(")");
                return localStringBuilder.toString();
                localStringBuilder.append(this.b);
                break;
                label538:
                localStringBuilder.append(this.c);
                break label140;
                label551:
                localStringBuilder.append(this.f);
                break label275;
                label564:
                localStringBuilder.append(this.h);
                break label367;
                label577:
                localStringBuilder.append(this.i);
                break label416;
                label590:
                localStringBuilder.append(this.j);
                i1 = i3;
                break label465;
                label605:
                localStringBuilder.append(this.k);
            }
            label618:
            i1 = i2;
        }
    }

    public boolean u() {
        return this.f != null;
    }

    public int v() {
        return this.g;
    }

    public void w() {
        this.D = com.umeng.a.a.a.a.b(this.D, 3);
    }

    public boolean x() {
        return com.umeng.a.a.a.a.a(this.D, 3);
    }

    public String y() {
        return this.h;
    }

    public void z() {
        this.h = null;
    }

    private static class a
            extends com.umeng.a.a.a.c.c<r> {
        public void a(h paramh, r paramr)
                throws j {
            paramh.j();
            com.umeng.a.a.a.b.c localc = paramh.l();
            if (localc.b == 0) {
                paramh.k();
                paramr.K();
                return;
            }
            switch (localc.c) {
                default:
                    com.umeng.a.a.a.b.k.a(paramh, localc.b);
            }
            for (; ; ) {
                paramh.m();
                break;
                if (localc.b == 8) {
                    paramr.a = paramh.w();
                    paramr.a(true);
                } else {
                    com.umeng.a.a.a.b.k.a(paramh, localc.b);
                    continue;
                    if (localc.b == 11) {
                        paramr.b = paramh.z();
                        paramr.b(true);
                    } else {
                        com.umeng.a.a.a.b.k.a(paramh, localc.b);
                        continue;
                        if (localc.b == 11) {
                            paramr.c = paramh.z();
                            paramr.c(true);
                        } else {
                            com.umeng.a.a.a.b.k.a(paramh, localc.b);
                            continue;
                            if (localc.b == 4) {
                                paramr.d = paramh.y();
                                paramr.d(true);
                            } else {
                                com.umeng.a.a.a.b.k.a(paramh, localc.b);
                                continue;
                                if (localc.b == 4) {
                                    paramr.e = paramh.y();
                                    paramr.e(true);
                                } else {
                                    com.umeng.a.a.a.b.k.a(paramh, localc.b);
                                    continue;
                                    if (localc.b == 11) {
                                        paramr.f = paramh.z();
                                        paramr.f(true);
                                    } else {
                                        com.umeng.a.a.a.b.k.a(paramh, localc.b);
                                        continue;
                                        if (localc.b == 8) {
                                            paramr.g = paramh.w();
                                            paramr.g(true);
                                        } else {
                                            com.umeng.a.a.a.b.k.a(paramh, localc.b);
                                            continue;
                                            if (localc.b == 11) {
                                                paramr.h = paramh.z();
                                                paramr.h(true);
                                            } else {
                                                com.umeng.a.a.a.b.k.a(paramh, localc.b);
                                                continue;
                                                if (localc.b == 8) {
                                                    paramr.i = a.a(paramh.w());
                                                    paramr.i(true);
                                                } else {
                                                    com.umeng.a.a.a.b.k.a(paramh, localc.b);
                                                    continue;
                                                    if (localc.b == 11) {
                                                        paramr.j = paramh.z();
                                                        paramr.j(true);
                                                    } else {
                                                        com.umeng.a.a.a.b.k.a(paramh, localc.b);
                                                        continue;
                                                        if (localc.b == 12) {
                                                            paramr.k = new A();
                                                            paramr.k.a(paramh);
                                                            paramr.k(true);
                                                        } else {
                                                            com.umeng.a.a.a.b.k.a(paramh, localc.b);
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
            }
        }

        public void b(h paramh, r paramr)
                throws j {
            paramr.K();
            paramh.a(r.L());
            if (paramr.e()) {
                paramh.a(r.M());
                paramh.a(paramr.a);
                paramh.c();
            }
            if ((paramr.b != null) && (paramr.i())) {
                paramh.a(r.N());
                paramh.a(paramr.b);
                paramh.c();
            }
            if ((paramr.c != null) && (paramr.l())) {
                paramh.a(r.O());
                paramh.a(paramr.c);
                paramh.c();
            }
            if (paramr.o()) {
                paramh.a(r.P());
                paramh.a(paramr.d);
                paramh.c();
            }
            if (paramr.r()) {
                paramh.a(r.Q());
                paramh.a(paramr.e);
                paramh.c();
            }
            if ((paramr.f != null) && (paramr.u())) {
                paramh.a(r.R());
                paramh.a(paramr.f);
                paramh.c();
            }
            if (paramr.x()) {
                paramh.a(r.S());
                paramh.a(paramr.g);
                paramh.c();
            }
            if ((paramr.h != null) && (paramr.A())) {
                paramh.a(r.T());
                paramh.a(paramr.h);
                paramh.c();
            }
            if ((paramr.i != null) && (paramr.D())) {
                paramh.a(r.U());
                paramh.a(paramr.i.a());
                paramh.c();
            }
            if ((paramr.j != null) && (paramr.G())) {
                paramh.a(r.V());
                paramh.a(paramr.j);
                paramh.c();
            }
            if ((paramr.k != null) && (paramr.J())) {
                paramh.a(r.W());
                paramr.k.b(paramh);
                paramh.c();
            }
            paramh.d();
            paramh.b();
        }
    }

    private static class b
            implements com.umeng.a.a.a.c.b {
        public r.a a() {
            return new r.a(null);
        }
    }

    private static class c
            extends com.umeng.a.a.a.c.d<r> {
        public void a(h paramh, r paramr)
                throws j {
            paramh = (n) paramh;
            BitSet localBitSet = new BitSet();
            if (paramr.e()) {
                localBitSet.set(0);
            }
            if (paramr.i()) {
                localBitSet.set(1);
            }
            if (paramr.l()) {
                localBitSet.set(2);
            }
            if (paramr.o()) {
                localBitSet.set(3);
            }
            if (paramr.r()) {
                localBitSet.set(4);
            }
            if (paramr.u()) {
                localBitSet.set(5);
            }
            if (paramr.x()) {
                localBitSet.set(6);
            }
            if (paramr.A()) {
                localBitSet.set(7);
            }
            if (paramr.D()) {
                localBitSet.set(8);
            }
            if (paramr.G()) {
                localBitSet.set(9);
            }
            if (paramr.J()) {
                localBitSet.set(10);
            }
            paramh.a(localBitSet, 11);
            if (paramr.e()) {
                paramh.a(paramr.a);
            }
            if (paramr.i()) {
                paramh.a(paramr.b);
            }
            if (paramr.l()) {
                paramh.a(paramr.c);
            }
            if (paramr.o()) {
                paramh.a(paramr.d);
            }
            if (paramr.r()) {
                paramh.a(paramr.e);
            }
            if (paramr.u()) {
                paramh.a(paramr.f);
            }
            if (paramr.x()) {
                paramh.a(paramr.g);
            }
            if (paramr.A()) {
                paramh.a(paramr.h);
            }
            if (paramr.D()) {
                paramh.a(paramr.i.a());
            }
            if (paramr.G()) {
                paramh.a(paramr.j);
            }
            if (paramr.J()) {
                paramr.k.b(paramh);
            }
        }

        public void b(h paramh, r paramr)
                throws j {
            paramh = (n) paramh;
            BitSet localBitSet = paramh.b(11);
            if (localBitSet.get(0)) {
                paramr.a = paramh.w();
                paramr.a(true);
            }
            if (localBitSet.get(1)) {
                paramr.b = paramh.z();
                paramr.b(true);
            }
            if (localBitSet.get(2)) {
                paramr.c = paramh.z();
                paramr.c(true);
            }
            if (localBitSet.get(3)) {
                paramr.d = paramh.y();
                paramr.d(true);
            }
            if (localBitSet.get(4)) {
                paramr.e = paramh.y();
                paramr.e(true);
            }
            if (localBitSet.get(5)) {
                paramr.f = paramh.z();
                paramr.f(true);
            }
            if (localBitSet.get(6)) {
                paramr.g = paramh.w();
                paramr.g(true);
            }
            if (localBitSet.get(7)) {
                paramr.h = paramh.z();
                paramr.h(true);
            }
            if (localBitSet.get(8)) {
                paramr.i = a.a(paramh.w());
                paramr.i(true);
            }
            if (localBitSet.get(9)) {
                paramr.j = paramh.z();
                paramr.j(true);
            }
            if (localBitSet.get(10)) {
                paramr.k = new A();
                paramr.k.a(paramh);
                paramr.k(true);
            }
        }
    }

    private static class d
            implements com.umeng.a.a.a.c.b {
        public r.c a() {
            return new r.c(null);
        }
    }

    public static enum e
            implements com.umeng.a.a.a.k {
        private static final Map<String, e> l;
        private final short m;
        private final String n;

        static {
            l = new HashMap();
            Iterator localIterator = EnumSet.allOf(e.class).iterator();
            while (localIterator.hasNext()) {
                e locale = (e) localIterator.next();
                l.put(locale.b(), locale);
            }
        }

        private e(short paramShort, String paramString) {
            this.m = paramShort;
            this.n = paramString;
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
                case 9:
                    return i;
                case 10:
                    return j;
            }
            return k;
        }

        public static e a(String paramString) {
            return (e) l.get(paramString);
        }

        public static e b(int paramInt) {
            e locale = a(paramInt);
            if (locale == null) {
                throw new IllegalArgumentException("Field " + paramInt + " doesn't exist!");
            }
            return locale;
        }

        public short a() {
            return this.m;
        }

        public String b() {
            return this.n;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/umeng/analytics/d/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */