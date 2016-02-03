package com.google.android.gms.internal;

import java.io.IOException;

public abstract class kt
{
  protected volatile int adY = -1;
  
  public static final <T extends kt> T a(T paramT, byte[] paramArrayOfByte)
    throws ks
  {
    return b(paramT, paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static final void a(kt paramkt, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      paramArrayOfByte = ko.b(paramArrayOfByte, paramInt1, paramInt2);
      paramkt.a(paramArrayOfByte);
      paramArrayOfByte.mw();
      return;
    }
    catch (IOException paramkt)
    {
      throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", paramkt);
    }
  }
  
  public static final <T extends kt> T b(T paramT, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws ks
  {
    try
    {
      paramArrayOfByte = kn.a(paramArrayOfByte, paramInt1, paramInt2);
      paramT.b(paramArrayOfByte);
      paramArrayOfByte.cP(0);
      return paramT;
    }
    catch (ks paramT)
    {
      throw paramT;
    }
    catch (IOException paramT)
    {
      throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).");
    }
  }
  
  public static final byte[] d(kt paramkt)
  {
    byte[] arrayOfByte = new byte[paramkt.c()];
    a(paramkt, arrayOfByte, 0, arrayOfByte.length);
    return arrayOfByte;
  }
  
  public void a(ko paramko)
    throws IOException
  {}
  
  public abstract kt b(kn paramkn)
    throws IOException;
  
  public int c()
  {
    int i = mx();
    this.adY = i;
    return i;
  }
  
  public int mF()
  {
    if (this.adY < 0) {
      c();
    }
    return this.adY;
  }
  
  protected int mx()
  {
    return 0;
  }
  
  public String toString()
  {
    return ku.e(this);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/internal/kt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */