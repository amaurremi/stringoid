package com.google.android.gms.internal;

import android.os.Bundle;

public class bm
{
  private final String EO;
  private int Fi;
  private int Fj;
  private final Object xV = new Object();
  
  public bm(String paramString)
  {
    this.EO = paramString;
  }
  
  public void q(int paramInt1, int paramInt2)
  {
    synchronized (this.xV)
    {
      this.Fi = paramInt1;
      this.Fj = paramInt2;
      bk.a(this.EO, this);
      return;
    }
  }
  
  public Bundle toBundle()
  {
    synchronized (this.xV)
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("pmnli", this.Fi);
      localBundle.putInt("pmnll", this.Fj);
      return localBundle;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/internal/bm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */