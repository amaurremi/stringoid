package com.pocket.p;

import java.util.Arrays;
import org.apache.a.c.a;

public class m
{
  private static final int[] c = new int[0];
  int a;
  transient int[] b;
  
  public m()
  {
    this.b = new int[0];
  }
  
  public m(int[] paramArrayOfInt)
  {
    int[] arrayOfInt = new int[paramArrayOfInt.length];
    System.arraycopy(paramArrayOfInt, 0, arrayOfInt, 0, arrayOfInt.length);
    this.b = arrayOfInt;
    this.a = arrayOfInt.length;
  }
  
  static IndexOutOfBoundsException b(int paramInt1, int paramInt2)
  {
    throw new IndexOutOfBoundsException("Invalid index " + paramInt1 + ", size is " + paramInt2);
  }
  
  private static int c(int paramInt)
  {
    if (paramInt < 6) {}
    for (int i = 12;; i = paramInt >> 1) {
      return i + paramInt;
    }
  }
  
  public void a()
  {
    if (this.a != 0)
    {
      Arrays.fill(this.b, 0, this.a, 0);
      this.a = 0;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    Object localObject = this.b;
    int i = this.a;
    if ((paramInt1 > i) || (paramInt1 < 0)) {
      b(paramInt1, i);
    }
    if (i < localObject.length) {
      System.arraycopy(localObject, paramInt1, localObject, paramInt1 + 1, i - paramInt1);
    }
    for (;;)
    {
      localObject[paramInt1] = paramInt2;
      this.a = (i + 1);
      return;
      int[] arrayOfInt = new int[c(i)];
      System.arraycopy(localObject, 0, arrayOfInt, 0, paramInt1);
      System.arraycopy(localObject, paramInt1, arrayOfInt, paramInt1 + 1, i - paramInt1);
      this.b = arrayOfInt;
      localObject = arrayOfInt;
    }
  }
  
  public boolean a(int paramInt)
  {
    Object localObject = this.b;
    int j = this.a;
    int i;
    if (j == localObject.length) {
      if (j < 6)
      {
        i = 12;
        int[] arrayOfInt = new int[i + j];
        System.arraycopy(localObject, 0, arrayOfInt, 0, j);
        this.b = arrayOfInt;
        localObject = arrayOfInt;
      }
    }
    for (;;)
    {
      localObject[j] = paramInt;
      this.a = (j + 1);
      return true;
      i = j >> 1;
      break;
    }
  }
  
  public int b(int paramInt)
  {
    if (paramInt >= this.a) {
      b(paramInt, this.a);
    }
    return this.b[paramInt];
  }
  
  public m b()
  {
    return new m(this.b);
  }
  
  public int c()
  {
    return this.a;
  }
  
  public int c(int paramInt1, int paramInt2)
  {
    int[] arrayOfInt = this.b;
    if (paramInt1 >= this.a) {
      b(paramInt1, this.a);
    }
    int i = arrayOfInt[paramInt1];
    arrayOfInt[paramInt1] = paramInt2;
    return i;
  }
  
  public boolean d()
  {
    return this.a == 0;
  }
  
  public int[] e()
  {
    return this.b;
  }
  
  public String toString()
  {
    return a.a(this.b);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/p/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */