package com.e.a.b.a;

import com.e.a.a;
import com.e.a.b;
import com.e.a.b.h;
import com.e.a.b.j;
import com.e.a.c;
import com.e.a.m;
import com.e.a.n;
import com.e.a.o;
import com.e.a.p;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.CacheRequest;
import java.net.CacheResponse;
import java.net.CookieHandler;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

public class f
{
  private static final CacheResponse j = new CacheResponse()
  {
    public InputStream getBody()
    {
      return new ByteArrayInputStream(com.e.a.b.q.a);
    }
    
    public Map getHeaders()
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put(null, Collections.singletonList("HTTP/1.1 504 Gateway Timeout"));
      return localHashMap;
    }
  };
  protected final r a;
  protected final m b;
  protected final String c;
  protected b d;
  protected w e;
  long f = -1L;
  final URI g;
  final t h;
  u i;
  private o k;
  private OutputStream l;
  private y m;
  private InputStream n;
  private InputStream o;
  private CacheResponse p;
  private CacheRequest q;
  private boolean r;
  private u s;
  private InputStream t;
  private boolean u;
  private boolean v;
  
  public f(m paramm, r paramr, String paramString, s params, b paramb, v paramv)
  {
    this.b = paramm;
    this.a = paramr;
    this.c = paramString;
    this.d = paramb;
    this.l = paramv;
    try
    {
      this.g = j.a().a(paramr.getURL());
      this.h = new t(this.g, new s(params));
      return;
    }
    catch (URISyntaxException paramm)
    {
      throw new IOException(paramm.getMessage());
    }
  }
  
  public static String a(URL paramURL)
  {
    String str = paramURL.getFile();
    if (str == null) {
      paramURL = "/";
    }
    do
    {
      return paramURL;
      paramURL = str;
    } while (str.startsWith("/"));
    return "/" + str;
  }
  
  private void a(u paramu, InputStream paramInputStream)
  {
    if (this.o != null) {
      throw new IllegalStateException();
    }
    this.i = paramu;
    if (paramInputStream != null) {
      a(paramInputStream);
    }
  }
  
  private void a(InputStream paramInputStream)
  {
    this.n = paramInputStream;
    if ((this.r) && (this.i.a()))
    {
      this.i.b();
      this.i.c();
      this.o = new GZIPInputStream(paramInputStream);
      return;
    }
    this.o = paramInputStream;
  }
  
  public static String b(URL paramURL)
  {
    int i1 = paramURL.getPort();
    String str2 = paramURL.getHost();
    String str1 = str2;
    if (i1 > 0)
    {
      str1 = str2;
      if (i1 != com.e.a.b.q.a(paramURL.getProtocol())) {
        str1 = str2 + ":" + i1;
      }
    }
    return str1;
  }
  
  public static String q()
  {
    String str = System.getProperty("http.agent");
    if (str != null) {
      return str;
    }
    return "Java" + System.getProperty("java.version");
  }
  
  private void t()
  {
    this.k = o.c;
    if (!this.a.getUseCaches()) {}
    Object localObject1;
    do
    {
      do
      {
        return;
        localObject1 = this.b.f();
      } while (localObject1 == null);
      localObject1 = ((n)localObject1).a(this.g, this.c, this.h.c().a(false));
    } while (localObject1 == null);
    Object localObject2 = ((CacheResponse)localObject1).getHeaders();
    this.t = ((CacheResponse)localObject1).getBody();
    if ((!a((CacheResponse)localObject1)) || (localObject2 == null) || (this.t == null))
    {
      com.e.a.b.q.a(this.t);
      return;
    }
    localObject2 = s.a((Map)localObject2, true);
    this.s = new u(this.g, (s)localObject2);
    long l1 = System.currentTimeMillis();
    this.k = this.s.a(l1, this.h);
    if (this.k == o.a)
    {
      this.p = ((CacheResponse)localObject1);
      a(this.s, this.t);
      return;
    }
    if (this.k == o.b)
    {
      this.p = ((CacheResponse)localObject1);
      return;
    }
    if (this.k == o.c)
    {
      com.e.a.b.q.a(this.t);
      return;
    }
    throw new AssertionError();
  }
  
  private void u()
  {
    if (this.d == null) {
      b();
    }
    if (this.m != null) {
      throw new IllegalStateException();
    }
    this.m = ((y)this.d.a(this));
    if ((d()) && (this.l == null)) {
      this.l = this.m.a();
    }
  }
  
  private void v()
  {
    if (!this.a.getUseCaches()) {}
    n localn;
    do
    {
      return;
      localn = this.b.f();
    } while (localn == null);
    HttpURLConnection localHttpURLConnection = this.a.a();
    if (!this.i.a(this.h))
    {
      localn.a(localHttpURLConnection.getRequestMethod(), this.g);
      return;
    }
    this.q = localn.a(this.g, localHttpURLConnection);
  }
  
  private void w()
  {
    this.h.c().a(o());
    if (this.h.k() == null) {
      this.h.a(q());
    }
    if (this.h.l() == null) {
      this.h.b(b(this.a.getURL()));
    }
    if (((this.d == null) || (this.d.j() != 0)) && (this.h.m() == null)) {
      this.h.c("Keep-Alive");
    }
    if (this.h.n() == null)
    {
      this.r = true;
      this.h.d("gzip");
    }
    if ((d()) && (this.h.o() == null)) {
      this.h.e("application/x-www-form-urlencoded");
    }
    long l1 = this.a.getIfModifiedSince();
    if (l1 != 0L) {
      this.h.a(new Date(l1));
    }
    CookieHandler localCookieHandler = this.b.e();
    if (localCookieHandler != null) {
      this.h.a(localCookieHandler.get(this.g, this.h.c().a(false)));
    }
  }
  
  private String x()
  {
    URL localURL = this.a.getURL();
    if (p()) {
      return localURL.toString();
    }
    return a(localURL);
  }
  
  public final void a()
  {
    if (this.k != null) {}
    do
    {
      return;
      w();
      t();
      Object localObject = this.b.f();
      if (localObject != null) {
        ((n)localObject).a(this.k);
      }
      if ((this.h.h()) && (this.k.a()))
      {
        if (this.k == o.b) {
          com.e.a.b.q.a(this.t);
        }
        this.k = o.a;
        this.p = j;
        localObject = s.a(this.p.getHeaders(), true);
        a(new u(this.g, (s)localObject), this.p.getBody());
      }
      if (this.k.a())
      {
        u();
        return;
      }
    } while (this.d == null);
    this.b.j().a(this.d);
    this.d = null;
  }
  
  public void a(s params)
  {
    CookieHandler localCookieHandler = this.b.e();
    if (localCookieHandler != null) {
      localCookieHandler.put(this.g, params.a(true));
    }
  }
  
  protected void a(b paramb) {}
  
  public final void a(boolean paramBoolean)
  {
    if (this.o == this.t) {
      com.e.a.b.q.a(this.o);
    }
    if ((!this.v) && (this.d != null))
    {
      this.v = true;
      if ((this.m != null) && (this.m.a(paramBoolean, this.l, this.n))) {
        break label78;
      }
      com.e.a.b.q.a(this.d);
      this.d = null;
    }
    label78:
    while (!this.u) {
      return;
    }
    this.b.j().a(this.d);
    this.d = null;
  }
  
  protected boolean a(CacheResponse paramCacheResponse)
  {
    return true;
  }
  
  protected final void b()
  {
    HostnameVerifier localHostnameVerifier = null;
    if (this.d != null) {
      return;
    }
    String str;
    SSLSocketFactory localSSLSocketFactory;
    if (this.e == null)
    {
      str = this.g.getHost();
      if (str == null) {
        throw new UnknownHostException(this.g.toString());
      }
      if (!this.g.getScheme().equalsIgnoreCase("https")) {
        break label277;
      }
      localSSLSocketFactory = this.b.g();
      localHostnameVerifier = this.b.h();
    }
    for (;;)
    {
      this.e = new w(new a(str, com.e.a.b.q.a(this.g), localSSLSocketFactory, localHostnameVerifier, this.b.i(), this.b.c(), this.b.m()), this.g, this.b.d(), this.b.j(), h.a, this.b.l());
      this.d = this.e.a(this.c);
      if (!this.d.a())
      {
        this.d.a(this.b.a(), this.b.b(), s());
        this.b.j().b(this.d);
        this.b.l().a(this.d.b());
      }
      a(this.d);
      if (this.d.b().b() == this.b.c()) {
        break;
      }
      this.h.c().a(o());
      return;
      label277:
      localSSLSocketFactory = null;
    }
  }
  
  public void c()
  {
    if (this.f != -1L) {
      throw new IllegalStateException();
    }
    this.f = System.currentTimeMillis();
  }
  
  boolean d()
  {
    return (this.c.equals("POST")) || (this.c.equals("PUT"));
  }
  
  public final OutputStream e()
  {
    if (this.k == null) {
      throw new IllegalStateException();
    }
    return this.l;
  }
  
  public final boolean f()
  {
    return this.i != null;
  }
  
  public final t g()
  {
    return this.h;
  }
  
  public final u h()
  {
    if (this.i == null) {
      throw new IllegalStateException();
    }
    return this.i;
  }
  
  public final int i()
  {
    if (this.i == null) {
      throw new IllegalStateException();
    }
    return this.i.f().c();
  }
  
  public final InputStream j()
  {
    if (this.i == null) {
      throw new IllegalStateException();
    }
    return this.o;
  }
  
  public final CacheResponse k()
  {
    return this.p;
  }
  
  public final b l()
  {
    return this.d;
  }
  
  public final void m()
  {
    this.u = true;
    if ((this.d != null) && (this.v))
    {
      this.b.j().a(this.d);
      this.d = null;
    }
  }
  
  public final boolean n()
  {
    int i1 = this.i.f().c();
    if (this.c.equals("HEAD")) {}
    do
    {
      return false;
      if (((i1 < 100) || (i1 >= 200)) && (i1 != 204) && (i1 != 304)) {
        return true;
      }
    } while ((this.i.h() == -1) && (!this.i.d()));
    return true;
  }
  
  String o()
  {
    if ((this.d == null) || (this.d.j() != 0)) {}
    for (String str = "HTTP/1.1";; str = "HTTP/1.0") {
      return this.c + " " + x() + " " + str;
    }
  }
  
  protected boolean p()
  {
    if (this.d == null) {
      return this.a.usingProxy();
    }
    return this.d.b().b().type() == Proxy.Type.HTTP;
  }
  
  public final void r()
  {
    if (f()) {
      this.i.a(this.k);
    }
    do
    {
      return;
      if (this.k == null) {
        throw new IllegalStateException("readResponse() without sendRequest()");
      }
    } while (!this.k.a());
    if (this.f == -1L)
    {
      if ((this.l instanceof v))
      {
        int i1 = ((v)this.l).c();
        this.h.a(i1);
      }
      this.m.c();
    }
    if (this.l != null)
    {
      this.l.close();
      if ((this.l instanceof v)) {
        this.m.a((v)this.l);
      }
    }
    this.m.b();
    this.i = this.m.d();
    this.i.a(this.f, System.currentTimeMillis());
    this.i.a(this.k);
    if (this.k == o.b)
    {
      if (this.s.a(this.i))
      {
        a(false);
        a(this.s.b(this.i), this.t);
        n localn = this.b.f();
        localn.a();
        localn.a(this.p, this.a.a());
        return;
      }
      com.e.a.b.q.a(this.t);
    }
    if (n()) {
      v();
    }
    a(this.m.a(this.q));
  }
  
  protected com.e.a.r s()
  {
    return null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/e/a/b/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */