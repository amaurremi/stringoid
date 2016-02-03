package com.umeng.analytics.d;

import com.umeng.a.a.a.a.g;
import com.umeng.a.a.a.b.h;
import com.umeng.a.a.a.b.i;
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
import java.util.Map.Entry;
import java.util.Set;

public class m
        implements com.umeng.a.a.a.d<m, e>, Serializable, Cloneable {
    public static final Map<e, com.umeng.a.a.a.a.b> d;
    private static final com.umeng.a.a.a.b.m e = new com.umeng.a.a.a.b.m("IdTracking");
    private static final com.umeng.a.a.a.b.c f = new com.umeng.a.a.a.b.c("snapshots", (byte) 13, (short) 1);
    private static final com.umeng.a.a.a.b.c g = new com.umeng.a.a.a.b.c("journals", (byte) 15, (short) 2);
    private static final com.umeng.a.a.a.b.c h = new com.umeng.a.a.a.b.c("checksum", (byte) 11, (short) 3);
    private static final Map<Class<? extends com.umeng.a.a.a.c.a>, com.umeng.a.a.a.c.b> i = new HashMap();
    public Map<String, l> a;
    public List<k> b;
    public String c;
    private e[] j = {e.b, e.c};

    static {
        i.put(com.umeng.a.a.a.c.c.class, new b(null));
        i.put(com.umeng.a.a.a.c.d.class, new d(null));
        EnumMap localEnumMap = new EnumMap(e.class);
        localEnumMap.put(e.a, new com.umeng.a.a.a.a.b("snapshots", (byte) 1, new com.umeng.a.a.a.a.e((byte) 13, new com.umeng.a.a.a.a.c((byte) 11), new g((byte) 12, l.class))));
        localEnumMap.put(e.b, new com.umeng.a.a.a.a.b("journals", (byte) 2, new com.umeng.a.a.a.a.d((byte) 15, new g((byte) 12, k.class))));
        localEnumMap.put(e.c, new com.umeng.a.a.a.a.b("checksum", (byte) 2, new com.umeng.a.a.a.a.c((byte) 11)));
        d = Collections.unmodifiableMap(localEnumMap);
        com.umeng.a.a.a.a.b.a(m.class, d);
    }

    public m() {
    }

    public m(m paramm) {
        Object localObject;
        Iterator localIterator;
        if (paramm.f()) {
            localObject = new HashMap();
            localIterator = paramm.a.entrySet().iterator();
            while (localIterator.hasNext()) {
                Map.Entry localEntry = (Map.Entry) localIterator.next();
                ((Map) localObject).put((String) localEntry.getKey(), new l((l) localEntry.getValue()));
            }
            this.a = ((Map) localObject);
        }
        if (paramm.l()) {
            localObject = new ArrayList();
            localIterator = paramm.b.iterator();
            while (localIterator.hasNext()) {
                ((List) localObject).add(new k((k) localIterator.next()));
            }
            this.b = ((List) localObject);
        }
        if (paramm.o()) {
            this.c = paramm.c;
        }
    }

    public m(Map<String, l> paramMap) {
        this();
        this.a = paramMap;
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

    public m a() {
        return new m(this);
    }

    public m a(String paramString) {
        this.c = paramString;
        return this;
    }

    public m a(List<k> paramList) {
        this.b = paramList;
        return this;
    }

    public m a(Map<String, l> paramMap) {
        this.a = paramMap;
        return this;
    }

    public void a(h paramh)
            throws j {
        ((com.umeng.a.a.a.c.b) i.get(paramh.D())).b().b(paramh, this);
    }

    public void a(k paramk) {
        if (this.b == null) {
            this.b = new ArrayList();
        }
        this.b.add(paramk);
    }

    public void a(String paramString, l paraml) {
        if (this.a == null) {
            this.a = new HashMap();
        }
        this.a.put(paramString, paraml);
    }

    public void a(boolean paramBoolean) {
        if (!paramBoolean) {
            this.a = null;
        }
    }

    public void b() {
        this.a = null;
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
        if (this.a == null) {
            return 0;
        }
        return this.a.size();
    }

    public void c(boolean paramBoolean) {
        if (!paramBoolean) {
            this.c = null;
        }
    }

    public Map<String, l> d() {
        return this.a;
    }

    public void e() {
        this.a = null;
    }

    public boolean f() {
        return this.a != null;
    }

    public int h() {
        if (this.b == null) {
            return 0;
        }
        return this.b.size();
    }

    public Iterator<k> i() {
        if (this.b == null) {
            return null;
        }
        return this.b.iterator();
    }

    public List<k> j() {
        return this.b;
    }

    public void k() {
        this.b = null;
    }

    public boolean l() {
        return this.b != null;
    }

    public String m() {
        return this.c;
    }

    public void n() {
        this.c = null;
    }

    public boolean o() {
        return this.c != null;
    }

    public void p()
            throws j {
        if (this.a == null) {
            throw new i("Required field 'snapshots' was not present! Struct: " + toString());
        }
    }

    public String toString() {
        StringBuilder localStringBuilder = new StringBuilder("IdTracking(");
        localStringBuilder.append("snapshots:");
        if (this.a == null) {
            localStringBuilder.append("null");
            if (l()) {
                localStringBuilder.append(", ");
                localStringBuilder.append("journals:");
                if (this.b != null) {
                    break label135;
                }
                localStringBuilder.append("null");
            }
            label72:
            if (o()) {
                localStringBuilder.append(", ");
                localStringBuilder.append("checksum:");
                if (this.c != null) {
                    break label147;
                }
                localStringBuilder.append("null");
            }
        }
        for (; ; ) {
            localStringBuilder.append(")");
            return localStringBuilder.toString();
            localStringBuilder.append(this.a);
            break;
            label135:
            localStringBuilder.append(this.b);
            break label72;
            label147:
            localStringBuilder.append(this.c);
        }
    }

    private static class a
            extends com.umeng.a.a.a.c.c<m> {
        public void a(h paramh, m paramm)
                throws j {
            paramh.j();
            Object localObject1 = paramh.l();
            if (((com.umeng.a.a.a.b.c) localObject1).b == 0) {
                paramh.k();
                paramm.p();
                return;
            }
            switch (((com.umeng.a.a.a.b.c) localObject1).c) {
                default:
                    com.umeng.a.a.a.b.k.a(paramh, ((com.umeng.a.a.a.b.c) localObject1).b);
            }
            for (; ; ) {
                paramh.m();
                break;
                int i;
                Object localObject2;
                if (((com.umeng.a.a.a.b.c) localObject1).b == 13) {
                    localObject1 = paramh.n();
                    paramm.a = new HashMap(((com.umeng.a.a.a.b.e) localObject1).c * 2);
                    i = 0;
                    while (i < ((com.umeng.a.a.a.b.e) localObject1).c) {
                        localObject2 = paramh.z();
                        l locall = new l();
                        locall.a(paramh);
                        paramm.a.put(localObject2, locall);
                        i += 1;
                    }
                    paramh.o();
                    paramm.a(true);
                } else {
                    com.umeng.a.a.a.b.k.a(paramh, ((com.umeng.a.a.a.b.c) localObject1).b);
                    continue;
                    if (((com.umeng.a.a.a.b.c) localObject1).b == 15) {
                        localObject1 = paramh.p();
                        paramm.b = new ArrayList(((com.umeng.a.a.a.b.d) localObject1).b);
                        i = 0;
                        while (i < ((com.umeng.a.a.a.b.d) localObject1).b) {
                            localObject2 = new k();
                            ((k) localObject2).a(paramh);
                            paramm.b.add(localObject2);
                            i += 1;
                        }
                        paramh.q();
                        paramm.b(true);
                    } else {
                        com.umeng.a.a.a.b.k.a(paramh, ((com.umeng.a.a.a.b.c) localObject1).b);
                        continue;
                        if (((com.umeng.a.a.a.b.c) localObject1).b == 11) {
                            paramm.c = paramh.z();
                            paramm.c(true);
                        } else {
                            com.umeng.a.a.a.b.k.a(paramh, ((com.umeng.a.a.a.b.c) localObject1).b);
                        }
                    }
                }
            }
        }

        public void b(h paramh, m paramm)
                throws j {
            paramm.p();
            paramh.a(m.q());
            Iterator localIterator;
            if (paramm.a != null) {
                paramh.a(m.r());
                paramh.a(new com.umeng.a.a.a.b.e((byte) 11, (byte) 12, paramm.a.size()));
                localIterator = paramm.a.entrySet().iterator();
                while (localIterator.hasNext()) {
                    Map.Entry localEntry = (Map.Entry) localIterator.next();
                    paramh.a((String) localEntry.getKey());
                    ((l) localEntry.getValue()).b(paramh);
                }
                paramh.e();
                paramh.c();
            }
            if ((paramm.b != null) && (paramm.l())) {
                paramh.a(m.s());
                paramh.a(new com.umeng.a.a.a.b.d((byte) 12, paramm.b.size()));
                localIterator = paramm.b.iterator();
                while (localIterator.hasNext()) {
                    ((k) localIterator.next()).b(paramh);
                }
                paramh.f();
                paramh.c();
            }
            if ((paramm.c != null) && (paramm.o())) {
                paramh.a(m.t());
                paramh.a(paramm.c);
                paramh.c();
            }
            paramh.d();
            paramh.b();
        }
    }

    private static class b
            implements com.umeng.a.a.a.c.b {
        public m.a a() {
            return new m.a(null);
        }
    }

    private static class c
            extends com.umeng.a.a.a.c.d<m> {
        public void a(h paramh, m paramm)
                throws j {
            paramh = (n) paramh;
            paramh.a(paramm.a.size());
            Object localObject = paramm.a.entrySet().iterator();
            while (((Iterator) localObject).hasNext()) {
                Map.Entry localEntry = (Map.Entry) ((Iterator) localObject).next();
                paramh.a((String) localEntry.getKey());
                ((l) localEntry.getValue()).b(paramh);
            }
            localObject = new BitSet();
            if (paramm.l()) {
                ((BitSet) localObject).set(0);
            }
            if (paramm.o()) {
                ((BitSet) localObject).set(1);
            }
            paramh.a((BitSet) localObject, 2);
            if (paramm.l()) {
                paramh.a(paramm.b.size());
                localObject = paramm.b.iterator();
                while (((Iterator) localObject).hasNext()) {
                    ((k) ((Iterator) localObject).next()).b(paramh);
                }
            }
            if (paramm.o()) {
                paramh.a(paramm.c);
            }
        }

        public void b(h paramh, m paramm)
                throws j {
            int j = 0;
            paramh = (n) paramh;
            Object localObject1 = new com.umeng.a.a.a.b.e((byte) 11, (byte) 12, paramh.w());
            paramm.a = new HashMap(((com.umeng.a.a.a.b.e) localObject1).c * 2);
            int i = 0;
            Object localObject2;
            Object localObject3;
            while (i < ((com.umeng.a.a.a.b.e) localObject1).c) {
                localObject2 = paramh.z();
                localObject3 = new l();
                ((l) localObject3).a(paramh);
                paramm.a.put(localObject2, localObject3);
                i += 1;
            }
            paramm.a(true);
            localObject1 = paramh.b(2);
            if (((BitSet) localObject1).get(0)) {
                localObject2 = new com.umeng.a.a.a.b.d((byte) 12, paramh.w());
                paramm.b = new ArrayList(((com.umeng.a.a.a.b.d) localObject2).b);
                i = j;
                while (i < ((com.umeng.a.a.a.b.d) localObject2).b) {
                    localObject3 = new k();
                    ((k) localObject3).a(paramh);
                    paramm.b.add(localObject3);
                    i += 1;
                }
                paramm.b(true);
            }
            if (((BitSet) localObject1).get(1)) {
                paramm.c = paramh.z();
                paramm.c(true);
            }
        }
    }

    private static class d
            implements com.umeng.a.a.a.c.b {
        public m.c a() {
            return new m.c(null);
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


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/umeng/analytics/d/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */