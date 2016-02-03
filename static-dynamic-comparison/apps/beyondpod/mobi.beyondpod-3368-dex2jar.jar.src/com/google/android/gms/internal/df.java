package com.google.android.gms.internal;

import java.io.IOException;

public abstract class df
{
  protected final dk lx;
  private final String ly;
  private dm lz;
  
  protected df(String paramString1, String paramString2)
  {
    this.ly = paramString1;
    this.lx = new dk(paramString2);
  }
  
  public void B(String paramString) {}
  
  public void a(long paramLong, int paramInt) {}
  
  public final void a(dm paramdm)
  {
    this.lz = paramdm;
    if (this.lz == null) {
      aT();
    }
  }
  
  protected final void a(String paramString1, long paramLong, String paramString2)
    throws IOException
  {
    this.lx.a("Sending text message: %s to: %s", new Object[] { paramString1, paramString2 });
    this.lz.a(this.ly, paramString1, paramLong, paramString2);
  }
  
  protected final long aS()
  {
    return this.lz.aR();
  }
  
  public void aT() {}
  
  public final String getNamespace()
  {
    return this.ly;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/internal/df.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */