package org.a.a.d;

import java.util.Iterator;
import java.util.Locale;
import java.util.Set;
import org.a.a.a;
import org.a.a.i;

 enum k
  implements p, s
{
  static final Set<String> b;
  static final int c;
  
  static
  {
    b = i.b();
    Iterator localIterator = b.iterator();
    for (int i = 0; localIterator.hasNext(); i = Math.max(i, ((String)localIterator.next()).length())) {}
    c = i;
  }
  
  private k() {}
  
  public int a()
  {
    return c;
  }
  
  public int a(q paramq, String paramString, int paramInt)
  {
    String str3 = paramString.substring(paramInt);
    paramString = null;
    Iterator localIterator = b.iterator();
    String str2;
    if (localIterator.hasNext())
    {
      str2 = (String)localIterator.next();
      if (!str3.startsWith(str2)) {
        break label104;
      }
      str1 = str2;
      if (paramString != null) {
        if (str2.length() <= paramString.length()) {
          break label104;
        }
      }
    }
    label104:
    for (String str1 = str2;; str1 = paramString)
    {
      paramString = str1;
      break;
      if (paramString != null)
      {
        paramq.a(i.a(paramString));
        return paramString.length() + paramInt;
      }
      return paramInt ^ 0xFFFFFFFF;
    }
  }
  
  public void a(StringBuffer paramStringBuffer, long paramLong, a parama, int paramInt, i parami, Locale paramLocale)
  {
    if (parami != null) {}
    for (parama = parami.c();; parama = "")
    {
      paramStringBuffer.append(parama);
      return;
    }
  }
  
  public int b()
  {
    return c;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/org/a/a/d/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */