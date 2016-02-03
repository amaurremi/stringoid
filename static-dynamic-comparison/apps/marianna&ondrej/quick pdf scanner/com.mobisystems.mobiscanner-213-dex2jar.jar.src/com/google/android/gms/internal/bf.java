package com.google.android.gms.internal;

import java.util.Map;

public final class bf
{
  private dd CB;
  private String DZ;
  private String Ea;
  public final s Eb = new s()
  {
    public void a(dd arg1, Map<String, String> paramAnonymousMap)
    {
      synchronized (bf.a(bf.this))
      {
        String str = (String)paramAnonymousMap.get("type");
        paramAnonymousMap = (String)paramAnonymousMap.get("errors");
        ce.D("Invalid " + str + " request error: " + paramAnonymousMap);
        bf.a(bf.this, 1);
        bf.a(bf.this).notify();
        return;
      }
    }
  };
  public final s Ec = new s()
  {
    public void a(dd paramAnonymousdd, Map<String, String> paramAnonymousMap)
    {
      synchronized (bf.a(bf.this))
      {
        String str2 = (String)paramAnonymousMap.get("url");
        if (str2 == null)
        {
          ce.D("URL missing in loadAdUrl GMSG.");
          return;
        }
        String str1 = str2;
        if (str2.contains("%40mediation_adapters%40"))
        {
          str1 = str2.replaceAll("%40mediation_adapters%40", bp.c(paramAnonymousdd.getContext(), (String)paramAnonymousMap.get("check_adapters"), bf.b(bf.this)));
          ce.C("Ad request URL modified to " + str1);
        }
        bf.a(bf.this, str1);
        bf.a(bf.this).notify();
        return;
      }
    }
  };
  private int nX = -2;
  private final Object xV = new Object();
  
  public bf(String paramString)
  {
    this.DZ = paramString;
  }
  
  public void b(dd paramdd)
  {
    synchronized (this.xV)
    {
      this.CB = paramdd;
      return;
    }
  }
  
  public int getErrorCode()
  {
    synchronized (this.xV)
    {
      int i = this.nX;
      return i;
    }
  }
  
  public String pC()
  {
    synchronized (this.xV)
    {
      while (this.Ea == null)
      {
        int i = this.nX;
        if (i == -2) {
          try
          {
            this.xV.wait();
          }
          catch (InterruptedException localInterruptedException)
          {
            ce.D("Ad request service was interrupted.");
            return null;
          }
        }
      }
      String str = this.Ea;
      return str;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/internal/bf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */