package com.google.android.gms.internal;

import java.util.Map;

public final class dz
{
  private ex lN;
  private final Object ls = new Object();
  private int pJ = -2;
  private String qB;
  private na qC;
  public final bc qD = new bc()
  {
    public void b(ex arg1, Map<String, String> paramAnonymousMap)
    {
      synchronized (dz.a(dz.this))
      {
        paramAnonymousMap = new na(paramAnonymousMap);
        eu.D("Invalid " + paramAnonymousMap.d() + " request error: " + paramAnonymousMap.a());
        dz.a(dz.this, 1);
        dz.a(dz.this).notify();
        return;
      }
    }
  };
  public final bc qE = new bc()
  {
    public void b(ex paramAnonymousex, Map<String, String> paramAnonymousMap)
    {
      synchronized (dz.a(dz.this))
      {
        na localna = new na(paramAnonymousMap);
        String str = localna.c();
        if (str == null)
        {
          eu.D("URL missing in loadAdUrl GMSG.");
          return;
        }
        if (str.contains("%40mediation_adapters%40"))
        {
          paramAnonymousex = str.replaceAll("%40mediation_adapters%40", el.a(paramAnonymousex.getContext(), (String)paramAnonymousMap.get("check_adapters"), dz.b(dz.this)));
          eu.C("Ad request URL modified to " + paramAnonymousex);
        }
        dz.a(dz.this, localna);
        dz.a(dz.this).notify();
        return;
      }
    }
  };
  
  public dz(String paramString)
  {
    this.qB = paramString;
  }
  
  public void b(ex paramex)
  {
    synchronized (this.ls)
    {
      this.lN = paramex;
      return;
    }
  }
  
  public na bx()
  {
    synchronized (this.ls)
    {
      while (this.qC == null)
      {
        int i = this.pJ;
        if (i == -2) {
          try
          {
            this.ls.wait();
          }
          catch (InterruptedException localInterruptedException)
          {
            eu.D("Ad request service was interrupted.");
            return null;
          }
        }
      }
      na localna = this.qC;
      return localna;
    }
  }
  
  public int getErrorCode()
  {
    synchronized (this.ls)
    {
      int i = this.pJ;
      return i;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/dz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */