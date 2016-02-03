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

public class l
        implements com.umeng.a.a.a.d<l, e>, Serializable, Cloneable {
    public static final Map<e, com.umeng.a.a.a.a.b> d;
    private static final m e = new m("IdSnapshot");
    private static final com.umeng.a.a.a.b.c f = new com.umeng.a.a.a.b.c("identity", (byte) 11, (short) 1);
    private static final com.umeng.a.a.a.b.c g = new com.umeng.a.a.a.b.c("ts", (byte) 10, (short) 2);
    private static final com.umeng.a.a.a.b.c h = new com.umeng.a.a.a.b.c("version", (byte) 8, (short) 3);
    private static final Map<Class<? extends com.umeng.a.a.a.c.a>, com.umeng.a.a.a.c.b> i = new HashMap();
    private static final int j = 0;
    private static final int k = 1;
    public String a;
    public long b;
    public int c;
    private byte l = 0;

    static {
        i.put(com.umeng.a.a.a.c.c.class, new b(null));
        i.put(com.umeng.a.a.a.c.d.class, new d(null));
        EnumMap localEnumMap = new EnumMap(e.class);
        localEnumMap.put(e.a, new com.umeng.a.a.a.a.b("identity", (byte) 1, new com.umeng.a.a.a.a.c((byte) 11)));
        localEnumMap.put(e.b, new com.umeng.a.a.a.a.b("ts", (byte) 1, new com.umeng.a.a.a.a.c((byte) 10)));
        localEnumMap.put(e.c, new com.umeng.a.a.a.a.b("version", (byte) 1, new com.umeng.a.a.a.a.c((byte) 8)));
        d = Collections.unmodifiableMap(localEnumMap);
        com.umeng.a.a.a.a.b.a(l.class, d);
    }

    public l() {
    }

    public l(l paraml) {
        this.l = paraml.l;
        if (paraml.e()) {
            this.a = paraml.a;
        }
        this.b = paraml.b;
        this.c = paraml.c;
    }

    public l(String paramString, long paramLong, int paramInt) {
        this();
        this.a = paramString;
        this.b = paramLong;
        b(true);
        this.c = paramInt;
        c(true);
    }

    private void a(ObjectInputStream paramObjectInputStream)
            throws IOException, ClassNotFoundException {
        try {
            this.l = 0;
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

    public l a() {
        return new l(this);
    }

    public l a(int paramInt) {
        this.c = paramInt;
        c(true);
        return this;
    }

    public l a(long paramLong) {
        this.b = paramLong;
        b(true);
        return this;
    }

    public l a(String paramString) {
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

    public void b() {
        this.a = null;
        b(false);
        this.b = 0L;
        c(false);
        this.c = 0;
    }

    public void b(h paramh)
            throws j {
        ((com.umeng.a.a.a.c.b) i.get(paramh.D())).b().a(paramh, this);
    }

    public void b(boolean paramBoolean) {
        this.l = com.umeng.a.a.a.a.a(this.l, 0, paramBoolean);
    }

    public e c(int paramInt) {
        return e.a(paramInt);
    }

    public String c() {
        return this.a;
    }

    public void c(boolean paramBoolean) {
        this.l = com.umeng.a.a.a.a.a(this.l, 1, paramBoolean);
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
        this.l = com.umeng.a.a.a.a.b(this.l, 0);
    }

    public boolean i() {
        return com.umeng.a.a.a.a.a(this.l, 0);
    }

    public int j() {
        return this.c;
    }

    public void k() {
        this.l = com.umeng.a.a.a.a.b(this.l, 1);
    }

    public boolean l() {
        return com.umeng.a.a.a.a.a(this.l, 1);
    }

    public void m()
            throws j {
        if (this.a == null) {
            throw new i("Required field 'identity' was not present! Struct: " + toString());
        }
    }

    public String toString() {
        StringBuilder localStringBuilder = new StringBuilder("IdSnapshot(");
        localStringBuilder.append("identity:");
        if (this.a == null) {
            localStringBuilder.append("null");
        }
        for (; ; ) {
            localStringBuilder.append(", ");
            localStringBuilder.append("ts:");
            localStringBuilder.append(this.b);
            localStringBuilder.append(", ");
            localStringBuilder.append("version:");
            localStringBuilder.append(this.c);
            localStringBuilder.append(")");
            return localStringBuilder.toString();
            localStringBuilder.append(this.a);
        }
    }

    private static class a
            extends com.umeng.a.a.a.c.c<l> {
        public void a(h paramh, l paraml)
                throws j {
            paramh.j();
            com.umeng.a.a.a.b.c localc = paramh.l();
            if (localc.b == 0) {
                paramh.k();
                if (!paraml.i()) {
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
                        paraml.a = paramh.z();
                        paraml.a(true);
                    } else {
                        com.umeng.a.a.a.b.k.a(paramh, localc.b);
                        continue;
                        if (localc.b == 10) {
                            paraml.b = paramh.x();
                            paraml.b(true);
                        } else {
                            com.umeng.a.a.a.b.k.a(paramh, localc.b);
                            continue;
                            if (localc.b == 8) {
                                paraml.c = paramh.w();
                                paraml.c(true);
                            } else {
                                com.umeng.a.a.a.b.k.a(paramh, localc.b);
                            }
                        }
                    }
                }
            }
            if (!paraml.l()) {
                throw new i("Required field 'version' was not found in serialized data! Struct: " + toString());
            }
            paraml.m();
        }

        public void b(h paramh, l paraml)
                throws j {
            paraml.m();
            paramh.a(l.n());
            if (paraml.a != null) {
                paramh.a(l.o());
                paramh.a(paraml.a);
                paramh.c();
            }
            paramh.a(l.p());
            paramh.a(paraml.b);
            paramh.c();
            paramh.a(l.q());
            paramh.a(paraml.c);
            paramh.c();
            paramh.d();
            paramh.b();
        }
    }

    private static class b
            implements com.umeng.a.a.a.c.b {
        public l.a a() {
            return new l.a(null);
        }
    }

    private static class c
            extends com.umeng.a.a.a.c.d<l> {
        public void a(h paramh, l paraml)
                throws j {
            paramh = (n) paramh;
            paramh.a(paraml.a);
            paramh.a(paraml.b);
            paramh.a(paraml.c);
        }

        public void b(h paramh, l paraml)
                throws j {
            paramh = (n) paramh;
            paraml.a = paramh.z();
            paraml.a(true);
            paraml.b = paramh.x();
            paraml.b(true);
            paraml.c = paramh.w();
            paraml.c(true);
        }
    }

    private static class d
            implements com.umeng.a.a.a.c.b {
        public l.c a() {
            return new l.c(null);
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


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/umeng/analytics/d/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */