package com.google.analytics.tracking.android;

public abstract interface Logger
{
  public abstract void a(LogLevel paramLogLevel);
  
  public abstract void info(String paramString);
  
  public abstract LogLevel jx();
  
  public abstract void o(String paramString);
  
  public abstract void p(String paramString);
  
  public abstract void q(String paramString);
  
  public static enum LogLevel
  {
    private LogLevel() {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/analytics/tracking/android/Logger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */