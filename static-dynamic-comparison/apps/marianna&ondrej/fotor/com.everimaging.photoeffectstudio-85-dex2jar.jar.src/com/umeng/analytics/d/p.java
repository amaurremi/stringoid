package com.umeng.analytics.d;

import com.umeng.a.a.a.b.h;
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

public class p
        implements com.umeng.a.a.a.d<p, e>, Serializable, Cloneable {
    public static final Map<e, com.umeng.a.a.a.a.b> e;
    private static final m f = new m("InstantMsg");
    private static final com.umeng.a.a.a.b.c g = new com.umeng.a.a.a.b.c("id", (byte) 11, (short) 1);
    private static final com.umeng.a.a.a.b.c h = new com.umeng.a.a.a.b.c("errors", (byte) 15, (short) 2);
    private static final com.umeng.a.a.a.b.c i = new com.umeng.a.a.a.b.c("events", (byte) 15, (short) 3);
    private static final com.umeng.a.a.a.b.c j = new com.umeng.a.a.a.b.c("game_events", (byte) 15, (short) 4);
    private static final Map<Class<? extends com.umeng.a.a.a.c.a>, com.umeng.a.a.a.c.b> k = new HashMap();
    public String a;
    public List<g> b;
    public List<i> c;
    public List<i> d;
    private e[] l = {e.b, e.c, e.d};

    static {
        k.put(com.umeng.a.a.a.c.c.class, new b(null));
        k.put(com.umeng.a.a.a.c.d.class, new d(null));
        EnumMap localEnumMap = new EnumMap(e.class);
        localEnumMap.put(e.a, new com.umeng.a.a.a.a.b("id", (byte) 1, new com.umeng.a.a.a.a.c((byte) 11)));
        localEnumMap.put(e.b, new com.umeng.a.a.a.a.b("errors", (byte) 2, new com.umeng.a.a.a.a.d((byte) 15, new com.umeng.a.a.a.a.g((byte) 12, g.class))));
        localEnumMap.put(e.c, new com.umeng.a.a.a.a.b("events", (byte) 2, new com.umeng.a.a.a.a.d((byte) 15, new com.umeng.a.a.a.a.g((byte) 12, i.class))));
        localEnumMap.put(e.d, new com.umeng.a.a.a.a.b("game_events", (byte) 2, new com.umeng.a.a.a.a.d((byte) 15, new com.umeng.a.a.a.a.g((byte) 12, i.class))));
        e = Collections.unmodifiableMap(localEnumMap);
        com.umeng.a.a.a.a.b.a(p.class, e);
    }

    public p() {
    }

    public p(p paramp) {
        if (paramp.e()) {
            this.a = paramp.a;
        }
        ArrayList localArrayList;
        Iterator localIterator;
        if (paramp.k()) {
            localArrayList = new ArrayList();
            localIterator = paramp.b.iterator();
            while (localIterator.hasNext()) {
                localArrayList.add(new g((g) localIterator.next()));
            }
            this.b = localArrayList;
        }
        if (paramp.p()) {
            localArrayList = new ArrayList();
            localIterator = paramp.c.iterator();
            while (localIterator.hasNext()) {
                localArrayList.add(new i((i) localIterator.next()));
            }
            this.c = localArrayList;
        }
        if (paramp.u()) {
            localArrayList = new ArrayList();
            paramp = paramp.d.iterator();
            while (paramp.hasNext()) {
                localArrayList.add(new i((i) paramp.next()));
            }
            this.d = localArrayList;
        }
    }

    public p(String paramString) {
        this();
        this.a = paramString;
    }

    private void a(ObjectInputStream paramObjectInputStream)
            throws IOException, ClassNotFoundException {
        try {
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

    public p a() {
        return new p(this);
    }

    public p a(String paramString) {
        this.a = paramString;
        return this;
    }

    public p a(List<g> paramList) {
        this.b = paramList;
        return this;
    }

    public void a(h paramh)
            throws j {
        ((com.umeng.a.a.a.c.b) k.get(paramh.D())).b().b(paramh, this);
    }

    public void a(g paramg) {
        if (this.b == null) {
            this.b = new ArrayList();
        }
        this.b.add(paramg);
    }

    public void a(i parami) {
        if (this.c == null) {
            this.c = new ArrayList();
        }
        this.c.add(parami);
    }

    public void a(boolean paramBoolean) {
        if (!paramBoolean) {
            this.a = null;
        }
    }

    public p b(List<i> paramList) {
        this.c = paramList;
        return this;
    }

    public void b() {
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
    }

    public void b(h paramh)
            throws j {
        ((com.umeng.a.a.a.c.b) k.get(paramh.D())).b().a(paramh, this);
    }

    public void b(i parami) {
        if (this.d == null) {
            this.d = new ArrayList();
        }
        this.d.add(parami);
    }

    public void b(boolean paramBoolean) {
        if (!paramBoolean) {
            this.b = null;
        }
    }

    public p c(List<i> paramList) {
        this.d = paramList;
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
        if (!paramBoolean) {
            this.d = null;
        }
    }

    public boolean e() {
        return this.a != null;
    }

    public int f() {
        if (this.b == null) {
            return 0;
        }
        return this.b.size();
    }

    public Iterator<g> h() {
        if (this.b == null) {
            return null;
        }
        return this.b.iterator();
    }

    public List<g> i() {
        return this.b;
    }

    public void j() {
        this.b = null;
    }

    public boolean k() {
        return this.b != null;
    }

    public int l() {
        if (this.c == null) {
            return 0;
        }
        return this.c.size();
    }

    public Iterator<i> m() {
        if (this.c == null) {
            return null;
        }
        return this.c.iterator();
    }

    public List<i> n() {
        return this.c;
    }

    public void o() {
        this.c = null;
    }

    public boolean p() {
        return this.c != null;
    }

    public int q() {
        if (this.d == null) {
            return 0;
        }
        return this.d.size();
    }

    public Iterator<i> r() {
        if (this.d == null) {
            return null;
        }
        return this.d.iterator();
    }

    public List<i> s() {
        return this.d;
    }

    public void t() {
        this.d = null;
    }

    public String toString() {
        StringBuilder localStringBuilder = new StringBuilder("InstantMsg(");
        localStringBuilder.append("id:");
        if (this.a == null) {
            localStringBuilder.append("null");
            if (k()) {
                localStringBuilder.append(", ");
                localStringBuilder.append("errors:");
                if (this.b != null) {
                    break label173;
                }
                localStringBuilder.append("null");
            }
            label72:
            if (p()) {
                localStringBuilder.append(", ");
                localStringBuilder.append("events:");
                if (this.c != null) {
                    break label185;
                }
                localStringBuilder.append("null");
            }
            label110:
            if (u()) {
                localStringBuilder.append(", ");
                localStringBuilder.append("game_events:");
                if (this.d != null) {
                    break label197;
                }
                localStringBuilder.append("null");
            }
        }
        for (; ; ) {
            localStringBuilder.append(")");
            return localStringBuilder.toString();
            localStringBuilder.append(this.a);
            break;
            label173:
            localStringBuilder.append(this.b);
            break label72;
            label185:
            localStringBuilder.append(this.c);
            break label110;
            label197:
            localStringBuilder.append(this.d);
        }
    }

    public boolean u() {
        return this.d != null;
    }

    public void v()
            throws j {
        if (this.a == null) {
            throw new com.umeng.a.a.a.b.i("Required field 'id' was not present! Struct: " + toString());
        }
    }

    private static class a
            extends com.umeng.a.a.a.c.c<p> {
        public void a(h paramh, p paramp)
                throws j {
            paramh.j();
            Object localObject1 = paramh.l();
            if (((com.umeng.a.a.a.b.c) localObject1).b == 0) {
                paramh.k();
                paramp.v();
                return;
            }
            switch (((com.umeng.a.a.a.b.c) localObject1).c) {
                default:
                    com.umeng.a.a.a.b.k.a(paramh, ((com.umeng.a.a.a.b.c) localObject1).b);
            }
            for (; ; ) {
                paramh.m();
                break;
                if (((com.umeng.a.a.a.b.c) localObject1).b == 11) {
                    paramp.a = paramh.z();
                    paramp.a(true);
                } else {
                    com.umeng.a.a.a.b.k.a(paramh, ((com.umeng.a.a.a.b.c) localObject1).b);
                    continue;
                    int i;
                    Object localObject2;
                    if (((com.umeng.a.a.a.b.c) localObject1).b == 15) {
                        localObject1 = paramh.p();
                        paramp.b = new ArrayList(((com.umeng.a.a.a.b.d) localObject1).b);
                        i = 0;
                        while (i < ((com.umeng.a.a.a.b.d) localObject1).b) {
                            localObject2 = new g();
                            ((g) localObject2).a(paramh);
                            paramp.b.add(localObject2);
                            i += 1;
                        }
                        paramh.q();
                        paramp.b(true);
                    } else {
                        com.umeng.a.a.a.b.k.a(paramh, ((com.umeng.a.a.a.b.c) localObject1).b);
                        continue;
                        if (((com.umeng.a.a.a.b.c) localObject1).b == 15) {
                            localObject1 = paramh.p();
                            paramp.c = new ArrayList(((com.umeng.a.a.a.b.d) localObject1).b);
                            i = 0;
                            while (i < ((com.umeng.a.a.a.b.d) localObject1).b) {
                                localObject2 = new i();
                                ((i) localObject2).a(paramh);
                                paramp.c.add(localObject2);
                                i += 1;
                            }
                            paramh.q();
                            paramp.c(true);
                        } else {
                            com.umeng.a.a.a.b.k.a(paramh, ((com.umeng.a.a.a.b.c) localObject1).b);
                            continue;
                            if (((com.umeng.a.a.a.b.c) localObject1).b == 15) {
                                localObject1 = paramh.p();
                                paramp.d = new ArrayList(((com.umeng.a.a.a.b.d) localObject1).b);
                                i = 0;
                                while (i < ((com.umeng.a.a.a.b.d) localObject1).b) {
                                    localObject2 = new i();
                                    ((i) localObject2).a(paramh);
                                    paramp.d.add(localObject2);
                                    i += 1;
                                }
                                paramh.q();
                                paramp.d(true);
                            } else {
                                com.umeng.a.a.a.b.k.a(paramh, ((com.umeng.a.a.a.b.c) localObject1).b);
                            }
                        }
                    }
                }
            }
        }

        public void b(h paramh, p paramp)
                throws j {
            paramp.v();
            paramh.a(p.w());
            if (paramp.a != null) {
                paramh.a(p.x());
                paramh.a(paramp.a);
                paramh.c();
            }
            Iterator localIterator;
            if ((paramp.b != null) && (paramp.k())) {
                paramh.a(p.y());
                paramh.a(new com.umeng.a.a.a.b.d((byte) 12, paramp.b.size()));
                localIterator = paramp.b.iterator();
                while (localIterator.hasNext()) {
                    ((g) localIterator.next()).b(paramh);
                }
                paramh.f();
                paramh.c();
            }
            if ((paramp.c != null) && (paramp.p())) {
                paramh.a(p.z());
                paramh.a(new com.umeng.a.a.a.b.d((byte) 12, paramp.c.size()));
                localIterator = paramp.c.iterator();
                while (localIterator.hasNext()) {
                    ((i) localIterator.next()).b(paramh);
                }
                paramh.f();
                paramh.c();
            }
            if ((paramp.d != null) && (paramp.u())) {
                paramh.a(p.A());
                paramh.a(new com.umeng.a.a.a.b.d((byte) 12, paramp.d.size()));
                paramp = paramp.d.iterator();
                while (paramp.hasNext()) {
                    ((i) paramp.next()).b(paramh);
                }
                paramh.f();
                paramh.c();
            }
            paramh.d();
            paramh.b();
        }
    }

    private static class b
            implements com.umeng.a.a.a.c.b {
        public p.a a() {
            return new p.a(null);
        }
    }

    private static class c
            extends com.umeng.a.a.a.c.d<p> {
        public void a(h paramh, p paramp)
                throws j {
            paramh = (n) paramh;
            paramh.a(paramp.a);
            Object localObject = new BitSet();
            if (paramp.k()) {
                ((BitSet) localObject).set(0);
            }
            if (paramp.p()) {
                ((BitSet) localObject).set(1);
            }
            if (paramp.u()) {
                ((BitSet) localObject).set(2);
            }
            paramh.a((BitSet) localObject, 3);
            if (paramp.k()) {
                paramh.a(paramp.b.size());
                localObject = paramp.b.iterator();
                while (((Iterator) localObject).hasNext()) {
                    ((g) ((Iterator) localObject).next()).b(paramh);
                }
            }
            if (paramp.p()) {
                paramh.a(paramp.c.size());
                localObject = paramp.c.iterator();
                while (((Iterator) localObject).hasNext()) {
                    ((i) ((Iterator) localObject).next()).b(paramh);
                }
            }
            if (paramp.u()) {
                paramh.a(paramp.d.size());
                paramp = paramp.d.iterator();
                while (paramp.hasNext()) {
                    ((i) paramp.next()).b(paramh);
                }
            }
        }

        public void b(h paramh, p paramp)
                throws j {
            int j = 0;
            paramh = (n) paramh;
            paramp.a = paramh.z();
            paramp.a(true);
            Object localObject1 = paramh.b(3);
            Object localObject2;
            int i;
            Object localObject3;
            if (((BitSet) localObject1).get(0)) {
                localObject2 = new com.umeng.a.a.a.b.d((byte) 12, paramh.w());
                paramp.b = new ArrayList(((com.umeng.a.a.a.b.d) localObject2).b);
                i = 0;
                while (i < ((com.umeng.a.a.a.b.d) localObject2).b) {
                    localObject3 = new g();
                    ((g) localObject3).a(paramh);
                    paramp.b.add(localObject3);
                    i += 1;
                }
                paramp.b(true);
            }
            if (((BitSet) localObject1).get(1)) {
                localObject2 = new com.umeng.a.a.a.b.d((byte) 12, paramh.w());
                paramp.c = new ArrayList(((com.umeng.a.a.a.b.d) localObject2).b);
                i = 0;
                while (i < ((com.umeng.a.a.a.b.d) localObject2).b) {
                    localObject3 = new i();
                    ((i) localObject3).a(paramh);
                    paramp.c.add(localObject3);
                    i += 1;
                }
                paramp.c(true);
            }
            if (((BitSet) localObject1).get(2)) {
                localObject1 = new com.umeng.a.a.a.b.d((byte) 12, paramh.w());
                paramp.d = new ArrayList(((com.umeng.a.a.a.b.d) localObject1).b);
                i = j;
                while (i < ((com.umeng.a.a.a.b.d) localObject1).b) {
                    localObject2 = new i();
                    ((i) localObject2).a(paramh);
                    paramp.d.add(localObject2);
                    i += 1;
                }
                paramp.d(true);
            }
        }
    }

    private static class d
            implements com.umeng.a.a.a.c.b {
        public p.c a() {
            return new p.c(null);
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


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/umeng/analytics/d/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */