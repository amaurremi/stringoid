package com.umeng.analytics.d;

import com.umeng.a.a.a.a.g;
import com.umeng.a.a.a.b.h;
import com.umeng.a.a.a.b.i;
import com.umeng.a.a.a.b.m;
import com.umeng.a.a.a.b.n;
import com.umeng.a.a.a.j;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class x
        implements com.umeng.a.a.a.d<x, e>, Serializable, Cloneable {
    public static final Map<e, com.umeng.a.a.a.a.b> h;
    private static final m i = new m("Session");
    private static final com.umeng.a.a.a.b.c j = new com.umeng.a.a.a.b.c("id", (byte) 11, (short) 1);
    private static final com.umeng.a.a.a.b.c k = new com.umeng.a.a.a.b.c("start_time", (byte) 10, (short) 2);
    private static final com.umeng.a.a.a.b.c l = new com.umeng.a.a.a.b.c("end_time", (byte) 10, (short) 3);
    private static final com.umeng.a.a.a.b.c m = new com.umeng.a.a.a.b.c("duration", (byte) 10, (short) 4);
    private static final com.umeng.a.a.a.b.c n = new com.umeng.a.a.a.b.c("pages", (byte) 15, (short) 5);
    private static final com.umeng.a.a.a.b.c o = new com.umeng.a.a.a.b.c("locations", (byte) 15, (short) 6);
    private static final com.umeng.a.a.a.b.c p = new com.umeng.a.a.a.b.c("traffic", (byte) 12, (short) 7);
    private static final Map<Class<? extends com.umeng.a.a.a.c.a>, com.umeng.a.a.a.c.b> q = new HashMap();
    private static final int r = 0;
    private static final int s = 1;
    private static final int t = 2;
    public String a;
    public long b;
    public long c;
    public long d;
    public List<s> e;
    public List<q> f;
    public y g;
    private byte u = 0;
    private e[] v = {e.e, e.f, e.g};

    static {
        q.put(com.umeng.a.a.a.c.c.class, new b(null));
        q.put(com.umeng.a.a.a.c.d.class, new d(null));
        EnumMap localEnumMap = new EnumMap(e.class);
        localEnumMap.put(e.a, new com.umeng.a.a.a.a.b("id", (byte) 1, new com.umeng.a.a.a.a.c((byte) 11)));
        localEnumMap.put(e.b, new com.umeng.a.a.a.a.b("start_time", (byte) 1, new com.umeng.a.a.a.a.c((byte) 10)));
        localEnumMap.put(e.c, new com.umeng.a.a.a.a.b("end_time", (byte) 1, new com.umeng.a.a.a.a.c((byte) 10)));
        localEnumMap.put(e.d, new com.umeng.a.a.a.a.b("duration", (byte) 1, new com.umeng.a.a.a.a.c((byte) 10)));
        localEnumMap.put(e.e, new com.umeng.a.a.a.a.b("pages", (byte) 2, new com.umeng.a.a.a.a.d((byte) 15, new g((byte) 12, s.class))));
        localEnumMap.put(e.f, new com.umeng.a.a.a.a.b("locations", (byte) 2, new com.umeng.a.a.a.a.d((byte) 15, new g((byte) 12, q.class))));
        localEnumMap.put(e.g, new com.umeng.a.a.a.a.b("traffic", (byte) 2, new g((byte) 12, y.class)));
        h = Collections.unmodifiableMap(localEnumMap);
        com.umeng.a.a.a.a.b.a(x.class, h);
    }

    public x() {
    }

    public x(x paramx) {
        this.u = paramx.u;
        if (paramx.e()) {
            this.a = paramx.a;
        }
        this.b = paramx.b;
        this.c = paramx.c;
        this.d = paramx.d;
        ArrayList localArrayList;
        Iterator localIterator;
        if (paramx.t()) {
            localArrayList = new ArrayList();
            localIterator = paramx.e.iterator();
            while (localIterator.hasNext()) {
                localArrayList.add(new s((s) localIterator.next()));
            }
            this.e = localArrayList;
        }
        if (paramx.y()) {
            localArrayList = new ArrayList();
            localIterator = paramx.f.iterator();
            while (localIterator.hasNext()) {
                localArrayList.add(new q((q) localIterator.next()));
            }
            this.f = localArrayList;
        }
        if (paramx.B()) {
            this.g = new y(paramx.g);
        }
    }

    public x(String paramString, long paramLong1, long paramLong2, long paramLong3) {
        this();
        this.a = paramString;
        this.b = paramLong1;
        b(true);
        this.c = paramLong2;
        c(true);
        this.d = paramLong3;
        d(true);
    }

    private void a(ObjectInputStream paramObjectInputStream)
            throws IOException, ClassNotFoundException {
        try {
            this.u = 0;
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

    public void A() {
        this.g = null;
    }

    public boolean B() {
        return this.g != null;
    }

    public void C()
            throws j {
        if (this.a == null) {
            throw new i("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.g != null) {
            this.g.j();
        }
    }

    public e a(int paramInt) {
        return e.a(paramInt);
    }

    public x a() {
        return new x(this);
    }

    public x a(long paramLong) {
        this.b = paramLong;
        b(true);
        return this;
    }

    public x a(y paramy) {
        this.g = paramy;
        return this;
    }

    public x a(String paramString) {
        this.a = paramString;
        return this;
    }

    public x a(List<s> paramList) {
        this.e = paramList;
        return this;
    }

    public void a(h paramh)
            throws j {
        ((com.umeng.a.a.a.c.b) q.get(paramh.D())).b().b(paramh, this);
    }

    public void a(q paramq) {
        if (this.f == null) {
            this.f = new ArrayList();
        }
        this.f.add(paramq);
    }

    public void a(s params) {
        if (this.e == null) {
            this.e = new ArrayList();
        }
        this.e.add(params);
    }

    public void a(boolean paramBoolean) {
        if (!paramBoolean) {
            this.a = null;
        }
    }

    public x b(long paramLong) {
        this.c = paramLong;
        c(true);
        return this;
    }

    public x b(List<q> paramList) {
        this.f = paramList;
        return this;
    }

    public void b() {
        this.a = null;
        b(false);
        this.b = 0L;
        c(false);
        this.c = 0L;
        d(false);
        this.d = 0L;
        this.e = null;
        this.f = null;
        this.g = null;
    }

    public void b(h paramh)
            throws j {
        ((com.umeng.a.a.a.c.b) q.get(paramh.D())).b().a(paramh, this);
    }

    public void b(boolean paramBoolean) {
        this.u = com.umeng.a.a.a.a.a(this.u, 0, paramBoolean);
    }

    public x c(long paramLong) {
        this.d = paramLong;
        d(true);
        return this;
    }

    public String c() {
        return this.a;
    }

    public void c(boolean paramBoolean) {
        this.u = com.umeng.a.a.a.a.a(this.u, 1, paramBoolean);
    }

    public void d() {
        this.a = null;
    }

    public void d(boolean paramBoolean) {
        this.u = com.umeng.a.a.a.a.a(this.u, 2, paramBoolean);
    }

    public void e(boolean paramBoolean) {
        if (!paramBoolean) {
            this.e = null;
        }
    }

    public boolean e() {
        return this.a != null;
    }

    public long f() {
        return this.b;
    }

    public void f(boolean paramBoolean) {
        if (!paramBoolean) {
            this.f = null;
        }
    }

    public void g(boolean paramBoolean) {
        if (!paramBoolean) {
            this.g = null;
        }
    }

    public void h() {
        this.u = com.umeng.a.a.a.a.b(this.u, 0);
    }

    public boolean i() {
        return com.umeng.a.a.a.a.a(this.u, 0);
    }

    public long j() {
        return this.c;
    }

    public void k() {
        this.u = com.umeng.a.a.a.a.b(this.u, 1);
    }

    public boolean l() {
        return com.umeng.a.a.a.a.a(this.u, 1);
    }

    public long m() {
        return this.d;
    }

    public void n() {
        this.u = com.umeng.a.a.a.a.b(this.u, 2);
    }

    public boolean o() {
        return com.umeng.a.a.a.a.a(this.u, 2);
    }

    public int p() {
        if (this.e == null) {
            return 0;
        }
        return this.e.size();
    }

    public Iterator<s> q() {
        if (this.e == null) {
            return null;
        }
        return this.e.iterator();
    }

    public List<s> r() {
        return this.e;
    }

    public void s() {
        this.e = null;
    }

    public boolean t() {
        return this.e != null;
    }

    public String toString() {
        StringBuilder localStringBuilder = new StringBuilder("Session(");
        localStringBuilder.append("id:");
        if (this.a == null) {
            localStringBuilder.append("null");
            localStringBuilder.append(", ");
            localStringBuilder.append("start_time:");
            localStringBuilder.append(this.b);
            localStringBuilder.append(", ");
            localStringBuilder.append("end_time:");
            localStringBuilder.append(this.c);
            localStringBuilder.append(", ");
            localStringBuilder.append("duration:");
            localStringBuilder.append(this.d);
            if (t()) {
                localStringBuilder.append(", ");
                localStringBuilder.append("pages:");
                if (this.e != null) {
                    break label248;
                }
                localStringBuilder.append("null");
            }
            label147:
            if (y()) {
                localStringBuilder.append(", ");
                localStringBuilder.append("locations:");
                if (this.f != null) {
                    break label260;
                }
                localStringBuilder.append("null");
            }
            label185:
            if (B()) {
                localStringBuilder.append(", ");
                localStringBuilder.append("traffic:");
                if (this.g != null) {
                    break label272;
                }
                localStringBuilder.append("null");
            }
        }
        for (; ; ) {
            localStringBuilder.append(")");
            return localStringBuilder.toString();
            localStringBuilder.append(this.a);
            break;
            label248:
            localStringBuilder.append(this.e);
            break label147;
            label260:
            localStringBuilder.append(this.f);
            break label185;
            label272:
            localStringBuilder.append(this.g);
        }
    }

    public int u() {
        if (this.f == null) {
            return 0;
        }
        return this.f.size();
    }

    public Iterator<q> v() {
        if (this.f == null) {
            return null;
        }
        return this.f.iterator();
    }

    public List<q> w() {
        return this.f;
    }

    public void x() {
        this.f = null;
    }

    public boolean y() {
        return this.f != null;
    }

    public y z() {
        return this.g;
    }

    private static class a
            extends com.umeng.a.a.a.c.c<x> {
        public void a(h paramh, x paramx)
                throws j {
            paramh.j();
            Object localObject1 = paramh.l();
            if (((com.umeng.a.a.a.b.c) localObject1).b == 0) {
                paramh.k();
                if (!paramx.i()) {
                    throw new i("Required field 'start_time' was not found in serialized data! Struct: " + toString());
                }
            } else {
                switch (((com.umeng.a.a.a.b.c) localObject1).c) {
                    default:
                        com.umeng.a.a.a.b.k.a(paramh, ((com.umeng.a.a.a.b.c) localObject1).b);
                }
                for (; ; ) {
                    paramh.m();
                    break;
                    if (((com.umeng.a.a.a.b.c) localObject1).b == 11) {
                        paramx.a = paramh.z();
                        paramx.a(true);
                    } else {
                        com.umeng.a.a.a.b.k.a(paramh, ((com.umeng.a.a.a.b.c) localObject1).b);
                        continue;
                        if (((com.umeng.a.a.a.b.c) localObject1).b == 10) {
                            paramx.b = paramh.x();
                            paramx.b(true);
                        } else {
                            com.umeng.a.a.a.b.k.a(paramh, ((com.umeng.a.a.a.b.c) localObject1).b);
                            continue;
                            if (((com.umeng.a.a.a.b.c) localObject1).b == 10) {
                                paramx.c = paramh.x();
                                paramx.c(true);
                            } else {
                                com.umeng.a.a.a.b.k.a(paramh, ((com.umeng.a.a.a.b.c) localObject1).b);
                                continue;
                                if (((com.umeng.a.a.a.b.c) localObject1).b == 10) {
                                    paramx.d = paramh.x();
                                    paramx.d(true);
                                } else {
                                    com.umeng.a.a.a.b.k.a(paramh, ((com.umeng.a.a.a.b.c) localObject1).b);
                                    continue;
                                    int i;
                                    Object localObject2;
                                    if (((com.umeng.a.a.a.b.c) localObject1).b == 15) {
                                        localObject1 = paramh.p();
                                        paramx.e = new ArrayList(((com.umeng.a.a.a.b.d) localObject1).b);
                                        i = 0;
                                        while (i < ((com.umeng.a.a.a.b.d) localObject1).b) {
                                            localObject2 = new s();
                                            ((s) localObject2).a(paramh);
                                            paramx.e.add(localObject2);
                                            i += 1;
                                        }
                                        paramh.q();
                                        paramx.e(true);
                                    } else {
                                        com.umeng.a.a.a.b.k.a(paramh, ((com.umeng.a.a.a.b.c) localObject1).b);
                                        continue;
                                        if (((com.umeng.a.a.a.b.c) localObject1).b == 15) {
                                            localObject1 = paramh.p();
                                            paramx.f = new ArrayList(((com.umeng.a.a.a.b.d) localObject1).b);
                                            i = 0;
                                            while (i < ((com.umeng.a.a.a.b.d) localObject1).b) {
                                                localObject2 = new q();
                                                ((q) localObject2).a(paramh);
                                                paramx.f.add(localObject2);
                                                i += 1;
                                            }
                                            paramh.q();
                                            paramx.f(true);
                                        } else {
                                            com.umeng.a.a.a.b.k.a(paramh, ((com.umeng.a.a.a.b.c) localObject1).b);
                                            continue;
                                            if (((com.umeng.a.a.a.b.c) localObject1).b == 12) {
                                                paramx.g = new y();
                                                paramx.g.a(paramh);
                                                paramx.g(true);
                                            } else {
                                                com.umeng.a.a.a.b.k.a(paramh, ((com.umeng.a.a.a.b.c) localObject1).b);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (!paramx.l()) {
                throw new i("Required field 'end_time' was not found in serialized data! Struct: " + toString());
            }
            if (!paramx.o()) {
                throw new i("Required field 'duration' was not found in serialized data! Struct: " + toString());
            }
            paramx.C();
        }

        public void b(h paramh, x paramx)
                throws j {
            paramx.C();
            paramh.a(x.D());
            if (paramx.a != null) {
                paramh.a(x.E());
                paramh.a(paramx.a);
                paramh.c();
            }
            paramh.a(x.F());
            paramh.a(paramx.b);
            paramh.c();
            paramh.a(x.G());
            paramh.a(paramx.c);
            paramh.c();
            paramh.a(x.H());
            paramh.a(paramx.d);
            paramh.c();
            Iterator localIterator;
            if ((paramx.e != null) && (paramx.t())) {
                paramh.a(x.I());
                paramh.a(new com.umeng.a.a.a.b.d((byte) 12, paramx.e.size()));
                localIterator = paramx.e.iterator();
                while (localIterator.hasNext()) {
                    ((s) localIterator.next()).b(paramh);
                }
                paramh.f();
                paramh.c();
            }
            if ((paramx.f != null) && (paramx.y())) {
                paramh.a(x.J());
                paramh.a(new com.umeng.a.a.a.b.d((byte) 12, paramx.f.size()));
                localIterator = paramx.f.iterator();
                while (localIterator.hasNext()) {
                    ((q) localIterator.next()).b(paramh);
                }
                paramh.f();
                paramh.c();
            }
            if ((paramx.g != null) && (paramx.B())) {
                paramh.a(x.K());
                paramx.g.b(paramh);
                paramh.c();
            }
            paramh.d();
            paramh.b();
        }
    }

    private static class b
            implements com.umeng.a.a.a.c.b {
        public x.a a() {
            return new x.a(null);
        }
    }

    private static class c
            extends com.umeng.a.a.a.c.d<x> {
        public void a(h paramh, x paramx)
                throws j {
            paramh = (n) paramh;
            paramh.a(paramx.a);
            paramh.a(paramx.b);
            paramh.a(paramx.c);
            paramh.a(paramx.d);
            Object localObject = new BitSet();
            if (paramx.t()) {
                ((BitSet) localObject).set(0);
            }
            if (paramx.y()) {
                ((BitSet) localObject).set(1);
            }
            if (paramx.B()) {
                ((BitSet) localObject).set(2);
            }
            paramh.a((BitSet) localObject, 3);
            if (paramx.t()) {
                paramh.a(paramx.e.size());
                localObject = paramx.e.iterator();
                while (((Iterator) localObject).hasNext()) {
                    ((s) ((Iterator) localObject).next()).b(paramh);
                }
            }
            if (paramx.y()) {
                paramh.a(paramx.f.size());
                localObject = paramx.f.iterator();
                while (((Iterator) localObject).hasNext()) {
                    ((q) ((Iterator) localObject).next()).b(paramh);
                }
            }
            if (paramx.B()) {
                paramx.g.b(paramh);
            }
        }

        public void b(h paramh, x paramx)
                throws j {
            int j = 0;
            paramh = (n) paramh;
            paramx.a = paramh.z();
            paramx.a(true);
            paramx.b = paramh.x();
            paramx.b(true);
            paramx.c = paramh.x();
            paramx.c(true);
            paramx.d = paramh.x();
            paramx.d(true);
            BitSet localBitSet = paramh.b(3);
            com.umeng.a.a.a.b.d locald;
            int i;
            Object localObject;
            if (localBitSet.get(0)) {
                locald = new com.umeng.a.a.a.b.d((byte) 12, paramh.w());
                paramx.e = new ArrayList(locald.b);
                i = 0;
                while (i < locald.b) {
                    localObject = new s();
                    ((s) localObject).a(paramh);
                    paramx.e.add(localObject);
                    i += 1;
                }
                paramx.e(true);
            }
            if (localBitSet.get(1)) {
                locald = new com.umeng.a.a.a.b.d((byte) 12, paramh.w());
                paramx.f = new ArrayList(locald.b);
                i = j;
                while (i < locald.b) {
                    localObject = new q();
                    ((q) localObject).a(paramh);
                    paramx.f.add(localObject);
                    i += 1;
                }
                paramx.f(true);
            }
            if (localBitSet.get(2)) {
                paramx.g = new y();
                paramx.g.a(paramh);
                paramx.g(true);
            }
        }
    }

    private static class d
            implements com.umeng.a.a.a.c.b {
        public x.c a() {
            return new x.c(null);
        }
    }

    public static enum e
            implements com.umeng.a.a.a.k {
        private static final Map<String, e> h;
        private final short i;
        private final String j;

        static {
            h = new HashMap();
            Iterator localIterator = EnumSet.allOf(e.class).iterator();
            while (localIterator.hasNext()) {
                e locale = (e) localIterator.next();
                h.put(locale.b(), locale);
            }
        }

        private e(short paramShort, String paramString) {
            this.i = paramShort;
            this.j = paramString;
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
                case 5:
                    return e;
                case 6:
                    return f;
            }
            return g;
        }

        public static e a(String paramString) {
            return (e) h.get(paramString);
        }

        public static e b(int paramInt) {
            e locale = a(paramInt);
            if (locale == null) {
                throw new IllegalArgumentException("Field " + paramInt + " doesn't exist!");
            }
            return locale;
        }

        public short a() {
            return this.i;
        }

        public String b() {
            return this.j;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/umeng/analytics/d/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */