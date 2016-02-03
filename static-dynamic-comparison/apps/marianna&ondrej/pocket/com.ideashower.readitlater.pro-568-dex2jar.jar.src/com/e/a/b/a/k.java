package com.e.a.b.a;

import com.e.a.b.a;
import com.e.a.b.q;
import java.io.OutputStream;
import java.net.ProtocolException;

final class k
  extends a
{
  private final OutputStream b;
  private long c;
  
  private k(OutputStream paramOutputStream, long paramLong)
  {
    this.b = paramOutputStream;
    this.c = paramLong;
  }
  
  public void close()
  {
    if (this.a) {}
    do
    {
      return;
      this.a = true;
    } while (this.c <= 0L);
    throw new ProtocolException("unexpected end of stream");
  }
  
  public void flush()
  {
    if (this.a) {
      return;
    }
    this.b.flush();
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    a();
    q.a(paramArrayOfByte.length, paramInt1, paramInt2);
    if (paramInt2 > this.c) {
      throw new ProtocolException("expected " + this.c + " bytes but received " + paramInt2);
    }
    this.b.write(paramArrayOfByte, paramInt1, paramInt2);
    this.c -= paramInt2;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/e/a/b/a/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */