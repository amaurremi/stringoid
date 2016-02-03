package com.google.android.gms.internal;

public final class ad
  extends ak.a
{
  private af.a BX;
  private ac BY;
  private final Object xV = new Object();
  
  public void a(ac paramac)
  {
    synchronized (this.xV)
    {
      this.BY = paramac;
      return;
    }
  }
  
  public void a(af.a parama)
  {
    synchronized (this.xV)
    {
      this.BX = parama;
      return;
    }
  }
  
  public void ba(int paramInt)
  {
    for (;;)
    {
      synchronized (this.xV)
      {
        if (this.BX != null)
        {
          if (paramInt == 3)
          {
            paramInt = 1;
            this.BX.cu(paramInt);
            this.BX = null;
          }
        }
        else {
          return;
        }
      }
      paramInt = 2;
    }
  }
  
  public void ko()
  {
    synchronized (this.xV)
    {
      if (this.BY != null) {
        this.BY.pc();
      }
      return;
    }
  }
  
  public void kp()
  {
    synchronized (this.xV)
    {
      if (this.BY != null) {
        this.BY.pd();
      }
      return;
    }
  }
  
  public void kq()
  {
    synchronized (this.xV)
    {
      if (this.BY != null) {
        this.BY.pe();
      }
      return;
    }
  }
  
  public void kr()
  {
    synchronized (this.xV)
    {
      if (this.BX != null)
      {
        this.BX.cu(0);
        this.BX = null;
        return;
      }
      if (this.BY != null) {
        this.BY.pf();
      }
      return;
    }
  }
  
  public void pg()
  {
    synchronized (this.xV)
    {
      if (this.BY != null) {
        this.BY.pb();
      }
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/internal/ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */