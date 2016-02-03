package org.a.a.d;

import java.io.IOException;
import java.io.Writer;
import java.util.Locale;
import org.a.a.a;
import org.a.a.c.l;
import org.a.a.d;
import org.a.a.i;

class f
  implements p, s
{
  protected int a;
  protected int b;
  private final d c;
  
  protected f(d paramd, int paramInt1, int paramInt2)
  {
    this.c = paramd;
    int i = paramInt2;
    if (paramInt2 > 18) {
      i = 18;
    }
    this.a = paramInt1;
    this.b = i;
  }
  
  private long[] a(long paramLong, org.a.a.c paramc)
  {
    long l2 = paramc.d().d();
    int i = this.b;
    for (;;)
    {
      long l1;
      switch (i)
      {
      default: 
        l1 = 1L;
      }
      while (l2 * l1 / l1 == l2)
      {
        return new long[] { l1 * paramLong / l2, i };
        l1 = 10L;
        continue;
        l1 = 100L;
        continue;
        l1 = 1000L;
        continue;
        l1 = 10000L;
        continue;
        l1 = 100000L;
        continue;
        l1 = 1000000L;
        continue;
        l1 = 10000000L;
        continue;
        l1 = 100000000L;
        continue;
        l1 = 1000000000L;
        continue;
        l1 = 10000000000L;
        continue;
        l1 = 100000000000L;
        continue;
        l1 = 1000000000000L;
        continue;
        l1 = 10000000000000L;
        continue;
        l1 = 100000000000000L;
        continue;
        l1 = 1000000000000000L;
        continue;
        l1 = 10000000000000000L;
        continue;
        l1 = 100000000000000000L;
        continue;
        l1 = 1000000000000000000L;
      }
      i -= 1;
    }
  }
  
  public int a()
  {
    return this.b;
  }
  
  public int a(q paramq, String paramString, int paramInt)
  {
    org.a.a.c localc = this.c.a(paramq.a());
    int j = Math.min(this.b, paramString.length() - paramInt);
    long l1 = 0L;
    long l2 = localc.d().d() * 10L;
    int i = 0;
    for (;;)
    {
      int k;
      if (i < j)
      {
        k = paramString.charAt(paramInt + i);
        if ((k >= 48) && (k <= 57)) {}
      }
      else
      {
        l1 /= 10L;
        if (i != 0) {
          break;
        }
        return paramInt ^ 0xFFFFFFFF;
      }
      i += 1;
      l2 /= 10L;
      l1 += (k - 48) * l2;
    }
    if (l1 > 2147483647L) {
      return paramInt ^ 0xFFFFFFFF;
    }
    paramq.a(new l(d.a(), org.a.a.c.j.a, localc.d()), (int)l1);
    return i + paramInt;
  }
  
  public void a(StringBuffer paramStringBuffer, long paramLong, a parama, int paramInt, i parami, Locale paramLocale)
  {
    try
    {
      a(paramStringBuffer, null, paramLong, parama);
      return;
    }
    catch (IOException paramStringBuffer) {}
  }
  
  protected void a(StringBuffer paramStringBuffer, Writer paramWriter, long paramLong, a parama)
  {
    parama = this.c.a(parama);
    int i = this.a;
    for (;;)
    {
      int j;
      try
      {
        paramLong = parama.i(paramLong);
        if (paramLong != 0L) {
          break label99;
        }
        j = i;
        if (paramStringBuffer != null)
        {
          i -= 1;
          if (i >= 0)
          {
            paramStringBuffer.append('0');
            continue;
          }
        }
        j -= 1;
      }
      catch (RuntimeException parama)
      {
        if (paramStringBuffer != null)
        {
          c.a(paramStringBuffer, i);
          return;
        }
        c.a(paramWriter, i);
        return;
      }
      while (j >= 0) {
        paramWriter.write(48);
      }
      continue;
      label99:
      parama = a(paramLong, parama);
      paramLong = parama[0];
      int m = (int)parama[1];
      int k;
      if ((0x7FFFFFFF & paramLong) == paramLong)
      {
        parama = Integer.toString((int)paramLong);
        j = parama.length();
        k = i;
        i = m;
        label152:
        if (j >= i) {
          break label203;
        }
        if (paramStringBuffer == null) {
          break label194;
        }
        paramStringBuffer.append('0');
      }
      for (;;)
      {
        k -= 1;
        i -= 1;
        break label152;
        parama = Long.toString(paramLong);
        break;
        label194:
        paramWriter.write(48);
      }
      label203:
      if (k >= i) {
        break;
      }
      for (;;)
      {
        if ((k >= i) || (j <= 1) || (parama.charAt(j - 1) != '0'))
        {
          if (j >= parama.length()) {
            break label327;
          }
          if (paramStringBuffer == null) {
            break label297;
          }
          i = 0;
          while (i < j)
          {
            paramStringBuffer.append(parama.charAt(i));
            i += 1;
          }
          break;
        }
        i -= 1;
        j -= 1;
      }
      label297:
      i = 0;
      while (i < j)
      {
        paramWriter.write(parama.charAt(i));
        i += 1;
      }
    }
    label327:
    if (paramStringBuffer != null)
    {
      paramStringBuffer.append(parama);
      return;
    }
    paramWriter.write(parama);
  }
  
  public int b()
  {
    return this.b;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/org/a/a/d/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */