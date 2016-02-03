package com.flurry.android.monolithic.sdk.impl;

public final class pk
  extends pa
{
  protected final pk c;
  protected int d;
  protected int e;
  protected String f;
  protected pk g = null;
  
  public pk(pk parampk, int paramInt1, int paramInt2, int paramInt3)
  {
    this.a = paramInt1;
    this.c = parampk;
    this.d = paramInt2;
    this.e = paramInt3;
    this.b = -1;
  }
  
  public static pk a(int paramInt1, int paramInt2)
  {
    return new pk(null, 0, paramInt1, paramInt2);
  }
  
  public static pk g()
  {
    return new pk(null, 0, 1, 0);
  }
  
  public final ot a(Object paramObject)
  {
    return new ot(paramObject, -1L, this.d, this.e);
  }
  
  protected final void a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.a = paramInt1;
    this.b = -1;
    this.d = paramInt2;
    this.e = paramInt3;
    this.f = null;
  }
  
  public void a(String paramString)
  {
    this.f = paramString;
  }
  
  public final pk b(int paramInt1, int paramInt2)
  {
    pk localpk = this.g;
    if (localpk == null)
    {
      localpk = new pk(this, 1, paramInt1, paramInt2);
      this.g = localpk;
      return localpk;
    }
    localpk.a(1, paramInt1, paramInt2);
    return localpk;
  }
  
  public final pk c(int paramInt1, int paramInt2)
  {
    pk localpk = this.g;
    if (localpk == null)
    {
      localpk = new pk(this, 2, paramInt1, paramInt2);
      this.g = localpk;
      return localpk;
    }
    localpk.a(2, paramInt1, paramInt2);
    return localpk;
  }
  
  public final String h()
  {
    return this.f;
  }
  
  public final pk i()
  {
    return this.c;
  }
  
  public final boolean j()
  {
    int i = this.b + 1;
    this.b = i;
    return (this.a != 0) && (i > 0);
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(64);
    switch (this.a)
    {
    default: 
    case 0: 
    case 1: 
      for (;;)
      {
        return localStringBuilder.toString();
        localStringBuilder.append("/");
        continue;
        localStringBuilder.append('[');
        localStringBuilder.append(f());
        localStringBuilder.append(']');
      }
    }
    localStringBuilder.append('{');
    if (this.f != null)
    {
      localStringBuilder.append('"');
      afr.a(localStringBuilder, this.f);
      localStringBuilder.append('"');
    }
    for (;;)
    {
      localStringBuilder.append('}');
      break;
      localStringBuilder.append('?');
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/pk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */