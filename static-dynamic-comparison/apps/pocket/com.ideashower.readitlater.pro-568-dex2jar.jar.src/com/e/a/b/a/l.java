package com.e.a.b.a;

import com.e.a.b;
import com.e.a.b.j;
import com.e.a.b.q;
import com.e.a.p;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpRetryException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.SocketPermission;
import java.net.URL;
import java.security.Permission;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLHandshakeException;

public class l
  extends HttpURLConnection
  implements r
{
  final com.e.a.m a;
  protected IOException b;
  protected f c;
  private final s d = new s();
  private long e = -1L;
  private int f;
  
  public l(URL paramURL, com.e.a.m paramm)
  {
    super(paramURL);
    this.a = paramm;
  }
  
  private f a(String paramString, s params, b paramb, v paramv)
  {
    if (this.url.getProtocol().equals("http")) {
      return new f(this.a, this, paramString, params, paramb, paramv);
    }
    if (this.url.getProtocol().equals("https")) {
      return new n(this.a, this, paramString, params, paramb, paramv);
    }
    throw new AssertionError();
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramBoolean) {
      localArrayList.addAll(this.a.m());
    }
    paramString = paramString.split(",", -1);
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      localArrayList.add(paramString[i]);
      i += 1;
    }
    this.a.a(localArrayList);
  }
  
  private boolean a(IOException paramIOException)
  {
    w localw = this.c.e;
    if ((localw != null) && (this.c.d != null)) {
      localw.a(this.c.d, paramIOException);
    }
    OutputStream localOutputStream = this.c.e();
    if ((localOutputStream == null) || ((localOutputStream instanceof v))) {}
    for (int i = 1; ((localw == null) && (this.c.d == null)) || ((localw != null) && (!localw.a())) || (!b(paramIOException)) || (i == 0); i = 0)
    {
      this.b = paramIOException;
      return false;
    }
    this.c.a(true);
    paramIOException = (v)localOutputStream;
    this.c = a(this.method, this.d, null, paramIOException);
    this.c.e = localw;
    return true;
  }
  
  private boolean a(boolean paramBoolean)
  {
    try
    {
      this.c.a();
      if (paramBoolean) {
        this.c.r();
      }
      return true;
    }
    catch (IOException localIOException)
    {
      if (a(localIOException)) {
        return false;
      }
      throw localIOException;
    }
  }
  
  private boolean b(IOException paramIOException)
  {
    if (((paramIOException instanceof SSLHandshakeException)) && ((paramIOException.getCause() instanceof CertificateException))) {}
    for (int i = 1;; i = 0)
    {
      boolean bool = paramIOException instanceof ProtocolException;
      if ((i != 0) || (bool)) {
        break;
      }
      return true;
    }
    return false;
  }
  
  private void e()
  {
    if (this.b != null) {
      throw this.b;
    }
    if (this.c != null) {
      return;
    }
    this.connected = true;
    do
    {
      try
      {
        if (this.doOutput)
        {
          if (this.method.equals("GET")) {
            this.method = "POST";
          }
        }
        else
        {
          this.c = a(this.method, this.d, null, null);
          return;
        }
      }
      catch (IOException localIOException)
      {
        this.b = localIOException;
        throw localIOException;
      }
    } while ((this.method.equals("POST")) || (this.method.equals("PUT")));
    throw new ProtocolException(this.method + " does not support writing");
  }
  
  private f f()
  {
    e();
    if (this.c.f()) {
      return this.c;
    }
    for (;;)
    {
      if (a(true))
      {
        m localm = g();
        if (localm == m.a)
        {
          this.c.m();
          return this.c;
        }
        String str = this.method;
        OutputStream localOutputStream = this.c.e();
        int i = getResponseCode();
        if ((i == 300) || (i == 301) || (i == 302) || (i == 303))
        {
          str = "GET";
          localOutputStream = null;
        }
        if ((localOutputStream != null) && (!(localOutputStream instanceof v))) {
          throw new HttpRetryException("Cannot retry streamed HTTP body", this.c.i());
        }
        if (localm == m.c) {
          this.c.m();
        }
        this.c.a(false);
        this.c = a(str, this.d, this.c.l(), (v)localOutputStream);
      }
    }
  }
  
  private m g()
  {
    if (this.c.d != null) {}
    for (Object localObject = this.c.d.b().b();; localObject = this.a.c())
    {
      i = getResponseCode();
      switch (i)
      {
      default: 
        return m.a;
      }
    }
    if (((Proxy)localObject).type() != Proxy.Type.HTTP) {
      throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
    }
    if (d.a(this.a.i(), getResponseCode(), this.c.h().f(), this.d, (Proxy)localObject, this.url)) {
      return m.b;
    }
    return m.a;
    if (!getInstanceFollowRedirects()) {
      return m.a;
    }
    int j = this.f + 1;
    this.f = j;
    if (j > 20) {
      throw new ProtocolException("Too many redirects: " + this.f);
    }
    if ((i == 307) && (!this.method.equals("GET")) && (!this.method.equals("HEAD"))) {
      return m.a;
    }
    localObject = getHeaderField("Location");
    if (localObject == null) {
      return m.a;
    }
    URL localURL = this.url;
    this.url = new URL(localURL, (String)localObject);
    if ((!this.url.getProtocol().equals("https")) && (!this.url.getProtocol().equals("http"))) {
      return m.a;
    }
    boolean bool1 = localURL.getProtocol().equals(this.url.getProtocol());
    if ((!bool1) && (!this.a.k())) {
      return m.a;
    }
    boolean bool2 = localURL.getHost().equals(this.url.getHost());
    if (q.a(localURL) == q.a(this.url)) {}
    for (int i = 1; (bool2) && (i != 0) && (bool1); i = 0) {
      return m.b;
    }
    return m.c;
  }
  
  public HttpURLConnection a()
  {
    return this;
  }
  
  public final void addRequestProperty(String paramString1, String paramString2)
  {
    if (this.connected) {
      throw new IllegalStateException("Cannot add request property after connection is made");
    }
    if (paramString1 == null) {
      throw new NullPointerException("field == null");
    }
    if (paramString2 == null)
    {
      j.a().a("Ignoring header " + paramString1 + " because its value was null.");
      return;
    }
    if ("X-Android-Transports".equals(paramString1))
    {
      a(paramString2, true);
      return;
    }
    this.d.a(paramString1, paramString2);
  }
  
  public f b()
  {
    return this.c;
  }
  
  public final long c()
  {
    return this.e;
  }
  
  public final void connect()
  {
    e();
    while (!a(false)) {}
  }
  
  public final int d()
  {
    return this.chunkLength;
  }
  
  public final void disconnect()
  {
    if (this.c != null)
    {
      if (this.c.f()) {
        q.a(this.c.j());
      }
      this.c.a(true);
    }
  }
  
  public int getConnectTimeout()
  {
    return this.a.a();
  }
  
  public final InputStream getErrorStream()
  {
    Object localObject2 = null;
    try
    {
      f localf = f();
      Object localObject1 = localObject2;
      if (localf.n())
      {
        localObject1 = localObject2;
        if (localf.i() >= 400) {
          localObject1 = localf.j();
        }
      }
      return (InputStream)localObject1;
    }
    catch (IOException localIOException) {}
    return null;
  }
  
  public final String getHeaderField(int paramInt)
  {
    try
    {
      String str = f().h().f().b(paramInt);
      return str;
    }
    catch (IOException localIOException) {}
    return null;
  }
  
  public final String getHeaderField(String paramString)
  {
    try
    {
      s locals = f().h().f();
      if (paramString == null) {
        return locals.a();
      }
      paramString = locals.e(paramString);
      return paramString;
    }
    catch (IOException paramString) {}
    return null;
  }
  
  public final String getHeaderFieldKey(int paramInt)
  {
    try
    {
      String str = f().h().f().a(paramInt);
      return str;
    }
    catch (IOException localIOException) {}
    return null;
  }
  
  public final Map getHeaderFields()
  {
    try
    {
      Map localMap = f().h().f().a(true);
      return localMap;
    }
    catch (IOException localIOException) {}
    return null;
  }
  
  public final InputStream getInputStream()
  {
    if (!this.doInput) {
      throw new ProtocolException("This protocol does not support input");
    }
    Object localObject = f();
    if (getResponseCode() >= 400) {
      throw new FileNotFoundException(this.url.toString());
    }
    localObject = ((f)localObject).j();
    if (localObject == null) {
      throw new ProtocolException("No response body exists; responseCode=" + getResponseCode());
    }
    return (InputStream)localObject;
  }
  
  public final OutputStream getOutputStream()
  {
    connect();
    OutputStream localOutputStream = this.c.e();
    if (localOutputStream == null) {
      throw new ProtocolException("method does not support a request body: " + this.method);
    }
    if (this.c.f()) {
      throw new ProtocolException("cannot write request body after response has been read");
    }
    return localOutputStream;
  }
  
  public final Permission getPermission()
  {
    String str = getURL().getHost();
    int i = q.a(getURL());
    if (usingProxy())
    {
      InetSocketAddress localInetSocketAddress = (InetSocketAddress)this.a.c().address();
      str = localInetSocketAddress.getHostName();
      i = localInetSocketAddress.getPort();
    }
    return new SocketPermission(str + ":" + i, "connect, resolve");
  }
  
  public int getReadTimeout()
  {
    return this.a.b();
  }
  
  public final Map getRequestProperties()
  {
    if (this.connected) {
      throw new IllegalStateException("Cannot access request header fields after connection is set");
    }
    return this.d.a(false);
  }
  
  public final String getRequestProperty(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return this.d.e(paramString);
  }
  
  public final int getResponseCode()
  {
    return f().i();
  }
  
  public String getResponseMessage()
  {
    return f().h().f().d();
  }
  
  public void setConnectTimeout(int paramInt)
  {
    this.a.a(paramInt, TimeUnit.MILLISECONDS);
  }
  
  public void setFixedLengthStreamingMode(int paramInt)
  {
    setFixedLengthStreamingMode(paramInt);
  }
  
  public void setFixedLengthStreamingMode(long paramLong)
  {
    if (this.connected) {
      throw new IllegalStateException("Already connected");
    }
    if (this.chunkLength > 0) {
      throw new IllegalStateException("Already in chunked mode");
    }
    if (paramLong < 0L) {
      throw new IllegalArgumentException("contentLength < 0");
    }
    this.e = paramLong;
    this.fixedContentLength = ((int)Math.min(paramLong, 2147483647L));
  }
  
  public void setReadTimeout(int paramInt)
  {
    this.a.b(paramInt, TimeUnit.MILLISECONDS);
  }
  
  public final void setRequestProperty(String paramString1, String paramString2)
  {
    if (this.connected) {
      throw new IllegalStateException("Cannot set request property after connection is made");
    }
    if (paramString1 == null) {
      throw new NullPointerException("field == null");
    }
    if (paramString2 == null)
    {
      j.a().a("Ignoring header " + paramString1 + " because its value was null.");
      return;
    }
    if ("X-Android-Transports".equals(paramString1))
    {
      a(paramString2, false);
      return;
    }
    this.d.b(paramString1, paramString2);
  }
  
  public final boolean usingProxy()
  {
    Proxy localProxy = this.a.c();
    return (localProxy != null) && (localProxy.type() != Proxy.Type.DIRECT);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/e/a/b/a/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */