package com.umeng.analytics.d;

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

public class g
        implements com.umeng.a.a.a.d<g, e>, Serializable, Cloneable {
    public static final Map<e, com.umeng.a.a.a.a.b> d;
    private static final m e = new m("Error");
    private static final com.umeng.a.a.a.b.c f = new com.umeng.a.a.a.b.c("ts", (byte) 10, (short) 1);
    private static final com.umeng.a.a.a.b.c g = new com.umeng.a.a.a.b.c("context", (byte) 11, (short) 2);
    private static final com.umeng.a.a.a.b.c h = new com.umeng.a.a.a.b.c("source", (byte) 8, (short) 3);
    private static final Map<Class<? extends com.umeng.a.a.a.c.a>, com.umeng.a.a.a.c.b> i = new HashMap();
    private static final int j = 0;
    public long a;
    public String b;
    public h c;
    private byte k = 0;
    private e[] l = {e.c};

    static {
        i.put(com.umeng.a.a.a.c.c.class, new b(null));
        i.put(com.umeng.a.a.a.c.d.class, new d(null));
        EnumMap localEnumMap = new EnumMap(e.class);
        localEnumMap.put(e.a, new com.umeng.a.a.a.a.b("ts", (byte) 1, new com.umeng.a.a.a.a.c((byte) 10)));
        localEnumMap.put(e.b, new com.umeng.a.a.a.a.b("context", (byte) 1, new com.umeng.a.a.a.a.c((byte) 11)));
        localEnumMap.put(e.c, new com.umeng.a.a.a.a.b("source", (byte) 2, new com.umeng.a.a.a.a.a((byte) 16, h.class)));
        d = Collections.unmodifiableMap(localEnumMap);
        com.umeng.a.a.a.a.b.a(g.class, d);
    }

    public g() {
    }

    public g(long paramLong, String paramString) {
        this();
        this.a = paramLong;
        b(true);
        this.b = paramString;
    }

    public g(g paramg) {
        this.k = paramg.k;
        this.a = paramg.a;
        if (paramg.i()) {
            this.b = paramg.b;
        }
        if (paramg.l()) {
            this.c = paramg.c;
        }
    }

    private void a(ObjectInputStream paramObjectInputStream)
            throws IOException, ClassNotFoundException {
        try {
            this.k = 0;
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

    public g a() {
        return new g(this);
    }

    public g a(long paramLong) {
        this.a = paramLong;
        b(true);
        return this;
    }

    public g a(h paramh) {
        this.c = paramh;
        return this;
    }

    public g a(String paramString) {
        this.b = paramString;
        return this;
    }

    public void a(com.umeng.a.a.a.b.h paramh)
            throws j {
        ((com.umeng.a.a.a.c.b) i.get(paramh.D())).b().b(paramh, this);
    }

    public void b() {
        b(false);
        this.a = 0L;
        this.b = null;
        this.c = null;
    }

    public void b(com.umeng.a.a.a.b.h paramh)
            throws j {
        ((com.umeng.a.a.a.c.b) i.get(paramh.D())).b().a(paramh, this);
    }

    public void b(boolean paramBoolean) {
        this.k = com.umeng.a.a.a.a.a(this.k, 0, paramBoolean);
    }

    public long c() {
        return this.a;
    }

    public void c(boolean paramBoolean) {
        if (!paramBoolean) {
            this.b = null;
        }
    }

    public void d() {
        this.k = com.umeng.a.a.a.a.b(this.k, 0);
    }

    public void d(boolean paramBoolean) {
        if (!paramBoolean) {
            this.c = null;
        }
    }

    public boolean e() {
        return com.umeng.a.a.a.a.a(this.k, 0);
    }

    public String f() {
        return this.b;
    }

    public void h() {
        this.b = null;
    }

    public boolean i() {
        return this.b != null;
    }

    public h j() {
        return this.c;
    }

    public void k() {
        this.c = null;
    }

    public boolean l() {
        return this.c != null;
    }

    public void m()
            throws j {
        if (this.b == null) {
            throw new i("Required field 'context' was not present! Struct: " + toString());
        }
    }

    public String toString() {
        StringBuilder localStringBuilder = new StringBuilder("Error(");
        localStringBuilder.append("ts:");
        localStringBuilder.append(this.a);
        localStringBuilder.append(", ");
        localStringBuilder.append("context:");
        if (this.b == null) {
            localStringBuilder.append("null");
            if (l()) {
                localStringBuilder.append(", ");
                localStringBuilder.append("source:");
                if (this.c != null) {
                    break label122;
                }
                localStringBuilder.append("null");
            }
        }
        for (; ; ) {
            localStringBuilder.append(")");
            return localStringBuilder.toString();
            localStringBuilder.append(this.b);
            break;
            label122:
            localStringBuilder.append(this.c);
        }
    }

    private static class a
            extends com.umeng.a.a.a.c.c<g> {
        public void a(com.umeng.a.a.a.b.h paramh, g paramg)
                throws j {
            paramh.j();
            com.umeng.a.a.a.b.c localc = paramh.l();
            if (localc.b == 0) {
                paramh.k();
                if (!paramg.e()) {
                    throw new i("Required field 'ts' was not found in serialized data! Struct: " + toString());
                }
            } else {
                switch (localc.c) {
                    default:
                        com.umeng.a.a.a.b.k.a(paramh, localc.b);
                }
                for (; ; ) {
                    paramh.m();
                    break;
                    if (localc.b == 10) {
                        paramg.a = paramh.x();
                        paramg.b(true);
                    } else {
                        com.umeng.a.a.a.b.k.a(paramh, localc.b);
                        continue;
                        if (localc.b == 11) {
                            paramg.b = paramh.z();
                            paramg.c(true);
                        } else {
                            com.umeng.a.a.a.b.k.a(paramh, localc.b);
                            continue;
                            if (localc.b == 8) {
                                paramg.c = h.a(paramh.w());
                                paramg.d(true);
                            } else {
                                com.umeng.a.a.a.b.k.a(paramh, localc.b);
                            }
                        }
                    }
                }
            }
            paramg.m();
        }

        public void b(com.umeng.a.a.a.b.h paramh, g paramg)
                throws j {
            paramg.m();
            paramh.a(g.n());
            paramh.a(g.o());
            paramh.a(paramg.a);
            paramh.c();
            if (paramg.b != null) {
                paramh.a(g.p());
                paramh.a(paramg.b);
                paramh.c();
            }
            if ((paramg.c != null) && (paramg.l())) {
                paramh.a(g.q());
                paramh.a(paramg.c.a());
                paramh.c();
            }
            paramh.d();
            paramh.b();
        }
    }

    private static class b
            implements com.umeng.a.a.a.c.b {
        public g.a a() {
            return new g.a(null);
        }
    }

    private static class c
            extends com.umeng.a.a.a.c.d<g> {
        public void a(com.umeng.a.a.a.b.h paramh, g paramg)
                throws j {
            paramh = (n) paramh;
            paramh.a(paramg.a);
            paramh.a(paramg.b);
            BitSet localBitSet = new BitSet();
            if (paramg.l()) {
                localBitSet.set(0);
            }
            paramh.a(localBitSet, 1);
            if (paramg.l()) {
                paramh.a(paramg.c.a());
            }
        }

        public void b(com.umeng.a.a.a.b.h paramh, g paramg)
                throws j {
            paramh = (n) paramh;
            paramg.a = paramh.x();
            paramg.b(true);
            paramg.b = paramh.z();
            paramg.c(true);
            if (paramh.b(1).get(0)) {
                paramg.c = h.a(paramh.w());
                paramg.d(true);
            }
        }
    }

    private static class d
            implements com.umeng.a.a.a.c.b {
        public g.c a() {
            return new g.c(null);
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


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/umeng/analytics/d/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */