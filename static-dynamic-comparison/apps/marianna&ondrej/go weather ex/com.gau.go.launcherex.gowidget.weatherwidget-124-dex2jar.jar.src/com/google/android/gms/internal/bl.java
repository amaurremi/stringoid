package com.google.android.gms.internal;

public final class bl
  extends bs.a
{
  private final Object li = new Object();
  private bn.a nl;
  private bk nm;
  
  public void P()
  {
    synchronized (this.li)
    {
      if (this.nm != null) {
        this.nm.X();
      }
      return;
    }
  }
  
  public void a(bk parambk)
  {
    synchronized (this.li)
    {
      this.nm = parambk;
      return;
    }
  }
  
  public void a(bn.a parama)
  {
    synchronized (this.li)
    {
      this.nl = parama;
      return;
    }
  }
  
  public void onAdClosed()
  {
    synchronized (this.li)
    {
      if (this.nm != null) {
        this.nm.Y();
      }
      return;
    }
  }
  
  public void onAdFailedToLoad(int paramInt)
  {
    for (;;)
    {
      synchronized (this.li)
      {
        if (this.nl != null)
        {
          if (paramInt == 3)
          {
            paramInt = 1;
            this.nl.f(paramInt);
            this.nl = null;
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
    synchronized (this.li)
    {
      if (this.nm != null) {
        this.nm.Z();
      }
      return;
    }
  }
  
  public void onAdLoaded()
  {
    synchronized (this.li)
    {
      if (this.nl != null)
      {
        this.nl.f(0);
        this.nl = null;
        return;
      }
      if (this.nm != null) {
        this.nm.ab();
      }
      return;
    }
  }
  
  public void onAdOpened()
  {
    synchronized (this.li)
    {
      if (this.nm != null) {
        this.nm.aa();
      }
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/internal/bl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */