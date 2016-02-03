package com.google.gson.internal;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;

public final class LinkedTreeMap<K, V>
        extends AbstractMap<K, V>
        implements Serializable {
    private static final Comparator<Comparable> NATURAL_ORDER;
    Comparator<? super K> comparator;
    private LinkedTreeMap<K, V>.aa entrySet;
    final af<K, V> header = new af();
    private LinkedTreeMap<K, V>.ac keySet;
    int modCount = 0;
    af<K, V> root;
    int size = 0;

    static {
        if (!LinkedTreeMap.class.desiredAssertionStatus()) {
        }
        for (boolean bool = true; ; bool = false) {
            $assertionsDisabled = bool;
            NATURAL_ORDER = new z();
            return;
        }
    }

    public LinkedTreeMap() {
        this(NATURAL_ORDER);
    }

    public LinkedTreeMap(Comparator<? super K> paramComparator) {
        if (paramComparator != null) {
        }
        for (; ; ) {
            this.comparator = paramComparator;
            return;
            paramComparator = NATURAL_ORDER;
        }
    }

    private boolean equal(Object paramObject1, Object paramObject2) {
        return (paramObject1 == paramObject2) || ((paramObject1 != null) && (paramObject1.equals(paramObject2)));
    }

    private void rebalance(af<K, V> paramaf, boolean paramBoolean) {
        af localaf1;
        af localaf2;
        int i;
        int j;
        label39:
        int k;
        af localaf3;
        if (paramaf != null) {
            localaf1 = paramaf.b;
            localaf2 = paramaf.c;
            if (localaf1 == null) {
                break label117;
            }
            i = localaf1.h;
            if (localaf2 == null) {
                break label122;
            }
            j = localaf2.h;
            k = i - j;
            if (k != -2) {
                break label172;
            }
            localaf1 = localaf2.b;
            localaf3 = localaf2.c;
            if (localaf3 == null) {
                break label128;
            }
            i = localaf3.h;
            label77:
            if (localaf1 == null) {
                break label133;
            }
            j = localaf1.h;
            label89:
            i = j - i;
            if ((i != -1) && ((i != 0) || (paramBoolean))) {
                break label139;
            }
            rotateLeft(paramaf);
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
            rotateRight(localaf2);
            rotateLeft(paramaf);
        }
        label172:
        if (k == 2) {
            localaf2 = localaf1.b;
            localaf3 = localaf1.c;
            if (localaf3 != null) {
                i = localaf3.h;
                label203:
                if (localaf2 == null) {
                    break label255;
                }
                j = localaf2.h;
                label215:
                i = j - i;
                if ((i != 1) && ((i != 0) || (paramBoolean))) {
                    break label261;
                }
                rotateRight(paramaf);
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
                i = 0;
                break label203;
                j = 0;
                break label215;
                assert (i == -1);
                rotateLeft(localaf1);
                rotateRight(paramaf);
                break label238;
                break label116;
                if (k != 0) {
                    break label311;
                }
                paramaf.h = (i + 1);
            } while (!paramBoolean);
            return;
            assert ((k == -1) || (k == 1));
            paramaf.h = (Math.max(i, j) + 1);
        } while (paramBoolean);
    }

    private void replaceInParent(af<K, V> paramaf1, af<K, V> paramaf2) {
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
            assert (localaf.c == paramaf1);
            localaf.c = paramaf2;
            return;
        }
        this.root = paramaf2;
    }

    private void rotateLeft(af<K, V> paramaf) {
        int k = 0;
        af localaf1 = paramaf.b;
        af localaf2 = paramaf.c;
        af localaf3 = localaf2.b;
        af localaf4 = localaf2.c;
        paramaf.c = localaf3;
        if (localaf3 != null) {
            localaf3.a = paramaf;
        }
        replaceInParent(paramaf, localaf2);
        localaf2.b = paramaf;
        paramaf.a = localaf2;
        int i;
        if (localaf1 != null) {
            i = localaf1.h;
            if (localaf3 == null) {
                break label135;
            }
        }
        label135:
        for (int j = localaf3.h; ; j = 0) {
            paramaf.h = (Math.max(i, j) + 1);
            j = paramaf.h;
            i = k;
            if (localaf4 != null) {
                i = localaf4.h;
            }
            localaf2.h = (Math.max(j, i) + 1);
            return;
            i = 0;
            break;
        }
    }

    private void rotateRight(af<K, V> paramaf) {
        int k = 0;
        af localaf1 = paramaf.b;
        af localaf2 = paramaf.c;
        af localaf3 = localaf1.b;
        af localaf4 = localaf1.c;
        paramaf.b = localaf4;
        if (localaf4 != null) {
            localaf4.a = paramaf;
        }
        replaceInParent(paramaf, localaf1);
        localaf1.c = paramaf;
        paramaf.a = localaf1;
        int i;
        if (localaf2 != null) {
            i = localaf2.h;
            if (localaf4 == null) {
                break label135;
            }
        }
        label135:
        for (int j = localaf4.h; ; j = 0) {
            paramaf.h = (Math.max(i, j) + 1);
            j = paramaf.h;
            i = k;
            if (localaf3 != null) {
                i = localaf3.h;
            }
            localaf1.h = (Math.max(j, i) + 1);
            return;
            i = 0;
            break;
        }
    }

    private Object writeReplace() {
        return new LinkedHashMap(this);
    }

    public void clear() {
        this.root = null;
        this.size = 0;
        this.modCount += 1;
        af localaf = this.header;
        localaf.e = localaf;
        localaf.d = localaf;
    }

    public boolean containsKey(Object paramObject) {
        return findByObject(paramObject) != null;
    }

    public Set<Map.Entry<K, V>> entrySet() {
        aa localaa = this.entrySet;
        if (localaa != null) {
            return localaa;
        }
        localaa = new aa(this);
        this.entrySet = localaa;
        return localaa;
    }

    af<K, V> find(K paramK, boolean paramBoolean) {
        Object localObject3 = null;
        Comparator localComparator = this.comparator;
        Object localObject1 = this.root;
        int i;
        Object localObject2;
        if (localObject1 != null) {
            Comparable localComparable;
            if (localComparator == NATURAL_ORDER) {
                localComparable = (Comparable) paramK;
                if (localComparable == null) {
                    break label69;
                }
            }
            label60:
            label69:
            for (i = localComparable.compareTo(((af) localObject1).f); ; i = localComparator.compare(paramK, ((af) localObject1).f)) {
                if (i != 0) {
                    break label86;
                }
                localObject2 = localObject1;
                return (af<K, V>) localObject2;
                localComparable = null;
                break;
            }
            label86:
            if (i < 0) {
                localObject2 = ((af) localObject1).b;
                label97:
                if (localObject2 != null) {
                    break label179;
                }
            }
        }
        for (; ; ) {
            localObject2 = localObject3;
            if (!paramBoolean) {
                break label60;
            }
            localObject2 = this.header;
            if (localObject1 == null) {
                if ((localComparator == NATURAL_ORDER) && (!(paramK instanceof Comparable))) {
                    throw new ClassCastException(paramK.getClass().getName() + " is not Comparable");
                    localObject2 = ((af) localObject1).c;
                    break label97;
                    label179:
                    localObject1 = localObject2;
                    break;
                }
                paramK = new af((af) localObject1, paramK, (af) localObject2, ((af) localObject2).e);
                this.root = paramK;
                this.size += 1;
                this.modCount += 1;
                return paramK;
            }
            paramK = new af((af) localObject1, paramK, (af) localObject2, ((af) localObject2).e);
            if (i < 0) {
                ((af) localObject1).b = paramK;
            }
            for (; ; ) {
                rebalance((af) localObject1, true);
                break;
                ((af) localObject1).c = paramK;
            }
            i = 0;
        }
    }

    af<K, V> findByEntry(Map.Entry<?, ?> paramEntry) {
        af localaf = findByObject(paramEntry.getKey());
        if ((localaf != null) && (equal(localaf.g, paramEntry.getValue()))) {
        }
        for (int i = 1; i != 0; i = 0) {
            return localaf;
        }
        return null;
    }

    af<K, V> findByObject(Object paramObject) {
        af localaf = null;
        if (paramObject != null) {
        }
        try {
            localaf = find(paramObject, false);
            return localaf;
        } catch (ClassCastException paramObject) {
        }
        return null;
    }

    public V get(Object paramObject) {
        paramObject = findByObject(paramObject);
        if (paramObject != null) {
            return (V) ((af) paramObject).g;
        }
        return null;
    }

    public Set<K> keySet() {
        ac localac = this.keySet;
        if (localac != null) {
            return localac;
        }
        localac = new ac(this);
        this.keySet = localac;
        return localac;
    }

    public V put(K paramK, V paramV) {
        if (paramK == null) {
            throw new NullPointerException("key == null");
        }
        paramK = find(paramK, true);
        Object localObject = paramK.g;
        paramK.g = paramV;
        return (V) localObject;
    }

    public V remove(Object paramObject) {
        paramObject = removeInternalByKey(paramObject);
        if (paramObject != null) {
            return (V) ((af) paramObject).g;
        }
        return null;
    }

    void removeInternal(af<K, V> paramaf, boolean paramBoolean) {
        int j = 0;
        if (paramBoolean) {
            paramaf.e.d = paramaf.d;
            paramaf.d.e = paramaf.e;
        }
        af localaf1 = paramaf.b;
        af localaf2 = paramaf.c;
        af localaf3 = paramaf.a;
        int i;
        if ((localaf1 != null) && (localaf2 != null)) {
            if (localaf1.h > localaf2.h) {
                localaf1 = localaf1.b();
                removeInternal(localaf1, false);
                localaf2 = paramaf.b;
                if (localaf2 == null) {
                    break label262;
                }
                i = localaf2.h;
                localaf1.b = localaf2;
                localaf2.a = localaf1;
                paramaf.b = null;
            }
        }
        for (; ; ) {
            localaf2 = paramaf.c;
            if (localaf2 != null) {
                j = localaf2.h;
                localaf1.c = localaf2;
                localaf2.a = localaf1;
                paramaf.c = null;
            }
            localaf1.h = (Math.max(i, j) + 1);
            replaceInParent(paramaf, localaf1);
            return;
            localaf1 = localaf2.a();
            break;
            if (localaf1 != null) {
                replaceInParent(paramaf, localaf1);
                paramaf.b = null;
            }
            for (; ; ) {
                rebalance(localaf3, false);
                this.size -= 1;
                this.modCount += 1;
                return;
                if (localaf2 != null) {
                    replaceInParent(paramaf, localaf2);
                    paramaf.c = null;
                } else {
                    replaceInParent(paramaf, null);
                }
            }
            label262:
            i = 0;
        }
    }

    af<K, V> removeInternalByKey(Object paramObject) {
        paramObject = findByObject(paramObject);
        if (paramObject != null) {
            removeInternal((af) paramObject, true);
        }
        return (af<K, V>) paramObject;
    }

    public int size() {
        return this.size;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/gson/internal/LinkedTreeMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */