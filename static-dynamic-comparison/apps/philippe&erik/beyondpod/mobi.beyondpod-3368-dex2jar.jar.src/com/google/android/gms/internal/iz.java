package com.google.android.gms.internal;

import java.io.IOException;

public abstract class iz
{
  protected int rw = -1;
  
  public static final <T extends iz> T a(T paramT, byte[] paramArrayOfByte)
    throws iy
  {
    return b(paramT, paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static final void a(iz paramiz, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      paramArrayOfByte = ix.b(paramArrayOfByte, paramInt1, paramInt2);
      paramiz.a(paramArrayOfByte);
      paramArrayOfByte.gf();
      return;
    }
    catch (IOException paramiz)
    {
      throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", paramiz);
    }
  }
  
  public static final byte[] a(iz paramiz)
  {
    byte[] arrayOfByte = new byte[paramiz.cP()];
    a(paramiz, arrayOfByte, 0, arrayOfByte.length);
    return arrayOfByte;
  }
  
  public static final <T extends iz> T b(T paramT, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws iy
  {
    try
    {
      paramArrayOfByte = iw.a(paramArrayOfByte, paramInt1, paramInt2);
      paramT.b(paramArrayOfByte);
      paramArrayOfByte.bI(0);
      return paramT;
    }
    catch (iy paramT)
    {
      throw paramT;
    }
    catch (IOException paramT)
    {
      throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).");
    }
  }
  
  public abstract void a(ix paramix)
    throws IOException;
  
  public abstract iz b(iw paramiw)
    throws IOException;
  
  public int cP()
  {
    this.rw = 0;
    return 0;
  }
  
  public String toString()
  {
    return ja.b(this);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/internal/iz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */