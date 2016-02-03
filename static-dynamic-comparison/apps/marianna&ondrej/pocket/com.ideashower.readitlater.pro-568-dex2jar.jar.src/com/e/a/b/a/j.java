package com.e.a.b.a;

import com.e.a.b.q;
import java.io.InputStream;
import java.net.CacheRequest;
import java.net.ProtocolException;

class j
  extends a
{
  private int d;
  
  public j(InputStream paramInputStream, CacheRequest paramCacheRequest, f paramf, int paramInt)
  {
    super(paramInputStream, paramf, paramCacheRequest);
    this.d = paramInt;
    if (this.d == 0) {
      b();
    }
  }
  
  public int available()
  {
    a();
    if (this.d == 0) {
      return 0;
    }
    return Math.min(this.a.available(), this.d);
  }
  
  public void close()
  {
    if (this.c) {
      return;
    }
    if ((this.d != 0) && (!g.a(this.b, this))) {
      c();
    }
    this.c = true;
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    q.a(paramArrayOfByte.length, paramInt1, paramInt2);
    a();
    if (this.d == 0) {
      return -1;
    }
    paramInt2 = this.a.read(paramArrayOfByte, paramInt1, Math.min(paramInt2, this.d));
    if (paramInt2 == -1)
    {
      c();
      throw new ProtocolException("unexpected end of stream");
    }
    this.d -= paramInt2;
    a(paramArrayOfByte, paramInt1, paramInt2);
    if (this.d == 0) {
      b();
    }
    return paramInt2;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/e/a/b/a/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */