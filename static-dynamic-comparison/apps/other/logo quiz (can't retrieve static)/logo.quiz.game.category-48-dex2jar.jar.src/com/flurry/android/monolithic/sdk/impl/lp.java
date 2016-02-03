package com.flurry.android.monolithic.sdk.impl;

import java.io.IOException;
import java.io.InputStream;

abstract class lp
  extends InputStream
{
  protected ln a;
  
  protected void a()
  {
    this.a.a();
  }
  
  protected void a(int paramInt, ll paramll)
  {
    ll.a(paramll, new byte[paramInt]);
    ll.a(paramll, 0);
    ll.c(paramll, 0);
    ll.b(paramll, 0);
    this.a = new ln(paramll, null);
  }
  
  protected abstract void a(long paramLong)
    throws IOException;
  
  protected abstract void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException;
  
  protected void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
    throws IOException
  {
    System.arraycopy(paramArrayOfByte, paramInt1, paramArrayOfByte, paramInt2, paramInt3);
    this.a.a(paramInt2);
    paramInt1 = b(paramArrayOfByte, paramInt2 + paramInt3, paramArrayOfByte.length - paramInt3);
    this.a.b(paramInt1 + paramInt3);
  }
  
  public int available()
    throws IOException
  {
    return this.a.c() - this.a.b();
  }
  
  protected abstract int b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException;
  
  protected abstract long b(long paramLong)
    throws IOException;
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    int j = this.a.c();
    int i = this.a.b();
    byte[] arrayOfByte = this.a.d();
    j -= i;
    if (j >= paramInt2)
    {
      System.arraycopy(arrayOfByte, i, paramArrayOfByte, paramInt1, paramInt2);
      this.a.a(i + paramInt2);
    }
    do
    {
      return paramInt2;
      System.arraycopy(arrayOfByte, i, paramArrayOfByte, paramInt1, j);
      this.a.a(i + j);
      paramInt1 = j + b(paramArrayOfByte, paramInt1 + j, paramInt2 - j);
      paramInt2 = paramInt1;
    } while (paramInt1 != 0);
    return -1;
  }
  
  public long skip(long paramLong)
    throws IOException
  {
    int i = this.a.c();
    int j = this.a.b();
    int k = i - j;
    if (k > paramLong)
    {
      i = (int)(j + paramLong);
      this.a.a(i);
      return paramLong;
    }
    this.a.a(i);
    return b(paramLong - k) + k;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/lp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */