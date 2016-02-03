package com.amazon.inapp.purchasing;

import com.amazon.android.framework.util.KiwiLogger;

class KiwiLogHandler
  implements LogHandler
{
  private static KiwiLogger LOGGER = new KiwiLogger("In App Purchasing SDK - Production Mode");
  
  private static String buildLogMessage(String paramString1, String paramString2)
  {
    return paramString1 + ": " + paramString2;
  }
  
  public void error(String paramString1, String paramString2)
  {
    LOGGER.error(buildLogMessage(paramString1, paramString2));
  }
  
  public boolean isErrorOn()
  {
    return KiwiLogger.ERROR_ON;
  }
  
  public boolean isTestOn()
  {
    return KiwiLogger.isTestEnabled();
  }
  
  public boolean isTraceOn()
  {
    return KiwiLogger.TRACE_ON;
  }
  
  public void test(String paramString1, String paramString2)
  {
    LOGGER.test(buildLogMessage(paramString1, paramString2));
  }
  
  public void trace(String paramString1, String paramString2)
  {
    LOGGER.trace(buildLogMessage(paramString1, paramString2));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazon/inapp/purchasing/KiwiLogHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */