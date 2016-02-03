package com.ideashower.readitlater.e;

public class m
{
  private int a;
  private int b;
  
  public m()
  {
    this(0, 0);
  }
  
  public m(int paramInt1, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramInt2;
  }
  
  public int a()
  {
    if (this.a == 0) {
      throw new RuntimeException("local id is not set");
    }
    return this.a;
  }
  
  public void a(int paramInt)
  {
    this.b = paramInt;
  }
  
  public boolean b()
  {
    return this.a != 0;
  }
  
  public int c()
  {
    return this.b;
  }
  
  public String toString()
  {
    return "{l:" + this.a + ", s:" + this.b + "}";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/e/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */