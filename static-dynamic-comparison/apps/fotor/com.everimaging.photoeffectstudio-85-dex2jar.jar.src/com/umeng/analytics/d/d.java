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

public class d
        implements com.umeng.a.a.a.d<d, e>, Serializable, Cloneable {
    public static final Map<e, com.umeng.a.a.a.a.b> d;
    private static final m e = new m("ClientStats");
    private static final com.umeng.a.a.a.b.c f = new com.umeng.a.a.a.b.c("successful_requests", (byte) 8, (short) 1);
    private static final com.umeng.a.a.a.b.c g = new com.umeng.a.a.a.b.c("failed_requests", (byte) 8, (short) 2);
    private static final com.umeng.a.a.a.b.c h = new com.umeng.a.a.a.b.c("last_request_spent_ms", (byte) 8, (short) 3);
    private static final Map<Class<? extends com.umeng.a.a.a.c.a>, com.umeng.a.a.a.c.b> i = new HashMap();
    private static final int j = 0;
    private static final int k = 1;
    private static final int l = 2;
    public int a;
    public int b;
    public int c;
    private byte m = 0;
    private e[] n = {e.c};

    static {
        i.put(com.umeng.a.a.a.c.c.class, new b(null));
        i.put(com.umeng.a.a.a.c.d.class, new d(null));
        EnumMap localEnumMap = new EnumMap(e.class);
        localEnumMap.put(e.a, new com.umeng.a.a.a.a.b("successful_requests", (byte) 1, new com.umeng.a.a.a.a.c((byte) 8)));
        localEnumMap.put(e.b, new com.umeng.a.a.a.a.b("failed_requests", (byte) 1, new com.umeng.a.a.a.a.c((byte) 8)));
        localEnumMap.put(e.c, new com.umeng.a.a.a.a.b("last_request_spent_ms", (byte) 2, new com.umeng.a.a.a.a.c((byte) 8)));
        d = Collections.unmodifiableMap(localEnumMap);
        com.umeng.a.a.a.a.b.a(d.class, d);
    }

    public d() {
        this.a = 0;
        this.b = 0;
    }

    public d(int paramInt1, int paramInt2) {
        this();
        this.a = paramInt1;
        a(true);
        this.b = paramInt2;
        b(true);
    }

    public d(d paramd) {
        this.m = paramd.m;
        this.a = paramd.a;
        this.b = paramd.b;
        this.c = paramd.c;
    }

    private void a(ObjectInputStream paramObjectInputStream)
            throws IOException, ClassNotFoundException {
        try {
            this.m = 0;
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

    public d a() {
        return new d(this);
    }

    public d a(int paramInt) {
        this.a = paramInt;
        a(true);
        return this;
    }

    public void a(h paramh)
            throws j {
        ((com.umeng.a.a.a.c.b) i.get(paramh.D())).b().b(paramh, this);
    }

    public void a(boolean paramBoolean) {
        this.m = com.umeng.a.a.a.a.a(this.m, 0, paramBoolean);
    }

    public void b() {
        this.a = 0;
        this.b = 0;
        c(false);
        this.c = 0;
    }

    public void b(h paramh)
            throws j {
        ((com.umeng.a.a.a.c.b) i.get(paramh.D())).b().a(paramh, this);
    }

    public void b(boolean paramBoolean) {
        this.m = com.umeng.a.a.a.a.a(this.m, 1, paramBoolean);
    }

    public int c() {
        return this.a;
    }

    public d c(int paramInt) {
        this.b = paramInt;
        b(true);
        return this;
    }

    public void c(boolean paramBoolean) {
        this.m = com.umeng.a.a.a.a.a(this.m, 2, paramBoolean);
    }

    public d d(int paramInt) {
        this.c = paramInt;
        c(true);
        return this;
    }

    public void d() {
        this.m = com.umeng.a.a.a.a.b(this.m, 0);
    }

    public e e(int paramInt) {
        return e.a(paramInt);
    }

    public boolean e() {
        return com.umeng.a.a.a.a.a(this.m, 0);
    }

    public int f() {
        return this.b;
    }

    public void h() {
        this.m = com.umeng.a.a.a.a.b(this.m, 1);
    }

    public boolean i() {
        return com.umeng.a.a.a.a.a(this.m, 1);
    }

    public int j() {
        return this.c;
    }

    public void k() {
        this.m = com.umeng.a.a.a.a.b(this.m, 2);
    }

    public boolean l() {
        return com.umeng.a.a.a.a.a(this.m, 2);
    }

    public void m()
            throws j {
    }

    public String toString() {
        StringBuilder localStringBuilder = new StringBuilder("ClientStats(");
        localStringBuilder.append("successful_requests:");
        localStringBuilder.append(this.a);
        localStringBuilder.append(", ");
        localStringBuilder.append("failed_requests:");
        localStringBuilder.append(this.b);
        if (l()) {
            localStringBuilder.append(", ");
            localStringBuilder.append("last_request_spent_ms:");
            localStringBuilder.append(this.c);
        }
        localStringBuilder.append(")");
        return localStringBuilder.toString();
    }

    private static class a
            extends com.umeng.a.a.a.c.c<d> {
        public void a(h paramh, d paramd)
                throws j {
            paramh.j();
            com.umeng.a.a.a.b.c localc = paramh.l();
            if (localc.b == 0) {
                paramh.k();
                if (!paramd.e()) {
                    throw new i("Required field 'successful_requests' was not found in serialized data! Struct: " + toString());
                }
            } else {
                switch (localc.c) {
                    default:
                        com.umeng.a.a.a.b.k.a(paramh, localc.b);
                }
                for (; ; ) {
                    paramh.m();
                    break;
                    if (localc.b == 8) {
                        paramd.a = paramh.w();
                        paramd.a(true);
                    } else {
                        com.umeng.a.a.a.b.k.a(paramh, localc.b);
                        continue;
                        if (localc.b == 8) {
                            paramd.b = paramh.w();
                            paramd.b(true);
                        } else {
                            com.umeng.a.a.a.b.k.a(paramh, localc.b);
                            continue;
                            if (localc.b == 8) {
                                paramd.c = paramh.w();
                                paramd.c(true);
                            } else {
                                com.umeng.a.a.a.b.k.a(paramh, localc.b);
                            }
                        }
                    }
                }
            }
            if (!paramd.i()) {
                throw new i("Required field 'failed_requests' was not found in serialized data! Struct: " + toString());
            }
            paramd.m();
        }

        public void b(h paramh, d paramd)
                throws j {
            paramd.m();
            paramh.a(d.n());
            paramh.a(d.o());
            paramh.a(paramd.a);
            paramh.c();
            paramh.a(d.p());
            paramh.a(paramd.b);
            paramh.c();
            if (paramd.l()) {
                paramh.a(d.q());
                paramh.a(paramd.c);
                paramh.c();
            }
            paramh.d();
            paramh.b();
        }
    }

    private static class b
            implements com.umeng.a.a.a.c.b {
        public d.a a() {
            return new d.a(null);
        }
    }

    private static class c
            extends com.umeng.a.a.a.c.d<d> {
        public void a(h paramh, d paramd)
                throws j {
            paramh = (n) paramh;
            paramh.a(paramd.a);
            paramh.a(paramd.b);
            BitSet localBitSet = new BitSet();
            if (paramd.l()) {
                localBitSet.set(0);
            }
            paramh.a(localBitSet, 1);
            if (paramd.l()) {
                paramh.a(paramd.c);
            }
        }

        public void b(h paramh, d paramd)
                throws j {
            paramh = (n) paramh;
            paramd.a = paramh.w();
            paramd.a(true);
            paramd.b = paramh.w();
            paramd.b(true);
            if (paramh.b(1).get(0)) {
                paramd.c = paramh.w();
                paramd.c(true);
            }
        }
    }

    private static class d
            implements com.umeng.a.a.a.c.b {
        public d.c a() {
            return new d.c(null);
        }
    }

    public static enum e
            implements com.umeng.a.a.a.k {
        private static final Map<String, e> d;
        private final short e;
        private final String f;

        static {
            d = new HashMap();
            Iterator localIterator = EnumSet.allOf(e.class).iterator();
            while (localIterator.hasNext()) {
                e locale = (e) localIterator.next();
                d.put(locale.b(), locale);
            }
        }

        private e(short paramShort, String paramString) {
            this.e = paramShort;
            this.f = paramString;
        }

        public static e a(int paramInt) {
            switch (paramInt) {
                default:
                    return null;
                case 1:
                    return a;
                case 2:
                    return b;
            }
            return c;
        }

        public static e a(String paramString) {
            return (e) d.get(paramString);
        }

        public static e b(int paramInt) {
            e locale = a(paramInt);
            if (locale == null) {
                throw new IllegalArgumentException("Field " + paramInt + " doesn't exist!");
            }
            return locale;
        }

        public short a() {
            return this.e;
        }

        public String b() {
            return this.f;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/umeng/analytics/d/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */