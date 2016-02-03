package com.pocket.p;

public class w
  implements Cloneable
{
  private int[] a;
  private long[] b;
  private int c;
  
  public w()
  {
    this(10);
  }
  
  public w(int paramInt)
  {
    paramInt = b(paramInt);
    this.a = new int[paramInt];
    this.b = new long[paramInt];
    this.c = 0;
  }
  
  private static int a(int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3)
  {
    int j = paramInt1 - 1;
    int i = paramInt1 + paramInt2;
    while (i - j > 1)
    {
      int k = (i + j) / 2;
      if (paramArrayOfInt[k] < paramInt3) {
        j = k;
      } else {
        i = k;
      }
    }
    if (i == paramInt1 + paramInt2) {
      paramInt1 = paramInt1 + paramInt2 ^ 0xFFFFFFFF;
    }
    do
    {
      return paramInt1;
      paramInt1 = i;
    } while (paramArrayOfInt[i] == paramInt3);
    return i ^ 0xFFFFFFFF;
  }
  
  public static int b(int paramInt)
  {
    return c(paramInt * 8) / 8;
  }
  
  public static int c(int paramInt)
  {
    int i = 4;
    for (;;)
    {
      int j = paramInt;
      if (i < 32)
      {
        if (paramInt <= (1 << i) - 12) {
          j = (1 << i) - 12;
        }
      }
      else {
        return j;
      }
      i += 1;
    }
  }
  
  public long a(int paramInt)
  {
    return a(paramInt, 0L);
  }
  
  public long a(int paramInt, long paramLong)
  {
    paramInt = a(this.a, 0, this.c, paramInt);
    if (paramInt < 0) {
      return paramLong;
    }
    return this.b[paramInt];
  }
  
  public w a()
  {
    try
    {
      w localw = (w)super.clone();
      return localCloneNotSupportedException1;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException1)
    {
      try
      {
        localw.a = ((int[])this.a.clone());
        localw.b = ((long[])this.b.clone());
        return localw;
      }
      catch (CloneNotSupportedException localCloneNotSupportedException2) {}
      localCloneNotSupportedException1 = localCloneNotSupportedException1;
      return null;
    }
  }
  
  public void b(int paramInt, long paramLong)
  {
    int i = a(this.a, 0, this.c, paramInt);
    if (i >= 0)
    {
      this.b[i] = paramLong;
      return;
    }
    i ^= 0xFFFFFFFF;
    if (this.c >= this.a.length)
    {
      int j = b(this.c + 1);
      int[] arrayOfInt = new int[j];
      long[] arrayOfLong = new long[j];
      System.arraycopy(this.a, 0, arrayOfInt, 0, this.a.length);
      System.arraycopy(this.b, 0, arrayOfLong, 0, this.b.length);
      this.a = arrayOfInt;
      this.b = arrayOfLong;
    }
    if (this.c - i != 0)
    {
      System.arraycopy(this.a, i, this.a, i + 1, this.c - i);
      System.arraycopy(this.b, i, this.b, i + 1, this.c - i);
    }
    this.a[i] = paramInt;
    this.b[i] = paramLong;
    this.c += 1;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/p/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */