package com.umeng.analytics.e;

import com.umeng.a.a.a.b.h;
import com.umeng.a.a.a.b.i;
import com.umeng.a.a.a.b.m;
import com.umeng.a.a.a.b.n;
import com.umeng.a.a.a.e;
import com.umeng.a.a.a.j;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class a
        implements com.umeng.a.a.a.d<a, e>, Serializable, Cloneable {
    public static final Map<e, com.umeng.a.a.a.a.b> j;
    private static final m k = new m("UMEnvelope");
    private static final com.umeng.a.a.a.b.c l = new com.umeng.a.a.a.b.c("version", (byte) 11, (short) 1);
    private static final com.umeng.a.a.a.b.c m = new com.umeng.a.a.a.b.c("address", (byte) 11, (short) 2);
    private static final com.umeng.a.a.a.b.c n = new com.umeng.a.a.a.b.c("signature", (byte) 11, (short) 3);
    private static final com.umeng.a.a.a.b.c o = new com.umeng.a.a.a.b.c("serial_num", (byte) 8, (short) 4);
    private static final com.umeng.a.a.a.b.c p = new com.umeng.a.a.a.b.c("ts_secs", (byte) 8, (short) 5);
    private static final com.umeng.a.a.a.b.c q = new com.umeng.a.a.a.b.c("length", (byte) 8, (short) 6);
    private static final com.umeng.a.a.a.b.c r = new com.umeng.a.a.a.b.c("entity", (byte) 11, (short) 7);
    private static final com.umeng.a.a.a.b.c s = new com.umeng.a.a.a.b.c("guid", (byte) 11, (short) 8);
    private static final com.umeng.a.a.a.b.c t = new com.umeng.a.a.a.b.c("checksum", (byte) 11, (short) 9);
    private static final Map<Class<? extends com.umeng.a.a.a.c.a>, com.umeng.a.a.a.c.b> u = new HashMap();
    private static final int v = 0;
    private static final int w = 1;
    private static final int x = 2;
    public String a;
    public String b;
    public String c;
    public int d;
    public int e;
    public int f;
    public ByteBuffer g;
    public String h;
    public String i;
    private byte y = 0;

    static {
        u.put(com.umeng.a.a.a.c.c.class, new b(null));
        u.put(com.umeng.a.a.a.c.d.class, new d(null));
        EnumMap localEnumMap = new EnumMap(e.class);
        localEnumMap.put(e.a, new com.umeng.a.a.a.a.b("version", (byte) 1, new com.umeng.a.a.a.a.c((byte) 11)));
        localEnumMap.put(e.b, new com.umeng.a.a.a.a.b("address", (byte) 1, new com.umeng.a.a.a.a.c((byte) 11)));
        localEnumMap.put(e.c, new com.umeng.a.a.a.a.b("signature", (byte) 1, new com.umeng.a.a.a.a.c((byte) 11)));
        localEnumMap.put(e.d, new com.umeng.a.a.a.a.b("serial_num", (byte) 1, new com.umeng.a.a.a.a.c((byte) 8)));
        localEnumMap.put(e.e, new com.umeng.a.a.a.a.b("ts_secs", (byte) 1, new com.umeng.a.a.a.a.c((byte) 8)));
        localEnumMap.put(e.f, new com.umeng.a.a.a.a.b("length", (byte) 1, new com.umeng.a.a.a.a.c((byte) 8)));
        localEnumMap.put(e.g, new com.umeng.a.a.a.a.b("entity", (byte) 1, new com.umeng.a.a.a.a.c((byte) 11, true)));
        localEnumMap.put(e.h, new com.umeng.a.a.a.a.b("guid", (byte) 1, new com.umeng.a.a.a.a.c((byte) 11)));
        localEnumMap.put(e.i, new com.umeng.a.a.a.a.b("checksum", (byte) 1, new com.umeng.a.a.a.a.c((byte) 11)));
        j = Collections.unmodifiableMap(localEnumMap);
        com.umeng.a.a.a.a.b.a(a.class, j);
    }

    public a() {
    }

    public a(a parama) {
        this.y = parama.y;
        if (parama.e()) {
            this.a = parama.a;
        }
        if (parama.i()) {
            this.b = parama.b;
        }
        if (parama.l()) {
            this.c = parama.c;
        }
        this.d = parama.d;
        this.e = parama.e;
        this.f = parama.f;
        if (parama.y()) {
            this.g = e.d(parama.g);
        }
        if (parama.B()) {
            this.h = parama.h;
        }
        if (parama.E()) {
            this.i = parama.i;
        }
    }

    public a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, ByteBuffer paramByteBuffer, String paramString4, String paramString5) {
        this();
        this.a = paramString1;
        this.b = paramString2;
        this.c = paramString3;
        this.d = paramInt1;
        d(true);
        this.e = paramInt2;
        e(true);
        this.f = paramInt3;
        f(true);
        this.g = paramByteBuffer;
        this.h = paramString4;
        this.i = paramString5;
    }

    private void a(ObjectInputStream paramObjectInputStream)
            throws IOException, ClassNotFoundException {
        try {
            this.y = 0;
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
        this.h = null;
    }

    public boolean B() {
        return this.h != null;
    }

    public String C() {
        return this.i;
    }

    public void D() {
        this.i = null;
    }

    public boolean E() {
        return this.i != null;
    }

    public void F()
            throws j {
        if (this.a == null) {
            throw new i("Required field 'version' was not present! Struct: " + toString());
        }
        if (this.b == null) {
            throw new i("Required field 'address' was not present! Struct: " + toString());
        }
        if (this.c == null) {
            throw new i("Required field 'signature' was not present! Struct: " + toString());
        }
        if (this.g == null) {
            throw new i("Required field 'entity' was not present! Struct: " + toString());
        }
        if (this.h == null) {
            throw new i("Required field 'guid' was not present! Struct: " + toString());
        }
        if (this.i == null) {
            throw new i("Required field 'checksum' was not present! Struct: " + toString());
        }
    }

    public a a() {
        return new a(this);
    }

    public a a(int paramInt) {
        this.d = paramInt;
        d(true);
        return this;
    }

    public a a(String paramString) {
        this.a = paramString;
        return this;
    }

    public a a(ByteBuffer paramByteBuffer) {
        this.g = paramByteBuffer;
        return this;
    }

    public a a(byte[] paramArrayOfByte) {
        if (paramArrayOfByte == null) {
        }
        for (paramArrayOfByte = (ByteBuffer) null; ; paramArrayOfByte = ByteBuffer.wrap(paramArrayOfByte)) {
            a(paramArrayOfByte);
            return this;
        }
    }

    public void a(h paramh)
            throws j {
        ((com.umeng.a.a.a.c.b) u.get(paramh.D())).b().b(paramh, this);
    }

    public void a(boolean paramBoolean) {
        if (!paramBoolean) {
            this.a = null;
        }
    }

    public a b(String paramString) {
        this.b = paramString;
        return this;
    }

    public void b() {
        this.a = null;
        this.b = null;
        this.c = null;
        d(false);
        this.d = 0;
        e(false);
        this.e = 0;
        f(false);
        this.f = 0;
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

    public a c(int paramInt) {
        this.e = paramInt;
        e(true);
        return this;
    }

    public a c(String paramString) {
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

    public a d(int paramInt) {
        this.f = paramInt;
        f(true);
        return this;
    }

    public a d(String paramString) {
        this.h = paramString;
        return this;
    }

    public void d() {
        this.a = null;
    }

    public void d(boolean paramBoolean) {
        this.y = com.umeng.a.a.a.a.a(this.y, 0, paramBoolean);
    }

    public e e(int paramInt) {
        return e.a(paramInt);
    }

    public a e(String paramString) {
        this.i = paramString;
        return this;
    }

    public void e(boolean paramBoolean) {
        this.y = com.umeng.a.a.a.a.a(this.y, 1, paramBoolean);
    }

    public boolean e() {
        return this.a != null;
    }

    public String f() {
        return this.b;
    }

    public void f(boolean paramBoolean) {
        this.y = com.umeng.a.a.a.a.a(this.y, 2, paramBoolean);
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

    public String j() {
        return this.c;
    }

    public void k() {
        this.c = null;
    }

    public boolean l() {
        return this.c != null;
    }

    public int m() {
        return this.d;
    }

    public void n() {
        this.y = com.umeng.a.a.a.a.b(this.y, 0);
    }

    public boolean o() {
        return com.umeng.a.a.a.a.a(this.y, 0);
    }

    public int p() {
        return this.e;
    }

    public void q() {
        this.y = com.umeng.a.a.a.a.b(this.y, 1);
    }

    public boolean r() {
        return com.umeng.a.a.a.a.a(this.y, 1);
    }

    public int s() {
        return this.f;
    }

    public void t() {
        this.y = com.umeng.a.a.a.a.b(this.y, 2);
    }

    public String toString() {
        StringBuilder localStringBuilder = new StringBuilder("UMEnvelope(");
        localStringBuilder.append("version:");
        if (this.a == null) {
            localStringBuilder.append("null");
            localStringBuilder.append(", ");
            localStringBuilder.append("address:");
            if (this.b != null) {
                break label289;
            }
            localStringBuilder.append("null");
            label65:
            localStringBuilder.append(", ");
            localStringBuilder.append("signature:");
            if (this.c != null) {
                break label301;
            }
            localStringBuilder.append("null");
            label96:
            localStringBuilder.append(", ");
            localStringBuilder.append("serial_num:");
            localStringBuilder.append(this.d);
            localStringBuilder.append(", ");
            localStringBuilder.append("ts_secs:");
            localStringBuilder.append(this.e);
            localStringBuilder.append(", ");
            localStringBuilder.append("length:");
            localStringBuilder.append(this.f);
            localStringBuilder.append(", ");
            localStringBuilder.append("entity:");
            if (this.g != null) {
                break label313;
            }
            localStringBuilder.append("null");
            label202:
            localStringBuilder.append(", ");
            localStringBuilder.append("guid:");
            if (this.h != null) {
                break label324;
            }
            localStringBuilder.append("null");
            label233:
            localStringBuilder.append(", ");
            localStringBuilder.append("checksum:");
            if (this.i != null) {
                break label336;
            }
            localStringBuilder.append("null");
        }
        for (; ; ) {
            localStringBuilder.append(")");
            return localStringBuilder.toString();
            localStringBuilder.append(this.a);
            break;
            label289:
            localStringBuilder.append(this.b);
            break label65;
            label301:
            localStringBuilder.append(this.c);
            break label96;
            label313:
            e.a(this.g, localStringBuilder);
            break label202;
            label324:
            localStringBuilder.append(this.h);
            break label233;
            label336:
            localStringBuilder.append(this.i);
        }
    }

    public boolean u() {
        return com.umeng.a.a.a.a.a(this.y, 2);
    }

    public byte[] v() {
        a(e.c(this.g));
        if (this.g == null) {
            return null;
        }
        return this.g.array();
    }

    public ByteBuffer w() {
        return this.g;
    }

    public void x() {
        this.g = null;
    }

    public boolean y() {
        return this.g != null;
    }

    public String z() {
        return this.h;
    }

    private static class a
            extends com.umeng.a.a.a.c.c<a> {
        public void a(h paramh, a parama)
                throws j {
            paramh.j();
            com.umeng.a.a.a.b.c localc = paramh.l();
            if (localc.b == 0) {
                paramh.k();
                if (!parama.o()) {
                    throw new i("Required field 'serial_num' was not found in serialized data! Struct: " + toString());
                }
            } else {
                switch (localc.c) {
                    default:
                        com.umeng.a.a.a.b.k.a(paramh, localc.b);
                }
                for (; ; ) {
                    paramh.m();
                    break;
                    if (localc.b == 11) {
                        parama.a = paramh.z();
                        parama.a(true);
                    } else {
                        com.umeng.a.a.a.b.k.a(paramh, localc.b);
                        continue;
                        if (localc.b == 11) {
                            parama.b = paramh.z();
                            parama.b(true);
                        } else {
                            com.umeng.a.a.a.b.k.a(paramh, localc.b);
                            continue;
                            if (localc.b == 11) {
                                parama.c = paramh.z();
                                parama.c(true);
                            } else {
                                com.umeng.a.a.a.b.k.a(paramh, localc.b);
                                continue;
                                if (localc.b == 8) {
                                    parama.d = paramh.w();
                                    parama.d(true);
                                } else {
                                    com.umeng.a.a.a.b.k.a(paramh, localc.b);
                                    continue;
                                    if (localc.b == 8) {
                                        parama.e = paramh.w();
                                        parama.e(true);
                                    } else {
                                        com.umeng.a.a.a.b.k.a(paramh, localc.b);
                                        continue;
                                        if (localc.b == 8) {
                                            parama.f = paramh.w();
                                            parama.f(true);
                                        } else {
                                            com.umeng.a.a.a.b.k.a(paramh, localc.b);
                                            continue;
                                            if (localc.b == 11) {
                                                parama.g = paramh.A();
                                                parama.g(true);
                                            } else {
                                                com.umeng.a.a.a.b.k.a(paramh, localc.b);
                                                continue;
                                                if (localc.b == 11) {
                                                    parama.h = paramh.z();
                                                    parama.h(true);
                                                } else {
                                                    com.umeng.a.a.a.b.k.a(paramh, localc.b);
                                                    continue;
                                                    if (localc.b == 11) {
                                                        parama.i = paramh.z();
                                                        parama.i(true);
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
            if (!parama.r()) {
                throw new i("Required field 'ts_secs' was not found in serialized data! Struct: " + toString());
            }
            if (!parama.u()) {
                throw new i("Required field 'length' was not found in serialized data! Struct: " + toString());
            }
            parama.F();
        }

        public void b(h paramh, a parama)
                throws j {
            parama.F();
            paramh.a(a.G());
            if (parama.a != null) {
                paramh.a(a.H());
                paramh.a(parama.a);
                paramh.c();
            }
            if (parama.b != null) {
                paramh.a(a.I());
                paramh.a(parama.b);
                paramh.c();
            }
            if (parama.c != null) {
                paramh.a(a.J());
                paramh.a(parama.c);
                paramh.c();
            }
            paramh.a(a.K());
            paramh.a(parama.d);
            paramh.c();
            paramh.a(a.L());
            paramh.a(parama.e);
            paramh.c();
            paramh.a(a.M());
            paramh.a(parama.f);
            paramh.c();
            if (parama.g != null) {
                paramh.a(a.N());
                paramh.a(parama.g);
                paramh.c();
            }
            if (parama.h != null) {
                paramh.a(a.O());
                paramh.a(parama.h);
                paramh.c();
            }
            if (parama.i != null) {
                paramh.a(a.P());
                paramh.a(parama.i);
                paramh.c();
            }
            paramh.d();
            paramh.b();
        }
    }

    private static class b
            implements com.umeng.a.a.a.c.b {
        public a.a a() {
            return new a.a(null);
        }
    }

    private static class c
            extends com.umeng.a.a.a.c.d<a> {
        public void a(h paramh, a parama)
                throws j {
            paramh = (n) paramh;
            paramh.a(parama.a);
            paramh.a(parama.b);
            paramh.a(parama.c);
            paramh.a(parama.d);
            paramh.a(parama.e);
            paramh.a(parama.f);
            paramh.a(parama.g);
            paramh.a(parama.h);
            paramh.a(parama.i);
        }

        public void b(h paramh, a parama)
                throws j {
            paramh = (n) paramh;
            parama.a = paramh.z();
            parama.a(true);
            parama.b = paramh.z();
            parama.b(true);
            parama.c = paramh.z();
            parama.c(true);
            parama.d = paramh.w();
            parama.d(true);
            parama.e = paramh.w();
            parama.e(true);
            parama.f = paramh.w();
            parama.f(true);
            parama.g = paramh.A();
            parama.g(true);
            parama.h = paramh.z();
            parama.h(true);
            parama.i = paramh.z();
            parama.i(true);
        }
    }

    private static class d
            implements com.umeng.a.a.a.c.b {
        public a.c a() {
            return new a.c(null);
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


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/umeng/analytics/e/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */