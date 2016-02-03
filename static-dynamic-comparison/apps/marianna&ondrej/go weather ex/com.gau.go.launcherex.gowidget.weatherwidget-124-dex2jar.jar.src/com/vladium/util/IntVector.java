package com.vladium.util;

public final class IntVector
  implements Cloneable
{
  private static final int COPY_THRESHOLD = 10;
  private int m_size;
  private int[] m_values;
  
  public IntVector()
  {
    this(5);
  }
  
  public IntVector(int paramInt)
  {
    this.m_values = new int[paramInt];
  }
  
  public void add(int paramInt)
  {
    int j = this.m_values.length;
    if (j == this.m_size)
    {
      arrayOfInt = new int[(j << 1) + 1];
      if (j < 10)
      {
        i = 0;
        while (i < j)
        {
          arrayOfInt[i] = this.m_values[i];
          i += 1;
        }
      }
      System.arraycopy(this.m_values, 0, arrayOfInt, 0, j);
      this.m_values = arrayOfInt;
    }
    int[] arrayOfInt = this.m_values;
    int i = this.m_size;
    this.m_size = (i + 1);
    arrayOfInt[i] = paramInt;
  }
  
  public Object clone()
  {
    try
    {
      IntVector localIntVector = (IntVector)super.clone();
      if (this.m_size < 10)
      {
        localIntVector.m_values = new int[this.m_values.length];
        int[] arrayOfInt = localIntVector.m_values;
        int i = 0;
        while (i < this.m_size)
        {
          arrayOfInt[i] = this.m_values[i];
          i += 1;
        }
      }
      localIntVector.m_values = ((int[])this.m_values.clone());
      return localIntVector;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      throw new InternalError(localCloneNotSupportedException.toString());
    }
  }
  
  public int get(int paramInt)
  {
    if (paramInt > this.m_size - 1) {
      throw new IndexOutOfBoundsException("get[" + paramInt + "] on vector of size " + this.m_size);
    }
    return this.m_values[paramInt];
  }
  
  public int set(int paramInt1, int paramInt2)
  {
    if (paramInt1 > this.m_size - 1) {
      throw new IndexOutOfBoundsException("get[" + paramInt1 + "] on vector of size " + this.m_size);
    }
    int i = this.m_values[paramInt1];
    this.m_values[paramInt1] = paramInt2;
    return i;
  }
  
  public int size()
  {
    return this.m_size;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer(super.toString() + ", size " + this.m_size + ": ");
    int i = 0;
    while (i < this.m_size)
    {
      if (i > 0) {
        localStringBuffer.append(", ");
      }
      localStringBuffer.append(this.m_values[i]);
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  public int[] values()
  {
    Object localObject;
    if (this.m_size == 0)
    {
      localObject = IConstants.EMPTY_INT_ARRAY;
      return (int[])localObject;
    }
    int j = this.m_size;
    int[] arrayOfInt = new int[j];
    if (j < 10)
    {
      int i = 0;
      for (;;)
      {
        localObject = arrayOfInt;
        if (i >= j) {
          break;
        }
        arrayOfInt[i] = this.m_values[i];
        i += 1;
      }
    }
    System.arraycopy(this.m_values, 0, arrayOfInt, 0, j);
    return arrayOfInt;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/util/IntVector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */