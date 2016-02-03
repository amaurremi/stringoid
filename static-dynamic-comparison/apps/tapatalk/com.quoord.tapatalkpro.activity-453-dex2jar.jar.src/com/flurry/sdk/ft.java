package com.flurry.sdk;

import java.nio.ByteBuffer;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ft {
    private static final ft a = new ft();
    private static final fn b = fn.a(fn.v.g);

    public static ft a() {
        return a;
    }

    private void a(String paramString, StringBuilder paramStringBuilder) {
        int i = 0;
        if (i < paramString.length()) {
            char c = paramString.charAt(i);
            int j;
            switch (c) {
                default:
                    if (((c >= 0) && (c <= '\037')) || ((c >= '') && (c <= '')) || ((c >= ' ') && (c <= '⃿'))) {
                        Integer.toHexString(c);
                        paramStringBuilder.append("\\u");
                        j = 0;
                    }
                    break;
                case '"':
                    while (j < 4 - paramStringBuilder.length()) {
                        paramStringBuilder.append('0');
                        j += 1;
                        continue;
                        paramStringBuilder.append("\\\"");
                    }
            }
            for (; ; ) {
                i += 1;
                break;
                paramStringBuilder.append("\\\\");
                continue;
                paramStringBuilder.append("\\b");
                continue;
                paramStringBuilder.append("\\f");
                continue;
                paramStringBuilder.append("\\n");
                continue;
                paramStringBuilder.append("\\r");
                continue;
                paramStringBuilder.append("\\t");
                continue;
                paramStringBuilder.append("\\/");
                continue;
                paramStringBuilder.append(paramString.toUpperCase());
                continue;
                paramStringBuilder.append(c);
            }
        }
    }

    protected int a(int paramInt, Object paramObject, fn paramfn) {
        return paramInt * 31 + b(paramObject, paramfn);
    }

    public int a(fn paramfn, Object paramObject) {
        Integer localInteger = paramfn.e(b(paramObject));
        if (localInteger != null) {
            return localInteger.intValue();
        }
        throw new fp(paramfn, paramObject);
    }

    public int a(Object paramObject1, Object paramObject2, fn paramfn) {
        return a(paramObject1, paramObject2, paramfn, false);
    }

    protected int a(Object paramObject1, Object paramObject2, fn paramfn, boolean paramBoolean) {
        int i = 1;
        if (paramObject1 == paramObject2) {
        }
        do {
            return 0;
            switch (1. a[paramfn.a().ordinal()])
            {
                case 14:
                case 6:
                case 8:
                case 9:
                case 10:
                case 11:
                case 12:
                case 13:
                default:
                    return ((Comparable) paramObject1).compareTo(paramObject2);
                case 1:
                    paramfn = paramfn.b().iterator();
                    fn.f localf;
                    do {
                        do {
                            if (!paramfn.hasNext()) {
                                break;
                            }
                            localf = (fn.f) paramfn.next();
                        } while (localf.f() == fn.f.a.c);
                        i = localf.b();
                        String str = localf.a();
                        i = a(a(paramObject1, str, i), a(paramObject2, str, i), localf.c(), paramBoolean);
                    } while (i == 0);
                    if (localf.f() == fn.f.a.b) {
                        i = -i;
                    }
                    for (; ; ) {
                        return i;
                    }
                case 2:
                    return paramfn.c(paramObject1.toString()) - paramfn.c(paramObject2.toString());
                case 3:
                    paramObject1 = (Collection) paramObject1;
                    paramObject2 = (Collection) paramObject2;
                    paramObject1 = ((Collection) paramObject1).iterator();
                    paramObject2 = ((Collection) paramObject2).iterator();
                    paramfn = paramfn.i();
                    while ((((Iterator) paramObject1).hasNext()) && (((Iterator) paramObject2).hasNext())) {
                        j = a(((Iterator) paramObject1).next(), ((Iterator) paramObject2).next(), paramfn, paramBoolean);
                        if (j != 0) {
                            return j;
                        }
                    }
                    if (((Iterator) paramObject1).hasNext()) {
                    }
                    for (; ; ) {
                        return i;
                        if (((Iterator) paramObject2).hasNext()) {
                            i = -1;
                        } else {
                            i = 0;
                        }
                    }
                case 4:
                    if (!paramBoolean) {
                        break label361;
                    }
            }
        } while (((Map) paramObject1).equals(paramObject2));
        return 1;
        label361:
        throw new fk("Can't compare maps!");
        i = a(paramfn, paramObject1);
        int j = a(paramfn, paramObject2);
        if (i == j) {
            i = a(paramObject1, paramObject2, (fn) paramfn.k().get(i), paramBoolean);
        }
        for (; ; ) {
            return i;
            i -= j;
        }
        if ((paramObject1 instanceof gy)) {
            paramObject1 = (gy) paramObject1;
            if (!(paramObject2 instanceof gy)) {
                break label476;
            }
        }
        label476:
        for (paramObject2 = (gy) paramObject2; ; paramObject2 = new gy(paramObject2.toString())) {
            return ((gy) paramObject1).a((gy) paramObject2);
            paramObject1 = new gy(paramObject1.toString());
            break;
        }
    }

    public ge a(fn paramfn) {
        return new fu(paramfn, paramfn, this);
    }

    protected Object a(Object paramObject, fn paramfn) {
        return null;
    }

    public Object a(Object paramObject, String paramString, int paramInt) {
        return ((fz) paramObject).a(paramInt);
    }

    public Object a(Object paramObject, byte[] paramArrayOfByte, fn paramfn) {
        paramObject = (fx) c(paramObject, paramfn);
        System.arraycopy(paramArrayOfByte, 0, ((fx) paramObject).b(), 0, paramfn.l());
        return paramObject;
    }

    public String a(Object paramObject) {
        StringBuilder localStringBuilder = new StringBuilder();
        a(paramObject, localStringBuilder);
        return localStringBuilder.toString();
    }

    public void a(Object paramObject1, String paramString, int paramInt, Object paramObject2) {
        ((fz) paramObject1).a(paramInt, paramObject2);
    }

    protected void a(Object paramObject1, String paramString, int paramInt, Object paramObject2, Object paramObject3) {
        a(paramObject1, paramString, paramInt, paramObject2);
    }

    protected void a(Object paramObject, StringBuilder paramStringBuilder) {
        int i = 0;
        Object localObject1;
        Object localObject2;
        if (d(paramObject)) {
            paramStringBuilder.append("{");
            localObject1 = e(paramObject);
            localObject2 = ((fn) localObject1).b().iterator();
            i = 0;
            while (((Iterator) localObject2).hasNext()) {
                fn.f localf = (fn.f) ((Iterator) localObject2).next();
                a(localf.a(), paramStringBuilder);
                paramStringBuilder.append(": ");
                a(a(paramObject, localf.a(), localf.b()), paramStringBuilder);
                i += 1;
                if (i < ((fn) localObject1).b().size()) {
                    paramStringBuilder.append(", ");
                }
            }
            paramStringBuilder.append("}");
            return;
        }
        if ((paramObject instanceof Collection)) {
            paramObject = (Collection) paramObject;
            paramStringBuilder.append("[");
            long l = ((Collection) paramObject).size() - 1;
            paramObject = ((Collection) paramObject).iterator();
            while (((Iterator) paramObject).hasNext()) {
                a(((Iterator) paramObject).next(), paramStringBuilder);
                if (i < l) {
                    paramStringBuilder.append(", ");
                }
                i += 1;
            }
            paramStringBuilder.append("]");
            return;
        }
        if ((paramObject instanceof Map)) {
            paramStringBuilder.append("{");
            paramObject = (Map) paramObject;
            localObject1 = ((Map) paramObject).entrySet().iterator();
            i = 0;
            while (((Iterator) localObject1).hasNext()) {
                localObject2 = (Map.Entry) ((Iterator) localObject1).next();
                a(((Map.Entry) localObject2).getKey(), paramStringBuilder);
                paramStringBuilder.append(": ");
                a(((Map.Entry) localObject2).getValue(), paramStringBuilder);
                i += 1;
                if (i < ((Map) paramObject).size()) {
                    paramStringBuilder.append(", ");
                }
            }
            paramStringBuilder.append("}");
            return;
        }
        if (((paramObject instanceof CharSequence)) || ((paramObject instanceof fw))) {
            paramStringBuilder.append("\"");
            a(paramObject.toString(), paramStringBuilder);
            paramStringBuilder.append("\"");
            return;
        }
        if ((paramObject instanceof ByteBuffer)) {
            paramStringBuilder.append("{\"bytes\": \"");
            paramObject = (ByteBuffer) paramObject;
            i = ((ByteBuffer) paramObject).position();
            while (i < ((ByteBuffer) paramObject).limit()) {
                paramStringBuilder.append((char) ((ByteBuffer) paramObject).get(i));
                i += 1;
            }
            paramStringBuilder.append("\"}");
            return;
        }
        paramStringBuilder.append(paramObject);
    }

    public int b(Object paramObject, fn paramfn) {
        int j = 0;
        if (paramObject == null) {
            return j;
        }
        int i = 1;
        switch (1. a[paramfn.a().ordinal()])
        {
            case 14:
            case 4:
            case 6:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            default:
                return paramObject.hashCode();
            case 1:
                paramfn = paramfn.b().iterator();
                i = 1;
                for (; ; ) {
                    j = i;
                    if (!paramfn.hasNext()) {
                        break;
                    }
                    fn.f localf = (fn.f) paramfn.next();
                    if (localf.f() != fn.f.a.c) {
                        i = a(i, a(paramObject, localf.a(), localf.b()), localf.c());
                    }
                }
            case 3:
                paramObject = (Collection) paramObject;
                paramfn = paramfn.i();
                paramObject = ((Collection) paramObject).iterator();
                while (((Iterator) paramObject).hasNext()) {
                    i = a(i, ((Iterator) paramObject).next(), paramfn);
                }
                return i;
            case 5:
                return b(paramObject, (fn) paramfn.k().get(a(paramfn, paramObject)));
            case 2:
                return paramfn.c(paramObject.toString());
        }
        if ((paramObject instanceof gy)) {
        }
        for (; ; ) {
            return paramObject.hashCode();
            paramObject = new gy(paramObject.toString());
        }
    }

    public Object b(fn paramfn, Object paramObject) {
        Object localObject1;
        if (paramObject == null) {
            localObject1 = null;
        }
        do {
            return localObject1;
            localObject1 = paramObject;
            Object localObject2;
            switch (1. a[paramfn.a().ordinal()])
            {
                case 2:
                default:
                    throw new fk("Deep copy failed for schema \"" + paramfn + "\" and value \"" + paramObject + "\"");
                case 3:
                    localObject1 = (List) paramObject;
                    paramObject = new a(((List) localObject1).size(), paramfn);
                    localObject1 = ((List) localObject1).iterator();
                    while (((Iterator) localObject1).hasNext()) {
                        localObject2 = ((Iterator) localObject1).next();
                        ((List) paramObject).add(b(paramfn.i(), localObject2));
                    }
                    return paramObject;
                case 13:
                    return new Boolean(((Boolean) paramObject).booleanValue());
                case 8:
                    paramfn = (ByteBuffer) paramObject;
                    paramObject = new byte[paramfn.capacity()];
                    paramfn.rewind();
                    paramfn.get((byte[]) paramObject);
                    paramfn.rewind();
                    return ByteBuffer.wrap((byte[]) paramObject);
                case 12:
                    return new Double(((Double) paramObject).doubleValue());
                case 6:
                    return a(null, ((fx) paramObject).b(), paramfn);
                case 11:
                    return new Float(((Float) paramObject).floatValue());
                case 9:
                    return new Integer(((Integer) paramObject).intValue());
                case 10:
                    return new Long(((Long) paramObject).longValue());
                case 4:
                    localObject1 = (Map) paramObject;
                    paramObject = new HashMap(((Map) localObject1).size());
                    localObject1 = ((Map) localObject1).entrySet().iterator();
                    while (((Iterator) localObject1).hasNext()) {
                        localObject2 = (Map.Entry) ((Iterator) localObject1).next();
                        ((Map) paramObject).put((CharSequence) b(b, ((Map.Entry) localObject2).getKey()), b(paramfn.j(), ((Map.Entry) localObject2).getValue()));
                    }
                    return paramObject;
                case 14:
                    return null;
                case 1:
                    paramObject = (fz) paramObject;
                    localObject1 = (fz) d(null, paramfn);
                    paramfn = paramfn.b().iterator();
                    while (paramfn.hasNext()) {
                        localObject2 = (fn.f) paramfn.next();
                        ((fz) localObject1).a(((fn.f) localObject2).b(), b(((fn.f) localObject2).c(), ((fz) paramObject).a(((fn.f) localObject2).b())));
                    }
                    return localObject1;
                case 7:
                    localObject1 = paramObject;
            }
        } while ((paramObject instanceof String));
        if ((paramObject instanceof gy)) {
            return new gy((gy) paramObject);
        }
        return new gy(paramObject.toString());
        return b((fn) paramfn.k().get(a(paramfn, paramObject)), paramObject);
    }

    protected Object b(Object paramObject1, String paramString, int paramInt, Object paramObject2) {
        return a(paramObject1, paramString, paramInt);
    }

    protected String b(Object paramObject) {
        if (paramObject == null) {
            return fn.v.n.a();
        }
        if (d(paramObject)) {
            return e(paramObject).g();
        }
        if (f(paramObject)) {
            return g(paramObject).g();
        }
        if (c(paramObject)) {
            return fn.v.c.a();
        }
        if (h(paramObject)) {
            return fn.v.d.a();
        }
        if (i(paramObject)) {
            return j(paramObject).g();
        }
        if (k(paramObject)) {
            return fn.v.g.a();
        }
        if (l(paramObject)) {
            return fn.v.h.a();
        }
        if ((paramObject instanceof Integer)) {
            return fn.v.i.a();
        }
        if ((paramObject instanceof Long)) {
            return fn.v.j.a();
        }
        if ((paramObject instanceof Float)) {
            return fn.v.k.a();
        }
        if ((paramObject instanceof Double)) {
            return fn.v.l.a();
        }
        if ((paramObject instanceof Boolean)) {
            return fn.v.m.a();
        }
        throw new fk("Unknown datum type: " + paramObject);
    }

    public Object c(Object paramObject, fn paramfn) {
        if (((paramObject instanceof fx)) && (((fx) paramObject).b().length == paramfn.l())) {
            return paramObject;
        }
        return new c(paramfn);
    }

    protected boolean c(Object paramObject) {
        return paramObject instanceof Collection;
    }

    public Object d(Object paramObject, fn paramfn) {
        if ((paramObject instanceof fz)) {
            paramObject = (fz) paramObject;
            if (((fz) paramObject).a() == paramfn) {
                return paramObject;
            }
        }
        return new d(paramfn);
    }

    protected boolean d(Object paramObject) {
        return paramObject instanceof fz;
    }

    protected fn e(Object paramObject) {
        return ((fs) paramObject).a();
    }

    protected boolean f(Object paramObject) {
        return paramObject instanceof fw;
    }

    protected fn g(Object paramObject) {
        return ((fs) paramObject).a();
    }

    protected boolean h(Object paramObject) {
        return paramObject instanceof Map;
    }

    protected boolean i(Object paramObject) {
        return paramObject instanceof fx;
    }

    protected fn j(Object paramObject) {
        return ((fs) paramObject).a();
    }

    protected boolean k(Object paramObject) {
        return paramObject instanceof CharSequence;
    }

    protected boolean l(Object paramObject) {
        return paramObject instanceof ByteBuffer;
    }

    public static class a<T>
            extends AbstractList<T>
            implements fr<T>, Comparable<fr<T>> {
        private static final Object[] a = new Object[0];
        private final fn b;
        private int c;
        private Object[] d = a;

        public a(int paramInt, fn paramfn) {
            if ((paramfn == null) || (!fn.v.c.equals(paramfn.a()))) {
                throw new fk("Not an array schema: " + paramfn);
            }
            this.b = paramfn;
            if (paramInt != 0) {
                this.d = new Object[paramInt];
            }
        }

        public int a(fr<T> paramfr) {
            return ft.a().a(this, paramfr, a());
        }

        public fn a() {
            return this.b;
        }

        public void add(int paramInt, T paramT) {
            if ((paramInt > this.c) || (paramInt < 0)) {
                throw new IndexOutOfBoundsException("Index " + paramInt + " out of bounds.");
            }
            if (this.c == this.d.length) {
                Object[] arrayOfObject = new Object[this.c * 3 / 2 + 1];
                System.arraycopy(this.d, 0, arrayOfObject, 0, this.c);
                this.d = arrayOfObject;
            }
            System.arraycopy(this.d, paramInt, this.d, paramInt + 1, this.c - paramInt);
            this.d[paramInt] = paramT;
            this.c += 1;
        }

        public boolean add(T paramT) {
            if (this.c == this.d.length) {
                arrayOfObject = new Object[this.c * 3 / 2 + 1];
                System.arraycopy(this.d, 0, arrayOfObject, 0, this.c);
                this.d = arrayOfObject;
            }
            Object[] arrayOfObject = this.d;
            int i = this.c;
            this.c = (i + 1);
            arrayOfObject[i] = paramT;
            return true;
        }

        public T b() {
            if (this.c < this.d.length) {
                return (T) this.d[this.c];
            }
            return null;
        }

        public void clear() {
            this.c = 0;
        }

        public T get(int paramInt) {
            if (paramInt >= this.c) {
                throw new IndexOutOfBoundsException("Index " + paramInt + " out of bounds.");
            }
            return (T) this.d[paramInt];
        }

        public Iterator<T> iterator() {
            new Iterator() {
                private int b = 0;

                public boolean hasNext() {
                    return this.b < ft.a.a(ft.a.this);
                }

                public T next() {
                    Object[] arrayOfObject = ft.a.b(ft.a.this);
                    int i = this.b;
                    this.b = (i + 1);
                    return (T) arrayOfObject[i];
                }

                public void remove() {
                    throw new UnsupportedOperationException();
                }
            };
        }

        public T remove(int paramInt) {
            if (paramInt >= this.c) {
                throw new IndexOutOfBoundsException("Index " + paramInt + " out of bounds.");
            }
            Object localObject = this.d[paramInt];
            this.c -= 1;
            System.arraycopy(this.d, paramInt + 1, this.d, paramInt, this.c - paramInt);
            this.d[this.c] = null;
            return (T) localObject;
        }

        public T set(int paramInt, T paramT) {
            if (paramInt >= this.c) {
                throw new IndexOutOfBoundsException("Index " + paramInt + " out of bounds.");
            }
            Object localObject = this.d[paramInt];
            this.d[paramInt] = paramT;
            return (T) localObject;
        }

        public int size() {
            return this.c;
        }

        public String toString() {
            StringBuffer localStringBuffer = new StringBuffer();
            localStringBuffer.append("[");
            int i = 0;
            Iterator localIterator = iterator();
            if (localIterator.hasNext()) {
                Object localObject = localIterator.next();
                if (localObject == null) {
                }
                for (localObject = "null"; ; localObject = localObject.toString()) {
                    localStringBuffer.append((String) localObject);
                    int j = i + 1;
                    i = j;
                    if (j >= size()) {
                        break;
                    }
                    localStringBuffer.append(", ");
                    i = j;
                    break;
                }
            }
            localStringBuffer.append("]");
            return localStringBuffer.toString();
        }
    }

    public static class b
            implements fw {
        private fn a;
        private String b;

        public b(fn paramfn, String paramString) {
            this.a = paramfn;
            this.b = paramString;
        }

        public fn a() {
            return this.a;
        }

        public boolean equals(Object paramObject) {
            if (paramObject == this) {
            }
            while (((paramObject instanceof fw)) && (this.b.equals(paramObject.toString()))) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.b.hashCode();
        }

        public String toString() {
            return this.b;
        }
    }

    public static class c
            implements fx, Comparable<c> {
        private fn a;
        private byte[] b;

        protected c() {
        }

        public c(fn paramfn) {
            a(paramfn);
        }

        public int a(c paramc) {
            return ga.a(this.b, 0, this.b.length, paramc.b, 0, paramc.b.length);
        }

        public fn a() {
            return this.a;
        }

        protected void a(fn paramfn) {
            this.a = paramfn;
            this.b = new byte[paramfn.l()];
        }

        public byte[] b() {
            return this.b;
        }

        public boolean equals(Object paramObject) {
            if (paramObject == this) {
            }
            while (((paramObject instanceof fx)) && (Arrays.equals(this.b, ((fx) paramObject).b()))) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return Arrays.hashCode(this.b);
        }

        public String toString() {
            return Arrays.toString(this.b);
        }
    }

    public static class d
            implements fy, Comparable<d> {
        private final fn a;
        private final Object[] b;

        public d(fn paramfn) {
            if ((paramfn == null) || (!fn.v.a.equals(paramfn.a()))) {
                throw new fk("Not a record schema: " + paramfn);
            }
            this.a = paramfn;
            this.b = new Object[paramfn.b().size()];
        }

        public int a(d paramd) {
            return ft.a().a(this, paramd, this.a);
        }

        public fn a() {
            return this.a;
        }

        public Object a(int paramInt) {
            return this.b[paramInt];
        }

        public void a(int paramInt, Object paramObject) {
            this.b[paramInt] = paramObject;
        }

        public boolean equals(Object paramObject) {
            if (paramObject == this) {
            }
            do {
                return true;
                if (!(paramObject instanceof d)) {
                    return false;
                }
                paramObject = (d) paramObject;
                if (!this.a.g().equals(((d) paramObject).a.g())) {
                    return false;
                }
            } while (ft.a().a(this, paramObject, this.a, true) == 0);
            return false;
        }

        public int hashCode() {
            return ft.a().b(this, this.a);
        }

        public String toString() {
            return ft.a().a(this);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/ft.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */