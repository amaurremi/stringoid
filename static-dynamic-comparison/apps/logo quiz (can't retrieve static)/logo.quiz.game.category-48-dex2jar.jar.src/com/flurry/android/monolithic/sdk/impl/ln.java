package com.flurry.android.monolithic.sdk.impl;

class ln
{
  boolean a = false;
  private final ll b;
  private byte[] c;
  private int d;
  private int e;
  
  private ln(ll paramll)
  {
    this.b = paramll;
  }
  
  void a()
  {
    this.c = ll.a(this.b);
    this.d = ll.b(this.b);
    this.e = ll.c(this.b);
    this.a = true;
  }
  
  void a(int paramInt)
  {
    if (this.a)
    {
      this.d = paramInt;
      return;
    }
    ll.a(this.b, paramInt);
  }
  
  void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (this.a)
    {
      this.c = paramArrayOfByte;
      this.e = (paramInt1 + paramInt2);
      this.d = paramInt1;
      return;
    }
    ll.a(this.b, paramArrayOfByte);
    ll.b(this.b, paramInt1 + paramInt2);
    ll.a(this.b, paramInt1);
    ll.c(this.b, paramInt1);
  }
  
  int b()
  {
    if (this.a) {
      return this.d;
    }
    return ll.b(this.b);
  }
  
  void b(int paramInt)
  {
    if (this.a)
    {
      this.e = paramInt;
      return;
    }
    ll.b(this.b, paramInt);
  }
  
  int c()
  {
    if (this.a) {
      return this.e;
    }
    return ll.c(this.b);
  }
  
  byte[] d()
  {
    if (this.a) {
      return this.c;
    }
    return ll.a(this.b);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/ln.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */