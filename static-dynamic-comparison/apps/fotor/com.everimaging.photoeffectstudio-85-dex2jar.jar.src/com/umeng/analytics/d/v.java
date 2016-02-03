package com.umeng.analytics.d;

import com.umeng.a.a.a.a.g;
import com.umeng.a.a.a.b.h;
import com.umeng.a.a.a.b.i;
import com.umeng.a.a.a.b.m;
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

public class v
        implements com.umeng.a.a.a.d<v, e>, Serializable, Cloneable {
    public static final Map<e, com.umeng.a.a.a.a.b> d;
    private static final m e = new m("Response");
    private static final com.umeng.a.a.a.b.c f = new com.umeng.a.a.a.b.c("resp_code", (byte) 8, (short) 1);
    private static final com.umeng.a.a.a.b.c g = new com.umeng.a.a.a.b.c("msg", (byte) 11, (short) 2);
    private static final com.umeng.a.a.a.b.c h = new com.umeng.a.a.a.b.c("imprint", (byte) 12, (short) 3);
    private static final Map<Class<? extends com.umeng.a.a.a.c.a>, com.umeng.a.a.a.c.b> i = new HashMap();
    private static final int j = 0;
    public int a;
    public String b;
    public n c;
    private byte k = 0;
    private e[] l = {e.b, e.c};

    static {
        i.put(com.umeng.a.a.a.c.c.class, new b(null));
        i.put(com.umeng.a.a.a.c.d.class, new d(null));
        EnumMap localEnumMap = new EnumMap(e.class);
        localEnumMap.put(e.a, new com.umeng.a.a.a.a.b("resp_code", (byte) 1, new com.umeng.a.a.a.a.c((byte) 8)));
        localEnumMap.put(e.b, new com.umeng.a.a.a.a.b("msg", (byte) 2, new com.umeng.a.a.a.a.c((byte) 11)));
        localEnumMap.put(e.c, new com.umeng.a.a.a.a.b("imprint", (byte) 2, new g((byte) 12, n.class)));
        d = Collections.unmodifiableMap(localEnumMap);
        com.umeng.a.a.a.a.b.a(v.class, d);
    }

    public v() {
    }

    public v(int paramInt) {
        this();
        this.a = paramInt;
        a(true);
    }

    public v(v paramv) {
        this.k = paramv.k;
        this.a = paramv.a;
        if (paramv.i()) {
            this.b = paramv.b;
        }
        if (paramv.l()) {
            this.c = new n(paramv.c);
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

    public v a() {
        return new v(this);
    }

    public v a(int paramInt) {
        this.a = paramInt;
        a(true);
        return this;
    }

    public v a(n paramn) {
        this.c = paramn;
        return this;
    }

    public v a(String paramString) {
        this.b = paramString;
        return this;
    }

    public void a(h paramh)
            throws j {
        ((com.umeng.a.a.a.c.b) i.get(paramh.D())).b().b(paramh, this);
    }

    public void a(boolean paramBoolean) {
        this.k = com.umeng.a.a.a.a.a(this.k, 0, paramBoolean);
    }

    public void b() {
        a(false);
        this.a = 0;
        this.b = null;
        this.c = null;
    }

    public void b(h paramh)
            throws j {
        ((com.umeng.a.a.a.c.b) i.get(paramh.D())).b().a(paramh, this);
    }

    public void b(boolean paramBoolean) {
        if (!paramBoolean) {
            this.b = null;
        }
    }

    public int c() {
        return this.a;
    }

    public e c(int paramInt) {
        return e.a(paramInt);
    }

    public void c(boolean paramBoolean) {
        if (!paramBoolean) {
            this.c = null;
        }
    }

    public void d() {
        this.k = com.umeng.a.a.a.a.b(this.k, 0);
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

    public n j() {
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
        if (this.c != null) {
            this.c.n();
        }
    }

    public String toString() {
        StringBuilder localStringBuilder = new StringBuilder("Response(");
        localStringBuilder.append("resp_code:");
        localStringBuilder.append(this.a);
        if (i()) {
            localStringBuilder.append(", ");
            localStringBuilder.append("msg:");
            if (this.b == null) {
                localStringBuilder.append("null");
            }
        } else if (l()) {
            localStringBuilder.append(", ");
            localStringBuilder.append("imprint:");
            if (this.c != null) {
                break label129;
            }
            localStringBuilder.append("null");
        }
        for (; ; ) {
            localStringBuilder.append(")");
            return localStringBuilder.toString();
            localStringBuilder.append(this.b);
            break;
            label129:
            localStringBuilder.append(this.c);
        }
    }

    private static class a
            extends com.umeng.a.a.a.c.c<v> {
        public void a(h paramh, v paramv)
                throws j {
            paramh.j();
            com.umeng.a.a.a.b.c localc = paramh.l();
            if (localc.b == 0) {
                paramh.k();
                if (!paramv.e()) {
                    throw new i("Required field 'resp_code' was not found in serialized data! Struct: " + toString());
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
                        paramv.a = paramh.w();
                        paramv.a(true);
                    } else {
                        com.umeng.a.a.a.b.k.a(paramh, localc.b);
                        continue;
                        if (localc.b == 11) {
                            paramv.b = paramh.z();
                            paramv.b(true);
                        } else {
                            com.umeng.a.a.a.b.k.a(paramh, localc.b);
                            continue;
                            if (localc.b == 12) {
                                paramv.c = new n();
                                paramv.c.a(paramh);
                                paramv.c(true);
                            } else {
                                com.umeng.a.a.a.b.k.a(paramh, localc.b);
                            }
                        }
                    }
                }
            }
            paramv.m();
        }

        public void b(h paramh, v paramv)
                throws j {
            paramv.m();
            paramh.a(v.n());
            paramh.a(v.o());
            paramh.a(paramv.a);
            paramh.c();
            if ((paramv.b != null) && (paramv.i())) {
                paramh.a(v.p());
                paramh.a(paramv.b);
                paramh.c();
            }
            if ((paramv.c != null) && (paramv.l())) {
                paramh.a(v.q());
                paramv.c.b(paramh);
                paramh.c();
            }
            paramh.d();
            paramh.b();
        }
    }

    private static class b
            implements com.umeng.a.a.a.c.b {
        public v.a a() {
            return new v.a(null);
        }
    }

    private static class c
            extends com.umeng.a.a.a.c.d<v> {
        public void a(h paramh, v paramv)
                throws j {
            paramh = (com.umeng.a.a.a.b.n) paramh;
            paramh.a(paramv.a);
            BitSet localBitSet = new BitSet();
            if (paramv.i()) {
                localBitSet.set(0);
            }
            if (paramv.l()) {
                localBitSet.set(1);
            }
            paramh.a(localBitSet, 2);
            if (paramv.i()) {
                paramh.a(paramv.b);
            }
            if (paramv.l()) {
                paramv.c.b(paramh);
            }
        }

        public void b(h paramh, v paramv)
                throws j {
            paramh = (com.umeng.a.a.a.b.n) paramh;
            paramv.a = paramh.w();
            paramv.a(true);
            BitSet localBitSet = paramh.b(2);
            if (localBitSet.get(0)) {
                paramv.b = paramh.z();
                paramv.b(true);
            }
            if (localBitSet.get(1)) {
                paramv.c = new n();
                paramv.c.a(paramh);
                paramv.c(true);
            }
        }
    }

    private static class d
            implements com.umeng.a.a.a.c.b {
        public v.c a() {
            return new v.c(null);
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


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/umeng/analytics/d/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */