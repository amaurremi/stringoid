package com.umeng.analytics.d;

import com.umeng.a.a.a.b.h;
import com.umeng.a.a.a.b.i;
import com.umeng.a.a.a.b.m;
import com.umeng.a.a.a.d.a;
import com.umeng.a.a.a.e;
import com.umeng.a.a.a.j;
import com.umeng.a.a.a.n;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class t
        extends n<t, a> {
    public static final Map<a, com.umeng.a.a.a.a.b> a;
    private static final m d = new m("PropertyValue");
    private static final com.umeng.a.a.a.b.c e = new com.umeng.a.a.a.b.c("string_value", (byte) 11, (short) 1);
    private static final com.umeng.a.a.a.b.c f = new com.umeng.a.a.a.b.c("long_value", (byte) 10, (short) 2);

    static {
        EnumMap localEnumMap = new EnumMap(a.class);
        localEnumMap.put(a.a, new com.umeng.a.a.a.a.b("string_value", (byte) 3, new com.umeng.a.a.a.a.c((byte) 11)));
        localEnumMap.put(a.b, new com.umeng.a.a.a.a.b("long_value", (byte) 3, new com.umeng.a.a.a.a.c((byte) 10)));
        a = Collections.unmodifiableMap(localEnumMap);
        com.umeng.a.a.a.a.b.a(t.class, a);
    }

    public t() {
    }

    public t(a parama, Object paramObject) {
        super(parama, paramObject);
    }

    public t(t paramt) {
        super(paramt);
    }

    public static t a(long paramLong) {
        t localt = new t();
        localt.b(paramLong);
        return localt;
    }

    public static t a(String paramString) {
        t localt = new t();
        localt.b(paramString);
        return localt;
    }

    private void a(ObjectInputStream paramObjectInputStream)
            throws IOException, ClassNotFoundException {
        try {
            a(new com.umeng.a.a.a.b.b(new a(paramObjectInputStream)));
            return;
        } catch (j paramObjectInputStream) {
            throw new IOException(paramObjectInputStream.getMessage());
        }
    }

    private void a(ObjectOutputStream paramObjectOutputStream)
            throws IOException {
        try {
            b(new com.umeng.a.a.a.b.b(new a(paramObjectOutputStream)));
            return;
        } catch (j paramObjectOutputStream) {
            throw new IOException(paramObjectOutputStream.getMessage());
        }
    }

    protected com.umeng.a.a.a.b.c a(a parama) {
        switch (1. a[parama.ordinal()])
        {
            default:
                throw new IllegalArgumentException("Unknown field id " + parama);
            case 1:
                return e;
        }
        return f;
    }

    public a a(int paramInt) {
        return a.a(paramInt);
    }

    protected a a(short paramShort) {
        return a.b(paramShort);
    }

    public t a() {
        return new t(this);
    }

    protected Object a(h paramh, com.umeng.a.a.a.b.c paramc)
            throws j {
        String str = null;
        a locala = a.a(paramc.c);
        if (locala != null) {
        }
        switch (1. a[locala.ordinal()])
        {
            default:
                throw new IllegalStateException("setField wasn't null, but didn't match any of the case statements!");
            case 1:
                if (paramc.b == e.b) {
                    str = paramh.z();
                    return str;
                }
                com.umeng.a.a.a.b.k.a(paramh, paramc.b);
                return null;
        }
        if (paramc.b == f.b) {
            return Long.valueOf(paramh.x());
        }
        com.umeng.a.a.a.b.k.a(paramh, paramc.b);
        return null;
    }

    protected Object a(h paramh, short paramShort)
            throws j {
        a locala = a.a(paramShort);
        if (locala != null) {
            switch (1. a[locala.ordinal()])
            {
                default:
                    throw new IllegalStateException("setField wasn't null, but didn't match any of the case statements!");
                case 1:
                    return paramh.z();
            }
            return Long.valueOf(paramh.x());
        }
        throw new i("Couldn't find a field with field id " + paramShort);
    }

    protected void a(a parama, Object paramObject)
            throws ClassCastException {
        switch (1. a[parama.ordinal()])
        {
            default:
                throw new IllegalArgumentException("Unknown field id " + parama);
            case 1:
                if (!(paramObject instanceof String)) {
                    break;
                }
        }
        do {
            return;
            throw new ClassCastException("Was expecting value of type String for field 'string_value', but got " + paramObject.getClass().getSimpleName());
        } while ((paramObject instanceof Long));
        throw new ClassCastException("Was expecting value of type Long for field 'long_value', but got " + paramObject.getClass().getSimpleName());
    }

    public boolean a(t paramt) {
        return (paramt != null) && (i() == paramt.i()) && (j().equals(paramt.j()));
    }

    public int b(t paramt) {
        int j = e.a((Comparable) i(), (Comparable) paramt.i());
        int i = j;
        if (j == 0) {
            i = e.a(j(), paramt.j());
        }
        return i;
    }

    public void b(long paramLong) {
        this.c = a.b;
        this.b = Long.valueOf(paramLong);
    }

    public void b(String paramString) {
        if (paramString == null) {
            throw new NullPointerException();
        }
        this.c = a.a;
        this.b = paramString;
    }

    protected m c() {
        return d;
    }

    protected void c(h paramh)
            throws j {
        switch (1. a[((a) this.c).ordinal()])
        {
            default:
                throw new IllegalStateException("Cannot write union with unknown field " + this.c);
            case 1:
                paramh.a((String) this.b);
                return;
        }
        paramh.a(((Long) this.b).longValue());
    }

    public String d() {
        if (i() == a.a) {
            return (String) j();
        }
        throw new RuntimeException("Cannot get field 'string_value' because union is currently set to " + a((a) i()).a);
    }

    protected void d(h paramh)
            throws j {
        switch (1. a[((a) this.c).ordinal()])
        {
            default:
                throw new IllegalStateException("Cannot write union with unknown field " + this.c);
            case 1:
                paramh.a((String) this.b);
                return;
        }
        paramh.a(((Long) this.b).longValue());
    }

    public long e() {
        if (i() == a.b) {
            return ((Long) j()).longValue();
        }
        throw new RuntimeException("Cannot get field 'long_value' because union is currently set to " + a((a) i()).a);
    }

    public boolean equals(Object paramObject) {
        if ((paramObject instanceof t)) {
            return a((t) paramObject);
        }
        return false;
    }

    public boolean f() {
        return this.c == a.a;
    }

    public boolean h() {
        return this.c == a.b;
    }

    public int hashCode() {
        return 0;
    }

    public static enum a
            implements com.umeng.a.a.a.k {
        private static final Map<String, a> c;
        private final short d;
        private final String e;

        static {
            c = new HashMap();
            Iterator localIterator = EnumSet.allOf(a.class).iterator();
            while (localIterator.hasNext()) {
                a locala = (a) localIterator.next();
                c.put(locala.b(), locala);
            }
        }

        private a(short paramShort, String paramString) {
            this.d = paramShort;
            this.e = paramString;
        }

        public static a a(int paramInt) {
            switch (paramInt) {
                default:
                    return null;
                case 1:
                    return a;
            }
            return b;
        }

        public static a a(String paramString) {
            return (a) c.get(paramString);
        }

        public static a b(int paramInt) {
            a locala = a(paramInt);
            if (locala == null) {
                throw new IllegalArgumentException("Field " + paramInt + " doesn't exist!");
            }
            return locala;
        }

        public short a() {
            return this.d;
        }

        public String b() {
            return this.e;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/umeng/analytics/d/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */