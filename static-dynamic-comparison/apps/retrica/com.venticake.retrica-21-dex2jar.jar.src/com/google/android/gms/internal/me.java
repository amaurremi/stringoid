package com.google.android.gms.internal;

import java.io.IOException;

public abstract class me
{
  protected volatile int anb = -1;
  
  public static final <T extends me> T a(T paramT, byte[] paramArrayOfByte)
  {
    return b(paramT, paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static final void a(me paramme, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      paramArrayOfByte = lz.b(paramArrayOfByte, paramInt1, paramInt2);
      paramme.a(paramArrayOfByte);
      paramArrayOfByte.nR();
      return;
    }
    catch (IOException paramme)
    {
      throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", paramme);
    }
  }
  
  public static final <T extends me> T b(T paramT, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      paramArrayOfByte = ly.a(paramArrayOfByte, paramInt1, paramInt2);
      paramT.b(paramArrayOfByte);
      paramArrayOfByte.eu(0);
      return paramT;
    }
    catch (md paramT)
    {
      throw paramT;
    }
    catch (IOException paramT)
    {
      throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).");
    }
  }
  
  public static final byte[] d(me paramme)
  {
    byte[] arrayOfByte = new byte[paramme.oa()];
    a(paramme, arrayOfByte, 0, arrayOfByte.length);
    return arrayOfByte;
  }
  
  public void a(lz paramlz) {}
  
  public abstract me b(ly paramly);
  
  protected int c()
  {
    return 0;
  }
  
  public int nZ()
  {
    if (this.anb < 0) {
      oa();
    }
    return this.anb;
  }
  
  public int oa()
  {
    int i = c();
    this.anb = i;
    return i;
  }
  
  public String toString()
  {
    return mf.e(this);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/me.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */