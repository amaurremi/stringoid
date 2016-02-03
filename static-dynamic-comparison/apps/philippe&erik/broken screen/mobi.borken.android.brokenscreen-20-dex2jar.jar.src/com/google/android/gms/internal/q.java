package com.google.android.gms.internal;

import java.io.IOException;

class q
  implements o
{
  private ma kl;
  private byte[] km;
  private final int kn;
  
  public q(int paramInt)
  {
    this.kn = paramInt;
    reset();
  }
  
  public void b(int paramInt, long paramLong)
    throws IOException
  {
    this.kl.b(paramInt, paramLong);
  }
  
  public void b(int paramInt, String paramString)
    throws IOException
  {
    this.kl.b(paramInt, paramString);
  }
  
  public void reset()
  {
    this.km = new byte[this.kn];
    this.kl = ma.q(this.km);
  }
  
  public byte[] z()
    throws IOException
  {
    int i = this.kl.nL();
    if (i < 0) {
      throw new IOException();
    }
    if (i == 0) {
      return this.km;
    }
    byte[] arrayOfByte = new byte[this.km.length - i];
    System.arraycopy(this.km, 0, arrayOfByte, 0, arrayOfByte.length);
    return arrayOfByte;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */