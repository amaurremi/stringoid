package com.pocket.billing;

public abstract class d
{
  private final String a;
  private final String b;
  private final String c;
  
  public d(String paramString1, String paramString2, String paramString3)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
  }
  
  public String a()
  {
    return this.a;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public String c()
  {
    return this.c;
  }
  
  public String toString()
  {
    return b() + "," + a() + "," + c();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/billing/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */