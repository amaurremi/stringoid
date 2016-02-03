package org.a.a.d;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.a.a.a;
import org.a.a.c;
import org.a.a.d;
import org.a.a.i;

class j
  implements p, s
{
  private static Map<Locale, Map<d, Object[]>> a = new HashMap();
  private final d b;
  private final boolean c;
  
  j(d paramd, boolean paramBoolean)
  {
    this.b = paramd;
    this.c = paramBoolean;
  }
  
  private String a(long paramLong, a parama, Locale paramLocale)
  {
    parama = this.b.a(parama);
    if (this.c) {
      return parama.b(paramLong, paramLocale);
    }
    return parama.a(paramLong, paramLocale);
  }
  
  public int a()
  {
    if (this.c) {
      return 6;
    }
    return 20;
  }
  
  public int a(q paramq, String paramString, int paramInt)
  {
    Locale localLocale = paramq.b();
    label486:
    label490:
    for (;;)
    {
      int i;
      synchronized (a)
      {
        Object localObject1 = (Map)a.get(localLocale);
        if (localObject1 != null) {
          break label490;
        }
        localObject1 = new HashMap();
        a.put(localLocale, localObject1);
        Object localObject2 = (Object[])((Map)localObject1).get(this.b);
        if (localObject2 == null)
        {
          localObject2 = new HashSet(32);
          org.a.a.q localq = new org.a.a.p(0L, i.a).a(this.b);
          i = localq.g();
          int k = localq.h();
          if (k - i > 32) {
            return paramInt ^ 0xFFFFFFFF;
          }
          int j = localq.c(localLocale);
          if (i <= k)
          {
            localq.a(i);
            ((Set)localObject2).add(localq.b(localLocale));
            ((Set)localObject2).add(localq.b(localLocale).toLowerCase(localLocale));
            ((Set)localObject2).add(localq.b(localLocale).toUpperCase(localLocale));
            ((Set)localObject2).add(localq.a(localLocale));
            ((Set)localObject2).add(localq.a(localLocale).toLowerCase(localLocale));
            ((Set)localObject2).add(localq.a(localLocale).toUpperCase(localLocale));
            i += 1;
            continue;
          }
          i = j;
          if ("en".equals(localLocale.getLanguage()))
          {
            i = j;
            if (this.b == d.w())
            {
              ((Set)localObject2).add("BCE");
              ((Set)localObject2).add("bce");
              ((Set)localObject2).add("CE");
              ((Set)localObject2).add("ce");
              i = 3;
            }
          }
          ((Map)localObject1).put(this.b, new Object[] { localObject2, Integer.valueOf(i) });
          localObject1 = localObject2;
          i = Math.min(paramString.length(), i + paramInt);
          if (i <= paramInt) {
            break label486;
          }
          localObject2 = paramString.substring(paramInt, i);
          if (((Set)localObject1).contains(localObject2))
          {
            paramq.a(this.b, (String)localObject2, localLocale);
            return i;
          }
        }
        else
        {
          localObject1 = (Set)localObject2[0];
          i = ((Integer)localObject2[1]).intValue();
        }
      }
      i -= 1;
      continue;
      return paramInt ^ 0xFFFFFFFF;
    }
  }
  
  public void a(StringBuffer paramStringBuffer, long paramLong, a parama, int paramInt, i parami, Locale paramLocale)
  {
    try
    {
      paramStringBuffer.append(a(paramLong, parama, paramLocale));
      return;
    }
    catch (RuntimeException parama)
    {
      paramStringBuffer.append(65533);
    }
  }
  
  public int b()
  {
    return a();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/org/a/a/d/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */