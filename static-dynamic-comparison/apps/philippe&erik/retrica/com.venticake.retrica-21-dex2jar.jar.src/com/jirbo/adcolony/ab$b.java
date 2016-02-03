package com.jirbo.adcolony;

class ab$b
{
  double a = System.currentTimeMillis();
  
  ab$b(double paramDouble)
  {
    a(paramDouble);
  }
  
  void a(double paramDouble)
  {
    this.a = (System.currentTimeMillis() / 1000.0D + paramDouble);
  }
  
  boolean a()
  {
    return b() == 0.0D;
  }
  
  double b()
  {
    double d = System.currentTimeMillis() / 1000.0D;
    d = this.a - d;
    if (d <= 0.0D) {
      return 0.0D;
    }
    return d;
  }
  
  public String toString()
  {
    return ab.a(b(), 2);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/jirbo/adcolony/ab$b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */