package com.e.a;

import com.e.a.b.d;
import com.e.a.b.q;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.CacheRequest;

final class f
  extends CacheRequest
{
  private final d b;
  private OutputStream c;
  private boolean d;
  private OutputStream e;
  
  public f(final e parame, final d paramd)
  {
    this.b = paramd;
    this.c = paramd.a(1);
    this.e = new FilterOutputStream(this.c)
    {
      public void close()
      {
        synchronized (parame)
        {
          if (f.a(f.this)) {
            return;
          }
          f.a(f.this, true);
          e.a(parame);
          super.close();
          paramd.a();
          return;
        }
      }
      
      public void write(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        this.out.write(paramAnonymousArrayOfByte, paramAnonymousInt1, paramAnonymousInt2);
      }
    };
  }
  
  public void abort()
  {
    synchronized (this.a)
    {
      if (this.d) {
        return;
      }
      this.d = true;
      e.b(this.a);
      q.a(this.c);
      try
      {
        this.b.b();
        return;
      }
      catch (IOException localIOException) {}
    }
  }
  
  public OutputStream getBody()
  {
    return this.e;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/e/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */