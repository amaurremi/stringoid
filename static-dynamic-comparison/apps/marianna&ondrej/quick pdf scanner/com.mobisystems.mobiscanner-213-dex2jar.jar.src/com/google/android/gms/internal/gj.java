package com.google.android.gms.internal;

import java.io.IOException;

public abstract class gj
{
  protected int tX = -1;
  
  public static final void a(gj paramgj, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      paramArrayOfByte = jz.b(paramArrayOfByte, paramInt1, paramInt2);
      paramgj.a(paramArrayOfByte);
      paramArrayOfByte.tz();
      return;
    }
    catch (IOException paramgj)
    {
      throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", paramgj);
    }
  }
  
  public static final byte[] c(gj paramgj)
  {
    byte[] arrayOfByte = new byte[paramgj.nq()];
    a(paramgj, arrayOfByte, 0, arrayOfByte.length);
    return arrayOfByte;
  }
  
  public void a(jz paramjz) {}
  
  public int np()
  {
    if (this.tX < 0) {
      nq();
    }
    return this.tX;
  }
  
  public int nq()
  {
    this.tX = 0;
    return 0;
  }
  
  public String toString()
  {
    return gk.d(this);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/internal/gj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */