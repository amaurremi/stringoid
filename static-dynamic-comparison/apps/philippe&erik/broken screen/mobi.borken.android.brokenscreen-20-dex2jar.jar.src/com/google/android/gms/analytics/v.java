package com.google.android.gms.analytics;

import android.content.Context;

class v
  extends k<w>
{
  public v(Context paramContext)
  {
    super(paramContext, new a());
  }
  
  private static class a
    implements k.a<w>
  {
    private final w wf = new w();
    
    public void a(String paramString, int paramInt)
    {
      if ("ga_dispatchPeriod".equals(paramString))
      {
        this.wf.wh = paramInt;
        return;
      }
      aa.D("int configuration name not recognized:  " + paramString);
    }
    
    public void c(String paramString1, String paramString2) {}
    
    public void c(String paramString, boolean paramBoolean)
    {
      if ("ga_dryRun".equals(paramString))
      {
        paramString = this.wf;
        if (paramBoolean) {}
        for (int i = 1;; i = 0)
        {
          paramString.wi = i;
          return;
        }
      }
      aa.D("bool configuration name not recognized:  " + paramString);
    }
    
    public w cS()
    {
      return this.wf;
    }
    
    public void d(String paramString1, String paramString2)
    {
      if ("ga_appName".equals(paramString1))
      {
        this.wf.tz = paramString2;
        return;
      }
      if ("ga_appVersion".equals(paramString1))
      {
        this.wf.tA = paramString2;
        return;
      }
      if ("ga_logLevel".equals(paramString1))
      {
        this.wf.wg = paramString2;
        return;
      }
      aa.D("string configuration name not recognized:  " + paramString1);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/analytics/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */