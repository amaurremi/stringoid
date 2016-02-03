package com.google.android.gms.internal;

import android.os.Bundle;

public class el
{
  private final Object lq = new Object();
  private final ei rA;
  private final String rD;
  private int rZ;
  private int sa;
  
  el(ei paramei, String paramString)
  {
    this.rA = paramei;
    this.rD = paramString;
  }
  
  public el(String paramString)
  {
    this(ei.bC(), paramString);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    synchronized (this.lq)
    {
      this.rZ = paramInt1;
      this.sa = paramInt2;
      this.rA.a(this.rD, this);
      return;
    }
  }
  
  public Bundle toBundle()
  {
    synchronized (this.lq)
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("pmnli", this.rZ);
      localBundle.putInt("pmnll", this.sa);
      return localBundle;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/el.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */