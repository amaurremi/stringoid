package android.support.v4.b;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

abstract class f<K, V>
{
  f<K, V>.b Q;
  f<K, V>.c R;
  f<K, V>.e S;
  
  public static <K, V> boolean a(Map<K, V> paramMap, Collection<?> paramCollection)
  {
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      if (!paramMap.containsKey(paramCollection.next())) {
        return false;
      }
    }
    return true;
  }
  
  public static <T> boolean a(Set<T> paramSet, Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1 = false;
    if (paramSet == paramObject) {
      bool1 = true;
    }
    while (!(paramObject instanceof Set)) {
      return bool1;
    }
    paramObject = (Set)paramObject;
    try
    {
      if (paramSet.size() == ((Set)paramObject).size())
      {
        bool1 = paramSet.containsAll((Collection)paramObject);
        if (!bool1) {}
      }
      for (bool1 = bool2;; bool1 = false) {
        return bool1;
      }
      return false;
    }
    catch (ClassCastException paramSet)
    {
      return false;
    }
    catch (NullPointerException paramSet) {}
  }
  
  public static <K, V> boolean b(Map<K, V> paramMap, Collection<?> paramCollection)
  {
    int i = paramMap.size();
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      paramMap.remove(paramCollection.next());
    }
    return i != paramMap.size();
  }
  
  public static <K, V> boolean c(Map<K, V> paramMap, Collection<?> paramCollection)
  {
    int i = paramMap.size();
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext()) {
      if (!paramCollection.contains(localIterator.next())) {
        localIterator.remove();
      }
    }
    return i != paramMap.size();
  }
  
  protected abstract int a(Object paramObject);
  
  protected abstract V a(int paramInt, V paramV);
  
  protected abstract void a(int paramInt);
  
  protected abstract void a(K paramK, V paramV);
  
  public <T> T[] a(T[] paramArrayOfT, int paramInt)
  {
    int j = k();
    if (paramArrayOfT.length < j) {
      paramArrayOfT = (Object[])Array.newInstance(paramArrayOfT.getClass().getComponentType(), j);
    }
    for (;;)
    {
      int i = 0;
      while (i < j)
      {
        paramArrayOfT[i] = b(i, paramInt);
        i += 1;
      }
      if (paramArrayOfT.length > j) {
        paramArrayOfT[j] = null;
      }
      return paramArrayOfT;
    }
  }
  
  protected abstract int b(Object paramObject);
  
  protected abstract Object b(int paramInt1, int paramInt2);
  
  public Object[] d(int paramInt)
  {
    int j = k();
    Object[] arrayOfObject = new Object[j];
    int i = 0;
    while (i < j)
    {
      arrayOfObject[i] = b(i, paramInt);
      i += 1;
    }
    return arrayOfObject;
  }
  
  protected abstract int k();
  
  protected abstract Map<K, V> l();
  
  protected abstract void m();
  
  public Set<Map.Entry<K, V>> o()
  {
    if (this.Q == null) {
      this.Q = new b();
    }
    return this.Q;
  }
  
  public Set<K> p()
  {
    if (this.R == null) {
      this.R = new c();
    }
    return this.R;
  }
  
  public Collection<V> q()
  {
    if (this.S == null) {
      this.S = new e();
    }
    return this.S;
  }
  
  final class a<T>
    implements Iterator<T>
  {
    final int T;
    int U;
    boolean V = false;
    int mIndex;
    
    a(int paramInt)
    {
      this.T = paramInt;
      this.U = f.this.k();
    }
    
    public boolean hasNext()
    {
      return this.mIndex < this.U;
    }
    
    public T next()
    {
      Object localObject = f.this.b(this.mIndex, this.T);
      this.mIndex += 1;
      this.V = true;
      return (T)localObject;
    }
    
    public void remove()
    {
      if (!this.V) {
        throw new IllegalStateException();
      }
      this.mIndex -= 1;
      this.U -= 1;
      this.V = false;
      f.this.a(this.mIndex);
    }
  }
  
  final class b
    implements Set<Map.Entry<K, V>>
  {
    b() {}
    
    public boolean a(Map.Entry<K, V> paramEntry)
    {
      throw new UnsupportedOperationException();
    }
    
    public boolean addAll(Collection<? extends Map.Entry<K, V>> paramCollection)
    {
      int i = f.this.k();
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramCollection.next();
        f.this.a(localEntry.getKey(), localEntry.getValue());
      }
      return i != f.this.k();
    }
    
    public void clear()
    {
      f.this.m();
    }
    
    public boolean contains(Object paramObject)
    {
      if (!(paramObject instanceof Map.Entry)) {}
      int i;
      do
      {
        return false;
        paramObject = (Map.Entry)paramObject;
        i = f.this.a(((Map.Entry)paramObject).getKey());
      } while (i < 0);
      return b.b(f.this.b(i, 1), ((Map.Entry)paramObject).getValue());
    }
    
    public boolean containsAll(Collection<?> paramCollection)
    {
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext()) {
        if (!contains(paramCollection.next())) {
          return false;
        }
      }
      return true;
    }
    
    public boolean equals(Object paramObject)
    {
      return f.a(this, paramObject);
    }
    
    public int hashCode()
    {
      int j = f.this.k() - 1;
      int i = 0;
      if (j >= 0)
      {
        Object localObject1 = f.this.b(j, 0);
        Object localObject2 = f.this.b(j, 1);
        int k;
        if (localObject1 == null)
        {
          k = 0;
          label45:
          if (localObject2 != null) {
            break label76;
          }
        }
        label76:
        for (int m = 0;; m = localObject2.hashCode())
        {
          j -= 1;
          i += (m ^ k);
          break;
          k = localObject1.hashCode();
          break label45;
        }
      }
      return i;
    }
    
    public boolean isEmpty()
    {
      return f.this.k() == 0;
    }
    
    public Iterator<Map.Entry<K, V>> iterator()
    {
      return new f.d(f.this);
    }
    
    public boolean remove(Object paramObject)
    {
      throw new UnsupportedOperationException();
    }
    
    public boolean removeAll(Collection<?> paramCollection)
    {
      throw new UnsupportedOperationException();
    }
    
    public boolean retainAll(Collection<?> paramCollection)
    {
      throw new UnsupportedOperationException();
    }
    
    public int size()
    {
      return f.this.k();
    }
    
    public Object[] toArray()
    {
      throw new UnsupportedOperationException();
    }
    
    public <T> T[] toArray(T[] paramArrayOfT)
    {
      throw new UnsupportedOperationException();
    }
  }
  
  final class c
    implements Set<K>
  {
    c() {}
    
    public boolean add(K paramK)
    {
      throw new UnsupportedOperationException();
    }
    
    public boolean addAll(Collection<? extends K> paramCollection)
    {
      throw new UnsupportedOperationException();
    }
    
    public void clear()
    {
      f.this.m();
    }
    
    public boolean contains(Object paramObject)
    {
      return f.this.a(paramObject) >= 0;
    }
    
    public boolean containsAll(Collection<?> paramCollection)
    {
      return f.a(f.this.l(), paramCollection);
    }
    
    public boolean equals(Object paramObject)
    {
      return f.a(this, paramObject);
    }
    
    public int hashCode()
    {
      int i = f.this.k() - 1;
      int j = 0;
      if (i >= 0)
      {
        Object localObject = f.this.b(i, 0);
        if (localObject == null) {}
        for (int k = 0;; k = localObject.hashCode())
        {
          j += k;
          i -= 1;
          break;
        }
      }
      return j;
    }
    
    public boolean isEmpty()
    {
      return f.this.k() == 0;
    }
    
    public Iterator<K> iterator()
    {
      return new f.a(f.this, 0);
    }
    
    public boolean remove(Object paramObject)
    {
      int i = f.this.a(paramObject);
      if (i >= 0)
      {
        f.this.a(i);
        return true;
      }
      return false;
    }
    
    public boolean removeAll(Collection<?> paramCollection)
    {
      return f.b(f.this.l(), paramCollection);
    }
    
    public boolean retainAll(Collection<?> paramCollection)
    {
      return f.c(f.this.l(), paramCollection);
    }
    
    public int size()
    {
      return f.this.k();
    }
    
    public Object[] toArray()
    {
      return f.this.d(0);
    }
    
    public <T> T[] toArray(T[] paramArrayOfT)
    {
      return f.this.a(paramArrayOfT, 0);
    }
  }
  
  final class d
    implements Iterator<Map.Entry<K, V>>, Map.Entry<K, V>
  {
    int X = f.this.k() - 1;
    boolean Y = false;
    int mIndex = -1;
    
    d() {}
    
    public final boolean equals(Object paramObject)
    {
      boolean bool = true;
      if (!this.Y) {
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
      }
      if (!(paramObject instanceof Map.Entry)) {
        return false;
      }
      paramObject = (Map.Entry)paramObject;
      if ((b.b(((Map.Entry)paramObject).getKey(), f.this.b(this.mIndex, 0))) && (b.b(((Map.Entry)paramObject).getValue(), f.this.b(this.mIndex, 1)))) {}
      for (;;)
      {
        return bool;
        bool = false;
      }
    }
    
    public K getKey()
    {
      if (!this.Y) {
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
      }
      return (K)f.this.b(this.mIndex, 0);
    }
    
    public V getValue()
    {
      if (!this.Y) {
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
      }
      return (V)f.this.b(this.mIndex, 1);
    }
    
    public boolean hasNext()
    {
      return this.mIndex < this.X;
    }
    
    public final int hashCode()
    {
      int j = 0;
      if (!this.Y) {
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
      }
      Object localObject1 = f.this.b(this.mIndex, 0);
      Object localObject2 = f.this.b(this.mIndex, 1);
      int i;
      if (localObject1 == null)
      {
        i = 0;
        if (localObject2 != null) {
          break label69;
        }
      }
      for (;;)
      {
        return j ^ i;
        i = localObject1.hashCode();
        break;
        label69:
        j = localObject2.hashCode();
      }
    }
    
    public Map.Entry<K, V> r()
    {
      this.mIndex += 1;
      this.Y = true;
      return this;
    }
    
    public void remove()
    {
      if (!this.Y) {
        throw new IllegalStateException();
      }
      f.this.a(this.mIndex);
      this.mIndex -= 1;
      this.X -= 1;
      this.Y = false;
    }
    
    public V setValue(V paramV)
    {
      if (!this.Y) {
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
      }
      return (V)f.this.a(this.mIndex, paramV);
    }
    
    public final String toString()
    {
      return getKey() + "=" + getValue();
    }
  }
  
  final class e
    implements Collection<V>
  {
    e() {}
    
    public boolean add(V paramV)
    {
      throw new UnsupportedOperationException();
    }
    
    public boolean addAll(Collection<? extends V> paramCollection)
    {
      throw new UnsupportedOperationException();
    }
    
    public void clear()
    {
      f.this.m();
    }
    
    public boolean contains(Object paramObject)
    {
      return f.this.b(paramObject) >= 0;
    }
    
    public boolean containsAll(Collection<?> paramCollection)
    {
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext()) {
        if (!contains(paramCollection.next())) {
          return false;
        }
      }
      return true;
    }
    
    public boolean isEmpty()
    {
      return f.this.k() == 0;
    }
    
    public Iterator<V> iterator()
    {
      return new f.a(f.this, 1);
    }
    
    public boolean remove(Object paramObject)
    {
      int i = f.this.b(paramObject);
      if (i >= 0)
      {
        f.this.a(i);
        return true;
      }
      return false;
    }
    
    public boolean removeAll(Collection<?> paramCollection)
    {
      int i = 0;
      int j = f.this.k();
      boolean bool = false;
      while (i < j)
      {
        int m = i;
        int k = j;
        if (paramCollection.contains(f.this.b(i, 1)))
        {
          f.this.a(i);
          m = i - 1;
          k = j - 1;
          bool = true;
        }
        i = m + 1;
        j = k;
      }
      return bool;
    }
    
    public boolean retainAll(Collection<?> paramCollection)
    {
      int i = 0;
      int j = f.this.k();
      boolean bool = false;
      while (i < j)
      {
        int m = i;
        int k = j;
        if (!paramCollection.contains(f.this.b(i, 1)))
        {
          f.this.a(i);
          m = i - 1;
          k = j - 1;
          bool = true;
        }
        i = m + 1;
        j = k;
      }
      return bool;
    }
    
    public int size()
    {
      return f.this.k();
    }
    
    public Object[] toArray()
    {
      return f.this.d(1);
    }
    
    public <T> T[] toArray(T[] paramArrayOfT)
    {
      return f.this.a(paramArrayOfT, 1);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/android/support/v4/b/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */