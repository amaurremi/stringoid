package com.vladium.util;

public final class ObjectIntMap
{
  private static final String EOL = System.getProperty("line.separator", "\n");
  private Entry[] m_buckets;
  private final float m_loadFactor;
  private int m_size;
  private int m_sizeThreshold;
  
  public ObjectIntMap()
  {
    this(11, 0.75F);
  }
  
  public ObjectIntMap(int paramInt)
  {
    this(paramInt, 0.75F);
  }
  
  public ObjectIntMap(int paramInt, float paramFloat)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException("negative input: initialCapacity [" + paramInt + "]");
    }
    if ((paramFloat <= 0.0D) || (paramFloat >= 1.000001D)) {
      throw new IllegalArgumentException("loadFactor not in (0.0, 1.0] range: " + paramFloat);
    }
    int i = paramInt;
    if (paramInt == 0) {
      i = 1;
    }
    if (paramFloat > 1.0D) {}
    for (float f = 1.0F;; f = paramFloat)
    {
      this.m_loadFactor = f;
      this.m_sizeThreshold = ((int)(i * paramFloat));
      this.m_buckets = new Entry[i];
      return;
    }
  }
  
  private void rehash()
  {
    Entry[] arrayOfEntry1 = this.m_buckets;
    int j = (this.m_buckets.length << 1) + 1;
    Entry[] arrayOfEntry2 = new Entry[j];
    int i = 0;
    while (i < arrayOfEntry1.length)
    {
      Entry localEntry;
      for (Object localObject = arrayOfEntry1[i]; localObject != null; localObject = localEntry)
      {
        localEntry = ((Entry)localObject).m_next;
        int k = (((Entry)localObject).m_key.hashCode() & 0x7FFFFFFF) % j;
        ((Entry)localObject).m_next = arrayOfEntry2[k];
        arrayOfEntry2[k] = localObject;
      }
      i += 1;
    }
    this.m_sizeThreshold = ((int)(j * this.m_loadFactor));
    this.m_buckets = arrayOfEntry2;
  }
  
  public boolean contains(Object paramObject)
  {
    Object localObject = this.m_buckets;
    int i = paramObject.hashCode();
    for (localObject = localObject[((0x7FFFFFFF & i) % localObject.length)]; localObject != null; localObject = ((Entry)localObject).m_next) {
      if ((i == ((Entry)localObject).m_key.hashCode()) || (((Entry)localObject).m_key.equals(paramObject))) {
        return true;
      }
    }
    return false;
  }
  
  void debugDump(StringBuffer paramStringBuffer)
  {
    if (paramStringBuffer != null)
    {
      paramStringBuffer.append(super.toString());
      paramStringBuffer.append(EOL);
      paramStringBuffer.append("size = " + this.m_size + ", bucket table size = " + this.m_buckets.length + ", load factor = " + this.m_loadFactor + EOL);
      paramStringBuffer.append("size threshold = " + this.m_sizeThreshold + EOL);
    }
  }
  
  public boolean get(Object paramObject, int[] paramArrayOfInt)
  {
    boolean bool2 = false;
    Object localObject = this.m_buckets;
    int i = paramObject.hashCode();
    for (localObject = localObject[((0x7FFFFFFF & i) % localObject.length)];; localObject = ((Entry)localObject).m_next)
    {
      boolean bool1 = bool2;
      if (localObject != null)
      {
        if ((i == ((Entry)localObject).m_key.hashCode()) || (((Entry)localObject).m_key.equals(paramObject)))
        {
          paramArrayOfInt[0] = ((Entry)localObject).m_value;
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
    }
  }
  
  public Object[] keys()
  {
    Object[] arrayOfObject = new Object[this.m_size];
    int i = 0;
    int j = 0;
    while (j < this.m_buckets.length)
    {
      Entry localEntry = this.m_buckets[j];
      while (localEntry != null)
      {
        arrayOfObject[i] = localEntry.m_key;
        localEntry = localEntry.m_next;
        i += 1;
      }
      j += 1;
    }
    return arrayOfObject;
  }
  
  public void put(Object paramObject, int paramInt)
  {
    Object localObject3 = null;
    int i = paramObject.hashCode();
    int j = this.m_buckets.length;
    for (Object localObject1 = this.m_buckets[((i & 0x7FFFFFFF) % j)];; localObject1 = ((Entry)localObject1).m_next)
    {
      Object localObject2 = localObject3;
      if (localObject1 != null)
      {
        if ((i == ((Entry)localObject1).m_key.hashCode()) || (((Entry)localObject1).m_key.equals(paramObject))) {
          localObject2 = localObject1;
        }
      }
      else
      {
        if (localObject2 == null) {
          break;
        }
        ((Entry)localObject2).m_value = paramInt;
        return;
      }
    }
    if (this.m_size >= this.m_sizeThreshold) {
      rehash();
    }
    localObject1 = this.m_buckets;
    i = (i & 0x7FFFFFFF) % localObject1.length;
    localObject1[i] = new Entry(paramObject, paramInt, localObject1[i]);
    this.m_size += 1;
  }
  
  public void remove(Object paramObject)
  {
    int i = paramObject.hashCode();
    int j = (0x7FFFFFFF & i) % this.m_buckets.length;
    Entry[] arrayOfEntry = this.m_buckets;
    Object localObject1 = arrayOfEntry[j];
    Object localObject2 = localObject1;
    for (;;)
    {
      Entry localEntry;
      if (localObject1 != null)
      {
        localEntry = ((Entry)localObject1).m_next;
        if ((i != ((Entry)localObject1).m_key.hashCode()) && (!((Entry)localObject1).m_key.equals(paramObject))) {
          break label102;
        }
        if (localObject2 != localObject1) {
          break label92;
        }
        arrayOfEntry[j] = localEntry;
      }
      for (;;)
      {
        this.m_size -= 1;
        return;
        label92:
        ((Entry)localObject2).m_next = localEntry;
      }
      label102:
      localObject2 = localObject1;
      localObject1 = localEntry;
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
  
  private static final class Entry
  {
    Object m_key;
    Entry m_next;
    int m_value;
    
    Entry(Object paramObject, int paramInt, Entry paramEntry)
    {
      this.m_key = paramObject;
      this.m_value = paramInt;
      this.m_next = paramEntry;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/util/ObjectIntMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */