package com.vungle.publisher;

import java.lang.reflect.Array;

public final class cj<E>
{
  private final Class<E> a;
  private final E[] b;
  private int c;
  private int d;
  
  public cj(Class<E> paramClass)
  {
    this.a = paramClass;
    this.b = a(10);
  }
  
  private E[] a(int paramInt)
  {
    return (Object[])Array.newInstance(this.a, paramInt);
  }
  
  private E[] b()
  {
    synchronized (this.b)
    {
      int j = this.b.length;
      int i = c();
      Object[] arrayOfObject2 = a(i);
      if (this.c + i > j)
      {
        j -= this.c;
        System.arraycopy(this.b, this.c, arrayOfObject2, 0, j);
        System.arraycopy(this.b, 0, arrayOfObject2, j, i - j);
        return arrayOfObject2;
      }
      System.arraycopy(this.b, this.c, arrayOfObject2, 0, i);
    }
  }
  
  private int c()
  {
    synchronized (this.b)
    {
      int i = this.d;
      return i;
    }
  }
  
  public final E[] a()
  {
    synchronized (this.b)
    {
      Object[] arrayOfObject3 = b();
      synchronized (this.b)
      {
        this.d = 0;
        return arrayOfObject3;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/cj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */