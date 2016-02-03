package com.flurry.android.monolithic.sdk.impl;

import java.io.EOFException;
import java.io.IOException;

class lo
  extends lp
{
  private byte[] b;
  private int c;
  private int d;
  private boolean e = false;
  
  private lo(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if ((paramArrayOfByte.length < 16) || (paramInt2 < 16))
    {
      this.b = new byte[16];
      System.arraycopy(paramArrayOfByte, paramInt1, this.b, 0, paramInt2);
      this.c = 0;
      this.d = paramInt2;
      return;
    }
    this.b = paramArrayOfByte;
    this.c = paramInt1;
    this.d = (paramInt1 + paramInt2);
  }
  
  protected void a(int paramInt, ll paramll)
  {
    ll.a(paramll, this.b);
    ll.a(paramll, this.c);
    ll.c(paramll, this.c);
    ll.b(paramll, this.d);
    this.a = new ln(paramll, null);
  }
  
  protected void a(long paramLong)
    throws IOException
  {
    if (b(paramLong) < paramLong) {
      throw new EOFException();
    }
  }
  
  protected void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    if (b(paramArrayOfByte, paramInt1, paramInt2) < paramInt2) {
      throw new EOFException();
    }
  }
  
  protected void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
    throws IOException
  {
    if (!this.e)
    {
      byte[] arrayOfByte = new byte[paramInt3 + 16];
      System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, 0, paramInt3);
      this.a.a(arrayOfByte, 0, paramInt3);
      this.e = true;
    }
  }
  
  protected int b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    return 0;
  }
  
  protected long b(long paramLong)
    throws IOException
  {
    this.d = this.a.c();
    this.c = this.a.b();
    long l = this.d - this.c;
    if (l >= paramLong)
    {
      this.c = ((int)(this.c + paramLong));
      this.a.a(this.c);
      return paramLong;
    }
    this.c = ((int)(this.c + l));
    this.a.a(this.c);
    return l;
  }
  
  public void close()
    throws IOException
  {
    this.a.a(this.a.c());
  }
  
  public int read()
    throws IOException
  {
    this.d = this.a.c();
    this.c = this.a.b();
    if (this.c >= this.d) {
      return -1;
    }
    byte[] arrayOfByte = this.a.d();
    int i = this.c;
    this.c = (i + 1);
    i = arrayOfByte[i];
    this.a.a(this.c);
    return i & 0xFF;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/lo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */