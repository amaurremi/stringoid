package com.amazon.inapp.purchasing;

abstract interface LogHandler
{
  public abstract void error(String paramString1, String paramString2);
  
  public abstract boolean isErrorOn();
  
  public abstract boolean isTestOn();
  
  public abstract boolean isTraceOn();
  
  public abstract void test(String paramString1, String paramString2);
  
  public abstract void trace(String paramString1, String paramString2);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazon/inapp/purchasing/LogHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */