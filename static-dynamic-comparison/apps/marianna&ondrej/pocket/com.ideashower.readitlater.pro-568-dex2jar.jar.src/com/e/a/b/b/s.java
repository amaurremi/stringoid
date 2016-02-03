package com.e.a.b.b;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.OutputStream;

final class s
  extends OutputStream
{
  private final byte[] c = new byte[' '];
  private int d = 0;
  private boolean e;
  private boolean f;
  private int g = 0;
  
  static
  {
    if (!q.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      return;
    }
  }
  
  private s(q paramq) {}
  
  private void a()
  {
    synchronized (this.b)
    {
      if (this.e) {
        throw new IOException("stream closed");
      }
    }
    if (this.f) {
      throw new IOException("stream finished");
    }
    if (q.d(this.b) != null) {
      throw new IOException("stream was reset: " + q.d(this.b));
    }
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    do
    {
      try
      {
        if (this.g + paramInt < q.g(this.b)) {
          break;
        }
        this.b.wait();
        if ((!paramBoolean) && (this.e)) {
          throw new IOException("stream closed");
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        throw new InterruptedIOException();
      }
      if (this.f) {
        throw new IOException("stream finished");
      }
    } while (q.d(this.b) == null);
    throw new IOException("stream was reset: " + q.d(this.b));
  }
  
  private void a(boolean paramBoolean)
  {
    if ((!a) && (Thread.holdsLock(this.b))) {
      throw new AssertionError();
    }
    int i = this.d;
    synchronized (this.b)
    {
      a(i, paramBoolean);
      this.g = (i + this.g);
      q.b(this.b).a(q.a(this.b), paramBoolean, this.c, 0, this.d);
      this.d = 0;
      return;
    }
  }
  
  public void close()
  {
    if ((!a) && (Thread.holdsLock(this.b))) {
      throw new AssertionError();
    }
    synchronized (this.b)
    {
      if (this.e) {
        return;
      }
      this.e = true;
      if (!q.f(this.b).f) {
        a(true);
      }
      q.b(this.b).c();
      q.e(this.b);
      return;
    }
  }
  
  public void flush()
  {
    if ((!a) && (Thread.holdsLock(this.b))) {
      throw new AssertionError();
    }
    a();
    if (this.d > 0)
    {
      a(false);
      q.b(this.b).c();
    }
  }
  
  public void write(int paramInt)
  {
    com.e.a.b.q.a(this, paramInt);
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if ((!a) && (Thread.holdsLock(this.b))) {
      throw new AssertionError();
    }
    com.e.a.b.q.a(paramArrayOfByte.length, paramInt1, paramInt2);
    a();
    while (paramInt2 > 0)
    {
      if (this.d == this.c.length) {
        a(false);
      }
      int i = Math.min(paramInt2, this.c.length - this.d);
      System.arraycopy(paramArrayOfByte, paramInt1, this.c, this.d, i);
      this.d += i;
      paramInt1 += i;
      paramInt2 -= i;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/e/a/b/b/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */