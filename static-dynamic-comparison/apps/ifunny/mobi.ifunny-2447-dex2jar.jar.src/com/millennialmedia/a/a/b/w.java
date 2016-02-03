package com.millennialmedia.a.a.b;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;

public final class w<K, V>
        extends AbstractMap<K, V>
        implements Serializable {
    private static final Comparator<Comparable> h;
    Comparator<? super K> a;
    af<K, V>[] b;
    final af<K, V> c;
    int d = 0;
    int e = 0;
    int f;
    private w<K, V>.aa i;
    private w<K, V>.ac j;

    static {
        if (!w.class.desiredAssertionStatus()) {
        }
        for (boolean bool = true; ; bool = false) {
            g = bool;
            h = new x();
            return;
        }
    }

    public w() {
        this(h);
    }

    public w(Comparator<? super K> paramComparator) {
        if (paramComparator != null) {
        }
        for (; ; ) {
            this.a = paramComparator;
            this.c = new af();
            this.b = new af[16];
            this.f = (this.b.length / 2 + this.b.length / 4);
            return;
            paramComparator = h;
        }
    }

    private static int a(int paramInt) {
        paramInt = paramInt >>> 20 ^ paramInt >>> 12 ^ paramInt;
        return paramInt >>> 4 ^ paramInt >>> 7 ^ paramInt;
    }

    private void a() {
        this.b = a(this.b);
        this.f = (this.b.length / 2 + this.b.length / 4);
    }

    private void a(af<K, V> paramaf) {
        int n = 0;
        af localaf1 = paramaf.b;
        af localaf2 = paramaf.c;
        af localaf3 = localaf2.b;
        af localaf4 = localaf2.c;
        paramaf.c = localaf3;
        if (localaf3 != null) {
            localaf3.a = paramaf;
        }
        a(paramaf, localaf2);
        localaf2.b = paramaf;
        paramaf.a = localaf2;
        int k;
        if (localaf1 != null) {
            k = localaf1.i;
            if (localaf3 == null) {
                break label135;
            }
        }
        label135:
        for (int m = localaf3.i; ; m = 0) {
            paramaf.i = (Math.max(k, m) + 1);
            m = paramaf.i;
            k = n;
            if (localaf4 != null) {
                k = localaf4.i;
            }
            localaf2.i = (Math.max(m, k) + 1);
            return;
            k = 0;
            break;
        }
    }

    private void a(af<K, V> paramaf1, af<K, V> paramaf2) {
        af localaf = paramaf1.a;
        paramaf1.a = null;
        if (paramaf2 != null) {
            paramaf2.a = localaf;
        }
        if (localaf != null) {
            if (localaf.b == paramaf1) {
                localaf.b = paramaf2;
                return;
            }
            if ((!g) && (localaf.c != paramaf1)) {
                throw new AssertionError();
            }
            localaf.c = paramaf2;
            return;
        }
        int k = paramaf1.g;
        int m = this.b.length;
        this.b[(k & m - 1)] = paramaf2;
    }

    private boolean a(Object paramObject1, Object paramObject2) {
        return (paramObject1 == paramObject2) || ((paramObject1 != null) && (paramObject1.equals(paramObject2)));
    }

    static <K, V> af<K, V>[] a(af<K, V>[] paramArrayOfaf) {
        int i1 = paramArrayOfaf.length;
        af[] arrayOfaf = new af[i1 * 2];
        z localz = new z();
        y localy1 = new y();
        y localy2 = new y();
        int k = 0;
        while (k < i1) {
            Object localObject2 = paramArrayOfaf[k];
            if (localObject2 == null) {
                k += 1;
            } else {
                localz.a((af) localObject2);
                int n = 0;
                int m = 0;
                Object localObject1;
                for (; ; ) {
                    localObject1 = localz.a();
                    if (localObject1 == null) {
                        break;
                    }
                    if ((((af) localObject1).g & i1) == 0) {
                        m += 1;
                    } else {
                        n += 1;
                    }
                }
                if ((m > 0) && (n > 0)) {
                    localy1.a(m);
                    localy2.a(n);
                    localz.a((af) localObject2);
                    for (; ; ) {
                        localObject1 = localz.a();
                        if (localObject1 == null) {
                            break;
                        }
                        if ((((af) localObject1).g & i1) == 0) {
                            localy1.a((af) localObject1);
                        } else {
                            localy2.a((af) localObject1);
                        }
                    }
                    localObject2 = localy1.a();
                    localObject1 = localy2.a();
                }
                for (; ; ) {
                    arrayOfaf[k] = localObject2;
                    arrayOfaf[(k + i1)] = localObject1;
                    break;
                    if (m > 0) {
                        localObject1 = null;
                    } else {
                        localObject1 = localObject2;
                        localObject2 = null;
                    }
                }
            }
        }
        return arrayOfaf;
    }

    private void b(af<K, V> paramaf) {
        int n = 0;
        af localaf1 = paramaf.b;
        af localaf2 = paramaf.c;
        af localaf3 = localaf1.b;
        af localaf4 = localaf1.c;
        paramaf.b = localaf4;
        if (localaf4 != null) {
            localaf4.a = paramaf;
        }
        a(paramaf, localaf1);
        localaf1.c = paramaf;
        paramaf.a = localaf1;
        int k;
        if (localaf2 != null) {
            k = localaf2.i;
            if (localaf4 == null) {
                break label135;
            }
        }
        label135:
        for (int m = localaf4.i; ; m = 0) {
            paramaf.i = (Math.max(k, m) + 1);
            m = paramaf.i;
            k = n;
            if (localaf3 != null) {
                k = localaf3.i;
            }
            localaf1.i = (Math.max(m, k) + 1);
            return;
            k = 0;
            break;
        }
    }

    private void b(af<K, V> paramaf, boolean paramBoolean) {
        af localaf1;
        af localaf2;
        int k;
        int m;
        label39:
        int n;
        af localaf3;
        if (paramaf != null) {
            localaf1 = paramaf.b;
            localaf2 = paramaf.c;
            if (localaf1 == null) {
                break label117;
            }
            k = localaf1.i;
            if (localaf2 == null) {
                break label122;
            }
            m = localaf2.i;
            n = k - m;
            if (n != -2) {
                break label172;
            }
            localaf1 = localaf2.b;
            localaf3 = localaf2.c;
            if (localaf3 == null) {
                break label128;
            }
            k = localaf3.i;
            label77:
            if (localaf1 == null) {
                break label133;
            }
            m = localaf1.i;
            label89:
            k = m - k;
            if ((k != -1) && ((k != 0) || (paramBoolean))) {
                break label139;
            }
            a(paramaf);
        }
        for (; ; ) {
            if (!paramBoolean) {
                break label242;
            }
            label116:
            return;
            label117:
            k = 0;
            break;
            label122:
            m = 0;
            break label39;
            label128:
            k = 0;
            break label77;
            label133:
            m = 0;
            break label89;
            label139:
            if ((!g) && (k != 1)) {
                throw new AssertionError();
            }
            b(localaf2);
            a(paramaf);
        }
        label172:
        if (n == 2) {
            localaf2 = localaf1.b;
            localaf3 = localaf1.c;
            if (localaf3 != null) {
                k = localaf3.i;
                label203:
                if (localaf2 == null) {
                    break label255;
                }
                m = localaf2.i;
                label215:
                k = m - k;
                if ((k != 1) && ((k != 0) || (paramBoolean))) {
                    break label261;
                }
                b(paramaf);
                label238:
                if (paramBoolean) {
                    break label292;
                }
            }
        }
        label242:
        label255:
        label261:
        label292:
        label311:
        do {
            do {
                paramaf = paramaf.a;
                break;
                k = 0;
                break label203;
                m = 0;
                break label215;
                if ((!g) && (k != -1)) {
                    throw new AssertionError();
                }
                a(localaf1);
                b(paramaf);
                break label238;
                break label116;
                if (n != 0) {
                    break label311;
                }
                paramaf.i = (k + 1);
            } while (!paramBoolean);
            return;
            if ((!g) && (n != -1) && (n != 1)) {
                throw new AssertionError();
            }
            paramaf.i = (Math.max(k, m) + 1);
        } while (paramBoolean);
    }

    private Object writeReplace() {
        return new LinkedHashMap(this);
    }

    af<K, V> a(Object paramObject) {
        af localaf = null;
        if (paramObject != null) {
        }
        try {
            localaf = a(paramObject, false);
            return localaf;
        } catch (ClassCastException paramObject) {
        }
        return null;
    }

    af<K, V> a(K paramK, boolean paramBoolean) {
        Object localObject3 = null;
        Comparator localComparator = this.a;
        af[] arrayOfaf = this.b;
        int m = a(paramK.hashCode());
        int n = m & arrayOfaf.length - 1;
        Object localObject1 = arrayOfaf[n];
        int k;
        Object localObject2;
        if (localObject1 != null) {
            Comparable localComparable;
            if (localComparator == h) {
                localComparable = (Comparable) paramK;
                if (localComparable == null) {
                    break label95;
                }
            }
            label86:
            label95:
            for (k = localComparable.compareTo(((af) localObject1).f); ; k = localComparator.compare(paramK, ((af) localObject1).f)) {
                if (k != 0) {
                    break label112;
                }
                localObject2 = localObject1;
                return (af<K, V>) localObject2;
                localComparable = null;
                break;
            }
            label112:
            if (k < 0) {
                localObject2 = ((af) localObject1).b;
                label123:
                if (localObject2 != null) {
                    break label205;
                }
            }
        }
        for (; ; ) {
            localObject2 = localObject3;
            if (!paramBoolean) {
                break label86;
            }
            localObject2 = this.c;
            if (localObject1 == null) {
                if ((localComparator == h) && (!(paramK instanceof Comparable))) {
                    throw new ClassCastException(paramK.getClass().getName() + " is not Comparable");
                    localObject2 = ((af) localObject1).c;
                    break label123;
                    label205:
                    localObject1 = localObject2;
                    break;
                }
                paramK = new af((af) localObject1, paramK, m, (af) localObject2, ((af) localObject2).e);
                arrayOfaf[n] = paramK;
                k = this.d;
                this.d = (k + 1);
                if (k > this.f) {
                    a();
                }
                this.e += 1;
                return paramK;
            }
            paramK = new af((af) localObject1, paramK, m, (af) localObject2, ((af) localObject2).e);
            if (k < 0) {
                ((af) localObject1).b = paramK;
            }
            for (; ; ) {
                b((af) localObject1, true);
                break;
                ((af) localObject1).c = paramK;
            }
            k = 0;
        }
    }

    af<K, V> a(Map.Entry<?, ?> paramEntry) {
        af localaf = a(paramEntry.getKey());
        if ((localaf != null) && (a(localaf.h, paramEntry.getValue()))) {
        }
        for (int k = 1; k != 0; k = 0) {
            return localaf;
        }
        return null;
    }

    void a(af<K, V> paramaf, boolean paramBoolean) {
        int m = 0;
        if (paramBoolean) {
            paramaf.e.d = paramaf.d;
            paramaf.d.e = paramaf.e;
            paramaf.e = null;
            paramaf.d = null;
        }
        af localaf1 = paramaf.b;
        af localaf2 = paramaf.c;
        af localaf3 = paramaf.a;
        int k;
        if ((localaf1 != null) && (localaf2 != null)) {
            if (localaf1.i > localaf2.i) {
                localaf1 = localaf1.b();
                a(localaf1, false);
                localaf2 = paramaf.b;
                if (localaf2 == null) {
                    break label272;
                }
                k = localaf2.i;
                localaf1.b = localaf2;
                localaf2.a = localaf1;
                paramaf.b = null;
            }
        }
        for (; ; ) {
            localaf2 = paramaf.c;
            if (localaf2 != null) {
                m = localaf2.i;
                localaf1.c = localaf2;
                localaf2.a = localaf1;
                paramaf.c = null;
            }
            localaf1.i = (Math.max(k, m) + 1);
            a(paramaf, localaf1);
            return;
            localaf1 = localaf2.a();
            break;
            if (localaf1 != null) {
                a(paramaf, localaf1);
                paramaf.b = null;
            }
            for (; ; ) {
                b(localaf3, false);
                this.d -= 1;
                this.e += 1;
                return;
                if (localaf2 != null) {
                    a(paramaf, localaf2);
                    paramaf.c = null;
                } else {
                    a(paramaf, null);
                }
            }
            label272:
            k = 0;
        }
    }

    af<K, V> b(Object paramObject) {
        paramObject = a(paramObject);
        if (paramObject != null) {
            a((af) paramObject, true);
        }
        return (af<K, V>) paramObject;
    }

    public void clear() {
        Arrays.fill(this.b, null);
        this.d = 0;
        this.e += 1;
        af localaf2 = this.c;
        af localaf1;
        for (Object localObject = localaf2.d; localObject != localaf2; localObject = localaf1) {
            localaf1 = ((af) localObject).d;
            ((af) localObject).e = null;
            ((af) localObject).d = null;
        }
        localaf2.e = localaf2;
        localaf2.d = localaf2;
    }

    public boolean containsKey(Object paramObject) {
        return a(paramObject) != null;
    }

    public Set<Map.Entry<K, V>> entrySet() {
        aa localaa = this.i;
        if (localaa != null) {
            return localaa;
        }
        localaa = new aa(this);
        this.i = localaa;
        return localaa;
    }

    public V get(Object paramObject) {
        paramObject = a(paramObject);
        if (paramObject != null) {
            return (V) ((af) paramObject).h;
        }
        return null;
    }

    public Set<K> keySet() {
        ac localac = this.j;
        if (localac != null) {
            return localac;
        }
        localac = new ac(this);
        this.j = localac;
        return localac;
    }

    public V put(K paramK, V paramV) {
        if (paramK == null) {
            throw new NullPointerException("key == null");
        }
        paramK = a(paramK, true);
        Object localObject = paramK.h;
        paramK.h = paramV;
        return (V) localObject;
    }

    public V remove(Object paramObject) {
        paramObject = b(paramObject);
        if (paramObject != null) {
            return (V) ((af) paramObject).h;
        }
        return null;
    }

    public int size() {
        return this.d;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/a/a/b/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */