package org.a.a.d;

import java.util.Arrays;
import java.util.Locale;
import org.a.a.a;
import org.a.a.c;
import org.a.a.d;
import org.a.a.f;
import org.a.a.i;
import org.a.a.j;
import org.a.a.k;
import org.a.a.m;
import org.a.a.n;

public class q
{
  private final a a;
  private final long b;
  private i c;
  private Integer d;
  private Locale e;
  private Integer f;
  private int g;
  private r[] h = new r[8];
  private int i;
  private boolean j;
  private Object k;
  
  public q(long paramLong, a parama, Locale paramLocale, Integer paramInteger, int paramInt)
  {
    parama = f.a(parama);
    this.b = paramLong;
    this.c = parama.a();
    this.a = parama.b();
    parama = paramLocale;
    if (paramLocale == null) {
      parama = Locale.getDefault();
    }
    this.e = parama;
    this.f = paramInteger;
    this.g = paramInt;
  }
  
  static int a(j paramj1, j paramj2)
  {
    if ((paramj1 == null) || (!paramj1.b()))
    {
      if ((paramj2 == null) || (!paramj2.b())) {
        return 0;
      }
      return -1;
    }
    if ((paramj2 == null) || (!paramj2.b())) {
      return 1;
    }
    return -paramj1.compareTo(paramj2);
  }
  
  private void a(r paramr)
  {
    Object localObject = this.h;
    int n = this.i;
    int m;
    if ((n == localObject.length) || (this.j)) {
      if (n == localObject.length)
      {
        m = n * 2;
        r[] arrayOfr = new r[m];
        System.arraycopy(localObject, 0, arrayOfr, 0, n);
        this.h = arrayOfr;
        this.j = false;
        localObject = arrayOfr;
      }
    }
    for (;;)
    {
      this.k = null;
      localObject[n] = paramr;
      this.i = (n + 1);
      return;
      m = localObject.length;
      break;
    }
  }
  
  private static void a(r[] paramArrayOfr, int paramInt)
  {
    int m = 0;
    if (paramInt > 10)
    {
      Arrays.sort(paramArrayOfr, 0, paramInt);
      return;
    }
    for (;;)
    {
      m += 1;
      if (m >= paramInt) {
        break;
      }
      int n = m;
      while ((n > 0) && (paramArrayOfr[(n - 1)].a(paramArrayOfr[n]) > 0))
      {
        r localr = paramArrayOfr[n];
        paramArrayOfr[n] = paramArrayOfr[(n - 1)];
        paramArrayOfr[(n - 1)] = localr;
        n -= 1;
      }
    }
  }
  
  public long a(boolean paramBoolean, String paramString)
  {
    r[] arrayOfr = this.h;
    int n = this.i;
    if (this.j)
    {
      arrayOfr = (r[])this.h.clone();
      this.h = arrayOfr;
      this.j = false;
    }
    a(arrayOfr, n);
    Object localObject3;
    if (n > 0)
    {
      localObject3 = k.i().a(this.a);
      j localj1 = k.f().a(this.a);
      j localj2 = arrayOfr[0].a.d();
      if ((a(localj2, (j)localObject3) >= 0) && (a(localj2, localj1) <= 0))
      {
        a(d.s(), this.g);
        l1 = a(paramBoolean, paramString);
        return l1;
      }
    }
    long l1 = this.b;
    int m = 0;
    if (m < n) {}
    for (;;)
    {
      try
      {
        l1 = arrayOfr[m].a(l1, paramBoolean);
        m += 1;
      }
      catch (m localm)
      {
        if (paramString == null) {
          continue;
        }
        localm.a("Cannot parse \"" + paramString + '"');
        throw localm;
      }
      l1 = ((r)localObject3).a(l1, paramBoolean);
      m += 1;
      break label380;
      paramBoolean = false;
      continue;
      Object localObject2;
      label380:
      do
      {
        do
        {
          Object localObject1;
          if (this.d != null) {
            return localObject1 - this.d.intValue();
          }
          l1 = localObject1;
          if (this.c == null) {
            break;
          }
          m = this.c.c(localObject1);
          localObject1 -= m;
          l1 = l2;
          if (m == this.c.b(l2)) {
            break;
          }
          localObject3 = "Illegal instant due to time zone offset transition (" + this.c + ')';
          localObject2 = localObject3;
          if (paramString != null) {
            localObject2 = "Cannot parse \"" + paramString + "\": " + (String)localObject3;
          }
          throw new n((String)localObject2);
          l2 = l1;
        } while (!paramBoolean);
        m = 0;
        long l2 = l1;
      } while (m >= n);
      localObject3 = localObject2[m];
      if (m == n - 1) {
        paramBoolean = true;
      }
    }
  }
  
  public a a()
  {
    return this.a;
  }
  
  public void a(Integer paramInteger)
  {
    this.k = null;
    this.d = paramInteger;
  }
  
  public void a(c paramc, int paramInt)
  {
    a(new r(paramc, paramInt));
  }
  
  public void a(d paramd, int paramInt)
  {
    a(new r(paramd.a(this.a), paramInt));
  }
  
  public void a(d paramd, String paramString, Locale paramLocale)
  {
    a(new r(paramd.a(this.a), paramString, paramLocale));
  }
  
  public void a(i parami)
  {
    this.k = null;
    this.c = parami;
  }
  
  public Locale b()
  {
    return this.e;
  }
  
  public i c()
  {
    return this.c;
  }
  
  public Integer d()
  {
    return this.d;
  }
  
  public Integer e()
  {
    return this.f;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/org/a/a/d/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */