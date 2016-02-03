package com.google.ads;

import java.io.IOException;
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
    throws IOException
  {
    if (this.e == null) {
      throw new a();
    }
    this.e.write(this.a, 0, this.c);
    this.c = 0;
  }
  
  public void a()
    throws IOException
  {
    if (this.e != null) {
      b();
    }
  }
  
  public void a(byte paramByte)
    throws IOException
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
    throws IOException
  {
    a((byte)paramInt);
  }
  
  public void a(int paramInt1, int paramInt2)
    throws IOException
  {
    b(av.a(paramInt1, paramInt2));
  }
  
  public void a(int paramInt, long paramLong)
    throws IOException
  {
    a(paramInt, 0);
    a(paramLong);
  }
  
  public void a(int paramInt, String paramString)
    throws IOException
  {
    a(paramInt, 2);
    a(paramString);
  }
  
  public void a(long paramLong)
    throws IOException
  {
    b(paramLong);
  }
  
  public void a(String paramString)
    throws IOException
  {
    paramString = paramString.getBytes("UTF-8");
    b(paramString.length);
    a(paramString);
  }
  
  public void a(byte[] paramArrayOfByte)
    throws IOException
  {
    a(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
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
    throws IOException
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
    throws IOException
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
  
  public static class a
    extends IOException
  {
    a()
    {
      super();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/rage meme camera free/com.troll.face-25-dex2jar.jar!/com/google/ads/au.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */