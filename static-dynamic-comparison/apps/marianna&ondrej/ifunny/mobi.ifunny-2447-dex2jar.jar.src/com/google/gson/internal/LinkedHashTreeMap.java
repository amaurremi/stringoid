package com.google.gson.internal;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;

public final class LinkedHashTreeMap<K, V>
        extends AbstractMap<K, V>
        implements Serializable {
    private static final Comparator<Comparable> NATURAL_ORDER;
    Comparator<? super K> comparator;
    private LinkedHashTreeMap<K, V>.t entrySet;
    final y<K, V> header;
    private LinkedHashTreeMap<K, V>.v keySet;
    int modCount = 0;
    int size = 0;
    y<K, V>[] table;
    int threshold;

    static {
        if (!LinkedHashTreeMap.class.desiredAssertionStatus()) {
        }
        for (boolean bool = true; ; bool = false) {
            $assertionsDisabled = bool;
            NATURAL_ORDER = new q();
            return;
        }
    }

    public LinkedHashTreeMap() {
        this(NATURAL_ORDER);
    }

    public LinkedHashTreeMap(Comparator<? super K> paramComparator) {
        if (paramComparator != null) {
        }
        for (; ; ) {
            this.comparator = paramComparator;
            this.header = new y();
            this.table = new y[16];
            this.threshold = (this.table.length / 2 + this.table.length / 4);
            return;
            paramComparator = NATURAL_ORDER;
        }
    }

    private void doubleCapacity() {
        this.table = doubleCapacity(this.table);
        this.threshold = (this.table.length / 2 + this.table.length / 4);
    }

    static <K, V> y<K, V>[] doubleCapacity(y<K, V>[] paramArrayOfy) {
        int m = paramArrayOfy.length;
        y[] arrayOfy = new y[m * 2];
        s locals = new s();
        r localr1 = new r();
        r localr2 = new r();
        int i = 0;
        while (i < m) {
            Object localObject = paramArrayOfy[i];
            if (localObject == null) {
                i += 1;
            } else {
                locals.a((y) localObject);
                int k = 0;
                int j = 0;
                for (; ; ) {
                    y localy = locals.a();
                    if (localy == null) {
                        break;
                    }
                    if ((localy.g & m) == 0) {
                        j += 1;
                    } else {
                        k += 1;
                    }
                }
                localr1.a(j);
                localr2.a(k);
                locals.a((y) localObject);
                for (; ; ) {
                    localObject = locals.a();
                    if (localObject == null) {
                        break;
                    }
                    if ((((y) localObject).g & m) == 0) {
                        localr1.a((y) localObject);
                    } else {
                        localr2.a((y) localObject);
                    }
                }
                if (j > 0) {
                    localObject = localr1.a();
                    label186:
                    arrayOfy[i] = localObject;
                    if (k <= 0) {
                        break label221;
                    }
                }
                label221:
                for (localObject = localr2.a(); ; localObject = null) {
                    arrayOfy[(i + m)] = localObject;
                    break;
                    localObject = null;
                    break label186;
                }
            }
        }
        return arrayOfy;
    }

    private boolean equal(Object paramObject1, Object paramObject2) {
        return (paramObject1 == paramObject2) || ((paramObject1 != null) && (paramObject1.equals(paramObject2)));
    }

    private void rebalance(y<K, V> paramy, boolean paramBoolean) {
        y localy1;
        y localy2;
        int i;
        int j;
        label39:
        int k;
        y localy3;
        if (paramy != null) {
            localy1 = paramy.b;
            localy2 = paramy.c;
            if (localy1 == null) {
                break label117;
            }
            i = localy1.i;
            if (localy2 == null) {
                break label122;
            }
            j = localy2.i;
            k = i - j;
            if (k != -2) {
                break label172;
            }
            localy1 = localy2.b;
            localy3 = localy2.c;
            if (localy3 == null) {
                break label128;
            }
            i = localy3.i;
            label77:
            if (localy1 == null) {
                break label133;
            }
            j = localy1.i;
            label89:
            i = j - i;
            if ((i != -1) && ((i != 0) || (paramBoolean))) {
                break label139;
            }
            rotateLeft(paramy);
        }
        for (; ; ) {
            if (!paramBoolean) {
                break label242;
            }
            label116:
            return;
            label117:
            i = 0;
            break;
            label122:
            j = 0;
            break label39;
            label128:
            i = 0;
            break label77;
            label133:
            j = 0;
            break label89;
            label139:
            assert (i == 1);
            rotateRight(localy2);
            rotateLeft(paramy);
        }
        label172:
        if (k == 2) {
            localy2 = localy1.b;
            localy3 = localy1.c;
            if (localy3 != null) {
                i = localy3.i;
                label203:
                if (localy2 == null) {
                    break label255;
                }
                j = localy2.i;
                label215:
                i = j - i;
                if ((i != 1) && ((i != 0) || (paramBoolean))) {
                    break label261;
                }
                rotateRight(paramy);
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
                paramy = paramy.a;
                break;
                i = 0;
                break label203;
                j = 0;
                break label215;
                assert (i == -1);
                rotateLeft(localy1);
                rotateRight(paramy);
                break label238;
                break label116;
                if (k != 0) {
                    break label311;
                }
                paramy.i = (i + 1);
            } while (!paramBoolean);
            return;
            assert ((k == -1) || (k == 1));
            paramy.i = (Math.max(i, j) + 1);
        } while (paramBoolean);
    }

    private void replaceInParent(y<K, V> paramy1, y<K, V> paramy2) {
        y localy = paramy1.a;
        paramy1.a = null;
        if (paramy2 != null) {
            paramy2.a = localy;
        }
        if (localy != null) {
            if (localy.b == paramy1) {
                localy.b = paramy2;
                return;
            }
            assert (localy.c == paramy1);
            localy.c = paramy2;
            return;
        }
        int i = paramy1.g;
        int j = this.table.length;
        this.table[(i & j - 1)] = paramy2;
    }

    private void rotateLeft(y<K, V> paramy) {
        int k = 0;
        y localy1 = paramy.b;
        y localy2 = paramy.c;
        y localy3 = localy2.b;
        y localy4 = localy2.c;
        paramy.c = localy3;
        if (localy3 != null) {
            localy3.a = paramy;
        }
        replaceInParent(paramy, localy2);
        localy2.b = paramy;
        paramy.a = localy2;
        int i;
        if (localy1 != null) {
            i = localy1.i;
            if (localy3 == null) {
                break label135;
            }
        }
        label135:
        for (int j = localy3.i; ; j = 0) {
            paramy.i = (Math.max(i, j) + 1);
            j = paramy.i;
            i = k;
            if (localy4 != null) {
                i = localy4.i;
            }
            localy2.i = (Math.max(j, i) + 1);
            return;
            i = 0;
            break;
        }
    }

    private void rotateRight(y<K, V> paramy) {
        int k = 0;
        y localy1 = paramy.b;
        y localy2 = paramy.c;
        y localy3 = localy1.b;
        y localy4 = localy1.c;
        paramy.b = localy4;
        if (localy4 != null) {
            localy4.a = paramy;
        }
        replaceInParent(paramy, localy1);
        localy1.c = paramy;
        paramy.a = localy1;
        int i;
        if (localy2 != null) {
            i = localy2.i;
            if (localy4 == null) {
                break label135;
            }
        }
        label135:
        for (int j = localy4.i; ; j = 0) {
            paramy.i = (Math.max(i, j) + 1);
            j = paramy.i;
            i = k;
            if (localy3 != null) {
                i = localy3.i;
            }
            localy1.i = (Math.max(j, i) + 1);
            return;
            i = 0;
            break;
        }
    }

    private static int secondaryHash(int paramInt) {
        paramInt = paramInt >>> 20 ^ paramInt >>> 12 ^ paramInt;
        return paramInt >>> 4 ^ paramInt >>> 7 ^ paramInt;
    }

    private Object writeReplace() {
        return new LinkedHashMap(this);
    }

    public void clear() {
        Arrays.fill(this.table, null);
        this.size = 0;
        this.modCount += 1;
        y localy2 = this.header;
        y localy1;
        for (Object localObject = localy2.d; localObject != localy2; localObject = localy1) {
            localy1 = ((y) localObject).d;
            ((y) localObject).e = null;
            ((y) localObject).d = null;
        }
        localy2.e = localy2;
        localy2.d = localy2;
    }

    public boolean containsKey(Object paramObject) {
        return findByObject(paramObject) != null;
    }

    public Set<Map.Entry<K, V>> entrySet() {
        t localt = this.entrySet;
        if (localt != null) {
            return localt;
        }
        localt = new t(this);
        this.entrySet = localt;
        return localt;
    }

    y<K, V> find(K paramK, boolean paramBoolean) {
        Object localObject3 = null;
        Comparator localComparator = this.comparator;
        y[] arrayOfy = this.table;
        int j = secondaryHash(paramK.hashCode());
        int k = j & arrayOfy.length - 1;
        Object localObject1 = arrayOfy[k];
        int i;
        Object localObject2;
        if (localObject1 != null) {
            Comparable localComparable;
            if (localComparator == NATURAL_ORDER) {
                localComparable = (Comparable) paramK;
                if (localComparable == null) {
                    break label95;
                }
            }
            label86:
            label95:
            for (i = localComparable.compareTo(((y) localObject1).f); ; i = localComparator.compare(paramK, ((y) localObject1).f)) {
                if (i != 0) {
                    break label112;
                }
                localObject2 = localObject1;
                return (y<K, V>) localObject2;
                localComparable = null;
                break;
            }
            label112:
            if (i < 0) {
                localObject2 = ((y) localObject1).b;
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
            localObject2 = this.header;
            if (localObject1 == null) {
                if ((localComparator == NATURAL_ORDER) && (!(paramK instanceof Comparable))) {
                    throw new ClassCastException(paramK.getClass().getName() + " is not Comparable");
                    localObject2 = ((y) localObject1).c;
                    break label123;
                    label205:
                    localObject1 = localObject2;
                    break;
                }
                paramK = new y((y) localObject1, paramK, j, (y) localObject2, ((y) localObject2).e);
                arrayOfy[k] = paramK;
                i = this.size;
                this.size = (i + 1);
                if (i > this.threshold) {
                    doubleCapacity();
                }
                this.modCount += 1;
                return paramK;
            }
            paramK = new y((y) localObject1, paramK, j, (y) localObject2, ((y) localObject2).e);
            if (i < 0) {
                ((y) localObject1).b = paramK;
            }
            for (; ; ) {
                rebalance((y) localObject1, true);
                break;
                ((y) localObject1).c = paramK;
            }
            i = 0;
        }
    }

    y<K, V> findByEntry(Map.Entry<?, ?> paramEntry) {
        y localy = findByObject(paramEntry.getKey());
        if ((localy != null) && (equal(localy.h, paramEntry.getValue()))) {
        }
        for (int i = 1; i != 0; i = 0) {
            return localy;
        }
        return null;
    }

    y<K, V> findByObject(Object paramObject) {
        y localy = null;
        if (paramObject != null) {
        }
        try {
            localy = find(paramObject, false);
            return localy;
        } catch (ClassCastException paramObject) {
        }
        return null;
    }

    public V get(Object paramObject) {
        paramObject = findByObject(paramObject);
        if (paramObject != null) {
            return (V) ((y) paramObject).h;
        }
        return null;
    }

    public Set<K> keySet() {
        v localv = this.keySet;
        if (localv != null) {
            return localv;
        }
        localv = new v(this);
        this.keySet = localv;
        return localv;
    }

    public V put(K paramK, V paramV) {
        if (paramK == null) {
            throw new NullPointerException("key == null");
        }
        paramK = find(paramK, true);
        Object localObject = paramK.h;
        paramK.h = paramV;
        return (V) localObject;
    }

    public V remove(Object paramObject) {
        paramObject = removeInternalByKey(paramObject);
        if (paramObject != null) {
            return (V) ((y) paramObject).h;
        }
        return null;
    }

    void removeInternal(y<K, V> paramy, boolean paramBoolean) {
        int j = 0;
        if (paramBoolean) {
            paramy.e.d = paramy.d;
            paramy.d.e = paramy.e;
            paramy.e = null;
            paramy.d = null;
        }
        y localy1 = paramy.b;
        y localy2 = paramy.c;
        y localy3 = paramy.a;
        int i;
        if ((localy1 != null) && (localy2 != null)) {
            if (localy1.i > localy2.i) {
                localy1 = localy1.b();
                removeInternal(localy1, false);
                localy2 = paramy.b;
                if (localy2 == null) {
                    break label272;
                }
                i = localy2.i;
                localy1.b = localy2;
                localy2.a = localy1;
                paramy.b = null;
            }
        }
        for (; ; ) {
            localy2 = paramy.c;
            if (localy2 != null) {
                j = localy2.i;
                localy1.c = localy2;
                localy2.a = localy1;
                paramy.c = null;
            }
            localy1.i = (Math.max(i, j) + 1);
            replaceInParent(paramy, localy1);
            return;
            localy1 = localy2.a();
            break;
            if (localy1 != null) {
                replaceInParent(paramy, localy1);
                paramy.b = null;
            }
            for (; ; ) {
                rebalance(localy3, false);
                this.size -= 1;
                this.modCount += 1;
                return;
                if (localy2 != null) {
                    replaceInParent(paramy, localy2);
                    paramy.c = null;
                } else {
                    replaceInParent(paramy, null);
                }
            }
            label272:
            i = 0;
        }
    }

    y<K, V> removeInternalByKey(Object paramObject) {
        paramObject = findByObject(paramObject);
        if (paramObject != null) {
            removeInternal((y) paramObject, true);
        }
        return (y<K, V>) paramObject;
    }

    public int size() {
        return this.size;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/gson/internal/LinkedHashTreeMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */