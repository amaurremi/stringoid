package com.e.a;

import com.e.a.b.b;
import java.io.UnsupportedEncodingException;

public final class l
{
  private final String a;
  
  private l(String paramString)
  {
    this.a = paramString;
  }
  
  public static l a(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = b.b((paramString1 + ":" + paramString2).getBytes("ISO-8859-1"));
      paramString1 = new l("Basic " + paramString1);
      return paramString1;
    }
    catch (UnsupportedEncodingException paramString1)
    {
      throw new AssertionError();
    }
  }
  
  public String a()
  {
    return this.a;
  }
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof l)) && (((l)paramObject).a.equals(this.a));
  }
  
  public int hashCode()
  {
    return this.a.hashCode();
  }
  
  public String toString()
  {
    return this.a;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/e/a/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */