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

public class s
        implements com.umeng.a.a.a.d<s, e>, Serializable, Cloneable {
    public static final Map<e, com.umeng.a.a.a.a.b> c;
    private static final m d = new m("Page");
    private static final com.umeng.a.a.a.b.c e = new com.umeng.a.a.a.b.c("page_name", (byte) 11, (short) 1);
    private static final com.umeng.a.a.a.b.c f = new com.umeng.a.a.a.b.c("duration", (byte) 10, (short) 2);
    private static final Map<Class<? extends com.umeng.a.a.a.c.a>, com.umeng.a.a.a.c.b> g = new HashMap();
    private static final int h = 0;
    public String a;
    public long b;
    private byte i = 0;

    static {
        g.put(com.umeng.a.a.a.c.c.class, new b(null));
        g.put(com.umeng.a.a.a.c.d.class, new d(null));
        EnumMap localEnumMap = new EnumMap(e.class);
        localEnumMap.put(e.a, new com.umeng.a.a.a.a.b("page_name", (byte) 1, new com.umeng.a.a.a.a.c((byte) 11)));
        localEnumMap.put(e.b, new com.umeng.a.a.a.a.b("duration", (byte) 1, new com.umeng.a.a.a.a.c((byte) 10)));
        c = Collections.unmodifiableMap(localEnumMap);
        com.umeng.a.a.a.a.b.a(s.class, c);
    }

    public s() {
    }

    public s(s params) {
        this.i = params.i;
        if (params.e()) {
            this.a = params.a;
        }
        this.b = params.b;
    }

    public s(String paramString, long paramLong) {
        this();
        this.a = paramString;
        this.b = paramLong;
        b(true);
    }

    private void a(ObjectInputStream paramObjectInputStream)
            throws IOException, ClassNotFoundException {
        try {
            this.i = 0;
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

    public s a() {
        return new s(this);
    }

    public s a(long paramLong) {
        this.b = paramLong;
        b(true);
        return this;
    }

    public s a(String paramString) {
        this.a = paramString;
        return this;
    }

    public void a(h paramh)
            throws j {
        ((com.umeng.a.a.a.c.b) g.get(paramh.D())).b().b(paramh, this);
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
    }

    public void b(h paramh)
            throws j {
        ((com.umeng.a.a.a.c.b) g.get(paramh.D())).b().a(paramh, this);
    }

    public void b(boolean paramBoolean) {
        this.i = com.umeng.a.a.a.a.a(this.i, 0, paramBoolean);
    }

    public String c() {
        return this.a;
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
        this.i = com.umeng.a.a.a.a.b(this.i, 0);
    }

    public boolean i() {
        return com.umeng.a.a.a.a.a(this.i, 0);
    }

    public void j()
            throws j {
        if (this.a == null) {
            throw new i("Required field 'page_name' was not present! Struct: " + toString());
        }
    }

    public String toString() {
        StringBuilder localStringBuilder = new StringBuilder("Page(");
        localStringBuilder.append("page_name:");
        if (this.a == null) {
            localStringBuilder.append("null");
        }
        for (; ; ) {
            localStringBuilder.append(", ");
            localStringBuilder.append("duration:");
            localStringBuilder.append(this.b);
            localStringBuilder.append(")");
            return localStringBuilder.toString();
            localStringBuilder.append(this.a);
        }
    }

    private static class a
            extends com.umeng.a.a.a.c.c<s> {
        public void a(h paramh, s params)
                throws j {
            paramh.j();
            com.umeng.a.a.a.b.c localc = paramh.l();
            if (localc.b == 0) {
                paramh.k();
                if (!params.i()) {
                    throw new i("Required field 'duration' was not found in serialized data! Struct: " + toString());
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
                        params.a = paramh.z();
                        params.a(true);
                    } else {
                        com.umeng.a.a.a.b.k.a(paramh, localc.b);
                        continue;
                        if (localc.b == 10) {
                            params.b = paramh.x();
                            params.b(true);
                        } else {
                            com.umeng.a.a.a.b.k.a(paramh, localc.b);
                        }
                    }
                }
            }
            params.j();
        }

        public void b(h paramh, s params)
                throws j {
            params.j();
            paramh.a(s.k());
            if (params.a != null) {
                paramh.a(s.l());
                paramh.a(params.a);
                paramh.c();
            }
            paramh.a(s.m());
            paramh.a(params.b);
            paramh.c();
            paramh.d();
            paramh.b();
        }
    }

    private static class b
            implements com.umeng.a.a.a.c.b {
        public s.a a() {
            return new s.a(null);
        }
    }

    private static class c
            extends com.umeng.a.a.a.c.d<s> {
        public void a(h paramh, s params)
                throws j {
            paramh = (n) paramh;
            paramh.a(params.a);
            paramh.a(params.b);
        }

        public void b(h paramh, s params)
                throws j {
            paramh = (n) paramh;
            params.a = paramh.z();
            params.a(true);
            params.b = paramh.x();
            params.b(true);
        }
    }

    private static class d
            implements com.umeng.a.a.a.c.b {
        public s.c a() {
            return new s.c(null);
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


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/umeng/analytics/d/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */