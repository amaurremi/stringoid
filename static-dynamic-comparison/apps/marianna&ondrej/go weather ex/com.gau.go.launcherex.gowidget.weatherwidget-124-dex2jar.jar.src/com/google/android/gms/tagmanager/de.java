package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Logger;
import com.google.android.gms.analytics.Tracker;

class de
{
  private GoogleAnalytics aaB;
  private Context mContext;
  private Tracker sB;
  
  de(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  private void bV(String paramString)
  {
    try
    {
      if (this.aaB == null)
      {
        this.aaB = GoogleAnalytics.getInstance(this.mContext);
        this.aaB.setLogger(new a());
        this.sB = this.aaB.newTracker(paramString);
      }
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public Tracker bU(String paramString)
  {
    bV(paramString);
    return this.sB;
  }
  
  static class a
    implements Logger
  {
    private static int ci(int paramInt)
    {
      switch (paramInt)
      {
      case 6: 
      default: 
        return 3;
      case 5: 
        return 2;
      case 3: 
      case 4: 
        return 1;
      }
      return 0;
    }
    
    public void error(Exception paramException)
    {
      bh.b("", paramException);
    }
    
    public void error(String paramString)
    {
      bh.w(paramString);
    }
    
    public int getLogLevel()
    {
      return ci(bh.getLogLevel());
    }
    
    public void info(String paramString)
    {
      bh.x(paramString);
    }
    
    public void setLogLevel(int paramInt)
    {
      bh.z("GA uses GTM logger. Please use TagManager.setLogLevel(int) instead.");
    }
    
    public void verbose(String paramString)
    {
      bh.y(paramString);
    }
    
    public void warn(String paramString)
    {
      bh.z(paramString);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/tagmanager/de.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */