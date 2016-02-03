package org.a.a.d;

import java.util.Locale;
import org.a.a.a;

class i
  implements p, s
{
  private final String a;
  
  i(String paramString)
  {
    this.a = paramString;
  }
  
  public int a()
  {
    return this.a.length();
  }
  
  public int a(q paramq, String paramString, int paramInt)
  {
    if (paramString.regionMatches(true, paramInt, this.a, 0, this.a.length())) {
      return this.a.length() + paramInt;
    }
    return paramInt ^ 0xFFFFFFFF;
  }
  
  public void a(StringBuffer paramStringBuffer, long paramLong, a parama, int paramInt, org.a.a.i parami, Locale paramLocale)
  {
    paramStringBuffer.append(this.a);
  }
  
  public int b()
  {
    return this.a.length();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/org/a/a/d/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */