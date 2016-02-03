package com.flurry.android.monolithic.sdk.impl;

import java.lang.reflect.Array;
import java.util.List;

public final class aeh
{
  private aei a;
  private aei b;
  private int c;
  private Object[] d;
  
  protected final void a(Object paramObject, int paramInt1, Object[] paramArrayOfObject, int paramInt2)
  {
    aei localaei = this.a;
    int i = 0;
    while (localaei != null)
    {
      Object[] arrayOfObject = localaei.a();
      int j = arrayOfObject.length;
      System.arraycopy(arrayOfObject, 0, paramObject, i, j);
      i += j;
      localaei = localaei.b();
    }
    System.arraycopy(paramArrayOfObject, 0, paramObject, i, paramInt2);
    paramInt2 = i + paramInt2;
    if (paramInt2 != paramInt1) {
      throw new IllegalStateException("Should have gotten " + paramInt1 + " entries, got " + paramInt2);
    }
  }
  
  public void a(Object[] paramArrayOfObject, int paramInt, List<Object> paramList)
  {
    int j = 0;
    int i;
    for (aei localaei = this.a;; localaei = localaei.b())
    {
      i = j;
      if (localaei == null) {
        break;
      }
      Object[] arrayOfObject = localaei.a();
      int k = arrayOfObject.length;
      i = 0;
      while (i < k)
      {
        paramList.add(arrayOfObject[i]);
        i += 1;
      }
    }
    while (i < paramInt)
    {
      paramList.add(paramArrayOfObject[i]);
      i += 1;
    }
  }
  
  public Object[] a()
  {
    c();
    if (this.d == null) {
      return new Object[12];
    }
    return this.d;
  }
  
  public Object[] a(Object[] paramArrayOfObject)
  {
    aei localaei = new aei(paramArrayOfObject);
    int i;
    if (this.a == null)
    {
      this.b = localaei;
      this.a = localaei;
      i = paramArrayOfObject.length;
      this.c += i;
      if (i >= 16384) {
        break label71;
      }
      i += i;
    }
    for (;;)
    {
      return new Object[i];
      this.b.a(localaei);
      this.b = localaei;
      break;
      label71:
      i += (i >> 2);
    }
  }
  
  public Object[] a(Object[] paramArrayOfObject, int paramInt)
  {
    int i = this.c + paramInt;
    Object[] arrayOfObject = new Object[i];
    a(arrayOfObject, i, paramArrayOfObject, paramInt);
    return arrayOfObject;
  }
  
  public <T> T[] a(Object[] paramArrayOfObject, int paramInt, Class<T> paramClass)
  {
    int i = paramInt + this.c;
    paramClass = (Object[])Array.newInstance(paramClass, i);
    a(paramClass, i, paramArrayOfObject, paramInt);
    c();
    return paramClass;
  }
  
  public int b()
  {
    if (this.d == null) {
      return 0;
    }
    return this.d.length;
  }
  
  protected void c()
  {
    if (this.b != null) {
      this.d = this.b.a();
    }
    this.b = null;
    this.a = null;
    this.c = 0;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/aeh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */