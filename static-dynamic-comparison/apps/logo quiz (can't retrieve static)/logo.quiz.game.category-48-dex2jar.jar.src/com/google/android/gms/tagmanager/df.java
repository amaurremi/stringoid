package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Logger;
import com.google.android.gms.analytics.Tracker;

class df
{
  private GoogleAnalytics arF;
  private Context mContext;
  private Tracker xY;
  
  df(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  private void cS(String paramString)
  {
    try
    {
      if (this.arF == null)
      {
        this.arF = GoogleAnalytics.getInstance(this.mContext);
        this.arF.setLogger(new a());
        this.xY = this.arF.newTracker(paramString);
      }
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public Tracker cR(String paramString)
  {
    cS(paramString);
    return this.xY;
  }
  
  static class a
    implements Logger
  {
    private static int fm(int paramInt)
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
      bh.T(paramString);
    }
    
    public int getLogLevel()
    {
      return fm(bh.getLogLevel());
    }
    
    public void info(String paramString)
    {
      bh.U(paramString);
    }
    
    public void setLogLevel(int paramInt)
    {
      bh.W("GA uses GTM logger. Please use TagManager.setLogLevel(int) instead.");
    }
    
    public void verbose(String paramString)
    {
      bh.V(paramString);
    }
    
    public void warn(String paramString)
    {
      bh.W(paramString);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/tagmanager/df.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */