package com.google.android.gms.analytics;

class at
  implements k.a<au>
{
  private final au a = new au();
  
  public au a()
  {
    return this.a;
  }
  
  public void a(String paramString, int paramInt)
  {
    if ("ga_dispatchPeriod".equals(paramString))
    {
      this.a.d = paramInt;
      return;
    }
    aa.D("int configuration name not recognized:  " + paramString);
  }
  
  public void c(String paramString1, String paramString2) {}
  
  public void c(String paramString, boolean paramBoolean)
  {
    if ("ga_dryRun".equals(paramString))
    {
      paramString = this.a;
      if (paramBoolean) {}
      for (int i = 1;; i = 0)
      {
        paramString.e = i;
        return;
      }
    }
    aa.D("bool configuration name not recognized:  " + paramString);
  }
  
  public void d(String paramString1, String paramString2)
  {
    if ("ga_appName".equals(paramString1))
    {
      this.a.a = paramString2;
      return;
    }
    if ("ga_appVersion".equals(paramString1))
    {
      this.a.b = paramString2;
      return;
    }
    if ("ga_logLevel".equals(paramString1))
    {
      this.a.c = paramString2;
      return;
    }
    aa.D("string configuration name not recognized:  " + paramString1);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/analytics/at.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */