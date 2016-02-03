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
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class n
        implements com.umeng.a.a.a.d<n, e>, Serializable, Cloneable {
    public static final Map<e, com.umeng.a.a.a.a.b> d;
    private static final m e = new m("Imprint");
    private static final com.umeng.a.a.a.b.c f = new com.umeng.a.a.a.b.c("property", (byte) 13, (short) 1);
    private static final com.umeng.a.a.a.b.c g = new com.umeng.a.a.a.b.c("version", (byte) 8, (short) 2);
    private static final com.umeng.a.a.a.b.c h = new com.umeng.a.a.a.b.c("checksum", (byte) 11, (short) 3);
    private static final Map<Class<? extends com.umeng.a.a.a.c.a>, com.umeng.a.a.a.c.b> i = new HashMap();
    private static final int j = 0;
    public Map<String, o> a;
    public int b;
    public String c;
    private byte k = 0;

    static {
        i.put(com.umeng.a.a.a.c.c.class, new b(null));
        i.put(com.umeng.a.a.a.c.d.class, new d(null));
        EnumMap localEnumMap = new EnumMap(e.class);
        localEnumMap.put(e.a, new com.umeng.a.a.a.a.b("property", (byte) 1, new com.umeng.a.a.a.a.e((byte) 13, new com.umeng.a.a.a.a.c((byte) 11), new g((byte) 12, o.class))));
        localEnumMap.put(e.b, new com.umeng.a.a.a.a.b("version", (byte) 1, new com.umeng.a.a.a.a.c((byte) 8)));
        localEnumMap.put(e.c, new com.umeng.a.a.a.a.b("checksum", (byte) 1, new com.umeng.a.a.a.a.c((byte) 11)));
        d = Collections.unmodifiableMap(localEnumMap);
        com.umeng.a.a.a.a.b.a(n.class, d);
    }

    public n() {
    }

    public n(n paramn) {
        this.k = paramn.k;
        if (paramn.f()) {
            HashMap localHashMap = new HashMap();
            Iterator localIterator = paramn.a.entrySet().iterator();
            while (localIterator.hasNext()) {
                Map.Entry localEntry = (Map.Entry) localIterator.next();
                localHashMap.put((String) localEntry.getKey(), new o((o) localEntry.getValue()));
            }
            this.a = localHashMap;
        }
        this.b = paramn.b;
        if (paramn.m()) {
            this.c = paramn.c;
        }
    }

    public n(Map<String, o> paramMap, int paramInt, String paramString) {
        this();
        this.a = paramMap;
        this.b = paramInt;
        b(true);
        this.c = paramString;
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

    public n a() {
        return new n(this);
    }

    public n a(int paramInt) {
        this.b = paramInt;
        b(true);
        return this;
    }

    public n a(String paramString) {
        this.c = paramString;
        return this;
    }

    public n a(Map<String, o> paramMap) {
        this.a = paramMap;
        return this;
    }

    public void a(h paramh)
            throws j {
        ((com.umeng.a.a.a.c.b) i.get(paramh.D())).b().b(paramh, this);
    }

    public void a(String paramString, o paramo) {
        if (this.a == null) {
            this.a = new HashMap();
        }
        this.a.put(paramString, paramo);
    }

    public void a(boolean paramBoolean) {
        if (!paramBoolean) {
            this.a = null;
        }
    }

    public void b() {
        this.a = null;
        b(false);
        this.b = 0;
        this.c = null;
    }

    public void b(h paramh)
            throws j {
        ((com.umeng.a.a.a.c.b) i.get(paramh.D())).b().a(paramh, this);
    }

    public void b(boolean paramBoolean) {
        this.k = com.umeng.a.a.a.a.a(this.k, 0, paramBoolean);
    }

    public int c() {
        if (this.a == null) {
            return 0;
        }
        return this.a.size();
    }

    public e c(int paramInt) {
        return e.a(paramInt);
    }

    public void c(boolean paramBoolean) {
        if (!paramBoolean) {
            this.c = null;
        }
    }

    public Map<String, o> d() {
        return this.a;
    }

    public void e() {
        this.a = null;
    }

    public boolean f() {
        return this.a != null;
    }

    public int h() {
        return this.b;
    }

    public void i() {
        this.k = com.umeng.a.a.a.a.b(this.k, 0);
    }

    public boolean j() {
        return com.umeng.a.a.a.a.a(this.k, 0);
    }

    public String k() {
        return this.c;
    }

    public void l() {
        this.c = null;
    }

    public boolean m() {
        return this.c != null;
    }

    public void n()
            throws j {
        if (this.a == null) {
            throw new i("Required field 'property' was not present! Struct: " + toString());
        }
        if (this.c == null) {
            throw new i("Required field 'checksum' was not present! Struct: " + toString());
        }
    }

    public String toString() {
        StringBuilder localStringBuilder = new StringBuilder("Imprint(");
        localStringBuilder.append("property:");
        if (this.a == null) {
            localStringBuilder.append("null");
            localStringBuilder.append(", ");
            localStringBuilder.append("version:");
            localStringBuilder.append(this.b);
            localStringBuilder.append(", ");
            localStringBuilder.append("checksum:");
            if (this.c != null) {
                break label115;
            }
            localStringBuilder.append("null");
        }
        for (; ; ) {
            localStringBuilder.append(")");
            return localStringBuilder.toString();
            localStringBuilder.append(this.a);
            break;
            label115:
            localStringBuilder.append(this.c);
        }
    }

    private static class a
            extends com.umeng.a.a.a.c.c<n> {
        public void a(h paramh, n paramn)
                throws j {
            paramh.j();
            Object localObject = paramh.l();
            if (((com.umeng.a.a.a.b.c) localObject).b == 0) {
                paramh.k();
                if (!paramn.j()) {
                    throw new i("Required field 'version' was not found in serialized data! Struct: " + toString());
                }
            } else {
                switch (((com.umeng.a.a.a.b.c) localObject).c) {
                    default:
                        com.umeng.a.a.a.b.k.a(paramh, ((com.umeng.a.a.a.b.c) localObject).b);
                }
                for (; ; ) {
                    paramh.m();
                    break;
                    if (((com.umeng.a.a.a.b.c) localObject).b == 13) {
                        localObject = paramh.n();
                        paramn.a = new HashMap(((com.umeng.a.a.a.b.e) localObject).c * 2);
                        int i = 0;
                        while (i < ((com.umeng.a.a.a.b.e) localObject).c) {
                            String str = paramh.z();
                            o localo = new o();
                            localo.a(paramh);
                            paramn.a.put(str, localo);
                            i += 1;
                        }
                        paramh.o();
                        paramn.a(true);
                    } else {
                        com.umeng.a.a.a.b.k.a(paramh, ((com.umeng.a.a.a.b.c) localObject).b);
                        continue;
                        if (((com.umeng.a.a.a.b.c) localObject).b == 8) {
                            paramn.b = paramh.w();
                            paramn.b(true);
                        } else {
                            com.umeng.a.a.a.b.k.a(paramh, ((com.umeng.a.a.a.b.c) localObject).b);
                            continue;
                            if (((com.umeng.a.a.a.b.c) localObject).b == 11) {
                                paramn.c = paramh.z();
                                paramn.c(true);
                            } else {
                                com.umeng.a.a.a.b.k.a(paramh, ((com.umeng.a.a.a.b.c) localObject).b);
                            }
                        }
                    }
                }
            }
            paramn.n();
        }

        public void b(h paramh, n paramn)
                throws j {
            paramn.n();
            paramh.a(n.o());
            if (paramn.a != null) {
                paramh.a(n.p());
                paramh.a(new com.umeng.a.a.a.b.e((byte) 11, (byte) 12, paramn.a.size()));
                Iterator localIterator = paramn.a.entrySet().iterator();
                while (localIterator.hasNext()) {
                    Map.Entry localEntry = (Map.Entry) localIterator.next();
                    paramh.a((String) localEntry.getKey());
                    ((o) localEntry.getValue()).b(paramh);
                }
                paramh.e();
                paramh.c();
            }
            paramh.a(n.q());
            paramh.a(paramn.b);
            paramh.c();
            if (paramn.c != null) {
                paramh.a(n.r());
                paramh.a(paramn.c);
                paramh.c();
            }
            paramh.d();
            paramh.b();
        }
    }

    private static class b
            implements com.umeng.a.a.a.c.b {
        public n.a a() {
            return new n.a(null);
        }
    }

    private static class c
            extends com.umeng.a.a.a.c.d<n> {
        public void a(h paramh, n paramn)
                throws j {
            paramh = (com.umeng.a.a.a.b.n) paramh;
            paramh.a(paramn.a.size());
            Iterator localIterator = paramn.a.entrySet().iterator();
            while (localIterator.hasNext()) {
                Map.Entry localEntry = (Map.Entry) localIterator.next();
                paramh.a((String) localEntry.getKey());
                ((o) localEntry.getValue()).b(paramh);
            }
            paramh.a(paramn.b);
            paramh.a(paramn.c);
        }

        public void b(h paramh, n paramn)
                throws j {
            paramh = (com.umeng.a.a.a.b.n) paramh;
            com.umeng.a.a.a.b.e locale = new com.umeng.a.a.a.b.e((byte) 11, (byte) 12, paramh.w());
            paramn.a = new HashMap(locale.c * 2);
            int i = 0;
            while (i < locale.c) {
                String str = paramh.z();
                o localo = new o();
                localo.a(paramh);
                paramn.a.put(str, localo);
                i += 1;
            }
            paramn.a(true);
            paramn.b = paramh.w();
            paramn.b(true);
            paramn.c = paramh.z();
            paramn.c(true);
        }
    }

    private static class d
            implements com.umeng.a.a.a.c.b {
        public n.c a() {
            return new n.c(null);
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


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/umeng/analytics/d/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */