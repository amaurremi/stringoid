package android.support.v4.d;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

abstract class g<K, V> {
    g<K, V>.i b;
    g<K, V>.j c;
    g<K, V>.l d;

    public static <K, V> boolean a(Map<K, V> paramMap, Collection<?> paramCollection) {
        paramCollection = paramCollection.iterator();
        while (paramCollection.hasNext()) {
            if (!paramMap.containsKey(paramCollection.next())) {
                return false;
            }
        }
        return true;
    }

    public static <T> boolean a(Set<T> paramSet, Object paramObject) {
        boolean bool2 = true;
        boolean bool1 = false;
        if (paramSet == paramObject) {
            bool1 = true;
        }
        while (!(paramObject instanceof Set)) {
            return bool1;
        }
        paramObject = (Set) paramObject;
        try {
            if (paramSet.size() == ((Set) paramObject).size()) {
                bool1 = paramSet.containsAll((Collection) paramObject);
                if (!bool1) {
                }
            }
            for (bool1 = bool2; ; bool1 = false) {
                return bool1;
            }
            return false;
        } catch (ClassCastException paramSet) {
            return false;
        } catch (NullPointerException paramSet) {
        }
    }

    public static <K, V> boolean b(Map<K, V> paramMap, Collection<?> paramCollection) {
        int i = paramMap.size();
        paramCollection = paramCollection.iterator();
        while (paramCollection.hasNext()) {
            paramMap.remove(paramCollection.next());
        }
        return i != paramMap.size();
    }

    public static <K, V> boolean c(Map<K, V> paramMap, Collection<?> paramCollection) {
        int i = paramMap.size();
        Iterator localIterator = paramMap.keySet().iterator();
        while (localIterator.hasNext()) {
            if (!paramCollection.contains(localIterator.next())) {
                localIterator.remove();
            }
        }
        return i != paramMap.size();
    }

    protected abstract int a();

    protected abstract int a(Object paramObject);

    protected abstract Object a(int paramInt1, int paramInt2);

    protected abstract V a(int paramInt, V paramV);

    protected abstract void a(int paramInt);

    protected abstract void a(K paramK, V paramV);

    public <T> T[] a(T[] paramArrayOfT, int paramInt) {
        int j = a();
        if (paramArrayOfT.length < j) {
            paramArrayOfT = (Object[]) Array.newInstance(paramArrayOfT.getClass().getComponentType(), j);
        }
        for (; ; ) {
            int i = 0;
            while (i < j) {
                paramArrayOfT[i] = a(i, paramInt);
                i += 1;
            }
            if (paramArrayOfT.length > j) {
                paramArrayOfT[j] = null;
            }
            return paramArrayOfT;
        }
    }

    protected abstract int b(Object paramObject);

    protected abstract Map<K, V> b();

    public Object[] b(int paramInt) {
        int j = a();
        Object[] arrayOfObject = new Object[j];
        int i = 0;
        while (i < j) {
            arrayOfObject[i] = a(i, paramInt);
            i += 1;
        }
        return arrayOfObject;
    }

    protected abstract void c();

    public Set<Map.Entry<K, V>> d() {
        if (this.b == null) {
            this.b = new i(this);
        }
        return this.b;
    }

    public Set<K> e() {
        if (this.c == null) {
            this.c = new j(this);
        }
        return this.c;
    }

    public Collection<V> f() {
        if (this.d == null) {
            this.d = new l(this);
        }
        return this.d;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v4/d/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */