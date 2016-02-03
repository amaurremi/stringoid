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

public class e
        implements com.umeng.a.a.a.d<e, e>, Serializable, Cloneable {
    private static final com.umeng.a.a.a.b.c A;
    private static final com.umeng.a.a.a.b.c B;
    private static final com.umeng.a.a.a.b.c C;
    private static final com.umeng.a.a.a.b.c D;
    private static final com.umeng.a.a.a.b.c E;
    private static final com.umeng.a.a.a.b.c F;
    private static final com.umeng.a.a.a.b.c G;
    private static final com.umeng.a.a.a.b.c H;
    private static final com.umeng.a.a.a.b.c I;
    private static final com.umeng.a.a.a.b.c J;
    private static final Map<Class<? extends com.umeng.a.a.a.c.a>, com.umeng.a.a.a.c.b> K;
    private static final int L = 0;
    private static final int M = 1;
    private static final int N = 2;
    public static final Map<e, com.umeng.a.a.a.a.b> r;
    private static final m s = new m("DeviceInfo");
    private static final com.umeng.a.a.a.b.c t = new com.umeng.a.a.a.b.c("device_id", (byte) 11, (short) 1);
    private static final com.umeng.a.a.a.b.c u = new com.umeng.a.a.a.b.c("idmd5", (byte) 11, (short) 2);
    private static final com.umeng.a.a.a.b.c v = new com.umeng.a.a.a.b.c("mac_address", (byte) 11, (short) 3);
    private static final com.umeng.a.a.a.b.c w = new com.umeng.a.a.a.b.c("open_udid", (byte) 11, (short) 4);
    private static final com.umeng.a.a.a.b.c x = new com.umeng.a.a.a.b.c("model", (byte) 11, (short) 5);
    private static final com.umeng.a.a.a.b.c y = new com.umeng.a.a.a.b.c("cpu", (byte) 11, (short) 6);
    private static final com.umeng.a.a.a.b.c z = new com.umeng.a.a.a.b.c("os", (byte) 11, (short) 7);
    private byte O = 0;
    private e[] P = {e.a, e.b, e.c, e.d, e.e, e.f, e.g, e.h, e.i, e.j, e.k, e.l, e.m, e.n, e.o, e.p, e.q};
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public u i;
    public boolean j;
    public boolean k;
    public String l;
    public String m;
    public long n;
    public String o;
    public String p;
    public String q;

    static {
        A = new com.umeng.a.a.a.b.c("os_version", (byte) 11, (short) 8);
        B = new com.umeng.a.a.a.b.c("resolution", (byte) 12, (short) 9);
        C = new com.umeng.a.a.a.b.c("is_jailbroken", (byte) 2, (short) 10);
        D = new com.umeng.a.a.a.b.c("is_pirated", (byte) 2, (short) 11);
        E = new com.umeng.a.a.a.b.c("device_board", (byte) 11, (short) 12);
        F = new com.umeng.a.a.a.b.c("device_brand", (byte) 11, (short) 13);
        G = new com.umeng.a.a.a.b.c("device_manutime", (byte) 10, (short) 14);
        H = new com.umeng.a.a.a.b.c("device_manufacturer", (byte) 11, (short) 15);
        I = new com.umeng.a.a.a.b.c("device_manuid", (byte) 11, (short) 16);
        J = new com.umeng.a.a.a.b.c("device_name", (byte) 11, (short) 17);
        K = new HashMap();
        K.put(com.umeng.a.a.a.c.c.class, new b(null));
        K.put(com.umeng.a.a.a.c.d.class, new d(null));
        EnumMap localEnumMap = new EnumMap(e.class);
        localEnumMap.put(e.a, new com.umeng.a.a.a.a.b("device_id", (byte) 2, new com.umeng.a.a.a.a.c((byte) 11)));
        localEnumMap.put(e.b, new com.umeng.a.a.a.a.b("idmd5", (byte) 2, new com.umeng.a.a.a.a.c((byte) 11)));
        localEnumMap.put(e.c, new com.umeng.a.a.a.a.b("mac_address", (byte) 2, new com.umeng.a.a.a.a.c((byte) 11)));
        localEnumMap.put(e.d, new com.umeng.a.a.a.a.b("open_udid", (byte) 2, new com.umeng.a.a.a.a.c((byte) 11)));
        localEnumMap.put(e.e, new com.umeng.a.a.a.a.b("model", (byte) 2, new com.umeng.a.a.a.a.c((byte) 11)));
        localEnumMap.put(e.f, new com.umeng.a.a.a.a.b("cpu", (byte) 2, new com.umeng.a.a.a.a.c((byte) 11)));
        localEnumMap.put(e.g, new com.umeng.a.a.a.a.b("os", (byte) 2, new com.umeng.a.a.a.a.c((byte) 11)));
        localEnumMap.put(e.h, new com.umeng.a.a.a.a.b("os_version", (byte) 2, new com.umeng.a.a.a.a.c((byte) 11)));
        localEnumMap.put(e.i, new com.umeng.a.a.a.a.b("resolution", (byte) 2, new g((byte) 12, u.class)));
        localEnumMap.put(e.j, new com.umeng.a.a.a.a.b("is_jailbroken", (byte) 2, new com.umeng.a.a.a.a.c((byte) 2)));
        localEnumMap.put(e.k, new com.umeng.a.a.a.a.b("is_pirated", (byte) 2, new com.umeng.a.a.a.a.c((byte) 2)));
        localEnumMap.put(e.l, new com.umeng.a.a.a.a.b("device_board", (byte) 2, new com.umeng.a.a.a.a.c((byte) 11)));
        localEnumMap.put(e.m, new com.umeng.a.a.a.a.b("device_brand", (byte) 2, new com.umeng.a.a.a.a.c((byte) 11)));
        localEnumMap.put(e.n, new com.umeng.a.a.a.a.b("device_manutime", (byte) 2, new com.umeng.a.a.a.a.c((byte) 10)));
        localEnumMap.put(e.o, new com.umeng.a.a.a.a.b("device_manufacturer", (byte) 2, new com.umeng.a.a.a.a.c((byte) 11)));
        localEnumMap.put(e.p, new com.umeng.a.a.a.a.b("device_manuid", (byte) 2, new com.umeng.a.a.a.a.c((byte) 11)));
        localEnumMap.put(e.q, new com.umeng.a.a.a.a.b("device_name", (byte) 2, new com.umeng.a.a.a.a.c((byte) 11)));
        r = Collections.unmodifiableMap(localEnumMap);
        com.umeng.a.a.a.a.b.a(e.class, r);
    }

    public e() {
    }

    public e(e parame) {
        this.O = parame.O;
        if (parame.e()) {
            this.a = parame.a;
        }
        if (parame.i()) {
            this.b = parame.b;
        }
        if (parame.l()) {
            this.c = parame.c;
        }
        if (parame.o()) {
            this.d = parame.d;
        }
        if (parame.r()) {
            this.e = parame.e;
        }
        if (parame.u()) {
            this.f = parame.f;
        }
        if (parame.x()) {
            this.g = parame.g;
        }
        if (parame.A()) {
            this.h = parame.h;
        }
        if (parame.D()) {
            this.i = new u(parame.i);
        }
        this.j = parame.j;
        this.k = parame.k;
        if (parame.M()) {
            this.l = parame.l;
        }
        if (parame.P()) {
            this.m = parame.m;
        }
        this.n = parame.n;
        if (parame.V()) {
            this.o = parame.o;
        }
        if (parame.Y()) {
            this.p = parame.p;
        }
        if (parame.ab()) {
            this.q = parame.q;
        }
    }

    private void a(ObjectInputStream paramObjectInputStream)
            throws IOException, ClassNotFoundException {
        try {
            this.O = 0;
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

    public u B() {
        return this.i;
    }

    public void C() {
        this.i = null;
    }

    public boolean D() {
        return this.i != null;
    }

    public boolean E() {
        return this.j;
    }

    public void F() {
        this.O = com.umeng.a.a.a.a.b(this.O, 0);
    }

    public boolean G() {
        return com.umeng.a.a.a.a.a(this.O, 0);
    }

    public boolean H() {
        return this.k;
    }

    public void I() {
        this.O = com.umeng.a.a.a.a.b(this.O, 1);
    }

    public boolean J() {
        return com.umeng.a.a.a.a.a(this.O, 1);
    }

    public String K() {
        return this.l;
    }

    public void L() {
        this.l = null;
    }

    public boolean M() {
        return this.l != null;
    }

    public String N() {
        return this.m;
    }

    public void O() {
        this.m = null;
    }

    public boolean P() {
        return this.m != null;
    }

    public long Q() {
        return this.n;
    }

    public void R() {
        this.O = com.umeng.a.a.a.a.b(this.O, 2);
    }

    public boolean S() {
        return com.umeng.a.a.a.a.a(this.O, 2);
    }

    public String T() {
        return this.o;
    }

    public void U() {
        this.o = null;
    }

    public boolean V() {
        return this.o != null;
    }

    public String W() {
        return this.p;
    }

    public void X() {
        this.p = null;
    }

    public boolean Y() {
        return this.p != null;
    }

    public String Z() {
        return this.q;
    }

    public e a(int paramInt) {
        return e.a(paramInt);
    }

    public e a() {
        return new e(this);
    }

    public e a(long paramLong) {
        this.n = paramLong;
        p(true);
        return this;
    }

    public e a(u paramu) {
        this.i = paramu;
        return this;
    }

    public e a(String paramString) {
        this.a = paramString;
        return this;
    }

    public void a(h paramh)
            throws j {
        ((com.umeng.a.a.a.c.b) K.get(paramh.D())).b().b(paramh, this);
    }

    public void a(boolean paramBoolean) {
        if (!paramBoolean) {
            this.a = null;
        }
    }

    public void aa() {
        this.q = null;
    }

    public boolean ab() {
        return this.q != null;
    }

    public void ac()
            throws j {
        if (this.i != null) {
            this.i.j();
        }
    }

    public e b(String paramString) {
        this.b = paramString;
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
        k(false);
        this.j = false;
        m(false);
        this.k = false;
        this.l = null;
        this.m = null;
        p(false);
        this.n = 0L;
        this.o = null;
        this.p = null;
        this.q = null;
    }

    public void b(h paramh)
            throws j {
        ((com.umeng.a.a.a.c.b) K.get(paramh.D())).b().a(paramh, this);
    }

    public void b(boolean paramBoolean) {
        if (!paramBoolean) {
            this.b = null;
        }
    }

    public e c(String paramString) {
        this.c = paramString;
        return this;
    }

    public String c() {
        return this.a;
    }

    public void c(boolean paramBoolean) {
        if (!paramBoolean) {
            this.c = null;
        }
    }

    public e d(String paramString) {
        this.d = paramString;
        return this;
    }

    public void d() {
        this.a = null;
    }

    public void d(boolean paramBoolean) {
        if (!paramBoolean) {
            this.d = null;
        }
    }

    public e e(String paramString) {
        this.e = paramString;
        return this;
    }

    public void e(boolean paramBoolean) {
        if (!paramBoolean) {
            this.e = null;
        }
    }

    public boolean e() {
        return this.a != null;
    }

    public e f(String paramString) {
        this.f = paramString;
        return this;
    }

    public String f() {
        return this.b;
    }

    public void f(boolean paramBoolean) {
        if (!paramBoolean) {
            this.f = null;
        }
    }

    public e g(String paramString) {
        this.g = paramString;
        return this;
    }

    public void g(boolean paramBoolean) {
        if (!paramBoolean) {
            this.g = null;
        }
    }

    public e h(String paramString) {
        this.h = paramString;
        return this;
    }

    public void h() {
        this.b = null;
    }

    public void h(boolean paramBoolean) {
        if (!paramBoolean) {
            this.h = null;
        }
    }

    public e i(String paramString) {
        this.l = paramString;
        return this;
    }

    public void i(boolean paramBoolean) {
        if (!paramBoolean) {
            this.i = null;
        }
    }

    public boolean i() {
        return this.b != null;
    }

    public e j(String paramString) {
        this.m = paramString;
        return this;
    }

    public e j(boolean paramBoolean) {
        this.j = paramBoolean;
        k(true);
        return this;
    }

    public String j() {
        return this.c;
    }

    public e k(String paramString) {
        this.o = paramString;
        return this;
    }

    public void k() {
        this.c = null;
    }

    public void k(boolean paramBoolean) {
        this.O = com.umeng.a.a.a.a.a(this.O, 0, paramBoolean);
    }

    public e l(String paramString) {
        this.p = paramString;
        return this;
    }

    public e l(boolean paramBoolean) {
        this.k = paramBoolean;
        m(true);
        return this;
    }

    public boolean l() {
        return this.c != null;
    }

    public e m(String paramString) {
        this.q = paramString;
        return this;
    }

    public String m() {
        return this.d;
    }

    public void m(boolean paramBoolean) {
        this.O = com.umeng.a.a.a.a.a(this.O, 1, paramBoolean);
    }

    public void n() {
        this.d = null;
    }

    public void n(boolean paramBoolean) {
        if (!paramBoolean) {
            this.l = null;
        }
    }

    public void o(boolean paramBoolean) {
        if (!paramBoolean) {
            this.m = null;
        }
    }

    public boolean o() {
        return this.d != null;
    }

    public String p() {
        return this.e;
    }

    public void p(boolean paramBoolean) {
        this.O = com.umeng.a.a.a.a.a(this.O, 2, paramBoolean);
    }

    public void q() {
        this.e = null;
    }

    public void q(boolean paramBoolean) {
        if (!paramBoolean) {
            this.o = null;
        }
    }

    public void r(boolean paramBoolean) {
        if (!paramBoolean) {
            this.p = null;
        }
    }

    public boolean r() {
        return this.e != null;
    }

    public String s() {
        return this.f;
    }

    public void s(boolean paramBoolean) {
        if (!paramBoolean) {
            this.q = null;
        }
    }

    public void t() {
        this.f = null;
    }

    public String toString() {
        int i3 = 0;
        StringBuilder localStringBuilder = new StringBuilder("DeviceInfo(");
        int i2 = 1;
        int i1;
        if (e()) {
            localStringBuilder.append("device_id:");
            if (this.a == null) {
                localStringBuilder.append("null");
                i2 = 0;
            }
        } else {
            i1 = i2;
            if (i()) {
                if (i2 == 0) {
                    localStringBuilder.append(", ");
                }
                localStringBuilder.append("idmd5:");
                if (this.b != null) {
                    break label838;
                }
                localStringBuilder.append("null");
                label97:
                i1 = 0;
            }
            i2 = i1;
            if (l()) {
                if (i1 == 0) {
                    localStringBuilder.append(", ");
                }
                localStringBuilder.append("mac_address:");
                if (this.c != null) {
                    break label851;
                }
                localStringBuilder.append("null");
                label146:
                i2 = 0;
            }
            i1 = i2;
            if (o()) {
                if (i2 == 0) {
                    localStringBuilder.append(", ");
                }
                localStringBuilder.append("open_udid:");
                if (this.d != null) {
                    break label864;
                }
                localStringBuilder.append("null");
                label195:
                i1 = 0;
            }
            i2 = i1;
            if (r()) {
                if (i1 == 0) {
                    localStringBuilder.append(", ");
                }
                localStringBuilder.append("model:");
                if (this.e != null) {
                    break label877;
                }
                localStringBuilder.append("null");
                label244:
                i2 = 0;
            }
            i1 = i2;
            if (u()) {
                if (i2 == 0) {
                    localStringBuilder.append(", ");
                }
                localStringBuilder.append("cpu:");
                if (this.f != null) {
                    break label890;
                }
                localStringBuilder.append("null");
                label293:
                i1 = 0;
            }
            i2 = i1;
            if (x()) {
                if (i1 == 0) {
                    localStringBuilder.append(", ");
                }
                localStringBuilder.append("os:");
                if (this.g != null) {
                    break label903;
                }
                localStringBuilder.append("null");
                label342:
                i2 = 0;
            }
            i1 = i2;
            if (A()) {
                if (i2 == 0) {
                    localStringBuilder.append(", ");
                }
                localStringBuilder.append("os_version:");
                if (this.h != null) {
                    break label916;
                }
                localStringBuilder.append("null");
                label391:
                i1 = 0;
            }
            i2 = i1;
            if (D()) {
                if (i1 == 0) {
                    localStringBuilder.append(", ");
                }
                localStringBuilder.append("resolution:");
                if (this.i != null) {
                    break label929;
                }
                localStringBuilder.append("null");
                label440:
                i2 = 0;
            }
            i1 = i2;
            if (G()) {
                if (i2 == 0) {
                    localStringBuilder.append(", ");
                }
                localStringBuilder.append("is_jailbroken:");
                localStringBuilder.append(this.j);
                i1 = 0;
            }
            i2 = i1;
            if (J()) {
                if (i1 == 0) {
                    localStringBuilder.append(", ");
                }
                localStringBuilder.append("is_pirated:");
                localStringBuilder.append(this.k);
                i2 = 0;
            }
            i1 = i2;
            if (M()) {
                if (i2 == 0) {
                    localStringBuilder.append(", ");
                }
                localStringBuilder.append("device_board:");
                if (this.l != null) {
                    break label942;
                }
                localStringBuilder.append("null");
                label575:
                i1 = 0;
            }
            i2 = i1;
            if (P()) {
                if (i1 == 0) {
                    localStringBuilder.append(", ");
                }
                localStringBuilder.append("device_brand:");
                if (this.m != null) {
                    break label955;
                }
                localStringBuilder.append("null");
                label624:
                i2 = 0;
            }
            i1 = i2;
            if (S()) {
                if (i2 == 0) {
                    localStringBuilder.append(", ");
                }
                localStringBuilder.append("device_manutime:");
                localStringBuilder.append(this.n);
                i1 = 0;
            }
            i2 = i1;
            if (V()) {
                if (i1 == 0) {
                    localStringBuilder.append(", ");
                }
                localStringBuilder.append("device_manufacturer:");
                if (this.o != null) {
                    break label968;
                }
                localStringBuilder.append("null");
                label716:
                i2 = 0;
            }
            if (!Y()) {
                break label1009;
            }
            if (i2 == 0) {
                localStringBuilder.append(", ");
            }
            localStringBuilder.append("device_manuid:");
            if (this.p != null) {
                break label981;
            }
            localStringBuilder.append("null");
            i1 = i3;
        }
        for (; ; ) {
            label765:
            if (ab()) {
                if (i1 == 0) {
                    localStringBuilder.append(", ");
                }
                localStringBuilder.append("device_name:");
                if (this.q != null) {
                    break label996;
                }
                localStringBuilder.append("null");
            }
            for (; ; ) {
                localStringBuilder.append(")");
                return localStringBuilder.toString();
                localStringBuilder.append(this.a);
                break;
                label838:
                localStringBuilder.append(this.b);
                break label97;
                label851:
                localStringBuilder.append(this.c);
                break label146;
                label864:
                localStringBuilder.append(this.d);
                break label195;
                label877:
                localStringBuilder.append(this.e);
                break label244;
                label890:
                localStringBuilder.append(this.f);
                break label293;
                label903:
                localStringBuilder.append(this.g);
                break label342;
                label916:
                localStringBuilder.append(this.h);
                break label391;
                label929:
                localStringBuilder.append(this.i);
                break label440;
                label942:
                localStringBuilder.append(this.l);
                break label575;
                label955:
                localStringBuilder.append(this.m);
                break label624;
                label968:
                localStringBuilder.append(this.o);
                break label716;
                label981:
                localStringBuilder.append(this.p);
                i1 = i3;
                break label765;
                label996:
                localStringBuilder.append(this.q);
            }
            label1009:
            i1 = i2;
        }
    }

    public boolean u() {
        return this.f != null;
    }

    public String v() {
        return this.g;
    }

    public void w() {
        this.g = null;
    }

    public boolean x() {
        return this.g != null;
    }

    public String y() {
        return this.h;
    }

    public void z() {
        this.h = null;
    }

    private static class a
            extends com.umeng.a.a.a.c.c<e> {
        public void a(h paramh, e parame)
                throws j {
            paramh.j();
            com.umeng.a.a.a.b.c localc = paramh.l();
            if (localc.b == 0) {
                paramh.k();
                parame.ac();
                return;
            }
            switch (localc.c) {
                default:
                    com.umeng.a.a.a.b.k.a(paramh, localc.b);
            }
            for (; ; ) {
                paramh.m();
                break;
                if (localc.b == 11) {
                    parame.a = paramh.z();
                    parame.a(true);
                } else {
                    com.umeng.a.a.a.b.k.a(paramh, localc.b);
                    continue;
                    if (localc.b == 11) {
                        parame.b = paramh.z();
                        parame.b(true);
                    } else {
                        com.umeng.a.a.a.b.k.a(paramh, localc.b);
                        continue;
                        if (localc.b == 11) {
                            parame.c = paramh.z();
                            parame.c(true);
                        } else {
                            com.umeng.a.a.a.b.k.a(paramh, localc.b);
                            continue;
                            if (localc.b == 11) {
                                parame.d = paramh.z();
                                parame.d(true);
                            } else {
                                com.umeng.a.a.a.b.k.a(paramh, localc.b);
                                continue;
                                if (localc.b == 11) {
                                    parame.e = paramh.z();
                                    parame.e(true);
                                } else {
                                    com.umeng.a.a.a.b.k.a(paramh, localc.b);
                                    continue;
                                    if (localc.b == 11) {
                                        parame.f = paramh.z();
                                        parame.f(true);
                                    } else {
                                        com.umeng.a.a.a.b.k.a(paramh, localc.b);
                                        continue;
                                        if (localc.b == 11) {
                                            parame.g = paramh.z();
                                            parame.g(true);
                                        } else {
                                            com.umeng.a.a.a.b.k.a(paramh, localc.b);
                                            continue;
                                            if (localc.b == 11) {
                                                parame.h = paramh.z();
                                                parame.h(true);
                                            } else {
                                                com.umeng.a.a.a.b.k.a(paramh, localc.b);
                                                continue;
                                                if (localc.b == 12) {
                                                    parame.i = new u();
                                                    parame.i.a(paramh);
                                                    parame.i(true);
                                                } else {
                                                    com.umeng.a.a.a.b.k.a(paramh, localc.b);
                                                    continue;
                                                    if (localc.b == 2) {
                                                        parame.j = paramh.t();
                                                        parame.k(true);
                                                    } else {
                                                        com.umeng.a.a.a.b.k.a(paramh, localc.b);
                                                        continue;
                                                        if (localc.b == 2) {
                                                            parame.k = paramh.t();
                                                            parame.m(true);
                                                        } else {
                                                            com.umeng.a.a.a.b.k.a(paramh, localc.b);
                                                            continue;
                                                            if (localc.b == 11) {
                                                                parame.l = paramh.z();
                                                                parame.n(true);
                                                            } else {
                                                                com.umeng.a.a.a.b.k.a(paramh, localc.b);
                                                                continue;
                                                                if (localc.b == 11) {
                                                                    parame.m = paramh.z();
                                                                    parame.o(true);
                                                                } else {
                                                                    com.umeng.a.a.a.b.k.a(paramh, localc.b);
                                                                    continue;
                                                                    if (localc.b == 10) {
                                                                        parame.n = paramh.x();
                                                                        parame.p(true);
                                                                    } else {
                                                                        com.umeng.a.a.a.b.k.a(paramh, localc.b);
                                                                        continue;
                                                                        if (localc.b == 11) {
                                                                            parame.o = paramh.z();
                                                                            parame.q(true);
                                                                        } else {
                                                                            com.umeng.a.a.a.b.k.a(paramh, localc.b);
                                                                            continue;
                                                                            if (localc.b == 11) {
                                                                                parame.p = paramh.z();
                                                                                parame.r(true);
                                                                            } else {
                                                                                com.umeng.a.a.a.b.k.a(paramh, localc.b);
                                                                                continue;
                                                                                if (localc.b == 11) {
                                                                                    parame.q = paramh.z();
                                                                                    parame.s(true);
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
                            }
                        }
                    }
                }
            }
        }

        public void b(h paramh, e parame)
                throws j {
            parame.ac();
            paramh.a(e.ad());
            if ((parame.a != null) && (parame.e())) {
                paramh.a(e.ae());
                paramh.a(parame.a);
                paramh.c();
            }
            if ((parame.b != null) && (parame.i())) {
                paramh.a(e.af());
                paramh.a(parame.b);
                paramh.c();
            }
            if ((parame.c != null) && (parame.l())) {
                paramh.a(e.ag());
                paramh.a(parame.c);
                paramh.c();
            }
            if ((parame.d != null) && (parame.o())) {
                paramh.a(e.ah());
                paramh.a(parame.d);
                paramh.c();
            }
            if ((parame.e != null) && (parame.r())) {
                paramh.a(e.ai());
                paramh.a(parame.e);
                paramh.c();
            }
            if ((parame.f != null) && (parame.u())) {
                paramh.a(e.aj());
                paramh.a(parame.f);
                paramh.c();
            }
            if ((parame.g != null) && (parame.x())) {
                paramh.a(e.ak());
                paramh.a(parame.g);
                paramh.c();
            }
            if ((parame.h != null) && (parame.A())) {
                paramh.a(e.al());
                paramh.a(parame.h);
                paramh.c();
            }
            if ((parame.i != null) && (parame.D())) {
                paramh.a(e.am());
                parame.i.b(paramh);
                paramh.c();
            }
            if (parame.G()) {
                paramh.a(e.an());
                paramh.a(parame.j);
                paramh.c();
            }
            if (parame.J()) {
                paramh.a(e.ao());
                paramh.a(parame.k);
                paramh.c();
            }
            if ((parame.l != null) && (parame.M())) {
                paramh.a(e.ap());
                paramh.a(parame.l);
                paramh.c();
            }
            if ((parame.m != null) && (parame.P())) {
                paramh.a(e.aq());
                paramh.a(parame.m);
                paramh.c();
            }
            if (parame.S()) {
                paramh.a(e.ar());
                paramh.a(parame.n);
                paramh.c();
            }
            if ((parame.o != null) && (parame.V())) {
                paramh.a(e.as());
                paramh.a(parame.o);
                paramh.c();
            }
            if ((parame.p != null) && (parame.Y())) {
                paramh.a(e.at());
                paramh.a(parame.p);
                paramh.c();
            }
            if ((parame.q != null) && (parame.ab())) {
                paramh.a(e.au());
                paramh.a(parame.q);
                paramh.c();
            }
            paramh.d();
            paramh.b();
        }
    }

    private static class b
            implements com.umeng.a.a.a.c.b {
        public e.a a() {
            return new e.a(null);
        }
    }

    private static class c
            extends com.umeng.a.a.a.c.d<e> {
        public void a(h paramh, e parame)
                throws j {
            paramh = (n) paramh;
            BitSet localBitSet = new BitSet();
            if (parame.e()) {
                localBitSet.set(0);
            }
            if (parame.i()) {
                localBitSet.set(1);
            }
            if (parame.l()) {
                localBitSet.set(2);
            }
            if (parame.o()) {
                localBitSet.set(3);
            }
            if (parame.r()) {
                localBitSet.set(4);
            }
            if (parame.u()) {
                localBitSet.set(5);
            }
            if (parame.x()) {
                localBitSet.set(6);
            }
            if (parame.A()) {
                localBitSet.set(7);
            }
            if (parame.D()) {
                localBitSet.set(8);
            }
            if (parame.G()) {
                localBitSet.set(9);
            }
            if (parame.J()) {
                localBitSet.set(10);
            }
            if (parame.M()) {
                localBitSet.set(11);
            }
            if (parame.P()) {
                localBitSet.set(12);
            }
            if (parame.S()) {
                localBitSet.set(13);
            }
            if (parame.V()) {
                localBitSet.set(14);
            }
            if (parame.Y()) {
                localBitSet.set(15);
            }
            if (parame.ab()) {
                localBitSet.set(16);
            }
            paramh.a(localBitSet, 17);
            if (parame.e()) {
                paramh.a(parame.a);
            }
            if (parame.i()) {
                paramh.a(parame.b);
            }
            if (parame.l()) {
                paramh.a(parame.c);
            }
            if (parame.o()) {
                paramh.a(parame.d);
            }
            if (parame.r()) {
                paramh.a(parame.e);
            }
            if (parame.u()) {
                paramh.a(parame.f);
            }
            if (parame.x()) {
                paramh.a(parame.g);
            }
            if (parame.A()) {
                paramh.a(parame.h);
            }
            if (parame.D()) {
                parame.i.b(paramh);
            }
            if (parame.G()) {
                paramh.a(parame.j);
            }
            if (parame.J()) {
                paramh.a(parame.k);
            }
            if (parame.M()) {
                paramh.a(parame.l);
            }
            if (parame.P()) {
                paramh.a(parame.m);
            }
            if (parame.S()) {
                paramh.a(parame.n);
            }
            if (parame.V()) {
                paramh.a(parame.o);
            }
            if (parame.Y()) {
                paramh.a(parame.p);
            }
            if (parame.ab()) {
                paramh.a(parame.q);
            }
        }

        public void b(h paramh, e parame)
                throws j {
            paramh = (n) paramh;
            BitSet localBitSet = paramh.b(17);
            if (localBitSet.get(0)) {
                parame.a = paramh.z();
                parame.a(true);
            }
            if (localBitSet.get(1)) {
                parame.b = paramh.z();
                parame.b(true);
            }
            if (localBitSet.get(2)) {
                parame.c = paramh.z();
                parame.c(true);
            }
            if (localBitSet.get(3)) {
                parame.d = paramh.z();
                parame.d(true);
            }
            if (localBitSet.get(4)) {
                parame.e = paramh.z();
                parame.e(true);
            }
            if (localBitSet.get(5)) {
                parame.f = paramh.z();
                parame.f(true);
            }
            if (localBitSet.get(6)) {
                parame.g = paramh.z();
                parame.g(true);
            }
            if (localBitSet.get(7)) {
                parame.h = paramh.z();
                parame.h(true);
            }
            if (localBitSet.get(8)) {
                parame.i = new u();
                parame.i.a(paramh);
                parame.i(true);
            }
            if (localBitSet.get(9)) {
                parame.j = paramh.t();
                parame.k(true);
            }
            if (localBitSet.get(10)) {
                parame.k = paramh.t();
                parame.m(true);
            }
            if (localBitSet.get(11)) {
                parame.l = paramh.z();
                parame.n(true);
            }
            if (localBitSet.get(12)) {
                parame.m = paramh.z();
                parame.o(true);
            }
            if (localBitSet.get(13)) {
                parame.n = paramh.x();
                parame.p(true);
            }
            if (localBitSet.get(14)) {
                parame.o = paramh.z();
                parame.q(true);
            }
            if (localBitSet.get(15)) {
                parame.p = paramh.z();
                parame.r(true);
            }
            if (localBitSet.get(16)) {
                parame.q = paramh.z();
                parame.s(true);
            }
        }
    }

    private static class d
            implements com.umeng.a.a.a.c.b {
        public e.c a() {
            return new e.c(null);
        }
    }

    public static enum e
            implements com.umeng.a.a.a.k {
        private static final Map<String, e> r;
        private final short s;
        private final String t;

        static {
            r = new HashMap();
            Iterator localIterator = EnumSet.allOf(e.class).iterator();
            while (localIterator.hasNext()) {
                e locale = (e) localIterator.next();
                r.put(locale.b(), locale);
            }
        }

        private e(short paramShort, String paramString) {
            this.s = paramShort;
            this.t = paramString;
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
                case 11:
                    return k;
                case 12:
                    return l;
                case 13:
                    return m;
                case 14:
                    return n;
                case 15:
                    return o;
                case 16:
                    return p;
            }
            return q;
        }

        public static e a(String paramString) {
            return (e) r.get(paramString);
        }

        public static e b(int paramInt) {
            e locale = a(paramInt);
            if (locale == null) {
                throw new IllegalArgumentException("Field " + paramInt + " doesn't exist!");
            }
            return locale;
        }

        public short a() {
            return this.s;
        }

        public String b() {
            return this.t;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/umeng/analytics/d/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */