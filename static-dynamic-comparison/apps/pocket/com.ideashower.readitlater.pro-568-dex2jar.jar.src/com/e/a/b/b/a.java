package com.e.a.b.b;

public enum a
{
  public final int o;
  public final int p;
  public final int q;
  
  private a(int paramInt2, int paramInt3, int paramInt4)
  {
    this.o = paramInt2;
    this.p = paramInt3;
    this.q = paramInt4;
  }
  
  public static a a(int paramInt)
  {
    a[] arrayOfa = values();
    int i2 = arrayOfa.length;
    int i1 = 0;
    while (i1 < i2)
    {
      a locala = arrayOfa[i1];
      if (locala.p == paramInt) {
        return locala;
      }
      i1 += 1;
    }
    return null;
  }
  
  public static a b(int paramInt)
  {
    a[] arrayOfa = values();
    int i2 = arrayOfa.length;
    int i1 = 0;
    while (i1 < i2)
    {
      a locala = arrayOfa[i1];
      if (locala.o == paramInt) {
        return locala;
      }
      i1 += 1;
    }
    return null;
  }
  
  public static a c(int paramInt)
  {
    a[] arrayOfa = values();
    int i2 = arrayOfa.length;
    int i1 = 0;
    while (i1 < i2)
    {
      a locala = arrayOfa[i1];
      if (locala.q == paramInt) {
        return locala;
      }
      i1 += 1;
    }
    return null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/e/a/b/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */