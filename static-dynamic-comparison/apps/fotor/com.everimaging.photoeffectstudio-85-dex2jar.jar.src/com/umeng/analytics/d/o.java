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

public class o
        implements com.umeng.a.a.a.d<o, e>, Serializable, Cloneable {
    public static final Map<e, com.umeng.a.a.a.a.b> d;
    private static final m e = new m("ImprintValue");
    private static final com.umeng.a.a.a.b.c f = new com.umeng.a.a.a.b.c("value", (byte) 11, (short) 1);
    private static final com.umeng.a.a.a.b.c g = new com.umeng.a.a.a.b.c("ts", (byte) 10, (short) 2);
    private static final com.umeng.a.a.a.b.c h = new com.umeng.a.a.a.b.c("guid", (byte) 11, (short) 3);
    private static final Map<Class<? extends com.umeng.a.a.a.c.a>, com.umeng.a.a.a.c.b> i = new HashMap();
    private static final int j = 0;
    public String a;
    public long b;
    public String c;
    private byte k = 0;
    private e[] l = {e.a};

    static {
        i.put(com.umeng.a.a.a.c.c.class, new b(null));
        i.put(com.umeng.a.a.a.c.d.class, new d(null));
        EnumMap localEnumMap = new EnumMap(e.class);
        localEnumMap.put(e.a, new com.umeng.a.a.a.a.b("value", (byte) 2, new com.umeng.a.a.a.a.c((byte) 11)));
        localEnumMap.put(e.b, new com.umeng.a.a.a.a.b("ts", (byte) 1, new com.umeng.a.a.a.a.c((byte) 10)));
        localEnumMap.put(e.c, new com.umeng.a.a.a.a.b("guid", (byte) 1, new com.umeng.a.a.a.a.c((byte) 11)));
        d = Collections.unmodifiableMap(localEnumMap);
        com.umeng.a.a.a.a.b.a(o.class, d);
    }

    public o() {
    }

    public o(long paramLong, String paramString) {
        this();
        this.b = paramLong;
        b(true);
        this.c = paramString;
    }

    public o(o paramo) {
        this.k = paramo.k;
        if (paramo.e()) {
            this.a = paramo.a;
        }
        this.b = paramo.b;
        if (paramo.l()) {
            this.c = paramo.c;
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

    public o a() {
        return new o(this);
    }

    public o a(long paramLong) {
        this.b = paramLong;
        b(true);
        return this;
    }

    public o a(String paramString) {
        this.a = paramString;
        return this;
    }

    public void a(h paramh)
            throws j {
        ((com.umeng.a.a.a.c.b) i.get(paramh.D())).b().b(paramh, this);
    }

    public void a(boolean paramBoolean) {
        if (!paramBoolean) {
            this.a = null;
        }
    }

    public o b(String paramString) {
        this.c = paramString;
        return this;
    }

    public void b() {
        this.a = null;
        b(false);
        this.b = 0L;
        this.c = null;
    }

    public void b(h paramh)
            throws j {
        ((com.umeng.a.a.a.c.b) i.get(paramh.D())).b().a(paramh, this);
    }

    public void b(boolean paramBoolean) {
        this.k = com.umeng.a.a.a.a.a(this.k, 0, paramBoolean);
    }

    public String c() {
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

    public boolean e() {
        return this.a != null;
    }

    public long f() {
        return this.b;
    }

    public void h() {
        this.k = com.umeng.a.a.a.a.b(this.k, 0);
    }

    public boolean i() {
        return com.umeng.a.a.a.a.a(this.k, 0);
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

    public void m()
            throws j {
        if (this.c == null) {
            throw new i("Required field 'guid' was not present! Struct: " + toString());
        }
    }

    public String toString() {
        StringBuilder localStringBuilder = new StringBuilder("ImprintValue(");
        int m = 1;
        if (e()) {
            localStringBuilder.append("value:");
            if (this.a == null) {
                localStringBuilder.append("null");
                m = 0;
            }
        } else {
            if (m == 0) {
                localStringBuilder.append(", ");
            }
            localStringBuilder.append("ts:");
            localStringBuilder.append(this.b);
            localStringBuilder.append(", ");
            localStringBuilder.append("guid:");
            if (this.c != null) {
                break label129;
            }
            localStringBuilder.append("null");
        }
        for (; ; ) {
            localStringBuilder.append(")");
            return localStringBuilder.toString();
            localStringBuilder.append(this.a);
            break;
            label129:
            localStringBuilder.append(this.c);
        }
    }

    private static class a
            extends com.umeng.a.a.a.c.c<o> {
        public void a(h paramh, o paramo)
                throws j {
            paramh.j();
            com.umeng.a.a.a.b.c localc = paramh.l();
            if (localc.b == 0) {
                paramh.k();
                if (!paramo.i()) {
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
                    if (localc.b == 11) {
                        paramo.a = paramh.z();
                        paramo.a(true);
                    } else {
                        com.umeng.a.a.a.b.k.a(paramh, localc.b);
                        continue;
                        if (localc.b == 10) {
                            paramo.b = paramh.x();
                            paramo.b(true);
                        } else {
                            com.umeng.a.a.a.b.k.a(paramh, localc.b);
                            continue;
                            if (localc.b == 11) {
                                paramo.c = paramh.z();
                                paramo.c(true);
                            } else {
                                com.umeng.a.a.a.b.k.a(paramh, localc.b);
                            }
                        }
                    }
                }
            }
            paramo.m();
        }

        public void b(h paramh, o paramo)
                throws j {
            paramo.m();
            paramh.a(o.n());
            if ((paramo.a != null) && (paramo.e())) {
                paramh.a(o.o());
                paramh.a(paramo.a);
                paramh.c();
            }
            paramh.a(o.p());
            paramh.a(paramo.b);
            paramh.c();
            if (paramo.c != null) {
                paramh.a(o.q());
                paramh.a(paramo.c);
                paramh.c();
            }
            paramh.d();
            paramh.b();
        }
    }

    private static class b
            implements com.umeng.a.a.a.c.b {
        public o.a a() {
            return new o.a(null);
        }
    }

    private static class c
            extends com.umeng.a.a.a.c.d<o> {
        public void a(h paramh, o paramo)
                throws j {
            paramh = (n) paramh;
            paramh.a(paramo.b);
            paramh.a(paramo.c);
            BitSet localBitSet = new BitSet();
            if (paramo.e()) {
                localBitSet.set(0);
            }
            paramh.a(localBitSet, 1);
            if (paramo.e()) {
                paramh.a(paramo.a);
            }
        }

        public void b(h paramh, o paramo)
                throws j {
            paramh = (n) paramh;
            paramo.b = paramh.x();
            paramo.b(true);
            paramo.c = paramh.z();
            paramo.c(true);
            if (paramh.b(1).get(0)) {
                paramo.a = paramh.z();
                paramo.a(true);
            }
        }
    }

    private static class d
            implements com.umeng.a.a.a.c.b {
        public o.c a() {
            return new o.c(null);
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


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/umeng/analytics/d/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */