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
import java.util.Map.Entry;
import java.util.Set;

public class f
        implements com.umeng.a.a.a.d<f, e>, Serializable, Cloneable {
    public static final Map<e, com.umeng.a.a.a.a.b> f;
    private static final m g = new m("Ekv");
    private static final com.umeng.a.a.a.b.c h = new com.umeng.a.a.a.b.c("ts", (byte) 10, (short) 1);
    private static final com.umeng.a.a.a.b.c i = new com.umeng.a.a.a.b.c("name", (byte) 11, (short) 2);
    private static final com.umeng.a.a.a.b.c j = new com.umeng.a.a.a.b.c("ckv", (byte) 13, (short) 3);
    private static final com.umeng.a.a.a.b.c k = new com.umeng.a.a.a.b.c("duration", (byte) 10, (short) 4);
    private static final com.umeng.a.a.a.b.c l = new com.umeng.a.a.a.b.c("acc", (byte) 8, (short) 5);
    private static final Map<Class<? extends com.umeng.a.a.a.c.a>, com.umeng.a.a.a.c.b> m = new HashMap();
    private static final int n = 0;
    private static final int o = 1;
    private static final int p = 2;
    public long a;
    public String b;
    public Map<String, String> c;
    public long d;
    public int e;
    private byte q = 0;
    private e[] r = {e.d, e.e};

    static {
        m.put(com.umeng.a.a.a.c.c.class, new b(null));
        m.put(com.umeng.a.a.a.c.d.class, new d(null));
        EnumMap localEnumMap = new EnumMap(e.class);
        localEnumMap.put(e.a, new com.umeng.a.a.a.a.b("ts", (byte) 1, new com.umeng.a.a.a.a.c((byte) 10)));
        localEnumMap.put(e.b, new com.umeng.a.a.a.a.b("name", (byte) 1, new com.umeng.a.a.a.a.c((byte) 11)));
        localEnumMap.put(e.c, new com.umeng.a.a.a.a.b("ckv", (byte) 1, new com.umeng.a.a.a.a.e((byte) 13, new com.umeng.a.a.a.a.c((byte) 11), new com.umeng.a.a.a.a.c((byte) 11))));
        localEnumMap.put(e.d, new com.umeng.a.a.a.a.b("duration", (byte) 2, new com.umeng.a.a.a.a.c((byte) 10)));
        localEnumMap.put(e.e, new com.umeng.a.a.a.a.b("acc", (byte) 2, new com.umeng.a.a.a.a.c((byte) 8)));
        f = Collections.unmodifiableMap(localEnumMap);
        com.umeng.a.a.a.a.b.a(f.class, f);
    }

    public f() {
    }

    public f(long paramLong, String paramString, Map<String, String> paramMap) {
        this();
        this.a = paramLong;
        a(true);
        this.b = paramString;
        this.c = paramMap;
    }

    public f(f paramf) {
        this.q = paramf.q;
        this.a = paramf.a;
        if (paramf.i()) {
            this.b = paramf.b;
        }
        if (paramf.m()) {
            HashMap localHashMap = new HashMap();
            Iterator localIterator = paramf.c.entrySet().iterator();
            while (localIterator.hasNext()) {
                Map.Entry localEntry = (Map.Entry) localIterator.next();
                localHashMap.put((String) localEntry.getKey(), (String) localEntry.getValue());
            }
            this.c = localHashMap;
        }
        this.d = paramf.d;
        this.e = paramf.e;
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

    public f a() {
        return new f(this);
    }

    public f a(int paramInt) {
        this.e = paramInt;
        e(true);
        return this;
    }

    public f a(long paramLong) {
        this.a = paramLong;
        a(true);
        return this;
    }

    public f a(String paramString) {
        this.b = paramString;
        return this;
    }

    public f a(Map<String, String> paramMap) {
        this.c = paramMap;
        return this;
    }

    public void a(h paramh)
            throws j {
        ((com.umeng.a.a.a.c.b) m.get(paramh.D())).b().b(paramh, this);
    }

    public void a(String paramString1, String paramString2) {
        if (this.c == null) {
            this.c = new HashMap();
        }
        this.c.put(paramString1, paramString2);
    }

    public void a(boolean paramBoolean) {
        this.q = com.umeng.a.a.a.a.a(this.q, 0, paramBoolean);
    }

    public f b(long paramLong) {
        this.d = paramLong;
        d(true);
        return this;
    }

    public void b() {
        a(false);
        this.a = 0L;
        this.b = null;
        this.c = null;
        d(false);
        this.d = 0L;
        e(false);
        this.e = 0;
    }

    public void b(h paramh)
            throws j {
        ((com.umeng.a.a.a.c.b) m.get(paramh.D())).b().a(paramh, this);
    }

    public void b(boolean paramBoolean) {
        if (!paramBoolean) {
            this.b = null;
        }
    }

    public long c() {
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
        this.q = com.umeng.a.a.a.a.b(this.q, 0);
    }

    public void d(boolean paramBoolean) {
        this.q = com.umeng.a.a.a.a.a(this.q, 1, paramBoolean);
    }

    public void e(boolean paramBoolean) {
        this.q = com.umeng.a.a.a.a.a(this.q, 2, paramBoolean);
    }

    public boolean e() {
        return com.umeng.a.a.a.a.a(this.q, 0);
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

    public int j() {
        if (this.c == null) {
            return 0;
        }
        return this.c.size();
    }

    public Map<String, String> k() {
        return this.c;
    }

    public void l() {
        this.c = null;
    }

    public boolean m() {
        return this.c != null;
    }

    public long n() {
        return this.d;
    }

    public void o() {
        this.q = com.umeng.a.a.a.a.b(this.q, 1);
    }

    public boolean p() {
        return com.umeng.a.a.a.a.a(this.q, 1);
    }

    public int q() {
        return this.e;
    }

    public void r() {
        this.q = com.umeng.a.a.a.a.b(this.q, 2);
    }

    public boolean s() {
        return com.umeng.a.a.a.a.a(this.q, 2);
    }

    public void t()
            throws j {
        if (this.b == null) {
            throw new i("Required field 'name' was not present! Struct: " + toString());
        }
        if (this.c == null) {
            throw new i("Required field 'ckv' was not present! Struct: " + toString());
        }
    }

    public String toString() {
        StringBuilder localStringBuilder = new StringBuilder("Ekv(");
        localStringBuilder.append("ts:");
        localStringBuilder.append(this.a);
        localStringBuilder.append(", ");
        localStringBuilder.append("name:");
        if (this.b == null) {
            localStringBuilder.append("null");
            localStringBuilder.append(", ");
            localStringBuilder.append("ckv:");
            if (this.c != null) {
                break label179;
            }
            localStringBuilder.append("null");
        }
        for (; ; ) {
            if (p()) {
                localStringBuilder.append(", ");
                localStringBuilder.append("duration:");
                localStringBuilder.append(this.d);
            }
            if (s()) {
                localStringBuilder.append(", ");
                localStringBuilder.append("acc:");
                localStringBuilder.append(this.e);
            }
            localStringBuilder.append(")");
            return localStringBuilder.toString();
            localStringBuilder.append(this.b);
            break;
            label179:
            localStringBuilder.append(this.c);
        }
    }

    private static class a
            extends com.umeng.a.a.a.c.c<f> {
        public void a(h paramh, f paramf)
                throws j {
            paramh.j();
            Object localObject = paramh.l();
            if (((com.umeng.a.a.a.b.c) localObject).b == 0) {
                paramh.k();
                if (!paramf.e()) {
                    throw new i("Required field 'ts' was not found in serialized data! Struct: " + toString());
                }
            } else {
                switch (((com.umeng.a.a.a.b.c) localObject).c) {
                    default:
                        com.umeng.a.a.a.b.k.a(paramh, ((com.umeng.a.a.a.b.c) localObject).b);
                }
                for (; ; ) {
                    paramh.m();
                    break;
                    if (((com.umeng.a.a.a.b.c) localObject).b == 10) {
                        paramf.a = paramh.x();
                        paramf.a(true);
                    } else {
                        com.umeng.a.a.a.b.k.a(paramh, ((com.umeng.a.a.a.b.c) localObject).b);
                        continue;
                        if (((com.umeng.a.a.a.b.c) localObject).b == 11) {
                            paramf.b = paramh.z();
                            paramf.b(true);
                        } else {
                            com.umeng.a.a.a.b.k.a(paramh, ((com.umeng.a.a.a.b.c) localObject).b);
                            continue;
                            if (((com.umeng.a.a.a.b.c) localObject).b == 13) {
                                localObject = paramh.n();
                                paramf.c = new HashMap(((com.umeng.a.a.a.b.e) localObject).c * 2);
                                int i = 0;
                                while (i < ((com.umeng.a.a.a.b.e) localObject).c) {
                                    String str1 = paramh.z();
                                    String str2 = paramh.z();
                                    paramf.c.put(str1, str2);
                                    i += 1;
                                }
                                paramh.o();
                                paramf.c(true);
                            } else {
                                com.umeng.a.a.a.b.k.a(paramh, ((com.umeng.a.a.a.b.c) localObject).b);
                                continue;
                                if (((com.umeng.a.a.a.b.c) localObject).b == 10) {
                                    paramf.d = paramh.x();
                                    paramf.d(true);
                                } else {
                                    com.umeng.a.a.a.b.k.a(paramh, ((com.umeng.a.a.a.b.c) localObject).b);
                                    continue;
                                    if (((com.umeng.a.a.a.b.c) localObject).b == 8) {
                                        paramf.e = paramh.w();
                                        paramf.e(true);
                                    } else {
                                        com.umeng.a.a.a.b.k.a(paramh, ((com.umeng.a.a.a.b.c) localObject).b);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            paramf.t();
        }

        public void b(h paramh, f paramf)
                throws j {
            paramf.t();
            paramh.a(f.u());
            paramh.a(f.v());
            paramh.a(paramf.a);
            paramh.c();
            if (paramf.b != null) {
                paramh.a(f.w());
                paramh.a(paramf.b);
                paramh.c();
            }
            if (paramf.c != null) {
                paramh.a(f.x());
                paramh.a(new com.umeng.a.a.a.b.e((byte) 11, (byte) 11, paramf.c.size()));
                Iterator localIterator = paramf.c.entrySet().iterator();
                while (localIterator.hasNext()) {
                    Map.Entry localEntry = (Map.Entry) localIterator.next();
                    paramh.a((String) localEntry.getKey());
                    paramh.a((String) localEntry.getValue());
                }
                paramh.e();
                paramh.c();
            }
            if (paramf.p()) {
                paramh.a(f.y());
                paramh.a(paramf.d);
                paramh.c();
            }
            if (paramf.s()) {
                paramh.a(f.z());
                paramh.a(paramf.e);
                paramh.c();
            }
            paramh.d();
            paramh.b();
        }
    }

    private static class b
            implements com.umeng.a.a.a.c.b {
        public f.a a() {
            return new f.a(null);
        }
    }

    private static class c
            extends com.umeng.a.a.a.c.d<f> {
        public void a(h paramh, f paramf)
                throws j {
            paramh = (n) paramh;
            paramh.a(paramf.a);
            paramh.a(paramf.b);
            paramh.a(paramf.c.size());
            Object localObject = paramf.c.entrySet().iterator();
            while (((Iterator) localObject).hasNext()) {
                Map.Entry localEntry = (Map.Entry) ((Iterator) localObject).next();
                paramh.a((String) localEntry.getKey());
                paramh.a((String) localEntry.getValue());
            }
            localObject = new BitSet();
            if (paramf.p()) {
                ((BitSet) localObject).set(0);
            }
            if (paramf.s()) {
                ((BitSet) localObject).set(1);
            }
            paramh.a((BitSet) localObject, 2);
            if (paramf.p()) {
                paramh.a(paramf.d);
            }
            if (paramf.s()) {
                paramh.a(paramf.e);
            }
        }

        public void b(h paramh, f paramf)
                throws j {
            paramh = (n) paramh;
            paramf.a = paramh.x();
            paramf.a(true);
            paramf.b = paramh.z();
            paramf.b(true);
            Object localObject = new com.umeng.a.a.a.b.e((byte) 11, (byte) 11, paramh.w());
            paramf.c = new HashMap(((com.umeng.a.a.a.b.e) localObject).c * 2);
            int i = 0;
            while (i < ((com.umeng.a.a.a.b.e) localObject).c) {
                String str1 = paramh.z();
                String str2 = paramh.z();
                paramf.c.put(str1, str2);
                i += 1;
            }
            paramf.c(true);
            localObject = paramh.b(2);
            if (((BitSet) localObject).get(0)) {
                paramf.d = paramh.x();
                paramf.d(true);
            }
            if (((BitSet) localObject).get(1)) {
                paramf.e = paramh.w();
                paramf.e(true);
            }
        }
    }

    private static class d
            implements com.umeng.a.a.a.c.b {
        public f.c a() {
            return new f.c(null);
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


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/umeng/analytics/d/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */