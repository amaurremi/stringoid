package com.e.a;

import com.e.a.b.a.l;
import com.e.a.b.a.o;
import com.e.a.b.c.b;
import java.net.CookieHandler;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.ResponseCache;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;
import java.net.URLStreamHandlerFactory;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

public final class m
  implements URLStreamHandlerFactory
{
  private static final List a = com.e.a.b.q.a(Arrays.asList(new String[] { "spdy/3", "http/1.1" }));
  private final q b;
  private final d c;
  private Proxy d;
  private List e;
  private ProxySelector f;
  private CookieHandler g;
  private ResponseCache h;
  private SSLSocketFactory i;
  private HostnameVerifier j;
  private j k;
  private c l;
  private boolean m = true;
  private int n;
  private int o;
  
  public m()
  {
    this.b = new q();
    this.c = new d();
  }
  
  private m(m paramm)
  {
    this.b = paramm.b;
    this.c = paramm.c;
  }
  
  private m n()
  {
    m localm = new m(this);
    localm.d = this.d;
    if (this.f != null)
    {
      localObject = this.f;
      localm.f = ((ProxySelector)localObject);
      if (this.g == null) {
        break label186;
      }
      localObject = this.g;
      label46:
      localm.g = ((CookieHandler)localObject);
      if (this.h == null) {
        break label193;
      }
      localObject = this.h;
      label63:
      localm.h = ((ResponseCache)localObject);
      if (this.i == null) {
        break label200;
      }
      localObject = this.i;
      label80:
      localm.i = ((SSLSocketFactory)localObject);
      if (this.j == null) {
        break label207;
      }
      localObject = this.j;
      label97:
      localm.j = ((HostnameVerifier)localObject);
      if (this.k == null) {
        break label214;
      }
      localObject = this.k;
      label114:
      localm.k = ((j)localObject);
      if (this.l == null) {
        break label221;
      }
      localObject = this.l;
      label131:
      localm.l = ((c)localObject);
      localm.m = this.m;
      if (this.e == null) {
        break label228;
      }
    }
    label186:
    label193:
    label200:
    label207:
    label214:
    label221:
    label228:
    for (Object localObject = this.e;; localObject = a)
    {
      localm.e = ((List)localObject);
      localm.n = this.n;
      localm.o = this.o;
      return localm;
      localObject = ProxySelector.getDefault();
      break;
      localObject = CookieHandler.getDefault();
      break label46;
      localObject = ResponseCache.getDefault();
      break label63;
      localObject = HttpsURLConnection.getDefaultSSLSocketFactory();
      break label80;
      localObject = b.a;
      break label97;
      localObject = com.e.a.b.a.d.a;
      break label114;
      localObject = c.a();
      break label131;
    }
  }
  
  public int a()
  {
    return this.n;
  }
  
  public m a(CookieHandler paramCookieHandler)
  {
    this.g = paramCookieHandler;
    return this;
  }
  
  public m a(Proxy paramProxy)
  {
    this.d = paramProxy;
    return this;
  }
  
  public m a(List paramList)
  {
    paramList = com.e.a.b.q.a(paramList);
    if (!paramList.contains("http/1.1")) {
      throw new IllegalArgumentException("transports doesn't contain http/1.1: " + paramList);
    }
    if (paramList.contains(null)) {
      throw new IllegalArgumentException("transports must not contain null");
    }
    if (paramList.contains("")) {
      throw new IllegalArgumentException("transports contains an empty string");
    }
    this.e = paramList;
    return this;
  }
  
  public m a(HostnameVerifier paramHostnameVerifier)
  {
    this.j = paramHostnameVerifier;
    return this;
  }
  
  public m a(SSLSocketFactory paramSSLSocketFactory)
  {
    this.i = paramSSLSocketFactory;
    return this;
  }
  
  public HttpURLConnection a(URL paramURL)
  {
    return a(paramURL, this.d);
  }
  
  HttpURLConnection a(URL paramURL, Proxy paramProxy)
  {
    String str = paramURL.getProtocol();
    m localm = n();
    localm.d = paramProxy;
    if (str.equals("http")) {
      return new l(paramURL, localm);
    }
    if (str.equals("https")) {
      return new o(paramURL, localm);
    }
    throw new IllegalArgumentException("Unexpected protocol: " + str);
  }
  
  public void a(long paramLong, TimeUnit paramTimeUnit)
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("timeout < 0");
    }
    if (paramTimeUnit == null) {
      throw new IllegalArgumentException("unit == null");
    }
    paramLong = paramTimeUnit.toMillis(paramLong);
    if (paramLong > 2147483647L) {
      throw new IllegalArgumentException("Timeout too large.");
    }
    this.n = ((int)paramLong);
  }
  
  public int b()
  {
    return this.o;
  }
  
  public void b(long paramLong, TimeUnit paramTimeUnit)
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("timeout < 0");
    }
    if (paramTimeUnit == null) {
      throw new IllegalArgumentException("unit == null");
    }
    paramLong = paramTimeUnit.toMillis(paramLong);
    if (paramLong > 2147483647L) {
      throw new IllegalArgumentException("Timeout too large.");
    }
    this.o = ((int)paramLong);
  }
  
  public Proxy c()
  {
    return this.d;
  }
  
  public URLStreamHandler createURLStreamHandler(final String paramString)
  {
    if ((!paramString.equals("http")) && (!paramString.equals("https"))) {
      return null;
    }
    new URLStreamHandler()
    {
      protected int getDefaultPort()
      {
        if (paramString.equals("http")) {
          return 80;
        }
        if (paramString.equals("https")) {
          return 443;
        }
        throw new AssertionError();
      }
      
      protected URLConnection openConnection(URL paramAnonymousURL)
      {
        return m.this.a(paramAnonymousURL);
      }
      
      protected URLConnection openConnection(URL paramAnonymousURL, Proxy paramAnonymousProxy)
      {
        return m.this.a(paramAnonymousURL, paramAnonymousProxy);
      }
    };
  }
  
  public ProxySelector d()
  {
    return this.f;
  }
  
  public CookieHandler e()
  {
    return this.g;
  }
  
  public n f()
  {
    if ((this.h instanceof e)) {
      return ((e)this.h).a;
    }
    if (this.h != null) {
      return new com.e.a.b.a.q(this.h);
    }
    return null;
  }
  
  public SSLSocketFactory g()
  {
    return this.i;
  }
  
  public HostnameVerifier h()
  {
    return this.j;
  }
  
  public j i()
  {
    return this.k;
  }
  
  public c j()
  {
    return this.l;
  }
  
  public boolean k()
  {
    return this.m;
  }
  
  public q l()
  {
    return this.b;
  }
  
  public List m()
  {
    return this.e;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/e/a/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */