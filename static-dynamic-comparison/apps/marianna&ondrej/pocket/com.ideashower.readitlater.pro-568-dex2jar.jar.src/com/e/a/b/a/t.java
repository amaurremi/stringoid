package com.e.a.b.a;

import java.net.URI;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class t
{
  private final URI a;
  private final s b;
  private boolean c;
  private int d = -1;
  private int e = -1;
  private int f = -1;
  private boolean g;
  private boolean h;
  private long i = -1L;
  private String j;
  private String k;
  private String l;
  private String m;
  private String n;
  private String o;
  private String p;
  private String q;
  private String r;
  
  public t(URI paramURI, s params)
  {
    this.a = paramURI;
    this.b = params;
    paramURI = new c()
    {
      public void a(String paramAnonymousString1, String paramAnonymousString2)
      {
        if ("no-cache".equalsIgnoreCase(paramAnonymousString1)) {
          t.a(t.this, true);
        }
        do
        {
          return;
          if ("max-age".equalsIgnoreCase(paramAnonymousString1))
          {
            t.a(t.this, b.a(paramAnonymousString2));
            return;
          }
          if ("max-stale".equalsIgnoreCase(paramAnonymousString1))
          {
            t.b(t.this, b.a(paramAnonymousString2));
            return;
          }
          if ("min-fresh".equalsIgnoreCase(paramAnonymousString1))
          {
            t.c(t.this, b.a(paramAnonymousString2));
            return;
          }
        } while (!"only-if-cached".equalsIgnoreCase(paramAnonymousString1));
        t.b(t.this, true);
      }
    };
    int i1 = 0;
    if (i1 < params.e())
    {
      String str1 = params.a(i1);
      String str2 = params.b(i1);
      if ("Cache-Control".equalsIgnoreCase(str1)) {
        b.a(str2, paramURI);
      }
      for (;;)
      {
        i1 += 1;
        break;
        if ("Pragma".equalsIgnoreCase(str1))
        {
          if ("no-cache".equalsIgnoreCase(str2)) {
            this.c = true;
          }
        }
        else if ("If-None-Match".equalsIgnoreCase(str1)) {
          this.q = str2;
        } else if ("If-Modified-Since".equalsIgnoreCase(str1)) {
          this.p = str2;
        } else if ("Authorization".equalsIgnoreCase(str1)) {
          this.h = true;
        } else if ("Content-Length".equalsIgnoreCase(str1)) {
          try
          {
            this.i = Integer.parseInt(str2);
          }
          catch (NumberFormatException localNumberFormatException) {}
        } else if ("Transfer-Encoding".equalsIgnoreCase(localNumberFormatException)) {
          this.j = str2;
        } else if ("User-Agent".equalsIgnoreCase(localNumberFormatException)) {
          this.k = str2;
        } else if ("Host".equalsIgnoreCase(localNumberFormatException)) {
          this.l = str2;
        } else if ("Connection".equalsIgnoreCase(localNumberFormatException)) {
          this.m = str2;
        } else if ("Accept-Encoding".equalsIgnoreCase(localNumberFormatException)) {
          this.n = str2;
        } else if ("Content-Type".equalsIgnoreCase(localNumberFormatException)) {
          this.o = str2;
        } else if ("Proxy-Authorization".equalsIgnoreCase(localNumberFormatException)) {
          this.r = str2;
        }
      }
    }
  }
  
  public void a(long paramLong)
  {
    if (this.i != -1L) {
      this.b.d("Content-Length");
    }
    this.b.a("Content-Length", Long.toString(paramLong));
    this.i = paramLong;
  }
  
  public void a(String paramString)
  {
    if (this.k != null) {
      this.b.d("User-Agent");
    }
    this.b.a("User-Agent", paramString);
    this.k = paramString;
  }
  
  public void a(Date paramDate)
  {
    if (this.p != null) {
      this.b.d("If-Modified-Since");
    }
    paramDate = e.a(paramDate);
    this.b.a("If-Modified-Since", paramDate);
    this.p = paramDate;
  }
  
  public void a(Map paramMap)
  {
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      String str = (String)localEntry.getKey();
      if (("Cookie".equalsIgnoreCase(str)) || ("Cookie2".equalsIgnoreCase(str))) {
        this.b.a(str, (List)localEntry.getValue());
      }
    }
  }
  
  public boolean a()
  {
    return "chunked".equalsIgnoreCase(this.j);
  }
  
  public void b(String paramString)
  {
    if (this.l != null) {
      this.b.d("Host");
    }
    this.b.a("Host", paramString);
    this.l = paramString;
  }
  
  public boolean b()
  {
    return "close".equalsIgnoreCase(this.m);
  }
  
  public s c()
  {
    return this.b;
  }
  
  public void c(String paramString)
  {
    if (this.m != null) {
      this.b.d("Connection");
    }
    this.b.a("Connection", paramString);
    this.m = paramString;
  }
  
  public void d(String paramString)
  {
    if (this.n != null) {
      this.b.d("Accept-Encoding");
    }
    this.b.a("Accept-Encoding", paramString);
    this.n = paramString;
  }
  
  public boolean d()
  {
    return this.c;
  }
  
  public int e()
  {
    return this.d;
  }
  
  public void e(String paramString)
  {
    if (this.o != null) {
      this.b.d("Content-Type");
    }
    this.b.a("Content-Type", paramString);
    this.o = paramString;
  }
  
  public int f()
  {
    return this.e;
  }
  
  public void f(String paramString)
  {
    if (this.q != null) {
      this.b.d("If-None-Match");
    }
    this.b.a("If-None-Match", paramString);
    this.q = paramString;
  }
  
  public int g()
  {
    return this.f;
  }
  
  public boolean h()
  {
    return this.g;
  }
  
  public boolean i()
  {
    return this.h;
  }
  
  public long j()
  {
    return this.i;
  }
  
  public String k()
  {
    return this.k;
  }
  
  public String l()
  {
    return this.l;
  }
  
  public String m()
  {
    return this.m;
  }
  
  public String n()
  {
    return this.n;
  }
  
  public String o()
  {
    return this.o;
  }
  
  public String p()
  {
    return this.r;
  }
  
  public void q()
  {
    if (this.j != null) {
      this.b.d("Transfer-Encoding");
    }
    this.b.a("Transfer-Encoding", "chunked");
    this.j = "chunked";
  }
  
  public boolean r()
  {
    return (this.p != null) || (this.q != null);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/e/a/b/a/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */