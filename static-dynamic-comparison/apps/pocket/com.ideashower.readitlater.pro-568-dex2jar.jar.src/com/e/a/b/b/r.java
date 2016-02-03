package com.e.a.b.b;

import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;

final class r
  extends InputStream
{
  private final byte[] c = new byte[65536];
  private int d = -1;
  private int e;
  private boolean f;
  private boolean g;
  private int h = 0;
  
  static
  {
    if (!q.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      return;
    }
  }
  
  private r(q paramq) {}
  
  private void a()
  {
    long l2;
    long l1;
    if (q.c(this.b) != 0L)
    {
      l2 = System.nanoTime() / 1000000L;
      l1 = q.c(this.b);
    }
    for (;;)
    {
      try
      {
        if ((this.d != -1) || (this.g) || (this.f) || (q.d(this.b) != null)) {
          break label135;
        }
        if (q.c(this.b) == 0L)
        {
          this.b.wait();
          continue;
        }
        if (l1 <= 0L) {
          break label127;
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        throw new InterruptedIOException();
      }
      this.b.wait(l1);
      l1 = q.c(this.b) + l2 - System.nanoTime() / 1000000L;
      continue;
      label127:
      throw new SocketTimeoutException();
      label135:
      return;
      l1 = 0L;
      l2 = 0L;
    }
  }
  
  private void b()
  {
    if (this.f) {
      throw new IOException("stream closed");
    }
    if (q.d(this.b) != null) {
      throw new IOException("stream was reset: " + q.d(this.b));
    }
  }
  
  void a(InputStream arg1, int paramInt)
  {
    int k = 0;
    if ((!a) && (Thread.holdsLock(this.b))) {
      throw new AssertionError();
    }
    if (paramInt == 0) {
      return;
    }
    boolean bool;
    int i1;
    int n;
    int m;
    synchronized (this.b)
    {
      bool = this.g;
      i1 = this.d;
      n = this.e;
      m = this.e;
      if (paramInt > this.c.length - available())
      {
        i = 1;
        if (i != 0)
        {
          com.e.a.b.q.a(???, paramInt);
          this.b.b(a.h);
        }
      }
      else
      {
        i = 0;
      }
    }
    if (bool)
    {
      com.e.a.b.q.a(???, paramInt);
      return;
    }
    int j = m;
    int i = paramInt;
    if (i1 < m)
    {
      i = Math.min(paramInt, this.c.length - m);
      com.e.a.b.q.a(???, this.c, m, i);
      m += i;
      paramInt -= i;
      j = m;
      i = paramInt;
      if (m == this.c.length) {
        i = paramInt;
      }
    }
    for (paramInt = k;; paramInt = j)
    {
      j = paramInt;
      if (i > 0)
      {
        com.e.a.b.q.a(???, this.c, paramInt, i);
        j = paramInt + i;
      }
      synchronized (this.b)
      {
        this.e = j;
        if (this.d == -1)
        {
          this.d = n;
          this.b.notifyAll();
        }
        return;
      }
    }
  }
  
  public int available()
  {
    synchronized (this.b)
    {
      b();
      if (this.d == -1) {
        return 0;
      }
      if (this.e > this.d)
      {
        i = this.e;
        j = this.d;
        return i - j;
      }
    }
    int i = this.e;
    int j = this.c.length;
    int k = this.d;
    return i + (j - k);
  }
  
  public void close()
  {
    synchronized (this.b)
    {
      this.f = true;
      this.b.notifyAll();
      q.e(this.b);
      return;
    }
  }
  
  public int read()
  {
    return com.e.a.b.q.a(this);
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    for (;;)
    {
      synchronized (this.b)
      {
        com.e.a.b.q.a(paramArrayOfByte.length, paramInt1, paramInt2);
        a();
        b();
        if (this.d == -1) {
          return -1;
        }
        if (this.e <= this.d)
        {
          i = Math.min(paramInt2, this.c.length - this.d);
          System.arraycopy(this.c, this.d, paramArrayOfByte, paramInt1, i);
          this.d += i;
          int j = i + 0;
          i = j;
          if (this.d == this.c.length)
          {
            this.d = 0;
            i = j;
          }
          j = i;
          if (i < paramInt2)
          {
            paramInt2 = Math.min(this.e - this.d, paramInt2 - i);
            System.arraycopy(this.c, this.d, paramArrayOfByte, paramInt1 + i, paramInt2);
            this.d += paramInt2;
            j = i + paramInt2;
          }
          this.h += j;
          if (this.h >= 32768)
          {
            q.b(this.b).a(q.a(this.b), this.h);
            this.h = 0;
          }
          if (this.d == this.e)
          {
            this.d = -1;
            this.e = 0;
          }
          return j;
        }
      }
      int i = 0;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/e/a/b/b/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */