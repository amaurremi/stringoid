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

public class u
        implements com.umeng.a.a.a.d<u, e>, Serializable, Cloneable {
    public static final Map<e, com.umeng.a.a.a.a.b> c;
    private static final m d = new m("Resolution");
    private static final com.umeng.a.a.a.b.c e = new com.umeng.a.a.a.b.c("height", (byte) 8, (short) 1);
    private static final com.umeng.a.a.a.b.c f = new com.umeng.a.a.a.b.c("width", (byte) 8, (short) 2);
    private static final Map<Class<? extends com.umeng.a.a.a.c.a>, com.umeng.a.a.a.c.b> g = new HashMap();
    private static final int h = 0;
    private static final int i = 1;
    public int a;
    public int b;
    private byte j = 0;

    static {
        g.put(com.umeng.a.a.a.c.c.class, new b(null));
        g.put(com.umeng.a.a.a.c.d.class, new d(null));
        EnumMap localEnumMap = new EnumMap(e.class);
        localEnumMap.put(e.a, new com.umeng.a.a.a.a.b("height", (byte) 1, new com.umeng.a.a.a.a.c((byte) 8)));
        localEnumMap.put(e.b, new com.umeng.a.a.a.a.b("width", (byte) 1, new com.umeng.a.a.a.a.c((byte) 8)));
        c = Collections.unmodifiableMap(localEnumMap);
        com.umeng.a.a.a.a.b.a(u.class, c);
    }

    public u() {
    }

    public u(int paramInt1, int paramInt2) {
        this();
        this.a = paramInt1;
        a(true);
        this.b = paramInt2;
        b(true);
    }

    public u(u paramu) {
        this.j = paramu.j;
        this.a = paramu.a;
        this.b = paramu.b;
    }

    private void a(ObjectInputStream paramObjectInputStream)
            throws IOException, ClassNotFoundException {
        try {
            this.j = 0;
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

    public u a() {
        return new u(this);
    }

    public u a(int paramInt) {
        this.a = paramInt;
        a(true);
        return this;
    }

    public void a(h paramh)
            throws j {
        ((com.umeng.a.a.a.c.b) g.get(paramh.D())).b().b(paramh, this);
    }

    public void a(boolean paramBoolean) {
        this.j = com.umeng.a.a.a.a.a(this.j, 0, paramBoolean);
    }

    public void b() {
        a(false);
        this.a = 0;
        b(false);
        this.b = 0;
    }

    public void b(h paramh)
            throws j {
        ((com.umeng.a.a.a.c.b) g.get(paramh.D())).b().a(paramh, this);
    }

    public void b(boolean paramBoolean) {
        this.j = com.umeng.a.a.a.a.a(this.j, 1, paramBoolean);
    }

    public int c() {
        return this.a;
    }

    public u c(int paramInt) {
        this.b = paramInt;
        b(true);
        return this;
    }

    public e d(int paramInt) {
        return e.a(paramInt);
    }

    public void d() {
        this.j = com.umeng.a.a.a.a.b(this.j, 0);
    }

    public boolean e() {
        return com.umeng.a.a.a.a.a(this.j, 0);
    }

    public int f() {
        return this.b;
    }

    public void h() {
        this.j = com.umeng.a.a.a.a.b(this.j, 1);
    }

    public boolean i() {
        return com.umeng.a.a.a.a.a(this.j, 1);
    }

    public void j()
            throws j {
    }

    public String toString() {
        StringBuilder localStringBuilder = new StringBuilder("Resolution(");
        localStringBuilder.append("height:");
        localStringBuilder.append(this.a);
        localStringBuilder.append(", ");
        localStringBuilder.append("width:");
        localStringBuilder.append(this.b);
        localStringBuilder.append(")");
        return localStringBuilder.toString();
    }

    private static class a
            extends com.umeng.a.a.a.c.c<u> {
        public void a(h paramh, u paramu)
                throws j {
            paramh.j();
            com.umeng.a.a.a.b.c localc = paramh.l();
            if (localc.b == 0) {
                paramh.k();
                if (!paramu.e()) {
                    throw new i("Required field 'height' was not found in serialized data! Struct: " + toString());
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
                        paramu.a = paramh.w();
                        paramu.a(true);
                    } else {
                        com.umeng.a.a.a.b.k.a(paramh, localc.b);
                        continue;
                        if (localc.b == 8) {
                            paramu.b = paramh.w();
                            paramu.b(true);
                        } else {
                            com.umeng.a.a.a.b.k.a(paramh, localc.b);
                        }
                    }
                }
            }
            if (!paramu.i()) {
                throw new i("Required field 'width' was not found in serialized data! Struct: " + toString());
            }
            paramu.j();
        }

        public void b(h paramh, u paramu)
                throws j {
            paramu.j();
            paramh.a(u.k());
            paramh.a(u.l());
            paramh.a(paramu.a);
            paramh.c();
            paramh.a(u.m());
            paramh.a(paramu.b);
            paramh.c();
            paramh.d();
            paramh.b();
        }
    }

    private static class b
            implements com.umeng.a.a.a.c.b {
        public u.a a() {
            return new u.a(null);
        }
    }

    private static class c
            extends com.umeng.a.a.a.c.d<u> {
        public void a(h paramh, u paramu)
                throws j {
            paramh = (n) paramh;
            paramh.a(paramu.a);
            paramh.a(paramu.b);
        }

        public void b(h paramh, u paramu)
                throws j {
            paramh = (n) paramh;
            paramu.a = paramh.w();
            paramu.a(true);
            paramu.b = paramh.w();
            paramu.b(true);
        }
    }

    private static class d
            implements com.umeng.a.a.a.c.b {
        public u.c a() {
            return new u.c(null);
        }
    }

    public static enum e
            implements com.umeng.a.a.a.k {
        private static final Map<String, e> c;
        private final short d;
        private final String e;

        static {
            c = new HashMap();
            Iterator localIterator = EnumSet.allOf(e.class).iterator();
            while (localIterator.hasNext()) {
                e locale = (e) localIterator.next();
                c.put(locale.b(), locale);
            }
        }

        private e(short paramShort, String paramString) {
            this.d = paramShort;
            this.e = paramString;
        }

        public static e a(int paramInt) {
            switch (paramInt) {
                default:
                    return null;
                case 1:
                    return a;
            }
            return b;
        }

        public static e a(String paramString) {
            return (e) c.get(paramString);
        }

        public static e b(int paramInt) {
            e locale = a(paramInt);
            if (locale == null) {
                throw new IllegalArgumentException("Field " + paramInt + " doesn't exist!");
            }
            return locale;
        }

        public short a() {
            return this.d;
        }

        public String b() {
            return this.e;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/umeng/analytics/d/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */