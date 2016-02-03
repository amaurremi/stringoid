package com.umeng.a.a.a;

import com.umeng.a.a.a.b.h;
import com.umeng.a.a.a.b.i;
import com.umeng.a.a.a.b.m;
import com.umeng.a.a.a.c.a;
import com.umeng.a.a.a.c.b;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public abstract class n<T extends n<?, ?>, F extends k>
        implements d<T, F> {
    private static final Map<Class<? extends a>, b> a = new HashMap();
    protected Object b;
    protected F c;

    static {
        a.put(com.umeng.a.a.a.c.c.class, new b(null));
        a.put(com.umeng.a.a.a.c.d.class, new d(null));
    }

    protected n() {
        this.c = null;
        this.b = null;
    }

    protected n(F paramF, Object paramObject) {
        b(paramF, paramObject);
    }

    protected n(n<T, F> paramn) {
        if (!paramn.getClass().equals(getClass())) {
            throw new ClassCastException();
        }
        this.c = paramn.c;
        this.b = a(paramn.b);
    }

    private static Object a(Object paramObject) {
        Object localObject;
        if ((paramObject instanceof d)) {
            localObject = ((d) paramObject).g();
        }
        do {
            return localObject;
            if ((paramObject instanceof ByteBuffer)) {
                return e.d((ByteBuffer) paramObject);
            }
            if ((paramObject instanceof List)) {
                return a((List) paramObject);
            }
            if ((paramObject instanceof Set)) {
                return a((Set) paramObject);
            }
            localObject = paramObject;
        } while (!(paramObject instanceof Map));
        return a((Map) paramObject);
    }

    private static List a(List paramList) {
        ArrayList localArrayList = new ArrayList(paramList.size());
        paramList = paramList.iterator();
        while (paramList.hasNext()) {
            localArrayList.add(a(paramList.next()));
        }
        return localArrayList;
    }

    private static Map a(Map<Object, Object> paramMap) {
        HashMap localHashMap = new HashMap();
        paramMap = paramMap.entrySet().iterator();
        while (paramMap.hasNext()) {
            Map.Entry localEntry = (Map.Entry) paramMap.next();
            localHashMap.put(a(localEntry.getKey()), a(localEntry.getValue()));
        }
        return localHashMap;
    }

    private static Set a(Set paramSet) {
        HashSet localHashSet = new HashSet();
        paramSet = paramSet.iterator();
        while (paramSet.hasNext()) {
            localHashSet.add(a(paramSet.next()));
        }
        return localHashSet;
    }

    protected abstract com.umeng.a.a.a.b.c a(F paramF);

    protected abstract Object a(h paramh, com.umeng.a.a.a.b.c paramc)
            throws j;

    protected abstract Object a(h paramh, short paramShort)
            throws j;

    public void a(int paramInt, Object paramObject) {
        b(b((short) paramInt), paramObject);
    }

    public void a(h paramh)
            throws j {
        ((b) a.get(paramh.D())).b().b(paramh, this);
    }

    protected abstract void a(F paramF, Object paramObject)
            throws ClassCastException;

    protected abstract F b(short paramShort);

    public Object b(F paramF) {
        if (paramF != this.c) {
            throw new IllegalArgumentException("Cannot get the value of field " + paramF + " because union's set field is " + this.c);
        }
        return j();
    }

    public final void b() {
        this.c = null;
        this.b = null;
    }

    public void b(h paramh)
            throws j {
        ((b) a.get(paramh.D())).b().a(paramh, this);
    }

    public void b(F paramF, Object paramObject) {
        a(paramF, paramObject);
        this.c = paramF;
        this.b = paramObject;
    }

    protected abstract m c();

    public Object c(int paramInt) {
        return b(b((short) paramInt));
    }

    protected abstract void c(h paramh)
            throws j;

    public boolean c(F paramF) {
        return this.c == paramF;
    }

    protected abstract void d(h paramh)
            throws j;

    public boolean d(int paramInt) {
        return c(b((short) paramInt));
    }

    public F i() {
        return this.c;
    }

    public Object j() {
        return this.b;
    }

    public boolean k() {
        return this.c != null;
    }

    public String toString() {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("<");
        localStringBuilder.append(getClass().getSimpleName());
        localStringBuilder.append(" ");
        Object localObject;
        if (i() != null) {
            localObject = j();
            localStringBuilder.append(a(i()).a);
            localStringBuilder.append(":");
            if (!(localObject instanceof ByteBuffer)) {
                break label96;
            }
            e.a((ByteBuffer) localObject, localStringBuilder);
        }
        for (; ; ) {
            localStringBuilder.append(">");
            return localStringBuilder.toString();
            label96:
            localStringBuilder.append(localObject.toString());
        }
    }

    private static class a
            extends com.umeng.a.a.a.c.c<n> {
        public void a(h paramh, n paramn)
                throws j {
            paramn.c = null;
            paramn.b = null;
            paramh.j();
            com.umeng.a.a.a.b.c localc = paramh.l();
            paramn.b = paramn.a(paramh, localc);
            if (paramn.b != null) {
                paramn.c = paramn.b(localc.c);
            }
            paramh.m();
            paramh.l();
            paramh.k();
        }

        public void b(h paramh, n paramn)
                throws j {
            if ((paramn.i() == null) || (paramn.j() == null)) {
                throw new i("Cannot write a TUnion with no set value!");
            }
            paramh.a(paramn.c());
            paramh.a(paramn.a(paramn.c));
            paramn.c(paramh);
            paramh.c();
            paramh.d();
            paramh.b();
        }
    }

    private static class b
            implements b {
        public n.a a() {
            return new n.a(null);
        }
    }

    private static class c
            extends com.umeng.a.a.a.c.d<n> {
        public void a(h paramh, n paramn)
                throws j {
            paramn.c = null;
            paramn.b = null;
            short s = paramh.v();
            paramn.b = paramn.a(paramh, s);
            if (paramn.b != null) {
                paramn.c = paramn.b(s);
            }
        }

        public void b(h paramh, n paramn)
                throws j {
            if ((paramn.i() == null) || (paramn.j() == null)) {
                throw new i("Cannot write a TUnion with no set value!");
            }
            paramh.a(paramn.c.a());
            paramn.d(paramh);
        }
    }

    private static class d
            implements b {
        public n.c a() {
            return new n.c(null);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/umeng/a/a/a/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */