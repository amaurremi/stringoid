package com.amazon.inapp.purchasing;

class Logger
{
  static void error(String paramString1, String paramString2)
  {
    if (isErrorOn()) {
      ImplementationFactory.getLogHandler().error(paramString1, paramString2);
    }
  }
  
  static boolean isErrorOn()
  {
    return ImplementationFactory.getLogHandler().isErrorOn();
  }
  
  static boolean isTestOn()
  {
    return ImplementationFactory.getLogHandler().isTestOn();
  }
  
  static boolean isTraceOn()
  {
    return ImplementationFactory.getLogHandler().isTraceOn();
  }
  
  static void test(String paramString1, String paramString2)
  {
    if (isTestOn()) {
      ImplementationFactory.getLogHandler().test(paramString1, paramString2);
    }
  }
  
  static void trace(String paramString1, String paramString2)
  {
    if (isTraceOn()) {
      ImplementationFactory.getLogHandler().trace(paramString1, paramString2);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazon/inapp/purchasing/Logger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */