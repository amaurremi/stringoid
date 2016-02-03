package com.flurry.android.monolithic.sdk.impl;

public final class tw
{
  final ow a;
  final qm b;
  final Object[] c;
  private int d;
  private ts e;
  
  public tw(ow paramow, qm paramqm, int paramInt)
  {
    this.a = paramow;
    this.b = paramqm;
    this.d = paramInt;
    this.c = new Object[paramInt];
  }
  
  protected ts a()
  {
    return this.e;
  }
  
  public void a(sv paramsv, String paramString, Object paramObject)
  {
    this.e = new tt(this.e, paramObject, paramsv, paramString);
  }
  
  public void a(sw paramsw, Object paramObject)
  {
    this.e = new tv(this.e, paramObject, paramsw);
  }
  
  public void a(Object paramObject1, Object paramObject2)
  {
    this.e = new tu(this.e, paramObject2, paramObject1);
  }
  
  public void a(sw[] paramArrayOfsw)
  {
    int i = 0;
    int j = paramArrayOfsw.length;
    while (i < j)
    {
      sw localsw = paramArrayOfsw[i];
      if (localsw != null) {
        this.c[i] = this.b.a(localsw.k(), localsw, null);
      }
      i += 1;
    }
  }
  
  public boolean a(int paramInt, Object paramObject)
  {
    this.c[paramInt] = paramObject;
    paramInt = this.d - 1;
    this.d = paramInt;
    return paramInt <= 0;
  }
  
  protected final Object[] a(Object[] paramArrayOfObject)
  {
    if (paramArrayOfObject != null)
    {
      int i = 0;
      int j = this.c.length;
      while (i < j)
      {
        if (this.c[i] == null)
        {
          Object localObject = paramArrayOfObject[i];
          if (localObject != null) {
            this.c[i] = localObject;
          }
        }
        i += 1;
      }
    }
    return this.c;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/tw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */