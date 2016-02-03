package com.e.a.b.a;

import com.e.a.b;
import com.e.a.b.b.a;
import com.e.a.b.b.n;
import com.e.a.b.b.q;
import com.e.a.m;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.CacheRequest;
import java.net.URI;
import java.net.URL;

public final class x
  implements y
{
  private final f a;
  private final n b;
  private q c;
  
  public x(f paramf, n paramn)
  {
    this.a = paramf;
    this.b = paramn;
  }
  
  public InputStream a(CacheRequest paramCacheRequest)
  {
    return new z(this.c.d(), paramCacheRequest, this.a);
  }
  
  public OutputStream a()
  {
    c();
    return this.c.e();
  }
  
  public void a(v paramv)
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean a(boolean paramBoolean, OutputStream paramOutputStream, InputStream paramInputStream)
  {
    if (paramBoolean)
    {
      if (this.c != null) {
        this.c.b(a.l);
      }
    }
    else {
      return true;
    }
    return false;
  }
  
  public void b()
  {
    this.c.e().close();
  }
  
  public void c()
  {
    if (this.c != null) {
      return;
    }
    this.a.c();
    s locals = this.a.h.c();
    if (this.a.d.j() == 1) {}
    for (String str = "HTTP/1.1";; str = "HTTP/1.0")
    {
      URL localURL = this.a.a.getURL();
      locals.a(this.a.c, f.a(localURL), str, f.b(localURL), this.a.g.getScheme());
      boolean bool = this.a.d();
      this.c = this.b.a(locals.g(), bool, true);
      this.c.a(this.a.b.b());
      return;
    }
  }
  
  public u d()
  {
    Object localObject = s.a(this.c.c());
    this.a.a((s)localObject);
    localObject = new u(this.a.g, (s)localObject);
    ((u)localObject).a("spdy/3");
    return (u)localObject;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/e/a/b/a/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */