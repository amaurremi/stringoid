package com.pocket.n;

import org.apache.a.c.k;

public class g
{
  private final e a;
  private final String b;
  
  public g(String paramString, e parame)
  {
    this.b = k.a(paramString);
    this.a = parame;
  }
  
  public g(String paramString1, String paramString2, String paramString3)
  {
    this(paramString1, e.a(paramString2, paramString3));
  }
  
  public e a()
  {
    return this.a;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public String toString()
  {
    if (this.a != null) {}
    for (String str1 = this.a.toString();; str1 = "")
    {
      String str2 = str1;
      if (this.b != null)
      {
        str2 = str1;
        if (str1.length() > 0) {
          str2 = str1 + " ";
        }
        str2 = str2 + this.b;
      }
      return str2;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/n/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */