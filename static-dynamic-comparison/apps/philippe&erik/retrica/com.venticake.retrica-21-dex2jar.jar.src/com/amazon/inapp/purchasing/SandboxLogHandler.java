package com.amazon.inapp.purchasing;

import android.util.Log;

class SandboxLogHandler
  implements LogHandler
{
  private static final boolean ERROR_ON = true;
  private static final boolean TEST_ON = true;
  private static final boolean TRACE_ON = true;
  
  private static String buildLogMessage(String paramString)
  {
    return "In App Purchasing SDK - Sandbox Mode: " + paramString;
  }
  
  public void error(String paramString1, String paramString2)
  {
    Log.e(paramString1, buildLogMessage(paramString2));
  }
  
  public boolean isErrorOn()
  {
    return true;
  }
  
  public boolean isTestOn()
  {
    return true;
  }
  
  public boolean isTraceOn()
  {
    return true;
  }
  
  public void test(String paramString1, String paramString2)
  {
    Log.v(paramString1, buildLogMessage(paramString2));
  }
  
  public void trace(String paramString1, String paramString2)
  {
    Log.d(paramString1, buildLogMessage(paramString2));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazon/inapp/purchasing/SandboxLogHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */