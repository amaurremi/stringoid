package com.e.a.b.a;

import com.e.a.b.j;
import com.e.a.b.q;
import com.e.a.o;
import java.net.URI;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

public final class u
{
  static final String a = j.a().b() + "-Response-Source";
  static final String b = j.a().b() + "-Selected-Transport";
  private static final String c = j.a().b() + "-Sent-Millis";
  private static final String d = j.a().b() + "-Received-Millis";
  private final URI e;
  private final s f;
  private Date g;
  private Date h;
  private Date i;
  private long j;
  private long k;
  private boolean l;
  private boolean m;
  private int n = -1;
  private int o = -1;
  private boolean p;
  private boolean q;
  private String r;
  private int s = -1;
  private Set t = Collections.emptySet();
  private String u;
  private String v;
  private int w = -1;
  private String x;
  
  public u(URI paramURI, s params)
  {
    this.e = paramURI;
    this.f = params;
    paramURI = new c()
    {
      public void a(String paramAnonymousString1, String paramAnonymousString2)
      {
        if ("no-cache".equalsIgnoreCase(paramAnonymousString1)) {
          u.a(u.this, true);
        }
        do
        {
          return;
          if ("no-store".equalsIgnoreCase(paramAnonymousString1))
          {
            u.b(u.this, true);
            return;
          }
          if ("max-age".equalsIgnoreCase(paramAnonymousString1))
          {
            u.a(u.this, b.a(paramAnonymousString2));
            return;
          }
          if ("s-maxage".equalsIgnoreCase(paramAnonymousString1))
          {
            u.b(u.this, b.a(paramAnonymousString2));
            return;
          }
          if ("public".equalsIgnoreCase(paramAnonymousString1))
          {
            u.c(u.this, true);
            return;
          }
        } while (!"must-revalidate".equalsIgnoreCase(paramAnonymousString1));
        u.d(u.this, true);
      }
    };
    int i1 = 0;
    if (i1 < params.e())
    {
      Object localObject = params.a(i1);
      String str = params.b(i1);
      if ("Cache-Control".equalsIgnoreCase((String)localObject)) {
        b.a(str, paramURI);
      }
      for (;;)
      {
        i1 += 1;
        break;
        if ("Date".equalsIgnoreCase((String)localObject))
        {
          this.g = e.a(str);
        }
        else if ("Expires".equalsIgnoreCase((String)localObject))
        {
          this.i = e.a(str);
        }
        else if ("Last-Modified".equalsIgnoreCase((String)localObject))
        {
          this.h = e.a(str);
        }
        else if ("ETag".equalsIgnoreCase((String)localObject))
        {
          this.r = str;
        }
        else if ("Pragma".equalsIgnoreCase((String)localObject))
        {
          if ("no-cache".equalsIgnoreCase(str)) {
            this.l = true;
          }
        }
        else if ("Age".equalsIgnoreCase((String)localObject))
        {
          this.s = b.a(str);
        }
        else if ("Vary".equalsIgnoreCase((String)localObject))
        {
          if (this.t.isEmpty()) {
            this.t = new TreeSet(String.CASE_INSENSITIVE_ORDER);
          }
          localObject = str.split(",");
          int i3 = localObject.length;
          int i2 = 0;
          while (i2 < i3)
          {
            str = localObject[i2];
            this.t.add(str.trim());
            i2 += 1;
          }
        }
        else if ("Content-Encoding".equalsIgnoreCase((String)localObject))
        {
          this.u = str;
        }
        else if ("Transfer-Encoding".equalsIgnoreCase((String)localObject))
        {
          this.v = str;
        }
        else if ("Content-Length".equalsIgnoreCase((String)localObject))
        {
          try
          {
            this.w = Integer.parseInt(str);
          }
          catch (NumberFormatException localNumberFormatException) {}
        }
        else if ("Connection".equalsIgnoreCase(localNumberFormatException))
        {
          this.x = str;
        }
        else if (c.equalsIgnoreCase(localNumberFormatException))
        {
          this.j = Long.parseLong(str);
        }
        else if (d.equalsIgnoreCase(localNumberFormatException))
        {
          this.k = Long.parseLong(str);
        }
      }
    }
  }
  
  private long a(long paramLong)
  {
    long l1 = 0L;
    if (this.g != null) {
      l1 = Math.max(0L, this.k - this.g.getTime());
    }
    long l2 = l1;
    if (this.s != -1) {
      l2 = Math.max(l1, TimeUnit.SECONDS.toMillis(this.s));
    }
    return l2 + (this.k - this.j) + (paramLong - this.k);
  }
  
  private static boolean b(String paramString)
  {
    return (!"Connection".equalsIgnoreCase(paramString)) && (!"Keep-Alive".equalsIgnoreCase(paramString)) && (!"Proxy-Authenticate".equalsIgnoreCase(paramString)) && (!"Proxy-Authorization".equalsIgnoreCase(paramString)) && (!"TE".equalsIgnoreCase(paramString)) && (!"Trailers".equalsIgnoreCase(paramString)) && (!"Transfer-Encoding".equalsIgnoreCase(paramString)) && (!"Upgrade".equalsIgnoreCase(paramString));
  }
  
  private long j()
  {
    long l2 = 0L;
    if (this.n != -1) {
      l1 = TimeUnit.SECONDS.toMillis(this.n);
    }
    label72:
    do
    {
      do
      {
        return l1;
        if (this.i != null)
        {
          if (this.g != null)
          {
            l1 = this.g.getTime();
            l1 = this.i.getTime() - l1;
            if (l1 <= 0L) {
              break label72;
            }
          }
          for (;;)
          {
            return l1;
            l1 = this.k;
            break;
            l1 = 0L;
          }
        }
        l1 = l2;
      } while (this.h == null);
      l1 = l2;
    } while (this.e.getRawQuery() != null);
    if (this.g != null) {}
    for (long l1 = this.g.getTime();; l1 = this.j)
    {
      long l3 = l1 - this.h.getTime();
      l1 = l2;
      if (l3 <= 0L) {
        break;
      }
      return l3 / 10L;
    }
  }
  
  private boolean k()
  {
    return (this.n == -1) && (this.i == null);
  }
  
  public o a(long paramLong, t paramt)
  {
    long l3 = 0L;
    if (!a(paramt)) {
      return o.c;
    }
    if ((paramt.d()) || (paramt.r())) {
      return o.c;
    }
    long l4 = a(paramLong);
    long l1 = j();
    paramLong = l1;
    if (paramt.e() != -1) {
      paramLong = Math.min(l1, TimeUnit.SECONDS.toMillis(paramt.e()));
    }
    if (paramt.g() != -1) {}
    for (l1 = TimeUnit.SECONDS.toMillis(paramt.g());; l1 = 0L)
    {
      long l2 = l3;
      if (!this.q)
      {
        l2 = l3;
        if (paramt.f() != -1) {
          l2 = TimeUnit.SECONDS.toMillis(paramt.f());
        }
      }
      if ((!this.l) && (l4 + l1 < l2 + paramLong))
      {
        if (l1 + l4 >= paramLong) {
          this.f.a("Warning", "110 HttpURLConnection \"Response is stale\"");
        }
        if ((l4 > 86400000L) && (k())) {
          this.f.a("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
        }
        return o.a;
      }
      if (this.h != null) {
        paramt.a(this.h);
      }
      for (;;)
      {
        if (this.r != null) {
          paramt.f(this.r);
        }
        if (!paramt.r()) {
          break;
        }
        return o.b;
        if (this.g != null) {
          paramt.a(this.g);
        }
      }
      return o.c;
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    this.j = paramLong1;
    this.f.a(c, Long.toString(paramLong1));
    this.k = paramLong2;
    this.f.a(d, Long.toString(paramLong2));
  }
  
  public void a(o paramo)
  {
    this.f.b(a, paramo.toString() + " " + this.f.c());
  }
  
  public void a(String paramString)
  {
    this.f.b(b, paramString);
  }
  
  public boolean a()
  {
    return "gzip".equalsIgnoreCase(this.u);
  }
  
  public boolean a(t paramt)
  {
    int i1 = this.f.c();
    if ((i1 != 200) && (i1 != 203) && (i1 != 300) && (i1 != 301) && (i1 != 410)) {}
    while (((paramt.i()) && (!this.p) && (!this.q) && (this.o == -1)) || (this.m)) {
      return false;
    }
    return true;
  }
  
  public boolean a(u paramu)
  {
    if (paramu.f.c() == 304) {}
    while ((this.h != null) && (paramu.h != null) && (paramu.h.getTime() < this.h.getTime())) {
      return true;
    }
    return false;
  }
  
  public boolean a(Map paramMap1, Map paramMap2)
  {
    Iterator localIterator = this.t.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (!q.a(paramMap1.get(str), paramMap2.get(str))) {
        return false;
      }
    }
    return true;
  }
  
  public u b(u paramu)
  {
    int i3 = 0;
    s locals = new s();
    locals.b(this.f.a());
    int i1 = 0;
    int i2 = i3;
    String str1;
    if (i1 < this.f.e())
    {
      str1 = this.f.a(i1);
      String str2 = this.f.b(i1);
      if (("Warning".equals(str1)) && (str2.startsWith("1"))) {}
      for (;;)
      {
        i1 += 1;
        break;
        if ((!b(str1)) || (paramu.f.e(str1) == null)) {
          locals.a(str1, str2);
        }
      }
    }
    while (i2 < paramu.f.e())
    {
      str1 = paramu.f.a(i2);
      if (b(str1)) {
        locals.a(str1, paramu.f.b(i2));
      }
      i2 += 1;
    }
    return new u(this.e, locals);
  }
  
  public void b()
  {
    this.u = null;
    this.f.d("Content-Encoding");
  }
  
  public void c()
  {
    this.w = -1;
    this.f.d("Content-Length");
  }
  
  public boolean d()
  {
    return "chunked".equalsIgnoreCase(this.v);
  }
  
  public boolean e()
  {
    return "close".equalsIgnoreCase(this.x);
  }
  
  public s f()
  {
    return this.f;
  }
  
  public Set g()
  {
    return this.t;
  }
  
  public int h()
  {
    return this.w;
  }
  
  public boolean i()
  {
    return this.t.contains("*");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/e/a/b/a/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */