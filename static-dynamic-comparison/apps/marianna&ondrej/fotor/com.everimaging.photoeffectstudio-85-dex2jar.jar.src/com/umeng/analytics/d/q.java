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
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class q
        implements com.umeng.a.a.a.d<q, e>, Serializable, Cloneable {
    public static final Map<e, com.umeng.a.a.a.a.b> d;
    private static final m e = new m("Location");
    private static final com.umeng.a.a.a.b.c f = new com.umeng.a.a.a.b.c("lat", (byte) 4, (short) 1);
    private static final com.umeng.a.a.a.b.c g = new com.umeng.a.a.a.b.c("lng", (byte) 4, (short) 2);
    private static final com.umeng.a.a.a.b.c h = new com.umeng.a.a.a.b.c("ts", (byte) 10, (short) 3);
    private static final Map<Class<? extends com.umeng.a.a.a.c.a>, com.umeng.a.a.a.c.b> i = new HashMap();
    private static final int j = 0;
    private static final int k = 1;
    private static final int l = 2;
    public double a;
    public double b;
    public long c;
    private byte m = 0;

    static {
        i.put(com.umeng.a.a.a.c.c.class, new b(null));
        i.put(com.umeng.a.a.a.c.d.class, new d(null));
        EnumMap localEnumMap = new EnumMap(e.class);
        localEnumMap.put(e.a, new com.umeng.a.a.a.a.b("lat", (byte) 1, new com.umeng.a.a.a.a.c((byte) 4)));
        localEnumMap.put(e.b, new com.umeng.a.a.a.a.b("lng", (byte) 1, new com.umeng.a.a.a.a.c((byte) 4)));
        localEnumMap.put(e.c, new com.umeng.a.a.a.a.b("ts", (byte) 1, new com.umeng.a.a.a.a.c((byte) 10)));
        d = Collections.unmodifiableMap(localEnumMap);
        com.umeng.a.a.a.a.b.a(q.class, d);
    }

    public q() {
    }

    public q(double paramDouble1, double paramDouble2, long paramLong) {
        this();
        this.a = paramDouble1;
        a(true);
        this.b = paramDouble2;
        b(true);
        this.c = paramLong;
        c(true);
    }

    public q(q paramq) {
        this.m = paramq.m;
        this.a = paramq.a;
        this.b = paramq.b;
        this.c = paramq.c;
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

    public e a(int paramInt) {
        return e.a(paramInt);
    }

    public q a() {
        return new q(this);
    }

    public q a(double paramDouble) {
        this.a = paramDouble;
        a(true);
        return this;
    }

    public q a(long paramLong) {
        this.c = paramLong;
        c(true);
        return this;
    }

    public void a(h paramh)
            throws j {
        ((com.umeng.a.a.a.c.b) i.get(paramh.D())).b().b(paramh, this);
    }

    public void a(boolean paramBoolean) {
        this.m = com.umeng.a.a.a.a.a(this.m, 0, paramBoolean);
    }

    public q b(double paramDouble) {
        this.b = paramDouble;
        b(true);
        return this;
    }

    public void b() {
        a(false);
        this.a = 0.0D;
        b(false);
        this.b = 0.0D;
        c(false);
        this.c = 0L;
    }

    public void b(h paramh)
            throws j {
        ((com.umeng.a.a.a.c.b) i.get(paramh.D())).b().a(paramh, this);
    }

    public void b(boolean paramBoolean) {
        this.m = com.umeng.a.a.a.a.a(this.m, 1, paramBoolean);
    }

    public double c() {
        return this.a;
    }

    public void c(boolean paramBoolean) {
        this.m = com.umeng.a.a.a.a.a(this.m, 2, paramBoolean);
    }

    public void d() {
        this.m = com.umeng.a.a.a.a.b(this.m, 0);
    }

    public boolean e() {
        return com.umeng.a.a.a.a.a(this.m, 0);
    }

    public double f() {
        return this.b;
    }

    public void h() {
        this.m = com.umeng.a.a.a.a.b(this.m, 1);
    }

    public boolean i() {
        return com.umeng.a.a.a.a.a(this.m, 1);
    }

    public long j() {
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
        StringBuilder localStringBuilder = new StringBuilder("Location(");
        localStringBuilder.append("lat:");
        localStringBuilder.append(this.a);
        localStringBuilder.append(", ");
        localStringBuilder.append("lng:");
        localStringBuilder.append(this.b);
        localStringBuilder.append(", ");
        localStringBuilder.append("ts:");
        localStringBuilder.append(this.c);
        localStringBuilder.append(")");
        return localStringBuilder.toString();
    }

    private static class a
            extends com.umeng.a.a.a.c.c<q> {
        public void a(h paramh, q paramq)
                throws j {
            paramh.j();
            com.umeng.a.a.a.b.c localc = paramh.l();
            if (localc.b == 0) {
                paramh.k();
                if (!paramq.e()) {
                    throw new i("Required field 'lat' was not found in serialized data! Struct: " + toString());
                }
            } else {
                switch (localc.c) {
                    default:
                        com.umeng.a.a.a.b.k.a(paramh, localc.b);
                }
                for (; ; ) {
                    paramh.m();
                    break;
                    if (localc.b == 4) {
                        paramq.a = paramh.y();
                        paramq.a(true);
                    } else {
                        com.umeng.a.a.a.b.k.a(paramh, localc.b);
                        continue;
                        if (localc.b == 4) {
                            paramq.b = paramh.y();
                            paramq.b(true);
                        } else {
                            com.umeng.a.a.a.b.k.a(paramh, localc.b);
                            continue;
                            if (localc.b == 10) {
                                paramq.c = paramh.x();
                                paramq.c(true);
                            } else {
                                com.umeng.a.a.a.b.k.a(paramh, localc.b);
                            }
                        }
                    }
                }
            }
            if (!paramq.i()) {
                throw new i("Required field 'lng' was not found in serialized data! Struct: " + toString());
            }
            if (!paramq.l()) {
                throw new i("Required field 'ts' was not found in serialized data! Struct: " + toString());
            }
            paramq.m();
        }

        public void b(h paramh, q paramq)
                throws j {
            paramq.m();
            paramh.a(q.n());
            paramh.a(q.o());
            paramh.a(paramq.a);
            paramh.c();
            paramh.a(q.p());
            paramh.a(paramq.b);
            paramh.c();
            paramh.a(q.q());
            paramh.a(paramq.c);
            paramh.c();
            paramh.d();
            paramh.b();
        }
    }

    private static class b
            implements com.umeng.a.a.a.c.b {
        public q.a a() {
            return new q.a(null);
        }
    }

    private static class c
            extends com.umeng.a.a.a.c.d<q> {
        public void a(h paramh, q paramq)
                throws j {
            paramh = (n) paramh;
            paramh.a(paramq.a);
            paramh.a(paramq.b);
            paramh.a(paramq.c);
        }

        public void b(h paramh, q paramq)
                throws j {
            paramh = (n) paramh;
            paramq.a = paramh.y();
            paramq.a(true);
            paramq.b = paramh.y();
            paramq.b(true);
            paramq.c = paramh.x();
            paramq.c(true);
        }
    }

    private static class d
            implements com.umeng.a.a.a.c.b {
        public q.c a() {
            return new q.c(null);
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


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/umeng/analytics/d/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */