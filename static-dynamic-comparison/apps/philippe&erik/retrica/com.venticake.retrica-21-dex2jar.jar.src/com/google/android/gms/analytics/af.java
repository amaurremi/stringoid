package com.google.android.gms.analytics;

import android.util.Log;

class af
  implements Logger
{
  private int a = 1;
  
  private String a(String paramString)
  {
    return Thread.currentThread().toString() + ": " + paramString;
  }
  
  public void error(Exception paramException)
  {
    if (this.a <= 3) {
      Log.e("GAV4", null, paramException);
    }
  }
  
  public void error(String paramString)
  {
    if (this.a <= 3) {
      Log.e("GAV4", a(paramString));
    }
  }
  
  public int getLogLevel()
  {
    return this.a;
  }
  
  public void info(String paramString)
  {
    if (this.a <= 1) {
      Log.i("GAV4", a(paramString));
    }
  }
  
  public void setLogLevel(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void verbose(String paramString)
  {
    if (this.a <= 0) {
      Log.v("GAV4", a(paramString));
    }
  }
  
  public void warn(String paramString)
  {
    if (this.a <= 2) {
      Log.w("GAV4", a(paramString));
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/analytics/af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */