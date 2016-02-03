package com.google.tagmanager;

class NoOpLogger
  implements Logger
{
  public void d(String paramString) {}
  
  public void d(String paramString, Throwable paramThrowable) {}
  
  public void e(String paramString) {}
  
  public void e(String paramString, Throwable paramThrowable) {}
  
  public Logger.LogLevel getLogLevel()
  {
    return Logger.LogLevel.NONE;
  }
  
  public void i(String paramString) {}
  
  public void i(String paramString, Throwable paramThrowable) {}
  
  public void setLogLevel(Logger.LogLevel paramLogLevel) {}
  
  public void v(String paramString) {}
  
  public void v(String paramString, Throwable paramThrowable) {}
  
  public void w(String paramString) {}
  
  public void w(String paramString, Throwable paramThrowable) {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/google/tagmanager/NoOpLogger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */