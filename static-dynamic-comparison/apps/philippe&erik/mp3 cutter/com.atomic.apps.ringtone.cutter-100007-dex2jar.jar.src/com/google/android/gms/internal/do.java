package com.google.android.gms.internal;

import java.io.IOException;

class do
{
  private di a;
  private byte[] b;
  private final int c = 239;
  
  public do(int paramInt)
  {
    a();
  }
  
  public void a()
  {
    this.b = new byte[this.c];
    this.a = di.a(this.b);
  }
  
  public void a(int paramInt, long paramLong)
  {
    di localdi = this.a;
    localdi.a(paramInt, 0);
    for (;;)
    {
      if ((0xFFFFFFFFFFFFFF80 & paramLong) == 0L)
      {
        localdi.a((int)paramLong);
        return;
      }
      localdi.a((int)paramLong & 0x7F | 0x80);
      paramLong >>>= 7;
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    this.a.a(paramInt, paramString);
  }
  
  public byte[] b()
  {
    int i = this.a.a();
    if (i < 0) {
      throw new IOException();
    }
    if (i == 0) {
      return this.b;
    }
    byte[] arrayOfByte = new byte[this.b.length - i];
    System.arraycopy(this.b, 0, arrayOfByte, 0, arrayOfByte.length);
    return arrayOfByte;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/mp3 cutter/com.atomic.apps.ringtone.cutter-100007-dex2jar.jar!/com/google/android/gms/internal/do.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */