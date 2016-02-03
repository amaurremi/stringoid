package com.e.a.b.a;

import com.e.a.b.q;
import java.io.IOException;
import java.io.InputStream;
import java.net.CacheRequest;
import java.net.ProtocolException;

class h
  extends a
{
  private final g d;
  private int e = -1;
  private boolean f = true;
  
  h(InputStream paramInputStream, CacheRequest paramCacheRequest, g paramg)
  {
    super(paramInputStream, g.a(paramg), paramCacheRequest);
    this.d = paramg;
  }
  
  private void d()
  {
    if (this.e != -1) {
      q.c(this.a);
    }
    String str = q.c(this.a);
    int i = str.indexOf(";");
    Object localObject = str;
    if (i != -1) {
      localObject = str.substring(0, i);
    }
    try
    {
      this.e = Integer.parseInt(((String)localObject).trim(), 16);
      if (this.e == 0)
      {
        this.f = false;
        localObject = this.b.i.f();
        s.a(g.b(this.d), (s)localObject);
        this.b.a((s)localObject);
        b();
      }
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      throw new ProtocolException("Expected a hex chunk size but was " + (String)localObject);
    }
  }
  
  public int available()
  {
    a();
    if ((!this.f) || (this.e == -1)) {
      return 0;
    }
    return Math.min(this.a.available(), this.e);
  }
  
  public void close()
  {
    if (this.c) {
      return;
    }
    if ((this.f) && (!g.a(this.b, this))) {
      c();
    }
    this.c = true;
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    q.a(paramArrayOfByte.length, paramInt1, paramInt2);
    a();
    if (!this.f) {}
    do
    {
      return -1;
      if ((this.e != 0) && (this.e != -1)) {
        break;
      }
      d();
    } while (!this.f);
    paramInt2 = this.a.read(paramArrayOfByte, paramInt1, Math.min(paramInt2, this.e));
    if (paramInt2 == -1)
    {
      c();
      throw new IOException("unexpected end of stream");
    }
    this.e -= paramInt2;
    a(paramArrayOfByte, paramInt1, paramInt2);
    return paramInt2;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/e/a/b/a/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */