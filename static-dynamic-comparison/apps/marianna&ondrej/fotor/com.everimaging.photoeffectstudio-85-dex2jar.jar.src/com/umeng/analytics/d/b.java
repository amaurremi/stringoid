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

public class b
        implements com.umeng.a.a.a.d<b, e>, Serializable, Cloneable {
    public static final Map<e, com.umeng.a.a.a.a.b> b;
    private static final m c = new m("ActivateMsg");
    private static final com.umeng.a.a.a.b.c d = new com.umeng.a.a.a.b.c("ts", (byte) 10, (short) 1);
    private static final Map<Class<? extends com.umeng.a.a.a.c.a>, com.umeng.a.a.a.c.b> e = new HashMap();
    private static final int f = 0;
    public long a;
    private byte g = 0;

    static {
        e.put(com.umeng.a.a.a.c.c.class, new b(null));
        e.put(com.umeng.a.a.a.c.d.class, new d(null));
        EnumMap localEnumMap = new EnumMap(e.class);
        localEnumMap.put(e.a, new com.umeng.a.a.a.a.b("ts", (byte) 1, new com.umeng.a.a.a.a.c((byte) 10)));
        b = Collections.unmodifiableMap(localEnumMap);
        com.umeng.a.a.a.a.b.a(b.class, b);
    }

    public b() {
    }

    public b(long paramLong) {
        this();
        this.a = paramLong;
        a(true);
    }

    public b(b paramb) {
        this.g = paramb.g;
        this.a = paramb.a;
    }

    private void a(ObjectInputStream paramObjectInputStream)
            throws IOException, ClassNotFoundException {
        try {
            this.g = 0;
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

    public b a() {
        return new b(this);
    }

    public b a(long paramLong) {
        this.a = paramLong;
        a(true);
        return this;
    }

    public void a(h paramh)
            throws j {
        ((com.umeng.a.a.a.c.b) e.get(paramh.D())).b().b(paramh, this);
    }

    public void a(boolean paramBoolean) {
        this.g = com.umeng.a.a.a.a.a(this.g, 0, paramBoolean);
    }

    public void b() {
        a(false);
        this.a = 0L;
    }

    public void b(h paramh)
            throws j {
        ((com.umeng.a.a.a.c.b) e.get(paramh.D())).b().a(paramh, this);
    }

    public long c() {
        return this.a;
    }

    public void d() {
        this.g = com.umeng.a.a.a.a.b(this.g, 0);
    }

    public boolean e() {
        return com.umeng.a.a.a.a.a(this.g, 0);
    }

    public void f()
            throws j {
    }

    public String toString() {
        StringBuilder localStringBuilder = new StringBuilder("ActivateMsg(");
        localStringBuilder.append("ts:");
        localStringBuilder.append(this.a);
        localStringBuilder.append(")");
        return localStringBuilder.toString();
    }

    private static class a
            extends com.umeng.a.a.a.c.c<b> {
        public void a(h paramh, b paramb)
                throws j {
            paramh.j();
            com.umeng.a.a.a.b.c localc = paramh.l();
            if (localc.b == 0) {
                paramh.k();
                if (!paramb.e()) {
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
                        paramb.a = paramh.x();
                        paramb.a(true);
                    } else {
                        com.umeng.a.a.a.b.k.a(paramh, localc.b);
                    }
                }
            }
            paramb.f();
        }

        public void b(h paramh, b paramb)
                throws j {
            paramb.f();
            paramh.a(b.h());
            paramh.a(b.i());
            paramh.a(paramb.a);
            paramh.c();
            paramh.d();
            paramh.b();
        }
    }

    private static class b
            implements com.umeng.a.a.a.c.b {
        public b.a a() {
            return new b.a(null);
        }
    }

    private static class c
            extends com.umeng.a.a.a.c.d<b> {
        public void a(h paramh, b paramb)
                throws j {
            ((n) paramh).a(paramb.a);
        }

        public void b(h paramh, b paramb)
                throws j {
            paramb.a = ((n) paramh).x();
            paramb.a(true);
        }
    }

    private static class d
            implements com.umeng.a.a.a.c.b {
        public b.c a() {
            return new b.c(null);
        }
    }

    public static enum e
            implements com.umeng.a.a.a.k {
        private static final Map<String, e> b;
        private final short c;
        private final String d;

        static {
            b = new HashMap();
            Iterator localIterator = EnumSet.allOf(e.class).iterator();
            while (localIterator.hasNext()) {
                e locale = (e) localIterator.next();
                b.put(locale.b(), locale);
            }
        }

        private e(short paramShort, String paramString) {
            this.c = paramShort;
            this.d = paramString;
        }

        public static e a(int paramInt) {
            switch (paramInt) {
                default:
                    return null;
            }
            return a;
        }

        public static e a(String paramString) {
            return (e) b.get(paramString);
        }

        public static e b(int paramInt) {
            e locale = a(paramInt);
            if (locale == null) {
                throw new IllegalArgumentException("Field " + paramInt + " doesn't exist!");
            }
            return locale;
        }

        public short a() {
            return this.c;
        }

        public String b() {
            return this.d;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/umeng/analytics/d/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */