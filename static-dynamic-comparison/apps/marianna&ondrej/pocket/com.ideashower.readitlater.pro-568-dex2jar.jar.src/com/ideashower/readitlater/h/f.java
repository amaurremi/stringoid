package com.ideashower.readitlater.h;

public abstract class f
{
  private String a;
  protected final String b;
  public final g c;
  
  private f(String paramString, g paramg)
  {
    this.b = paramString;
    this.c = paramg;
  }
  
  public f a(String paramString)
  {
    this.a = paramString;
    return this;
  }
  
  public f b(int paramInt)
  {
    this.a = String.valueOf(paramInt);
    return this;
  }
  
  public String b()
  {
    if (this.a == null) {
      return this.b;
    }
    return this.b + this.a;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/h/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */