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

public class k
        implements com.umeng.a.a.a.d<k, e>, Serializable, Cloneable {
    public static final Map<e, com.umeng.a.a.a.a.b> e;
    private static final m f = new m("IdJournal");
    private static final com.umeng.a.a.a.b.c g = new com.umeng.a.a.a.b.c("domain", (byte) 11, (short) 1);
    private static final com.umeng.a.a.a.b.c h = new com.umeng.a.a.a.b.c("old_id", (byte) 11, (short) 2);
    private static final com.umeng.a.a.a.b.c i = new com.umeng.a.a.a.b.c("new_id", (byte) 11, (short) 3);
    private static final com.umeng.a.a.a.b.c j = new com.umeng.a.a.a.b.c("ts", (byte) 10, (short) 4);
    private static final Map<Class<? extends com.umeng.a.a.a.c.a>, com.umeng.a.a.a.c.b> k = new HashMap();
    private static final int l = 0;
    public String a;
    public String b;
    public String c;
    public long d;
    private byte m = 0;
    private e[] n = {e.b};

    static {
        k.put(com.umeng.a.a.a.c.c.class, new b(null));
        k.put(com.umeng.a.a.a.c.d.class, new d(null));
        EnumMap localEnumMap = new EnumMap(e.class);
        localEnumMap.put(e.a, new com.umeng.a.a.a.a.b("domain", (byte) 1, new com.umeng.a.a.a.a.c((byte) 11)));
        localEnumMap.put(e.b, new com.umeng.a.a.a.a.b("old_id", (byte) 2, new com.umeng.a.a.a.a.c((byte) 11)));
        localEnumMap.put(e.c, new com.umeng.a.a.a.a.b("new_id", (byte) 1, new com.umeng.a.a.a.a.c((byte) 11)));
        localEnumMap.put(e.d, new com.umeng.a.a.a.a.b("ts", (byte) 1, new com.umeng.a.a.a.a.c((byte) 10)));
        e = Collections.unmodifiableMap(localEnumMap);
        com.umeng.a.a.a.a.b.a(k.class, e);
    }

    public k() {
    }

    public k(k paramk) {
        this.m = paramk.m;
        if (paramk.e()) {
            this.a = paramk.a;
        }
        if (paramk.i()) {
            this.b = paramk.b;
        }
        if (paramk.l()) {
            this.c = paramk.c;
        }
        this.d = paramk.d;
    }

    public k(String paramString1, String paramString2, long paramLong) {
        this();
        this.a = paramString1;
        this.c = paramString2;
        this.d = paramLong;
        d(true);
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

    public k a() {
        return new k(this);
    }

    public k a(long paramLong) {
        this.d = paramLong;
        d(true);
        return this;
    }

    public k a(String paramString) {
        this.a = paramString;
        return this;
    }

    public void a(h paramh)
            throws j {
        ((com.umeng.a.a.a.c.b) k.get(paramh.D())).b().b(paramh, this);
    }

    public void a(boolean paramBoolean) {
        if (!paramBoolean) {
            this.a = null;
        }
    }

    public k b(String paramString) {
        this.b = paramString;
        return this;
    }

    public void b() {
        this.a = null;
        this.b = null;
        this.c = null;
        d(false);
        this.d = 0L;
    }

    public void b(h paramh)
            throws j {
        ((com.umeng.a.a.a.c.b) k.get(paramh.D())).b().a(paramh, this);
    }

    public void b(boolean paramBoolean) {
        if (!paramBoolean) {
            this.b = null;
        }
    }

    public k c(String paramString) {
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

    public void d() {
        this.a = null;
    }

    public void d(boolean paramBoolean) {
        this.m = com.umeng.a.a.a.a.a(this.m, 0, paramBoolean);
    }

    public boolean e() {
        return this.a != null;
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

    public String j() {
        return this.c;
    }

    public void k() {
        this.c = null;
    }

    public boolean l() {
        return this.c != null;
    }

    public long m() {
        return this.d;
    }

    public void n() {
        this.m = com.umeng.a.a.a.a.b(this.m, 0);
    }

    public boolean o() {
        return com.umeng.a.a.a.a.a(this.m, 0);
    }

    public void p()
            throws j {
        if (this.a == null) {
            throw new i("Required field 'domain' was not present! Struct: " + toString());
        }
        if (this.c == null) {
            throw new i("Required field 'new_id' was not present! Struct: " + toString());
        }
    }

    public String toString() {
        StringBuilder localStringBuilder = new StringBuilder("IdJournal(");
        localStringBuilder.append("domain:");
        if (this.a == null) {
            localStringBuilder.append("null");
            if (i()) {
                localStringBuilder.append(", ");
                localStringBuilder.append("old_id:");
                if (this.b != null) {
                    break label153;
                }
                localStringBuilder.append("null");
            }
            label72:
            localStringBuilder.append(", ");
            localStringBuilder.append("new_id:");
            if (this.c != null) {
                break label165;
            }
            localStringBuilder.append("null");
        }
        for (; ; ) {
            localStringBuilder.append(", ");
            localStringBuilder.append("ts:");
            localStringBuilder.append(this.d);
            localStringBuilder.append(")");
            return localStringBuilder.toString();
            localStringBuilder.append(this.a);
            break;
            label153:
            localStringBuilder.append(this.b);
            break label72;
            label165:
            localStringBuilder.append(this.c);
        }
    }

    private static class a
            extends com.umeng.a.a.a.c.c<k> {
        public void a(h paramh, k paramk)
                throws j {
            paramh.j();
            com.umeng.a.a.a.b.c localc = paramh.l();
            if (localc.b == 0) {
                paramh.k();
                if (!paramk.o()) {
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
                        paramk.a = paramh.z();
                        paramk.a(true);
                    } else {
                        com.umeng.a.a.a.b.k.a(paramh, localc.b);
                        continue;
                        if (localc.b == 11) {
                            paramk.b = paramh.z();
                            paramk.b(true);
                        } else {
                            com.umeng.a.a.a.b.k.a(paramh, localc.b);
                            continue;
                            if (localc.b == 11) {
                                paramk.c = paramh.z();
                                paramk.c(true);
                            } else {
                                com.umeng.a.a.a.b.k.a(paramh, localc.b);
                                continue;
                                if (localc.b == 10) {
                                    paramk.d = paramh.x();
                                    paramk.d(true);
                                } else {
                                    com.umeng.a.a.a.b.k.a(paramh, localc.b);
                                }
                            }
                        }
                    }
                }
            }
            paramk.p();
        }

        public void b(h paramh, k paramk)
                throws j {
            paramk.p();
            paramh.a(k.q());
            if (paramk.a != null) {
                paramh.a(k.r());
                paramh.a(paramk.a);
                paramh.c();
            }
            if ((paramk.b != null) && (paramk.i())) {
                paramh.a(k.s());
                paramh.a(paramk.b);
                paramh.c();
            }
            if (paramk.c != null) {
                paramh.a(k.t());
                paramh.a(paramk.c);
                paramh.c();
            }
            paramh.a(k.u());
            paramh.a(paramk.d);
            paramh.c();
            paramh.d();
            paramh.b();
        }
    }

    private static class b
            implements com.umeng.a.a.a.c.b {
        public k.a a() {
            return new k.a(null);
        }
    }

    private static class c
            extends com.umeng.a.a.a.c.d<k> {
        public void a(h paramh, k paramk)
                throws j {
            paramh = (n) paramh;
            paramh.a(paramk.a);
            paramh.a(paramk.c);
            paramh.a(paramk.d);
            BitSet localBitSet = new BitSet();
            if (paramk.i()) {
                localBitSet.set(0);
            }
            paramh.a(localBitSet, 1);
            if (paramk.i()) {
                paramh.a(paramk.b);
            }
        }

        public void b(h paramh, k paramk)
                throws j {
            paramh = (n) paramh;
            paramk.a = paramh.z();
            paramk.a(true);
            paramk.c = paramh.z();
            paramk.c(true);
            paramk.d = paramh.x();
            paramk.d(true);
            if (paramh.b(1).get(0)) {
                paramk.b = paramh.z();
                paramk.b(true);
            }
        }
    }

    private static class d
            implements com.umeng.a.a.a.c.b {
        public k.c a() {
            return new k.c(null);
        }
    }

    public static enum e
            implements com.umeng.a.a.a.k {
        private static final Map<String, e> e;
        private final short f;
        private final String g;

        static {
            e = new HashMap();
            Iterator localIterator = EnumSet.allOf(e.class).iterator();
            while (localIterator.hasNext()) {
                e locale = (e) localIterator.next();
                e.put(locale.b(), locale);
            }
        }

        private e(short paramShort, String paramString) {
            this.f = paramShort;
            this.g = paramString;
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
            }
            return d;
        }

        public static e a(String paramString) {
            return (e) e.get(paramString);
        }

        public static e b(int paramInt) {
            e locale = a(paramInt);
            if (locale == null) {
                throw new IllegalArgumentException("Field " + paramInt + " doesn't exist!");
            }
            return locale;
        }

        public short a() {
            return this.f;
        }

        public String b() {
            return this.g;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/umeng/analytics/d/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */