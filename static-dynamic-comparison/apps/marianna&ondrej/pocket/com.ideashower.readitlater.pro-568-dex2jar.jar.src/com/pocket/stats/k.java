package com.pocket.stats;

import com.ideashower.readitlater.util.e;

public class k
{
  public final int a;
  public final String b;
  public final String c;
  public String d;
  
  public k(int paramInt, String paramString1, String paramString2)
  {
    this.a = paramInt;
    this.b = paramString1;
    this.c = paramString2;
  }
  
  public k(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    this.a = paramInt;
    this.b = paramString1;
    this.d = paramString2;
    this.c = paramString3;
  }
  
  public void a()
  {
    a(this.d, null, null);
  }
  
  public void a(String paramString)
  {
    a(this.d, paramString, null);
  }
  
  public void a(String paramString1, String paramString2)
  {
    a(this.d, paramString1, paramString2);
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    this.d = paramString1;
    if (this.d == null) {
      e.a("page not set", true);
    }
    j.a(this, paramString2, paramString3);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/stats/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */