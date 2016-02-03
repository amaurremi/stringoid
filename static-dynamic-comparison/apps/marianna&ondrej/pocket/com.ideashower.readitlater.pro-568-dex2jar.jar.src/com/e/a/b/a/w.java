package com.e.a.b.a;

import com.e.a.a;
import com.e.a.b;
import com.e.a.b.h;
import com.e.a.c;
import com.e.a.p;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.ProxySelector;
import java.net.URI;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

public final class w
{
  private final a a;
  private final URI b;
  private final ProxySelector c;
  private final c d;
  private final h e;
  private final com.e.a.q f;
  private Proxy g;
  private InetSocketAddress h;
  private boolean i;
  private Proxy j;
  private Iterator k;
  private InetAddress[] l;
  private int m;
  private int n;
  private int o = -1;
  private final List p;
  
  public w(a parama, URI paramURI, ProxySelector paramProxySelector, c paramc, h paramh, com.e.a.q paramq)
  {
    this.a = parama;
    this.b = paramURI;
    this.c = paramProxySelector;
    this.d = paramc;
    this.e = paramh;
    this.f = paramq;
    this.p = new LinkedList();
    a(paramURI, parama.c());
  }
  
  private void a(Proxy paramProxy)
  {
    this.l = null;
    if (paramProxy.type() == Proxy.Type.DIRECT) {
      paramProxy = this.b.getHost();
    }
    InetSocketAddress localInetSocketAddress;
    for (this.n = com.e.a.b.q.a(this.b);; this.n = localInetSocketAddress.getPort())
    {
      this.l = this.e.a(paramProxy);
      this.m = 0;
      return;
      paramProxy = paramProxy.address();
      if (!(paramProxy instanceof InetSocketAddress)) {
        throw new IllegalArgumentException("Proxy.address() is not an InetSocketAddress: " + paramProxy.getClass());
      }
      localInetSocketAddress = (InetSocketAddress)paramProxy;
      paramProxy = localInetSocketAddress.getHostName();
    }
  }
  
  private void a(URI paramURI, Proxy paramProxy)
  {
    this.i = true;
    if (paramProxy != null) {
      this.j = paramProxy;
    }
    do
    {
      return;
      paramURI = this.c.select(paramURI);
    } while (paramURI == null);
    this.k = paramURI.iterator();
  }
  
  private boolean b()
  {
    return this.i;
  }
  
  private Proxy c()
  {
    if (this.j != null)
    {
      this.i = false;
      return this.j;
    }
    if (this.k != null) {
      while (this.k.hasNext())
      {
        Proxy localProxy = (Proxy)this.k.next();
        if (localProxy.type() != Proxy.Type.DIRECT) {
          return localProxy;
        }
      }
    }
    this.i = false;
    return Proxy.NO_PROXY;
  }
  
  private boolean d()
  {
    return this.l != null;
  }
  
  private InetSocketAddress e()
  {
    Object localObject = this.l;
    int i1 = this.m;
    this.m = (i1 + 1);
    localObject = new InetSocketAddress(localObject[i1], this.n);
    if (this.m == this.l.length)
    {
      this.l = null;
      this.m = 0;
    }
    return (InetSocketAddress)localObject;
  }
  
  private void f()
  {
    if (this.a.b() != null) {}
    for (int i1 = 1;; i1 = 0)
    {
      this.o = i1;
      return;
    }
  }
  
  private boolean g()
  {
    return this.o != -1;
  }
  
  private int h()
  {
    if (this.o == 1)
    {
      this.o = 0;
      return 1;
    }
    if (this.o == 0)
    {
      this.o = -1;
      return 0;
    }
    throw new AssertionError();
  }
  
  private boolean i()
  {
    return !this.p.isEmpty();
  }
  
  private p j()
  {
    return (p)this.p.remove(0);
  }
  
  public b a(String paramString)
  {
    boolean bool = true;
    Object localObject;
    for (;;)
    {
      localObject = this.d.a(this.a);
      if (localObject == null) {
        break;
      }
      if ((paramString.equals("GET")) || (((b)localObject).e())) {
        return (b)localObject;
      }
      ((b)localObject).close();
    }
    if (!g())
    {
      if (!d())
      {
        if (!b())
        {
          if (!i()) {
            throw new NoSuchElementException();
          }
          return new b(j());
        }
        this.g = c();
        a(this.g);
      }
      this.h = e();
      f();
    }
    if (h() == 1) {}
    for (;;)
    {
      localObject = new p(this.a, this.g, this.h, bool);
      if (!this.f.b((p)localObject)) {
        break;
      }
      this.p.add(localObject);
      return a(paramString);
      bool = false;
    }
    return new b((p)localObject);
  }
  
  public void a(b paramb, IOException paramIOException)
  {
    paramb = paramb.b();
    if ((paramb.b().type() != Proxy.Type.DIRECT) && (this.c != null)) {
      this.c.connectFailed(this.b, paramb.b().address(), paramIOException);
    }
    this.f.a(paramb, paramIOException);
  }
  
  public boolean a()
  {
    return (g()) || (d()) || (b()) || (i());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/e/a/b/a/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */