package com.google.android.gms.internal;

import java.io.IOException;

class gq
  implements gp
{
  private jz Tq;
  private byte[] Tr;
  private final int Ts;
  
  public gq(int paramInt)
  {
    this.Ts = paramInt;
    reset();
  }
  
  public void b(int paramInt, long paramLong)
  {
    this.Tq.b(paramInt, paramLong);
  }
  
  public void b(int paramInt, String paramString)
  {
    this.Tq.b(paramInt, paramString);
  }
  
  public void reset()
  {
    this.Tr = new byte[this.Ts];
    this.Tq = jz.e(this.Tr);
  }
  
  public byte[] tB()
  {
    int i = this.Tq.ty();
    if (i < 0) {
      throw new IOException();
    }
    if (i == 0) {
      return this.Tr;
    }
    byte[] arrayOfByte = new byte[this.Tr.length - i];
    System.arraycopy(this.Tr, 0, arrayOfByte, 0, arrayOfByte.length);
    return arrayOfByte;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/internal/gq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */