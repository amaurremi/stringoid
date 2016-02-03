package com.google.gson.internal;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;

public final class StringMap<V>
  extends AbstractMap<String, V>
{
  private static final Map.Entry[] EMPTY_TABLE = new StringMap.LinkedEntry[2];
  private static final int MAXIMUM_CAPACITY = 1073741824;
  private static final int MINIMUM_CAPACITY = 4;
  private static final int seed = new Random().nextInt();
  private Set<Map.Entry<String, V>> entrySet;
  private StringMap.LinkedEntry<V> header = new StringMap.LinkedEntry();
  private Set<String> keySet;
  private int size;
  private StringMap.LinkedEntry<V>[] table = (StringMap.LinkedEntry[])EMPTY_TABLE;
  private int threshold = -1;
  private Collection<V> values;
  
  private void addNewEntry(String paramString, V paramV, int paramInt1, int paramInt2)
  {
    StringMap.LinkedEntry localLinkedEntry1 = this.header;
    StringMap.LinkedEntry localLinkedEntry2 = localLinkedEntry1.prv;
    paramString = new StringMap.LinkedEntry(paramString, paramV, paramInt1, this.table[paramInt2], localLinkedEntry1, localLinkedEntry2);
    paramV = this.table;
    localLinkedEntry1.prv = paramString;
    localLinkedEntry2.nxt = paramString;
    paramV[paramInt2] = paramString;
  }
  
  private StringMap.LinkedEntry<V>[] doubleCapacity()
  {
    StringMap.LinkedEntry[] arrayOfLinkedEntry1 = this.table;
    int m = arrayOfLinkedEntry1.length;
    if (m == 1073741824) {
      return arrayOfLinkedEntry1;
    }
    StringMap.LinkedEntry[] arrayOfLinkedEntry2 = makeTable(m * 2);
    if (this.size == 0) {
      return arrayOfLinkedEntry2;
    }
    int j = 0;
    Object localObject2;
    Object localObject1;
    Object localObject3;
    for (;;)
    {
      if (j < m)
      {
        localObject2 = arrayOfLinkedEntry1[j];
        if (localObject2 == null)
        {
          j += 1;
        }
        else
        {
          int i = ((StringMap.LinkedEntry)localObject2).hash & m;
          arrayOfLinkedEntry2[(j | i)] = localObject2;
          localObject1 = ((StringMap.LinkedEntry)localObject2).next;
          localObject3 = null;
          label94:
          if (localObject1 != null)
          {
            int k = ((StringMap.LinkedEntry)localObject1).hash & m;
            if (k == i) {
              break label177;
            }
            if (localObject3 == null)
            {
              arrayOfLinkedEntry2[(j | k)] = localObject1;
              label126:
              i = k;
            }
          }
        }
      }
    }
    for (;;)
    {
      StringMap.LinkedEntry localLinkedEntry = ((StringMap.LinkedEntry)localObject1).next;
      localObject3 = localObject2;
      localObject2 = localObject1;
      localObject1 = localLinkedEntry;
      break label94;
      ((StringMap.LinkedEntry)localObject3).next = ((StringMap.LinkedEntry)localObject1);
      break label126;
      if (localObject3 == null) {
        break;
      }
      ((StringMap.LinkedEntry)localObject3).next = null;
      break;
      return arrayOfLinkedEntry2;
      label177:
      localObject2 = localObject3;
    }
  }
  
  private StringMap.LinkedEntry<V> getEntry(String paramString)
  {
    if (paramString == null) {}
    for (;;)
    {
      return null;
      int i = hash(paramString);
      Object localObject = this.table;
      for (localObject = localObject[(localObject.length - 1 & i)]; localObject != null; localObject = ((StringMap.LinkedEntry)localObject).next)
      {
        String str = ((StringMap.LinkedEntry)localObject).key;
        if ((str == paramString) || ((((StringMap.LinkedEntry)localObject).hash == i) && (paramString.equals(str)))) {
          return (StringMap.LinkedEntry<V>)localObject;
        }
      }
    }
  }
  
  private static int hash(String paramString)
  {
    int j = seed;
    int i = 0;
    while (i < paramString.length())
    {
      j += paramString.charAt(i);
      j = j + j << 10;
      j ^= j >>> 6;
      i += 1;
    }
    i = j >>> 20 ^ j >>> 12 ^ j;
    return i >>> 4 ^ i >>> 7 ^ i;
  }
  
  private StringMap.LinkedEntry<V>[] makeTable(int paramInt)
  {
    StringMap.LinkedEntry[] arrayOfLinkedEntry = (StringMap.LinkedEntry[])new StringMap.LinkedEntry[paramInt];
    this.table = arrayOfLinkedEntry;
    this.threshold = ((paramInt >> 1) + (paramInt >> 2));
    return arrayOfLinkedEntry;
  }
  
  private boolean removeMapping(Object paramObject1, Object paramObject2)
  {
    if ((paramObject1 == null) || (!(paramObject1 instanceof String))) {
      return false;
    }
    int i = hash((String)paramObject1);
    StringMap.LinkedEntry[] arrayOfLinkedEntry = this.table;
    int j = i & arrayOfLinkedEntry.length - 1;
    Object localObject1 = arrayOfLinkedEntry[j];
    Object localObject2 = null;
    while (localObject1 != null)
    {
      if ((((StringMap.LinkedEntry)localObject1).hash == i) && (paramObject1.equals(((StringMap.LinkedEntry)localObject1).key)))
      {
        if (paramObject2 == null)
        {
          if (((StringMap.LinkedEntry)localObject1).value == null) {}
        }
        else {
          while (!paramObject2.equals(((StringMap.LinkedEntry)localObject1).value)) {
            return false;
          }
        }
        if (localObject2 == null) {
          arrayOfLinkedEntry[j] = ((StringMap.LinkedEntry)localObject1).next;
        }
        for (;;)
        {
          this.size -= 1;
          unlink((StringMap.LinkedEntry)localObject1);
          return true;
          ((StringMap.LinkedEntry)localObject2).next = ((StringMap.LinkedEntry)localObject1).next;
        }
      }
      StringMap.LinkedEntry localLinkedEntry = ((StringMap.LinkedEntry)localObject1).next;
      localObject2 = localObject1;
      localObject1 = localLinkedEntry;
    }
    return false;
  }
  
  private void unlink(StringMap.LinkedEntry<V> paramLinkedEntry)
  {
    paramLinkedEntry.prv.nxt = paramLinkedEntry.nxt;
    paramLinkedEntry.nxt.prv = paramLinkedEntry.prv;
    paramLinkedEntry.prv = null;
    paramLinkedEntry.nxt = null;
  }
  
  public void clear()
  {
    if (this.size != 0)
    {
      Arrays.fill(this.table, null);
      this.size = 0;
    }
    StringMap.LinkedEntry localLinkedEntry2 = this.header;
    StringMap.LinkedEntry localLinkedEntry1;
    for (Object localObject = localLinkedEntry2.nxt; localObject != localLinkedEntry2; localObject = localLinkedEntry1)
    {
      localLinkedEntry1 = ((StringMap.LinkedEntry)localObject).nxt;
      ((StringMap.LinkedEntry)localObject).prv = null;
      ((StringMap.LinkedEntry)localObject).nxt = null;
    }
    localLinkedEntry2.prv = localLinkedEntry2;
    localLinkedEntry2.nxt = localLinkedEntry2;
  }
  
  public boolean containsKey(Object paramObject)
  {
    return ((paramObject instanceof String)) && (getEntry((String)paramObject) != null);
  }
  
  public Set<Map.Entry<String, V>> entrySet()
  {
    Object localObject = this.entrySet;
    if (localObject != null) {
      return (Set<Map.Entry<String, V>>)localObject;
    }
    localObject = new StringMap.EntrySet(this, null);
    this.entrySet = ((Set)localObject);
    return (Set<Map.Entry<String, V>>)localObject;
  }
  
  public V get(Object paramObject)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if ((paramObject instanceof String))
    {
      paramObject = getEntry((String)paramObject);
      localObject1 = localObject2;
      if (paramObject != null) {
        localObject1 = ((StringMap.LinkedEntry)paramObject).value;
      }
    }
    return (V)localObject1;
  }
  
  public Set<String> keySet()
  {
    Object localObject = this.keySet;
    if (localObject != null) {
      return (Set<String>)localObject;
    }
    localObject = new StringMap.KeySet(this, null);
    this.keySet = ((Set)localObject);
    return (Set<String>)localObject;
  }
  
  public V put(String paramString, V paramV)
  {
    if (paramString == null) {
      throw new NullPointerException("key == null");
    }
    int j = hash(paramString);
    Object localObject = this.table;
    int i = localObject.length - 1 & j;
    for (localObject = localObject[i]; localObject != null; localObject = ((StringMap.LinkedEntry)localObject).next) {
      if ((((StringMap.LinkedEntry)localObject).hash == j) && (paramString.equals(((StringMap.LinkedEntry)localObject).key)))
      {
        paramString = ((StringMap.LinkedEntry)localObject).value;
        ((StringMap.LinkedEntry)localObject).value = paramV;
        return paramString;
      }
    }
    int k = this.size;
    this.size = (k + 1);
    if (k > this.threshold) {
      i = doubleCapacity().length - 1 & j;
    }
    addNewEntry(paramString, paramV, j, i);
    return null;
  }
  
  public V remove(Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof String))) {
      return null;
    }
    int i = hash((String)paramObject);
    StringMap.LinkedEntry[] arrayOfLinkedEntry = this.table;
    int j = i & arrayOfLinkedEntry.length - 1;
    Object localObject1 = arrayOfLinkedEntry[j];
    Object localObject2 = null;
    while (localObject1 != null)
    {
      if ((((StringMap.LinkedEntry)localObject1).hash == i) && (paramObject.equals(((StringMap.LinkedEntry)localObject1).key)))
      {
        if (localObject2 == null) {
          arrayOfLinkedEntry[j] = ((StringMap.LinkedEntry)localObject1).next;
        }
        for (;;)
        {
          this.size -= 1;
          unlink((StringMap.LinkedEntry)localObject1);
          return (V)((StringMap.LinkedEntry)localObject1).value;
          ((StringMap.LinkedEntry)localObject2).next = ((StringMap.LinkedEntry)localObject1).next;
        }
      }
      StringMap.LinkedEntry localLinkedEntry = ((StringMap.LinkedEntry)localObject1).next;
      localObject2 = localObject1;
      localObject1 = localLinkedEntry;
    }
    return null;
  }
  
  public int size()
  {
    return this.size;
  }
  
  public Collection<V> values()
  {
    Object localObject = this.values;
    if (localObject != null) {
      return (Collection<V>)localObject;
    }
    localObject = new StringMap.Values(this, null);
    this.values = ((Collection)localObject);
    return (Collection<V>)localObject;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/google/gson/internal/StringMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */