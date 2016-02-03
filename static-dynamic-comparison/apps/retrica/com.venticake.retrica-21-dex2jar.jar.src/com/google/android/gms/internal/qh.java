package com.google.android.gms.internal;

import java.io.IOException;

class qh
  implements qg
{
  private lz a;
  private byte[] b;
  private final int c;
  
  public qh(int paramInt)
  {
    this.c = paramInt;
    a();
  }
  
  public void a()
  {
    this.b = new byte[this.c];
    this.a = lz.q(this.b);
  }
  
  public void a(int paramInt, long paramLong)
  {
    this.a.b(paramInt, paramLong);
  }
  
  public void a(int paramInt, String paramString)
  {
    this.a.b(paramInt, paramString);
  }
  
  public byte[] b()
  {
    int i = this.a.nQ();
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/qh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */