package com.google.android.gms.analytics;

import java.util.Map;

class r
  implements k.a<s>
{
  private final s a = new s();
  
  public s a()
  {
    return this.a;
  }
  
  public void a(String paramString, int paramInt)
  {
    if ("ga_sessionTimeout".equals(paramString))
    {
      this.a.c = paramInt;
      return;
    }
    aa.D("int configuration name not recognized:  " + paramString);
  }
  
  public void c(String paramString1, String paramString2)
  {
    this.a.g.put(paramString1, paramString2);
  }
  
  public void c(String paramString, boolean paramBoolean)
  {
    int j = 1;
    int k = 1;
    int i = 1;
    if ("ga_autoActivityTracking".equals(paramString))
    {
      paramString = this.a;
      if (paramBoolean) {}
      for (;;)
      {
        paramString.d = i;
        return;
        i = 0;
      }
    }
    if ("ga_anonymizeIp".equals(paramString))
    {
      paramString = this.a;
      if (paramBoolean) {}
      for (i = j;; i = 0)
      {
        paramString.e = i;
        return;
      }
    }
    if ("ga_reportUncaughtExceptions".equals(paramString))
    {
      paramString = this.a;
      if (paramBoolean) {}
      for (i = k;; i = 0)
      {
        paramString.f = i;
        return;
      }
    }
    aa.D("bool configuration name not recognized:  " + paramString);
  }
  
  public void d(String paramString1, String paramString2)
  {
    if ("ga_trackingId".equals(paramString1))
    {
      this.a.a = paramString2;
      return;
    }
    if ("ga_sampleFrequency".equals(paramString1)) {
      try
      {
        this.a.b = Double.parseDouble(paramString2);
        return;
      }
      catch (NumberFormatException paramString1)
      {
        aa.A("Error parsing ga_sampleFrequency value: " + paramString2);
        return;
      }
    }
    aa.D("string configuration name not recognized:  " + paramString1);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/analytics/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */