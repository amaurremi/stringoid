package org.a.a.d;

import java.util.Locale;
import org.a.a.a;
import org.a.a.c;
import org.a.a.d;
import org.a.a.i;

class n
  implements p, s
{
  private final d a;
  private final int b;
  private final boolean c;
  
  n(d paramd, int paramInt, boolean paramBoolean)
  {
    this.a = paramd;
    this.b = paramInt;
    this.c = paramBoolean;
  }
  
  private int a(long paramLong, a parama)
  {
    try
    {
      int j = this.a.a(parama).a(paramLong);
      int i = j;
      if (j < 0) {
        i = -j;
      }
      return i % 100;
    }
    catch (RuntimeException parama) {}
    return -1;
  }
  
  public int a()
  {
    return 2;
  }
  
  public int a(q paramq, String paramString, int paramInt)
  {
    int n = 0;
    int m = paramString.length() - paramInt;
    int j;
    int i;
    if (!this.c)
    {
      k = paramInt;
      if (Math.min(2, m) < 2) {
        return paramInt ^ 0xFFFFFFFF;
      }
    }
    else
    {
      j = 0;
      i = 0;
      k = 0;
      for (;;)
      {
        if (j < m)
        {
          int i1 = paramString.charAt(paramInt + j);
          if ((j == 0) && ((i1 == 45) || (i1 == 43)))
          {
            if (i1 == 45) {}
            for (i = 1;; i = 0)
            {
              if (i == 0) {
                break label113;
              }
              j += 1;
              k = 1;
              break;
            }
            label113:
            paramInt += 1;
            k = 1;
            m -= 1;
            continue;
          }
          if ((i1 >= 48) && (i1 <= 57)) {}
        }
        else
        {
          if (j != 0) {
            break;
          }
          return paramInt ^ 0xFFFFFFFF;
        }
        j += 1;
      }
      if (k == 0)
      {
        k = paramInt;
        if (j == 2) {}
      }
      else
      {
        if (j >= 9)
        {
          k = paramInt + j;
          j = Integer.parseInt(paramString.substring(paramInt, k));
          paramq.a(this.a, j);
          return k;
        }
        if (i == 0) {
          break label472;
        }
      }
    }
    label472:
    for (int k = paramInt + 1;; k = paramInt)
    {
      try
      {
        n = paramString.charAt(k);
        m = paramInt + j;
        paramInt = n - 48;
        j = k + 1;
        while (j < m)
        {
          paramInt = paramString.charAt(j) + ((paramInt << 3) + (paramInt << 1)) - 48;
          j += 1;
        }
        j = paramInt;
      }
      catch (StringIndexOutOfBoundsException paramq)
      {
        return paramInt ^ 0xFFFFFFFF;
      }
      k = m;
      if (i == 0) {
        break;
      }
      j = -paramInt;
      k = m;
      break;
      paramInt = paramString.charAt(k);
      if ((paramInt < 48) || (paramInt > 57)) {
        return k ^ 0xFFFFFFFF;
      }
      paramInt -= 48;
      i = paramString.charAt(k + 1);
      if ((i < 48) || (i > 57)) {
        return k ^ 0xFFFFFFFF;
      }
      j = (paramInt << 1) + (paramInt << 3) + i - 48;
      paramInt = this.b;
      if (paramq.e() != null) {
        paramInt = paramq.e().intValue();
      }
      m = paramInt - 50;
      if (m >= 0) {}
      for (paramInt = m % 100;; paramInt = (m + 1) % 100 + 99)
      {
        i = n;
        if (j < paramInt) {
          i = 100;
        }
        paramq.a(this.a, i + m - paramInt + j);
        return k + 2;
      }
    }
  }
  
  public void a(StringBuffer paramStringBuffer, long paramLong, a parama, int paramInt, i parami, Locale paramLocale)
  {
    paramInt = a(paramLong, parama);
    if (paramInt < 0)
    {
      paramStringBuffer.append(65533);
      paramStringBuffer.append(65533);
      return;
    }
    t.a(paramStringBuffer, paramInt, 2);
  }
  
  public int b()
  {
    if (this.c) {
      return 4;
    }
    return 2;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/org/a/a/d/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */