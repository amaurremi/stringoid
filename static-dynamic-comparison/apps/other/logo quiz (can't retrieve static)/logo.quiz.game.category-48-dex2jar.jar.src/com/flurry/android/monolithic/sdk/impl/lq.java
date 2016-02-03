package com.flurry.android.monolithic.sdk.impl;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

class lq
  extends lp
{
  protected boolean b = false;
  private InputStream c;
  
  private lq(InputStream paramInputStream)
  {
    this.c = paramInputStream;
  }
  
  protected void a(long paramLong)
    throws IOException
  {
    int i = 0;
    while (paramLong > 0L)
    {
      long l = this.c.skip(paramLong);
      if (l > 0L)
      {
        paramLong -= l;
      }
      else if (l == 0L)
      {
        if (i != 0)
        {
          this.b = true;
          throw new EOFException();
        }
        i = 1;
      }
      else
      {
        this.b = true;
        throw new EOFException();
      }
    }
  }
  
  protected void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    while (paramInt2 > 0)
    {
      int i = this.c.read(paramArrayOfByte, paramInt1, paramInt2);
      if (i < 0)
      {
        this.b = true;
        throw new EOFException();
      }
      paramInt2 -= i;
      paramInt1 += i;
    }
  }
  
  protected int b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    int i = paramInt2;
    for (;;)
    {
      if (i > 0) {}
      try
      {
        j = this.c.read(paramArrayOfByte, paramInt1, i);
        if (j >= 0) {
          break label36;
        }
        this.b = true;
      }
      catch (EOFException paramArrayOfByte)
      {
        for (;;)
        {
          int j;
          this.b = true;
        }
      }
      return paramInt2 - i;
      label36:
      i -= j;
      paramInt1 += j;
    }
  }
  
  protected long b(long paramLong)
    throws IOException
  {
    int i = 0;
    long l1 = paramLong;
    for (;;)
    {
      if (l1 > 0L)
      {
        try
        {
          long l2 = this.c.skip(paramLong);
          if (l2 > 0L)
          {
            l1 -= l2;
            continue;
          }
          if (l2 == 0L)
          {
            if (i == 0) {
              break label78;
            }
            this.b = true;
          }
          else
          {
            this.b = true;
          }
        }
        catch (EOFException localEOFException)
        {
          this.b = true;
        }
      }
      else
      {
        return paramLong - l1;
        label78:
        i = 1;
      }
    }
  }
  
  public void close()
    throws IOException
  {
    this.c.close();
  }
  
  public int read()
    throws IOException
  {
    if (this.a.c() - this.a.b() == 0) {
      return this.c.read();
    }
    int i = this.a.b();
    int j = this.a.d()[i];
    this.a.a(i + 1);
    return j & 0xFF;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/lq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */