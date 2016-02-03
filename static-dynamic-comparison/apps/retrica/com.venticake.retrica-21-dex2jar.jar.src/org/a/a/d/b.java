package org.a.a.d;

import java.util.Locale;
import org.a.a.a;
import org.a.a.f;
import org.a.a.i;
import org.a.a.u;

public class b
{
  private final s a;
  private final p b;
  private final Locale c;
  private final boolean d;
  private final a e;
  private final i f;
  private final Integer g;
  private final int h;
  
  public b(s params, p paramp)
  {
    this.a = params;
    this.b = paramp;
    this.c = null;
    this.d = false;
    this.e = null;
    this.f = null;
    this.g = null;
    this.h = 2000;
  }
  
  private b(s params, p paramp, Locale paramLocale, boolean paramBoolean, a parama, i parami, Integer paramInteger, int paramInt)
  {
    this.a = params;
    this.b = paramp;
    this.c = paramLocale;
    this.d = paramBoolean;
    this.e = parama;
    this.f = parami;
    this.g = paramInteger;
    this.h = paramInt;
  }
  
  private void a(StringBuffer paramStringBuffer, long paramLong, a parama)
  {
    s locals = e();
    a locala = b(parama);
    i locali = locala.a();
    int j = locali.b(paramLong);
    long l2 = j + paramLong;
    long l1 = l2;
    int i = j;
    parama = locali;
    if ((paramLong ^ l2) < 0L)
    {
      l1 = l2;
      i = j;
      parama = locali;
      if ((j ^ paramLong) >= 0L)
      {
        parama = i.a;
        i = 0;
        l1 = paramLong;
      }
    }
    locals.a(paramStringBuffer, l1, locala.b(), i, parama, this.c);
  }
  
  private a b(a parama)
  {
    parama = f.a(parama);
    if (this.e != null) {
      parama = this.e;
    }
    a locala = parama;
    if (this.f != null) {
      locala = parama.a(this.f);
    }
    return locala;
  }
  
  private s e()
  {
    s locals = this.a;
    if (locals == null) {
      throw new UnsupportedOperationException("Printing not supported");
    }
    return locals;
  }
  
  private p f()
  {
    p localp = this.b;
    if (localp == null) {
      throw new UnsupportedOperationException("Parsing not supported");
    }
    return localp;
  }
  
  public long a(String paramString)
  {
    p localp = f();
    q localq = new q(0L, b(this.e), this.c, this.g, this.h);
    int i = localp.a(localq, paramString, 0);
    if (i >= 0)
    {
      if (i >= paramString.length()) {
        return localq.a(true, paramString);
      }
    }
    else {
      i ^= 0xFFFFFFFF;
    }
    for (;;)
    {
      throw new IllegalArgumentException(t.b(paramString, i));
    }
  }
  
  public String a(long paramLong)
  {
    StringBuffer localStringBuffer = new StringBuffer(e().a());
    a(localStringBuffer, paramLong);
    return localStringBuffer.toString();
  }
  
  public String a(u paramu)
  {
    StringBuffer localStringBuffer = new StringBuffer(e().a());
    a(localStringBuffer, paramu);
    return localStringBuffer.toString();
  }
  
  public b a(Locale paramLocale)
  {
    if ((paramLocale == c()) || ((paramLocale != null) && (paramLocale.equals(c())))) {
      return this;
    }
    return new b(this.a, this.b, paramLocale, this.d, this.e, this.f, this.g, this.h);
  }
  
  public b a(a parama)
  {
    if (this.e == parama) {
      return this;
    }
    return new b(this.a, this.b, this.c, this.d, parama, this.f, this.g, this.h);
  }
  
  public b a(i parami)
  {
    if (this.f == parami) {
      return this;
    }
    return new b(this.a, this.b, this.c, false, this.e, parami, this.g, this.h);
  }
  
  public s a()
  {
    return this.a;
  }
  
  public void a(StringBuffer paramStringBuffer, long paramLong)
  {
    a(paramStringBuffer, paramLong, null);
  }
  
  public void a(StringBuffer paramStringBuffer, u paramu)
  {
    a(paramStringBuffer, f.a(paramu), f.b(paramu));
  }
  
  public org.a.a.b b(String paramString)
  {
    p localp = f();
    Object localObject = b(null);
    q localq = new q(0L, (a)localObject, this.c, this.g, this.h);
    int i = localp.a(localq, paramString, 0);
    if (i >= 0)
    {
      if (i >= paramString.length())
      {
        long l = localq.a(true, paramString);
        if ((this.d) && (localq.d() != null)) {
          paramString = ((a)localObject).a(i.a(localq.d().intValue()));
        }
        for (;;)
        {
          localObject = new org.a.a.b(l, paramString);
          paramString = (String)localObject;
          if (this.f != null) {
            paramString = ((org.a.a.b)localObject).a(this.f);
          }
          return paramString;
          paramString = (String)localObject;
          if (localq.c() != null) {
            paramString = ((a)localObject).a(localq.c());
          }
        }
      }
    }
    else {
      i ^= 0xFFFFFFFF;
    }
    for (;;)
    {
      throw new IllegalArgumentException(t.b(paramString, i));
    }
  }
  
  public p b()
  {
    return this.b;
  }
  
  public Locale c()
  {
    return this.c;
  }
  
  public b d()
  {
    return a(i.a);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/org/a/a/d/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */