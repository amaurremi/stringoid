package com.pocket.k;

public class g
  extends a
{
  private final int b;
  private final int c;
  
  public g(int paramInt1, int paramInt2)
  {
    super(false);
    this.b = paramInt1;
    this.c = paramInt2;
  }
  
  public int a()
  {
    return this.b;
  }
  
  public int a(int paramInt1, int paramInt2)
  {
    if (this.b / paramInt1 < this.c / paramInt2) {
      return c(paramInt1, this.b);
    }
    return c(paramInt2, this.c);
  }
  
  public int a(int paramInt1, int paramInt2, float paramFloat)
  {
    return (int)(paramInt1 * paramFloat);
  }
  
  public float b(int paramInt1, int paramInt2)
  {
    if (this.b / paramInt1 < this.c / paramInt2) {
      return d(paramInt1, this.b);
    }
    return d(paramInt2, this.c);
  }
  
  public int b()
  {
    return this.c;
  }
  
  public int b(int paramInt1, int paramInt2, float paramFloat)
  {
    return (int)(paramInt2 * paramFloat);
  }
  
  public String c()
  {
    return String.valueOf(this.b);
  }
  
  public String d()
  {
    return String.valueOf(this.c);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/k/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */