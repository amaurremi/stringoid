package com.google.android.gms.analytics;

import android.util.Log;

class l
  implements Logger
{
  private int sz = 1;
  
  private String E(String paramString)
  {
    return Thread.currentThread().toString() + ": " + paramString;
  }
  
  public void error(Exception paramException)
  {
    if (this.sz <= 3) {
      Log.e("GAV4", null, paramException);
    }
  }
  
  public void error(String paramString)
  {
    if (this.sz <= 3) {
      Log.e("GAV4", E(paramString));
    }
  }
  
  public int getLogLevel()
  {
    return this.sz;
  }
  
  public void info(String paramString)
  {
    if (this.sz <= 1) {
      Log.i("GAV4", E(paramString));
    }
  }
  
  public void setLogLevel(int paramInt)
  {
    this.sz = paramInt;
  }
  
  public void verbose(String paramString)
  {
    if (this.sz <= 0) {
      Log.v("GAV4", E(paramString));
    }
  }
  
  public void warn(String paramString)
  {
    if (this.sz <= 2) {
      Log.w("GAV4", E(paramString));
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/analytics/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */