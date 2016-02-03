package com.e.a.b.a;

import com.e.a.b.q;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.CacheRequest;

abstract class a
  extends InputStream
{
  protected final InputStream a;
  protected final f b;
  protected boolean c;
  private final CacheRequest d;
  private final OutputStream e;
  
  a(InputStream paramInputStream, f paramf, CacheRequest paramCacheRequest)
  {
    this.a = paramInputStream;
    this.b = paramf;
    if (paramCacheRequest != null) {}
    for (paramInputStream = paramCacheRequest.getBody();; paramInputStream = null)
    {
      if (paramInputStream == null) {
        paramCacheRequest = null;
      }
      this.e = paramInputStream;
      this.d = paramCacheRequest;
      return;
    }
  }
  
  protected final void a()
  {
    if (this.c) {
      throw new IOException("stream closed");
    }
  }
  
  protected final void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (this.e != null) {
      this.e.write(paramArrayOfByte, paramInt1, paramInt2);
    }
  }
  
  protected final void b()
  {
    if (this.d != null) {
      this.e.close();
    }
    this.b.a(false);
  }
  
  protected final void c()
  {
    if (this.d != null) {
      this.d.abort();
    }
    this.b.a(true);
  }
  
  public final int read()
  {
    return q.a(this);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/e/a/b/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */