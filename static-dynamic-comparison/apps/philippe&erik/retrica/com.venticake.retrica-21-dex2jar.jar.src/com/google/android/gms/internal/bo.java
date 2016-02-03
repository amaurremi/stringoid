package com.google.android.gms.internal;

public final class bo
  extends bv.a
{
  private final Object ls = new Object();
  private bq.a nA;
  private bn nB;
  
  public void a(bn parambn)
  {
    synchronized (this.ls)
    {
      this.nB = parambn;
      return;
    }
  }
  
  public void a(bq.a parama)
  {
    synchronized (this.ls)
    {
      this.nA = parama;
      return;
    }
  }
  
  public void onAdClicked()
  {
    synchronized (this.ls)
    {
      if (this.nB != null) {
        this.nB.ab();
      }
      return;
    }
  }
  
  public void onAdClosed()
  {
    synchronized (this.ls)
    {
      if (this.nB != null) {
        this.nB.ac();
      }
      return;
    }
  }
  
  public void onAdFailedToLoad(int paramInt)
  {
    for (;;)
    {
      synchronized (this.ls)
      {
        if (this.nA != null)
        {
          if (paramInt == 3)
          {
            paramInt = 1;
            this.nA.g(paramInt);
            this.nA = null;
          }
        }
        else {
          return;
        }
      }
      paramInt = 2;
    }
  }
  
  public void onAdLeftApplication()
  {
    synchronized (this.ls)
    {
      if (this.nB != null) {
        this.nB.ad();
      }
      return;
    }
  }
  
  public void onAdLoaded()
  {
    synchronized (this.ls)
    {
      if (this.nA != null)
      {
        this.nA.g(0);
        this.nA = null;
        return;
      }
      if (this.nB != null) {
        this.nB.af();
      }
      return;
    }
  }
  
  public void onAdOpened()
  {
    synchronized (this.ls)
    {
      if (this.nB != null) {
        this.nB.ae();
      }
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/bo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */