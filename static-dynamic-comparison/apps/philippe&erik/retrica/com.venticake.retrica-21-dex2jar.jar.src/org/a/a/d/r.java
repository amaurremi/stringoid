package org.a.a.d;

import java.util.Locale;
import org.a.a.c;

class r
  implements Comparable<r>
{
  final c a;
  final int b;
  final String c;
  final Locale d;
  
  r(c paramc, int paramInt)
  {
    this.a = paramc;
    this.b = paramInt;
    this.c = null;
    this.d = null;
  }
  
  r(c paramc, String paramString, Locale paramLocale)
  {
    this.a = paramc;
    this.b = 0;
    this.c = paramString;
    this.d = paramLocale;
  }
  
  public int a(r paramr)
  {
    paramr = paramr.a;
    int i = q.a(this.a.e(), paramr.e());
    if (i != 0) {
      return i;
    }
    return q.a(this.a.d(), paramr.d());
  }
  
  long a(long paramLong, boolean paramBoolean)
  {
    if (this.c == null) {}
    for (paramLong = this.a.b(paramLong, this.b);; paramLong = this.a.a(paramLong, this.c, this.d))
    {
      long l = paramLong;
      if (paramBoolean) {
        l = this.a.d(paramLong);
      }
      return l;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/org/a/a/d/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */