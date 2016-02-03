package com.e.a;

import com.e.a.b.a.d;
import com.e.a.b.a.f;
import com.e.a.b.a.g;
import com.e.a.b.a.s;
import com.e.a.b.a.x;
import com.e.a.b.b.n;
import com.e.a.b.b.o;
import com.e.a.b.j;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public final class b
  implements Closeable
{
  private static final byte[] a = { 6, 115, 112, 100, 121, 47, 51, 8, 104, 116, 116, 112, 47, 49, 46, 49 };
  private static final byte[] b = { 115, 112, 100, 121, 47, 51 };
  private static final byte[] c = { 104, 116, 116, 112, 47, 49, 46, 49 };
  private final p d;
  private Socket e;
  private InputStream f;
  private OutputStream g;
  private boolean h = false;
  private n i;
  private int j = 1;
  private long k;
  
  public b(p paramp)
  {
    this.d = paramp;
  }
  
  private void a(r paramr)
  {
    Object localObject = j.a();
    if (k()) {
      b(paramr);
    }
    this.e = this.d.a.d.createSocket(this.e, this.d.a.b, this.d.a.c, true);
    paramr = (SSLSocket)this.e;
    if (this.d.d)
    {
      ((j)localObject).a(paramr, this.d.a.b);
      if ((!this.d.d) || (!this.d.a.g.contains("spdy/3"))) {
        break label220;
      }
    }
    label220:
    for (int m = 1;; m = 0)
    {
      if (m != 0) {
        ((j)localObject).a(paramr, a);
      }
      paramr.startHandshake();
      if (this.d.a.e.verify(this.d.a.b, paramr.getSession())) {
        break label225;
      }
      throw new IOException("Hostname '" + this.d.a.b + "' was not verified");
      ((j)localObject).a(paramr);
      break;
    }
    label225:
    this.g = paramr.getOutputStream();
    this.f = paramr.getInputStream();
    if (m != 0)
    {
      localObject = ((j)localObject).b(paramr);
      if (localObject != null)
      {
        if (!Arrays.equals((byte[])localObject, b)) {
          break label311;
        }
        paramr.setSoTimeout(0);
        this.i = new o(this.d.a.a(), true, this.f, this.g).a();
        this.i.d();
      }
    }
    label311:
    while (Arrays.equals((byte[])localObject, c)) {
      return;
    }
    throw new IOException("Unexpected NPN transport " + new String((byte[])localObject, "ISO-8859-1"));
  }
  
  private void b(r paramr)
  {
    s locals1 = paramr.a();
    s locals2;
    URL localURL;
    do
    {
      this.g.write(locals1.f());
      locals2 = s.a(this.f);
      switch (locals2.c())
      {
      default: 
        throw new IOException("Unexpected response code for CONNECT: " + locals2.c());
      case 407: 
        locals1 = new s(locals1);
        localURL = new URL("https", paramr.a, paramr.b, "/");
      }
    } while (d.a(this.d.a.f, 407, locals2, locals1, this.d.b, localURL));
    throw new IOException("Failed to authenticate with proxy");
  }
  
  public Object a(f paramf)
  {
    if (this.i != null) {
      return new x(paramf, this.i);
    }
    return new g(paramf, this.g, this.f);
  }
  
  public void a(int paramInt)
  {
    this.j = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2, r paramr)
  {
    if (this.h) {
      throw new IllegalStateException("already connected");
    }
    this.h = true;
    if (this.d.b.type() != Proxy.Type.HTTP) {}
    for (Socket localSocket = new Socket(this.d.b);; localSocket = new Socket())
    {
      this.e = localSocket;
      j.a().a(this.e, this.d.c, paramInt1);
      this.e.setSoTimeout(paramInt2);
      this.f = this.e.getInputStream();
      this.g = this.e.getOutputStream();
      if (this.d.a.d != null) {
        a(paramr);
      }
      paramInt2 = j.a().c(this.e);
      paramInt1 = paramInt2;
      if (paramInt2 < 1024) {
        paramInt1 = 1024;
      }
      paramInt2 = paramInt1;
      if (paramInt1 > 8192) {
        paramInt2 = 8192;
      }
      this.f = new BufferedInputStream(this.f, paramInt2);
      this.g = new BufferedOutputStream(this.g, paramInt2);
      return;
    }
  }
  
  public boolean a()
  {
    return this.h;
  }
  
  public boolean a(long paramLong)
  {
    return (g()) && (System.nanoTime() - h() > paramLong);
  }
  
  public p b()
  {
    return this.d;
  }
  
  public Socket c()
  {
    return this.e;
  }
  
  public void close()
  {
    this.e.close();
  }
  
  public boolean d()
  {
    return (!this.e.isClosed()) && (!this.e.isInputShutdown()) && (!this.e.isOutputShutdown());
  }
  
  public boolean e()
  {
    if (!(this.f instanceof BufferedInputStream)) {
      return true;
    }
    if (i()) {
      return true;
    }
    BufferedInputStream localBufferedInputStream = (BufferedInputStream)this.f;
    try
    {
      int m = this.e.getSoTimeout();
      try
      {
        this.e.setSoTimeout(1);
        localBufferedInputStream.mark(1);
        int n = localBufferedInputStream.read();
        if (n == -1) {
          return false;
        }
        localBufferedInputStream.reset();
        return true;
      }
      finally
      {
        this.e.setSoTimeout(m);
      }
      return false;
    }
    catch (SocketTimeoutException localSocketTimeoutException)
    {
      return true;
    }
    catch (IOException localIOException) {}
  }
  
  public void f()
  {
    if (this.i != null) {
      throw new IllegalStateException("spdyConnection != null");
    }
    this.k = System.nanoTime();
  }
  
  public boolean g()
  {
    return (this.i == null) || (this.i.a());
  }
  
  public long h()
  {
    if (this.i == null) {
      return this.k;
    }
    return this.i.b();
  }
  
  public boolean i()
  {
    return this.i != null;
  }
  
  public int j()
  {
    return this.j;
  }
  
  public boolean k()
  {
    return (this.d.a.d != null) && (this.d.b.type() == Proxy.Type.HTTP);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/e/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */