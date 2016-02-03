package com.flurry.android.monolithic.sdk.impl;

public final class pq
{
  protected final Object a;
  protected final boolean b;
  protected final afn c;
  protected byte[] d = null;
  protected byte[] e = null;
  protected char[] f = null;
  protected char[] g = null;
  protected char[] h = null;
  
  public pq(afn paramafn, Object paramObject, boolean paramBoolean)
  {
    this.c = paramafn;
    this.a = paramObject;
    this.b = paramBoolean;
  }
  
  public final Object a()
  {
    return this.a;
  }
  
  public final void a(char[] paramArrayOfChar)
  {
    if (paramArrayOfChar != null)
    {
      if (paramArrayOfChar != this.f) {
        throw new IllegalArgumentException("Trying to release buffer not owned by the context");
      }
      this.f = null;
      this.c.a(afp.a, paramArrayOfChar);
    }
  }
  
  public final char[] a(int paramInt)
  {
    if (this.h != null) {
      throw new IllegalStateException("Trying to call allocNameCopyBuffer() second time");
    }
    this.h = this.c.a(afp.d, paramInt);
    return this.h;
  }
  
  public final void b(char[] paramArrayOfChar)
  {
    if (paramArrayOfChar != null)
    {
      if (paramArrayOfChar != this.g) {
        throw new IllegalArgumentException("Trying to release buffer not owned by the context");
      }
      this.g = null;
      this.c.a(afp.b, paramArrayOfChar);
    }
  }
  
  public final boolean b()
  {
    return this.b;
  }
  
  public final afy c()
  {
    return new afy(this.c);
  }
  
  public final void c(char[] paramArrayOfChar)
  {
    if (paramArrayOfChar != null)
    {
      if (paramArrayOfChar != this.h) {
        throw new IllegalArgumentException("Trying to release buffer not owned by the context");
      }
      this.h = null;
      this.c.a(afp.d, paramArrayOfChar);
    }
  }
  
  public final char[] d()
  {
    if (this.f != null) {
      throw new IllegalStateException("Trying to call allocTokenBuffer() second time");
    }
    this.f = this.c.a(afp.a);
    return this.f;
  }
  
  public final char[] e()
  {
    if (this.g != null) {
      throw new IllegalStateException("Trying to call allocConcatBuffer() second time");
    }
    this.g = this.c.a(afp.b);
    return this.g;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/pq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */