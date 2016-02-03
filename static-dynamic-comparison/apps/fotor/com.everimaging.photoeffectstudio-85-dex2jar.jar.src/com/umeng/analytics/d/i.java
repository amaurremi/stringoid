package com.umeng.analytics.d;

import com.umeng.a.a.a.a.g;
import com.umeng.a.a.a.b.h;
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
import java.util.Map.Entry;
import java.util.Set;

public class i
        implements com.umeng.a.a.a.d<i, e>, Serializable, Cloneable {
    private static final m a = new m("Event");
    private static final com.umeng.a.a.a.b.c b = new com.umeng.a.a.a.b.c("name", (byte) 11, (short) 1);
    public static final Map<e, com.umeng.a.a.a.a.b> h;
    private static final com.umeng.a.a.a.b.c i = new com.umeng.a.a.a.b.c("properties", (byte) 13, (short) 2);
    private static final com.umeng.a.a.a.b.c j = new com.umeng.a.a.a.b.c("duration", (byte) 10, (short) 3);
    private static final com.umeng.a.a.a.b.c k = new com.umeng.a.a.a.b.c("acc", (byte) 8, (short) 4);
    private static final com.umeng.a.a.a.b.c l = new com.umeng.a.a.a.b.c("ts", (byte) 10, (short) 5);
    private static final Map<Class<? extends com.umeng.a.a.a.c.a>, com.umeng.a.a.a.c.b> m = new HashMap();
    private static final int n = 0;
    private static final int o = 1;
    private static final int p = 2;
    public String c;
    public Map<String, t> d;
    public long e;
    public int f;
    public long g;
    private byte q = 0;
    private e[] r = {e.c, e.d};

    static {
        m.put(com.umeng.a.a.a.c.c.class, new b(null));
        m.put(com.umeng.a.a.a.c.d.class, new d(null));
        EnumMap localEnumMap = new EnumMap(e.class);
        localEnumMap.put(e.a, new com.umeng.a.a.a.a.b("name", (byte) 1, new com.umeng.a.a.a.a.c((byte) 11)));
        localEnumMap.put(e.b, new com.umeng.a.a.a.a.b("properties", (byte) 1, new com.umeng.a.a.a.a.e((byte) 13, new com.umeng.a.a.a.a.c((byte) 11), new g((byte) 12, t.class))));
        localEnumMap.put(e.c, new com.umeng.a.a.a.a.b("duration", (byte) 2, new com.umeng.a.a.a.a.c((byte) 10)));
        localEnumMap.put(e.d, new com.umeng.a.a.a.a.b("acc", (byte) 2, new com.umeng.a.a.a.a.c((byte) 8)));
        localEnumMap.put(e.e, new com.umeng.a.a.a.a.b("ts", (byte) 1, new com.umeng.a.a.a.a.c((byte) 10)));
        h = Collections.unmodifiableMap(localEnumMap);
        com.umeng.a.a.a.a.b.a(i.class, h);
    }

    public i() {
    }

    public i(i parami) {
        this.q = parami.q;
        if (parami.f()) {
            this.c = parami.c;
        }
        if (parami.k()) {
            HashMap localHashMap = new HashMap();
            Iterator localIterator = parami.d.entrySet().iterator();
            while (localIterator.hasNext()) {
                Map.Entry localEntry = (Map.Entry) localIterator.next();
                localHashMap.put((String) localEntry.getKey(), new t((t) localEntry.getValue()));
            }
            this.d = localHashMap;
        }
        this.e = parami.e;
        this.f = parami.f;
        this.g = parami.g;
    }

    public i(String paramString, Map<String, t> paramMap, long paramLong) {
        this();
        this.c = paramString;
        this.d = paramMap;
        this.g = paramLong;
        e(true);
    }

    private void a(ObjectInputStream paramObjectInputStream)
            throws IOException, ClassNotFoundException {
        try {
            this.q = 0;
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

    public i a(long paramLong) {
        this.e = paramLong;
        c(true);
        return this;
    }

    public i a(String paramString) {
        this.c = paramString;
        return this;
    }

    public i a(Map<String, t> paramMap) {
        this.d = paramMap;
        return this;
    }

    public void a(h paramh)
            throws j {
        ((com.umeng.a.a.a.c.b) m.get(paramh.D())).b().b(paramh, this);
    }

    public void a(String paramString, t paramt) {
        if (this.d == null) {
            this.d = new HashMap();
        }
        this.d.put(paramString, paramt);
    }

    public void a(boolean paramBoolean) {
        if (!paramBoolean) {
            this.c = null;
        }
    }

    public i b(long paramLong) {
        this.g = paramLong;
        e(true);
        return this;
    }

    public void b() {
        this.c = null;
        this.d = null;
        c(false);
        this.e = 0L;
        d(false);
        this.f = 0;
        e(false);
        this.g = 0L;
    }

    public void b(h paramh)
            throws j {
        ((com.umeng.a.a.a.c.b) m.get(paramh.D())).b().a(paramh, this);
    }

    public void b(boolean paramBoolean) {
        if (!paramBoolean) {
            this.d = null;
        }
    }

    public i c() {
        return new i(this);
    }

    public i c(int paramInt) {
        this.f = paramInt;
        d(true);
        return this;
    }

    public void c(boolean paramBoolean) {
        this.q = com.umeng.a.a.a.a.a(this.q, 0, paramBoolean);
    }

    public e d(int paramInt) {
        return e.a(paramInt);
    }

    public String d() {
        return this.c;
    }

    public void d(boolean paramBoolean) {
        this.q = com.umeng.a.a.a.a.a(this.q, 1, paramBoolean);
    }

    public void e() {
        this.c = null;
    }

    public void e(boolean paramBoolean) {
        this.q = com.umeng.a.a.a.a.a(this.q, 2, paramBoolean);
    }

    public boolean f() {
        return this.c != null;
    }

    public int h() {
        if (this.d == null) {
            return 0;
        }
        return this.d.size();
    }

    public Map<String, t> i() {
        return this.d;
    }

    public void j() {
        this.d = null;
    }

    public boolean k() {
        return this.d != null;
    }

    public long l() {
        return this.e;
    }

    public void m() {
        this.q = com.umeng.a.a.a.a.b(this.q, 0);
    }

    public boolean n() {
        return com.umeng.a.a.a.a.a(this.q, 0);
    }

    public int o() {
        return this.f;
    }

    public void p() {
        this.q = com.umeng.a.a.a.a.b(this.q, 1);
    }

    public boolean q() {
        return com.umeng.a.a.a.a.a(this.q, 1);
    }

    public long r() {
        return this.g;
    }

    public void s() {
        this.q = com.umeng.a.a.a.a.b(this.q, 2);
    }

    public boolean t() {
        return com.umeng.a.a.a.a.a(this.q, 2);
    }

    public String toString() {
        StringBuilder localStringBuilder = new StringBuilder("Event(");
        localStringBuilder.append("name:");
        if (this.c == null) {
            localStringBuilder.append("null");
            localStringBuilder.append(", ");
            localStringBuilder.append("properties:");
            if (this.d != null) {
                break label179;
            }
            localStringBuilder.append("null");
        }
        for (; ; ) {
            if (n()) {
                localStringBuilder.append(", ");
                localStringBuilder.append("duration:");
                localStringBuilder.append(this.e);
            }
            if (q()) {
                localStringBuilder.append(", ");
                localStringBuilder.append("acc:");
                localStringBuilder.append(this.f);
            }
            localStringBuilder.append(", ");
            localStringBuilder.append("ts:");
            localStringBuilder.append(this.g);
            localStringBuilder.append(")");
            return localStringBuilder.toString();
            localStringBuilder.append(this.c);
            break;
            label179:
            localStringBuilder.append(this.d);
        }
    }

    public void u()
            throws j {
        if (this.c == null) {
            throw new com.umeng.a.a.a.b.i("Required field 'name' was not present! Struct: " + toString());
        }
        if (this.d == null) {
            throw new com.umeng.a.a.a.b.i("Required field 'properties' was not present! Struct: " + toString());
        }
    }

    private static class a
            extends com.umeng.a.a.a.c.c<i> {
        public void a(h paramh, i parami)
                throws j {
            paramh.j();
            Object localObject = paramh.l();
            if (((com.umeng.a.a.a.b.c) localObject).b == 0) {
                paramh.k();
                if (!parami.t()) {
                    throw new com.umeng.a.a.a.b.i("Required field 'ts' was not found in serialized data! Struct: " + toString());
                }
            } else {
                switch (((com.umeng.a.a.a.b.c) localObject).c) {
                    default:
                        com.umeng.a.a.a.b.k.a(paramh, ((com.umeng.a.a.a.b.c) localObject).b);
                }
                for (; ; ) {
                    paramh.m();
                    break;
                    if (((com.umeng.a.a.a.b.c) localObject).b == 11) {
                        parami.c = paramh.z();
                        parami.a(true);
                    } else {
                        com.umeng.a.a.a.b.k.a(paramh, ((com.umeng.a.a.a.b.c) localObject).b);
                        continue;
                        if (((com.umeng.a.a.a.b.c) localObject).b == 13) {
                            localObject = paramh.n();
                            parami.d = new HashMap(((com.umeng.a.a.a.b.e) localObject).c * 2);
                            int i = 0;
                            while (i < ((com.umeng.a.a.a.b.e) localObject).c) {
                                String str = paramh.z();
                                t localt = new t();
                                localt.a(paramh);
                                parami.d.put(str, localt);
                                i += 1;
                            }
                            paramh.o();
                            parami.b(true);
                        } else {
                            com.umeng.a.a.a.b.k.a(paramh, ((com.umeng.a.a.a.b.c) localObject).b);
                            continue;
                            if (((com.umeng.a.a.a.b.c) localObject).b == 10) {
                                parami.e = paramh.x();
                                parami.c(true);
                            } else {
                                com.umeng.a.a.a.b.k.a(paramh, ((com.umeng.a.a.a.b.c) localObject).b);
                                continue;
                                if (((com.umeng.a.a.a.b.c) localObject).b == 8) {
                                    parami.f = paramh.w();
                                    parami.d(true);
                                } else {
                                    com.umeng.a.a.a.b.k.a(paramh, ((com.umeng.a.a.a.b.c) localObject).b);
                                    continue;
                                    if (((com.umeng.a.a.a.b.c) localObject).b == 10) {
                                        parami.g = paramh.x();
                                        parami.e(true);
                                    } else {
                                        com.umeng.a.a.a.b.k.a(paramh, ((com.umeng.a.a.a.b.c) localObject).b);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            parami.u();
        }

        public void b(h paramh, i parami)
                throws j {
            parami.u();
            paramh.a(i.v());
            if (parami.c != null) {
                paramh.a(i.w());
                paramh.a(parami.c);
                paramh.c();
            }
            if (parami.d != null) {
                paramh.a(i.x());
                paramh.a(new com.umeng.a.a.a.b.e((byte) 11, (byte) 12, parami.d.size()));
                Iterator localIterator = parami.d.entrySet().iterator();
                while (localIterator.hasNext()) {
                    Map.Entry localEntry = (Map.Entry) localIterator.next();
                    paramh.a((String) localEntry.getKey());
                    ((t) localEntry.getValue()).b(paramh);
                }
                paramh.e();
                paramh.c();
            }
            if (parami.n()) {
                paramh.a(i.y());
                paramh.a(parami.e);
                paramh.c();
            }
            if (parami.q()) {
                paramh.a(i.z());
                paramh.a(parami.f);
                paramh.c();
            }
            paramh.a(i.A());
            paramh.a(parami.g);
            paramh.c();
            paramh.d();
            paramh.b();
        }
    }

    private static class b
            implements com.umeng.a.a.a.c.b {
        public i.a a() {
            return new i.a(null);
        }
    }

    private static class c
            extends com.umeng.a.a.a.c.d<i> {
        public void a(h paramh, i parami)
                throws j {
            paramh = (n) paramh;
            paramh.a(parami.c);
            paramh.a(parami.d.size());
            Object localObject = parami.d.entrySet().iterator();
            while (((Iterator) localObject).hasNext()) {
                Map.Entry localEntry = (Map.Entry) ((Iterator) localObject).next();
                paramh.a((String) localEntry.getKey());
                ((t) localEntry.getValue()).b(paramh);
            }
            paramh.a(parami.g);
            localObject = new BitSet();
            if (parami.n()) {
                ((BitSet) localObject).set(0);
            }
            if (parami.q()) {
                ((BitSet) localObject).set(1);
            }
            paramh.a((BitSet) localObject, 2);
            if (parami.n()) {
                paramh.a(parami.e);
            }
            if (parami.q()) {
                paramh.a(parami.f);
            }
        }

        public void b(h paramh, i parami)
                throws j {
            paramh = (n) paramh;
            parami.c = paramh.z();
            parami.a(true);
            Object localObject = new com.umeng.a.a.a.b.e((byte) 11, (byte) 12, paramh.w());
            parami.d = new HashMap(((com.umeng.a.a.a.b.e) localObject).c * 2);
            int i = 0;
            while (i < ((com.umeng.a.a.a.b.e) localObject).c) {
                String str = paramh.z();
                t localt = new t();
                localt.a(paramh);
                parami.d.put(str, localt);
                i += 1;
            }
            parami.b(true);
            parami.g = paramh.x();
            parami.e(true);
            localObject = paramh.b(2);
            if (((BitSet) localObject).get(0)) {
                parami.e = paramh.x();
                parami.c(true);
            }
            if (((BitSet) localObject).get(1)) {
                parami.f = paramh.w();
                parami.d(true);
            }
        }
    }

    private static class d
            implements com.umeng.a.a.a.c.b {
        public i.c a() {
            return new i.c(null);
        }
    }

    public static enum e
            implements com.umeng.a.a.a.k {
        private static final Map<String, e> f;
        private final short g;
        private final String h;

        static {
            f = new HashMap();
            Iterator localIterator = EnumSet.allOf(e.class).iterator();
            while (localIterator.hasNext()) {
                e locale = (e) localIterator.next();
                f.put(locale.b(), locale);
            }
        }

        private e(short paramShort, String paramString) {
            this.g = paramShort;
            this.h = paramString;
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
                case 4:
                    return d;
            }
            return e;
        }

        public static e a(String paramString) {
            return (e) f.get(paramString);
        }

        public static e b(int paramInt) {
            e locale = a(paramInt);
            if (locale == null) {
                throw new IllegalArgumentException("Field " + paramInt + " doesn't exist!");
            }
            return locale;
        }

        public short a() {
            return this.g;
        }

        public String b() {
            return this.h;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/umeng/analytics/d/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */