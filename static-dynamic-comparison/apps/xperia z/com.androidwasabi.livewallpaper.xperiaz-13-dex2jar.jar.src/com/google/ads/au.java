package com.google.ads;

import java.io.OutputStream;

public final class au
{
  private final byte[] a;
  private final int b;
  private int c;
  private int d = 0;
  private final OutputStream e;
  
  private au(OutputStream paramOutputStream, byte[] paramArrayOfByte)
  {
    this.e = paramOutputStream;
    this.a = paramArrayOfByte;
    this.c = 0;
    this.b = paramArrayOfByte.length;
  }
  
  public static au a(OutputStream paramOutputStream)
  {
    return a(paramOutputStream, 4096);
  }
  
  public static au a(OutputStream paramOutputStream, int paramInt)
  {
    return new au(paramOutputStream, new byte[paramInt]);
  }
  
  private void b()
  {
    if (this.e == null) {
      throw new au.a();
    }
    this.e.write(this.a, 0, this.c);
    this.c = 0;
  }
  
  public void a()
  {
    if (this.e != null) {
      b();
    }
  }
  
  public void a(byte paramByte)
  {
    if (this.c == this.b) {
      b();
    }
    byte[] arrayOfByte = this.a;
    int i = this.c;
    this.c = (i + 1);
    arrayOfByte[i] = paramByte;
    this.d += 1;
  }
  
  public void a(int paramInt)
  {
    a((byte)paramInt);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    b(av.a(paramInt1, paramInt2));
  }
  
  public void a(int paramInt, long paramLong)
  {
    a(paramInt, 0);
    a(paramLong);
  }
  
  public void a(int paramInt, String paramString)
  {
    a(paramInt, 2);
    a(paramString);
  }
  
  public void a(long paramLong)
  {
    b(paramLong);
  }
  
  public void a(String paramString)
  {
    paramString = paramString.getBytes("UTF-8");
    b(paramString.length);
    a(paramString);
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    a(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (this.b - this.c >= paramInt2)
    {
      System.arraycopy(paramArrayOfByte, paramInt1, this.a, this.c, paramInt2);
      this.c += paramInt2;
      this.d += paramInt2;
      return;
    }
    int i = this.b - this.c;
    System.arraycopy(paramArrayOfByte, paramInt1, this.a, this.c, i);
    paramInt1 += i;
    paramInt2 -= i;
    this.c = this.b;
    this.d = (i + this.d);
    b();
    if (paramInt2 <= this.b)
    {
      System.arraycopy(paramArrayOfByte, paramInt1, this.a, 0, paramInt2);
      this.c = paramInt2;
    }
    for (;;)
    {
      this.d += paramInt2;
      return;
      this.e.write(paramArrayOfByte, paramInt1, paramInt2);
    }
  }
  
  public void b(int paramInt)
  {
    for (;;)
    {
      if ((paramInt & 0xFFFFFF80) == 0)
      {
        a(paramInt);
        return;
      }
      a(paramInt & 0x7F | 0x80);
      paramInt >>>= 7;
    }
  }
  
  public void b(long paramLong)
  {
    for (;;)
    {
      if ((0xFFFFFFFFFFFFFF80 & paramLong) == 0L)
      {
        a((int)paramLong);
        return;
      }
      a((int)paramLong & 0x7F | 0x80);
      paramLong >>>= 7;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/google/ads/au.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */