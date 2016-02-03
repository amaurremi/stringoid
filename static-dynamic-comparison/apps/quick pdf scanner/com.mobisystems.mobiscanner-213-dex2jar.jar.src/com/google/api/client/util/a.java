package com.google.api.client.util;

import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;

public class a<K, V>
  extends AbstractMap<K, V>
  implements Cloneable
{
  private Object[] acO;
  int size;
  
  private int af(Object paramObject)
  {
    int j = this.size;
    Object[] arrayOfObject = this.acO;
    int i = 0;
    while (i < j << 1)
    {
      Object localObject = arrayOfObject[i];
      if (paramObject == null)
      {
        if (localObject != null) {}
      }
      else {
        while (paramObject.equals(localObject)) {
          return i;
        }
      }
      i += 2;
    }
    return -2;
  }
  
  private void b(int paramInt, K paramK, V paramV)
  {
    Object[] arrayOfObject = this.acO;
    arrayOfObject[paramInt] = paramK;
    arrayOfObject[(paramInt + 1)] = paramV;
  }
  
  private V eN(int paramInt)
  {
    if (paramInt < 0) {
      return null;
    }
    return (V)this.acO[paramInt];
  }
  
  private V eO(int paramInt)
  {
    int i = this.size << 1;
    if ((paramInt < 0) || (paramInt >= i)) {
      return null;
    }
    Object localObject = eN(paramInt + 1);
    Object[] arrayOfObject = this.acO;
    int j = i - paramInt - 2;
    if (j != 0) {
      System.arraycopy(arrayOfObject, paramInt + 2, arrayOfObject, paramInt, j);
    }
    this.size -= 1;
    b(i - 2, null, null);
    return (V)localObject;
  }
  
  private void setDataCapacity(int paramInt)
  {
    if (paramInt == 0) {
      this.acO = null;
    }
    int i;
    Object[] arrayOfObject1;
    Object[] arrayOfObject2;
    do
    {
      do
      {
        return;
        i = this.size;
        arrayOfObject1 = this.acO;
      } while ((i != 0) && (paramInt == arrayOfObject1.length));
      arrayOfObject2 = new Object[paramInt];
      this.acO = arrayOfObject2;
    } while (i == 0);
    System.arraycopy(arrayOfObject1, 0, arrayOfObject2, 0, i << 1);
  }
  
  public static <K, V> a<K, V> yC()
  {
    return new a();
  }
  
  public final V a(int paramInt, K paramK, V paramV)
  {
    if (paramInt < 0) {
      throw new IndexOutOfBoundsException();
    }
    int i = paramInt + 1;
    ensureCapacity(i);
    paramInt <<= 1;
    Object localObject = eN(paramInt + 1);
    b(paramInt, paramK, paramV);
    if (i > this.size) {
      this.size = i;
    }
    return (V)localObject;
  }
  
  public final int ae(K paramK)
  {
    return af(paramK) >> 1;
  }
  
  public void clear()
  {
    this.size = 0;
    this.acO = null;
  }
  
  public final boolean containsKey(Object paramObject)
  {
    return -2 != af(paramObject);
  }
  
  public final boolean containsValue(Object paramObject)
  {
    int j = this.size;
    Object[] arrayOfObject = this.acO;
    int i = 1;
    while (i < j << 1)
    {
      Object localObject = arrayOfObject[i];
      if (paramObject == null)
      {
        if (localObject != null) {}
      }
      else {
        while (paramObject.equals(localObject)) {
          return true;
        }
      }
      i += 2;
    }
    return false;
  }
  
  public final K eL(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.size)) {
      return null;
    }
    return (K)this.acO[(paramInt << 1)];
  }
  
  public final V eM(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.size)) {
      return null;
    }
    return (V)eN((paramInt << 1) + 1);
  }
  
  public final void ensureCapacity(int paramInt)
  {
    if (paramInt < 0) {
      throw new IndexOutOfBoundsException();
    }
    Object[] arrayOfObject = this.acO;
    int i = paramInt << 1;
    if (arrayOfObject == null)
    {
      paramInt = 0;
      if (i > paramInt)
      {
        int j = paramInt / 2 * 3 + 1;
        paramInt = j;
        if (j % 2 != 0) {
          paramInt = j + 1;
        }
        if (paramInt >= i) {
          break label74;
        }
        paramInt = i;
      }
    }
    label74:
    for (;;)
    {
      setDataCapacity(paramInt);
      return;
      paramInt = arrayOfObject.length;
      break;
    }
  }
  
  public final Set<Map.Entry<K, V>> entrySet()
  {
    return new c();
  }
  
  public final V get(Object paramObject)
  {
    return (V)eN(af(paramObject) + 1);
  }
  
  public final V put(K paramK, V paramV)
  {
    int j = ae(paramK);
    int i = j;
    if (j == -1) {
      i = this.size;
    }
    return (V)a(i, paramK, paramV);
  }
  
  public final V remove(int paramInt)
  {
    return (V)eO(paramInt << 1);
  }
  
  public final V remove(Object paramObject)
  {
    return (V)eO(af(paramObject));
  }
  
  public final V set(int paramInt, V paramV)
  {
    int i = this.size;
    if ((paramInt < 0) || (paramInt >= i)) {
      throw new IndexOutOfBoundsException();
    }
    paramInt = (paramInt << 1) + 1;
    Object localObject = eN(paramInt);
    this.acO[paramInt] = paramV;
    return (V)localObject;
  }
  
  public final int size()
  {
    return this.size;
  }
  
  public a<K, V> yD()
  {
    try
    {
      a locala = (a)super.clone();
      Object[] arrayOfObject1 = this.acO;
      if (arrayOfObject1 != null)
      {
        int i = arrayOfObject1.length;
        Object[] arrayOfObject2 = new Object[i];
        locala.acO = arrayOfObject2;
        System.arraycopy(arrayOfObject1, 0, arrayOfObject2, 0, i);
      }
      return locala;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException) {}
    return null;
  }
  
  final class a
    implements Map.Entry<K, V>
  {
    private int index;
    
    a(int paramInt)
    {
      this.index = paramInt;
    }
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        return true;
        if (!(paramObject instanceof Map.Entry)) {
          return false;
        }
        paramObject = (Map.Entry)paramObject;
      } while ((w.b(getKey(), ((Map.Entry)paramObject).getKey())) && (w.b(getValue(), ((Map.Entry)paramObject).getValue())));
      return false;
    }
    
    public K getKey()
    {
      return (K)a.this.eL(this.index);
    }
    
    public V getValue()
    {
      return (V)a.this.eM(this.index);
    }
    
    public int hashCode()
    {
      return getKey().hashCode() ^ getValue().hashCode();
    }
    
    public V setValue(V paramV)
    {
      return (V)a.this.set(this.index, paramV);
    }
  }
  
  final class b
    implements Iterator<Map.Entry<K, V>>
  {
    private boolean acQ;
    private int acR;
    
    b() {}
    
    public boolean hasNext()
    {
      return this.acR < a.this.size;
    }
    
    public Map.Entry<K, V> r()
    {
      int i = this.acR;
      if (i == a.this.size) {
        throw new NoSuchElementException();
      }
      this.acR += 1;
      return new a.a(a.this, i);
    }
    
    public void remove()
    {
      int i = this.acR - 1;
      if ((this.acQ) || (i < 0)) {
        throw new IllegalArgumentException();
      }
      a.this.remove(i);
      this.acQ = true;
    }
  }
  
  final class c
    extends AbstractSet<Map.Entry<K, V>>
  {
    c() {}
    
    public Iterator<Map.Entry<K, V>> iterator()
    {
      return new a.b(a.this);
    }
    
    public int size()
    {
      return a.this.size;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/api/client/util/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */