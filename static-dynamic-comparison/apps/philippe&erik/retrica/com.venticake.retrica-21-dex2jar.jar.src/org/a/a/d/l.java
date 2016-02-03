package org.a.a.d;

import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.a.a.a;
import org.a.a.f;
import org.a.a.i;

class l
  implements p, s
{
  private final Map<String, i> a;
  private final int b;
  
  l(int paramInt, Map<String, i> paramMap)
  {
    this.b = paramInt;
    this.a = paramMap;
  }
  
  private String a(long paramLong, i parami, Locale paramLocale)
  {
    if (parami == null) {
      return "";
    }
    switch (this.b)
    {
    default: 
      return "";
    case 0: 
      return parami.b(paramLong, paramLocale);
    }
    return parami.a(paramLong, paramLocale);
  }
  
  public int a()
  {
    if (this.b == 1) {
      return 4;
    }
    return 20;
  }
  
  public int a(q paramq, String paramString, int paramInt)
  {
    Map localMap = this.a;
    if (localMap != null) {}
    for (;;)
    {
      paramString = paramString.substring(paramInt);
      Iterator localIterator = localMap.keySet().iterator();
      String str;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        str = (String)localIterator.next();
      } while (!paramString.startsWith(str));
      paramq.a((i)localMap.get(str));
      return str.length() + paramInt;
      localMap = f.b();
    }
    return paramInt ^ 0xFFFFFFFF;
  }
  
  public void a(StringBuffer paramStringBuffer, long paramLong, a parama, int paramInt, i parami, Locale paramLocale)
  {
    paramStringBuffer.append(a(paramLong - paramInt, parami, paramLocale));
  }
  
  public int b()
  {
    if (this.b == 1) {
      return 4;
    }
    return 20;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/org/a/a/d/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */