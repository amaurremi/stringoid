package com.vladium.util;

public final class IntSet
{
  private static final String EOL = System.getProperty("line.separator", "\n");
  private Entry[] m_buckets;
  private final float m_loadFactor;
  private int m_size;
  private int m_sizeThreshold;
  
  public IntSet()
  {
    this(11, 0.75F);
  }
  
  public IntSet(int paramInt)
  {
    this(paramInt, 0.75F);
  }
  
  public IntSet(int paramInt, float paramFloat)
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
        int k = (0x7FFFFFFF & ((Entry)localObject).m_key) % j;
        ((Entry)localObject).m_next = arrayOfEntry2[k];
        arrayOfEntry2[k] = localObject;
      }
      i += 1;
    }
    this.m_sizeThreshold = ((int)(j * this.m_loadFactor));
    this.m_buckets = arrayOfEntry2;
  }
  
  public boolean add(int paramInt)
  {
    Object localObject3 = null;
    int i = this.m_buckets.length;
    for (Object localObject1 = this.m_buckets[((paramInt & 0x7FFFFFFF) % i)];; localObject1 = ((Entry)localObject1).m_next)
    {
      Object localObject2 = localObject3;
      if (localObject1 != null)
      {
        if (paramInt == ((Entry)localObject1).m_key) {
          localObject2 = localObject1;
        }
      }
      else
      {
        if (localObject2 != null) {
          break;
        }
        if (this.m_size >= this.m_sizeThreshold) {
          rehash();
        }
        localObject1 = this.m_buckets;
        i = (paramInt & 0x7FFFFFFF) % localObject1.length;
        localObject1[i] = new Entry(paramInt, localObject1[i]);
        this.m_size += 1;
        return true;
      }
    }
    return false;
  }
  
  public boolean contains(int paramInt)
  {
    Object localObject = this.m_buckets;
    for (localObject = localObject[((0x7FFFFFFF & paramInt) % localObject.length)]; localObject != null; localObject = ((Entry)localObject).m_next) {
      if (paramInt == ((Entry)localObject).m_key) {
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
  
  public void values(int[] paramArrayOfInt, int paramInt)
  {
    if (this.m_size != 0)
    {
      int i = 0;
      while (i < this.m_buckets.length)
      {
        Entry localEntry = this.m_buckets[i];
        while (localEntry != null)
        {
          paramArrayOfInt[paramInt] = localEntry.m_key;
          localEntry = localEntry.m_next;
          paramInt += 1;
        }
        i += 1;
      }
    }
  }
  
  public int[] values()
  {
    Object localObject;
    if (this.m_size == 0)
    {
      localObject = IConstants.EMPTY_INT_ARRAY;
      return (int[])localObject;
    }
    int[] arrayOfInt = new int[this.m_size];
    int i = 0;
    int j = 0;
    for (;;)
    {
      localObject = arrayOfInt;
      if (j >= this.m_buckets.length) {
        break;
      }
      localObject = this.m_buckets[j];
      while (localObject != null)
      {
        arrayOfInt[i] = ((Entry)localObject).m_key;
        localObject = ((Entry)localObject).m_next;
        i += 1;
      }
      j += 1;
    }
  }
  
  private static final class Entry
  {
    final int m_key;
    Entry m_next;
    
    Entry(int paramInt, Entry paramEntry)
    {
      this.m_key = paramInt;
      this.m_next = paramEntry;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/util/IntSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */