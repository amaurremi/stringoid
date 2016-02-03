package com.google.android.gms.analytics;

import android.content.Context;
import java.util.Map;

class ai
  extends k<aj>
{
  public ai(Context paramContext)
  {
    super(paramContext, new a());
  }
  
  private static class a
    implements k.a<aj>
  {
    private final aj xt = new aj();
    
    public void a(String paramString, int paramInt)
    {
      if ("ga_sessionTimeout".equals(paramString))
      {
        this.xt.xw = paramInt;
        return;
      }
      aa.D("int configuration name not recognized:  " + paramString);
    }
    
    public void c(String paramString1, String paramString2)
    {
      this.xt.xA.put(paramString1, paramString2);
    }
    
    public void c(String paramString, boolean paramBoolean)
    {
      int j = 1;
      int k = 1;
      int i = 1;
      if ("ga_autoActivityTracking".equals(paramString))
      {
        paramString = this.xt;
        if (paramBoolean) {}
        for (;;)
        {
          paramString.xx = i;
          return;
          i = 0;
        }
      }
      if ("ga_anonymizeIp".equals(paramString))
      {
        paramString = this.xt;
        if (paramBoolean) {}
        for (i = j;; i = 0)
        {
          paramString.xy = i;
          return;
        }
      }
      if ("ga_reportUncaughtExceptions".equals(paramString))
      {
        paramString = this.xt;
        if (paramBoolean) {}
        for (i = k;; i = 0)
        {
          paramString.xz = i;
          return;
        }
      }
      aa.D("bool configuration name not recognized:  " + paramString);
    }
    
    public void d(String paramString1, String paramString2)
    {
      if ("ga_trackingId".equals(paramString1))
      {
        this.xt.xu = paramString2;
        return;
      }
      if ("ga_sampleFrequency".equals(paramString1)) {
        try
        {
          this.xt.xv = Double.parseDouble(paramString2);
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
    
    public aj dy()
    {
      return this.xt;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/analytics/ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */