package com.google.android.gms.internal;

public final class bp
  extends bw.a
{
  private final Object lq = new Object();
  private br.a ny;
  private bo nz;
  
  public void a(bo parambo)
  {
    synchronized (this.lq)
    {
      this.nz = parambo;
      return;
    }
  }
  
  public void a(br.a parama)
  {
    synchronized (this.lq)
    {
      this.ny = parama;
      return;
    }
  }
  
  public void onAdClicked()
  {
    synchronized (this.lq)
    {
      if (this.nz != null) {
        this.nz.W();
      }
      return;
    }
  }
  
  public void onAdClosed()
  {
    synchronized (this.lq)
    {
      if (this.nz != null) {
        this.nz.X();
      }
      return;
    }
  }
  
  public void onAdFailedToLoad(int paramInt)
  {
    for (;;)
    {
      synchronized (this.lq)
      {
        if (this.ny != null)
        {
          if (paramInt == 3)
          {
            paramInt = 1;
            this.ny.g(paramInt);
            this.ny = null;
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
    synchronized (this.lq)
    {
      if (this.nz != null) {
        this.nz.Y();
      }
      return;
    }
  }
  
  public void onAdLoaded()
  {
    synchronized (this.lq)
    {
      if (this.ny != null)
      {
        this.ny.g(0);
        this.ny = null;
        return;
      }
      if (this.nz != null) {
        this.nz.aa();
      }
      return;
    }
  }
  
  public void onAdOpened()
  {
    synchronized (this.lq)
    {
      if (this.nz != null) {
        this.nz.Z();
      }
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/bp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */