package com.umeng.analytics.d;

import com.umeng.a.a.a.b.h;
import com.umeng.a.a.a.b.i;
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

public class c
        implements com.umeng.a.a.a.d<c, e>, Serializable, Cloneable {
    public static final Map<e, com.umeng.a.a.a.a.b> k;
    private static final m l = new m("AppInfo");
    private static final com.umeng.a.a.a.b.c m = new com.umeng.a.a.a.b.c("key", (byte) 11, (short) 1);
    private static final com.umeng.a.a.a.b.c n = new com.umeng.a.a.a.b.c("version", (byte) 11, (short) 2);
    private static final com.umeng.a.a.a.b.c o = new com.umeng.a.a.a.b.c("version_index", (byte) 8, (short) 3);
    private static final com.umeng.a.a.a.b.c p = new com.umeng.a.a.a.b.c("package_name", (byte) 11, (short) 4);
    private static final com.umeng.a.a.a.b.c q = new com.umeng.a.a.a.b.c("sdk_type", (byte) 8, (short) 5);
    private static final com.umeng.a.a.a.b.c r = new com.umeng.a.a.a.b.c("sdk_version", (byte) 11, (short) 6);
    private static final com.umeng.a.a.a.b.c s = new com.umeng.a.a.a.b.c("channel", (byte) 11, (short) 7);
    private static final com.umeng.a.a.a.b.c t = new com.umeng.a.a.a.b.c("wrapper_type", (byte) 11, (short) 8);
    private static final com.umeng.a.a.a.b.c u = new com.umeng.a.a.a.b.c("wrapper_version", (byte) 11, (short) 9);
    private static final com.umeng.a.a.a.b.c v = new com.umeng.a.a.a.b.c("vertical_type", (byte) 8, (short) 10);
    private static final Map<Class<? extends com.umeng.a.a.a.c.a>, com.umeng.a.a.a.c.b> w = new HashMap();
    private static final int x = 0;
    private static final int y = 1;
    private e[] A = {e.b, e.c, e.d, e.h, e.i, e.j};
    public String a;
    public String b;
    public int c;
    public String d;
    public w e;
    public String f;
    public String g;
    public String h;
    public String i;
    public int j;
    private byte z = 0;

    static {
        w.put(com.umeng.a.a.a.c.c.class, new b(null));
        w.put(com.umeng.a.a.a.c.d.class, new d(null));
        EnumMap localEnumMap = new EnumMap(e.class);
        localEnumMap.put(e.a, new com.umeng.a.a.a.a.b("key", (byte) 1, new com.umeng.a.a.a.a.c((byte) 11)));
        localEnumMap.put(e.b, new com.umeng.a.a.a.a.b("version", (byte) 2, new com.umeng.a.a.a.a.c((byte) 11)));
        localEnumMap.put(e.c, new com.umeng.a.a.a.a.b("version_index", (byte) 2, new com.umeng.a.a.a.a.c((byte) 8)));
        localEnumMap.put(e.d, new com.umeng.a.a.a.a.b("package_name", (byte) 2, new com.umeng.a.a.a.a.c((byte) 11)));
        localEnumMap.put(e.e, new com.umeng.a.a.a.a.b("sdk_type", (byte) 1, new com.umeng.a.a.a.a.a((byte) 16, w.class)));
        localEnumMap.put(e.f, new com.umeng.a.a.a.a.b("sdk_version", (byte) 1, new com.umeng.a.a.a.a.c((byte) 11)));
        localEnumMap.put(e.g, new com.umeng.a.a.a.a.b("channel", (byte) 1, new com.umeng.a.a.a.a.c((byte) 11)));
        localEnumMap.put(e.h, new com.umeng.a.a.a.a.b("wrapper_type", (byte) 2, new com.umeng.a.a.a.a.c((byte) 11)));
        localEnumMap.put(e.i, new com.umeng.a.a.a.a.b("wrapper_version", (byte) 2, new com.umeng.a.a.a.a.c((byte) 11)));
        localEnumMap.put(e.j, new com.umeng.a.a.a.a.b("vertical_type", (byte) 2, new com.umeng.a.a.a.a.c((byte) 8)));
        k = Collections.unmodifiableMap(localEnumMap);
        com.umeng.a.a.a.a.b.a(c.class, k);
    }

    public c() {
    }

    public c(c paramc) {
        this.z = paramc.z;
        if (paramc.e()) {
            this.a = paramc.a;
        }
        if (paramc.i()) {
            this.b = paramc.b;
        }
        this.c = paramc.c;
        if (paramc.o()) {
            this.d = paramc.d;
        }
        if (paramc.r()) {
            this.e = paramc.e;
        }
        if (paramc.u()) {
            this.f = paramc.f;
        }
        if (paramc.x()) {
            this.g = paramc.g;
        }
        if (paramc.A()) {
            this.h = paramc.h;
        }
        if (paramc.D()) {
            this.i = paramc.i;
        }
        this.j = paramc.j;
    }

    public c(String paramString1, w paramw, String paramString2, String paramString3) {
        this();
        this.a = paramString1;
        this.e = paramw;
        this.f = paramString2;
        this.g = paramString3;
    }

    private void a(ObjectInputStream paramObjectInputStream)
            throws IOException, ClassNotFoundException {
        try {
            this.z = 0;
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

    public String B() {
        return this.i;
    }

    public void C() {
        this.i = null;
    }

    public boolean D() {
        return this.i != null;
    }

    public int E() {
        return this.j;
    }

    public void F() {
        this.z = com.umeng.a.a.a.a.b(this.z, 1);
    }

    public boolean G() {
        return com.umeng.a.a.a.a.a(this.z, 1);
    }

    public void H()
            throws j {
        if (this.a == null) {
            throw new i("Required field 'key' was not present! Struct: " + toString());
        }
        if (this.e == null) {
            throw new i("Required field 'sdk_type' was not present! Struct: " + toString());
        }
        if (this.f == null) {
            throw new i("Required field 'sdk_version' was not present! Struct: " + toString());
        }
        if (this.g == null) {
            throw new i("Required field 'channel' was not present! Struct: " + toString());
        }
    }

    public c a() {
        return new c(this);
    }

    public c a(int paramInt) {
        this.c = paramInt;
        c(true);
        return this;
    }

    public c a(w paramw) {
        this.e = paramw;
        return this;
    }

    public c a(String paramString) {
        this.a = paramString;
        return this;
    }

    public void a(h paramh)
            throws j {
        ((com.umeng.a.a.a.c.b) w.get(paramh.D())).b().b(paramh, this);
    }

    public void a(boolean paramBoolean) {
        if (!paramBoolean) {
            this.a = null;
        }
    }

    public c b(String paramString) {
        this.b = paramString;
        return this;
    }

    public void b() {
        this.a = null;
        this.b = null;
        c(false);
        this.c = 0;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        j(false);
        this.j = 0;
    }

    public void b(h paramh)
            throws j {
        ((com.umeng.a.a.a.c.b) w.get(paramh.D())).b().a(paramh, this);
    }

    public void b(boolean paramBoolean) {
        if (!paramBoolean) {
            this.b = null;
        }
    }

    public c c(int paramInt) {
        this.j = paramInt;
        j(true);
        return this;
    }

    public c c(String paramString) {
        this.d = paramString;
        return this;
    }

    public String c() {
        return this.a;
    }

    public void c(boolean paramBoolean) {
        this.z = com.umeng.a.a.a.a.a(this.z, 0, paramBoolean);
    }

    public e d(int paramInt) {
        return e.a(paramInt);
    }

    public c d(String paramString) {
        this.f = paramString;
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

    public c e(String paramString) {
        this.g = paramString;
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

    public c f(String paramString) {
        this.h = paramString;
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

    public c g(String paramString) {
        this.i = paramString;
        return this;
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

    public int j() {
        return this.c;
    }

    public void j(boolean paramBoolean) {
        this.z = com.umeng.a.a.a.a.a(this.z, 1, paramBoolean);
    }

    public void k() {
        this.z = com.umeng.a.a.a.a.b(this.z, 0);
    }

    public boolean l() {
        return com.umeng.a.a.a.a.a(this.z, 0);
    }

    public String m() {
        return this.d;
    }

    public void n() {
        this.d = null;
    }

    public boolean o() {
        return this.d != null;
    }

    public w p() {
        return this.e;
    }

    public void q() {
        this.e = null;
    }

    public boolean r() {
        return this.e != null;
    }

    public String s() {
        return this.f;
    }

    public void t() {
        this.f = null;
    }

    public String toString() {
        StringBuilder localStringBuilder = new StringBuilder("AppInfo(");
        localStringBuilder.append("key:");
        if (this.a == null) {
            localStringBuilder.append("null");
            if (i()) {
                localStringBuilder.append(", ");
                localStringBuilder.append("version:");
                if (this.b != null) {
                    break label368;
                }
                localStringBuilder.append("null");
            }
            label72:
            if (l()) {
                localStringBuilder.append(", ");
                localStringBuilder.append("version_index:");
                localStringBuilder.append(this.c);
            }
            if (o()) {
                localStringBuilder.append(", ");
                localStringBuilder.append("package_name:");
                if (this.d != null) {
                    break label380;
                }
                localStringBuilder.append("null");
            }
            label142:
            localStringBuilder.append(", ");
            localStringBuilder.append("sdk_type:");
            if (this.e != null) {
                break label392;
            }
            localStringBuilder.append("null");
            label173:
            localStringBuilder.append(", ");
            localStringBuilder.append("sdk_version:");
            if (this.f != null) {
                break label404;
            }
            localStringBuilder.append("null");
            label204:
            localStringBuilder.append(", ");
            localStringBuilder.append("channel:");
            if (this.g != null) {
                break label416;
            }
            localStringBuilder.append("null");
            label235:
            if (A()) {
                localStringBuilder.append(", ");
                localStringBuilder.append("wrapper_type:");
                if (this.h != null) {
                    break label428;
                }
                localStringBuilder.append("null");
            }
            label273:
            if (D()) {
                localStringBuilder.append(", ");
                localStringBuilder.append("wrapper_version:");
                if (this.i != null) {
                    break label440;
                }
                localStringBuilder.append("null");
            }
        }
        for (; ; ) {
            if (G()) {
                localStringBuilder.append(", ");
                localStringBuilder.append("vertical_type:");
                localStringBuilder.append(this.j);
            }
            localStringBuilder.append(")");
            return localStringBuilder.toString();
            localStringBuilder.append(this.a);
            break;
            label368:
            localStringBuilder.append(this.b);
            break label72;
            label380:
            localStringBuilder.append(this.d);
            break label142;
            label392:
            localStringBuilder.append(this.e);
            break label173;
            label404:
            localStringBuilder.append(this.f);
            break label204;
            label416:
            localStringBuilder.append(this.g);
            break label235;
            label428:
            localStringBuilder.append(this.h);
            break label273;
            label440:
            localStringBuilder.append(this.i);
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
            extends com.umeng.a.a.a.c.c<c> {
        public void a(h paramh, c paramc)
                throws j {
            paramh.j();
            com.umeng.a.a.a.b.c localc = paramh.l();
            if (localc.b == 0) {
                paramh.k();
                paramc.H();
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
                    paramc.a = paramh.z();
                    paramc.a(true);
                } else {
                    com.umeng.a.a.a.b.k.a(paramh, localc.b);
                    continue;
                    if (localc.b == 11) {
                        paramc.b = paramh.z();
                        paramc.b(true);
                    } else {
                        com.umeng.a.a.a.b.k.a(paramh, localc.b);
                        continue;
                        if (localc.b == 8) {
                            paramc.c = paramh.w();
                            paramc.c(true);
                        } else {
                            com.umeng.a.a.a.b.k.a(paramh, localc.b);
                            continue;
                            if (localc.b == 11) {
                                paramc.d = paramh.z();
                                paramc.d(true);
                            } else {
                                com.umeng.a.a.a.b.k.a(paramh, localc.b);
                                continue;
                                if (localc.b == 8) {
                                    paramc.e = w.a(paramh.w());
                                    paramc.e(true);
                                } else {
                                    com.umeng.a.a.a.b.k.a(paramh, localc.b);
                                    continue;
                                    if (localc.b == 11) {
                                        paramc.f = paramh.z();
                                        paramc.f(true);
                                    } else {
                                        com.umeng.a.a.a.b.k.a(paramh, localc.b);
                                        continue;
                                        if (localc.b == 11) {
                                            paramc.g = paramh.z();
                                            paramc.g(true);
                                        } else {
                                            com.umeng.a.a.a.b.k.a(paramh, localc.b);
                                            continue;
                                            if (localc.b == 11) {
                                                paramc.h = paramh.z();
                                                paramc.h(true);
                                            } else {
                                                com.umeng.a.a.a.b.k.a(paramh, localc.b);
                                                continue;
                                                if (localc.b == 11) {
                                                    paramc.i = paramh.z();
                                                    paramc.i(true);
                                                } else {
                                                    com.umeng.a.a.a.b.k.a(paramh, localc.b);
                                                    continue;
                                                    if (localc.b == 8) {
                                                        paramc.j = paramh.w();
                                                        paramc.j(true);
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

        public void b(h paramh, c paramc)
                throws j {
            paramc.H();
            paramh.a(c.I());
            if (paramc.a != null) {
                paramh.a(c.J());
                paramh.a(paramc.a);
                paramh.c();
            }
            if ((paramc.b != null) && (paramc.i())) {
                paramh.a(c.K());
                paramh.a(paramc.b);
                paramh.c();
            }
            if (paramc.l()) {
                paramh.a(c.L());
                paramh.a(paramc.c);
                paramh.c();
            }
            if ((paramc.d != null) && (paramc.o())) {
                paramh.a(c.M());
                paramh.a(paramc.d);
                paramh.c();
            }
            if (paramc.e != null) {
                paramh.a(c.N());
                paramh.a(paramc.e.a());
                paramh.c();
            }
            if (paramc.f != null) {
                paramh.a(c.O());
                paramh.a(paramc.f);
                paramh.c();
            }
            if (paramc.g != null) {
                paramh.a(c.P());
                paramh.a(paramc.g);
                paramh.c();
            }
            if ((paramc.h != null) && (paramc.A())) {
                paramh.a(c.Q());
                paramh.a(paramc.h);
                paramh.c();
            }
            if ((paramc.i != null) && (paramc.D())) {
                paramh.a(c.R());
                paramh.a(paramc.i);
                paramh.c();
            }
            if (paramc.G()) {
                paramh.a(c.S());
                paramh.a(paramc.j);
                paramh.c();
            }
            paramh.d();
            paramh.b();
        }
    }

    private static class b
            implements com.umeng.a.a.a.c.b {
        public c.a a() {
            return new c.a(null);
        }
    }

    private static class c
            extends com.umeng.a.a.a.c.d<c> {
        public void a(h paramh, c paramc)
                throws j {
            paramh = (n) paramh;
            paramh.a(paramc.a);
            paramh.a(paramc.e.a());
            paramh.a(paramc.f);
            paramh.a(paramc.g);
            BitSet localBitSet = new BitSet();
            if (paramc.i()) {
                localBitSet.set(0);
            }
            if (paramc.l()) {
                localBitSet.set(1);
            }
            if (paramc.o()) {
                localBitSet.set(2);
            }
            if (paramc.A()) {
                localBitSet.set(3);
            }
            if (paramc.D()) {
                localBitSet.set(4);
            }
            if (paramc.G()) {
                localBitSet.set(5);
            }
            paramh.a(localBitSet, 6);
            if (paramc.i()) {
                paramh.a(paramc.b);
            }
            if (paramc.l()) {
                paramh.a(paramc.c);
            }
            if (paramc.o()) {
                paramh.a(paramc.d);
            }
            if (paramc.A()) {
                paramh.a(paramc.h);
            }
            if (paramc.D()) {
                paramh.a(paramc.i);
            }
            if (paramc.G()) {
                paramh.a(paramc.j);
            }
        }

        public void b(h paramh, c paramc)
                throws j {
            paramh = (n) paramh;
            paramc.a = paramh.z();
            paramc.a(true);
            paramc.e = w.a(paramh.w());
            paramc.e(true);
            paramc.f = paramh.z();
            paramc.f(true);
            paramc.g = paramh.z();
            paramc.g(true);
            BitSet localBitSet = paramh.b(6);
            if (localBitSet.get(0)) {
                paramc.b = paramh.z();
                paramc.b(true);
            }
            if (localBitSet.get(1)) {
                paramc.c = paramh.w();
                paramc.c(true);
            }
            if (localBitSet.get(2)) {
                paramc.d = paramh.z();
                paramc.d(true);
            }
            if (localBitSet.get(3)) {
                paramc.h = paramh.z();
                paramc.h(true);
            }
            if (localBitSet.get(4)) {
                paramc.i = paramh.z();
                paramc.i(true);
            }
            if (localBitSet.get(5)) {
                paramc.j = paramh.w();
                paramc.j(true);
            }
        }
    }

    private static class d
            implements com.umeng.a.a.a.c.b {
        public c.c a() {
            return new c.c(null);
        }
    }

    public static enum e
            implements com.umeng.a.a.a.k {
        private static final Map<String, e> k;
        private final short l;
        private final String m;

        static {
            k = new HashMap();
            Iterator localIterator = EnumSet.allOf(e.class).iterator();
            while (localIterator.hasNext()) {
                e locale = (e) localIterator.next();
                k.put(locale.b(), locale);
            }
        }

        private e(short paramShort, String paramString) {
            this.l = paramShort;
            this.m = paramString;
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
            }
            return j;
        }

        public static e a(String paramString) {
            return (e) k.get(paramString);
        }

        public static e b(int paramInt) {
            e locale = a(paramInt);
            if (locale == null) {
                throw new IllegalArgumentException("Field " + paramInt + " doesn't exist!");
            }
            return locale;
        }

        public short a() {
            return this.l;
        }

        public String b() {
            return this.m;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/umeng/analytics/d/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */