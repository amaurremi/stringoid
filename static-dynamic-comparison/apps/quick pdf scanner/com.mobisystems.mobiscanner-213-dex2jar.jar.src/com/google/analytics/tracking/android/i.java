package com.google.analytics.tracking.android;

import android.util.Log;

class i
  implements Logger
{
  private Logger.LogLevel hZ = Logger.LogLevel.la;
  
  private String r(String paramString)
  {
    return Thread.currentThread().toString() + ": " + paramString;
  }
  
  public void a(Logger.LogLevel paramLogLevel)
  {
    this.hZ = paramLogLevel;
  }
  
  public void info(String paramString)
  {
    if (this.hZ.ordinal() <= Logger.LogLevel.la.ordinal()) {
      Log.i("GAV3", r(paramString));
    }
  }
  
  public Logger.LogLevel jx()
  {
    return this.hZ;
  }
  
  public void o(String paramString)
  {
    if (this.hZ.ordinal() <= Logger.LogLevel.kZ.ordinal()) {
      Log.v("GAV3", r(paramString));
    }
  }
  
  public void p(String paramString)
  {
    if (this.hZ.ordinal() <= Logger.LogLevel.lb.ordinal()) {
      Log.w("GAV3", r(paramString));
    }
  }
  
  public void q(String paramString)
  {
    if (this.hZ.ordinal() <= Logger.LogLevel.lc.ordinal()) {
      Log.e("GAV3", r(paramString));
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/analytics/tracking/android/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */