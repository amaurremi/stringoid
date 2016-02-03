package com.google.android.gms.internal;

import java.util.Map;

public final class cg
{
  private final Object fx = new Object();
  private cw gv;
  private String hK;
  private String hL;
  public final an hM = new an()
  {
    public void a(cw arg1, Map<String, String> paramAnonymousMap)
    {
      synchronized (cg.a(cg.this))
      {
        String str = (String)paramAnonymousMap.get("type");
        paramAnonymousMap = (String)paramAnonymousMap.get("errors");
        ct.v("Invalid " + str + " request error: " + paramAnonymousMap);
        cg.a(cg.this, 1);
        cg.a(cg.this).notify();
        return;
      }
    }
  };
  public final an hN = new an()
  {
    public void a(cw paramAnonymouscw, Map<String, String> paramAnonymousMap)
    {
      synchronized (cg.a(cg.this))
      {
        String str2 = (String)paramAnonymousMap.get("url");
        if (str2 == null)
        {
          ct.v("URL missing in loadAdUrl GMSG.");
          return;
        }
        String str1 = str2;
        if (str2.contains("%40mediation_adapters%40"))
        {
          str1 = str2.replaceAll("%40mediation_adapters%40", cl.b(paramAnonymouscw.getContext(), (String)paramAnonymousMap.get("check_adapters"), cg.b(cg.this)));
          ct.u("Ad request URL modified to " + str1);
        }
        cg.a(cg.this, str1);
        cg.a(cg.this).notify();
        return;
      }
    }
  };
  private int hm = -2;
  
  public cg(String paramString)
  {
    this.hK = paramString;
  }
  
  public String ap()
  {
    synchronized (this.fx)
    {
      while (this.hL == null)
      {
        int i = this.hm;
        if (i == -2) {
          try
          {
            this.fx.wait();
          }
          catch (InterruptedException localInterruptedException)
          {
            ct.v("Ad request service was interrupted.");
            return null;
          }
        }
      }
      String str = this.hL;
      return str;
    }
  }
  
  public void b(cw paramcw)
  {
    synchronized (this.fx)
    {
      this.gv = paramcw;
      return;
    }
  }
  
  public int getErrorCode()
  {
    synchronized (this.fx)
    {
      int i = this.hm;
      return i;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/internal/cg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */