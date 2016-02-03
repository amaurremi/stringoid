package com.e.a.b.a;

import com.e.a.b.a;
import com.e.a.b.q;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.net.ProtocolException;

final class v
  extends a
{
  private final int b;
  private final ByteArrayOutputStream c;
  
  public v()
  {
    this.b = -1;
    this.c = new ByteArrayOutputStream();
  }
  
  public v(int paramInt)
  {
    this.b = paramInt;
    this.c = new ByteArrayOutputStream(paramInt);
  }
  
  public void a(OutputStream paramOutputStream)
  {
    this.c.writeTo(paramOutputStream);
  }
  
  public int c()
  {
    try
    {
      close();
      int i = this.c.size();
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void close()
  {
    try
    {
      boolean bool = this.a;
      if (bool) {}
      do
      {
        return;
        this.a = true;
      } while (this.c.size() >= this.b);
      throw new ProtocolException("content-length promised " + this.b + " bytes, but received " + this.c.size());
    }
    finally {}
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      a();
      q.a(paramArrayOfByte.length, paramInt1, paramInt2);
      if ((this.b != -1) && (this.c.size() > this.b - paramInt2)) {
        throw new ProtocolException("exceeded content-length limit of " + this.b + " bytes");
      }
    }
    finally {}
    this.c.write(paramArrayOfByte, paramInt1, paramInt2);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/e/a/b/a/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */