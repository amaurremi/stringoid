package com.google.android.gms.analytics;

import android.content.Context;

class al
  extends ad<am>
{
  public al(Context paramContext)
  {
    super(paramContext, new a());
  }
  
  private static class a
    implements ad.a<am>
  {
    private final am pP = new am();
    
    public void b(String paramString, int paramInt)
    {
      if ("ga_dispatchPeriod".equals(paramString))
      {
        this.pP.pR = paramInt;
        return;
      }
      j.D("int configuration name not recognized:  " + paramString);
    }
    
    public void c(String paramString, boolean paramBoolean)
    {
      if ("ga_dryRun".equals(paramString))
      {
        paramString = this.pP;
        if (paramBoolean) {}
        for (int i = 1;; i = 0)
        {
          paramString.pS = i;
          return;
        }
      }
      j.D("bool configuration name not recognized:  " + paramString);
    }
    
    public void g(String paramString1, String paramString2) {}
    
    public void h(String paramString1, String paramString2)
    {
      if ("ga_appName".equals(paramString1))
      {
        this.pP.mp = paramString2;
        return;
      }
      if ("ga_appVersion".equals(paramString1))
      {
        this.pP.mo = paramString2;
        return;
      }
      if ("ga_logLevel".equals(paramString1))
      {
        this.pP.pQ = paramString2;
        return;
      }
      j.D("string configuration name not recognized:  " + paramString1);
    }
    
    public am lI()
    {
      return this.pP;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/analytics/al.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */