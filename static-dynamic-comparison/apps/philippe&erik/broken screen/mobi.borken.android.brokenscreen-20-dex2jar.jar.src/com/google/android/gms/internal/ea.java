package com.google.android.gms.internal;

import java.util.Map;

public final class ea
{
  private ey lL;
  private final Object lq = new Object();
  private int pH = -2;
  public final bd qA = new bd()
  {
    public void b(ey arg1, Map<String, String> paramAnonymousMap)
    {
      synchronized (ea.a(ea.this))
      {
        paramAnonymousMap = new ec(paramAnonymousMap);
        ev.D("Invalid " + paramAnonymousMap.getType() + " request error: " + paramAnonymousMap.bt());
        ea.a(ea.this, 1);
        ea.a(ea.this).notify();
        return;
      }
    }
  };
  public final bd qB = new bd()
  {
    public void b(ey paramAnonymousey, Map<String, String> paramAnonymousMap)
    {
      synchronized (ea.a(ea.this))
      {
        ec localec = new ec(paramAnonymousMap);
        String str = localec.getUrl();
        if (str == null)
        {
          ev.D("URL missing in loadAdUrl GMSG.");
          return;
        }
        if (str.contains("%40mediation_adapters%40"))
        {
          paramAnonymousey = str.replaceAll("%40mediation_adapters%40", em.a(paramAnonymousey.getContext(), (String)paramAnonymousMap.get("check_adapters"), ea.b(ea.this)));
          ev.C("Ad request URL modified to " + paramAnonymousey);
        }
        ea.a(ea.this, localec);
        ea.a(ea.this).notify();
        return;
      }
    }
  };
  private String qy;
  private ec qz;
  
  public ea(String paramString)
  {
    this.qy = paramString;
  }
  
  public void b(ey paramey)
  {
    synchronized (this.lq)
    {
      this.lL = paramey;
      return;
    }
  }
  
  public ec bs()
  {
    synchronized (this.lq)
    {
      while (this.qz == null)
      {
        int i = this.pH;
        if (i == -2) {
          try
          {
            this.lq.wait();
          }
          catch (InterruptedException localInterruptedException)
          {
            ev.D("Ad request service was interrupted.");
            return null;
          }
        }
      }
      ec localec = this.qz;
      return localec;
    }
  }
  
  public int getErrorCode()
  {
    synchronized (this.lq)
    {
      int i = this.pH;
      return i;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/ea.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */