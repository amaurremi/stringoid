package org.a.a.d;

import java.util.Locale;
import org.a.a.a;
import org.a.a.i;

class d
  implements p, s
{
  private final char a;
  
  d(char paramChar)
  {
    this.a = paramChar;
  }
  
  public int a()
  {
    return 1;
  }
  
  public int a(q paramq, String paramString, int paramInt)
  {
    if (paramInt >= paramString.length()) {
      return paramInt ^ 0xFFFFFFFF;
    }
    char c2 = paramString.charAt(paramInt);
    char c1 = this.a;
    if (c2 != c1)
    {
      c2 = Character.toUpperCase(c2);
      c1 = Character.toUpperCase(c1);
      if ((c2 != c1) && (Character.toLowerCase(c2) != Character.toLowerCase(c1))) {
        return paramInt ^ 0xFFFFFFFF;
      }
    }
    return paramInt + 1;
  }
  
  public void a(StringBuffer paramStringBuffer, long paramLong, a parama, int paramInt, i parami, Locale paramLocale)
  {
    paramStringBuffer.append(this.a);
  }
  
  public int b()
  {
    return 1;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/org/a/a/d/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */