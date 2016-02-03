package com.google.android.gms.internal;

import android.os.Bundle;

public class ek
{
  private final Object ls = new Object();
  private final eh rD;
  private final String rG;
  private int sc;
  private int sd;
  
  ek(eh parameh, String paramString)
  {
    this.rD = parameh;
    this.rG = paramString;
  }
  
  public ek(String paramString)
  {
    this(eh.bH(), paramString);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    synchronized (this.ls)
    {
      this.sc = paramInt1;
      this.sd = paramInt2;
      this.rD.a(this.rG, this);
      return;
    }
  }
  
  public Bundle toBundle()
  {
    synchronized (this.ls)
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("pmnli", this.sc);
      localBundle.putInt("pmnll", this.sd);
      return localBundle;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/ek.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */