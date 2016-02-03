package com.e.a.b.a;

import com.e.a.b.q;
import java.io.InputStream;
import java.net.CacheRequest;

final class z
  extends a
{
  private boolean d;
  
  z(InputStream paramInputStream, CacheRequest paramCacheRequest, f paramf)
  {
    super(paramInputStream, paramf, paramCacheRequest);
  }
  
  public int available()
  {
    a();
    if (this.a == null) {
      return 0;
    }
    return this.a.available();
  }
  
  public void close()
  {
    if (this.c) {}
    do
    {
      return;
      this.c = true;
    } while (this.d);
    c();
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    q.a(paramArrayOfByte.length, paramInt1, paramInt2);
    a();
    if ((this.a == null) || (this.d)) {
      return -1;
    }
    paramInt2 = this.a.read(paramArrayOfByte, paramInt1, paramInt2);
    if (paramInt2 == -1)
    {
      this.d = true;
      b();
      return -1;
    }
    a(paramArrayOfByte, paramInt1, paramInt2);
    return paramInt2;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/e/a/b/a/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */