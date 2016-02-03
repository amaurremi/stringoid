package com.e.a.b.b;

final class j
{
  private int a;
  private int b;
  private int c;
  private final int[] d = new int[10];
  
  void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 >= this.d.length) {
      return;
    }
    int i = 1 << paramInt1;
    this.a |= i;
    if ((paramInt2 & 0x1) != 0)
    {
      this.b |= i;
      if ((paramInt2 & 0x2) == 0) {
        break label84;
      }
    }
    label84:
    for (this.c = (i | this.c);; this.c = ((i ^ 0xFFFFFFFF) & this.c))
    {
      this.d[paramInt1] = paramInt3;
      return;
      this.b &= (i ^ 0xFFFFFFFF);
      break;
    }
  }
  
  void a(j paramj)
  {
    int i = 0;
    if (i < 10)
    {
      if (!paramj.a(i)) {}
      for (;;)
      {
        i += 1;
        break;
        a(i, paramj.c(i), paramj.b(i));
      }
    }
  }
  
  boolean a(int paramInt)
  {
    return (1 << paramInt & this.a) != 0;
  }
  
  int b(int paramInt)
  {
    return this.d[paramInt];
  }
  
  int c(int paramInt)
  {
    int i = 0;
    if (f(paramInt)) {
      i = 2;
    }
    int j = i;
    if (e(paramInt)) {
      j = i | 0x1;
    }
    return j;
  }
  
  int d(int paramInt)
  {
    if ((0x80 & this.a) != 0) {
      paramInt = this.d[7];
    }
    return paramInt;
  }
  
  boolean e(int paramInt)
  {
    return (1 << paramInt & this.b) != 0;
  }
  
  boolean f(int paramInt)
  {
    return (1 << paramInt & this.c) != 0;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/e/a/b/b/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */