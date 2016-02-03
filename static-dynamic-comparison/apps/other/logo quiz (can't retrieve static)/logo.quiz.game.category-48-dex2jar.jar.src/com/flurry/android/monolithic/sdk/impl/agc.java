package com.flurry.android.monolithic.sdk.impl;

public final class agc
{
  private static final pb[] d = new pb[16];
  protected agc a;
  protected long b;
  protected final Object[] c = new Object[16];
  
  static
  {
    pb[] arrayOfpb = pb.values();
    System.arraycopy(arrayOfpb, 1, d, 1, Math.min(15, arrayOfpb.length - 1));
  }
  
  public agc a()
  {
    return this.a;
  }
  
  public agc a(int paramInt, pb parampb)
  {
    if (paramInt < 16)
    {
      b(paramInt, parampb);
      return null;
    }
    this.a = new agc();
    this.a.b(0, parampb);
    return this.a;
  }
  
  public agc a(int paramInt, pb parampb, Object paramObject)
  {
    if (paramInt < 16)
    {
      b(paramInt, parampb, paramObject);
      return null;
    }
    this.a = new agc();
    this.a.b(0, parampb, paramObject);
    return this.a;
  }
  
  public pb a(int paramInt)
  {
    long l2 = this.b;
    long l1 = l2;
    if (paramInt > 0) {
      l1 = l2 >> (paramInt << 2);
    }
    paramInt = (int)l1;
    return d[(paramInt & 0xF)];
  }
  
  public Object b(int paramInt)
  {
    return this.c[paramInt];
  }
  
  public void b(int paramInt, pb parampb)
  {
    long l2 = parampb.ordinal();
    long l1 = l2;
    if (paramInt > 0) {
      l1 = l2 << (paramInt << 2);
    }
    this.b = (l1 | this.b);
  }
  
  public void b(int paramInt, pb parampb, Object paramObject)
  {
    this.c[paramInt] = paramObject;
    long l2 = parampb.ordinal();
    long l1 = l2;
    if (paramInt > 0) {
      l1 = l2 << (paramInt << 2);
    }
    this.b = (l1 | this.b);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/agc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */