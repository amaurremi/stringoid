package org.a.a;

import org.a.a.d.a;
import org.a.a.d.b;

public class n
  extends IllegalArgumentException
{
  public n(long paramLong, String paramString)
  {
    super(a(paramLong, paramString));
  }
  
  public n(String paramString)
  {
    super(paramString);
  }
  
  private static String a(long paramLong, String paramString)
  {
    String str = a.a("yyyy-MM-dd'T'HH:mm:ss.SSS").a(new o(paramLong));
    if (paramString != null) {}
    for (paramString = " (" + paramString + ")";; paramString = "") {
      return "Illegal instant due to time zone offset transition (daylight savings time 'gap'): " + str + paramString;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/org/a/a/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */