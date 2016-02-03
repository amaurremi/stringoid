package com.google.android.gms.internal;

public final class aw
  extends bd.a
{
  private ay.a fP;
  private av fQ;
  private final Object fx = new Object();
  
  public void a(av paramav)
  {
    synchronized (this.fx)
    {
      this.fQ = paramav;
      return;
    }
  }
  
  public void a(ay.a parama)
  {
    synchronized (this.fx)
    {
      this.fP = parama;
      return;
    }
  }
  
  public void onAdClosed()
  {
    synchronized (this.fx)
    {
      if (this.fQ != null) {
        this.fQ.D();
      }
      return;
    }
  }
  
  public void onAdFailedToLoad(int paramInt)
  {
    for (;;)
    {
      synchronized (this.fx)
      {
        if (this.fP != null)
        {
          if (paramInt == 3)
          {
            paramInt = 1;
            this.fP.f(paramInt);
            this.fP = null;
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
    synchronized (this.fx)
    {
      if (this.fQ != null) {
        this.fQ.E();
      }
      return;
    }
  }
  
  public void onAdLoaded()
  {
    synchronized (this.fx)
    {
      if (this.fP != null)
      {
        this.fP.f(0);
        this.fP = null;
        return;
      }
      if (this.fQ != null) {
        this.fQ.G();
      }
      return;
    }
  }
  
  public void onAdOpened()
  {
    synchronized (this.fx)
    {
      if (this.fQ != null) {
        this.fQ.F();
      }
      return;
    }
  }
  
  public void w()
  {
    synchronized (this.fx)
    {
      if (this.fQ != null) {
        this.fQ.C();
      }
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/internal/aw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */