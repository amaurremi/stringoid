package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Logger;
import com.google.android.gms.analytics.Tracker;

class de
{
  private GoogleAnalytics aig;
  private Context mContext;
  private Tracker tM;
  
  de(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  private void cn(String paramString)
  {
    try
    {
      if (this.aig == null)
      {
        this.aig = GoogleAnalytics.getInstance(this.mContext);
        this.aig.setLogger(new a());
        this.tM = this.aig.newTracker(paramString);
      }
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public Tracker cm(String paramString)
  {
    cn(paramString);
    return this.tM;
  }
  
  static class a
    implements Logger
  {
    private static int dv(int paramInt)
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
      bh.A(paramString);
    }
    
    public int getLogLevel()
    {
      return dv(bh.getLogLevel());
    }
    
    public void info(String paramString)
    {
      bh.B(paramString);
    }
    
    public void setLogLevel(int paramInt)
    {
      bh.D("GA uses GTM logger. Please use TagManager.setLogLevel(int) instead.");
    }
    
    public void verbose(String paramString)
    {
      bh.C(paramString);
    }
    
    public void warn(String paramString)
    {
      bh.D(paramString);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/tagmanager/de.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */