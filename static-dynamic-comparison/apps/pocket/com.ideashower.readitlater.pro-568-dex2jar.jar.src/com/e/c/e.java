package com.e.c;

class e
{
  private final d a = new d();
  private c b;
  private c c;
  private int d;
  private int e;
  
  void a()
  {
    while (this.b != null)
    {
      c localc = this.b;
      this.b = localc.c;
      this.a.a(localc);
    }
    this.c = null;
    this.d = 0;
    this.e = 0;
  }
  
  void a(long paramLong)
  {
    while ((this.d >= 4) && (this.b != null) && (paramLong - this.b.a > 0L))
    {
      c localc = this.b;
      if (localc.b) {
        this.e -= 1;
      }
      this.d -= 1;
      this.b = localc.c;
      if (this.b == null) {
        this.c = null;
      }
      this.a.a(localc);
    }
  }
  
  void a(long paramLong, boolean paramBoolean)
  {
    a(paramLong - 500000000L);
    c localc = this.a.a();
    localc.a = paramLong;
    localc.b = paramBoolean;
    localc.c = null;
    if (this.c != null) {
      this.c.c = localc;
    }
    this.c = localc;
    if (this.b == null) {
      this.b = localc;
    }
    this.d += 1;
    if (paramBoolean) {
      this.e += 1;
    }
  }
  
  boolean b()
  {
    return (this.c != null) && (this.b != null) && (this.c.a - this.b.a >= 250000000L) && (this.e >= (this.d >> 1) + (this.d >> 2));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/e/c/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */