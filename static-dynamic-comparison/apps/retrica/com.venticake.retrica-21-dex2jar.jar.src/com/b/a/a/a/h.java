package com.b.a.a.a;

public class h
{
  int a;
  String b;
  
  public h(int paramInt, String paramString)
  {
    this.a = paramInt;
    if ((paramString == null) || (paramString.trim().length() == 0))
    {
      this.b = d.a(paramInt);
      return;
    }
    this.b = (paramString + " (response: " + d.a(paramInt) + ")");
  }
  
  public int a()
  {
    return this.a;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public boolean c()
  {
    return this.a == 0;
  }
  
  public boolean d()
  {
    return !c();
  }
  
  public String toString()
  {
    return "IabResult: " + b();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/b/a/a/a/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */