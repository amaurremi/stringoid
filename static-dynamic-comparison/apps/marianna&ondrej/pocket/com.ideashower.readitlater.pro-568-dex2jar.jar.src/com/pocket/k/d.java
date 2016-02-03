package com.pocket.k;

public class d
  extends a
{
  private final int b;
  private final int c;
  private int d;
  
  public d(float paramFloat1, float paramFloat2)
  {
    this((int)paramFloat1, (int)paramFloat2);
  }
  
  public d(int paramInt1, int paramInt2)
  {
    super(true);
    this.b = paramInt1;
    this.c = paramInt2;
  }
  
  public int a()
  {
    return this.b;
  }
  
  public int a(int paramInt1, int paramInt2)
  {
    if (this.b / paramInt1 > this.c / paramInt2)
    {
      this.d = 2;
      return c(paramInt1, this.b);
    }
    this.d = 1;
    return c(paramInt2, this.c);
  }
  
  public int a(int paramInt1, int paramInt2, float paramFloat)
  {
    return this.b;
  }
  
  public float b(int paramInt1, int paramInt2)
  {
    if (this.b / paramInt1 > this.c / paramInt2)
    {
      this.d = 2;
      return d(paramInt1, this.b);
    }
    this.d = 1;
    return d(paramInt2, this.c);
  }
  
  public int b()
  {
    return this.c;
  }
  
  public int b(int paramInt1, int paramInt2, float paramFloat)
  {
    return this.c;
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/k/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */