package com.e.a.b.a;

import com.e.a.b;
import com.e.a.b.a;
import com.e.a.b.q;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.CacheRequest;
import java.net.Socket;

public final class g
  implements y
{
  private final f a;
  private final InputStream b;
  private final OutputStream c;
  private OutputStream d;
  
  public g(f paramf, OutputStream paramOutputStream, InputStream paramInputStream)
  {
    this.a = paramf;
    this.c = paramOutputStream;
    this.d = paramOutputStream;
    this.b = paramInputStream;
  }
  
  private static boolean b(f paramf, InputStream paramInputStream)
  {
    paramf = paramf.d;
    if (paramf == null) {}
    do
    {
      return false;
      paramf = paramf.c();
    } while (paramf == null);
    try
    {
      int i = paramf.getSoTimeout();
      paramf.setSoTimeout(100);
      try
      {
        q.b(paramInputStream);
        return true;
      }
      finally
      {
        paramf.setSoTimeout(i);
      }
      return false;
    }
    catch (IOException paramf) {}
  }
  
  public InputStream a(CacheRequest paramCacheRequest)
  {
    if (!this.a.n()) {
      return new j(this.b, paramCacheRequest, this.a, 0);
    }
    if (this.a.i.d()) {
      return new h(this.b, paramCacheRequest, this);
    }
    if (this.a.i.h() != -1) {
      return new j(this.b, paramCacheRequest, this.a, this.a.i.h());
    }
    return new z(this.b, paramCacheRequest, this.a);
  }
  
  public OutputStream a()
  {
    boolean bool2 = this.a.h.a();
    boolean bool1 = bool2;
    if (!bool2)
    {
      bool1 = bool2;
      if (this.a.a.d() > 0)
      {
        bool1 = bool2;
        if (this.a.d.j() != 0)
        {
          this.a.h.q();
          bool1 = true;
        }
      }
    }
    if (bool1)
    {
      int j = this.a.a.d();
      int i = j;
      if (j == -1) {
        i = 1024;
      }
      c();
      return new i(this.d, i, null);
    }
    long l = this.a.a.c();
    if (l != -1L)
    {
      this.a.h.a(l);
      c();
      return new k(this.d, l, null);
    }
    l = this.a.h.j();
    if (l > 2147483647L) {
      throw new IllegalArgumentException("Use setFixedLengthStreamingMode() or setChunkedStreamingMode() for requests larger than 2 GiB.");
    }
    if (l != -1L)
    {
      c();
      return new v((int)l);
    }
    return new v();
  }
  
  public void a(v paramv)
  {
    paramv.a(this.d);
  }
  
  public boolean a(boolean paramBoolean, OutputStream paramOutputStream, InputStream paramInputStream)
  {
    if (paramBoolean) {}
    while (((paramOutputStream != null) && (!((a)paramOutputStream).b())) || (this.a.h.b()) || ((this.a.i != null) && (this.a.i.e())) || ((paramInputStream instanceof z))) {
      return false;
    }
    if (paramInputStream != null) {
      return b(this.a, paramInputStream);
    }
    return true;
  }
  
  public void b()
  {
    this.d.flush();
    this.d = this.c;
  }
  
  public void c()
  {
    this.a.c();
    byte[] arrayOfByte = this.a.h.c().f();
    this.d.write(arrayOfByte);
  }
  
  public u d()
  {
    Object localObject = s.a(this.b);
    this.a.d.a(((s)localObject).b());
    this.a.a((s)localObject);
    localObject = new u(this.a.g, (s)localObject);
    ((u)localObject).a("http/1.1");
    return (u)localObject;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/e/a/b/a/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */