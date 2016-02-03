package com.vladium.util;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

public final class SoftValueMap
  implements Map
{
  private static final boolean DEBUG = false;
  private static final boolean ENQUEUE_FOUND_CLEARED_ENTRIES = true;
  private static final String EOL = System.getProperty("line.separator", "\n");
  private static final boolean IDENTITY_OPTIMIZATION = true;
  private SoftEntry[] m_buckets;
  private final float m_loadFactor;
  private int m_readAccessCount;
  private final int m_readClearCheckFrequency;
  private int m_size;
  private int m_sizeThreshold;
  private final ReferenceQueue m_valueReferenceQueue;
  private int m_writeAccessCount;
  private final int m_writeClearCheckFrequency;
  
  public SoftValueMap()
  {
    this(1, 1);
  }
  
  public SoftValueMap(int paramInt1, float paramFloat, int paramInt2, int paramInt3)
  {
    if (paramInt1 < 0) {
      throw new IllegalArgumentException("negative input: initialCapacity [" + paramInt1 + "]");
    }
    if ((paramFloat <= 0.0D) || (paramFloat >= 1.000001D)) {
      throw new IllegalArgumentException("loadFactor not in (0.0, 1.0] range: " + paramFloat);
    }
    if (paramInt2 < 1) {
      throw new IllegalArgumentException("readClearCheckFrequency not in [1, +inf) range: " + paramInt2);
    }
    if (paramInt3 < 1) {
      throw new IllegalArgumentException("writeClearCheckFrequency not in [1, +inf) range: " + paramInt3);
    }
    int i = paramInt1;
    if (paramInt1 == 0) {
      i = 1;
    }
    this.m_valueReferenceQueue = new ReferenceQueue();
    this.m_loadFactor = paramFloat;
    this.m_sizeThreshold = ((int)(i * paramFloat));
    this.m_readClearCheckFrequency = paramInt2;
    this.m_writeClearCheckFrequency = paramInt3;
    this.m_buckets = new SoftEntry[i];
  }
  
  public SoftValueMap(int paramInt1, int paramInt2)
  {
    this(11, 0.75F, paramInt1, paramInt2);
  }
  
  private void rehash()
  {
    SoftEntry[] arrayOfSoftEntry1 = this.m_buckets;
    int k = (this.m_buckets.length << 1) + 1;
    SoftEntry[] arrayOfSoftEntry2 = new SoftEntry[k];
    int j = 0;
    int i = 0;
    int m = arrayOfSoftEntry1.length;
    while (i < m)
    {
      Object localObject = arrayOfSoftEntry1[i];
      if (localObject != null)
      {
        SoftEntry localSoftEntry = ((SoftEntry)localObject).m_next;
        IndexedSoftReference localIndexedSoftReference = ((SoftEntry)localObject).m_softValue;
        if (localIndexedSoftReference.get() != null)
        {
          int n = (0x7FFFFFFF & ((SoftEntry)localObject).m_key.hashCode()) % k;
          ((SoftEntry)localObject).m_next = arrayOfSoftEntry2[n];
          arrayOfSoftEntry2[n] = localObject;
          localIndexedSoftReference.m_bucketIndex = n;
          j += 1;
        }
        for (;;)
        {
          localObject = localSoftEntry;
          break;
          localIndexedSoftReference.m_bucketIndex = -1;
        }
      }
      i += 1;
    }
    this.m_size = j;
    this.m_sizeThreshold = ((int)(k * this.m_loadFactor));
    this.m_buckets = arrayOfSoftEntry2;
  }
  
  private void removeClearedValues()
  {
    Reference localReference;
    int i;
    do
    {
      localReference = this.m_valueReferenceQueue.poll();
      if (localReference == null) {
        break;
      }
      i = ((IndexedSoftReference)localReference).m_bucketIndex;
    } while (i < 0);
    Object localObject1 = this.m_buckets[i];
    Object localObject2 = null;
    for (;;)
    {
      if (localObject1 == null) {
        break label112;
      }
      if (((SoftEntry)localObject1).m_softValue == localReference)
      {
        if (localObject2 == null) {
          this.m_buckets[i] = ((SoftEntry)localObject1).m_next;
        }
        for (;;)
        {
          ((SoftEntry)localObject1).m_softValue = null;
          ((SoftEntry)localObject1).m_key = null;
          ((SoftEntry)localObject1).m_next = null;
          this.m_size -= 1;
          break;
          ((SoftEntry)localObject2).m_next = ((SoftEntry)localObject1).m_next;
        }
      }
      localObject2 = localObject1;
      localObject1 = ((SoftEntry)localObject1).m_next;
    }
    label112:
    localObject1 = new StringBuffer("removeClearedValues(): soft reference [" + localReference + "] did not match within bucket #" + i + EOL);
    debugDump((StringBuffer)localObject1);
    throw new Error(((StringBuffer)localObject1).toString());
  }
  
  public void clear()
  {
    SoftEntry[] arrayOfSoftEntry = this.m_buckets;
    int i = 0;
    int j = arrayOfSoftEntry.length;
    while (i < j)
    {
      SoftEntry localSoftEntry;
      for (Object localObject = arrayOfSoftEntry[i]; localObject != null; localObject = localSoftEntry)
      {
        localSoftEntry = ((SoftEntry)localObject).m_next;
        ((SoftEntry)localObject).m_softValue.m_bucketIndex = -1;
        ((SoftEntry)localObject).m_softValue = null;
        ((SoftEntry)localObject).m_next = null;
        ((SoftEntry)localObject).m_key = null;
      }
      arrayOfSoftEntry[i] = null;
      i += 1;
    }
    this.m_size = 0;
    this.m_readAccessCount = 0;
    this.m_writeAccessCount = 0;
  }
  
  public boolean containsKey(Object paramObject)
  {
    throw new UnsupportedOperationException("not implemented: containsKey");
  }
  
  public boolean containsValue(Object paramObject)
  {
    throw new UnsupportedOperationException("not implemented: containsValue");
  }
  
  void debugDump(StringBuffer paramStringBuffer)
  {
    if (paramStringBuffer != null)
    {
      paramStringBuffer.append(getClass().getName().concat("@").concat(Integer.toHexString(System.identityHashCode(this))));
      paramStringBuffer.append(EOL);
      paramStringBuffer.append("size = " + this.m_size + ", bucket table size = " + this.m_buckets.length + ", load factor = " + this.m_loadFactor + EOL);
      paramStringBuffer.append("size threshold = " + this.m_sizeThreshold + ", get clear frequency = " + this.m_readClearCheckFrequency + ", put clear frequency = " + this.m_writeClearCheckFrequency + EOL);
      paramStringBuffer.append("get count: " + this.m_readAccessCount + ", put count: " + this.m_writeAccessCount + EOL);
    }
  }
  
  public Set entrySet()
  {
    throw new UnsupportedOperationException("not implemented: entrySet");
  }
  
  public boolean equals(Object paramObject)
  {
    throw new UnsupportedOperationException("not implemented: equals");
  }
  
  public Object get(Object paramObject)
  {
    if (paramObject == null) {
      throw new IllegalArgumentException("null input: key");
    }
    int i = this.m_readAccessCount + 1;
    this.m_readAccessCount = i;
    if (i % this.m_readClearCheckFrequency == 0) {
      removeClearedValues();
    }
    i = paramObject.hashCode();
    Object localObject1 = this.m_buckets;
    for (localObject1 = localObject1[((0x7FFFFFFF & i) % localObject1.length)]; localObject1 != null; localObject1 = ((SoftEntry)localObject1).m_next)
    {
      Object localObject2 = ((SoftEntry)localObject1).m_key;
      if ((paramObject == localObject2) || ((i == localObject2.hashCode()) && (paramObject.equals(localObject2))))
      {
        paramObject = ((SoftEntry)localObject1).m_softValue;
        localObject1 = ((Reference)paramObject).get();
        if (localObject1 == null) {
          ((Reference)paramObject).enqueue();
        }
        return localObject1;
      }
    }
    return null;
  }
  
  public int hashCode()
  {
    throw new UnsupportedOperationException("not implemented: hashCode");
  }
  
  public boolean isEmpty()
  {
    return this.m_size == 0;
  }
  
  public Set keySet()
  {
    throw new UnsupportedOperationException("not implemented: keySet");
  }
  
  public Object put(Object paramObject1, Object paramObject2)
  {
    if (paramObject1 == null) {
      throw new IllegalArgumentException("null input: key");
    }
    if (paramObject2 == null) {
      throw new IllegalArgumentException("null input: value");
    }
    int i = this.m_writeAccessCount + 1;
    this.m_writeAccessCount = i;
    if (i % this.m_writeClearCheckFrequency == 0) {
      removeClearedValues();
    }
    Object localObject3 = null;
    i = paramObject1.hashCode();
    Object localObject1 = this.m_buckets;
    int j = (i & 0x7FFFFFFF) % localObject1.length;
    for (localObject1 = localObject1[j];; localObject1 = ((SoftEntry)localObject1).m_next)
    {
      localObject2 = localObject3;
      if (localObject1 != null)
      {
        localObject2 = ((SoftEntry)localObject1).m_key;
        if ((paramObject1 == localObject2) || ((i == localObject2.hashCode()) && (paramObject1.equals(localObject2)))) {
          localObject2 = localObject1;
        }
      }
      else
      {
        if (localObject2 == null) {
          break;
        }
        paramObject1 = ((SoftEntry)localObject2).m_softValue;
        localObject1 = ((IndexedSoftReference)paramObject1).get();
        if (localObject1 == null) {
          ((IndexedSoftReference)paramObject1).m_bucketIndex = -1;
        }
        ((SoftEntry)localObject2).m_softValue = new IndexedSoftReference(paramObject2, this.m_valueReferenceQueue, j);
        return localObject1;
      }
    }
    if (this.m_size >= this.m_sizeThreshold) {
      rehash();
    }
    localObject1 = this.m_buckets;
    i = (i & 0x7FFFFFFF) % localObject1.length;
    Object localObject2 = localObject1[i];
    localObject1[i] = new SoftEntry(this.m_valueReferenceQueue, paramObject1, paramObject2, (SoftEntry)localObject2, i);
    this.m_size += 1;
    return null;
  }
  
  public void putAll(Map paramMap)
  {
    throw new UnsupportedOperationException("not implemented: putAll");
  }
  
  public Object remove(Object paramObject)
  {
    if (paramObject == null) {
      throw new IllegalArgumentException("null input: key");
    }
    int i = this.m_writeAccessCount + 1;
    this.m_writeAccessCount = i;
    if (i % this.m_writeClearCheckFrequency == 0) {
      removeClearedValues();
    }
    i = paramObject.hashCode();
    SoftEntry[] arrayOfSoftEntry = this.m_buckets;
    int j = (0x7FFFFFFF & i) % arrayOfSoftEntry.length;
    Object localObject2 = null;
    SoftEntry localSoftEntry1 = arrayOfSoftEntry[j];
    SoftEntry localSoftEntry2 = null;
    for (;;)
    {
      Object localObject1 = localObject2;
      if (localSoftEntry1 != null)
      {
        localObject1 = localSoftEntry1.m_key;
        if ((localObject1 != paramObject) && ((i != localObject1.hashCode()) || (!paramObject.equals(localObject1)))) {
          break label186;
        }
        if (localSoftEntry2 != null) {
          break label173;
        }
        arrayOfSoftEntry[j] = localSoftEntry1.m_next;
      }
      for (;;)
      {
        paramObject = localSoftEntry1.m_softValue;
        localObject1 = ((IndexedSoftReference)paramObject).get();
        ((IndexedSoftReference)paramObject).m_bucketIndex = -1;
        localSoftEntry1.m_softValue = null;
        localSoftEntry1.m_key = null;
        localSoftEntry1.m_next = null;
        this.m_size -= 1;
        return localObject1;
        label173:
        localSoftEntry2.m_next = localSoftEntry1.m_next;
      }
      label186:
      localSoftEntry2 = localSoftEntry1;
      localSoftEntry1 = localSoftEntry1.m_next;
    }
  }
  
  public int size()
  {
    return this.m_size;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    debugDump(localStringBuffer);
    return localStringBuffer.toString();
  }
  
  public Collection values()
  {
    throw new UnsupportedOperationException("not implemented: values");
  }
  
  static class IndexedSoftReference
    extends SoftReference
  {
    int m_bucketIndex;
    
    IndexedSoftReference(Object paramObject, ReferenceQueue paramReferenceQueue, int paramInt)
    {
      super(paramReferenceQueue);
      this.m_bucketIndex = paramInt;
    }
  }
  
  static class SoftEntry
  {
    Object m_key;
    SoftEntry m_next;
    SoftValueMap.IndexedSoftReference m_softValue;
    
    SoftEntry(ReferenceQueue paramReferenceQueue, Object paramObject1, Object paramObject2, SoftEntry paramSoftEntry, int paramInt)
    {
      this.m_key = paramObject1;
      this.m_softValue = new SoftValueMap.IndexedSoftReference(paramObject2, paramReferenceQueue, paramInt);
      this.m_next = paramSoftEntry;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/util/SoftValueMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */