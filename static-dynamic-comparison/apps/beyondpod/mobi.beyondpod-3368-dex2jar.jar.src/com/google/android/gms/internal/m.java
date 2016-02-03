package com.google.android.gms.internal;

import java.io.IOException;

class m
  implements k
{
  private ix dR;
  private byte[] dS;
  private final int dT;
  
  public m(int paramInt)
  {
    this.dT = paramInt;
    reset();
  }
  
  public void b(int paramInt, long paramLong)
    throws IOException
  {
    this.dR.b(paramInt, paramLong);
  }
  
  public void b(int paramInt, String paramString)
    throws IOException
  {
    this.dR.b(paramInt, paramString);
  }
  
  public byte[] h()
    throws IOException
  {
    int i = this.dR.ge();
    if (i < 0) {
      throw new IOException();
    }
    if (i == 0) {
      return this.dS;
    }
    byte[] arrayOfByte = new byte[this.dS.length - i];
    System.arraycopy(this.dS, 0, arrayOfByte, 0, arrayOfByte.length);
    return arrayOfByte;
  }
  
  public void reset()
  {
    this.dS = new byte[this.dT];
    this.dR = ix.i(this.dS);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/internal/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */